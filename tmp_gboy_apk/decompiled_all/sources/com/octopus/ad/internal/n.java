package com.octopus.ad.internal;

import android.content.Context;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.x;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private String f12443a;
    private String b;
    private String c;
    private long d;
    private String e;
    private x f;
    private Context h;
    private ArrayList<String> j;
    private HTTPGet.ResponseListener k;
    private boolean g = false;
    private a i = new a();

    public class a implements x.a {

        /* renamed from: a, reason: collision with root package name */
        long f12445a;

        private a() {
            this.f12445a = 0L;
        }

        @Override // com.octopus.ad.internal.x.a
        public void a(boolean z) {
            if (z) {
                this.f12445a += 250;
            } else {
                this.f12445a = 0L;
            }
            if (this.f12445a >= 500) {
                n.this.a();
            }
        }
    }

    private n(String str, String str2, String str3, long j, String str4, x xVar, Context context, ArrayList<String> arrayList) {
        this.f12443a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = str4;
        this.f = xVar;
        this.h = context;
        this.j = arrayList;
    }

    public static n a(String str, String str2, String str3, long j, String str4, x xVar, Context context, ArrayList<String> arrayList) {
        if (xVar == null) {
            return null;
        }
        n nVar = new n(str, str2, str3, j, str4, xVar, context, arrayList);
        xVar.a(nVar.i);
        return nVar;
    }

    private void b() {
        u uVar = new u(this.f12443a, this.b, this.c, this.d, this.e, true);
        uVar.a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.n.1
            @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
            public void getResponse(int i, boolean z, String str) {
                if (n.this.k != null) {
                    n.this.k.getResponse(i, z, str);
                }
            }
        });
        uVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Context context;
        try {
            if (!this.g && (context = this.h) != null) {
                com.octopus.ad.internal.network.c a2 = com.octopus.ad.internal.network.c.a(context.getApplicationContext());
                if (a2.b(this.h)) {
                    b();
                    this.f.b(this.i);
                    this.i = null;
                } else {
                    a2.a(this.e, this.h);
                }
                this.g = true;
                this.j.remove(this.e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(HTTPGet.ResponseListener responseListener) {
        this.k = responseListener;
    }
}
