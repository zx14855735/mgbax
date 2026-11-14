package com.bytedance.msdk.core.f;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends u {
    private String c;
    private long f;
    private long y;

    public d(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        super(str, str2, str3, str4, i);
        this.f = 0L;
        this.y = 0L;
        try {
            this.y = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.c = str6;
    }

    public long d() {
        return this.y;
    }

    @Override // com.bytedance.msdk.core.f.u
    public boolean f() {
        return (TextUtils.isEmpty(this.c) || this.y == 0) ? false : true;
    }

    public long p() {
        return this.f;
    }

    public boolean pl() {
        return this.f != 0;
    }

    public String tf() {
        return this.c;
    }

    @Override // com.bytedance.msdk.core.f.u
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.xj + "', showRulesVersion='" + this.w + "', timingMode=" + this.kd + "}IntervalPacingBean{pacing=" + this.y + ", pacingRuleId='" + this.c + "', effectiveTime=" + this.f + '}';
    }

    public void xj(long j) {
        this.f = j;
    }

    public d(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i, str5, str6);
        this.f = 0L;
        try {
            this.f = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }
}
