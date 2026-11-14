package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaeaaaa;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaeaaaa;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa {
    private byte[] aaaaaaac;
    private byte[] aaaaaaao;
    private static final byte[] aaaaaaau = {42};
    private static final String[] aaaaaaan = new String[0];
    private static final String[] aaaaaaae = {"*"};
    private static final aaaaaaaa aaaaaaav = new aaaaaaaa();
    private final AtomicBoolean aaaaaaaa = new AtomicBoolean(false);
    private final CountDownLatch aaaaaaa0 = new CountDownLatch(1);

    static {
        zhxckZc();
    }

    private void aaaaaaa0() {
        InputStream resourceAsStream = aaaaaaaa.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        aaaaaaau aaaaaaaa = aaaaaeaa.aaaaaaaa(new aaaeaaaa(aaaaaeaa.aaaaaaaa(resourceAsStream)));
        try {
            byte[] bArr = new byte[aaaaaaaa.readInt()];
            aaaaaaaa.readFully(bArr);
            byte[] bArr2 = new byte[aaaaaaaa.readInt()];
            aaaaaaaa.readFully(bArr2);
            synchronized (this) {
                this.aaaaaaao = bArr;
                this.aaaaaaac = bArr2;
            }
            this.aaaaaaa0.countDown();
        } finally {
            aaaaaaao.aaaaaaaa(aaaaaaaa);
        }
    }

    public static aaaaaaaa aaaaaaaa() {
        return aaaaaaav;
    }

    private void aaaaaaao() {
        boolean z = false;
        while (true) {
            try {
                try {
                    aaaaaaa0();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    aaaaaaan.aaaaaaa0().aaaaaaaa(5, "Failed to read public suffix list", e);
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

    private static /* synthetic */ void zhxckZc() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String aaaaaaaa(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] aaaaaaaa = aaaaaaaa(split);
        if (split.length == aaaaaaaa.length && aaaaaaaa[0].charAt(0) != '!') {
            return null;
        }
        if (aaaaaaaa[0].charAt(0) == '!') {
            length = split.length;
            length2 = aaaaaaaa.length;
        } else {
            length = split.length;
            length2 = aaaaaaaa.length + 1;
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

    private String[] aaaaaaaa(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i = 0;
        if (!this.aaaaaaaa.get() && this.aaaaaaaa.compareAndSet(false, true)) {
            aaaaaaao();
        } else {
            try {
                this.aaaaaaa0.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.aaaaaaao == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(aaaaaaao.aaaeaaaa);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = aaaaaaaa(this.aaaaaaao, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = aaaaaaau;
                str3 = aaaaaaaa(this.aaaaaaao, bArr2, i4);
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
                String aaaaaaaa = aaaaaaaa(this.aaaaaaac, bArr, i);
                if (aaaaaaaa != null) {
                    str = aaaaaaaa;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return "!".concat(str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return aaaaaaae;
        }
        if (str2 != null) {
            strArr2 = str2.split("\\.");
        } else {
            strArr2 = aaaaaaan;
        }
        if (str3 != null) {
            strArr3 = str3.split("\\.");
        } else {
            strArr3 = aaaaaaan;
        }
        return strArr2.length > strArr3.length ? strArr2 : strArr3;
    }

    private static String aaaaaaaa(byte[] bArr, byte[][] bArr2, int i) {
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
                            return new String(bArr, i7, i9, aaaaaaao.aaaeaaaa);
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
