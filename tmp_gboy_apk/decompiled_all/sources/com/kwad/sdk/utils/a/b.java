package com.kwad.sdk.utils.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] bgU;
    public byte[] bgV;
    public int position;

    static {
        tlfUdst();
    }

    public b(int i) {
        this(new byte[i], 0);
    }

    private int F(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.bgV[i] = (byte) ((i2 & 127) | r.b.d);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.bgV[i] = (byte) i2;
        return i3;
    }

    public static int fs(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    private char[] fu(int i) {
        char[] cArr = this.bgU;
        if (cArr == null) {
            if (i <= 256) {
                this.bgU = new char[256];
            } else {
                this.bgU = new char[2048];
            }
        } else if (cArr.length < i) {
            this.bgU = new char[2048];
        }
        return this.bgU;
    }

    private String fv(int i) {
        if (i > 2048) {
            return new String(this.bgV, this.position, i, UTF_8);
        }
        char[] fu = fu(i);
        byte[] bArr = this.bgV;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                fu[i4] = (char) (b ^ 1);
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                fu[i4] = (char) ((bArr[i5] & 63) | ((b & 31) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                i2 += 3;
                fu[i4] = (char) (((bArr[i5] & 63) << 6) | ((b & 15) << 12) | (bArr[i6] & 63));
                i4++;
            } else {
                byte b2 = bArr[i5];
                int i7 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i8 = ((b2 & 63) << 12) | ((b & 7) << 18) | ((b3 & 63) << 6) | (bArr[i7] & 63);
                int i9 = i4 + 1;
                fu[i4] = (char) ((i8 >>> 10) + 55232);
                i4 += 2;
                fu[i9] = (char) ((i8 & 1023) + 56320);
            }
        }
        if (i2 <= i3) {
            return new String(fu, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String fw(int i) {
        if (i > 2048) {
            return new String(this.bgV, this.position, i, UTF_8);
        }
        char[] fu = fu(i);
        byte[] bArr = this.bgV;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                fu[i4] = (char) b;
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                fu[i4] = (char) ((bArr[i5] & 63) | ((b & 31) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                i2 += 3;
                fu[i4] = (char) (((bArr[i5] & 63) << 6) | ((b & 15) << 12) | (bArr[i6] & 63));
                i4++;
            } else {
                byte b2 = bArr[i5];
                int i7 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i8 = ((b2 & 63) << 12) | ((b & 7) << 18) | ((b3 & 63) << 6) | (bArr[i7] & 63);
                int i9 = i4 + 1;
                fu[i4] = (char) ((i8 >>> 10) + 55232);
                i4 += 2;
                fu[i9] = (char) ((i8 & 1023) + 56320);
            }
        }
        if (i2 <= i3) {
            return new String(fu, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i) {
        byte[] bArr = this.bgV;
        return (bArr[i + 7] << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((255 & bArr[i + 6]) << 48);
    }

    public static int hU(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                i += 2;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private void hV(String str) {
        byte[] bArr = this.bgV;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) (charAt ^ 1);
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                i += 2;
                bArr[i4] = (byte) ((charAt & '?') | r.b.d);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i5 = i + 2;
                bArr[i + 1] = (byte) (((charAt >>> 6) & 63) | r.b.d);
                i += 3;
                bArr[i5] = (byte) ((charAt & '?') | r.b.d);
            } else {
                i2 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((charAt2 >>> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                bArr[i + 1] = (byte) (((charAt2 >>> 12) & 63) | r.b.d);
                int i6 = i + 3;
                bArr[i + 2] = (byte) (((charAt2 >>> 6) & 63) | r.b.d);
                i += 4;
                bArr[i6] = (byte) ((charAt2 & 63) | r.b.d);
            }
            i2 = i3;
        }
        this.position = i;
    }

    public static byte[] hW(String str) {
        byte[] bArr = new byte[hU(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i2++;
            } else if (charAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                i2 += 2;
                bArr[i4] = (byte) ((charAt & '?') | r.b.d);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i5 = i2 + 2;
                bArr[i2 + 1] = (byte) (((charAt >>> 6) & 63) | r.b.d);
                i2 += 3;
                bArr[i5] = (byte) ((charAt & '?') | r.b.d);
            } else {
                i += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i2] = (byte) ((charAt2 >>> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                bArr[i2 + 1] = (byte) (((charAt2 >>> 12) & 63) | r.b.d);
                int i6 = i2 + 3;
                bArr[i2 + 2] = (byte) (((charAt2 >>> 6) & 63) | r.b.d);
                i2 += 4;
                bArr[i6] = (byte) ((charAt2 & 63) | r.b.d);
            }
            i = i3;
        }
        return bArr;
    }

    public static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i3++;
                i2 = i4;
            } else if (b < -32) {
                i2 += 2;
                cArr[i3] = (char) ((bArr[i4] & 63) | ((b & 31) << 6));
                i3++;
            } else if (b < -16) {
                int i5 = i2 + 2;
                i2 += 3;
                cArr[i3] = (char) (((bArr[i4] & 63) << 6) | ((b & 15) << 12) | (bArr[i5] & 63));
                i3++;
            } else {
                byte b2 = bArr[i4];
                int i6 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i7 = ((b2 & 63) << 12) | ((b & 7) << 18) | ((b3 & 63) << 6) | (bArr[i6] & 63);
                int i8 = i3 + 1;
                cArr[i3] = (char) ((i7 >>> 10) + 55232);
                i3 += 2;
                cArr[i8] = (char) ((i7 & 1023) + 56320);
            }
        }
        if (i2 <= i) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private static /* synthetic */ void tlfUdst() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void E(int i, int i2) {
        byte[] bArr = this.bgV;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public final long G(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        while (i5 < (i4 << 3)) {
            j ^= (this.bgV[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i8 = (i & 7) << 3;
        return (j >>> (64 - i8)) | (j << i8);
    }

    public final int Ui() {
        byte[] bArr = this.bgV;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] << 7) | (b & Byte.MAX_VALUE);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i + 3;
        this.position = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << 14);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i + 4;
        this.position = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << 21);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.position = i + 5;
        return (bArr[i7] << 28) | (i8 & 268435455);
    }

    public final void a(short s) {
        byte[] bArr = this.bgV;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) s;
        this.position = i + 2;
        bArr[i2] = (byte) (s >> 8);
    }

    public final void bb(long j) {
        f(this.position, j);
        this.position += 8;
    }

    public final void e(byte b) {
        byte[] bArr = this.bgV;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void f(int i, long j) {
        byte[] bArr = this.bgV;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public final void fq(int i) {
        byte[] bArr = this.bgV;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) i;
        int i4 = i2 + 2;
        this.position = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i2 + 3;
        this.position = i5;
        bArr[i4] = (byte) (i >> 16);
        this.position = i2 + 4;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void fr(int i) {
        this.position = F(this.position, i);
    }

    public final String ft(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String fw = fw(i);
        this.position += i;
        return fw;
    }

    public final byte get() {
        byte[] bArr = this.bgV;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.bgV, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.bgV;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.position = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.position = i + 4;
        return (bArr[i6] << 24) | i7;
    }

    public final short getShort() {
        byte[] bArr = this.bgV;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        this.position = i + 2;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String fv = fv(i);
        this.position += i;
        return fv;
    }

    public final void hT(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hV(str);
    }

    public final void k(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.bgV, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public b(byte[] bArr, int i) {
        this.bgU = null;
        this.bgV = bArr;
        this.position = i;
    }
}
