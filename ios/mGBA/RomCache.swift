/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation
import CryptoKit

/// 本地 ROM 副本缓存（需求④）— iOS 对称版。
/// 契约与 Android io.mgba.android.RomCache / PC RomCache 同名同值：
/// 500MB / 20 条上限，清到 80%（400MB / 16 条）水位；清单 schema=1。
/// 纯设备私有：缓存路径绝不写 lastRom / lastRomBookmark / rom_favs /
/// RecentRoms.paths / 备份 settings / WebDAV manifest。
/// 双锁体系：writeLock（全局清单读改写） + copyLocks（per-ROM 复制互斥）；
/// 与 RecentRoms.writeLock 完全独立，两者从不嵌套持有。
/// 所有含文件 I/O 的方法由调用方放后台队列，勿阻塞 emu 循环。
/// 诚实纪律：size 不符 / 文件缺失 / JSON 损坏 / 复制失败一律自愈或返回 nil，
/// 绝不假装缓存成功。
final class RomCache {
    private init() {}

    // MARK: - 具名常量（三端同名同值；禁裸 hex / 裸字符串）

    static let schema = 1
    static let maxBytes: Int64 = 500 * 1024 * 1024          // 500MB
    static let maxEntries = 20
    static let watermarkBytes: Int64 = maxBytes * 4 / 5     // 400MB
    static let watermarkEntries = maxEntries * 4 / 5        // 16

    private static let indexKey = "RomCache.index"
    private static let dirName = "rom_cache"
    private static let hiddenDirName = ".rom_cache"

    private static let idMD5 = RecentRoms.idMD5
    private static let idPath = RecentRoms.idPath

    // MARK: - 双锁（与 RecentRoms.writeLock 独立）

    private static let writeLock = NSLock()
    private static let copyLocksGuard = NSLock()
    private static var copyLocks: [String: NSLock] = [:]

    /// 清单条目：rom_id -> {path,size,last_access_ms,origin}。
    struct Entry {
        var romId: String
        var path: String
        var size: Int64
        var lastAccessMs: Int64
        var origin: String = ""
    }

    private static var defaults: UserDefaults { .standard }
    private static func nowMs() -> Int64 { Int64(Date().timeIntervalSince1970 * 1000.0) }

    private static func num64(_ any: Any?, fallback: Int64 = 0) -> Int64 {
        if let n = any as? NSNumber { return n.int64Value }
        if let v = any as? Int64 { return v }
        if let v = any as? Int { return Int64(v) }
        if let v = any as? Double { return Int64(v) }
        return fallback
    }

    // MARK: - 目录

    private static func cacheDir() -> URL? {
        let fm = FileManager.default
        let base: URL?
        let hiddenFallback: Bool
        if let support = fm.urls(for: .applicationSupportDirectory, in: .userDomainMask).first {
            base = support
            hiddenFallback = false
        } else if let docs = fm.urls(for: .documentDirectory, in: .userDomainMask).first {
            base = docs
            hiddenFallback = true
        } else {
            return nil
        }
        guard let base else { return nil }
        let target = hiddenFallback
            ? base.appendingPathComponent(hiddenDirName, isDirectory: true)
            : base.appendingPathComponent(dirName, isDirectory: true)
        do {
            try fm.createDirectory(at: target, withIntermediateDirectories: true)
        } catch {
            return nil
        }
        return target
    }

    private static func fileName(for romId: String) -> String {
        let raw = romId.hasPrefix(idMD5) ? String(romId.dropFirst(idMD5.count)) : romId
        var out = ""
        for c in raw {
            let ok = ("a"..."z").contains(c) || ("A"..."Z").contains(c)
                || ("0"..."9").contains(c) || c == "_" || c == "-" || c == "."
            out.append(ok ? c : "_")
        }
        return out + ".gba"
    }

    private static func deleteQuiet(at url: URL?) {
        guard let url else { return }
        try? FileManager.default.removeItem(at: url)
    }

    // MARK: - 清单读改写（内部函数，调用方须已持 writeLock）

    private static func loadLocked() -> [Entry] {
        let fm = FileManager.default
        let d = defaults
        guard let raw = d.string(forKey: indexKey), !raw.isEmpty,
              let data = raw.data(using: .utf8),
              let obj = try? JSONSerialization.jsonObject(with: data, options: []),
              let doc = obj as? [String: Any],
              let dict = doc["entries"] as? [String: Any] else {
            d.removeObject(forKey: indexKey)
            return []
        }
        if num64(doc["schema"], fallback: -1) != Int64(schema) {
            d.removeObject(forKey: indexKey)
            return []
        }
        var out: [Entry] = []
        var dirty = false
        for (romId, value) in dict {
            guard let one = value as? [String: Any] else { dirty = true; continue }
            guard let path = one["path"] as? String, !path.isEmpty else {
                dirty = true; continue
            }
            let size = num64(one["size"], fallback: -1)
            guard size >= 0 else { dirty = true; continue }
            let at = num64(one["last_access_ms"])
            let origin = one["origin"] as? String ?? ""
            guard fm.fileExists(atPath: path),
                  let attrs = try? fm.attributesOfItem(atPath: path) else {
                dirty = true; continue
            }
            let actual = num64(attrs[.size], fallback: -1)
            guard actual == size else {
                dirty = true; continue
            }
            out.append(Entry(romId: romId, path: path, size: size,
                             lastAccessMs: at, origin: origin))
        }
        if dirty { saveLocked(out) }
        return out
    }

    private static func saveLocked(_ entries: [Entry]) {
        var dict: [String: Any] = [:]
        for e in entries {
            dict[e.romId] = [
                "path": e.path,
                "size": NSNumber(value: e.size),
                "last_access_ms": NSNumber(value: e.lastAccessMs),
                "origin": e.origin,
            ]
        }
        let doc: [String: Any] = [
            "schema": NSNumber(value: schema),
            "entries": dict,
        ]
        guard JSONSerialization.isValidJSONObject(doc),
              let data = try? JSONSerialization.data(withJSONObject: doc, options: [.sortedKeys]) else { return }
        defaults.set(String(decoding: data, as: UTF8.self), forKey: indexKey)
    }

    private static func putEntryLocked(_ e: Entry) {
        var es = loadLocked()
        if let idx = es.firstIndex(where: { $0.romId == e.romId }) { es[idx] = e } else { es.append(e) }
        saveLocked(es)
    }

    private static func lockFor(_ romId: String) -> NSLock {
        copyLocksGuard.lock(); defer { copyLocksGuard.unlock() }
        if let l = copyLocks[romId] { return l }
        let l = NSLock()
        copyLocks[romId] = l
        return l
    }

    // MARK: - public

    @discardableResult
    static func record(romId: String, path: String, size: Int64,
                       lastAccessMs: Int64? = nil, origin: String? = nil) -> Bool {
        guard !romId.isEmpty, !path.isEmpty, size > 0 else { return false }
        let e = Entry(romId: romId, path: path, size: size,
                      lastAccessMs: lastAccessMs ?? nowMs(),
                      origin: origin.map { URL(fileURLWithPath: $0).standardizedFileURL.path } ?? "")
        writeLock.lock(); defer { writeLock.unlock() }
        putEntryLocked(e)
        return true
    }

    static func getCachedPath(_ romId: String) -> String? {
        guard !romId.isEmpty else { return nil }
        writeLock.lock(); defer { writeLock.unlock() }
        return loadLocked().first { $0.romId == romId }?.path
    }

    static func cachedPathForOrigin(_ originPath: String) -> String? {
        guard !originPath.isEmpty else { return nil }
        let needle = URL(fileURLWithPath: originPath).standardizedFileURL.path
        writeLock.lock(); defer { writeLock.unlock() }
        let es = loadLocked()
        if let e = es.first(where: { $0.origin == originPath }) { return e.path }
        if let e = es.first(where: { !$0.origin.isEmpty && $0.origin == needle }) { return e.path }
        return nil
    }

    static func touch(_ romId: String) {
        guard !romId.isEmpty else { return }
        writeLock.lock(); defer { writeLock.unlock() }
        var es = loadLocked()
        guard let idx = es.firstIndex(where: { $0.romId == romId }) else { return }
        es[idx].lastAccessMs = nowMs()
        saveLocked(es)
    }

    static func cachedSize() -> Int64 {
        writeLock.lock(); defer { writeLock.unlock() }
        return loadLocked().reduce(Int64(0)) { $0 + $1.size }
    }

    static func cachedCount() -> Int {
        writeLock.lock(); defer { writeLock.unlock() }
        return loadLocked().count
    }

    static func isCachePath(_ path: String) -> Bool {
        guard !path.isEmpty, let dir = cacheDir() else { return false }
        let prefix = dir.standardizedFileURL.path + "/"
        let norm = URL(fileURLWithPath: path).standardizedFileURL.path
        return norm.hasPrefix(prefix)
    }

    static func clearAll() {
        writeLock.lock(); defer { writeLock.unlock() }
        if let dir = cacheDir(),
           let files = try? FileManager.default.contentsOfDirectory(at: dir, includingPropertiesForKeys: nil) {
            for f in files
            where f.lastPathComponent.hasSuffix(".gba") || f.lastPathComponent.hasSuffix(".part") {
                deleteQuiet(at: f)
            }
        }
        defaults.removeObject(forKey: indexKey)
    }

    static func pruneIfNeeded(protectedRomId: String? = nil) {
        writeLock.lock(); defer { writeLock.unlock() }
        let es = loadLocked()
        guard !es.isEmpty else { return }
        var total = es.reduce(Int64(0)) { $0 + $1.size }
        var count = es.count
        let sizeOver = total > maxBytes
        let countOver = count > maxEntries
        if !sizeOver && !countOver { return }
        let ordered = es.sorted { $0.lastAccessMs < $1.lastAccessMs }
        var keep: [Entry] = []
        for e in ordered {
            let need = (sizeOver && total > watermarkBytes)
                || (countOver && count > watermarkEntries)
            if !need { keep.append(e); continue }
            if let prot = protectedRomId, prot == e.romId { keep.append(e); continue }
            deleteQuiet(at: URL(fileURLWithPath: e.path))
            total -= e.size
            count -= 1
        }
        saveLocked(keep)
    }

    @discardableResult
    static func ensureCached(romId: String, sourcePath: String, originPath: String? = nil) -> String? {
        guard !romId.isEmpty, !sourcePath.isEmpty else { return nil }
        if let hit = getCachedPath(romId) { touch(romId); return hit }

        let src = URL(fileURLWithPath: sourcePath)
        let fm = FileManager.default
        guard fm.fileExists(atPath: sourcePath), fm.isReadableFile(atPath: sourcePath),
              let attrs = try? fm.attributesOfItem(atPath: sourcePath) else { return nil }
        let srcSize = num64(attrs[.size], fallback: -1)
        guard srcSize > 0 else { return nil }

        let copyLock = lockFor(romId)
        copyLock.lock(); defer { copyLock.unlock() }
        if let hit = getCachedPath(romId) { touch(romId); return hit }
        guard let dir = cacheDir() else { return nil }
        let dest = dir.appendingPathComponent(fileName(for: romId))
        let tmp = dir.appendingPathComponent(dest.lastPathComponent + ".part")
        deleteQuiet(at: tmp)
        do {
            try fm.copyItem(at: src, to: tmp)
            guard let ta = try? fm.attributesOfItem(atPath: tmp.path),
                  num64(ta[.size], fallback: -1) == srcSize else {
                deleteQuiet(at: tmp); return nil
            }
            do {
                try fm.moveItem(at: tmp, to: dest)
            } catch {
                deleteQuiet(at: dest)
                do {
                    try fm.moveItem(at: tmp, to: dest)
                } catch {
                    deleteQuiet(at: tmp)
                    return nil
                }
            }
        } catch {
            deleteQuiet(at: tmp)
            return nil
        }
        let origin = URL(fileURLWithPath: originPath ?? sourcePath).standardizedFileURL.path
        let entry = Entry(romId: romId, path: dest.path, size: srcSize,
                          lastAccessMs: nowMs(), origin: origin)
        writeLock.lock()
        putEntryLocked(entry)
        writeLock.unlock()
        pruneIfNeeded(protectedRomId: romId)
        return dest.path
    }

    // MARK: - 身份（rom_id 同源）

    static func md5Of(_ url: URL) -> String? {
        return RecentRoms.md5Of(url)
    }

    static func md5Of(path: String) -> String? {
        return md5Of(URL(fileURLWithPath: path))
    }

    static func romId(forFile url: URL) -> String {
        if let hex = md5Of(url) { return idMD5 + hex }
        return idPath + url.standardizedFileURL.path
    }

    static func romId(fromCachedPath path: String) -> String? {
        let norm = URL(fileURLWithPath: path).standardizedFileURL.path
        writeLock.lock(); defer { writeLock.unlock() }
        if let e = loadLocked().first(where: {
            URL(fileURLWithPath: $0.path).standardizedFileURL.path == norm
        }) { return e.romId }
        let name = URL(fileURLWithPath: norm).lastPathComponent
        guard name.hasSuffix(".gba") else { return nil }
        let stem = String(name.dropLast(4))
        guard !stem.isEmpty else { return nil }
        return idMD5 + stem
    }
}
