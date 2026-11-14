package com.bytedance.sdk.component.w.xj;

import ADYaiT.CtFAbx;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements Serializable, Comparable<y> {
    transient String kd;
    transient int u;
    final byte[] w;
    static final char[] xj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final y hf = xj(new byte[0]);

    public y(byte[] bArr) {
        this.w = bArr;
    }

    public static y xj(byte... bArr) {
        if (bArr != null) {
            return new y((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public int c() {
        return this.w.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            int c = yVar.c();
            byte[] bArr = this.w;
            if (c == bArr.length && yVar.xj(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte[] f() {
        return (byte[]) this.w.clone();
    }

    public int hashCode() {
        int i = this.u;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.w);
        this.u = hashCode;
        return hashCode;
    }

    public String hf() {
        return hf.xj(this.w);
    }

    public String kd() {
        byte[] bArr = this.w;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = xj;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public String toString() {
        if (this.w.length == 0) {
            return "[size=0]";
        }
        String xj2 = xj();
        int xj3 = xj(xj2, 64);
        if (xj3 != -1) {
            String replace = xj2.substring(0, xj3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (xj3 >= xj2.length()) {
                return CtFAbx.BI9f7h("[text=", replace, "]");
            }
            return "[size=" + this.w.length + " text=" + replace + "…]";
        }
        if (this.w.length <= 64) {
            return "[hex=" + kd() + "]";
        }
        return "[size=" + this.w.length + " hex=" + xj(0, 64).kd() + "…]";
    }

    public y u() {
        return w(MessageDigestAlgorithms.SHA_256);
    }

    public y w() {
        return w(MessageDigestAlgorithms.SHA_1);
    }

    public y y() {
        int i = 0;
        while (true) {
            byte[] bArr = this.w;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new y(bArr2);
            }
            i++;
        }
    }

    public static y hf(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((xj(str.charAt(i2)) << 4) + xj(str.charAt(i2 + 1)));
        }
        return xj(bArr);
    }

    private y w(String str) {
        try {
            return xj(MessageDigest.getInstance(str).digest(this.w));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static y xj(String str) {
        if (str != null) {
            y yVar = new y(str.getBytes(pz.xj));
            yVar.kd = str;
            return yVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String xj() {
        String str = this.kd;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.w, pz.xj);
        this.kd = str2;
        return str2;
    }

    private static int xj(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
        }
        return c - '7';
    }

    public y xj(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.w;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException(CtFAbx.AZkASS(")", this.w.length, new StringBuilder("endIndex > length(")));
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new y(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public int compareTo(y yVar) {
        int c = c();
        int c2 = yVar.c();
        int min = Math.min(c, c2);
        for (int i = 0; i < min; i++) {
            int xj2 = xj(i) & 255;
            int xj3 = yVar.xj(i) & 255;
            if (xj2 != xj3) {
                return xj2 < xj3 ? -1 : 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        return c < c2 ? -1 : 1;
    }

    public byte xj(int i) {
        return this.w[i];
    }

    public void xj(w wVar) {
        byte[] bArr = this.w;
        wVar.w(bArr, 0, bArr.length);
    }

    public boolean xj(int i, y yVar, int i2, int i3) {
        return yVar.xj(i2, this.w, i, i3);
    }

    public boolean xj(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.w;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && pz.xj(bArr2, i, bArr, i2, i3);
    }

    public final boolean xj(y yVar) {
        return xj(0, yVar, 0, yVar.c());
    }

    public static int xj(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
