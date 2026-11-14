package com.bytedance.pangle.w;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.kd.w;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.u;
import com.bytedance.pangle.tf;
import com.bytedance.pangle.u.hf;
import com.bytedance.pangle.util.c;
import com.bytedance.pangle.util.d;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import com.bytedance.sdk.openadsdk.api.y;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static String hf(String str) {
        return (str == null || !str.endsWith(":")) ? str : CtFAbx.AMqCpz(1, 0, str);
    }

    public static int xj(String str) {
        String xj;
        File[] p;
        int i = -1;
        if (TextUtils.isEmpty(str) || (xj = w.xj(str)) == null) {
            return -1;
        }
        File[] listFiles = new File(xj).listFiles(new FileFilter() { // from class: com.bytedance.pangle.w.hf.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i && g.xj().u(str, parseInt) && (p = w.p(str, parseInt)) != null && p.length > 0) {
                    i = parseInt;
                }
            }
        }
        return i;
    }

    public static void xj(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String xj = w.xj(str);
        if (TextUtils.isEmpty(xj)) {
            return;
        }
        final String concat = "version-".concat(String.valueOf(i));
        new File(xj).listFiles(new FileFilter() { // from class: com.bytedance.pangle.w.hf.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !concat.equals(file.getName())) {
                    c.xj(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        g.xj().hf(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
    
        if (r5 == 0) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.pangle.w.xj xj(java.io.File r7, java.util.List<java.io.File> r8) {
        /*
            java.lang.String r0 = "Zeus/install_pangle"
            r1 = 0
            if (r7 == 0) goto La8
            if (r8 == 0) goto La8
            int r2 = r8.size()
            if (r2 <= 0) goto La8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r2.<init>()     // Catch: java.lang.Throwable -> L79
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L75
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L75
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L72
        L21:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L2d
            r2.append(r6)     // Catch: java.lang.Throwable -> L2b
            goto L21
        L2b:
            r7 = move-exception
            goto L7d
        L2d:
            com.bytedance.pangle.tf r6 = com.bytedance.pangle.tf.xj()     // Catch: java.lang.Throwable -> L2b
            com.bytedance.pangle.ZeusPluginDecodeCallback r6 = r6.u()     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L63
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = r6.decode(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2b
            if (r6 != 0) goto L5d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2b
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "DexPluginUtils parse dex config json success"
            com.bytedance.pangle.log.ZeusLogger.i(r0, r2)     // Catch: java.lang.Throwable -> L2b
            com.bytedance.pangle.w.xj r7 = com.bytedance.pangle.w.xj.xj(r6, r7, r8)     // Catch: java.lang.Throwable -> L2b
            r3.close()
            r4.close()
            r5.close()
            return r7
        L5d:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode content is empty"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L2b
            goto L68
        L63:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode callback is null"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L2b
        L68:
            r3.close()
            r4.close()
        L6e:
            r5.close()
            goto La8
        L72:
            r7 = move-exception
            r5 = r1
            goto L7d
        L75:
            r7 = move-exception
            r4 = r1
        L77:
            r5 = r4
            goto L7d
        L79:
            r7 = move-exception
            r3 = r1
            r4 = r3
            goto L77
        L7d:
            java.lang.String r8 = "DexPluginUtils parse dex config fail throw error "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = r8.concat(r7)     // Catch: java.lang.Throwable -> L97
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L97
            if (r3 == 0) goto L8f
            r3.close()
        L8f:
            if (r4 == 0) goto L94
            r4.close()
        L94:
            if (r5 == 0) goto La8
            goto L6e
        L97:
            r7 = move-exception
            if (r3 == 0) goto L9d
            r3.close()
        L9d:
            if (r4 == 0) goto La2
            r4.close()
        La2:
            if (r5 == 0) goto La7
            r5.close()
        La7:
            throw r7
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.w.hf.xj(java.io.File, java.util.List):com.bytedance.pangle.w.xj");
    }

    public static boolean xj(xj xjVar, long j) {
        List<File> list;
        File file;
        if (xjVar != null) {
            list = xjVar.u();
            file = xjVar.kd();
        } else {
            list = null;
            file = null;
        }
        if (file == null || list == null || list.size() <= 0) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        } else {
            int w = xjVar.w();
            String hf = xjVar.hf();
            ZeusPluginStateListener.postStateChange(hf, 11, new Object[0]);
            com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.u, hf.xj.yo, hf, w, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + hf + " version is " + w);
            String p = g.xj().p(hf);
            if (!TextUtils.isEmpty(p) && xj(p) >= w) {
                com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.kd, hf.xj.jk, hf, w, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String c = TextUtils.isEmpty(xjVar.c()) ? hf : xjVar.c();
            if (!w.tf(c, w)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + hf + " version=" + w);
                    for (File file2 : list) {
                        if (file2.getName().endsWith(".dex")) {
                            String xj = w.xj(c, w, file2.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file2.getName());
                            f.xj(file2.getAbsolutePath(), xj);
                        }
                    }
                    if (file.getName().endsWith(".json")) {
                        String pl2 = w.pl(c, w);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + file.getName());
                        f.xj(file.getAbsolutePath(), pl2);
                    }
                    if (w.tf(c, w)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + hf + " version = " + w);
                        ZeusPluginStateListener.postStateChange(hf, 12, new Object[0]);
                        com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.kd, hf.xj.v, hf, w, SystemClock.elapsedRealtime() - j, "install success");
                        g.xj().hf(c, w, true);
                        if (!TextUtils.isEmpty(xjVar.c())) {
                            g.xj().w(hf, c);
                            g.xj().u(hf, p);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.kd, hf.xj.jk, hf, w, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.kd, hf.xj.jk, hf, w, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    y.xj(e);
                }
            } else {
                com.bytedance.pangle.plugin.w.xj(com.bytedance.pangle.u.hf.kd, hf.xj.v, hf, w, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + hf + " version = " + w);
                return true;
            }
        }
        return false;
    }

    public static boolean xj(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.xj)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String p = g.xj().p(plugin.mPkgName);
            if (TextUtils.isEmpty(p)) {
                p = plugin.mPkgName;
            }
            int xj = xj(p);
            if (xj == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] p2 = w.p(p, xj);
            if (p2 != null && p2.length != 0) {
                String pl2 = w.pl(p, xj);
                if (TextUtils.isEmpty(pl2)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(pl2);
                if (file.exists() && file.isFile()) {
                    xj xj2 = xj(file, (List<File>) Arrays.asList(p2));
                    ((com.bytedance.pangle.plugin.xj) plugin).xj(xj2);
                    if (xj2 == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!xj2.xj()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : p2) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String hf = hf(sb2.toString());
                    if (TextUtils.isEmpty(hf)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> kd = tf.xj().kd();
                    if (kd != null && kd.size() != 0) {
                        JSONObject jSONObject = kd.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String optString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(optString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(optString);
                            if (plugin2 != null) {
                                if (d.p()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(hf)));
                                    return u.xj(plugin2.mClassLoader, hf);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(hf, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=");
                                    sb.append(hf);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=");
                            sb.append(optString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ");
            sb.append(th);
            return false;
        }
    }
}
