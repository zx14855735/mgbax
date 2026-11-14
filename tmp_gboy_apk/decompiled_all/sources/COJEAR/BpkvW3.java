package COJEAR;

import android.R;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BpkvW3 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final View f1656A2egSU;

    public void A2egSU() {
        View view = this.f1656A2egSU;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void A4TApA() {
        View view;
        View view2 = this.f1656A2egSU;
        if (view2 == null) {
            return;
        }
        if (view2.isInEditMode() || view2.onCheckIsTextEditor()) {
            view2.requestFocus();
            view = view2;
        } else {
            view = view2.getRootView().findFocus();
        }
        if (view == null) {
            view = view2.getRootView().findViewById(R.id.content);
        }
        if (view == null || !view.hasWindowFocus()) {
            return;
        }
        view.post(new BniPrB(view, 0));
    }
}
