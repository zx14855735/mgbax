package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaan implements Serializable, Comparable {
    static final char[] aaaaaaac = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final aaaaaaan aaaaaaau = aaaaaaaa(new byte[0]);
    transient int aaaaaaa0;
    final byte[] aaaaaaaa;
    transient String aaaaaaao;

    public aaaaaaan(byte[] bArr) {
        this.aaaaaaaa = bArr;
    }

    private aaaaaaan aaaaaaa0(String str) {
        try {
            return aaaaaaaa(MessageDigest.getInstance(str).digest(this.aaaaaaaa));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static aaaaaaan aaaaaaaa(byte... bArr) {
        if (bArr != null) {
            return new aaaaaaan((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static aaaaaaan aaaaaaao(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        aaaaaaan aaaaaaanVar = new aaaaaaan(str.getBytes(aaaaaaoa.aaaaaaaa));
        aaaaaaanVar.aaaaaaao = str;
        return aaaaaaanVar;
    }

    public int aaaaaaac() {
        return this.aaaaaaaa.length;
    }

    public String aaaaaaae() {
        String str = this.aaaaaaao;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.aaaaaaaa, aaaaaaoa.aaaaaaaa);
        this.aaaaaaao = str2;
        return str2;
    }

    public byte[] aaaaaaan() {
        return (byte[]) this.aaaaaaaa.clone();
    }

    public aaaaaaan aaaaaaau() {
        int i = 0;
        while (true) {
            byte[] bArr = this.aaaaaaaa;
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
                return new aaaaaaan(bArr2);
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aaaaaaan) {
            aaaaaaan aaaaaaanVar = (aaaaaaan) obj;
            int aaaaaaac2 = aaaaaaanVar.aaaaaaac();
            byte[] bArr = this.aaaaaaaa;
            if (aaaaaaac2 == bArr.length && aaaaaaanVar.aaaaaaaa(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.aaaaaaa0;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.aaaaaaaa);
        this.aaaaaaa0 = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.aaaaaaaa.length == 0) {
            return "[size=0]";
        }
        String aaaaaaae = aaaaaaae();
        int aaaaaaaa = aaaaaaaa(aaaaaaae, 64);
        if (aaaaaaaa != -1) {
            String replace = aaaaaaae.substring(0, aaaaaaaa).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (aaaaaaaa >= aaaaaaae.length()) {
                return CtFAbx.BI9f7h("[text=", replace, "]");
            }
            return "[size=" + this.aaaaaaaa.length + " text=" + replace + "…]";
        }
        if (this.aaaaaaaa.length <= 64) {
            return "[hex=" + aaaaaaa0() + "]";
        }
        return "[size=" + this.aaaaaaaa.length + " hex=" + aaaaaaaa(0, 64).aaaaaaa0() + "…]";
    }

    public String aaaaaaa0() {
        byte[] bArr = this.aaaaaaaa;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = aaaaaaac;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public String aaaaaaaa() {
        return aaaaaaa0.aaaaaaaa(this.aaaaaaaa);
    }

    public static aaaaaaan aaaaaaaa(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((aaaaaaaa(str.charAt(i2)) << 4) + aaaaaaaa(str.charAt(i2 + 1)));
                }
                return aaaaaaaa(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
        }
        throw new IllegalArgumentException("hex == null");
    }

    public aaaaaaan aaaaaaao() {
        return aaaaaaa0(MessageDigestAlgorithms.SHA_256);
    }

    public final boolean aaaaaaa0(aaaaaaan aaaaaaanVar) {
        return aaaaaaaa(0, aaaaaaanVar, 0, aaaaaaanVar.aaaaaaac());
    }

    private static int aaaaaaaa(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public aaaaaaan aaaaaaaa(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.aaaaaaaa;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException(CtFAbx.AZkASS(")", this.aaaaaaaa.length, new StringBuilder("endIndex > length(")));
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new aaaaaaan(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte aaaaaaaa(int i) {
        return this.aaaaaaaa[i];
    }

    public void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        byte[] bArr = this.aaaaaaaa;
        aaaaaaaoVar.write(bArr, 0, bArr.length);
    }

    public boolean aaaaaaaa(int i, aaaaaaan aaaaaaanVar, int i2, int i3) {
        return aaaaaaanVar.aaaaaaaa(i2, this.aaaaaaaa, i, i3);
    }

    public boolean aaaaaaaa(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.aaaaaaaa;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && aaaaaaoa.aaaaaaaa(bArr2, i, bArr, i2, i3);
    }

    @Override // java.lang.Comparable
    /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
    public int compareTo(aaaaaaan aaaaaaanVar) {
        int aaaaaaac2 = aaaaaaac();
        int aaaaaaac3 = aaaaaaanVar.aaaaaaac();
        int min = Math.min(aaaaaaac2, aaaaaaac3);
        for (int i = 0; i < min; i++) {
            int aaaaaaaa = aaaaaaaa(i) & 255;
            int aaaaaaaa2 = aaaaaaanVar.aaaaaaaa(i) & 255;
            if (aaaaaaaa != aaaaaaaa2) {
                return aaaaaaaa < aaaaaaaa2 ? -1 : 1;
            }
        }
        if (aaaaaaac2 == aaaaaaac3) {
            return 0;
        }
        return aaaaaaac2 < aaaaaaac3 ? -1 : 1;
    }

    public static int aaaaaaaa(String str, int i) {
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
