/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// Exports and restores a backup bundle: the settings, the battery saves and
/// the save states, packed into one zip file.
///
/// The bundle looks exactly like the one the Android build writes, so the two
/// apps can import each other's backups:
///
///     settings.json      the settings as a JSON object
///     saves/<path>       every file below the save directory
///     states/<path>      every file below the state directory
enum BackupStore {
    private static let settingsEntry = "settings.json"
    private static let savesPrefix = "saves/"
    private static let statesPrefix = "states/"

    /// Writes the backup to `destination`. Returns the number of files packed,
    /// or nil on failure.
    @discardableResult
    static func export(settings: [String: Any], saves: URL, states: URL, to destination: URL) -> Int? {
        var entries: [Zip.Entry] = []

        // 只保留 JSON 能表示的值,其余的丢掉.
        let plain = plainSettings(settings)
        guard JSONSerialization.isValidJSONObject(plain),
              let json = try? JSONSerialization.data(withJSONObject: plain, options: [.sortedKeys]) else {
            return nil
        }
        entries.append(Zip.Entry(name: settingsEntry, data: json))

        // 存档和即时存档按目录原样打包,单个文件读失败就跳过.
        entries.append(contentsOf: pack(directory: saves, prefix: savesPrefix))
        entries.append(contentsOf: pack(directory: states, prefix: statesPrefix))

        guard Zip.write(entries, to: destination) else { return nil }
        return entries.count
    }

    /// Reads a backup from `source` and writes the files back into `saves`
    /// and `states`. Returns the settings that came with it, or nil on failure.
    static func restore(from source: URL, saves: URL, states: URL) -> [String: Any]? {
        guard let entries = Zip.read(source) else { return nil }
        var settings: [String: Any] = [:]
        // 只有认出至少一项内容,才算是一份备份;普通 zip 直接拒绝,
        // 免得用户拿错文件时只看到一句"已恢复".
        var recognized = false
        for entry in entries {
            let name = entry.name
            if name == settingsEntry {
                recognized = true
                if let object = try? JSONSerialization.jsonObject(with: entry.data),
                   let dict = object as? [String: Any] {
                    settings = dict
                }
                continue
            }
            let root: URL
            let relative: String
            if name.hasPrefix(savesPrefix) {
                root = saves
                relative = String(name.dropFirst(savesPrefix.count))
            } else if name.hasPrefix(statesPrefix) {
                root = states
                relative = String(name.dropFirst(statesPrefix.count))
            } else {
                continue
            }
            recognized = true
            // 目录条目和空路径没有内容可还原.
            guard !relative.isEmpty, !relative.hasSuffix("/") else { continue }
            guard let target = safeTarget(root: root, relative: relative) else { continue }
            do {
                try FileManager.default.createDirectory(at: target.deletingLastPathComponent(),
                                                        withIntermediateDirectories: true)
                try entry.data.write(to: target, options: .atomic)
            } catch {
                // 一个文件还原失败不影响其它文件.
                continue
            }
        }
        // 没有 settings.json 时返回空字典,文件照样还原.
        return recognized ? settings : nil
    }

    /// Keeps only the values JSON can carry: strings, numbers, booleans and
    /// the containers built from them.
    private static func plainSettings(_ settings: [String: Any]) -> [String: Any] {
        var out: [String: Any] = [:]
        for (key, value) in settings {
            guard let safe = jsonSafe(value) else { continue }
            out[key] = safe
        }
        return out
    }

    /// Returns the value when JSON can carry it, nil when it cannot. Dates,
    /// data and non-finite numbers have no JSON form and are dropped.
    private static func jsonSafe(_ value: Any) -> Any? {
        switch value {
        case is String, is NSNumber, is NSNull:
            // A one element array makes isValidJSONObject look at the value
            // itself, which is how NaN and infinity get rejected. A Swift Bool
            // lands here too and keeps its true/false form in the output.
            return JSONSerialization.isValidJSONObject([value]) ? value : nil
        case let map as [String: Any]:
            var out: [String: Any] = [:]
            for (key, element) in map {
                guard let safe = jsonSafe(element) else { continue }
                out[key] = safe
            }
            return out
        case let list as [Any]:
            return list.compactMap { jsonSafe($0) }
        default:
            return nil
        }
    }

    /// Reads a directory tree into zip entries named `<prefix><relative path>`.
    private static func pack(directory: URL, prefix: String) -> [Zip.Entry] {
        let keys: [URLResourceKey] = [.isDirectoryKey]
        guard let walker = FileManager.default.enumerator(at: directory,
                                                         includingPropertiesForKeys: keys,
                                                         options: []) else { return [] }
        var entries: [Zip.Entry] = []
        let rootPath = directory.standardizedFileURL.path
        for case let url as URL in walker {
            let values = try? url.resourceValues(forKeys: Set(keys))
            if values?.isDirectory == true { continue }
            // 相对路径用 / 分隔,和 Android 的压缩包一致.
            var relative = url.standardizedFileURL.path
            guard isInside(rootPath: rootPath, path: relative) else { continue }
            relative.removeFirst(rootPath == "/" ? 1 : rootPath.count + 1)
            guard !relative.isEmpty else { continue }
            guard let data = try? Data(contentsOf: url) else { continue }
            entries.append(Zip.Entry(name: prefix + relative, data: data))
        }
        return entries
    }

    /// Builds the file a zip entry points at and keeps it inside the root.
    /// A crafted backup must not be able to write outside the sandbox.
    private static func safeTarget(root: URL, relative: String) -> URL? {
        let parts = relative.split(separator: "/").map(String.init)
        guard !parts.isEmpty, !parts.contains("..") else { return nil }
        let target = parts.reduce(root) { $0.appendingPathComponent($1) }.standardizedFileURL
        // 目标必须还在根目录里面.
        guard isInside(rootPath: root.standardizedFileURL.path, path: target.path) else { return nil }
        return target
    }

    /// True when `path` sits below `rootPath`; a sibling with a shared name
    /// prefix does not count.
    private static func isInside(rootPath: String, path: String) -> Bool {
        if rootPath == "/" { return path.hasPrefix("/") }
        return path.hasPrefix(rootPath + "/")
    }
}
