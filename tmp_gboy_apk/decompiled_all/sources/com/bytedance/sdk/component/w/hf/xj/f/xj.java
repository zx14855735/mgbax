package com.bytedance.sdk.component.w.hf.xj.f;

import com.bytedance.sdk.component.w.hf.xj.c.kd;
import com.bytedance.sdk.component.w.hf.xj.w;
import com.bytedance.sdk.component.w.xj.pl;
import com.bytedance.sdk.component.w.xj.tf;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    private byte[] c;
    private byte[] f;
    private final AtomicBoolean kd = new AtomicBoolean(false);
    private final CountDownLatch y = new CountDownLatch(1);
    private static final byte[] xj = {42};
    private static final String[] hf = new String[0];
    private static final String[] w = {"*"};
    private static final xj u = new xj();

    static {
        JIlpvR();
    }

    private static /* synthetic */ void JIlpvR() {
        char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 255);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 255);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void hf() {
        boolean z = false;
        while (true) {
            try {
                try {
                    w();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    kd.hf().xj(5, "Failed to read public suffix list", e);
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private void w() {
        InputStream resourceAsStream = xj.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.w.xj.kd xj2 = pl.xj(new tf(pl.xj(resourceAsStream)));
        try {
            byte[] bArr = new byte[xj2.tf()];
            xj2.xj(bArr);
            byte[] bArr2 = new byte[xj2.tf()];
            xj2.xj(bArr2);
            synchronized (this) {
                this.c = bArr;
                this.f = bArr2;
            }
            this.y.countDown();
        } finally {
            w.xj(xj2);
        }
    }

    public static xj xj() {
        return u;
    }

    public String xj(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] xj2 = xj(split);
        if (split.length == xj2.length && xj2[0].charAt(0) != '!') {
            return null;
        }
        if (xj2[0].charAt(0) == '!') {
            length = split.length;
            length2 = xj2.length;
        } else {
            length = split.length;
            length2 = xj2.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i = length - length2; i < split2.length; i++) {
            sb.append(split2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] xj(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (!this.kd.get() && this.kd.compareAndSet(false, true)) {
            hf();
        } else {
            try {
                this.y.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(w.kd);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = xj(this.c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = xj;
                str3 = xj(this.c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String xj2 = xj(this.f, bArr, i);
                if (xj2 != null) {
                    str = xj2;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return "!".concat(str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return w;
        }
        String[] split = str2 != null ? str2.split("\\.") : hf;
        String[] split2 = str3 != null ? str3.split("\\.") : hf;
        return split.length > split2.length ? split : split2;
    }

    private static String xj(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
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
                if (i4 != 0) {
                    break;
                }
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
                            return new String(bArr, i7, i9, w.kd);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i6;
        }
        return null;
    }
}
