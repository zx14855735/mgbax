package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.n0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class m0 implements n0.pgla {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long f14019A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f14020A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final pblu f14021A5SV6n;

    public m0(pblu pbluVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.f14021A5SV6n = pbluVar;
        this.f14020A4TApA = context.getApplicationContext();
        this.f14019A2egSU = j;
    }
}
