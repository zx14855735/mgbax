package ADYaiT;

import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU implements Executor {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f96AcNBzu;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f96AcNBzu) {
            case 0:
                new Thread(runnable).start();
                break;
            case 1:
                ItGa5w.AlLFFp.AMqCpz().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
