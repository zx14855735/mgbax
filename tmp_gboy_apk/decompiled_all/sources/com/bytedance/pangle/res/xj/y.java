package com.bytedance.pangle.res.xj;

import java.io.DataInput;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class y implements DataInput {
    public final d xj;

    public y(d dVar) {
        this.xj = dVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.xj.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.xj.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.xj.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.xj.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.xj.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.xj.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.xj.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.xj.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.xj.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.xj.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.xj.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.xj.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.xj.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.xj.skipBytes(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.xj.readFully(bArr);
    }
}
