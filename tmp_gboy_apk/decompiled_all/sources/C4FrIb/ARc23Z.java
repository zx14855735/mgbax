package C4FrIb;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ContentProviderClient f1552A2egSU;

    public ARc23Z(Context context, Uri uri) {
        this.f1552A2egSU = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    @Override // C4FrIb.ADYaiT
    public final void close() {
        ContentProviderClient contentProviderClient = this.f1552A2egSU;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // C4FrIb.ADYaiT
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        ContentProviderClient contentProviderClient = this.f1552A2egSU;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
