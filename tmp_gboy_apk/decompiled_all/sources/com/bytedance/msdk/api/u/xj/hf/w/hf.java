package com.bytedance.msdk.api.u.xj.hf.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.zg.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private final String c;
    private final String d;
    private final String f;
    private final String hf;
    private final String kd;
    private final String p;

    /* renamed from: pl, reason: collision with root package name */
    private final String f10116pl;
    private final String tf;
    private final String u;
    private final String w;
    private final String xj;
    private final String y;

    public hf() {
        this.w = "";
        this.xj = "";
        this.hf = "";
        this.u = "";
        this.kd = "";
        this.y = "";
        this.c = "";
        this.f = "";
        this.d = "";
        this.tf = "";
        this.p = "";
        this.f10116pl = "";
    }

    public String hf() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GMCustomInitConfig{mAppId='");
        sb.append(this.xj);
        sb.append("', mAppKey='");
        sb.append(this.hf);
        sb.append("', mADNName='");
        sb.append(this.w);
        sb.append("', mAdnInitClassName='");
        sb.append(this.u);
        sb.append("', mBannerClassName='");
        sb.append(this.kd);
        sb.append("', mInterstitialClassName='");
        sb.append(this.y);
        sb.append("', mRewardClassName='");
        sb.append(this.c);
        sb.append("', mFullVideoClassName='");
        sb.append(this.f);
        sb.append("', mSplashClassName='");
        sb.append(this.d);
        sb.append("', mDrawClassName='");
        sb.append(this.p);
        sb.append("', mFeedClassName='");
        return CtFAbx.B25kr6(sb, this.tf, "'}");
    }

    public boolean u() {
        return TextUtils.equals(this.f10116pl, "1");
    }

    public String w() {
        return this.u;
    }

    public SparseArray<Object> xj() {
        u xj = u.xj();
        xj.xj(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, this.w);
        xj.xj(8534, this.xj);
        xj.xj(8535, this.hf);
        xj.xj(8536, this.u);
        xj.xj(8537, this.kd);
        xj.xj(8538, this.y);
        xj.xj(8539, this.c);
        xj.xj(8540, this.f);
        xj.xj(8541, this.d);
        xj.xj(8542, this.tf);
        xj.xj(8543, this.p);
        xj.xj(8544, this.f10116pl);
        return xj.hf();
    }

    public hf(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.w = str;
        this.xj = str2;
        this.hf = str3;
        this.u = str4;
        this.kd = str5;
        this.y = str6;
        this.c = str7;
        this.f = str8;
        this.d = str9;
        this.tf = str10;
        this.p = str11;
        this.f10116pl = str12;
    }

    public xj xj(int i, int i2) {
        switch (i) {
            case 1:
                return new xj(this.kd, com.bytedance.msdk.api.u.xj.hf.xj.xj.class);
            case 2:
                return new xj(this.y, com.bytedance.msdk.api.u.xj.hf.c.xj.class);
            case 3:
                return new xj(this.d, com.bytedance.msdk.api.u.xj.hf.tf.xj.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new xj(this.tf, com.bytedance.msdk.api.u.xj.hf.f.xj.class);
                }
                if (i2 == 5) {
                    return new xj(this.p, com.bytedance.msdk.api.u.xj.hf.u.xj.class);
                }
                if (i2 == 3) {
                    return new xj(this.kd, com.bytedance.msdk.api.u.xj.hf.xj.xj.class);
                }
                return new xj(this.tf, com.bytedance.msdk.api.u.xj.hf.f.xj.class);
            case 7:
                if (i2 == 6) {
                    return new xj(this.c, com.bytedance.msdk.api.u.xj.hf.d.xj.class);
                }
                if (i2 == 7) {
                    return new xj(this.f, com.bytedance.msdk.api.u.xj.hf.kd.xj.class);
                }
                return new xj(this.c, com.bytedance.msdk.api.u.xj.hf.d.xj.class);
            case 8:
                return new xj(this.f, com.bytedance.msdk.api.u.xj.hf.kd.xj.class);
            case 9:
                break;
            case 10:
                if (i2 == 1) {
                    return new xj(this.y, com.bytedance.msdk.api.u.xj.hf.c.xj.class);
                }
                if (i2 == 2) {
                    return new xj(this.f, com.bytedance.msdk.api.u.xj.hf.kd.xj.class);
                }
                break;
        }
        return new xj(this.p, com.bytedance.msdk.api.u.xj.hf.u.xj.class);
    }
}
