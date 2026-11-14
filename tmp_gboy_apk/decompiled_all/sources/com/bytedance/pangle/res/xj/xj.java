package com.bytedance.pangle.res.xj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final Logger y = Logger.getLogger(xj.class.getName());
    private final f hf;
    private C0093xj kd;
    private final kd u;
    private final c w;
    private final byte[] xj;

    /* renamed from: com.bytedance.pangle.res.xj.xj$xj, reason: collision with other inner class name */
    public static class C0093xj {
        public final int hf;
        public final int kd;
        public final int u;
        public final int w;
        public final short xj;

        public C0093xj(short s, int i, int i2, int i3) {
            this.xj = s;
            this.hf = i;
            this.w = i2;
            this.u = i3;
            this.kd = i3 + i2;
        }

        public static C0093xj xj(c cVar, kd kdVar) {
            int xj = kdVar.xj();
            try {
                return new C0093xj(cVar.readShort(), cVar.readShort(), cVar.readInt(), xj);
            } catch (EOFException unused) {
                return new C0093xj((short) -1, 0, 0, kdVar.xj());
            }
        }
    }

    static {
        MmDuYwE();
    }

    public xj(byte[] bArr, f fVar) {
        kd kdVar = new kd(new ByteArrayInputStream(bArr));
        this.u = kdVar;
        this.w = new c(new d(kdVar));
        this.xj = bArr;
        this.hf = fVar;
    }

    private static /* synthetic */ void MmDuYwE() {
        char[] charArray = "áíï¬åãïç¬àíû¬ñêçîî¬ÈìëÀðëæåç".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 130);
        }
        String str = new String(charArray);
        char[] charArray2 = "áîëìëö".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 130);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void c() {
        if (this.w.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.w.readShort();
        this.w.readInt();
        if ((readShort & 1) == 0) {
            d();
        } else {
            f();
        }
    }

    private void d() {
        this.w.xj((short) 8);
        this.w.xj((byte) 0);
        byte readByte = this.w.readByte();
        int xj = p.xj(this.w);
        int readInt = this.w.readInt();
        if (readByte == 1) {
            p.xj(this.xj, readInt, xj, this.hf);
        }
        if (readByte == 2) {
            p.xj(this.xj, readInt, xj, this.hf);
        }
    }

    private void f() {
        int xj = p.xj(this.w);
        p.xj(this.xj, this.w.readInt(), xj, this.hf);
        int readInt = this.w.readInt();
        for (int i = 0; i < readInt; i++) {
            int xj2 = p.xj(this.w);
            p.xj(this.xj, this.w.readInt(), xj2, this.hf);
            d();
        }
    }

    private void hf() {
        hf(512);
        this.w.readInt();
        this.w.skipBytes(256);
        this.w.xj();
        this.w.xj();
        this.w.xj();
        this.w.xj();
        if (this.kd.hf == 288 && this.w.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        pl.xj(this.w);
        pl.xj(this.w);
        p();
        boolean z = true;
        while (z) {
            short s = this.kd.xj;
            if (s == 514) {
                u();
            } else if (s != 515) {
                z = false;
            } else {
                w();
            }
        }
    }

    private void kd() {
        hf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.w.readUnsignedByte();
        this.w.skipBytes(3);
        this.w.skipBytes(this.w.readInt() * 4);
    }

    private C0093xj p() {
        C0093xj xj = C0093xj.xj(this.w, this.u);
        this.kd = xj;
        return xj;
    }

    private void tf() {
        int readInt = this.w.readInt();
        int i = 28;
        if (readInt < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.w.readShort();
        this.w.readShort();
        this.w.readByte();
        this.w.readByte();
        this.w.readByte();
        this.w.readByte();
        this.w.readByte();
        this.w.readByte();
        this.w.readUnsignedShort();
        this.w.readByte();
        this.w.readByte();
        this.w.readByte();
        this.w.skipBytes(1);
        this.w.readShort();
        this.w.readShort();
        this.w.readShort();
        this.w.skipBytes(2);
        if (readInt >= 32) {
            this.w.readByte();
            this.w.readByte();
            this.w.readShort();
            i = 32;
        }
        if (readInt >= 36) {
            this.w.readShort();
            this.w.readShort();
            i = 36;
        }
        if (readInt >= 48) {
            xj(4).toCharArray();
            xj(8).toCharArray();
            i = 48;
        }
        if (readInt >= 52) {
            this.w.readByte();
            this.w.readByte();
            this.w.skipBytes(2);
            i = 52;
        }
        if (readInt >= 56) {
            this.w.skipBytes(4);
            i = 56;
        }
        int i2 = readInt - 56;
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            i += i2;
            this.w.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                y.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                y.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
            }
        }
        int i3 = readInt - i;
        if (i3 > 0) {
            this.w.skipBytes(i3);
        }
    }

    private void u() {
        kd();
        short s = p().xj;
        while (s == 514) {
            kd();
            s = p().xj;
        }
        while (s == 513) {
            y();
            if (this.u.xj() < this.kd.kd) {
                y.warning("Unknown data detected. Skipping: " + (this.kd.kd - this.u.xj()) + " byte(s)");
                kd kdVar = this.u;
                kdVar.skip((long) (this.kd.kd - kdVar.xj()));
            }
            s = p().xj;
        }
    }

    private void w() {
        hf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int readInt = this.w.readInt();
        for (int i = 0; i < readInt; i++) {
            this.w.readInt();
            this.w.skipBytes(256);
        }
        while (p().xj == 513) {
            u();
        }
    }

    private void y() {
        hf(MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID);
        this.w.readUnsignedByte();
        this.w.readByte();
        this.w.skipBytes(2);
        int readInt = this.w.readInt();
        int readInt2 = this.w.readInt();
        tf();
        int i = (this.kd.u + readInt2) - (readInt * 4);
        if (i != this.u.xj()) {
            y.warning("Invalid data detected. Skipping: " + (i - this.u.xj()) + " byte(s)");
            this.w.skipBytes(i - this.u.xj());
        }
        int[] xj = this.w.xj(readInt);
        HashSet hashSet = new HashSet();
        for (int i2 : xj) {
            if (i2 != -1 && !hashSet.contains(Integer.valueOf(i2))) {
                c();
                hashSet.add(Integer.valueOf(i2));
            }
        }
    }

    public void xj() {
        w(2);
        int readInt = this.w.readInt();
        pl.xj(this.w);
        p();
        for (int i = 0; i < readInt; i++) {
            hf();
        }
    }

    private String xj(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.w.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.w.skipBytes(i2);
        return sb.toString();
    }

    private void w(int i) {
        p();
        hf(i);
    }

    private void hf(int i) {
        if (this.kd.xj != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.kd.xj)));
        }
    }
}
