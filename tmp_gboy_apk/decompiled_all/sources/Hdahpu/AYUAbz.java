package Hdahpu;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f3696A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f3697A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f3698A5SV6n;

    public AYUAbz(ARc23Z aRc23Z) {
        Context context = aRc23Z.f3691A2egSU;
        ActivityManager activityManager = aRc23Z.f3692A4TApA;
        int i = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        this.f3698A5SV6n = i;
        int round = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = aRc23Z.f3693A5SV6n.f3695AcNBzu;
        float f = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        float f2 = aRc23Z.f3694ADYaiT;
        int round2 = Math.round(f * f2);
        int round3 = Math.round(f * 2.0f);
        int i2 = round - i;
        if (round3 + round2 <= i2) {
            this.f3697A4TApA = round3;
            this.f3696A2egSU = round2;
        } else {
            float f3 = i2 / (f2 + 2.0f);
            this.f3697A4TApA = Math.round(2.0f * f3);
            this.f3696A2egSU = Math.round(f3 * f2);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Formatter.formatFileSize(context, this.f3697A4TApA);
            Formatter.formatFileSize(context, this.f3696A2egSU);
            Formatter.formatFileSize(context, i);
            Formatter.formatFileSize(context, round);
            activityManager.getMemoryClass();
            activityManager.isLowRamDevice();
        }
    }
}
