package com.bytedance.pangle.util.hf.xj;

import com.bytedance.pangle.util.hf.hf.u;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private void hf(RandomAccessFile randomAccessFile, u uVar) {
        com.bytedance.pangle.util.hf.hf.xj xjVar = new com.bytedance.pangle.util.hf.hf.xj();
        ArrayList arrayList = new ArrayList();
        long hf = uVar.hf().hf();
        long xj = uVar.hf().xj();
        randomAccessFile.seek(hf);
        for (int i = 0; i < xj; i++) {
            com.bytedance.pangle.util.hf.hf.w wVar = new com.bytedance.pangle.util.hf.hf.w();
            if (uVar.u().xj(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            wVar.xj(uVar.u().hf(randomAccessFile));
            randomAccessFile.skipBytes(4);
            wVar.xj(uVar.u().xj(randomAccessFile));
            wVar.hf(uVar.u().xj(randomAccessFile));
            wVar.w(uVar.u().xj(randomAccessFile));
            int hf2 = uVar.u().hf(randomAccessFile);
            wVar.w(hf2);
            wVar.u(uVar.u().hf(randomAccessFile));
            int hf3 = uVar.u().hf(randomAccessFile);
            randomAccessFile.skipBytes(8);
            wVar.u(uVar.u().xj(randomAccessFile));
            if (hf2 <= 0) {
                throw new IOException("Invalid entry name in file header");
            }
            byte[] bArr = new byte[hf2];
            randomAccessFile.readFully(bArr);
            wVar.xj(xj(bArr));
            randomAccessFile.skipBytes(wVar.p());
            if (hf3 > 0) {
                randomAccessFile.skipBytes(hf3);
            }
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(wVar.g() + 28);
            wVar.hf(uVar.u().hf(randomAccessFile));
            randomAccessFile.seek(filePointer);
            arrayList.add(wVar);
        }
        xjVar.xj(arrayList);
        uVar.xj(xjVar);
    }

    private long u(RandomAccessFile randomAccessFile, u uVar) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (uVar.u().xj(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private long w(RandomAccessFile randomAccessFile, u uVar) {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) uVar.u().xj(randomAccessFile)) == 101010256 ? j : u(randomAccessFile, uVar);
    }

    public u xj(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() < 22) {
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            }
            u uVar = new u(str);
            xj(randomAccessFile, uVar);
            if (uVar.hf().xj() != 0) {
                hf(randomAccessFile, uVar);
            }
            try {
                randomAccessFile.close();
                return uVar;
            } catch (IOException unused) {
                return uVar;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private void xj(RandomAccessFile randomAccessFile, u uVar) {
        randomAccessFile.seek(w(randomAccessFile, uVar) + 4);
        com.bytedance.pangle.util.hf.hf.hf hfVar = new com.bytedance.pangle.util.hf.hf.hf();
        randomAccessFile.skipBytes(6);
        hfVar.xj(uVar.u().hf(randomAccessFile));
        randomAccessFile.skipBytes(4);
        hfVar.xj(uVar.u().xj(randomAccessFile));
        uVar.xj(hfVar);
    }

    private String xj(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
