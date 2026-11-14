package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ADYaiT implements ThreadFactory {
    final /* synthetic */ boolean val$daemon;
    final /* synthetic */ String val$name;

    public ADYaiT(String str, boolean z) {
        this.val$name = str;
        this.val$daemon = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.val$name);
        thread.setDaemon(this.val$daemon);
        return thread;
    }
}
