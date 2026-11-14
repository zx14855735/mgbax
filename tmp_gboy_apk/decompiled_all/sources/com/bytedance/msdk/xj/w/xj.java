package com.bytedance.msdk.xj.w;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.api.u.am;
import com.czhj.sdk.common.Constants;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.msdk.xj.xj.u {
    private void d() {
        hf.hf(hf.xj(hf.xj(), "personal_ads_type", com.bytedance.msdk.core.xj.p().hf().c() ? Constants.FAIL : "1"));
    }

    private void f() {
        d();
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void c() {
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public Map<String, Object> hf(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public long kd() {
        return 0L;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void u() {
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String w() {
        return com.bytedance.sdk.gromore.init.xj.u();
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public int xj(com.bytedance.msdk.api.u.w wVar) {
        return 0;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public int y() {
        return 0;
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String hf() {
        return com.bytedance.sdk.gromore.init.xj.w();
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public String xj() {
        return hf() + ".0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x007a, code lost:
    
        if (r4 == 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0087, code lost:
    
        if (r4 == 3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0063, code lost:
    
        if (r4 == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0065, code lost:
    
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x006f, code lost:
    
        if (r4 == 4) goto L34;
     */
    @Override // com.bytedance.msdk.xj.xj.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String xj(android.content.Context r18, java.util.Map<java.lang.String, java.lang.Object> r19) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xj.w.xj.xj(android.content.Context, java.util.Map):java.lang.String");
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void xj(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.bytedance.msdk.xj.xj.xj.kd);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (intValue == 0 || intValue == 1) {
            com.bytedance.sdk.gromore.init.xj.xj(intValue);
        }
    }

    @Override // com.bytedance.msdk.xj.xj.u
    public void xj(am amVar, SparseArray<Object> sparseArray) {
        com.bytedance.msdk.core.xj.p().hf().hf(sparseArray);
        f();
    }

    @Override // com.bytedance.msdk.xj.xj.hf
    public void xj(Context context, Map<String, Object> map, com.bytedance.msdk.xj.xj.w wVar) {
        d();
        wVar.xj();
    }
}
