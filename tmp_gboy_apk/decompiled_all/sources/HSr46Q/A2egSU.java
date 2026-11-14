package HSr46Q;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements ADYaiT {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final String[] f3474A4TApA = {"_data"};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ContentResolver f3475A2egSU;

    static {
        izFb();
    }

    public A2egSU(ContentResolver contentResolver) {
        this.f3475A2egSU = contentResolver;
    }

    private static /* synthetic */ void izFb() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSr46Q.ADYaiT
    public Cursor query(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.f3475A2egSU.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f3474A4TApA, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
    }
}
