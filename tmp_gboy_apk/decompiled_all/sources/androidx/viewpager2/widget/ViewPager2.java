package androidx.viewpager2.widget;

import ADYaiT.CtFAbx;
import AZkASS.ARc23Z;
import COJEAR.DG07BK;
import De4eam.AZOQYO;
import De4eam.AZkASS;
import De4eam.AaHO0E;
import De4eam.AcNBzu;
import De4eam.AlLFFp;
import De4eam.AmA8tU;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.AYUAbz;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Rect f9585AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Rect f9586AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final androidx.viewpager2.widget.A2egSU f9587AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f9588AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f9589B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final De4eam.AMqCpz f9590B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final AZOQYO f9591B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f9592B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Parcelable f9593B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final AlLFFp f9594B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final AcNBzu f9595BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final A5SV6n f9596BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final androidx.viewpager2.widget.A2egSU f9597BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ARc23Z f9598BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final A4TApA f9599BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public RecyclerView.ADYaiT f9600BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f9601BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f9602BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f9603BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final AZkASS f9604BniPrB;

    public static abstract class A2egSU {
        public void A2egSU(int i) {
        }

        public void A4TApA(int i, float f, int i2) {
        }

        public void A5SV6n(int i) {
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9585AcNBzu = new Rect();
        this.f9586AlLFFp = new Rect();
        androidx.viewpager2.widget.A2egSU a2egSU = new androidx.viewpager2.widget.A2egSU();
        this.f9587AmA8tU = a2egSU;
        this.f9589B25kr6 = false;
        this.f9590B2KMhB = new De4eam.AMqCpz(0, this);
        this.f9592B4ZgIw = -1;
        this.f9600BPw6Q8 = null;
        this.f9601BTvldC = false;
        int i = 1;
        this.f9602BV3sI0 = true;
        this.f9603BmvVmW = -1;
        this.f9604BniPrB = new AZkASS(this);
        AlLFFp alLFFp = new AlLFFp(this, context);
        this.f9594B9tovu = alLFFp;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        alLFFp.setId(View.generateViewId());
        this.f9594B9tovu.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        AZOQYO azoqyo = new AZOQYO(this);
        this.f9591B3GDIM = azoqyo;
        this.f9594B9tovu.setLayoutManager(azoqyo);
        this.f9594B9tovu.setScrollingTouchSlop(1);
        int[] iArr = R$styleable.f9542A2egSU;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        DG07BK.B3GDIM(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
            this.f9594B9tovu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f9594B9tovu.addOnChildAttachStateChangeListener(new De4eam.ARc23Z());
            A5SV6n a5SV6n = new A5SV6n(this);
            this.f9596BI9f7h = a5SV6n;
            this.f9598BJ7GGh = new ARc23Z(11, a5SV6n);
            AcNBzu acNBzu = new AcNBzu(this);
            this.f9595BChYOn = acNBzu;
            acNBzu.attachToRecyclerView(this.f9594B9tovu);
            this.f9594B9tovu.addOnScrollListener(this.f9596BI9f7h);
            androidx.viewpager2.widget.A2egSU a2egSU2 = new androidx.viewpager2.widget.A2egSU();
            this.f9597BIYEnU = a2egSU2;
            this.f9596BI9f7h.f9572A2egSU = a2egSU2;
            ADYaiT aDYaiT = new ADYaiT(this);
            AMqCpz aMqCpz = new AMqCpz(this);
            this.f9597BIYEnU.f9569A2egSU.add(aDYaiT);
            this.f9597BIYEnU.f9569A2egSU.add(aMqCpz);
            AZkASS aZkASS = this.f9604BniPrB;
            AlLFFp alLFFp2 = this.f9594B9tovu;
            aZkASS.getClass();
            alLFFp2.setImportantForAccessibility(2);
            aZkASS.f2412A5SV6n = new De4eam.AMqCpz(i, aZkASS);
            ViewPager2 viewPager2 = aZkASS.f2413ADYaiT;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
            this.f9597BIYEnU.f9569A2egSU.add(a2egSU);
            A4TApA a4TApA = new A4TApA(this.f9591B3GDIM);
            this.f9599BNL6CD = a4TApA;
            this.f9597BIYEnU.f9569A2egSU.add(a4TApA);
            AlLFFp alLFFp3 = this.f9594B9tovu;
            attachViewToParent(alLFFp3, 0, alLFFp3.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A2egSU() {
        RecyclerView.A2egSU adapter;
        if (this.f9592B4ZgIw == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f9593B7CMnp;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.AZkASS) {
                ((AYUAbz) ((androidx.viewpager2.adapter.AZkASS) adapter)).ASJ6gh(parcelable);
            }
            this.f9593B7CMnp = null;
        }
        int max = Math.max(0, Math.min(this.f9592B4ZgIw, adapter.getItemCount() - 1));
        this.f9588AzWtSf = max;
        this.f9592B4ZgIw = -1;
        this.f9594B9tovu.scrollToPosition(max);
        this.f9604BniPrB.A2egSU();
    }

    public final void A4TApA(int i, boolean z) {
        Object obj = this.f9598BJ7GGh.f451AlLFFp;
        A5SV6n(i, z);
    }

    public final void A5SV6n(int i, boolean z) {
        androidx.viewpager2.widget.A2egSU a2egSU;
        RecyclerView.A2egSU adapter = getAdapter();
        if (adapter == null) {
            if (this.f9592B4ZgIw != -1) {
                this.f9592B4ZgIw = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
        int i2 = this.f9588AzWtSf;
        if (min == i2 && this.f9596BI9f7h.f9576ARc23Z == 0) {
            return;
        }
        if (min == i2 && z) {
            return;
        }
        double d = i2;
        this.f9588AzWtSf = min;
        this.f9604BniPrB.A2egSU();
        A5SV6n a5SV6n = this.f9596BI9f7h;
        if (a5SV6n.f9576ARc23Z != 0) {
            a5SV6n.A5SV6n();
            De4eam.ADYaiT aDYaiT = a5SV6n.f9577ASJ6gh;
            d = aDYaiT.f2404A2egSU + aDYaiT.f2405A4TApA;
        }
        A5SV6n a5SV6n2 = this.f9596BI9f7h;
        a5SV6n2.getClass();
        a5SV6n2.AMqCpz = z ? 2 : 3;
        boolean z2 = a5SV6n2.f9579AZOQYO != min;
        a5SV6n2.f9579AZOQYO = min;
        a5SV6n2.A2egSU(2);
        if (z2 && (a2egSU = a5SV6n2.f9572A2egSU) != null) {
            a2egSU.A5SV6n(min);
        }
        if (!z) {
            this.f9594B9tovu.scrollToPosition(min);
            return;
        }
        double d2 = min;
        if (Math.abs(d2 - d) <= 3.0d) {
            this.f9594B9tovu.smoothScrollToPosition(min);
            return;
        }
        this.f9594B9tovu.scrollToPosition(d2 > d ? min - 3 : min + 3);
        AlLFFp alLFFp = this.f9594B9tovu;
        alLFFp.post(new C4FrIb.A4TApA(min, alLFFp));
    }

    public final void ADYaiT() {
        AcNBzu acNBzu = this.f9595BChYOn;
        if (acNBzu == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View findSnapView = acNBzu.findSnapView(this.f9591B3GDIM);
        if (findSnapView == null) {
            return;
        }
        int position = this.f9591B3GDIM.getPosition(findSnapView);
        if (position != this.f9588AzWtSf && getScrollState() == 0) {
            this.f9597BIYEnU.A5SV6n(position);
        }
        this.f9589B25kr6 = false;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.f9594B9tovu.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.f9594B9tovu.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof AmA8tU) {
            int i = ((AmA8tU) parcelable).f2416AcNBzu;
            sparseArray.put(this.f9594B9tovu.getId(), (Parcelable) sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        A2egSU();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.f9604BniPrB.getClass();
        this.f9604BniPrB.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public RecyclerView.A2egSU getAdapter() {
        return this.f9594B9tovu.getAdapter();
    }

    public int getCurrentItem() {
        return this.f9588AzWtSf;
    }

    public int getItemDecorationCount() {
        return this.f9594B9tovu.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f9603BmvVmW;
    }

    public int getOrientation() {
        return this.f9591B3GDIM.getOrientation() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        AlLFFp alLFFp = this.f9594B9tovu;
        if (getOrientation() == 0) {
            height = alLFFp.getWidth() - alLFFp.getPaddingLeft();
            paddingBottom = alLFFp.getPaddingRight();
        } else {
            height = alLFFp.getHeight() - alLFFp.getPaddingTop();
            paddingBottom = alLFFp.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f9596BI9f7h.f9576ARc23Z;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        int i2;
        int itemCount;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = this.f9604BniPrB.f2413ADYaiT;
        if (viewPager2.getAdapter() == null) {
            i = 0;
            i2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            i = viewPager2.getAdapter().getItemCount();
            i2 = 1;
        } else {
            i2 = viewPager2.getAdapter().getItemCount();
            i = 1;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ARc23Z.BJ7GGh(i, i2, 0, false).f451AlLFFp);
        RecyclerView.A2egSU adapter = viewPager2.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !viewPager2.f9602BV3sI0) {
            return;
        }
        if (viewPager2.f9588AzWtSf > 0) {
            accessibilityNodeInfo.addAction(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        }
        if (viewPager2.f9588AzWtSf < itemCount - 1) {
            accessibilityNodeInfo.addAction(f.a.c);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.f9594B9tovu.getMeasuredWidth();
        int measuredHeight = this.f9594B9tovu.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f9585AcNBzu;
        rect.left = paddingLeft;
        rect.right = (i3 - i) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i4 - i2) - getPaddingBottom();
        Rect rect2 = this.f9586AlLFFp;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f9594B9tovu.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.f9589B25kr6) {
            ADYaiT();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChild(this.f9594B9tovu, i, i2);
        int measuredWidth = this.f9594B9tovu.getMeasuredWidth();
        int measuredHeight = this.f9594B9tovu.getMeasuredHeight();
        int measuredState = this.f9594B9tovu.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof AmA8tU)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        AmA8tU amA8tU = (AmA8tU) parcelable;
        super.onRestoreInstanceState(amA8tU.getSuperState());
        this.f9592B4ZgIw = amA8tU.f2417AlLFFp;
        this.f9593B7CMnp = amA8tU.f2418AmA8tU;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        AmA8tU amA8tU = new AmA8tU(super.onSaveInstanceState());
        amA8tU.f2416AcNBzu = this.f9594B9tovu.getId();
        int i = this.f9592B4ZgIw;
        if (i == -1) {
            i = this.f9588AzWtSf;
        }
        amA8tU.f2417AlLFFp = i;
        Parcelable parcelable = this.f9593B7CMnp;
        if (parcelable != null) {
            amA8tU.f2418AmA8tU = parcelable;
            return amA8tU;
        }
        Object adapter = this.f9594B9tovu.getAdapter();
        if (adapter instanceof androidx.viewpager2.adapter.AZkASS) {
            AYUAbz aYUAbz = (AYUAbz) ((androidx.viewpager2.adapter.AZkASS) adapter);
            aYUAbz.getClass();
            B25kr6.AYUAbz aYUAbz2 = aYUAbz.f9556AmA8tU;
            int AZkASS2 = aYUAbz2.AZkASS();
            B25kr6.AYUAbz aYUAbz3 = aYUAbz.f9557AzWtSf;
            Bundle bundle = new Bundle(aYUAbz3.AZkASS() + AZkASS2);
            for (int i2 = 0; i2 < aYUAbz2.AZkASS(); i2++) {
                long ASJ6gh2 = aYUAbz2.ASJ6gh(i2);
                Fragment fragment = (Fragment) aYUAbz2.ADYaiT(ASJ6gh2);
                if (fragment != null && fragment.isAdded()) {
                    aYUAbz.f9555AlLFFp.CmUvjW(bundle, CtFAbx.AaHO0E("f#", ASJ6gh2), fragment);
                }
            }
            for (int i3 = 0; i3 < aYUAbz3.AZkASS(); i3++) {
                long ASJ6gh3 = aYUAbz3.ASJ6gh(i3);
                if (aYUAbz.A4TApA(ASJ6gh3)) {
                    bundle.putParcelable(CtFAbx.AaHO0E("s#", ASJ6gh3), (Parcelable) aYUAbz3.ADYaiT(ASJ6gh3));
                }
            }
            amA8tU.f2418AmA8tU = bundle;
        }
        return amA8tU;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        this.f9604BniPrB.getClass();
        if (i != 8192 && i != 4096) {
            return super.performAccessibilityAction(i, bundle);
        }
        AZkASS aZkASS = this.f9604BniPrB;
        aZkASS.getClass();
        if (i != 8192 && i != 4096) {
            throw new IllegalStateException();
        }
        ViewPager2 viewPager2 = aZkASS.f2413ADYaiT;
        int currentItem = i == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        if (viewPager2.f9602BV3sI0) {
            viewPager2.A5SV6n(currentItem, true);
        }
        return true;
    }

    public void setAdapter(RecyclerView.A2egSU a2egSU) {
        RecyclerView.A2egSU adapter = this.f9594B9tovu.getAdapter();
        AZkASS aZkASS = this.f9604BniPrB;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(aZkASS.f2412A5SV6n);
        } else {
            aZkASS.getClass();
        }
        De4eam.AMqCpz aMqCpz = this.f9590B2KMhB;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(aMqCpz);
        }
        this.f9594B9tovu.setAdapter(a2egSU);
        this.f9588AzWtSf = 0;
        A2egSU();
        AZkASS aZkASS2 = this.f9604BniPrB;
        aZkASS2.A2egSU();
        if (a2egSU != null) {
            a2egSU.registerAdapterDataObserver(aZkASS2.f2412A5SV6n);
        }
        if (a2egSU != null) {
            a2egSU.registerAdapterDataObserver(aMqCpz);
        }
    }

    public void setCurrentItem(int i) {
        A4TApA(i, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.f9604BniPrB.A2egSU();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f9603BmvVmW = i;
        this.f9594B9tovu.requestLayout();
    }

    public void setOrientation(int i) {
        this.f9591B3GDIM.setOrientation(i);
        this.f9604BniPrB.A2egSU();
    }

    public void setPageTransformer(AaHO0E aaHO0E) {
        if (aaHO0E != null) {
            if (!this.f9601BTvldC) {
                this.f9600BPw6Q8 = this.f9594B9tovu.getItemAnimator();
                this.f9601BTvldC = true;
            }
            this.f9594B9tovu.setItemAnimator(null);
        } else if (this.f9601BTvldC) {
            this.f9594B9tovu.setItemAnimator(this.f9600BPw6Q8);
            this.f9600BPw6Q8 = null;
            this.f9601BTvldC = false;
        }
        A4TApA a4TApA = this.f9599BNL6CD;
        if (aaHO0E == a4TApA.f9571A4TApA) {
            return;
        }
        a4TApA.f9571A4TApA = aaHO0E;
        if (aaHO0E == null) {
            return;
        }
        A5SV6n a5SV6n = this.f9596BI9f7h;
        a5SV6n.A5SV6n();
        De4eam.ADYaiT aDYaiT = a5SV6n.f9577ASJ6gh;
        double d = aDYaiT.f2404A2egSU + aDYaiT.f2405A4TApA;
        int i = (int) d;
        float f = (float) (d - i);
        this.f9599BNL6CD.A4TApA(i, f, Math.round(getPageSize() * f));
    }

    public void setUserInputEnabled(boolean z) {
        this.f9602BV3sI0 = z;
        this.f9604BniPrB.A2egSU();
    }
}
