package com.octopus.ad.utils;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    private static g c;

    /* renamed from: a, reason: collision with root package name */
    public h f12705a;
    private String b = "OnLineState";

    private g(Context context) {
        if (context == null) {
            com.octopus.ad.utils.b.f.c("OnLineState", "OnLineState init failed,because context cann't be null ");
            return;
        }
        h hVar = new h();
        this.f12705a = hVar;
        hVar.a(context);
    }

    public static g a(Context context) {
        if (c == null) {
            synchronized (g.class) {
                try {
                    if (c == null) {
                        c = new g(context);
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(f fVar) {
        h hVar = this.f12705a;
        if (hVar != null) {
            hVar.a(fVar);
        } else {
            com.octopus.ad.utils.b.f.a(this.b, "please init OnLineState first ,you can init it with 'OnLineState.init(context);' in you BaseApplication ");
        }
    }
}
