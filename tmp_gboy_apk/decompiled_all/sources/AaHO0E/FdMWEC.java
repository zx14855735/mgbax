package AaHO0E;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FdMWEC extends EdQ5bb {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int f846BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final int f847BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public FOAO9d f848BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AZkASS.B25kr6 f849BPw6Q8;

    public FdMWEC(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.f846BIYEnU = 21;
            this.f847BJ7GGh = 22;
        } else {
            this.f846BIYEnU = 22;
            this.f847BJ7GGh = 21;
        }
    }

    @Override // AaHO0E.EdQ5bb, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        AZkASS.AaHO0E aaHO0E;
        int i;
        int pointToPosition;
        int i2;
        if (this.f848BNL6CD != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i = headerViewListAdapter.getHeadersCount();
                aaHO0E = (AZkASS.AaHO0E) headerViewListAdapter.getWrappedAdapter();
            } else {
                aaHO0E = (AZkASS.AaHO0E) adapter;
                i = 0;
            }
            AZkASS.B25kr6 item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = pointToPosition - i) < 0 || i2 >= aaHO0E.getCount()) ? null : aaHO0E.getItem(i2);
            AZkASS.B25kr6 b25kr6 = this.f849BPw6Q8;
            if (b25kr6 != item) {
                AZkASS.AmA8tU amA8tU = aaHO0E.f487A2egSU;
                if (b25kr6 != null) {
                    this.f848BNL6CD.B9tovu(amA8tU, b25kr6);
                }
                this.f849BPw6Q8 = item;
                if (item != null) {
                    this.f848BNL6CD.AZOQYO(amA8tU, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.f846BIYEnU) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.f847BJ7GGh) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (AZkASS.AaHO0E) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (AZkASS.AaHO0E) adapter).f487A2egSU.A5SV6n(false);
        return true;
    }

    public void setHoverListener(FOAO9d fOAO9d) {
        this.f848BNL6CD = fOAO9d;
    }

    @Override // AaHO0E.EdQ5bb, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
