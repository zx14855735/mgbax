package AaHO0E;

import android.os.Handler;
import android.widget.AbsListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F508T2 implements AbsListView.OnScrollListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ FM663C f815A2egSU;

    public F508T2(FM663C fm663c) {
        this.f815A2egSU = fm663c;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            FM663C fm663c = this.f815A2egSU;
            if (fm663c.f845COJEAR.getInputMethodMode() == 2 || fm663c.f845COJEAR.getContentView() == null) {
                return;
            }
            Handler handler = fm663c.f841C2rE4F;
            F1loUV f1loUV = fm663c.f838BV3sI0;
            handler.removeCallbacks(f1loUV);
            f1loUV.run();
        }
    }
}
