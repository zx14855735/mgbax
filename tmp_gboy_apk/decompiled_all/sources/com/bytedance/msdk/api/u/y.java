package com.bytedance.msdk.api.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private Map<String, String> f;
    public final String xj = MediationConstant.TAG;
    private String hf = "";
    private String w = "";
    private String u = "";
    private int kd = 0;
    private String y = "";
    private String c = "";

    public String c() {
        return this.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        if (r7 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lba
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lba
        L13:
            com.bytedance.msdk.api.u.y r7 = (com.bytedance.msdk.api.u.y) r7
            int r2 = r6.kd()
            int r3 = r7.kd()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.c()
            java.lang.String r3 = r7.c()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.hf()
            java.lang.String r3 = r7.hf()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.w()
            java.lang.String r3 = r7.w()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.u()
            java.lang.String r3 = r7.u()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.y()
            java.lang.String r3 = r7.y()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.xj()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 != r4) goto Lb4
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L86:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L86
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto Lb4
            goto L86
        Lad:
            r7 = 1
            goto Lb5
        Laf:
            if (r3 != 0) goto Lb4
            if (r7 != 0) goto Lb4
            goto Lad
        Lb4:
            r7 = 0
        Lb5:
            if (r2 == 0) goto Lba
            if (r7 == 0) goto Lba
            return r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.u.y.equals(java.lang.Object):boolean");
    }

    public String hf() {
        return this.hf;
    }

    public int kd() {
        return this.kd;
    }

    public String u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public void xj(Map<String, String> map) {
        this.f = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!y(entry.getKey())) {
                    com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (y(entry.getValue())) {
                    this.f.put(entry.getKey(), entry.getValue());
                } else {
                    com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                }
            }
        }
    }

    public String y() {
        return this.y;
    }

    public static boolean y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    public void hf(String str) {
        if (y(str)) {
            this.w = str;
        } else {
            com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public void kd(String str) {
        if (y(str)) {
            this.c = str;
        } else {
            com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }

    public void u(String str) {
        if (y(str)) {
            this.y = str;
        } else {
            com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public void w(String str) {
        if (y(str)) {
            this.u = str;
        } else {
            com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public Map<String, String> xj() {
        return this.f;
    }

    public void xj(String str) {
        if (y(str)) {
            this.hf = str;
        } else {
            com.bytedance.sdk.component.utils.pl.u(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public void xj(int i) {
        this.kd = i;
    }
}
