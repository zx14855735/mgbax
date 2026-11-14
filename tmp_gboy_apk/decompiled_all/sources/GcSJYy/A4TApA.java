package GcSJYy;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends FutureTask {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3065AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3066AlLFFp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A4TApA(Object obj, Callable callable, int i) {
        super(callable);
        this.f3065AcNBzu = i;
        this.f3066AlLFFp = obj;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        switch (this.f3065AcNBzu) {
            case 0:
                AMqCpz aMqCpz = (AMqCpz) this.f3066AlLFFp;
                super.done();
                try {
                    AMqCpz.f3070ADYaiT.obtainMessage(1, new A5SV6n(aMqCpz, get())).sendToTarget();
                    return;
                } catch (InterruptedException e) {
                    AMqCpz.f3070ADYaiT.obtainMessage(4, new A5SV6n(aMqCpz, (Exception) e)).sendToTarget();
                    e.printStackTrace();
                    return;
                } catch (CancellationException e2) {
                    AMqCpz.f3070ADYaiT.obtainMessage(3, new A5SV6n(aMqCpz, (Exception) e2)).sendToTarget();
                    e2.printStackTrace();
                    return;
                } catch (ExecutionException e3) {
                    AMqCpz.f3070ADYaiT.obtainMessage(4, new A5SV6n(aMqCpz, (Exception) e3)).sendToTarget();
                    e3.printStackTrace();
                    return;
                } catch (Exception e4) {
                    AMqCpz.f3070ADYaiT.obtainMessage(4, new A5SV6n(aMqCpz, e4)).sendToTarget();
                    e4.printStackTrace();
                    return;
                }
            default:
                QigWB9.AMqCpz aMqCpz2 = (QigWB9.AMqCpz) this.f3066AlLFFp;
                AtomicBoolean atomicBoolean = aMqCpz2.f7718B25kr6;
                try {
                    Object obj = get();
                    if (atomicBoolean.get()) {
                        return;
                    }
                    aMqCpz2.ADYaiT(obj);
                    return;
                } catch (InterruptedException unused) {
                    return;
                } catch (CancellationException unused2) {
                    if (atomicBoolean.get()) {
                        return;
                    }
                    aMqCpz2.ADYaiT(null);
                    return;
                } catch (ExecutionException e5) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e5.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
        }
    }
}
