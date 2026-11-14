package COJEAR;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class D8MqeW {
    public static String[] A2egSU(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static AYUAbz A4TApA(View view, AYUAbz aYUAbz) {
        ContentInfo B2KMhB2 = aYUAbz.f1624A2egSU.B2KMhB();
        Objects.requireNonNull(B2KMhB2);
        ContentInfo ASJ6gh2 = ADYaiT.ASJ6gh(B2KMhB2);
        ContentInfo performReceiveContent = view.performReceiveContent(ASJ6gh2);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == ASJ6gh2 ? aYUAbz : new AYUAbz(new AZkASS.ARc23Z(performReceiveContent));
    }

    public static void A5SV6n(View view, String[] strArr, BPw6Q8 bPw6Q8) {
        if (bPw6Q8 == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new D8cQ8b(bPw6Q8));
        }
    }
}
