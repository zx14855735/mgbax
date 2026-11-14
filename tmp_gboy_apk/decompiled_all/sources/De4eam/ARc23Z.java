package De4eam;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DG07BK;
import androidx.recyclerview.widget.DRlcZ9;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements DRlcZ9 {
    @Override // androidx.recyclerview.widget.DRlcZ9
    public final void onChildViewAttachedToWindow(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) dg07bk).width != -1 || ((ViewGroup.MarginLayoutParams) dg07bk).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    @Override // androidx.recyclerview.widget.DRlcZ9
    public final void onChildViewDetachedFromWindow(View view) {
    }
}
