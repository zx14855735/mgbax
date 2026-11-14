package QJCbnW;

import android.graphics.Color;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f7468A2egSU;

    public A4TApA(int i) {
        this.f7468A2egSU = i;
        String.format(Locale.getDefault(), "%02X%02X%02X%02X", Integer.valueOf(Color.alpha(i)), Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)));
        Color.alpha(i);
        Color.red(i);
        Color.green(i);
        Color.blue(i);
    }
}
