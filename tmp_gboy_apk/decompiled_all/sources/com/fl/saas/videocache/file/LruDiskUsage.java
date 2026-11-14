package com.fl.saas.videocache.file;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class LruDiskUsage implements DiskUsage {
    private final ExecutorService workerThread = Executors.newSingleThreadExecutor();

    public class TouchCallable implements Callable<Void> {
        private final File file;

        public TouchCallable(File file) {
            this.file = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            LruDiskUsage.this.touchInBackground(this.file);
            return null;
        }
    }

    private long countTotalSize(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void touchInBackground(File file) {
        Files.setLastModifiedNow(file);
        trim(Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(List<File> list) {
        long countTotalSize = countTotalSize(list);
        int size = list.size();
        for (File file : list) {
            if (!accept(file, countTotalSize, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    countTotalSize -= length;
                }
            }
        }
    }

    public abstract boolean accept(File file, long j, int i);

    @Override // com.fl.saas.videocache.file.DiskUsage
    public void touch(File file) {
        this.workerThread.submit(new TouchCallable(file));
    }
}
