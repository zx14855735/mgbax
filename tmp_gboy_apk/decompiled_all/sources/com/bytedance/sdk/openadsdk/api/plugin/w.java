package com.bytedance.sdk.openadsdk.api.plugin;

import ADYaiT.CtFAbx;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.d;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class w {
    private static final String hf;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile w w;
    private static final String xj;
    private volatile boolean c;
    private final Function<SparseArray<Object>, Object> kd = new d.w();
    private final Context u;
    private f.xj y;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        xj = CtFAbx.B25kr6(sb, str, "next");
        hf = CtFAbx.AcNBzu(str, "tmp");
        JAzzfG();
    }

    private w(Context context) {
        this.u = context;
    }

    private static /* synthetic */ void JAzzfG() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private File hf() {
        return new File(xj(), hf);
    }

    private File w() {
        return new File(xj(), xj);
    }

    public static w xj(Context context) {
        if (w == null) {
            synchronized (w.class) {
                try {
                    if (w == null) {
                        w = new w(context);
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public void xj(List<f.xj> list) {
        if (list == null || list.isEmpty()) {
            kd.xj("plugin_download", "plugin is empty");
            return;
        }
        f.xj xjVar = list.get(0);
        this.y = xjVar;
        if (TextUtils.isEmpty(xjVar.w)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.y.xj);
        sb.append("-");
        sb.append(this.y.hf);
        sb.append("-");
        sb.append(this.y.y);
        sb.append("-");
        String AZkASS2 = CtFAbx.AZkASS(".apk", this.y.c, sb);
        File w2 = w();
        File file = new File(w2, AZkASS2);
        if (file.exists()) {
            kd.xj("plugin_download", "plugin file already exists");
            com.bytedance.sdk.openadsdk.api.y.hf("FileDownloadTask", "Plugin file already exists.");
            this.y.d = file.getAbsolutePath();
            f.xj xjVar2 = this.y;
            xjVar2.tf = xjVar2.hf < 7132;
            xj(true, xjVar2.xj, xjVar2.toString());
            return;
        }
        File hf2 = hf();
        if (!w2.exists()) {
            w2.mkdirs();
        }
        if (!hf2.exists()) {
            hf2.mkdirs();
        }
        xj(this.y.w, w2.getAbsolutePath(), hf2.getAbsolutePath(), AZkASS2);
    }

    private void xj(String str, String str2, String str3, String str4) {
        if (this.c) {
            com.bytedance.sdk.openadsdk.api.y.hf("FileDownloadTask", "Downloading...");
            return;
        }
        this.c = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.api.plugin.hf.w.xj().xj(str, str2, str4, new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.w.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    w.this.c = false;
                    if (i != 0) {
                        String message = result.message();
                        kd.xj("plugin_download", "download failed: ".concat(String.valueOf(message)));
                        com.bytedance.sdk.openadsdk.api.y.kd("FileDownloadTask", "Download failed. ".concat(String.valueOf(message)));
                        w wVar = w.this;
                        wVar.xj(false, wVar.y.xj, w.this.y.toString());
                        return null;
                    }
                    kd.xj("plugin_download", "download success");
                    w.this.y.d = result.message();
                    com.bytedance.sdk.openadsdk.api.y.hf("FileDownloadTask", "Download end." + w.this.y.d);
                    w.this.y.tf = w.this.y.hf < 7132;
                    w wVar2 = w.this;
                    wVar2.xj(true, wVar2.y.xj, w.this.y.toString());
                    return null;
                }
            });
            kd.xj("plugin_download", "start download");
            com.bytedance.sdk.openadsdk.api.y.hf("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            kd.xj("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.bytedance.sdk.openadsdk.api.y.kd("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z, String str, String str2) {
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        SparseArray sparseArray = A4TApA2.f4113A2egSU;
        sparseArray.put(2, str2);
        sparseArray.put(3, str);
        ADYaiT A2egSU2 = A4TApA2.A2egSU();
        ARc23Z A4TApA3 = ARc23Z.A4TApA();
        A4TApA3.ADYaiT(-999900, z ? 0 : PluginConstants.ERROR_PLUGIN_DOWNLOAD);
        A4TApA3.ASJ6gh(-999903, z);
        A4TApA3.f4113A2egSU.put(-999902, A2egSU2.sparseArray());
        ADYaiT A2egSU3 = A4TApA3.A2egSU();
        SparseArray sparseArray2 = new SparseArray();
        A2egSU.B2KMhB(1, sparseArray2, -99999987, -99999985, Void.class);
        sparseArray2.put(-99999979, A2egSU3.sparseArray());
        this.kd.apply(sparseArray2);
    }

    private File xj() {
        return hf.xj(this.u, "tt_pangle_bykv_file", 0);
    }
}
