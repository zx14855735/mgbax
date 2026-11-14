package com.sigmob.sdk.downloader.core.file;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.sigmob.sdk.downloader.core.file.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.sigmob.sdk.downloader.core.file.a {

    /* renamed from: a, reason: collision with root package name */
    final ParcelFileDescriptor f13400a;
    final BufferedOutputStream b;
    final FileOutputStream c;
    private final FileChannel d;

    public static class a implements a.InterfaceC0454a {
        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0454a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, Uri uri, int i) {
            return new b(context, uri, i);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0454a
        public com.sigmob.sdk.downloader.core.file.a a(Context context, File file, int i) {
            return new b(context, Uri.fromFile(file), i);
        }

        @Override // com.sigmob.sdk.downloader.core.file.a.InterfaceC0454a
        public boolean a() {
            return true;
        }
    }

    public b(Context context, Uri uri, int i) {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.f13400a = openFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
        this.c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        this.b = new BufferedOutputStream(fileOutputStream, i);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a() {
        this.b.close();
        this.c.close();
        this.f13400a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b() {
        this.b.flush();
        this.f13400a.getFileDescriptor().sync();
    }

    public b(FileChannel fileChannel, ParcelFileDescriptor parcelFileDescriptor, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream) {
        this.d = fileChannel;
        this.f13400a = parcelFileDescriptor;
        this.c = fileOutputStream;
        this.b = bufferedOutputStream;
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(long j) {
        this.d.position(j);
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void b(long j) {
        try {
            Os.posix_fallocate(this.f13400a.getFileDescriptor(), 0L, j);
        } catch (Throwable th) {
            th = th;
            if (th instanceof ErrnoException) {
                int i = th.errno;
                if (i == OsConstants.ENOSYS || i == OsConstants.ENOTSUP) {
                    com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                    try {
                        Os.ftruncate(this.f13400a.getFileDescriptor(), j);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("It can't pre-allocate length(", j, ") on the sdk version(");
                        B2KMhB2.append(Build.VERSION.SDK_INT);
                        B2KMhB2.append("), because of ");
                        B2KMhB2.append(th);
                        com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", B2KMhB2.toString());
                    }
                }
                return;
            }
            StringBuilder B2KMhB22 = CtFAbx.B2KMhB("It can't pre-allocate length(", j, ") on the sdk version(");
            B2KMhB22.append(Build.VERSION.SDK_INT);
            B2KMhB22.append("), because of ");
            B2KMhB22.append(th);
            com.sigmob.sdk.downloader.core.c.a("DownloadUriOutputStream", B2KMhB22.toString());
        }
    }

    @Override // com.sigmob.sdk.downloader.core.file.a
    public void a(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }
}
