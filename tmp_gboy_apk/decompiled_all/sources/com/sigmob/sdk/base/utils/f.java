package com.sigmob.sdk.base.utils;

import ADYaiT.CtFAbx;
import android.os.AsyncTask;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f {

    public static class a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final File f13216a;
        private final File b;
        private final b c;

        public a(File file, File file2, b bVar) {
            this.f13216a = file2;
            this.b = file;
            this.c = bVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String[] strArr) {
            try {
                f.a(this.f13216a, this.b);
                return Boolean.TRUE;
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(bool.booleanValue());
            }
        }
    }

    public interface b {
        void a(boolean z);
    }

    public static List<File> a(File file, File file2) {
        GZIPInputStream gZIPInputStream;
        com.sigmob.sdk.archives.d dVar;
        com.sigmob.sdk.archives.c a2;
        SigmobLog.i("Untaring " + file.getAbsolutePath() + " to dir " + file2.getAbsolutePath() + ".");
        LinkedList linkedList = new LinkedList();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            gZIPInputStream = new GZIPInputStream(fileInputStream);
        } catch (Throwable th) {
            fileInputStream.close();
            fileInputStream = new FileInputStream(file);
            SigmobLog.e(th.getMessage());
            gZIPInputStream = null;
        }
        if (gZIPInputStream != null) {
            dVar = new com.sigmob.sdk.archives.d();
            a2 = dVar.a("tar", gZIPInputStream);
        } else {
            dVar = new com.sigmob.sdk.archives.d();
            a2 = dVar.a("tar", fileInputStream);
        }
        com.sigmob.sdk.archives.tar.b bVar = (com.sigmob.sdk.archives.tar.b) a2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        while (true) {
            com.sigmob.sdk.archives.tar.a aVar = (com.sigmob.sdk.archives.tar.a) bVar.a();
            if (aVar == null) {
                bVar.close();
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                fileInputStream.close();
                return linkedList;
            }
            File file3 = new File(file2, aVar.a());
            if (aVar.c()) {
                SigmobLog.i("Attempting to write output directory " + file3.getAbsolutePath() + ".");
                if (file3.exists()) {
                    continue;
                } else {
                    SigmobLog.i("Attempting to create output directory " + file3.getAbsolutePath() + ".");
                    if (!file3.mkdirs()) {
                        throw new IllegalStateException(CtFAbx.BI9f7h("Couldn't create directory ", file3.getAbsolutePath(), "."));
                    }
                }
            } else {
                SigmobLog.i("Creating output file " + file3.getAbsolutePath() + ".");
                if (!file3.getParentFile().exists()) {
                    file3.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                com.sigmob.sdk.archives.utils.c.a(bVar, fileOutputStream);
                fileOutputStream.close();
            }
            linkedList.add(file3);
        }
    }

    public static String b(String str) {
        return (str == null || str.isEmpty()) ? str : new String(b(str.getBytes("utf-8")));
    }

    private static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read < 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static void a(File file, File file2, b bVar) {
        new a(file, file2, bVar);
        SigmobLog.d("uncompressTarGzipAsync()  inputFile = [" + file + "], outputDir = [" + file2 + "], unCompressAsyncTaskListener = [" + bVar + "]");
    }

    public static byte[] a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
