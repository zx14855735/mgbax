package com.octopus.ad.b.d;

import android.content.Context;
import com.octopus.ad.b.d.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.octopus.ad.b.c {

    /* renamed from: a, reason: collision with root package name */
    private c f12359a;
    private boolean b = false;
    private boolean c = false;

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            c cVar = new c();
            this.f12359a = cVar;
            this.c = cVar.a(context, (c.a<String>) null) == 1;
            this.b = true;
        }
        if (this.c && this.f12359a.b()) {
            return this.f12359a.a();
        }
        return null;
    }
}
