package COJEAR;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class BniPrB implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1654AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ View f1655AlLFFp;

    public /* synthetic */ BniPrB(View view, int i) {
        this.f1654AcNBzu = i;
        this.f1655AlLFFp = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1654AcNBzu) {
            case 0:
                View view = this.f1655AlLFFp;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                break;
            default:
                View view2 = this.f1655AlLFFp;
                ((InputMethodManager) BPw6Q8.ASJ6gh.ADYaiT(view2.getContext(), InputMethodManager.class)).showSoftInput(view2, 1);
                break;
        }
    }
}
