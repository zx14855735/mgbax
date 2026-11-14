package AZkASS;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BChYOn implements BmvVmW, BNL6CD, AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Rect f558AcNBzu;

    public static int AlLFFp(ListAdapter listAdapter, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean B9tovu(AmA8tU amA8tU) {
        int size = amA8tU.f498B2KMhB.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = amA8tU.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ASJ6gh(B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final boolean AZOQYO(B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AmA8tU amA8tU) {
    }

    public abstract void AcNBzu(AmA8tU amA8tU);

    public abstract void AmA8tU(View view);

    public abstract void AzWtSf(boolean z);

    public abstract void B25kr6(int i);

    public abstract void B2KMhB(int i);

    public abstract void B3GDIM(PopupWindow.OnDismissListener onDismissListener);

    public abstract void B4ZgIw(boolean z);

    public abstract void B7CMnp(int i);

    @Override // AZkASS.BNL6CD
    public final int getId() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (AaHO0E) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (AaHO0E) listAdapter).f487A2egSU.B2KMhB((MenuItem) listAdapter.getItem(i), this, !(this instanceof AYUAbz) ? 0 : 4);
    }
}
