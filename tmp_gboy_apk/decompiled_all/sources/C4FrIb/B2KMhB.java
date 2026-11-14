package C4FrIb;

import android.os.Process;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f1580AcNBzu;

    public B2KMhB(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f1580AcNBzu = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f1580AcNBzu);
        super.run();
    }
}
