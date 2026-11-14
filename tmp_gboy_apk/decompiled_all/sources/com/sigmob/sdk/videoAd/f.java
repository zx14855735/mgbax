package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.views.n;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final int f13700a;
    private final int b;
    private final n c;
    private final int d;
    private String e;
    private a f;
    private String g;
    private String h;
    private int i;
    private boolean j = false;
    private com.sigmob.sdk.videoAd.a k;

    public interface a {
        void a();

        void b();
    }

    public f(int i, int i2, int i3, String str, String str2, n nVar) {
        this.f13700a = i;
        this.b = i2;
        this.d = i3;
        this.h = str2;
        this.g = str;
        this.c = nVar;
    }

    public n a() {
        return this.c;
    }

    public String b() {
        return this.h;
    }

    public int c() {
        return this.f13700a;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        this.i = i;
    }

    private void a(BaseAdUnit baseAdUnit, String str, String str2, com.sigmob.sdk.base.a aVar) {
    }

    public void a(com.sigmob.sdk.videoAd.a aVar) {
        this.k = aVar;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(String str) {
        this.h = str;
    }
}
