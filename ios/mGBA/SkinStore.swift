/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import UIKit

/**
 * Full PNG skins, in the spirit of Pizza Boy's 整包皮肤: an archive holding
 * one PNG per button — dpad / a / b / l / r / select / start, with an
 * optional `_p` suffix for the pressed look and optional bg_portrait.png /
 * bg_landscape.png backgrounds. Skins live in `<root>/<name>/` and are picked
 * in the skin dialog.
 */
final class SkinStore {
    /// Button keys a skin may provide, in drawing order.
    static let buttons = ["dpad", "a", "b", "l", "r", "select", "start"]

    private let root: URL
    private let manager = FileManager.default

    /// `root` is the folder that holds one directory per skin.
    init(root: URL) {
        self.root = root
        try? manager.createDirectory(at: root, withIntermediateDirectories: true)
    }

    /// Names of the installed skins, sorted case-insensitively.
    func list() -> [String] {
        guard let items = try? manager.contentsOfDirectory(at: root,
                                                           includingPropertiesForKeys: nil,
                                                           options: [.skipsHiddenFiles]) else { return [] }
        let names = items.compactMap { item -> String? in
            var isDirectory: ObjCBool = false
            guard manager.fileExists(atPath: item.path, isDirectory: &isDirectory), isDirectory.boolValue else { return nil }
            return item.lastPathComponent
        }
        return names.sorted { $0.localizedStandardCompare($1) == .orderedAscending }
    }

    /// Folder of one skin.
    func directory(_ name: String) -> URL {
        root.appendingPathComponent(sanitize(name), isDirectory: true)
    }

    /**
     * Extracts a zip into a new skin directory; nil when the archive holds no
     * usable button PNG.
     */
    func importZip(_ url: URL, suggestedName: String?) -> String? {
        let base = sanitize(suggestedName ?? "skin")
        guard let target = uniqueDirectory(for: base) else { return nil }
        do {
            try manager.createDirectory(at: target, withIntermediateDirectories: true)
        } catch {
            return nil
        }
        guard let entries = Zip.read(url) else {
            removeDirectory(target)
            return nil
        }
        var images = 0
        for entry in entries {
            let file = baseName(entry.name).lowercased()
            guard file.hasSuffix(".png") else { continue }
            do {
                try entry.data.write(to: target.appendingPathComponent(file), options: .atomic)
                images += 1
            } catch {
                continue
            }
        }
        if images == 0 || !hasButtonImage(target) {
            removeDirectory(target)
            return nil
        }
        return target.lastPathComponent
    }

    /**
     * Imports the PNGs of a plain folder; nil when it holds no button PNG.
     */
    func importDirectory(_ url: URL, name: String?) -> String? {
        let base = sanitize(name ?? url.lastPathComponent)
        guard let target = uniqueDirectory(for: base) else { return nil }
        guard let items = try? manager.contentsOfDirectory(at: url,
                                                           includingPropertiesForKeys: nil,
                                                           options: [.skipsHiddenFiles]) else { return nil }
        let pngs = items.filter { $0.pathExtension.lowercased() == "png" }
        guard !pngs.isEmpty else { return nil }
        do {
            try manager.createDirectory(at: target, withIntermediateDirectories: true)
        } catch {
            return nil
        }
        var images = 0
        for source in pngs {
            let file = source.lastPathComponent
            do {
                try manager.copyItem(at: source, to: target.appendingPathComponent(file))
                images += 1
            } catch {
                continue
            }
        }
        if images == 0 || !hasButtonImage(target) {
            removeDirectory(target)
            return nil
        }
        return target.lastPathComponent
    }

    /// Removes a skin.
    func delete(_ name: String) {
        removeDirectory(directory(name))
    }

    /**
     * Loads every PNG of a skin into memory. Keys are the lowercased file
     * name without its extension: "a", "a_p", "dpad", "bg_portrait"...
     * Missing entries are simply absent from the dictionary.
     */
    func load(_ name: String) -> [String: UIImage] {
        var images: [String: UIImage] = [:]
        let folder = directory(name)
        guard let items = try? manager.contentsOfDirectory(at: folder,
                                                           includingPropertiesForKeys: nil,
                                                           options: [.skipsHiddenFiles]) else { return images }
        for item in items {
            let file = item.lastPathComponent.lowercased()
            guard file.hasSuffix(".png") else { continue }
            guard let image = UIImage(contentsOfFile: item.path) else { continue }
            images[String(file.dropLast(4))] = image
        }
        return images
    }

    // MARK: - Helpers

    /**
     * Finds a free directory name, appending "-2", "-3"... on collision. The
     * suffix is trimmed so the final name stays within the 60 character
     * limit the sanitizer enforces.
     */
    private func uniqueDirectory(for base: String) -> URL? {
        var candidate = sanitize(base)
        var serial = 2
        while manager.fileExists(atPath: root.appendingPathComponent(candidate).path) {
            let suffix = "-\(serial)"
            let trimmed = candidate.count + suffix.count > 60
                ? String(candidate.prefix(max(1, 60 - suffix.count)))
                : candidate
            candidate = trimmed + suffix
            serial += 1
            if serial > 999 { return nil }
        }
        return root.appendingPathComponent(candidate, isDirectory: true)
    }

    /// True when the folder holds at least one button image (`<key>.png` or
    /// `<key>_p.png`), matched case-insensitively.
    private func hasButtonImage(_ folder: URL) -> Bool {
        guard let items = try? manager.contentsOfDirectory(at: folder,
                                                           includingPropertiesForKeys: nil,
                                                           options: [.skipsHiddenFiles]) else { return false }
        let files = Set(items.map { $0.lastPathComponent.lowercased() })
        for key in SkinStore.buttons {
            if files.contains("\(key).png") || files.contains("\(key)_p.png") { return true }
        }
        return false
    }

    /// Cleans a skin name so it can be used as a directory name.
    private func sanitize(_ name: String) -> String {
        let invalid = CharacterSet(charactersIn: "\\/:*?\"<>|")
        var clean = name.components(separatedBy: invalid).joined(separator: "_")
        clean = clean.trimmingCharacters(in: .whitespacesAndNewlines)
        if clean.isEmpty || clean.count > 60 {
            clean = "skin"
        }
        return clean
    }

    /// Removes a directory and everything inside it.
    private func removeDirectory(_ url: URL) {
        try? manager.removeItem(at: url)
    }

    /// Last path component of an archive entry name; zip entries may use
    /// either separator, and the folder part is never interesting for skins.
    private func baseName(_ name: String) -> String {
        var file = name
        if let index = file.range(of: "/", options: .backwards) {
            file = String(file[index.upperBound...])
        }
        if let index = file.range(of: "\\", options: .backwards) {
            file = String(file[index.upperBound...])
        }
        return file
    }
}
