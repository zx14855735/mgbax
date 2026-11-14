package com.bytedance.sdk.openadsdk.core.x.kd;

import com.bytedance.sdk.openadsdk.ats.u;
import com.bytedance.sdk.openadsdk.core.x.hf;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements hf {
    private static volatile xj xj;

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String hf() {
        return "ugen_render";
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String xj(String str) {
        int i = u.xj(hf()).get(str, 0);
        if (i == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) {
            return Constants.FAIL;
        }
        return String.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0104 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.kd.xj.xj(java.lang.String, java.lang.String):void");
    }
}
