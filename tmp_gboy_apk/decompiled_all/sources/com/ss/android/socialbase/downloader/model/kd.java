package com.ss.android.socialbase.downloader.model;

import com.fl.saas.videocache.ProxyCacheUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.tf.y;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd implements Closeable {
    private FileDescriptor hf;
    private RandomAccessFile w;
    private BufferedOutputStream xj;

    public kd(File file, int i) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.w = randomAccessFile;
            this.hf = randomAccessFile.getFD();
            if (i <= 0) {
                this.xj = new BufferedOutputStream(new FileOutputStream(this.w.getFD()));
                return;
            }
            if (i < 8192) {
                i = ProxyCacheUtils.DEFAULT_BUFFER_SIZE;
            } else if (i > 131072) {
                i = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            }
            this.xj = new BufferedOutputStream(new FileOutputStream(this.w.getFD()), i);
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        y.xj(this.w, this.xj);
    }

    public void hf() {
        BufferedOutputStream bufferedOutputStream = this.xj;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void w() {
        FileDescriptor fileDescriptor = this.hf;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void xj(byte[] bArr, int i, int i2) {
        this.xj.write(bArr, i, i2);
    }

    public void xj() {
        BufferedOutputStream bufferedOutputStream = this.xj;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.hf;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void hf(long j) {
        this.w.setLength(j);
    }

    public void xj(long j) {
        this.w.seek(j);
    }
}
