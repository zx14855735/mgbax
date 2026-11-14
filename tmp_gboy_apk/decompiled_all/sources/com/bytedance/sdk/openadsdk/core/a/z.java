package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class z {
    private String xj;

    private z() {
        hf();
    }

    private void hf() {
        File xj;
        Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.x.w.xj()) && (xj = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context, "TTCache")) != null) {
                xj.mkdirs();
                this.xj = xj.getPath();
            }
            if (TextUtils.isEmpty(this.xj)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context), "TTCache");
                file.mkdirs();
                this.xj = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void w() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj().w();
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().hf();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.j.f.xj();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.xj.hf.hf.hf();
            com.bytedance.sdk.openadsdk.core.ugeno.kd.xj.hf().y();
        } catch (Throwable unused4) {
        }
        try {
            Function<SparseArray<Object>, Object> r = com.bytedance.sdk.openadsdk.core.f.zg().r();
            if (r != null) {
                r.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(7).xj(Void.class).hf());
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.w.w.xj().tf();
            com.bytedance.sdk.openadsdk.core.w.u.xj().ra();
            com.bytedance.sdk.openadsdk.core.w.kd.xj().zg();
        } catch (Throwable unused6) {
        }
    }

    public static z xj() {
        return new z();
    }

    public void xj(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            r0 = stringWriter2 != null ? stringWriter2.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.c.u.xj().xj(thread, th);
        } catch (Throwable unused) {
        }
        if (r0) {
            hf(thread, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void hf(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.z.hf(java.lang.Thread, java.lang.Throwable):void");
    }
}
