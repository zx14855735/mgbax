package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends A4TApA {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f9974B25kr6;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A2egSU(ContentResolver contentResolver, Uri uri, int i) {
        super(1, uri, contentResolver);
        this.f9974B25kr6 = i;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        switch (this.f9974B25kr6) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // com.bumptech.glide.load.data.A4TApA
    public final void ADYaiT(Object obj) {
        switch (this.f9974B25kr6) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.A4TApA
    public final Object ASJ6gh(ContentResolver contentResolver, Uri uri) {
        switch (this.f9974B25kr6) {
            case 0:
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
                if (openAssetFileDescriptor != null) {
                    return openAssetFileDescriptor;
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
            default:
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uri, t.k);
                if (openAssetFileDescriptor2 != null) {
                    return openAssetFileDescriptor2.getParcelFileDescriptor();
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
    }
}
