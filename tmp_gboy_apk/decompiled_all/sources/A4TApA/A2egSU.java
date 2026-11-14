package A4TApA;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.data.ASJ6gh;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements ASJ6gh {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static A2egSU f6AlLFFp;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f7AcNBzu;

    public void A2egSU() {
        synchronized (this.f7AcNBzu) {
        }
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public void AMqCpz() {
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public Object AYUAbz() {
        return this.f7AcNBzu;
    }

    public A2egSU() {
        this.f7AcNBzu = new Object();
        new Handler(Looper.getMainLooper(), new IJPJ4E.ASJ6gh(1, this));
    }
}
