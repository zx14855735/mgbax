package Mt2q9w;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends AZOQYO {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f5537A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Drawable f5538A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f5539ADYaiT;
    public final ArrayList AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final boolean f5540ARc23Z;

    public ASJ6gh(int i, Drawable drawable, String str, ArrayList arrayList) {
        this.f5540ARc23Z = false;
        this.f5537A4TApA = i;
        this.f5538A5SV6n = drawable;
        this.f5539ADYaiT = str;
        this.AMqCpz = arrayList;
        this.f5540ARc23Z = arrayList != null;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AYUAbz) it.next()).f5544A2egSU = 1;
            }
        }
    }
}
