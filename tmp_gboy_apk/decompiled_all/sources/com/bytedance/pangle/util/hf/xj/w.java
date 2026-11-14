package com.bytedance.pangle.util.hf.xj;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private final byte[] xj = new byte[2];
    private final byte[] hf = new byte[4];

    public int hf(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.xj);
        return xj(this.xj);
    }

    public int xj(RandomAccessFile randomAccessFile) {
        randomAccessFile.readFully(this.hf);
        return hf(this.hf);
    }

    private int hf(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public void xj(RandomAccessFile randomAccessFile, int i) {
        xj(this.xj, i);
        randomAccessFile.write(this.xj);
    }

    private void hf(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    public void xj(ByteArrayOutputStream byteArrayOutputStream, int i) {
        xj(this.xj, i);
        byteArrayOutputStream.write(this.xj);
    }

    public void xj(OutputStream outputStream, int i) {
        hf(this.hf, i);
        outputStream.write(this.hf);
    }

    private int xj(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private void xj(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
