package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.A5SV6n;
import okhttp3.internal.platform.ARc23Z;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final String[] EMPTY_RULE = new String[0];
    private static final String[] PREVAILING_RULE = {"*"};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    static {
        gdNdz();
    }

    public static String A2egSU(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, A5SV6n.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i6;
        }
        return null;
    }

    public static PublicSuffixDatabase A4TApA() {
        return instance;
    }

    private static /* synthetic */ void gdNdz() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String A5SV6n(String str) {
        String str2;
        String str3;
        String str4;
        String[] split;
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split2 = IDN.toUnicode(str).split("\\.");
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            ADYaiT();
                            break;
                        } catch (IOException e) {
                            ARc23Z.AZOQYO().AmA8tU(5, "Failed to read public suffix list", e);
                            if (z) {
                            }
                        }
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length3 = split2.length;
        byte[][] bArr = new byte[length3][];
        for (int i = 0; i < split2.length; i++) {
            bArr[i] = split2[i].getBytes(A5SV6n.UTF_8);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= length3) {
                str2 = null;
                break;
            }
            str2 = A2egSU(this.publicSuffixListBytes, bArr, i2);
            if (str2 != null) {
                break;
            }
            i2++;
        }
        if (length3 > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = WILDCARD_LABEL;
                str3 = A2egSU(this.publicSuffixListBytes, bArr2, i3);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            for (int i4 = 0; i4 < length3 - 1; i4++) {
                str4 = A2egSU(this.publicSuffixExceptionListBytes, bArr, i4);
                if (str4 != null) {
                    break;
                }
            }
        }
        str4 = null;
        if (str4 != null) {
            split = "!".concat(str4).split("\\.");
        } else if (str2 == null && str3 == null) {
            split = PREVAILING_RULE;
        } else {
            split = str2 != null ? str2.split("\\.") : EMPTY_RULE;
            String[] split3 = str3 != null ? str3.split("\\.") : EMPTY_RULE;
            if (split.length <= split3.length) {
                split = split3;
            }
        }
        if (split2.length == split.length && split[0].charAt(0) != '!') {
            return null;
        }
        if (split[0].charAt(0) == '!') {
            length = split2.length;
            length2 = split.length;
        } else {
            length = split2.length;
            length2 = split.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split4 = str.split("\\.");
        for (int i5 = length - length2; i5 < split4.length; i5++) {
            sb.append(split4[i5]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public final void ADYaiT() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            synchronized (this) {
                this.publicSuffixListBytes = bArr;
                this.publicSuffixExceptionListBytes = bArr2;
            }
            this.readCompleteLatch.countDown();
        } finally {
            A5SV6n.ARc23Z(buffer);
        }
    }
}
