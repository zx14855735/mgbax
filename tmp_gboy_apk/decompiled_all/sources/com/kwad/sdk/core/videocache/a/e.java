package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService aQt = GlobalThreadPools.Le();

    public class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: Iz, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.z(this.file);
            return null;
        }
    }

    private void E(List<File> list) {
        long F = F(list);
        list.size();
        for (File file : list) {
            if (!aL(F)) {
                long length = file.length();
                if (file.delete()) {
                    F -= length;
                } else {
                    com.kwad.sdk.core.d.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long F(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) {
        d.w(file);
        E(d.v(file.getParentFile()));
    }

    public abstract boolean aL(long j);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.aQt.submit(new a(file));
    }
}
