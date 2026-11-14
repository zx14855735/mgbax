package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.tf;
import com.bytedance.pangle.u.hf;
import com.bytedance.pangle.util.d;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.xj.xj;
import com.bytedance.pangle.y.c;
import com.bytedance.pangle.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static final tf xj = tf.xj();

    static {
        BqCTfrr();
    }

    private static /* synthetic */ void BqCTfrr() {
        char[] charArray = "ÏÃÁ\u0082ËÍÁÉ\u0082ÎÃÕ\u0082ßÄÉÀÀ\u0082æÂÅîÞÅÈËÉ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 172);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÏÀÅÂÅØ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 172);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> c(File file, String str, int i, StringBuffer stringBuffer) {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.kd<Boolean, Map<String, List<ZipEntry>>> xj2 = com.bytedance.pangle.kd.hf.xj(file);
                boolean booleanValue = xj2.xj.booleanValue();
                Map<String, List<ZipEntry>> map = xj2.hf;
                if (booleanValue) {
                    return map;
                }
                throw new xj(str2);
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.x, str, i, -1L, null);
                xj.xj(1100, -5, str, i, e);
                throw new xj(str2, e);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String hf = com.bytedance.pangle.kd.w.hf(str, i);
        try {
            try {
                f.xj(file.getAbsolutePath(), hf);
                return hf;
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.ra, str, i, -1L, null);
                xj.xj(1100, -6, str, i, e);
                throw new xj("安装包拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), f.a.c);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), f.a.c);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new xj("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                    }
                }
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.ht, str, i, -1L, null);
                xj.xj(1100, -4, str, i, e);
                throw new xj("安装包权限校验失败", e);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tf(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (d.w()) {
                    c.xj(file, str, i);
                    com.bytedance.pangle.y.hf.xj(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                    y.xj();
                } else if (d.f()) {
                    String w = com.bytedance.pangle.kd.w.w(str, i);
                    String hf = com.bytedance.pangle.kd.w.hf(str, i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(w);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(com.bytedance.pangle.y.hf.xj(hf));
                    String sb2 = sb.toString();
                    if (com.bytedance.pangle.y.hf.xj(hf, w + str2 + com.bytedance.pangle.y.hf.xj(hf)) && com.bytedance.pangle.y.hf.xj(sb2)) {
                        stringBuffer.append("dexOpt1 cost:");
                        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                        stringBuffer.append(";");
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(";");
                return false;
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.f10174io, str, i, -1L, null);
                throw new xj("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (com.bytedance.pangle.f.kd.xj(file.getAbsolutePath(), str, sb)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
                }
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.pz, str, i, -1L, Log.getStackTraceString(e));
                xj.xj(1100, -3, str, i, e);
                throw new xj(e.getMessage(), e);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static class xj extends IOException {
        private xj(String str) {
            super(str);
        }

        private xj(String str, Throwable th) {
            super(str, th);
        }
    }

    private static void hf(String str, int i) {
        int hf = g.xj().hf(str, i, "install");
        int hf2 = g.xj().hf(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (hf > 3 || hf2 > 3) {
            removeApkEntryFlag = 0;
        }
        g.xj().xj(str, i, removeApkEntryFlag);
        g.xj().u(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str, int i) {
        try {
            if (!d.c() && !d.d()) {
                return;
            }
            g.xj().w(str, i, false);
            com.bytedance.pangle.y.hf.xj(Zeus.getAppApplication()).edit().putInt(str, i).apply();
            y.xj();
        } catch (Exception e) {
            xj(com.bytedance.pangle.u.hf.kd, hf.xj.f10174io, str, i, -1L, null);
            throw new xj("dexOpt2失败", e);
        }
    }

    public static boolean xj(final File file, final String str, final int i) {
        int i2;
        tf tfVar;
        com.bytedance.pangle.log.xj xj2;
        xj.InterfaceC0097xj interfaceC0097xj;
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            tfVar = xj;
            tfVar.xj(1000, 0, str, i, null);
            xj2 = com.bytedance.pangle.log.xj.xj(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            xj(com.bytedance.pangle.u.hf.u, hf.xj.yo, str, i, -1L, null);
            hf(str, i);
            com.bytedance.pangle.util.c.xj(com.bytedance.pangle.kd.w.xj(str, i));
            interfaceC0097xj = new xj.InterfaceC0097xj() { // from class: com.bytedance.pangle.plugin.w.1
                @Override // com.bytedance.pangle.xj.xj.InterfaceC0097xj
                public void xj() {
                    w.y(file, str, i, stringBuffer);
                }
            };
        } catch (Throwable th) {
            th = th;
        }
        try {
            xj.InterfaceC0097xj interfaceC0097xj2 = new xj.InterfaceC0097xj() { // from class: com.bytedance.pangle.plugin.w.2
                @Override // com.bytedance.pangle.xj.xj.InterfaceC0097xj
                public void xj() {
                    final Map c = w.c(file, str, i, stringBuffer);
                    w.f(file, str, i, stringBuffer);
                    w.hf(w.d(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (d.f() || d.w()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.xj.xj.xj(false, new xj.InterfaceC0097xj() { // from class: com.bytedance.pangle.plugin.w.2.1
                            @Override // com.bytedance.pangle.xj.xj.InterfaceC0097xj
                            public void xj() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                w.hf(str, i, (Map<String, List<ZipEntry>>) c, stringBuffer);
                            }
                        }, new xj.InterfaceC0097xj() { // from class: com.bytedance.pangle.plugin.w.2.2
                            @Override // com.bytedance.pangle.xj.xj.InterfaceC0097xj
                            public void xj() {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = w.tf(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = w.hf(str, i, zArr2[0], stringBuffer);
                    } else {
                        w.hf(str, i, (Map<String, List<ZipEntry>>) c, stringBuffer);
                        zArr[0] = w.hf(str, i, false, stringBuffer);
                        w.w(str, i);
                    }
                }
            };
            stringBuffer = stringBuffer;
            zArr = zArr;
            com.bytedance.pangle.xj.xj.xj(false, interfaceC0097xj, interfaceC0097xj2);
            com.bytedance.pangle.util.c.xj(file);
            xj(com.bytedance.pangle.u.hf.kd, hf.xj.v, str, i, xj2.xj(), stringBuffer.toString());
            xj2.xj(cb.o);
            tfVar.xj(1100, 0, str, i, null);
            return true;
        } catch (Throwable th2) {
            th = th2;
            stringBuffer = stringBuffer;
            zArr = zArr;
            Throwable th3 = th;
            if (th3 instanceof xj) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th3);
                i2 = i;
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th3);
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.jk, str, i, -1L, stringBuffer.toString());
                xj.xj(1100, -1, str, i, th3);
                i2 = i;
            }
            if (zArr[0]) {
                g.xj().xj(str, i2, "install");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(String str, int i, boolean z, StringBuffer stringBuffer) {
        int d = g.xj().d(str, i);
        boolean z2 = (d & 1) != 0;
        boolean z3 = (d & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String hf = com.bytedance.pangle.kd.w.hf(str, i);
        long currentTimeMillis = System.currentTimeMillis();
        boolean xj2 = com.bytedance.pangle.util.hf.hf.xj(hf, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return xj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(String str, String str2, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int xj2 = new com.bytedance.pangle.res.xj.w().xj(new File(str), false, sb);
        stringBuffer.append(xj2 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (xj2 == 100 || xj2 == 200) {
            return;
        }
        String sb2 = sb.toString();
        xj(com.bytedance.pangle.u.hf.kd, hf.xj.ai, str2, i, -1L, sb2);
        xj.xj(1100, -2, str2, i, null);
        throw new xj("modifyRes failed. result = " + xj2 + ", errorLog = " + sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.kd.hf.xj(new File(com.bytedance.pangle.kd.w.hf(str, i)), new File(com.bytedance.pangle.kd.w.u(str, i)), str, map);
            } catch (Exception e) {
                xj(com.bytedance.pangle.u.hf.kd, hf.xj.dk, str, i, -1L, com.bytedance.pangle.log.hf.xj((Object) e));
                xj.xj(1100, -7, str, i, e);
                throw new xj("安装包动态库拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    public static void xj(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.hf.xj(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.hf.xj(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.bytedance.pangle.log.hf.hf(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.hf.xj(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.y.xj(e);
        }
        com.bytedance.pangle.u.hf.xj().xj(str, jSONObject, jSONObject3, jSONObject2);
    }
}
