/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation
import CryptoKit

/// 「最近打开过的 ROM」— 三端统一 schema（C1_CONTRACT §1.3 / SY2 §2.2）。
/// 纯增量：不读写 lastRom / lastRomBookmark / rom_favs，保留现有键。
/// 身份 = 整文件 MD5（md5:<32hex>）；算不出 → path:<abs> + tentative=true，绝不伪造。
/// 三端对称基准 = Android RecentRoms.java（已 E2E 验证 8 项 PASS）。
/// 按 SYNC_DECISIONS：device_id 私有键 mgbax_device_id、前缀 ios-、recent_roms 键名。
final class RecentRoms {
    // MARK: 具名常量（三端同名同值；禁裸字符串/裸 hex）
    static let storeKey      = "recent_roms"        // UserDefaults 单 JSON 字符串 = Android PREF_RECENT
    static let deviceIdKey   = "mgbax_device_id"    // C1_CONTRACT §1.7 设备私有键
    static let devicePrefix  = "ios-"               // C1_CONTRACT §1.7
    static let schema        = 1                    // RECENT_SCHEMA
    static let capacity      = 20                   // CAPACITY
    static let idMD5         = "md5:"
    static let idPath        = "path:"

    private static let writeLock = NSLock()
    private static var md5Cache: [String: String] = [:]   // key = path|size|crc32
    private static var crcCache: [String: Int64]  = [:]   // key = path|size

    private init() {}

    // MARK: - Entry（字段与 C1_CONTRACT §1.3 一一对应）
    struct Entry {
        var romId = ""
        var idAlgo = "md5"
        var tentative = false
        var size: Int64 = 0
        var crc32: Int64 = -1                 // -1 = 未知
        var displayName = ""
        var paths: [String: String] = [:]     // device_id -> 绝对路径
        var lastOpenedMs: Int64 = 0
        var lastDeviceId = ""
        var version = 0
        var openCount = 0
        var syncOrigin = ""
        var syncUpdatedAt: Int64 = 0
        var syncRev = 0
        var syncOp = "upsert"

        /// 单条坏 JSON → nil，跳过不影响整表。
        static func from(_ o: [String: Any]) -> Entry? {
            guard let rid = o["rom_id"] as? String, !rid.isEmpty else { return nil }
            var e = Entry()
            e.romId        = rid
            e.idAlgo       = o["id_algo"] as? String ?? "md5"
            e.tentative    = o["tentative"] as? Bool ?? false
            e.size         = num64(o["size"])
            e.crc32        = num64(o["crc32"], fallback: -1)
            e.displayName  = o["display_name"] as? String ?? ""
            e.lastOpenedMs = num64(o["last_opened_ms"])
            e.lastDeviceId = o["last_device_id"] as? String ?? ""
            e.version      = Int(num64(o["version"], fallback: 1))  // 对齐 Android Entry.fromJson 缺省 1
            e.openCount    = Int(num64(o["open_count"]))
            if let ps = o["paths"] as? [String: String] { e.paths = ps }
            if let s = o["sync"] as? [String: Any] {
                e.syncOrigin    = s["origin_device"] as? String ?? ""
                e.syncUpdatedAt = num64(s["updated_at"])
                e.syncRev       = Int(num64(s["rev"]))
                e.syncOp        = s["op"] as? String ?? "upsert"
            }
            return e
        }

        /// 与 Android Entry.toJson() 同字段同结构。
        func dict() -> [String: Any] {
            var p: [String: String] = [:]
            for (k, v) in paths where !v.isEmpty { p[k] = v }
            let now = lastOpenedMs
            let s: [String: Any] = [
                "origin_device": syncOrigin.isEmpty ? lastDeviceId : syncOrigin,
                "updated_at": syncUpdatedAt > 0 ? syncUpdatedAt : now,
                "rev": syncRev,
                "op": syncOp.isEmpty ? "upsert" : syncOp,
            ]
            return [
                "rom_id": romId,
                "id_algo": idAlgo.isEmpty ? "md5" : idAlgo,
                "tentative": tentative,
                "size": size,
                "crc32": crc32,
                "display_name": displayName,
                "paths": p,
                "last_opened_ms": lastOpenedMs,
                "last_device_id": lastDeviceId,
                "version": version,
                "open_count": openCount,
                "sync": s,
            ]
        }
    }

    // MARK: - JSON 数字兼容（NSNumber / Int / Double）
    private static func num64(_ any: Any?, fallback: Int64 = 0) -> Int64 {
        if let n = any as? NSNumber { return n.int64Value }
        if let v = any as? Int64 { return v }
        if let v = any as? Int { return Int64(v) }
        if let v = any as? Double { return Int64(v) }
        return fallback
    }

    private static func defaults() -> UserDefaults { .standard }

    // MARK: - deviceId（安装期一次，只读不重算；ios- 前缀）
    static func deviceId() -> String {
        let d = defaults()
        if let id = d.string(forKey: deviceIdKey), !id.isEmpty { return id }
        let id = devicePrefix + UUID().uuidString.replacingOccurrences(of: "-", with: "").lowercased()
        d.set(id, forKey: deviceIdKey)
        return id
    }

    // MARK: - 全文件流式 MD5（Insecure.MD5，CryptoKit）
    /// 失败返回 nil，绝不抛、绝不伪造。沿用 GBoyLink.swift:1099-1108 的流式写法。
    /// 身份基于原始字节（SYNC_DECISIONS S12）：调用方须在补零前用原始文件调用本方法。
    static func md5Of(_ url: URL) -> String? {
        let path = url.standardizedFileURL.path
        let size = (try? FileManager.default.attributesOfItem(atPath: path)[.size] as? NSNumber)?.int64Value ?? 0
        let crc = crc32Of(url)
        let key = "\(path)|\(size)|\(crc)"
        if let hit = md5Cache[key] { return hit }
        guard let handle = FileHandle(forReadingAtPath: path) else { return nil }
        defer { try? handle.close() }
        var hasher = Insecure.MD5()
        while true {
            guard let chunk = try? handle.read(upToCount: 65536), !chunk.isEmpty else { break }
            hasher.update(data: chunk)
        }
        let hex = hasher.finalize().map { String(format: "%02x", $0) }.joined()
        md5Cache[key] = hex
        return hex
    }

    // MARK: - 全文件流式 CRC32（复用 RomSettings.crc32，UInt32 → Int64 防溢出）
    static func crc32Of(_ url: URL) -> Int64 {
        let path = url.standardizedFileURL.path
        let size = (try? FileManager.default.attributesOfItem(atPath: path)[.size] as? NSNumber)?.int64Value ?? 0
        let key = "\(path)|\(size)"
        if let hit = crcCache[key] { return hit }
        guard let v = RomSettings.crc32(ofFile: url) else { return -1 }
        let out = Int64(v)
        crcCache[key] = out
        return out
    }

    // MARK: - S12 身份锚（补零安全）
    static let padSize: Int64 = 33_554_432   // 32 MiB，与 VC 补零阈值同值（具名常量）

    /// 已锁定的原始字节身份；md5 = 去 "md5:" 前缀的 hex，nil = path: 降级。
    struct Identity {
        var md5: String?
        var size: Int64
        var crc: Int64                       // -1 = 未知
    }

    private static func prefixData(_ url: URL, count: Int) -> Data? {
        guard let fh = FileHandle(forReadingAtPath: url.standardizedFileURL.path) else { return nil }
        defer { try? fh.close() }
        fh.seek(toFileOffset: 0)
        return try? fh.read(upToCount: count)
    }

    private static func tailIsZero(_ url: URL, from offset: Int64) -> Bool {
        guard let fh = FileHandle(forReadingAtPath: url.standardizedFileURL.path) else { return false }
        defer { try? fh.close() }
        fh.seek(toFileOffset: UInt64(max(0, offset)))
        while let chunk = try? fh.read(upToCount: 65536), !chunk.isEmpty {
            if chunk.contains(where: { $0 != 0 }) { return false }
        }
        return true
    }

    /// S12 身份：四条证据齐备才复用 persisted 原始身份，否则现算。
    /// 证据 = 旧条目 size<32MB 且当前 size==32MB 且前缀 CRC 相等 且尾部全零，缺一不可。
    /// 绝不只凭 size==32MB 复用（那是伪造身份证据）。
    static func identity(of url: URL) -> Identity {
        let p = url.standardizedFileURL.path
        let cur = (try? FileManager.default.attributesOfItem(atPath: p)[.size] as? NSNumber)?.int64Value ?? 0
        let dev = deviceId()
        if let e = list().first(where: { $0.paths[dev] == p }),
           e.size > 0, e.size < padSize, cur == padSize, e.crc32 >= 0,
           let prefix = prefixData(url, count: Int(e.size)),
           Zip.crc32(prefix) == UInt32(truncatingIfNeeded: e.crc32),
           tailIsZero(url, from: e.size) {
            let md5 = e.romId.hasPrefix(idMD5) ? String(e.romId.dropFirst(idMD5.count)) : nil
            return Identity(md5: md5, size: e.size, crc: e.crc32)
        }
        return Identity(md5: md5Of(url), size: cur, crc: crc32Of(url))
    }

    // MARK: - envelope 读写（schema/device_id/updated_at/items）
    /// 读整表，按 last_opened_ms 倒序；无/损坏 → 空表，不抛。
    static func list() -> [Entry] {
        guard let raw = defaults().string(forKey: storeKey), !raw.isEmpty,
              let data = raw.data(using: .utf8),
              let obj = try? JSONSerialization.jsonObject(with: data, options: []),
              let doc = obj as? [String: Any],
              let items = doc["items"] as? [Any] else { return [] }
        var out: [Entry] = []
        for it in items {
            if let o = it as? [String: Any], let e = Entry.from(o) { out.append(e) }
        }
        out.sort { $0.lastOpenedMs > $1.lastOpenedMs }
        return out
    }

    /// 整表写回（截断 CAPACITY + envelope）；同步导入后也走这里。
    static func writeAll(_ items: [Entry]) {
        var keep = Array(items.prefix(capacity))
        keep.sort { $0.lastOpenedMs > $1.lastOpenedMs }
        let doc: [String: Any] = [
            "schema": schema,
            "device_id": deviceId(),
            "updated_at": Int64(Date().timeIntervalSince1970 * 1000),
            "items": keep.map { $0.dict() },
        ]
        guard let data = try? JSONSerialization.data(withJSONObject: doc, options: []),
              let raw = String(data: data, encoding: .utf8) else { return }
        defaults().set(raw, forKey: storeKey)
    }

    // MARK: - record（加载成功钩子；含文件 I/O，调用方须在后台线程）
    /// 现算便捷入口（无补零场景 / 首开原始文件）。
    static func record(_ url: URL) {
        let size = (try? FileManager.default.attributesOfItem(atPath: url.path)[.size] as? NSNumber)?.int64Value ?? 0
        recordWithIdentity(url, identity: Identity(md5: md5Of(url), size: size, crc: crc32Of(url)))
    }

    /// 用已锁定的原始字节身份 upsert（补零场景：identity 由 identity(of:) 在补零前锁定）。
    /// bindPath=false（从缓存副本打开）：只刷 recency，绝不把私有缓存路径写进 paths（D5/C10 A1）。
    static func recordWithIdentity(_ url: URL, identity: Identity, bindPath: Bool = true) {
        guard FileManager.default.isReadableFile(atPath: url.standardizedFileURL.path) else { return }
        let size = identity.size
        let crc  = identity.crc
        let md5  = identity.md5                     // nil → path: 降级，不伪造
        let abs  = url.standardizedFileURL.path
        let dev  = deviceId()
        let romId = md5.map { idMD5 + $0 } ?? (idPath + abs)
        let tentative = md5 == nil
        let now = Int64(Date().timeIntervalSince1970 * 1000)

        writeLock.lock()
        defer { writeLock.unlock() }
        // 已有数据但 JSON 损坏 → 保留原串、跳过本次写入，避免静默丢数据
        if let raw = defaults().string(forKey: storeKey), !raw.isEmpty,
           let data = raw.data(using: .utf8),
           (try? JSONSerialization.jsonObject(with: data, options: [])) == nil { return }

        var items = list()
        // 直接记录目标下标：Swift 是值类型，若先 append 空 Entry 再按 romId 回查会找不到
        // （新条目 romId 尚为空），导致首次打开记不进。用 index 定位可同时覆盖命中/新增两路。
        var targetIdx: Int? = nil
        for (i, e) in items.enumerated() {
            let sameId = romId == e.romId
            let quickSame = !tentative && e.size == size && e.crc32 == crc && e.paths[dev] == abs
            if sameId || quickSame { targetIdx = i; break }
        }
        if targetIdx == nil { items.append(Entry()) ; targetIdx = items.count - 1 }
        guard let idx = targetIdx else { return }
        var t = items[idx]
        t.romId = romId
        t.idAlgo = tentative ? "path" : "md5"
        t.tentative = tentative
        t.size = size
        t.crc32 = crc
        t.displayName = url.lastPathComponent
        if bindPath { t.paths[dev] = abs }           // 缓存打开时不写私有路径，保留他端真实路径（并集）
        t.lastOpenedMs = now
        t.lastDeviceId = dev
        t.version += 1
        t.openCount += 1
        t.syncOrigin = dev
        t.syncUpdatedAt = now
        t.syncRev += 1
        t.syncOp = "upsert"
        // 值类型拷贝按原下标写回（不用 romId 回查——新条目此时才刚赋 romId，但旧条目可能重名）。
        items[idx] = t
        writeAll(items)
    }

    /// 从缓存副本打开：只更新时间/排序，不改 paths（缓存路径设备私有，不污染并集）。
    static func touchById(_ romId: String) {
        writeLock.lock(); defer { writeLock.unlock() }
        var items = list()
        let now = Int64(Date().timeIntervalSince1970 * 1000)
        if let idx = items.firstIndex(where: { $0.romId == romId }) {
            let dev = deviceId()
            items[idx].lastOpenedMs = now
            items[idx].version += 1
            items[idx].openCount += 1
            items[idx].lastDeviceId = dev
            items[idx].syncUpdatedAt = now
            items[idx].syncRev += 1
            items[idx].syncOrigin = dev
            items[idx].syncOp = "upsert"
            writeAll(items)
        }
    }

    // MARK: - resolve（诚实核心：哈希证实才返回，找不到 nil → UI 标灰）
    static func resolve(_ e: Entry, candidates: [URL]? = nil) -> URL? {
        let dev = deviceId()
        if let own = e.paths[dev], verified(own, e) { return URL(fileURLWithPath: own) }
        for p in e.paths.values where p != e.paths[dev] {
            if verified(p, e) { bindPath(e, p); return URL(fileURLWithPath: p) }
        }
        if let candidates = candidates {
            for f in candidates {
                guard FileManager.default.isReadableFile(atPath: f.path) else { continue }
                let size = (try? FileManager.default.attributesOfItem(atPath: f.path)[.size] as? NSNumber)?.int64Value ?? 0
                if e.size > 0 && size != e.size { continue }
                let c = crc32Of(f)
                if e.crc32 >= 0 && c != e.crc32 { continue }
                guard let m = md5Of(f) else { continue }
                if e.tentative || (idMD5 + m) == e.romId {
                    bindPath(e, f.standardizedFileURL.path)
                    return f
                }
            }
        }
        return nil
    }

    private static func verified(_ path: String, _ e: Entry) -> Bool {
        guard FileManager.default.isReadableFile(atPath: path) else { return false }
        let url = URL(fileURLWithPath: path)
        let size = (try? FileManager.default.attributesOfItem(atPath: path)[.size] as? NSNumber)?.int64Value ?? 0

        // 情形1：磁盘未补零（≥32MB 或尚未补零）→ 严格相等校验。
        if size == e.size || e.size <= 0 {
            let c = crc32Of(url)
            if e.crc32 >= 0 && c != e.crc32 { return false }
            if e.tentative { return true }
            guard let m = md5Of(url) else { return false }
            return (idMD5 + m) == e.romId
        }

        // 情形2：iOS 补零独有差异（J1 R1）——Entry 记原始 <32MB，磁盘已被补零到 32MB。
        // 四证据：Entry 原始 0<size<padSize、磁盘==padSize、前缀 CRC 相等、尾部全零。
        // 证据齐备则对「原始前缀」算 MD5，与 e.romId 比对；绝不只凭 size 放行。
        guard e.size > 0, e.size < padSize, size == padSize, e.crc32 >= 0,
              let prefix = prefixData(url, count: Int(e.size)),
              Zip.crc32(prefix) == UInt32(truncatingIfNeeded: e.crc32),
              tailIsZero(url, from: e.size) else { return false }
        if e.tentative { return true }
        let m = Insecure.MD5.hash(data: prefix).map { String(format: "%02x", $0) }.joined()
        return (idMD5 + m) == e.romId
    }

    /// 只读核验缓存副本（D5/C10 A1：不写回 paths）。供 UI verifiedCacheURL 调用。
    static func verify(_ path: String, against e: Entry) -> Bool { verified(path, e) }

    private static func bindPath(_ e: Entry, _ path: String) {
        writeLock.lock(); defer { writeLock.unlock() }
        var items = list()
        let dev = deviceId()
        if let idx = items.firstIndex(where: { $0.romId == e.romId }) {
            items[idx].paths[dev] = path
            writeAll(items)
        }
    }

    /// 只清最近列表；不动 lastRom / lastRomBookmark / rom_favs。
    static func clear() {
        writeLock.lock(); defer { writeLock.unlock() }
        defaults().removeObject(forKey: storeKey)
    }
}
