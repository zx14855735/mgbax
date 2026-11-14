package Hjvs0g;

import android.content.ContentResolver;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CQhlFr implements BIYEnU, CSDoyG {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3771AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ContentResolver f3772AlLFFp;

    public /* synthetic */ CQhlFr(ContentResolver contentResolver, int i) {
        this.f3771AcNBzu = i;
        this.f3772AlLFFp = contentResolver;
    }

    @Override // Hjvs0g.BIYEnU
    public final BI9f7h AYUAbz(BmvVmW bmvVmW) {
        switch (this.f3771AcNBzu) {
        }
        return new CTkVKb(this);
    }

    @Override // Hjvs0g.CSDoyG
    public final com.bumptech.glide.load.data.AMqCpz AaHO0E(Uri uri) {
        switch (this.f3771AcNBzu) {
            case 0:
                return new com.bumptech.glide.load.data.A2egSU(this.f3772AlLFFp, uri, 0);
            default:
                return new com.bumptech.glide.load.data.B25kr6(1, uri, this.f3772AlLFFp);
        }
    }
}
