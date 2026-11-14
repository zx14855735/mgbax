package com.bytedance.sdk.component.hf.xj.hf;

import ADYaiT.CtFAbx;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements Serializable, Comparable<u> {
    transient int kd;
    final byte[] u;
    transient String y;
    static final char[] xj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset hf = Charset.forName("UTF-8");
    public static final u w = xj(new byte[0]);

    public u(byte[] bArr) {
        this.u = bArr;
    }

    public static u xj(byte... bArr) {
        if (bArr != null) {
            return new u((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            int w2 = uVar.w();
            byte[] bArr = this.u;
            if (w2 == bArr.length && uVar.xj(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.kd;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.u);
        this.kd = hashCode;
        return hashCode;
    }

    public String hf() {
        byte[] bArr = this.u;
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
        if (this.u.length == 0) {
            return "[size=0]";
        }
        String xj2 = xj();
        int xj3 = xj(xj2, 64);
        if (xj3 != -1) {
            String replace = xj2.substring(0, xj3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (xj3 >= xj2.length()) {
                return CtFAbx.BI9f7h("[text=", replace, "]");
            }
            return "[size=" + this.u.length + " text=" + replace + "…]";
        }
        if (this.u.length <= 64) {
            return "[hex=" + hf() + "]";
        }
        return "[size=" + this.u.length + " hex=" + xj(0, 64).hf() + "…]";
    }

    public byte[] u() {
        return (byte[]) this.u.clone();
    }

    public int w() {
        return this.u.length;
    }

    public String xj() {
        String str = this.y;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.u, hf);
        this.y = str2;
        return str2;
    }

    public static u xj(String str) {
        if (str != null) {
            u uVar = new u(str.getBytes(tf.xj));
            uVar.y = str;
            return uVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public u xj(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.u;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException(CtFAbx.AZkASS(")", this.u.length, new StringBuilder("endIndex > length(")));
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new u(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte xj(int i) {
        return this.u[i];
    }

    public boolean xj(int i, u uVar, int i2, int i3) {
        return uVar.xj(i2, this.u, i, i3);
    }

    public boolean xj(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.u;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && tf.xj(bArr2, i, bArr, i2, i3);
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        int w2 = w();
        int w3 = uVar.w();
        int min = Math.min(w2, w3);
        for (int i = 0; i < min; i++) {
            int xj2 = xj(i) & 255;
            int xj3 = uVar.xj(i) & 255;
            if (xj2 != xj3) {
                return xj2 < xj3 ? -1 : 1;
            }
        }
        if (w2 == w3) {
            return 0;
        }
        return w2 < w3 ? -1 : 1;
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
