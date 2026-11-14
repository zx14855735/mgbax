package IJPJ4E;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends IlwJBd.A5SV6n {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Handler f3899AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f3900B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final long f3901B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Bitmap f3902B3GDIM;

    public AMqCpz(int i, long j, Handler handler) {
        this.f3899AzWtSf = handler;
        this.f3900B25kr6 = i;
        this.f3901B2KMhB = j;
    }

    @Override // IlwJBd.AYUAbz
    public final void ADYaiT(Object obj, IsbtnO.A4TApA a4TApA) {
        this.f3902B3GDIM = (Bitmap) obj;
        Handler handler = this.f3899AzWtSf;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f3901B2KMhB);
    }

    @Override // IlwJBd.AYUAbz
    public final void AZOQYO(Drawable drawable) {
        this.f3902B3GDIM = null;
    }
}
