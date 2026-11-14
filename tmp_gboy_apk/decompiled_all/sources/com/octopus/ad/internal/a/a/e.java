package com.octopus.ad.internal.a.a;

import com.octopus.ad.internal.utilities.HaoboLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class e implements com.octopus.ad.internal.a.a.a {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f12384a = Executors.newSingleThreadExecutor();

    public class a implements Callable<Void> {
        private final File b;

        public a(File file) {
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.b(this.b);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    public abstract boolean a(File file, long j, int i);

    @Override // com.octopus.ad.internal.a.a.a
    public void a(File file) {
        this.f12384a.submit(new a(file));
    }

    private void a(List<File> list) {
        long b = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                    HaoboLog.i(HaoboLog.lruDiskUsageLogTag, "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    HaoboLog.e(HaoboLog.lruDiskUsageLogTag, "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }
}
