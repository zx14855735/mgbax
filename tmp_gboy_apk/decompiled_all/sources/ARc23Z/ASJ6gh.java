package ARc23Z;

import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Drawable.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f288AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f289AlLFFp;

    public /* synthetic */ ASJ6gh() {
    }

    private final void A2egSU(Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f288AcNBzu) {
            case 0:
                break;
            default:
                ((DcUJf1.ARc23Z) this.f289AlLFFp).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        switch (this.f288AcNBzu) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f289AlLFFp;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j);
                    break;
                }
                break;
            default:
                ((DcUJf1.ARc23Z) this.f289AlLFFp).scheduleSelf(runnable, j);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f288AcNBzu) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f289AlLFFp;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    break;
                }
                break;
            default:
                ((DcUJf1.ARc23Z) this.f289AlLFFp).unscheduleSelf(runnable);
                break;
        }
    }

    public ASJ6gh(DcUJf1.ARc23Z aRc23Z) {
        this.f289AlLFFp = aRc23Z;
    }
}
