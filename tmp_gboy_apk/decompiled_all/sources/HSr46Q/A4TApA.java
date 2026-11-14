package HSr46Q;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ADYaiT {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final String[] f3476A4TApA = {"_data"};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ContentResolver f3477A2egSU;

    static {
        tCITtq();
    }

    public A4TApA(ContentResolver contentResolver) {
        this.f3477A2egSU = contentResolver;
    }

    private static /* synthetic */ void tCITtq() {
        char[] charArray = "÷ûùºóõùñºöûíºçüñøøºÞúýÖæýðóñ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 148);
        }
        String str = new String(charArray);
        char[] charArray2 = "÷øýúýà".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 148);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSr46Q.ADYaiT
    public Cursor query(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.f3477A2egSU.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f3476A4TApA, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
    }
}
