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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 需求③阶段A —— Android 端 mGBAx-library.json 生成 / 导入 / 纯函数合并。
 * 唯一权威契约：.zcode-tmp/C1_CONTRACT.md（§1.1~§1.9）。
 *
 * 设计边界：
 *  - 单文件 manifest；settings 作为内嵌对象，不是独立文件；
 *  - 敏感键「白名单准入」为主、deny-list 为 belt-and-braces（§1.4/§1.5）；
 *  - 文件级 LWW（唯一裁决=mtime，timestamp 仅审计）与首启 mtime=1 由 WebDavSync
 *    负责；本类只提供签名/策略钩子，不设置镜像 mtime；
 *  - mergeLibraryJson 为纯函数（无 Context、无文件 I/O），供 JUnit/纯 JVM selftest。
 *
 * 诚实：iOS / 真实云 UNOBS，未实测，不预设成功；本类不触碰联机判据。
 */
public final class ManifestSync {
    private ManifestSync() { }

    // ── 具名常量（C1_CONTRACT §1.1/§1.2/§1.3；三端同名同值，禁裸字符串/裸 hex）──
    public static final String LIBRARY_MANIFEST = "mGBAx-library.json";
    static final String LEGACY_RECENT_MANIFEST = "recent_roms.json";
    public static final int LIBRARY_SCHEMA = 1;
    public static final int LIBRARY_VERSION = 1;
    public static final int RECENT_SCHEMA = 1;
    public static final int RECENT_CAPACITY = 20;

    public static final String PREF_LIB_LAST_RECENT = "lib.last_recent";
    public static final String PREF_LIB_LAST_SETTINGS = "lib.last_settings";
    /** mirrorMtimeFor 返回此值 = 本次不重写镜像（防 ping-pong，§1.8 C）。 */
    public static final long MTIME_NO_WRITE = -1L;
    private static final String SIG_SEP = "#ManifestSync#";

    private static final String K_SCHEMA = "schema";
    private static final String K_VERSION = "version";
    private static final String K_DEVICE_ID = "device_id";
    private static final String K_TIMESTAMP = "timestamp";
    private static final String K_RECENT = "recent_roms";
    private static final String K_SETTINGS = "settings";
    private static final String K_UPDATED_AT = "updated_at";
    private static final String K_ITEMS = "items";
    private static final String K_ROM_ID = "rom_id";
    private static final String K_ID_ALGO = "id_algo";
    private static final String K_TENTATIVE = "tentative";
    private static final String K_PATHS = "paths";
    private static final String K_LAST_OPENED = "last_opened_ms";
    private static final String K_SYNC = "sync";
    private static final String K_SYNC_ORIGIN = "origin_device";
    private static final String K_SYNC_UPDATED = "updated_at";
    private static final String K_SYNC_REV = "rev";
    private static final String V_ID_MD5 = "md5";

    // ── 28 键精确白名单（C1_CONTRACT §1.4 表）──
    private enum Type { INT, BOOL, STR }

    private static final class WKey {
        final String canonical;
        final String pref;
        final Type type;
        WKey(String canonical, String pref, Type type) {
            this.canonical = canonical;
            this.pref = pref;
            this.type = type;
        }
    }

    private static final WKey[] SETTINGS_WHITELIST = {
            new WKey("vf.filter",       "vf_filter",       Type.INT),
            new WKey("vf.blend",        "vf_blend",        Type.BOOL),
            new WKey("vf.linear",       "vf_linear",       Type.BOOL),
            new WKey("vf.aspect",       "vf_aspect",       Type.BOOL),
            new WKey("vf.integer",      "vf_integer",      Type.BOOL),
            new WKey("vf.scan",         "vf_scan",         Type.BOOL),
            new WKey("vf.bright",       "vf_bright",       Type.INT),
            new WKey("vf.contrast",     "vf_contrast",     Type.INT),
            new WKey("vf.skip",         "vf_skip",         Type.INT),
            new WKey("vf.skipAuto",     "vf_skip_auto",    Type.BOOL),
            new WKey("speed.hold",      "fast_hold",       Type.INT),
            new WKey("speed.turboMode", "turbo_mode",      Type.INT),
            new WKey("speed.turboRate", "turbo_rate",      Type.INT),
            new WKey("save.type",       "save_type",       Type.INT),
            new WKey("save.autoLoad",   "auto_load_state", Type.BOOL),
            new WKey("save.autoSave",   "auto_save_state", Type.BOOL),
            new WKey("save.patches",    "patches",         Type.BOOL),
            new WKey("save.timedMin",   "timed_save_min",  Type.INT),
            new WKey("save.quickRotate","quick_rotate",    Type.BOOL),
            new WKey("emu.useBios",     "use_bios",        Type.BOOL),
            new WKey("emu.skipBios",    "skip_bios",       Type.BOOL),
            new WKey("emu.cartRumble",  "cart_rumble",     Type.BOOL),
            new WKey("emu.solarOn",     "solar_on",        Type.BOOL),
            new WKey("emu.solarLevel",  "solar_level",     Type.INT),
            new WKey("emu.sgbBorders",  "sgb_borders",     Type.BOOL),
            new WKey("emu.gbPalette",   "gb_palette",      Type.INT),
            new WKey("shot.format",     "shot_format",     Type.STR),
            new WKey("ai.lang",         "ai_lang",         Type.STR)
    };

    // ── deny-list（C1_CONTRACT §1.5；硬红线，机制仍是白名单准入）──
    private static final String[] DENY_EXACT = {
            "sync_url", "sync_dir", "sync_user", "sync_pass", "sync_enable", "sync_auto",
            "device_id", "mgbax_device_id", "ai_key",
            "lastrom", "lastrombookmark", "rom_dirs", "rom_favs", "full_skin",
            "camera_image", "ext_shader", "savegamepath", "lastdirectory"
    };
    private static final String[] DENY_PREFIX = {
            "cloud_", "lobby_", "gboy_", "bus_", "link_",
            "mgbax.link.", "debug.mgbax.link.", "mgbax_", "lib."
    };
    private static final String[] DENY_CONTAINS = { "room", "pass", "key", "token" };

    /** 键是否命中敏感红线（大小写不敏感）。供 selftest 直接断言。 */
    public static boolean isDeniedKey(String key) {
        if (key == null) return true;
        String k = key.toLowerCase(Locale.US);
        for (int i = 0; i < DENY_EXACT.length; i++) if (k.equals(DENY_EXACT[i])) return true;
        for (int i = 0; i < DENY_PREFIX.length; i++) if (k.startsWith(DENY_PREFIX[i])) return true;
        for (int i = 0; i < DENY_CONTAINS.length; i++) if (k.contains(DENY_CONTAINS[i])) return true;
        return false;
    }

    /** 白名单准入 + deny-list 二次确认（canonical 与 Android pref 键同时过检）。 */
    private static boolean isAdmitted(String canonical, String pref) {
        for (int i = 0; i < SETTINGS_WHITELIST.length; i++) {
            WKey w = SETTINGS_WHITELIST[i];
            if (w.canonical.equals(canonical) && w.pref.equals(pref)) {
                return !isDeniedKey(canonical) && !isDeniedKey(pref);
            }
        }
        return false;
    }

    /** settings 白名单键数（供 selftest 断言 == 28）。 */
    public static int whitelistSize() { return SETTINGS_WHITELIST.length; }

    // ── 基础设施 ──────────────────────────────────────────────
    private static SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext()
                .getSharedPreferences(RecentRoms.PREFS_NAME, Context.MODE_PRIVATE);
    }

    /** 设备 ID（and- + UUID，§1.7；只走顶层，不进 settings）。 */
    public static String deviceId(Context ctx) { return RecentRoms.deviceId(ctx); }

    private static boolean writeTextAtomic(File dest, String text) {
        if (dest == null || dest.getParentFile() == null) return false;
        File tmp = new File(dest.getParentFile(), dest.getName() + ".lib-tmp");
        OutputStream out = null;
        try {
            out = new FileOutputStream(tmp);
            out.write(text.getBytes("UTF-8"));
            out.close();
            out = null;
        } catch (Exception e) {
            if (out != null) try { out.close(); } catch (Exception ignored) { }
            return false;
        }
        if (dest.exists() && !dest.delete()) return false;
        return tmp.renameTo(dest);
    }

    private static String readText(File f) {
        if (f == null || !f.isFile()) return null;
        InputStream in = null;
        try {
            in = new FileInputStream(f);
            java.io.ByteArrayOutputStream sink = new java.io.ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) sink.write(buf, 0, n);
            in.close();
            in = null;
            return sink.toString("UTF-8");
        } catch (Exception e) {
            if (in != null) try { in.close(); } catch (Exception ignored) { }
            return null;
        }
    }

    // ── ① 导出：prefs → manifest JSON ───────────────────────────
    private static JSONObject buildSettings(SharedPreferences p) {
        JSONObject out = new JSONObject();
        Map<String, ?> all = p.getAll();
        for (int i = 0; i < SETTINGS_WHITELIST.length; i++) {
            WKey w = SETTINGS_WHITELIST[i];
            if (!all.containsKey(w.pref)) continue; // 不存在则跳过，不制造默认值
            Object v = all.get(w.pref);
            if (v == null || !isAdmitted(w.canonical, w.pref)) continue;
            try {
                if (w.type == Type.INT) {
                    if (v instanceof Integer) out.put(w.canonical, v);
                    else if (v instanceof Long) out.put(w.canonical, ((Long) v).intValue());
                } else if (w.type == Type.BOOL) {
                    if (v instanceof Boolean) out.put(w.canonical, v);
                } else {
                    if (v instanceof String) out.put(w.canonical, v);
                }
            } catch (Exception ignored) { }
        }
        return out;
    }

    private static JSONObject buildRecent(Context ctx, SharedPreferences p) {
        JSONObject env = new JSONObject();
        try {
            env.put(K_SCHEMA, RECENT_SCHEMA);
            env.put(K_DEVICE_ID, deviceId(ctx));
            long updated = 0L;
            String raw = p.getString(RecentRoms.PREF_RECENT, null);
            if (raw != null && !raw.isEmpty()) {
                try {
                    JSONObject old = new JSONObject(raw);
                    if (old.optInt(K_SCHEMA, -1) == RECENT_SCHEMA) updated = old.optLong(K_UPDATED_AT, 0L);
                } catch (Exception ignored) { }
            }
            List<RecentRoms.Entry> list = RecentRoms.list(ctx);
            JSONArray arr = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                RecentRoms.Entry e = list.get(i);
                if (e == null) continue;
                arr.put(e.toJson());
                long t = e.syncUpdatedAt > 0 ? e.syncUpdatedAt : e.lastOpenedMs;
                if (t > updated) updated = t;
            }
            env.put(K_UPDATED_AT, updated);
            env.put(K_ITEMS, arr);
        } catch (Exception ignored) { }
        return env;
    }

    /** 纯组装（无文件 I/O）：返回顶层封套 JSON 字符串。 */
    public static String buildManifestJson(Context ctx) {
        SharedPreferences p = prefs(ctx);
        JSONObject doc = new JSONObject();
        try {
            doc.put(K_SCHEMA, LIBRARY_SCHEMA);
            doc.put(K_VERSION, LIBRARY_VERSION);
            doc.put(K_DEVICE_ID, deviceId(ctx));
            doc.put(K_TIMESTAMP, System.currentTimeMillis()); // 仅审计，不裁决
            doc.put(K_RECENT, buildRecent(ctx, p));
            doc.put(K_SETTINGS, buildSettings(p));
        } catch (Exception ignored) { }
        return doc.toString();
    }

    public static boolean exportManifest(Context ctx) {
        File dir = WebDavSync.savesDir(ctx);
        if (dir == null) return false;
        File dest = new File(dir, LIBRARY_MANIFEST);
        return writeTextAtomic(dest, buildManifestJson(ctx));
    }

    public static boolean exportManifestTo(Context ctx, File mirror) {
        return mirror != null && writeTextAtomic(mirror, buildManifestJson(ctx));
    }

    // ── ② 签名 / 首启 mtime 钩子 ───────────────────────────────
    public static String recentSignature(Context ctx) {
        String raw = prefs(ctx).getString(RecentRoms.PREF_RECENT, "");
        return raw == null ? "" : raw;
    }

    public static String settingsSignature(Context ctx) {
        StringBuilder b = new StringBuilder();
        Map<String, ?> all = prefs(ctx).getAll();
        for (int i = 0; i < SETTINGS_WHITELIST.length; i++) {
            WKey w = SETTINGS_WHITELIST[i];
            Object v = all.get(w.pref);
            if (v != null) b.append(w.canonical).append('=').append(v).append(';');
        }
        return b.toString();
    }

    public static String currentSignature(Context ctx) {
        return recentSignature(ctx) + SIG_SEP + settingsSignature(ctx);
    }

    private static boolean changed(String cur, String old) {
        return old == null ? (cur != null && cur.length() > 0) : !cur.equals(old);
    }

    public static boolean localChanged(Context ctx) {
        SharedPreferences p = prefs(ctx);
        return changed(recentSignature(ctx), p.getString(PREF_LIB_LAST_RECENT, null))
                || changed(settingsSignature(ctx), p.getString(PREF_LIB_LAST_SETTINGS, null));
    }

    public static void refreshSnapshot(Context ctx) {
        prefs(ctx).edit()
                .putString(PREF_LIB_LAST_RECENT, recentSignature(ctx))
                .putString(PREF_LIB_LAST_SETTINGS, settingsSignature(ctx))
                .apply();
    }

    /** 镜像 mtime 策略钩子：不存在→1L；本地变化→now；否则 MTIME_NO_WRITE。 */
    public static long mirrorMtimeFor(boolean mirrorExists, boolean localChanged) {
        if (!mirrorExists) return 1L;
        if (localChanged) return System.currentTimeMillis();
        return MTIME_NO_WRITE;
    }

    /** 合并写回文件白名单门。 */
    public static boolean isManifestName(String name) {
        if (name == null) return false;
        return LIBRARY_MANIFEST.equalsIgnoreCase(name)
                || LEGACY_RECENT_MANIFEST.equalsIgnoreCase(name);
    }

    // ── ③ 条目级 LWW（§1.8 D）──────────────────────────────────
    private static boolean proven(JSONObject e) {
        return e != null && V_ID_MD5.equals(e.optString(K_ID_ALGO, ""))
                && !e.optBoolean(K_TENTATIVE, false);
    }

    /** 单条目 LWW：updated_at → rev → origin_device 字典序；paths 并集；tentative 不覆盖 md5。 */
    private static JSONObject mergeEntry(JSONObject a, JSONObject b) {
        try {
            JSONObject sa = a.optJSONObject(K_SYNC), sb = b.optJSONObject(K_SYNC);
            long ta = sa == null ? 0L : sa.optLong(K_SYNC_UPDATED, 0L);
            long tb = sb == null ? 0L : sb.optLong(K_SYNC_UPDATED, 0L);
            int ra = sa == null ? 0 : sa.optInt(K_SYNC_REV, 0);
            int rb = sb == null ? 0 : sb.optInt(K_SYNC_REV, 0);
            String oa = sa == null ? "" : sa.optString(K_SYNC_ORIGIN, "");
            String ob = sb == null ? "" : sb.optString(K_SYNC_ORIGIN, "");
            boolean bWins = tb > ta
                    || (tb == ta && (rb > ra || (rb == ra && ob.compareTo(oa) > 0)));
            JSONObject win = bWins ? b : a;
            JSONObject lose = bWins ? a : b;
            JSONObject out = new JSONObject(win.toString());

            JSONObject pw = win.optJSONObject(K_PATHS), pl = lose.optJSONObject(K_PATHS);
            JSONObject paths = new JSONObject();
            if (pl != null) {
                Iterator<String> it = pl.keys();
                while (it.hasNext()) { String k = it.next(); paths.put(k, pl.opt(k)); }
            }
            if (pw != null) {
                Iterator<String> it = pw.keys();
                while (it.hasNext()) { String k = it.next(); paths.put(k, pw.opt(k)); }
            }
            out.put(K_PATHS, paths);

            if (!proven(win) && proven(lose)) {
                out.put(K_ROM_ID, lose.optString(K_ROM_ID));
                out.put(K_ID_ALGO, V_ID_MD5);
                out.put(K_TENTATIVE, false);
            }
            return out;
        } catch (Exception e) {
            return a;
        }
    }

    /** 纯函数合并（无文件 I/O、无 Context）：schema/version 守卫 + recent 条目 LWW + settings 整对象 LWW。 */
    public static String mergeLibraryJson(String localJson, String remoteJson) {
        JSONObject base, incoming;
        try { base = new JSONObject(localJson); } catch (Exception e) { return remoteJson; }
        try { incoming = new JSONObject(remoteJson); } catch (Exception e) { return localJson; }
        if (base.optInt(K_SCHEMA, -1) != LIBRARY_SCHEMA
                || incoming.optInt(K_SCHEMA, -1) != LIBRARY_SCHEMA
                || base.optInt(K_VERSION, -1) != LIBRARY_VERSION
                || incoming.optInt(K_VERSION, -1) != LIBRARY_VERSION) {
            return base.toString();
        }

        try {
        JSONObject br = base.optJSONObject(K_RECENT);
        JSONObject ir = incoming.optJSONObject(K_RECENT);
        if (br != null && ir != null) {
            LinkedHashMap<String, JSONObject> byId = new LinkedHashMap<String, JSONObject>();
            JSONArray ba = br.optJSONArray(K_ITEMS);
            if (ba != null) {
                for (int i = 0; i < ba.length(); i++) {
                    JSONObject o = ba.optJSONObject(i);
                    if (o == null) continue;
                    String id = o.optString(K_ROM_ID, null);
                    if (id != null && !id.isEmpty()) byId.put(id, o);
                }
            }
            JSONArray ia = ir.optJSONArray(K_ITEMS);
            if (ia != null) {
                for (int i = 0; i < ia.length(); i++) {
                    JSONObject o = ia.optJSONObject(i);
                    if (o == null) continue;
                    String id = o.optString(K_ROM_ID, null);
                    if (id == null || id.isEmpty()) continue;
                    JSONObject prev = byId.get(id);
                    byId.put(id, prev == null ? o : mergeEntry(prev, o));
                }
            }
            final List<JSONObject> ordered = new ArrayList<JSONObject>(byId.values());
            Collections.sort(ordered, new Comparator<JSONObject>() {
                @Override public int compare(JSONObject x, JSONObject y) {
                    return Long.compare(y.optLong(K_LAST_OPENED, 0L), x.optLong(K_LAST_OPENED, 0L));
                }
            });
            JSONArray out = new JSONArray();
            for (int i = 0; i < ordered.size() && i < RECENT_CAPACITY; i++) out.put(ordered.get(i));
            br.put(K_ITEMS, out);
            br.put(K_DEVICE_ID, incoming.optString(K_DEVICE_ID, br.optString(K_DEVICE_ID, "")));
            br.put(K_UPDATED_AT, Math.max(br.optLong(K_UPDATED_AT, 0L), ir.optLong(K_UPDATED_AT, 0L)));
        }

        JSONObject is = incoming.optJSONObject(K_SETTINGS);
        if (is != null) base.put(K_SETTINGS, is);
        base.put(K_DEVICE_ID, incoming.optString(K_DEVICE_ID, base.optString(K_DEVICE_ID, "")));
        base.put(K_TIMESTAMP, Math.max(base.optLong(K_TIMESTAMP, 0L), incoming.optLong(K_TIMESTAMP, 0L)));
        return base.toString();
        } catch (Exception e) { return base.toString(); }
    }

    // ── ⑤ 导入：远端 JSON → 合并 → 回写 prefs ─────────────────────
    public static final class ImportResult {
        public boolean accepted;
        public int recentItems;
        public int settingsKeys;
        public final List<String> errors = new ArrayList<String>();
    }

    public static ImportResult importManifest(Context ctx, String json) {
        ImportResult r = new ImportResult();
        if (json == null || json.isEmpty()) { r.errors.add("empty-json"); return r; }
        JSONObject doc;
        try { doc = new JSONObject(json); } catch (Exception e) { r.errors.add("bad-json"); return r; }
        if (doc.optInt(K_SCHEMA, -1) != LIBRARY_SCHEMA
                || doc.optInt(K_VERSION, -1) != LIBRARY_VERSION) {
            r.errors.add("schema-or-version-unknown");
            return r;
        }

        String merged;
        try { merged = mergeLibraryJson(buildManifestJson(ctx), doc.toString()); }
        catch (Exception e) { r.errors.add("merge-failed"); return r; }

        JSONObject mo;
        try { mo = new JSONObject(merged); } catch (Exception e) { r.errors.add("merged-json-bad"); return r; }

        JSONObject mr = mo.optJSONObject(K_RECENT);
        if (mr != null) {
            try {
                List<RecentRoms.Entry> items = new ArrayList<RecentRoms.Entry>();
                JSONArray arr = mr.optJSONArray(K_ITEMS);
                if (arr != null) {
                    for (int i = 0; i < arr.length(); i++) {
                        RecentRoms.Entry e = RecentRoms.Entry.fromJson(arr.optJSONObject(i));
                        if (e != null) items.add(e);
                    }
                }
                long mergedUpdatedAt = mr.optLong(K_UPDATED_AT, 0L);
                RecentRoms.writeAllWithUpdatedAt(ctx, items, mergedUpdatedAt);
                r.recentItems = items.size();
            } catch (Exception e) { r.errors.add("recent-apply-failed"); }
        }

        JSONObject ms = mo.optJSONObject(K_SETTINGS);
        if (ms != null) {
            SharedPreferences.Editor ed = prefs(ctx).edit();
            int n = 0;
            for (int i = 0; i < SETTINGS_WHITELIST.length; i++) {
                WKey w = SETTINGS_WHITELIST[i];
                if (!ms.has(w.canonical)) continue;
                if (!isAdmitted(w.canonical, w.pref)) { r.errors.add("deny:" + w.canonical); continue; }
                Object v = ms.opt(w.canonical);
                try {
                    if (w.type == Type.INT) {
                        if (v instanceof Number) { ed.putInt(w.pref, ((Number) v).intValue()); n++; }
                        else r.errors.add("type:" + w.canonical);
                    } else if (w.type == Type.BOOL) {
                        if (v instanceof Boolean) { ed.putBoolean(w.pref, (Boolean) v); n++; }
                        else r.errors.add("type:" + w.canonical);
                    } else {
                        if (v instanceof String) { ed.putString(w.pref, (String) v); n++; }
                        else r.errors.add("type:" + w.canonical);
                    }
                } catch (Exception e) { r.errors.add("put:" + w.canonical); }
            }
            ed.apply();
            r.settingsKeys = n;
        }
        r.accepted = r.errors.isEmpty();
        return r;
    }

    /** 工具：读取已落地的镜像 JSON。 */
    public static String readMirror(File mirror) { return readText(mirror); }
}
