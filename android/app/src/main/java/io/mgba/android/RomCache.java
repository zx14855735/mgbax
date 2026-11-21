/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地 ROM 副本缓存（需求④）。
 * - 缓存目录：getExternalFilesDir("rom_cache")，app 专属外部目录，系统不会随手清；
 * - 身份：rom_id（与 RecentRoms 一致，md5:<32hex> 或 path:<abs>），文件名去 "md5:" 前缀 + ".gba"；
 * - 清单：独立 prefs 文件 "RomCache"，key "index"，
 *   JSON {"schema":1,"entries":{rom_id:{path,size,last_access_ms}}}；
 * - LRU：>500MB 或 >20 条 → 按 last_access_ms 升序删最旧，清到 80% 水位（400MB/16 条），
 *   当前加载的 rom_id 通过 pruneIfNeeded(ctx, romId) 参数保护不删。
 *
 * 诚实纪律：size 不符/文件缺失/JSON 损坏/复制失败/磁盘满一律返回 null 或自愈，绝不假装缓存成功。
 * 缓存路径绝不写入 RecentRoms.paths / WebDAV manifest（设备私有，防污染三端同步）。
 * minSdk 24 兼容：不用 java.nio.file（API 26+ 才可用），复制用普通 FileInputStream/FileOutputStream。
 * 本类含文件 I/O，所有 public 方法调用方须放后台线程，勿阻塞 emu 循环。
 */
public final class RomCache {
    private RomCache() { }

    private static final String PREFS_NAME = "RomCache";
    private static final String PREF_INDEX = "index";
    private static final String CACHE_DIR = "rom_cache";
    private static final int SCHEMA = 1;

    /** LRU 上限与 80% 水位。 */
    static final long MAX_BYTES = 500L * 1024L * 1024L;      // 500MB
    static final int MAX_ENTRIES = 20;
    static final long WATERMARK_BYTES = (long) (MAX_BYTES * 0.8); // 400MB
    static final int WATERMARK_ENTRIES = (int) (MAX_ENTRIES * 0.8); // 16

    private static final Object WRITE_LOCK = new Object();
    private static final ConcurrentHashMap<String, Object> COPY_LOCKS = new ConcurrentHashMap<>();

    /** 清单条目：rom_id -> {path,size,last_access_ms}。 */
    private static final class Entry {
        String romId;
        String path;
        long size;
        long lastAccessMs;
    }

    private static final Comparator<Entry> BY_ACCESS_ASC = new Comparator<Entry>() {
        @Override public int compare(Entry a, Entry b) {
            return Long.compare(a.lastAccessMs, b.lastAccessMs); // 最旧在前
        }
    };

    private static SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    private static File cacheDir(Context ctx) {
        if (ctx == null) return null;
        File base = ctx.getExternalFilesDir(null); // 根：<external>/files；外部未挂载时 null
        if (base == null) base = ctx.getFilesDir(); // 回退：<internal>/files
        if (base == null) return null;
        File target = new File(base, CACHE_DIR);   // 统一一层 rom_cache 子目录
        if (!target.isDirectory() && !target.mkdirs() && !target.isDirectory()) return null;
        return target;
    }

    /** rom_id -> 文件名：去 "md5:" 前缀；path: 等含非法字符的净化为 '_'；统一加 ".gba"。 */
    private static String fileNameFor(String romId) {
        String id = romId.startsWith("md5:") ? romId.substring(4) : romId;
        StringBuilder sb = new StringBuilder(id.length() + 4);
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            boolean ok = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9') || c == '_' || c == '-' || c == '.';
            sb.append(ok ? c : '_');
        }
        return sb.toString() + ".gba";
    }

    private static void deleteQuiet(File f) {
        if (f == null) return;
        try { if (f.exists()) f.delete(); } catch (Exception ignored) { }
    }

    /** 普通流复制（minSdk 24 兼容）；失败返回 false，绝不抛。 */
    private static boolean copyFile(File src, File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst, false);
            byte[] buf = new byte[65536];
            int n;
            while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
            out.flush();
            return true;
        } catch (Exception ex) {
            return false; // 读失败 / 磁盘满 / 权限 → 降级
        } finally {
            if (out != null) try { out.close(); } catch (Exception ignored) { }
            if (in != null) try { in.close(); } catch (Exception ignored) { }
        }
    }

    /** 调用者持有 WRITE_LOCK。读清单并自愈：文件缺失/size 不符/坏条目当场删除并回写。 */
    private static List<Entry> loadLocked(Context ctx) {
        List<Entry> out = new ArrayList<>();
        String raw = prefs(ctx).getString(PREF_INDEX, null);
        if (raw == null || raw.isEmpty()) return out;
        JSONObject entries;
        try {
            JSONObject doc = new JSONObject(raw);
            entries = doc.optJSONObject("entries");
        } catch (Exception ex) {
            prefs(ctx).edit().remove(PREF_INDEX).apply(); // JSON 损坏 → 清空，不崩
            return out;
        }
        if (entries == null) return out;
        boolean dirty = false;
        Iterator<String> keys = entries.keys();
        while (keys.hasNext()) {
            String id = keys.next();
            try {
                JSONObject o = entries.optJSONObject(id);
                if (o == null) { dirty = true; continue; }
                String path = o.optString("path", null);
                long size = o.optLong("size", -1L);
                long at = o.optLong("last_access_ms", 0L);
                if (path == null || path.isEmpty() || size < 0) { dirty = true; continue; }
                File f = new File(path);
                if (!f.isFile() || f.length() != size) { dirty = true; continue; } // 自愈：条目失效
                Entry e = new Entry();
                e.romId = id;
                e.path = path;
                e.size = size;
                e.lastAccessMs = at;
                out.add(e);
            } catch (Exception ex) {
                dirty = true;
            }
        }
        if (dirty) saveLocked(ctx, out);
        return out;
    }

    /** 调用者持有 WRITE_LOCK。整表写回。 */
    private static void saveLocked(Context ctx, List<Entry> entries) {
        try {
            JSONObject doc = new JSONObject();
            doc.put("schema", SCHEMA);
            JSONObject obj = new JSONObject();
            for (Entry e : entries) {
                JSONObject one = new JSONObject();
                one.put("path", e.path);
                one.put("size", e.size);
                one.put("last_access_ms", e.lastAccessMs);
                obj.put(e.romId, one);
            }
            doc.put("entries", obj);
            prefs(ctx).edit().putString(PREF_INDEX, doc.toString()).apply();
        } catch (Exception ignored) { }
    }

    /** 调用者持有 WRITE_LOCK：写入/覆盖一条。 */
    private static void putEntryLocked(Context ctx, String romId, String path, long size, long at) {
        List<Entry> es = loadLocked(ctx);
        Entry target = null;
        for (Entry e : es) if (romId.equals(e.romId)) { target = e; break; }
        if (target == null) { target = new Entry(); target.romId = romId; es.add(target); }
        target.path = path;
        target.size = size;
        target.lastAccessMs = at;
        saveLocked(ctx, es);
    }

    private static Object lockFor(String romId) {
        Object cur = COPY_LOCKS.get(romId);
        if (cur != null) return cur;
        Object created = new Object();
        Object prev = COPY_LOCKS.putIfAbsent(romId, created);
        return prev == null ? created : prev;
    }

    /** 返回可用缓存绝对路径；文件缺失/size 不符/清单无此条 → null（并自愈删坏条目）。 */
    public static String getCachedPath(Context ctx, String romId) {
        if (ctx == null || romId == null) return null;
        synchronized (WRITE_LOCK) {
            List<Entry> es = loadLocked(ctx); // 内含自愈
            for (Entry e : es) if (romId.equals(e.romId)) return e.path;
            return null;
        }
    }

    /** 更新 last_access_ms（LRU 置顶）；条目不存在则 no-op。 */
    public static void touch(Context ctx, String romId) {
        if (ctx == null || romId == null) return;
        synchronized (WRITE_LOCK) {
            List<Entry> es = loadLocked(ctx);
            for (Entry e : es) {
                if (romId.equals(e.romId)) {
                    e.lastAccessMs = System.currentTimeMillis();
                    saveLocked(ctx, es);
                    return;
                }
            }
        }
    }

    /** 当前缓存实际占用字节（按仍存在的文件长度累加；坏条目已被 loadLocked 自愈剔除）。 */
    public static long cachedSize(Context ctx) {
        if (ctx == null) return 0L;
        synchronized (WRITE_LOCK) {
            long total = 0L;
            for (Entry e : loadLocked(ctx)) {
                File f = new File(e.path);
                if (f.isFile()) total += f.length();
            }
            return total;
        }
    }

    /** 当前缓存条目数。 */
    public static int cachedCount(Context ctx) {
        if (ctx == null) return 0;
        synchronized (WRITE_LOCK) {
            return loadLocked(ctx).size();
        }
    }

    /** 判断某路径是否落在本缓存目录内（从缓存打开时用于跳过 record 写 paths）。 */
    public static boolean isCachePath(Context ctx, String path) {
        if (ctx == null || path == null) return false;
        File dir = cacheDir(ctx);
        if (dir == null) return false;
        String prefix = dir.getAbsolutePath();
        return path.startsWith(prefix + File.separator);
    }

    /** 清空全部缓存：删除 rom_cache 目录下所有文件 + 清清单。 */
    public static void clearAll(Context ctx) {
        if (ctx == null) return;
        synchronized (WRITE_LOCK) {
            File dir = cacheDir(ctx);
            if (dir != null && dir.isDirectory()) {
                File[] files = dir.listFiles();
                // 防御：只删缓存 ROM 副本（.gba/.part），绝不删可能存在的 .sav/.ssN 存档。
                if (files != null) for (File f : files) {
                    if (!f.isFile()) continue;
                    String n = f.getName();
                    if (n.endsWith(".gba") || n.endsWith(".part")) deleteQuiet(f);
                }
            }
            prefs(ctx).edit().remove(PREF_INDEX).apply();
        }
    }

    /** 无参版：不保护任何 rom_id（仅供外部显式调用）；ensureCached 走带参版保护当前 ROM。 */
    public static void pruneIfNeeded(Context ctx) {
        pruneIfNeeded(ctx, null);
    }

    /**
     * LRU 清理：总量 >500MB 或条数 >20 → 按 last_access_ms 升序删最旧，
     * 对越线维度收敛到 80% 水位（400MB/16 条）；protectedRomId 指定的条目永不删除。
     */
    public static void pruneIfNeeded(Context ctx, String protectedRomId) {
        if (ctx == null) return;
        synchronized (WRITE_LOCK) {
            List<Entry> es = loadLocked(ctx);
            if (es.isEmpty()) return;
            long total = 0L;
            for (Entry e : es) total += e.size;
            int count = es.size();
            // 记录"最初是否越线"，清理持续到降到 80% 水位（防抖动），而不是刚低于上限就停。
            final boolean sizeOver = total > MAX_BYTES;
            final boolean countOver = count > MAX_ENTRIES;
            if (!sizeOver && !countOver) return; // 未越线

            Collections.sort(es, BY_ACCESS_ASC);
            List<Entry> keep = new ArrayList<>();
            for (Entry e : es) {
                boolean need = (sizeOver && total > WATERMARK_BYTES)
                        || (countOver && count > WATERMARK_ENTRIES);
                if (!need) { keep.add(e); continue; }
                if (protectedRomId != null && protectedRomId.equals(e.romId)) {
                    keep.add(e); continue; // 保护当前加载 ROM
                }
                deleteQuiet(new File(e.path));
                total -= e.size;
                count--;
            }
            saveLocked(ctx, keep);
        }
    }

    /**
     * 确保 rom_id 有本地副本：命中（文件存在+size 相符）→ touch 返回；
     * 否则从 sourcePath 复制（含原子改名）→ 写清单 → 清理（保护当前 rom_id）。
     * 含文件 I/O，调用方须放后台线程；任何失败返回 null 降级。
     */
    public static String ensureCached(Context ctx, String romId, String sourcePath) {
        if (ctx == null || romId == null || romId.isEmpty() || sourcePath == null) return null;

        // 1) 命中：已缓存且文件存在且 size 相符（getCachedPath 内含自愈）→ touch 后返回
        String hit = getCachedPath(ctx, romId);
        if (hit != null) { touch(ctx, romId); return hit; }

        File src = new File(sourcePath);
        if (!src.isFile() || !src.canRead()) return null;
        final long srcSize = src.length();
        if (srcSize <= 0) return null; // 空/非法文件不缓存

        Object copyLock = lockFor(romId);
        synchronized (copyLock) {
            // 双重检查：等锁期间可能已被别的线程缓存
            hit = getCachedPath(ctx, romId);
            if (hit != null) { touch(ctx, romId); return hit; }

            File dir = cacheDir(ctx);
            if (dir == null) return null;
            String name = fileNameFor(romId);
            File tmp = new File(dir, name + ".part");
            File dest = new File(dir, name);

            if (!copyFile(src, tmp) || tmp.length() != srcSize) {
                deleteQuiet(tmp);
                return null; // 复制失败/磁盘满/尺寸不符 → 不写清单，降级
            }
            // 原子改名；目标已存在导致 rename 失败时，先删目标再重试
            if (tmp.exists() && !tmp.renameTo(dest)) {
                deleteQuiet(dest);
                if (!tmp.renameTo(dest)) { deleteQuiet(tmp); return null; }
            }
            final String destPath = dest.getAbsolutePath();
            synchronized (WRITE_LOCK) {
                putEntryLocked(ctx, romId, destPath, srcSize, System.currentTimeMillis());
            }
            pruneIfNeeded(ctx, romId); // 清理时保护当前 ROM
            return destPath;
        }
    }
}
