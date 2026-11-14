package N8W1LJ;

import android.content.Context;
import android.widget.OverScroller;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final OverScroller f5564AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f5565AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f5566AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f5567AzWtSf;

    public AlLFFp(AmA8tU amA8tU, Context context) {
        this.f5567AzWtSf = amA8tU;
        this.f5564AcNBzu = new OverScroller(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverScroller overScroller = this.f5564AcNBzu;
        if (!overScroller.isFinished() && overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            AmA8tU amA8tU = this.f5567AzWtSf;
            amA8tU.f5580BIYEnU.postTranslate(this.f5565AlLFFp - currX, this.f5566AmA8tU - currY);
            amA8tU.A2egSU();
            this.f5565AlLFFp = currX;
            this.f5566AmA8tU = currY;
            amA8tU.f5575B4ZgIw.postOnAnimation(this);
        }
    }
}
