package com.bytedance.pangle.res.xj;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d extends FilterInputStream implements DataInput {
    public d(kd kdVar) {
        super(kdVar);
    }

    private byte hf() {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public static int xj(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        u.xj(this, bArr);
    }

    @Override // java.io.DataInput
    public int readInt() {
        byte hf = hf();
        byte hf2 = hf();
        return xj(hf(), hf(), hf2, hf);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public long readLong() {
        byte hf = hf();
        byte hf2 = hf();
        byte hf3 = hf();
        byte hf4 = hf();
        byte hf5 = hf();
        byte hf6 = hf();
        return xj(hf(), hf(), hf6, hf5, hf4, hf3, hf2, hf);
    }

    @Override // java.io.DataInput
    public short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return xj((byte) 0, (byte) 0, hf(), hf());
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return (int) ((FilterInputStream) this).in.skip(i);
    }

    public static long xj(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (b8 & 255);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        u.xj(this, bArr, i, i2);
    }

    public kd xj() {
        return (kd) ((FilterInputStream) this).in;
    }
}
