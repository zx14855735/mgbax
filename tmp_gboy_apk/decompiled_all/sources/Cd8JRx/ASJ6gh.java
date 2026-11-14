package Cd8JRx;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements AYUAbz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final InputContentInfo f1782AcNBzu;

    public ASJ6gh(Object obj) {
        this.f1782AcNBzu = (InputContentInfo) obj;
    }

    @Override // Cd8JRx.AYUAbz
    public final Uri A2egSU() {
        return this.f1782AcNBzu.getContentUri();
    }

    @Override // Cd8JRx.AYUAbz
    public final void A5SV6n() {
        this.f1782AcNBzu.requestPermission();
    }

    @Override // Cd8JRx.AYUAbz
    public final Uri ADYaiT() {
        return this.f1782AcNBzu.getLinkUri();
    }

    @Override // Cd8JRx.AYUAbz
    public final Object ASJ6gh() {
        return this.f1782AcNBzu;
    }

    @Override // Cd8JRx.AYUAbz
    public final ClipDescription getDescription() {
        return this.f1782AcNBzu.getDescription();
    }

    public ASJ6gh(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f1782AcNBzu = new InputContentInfo(uri, clipDescription, uri2);
    }
}
