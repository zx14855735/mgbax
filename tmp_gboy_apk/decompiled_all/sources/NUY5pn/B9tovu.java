package NUY5pn;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends BChYOn {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Intent f5973AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final GoogleApiActivity f5974AlLFFp;

    public B9tovu(Intent intent, GoogleApiActivity googleApiActivity) {
        this.f5973AcNBzu = intent;
        this.f5974AlLFFp = googleApiActivity;
    }

    @Override // NUY5pn.BChYOn
    public final void A2egSU() {
        Intent intent = this.f5973AcNBzu;
        if (intent != null) {
            this.f5974AlLFFp.startActivityForResult(intent, 2);
        }
    }
}
