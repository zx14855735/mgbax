package com.ss.android.xj;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements hf {
    private final RandomAccessFile xj;

    public xj(File file) {
        this.xj = new RandomAccessFile(file, t.k);
    }

    @Override // com.ss.android.xj.hf
    public void hf() {
        this.xj.close();
    }

    @Override // com.ss.android.xj.hf
    public long xj() {
        return this.xj.length();
    }

    @Override // com.ss.android.xj.hf
    public int xj(byte[] bArr, int i, int i2) {
        return this.xj.read(bArr, i, i2);
    }

    @Override // com.ss.android.xj.hf
    public void xj(long j, long j2) {
        this.xj.seek(j);
    }
}
