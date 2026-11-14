package androidx.viewpager2.adapter;

import ADYaiT.CtFAbx;
import COJEAR.DG07BK;
import IQ76hF.AmA8tU;
import MOpbMP.B25kr6;
import MOpbMP.B2KMhB;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.BV3sI0;
import androidx.fragment.app.CcAIMM;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AlLFFp;
import androidx.lifecycle.AzWtSf;
import androidx.lifecycle.B4ZgIw;
import androidx.lifecycle.B9tovu;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AYUAbz extends RecyclerView.A2egSU implements AZkASS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AzWtSf f9554AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final CtxOCS f9555AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final B25kr6.AYUAbz f9556AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B25kr6.AYUAbz f9557AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final B25kr6.AYUAbz f9558B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AMqCpz f9559B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final AmA8tU f9560B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f9561B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f9562B7CMnp;

    public AYUAbz(B2KMhB b2KMhB) {
        CtxOCS childFragmentManager = b2KMhB.getChildFragmentManager();
        AzWtSf lifecycle = b2KMhB.getLifecycle();
        this.f9556AmA8tU = new B25kr6.AYUAbz();
        this.f9557AzWtSf = new B25kr6.AYUAbz();
        this.f9558B25kr6 = new B25kr6.AYUAbz();
        AmA8tU amA8tU = new AmA8tU();
        amA8tU.f3956AlLFFp = new CopyOnWriteArrayList();
        this.f9560B3GDIM = amA8tU;
        this.f9561B4ZgIw = false;
        this.f9562B7CMnp = false;
        this.f9555AlLFFp = childFragmentManager;
        this.f9554AcNBzu = lifecycle;
        super.setHasStableIds(true);
    }

    public static void A2egSU(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public abstract boolean A4TApA(long j);

    public final void A5SV6n() {
        B25kr6.AYUAbz aYUAbz;
        B25kr6.AYUAbz aYUAbz2;
        Fragment fragment;
        View view;
        if (!this.f9562B7CMnp || this.f9555AlLFFp.CQhlFr()) {
            return;
        }
        B25kr6.AMqCpz aMqCpz = new B25kr6.AMqCpz();
        int i = 0;
        while (true) {
            aYUAbz = this.f9556AmA8tU;
            int AZkASS2 = aYUAbz.AZkASS();
            aYUAbz2 = this.f9558B25kr6;
            if (i >= AZkASS2) {
                break;
            }
            long ASJ6gh2 = aYUAbz.ASJ6gh(i);
            if (!A4TApA(ASJ6gh2)) {
                aMqCpz.add(Long.valueOf(ASJ6gh2));
                aYUAbz2.AZOQYO(ASJ6gh2);
            }
            i++;
        }
        if (!this.f9561B4ZgIw) {
            this.f9562B7CMnp = false;
            for (int i2 = 0; i2 < aYUAbz.AZkASS(); i2++) {
                long ASJ6gh3 = aYUAbz.ASJ6gh(i2);
                if (aYUAbz2.ARc23Z(ASJ6gh3) < 0 && ((fragment = (Fragment) aYUAbz.ADYaiT(ASJ6gh3)) == null || (view = fragment.getView()) == null || view.getParent() == null)) {
                    aMqCpz.add(Long.valueOf(ASJ6gh3));
                }
            }
        }
        B25kr6.A2egSU a2egSU = new B25kr6.A2egSU(aMqCpz);
        while (a2egSU.hasNext()) {
            ARc23Z(((Long) a2egSU.next()).longValue());
        }
    }

    public final Long ADYaiT(int i) {
        Long l = null;
        int i2 = 0;
        while (true) {
            B25kr6.AYUAbz aYUAbz = this.f9558B25kr6;
            if (i2 >= aYUAbz.AZkASS()) {
                return l;
            }
            if (((Integer) aYUAbz.AaHO0E(i2)).intValue() == i) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l = Long.valueOf(aYUAbz.ASJ6gh(i2));
            }
            i2++;
        }
    }

    public final void AMqCpz(final AZOQYO azoqyo) {
        Fragment fragment = (Fragment) this.f9556AmA8tU.ADYaiT(azoqyo.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayout = (FrameLayout) azoqyo.itemView;
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        boolean isAdded = fragment.isAdded();
        CtxOCS ctxOCS = this.f9555AlLFFp;
        if (isAdded && view == null) {
            ctxOCS.f8839AcNBzu.f8820A2egSU.add(new CcAIMM(new A2egSU(this, fragment, frameLayout), false));
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayout) {
                A2egSU(view, frameLayout);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            A2egSU(view, frameLayout);
            return;
        }
        if (ctxOCS.CQhlFr()) {
            if (ctxOCS.f8859C2rE4F) {
                return;
            }
            this.f9554AcNBzu.A2egSU(new B4ZgIw() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$1
                @Override // androidx.lifecycle.B4ZgIw
                public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
                    AYUAbz aYUAbz = AYUAbz.this;
                    if (aYUAbz.f9555AlLFFp.CQhlFr()) {
                        return;
                    }
                    b9tovu.getLifecycle().A5SV6n(this);
                    AZOQYO azoqyo2 = azoqyo;
                    FrameLayout frameLayout2 = (FrameLayout) azoqyo2.itemView;
                    WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                    if (frameLayout2.isAttachedToWindow()) {
                        aYUAbz.AMqCpz(azoqyo2);
                    }
                }
            });
            return;
        }
        ctxOCS.f8839AcNBzu.f8820A2egSU.add(new CcAIMM(new A2egSU(this, fragment, frameLayout), false));
        AmA8tU amA8tU = this.f9560B3GDIM;
        amA8tU.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((CopyOnWriteArrayList) amA8tU.f3956AlLFFp).iterator();
        while (it.hasNext()) {
            ((ASJ6gh) it.next()).getClass();
            arrayList.add(ASJ6gh.f9553A2egSU);
        }
        try {
            fragment.setMenuVisibility(false);
            androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(ctxOCS);
            a2egSU.AZOQYO(0, fragment, "f" + azoqyo.getItemId(), 1);
            a2egSU.B4ZgIw(fragment, androidx.lifecycle.AmA8tU.f8980AzWtSf);
            a2egSU.AMqCpz();
            this.f9559B2KMhB.A4TApA(false);
        } finally {
            AmA8tU.AzWtSf(arrayList);
        }
    }

    public final void ARc23Z(long j) {
        ViewParent parent;
        B25kr6.AYUAbz aYUAbz = this.f9556AmA8tU;
        Fragment fragment = (Fragment) aYUAbz.ADYaiT(j);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        boolean A4TApA2 = A4TApA(j);
        B25kr6.AYUAbz aYUAbz2 = this.f9557AzWtSf;
        if (!A4TApA2) {
            aYUAbz2.AZOQYO(j);
        }
        if (!fragment.isAdded()) {
            aYUAbz.AZOQYO(j);
            return;
        }
        CtxOCS ctxOCS = this.f9555AlLFFp;
        if (ctxOCS.CQhlFr()) {
            this.f9562B7CMnp = true;
            return;
        }
        boolean isAdded = fragment.isAdded();
        ARc23Z aRc23Z = ASJ6gh.f9553A2egSU;
        AmA8tU amA8tU = this.f9560B3GDIM;
        if (isAdded && A4TApA(j)) {
            amA8tU.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((CopyOnWriteArrayList) amA8tU.f3956AlLFFp).iterator();
            while (it.hasNext()) {
                ((ASJ6gh) it.next()).getClass();
                arrayList.add(aRc23Z);
            }
            BV3sI0 D07BeM2 = ctxOCS.D07BeM(fragment);
            AmA8tU.AzWtSf(arrayList);
            aYUAbz2.AYUAbz(j, D07BeM2);
        }
        amA8tU.getClass();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = ((CopyOnWriteArrayList) amA8tU.f3956AlLFFp).iterator();
        while (it2.hasNext()) {
            ((ASJ6gh) it2.next()).getClass();
            arrayList2.add(aRc23Z);
        }
        try {
            androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(ctxOCS);
            a2egSU.AcNBzu(fragment);
            a2egSU.AMqCpz();
            aYUAbz.AZOQYO(j);
        } finally {
            AmA8tU.AzWtSf(arrayList2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        throw new java.lang.IllegalArgumentException("Unexpected key in savedState: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ASJ6gh(android.os.Parcelable r8) {
        /*
            r7 = this;
            B25kr6.AYUAbz r0 = r7.f9557AzWtSf
            int r1 = r0.AZkASS()
            if (r1 != 0) goto Lbd
            B25kr6.AYUAbz r1 = r7.f9556AmA8tU
            int r2 = r1.AZkASS()
            if (r2 != 0) goto Lbd
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.lang.ClassLoader r2 = r8.getClassLoader()
            if (r2 != 0) goto L23
            java.lang.Class r2 = r7.getClass()
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r8.setClassLoader(r2)
        L23:
            java.util.Set r2 = r8.keySet()
            java.util.Iterator r2 = r2.iterator()
        L2b:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L8f
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = "f#"
            boolean r5 = r3.startsWith(r5)
            r6 = 2
            if (r5 == 0) goto L48
            int r5 = r3.length()
            if (r5 <= r6) goto L48
            goto L49
        L48:
            r4 = 0
        L49:
            if (r4 == 0) goto L5d
            java.lang.String r4 = r3.substring(r6)
            long r4 = java.lang.Long.parseLong(r4)
            androidx.fragment.app.CtxOCS r6 = r7.f9555AlLFFp
            androidx.fragment.app.Fragment r3 = r6.BmvVmW(r8, r3)
            r1.AYUAbz(r4, r3)
            goto L2b
        L5d:
            java.lang.String r4 = "s#"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L83
            int r4 = r3.length()
            if (r4 <= r6) goto L83
            java.lang.String r4 = r3.substring(r6)
            long r4 = java.lang.Long.parseLong(r4)
            android.os.Parcelable r3 = r8.getParcelable(r3)
            androidx.fragment.app.BV3sI0 r3 = (androidx.fragment.app.BV3sI0) r3
            boolean r6 = r7.A4TApA(r4)
            if (r6 == 0) goto L2b
            r0.AYUAbz(r4, r3)
            goto L2b
        L83:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unexpected key in savedState: "
            java.lang.String r0 = r0.concat(r3)
            r8.<init>(r0)
            throw r8
        L8f:
            int r8 = r1.AZkASS()
            if (r8 != 0) goto L96
            return
        L96:
            r7.f9562B7CMnp = r4
            r7.f9561B4ZgIw = r4
            r7.A5SV6n()
            android.os.Handler r8 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r8.<init>(r0)
            LLYwnm.AMqCpz r0 = new LLYwnm.AMqCpz
            r1 = 26
            r0.<init>(r1, r7)
            androidx.viewpager2.adapter.FragmentStateAdapter$4 r1 = new androidx.viewpager2.adapter.FragmentStateAdapter$4
            r1.<init>()
            androidx.lifecycle.AzWtSf r2 = r7.f9554AcNBzu
            r2.A2egSU(r1)
            r1 = 10000(0x2710, double:4.9407E-320)
            r8.postDelayed(r0, r1)
            return
        Lbd:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Expected the adapter to be 'fresh' while restoring state."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.adapter.AYUAbz.ASJ6gh(android.os.Parcelable):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.f9559B2KMhB != null) {
            throw new IllegalArgumentException();
        }
        final AMqCpz aMqCpz = new AMqCpz(this);
        this.f9559B2KMhB = aMqCpz;
        aMqCpz.f9551ADYaiT = AMqCpz.A2egSU(recyclerView);
        A5SV6n a5SV6n = new A5SV6n(aMqCpz);
        aMqCpz.f9548A2egSU = a5SV6n;
        aMqCpz.f9551ADYaiT.f9587AmA8tU.f9569A2egSU.add(a5SV6n);
        ADYaiT aDYaiT = new ADYaiT(aMqCpz);
        aMqCpz.f9549A4TApA = aDYaiT;
        registerAdapterDataObserver(aDYaiT);
        B4ZgIw b4ZgIw = new B4ZgIw() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
                AMqCpz.this.A4TApA(false);
            }
        };
        aMqCpz.f9550A5SV6n = b4ZgIw;
        this.f9554AcNBzu.A2egSU(b4ZgIw);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        Fragment fragment;
        AZOQYO azoqyo = (AZOQYO) dphsd2;
        long itemId = azoqyo.getItemId();
        int id = ((FrameLayout) azoqyo.itemView).getId();
        Long ADYaiT2 = ADYaiT(id);
        B25kr6.AYUAbz aYUAbz = this.f9558B25kr6;
        if (ADYaiT2 != null && ADYaiT2.longValue() != itemId) {
            ARc23Z(ADYaiT2.longValue());
            aYUAbz.AZOQYO(ADYaiT2.longValue());
        }
        aYUAbz.AYUAbz(itemId, Integer.valueOf(id));
        long j = i;
        B25kr6.AYUAbz aYUAbz2 = this.f9556AmA8tU;
        if (aYUAbz2.ARc23Z(j) < 0) {
            B25kr6 b25kr6 = (B25kr6) this;
            if (i == 0) {
                MTKlkd.ARc23Z aRc23Z = b25kr6.f5030B9tovu.f5034B3GDIM;
                MQlCFp.AYUAbz aYUAbz3 = new MQlCFp.AYUAbz();
                Bundle bundle = new Bundle();
                bundle.putParcelable("game_item", aRc23Z);
                aYUAbz3.setArguments(bundle);
                fragment = aYUAbz3;
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Invalid position: "));
                }
                fragment = new MQlCFp.A5SV6n();
            }
            fragment.setInitialSavedState((BV3sI0) this.f9557AzWtSf.ADYaiT(j));
            aYUAbz2.AYUAbz(j, fragment);
        }
        FrameLayout frameLayout = (FrameLayout) azoqyo.itemView;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (frameLayout.isAttachedToWindow()) {
            AMqCpz(azoqyo);
        }
        A5SV6n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = AZOQYO.f9563AcNBzu;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new AZOQYO(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AMqCpz aMqCpz = this.f9559B2KMhB;
        aMqCpz.getClass();
        ViewPager2 A2egSU2 = AMqCpz.A2egSU(recyclerView);
        A2egSU2.f9587AmA8tU.f9569A2egSU.remove(aMqCpz.f9548A2egSU);
        ADYaiT aDYaiT = aMqCpz.f9549A4TApA;
        AYUAbz aYUAbz = aMqCpz.f9552ARc23Z;
        aYUAbz.unregisterAdapterDataObserver(aDYaiT);
        aYUAbz.f9554AcNBzu.A5SV6n(aMqCpz.f9550A5SV6n);
        aMqCpz.f9551ADYaiT = null;
        this.f9559B2KMhB = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final /* bridge */ /* synthetic */ boolean onFailedToRecycleView(Dphsd2 dphsd2) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewAttachedToWindow(Dphsd2 dphsd2) {
        AMqCpz((AZOQYO) dphsd2);
        A5SV6n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        Long ADYaiT2 = ADYaiT(((FrameLayout) ((AZOQYO) dphsd2).itemView).getId());
        if (ADYaiT2 != null) {
            ARc23Z(ADYaiT2.longValue());
            this.f9558B25kr6.AZOQYO(ADYaiT2.longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
}
