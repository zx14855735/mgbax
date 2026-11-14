package C4FrIb;

import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface ADYaiT {
    void close();

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
}
