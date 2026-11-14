package Hjvs0g;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements com.bumptech.glide.load.data.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3716AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3717AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Object obj) {
        this.f3716AcNBzu = i;
        this.f3717AlLFFp = obj;
    }

    private final void A4TApA() {
    }

    private final void A5SV6n() {
    }

    private final void ADYaiT() {
    }

    private final void ASJ6gh() {
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        switch (this.f3716AcNBzu) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f3717AlLFFp.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        int i = this.f3716AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, com.bumptech.glide.load.data.ADYaiT aDYaiT) {
        switch (this.f3716AcNBzu) {
            case 0:
                try {
                    aDYaiT.ASJ6gh(ItGa5w.A4TApA.A2egSU((File) this.f3717AlLFFp));
                    break;
                } catch (IOException e) {
                    Log.isLoggable("ByteBufferFileLoader", 3);
                    aDYaiT.A5SV6n(e);
                    return;
                }
            default:
                aDYaiT.ASJ6gh(this.f3717AlLFFp);
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        int i = this.f3716AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        switch (this.f3716AcNBzu) {
        }
        return 1;
    }
}
