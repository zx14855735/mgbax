package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CikNvS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f9030A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final LinkedHashSet f9031A4TApA = new LinkedHashSet();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile boolean f9032A5SV6n = false;

    public static void A2egSU(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void A4TApA() {
    }
}
