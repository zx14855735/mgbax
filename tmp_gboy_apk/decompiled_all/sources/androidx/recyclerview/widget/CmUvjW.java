package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CmUvjW implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f9331AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f9332AlLFFp;

    public /* synthetic */ CmUvjW(int i, Object obj) {
        this.f9331AcNBzu = i;
        this.f9332AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f9332AlLFFp;
        switch (this.f9331AcNBzu) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) obj;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.mIsAttached) {
                        recyclerView.requestLayout();
                        break;
                    } else if (!recyclerView.mLayoutSuppressed) {
                        recyclerView.consumePendingUpdateOperations();
                        break;
                    } else {
                        recyclerView.mLayoutWasDefered = true;
                        break;
                    }
                }
                break;
            case 1:
                BJ7GGh bJ7GGh = (BJ7GGh) obj;
                int i = bJ7GGh.f9275BPw6Q8;
                ValueAnimator valueAnimator = bJ7GGh.f9274BNL6CD;
                if (i == 1) {
                    valueAnimator.cancel();
                } else if (i != 2) {
                }
                bJ7GGh.f9275BPw6Q8 = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
            default:
                ((StaggeredGridLayoutManager) obj).ADYaiT();
                break;
        }
    }
}
