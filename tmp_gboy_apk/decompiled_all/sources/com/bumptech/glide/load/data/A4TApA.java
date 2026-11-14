package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA implements AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f9975AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f9976AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Comparable f9977AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Object f9978AzWtSf;

    public /* synthetic */ A4TApA(int i, Comparable comparable, Object obj) {
        this.f9975AcNBzu = i;
        this.f9978AzWtSf = obj;
        this.f9977AmA8tU = comparable;
    }

    private final void A4TApA() {
    }

    private final void A5SV6n() {
    }

    public abstract void ADYaiT(Object obj);

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        switch (this.f9975AcNBzu) {
            case 0:
                Object obj = this.f9976AlLFFp;
                if (obj != null) {
                    try {
                        ADYaiT(obj);
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            default:
                Object obj2 = this.f9976AlLFFp;
                if (obj2 != null) {
                    try {
                        ADYaiT(obj2);
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, ADYaiT aDYaiT) {
        switch (this.f9975AcNBzu) {
            case 0:
                try {
                    Object AYUAbz2 = AYUAbz((AssetManager) this.f9978AzWtSf, (String) this.f9977AmA8tU);
                    this.f9976AlLFFp = AYUAbz2;
                    aDYaiT.ASJ6gh(AYUAbz2);
                    break;
                } catch (IOException e) {
                    Log.isLoggable("AssetPathFetcher", 3);
                    aDYaiT.A5SV6n(e);
                }
            default:
                try {
                    Object ASJ6gh2 = ASJ6gh((ContentResolver) this.f9978AzWtSf, (Uri) this.f9977AmA8tU);
                    this.f9976AlLFFp = ASJ6gh2;
                    aDYaiT.ASJ6gh(ASJ6gh2);
                    break;
                } catch (FileNotFoundException e2) {
                    Log.isLoggable("LocalUriFetcher", 3);
                    aDYaiT.A5SV6n(e2);
                    return;
                }
        }
    }

    public abstract Object ASJ6gh(ContentResolver contentResolver, Uri uri);

    public abstract Object AYUAbz(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        int i = this.f9975AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        switch (this.f9975AcNBzu) {
        }
        return 1;
    }
}
