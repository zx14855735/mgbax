package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends A4TApA {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f9989B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AaHO0E(AssetManager assetManager, String str, int i) {
        super(0, str, assetManager);
        this.f9989B25kr6 = i;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        switch (this.f9989B25kr6) {
            case 0:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.A4TApA
    public final void ADYaiT(Object obj) {
        switch (this.f9989B25kr6) {
            case 0:
                ((ParcelFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.A4TApA
    public final Object AYUAbz(AssetManager assetManager, String str) {
        switch (this.f9989B25kr6) {
            case 0:
                return assetManager.openFd(str).getParcelFileDescriptor();
            default:
                return assetManager.open(str);
        }
    }
}
