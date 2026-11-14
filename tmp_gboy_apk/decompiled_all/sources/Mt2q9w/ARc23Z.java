package Mt2q9w;

import Oay4Bh.BI9f7h;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import com.game.boy.viewUi.navigationView.ExpandableNavigationView;
import com.google.android.material.internal.NavigationMenuView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5535AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ExpandableNavigationView f5536AlLFFp;

    public /* synthetic */ ARc23Z(ExpandableNavigationView expandableNavigationView, int i) {
        this.f5535AcNBzu = i;
        this.f5536AlLFFp = expandableNavigationView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect rect;
        WindowMetrics currentWindowMetrics;
        switch (this.f5535AcNBzu) {
            case 0:
                ExpandableNavigationView expandableNavigationView = this.f5536AlLFFp;
                expandableNavigationView.f11197CcAIMM.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height = expandableNavigationView.f11197CcAIMM.getHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) expandableNavigationView.f11195CSDoyG.getLayoutParams();
                layoutParams.topMargin = height;
                expandableNavigationView.f11195CSDoyG.setLayoutParams(layoutParams);
                expandableNavigationView.requestLayout();
                break;
            default:
                ExpandableNavigationView expandableNavigationView2 = this.f5536AlLFFp;
                int[] iArr = expandableNavigationView2.f6804BI9f7h;
                expandableNavigationView2.getLocationOnScreen(iArr);
                boolean z = true;
                boolean z2 = iArr[1] == 0;
                BI9f7h bI9f7h = expandableNavigationView2.f6801B7CMnp;
                if (bI9f7h.f6568CASmeH != z2) {
                    bI9f7h.f6568CASmeH = z2;
                    int i = (bI9f7h.f6547AlLFFp.getChildCount() <= 0 && bI9f7h.f6568CASmeH) ? bI9f7h.f6570COJEAR : 0;
                    NavigationMenuView navigationMenuView = bI9f7h.f6546AcNBzu;
                    navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
                }
                expandableNavigationView2.setDrawTopInsetForeground(z2 && expandableNavigationView2.f6807BNL6CD);
                boolean z3 = expandableNavigationView2.getLayoutDirection() == 1;
                int i2 = iArr[0];
                expandableNavigationView2.setDrawLeftInsetForeground((i2 == 0 || expandableNavigationView2.getWidth() + i2 == 0) && (!z3 ? !expandableNavigationView2.f6809BTvldC : !expandableNavigationView2.f6810BV3sI0));
                Activity activity = Oay4Bh.ADYaiT.getActivity(expandableNavigationView2.getContext());
                if (activity != null) {
                    WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                    if (Build.VERSION.SDK_INT >= 30) {
                        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                        rect = currentWindowMetrics.getBounds();
                    } else {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        rect = new Rect();
                        rect.right = point.x;
                        rect.bottom = point.y;
                    }
                    expandableNavigationView2.setDrawBottomInsetForeground((rect.height() - expandableNavigationView2.getHeight() == iArr[1]) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) && expandableNavigationView2.f6808BPw6Q8);
                    if ((rect.width() != iArr[0] && rect.width() - expandableNavigationView2.getWidth() != iArr[0]) || (!z3 ? !expandableNavigationView2.f6810BV3sI0 : !expandableNavigationView2.f6809BTvldC)) {
                        z = false;
                    }
                    expandableNavigationView2.setDrawRightInsetForeground(z);
                    break;
                }
                break;
        }
    }
}
