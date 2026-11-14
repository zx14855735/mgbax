package com.octopus.ad.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static k f12440a;
    private final ArrayList<a> b = new ArrayList<>();

    public interface a {
        void a(String str);
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            try {
                if (f12440a == null) {
                    f12440a = new k();
                }
                kVar = f12440a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }

    public void b(a aVar) {
        try {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next() == aVar) {
                    it.remove();
                }
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public void a(String str) {
        try {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
