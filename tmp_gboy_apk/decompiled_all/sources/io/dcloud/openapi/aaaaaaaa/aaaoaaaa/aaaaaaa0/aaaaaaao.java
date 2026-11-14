package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao {
    public static final byte[] aaaaaaaa;
    public static final aaaaacaa aaaaaaac;
    public static final a0aaaaaa aaaaaaao;
    private static final Pattern aaaaoaaa;
    private static final Method aaaoaaaa;
    public static final String[] aaaaaaa0 = new String[0];
    private static final aaaaaaan aaaaaaau = aaaaaaan.aaaaaaaa("efbbbf");
    private static final aaaaaaan aaaaaaan = aaaaaaan.aaaaaaaa("feff");
    private static final aaaaaaan aaaaaaae = aaaaaaan.aaaaaaaa("fffe");
    private static final aaaaaaan aaaaaaav = aaaaaaan.aaaaaaaa("0000ffff");
    private static final aaaaaaan aaaaaaeo = aaaaaaan.aaaaaaaa("ffff0000");
    public static final Charset aaaeaaaa = Charset.forName("UTF-8");
    public static final Charset aaaaeaaa = Charset.forName(CharEncoding.ISO_8859_1);
    private static final Charset aaaaaeaa = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset aaaaaaea = Charset.forName(CharEncoding.UTF_16LE);
    private static final Charset eaaaaaaa = Charset.forName("UTF-32BE");
    private static final Charset aeaaaaaa = Charset.forName("UTF-32LE");
    public static final TimeZone aoaaaaaa = TimeZone.getTimeZone("GMT");
    public static final Comparator aaoaaaaa = new aaaaaaaa();

    public class aaaaaaa0 implements ThreadFactory {
        final /* synthetic */ boolean aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;

        public aaaaaaa0(String str, boolean z) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.aaaaaaaa);
            thread.setDaemon(this.aaaaaaa0);
            return thread;
        }
    }

    public class aaaaaaaa implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        byte[] bArr = new byte[0];
        aaaaaaaa = bArr;
        Method method = null;
        aaaaaaao = a0aaaaaa.aaaaaaaa(null, bArr);
        aaaaaaac = aaaaacaa.aaaaaaaa(null, bArr);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        aaaoaaaa = method;
        aaaaoaaa = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static boolean aaaaaaa0(aaaaoaaa aaaaoaaaVar, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long aaaaaaao2 = aaaaoaaaVar.aaaaaaa0().aaaaaaac() ? aaaaoaaaVar.aaaaaaa0().aaaaaaao() - nanoTime : Long.MAX_VALUE;
        aaaaoaaaVar.aaaaaaa0().aaaaaaaa(Math.min(aaaaaaao2, timeUnit.toNanos(i)) + nanoTime);
        try {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
            while (aaaaoaaaVar.aaaaaaaa(aaaaaaaoVar, 8192L) != -1) {
                aaaaaaaoVar.aaaaaaeo();
            }
            if (aaaaaaao2 == Long.MAX_VALUE) {
                aaaaoaaaVar.aaaaaaa0().aaaaaaaa();
                return true;
            }
            aaaaoaaaVar.aaaaaaa0().aaaaaaaa(nanoTime + aaaaaaao2);
            return true;
        } catch (InterruptedIOException unused) {
            if (aaaaaaao2 == Long.MAX_VALUE) {
                aaaaoaaaVar.aaaaaaa0().aaaaaaaa();
                return false;
            }
            aaaaoaaaVar.aaaaaaa0().aaaaaaaa(nanoTime + aaaaaaao2);
            return false;
        } catch (Throwable th) {
            if (aaaaaaao2 == Long.MAX_VALUE) {
                aaaaoaaaVar.aaaaaaa0().aaaaaaaa();
            } else {
                aaaaoaaaVar.aaaaaaa0().aaaaaaaa(nanoTime + aaaaaaao2);
            }
            throw th;
        }
    }

    public static int aaaaaaaa(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static String aaaaaaac(String str, int i, int i2) {
        int aaaaaaa02 = aaaaaaa0(str, i, i2);
        return str.substring(aaaaaaa02, aaaaaaao(str, aaaaaaa02, i2));
    }

    public static int aaaaaaao(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static void aaaaaaaa(Throwable th, Throwable th2) {
        Method method = aaaoaaaa;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static int aaaaaaao(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static void aaaaaaaa(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean aaaaaaac(String str) {
        return aaaaoaaa.matcher(str).matches();
    }

    public static boolean aaaaaaaa(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void aaaaaaaa(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void aaaaaaaa(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!aaaaaaaa(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean aaaaaaaa(aaaaoaaa aaaaoaaaVar, int i, TimeUnit timeUnit) {
        try {
            return aaaaaaa0(aaaaoaaaVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static List aaaaaaaa(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static Map aaaaaaaa(Map map) {
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static boolean aaaaaaa0(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List aaaaaaaa(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static ThreadFactory aaaaaaaa(String str, boolean z) {
        return new aaaaaaa0(str, z);
    }

    public static String[] aaaaaaaa(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static int aaaaaaa0(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static boolean aaaaaaa0(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static aaaoaaaa aaaaaaa0(List list) {
        aaaoaaaa.aaaaaaaa aaaaaaaaVar = new aaaoaaaa.aaaaaaaa();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaao aaaaaaaoVar = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaao) it.next();
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaaVar, aaaaaaaoVar.aaaaaaaa.aaaaaaae(), aaaaaaaoVar.aaaaaaa0.aaaaaaae());
        }
        return aaaaaaaaVar.aaaaaaaa();
    }

    public static String aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa aaaaoaaaVar, boolean z) {
        String aaaaaaae2;
        if (aaaaoaaaVar.aaaaaaae().contains(":")) {
            aaaaaaae2 = "[" + aaaaoaaaVar.aaaaaaae() + "]";
        } else {
            aaaaaaae2 = aaaaoaaaVar.aaaaaaae();
        }
        if (!z && aaaaoaaaVar.aaaeaaaa() == io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa.aaaaaaaa(aaaaoaaaVar.aaaaaaea())) {
            return aaaaaaae2;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(aaaaaaae2, ":");
        A5SV6n2.append(aaaaoaaaVar.aaaeaaaa());
        return A5SV6n2.toString();
    }

    public static boolean aaaaaaaa(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int aaaaaaaa(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] aaaaaaaa(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static int aaaaaaaa(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int aaaaaaaa(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String aaaaaaaa(String str) {
        InetAddress aaaaaaaa2;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                aaaaaaaa2 = aaaaaaaa(str, 1, str.length() - 1);
            } else {
                aaaaaaaa2 = aaaaaaaa(str, 0, str.length());
            }
            if (aaaaaaaa2 == null) {
                return null;
            }
            byte[] address = aaaaaaaa2.getAddress();
            if (address.length == 16) {
                return aaaaaaaa(address);
            }
            throw new AssertionError(CtFAbx.BI9f7h("Invalid IPv6 address: '", str, "'"));
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (aaaaaaa0(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String aaaaaaaa(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static AssertionError aaaaaaaa(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress aaaaaaaa(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = aaaaaaaa(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r13 = r6
            r8 = 0
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = aaaaaaaa(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean aaaaaaaa(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String aaaaaaaa(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        while (i2 < bArr.length) {
            if (i2 == i) {
                aaaaaaaoVar.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    aaaaaaaoVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    aaaaaaaoVar.writeByte(58);
                }
                aaaaaaaoVar.aaaaaaaa(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return aaaaaaaoVar.aaaaaeaa();
    }

    public static X509TrustManager aaaaaaaa() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw aaaaaaaa("No System TLS", (Exception) e);
        }
    }
}
