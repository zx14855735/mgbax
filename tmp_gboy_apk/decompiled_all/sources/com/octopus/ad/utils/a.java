package com.octopus.ad.utils;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Handler;
import com.octopus.ad.internal.utilities.ViewUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f12662a = 0;
    public int b = 0;

    public void a(Context context, final double d, final double d2, int i) {
        if (context == null) {
            return;
        }
        try {
            this.f12662a = ViewUtil.getScreenWidth(context);
            this.b = ViewUtil.getScreenHeight(context);
            new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.utils.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    try {
                        new ProcessBuilder("input", "tap", CtFAbx.ARc23Z((int) (aVar.f12662a * d), ""), CtFAbx.ARc23Z((int) (aVar.b * d2), "")).start();
                    } catch (Exception e) {
                        com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            }, i);
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
