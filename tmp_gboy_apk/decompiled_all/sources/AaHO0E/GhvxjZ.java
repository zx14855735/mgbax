package AaHO0E;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import com.qq.e.comm.adevent.AdEventType;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class GhvxjZ implements AZkASS.BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AZkASS.AmA8tU f888AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AZkASS.B25kr6 f889AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Toolbar f890AmA8tU;

    public GhvxjZ(Toolbar toolbar) {
        this.f890AmA8tU = toolbar;
    }

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        if (this.f889AlLFFp != null) {
            AZkASS.AmA8tU amA8tU = this.f888AcNBzu;
            if (amA8tU != null) {
                int size = amA8tU.f498B2KMhB.size();
                for (int i = 0; i < size; i++) {
                    if (this.f888AcNBzu.getItem(i) == this.f889AlLFFp) {
                        return;
                    }
                }
            }
            ASJ6gh(this.f889AlLFFp);
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(AZkASS.BpkvW3 bpkvW3) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ASJ6gh(AZkASS.B25kr6 b25kr6) {
        Toolbar toolbar = this.f890AmA8tU;
        KeyEvent.Callback callback = toolbar.f8227B7CMnp;
        if (callback instanceof AZOQYO.A5SV6n) {
            ((AZkASS.B3GDIM) ((AZOQYO.A5SV6n) callback)).f551AcNBzu.onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f8227B7CMnp);
        toolbar.removeView(toolbar.f8226B4ZgIw);
        toolbar.f8227B7CMnp = null;
        ArrayList arrayList = toolbar.f8248Cd8JRx;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f889AlLFFp = null;
        toolbar.requestLayout();
        b25kr6.f547CTkVKb = false;
        b25kr6.f533BJ7GGh.B25kr6(false);
        toolbar.BI9f7h();
        return true;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        return null;
    }

    @Override // AZkASS.BNL6CD
    public final boolean AZOQYO(AZkASS.B25kr6 b25kr6) {
        Toolbar toolbar = this.f890AmA8tU;
        toolbar.A5SV6n();
        ViewParent parent = toolbar.f8226B4ZgIw.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f8226B4ZgIw);
            }
            toolbar.addView(toolbar.f8226B4ZgIw);
        }
        View actionView = b25kr6.getActionView();
        toolbar.f8227B7CMnp = actionView;
        this.f889AlLFFp = b25kr6;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f8227B7CMnp);
            }
            GnQT2j AYUAbz2 = Toolbar.AYUAbz();
            AYUAbz2.f891A2egSU = (toolbar.f8232BJ7GGh & AdEventType.AD_TICK) | 8388611;
            AYUAbz2.f892A4TApA = 2;
            toolbar.f8227B7CMnp.setLayoutParams(AYUAbz2);
            toolbar.addView(toolbar.f8227B7CMnp);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((GnQT2j) childAt.getLayoutParams()).f892A4TApA != 2 && childAt != toolbar.f8219AcNBzu) {
                toolbar.removeViewAt(childCount);
                toolbar.f8248Cd8JRx.add(childAt);
            }
        }
        toolbar.requestLayout();
        b25kr6.f547CTkVKb = true;
        b25kr6.f533BJ7GGh.B25kr6(false);
        KeyEvent.Callback callback = toolbar.f8227B7CMnp;
        if (callback instanceof AZOQYO.A5SV6n) {
            ((AZkASS.B3GDIM) ((AZOQYO.A5SV6n) callback)).f551AcNBzu.onActionViewExpanded();
        }
        toolbar.BI9f7h();
        return true;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AZkASS.AmA8tU amA8tU) {
        AZkASS.B25kr6 b25kr6;
        AZkASS.AmA8tU amA8tU2 = this.f888AcNBzu;
        if (amA8tU2 != null && (b25kr6 = this.f889AlLFFp) != null) {
            amA8tU2.ADYaiT(b25kr6);
        }
        this.f888AcNBzu = amA8tU;
    }

    @Override // AZkASS.BNL6CD
    public final int getId() {
        return 0;
    }
}
