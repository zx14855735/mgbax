package com.google.android.material.datepicker;

import COJEAR.DG07BK;
import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.CkXcdM;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp<S> extends BI9f7h {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11598AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A4TApA f11599AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ARc23Z f11600AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public B2KMhB f11601B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f11602B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ADYaiT f11603B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public RecyclerView f11604B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public RecyclerView f11605B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public View f11606B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public View f11607BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public View f11608BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public View f11609BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public MaterialButton f11610BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public AccessibilityManager f11611BNL6CD;

    public final void AZkASS(B2KMhB b2KMhB) {
        B9tovu b9tovu = (B9tovu) this.f11605B7CMnp.getAdapter();
        int ADYaiT2 = b9tovu.f11653AcNBzu.f11575AcNBzu.ADYaiT(b2KMhB);
        AccessibilityManager accessibilityManager = this.f11611BNL6CD;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int ADYaiT3 = ADYaiT2 - b9tovu.f11653AcNBzu.f11575AcNBzu.ADYaiT(this.f11601B25kr6);
            boolean z = Math.abs(ADYaiT3) > 3;
            boolean z2 = ADYaiT3 > 0;
            this.f11601B25kr6 = b2KMhB;
            if (z && z2) {
                this.f11605B7CMnp.scrollToPosition(ADYaiT2 - 3);
                this.f11605B7CMnp.post(new C4FrIb.A4TApA(ADYaiT2, 8, this));
            } else if (z) {
                this.f11605B7CMnp.scrollToPosition(ADYaiT2 + 3);
                this.f11605B7CMnp.post(new C4FrIb.A4TApA(ADYaiT2, 8, this));
            } else {
                this.f11605B7CMnp.post(new C4FrIb.A4TApA(ADYaiT2, 8, this));
            }
        } else {
            this.f11601B25kr6 = b2KMhB;
            this.f11605B7CMnp.scrollToPosition(ADYaiT2);
        }
        AlLFFp(ADYaiT2);
    }

    public final void AcNBzu(int i) {
        this.f11602B2KMhB = i;
        if (i == 2) {
            this.f11604B4ZgIw.getLayoutManager().scrollToPosition(this.f11601B25kr6.f11640AmA8tU - ((BmvVmW) this.f11604B4ZgIw.getAdapter()).f11660AcNBzu.f11599AmA8tU.f11575AcNBzu.f11640AmA8tU);
            this.f11608BI9f7h.setVisibility(0);
            this.f11609BIYEnU.setVisibility(8);
            this.f11606B9tovu.setVisibility(8);
            this.f11607BChYOn.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.f11608BI9f7h.setVisibility(8);
            this.f11609BIYEnU.setVisibility(0);
            this.f11606B9tovu.setVisibility(0);
            this.f11607BChYOn.setVisibility(0);
            AZkASS(this.f11601B25kr6);
        }
    }

    public final void AlLFFp(int i) {
        this.f11607BChYOn.setEnabled(i + 1 < this.f11605B7CMnp.getAdapter().getItemCount());
        this.f11606B9tovu.setEnabled(i - 1 >= 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f11598AlLFFp = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f11599AmA8tU = (A4TApA) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f11600AzWtSf = (ARc23Z) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f11601B25kr6 = (B2KMhB) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f11598AlLFFp);
        this.f11603B3GDIM = new ADYaiT(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f11611BNL6CD = (AccessibilityManager) requireContext().getSystemService("accessibility");
        B2KMhB b2KMhB = this.f11599AmA8tU.f11575AcNBzu;
        if (AmA8tU.AmA8tU(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = 2131493244;
            i2 = 1;
        } else {
            i = 2131493239;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131166406) + resources.getDimensionPixelOffset(2131166408) + resources.getDimensionPixelSize(2131166407);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131166391);
        int i3 = B3GDIM.f11645ADYaiT;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(2131166405) * (i3 - 1)) + (resources.getDimensionPixelSize(2131166386) * i3) + resources.getDimensionPixelOffset(2131166383));
        GridView gridView = (GridView) inflate.findViewById(2131297662);
        DG07BK.B4ZgIw(gridView, new CikNvS.AYUAbz(3));
        int i4 = this.f11599AmA8tU.f11579B25kr6;
        gridView.setAdapter((ListAdapter) (i4 > 0 ? new ASJ6gh(i4) : new ASJ6gh()));
        gridView.setNumColumns(b2KMhB.f11641AzWtSf);
        gridView.setEnabled(false);
        this.f11605B7CMnp = (RecyclerView) inflate.findViewById(2131297665);
        getContext();
        this.f11605B7CMnp.setLayoutManager(new AZOQYO(this, i2, i2));
        this.f11605B7CMnp.setTag("MONTHS_VIEW_GROUP_TAG");
        B9tovu b9tovu = new B9tovu(contextThemeWrapper, this.f11599AmA8tU, this.f11600AzWtSf, new AZkASS(this));
        this.f11605B7CMnp.setAdapter(b9tovu);
        int integer = contextThemeWrapper.getResources().getInteger(2131361847);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131297668);
        this.f11604B4ZgIw = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f11604B4ZgIw.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f11604B4ZgIw.setAdapter(new BmvVmW(this));
            this.f11604B4ZgIw.addItemDecoration(new AaHO0E(this));
        }
        View findViewById = inflate.findViewById(2131297654);
        A4TApA a4TApA = b9tovu.f11653AcNBzu;
        if (findViewById != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(2131297654);
            this.f11610BJ7GGh = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            DG07BK.B4ZgIw(this.f11610BJ7GGh, new O1Vn2F.ADYaiT(5, this));
            View findViewById2 = inflate.findViewById(2131297656);
            this.f11606B9tovu = findViewById2;
            findViewById2.setTag("NAVIGATION_PREV_TAG");
            View findViewById3 = inflate.findViewById(2131297655);
            this.f11607BChYOn = findViewById3;
            findViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.f11608BI9f7h = inflate.findViewById(2131297668);
            this.f11609BIYEnU = inflate.findViewById(2131297661);
            AcNBzu(1);
            this.f11610BJ7GGh.setText(this.f11601B25kr6.A5SV6n());
            this.f11605B7CMnp.addOnScrollListener(new AcNBzu(this, b9tovu));
            this.f11610BJ7GGh.setOnClickListener(new ADYaiT.A5SV6n(22, this));
            this.f11607BChYOn.setOnClickListener(new AYUAbz(this, b9tovu, 1));
            this.f11606B9tovu.setOnClickListener(new AYUAbz(this, b9tovu, 0));
            AlLFFp(a4TApA.f11575AcNBzu.ADYaiT(this.f11601B25kr6));
        }
        if (!AmA8tU.AmA8tU(contextThemeWrapper, R.attr.windowFullscreen)) {
            new CkXcdM().attachToRecyclerView(this.f11605B7CMnp);
        }
        this.f11605B7CMnp.scrollToPosition(a4TApA.f11575AcNBzu.ADYaiT(this.f11601B25kr6));
        DG07BK.B4ZgIw(this.f11605B7CMnp, new CikNvS.AYUAbz(4));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f11598AlLFFp);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f11599AmA8tU);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f11600AzWtSf);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f11601B25kr6);
    }
}
