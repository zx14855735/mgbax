package com.bytedance.sdk.openadsdk.core.ff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ff.xj.hf;
import com.bytedance.sdk.openadsdk.core.ff.xj.w;
import com.bytedance.sdk.openadsdk.core.ra.gj;
import com.bytedance.sdk.openadsdk.core.w.u;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.bi;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static final List<String> g = Arrays.asList("-10001", "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");

    @SuppressLint({"StaticFieldLeak"})
    private static volatile xj xj;
    private String[] f;
    private final Context hf;
    private final u kd;
    private final gj u;
    private final w w;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private long d = 0;
    private long tf = 0;
    private long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private long f10355pl = 0;
    private boolean y = true;

    static {
        IineZrh();
    }

    private xj(Context context) {
        this.hf = context;
        this.w = w.xj(context);
        u xj2 = u.xj();
        this.kd = xj2;
        if (xj2 == null) {
            this.u = new gj("", "-1", "", "");
            return;
        }
        String w = xj2.w("cr", 3300000L);
        if (TextUtils.isEmpty(w)) {
            this.u = new gj("", "", "", "");
        } else {
            this.u = new gj(xj2.w("vd", xj(w)), xj2.w("err", xj(w)), xj2.w("tk", xj(w)), xj2.w("cr", xj(w)));
        }
        w();
    }

    private static /* synthetic */ void IineZrh() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean hf() {
        u uVar = this.kd;
        if (uVar != null) {
            String w = uVar.w("cr", 3300000L);
            if (!TextUtils.isEmpty(w) && !TextUtils.isEmpty(this.kd.w("tk", xj(w)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.c.set(false);
        this.w.hf();
    }

    private void w() {
        u uVar = this.kd;
        if (uVar != null) {
            this.tf = uVar.hf("uni_fir_ts", 0L);
            if (wo.xj(System.currentTimeMillis(), this.tf)) {
                this.p = this.kd.hf("uni_times", 0L);
                this.f10355pl = this.kd.hf("uni_ts", 0L);
            } else {
                this.p = 0L;
                this.f10355pl = 0L;
            }
        }
    }

    private long xj(String str) {
        String str2;
        switch (str.hashCode()) {
            case 49:
                str2 = "1";
                break;
            case 50:
                return str.equals("2") ? 50000L : 3300000L;
            case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                str2 = "3";
                break;
            default:
                return 3300000L;
        }
        str.equals(str2);
        return 3300000L;
    }

    public static xj xj(Context context) {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public gj xj() {
        if (!hf() && this.y) {
            if (!this.c.compareAndSet(false, true)) {
                return this.u;
            }
            f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ff.xj.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
                
                    if (r12.equals("2") == false) goto L14;
                 */
                /* JADX WARN: Removed duplicated region for block: B:10:0x00cf  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x00e2  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 294
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ff.xj.AnonymousClass1.run():void");
                }
            });
            return this.u;
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0108 A[EDGE_INSN: B:56:0x0108->B:45:0x0108 BREAK  A[LOOP:0: B:2:0x0006->B:54:0x0006], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(android.net.Network r15, java.util.List<java.lang.String> r16) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ff.xj.xj(android.net.Network, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0 A[Catch: Exception -> 0x0112, TryCatch #0 {Exception -> 0x0112, blocks: (B:12:0x0025, B:13:0x002c, B:21:0x00e7, B:23:0x00f0, B:25:0x00f6, B:30:0x0058, B:32:0x005e, B:33:0x0064, B:35:0x006a, B:37:0x0074, B:39:0x008d, B:40:0x0090, B:42:0x0094, B:45:0x009a, B:47:0x00aa, B:50:0x00ca, B:52:0x00de, B:54:0x0030, B:57:0x003a, B:60:0x0044), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(android.net.Network r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ff.xj.xj(android.net.Network, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private Pair<String, String> xj(Network network, String str, String str2, String str3) {
        String str4;
        JSONObject xj2 = hf.xj(network, str, null);
        try {
            if (xj2 == null) {
                this.u.xj(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string = xj2.has("err_code") ? xj2.getString("err_code") : "6";
            if (this.f == null || System.currentTimeMillis() - this.d > bi.s) {
                this.f = p.d();
                this.d = System.currentTimeMillis();
            }
            String[] strArr = this.f;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.u.xj(this.f[1]);
            }
            if (xj2.has("province")) {
                this.u.hf(xj2.getString("province"));
            }
            if (!xj2.has(PluginConstants.KEY_ERROR_CODE)) {
                str4 = "";
            } else {
                string = Constants.FAIL;
                str4 = xj2.getString(PluginConstants.KEY_ERROR_CODE);
            }
            return new Pair<>(string, str4);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
