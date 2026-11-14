package com.fl.saas.videocache.file;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class Files {

    public static final class LastModifiedComparator implements Comparator<File> {
        private LastModifiedComparator() {
        }

        private int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    public static List<File> getLruListFiles(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new LastModifiedComparator());
        return asList;
    }

    public static void makeDir(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException(A2egSU.AlLFFp("File ", file, " is not directory!"));
            }
        } else if (!file.mkdirs()) {
            throw new IOException(CtFAbx.BI9f7h("Directory ", file.getAbsolutePath(), " can't be created"));
        }
    }

    public static void modify(File file) {
        long length = file.length();
        if (length == 0) {
            recreateZeroSizeFile(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void recreateZeroSizeFile(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException(CtFAbx.AYUAbz(file, "Error recreate zero-size file "));
        }
    }

    public static void setLastModifiedNow(File file) {
        if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        modify(file);
        file.lastModified();
    }
}
