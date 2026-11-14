package okhttp3.internal.http2;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.util.Locale;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT {
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);

    static {
        ghwp();
    }

    public ADYaiT(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    private static /* synthetic */ void ghwp() {
        char[] charArray = "ÙÕ×\u0094ÝÛ×ß\u0094ØÕÃ\u0094ÉÒßÖÖ\u0094ðÔÓøÈÓÞÝß".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 186);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÙÖÓÔÓÎ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 186);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ADYaiT) {
            ADYaiT aDYaiT = (ADYaiT) obj;
            if (this.name.equals(aDYaiT.name) && this.value.equals(aDYaiT.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() + ((this.name.hashCode() + 527) * 31);
    }

    public final String toString() {
        String utf8 = this.name.utf8();
        String utf82 = this.value.utf8();
        byte[] bArr = okhttp3.internal.A5SV6n.EMPTY_BYTE_ARRAY;
        Locale locale = Locale.US;
        return CtFAbx.AlLFFp(utf8, ": ", utf82);
    }

    public ADYaiT(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public ADYaiT(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.size() + byteString.size() + 32;
    }
}
