package Hjvs0g;

import android.content.Context;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3737A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f3738A4TApA;

    public B3GDIM(Context context, int i) {
        this.f3737A2egSU = i;
        switch (i) {
            case 1:
                this.f3738A4TApA = context.getApplicationContext();
                break;
            case 2:
                this.f3738A4TApA = context.getApplicationContext();
                break;
            default:
                this.f3738A4TApA = context;
                break;
        }
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        Long l;
        switch (this.f3737A2egSU) {
            case 0:
                Uri uri = (Uri) obj;
                return new BChYOn(new IssTRV.ADYaiT(uri), new B2KMhB(this.f3738A4TApA, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384) {
                    return null;
                }
                IssTRV.ADYaiT aDYaiT = new IssTRV.ADYaiT(uri2);
                Context context = this.f3738A4TApA;
                return new BChYOn(aDYaiT, new HSr46Q.A5SV6n(0, uri2, new HSr46Q.AMqCpz(com.bumptech.glide.A4TApA.A4TApA(context).f9878AzWtSf.ARc23Z(), new HSr46Q.A2egSU(context.getContentResolver()), com.bumptech.glide.A4TApA.A4TApA(context).f9879B25kr6, context.getContentResolver())));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384 || (l = (Long) amA8tU.A5SV6n(I3HV03.COJEAR.f3873ADYaiT)) == null || l.longValue() != -1) {
                    return null;
                }
                IssTRV.ADYaiT aDYaiT2 = new IssTRV.ADYaiT(uri3);
                Context context2 = this.f3738A4TApA;
                return new BChYOn(aDYaiT2, new HSr46Q.A5SV6n(0, uri3, new HSr46Q.AMqCpz(com.bumptech.glide.A4TApA.A4TApA(context2).f9878AzWtSf.ARc23Z(), new HSr46Q.A4TApA(context2.getContentResolver()), com.bumptech.glide.A4TApA.A4TApA(context2).f9879B25kr6, context2.getContentResolver())));
        }
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        switch (this.f3737A2egSU) {
            case 0:
                return JrXYwF.A4TApA.CikNvS((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return JrXYwF.A4TApA.CikNvS(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return JrXYwF.A4TApA.CikNvS(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
