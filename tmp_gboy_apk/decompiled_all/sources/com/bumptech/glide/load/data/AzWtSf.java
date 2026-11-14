package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ParcelFileDescriptorRewinder$InternalRewinder f9996AcNBzu;

    public AzWtSf(ParcelFileDescriptor parcelFileDescriptor) {
        this.f9996AcNBzu = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public final ParcelFileDescriptor A2egSU() {
        return this.f9996AcNBzu.rewind();
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public final void AMqCpz() {
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public final Object AYUAbz() {
        return this.f9996AcNBzu.rewind();
    }
}
