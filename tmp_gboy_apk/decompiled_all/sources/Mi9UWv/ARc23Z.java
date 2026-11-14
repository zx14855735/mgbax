package Mi9UWv;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends RecyclerView.AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f5398A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f5399A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f5400A5SV6n;

    @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f5398A2egSU;
        int i2 = childAdapterPosition % i;
        boolean z = this.f5400A5SV6n;
        int i3 = this.f5399A4TApA;
        if (z) {
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = i3;
            }
            rect.bottom = i3;
            return;
        }
        rect.left = (i2 * i3) / i;
        rect.right = i3 - (((i2 + 1) * i3) / i);
        if (childAdapterPosition >= i) {
            rect.top = i3;
        }
    }
}
