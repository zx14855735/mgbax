/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// The player's game library: ROMs found on disk, the favourites among them
/// and the game that was played last.
///
/// The preferences live under the same keys the Android build uses
/// (`rom_favs`, `lastRom`), so a library carried over between the two apps
/// still reads back correctly.
final class RomLibrary {
    struct Entry {
        /// Where the ROM lives.
        let url: URL
        /// File name without the extension.
        let title: String
        /// Last modification date, newest first when scanning.
        let modified: Date
    }

    /// Newline separated absolute paths, the Android layout.
    private static let favoritesKey = "rom_favs"
    /// Absolute path of the game that was opened last.
    private static let lastRomKey = "lastRom"
    /// How many ROMs one directory contributes and how many the list holds.
    private static let limit = 200
    /// How far below a root directory the walk goes.
    private static let maxDepth = 3

    private let defaults: UserDefaults

    init(defaults: UserDefaults = .standard) {
        self.defaults = defaults
    }

    /// True for the extensions the emulator loads: .gba .gbc .gb .sgc
    static func isRomFile(_ name: String) -> Bool {
        let lower = name.lowercased()
        return lower.hasSuffix(".gba") || lower.hasSuffix(".gbc") || lower.hasSuffix(".gb") || lower.hasSuffix(".sgc")
    }

    /// Scans the given folders for ROMs, at most three levels deep, and returns
    /// them newest first. Games under `preferred` (the player's own folders)
    /// are listed first. The result is capped at 200 entries.
    func scan(roots: [URL], preferred: Set<String> = []) -> [Entry] {
        var found: [Entry] = []
        var seen = Set<String>()
        for root in roots {
            collect(root, depth: 0, into: &found, seen: &seen)
        }
        func isPreferred(_ entry: Entry) -> Bool {
            let path = entry.url.standardizedFileURL.path
            for dir in preferred where path.hasPrefix(dir + "/") { return true }
            return false
        }
        found.sort { a, b in
            let ca = isPreferred(a)
            let cb = isPreferred(b)
            if ca != cb { return ca }
            return a.modified > b.modified
        }
        return Array(found.prefix(RomLibrary.limit))
    }

    /// Walks one directory. Files land in `out`, sub directories are visited
    /// one level deeper until `maxDepth` is reached.
    private func collect(_ dir: URL, depth: Int, into out: inout [Entry], seen: inout Set<String>) {
        guard depth <= RomLibrary.maxDepth else { return }
        let keys: [URLResourceKey] = [.isDirectoryKey, .fileSizeKey, .contentModificationDateKey]
        guard let items = try? FileManager.default.contentsOfDirectory(at: dir,
                                                                      includingPropertiesForKeys: keys,
                                                                      options: []) else { return }
        var roms: [Entry] = []
        for url in items {
            let values = try? url.resourceValues(forKeys: Set(keys))
            if values?.isDirectory == true {
                // Hidden folders hold thumbnails and the like; skip them.
                guard depth < RomLibrary.maxDepth, !url.lastPathComponent.hasPrefix(".") else { continue }
                collect(url, depth: depth + 1, into: &out, seen: &seen)
                continue
            }
            // 跳过空文件和不是 ROM 的文件.
            guard (values?.fileSize ?? 0) > 0 else { continue }
            guard RomLibrary.isRomFile(url.lastPathComponent) else { continue }
            guard seen.insert(url.path).inserted else { continue }
            roms.append(Entry(url: url,
                              title: url.deletingPathExtension().lastPathComponent,
                              modified: values?.contentModificationDate ?? Date.distantPast))
        }
        // 每个目录最多贡献 200 个 ROM,新的在前.
        out.append(contentsOf: roms.sorted { $0.modified > $1.modified }.prefix(RomLibrary.limit))
    }

    /// The favourites, as a set of absolute file paths.
    func favorites() -> Set<String> {
        guard let raw = defaults.string(forKey: RomLibrary.favoritesKey), !raw.isEmpty else { return [] }
        return Set(raw.split(separator: "\n").map(String.init))
    }

    /// Adds or removes a ROM from the favourites; returns the new state.
    func toggleFavorite(_ url: URL) -> Bool {
        var favs = favorites()
        let path = url.path
        let now: Bool
        if favs.contains(path) {
            favs.remove(path)
            now = false
        } else {
            favs.insert(path)
            now = true
        }
        defaults.set(favs.sorted().joined(separator: "\n"), forKey: RomLibrary.favoritesKey)
        return now
    }

    /// True when the ROM is a favourite.
    func isFavorite(_ url: URL) -> Bool {
        favorites().contains(url.path)
    }

    /// Absolute path of the game played last, when it still exists.
    func lastRom() -> URL? {
        guard let path = defaults.string(forKey: RomLibrary.lastRomKey), !path.isEmpty else { return nil }
        guard FileManager.default.fileExists(atPath: path) else { return nil }
        return URL(fileURLWithPath: path)
    }

    /// Records the game that was opened last.
    func setLastRom(_ url: URL) {
        defaults.set(url.path, forKey: RomLibrary.lastRomKey)
    }
}
