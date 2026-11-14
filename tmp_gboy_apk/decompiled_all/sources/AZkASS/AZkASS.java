package AZkASS;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements BNL6CD, AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Context f481AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LayoutInflater f482AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AmA8tU f483AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ExpandedMenuView f484AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public BJ7GGh f485B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AZOQYO f486B2KMhB;

    public AZkASS(Context context) {
        this.f481AcNBzu = context;
        this.f482AlLFFp = LayoutInflater.from(context);
    }

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AmA8tU amA8tU, boolean z) {
        BJ7GGh bJ7GGh = this.f485B25kr6;
        if (bJ7GGh != null) {
            bJ7GGh.A2egSU(amA8tU, z);
        }
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        AZOQYO azoqyo = this.f486B2KMhB;
        if (azoqyo != null) {
            azoqyo.notifyDataSetChanged();
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f484AzWtSf.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(BpkvW3 bpkvW3) {
        if (!bpkvW3.hasVisibleItems()) {
            return false;
        }
        AzWtSf azWtSf = new AzWtSf();
        azWtSf.f517AcNBzu = bpkvW3;
        ADYaiT.AlLFFp alLFFp = new ADYaiT.AlLFFp(bpkvW3.getContext());
        AZkASS aZkASS = new AZkASS(alLFFp.getContext());
        azWtSf.f519AmA8tU = aZkASS;
        aZkASS.f485B25kr6 = azWtSf;
        bpkvW3.A4TApA(aZkASS, bpkvW3.f493AcNBzu);
        AZkASS aZkASS2 = azWtSf.f519AmA8tU;
        if (aZkASS2.f486B2KMhB == null) {
            aZkASS2.f486B2KMhB = new AZOQYO(aZkASS2);
        }
        AZOQYO azoqyo = aZkASS2.f486B2KMhB;
        ADYaiT.AZOQYO azoqyo2 = alLFFp.f81AcNBzu;
        azoqyo2.f39B3GDIM = azoqyo;
        azoqyo2.f40B4ZgIw = azWtSf;
        View view = bpkvW3.f507BNL6CD;
        if (view != null) {
            azoqyo2.f27ARc23Z = view;
        } else {
            azoqyo2.f26ADYaiT = bpkvW3.f506BJ7GGh;
            azoqyo2.AMqCpz = bpkvW3.f505BIYEnU;
        }
        azoqyo2.f37B25kr6 = azWtSf;
        ADYaiT.AmA8tU A2egSU2 = alLFFp.A2egSU();
        azWtSf.f518AlLFFp = A2egSU2;
        A2egSU2.setOnDismissListener(azWtSf);
        WindowManager.LayoutParams attributes = azWtSf.f518AlLFFp.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        azWtSf.f518AlLFFp.show();
        BJ7GGh bJ7GGh = this.f485B25kr6;
        if (bJ7GGh == null) {
            return true;
        }
        bJ7GGh.AMqCpz(bpkvW3);
        return true;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ASJ6gh(B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        if (this.f484AzWtSf == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f484AzWtSf;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // AZkASS.BNL6CD
    public final boolean AZOQYO(B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AmA8tU amA8tU) {
        if (this.f481AcNBzu != null) {
            this.f481AcNBzu = context;
            if (this.f482AlLFFp == null) {
                this.f482AlLFFp = LayoutInflater.from(context);
            }
        }
        this.f483AmA8tU = amA8tU;
        AZOQYO azoqyo = this.f486B2KMhB;
        if (azoqyo != null) {
            azoqyo.notifyDataSetChanged();
        }
    }

    @Override // AZkASS.BNL6CD
    public final void AaHO0E(BJ7GGh bJ7GGh) {
        throw null;
    }

    @Override // AZkASS.BNL6CD
    public final int getId() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f483AmA8tU.B2KMhB(this.f486B2KMhB.getItem(i), this, 0);
    }
}
