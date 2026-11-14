package com.bytedance.pangle.y;

import B4ZgIw.AYUAbz;
import com.sigmob.sdk.base.views.r;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements Closeable {
    private xj hf;
    private final Map<String, w> kd = new HashMap();
    private w[] u;
    private hf[] w;
    private final FileInputStream xj;

    public static class hf {
        public final long c;
        public final long f;
        public final int hf;
        public final long kd;
        public final long u;
        public final long w;
        public final int xj;
        public final long y;

        private hf(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.xj = byteBuffer.getInt();
                this.w = byteBuffer.getInt();
                this.u = byteBuffer.getInt();
                this.kd = byteBuffer.getInt();
                this.y = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.hf = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                return;
            }
            if (i != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.xj = byteBuffer.getInt();
            this.hf = byteBuffer.getInt();
            this.w = byteBuffer.getLong();
            this.u = byteBuffer.getLong();
            this.kd = byteBuffer.getLong();
            this.y = byteBuffer.getLong();
            this.c = byteBuffer.getLong();
            this.f = byteBuffer.getLong();
        }
    }

    public static class w {
        public final int c;
        public final long d;
        public final int f;
        public final int hf;
        public final long kd;
        public String p;
        public final long tf;
        public final long u;
        public final long w;
        public final int xj;
        public final long y;

        private w(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.xj = byteBuffer.getInt();
                this.hf = byteBuffer.getInt();
                this.w = byteBuffer.getInt();
                this.u = byteBuffer.getInt();
                this.kd = byteBuffer.getInt();
                this.y = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.tf = byteBuffer.getInt();
            } else {
                if (i != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
                }
                this.xj = byteBuffer.getInt();
                this.hf = byteBuffer.getInt();
                this.w = byteBuffer.getLong();
                this.u = byteBuffer.getLong();
                this.kd = byteBuffer.getLong();
                this.y = byteBuffer.getLong();
                this.c = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.d = byteBuffer.getLong();
                this.tf = byteBuffer.getLong();
            }
            this.p = null;
        }
    }

    public static class xj {
        public final short am;
        public final long c;
        public final short d;
        public final int f;
        public final short g;
        public final short hf;
        public final long kd;
        public final short p;

        /* renamed from: pl, reason: collision with root package name */
        public final short f10176pl;
        public final short tf;
        public final int u;
        public final short w;
        public final byte[] xj;
        public final long y;

        private xj(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.xj = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] != Byte.MAX_VALUE || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            f.hf(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
            f.hf(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
            ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            f.hf(fileChannel, allocate, "failed to read rest part of ehdr.");
            this.hf = allocate.getShort();
            this.w = allocate.getShort();
            int i = allocate.getInt();
            this.u = i;
            f.hf(i, 1, 1, "bad elf version: " + i);
            byte b = bArr[4];
            if (b == 1) {
                this.kd = allocate.getInt();
                this.y = allocate.getInt();
                this.c = allocate.getInt();
            } else {
                if (b != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.kd = allocate.getLong();
                this.y = allocate.getLong();
                this.c = allocate.getLong();
            }
            this.f = allocate.getInt();
            this.d = allocate.getShort();
            this.tf = allocate.getShort();
            this.p = allocate.getShort();
            this.f10176pl = allocate.getShort();
            this.g = allocate.getShort();
            this.am = allocate.getShort();
        }
    }

    private f(File file) {
        w[] wVarArr;
        this.hf = null;
        this.w = null;
        this.u = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.xj = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.hf = new xj(channel);
        ByteBuffer allocate = ByteBuffer.allocate(r.b.d);
        allocate.limit(this.hf.tf);
        allocate.order(this.hf.xj[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.hf.y);
        this.w = new hf[this.hf.p];
        for (int i = 0; i < this.w.length; i++) {
            hf(channel, allocate, "failed to read phdr.");
            this.w[i] = new hf(allocate, this.hf.xj[4]);
        }
        channel.position(this.hf.c);
        allocate.limit(this.hf.f10176pl);
        this.u = new w[this.hf.g];
        int i2 = 0;
        while (true) {
            wVarArr = this.u;
            if (i2 >= wVarArr.length) {
                break;
            }
            hf(channel, allocate, "failed to read shdr.");
            this.u[i2] = new w(allocate, this.hf.xj[4]);
            i2++;
        }
        short s = this.hf.am;
        if (s > 0) {
            ByteBuffer xj2 = xj(wVarArr[s]);
            for (w wVar : this.u) {
                xj2.position(wVar.xj);
                String xj3 = xj(xj2);
                wVar.p = xj3;
                this.kd.put(xj3, wVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, " Rest bytes insufficient, expect to read ");
        A5SV6n2.append(byteBuffer.limit());
        A5SV6n2.append(" bytes but only ");
        A5SV6n2.append(read);
        A5SV6n2.append(" bytes were read.");
        throw new IOException(A5SV6n2.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.xj.close();
        this.kd.clear();
        this.w = null;
        this.u = null;
    }

    public static boolean xj(File file) {
        try {
            com.bytedance.pangle.util.c.xj(new f(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.c.xj((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.c.xj((Closeable) null);
            throw th;
        }
    }

    private static String xj(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer xj(w wVar) {
        ByteBuffer allocate = ByteBuffer.allocate((int) wVar.y);
        this.xj.getChannel().position(wVar.kd);
        hf(this.xj.getChannel(), allocate, "failed to read section: " + wVar.p);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(int i, int i2, int i3, String str) {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }
}
