/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// 需求③阶段A — mGBAx-library.json manifest 封套/合并/物化。
/// 职责边界：常量 / 28 键白名单 / deny-list 注释 / 封套构建 / 纯解析 / 纯合并 /
/// 镜像三态 / 回灌。不建 recent 真源、不碰 HTTP、不碰 CCore。
/// 全部读写走 UserDefaults.standard（与 RecentRoms.defaults() 同实例）；
/// 诚实纪律：schema/version/类型不符一律忽略或保留本地，绝不伪造条目与成功。
enum ManifestSync {
    static let libraryManifest = "mGBAx-library.json"
    static let legacyRecentManifest = "recent_roms.json"   // 仅白名单识别，不写出

    /// 同步白名单真源（规范名 + 兼容别名，仅识别不写出），三端同构。
    static func isManifestName(_ name: String?) -> Bool {
        guard let name else { return false }
        let lower = name.lowercased()
        return lower == libraryManifest.lowercased() || lower == legacyRecentManifest.lowercased()
    }

    static let librarySchema = 1
    static let libraryVersion = 1
    private static let prefLastRecent = "lib.last_recent"
    private static let prefLastSettings = "lib.last_settings"
    private static let tmpSuffix = ".lib-tmp"

    // C1 §1.4 精确 28 键（iOS UserDefaults 实键，canonical 名三端唯一）。
    static let settingsWhitelist: [(String, String)] = [
        ("vf_filter",      "vf.filter"),       ("vf_blend",       "vf.blend"),
        ("vf_linear",      "vf.linear"),       ("vf_aspect",      "vf.aspect"),
        ("vf_integer",     "vf.integer"),      ("vf_scan",        "vf.scan"),
        ("vf_bright",      "vf.bright"),       ("vf_contrast",    "vf.contrast"),
        ("vf_skip",        "vf.skip"),         ("vf_skip_auto",   "vf.skipAuto"),
        ("fast_hold",      "speed.hold"),      ("turbo_mode",     "speed.turboMode"),
        ("turbo_rate",     "speed.turboRate"), ("save_type",      "save.type"),
        ("auto_load_state","save.autoLoad"),   ("auto_save_state","save.autoSave"),
        ("patches",        "save.patches"),    ("timed_save_min", "save.timedMin"),
        ("quick_rotate",   "save.quickRotate"),
        ("use_bios",       "emu.useBios"),     ("skip_bios",      "emu.skipBios"),
        ("cart_rumble",    "emu.cartRumble"),  ("solar_on",       "emu.solarOn"),
        ("solar_level",    "emu.solarLevel"),  ("sgb_borders",    "emu.sgbBorders"),
        ("gb_palette",     "emu.gbPalette"),   ("shot_format",    "shot.format"),
        ("ai_lang",        "ai.lang")
    ]

    // C1 §1.5 deny-list（硬红线；机制仍是白名单准入）：
    //  WebDAV 凭据/开关、云/联机会话与房号、诊断门 mgbax.link.*、本机身份、
    //  绝对路径态、bookkeeping lib.*。唯一允许绝对路径处：recent.items[].paths[device_id]。

    // MARK: - 数字兼容与签名

    private static func num64(_ v: Any?, fallback: Int64 = 0) -> Int64 {
        if let n = v as? NSNumber { return n.int64Value }
        if let i = v as? Int { return Int64(i) }
        if let d = v as? Double { return Int64(d) }
        return fallback
    }

    static func recentSig(_ defaults: UserDefaults) -> String {
        defaults.string(forKey: RecentRoms.storeKey) ?? ""
    }
    static func settingsSig(_ defaults: UserDefaults) -> String {
        var b = ""
        for (k, canonical) in settingsWhitelist {
            if let v = defaults.object(forKey: k) { b += "\(canonical)=\(v);" }
        }
        return b
    }

    // MARK: - 导出

    static func buildManifest(_ defaults: UserDefaults = .standard) -> [String: Any] {
        let dev = RecentRoms.deviceId()
        var recent: [String: Any] = [
            "schema": RecentRoms.schema, "device_id": dev,
            "updated_at": 0, "items": []
        ]
        if let raw = defaults.string(forKey: RecentRoms.storeKey), !raw.isEmpty,
           let data = raw.data(using: .utf8),
           let obj = try? JSONSerialization.jsonObject(with: data, options: []),
           let doc = obj as? [String: Any],
           num64(doc["schema"], fallback: -1) == Int64(RecentRoms.schema) {
            recent = doc
        }
        var values: [String: Any] = [:]
        for (iosKey, canonical) in settingsWhitelist {
            guard let v = defaults.object(forKey: iosKey) else { continue }
            if v is String || v is Bool || v is NSNumber { values[canonical] = v }
        }
        return [
            "schema": librarySchema, "version": libraryVersion,
            "device_id": dev, "timestamp": Int64(Date().timeIntervalSince1970 * 1000),
            "recent_roms": recent, "settings": values
        ]
    }

    static func exportManifest(_ defaults: UserDefaults = .standard) -> String? {
        let doc = buildManifest(defaults)
        guard JSONSerialization.isValidJSONObject(doc),
              let data = try? JSONSerialization.data(withJSONObject: doc, options: [.sortedKeys])
        else { return nil }
        return String(data: data, encoding: .utf8)
    }

    // MARK: - 纯解析

    struct Imported {
        var recent: [String: Any]
        var settings: [String: Any]
        var deviceID: String
        var timestamp: Int64
    }
    static func importManifest(_ text: String) -> Imported? {
        guard let data = text.data(using: .utf8),
              let obj = try? JSONSerialization.jsonObject(with: data, options: []),
              let doc = obj as? [String: Any],
              num64(doc["schema"], fallback: -1) == Int64(librarySchema),
              num64(doc["version"], fallback: -1) == Int64(libraryVersion)
        else { return nil }
        var recent: [String: Any] = [
            "schema": RecentRoms.schema, "device_id": "",
            "updated_at": 0, "items": []
        ]
        if let r = doc["recent_roms"] as? [String: Any],
           num64(r["schema"], fallback: -1) == Int64(RecentRoms.schema) { recent = r }
        var values: [String: Any] = [:]
        if let s = doc["settings"] as? [String: Any] {
            let allowed = Set(settingsWhitelist.map { $0.1 })
            for (k, v) in s where allowed.contains(k) {
                if v is String || v is Bool || v is NSNumber { values[k] = v }
            }
        }
        return Imported(recent: recent, settings: values,
                        deviceID: doc["device_id"] as? String ?? "",
                        timestamp: num64(doc["timestamp"]))
    }

    // MARK: - 纯合并

    private static func mergeEntry(_ a: [String: Any], _ b: [String: Any]) -> [String: Any] {
        let sa = a["sync"] as? [String: Any] ?? [:]
        let sb = b["sync"] as? [String: Any] ?? [:]
        let ta = num64(sa["updated_at"]), tb = num64(sb["updated_at"])
        let ra = num64(sa["rev"]),         rb = num64(sb["rev"])
        let oa = sa["origin_device"] as? String ?? "", ob = sb["origin_device"] as? String ?? ""
        let bWins = tb > ta || (tb == ta && (rb > ra || (rb == ra && ob > oa)))
        var out = bWins ? b : a
        let win = bWins ? b : a, lose = bWins ? a : b
        var pw = win["paths"] as? [String: String] ?? [:]
        let pl = lose["paths"] as? [String: String] ?? [:]
        for (k, v) in pl where pw[k] == nil { pw[k] = v }
        out["paths"] = pw
        if (win["id_algo"] as? String) != "md5", (lose["id_algo"] as? String) == "md5" {
            out["rom_id"] = lose["rom_id"] ?? ""
            out["id_algo"] = "md5"
            out["tentative"] = false
        }
        return out
    }

    static func mergeLibraryJson(local: [String: Any], remote: [String: Any]) -> [String: Any] {
        guard num64(local["schema"],  fallback: -1) == Int64(librarySchema),
              num64(remote["schema"], fallback: -1) == Int64(librarySchema),
              num64(local["version"],  fallback: -1) == Int64(libraryVersion),
              num64(remote["version"], fallback: -1) == Int64(libraryVersion)
        else { return local }

        var out = local
        if let lr = local["recent_roms"] as? [String: Any],
           let rr = remote["recent_roms"] as? [String: Any] {
            var byID: [String: [String: Any]] = [:]
            for e in (lr["items"] as? [[String: Any]]) ?? [] {
                if let id = e["rom_id"] as? String { byID[id] = e }
            }
            for e in (rr["items"] as? [[String: Any]]) ?? [] {
                guard let id = e["rom_id"] as? String else { continue }
                byID[id] = byID[id].map { mergeEntry($0, e) } ?? e
            }
            let sorted = byID.values.sorted {
                num64($0["last_opened_ms"]) > num64($1["last_opened_ms"])
            }
            var recent = rr
            recent["items"] = Array(sorted.prefix(RecentRoms.capacity))
            recent["device_id"] = rr["device_id"] as? String ?? lr["device_id"] as? String ?? ""
            recent["updated_at"] = max(num64(lr["updated_at"]), num64(rr["updated_at"]))
            out["recent_roms"] = recent
        }
        if let rs = remote["settings"] as? [String: Any] { out["settings"] = rs }
        out["device_id"] = remote["device_id"] ?? local["device_id"] ?? ""
        out["timestamp"] = max(num64(local["timestamp"]), num64(remote["timestamp"]))
        return out
    }

    private static func remoteAsDict(_ r: Imported) -> [String: Any] {
        return [
            "schema": librarySchema,
            "version": libraryVersion,
            "device_id": r.deviceID,
            "timestamp": r.timestamp,
            "recent_roms": r.recent,
            "settings": r.settings,
        ]
    }

    // MARK: - 镜像三态与回灌（唯一有 I/O 的部分）

    private static func writeAtomic(_ url: URL, _ text: String) -> Bool {
        let tmp = url.deletingLastPathComponent()
                     .appendingPathComponent(url.lastPathComponent + tmpSuffix)
        do {
            try text.data(using: .utf8)?.write(to: tmp, options: .atomic)
            if FileManager.default.fileExists(atPath: url.path) {
                try? FileManager.default.removeItem(at: url)
            }
            try FileManager.default.moveItem(at: tmp, to: url)
            return true
        } catch {
            try? FileManager.default.removeItem(at: tmp)
            return false
        }
    }

    /// ④-pre：首启 mtime=1；本地事件→now；无变化→不动镜像。
    static func prepareMirrors(defaults: UserDefaults = .standard, saves: URL) {
        let mirror = saves.appendingPathComponent(libraryManifest)
        let changed = recentSig(defaults) != (defaults.string(forKey: prefLastRecent) ?? "\u{0}")
                   || settingsSig(defaults) != (defaults.string(forKey: prefLastSettings) ?? "\u{0}")
        let first = !FileManager.default.fileExists(atPath: mirror.path)
        guard first || changed, let text = exportManifest(defaults), writeAtomic(mirror, text) else { return }
        let seconds: TimeInterval = first ? 1 : Date().timeIntervalSince1970
        try? FileManager.default.setAttributes([.modificationDate: Date(timeIntervalSince1970: seconds)],
                                               ofItemAtPath: mirror.path)
    }

    /// ④-post：本轮下载 manifest 才合并回写；无论如何刷新快照防 ping-pong。
    /// recent 直接写 merged 信封原文以保留 updated_at=max（不调 RecentRoms.writeAll）。
    /// libraryUpdatedName = 本轮实际命中并下载的文件名（R-A 三端同构）；nil 回退规范名。
    static func applyFromMirror(defaults: UserDefaults = .standard, saves: URL,
                                libraryUpdated: Bool, libraryUpdatedName: String? = nil) {
        let landed = libraryUpdatedName.map { saves.appendingPathComponent($0) }
                     ?? saves.appendingPathComponent(libraryManifest)
        if libraryUpdated,
           let text = try? String(contentsOf: landed, encoding: .utf8),
           let remote = importManifest(text) {
            let merged = mergeLibraryJson(local: buildManifest(defaults),
                                          remote: remoteAsDict(remote))
            if let r = merged["recent_roms"],
               let d = try? JSONSerialization.data(withJSONObject: r, options: [.sortedKeys]),
               let s = String(data: d, encoding: .utf8) {
                defaults.set(s, forKey: RecentRoms.storeKey)
            }
            if let vals = merged["settings"] as? [String: Any] {
                for (iosKey, canonical) in settingsWhitelist {
                    guard let v = vals[canonical] else { continue }
                    if v is String || v is Bool || v is NSNumber { defaults.set(v, forKey: iosKey) }
                }
            }
        }
        defaults.set(recentSig(defaults), forKey: prefLastRecent)
        defaults.set(settingsSig(defaults), forKey: prefLastSettings)
    }
}
