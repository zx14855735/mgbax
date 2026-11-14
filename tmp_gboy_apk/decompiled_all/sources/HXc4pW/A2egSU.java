package HXc4pW;

import android.os.Process;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3486AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Runnable f3487AlLFFp;

    public /* synthetic */ A2egSU(int i, Runnable runnable) {
        this.f3486AcNBzu = i;
        this.f3487AlLFFp = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3486AcNBzu) {
            case 0:
                Process.setThreadPriority(10);
                this.f3487AlLFFp.run();
                break;
            default:
                Process.setThreadPriority(0);
                this.f3487AlLFFp.run();
                break;
        }
    }
}
