package DjONCG;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2419AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ScrollView f2420AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2421AmA8tU;

    public /* synthetic */ A2egSU(ScrollView scrollView, LinearLayout linearLayout, int i) {
        this.f2419AcNBzu = i;
        this.f2420AlLFFp = scrollView;
        this.f2421AmA8tU = linearLayout;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f2419AcNBzu) {
            case 0:
                ScrollView scrollView = this.f2420AlLFFp;
                scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                scrollView.getLayoutParams().height = this.f2421AmA8tU.getHeight();
                scrollView.requestLayout();
                break;
            default:
                ScrollView scrollView2 = this.f2420AlLFFp;
                scrollView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                scrollView2.getLayoutParams().height = this.f2421AmA8tU.getHeight();
                scrollView2.requestLayout();
                break;
        }
    }
}
