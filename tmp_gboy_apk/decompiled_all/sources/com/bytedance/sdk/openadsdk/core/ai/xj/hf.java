package com.bytedance.sdk.openadsdk.core.ai.xj;

import ADYaiT.CtFAbx;
import IzHBwY.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.zg.kd;
import com.bytedance.sdk.openadsdk.zg.u;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static final HashMap<String, String> c;
    private static long d;
    private static long f;
    private static final String hf;
    private static final hf kd;
    private static final String w;
    private static final String xj;
    private FileOutputStream u;
    private Function<SparseArray<Object>, Object> y;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ai.xj.hf$hf, reason: collision with other inner class name */
    public static final class C0135hf extends Exception {
        private int xj;

        public C0135hf(int i, String str) {
            super(str);
            this.xj = i;
        }

        public int xj() {
            return this.xj;
        }
    }

    public static final class xj {
        public boolean c;
        public int d;
        public int f;
        public int hf;
        public String kd;
        public String p;
        public int tf;
        public String u;
        public String w;
        public String xj;
        public String y;

        private xj() {
        }

        public String toString() {
            try {
                return new JSONObject().put(n.p, this.xj).put("version_code", this.hf).put("sign", this.kd).put("max_version", this.d).put("min_version", this.f).put("is_revert", this.c).put(TKDownloadReason.KSAD_TK_MD5, this.y).put("plugin_file", this.p).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        public boolean xj() {
            return TextUtils.equals(this.xj, "com.byted.mixed");
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        xj = CtFAbx.B25kr6(sb, str, "next");
        hf = CtFAbx.AcNBzu(str, "tmp");
        w = CtFAbx.AcNBzu(str, "conf");
        kd = new hf();
        c = new HashMap<>();
        PFnvaCp();
    }

    private hf() {
    }

    private static /* synthetic */ void PFnvaCp() {
        char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '8');
        }
        String str = new String(charArray);
        char[] charArray2 = "[TQVQL".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '8');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static File kd(Context context) {
        return new File(w(context), xj);
    }

    private static File u(Context context) {
        return new File(w(context), hf);
    }

    private static File w(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context, "tt_pangle_bykv_file", 0);
    }

    private static File y(Context context) {
        return new File(w(context), w);
    }

    private void hf(Context context) {
        FileOutputStream fileOutputStream = this.u;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        File u = u(context);
        if (u.exists()) {
            for (File file : u.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static int u(xj xjVar) {
        JSONObject optJSONObject;
        if (xj(xjVar)) {
            return 7132;
        }
        if (!f.zg().en().has(xjVar.xj) || (optJSONObject = f.zg().en().optJSONObject(xjVar.xj)) == null) {
            return 0;
        }
        return hf(optJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION));
    }

    private static boolean w(xj xjVar) {
        if (xj(xjVar)) {
            return 7132 == xjVar.hf;
        }
        JSONObject optJSONObject = f.zg().en().optJSONObject(xjVar.xj);
        return (optJSONObject != null ? hf(optJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0) == xjVar.hf;
    }

    public static hf xj() {
        return kd;
    }

    public void xj(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = pz.getContext().getApplicationContext();
        c.hf(new d("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hf.this.xj(applicationContext, (List<xj>) hf.w(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<xj> w(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    xj xjVar = new xj();
                    xjVar.xj = xj(optJSONObject.optString(n.p));
                    xjVar.hf = optJSONObject.optInt("version_code");
                    xjVar.w = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                    xjVar.u = optJSONObject.optString("download_url");
                    xjVar.kd = optJSONObject.optString("sign");
                    xjVar.f = hf(optJSONObject.optString("min_version"));
                    xjVar.d = hf(optJSONObject.optString("max_version"));
                    xjVar.tf = optJSONObject.optInt("plugin_update_network", -2);
                    arrayList.add(xjVar);
                }
            }
        }
        return arrayList;
    }

    private boolean xj(Context context, int i, String str) {
        int xj2 = f.zg().et().xj(str);
        if (f.zg().hl()) {
            return xj(xj2);
        }
        if (i != -1) {
            if (i != 1 && i != 2 && i != 3) {
                if (i == 4 || i == 5) {
                    return false;
                }
                if (xj2 == 3) {
                    i = 1;
                }
            }
            return xj(i);
        }
        i = xj2;
        return xj(i);
    }

    private boolean hf(xj xjVar, int i) {
        xj(xjVar);
        return (i == 21 || i == 18) ? false : true;
    }

    private static boolean hf(xj xjVar) {
        int hf2;
        JSONObject optJSONObject;
        if (xj(xjVar)) {
            hf2 = ai.w;
        } else {
            hf2 = (!f.zg().en().has(xjVar.xj) || (optJSONObject = f.zg().en().optJSONObject(xjVar.xj)) == null) ? 0 : hf(optJSONObject.optString(PluginConstants.KEY_SDK_VERSION));
        }
        return hf2 >= xjVar.f && hf2 <= xjVar.d;
    }

    private boolean xj(int i) {
        if (i != 1) {
            if (i == 3 || i == 4 || i == 5) {
                return false;
            }
        } else if (!am.u(pz.getContext())) {
            return false;
        }
        return true;
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        this.y = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final Context context, List<xj> list) {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("", 7132, 0, "", 14, e.getMessage(), 0L);
                    pl.hf("PluginUpdater", "Handle file error: " + e);
                }
                if (!xj(context)) {
                    hf(context);
                    return;
                }
                list.size();
                final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                for (final xj xjVar : list) {
                    c.hf(new d("pl download") { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.hf.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hf.this.xj(context, xjVar);
                            countDownLatch.countDown();
                        }
                    });
                }
                countDownLatch.await();
                hf(context);
            } catch (Throwable th) {
                hf(context);
                throw th;
            }
        }
    }

    private static boolean hf(int i) {
        File xj2 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext());
        if (xj2 == null) {
            return false;
        }
        return A2egSU.BPw6Q8(xj2.getParent() + "/pangle_p/com.byted.pangle/version-" + i);
    }

    public static String hf() {
        String str;
        String xj2 = com.bytedance.sdk.openadsdk.core.ai.hf.hf.xj();
        if ("arm64-v8a".equals(xj2)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(xj2)) {
            str = "@32";
        } else if ("armeabi".equals(xj2)) {
            str = "@armeabi";
        } else {
            str = "";
        }
        return "com.byted.live.lite".concat(str);
    }

    private boolean xj(Context context) {
        try {
            File u = u(context);
            if (!u.exists()) {
                u.mkdirs();
            }
            File file = new File(u, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                pl.hf("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.u = fileOutputStream;
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock != null && tryLock.isValid()) {
                return true;
            }
            pl.hf("PluginUpdater", "Acquire file lock failed");
            this.u.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.u;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            pl.hf("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private static int hf(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(".", ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private static boolean xj(xj xjVar) {
        return "com.byted.pangle".equals(xjVar.xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, xj xjVar) {
        String str;
        int i;
        int i2;
        boolean z;
        try {
            if (!xj(context, xjVar.tf, xjVar.xj)) {
                str = f.zg().et() + ":" + xjVar.tf;
                i2 = 0;
                z = false;
                i = 20;
            } else {
                i2 = xj(context, u(context), xjVar);
                z = true;
                str = "";
                i = i2;
            }
        } catch (C0135hf e) {
            int xj2 = e.xj();
            String message = e.getMessage();
            xj(xjVar.xj, PluginConstants.ERROR_PLUGIN_DOWNLOAD);
            str = message;
            i = xj2;
            i2 = 0;
            z = false;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(xjVar.xj, xj(xjVar) ? 7132 : 0, xjVar.hf, xjVar.u, i, str, d - f);
        if (z) {
            xj(xjVar, i2);
        }
    }

    private void xj(xj xjVar, int i) {
        SparseArray<Object> hf2;
        Object apply;
        PluginValueSet pluginValueSet;
        if (this.y == null || !hf(xjVar, i)) {
            return;
        }
        SparseArray<Object> hf3 = u.xj().xj(2, xjVar.toString()).xj(3, xjVar.xj).hf();
        boolean z = i == 6 || i == 10 || i == 16;
        SparseArray<Object> hf4 = kd.xj().xj(z).xj(z ? 0 : PluginConstants.ERROR_PLUGIN_DOWNLOAD).xj(hf3).hf();
        try {
            if (com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w)) {
                hf2 = u.xj(hf4).xj(1).xj(SparseArray.class).hf();
            } else {
                hf2 = u.xj().xj(1).xj(SparseArray.class).xj(-99999979, hf4).hf();
            }
            apply = this.y.apply(hf2);
            if (apply instanceof SparseArray) {
                pluginValueSet = new AYUAbz((SparseArray) apply).A2egSU();
            } else {
                pluginValueSet = (com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w) && (apply instanceof PluginValueSet)) ? (PluginValueSet) apply : null;
            }
            if (pluginValueSet == null || !pluginValueSet.booleanValue(4) || xjVar.p == null) {
                return;
            }
            HashMap<String, String> hashMap = c;
            hashMap.put(xjVar.xj, new File(xjVar.p).getName());
            xj(xjVar.xj, xjVar.w);
            hashMap.values();
        } catch (Exception e) {
            pl.w("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
        }
    }

    private static void xj(String str, String str2) {
        if (str == null) {
            return;
        }
        f.zg().xj(str, str2);
    }

    private static int xj(Context context, File file, xj xjVar) {
        String str;
        if (xjVar == null) {
            return 2;
        }
        try {
            if (TextUtils.isEmpty(xjVar.u)) {
                return 2;
            }
            if (TextUtils.isEmpty(xjVar.xj)) {
                return 12;
            }
            if (!xj(xjVar) && !f.zg().en().has(xjVar.xj)) {
                return 17;
            }
            if (w(xjVar)) {
                return 18;
            }
            if (hf(xjVar.hf)) {
                return 21;
            }
            if (!hf(xjVar)) {
                return 19;
            }
            File y = y(context);
            if (!y.exists()) {
                y.mkdirs();
            }
            boolean z = true;
            if (xj(xjVar) && ai.w >= xjVar.hf) {
                String str2 = "-" + com.bytedance.sdk.component.utils.kd.hf(xjVar.xj) + "-" + ai.w + "-" + ai.w;
                int i = ai.w;
                xjVar.d = i;
                xjVar.f = i;
                xjVar.c = true;
                xj(new File(y, str2 + ".conf"), xjVar);
                return 10;
            }
            if (TextUtils.isEmpty(xjVar.kd) && !xjVar.xj()) {
                return 1;
            }
            String hf2 = com.bytedance.sdk.component.utils.kd.hf(xjVar.xj);
            StringBuilder sb = new StringBuilder();
            String hf3 = com.bytedance.sdk.component.utils.kd.hf(xjVar.kd);
            if (!TextUtils.isEmpty(hf3)) {
                sb.append(hf3);
                sb.append("-");
            }
            sb.append(hf2);
            sb.append("-");
            sb.append(xjVar.f);
            sb.append("-");
            sb.append(xjVar.d);
            String sb2 = sb.toString();
            File kd2 = kd(context);
            if (!kd2.exists()) {
                kd2.mkdirs();
            }
            File file2 = new File(kd2, sb2 + (xjVar.xj() ? ".dex.zip" : ".apk"));
            if (file2.exists()) {
                xjVar.y = com.bytedance.sdk.component.utils.kd.xj(file2);
                xjVar.p = file2.getAbsolutePath();
                return 16;
            }
            if (file2.getName().equals(c.get(xjVar.xj))) {
                return 21;
            }
            com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(xjVar.xj, xj(xjVar) ? 7132 : 0, xjVar.hf, xjVar.u, 7, "", 0L);
            File file3 = new File(file, sb2);
            com.bytedance.sdk.component.d.hf.hf u = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().u();
            u.xj(xjVar.u);
            u.xj(file.getAbsolutePath(), sb2);
            f = System.currentTimeMillis();
            com.bytedance.sdk.component.d.hf xj2 = u.xj();
            if (xj2 != null && xj2.f()) {
                d = System.currentTimeMillis();
                if (!file3.exists()) {
                    return 13;
                }
                xj(kd2, hf2);
                xj(y, hf2);
                if (!file3.renameTo(file2)) {
                    return 5;
                }
                File file4 = new File(y, file3.getName() + ".conf");
                xjVar.y = com.bytedance.sdk.component.utils.kd.xj(file2);
                xjVar.p = file2.getAbsolutePath();
                if (xjVar.hf >= u(xjVar)) {
                    z = false;
                }
                xjVar.c = z;
                return xj(file4, xjVar) ? 6 : 15;
            }
            if (xj2 != null) {
                str = xj2.xj() + " : " + xj2.hf();
            } else {
                str = "no response";
            }
            throw new C0135hf(9, str);
        } catch (Exception e) {
            pl.hf("PluginUpdater", "Download file error: " + e);
            if (e instanceof C0135hf) {
                throw e;
            }
            String message = e.getMessage();
            try {
                message = Log.getStackTraceString(e);
            } catch (Throwable th) {
                pl.xj(th);
            }
            throw new C0135hf(14, message);
        }
    }

    private static boolean xj(File file, xj xjVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(xjVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            pl.hf("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void xj(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.hf.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                pl.hf("PluginUpdater", "Delete file: ".concat(str2));
                return false;
            }
        });
    }

    public static String xj(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    public void xj(String str, int i) {
        SparseArray<Object> hf2;
        if (this.y == null) {
            return;
        }
        SparseArray<Object> hf3 = kd.xj().xj(false).xj(i).xj(u.xj().xj(3, str).hf()).hf();
        int i2 = ai.w;
        if (i2 < 7000 && i2 >= 6800) {
            hf2 = u.xj(hf3).xj(1).xj(Void.class).hf();
        } else {
            hf2 = u.xj().xj(1).xj(Void.class).xj(-99999979, hf3).hf();
        }
        this.y.apply(hf2);
    }
}
