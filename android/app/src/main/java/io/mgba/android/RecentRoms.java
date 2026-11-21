/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;

/**
 * 「最近打开过的 ROM」列表（三端统一 schema，见 .zcode-tmp/SY2.md §2.2）。
 * 纯增量：不读写 lastRom / rom_favs，不动现有 25 处 lastRom 引用。
 * 身份靠全文件 MD5（md5:<32hex>）；算不出时降级 path:<abs> + tentative=true，
 * 绝不伪造哈希、绝不因“记录里有路径”假装打开。
 *
 * 三层缓存（避免每次打开重算 32MB）：
 *   1) 持久化：rom_id 本身就是“md5:”结果写进 JSON；下次 (size,crc32) 未变则不重算；
 *   2) 内存：MD5_CACHE / CRC_CACHE（ConcurrentHashMap，key 含 size[/crc] 做失效）；
 *   3) 快筛：resolve() 先按 size + crc32 过滤候选，命中才做 MD5 确认。
 */
public final class RecentRoms {
    private RecentRoms() { }

    /** 与 EmulatorActivity.getPreferences(MODE_PRIVATE) 同一文件（local class name = "EmulatorActivity"）。 */
    static final String PREFS_NAME = "EmulatorActivity";
    public static final String PREF_RECENT = "recent_roms";
    /** 契约 §1.7 设备私有键（唯一真源，三端同名同值）。 */
    public static final String PREF_DEVICE_ID = "mgbax_device_id";
    /** 旧键：仅用于兼容升级读取，迁移后立即删除，禁止再次写入。 */
    private static final String PREF_DEVICE_ID_LEGACY = "device_id";
    public static final int CAPACITY = 20;
    public static final int SCHEMA = 1;

    private static final String ID_MD5 = "md5:";
    private static final String ID_PATH = "path:";
    private static final Object WRITE_LOCK = new Object();

    private static final Map<String, String> MD5_CACHE = new ConcurrentHashMap<>();
    private static final Map<String, Long> CRC_CACHE = new ConcurrentHashMap<>();

    // ── 数据结构：字段与 SY2 §2.2 一一对应 ─────────────────────────
    public static final class Entry {
        public String romId;                 // rom_id
        public String idAlgo;                // id_algo : md5 / path
        public boolean tentative;            // tentative
        public long size;                    // size
        public long crc32;                   // crc32（-1 = 未知）
        public String displayName;           // display_name（basename）
        public final Map<String, String> paths = new LinkedHashMap<>(); // device_id -> 绝对路径
        public long lastOpenedMs;            // last_opened_ms
        public String lastDeviceId;          // last_device_id
        public int version;                  // version
        public int openCount;                // open_count（仅统计）
        public String syncOrigin;            // sync.origin_device（SY1/SY7 预留）
        public long syncUpdatedAt;           // sync.updated_at
        public int syncRev;                  // sync.rev
        public String syncOp;                // sync.op : upsert / delete

        public Entry() { }

        /** 单条坏 JSON 只返回 null 跳过，不影响整表。 */
        static Entry fromJson(JSONObject o) {
            if (o == null) return null;
            try {
                Entry e = new Entry();
                e.romId = o.optString("rom_id", null);
                if (e.romId == null || e.romId.isEmpty()) return null;
                e.idAlgo = o.optString("id_algo", "md5");
                e.tentative = o.optBoolean("tentative", false);
                e.size = o.optLong("size", 0L);
                e.crc32 = o.optLong("crc32", -1L);
                e.displayName = o.optString("display_name", null);
                e.lastOpenedMs = o.optLong("last_opened_ms", 0L);
                e.lastDeviceId = o.optString("last_device_id", null);
                e.version = o.optInt("version", 1);
                e.openCount = o.optInt("open_count", 0);
                JSONObject ps = o.optJSONObject("paths");
                if (ps != null) {
                    Iterator<String> keys = ps.keys();
                    while (keys.hasNext()) {
                        String k = keys.next();
                        String v = ps.optString(k, null);
                        if (v != null && !v.isEmpty()) e.paths.put(k, v);
                    }
                }
                JSONObject s = o.optJSONObject("sync");
                if (s != null) {
                    e.syncOrigin = s.optString("origin_device", null);
                    e.syncUpdatedAt = s.optLong("updated_at", 0L);
                    e.syncRev = s.optInt("rev", 0);
                    e.syncOp = s.optString("op", "upsert");
                }
                return e;
            } catch (Exception ex) {
                return null;
            }
        }

        JSONObject toJson() {
            JSONObject o = new JSONObject();
            try {
                o.put("rom_id", romId);
                o.put("id_algo", idAlgo == null ? "md5" : idAlgo);
                o.put("tentative", tentative);
                o.put("size", size);
                o.put("crc32", crc32);
                o.put("display_name", displayName == null ? "" : displayName);
                JSONObject p = new JSONObject();
                for (Map.Entry<String, String> kv : paths.entrySet()) {
                    p.put(kv.getKey(), kv.getValue());
                }
                o.put("paths", p);
                o.put("last_opened_ms", lastOpenedMs);
                o.put("last_device_id", lastDeviceId == null ? "" : lastDeviceId);
                o.put("version", version);
                o.put("open_count", openCount);
                JSONObject s = new JSONObject();
                String origin = syncOrigin == null ? (lastDeviceId == null ? "" : lastDeviceId) : syncOrigin;
                s.put("origin_device", origin);
                s.put("updated_at", syncUpdatedAt > 0 ? syncUpdatedAt : lastOpenedMs);
                s.put("rev", syncRev);
                s.put("op", syncOp == null ? "upsert" : syncOp);
                o.put("sync", s);
            } catch (Exception ignored) { }
            return o;
        }
    }

    private static SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /** 安装期生成一次稳定 device_id（and- + UUID），只读不重算。兼容升级：旧键 device_id 迁移到新键。 */
    public static String deviceId(Context ctx) {
        SharedPreferences p = prefs(ctx);
        String id = p.getString(PREF_DEVICE_ID, null);
        if (id == null || id.isEmpty()) {
            String legacy = p.getString(PREF_DEVICE_ID_LEGACY, null);
            if (legacy != null && !legacy.isEmpty()) {
                id = legacy;                       // 读旧键 → 写新键，身份不漂移
            } else {
                id = "and-" + UUID.randomUUID().toString().replace("-", "");
            }
            p.edit()
                    .putString(PREF_DEVICE_ID, id)
                    .remove(PREF_DEVICE_ID_LEGACY) // 删旧键
                    .apply();
        }
        return id;
    }

    /** 全文件流式 MD5（照搬 GBoyCloudLink.gameUuid() 2811-2830），64KB 缓冲；失败返回 null，绝不抛。 */
    public static String md5Of(File f) {
        if (f == null) return null;
        String key = f.getAbsolutePath() + '|' + f.length() + '|' + crc32Of(f);
        String hit = MD5_CACHE.get(key);
        if (hit != null) return hit;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buf = new byte[65536];
            try (InputStream in = new FileInputStream(f)) {
                int n;
                while ((n = in.read(buf)) > 0) md.update(buf, 0, n);
            }
            StringBuilder hex = new StringBuilder(32);
            for (byte b : md.digest()) {
                hex.append(Character.forDigit((b >> 4) & 0xF, 16));
                hex.append(Character.forDigit(b & 0xF, 16));
            }
            String out = hex.toString();
            MD5_CACHE.put(key, out);
            return out;
        } catch (Exception e) {
            return null;
        }
    }

    /** 全文件流式 CRC32（照搬 EmulatorActivity.romCrc32() 3399-3416），64KB 缓冲；失败 -1。 */
    public static long crc32Of(File f) {
        if (f == null) return -1L;
        String key = f.getAbsolutePath() + '|' + f.length();
        Long hit = CRC_CACHE.get(key);
        if (hit != null) return hit;
        try {
            CRC32 crc = new CRC32();
            byte[] buf = new byte[65536];
            try (InputStream in = new FileInputStream(f)) {
                int n;
                while ((n = in.read(buf)) > 0) crc.update(buf, 0, n);
            }
            long v = crc.getValue();
            CRC_CACHE.put(key, v);
            return v;
        } catch (Exception e) {
            return -1L;
        }
    }

    private static String normalizePath(String path) {
        return new File(path).getAbsolutePath();
    }

    private static final Comparator<Entry> BY_TIME_DESC = new Comparator<Entry>() {
        @Override public int compare(Entry a, Entry b) {
            return Long.compare(b.lastOpenedMs, a.lastOpenedMs);
        }
    };

    /** 读整表，按 last_opened_ms 降序；无/损坏 → 空表，不抛异常。 */
    public static List<Entry> list(Context ctx) {
        List<Entry> out = new ArrayList<>();
        String raw = prefs(ctx).getString(PREF_RECENT, null);
        if (raw == null || raw.isEmpty()) return out;
        try {
            JSONObject doc = new JSONObject(raw);
            JSONArray arr = doc.optJSONArray("items");
            if (arr == null) return out;
            for (int i = 0; i < arr.length(); i++) {
                Entry e = Entry.fromJson(arr.optJSONObject(i));
                if (e != null) out.add(e); // 单条坏 Entry 跳过，不影响整表
            }
        } catch (Exception ignored) {
            return new ArrayList<Entry>();
        }
        Collections.sort(out, BY_TIME_DESC);
        return out;
    }

    /** 整表写回（截断 20 + schema:1 envelope）；updated_at=now。 */
    public static void writeAll(Context ctx, List<Entry> items) {
        writeAllWithUpdatedAt(ctx, items, 0L);
    }

    /** 调用者已持有 WRITE_LOCK 时使用，避免 synchronized 重入混乱。 */
    private static void writeAllLocked(Context ctx, List<Entry> items) {
        writeAllLocked(ctx, items, 0L);
    }

    /** 导入专用：以显式 updated_at 写回（>0 用其值，否则 now），保留合并结果的 max 时间戳。 */
    public static void writeAllWithUpdatedAt(Context ctx, List<Entry> items, long explicitUpdatedAt) {
        synchronized (WRITE_LOCK) {
            writeAllLocked(ctx, items, explicitUpdatedAt);
        }
    }

    /** 实际写回（含显式/默认 updated_at 二选一）。 */
    private static void writeAllLocked(Context ctx, List<Entry> items, long explicitUpdatedAt) {
        List<Entry> keep = items == null ? new ArrayList<Entry>() : new ArrayList<>(items);
        if (keep.size() > CAPACITY) keep = new ArrayList<>(keep.subList(0, CAPACITY));
        JSONObject doc = new JSONObject();
        try {
            doc.put("schema", SCHEMA);
            doc.put("device_id", deviceId(ctx));
            doc.put("updated_at", explicitUpdatedAt > 0 ? explicitUpdatedAt : System.currentTimeMillis());
            JSONArray arr = new JSONArray();
            for (Entry e : keep) arr.put(e.toJson());
            doc.put("items", arr);
            prefs(ctx).edit().putString(PREF_RECENT, doc.toString()).apply();
        } catch (Exception ignored) { }
    }

    /**
     * 加载成功后记一次（SY9 §5.2：loadRom 中 core.load 返回 true 之后）。
     * 含文件 I/O（crc32 + md5），父会话须放后台线程，勿阻塞 emu 循环。
     */
    public static void record(Context ctx, String path) {
        if (path == null) return;
        File f = new File(path);
        if (!f.isFile() || !f.canRead()) return; // 文件不可读 → 不记，绝不伪造

        final long size = f.length();
        final long crc = crc32Of(f);
        final String md5 = md5Of(f);
        final String abs = normalizePath(path);
        final String display = f.getName();
        final String dev = deviceId(ctx);
        final String romId = md5 != null ? ID_MD5 + md5 : ID_PATH + abs;
        final boolean tentative = md5 == null;

        synchronized (WRITE_LOCK) {
            // 已有数据但 JSON 损坏 → 保留原串、跳过本次写入，避免静默丢数据
            String raw = prefs(ctx).getString(PREF_RECENT, null);
            if (raw != null && !raw.isEmpty()) {
                try { new JSONObject(raw); } catch (Exception ex) { return; }
            }
            List<Entry> items = list(ctx); // 已按时间倒序
            Entry target = null;
            for (Entry e : items) {
                boolean sameId = romId.equals(e.romId); // 主键 rom_id 去重
                boolean quickSame = !tentative && e.size == size && e.crc32 == crc
                        && abs.equals(e.paths.get(dev)); // size+crc32 快筛次级去重
                if (sameId || quickSame) { target = e; break; }
            }
            if (target == null) {
                target = new Entry();
                items.add(target);
            }
            long now = System.currentTimeMillis();
            target.romId = romId;
            target.idAlgo = tentative ? "path" : "md5";
            target.tentative = tentative;
            target.size = size;
            target.crc32 = crc;
            target.displayName = display;
            target.paths.put(dev, abs); // 按 device_id 覆盖，保留他端路径（SY2 §4 并集）
            target.lastOpenedMs = now;
            target.lastDeviceId = dev;
            target.version = target.version + 1;
            target.openCount = target.openCount + 1;
            target.syncOrigin = dev;
            target.syncUpdatedAt = now;
            target.syncRev = target.syncRev + 1;
            target.syncOp = "upsert";

            Collections.sort(items, BY_TIME_DESC);
            writeAllLocked(ctx, items); // 不重复加锁
        }
    }

    /**
     * 从缓存副本打开时用：只更新最近访问时间与排序，绝不改 paths（缓存路径是设备私有，
     * 不得污染三端同步的 paths 并集）。romId 不存在则 no-op。
     */
    public static void touchById(Context ctx, String romId) {
        if (ctx == null || romId == null) return;
        final String dev = deviceId(ctx);          // 迁移后稳定；只取一次
        synchronized (WRITE_LOCK) {
            String raw = prefs(ctx).getString(PREF_RECENT, null);
            if (raw != null && !raw.isEmpty()) {
                try { new JSONObject(raw); } catch (Exception ex) { return; }
            }
            List<Entry> items = list(ctx);
            long now = System.currentTimeMillis();
            for (Entry e : items) {
                if (romId.equals(e.romId)) {
                    e.lastOpenedMs = now;
                    e.version = e.version + 1;      // §1.3 计数语义
                    e.openCount = e.openCount + 1;  // 统计
                    e.lastDeviceId = dev;           // 契约 §1.3
                    e.syncUpdatedAt = now;
                    e.syncRev = e.syncRev + 1;
                    e.syncOrigin = dev;
                    e.syncOp = "upsert";
                    // 刻意不写 paths —— 缓存路径设备私有（§1.6 / C10 A1）
                    Collections.sort(items, BY_TIME_DESC);
                    writeAllLocked(ctx, items);
                    return;
                }
            }
        }
    }

    public static String resolve(Entry e, Context ctx) {
        return resolve(e, ctx, null);
    }

    /**
     * 解析本端可打开的绝对路径（诚实核心：必须哈希证实，找不到返回 null，UI 标灰）。
     * @param candidates 父会话 scanRoms() 得到的本地库候选（可为 null）
     */
    public static String resolve(Entry e, Context ctx, List<File> candidates) {
        if (e == null) return null;
        String dev = deviceId(ctx);
        String own = e.paths.get(dev);
        if (own != null && verified(own, e)) return own;
        for (String p : e.paths.values()) {
            if (p != null && !p.equals(own) && verified(p, e)) {
                bindPath(ctx, e, p);
                return p;
            }
        }
        if (candidates != null) {
            for (File f : candidates) {
                if (f == null || !f.isFile() || !f.canRead()) continue;
                if (e.size > 0 && f.length() != e.size) continue;
                long c = crc32Of(f);
                if (e.crc32 >= 0 && c != e.crc32) continue;
                String m = md5Of(f);
                if (m == null) continue;
                if (e.tentative || (ID_MD5 + m).equals(e.romId)) {
                    String hit = f.getAbsolutePath();
                    bindPath(ctx, e, hit);
                    return hit;
                }
            }
        }
        return null; // 本设备未找到 / 哈希未证实 → 不打开、不伪造，UI 标灰
    }

    /** 哈希证实一条路径确实是该 ROM（md5: 条目必须 md5 相符）。 */
    private static boolean verified(String path, Entry e) {
        File f = new File(path);
        if (!f.isFile() || !f.canRead()) return false;
        if (e.size > 0 && f.length() != e.size) return false;
        long c = crc32Of(f);
        if (e.crc32 >= 0 && c != e.crc32) return false;
        if (e.tentative) return true; // path: 占位以存在 + size/crc 为准
        String m = md5Of(f);
        return m != null && (ID_MD5 + m).equals(e.romId);
    }

    /** 把新找到的本端路径写回 paths[device_id]（按 rom_id upsert，不动打开时间）。 */
    private static void bindPath(Context ctx, Entry e, String path) {
        synchronized (WRITE_LOCK) {
            List<Entry> items = list(ctx);
            String dev = deviceId(ctx);
            for (Entry it : items) {
                if (e.romId.equals(it.romId)) {
                    it.paths.put(dev, path);
                    writeAllLocked(ctx, items);
                    return;
                }
            }
        }
    }

    /** 只清最近列表；不动 lastRom / rom_favs（向后兼容）。 */
    public static void clear(Context ctx) {
        synchronized (WRITE_LOCK) {
            prefs(ctx).edit().remove(PREF_RECENT).apply();
        }
    }
}
