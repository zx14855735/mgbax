package com.bytedance.sdk.openadsdk.core.p;

import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.tf.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {

    /* renamed from: com.bytedance.sdk.openadsdk.core.p.xj$xj, reason: collision with other inner class name */
    public class CallableC0175xj implements Callable<Void> {
        private final File hf;

        private CallableC0175xj(File file) {
            this.hf = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            xj.this.hf(this.hf);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(File file) {
        try {
            y.hf(file);
        } catch (Throwable unused) {
        }
        List<File> xj = y.xj(file.getParentFile());
        pl.u("splashLoadAd", "LruDiskFile touchInBackground files.size() " + xj.size());
        xj(xj);
    }

    public abstract void xj(List<File> list);

    public abstract boolean xj(long j, int i);

    public abstract boolean xj(File file, long j, int i);

    public void xj(File file) {
        final f fVar = new f(new CallableC0175xj(file), 1, 2);
        c.hf(new d("touch", fVar.xj()) { // from class: com.bytedance.sdk.openadsdk.core.p.xj.1
            @Override // java.lang.Runnable
            public void run() {
                fVar.run();
            }
        });
    }

    public long hf(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }
}
