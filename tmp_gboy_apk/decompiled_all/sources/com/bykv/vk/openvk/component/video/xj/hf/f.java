package com.bykv.vk.openvk.component.video.xj.hf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class f {
    private final RandomAccessFile xj;

    public static class xj extends Exception {
        public xj(Throwable th) {
            super(th);
        }
    }

    public f(File file, String str) {
        try {
            this.xj = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new xj(e);
        }
    }

    public void xj(long j) {
        try {
            this.xj.seek(j);
        } catch (IOException e) {
            throw new xj(e);
        }
    }

    public void xj(byte[] bArr, int i, int i2) {
        try {
            this.xj.write(bArr, i, i2);
        } catch (IOException e) {
            throw new xj(e);
        }
    }

    public int xj(byte[] bArr) {
        try {
            return this.xj.read(bArr);
        } catch (IOException e) {
            throw new xj(e);
        }
    }

    public void xj() {
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(this.xj);
    }
}
