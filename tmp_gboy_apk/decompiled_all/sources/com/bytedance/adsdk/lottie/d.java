package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private Bitmap am;
    private final String c;
    private final List<hf> d;
    private final String f;
    private final xj g;
    private final int hf;
    private final String kd;
    private final int[][] p;

    /* renamed from: pl, reason: collision with root package name */
    private final JSONArray f10037pl;
    private final String tf;
    private final String u;
    private final String w;
    private final int xj;
    private final String y;

    public static class hf {
        public int c;
        public String d;
        public int f;
        public int g;
        public int hf;
        public String kd;
        public xj p;

        /* renamed from: pl, reason: collision with root package name */
        public int f10038pl;
        public xj tf;
        public String u;
        public String w;
        public int xj;
        public int y;

        public static class xj {
            public String hf;
            public int xj;
        }
    }

    public static class xj {
        public boolean hf;
        public C0021xj xj = null;

        /* renamed from: com.bytedance.adsdk.lottie.d$xj$xj, reason: collision with other inner class name */
        public static class C0021xj {
            public float xj = 5.0f;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d(int i, int i2, String str, String str2, String str3, String str4, List<hf> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, xj xjVar) {
        this.xj = i;
        this.hf = i2;
        this.w = str;
        this.u = str2;
        this.kd = str3;
        this.y = str4;
        this.c = str6;
        this.f = str7;
        this.d = list;
        this.tf = str5;
        this.p = iArr;
        this.f10037pl = jSONArray;
        this.g = xjVar;
    }

    public Bitmap am() {
        return this.am;
    }

    public String c() {
        return this.tf;
    }

    public JSONArray d() {
        return this.f10037pl;
    }

    public int[][] f() {
        return this.p;
    }

    public String g() {
        return this.kd;
    }

    public int hf() {
        return this.hf;
    }

    public String kd() {
        return this.c;
    }

    public String p() {
        return this.w;
    }

    public String pl() {
        return this.u;
    }

    public xj tf() {
        return this.g;
    }

    public String u() {
        return this.y;
    }

    public List<hf> w() {
        return this.d;
    }

    public int xj() {
        return this.xj;
    }

    public String y() {
        return this.f;
    }

    public void xj(Bitmap bitmap) {
        this.am = bitmap;
    }
}
