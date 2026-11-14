package com.bytedance.sdk.component.w.hf.xj;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import com.bytedance.sdk.component.w.hf.pz;
import com.bytedance.sdk.component.w.hf.x;
import com.bytedance.sdk.component.w.hf.z;
import com.bytedance.sdk.component.w.xj.kd;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    public static final x u;
    public static final z w;
    public static final byte[] xj;
    public static final String[] hf = new String[0];
    private static final y d = y.hf("efbbbf");
    private static final y tf = y.hf("feff");
    private static final y p = y.hf("fffe");

    /* renamed from: pl, reason: collision with root package name */
    private static final y f10240pl = y.hf("0000ffff");
    private static final y g = y.hf("ffff0000");
    public static final Charset kd = Charset.forName("UTF-8");
    public static final Charset y = Charset.forName(CharEncoding.ISO_8859_1);
    private static final Charset am = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset qt = Charset.forName(CharEncoding.UTF_16LE);
    private static final Charset zg = Charset.forName("UTF-32BE");
    private static final Charset e = Charset.forName("UTF-32LE");
    public static final TimeZone c = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> f = new Comparator<String>() { // from class: com.bytedance.sdk.component.w.hf.xj.w.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern yo = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        xj = bArr;
        w = z.xj(null, bArr);
        u = x.xj((pz) null, bArr);
        JdZkhh();
    }

    private static /* synthetic */ void JdZkhh() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf(v vVar, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long o_ = vVar.xj().w() ? vVar.xj().o_() - nanoTime : Long.MAX_VALUE;
        vVar.xj().xj(Math.min(o_, timeUnit.toNanos(i)) + nanoTime);
        try {
            com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
            while (vVar.xj(wVar, 8192L) != -1) {
                wVar.yo();
            }
            if (o_ == Long.MAX_VALUE) {
                vVar.xj().y();
                return true;
            }
            vVar.xj().xj(nanoTime + o_);
            return true;
        } catch (InterruptedIOException unused) {
            if (o_ == Long.MAX_VALUE) {
                vVar.xj().y();
                return false;
            }
            vVar.xj().xj(nanoTime + o_);
            return false;
        } catch (Throwable th) {
            if (o_ == Long.MAX_VALUE) {
                vVar.xj().y();
            } else {
                vVar.xj().xj(nanoTime + o_);
            }
            throw th;
        }
    }

    private static boolean u(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String w(String str, int i, int i2) {
        int xj2 = xj(str, i, i2);
        return str.substring(xj2, hf(str, xj2, i2));
    }

    public static int xj(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    public static void xj(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean xj(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress u(java.lang.String r12, int r13, int r14) {
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
            if (r13 >= r14) goto L78
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
            goto L78
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
            boolean r12 = xj(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L78
        L4a:
            return r7
        L4b:
            r13 = r6
            r8 = 0
        L4d:
            if (r13 >= r14) goto L5f
            char r10 = r12.charAt(r13)
            int r10 = xj(r10)
            if (r10 == r3) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L5f:
            int r10 = r13 - r6
            if (r10 == 0) goto L77
            r11 = 4
            if (r10 <= r11) goto L67
            goto L77
        L67:
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
        L77:
            return r7
        L78:
            if (r4 == r0) goto L89
            if (r5 != r3) goto L7d
            return r7
        L7d:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L89:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8e
            return r12
        L8e:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.w.u(java.lang.String, int, int):java.net.InetAddress");
    }

    public static boolean w(String str) {
        return yo.matcher(str).matches();
    }

    public static void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void xj(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!xj(e2)) {
                    throw e2;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean xj(v vVar, int i, TimeUnit timeUnit) {
        try {
            return hf(vVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> xj(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> xj(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory xj(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.w.hf.xj.w.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(runnable, "csj_" + str);
                wVar.setDaemon(z);
                wVar.setPriority(10);
                return wVar;
            }
        };
    }

    public static String[] xj(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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

    public static boolean hf(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    public static int hf(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String xj(com.bytedance.sdk.component.w.hf.v vVar, boolean z) {
        String c2;
        if (vVar.c().contains(":")) {
            c2 = "[" + vVar.c() + "]";
        } else {
            c2 = vVar.c();
        }
        if (!z && vVar.f() == com.bytedance.sdk.component.w.hf.v.xj(vVar.w())) {
            return c2;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(c2, ":");
        A5SV6n2.append(vVar.f());
        return A5SV6n2.toString();
    }

    public static int hf(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean xj(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int xj(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] xj(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static int xj(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int xj(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int xj(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String xj(String str) {
        InetAddress u2;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                u2 = u(str, 1, str.length() - 1);
            } else {
                u2 = u(str, 0, str.length());
            }
            if (u2 == null) {
                return null;
            }
            byte[] address = u2.getAddress();
            if (address.length == 16) {
                return xj(address);
            }
            throw new AssertionError(CtFAbx.BI9f7h("Invalid IPv6 address: '", str, "'"));
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (u(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String xj(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset xj(kd kdVar, Charset charset) {
        if (kdVar.xj(0L, d)) {
            kdVar.f(r0.c());
            return kd;
        }
        if (kdVar.xj(0L, tf)) {
            kdVar.f(r0.c());
            return am;
        }
        if (kdVar.xj(0L, p)) {
            kdVar.f(r0.c());
            return qt;
        }
        if (kdVar.xj(0L, f10240pl)) {
            kdVar.f(r0.c());
            return zg;
        }
        if (!kdVar.xj(0L, g)) {
            return charset;
        }
        kdVar.f(r0.c());
        return e;
    }

    public static AssertionError xj(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean xj(String str, int i, int i2, byte[] bArr, int i3) {
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

    private static String xj(byte[] bArr) {
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
        com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
        while (i2 < bArr.length) {
            if (i2 == i) {
                wVar.d(58);
                i2 += i4;
                if (i2 == 16) {
                    wVar.d(58);
                }
            } else {
                if (i2 > 0) {
                    wVar.d(58);
                }
                wVar.p(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return wVar.qt();
    }
}
