package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f implements Executor {
    private Runnable bhJ;
    private Runnable bhK;

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.bhK;
        this.bhJ = runnable;
        this.bhK = null;
        if (runnable != null) {
            d.getExecutor().execute(this.bhJ);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.bhJ == null) {
            this.bhJ = d(runnable);
            d.getExecutor().execute(this.bhJ);
        } else {
            if (this.bhK == null) {
                this.bhK = d(runnable);
            }
        }
    }
}
