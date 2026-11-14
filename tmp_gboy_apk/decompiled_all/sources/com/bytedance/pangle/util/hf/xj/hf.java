package com.bytedance.pangle.util.hf.xj;

import com.bytedance.pangle.util.hf.hf.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public void xj(u uVar, RandomAccessFile randomAccessFile) {
        if (uVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                xj(uVar, byteArrayOutputStream2);
                xj(uVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
                randomAccessFile.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void xj(u uVar, ByteArrayOutputStream byteArrayOutputStream) {
        if (uVar.xj() == null || uVar.xj().xj() == null || uVar.xj().xj().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.hf.hf.w> it = uVar.xj().xj().iterator();
        while (it.hasNext()) {
            xj(it.next(), byteArrayOutputStream, uVar.u());
        }
    }

    private void xj(com.bytedance.pangle.util.hf.hf.w wVar, ByteArrayOutputStream byteArrayOutputStream, w wVar2) {
        if (wVar != null) {
            byte[] bArr = {0, 0};
            wVar2.xj((OutputStream) byteArrayOutputStream, 33639248);
            wVar2.xj(byteArrayOutputStream, 0);
            wVar2.xj(byteArrayOutputStream, 0);
            wVar2.xj(byteArrayOutputStream, 0);
            wVar2.xj(byteArrayOutputStream, wVar.xj());
            wVar2.xj(byteArrayOutputStream, 2081);
            wVar2.xj(byteArrayOutputStream, 545);
            wVar2.xj((OutputStream) byteArrayOutputStream, (int) wVar.c());
            wVar2.xj((OutputStream) byteArrayOutputStream, (int) wVar.f());
            wVar2.xj((OutputStream) byteArrayOutputStream, (int) wVar.d());
            byte[] bArr2 = new byte[0];
            if (wVar.pl() != null && wVar.pl().trim().length() > 0) {
                bArr2 = xj(wVar.pl());
            }
            wVar2.xj(byteArrayOutputStream, bArr2.length);
            int p = wVar.p();
            wVar2.xj(byteArrayOutputStream, p);
            wVar2.xj(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            wVar2.xj((OutputStream) byteArrayOutputStream, (int) wVar.g());
            if (bArr2.length > 0) {
                byteArrayOutputStream.write(bArr2);
            }
            if (p > 0) {
                byteArrayOutputStream.write(new byte[p]);
                return;
            }
            return;
        }
        throw new IOException("input parameters is null, cannot write local file header");
    }

    private void xj(u uVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) {
        uVar.u().xj((OutputStream) byteArrayOutputStream, 101010256);
        uVar.u().xj(byteArrayOutputStream, 0);
        uVar.u().xj(byteArrayOutputStream, 0);
        int size = uVar.xj().xj().size();
        uVar.u().xj(byteArrayOutputStream, size);
        uVar.u().xj(byteArrayOutputStream, size);
        uVar.u().xj((OutputStream) byteArrayOutputStream, i);
        uVar.u().xj((OutputStream) byteArrayOutputStream, i2);
        uVar.u().xj(byteArrayOutputStream, 0);
    }

    private byte[] xj(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}
