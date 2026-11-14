package okhttp3.internal.http;

import com.sigmob.sdk.downloader.core.c;
import java.io.EOFException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Response;
import okio.Buffer;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f14071A2egSU = 0;
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    static {
        CGbNJwh();
    }

    private AMqCpz() {
    }

    public static long A2egSU(Response response) {
        String str = response.headers().get(c.e);
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean A4TApA(Response response) {
        if (response.request().method().equals(c.f13360a)) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && A2egSU(response) == -1 && !"chunked".equalsIgnoreCase(response.header(c.h))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x013d, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a1, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList A5SV6n(okhttp3.Headers r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.AMqCpz.A5SV6n(okhttp3.Headers, java.lang.String):java.util.ArrayList");
    }

    public static int ADYaiT(int i, String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String AMqCpz(Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            if (indexOfElement != 0) {
                return buffer.readUtf8(indexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static int ARc23Z(Buffer buffer) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == 61) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    public static int ASJ6gh(int i, String str, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static boolean AYUAbz(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b != 44) {
                if (b != 32 && b != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    public static Set AZOQYO(Headers headers) {
        Set set = Collections.EMPTY_SET;
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    set.add(str.trim());
                }
            }
        }
        return set;
    }

    private static /* synthetic */ void CGbNJwh() {
        char[] charArray = "]QS\u0010Y_S[\u0010\\QG\u0010MV[RR\u0010tPW|LWZY[".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '>');
        }
        String str = new String(charArray);
        char[] charArray2 = "]RWPWJ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '>');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
