package com.kwad.sdk.core.videocache.a;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class d {

    public static final class a implements Comparator<File> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void u(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException(A2egSU.AlLFFp("File ", file, " is not directory!"));
            }
        } else if (!file.mkdirs()) {
            throw new IOException(CtFAbx.BI9f7h("Directory ", file.getAbsolutePath(), " can't be created"));
        }
    }

    public static List<File> v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a((byte) 0));
        return asList;
    }

    public static void w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            x(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.d.c.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    private static void x(File file) {
        RandomAccessFile randomAccessFile;
        long j;
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rwd");
                j = length - 1;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            randomAccessFile.seek(j);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(readByte);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
        } catch (IOException e2) {
            e = e2;
            randomAccessFile2 = randomAccessFile;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
            throw th;
        }
    }

    private static void y(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException(CtFAbx.AYUAbz(file, "Error recreate zero-size file "));
        }
    }
}
