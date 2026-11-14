package K7mCWO;

import com.bytedance.sdk.component.tf.u.w;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends w {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Process f4193AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f4194AlLFFp;

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(this.f4194AlLFFp);
        } catch (InterruptedException e) {
            pl.xj(e);
        }
        Process process = this.f4193AcNBzu;
        if (process != null) {
            process.destroy();
        }
    }
}
