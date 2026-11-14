package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import com.sigmob.sdk.base.views.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CtxOCS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f8830A4TApA;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ArrayList f8832ADYaiT;
    public ArrayList AMqCpz;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public OnBackPressedDispatcher f8834ASJ6gh;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Cd8JRx f8839AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final CopyOnWriteArrayList f8840AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final CikNvS f8841AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final CikNvS f8842AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final CikNvS f8843B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final CikNvS f8844B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CmUvjW f8845B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f8846B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CQhlFr f8847B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CNPG0E f8848B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Fragment f8849BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Fragment f8850BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final CqNSpT f8851BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final OLy1FW.AzWtSf f8852BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public androidx.activity.result.ADYaiT f8853BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public androidx.activity.result.ADYaiT f8854BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public androidx.activity.result.ADYaiT f8855BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public ArrayDeque f8856BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f8857BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f8858BniPrB;
    public boolean BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f8859C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f8860C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public ArrayList f8861CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public ArrayList f8862CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public ArrayList f8863COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public D9tr6l f8864CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final AzWtSf f8865CSDoyG;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f8829A2egSU = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final DV2E8K f8831A5SV6n = new DV2E8K();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final CTkVKb f8833ARc23Z = new CTkVKb(this);

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final MOpbMP.BmvVmW f8835AYUAbz = new MOpbMP.BmvVmW(1, this);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final AtomicInteger f8836AZOQYO = new AtomicInteger();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Map f8837AZkASS = J3FDQU.A2egSU.BIYEnU();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final Map f8838AaHO0E = J3FDQU.A2egSU.BIYEnU();

    public static abstract class A2egSU {
        public void onFragmentActivityCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(CtxOCS ctxOCS, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentDetached(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentPaused(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentPreAttached(CtxOCS ctxOCS, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(CtxOCS ctxOCS, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentStopped(CtxOCS ctxOCS, Fragment fragment) {
        }

        public void onFragmentViewCreated(CtxOCS ctxOCS, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(CtxOCS ctxOCS, Fragment fragment) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.fragment.app.CikNvS] */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.fragment.app.CikNvS] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.CikNvS] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.CikNvS] */
    public CtxOCS() {
        Collections.synchronizedMap(new HashMap());
        this.f8839AcNBzu = new Cd8JRx(this);
        this.f8840AlLFFp = new CopyOnWriteArrayList();
        final int i = 0;
        this.f8841AmA8tU = new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.CikNvS

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ CtxOCS f8823A4TApA;

            {
                this.f8823A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        CtxOCS ctxOCS = this.f8823A4TApA;
                        if (ctxOCS.CNPG0E()) {
                            ctxOCS.AYUAbz(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        CtxOCS ctxOCS2 = this.f8823A4TApA;
                        if (ctxOCS2.CNPG0E() && num.intValue() == 80) {
                            ctxOCS2.AcNBzu(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.BJ7GGh bJ7GGh = (androidx.core.app.BJ7GGh) obj;
                        CtxOCS ctxOCS3 = this.f8823A4TApA;
                        if (ctxOCS3.CNPG0E()) {
                            ctxOCS3.AlLFFp(bJ7GGh.f8502A2egSU, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.CtFAbx ctFAbx = (androidx.core.app.CtFAbx) obj;
                        CtxOCS ctxOCS4 = this.f8823A4TApA;
                        if (ctxOCS4.CNPG0E()) {
                            ctxOCS4.B3GDIM(ctFAbx.f8563A2egSU, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f8842AzWtSf = new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.CikNvS

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ CtxOCS f8823A4TApA;

            {
                this.f8823A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        CtxOCS ctxOCS = this.f8823A4TApA;
                        if (ctxOCS.CNPG0E()) {
                            ctxOCS.AYUAbz(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        CtxOCS ctxOCS2 = this.f8823A4TApA;
                        if (ctxOCS2.CNPG0E() && num.intValue() == 80) {
                            ctxOCS2.AcNBzu(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.BJ7GGh bJ7GGh = (androidx.core.app.BJ7GGh) obj;
                        CtxOCS ctxOCS3 = this.f8823A4TApA;
                        if (ctxOCS3.CNPG0E()) {
                            ctxOCS3.AlLFFp(bJ7GGh.f8502A2egSU, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.CtFAbx ctFAbx = (androidx.core.app.CtFAbx) obj;
                        CtxOCS ctxOCS4 = this.f8823A4TApA;
                        if (ctxOCS4.CNPG0E()) {
                            ctxOCS4.B3GDIM(ctFAbx.f8563A2egSU, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.f8843B25kr6 = new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.CikNvS

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ CtxOCS f8823A4TApA;

            {
                this.f8823A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        CtxOCS ctxOCS = this.f8823A4TApA;
                        if (ctxOCS.CNPG0E()) {
                            ctxOCS.AYUAbz(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        CtxOCS ctxOCS2 = this.f8823A4TApA;
                        if (ctxOCS2.CNPG0E() && num.intValue() == 80) {
                            ctxOCS2.AcNBzu(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.BJ7GGh bJ7GGh = (androidx.core.app.BJ7GGh) obj;
                        CtxOCS ctxOCS3 = this.f8823A4TApA;
                        if (ctxOCS3.CNPG0E()) {
                            ctxOCS3.AlLFFp(bJ7GGh.f8502A2egSU, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.CtFAbx ctFAbx = (androidx.core.app.CtFAbx) obj;
                        CtxOCS ctxOCS4 = this.f8823A4TApA;
                        if (ctxOCS4.CNPG0E()) {
                            ctxOCS4.B3GDIM(ctFAbx.f8563A2egSU, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.f8844B2KMhB = new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.CikNvS

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ CtxOCS f8823A4TApA;

            {
                this.f8823A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        CtxOCS ctxOCS = this.f8823A4TApA;
                        if (ctxOCS.CNPG0E()) {
                            ctxOCS.AYUAbz(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        CtxOCS ctxOCS2 = this.f8823A4TApA;
                        if (ctxOCS2.CNPG0E() && num.intValue() == 80) {
                            ctxOCS2.AcNBzu(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.BJ7GGh bJ7GGh = (androidx.core.app.BJ7GGh) obj;
                        CtxOCS ctxOCS3 = this.f8823A4TApA;
                        if (ctxOCS3.CNPG0E()) {
                            ctxOCS3.AlLFFp(bJ7GGh.f8502A2egSU, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.CtFAbx ctFAbx = (androidx.core.app.CtFAbx) obj;
                        CtxOCS ctxOCS4 = this.f8823A4TApA;
                        if (ctxOCS4.CNPG0E()) {
                            ctxOCS4.B3GDIM(ctFAbx.f8563A2egSU, false);
                            break;
                        }
                        break;
                }
            }
        };
        this.f8845B3GDIM = new CmUvjW(this);
        this.f8846B4ZgIw = -1;
        this.f8851BIYEnU = new CqNSpT(this);
        this.f8852BJ7GGh = new OLy1FW.AzWtSf(11, (byte) 0);
        this.f8856BV3sI0 = new ArrayDeque();
        this.f8865CSDoyG = new AzWtSf(2, this);
    }

    public static boolean C4FrIb(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean CASmeH(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        Iterator it = fragment.mChildFragmentManager.f8831A5SV6n.AMqCpz().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z = CASmeH(fragment2);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean COJEAR(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        CtxOCS ctxOCS = fragment.mFragmentManager;
        return fragment.equals(ctxOCS.f8850BI9f7h) && COJEAR(ctxOCS.f8849BChYOn);
    }

    public final DUi7mC A2egSU(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            D6yqiO.ADYaiT.A5SV6n(fragment, str);
        }
        if (C4FrIb(2)) {
            fragment.toString();
        }
        DUi7mC ARc23Z2 = ARc23Z(fragment);
        fragment.mFragmentManager = this;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        dv2e8k.ASJ6gh(ARc23Z2);
        if (!fragment.mDetached) {
            dv2e8k.A2egSU(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (CASmeH(fragment)) {
                this.f8857BmvVmW = true;
            }
        }
        return ARc23Z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A4TApA(CQhlFr cQhlFr, CNPG0E cnpg0e, Fragment fragment) {
        if (this.f8847B7CMnp != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f8847B7CMnp = cQhlFr;
        this.f8848B9tovu = cnpg0e;
        this.f8849BChYOn = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8840AlLFFp;
        if (fragment != null) {
            copyOnWriteArrayList.add(new CrfGsy(fragment));
        } else if (cQhlFr instanceof DAk1zC) {
            copyOnWriteArrayList.add((DAk1zC) cQhlFr);
        }
        if (this.f8849BChYOn != null) {
            DRlcZ9();
        }
        if (cQhlFr instanceof androidx.activity.B9tovu) {
            androidx.activity.B9tovu b9tovu = (androidx.activity.B9tovu) cQhlFr;
            OnBackPressedDispatcher onBackPressedDispatcher = b9tovu.getOnBackPressedDispatcher();
            this.f8834ASJ6gh = onBackPressedDispatcher;
            androidx.lifecycle.B9tovu b9tovu2 = b9tovu;
            if (fragment != null) {
                b9tovu2 = fragment;
            }
            onBackPressedDispatcher.A2egSU(b9tovu2, this.f8835AYUAbz);
        }
        if (fragment != null) {
            D9tr6l d9tr6l = fragment.mFragmentManager.f8864CQhlFr;
            HashMap hashMap = d9tr6l.AMqCpz;
            D9tr6l d9tr6l2 = (D9tr6l) hashMap.get(fragment.mWho);
            if (d9tr6l2 == null) {
                d9tr6l2 = new D9tr6l(d9tr6l.f8883ASJ6gh);
                hashMap.put(fragment.mWho, d9tr6l2);
            }
            this.f8864CQhlFr = d9tr6l2;
        } else if (cQhlFr instanceof androidx.lifecycle.D07BeM) {
            this.f8864CQhlFr = (D9tr6l) new ADYaiT.DUi7mC(((androidx.lifecycle.D07BeM) cQhlFr).getViewModelStore(), D9tr6l.f8880AZkASS).AlLFFp(D9tr6l.class);
        } else {
            this.f8864CQhlFr = new D9tr6l(false);
        }
        this.f8864CQhlFr.f8885AZOQYO = CQhlFr();
        this.f8831A5SV6n.f8908ADYaiT = this.f8864CQhlFr;
        Object obj = this.f8847B7CMnp;
        if ((obj instanceof DV2E8K.ARc23Z) && fragment == null) {
            DV2E8K.ADYaiT savedStateRegistry = ((DV2E8K.ARc23Z) obj).getSavedStateRegistry();
            savedStateRegistry.A5SV6n("android:support:fragments", new BmvVmW(1, this));
            Bundle A2egSU2 = savedStateRegistry.A2egSU("android:support:fragments");
            if (A2egSU2 != null) {
                CtFAbx(A2egSU2);
            }
        }
        Object obj2 = this.f8847B7CMnp;
        if (obj2 instanceof androidx.activity.result.AYUAbz) {
            androidx.activity.result.ASJ6gh activityResultRegistry = ((androidx.activity.result.AYUAbz) obj2).getActivityResultRegistry();
            String BChYOn2 = ADYaiT.CtFAbx.BChYOn("FragmentManager:", fragment != null ? ADYaiT.CtFAbx.B25kr6(new StringBuilder(), fragment.mWho, ":") : "");
            this.f8853BNL6CD = activityResultRegistry.A5SV6n(ADYaiT.CtFAbx.AcNBzu(BChYOn2, "StartActivityForResult"), new A4TApA.ADYaiT(), new CkXcdM(this, 1));
            this.f8854BPw6Q8 = activityResultRegistry.A5SV6n(ADYaiT.CtFAbx.AcNBzu(BChYOn2, "StartIntentSenderForResult"), new CtFAbx(), new CkXcdM(this, 2));
            this.f8855BTvldC = activityResultRegistry.A5SV6n(ADYaiT.CtFAbx.AcNBzu(BChYOn2, "RequestPermissions"), new A4TApA.A5SV6n(), new CkXcdM(this, 0));
        }
        Object obj3 = this.f8847B7CMnp;
        if (obj3 instanceof BPw6Q8.AaHO0E) {
            ((BPw6Q8.AaHO0E) obj3).addOnConfigurationChangedListener(this.f8841AmA8tU);
        }
        Object obj4 = this.f8847B7CMnp;
        if (obj4 instanceof BPw6Q8.AcNBzu) {
            ((BPw6Q8.AcNBzu) obj4).addOnTrimMemoryListener(this.f8842AzWtSf);
        }
        Object obj5 = this.f8847B7CMnp;
        if (obj5 instanceof androidx.core.app.CqNSpT) {
            ((androidx.core.app.CqNSpT) obj5).addOnMultiWindowModeChangedListener(this.f8843B25kr6);
        }
        Object obj6 = this.f8847B7CMnp;
        if (obj6 instanceof androidx.core.app.CrfGsy) {
            ((androidx.core.app.CrfGsy) obj6).addOnPictureInPictureModeChangedListener(this.f8844B2KMhB);
        }
        Object obj7 = this.f8847B7CMnp;
        if ((obj7 instanceof COJEAR.AmA8tU) && fragment == null) {
            ((COJEAR.AmA8tU) obj7).addMenuProvider(this.f8845B3GDIM);
        }
    }

    public final void A5SV6n(Fragment fragment) {
        if (C4FrIb(2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f8831A5SV6n.A2egSU(fragment);
            if (C4FrIb(2)) {
                fragment.toString();
            }
            if (CASmeH(fragment)) {
                this.f8857BmvVmW = true;
            }
        }
    }

    public final void ADYaiT() {
        this.f8830A4TApA = false;
        this.f8862CNPG0E.clear();
        this.f8861CASmeH.clear();
    }

    public final HashSet AMqCpz() {
        AmA8tU amA8tU;
        HashSet hashSet = new HashSet();
        Iterator it = this.f8831A5SV6n.ADYaiT().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((DUi7mC) it.next()).f8903A5SV6n.mContainer;
            if (viewGroup != null) {
                RXb0Sz.ARc23Z.AMqCpz(C2rE4F(), "factory");
                Object tag = viewGroup.getTag(2131298002);
                if (tag instanceof AmA8tU) {
                    amA8tU = (AmA8tU) tag;
                } else {
                    amA8tU = new AmA8tU(viewGroup);
                    viewGroup.setTag(2131298002, amA8tU);
                }
                hashSet.add(amA8tU);
            }
        }
        return hashSet;
    }

    public final DUi7mC ARc23Z(Fragment fragment) {
        String str = fragment.mWho;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        DUi7mC dUi7mC = (DUi7mC) dv2e8k.f8906A4TApA.get(str);
        if (dUi7mC != null) {
            return dUi7mC;
        }
        DUi7mC dUi7mC2 = new DUi7mC(this.f8839AcNBzu, dv2e8k, fragment);
        dUi7mC2.AZkASS(this.f8847B7CMnp.getContext().getClassLoader());
        dUi7mC2.AMqCpz = this.f8846B4ZgIw;
        return dUi7mC2;
    }

    public final void ASJ6gh(Fragment fragment) {
        if (C4FrIb(2)) {
            Objects.toString(fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (C4FrIb(2)) {
                fragment.toString();
            }
            DV2E8K dv2e8k = this.f8831A5SV6n;
            synchronized (dv2e8k.f8905A2egSU) {
                dv2e8k.f8905A2egSU.remove(fragment);
            }
            fragment.mAdded = false;
            if (CASmeH(fragment)) {
                this.f8857BmvVmW = true;
            }
            D9tr6l(fragment);
        }
    }

    public final void AYUAbz(boolean z, Configuration configuration) {
        if (z && (this.f8847B7CMnp instanceof BPw6Q8.AaHO0E)) {
            DAk1zC(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.AYUAbz(true, configuration);
                }
            }
        }
    }

    public final boolean AZOQYO(MenuItem menuItem) {
        if (this.f8846B4ZgIw < 1) {
            return false;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean AZkASS(Menu menu, MenuInflater menuInflater) {
        if (this.f8846B4ZgIw < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                Fragment fragment2 = (Fragment) this.AMqCpz.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.AMqCpz = arrayList;
        return z;
    }

    public final void AaHO0E() {
        boolean z = true;
        this.f8859C2rE4F = true;
        BIYEnU(true);
        Iterator it = AMqCpz().iterator();
        while (it.hasNext()) {
            ((AmA8tU) it.next()).ASJ6gh();
        }
        CQhlFr cQhlFr = this.f8847B7CMnp;
        boolean z2 = cQhlFr instanceof androidx.lifecycle.D07BeM;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        if (z2) {
            z = dv2e8k.f8908ADYaiT.f8884AYUAbz;
        } else if (cQhlFr.getContext() instanceof Activity) {
            z = true ^ ((Activity) this.f8847B7CMnp.getContext()).isChangingConfigurations();
        }
        if (z) {
            Iterator it2 = this.f8837AZkASS.values().iterator();
            while (it2.hasNext()) {
                for (String str : ((A5SV6n) it2.next()).f8719AcNBzu) {
                    D9tr6l d9tr6l = dv2e8k.f8908ADYaiT;
                    d9tr6l.getClass();
                    C4FrIb(3);
                    d9tr6l.ADYaiT(str);
                }
            }
        }
        B7CMnp(-1);
        Object obj = this.f8847B7CMnp;
        if (obj instanceof BPw6Q8.AcNBzu) {
            ((BPw6Q8.AcNBzu) obj).removeOnTrimMemoryListener(this.f8842AzWtSf);
        }
        Object obj2 = this.f8847B7CMnp;
        if (obj2 instanceof BPw6Q8.AaHO0E) {
            ((BPw6Q8.AaHO0E) obj2).removeOnConfigurationChangedListener(this.f8841AmA8tU);
        }
        Object obj3 = this.f8847B7CMnp;
        if (obj3 instanceof androidx.core.app.CqNSpT) {
            ((androidx.core.app.CqNSpT) obj3).removeOnMultiWindowModeChangedListener(this.f8843B25kr6);
        }
        Object obj4 = this.f8847B7CMnp;
        if (obj4 instanceof androidx.core.app.CrfGsy) {
            ((androidx.core.app.CrfGsy) obj4).removeOnPictureInPictureModeChangedListener(this.f8844B2KMhB);
        }
        Object obj5 = this.f8847B7CMnp;
        if ((obj5 instanceof COJEAR.AmA8tU) && this.f8849BChYOn == null) {
            ((COJEAR.AmA8tU) obj5).removeMenuProvider(this.f8845B3GDIM);
        }
        this.f8847B7CMnp = null;
        this.f8848B9tovu = null;
        this.f8849BChYOn = null;
        if (this.f8834ASJ6gh != null) {
            Iterator it3 = this.f8835AYUAbz.f5057A4TApA.iterator();
            while (it3.hasNext()) {
                ((androidx.activity.A5SV6n) it3.next()).cancel();
            }
            this.f8834ASJ6gh = null;
        }
        androidx.activity.result.ADYaiT aDYaiT = this.f8853BNL6CD;
        if (aDYaiT != null) {
            aDYaiT.A4TApA();
            this.f8854BPw6Q8.A4TApA();
            this.f8855BTvldC.A4TApA();
        }
    }

    public final void AcNBzu(boolean z) {
        if (z && (this.f8847B7CMnp instanceof BPw6Q8.AcNBzu)) {
            DAk1zC(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.AcNBzu(true);
                }
            }
        }
    }

    public final void AlLFFp(boolean z, boolean z2) {
        if (z2 && (this.f8847B7CMnp instanceof androidx.core.app.CqNSpT)) {
            DAk1zC(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.AlLFFp(z, true);
                }
            }
        }
    }

    public final void AmA8tU() {
        Iterator it = this.f8831A5SV6n.AMqCpz().iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.AmA8tU();
            }
        }
    }

    public final boolean AzWtSf(MenuItem menuItem) {
        if (this.f8846B4ZgIw < 1) {
            return false;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void B25kr6(Menu menu) {
        if (this.f8846B4ZgIw < 1) {
            return;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void B2KMhB(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f8831A5SV6n.A4TApA(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void B3GDIM(boolean z, boolean z2) {
        if (z2 && (this.f8847B7CMnp instanceof androidx.core.app.CrfGsy)) {
            DAk1zC(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.B3GDIM(z, true);
                }
            }
        }
    }

    public final boolean B4ZgIw(Menu menu) {
        boolean z = false;
        if (this.f8846B4ZgIw < 1) {
            return false;
        }
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void B7CMnp(int i) {
        try {
            this.f8830A4TApA = true;
            for (DUi7mC dUi7mC : this.f8831A5SV6n.f8906A4TApA.values()) {
                if (dUi7mC != null) {
                    dUi7mC.AMqCpz = i;
                }
            }
            CSDoyG(i, false);
            Iterator it = AMqCpz().iterator();
            while (it.hasNext()) {
                ((AmA8tU) it.next()).ASJ6gh();
            }
            this.f8830A4TApA = false;
            BIYEnU(true);
        } catch (Throwable th) {
            this.f8830A4TApA = false;
            throw th;
        }
    }

    public final void B9tovu(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String AcNBzu2 = ADYaiT.CtFAbx.AcNBzu(str, "    ");
        DV2E8K dv2e8k = this.f8831A5SV6n;
        dv2e8k.getClass();
        String str2 = str + "    ";
        HashMap hashMap = dv2e8k.f8906A4TApA;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (DUi7mC dUi7mC : hashMap.values()) {
                printWriter.print(str);
                if (dUi7mC != null) {
                    Fragment fragment = dUi7mC.f8903A5SV6n;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = dv2e8k.f8905A2egSU;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.AMqCpz;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment3 = (Fragment) this.AMqCpz.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.f8832ADYaiT;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.A2egSU a2egSU = (androidx.fragment.app.A2egSU) this.f8832ADYaiT.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(a2egSU.toString());
                a2egSU.B3GDIM(AcNBzu2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f8836AZOQYO.get());
        synchronized (this.f8829A2egSU) {
            try {
                int size4 = this.f8829A2egSU.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (D6DOie) this.f8829A2egSU.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f8847B7CMnp);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f8848B9tovu);
        if (this.f8849BChYOn != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f8849BChYOn);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f8846B4ZgIw);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f8858BniPrB);
        printWriter.print(" mStopped=");
        printWriter.print(this.BpkvW3);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f8859C2rE4F);
        if (this.f8857BmvVmW) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f8857BmvVmW);
        }
    }

    public final void BChYOn(D6DOie d6DOie, boolean z) {
        if (!z) {
            if (this.f8847B7CMnp == null) {
                if (!this.f8859C2rE4F) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (CQhlFr()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f8829A2egSU) {
            try {
                if (this.f8847B7CMnp == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f8829A2egSU.add(d6DOie);
                    D6DOie();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void BI9f7h(boolean z) {
        if (this.f8830A4TApA) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f8847B7CMnp == null) {
            if (!this.f8859C2rE4F) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f8847B7CMnp.f8813AmA8tU.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && CQhlFr()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f8861CASmeH == null) {
            this.f8861CASmeH = new ArrayList();
            this.f8862CNPG0E = new ArrayList();
        }
    }

    public final boolean BIYEnU(boolean z) {
        boolean z2;
        BI9f7h(z);
        boolean z3 = false;
        while (true) {
            ArrayList arrayList = this.f8861CASmeH;
            ArrayList arrayList2 = this.f8862CNPG0E;
            synchronized (this.f8829A2egSU) {
                if (this.f8829A2egSU.isEmpty()) {
                    z2 = false;
                } else {
                    try {
                        int size = this.f8829A2egSU.size();
                        z2 = false;
                        for (int i = 0; i < size; i++) {
                            z2 |= ((D6DOie) this.f8829A2egSU.get(i)).A2egSU(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!z2) {
                break;
            }
            this.f8830A4TApA = true;
            try {
                CrfGsy(this.f8861CASmeH, this.f8862CNPG0E);
                ADYaiT();
                z3 = true;
            } catch (Throwable th) {
                ADYaiT();
                throw th;
            }
        }
        DRlcZ9();
        if (this.f8860C4FrIb) {
            this.f8860C4FrIb = false;
            Iterator it = this.f8831A5SV6n.ADYaiT().iterator();
            while (it.hasNext()) {
                DUi7mC dUi7mC = (DUi7mC) it.next();
                Fragment fragment = dUi7mC.f8903A5SV6n;
                if (fragment.mDeferStart) {
                    if (this.f8830A4TApA) {
                        this.f8860C4FrIb = true;
                    } else {
                        fragment.mDeferStart = false;
                        dUi7mC.AZOQYO();
                    }
                }
            }
        }
        this.f8831A5SV6n.f8906A4TApA.values().removeAll(Collections.singleton(null));
        return z3;
    }

    public final void BJ7GGh(androidx.fragment.app.A2egSU a2egSU, boolean z) {
        if (z && (this.f8847B7CMnp == null || this.f8859C2rE4F)) {
            return;
        }
        BI9f7h(z);
        a2egSU.A2egSU(this.f8861CASmeH, this.f8862CNPG0E);
        this.f8830A4TApA = true;
        try {
            CrfGsy(this.f8861CASmeH, this.f8862CNPG0E);
            ADYaiT();
            DRlcZ9();
            boolean z2 = this.f8860C4FrIb;
            DV2E8K dv2e8k = this.f8831A5SV6n;
            if (z2) {
                this.f8860C4FrIb = false;
                Iterator it = dv2e8k.ADYaiT().iterator();
                while (it.hasNext()) {
                    DUi7mC dUi7mC = (DUi7mC) it.next();
                    Fragment fragment = dUi7mC.f8903A5SV6n;
                    if (fragment.mDeferStart) {
                        if (this.f8830A4TApA) {
                            this.f8860C4FrIb = true;
                        } else {
                            fragment.mDeferStart = false;
                            dUi7mC.AZOQYO();
                        }
                    }
                }
            }
            dv2e8k.f8906A4TApA.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            ADYaiT();
            throw th;
        }
    }

    public final void BNL6CD(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ViewGroup viewGroup;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        int i7;
        boolean z5 = ((androidx.fragment.app.A2egSU) arrayList.get(i)).f8931B25kr6;
        ArrayList arrayList3 = this.f8863COJEAR;
        if (arrayList3 == null) {
            this.f8863COJEAR = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.f8863COJEAR;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        arrayList4.addAll(dv2e8k.ARc23Z());
        Fragment fragment = this.f8850BI9f7h;
        int i8 = i;
        boolean z6 = false;
        while (true) {
            int i9 = 1;
            if (i8 >= i2) {
                boolean z7 = z5;
                this.f8863COJEAR.clear();
                if (!z7 && this.f8846B4ZgIw >= 1) {
                    for (int i10 = i; i10 < i2; i10++) {
                        Iterator it = ((androidx.fragment.app.A2egSU) arrayList.get(i10)).f8917A2egSU.iterator();
                        while (it.hasNext()) {
                            Fragment fragment2 = ((DXnQ0V) it.next()).f8910A4TApA;
                            if (fragment2 != null && fragment2.mFragmentManager != null) {
                                dv2e8k.ASJ6gh(ARc23Z(fragment2));
                            }
                        }
                    }
                }
                for (int i11 = i; i11 < i2; i11++) {
                    androidx.fragment.app.A2egSU a2egSU = (androidx.fragment.app.A2egSU) arrayList.get(i11);
                    if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                        a2egSU.B25kr6(-1);
                        ArrayList arrayList5 = a2egSU.f8917A2egSU;
                        boolean z8 = true;
                        for (int size = arrayList5.size() - 1; size >= 0; size--) {
                            DXnQ0V dXnQ0V = (DXnQ0V) arrayList5.get(size);
                            Fragment fragment3 = dXnQ0V.f8910A4TApA;
                            if (fragment3 != null) {
                                fragment3.mBeingSaved = false;
                                fragment3.setPopDirection(z8);
                                int i12 = a2egSU.f8921ARc23Z;
                                int i13 = 8194;
                                if (i12 != 4097) {
                                    if (i12 != 8194) {
                                        i13 = 4100;
                                        if (i12 != 8197) {
                                            i13 = i12 != 4099 ? i12 != 4100 ? 0 : 8197 : 4099;
                                        }
                                    } else {
                                        i13 = 4097;
                                    }
                                }
                                fragment3.setNextTransition(i13);
                                fragment3.setSharedElementNames(a2egSU.f8930AzWtSf, a2egSU.f8929AmA8tU);
                            }
                            int i14 = dXnQ0V.f8909A2egSU;
                            CtxOCS ctxOCS = a2egSU.f8702B3GDIM;
                            switch (i14) {
                                case 1:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    z8 = true;
                                    ctxOCS.D6yqiO(fragment3, true);
                                    ctxOCS.CqNSpT(fragment3);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + dXnQ0V.f8909A2egSU);
                                case 3:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    ctxOCS.A2egSU(fragment3);
                                    z8 = true;
                                case 4:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    ctxOCS.getClass();
                                    if (C4FrIb(2)) {
                                        Objects.toString(fragment3);
                                    }
                                    if (fragment3.mHidden) {
                                        fragment3.mHidden = false;
                                        fragment3.mHiddenChanged = !fragment3.mHiddenChanged;
                                    }
                                    z8 = true;
                                case 5:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    ctxOCS.D6yqiO(fragment3, true);
                                    if (C4FrIb(2)) {
                                        Objects.toString(fragment3);
                                    }
                                    if (!fragment3.mHidden) {
                                        fragment3.mHidden = true;
                                        fragment3.mHiddenChanged = !fragment3.mHiddenChanged;
                                        ctxOCS.D9tr6l(fragment3);
                                    }
                                    z8 = true;
                                case 6:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    ctxOCS.A5SV6n(fragment3);
                                    z8 = true;
                                case 7:
                                    fragment3.setAnimations(dXnQ0V.f8912ADYaiT, dXnQ0V.AMqCpz, dXnQ0V.f8913ARc23Z, dXnQ0V.f8914ASJ6gh);
                                    ctxOCS.D6yqiO(fragment3, true);
                                    ctxOCS.ASJ6gh(fragment3);
                                    z8 = true;
                                case 8:
                                    ctxOCS.D8cQ8b(null);
                                    z8 = true;
                                case 9:
                                    ctxOCS.D8cQ8b(fragment3);
                                    z8 = true;
                                case 10:
                                    ctxOCS.D8MqeW(fragment3, dXnQ0V.f8915AYUAbz);
                                    z8 = true;
                            }
                        }
                    } else {
                        a2egSU.B25kr6(1);
                        ArrayList arrayList6 = a2egSU.f8917A2egSU;
                        int size2 = arrayList6.size();
                        for (int i15 = 0; i15 < size2; i15++) {
                            DXnQ0V dXnQ0V2 = (DXnQ0V) arrayList6.get(i15);
                            Fragment fragment4 = dXnQ0V2.f8910A4TApA;
                            if (fragment4 != null) {
                                fragment4.mBeingSaved = false;
                                fragment4.setPopDirection(false);
                                fragment4.setNextTransition(a2egSU.f8921ARc23Z);
                                fragment4.setSharedElementNames(a2egSU.f8929AmA8tU, a2egSU.f8930AzWtSf);
                            }
                            int i16 = dXnQ0V2.f8909A2egSU;
                            CtxOCS ctxOCS2 = a2egSU.f8702B3GDIM;
                            switch (i16) {
                                case 1:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.D6yqiO(fragment4, false);
                                    ctxOCS2.A2egSU(fragment4);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + dXnQ0V2.f8909A2egSU);
                                case 3:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.CqNSpT(fragment4);
                                case 4:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.getClass();
                                    if (C4FrIb(2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (!fragment4.mHidden) {
                                        fragment4.mHidden = true;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                        ctxOCS2.D9tr6l(fragment4);
                                    }
                                case 5:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.D6yqiO(fragment4, false);
                                    if (C4FrIb(2)) {
                                        Objects.toString(fragment4);
                                    }
                                    if (fragment4.mHidden) {
                                        fragment4.mHidden = false;
                                        fragment4.mHiddenChanged = !fragment4.mHiddenChanged;
                                    }
                                case 6:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.ASJ6gh(fragment4);
                                case 7:
                                    fragment4.setAnimations(dXnQ0V2.f8912ADYaiT, dXnQ0V2.AMqCpz, dXnQ0V2.f8913ARc23Z, dXnQ0V2.f8914ASJ6gh);
                                    ctxOCS2.D6yqiO(fragment4, false);
                                    ctxOCS2.A5SV6n(fragment4);
                                case 8:
                                    ctxOCS2.D8cQ8b(fragment4);
                                case 9:
                                    ctxOCS2.D8cQ8b(null);
                                case 10:
                                    ctxOCS2.D8MqeW(fragment4, dXnQ0V2.f8916AZOQYO);
                            }
                        }
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                for (int i17 = i; i17 < i2; i17++) {
                    androidx.fragment.app.A2egSU a2egSU2 = (androidx.fragment.app.A2egSU) arrayList.get(i17);
                    if (booleanValue) {
                        for (int size3 = a2egSU2.f8917A2egSU.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment5 = ((DXnQ0V) a2egSU2.f8917A2egSU.get(size3)).f8910A4TApA;
                            if (fragment5 != null) {
                                ARc23Z(fragment5).AZOQYO();
                            }
                        }
                    } else {
                        Iterator it2 = a2egSU2.f8917A2egSU.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment6 = ((DXnQ0V) it2.next()).f8910A4TApA;
                            if (fragment6 != null) {
                                ARc23Z(fragment6).AZOQYO();
                            }
                        }
                    }
                }
                CSDoyG(this.f8846B4ZgIw, true);
                HashSet hashSet = new HashSet();
                for (int i18 = i; i18 < i2; i18++) {
                    Iterator it3 = ((androidx.fragment.app.A2egSU) arrayList.get(i18)).f8917A2egSU.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment7 = ((DXnQ0V) it3.next()).f8910A4TApA;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(AmA8tU.AYUAbz(viewGroup, this));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    AmA8tU amA8tU = (AmA8tU) it4.next();
                    amA8tU.f8756ADYaiT = booleanValue;
                    amA8tU.AZOQYO();
                    amA8tU.ADYaiT();
                }
                for (int i19 = i; i19 < i2; i19++) {
                    androidx.fragment.app.A2egSU a2egSU3 = (androidx.fragment.app.A2egSU) arrayList.get(i19);
                    if (((Boolean) arrayList2.get(i19)).booleanValue() && a2egSU3.f8704B7CMnp >= 0) {
                        a2egSU3.f8704B7CMnp = -1;
                    }
                    if (a2egSU3.f8932B2KMhB != null) {
                        for (int i20 = 0; i20 < a2egSU3.f8932B2KMhB.size(); i20++) {
                            ((Runnable) a2egSU3.f8932B2KMhB.get(i20)).run();
                        }
                        a2egSU3.f8932B2KMhB = null;
                    }
                }
                return;
            }
            androidx.fragment.app.A2egSU a2egSU4 = (androidx.fragment.app.A2egSU) arrayList.get(i8);
            if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                z = z5;
                i3 = i8;
                z2 = z6;
                int i21 = 1;
                ArrayList arrayList7 = this.f8863COJEAR;
                ArrayList arrayList8 = a2egSU4.f8917A2egSU;
                int size4 = arrayList8.size() - 1;
                while (size4 >= 0) {
                    DXnQ0V dXnQ0V3 = (DXnQ0V) arrayList8.get(size4);
                    int i22 = dXnQ0V3.f8909A2egSU;
                    if (i22 != i21) {
                        if (i22 != 3) {
                            switch (i22) {
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = dXnQ0V3.f8910A4TApA;
                                    break;
                                case 10:
                                    dXnQ0V3.f8916AZOQYO = dXnQ0V3.f8915AYUAbz;
                                    break;
                            }
                            size4--;
                            i21 = 1;
                        }
                        arrayList7.add(dXnQ0V3.f8910A4TApA);
                        size4--;
                        i21 = 1;
                    }
                    arrayList7.remove(dXnQ0V3.f8910A4TApA);
                    size4--;
                    i21 = 1;
                }
            } else {
                ArrayList arrayList9 = this.f8863COJEAR;
                int i23 = 0;
                while (true) {
                    ArrayList arrayList10 = a2egSU4.f8917A2egSU;
                    if (i23 < arrayList10.size()) {
                        DXnQ0V dXnQ0V4 = (DXnQ0V) arrayList10.get(i23);
                        int i24 = dXnQ0V4.f8909A2egSU;
                        if (i24 != i9) {
                            if (i24 != 2) {
                                if (i24 == 3 || i24 == 6) {
                                    z3 = z5;
                                    arrayList9.remove(dXnQ0V4.f8910A4TApA);
                                    Fragment fragment8 = dXnQ0V4.f8910A4TApA;
                                    if (fragment8 == fragment) {
                                        arrayList10.add(i23, new DXnQ0V(fragment8, 9));
                                        i23++;
                                        i4 = i8;
                                        z4 = z6;
                                        i5 = 1;
                                        fragment = null;
                                    }
                                } else if (i24 != 7) {
                                    if (i24 != 8) {
                                        z3 = z5;
                                    } else {
                                        z3 = z5;
                                        arrayList10.add(i23, new DXnQ0V(9, fragment, 0));
                                        dXnQ0V4.f8911A5SV6n = true;
                                        i23++;
                                        fragment = dXnQ0V4.f8910A4TApA;
                                    }
                                }
                                i4 = i8;
                                z4 = z6;
                                i5 = 1;
                            } else {
                                z3 = z5;
                                Fragment fragment9 = dXnQ0V4.f8910A4TApA;
                                int i25 = fragment9.mContainerId;
                                int size5 = arrayList9.size() - 1;
                                boolean z9 = false;
                                while (size5 >= 0) {
                                    int i26 = i8;
                                    Fragment fragment10 = (Fragment) arrayList9.get(size5);
                                    boolean z10 = z6;
                                    if (fragment10.mContainerId != i25) {
                                        i6 = i25;
                                    } else if (fragment10 == fragment9) {
                                        i6 = i25;
                                        z9 = true;
                                    } else {
                                        if (fragment10 == fragment) {
                                            i6 = i25;
                                            i7 = 0;
                                            arrayList10.add(i23, new DXnQ0V(9, fragment10, 0));
                                            i23++;
                                            fragment = null;
                                        } else {
                                            i6 = i25;
                                            i7 = 0;
                                        }
                                        DXnQ0V dXnQ0V5 = new DXnQ0V(3, fragment10, i7);
                                        dXnQ0V5.f8912ADYaiT = dXnQ0V4.f8912ADYaiT;
                                        dXnQ0V5.f8913ARc23Z = dXnQ0V4.f8913ARc23Z;
                                        dXnQ0V5.AMqCpz = dXnQ0V4.AMqCpz;
                                        dXnQ0V5.f8914ASJ6gh = dXnQ0V4.f8914ASJ6gh;
                                        arrayList10.add(i23, dXnQ0V5);
                                        arrayList9.remove(fragment10);
                                        i23++;
                                        fragment = fragment;
                                    }
                                    size5--;
                                    i25 = i6;
                                    z6 = z10;
                                    i8 = i26;
                                }
                                i4 = i8;
                                z4 = z6;
                                i5 = 1;
                                if (z9) {
                                    arrayList10.remove(i23);
                                    i23--;
                                } else {
                                    dXnQ0V4.f8909A2egSU = 1;
                                    dXnQ0V4.f8911A5SV6n = true;
                                    arrayList9.add(fragment9);
                                }
                            }
                            i23 += i5;
                            z5 = z3;
                            z6 = z4;
                            i8 = i4;
                            i9 = 1;
                        }
                        z3 = z5;
                        i4 = i8;
                        z4 = z6;
                        i5 = 1;
                        arrayList9.add(dXnQ0V4.f8910A4TApA);
                        i23 += i5;
                        z5 = z3;
                        z6 = z4;
                        i8 = i4;
                        i9 = 1;
                    } else {
                        z = z5;
                        i3 = i8;
                        z2 = z6;
                    }
                }
            }
            z6 = z2 || a2egSU4.f8922ASJ6gh;
            i8 = i3 + 1;
            z5 = z;
        }
    }

    public final Fragment BPw6Q8(int i) {
        DV2E8K dv2e8k = this.f8831A5SV6n;
        ArrayList arrayList = dv2e8k.f8905A2egSU;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (DUi7mC dUi7mC : dv2e8k.f8906A4TApA.values()) {
            if (dUi7mC != null) {
                Fragment fragment2 = dUi7mC.f8903A5SV6n;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment BTvldC(String str) {
        DV2E8K dv2e8k = this.f8831A5SV6n;
        if (str != null) {
            ArrayList arrayList = dv2e8k.f8905A2egSU;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            dv2e8k.getClass();
            return null;
        }
        for (DUi7mC dUi7mC : dv2e8k.f8906A4TApA.values()) {
            if (dUi7mC != null) {
                Fragment fragment2 = dUi7mC.f8903A5SV6n;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final void BV3sI0() {
        Iterator it = AMqCpz().iterator();
        while (it.hasNext()) {
            AmA8tU amA8tU = (AmA8tU) it.next();
            if (amA8tU.AMqCpz) {
                C4FrIb(2);
                amA8tU.AMqCpz = false;
                amA8tU.ADYaiT();
            }
        }
    }

    public final Fragment BmvVmW(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment A4TApA2 = this.f8831A5SV6n.A4TApA(string);
        if (A4TApA2 != null) {
            return A4TApA2;
        }
        DAk1zC(new IllegalStateException(ADYaiT.CtFAbx.AmA8tU("Fragment no longer exists for key ", str, ": unique id ", string)));
        throw null;
    }

    public final ViewGroup BniPrB(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.f8848B9tovu.A5SV6n()) {
            return null;
        }
        View A4TApA2 = this.f8848B9tovu.A4TApA(fragment.mContainerId);
        if (A4TApA2 instanceof ViewGroup) {
            return (ViewGroup) A4TApA2;
        }
        return null;
    }

    public final FragmentFactory BpkvW3() {
        Fragment fragment = this.f8849BChYOn;
        return fragment != null ? fragment.mFragmentManager.BpkvW3() : this.f8851BIYEnU;
    }

    public final OLy1FW.AzWtSf C2rE4F() {
        Fragment fragment = this.f8849BChYOn;
        return fragment != null ? fragment.mFragmentManager.C2rE4F() : this.f8852BJ7GGh;
    }

    public final boolean CNPG0E() {
        Fragment fragment = this.f8849BChYOn;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f8849BChYOn.getParentFragmentManager().CNPG0E();
    }

    public final boolean CQhlFr() {
        return this.f8858BniPrB || this.BpkvW3;
    }

    public final void CSDoyG(int i, boolean z) {
        HashMap hashMap;
        CQhlFr cQhlFr;
        if (this.f8847B7CMnp == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f8846B4ZgIw) {
            this.f8846B4ZgIw = i;
            DV2E8K dv2e8k = this.f8831A5SV6n;
            Iterator it = dv2e8k.f8905A2egSU.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                hashMap = dv2e8k.f8906A4TApA;
                if (!hasNext) {
                    break;
                }
                DUi7mC dUi7mC = (DUi7mC) hashMap.get(((Fragment) it.next()).mWho);
                if (dUi7mC != null) {
                    dUi7mC.AZOQYO();
                }
            }
            for (DUi7mC dUi7mC2 : hashMap.values()) {
                if (dUi7mC2 != null) {
                    dUi7mC2.AZOQYO();
                    Fragment fragment = dUi7mC2.f8903A5SV6n;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        if (fragment.mBeingSaved && !dv2e8k.f8907A5SV6n.containsKey(fragment.mWho)) {
                            dv2e8k.AZOQYO(dUi7mC2.AcNBzu(), fragment.mWho);
                        }
                        dv2e8k.AYUAbz(dUi7mC2);
                    }
                }
            }
            Iterator it2 = dv2e8k.ADYaiT().iterator();
            while (it2.hasNext()) {
                DUi7mC dUi7mC3 = (DUi7mC) it2.next();
                Fragment fragment2 = dUi7mC3.f8903A5SV6n;
                if (fragment2.mDeferStart) {
                    if (this.f8830A4TApA) {
                        this.f8860C4FrIb = true;
                    } else {
                        fragment2.mDeferStart = false;
                        dUi7mC3.AZOQYO();
                    }
                }
            }
            if (this.f8857BmvVmW && (cQhlFr = this.f8847B7CMnp) != null && this.f8846B4ZgIw == 7) {
                ((C2rE4F) cQhlFr).f8802B25kr6.invalidateMenu();
                this.f8857BmvVmW = false;
            }
        }
    }

    public final void CTkVKb() {
        if (this.f8847B7CMnp == null) {
            return;
        }
        this.f8858BniPrB = false;
        this.BpkvW3 = false;
        this.f8864CQhlFr.f8885AZOQYO = false;
        for (Fragment fragment : this.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void CcAIMM(int i, int i2, boolean z) {
        if (i < 0) {
            throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "Bad id: "));
        }
        BChYOn(new D6yqiO(this, null, i, i2), z);
    }

    public final boolean Cd8JRx() {
        return CikNvS(-1, 0, null);
    }

    public final boolean CikNvS(int i, int i2, String str) {
        BIYEnU(false);
        BI9f7h(true);
        Fragment fragment = this.f8850BI9f7h;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().Cd8JRx()) {
            return true;
        }
        boolean CkXcdM2 = CkXcdM(this.f8861CASmeH, this.f8862CNPG0E, str, i, i2);
        if (CkXcdM2) {
            this.f8830A4TApA = true;
            try {
                CrfGsy(this.f8861CASmeH, this.f8862CNPG0E);
            } finally {
                ADYaiT();
            }
        }
        DRlcZ9();
        boolean z = this.f8860C4FrIb;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        if (z) {
            this.f8860C4FrIb = false;
            Iterator it = dv2e8k.ADYaiT().iterator();
            while (it.hasNext()) {
                DUi7mC dUi7mC = (DUi7mC) it.next();
                Fragment fragment2 = dUi7mC.f8903A5SV6n;
                if (fragment2.mDeferStart) {
                    if (this.f8830A4TApA) {
                        this.f8860C4FrIb = true;
                    } else {
                        fragment2.mDeferStart = false;
                        dUi7mC.AZOQYO();
                    }
                }
            }
        }
        dv2e8k.f8906A4TApA.values().removeAll(Collections.singleton(null));
        return CkXcdM2;
    }

    public final boolean CkXcdM(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        ArrayList arrayList3 = this.f8832ADYaiT;
        int i3 = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (str != null || i >= 0) {
                int size = this.f8832ADYaiT.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.A2egSU a2egSU = (androidx.fragment.app.A2egSU) this.f8832ADYaiT.get(size);
                    if ((str != null && str.equals(a2egSU.f8924AZOQYO)) || (i >= 0 && i == a2egSU.f8704B7CMnp)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i3 = size;
                } else if (z) {
                    i3 = size;
                    while (i3 > 0) {
                        androidx.fragment.app.A2egSU a2egSU2 = (androidx.fragment.app.A2egSU) this.f8832ADYaiT.get(i3 - 1);
                        if ((str == null || !str.equals(a2egSU2.f8924AZOQYO)) && (i < 0 || i != a2egSU2.f8704B7CMnp)) {
                            break;
                        }
                        i3--;
                    }
                } else if (size != this.f8832ADYaiT.size() - 1) {
                    i3 = size + 1;
                }
            } else {
                i3 = z ? 0 : this.f8832ADYaiT.size() - 1;
            }
        }
        if (i3 < 0) {
            return false;
        }
        for (int size2 = this.f8832ADYaiT.size() - 1; size2 >= i3; size2--) {
            arrayList.add((androidx.fragment.app.A2egSU) this.f8832ADYaiT.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void CmUvjW(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            DAk1zC(new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void CqNSpT(Fragment fragment) {
        if (C4FrIb(2)) {
            Objects.toString(fragment);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && isInBackStack) {
            return;
        }
        DV2E8K dv2e8k = this.f8831A5SV6n;
        synchronized (dv2e8k.f8905A2egSU) {
            dv2e8k.f8905A2egSU.remove(fragment);
        }
        fragment.mAdded = false;
        if (CASmeH(fragment)) {
            this.f8857BmvVmW = true;
        }
        fragment.mRemoving = true;
        D9tr6l(fragment);
    }

    public final void CrfGsy(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((androidx.fragment.app.A2egSU) arrayList.get(i)).f8931B25kr6) {
                if (i2 != i) {
                    BNL6CD(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((androidx.fragment.app.A2egSU) arrayList.get(i2)).f8931B25kr6) {
                        i2++;
                    }
                }
                BNL6CD(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            BNL6CD(arrayList, arrayList2, i2, size);
        }
    }

    public final void CtFAbx(Bundle bundle) {
        Cd8JRx cd8JRx;
        DUi7mC dUi7mC;
        Bundle bundle2;
        Bundle bundle3;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle3 = bundle.getBundle(str)) != null) {
                bundle3.setClassLoader(this.f8847B7CMnp.getContext().getClassLoader());
                this.f8838AaHO0E.put(str.substring(7), bundle3);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle2 = bundle.getBundle(str2)) != null) {
                bundle2.setClassLoader(this.f8847B7CMnp.getContext().getClassLoader());
                hashMap.put(str2.substring(9), bundle2);
            }
        }
        DV2E8K dv2e8k = this.f8831A5SV6n;
        HashMap hashMap2 = dv2e8k.f8907A5SV6n;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        D8cQ8b d8cQ8b = (D8cQ8b) bundle.getParcelable("state");
        if (d8cQ8b == null) {
            return;
        }
        HashMap hashMap3 = dv2e8k.f8906A4TApA;
        hashMap3.clear();
        Iterator it = d8cQ8b.f8872AcNBzu.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            cd8JRx = this.f8839AcNBzu;
            if (!hasNext) {
                break;
            }
            Bundle AZOQYO2 = dv2e8k.AZOQYO(null, (String) it.next());
            if (AZOQYO2 != null) {
                Fragment fragment = (Fragment) this.f8864CQhlFr.f8881ADYaiT.get(((DG07BK) AZOQYO2.getParcelable("state")).f8887AlLFFp);
                if (fragment != null) {
                    if (C4FrIb(2)) {
                        fragment.toString();
                    }
                    dUi7mC = new DUi7mC(cd8JRx, dv2e8k, fragment, AZOQYO2);
                } else {
                    dUi7mC = new DUi7mC(this.f8839AcNBzu, this.f8831A5SV6n, this.f8847B7CMnp.getContext().getClassLoader(), BpkvW3(), AZOQYO2);
                }
                Fragment fragment2 = dUi7mC.f8903A5SV6n;
                fragment2.mSavedFragmentState = AZOQYO2;
                fragment2.mFragmentManager = this;
                if (C4FrIb(2)) {
                    fragment2.toString();
                }
                dUi7mC.AZkASS(this.f8847B7CMnp.getContext().getClassLoader());
                dv2e8k.ASJ6gh(dUi7mC);
                dUi7mC.AMqCpz = this.f8846B4ZgIw;
            }
        }
        D9tr6l d9tr6l = this.f8864CQhlFr;
        d9tr6l.getClass();
        Iterator it2 = new ArrayList(d9tr6l.f8881ADYaiT.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (hashMap3.get(fragment3.mWho) == null) {
                if (C4FrIb(2)) {
                    fragment3.toString();
                    Objects.toString(d8cQ8b.f8872AcNBzu);
                }
                this.f8864CQhlFr.AMqCpz(fragment3);
                fragment3.mFragmentManager = this;
                DUi7mC dUi7mC2 = new DUi7mC(cd8JRx, dv2e8k, fragment3);
                dUi7mC2.AMqCpz = 1;
                dUi7mC2.AZOQYO();
                fragment3.mRemoving = true;
                dUi7mC2.AZOQYO();
            }
        }
        ArrayList<String> arrayList = d8cQ8b.f8873AlLFFp;
        dv2e8k.f8905A2egSU.clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                Fragment A4TApA2 = dv2e8k.A4TApA(str3);
                if (A4TApA2 == null) {
                    throw new IllegalStateException(ADYaiT.CtFAbx.BI9f7h("No instantiated fragment for (", str3, ")"));
                }
                if (C4FrIb(2)) {
                    A4TApA2.toString();
                }
                dv2e8k.A2egSU(A4TApA2);
            }
        }
        if (d8cQ8b.f8874AmA8tU != null) {
            this.f8832ADYaiT = new ArrayList(d8cQ8b.f8874AmA8tU.length);
            int i = 0;
            while (true) {
                A4TApA[] a4TApAArr = d8cQ8b.f8874AmA8tU;
                if (i >= a4TApAArr.length) {
                    break;
                }
                A4TApA a4TApA = a4TApAArr[i];
                a4TApA.getClass();
                androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(this);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr = a4TApA.f8705AcNBzu;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    DXnQ0V dXnQ0V = new DXnQ0V();
                    int i4 = i2 + 1;
                    dXnQ0V.f8909A2egSU = iArr[i2];
                    if (C4FrIb(2)) {
                        Objects.toString(a2egSU);
                        int i5 = iArr[i4];
                    }
                    dXnQ0V.f8915AYUAbz = androidx.lifecycle.AmA8tU.values()[a4TApA.f8707AmA8tU[i3]];
                    dXnQ0V.f8916AZOQYO = androidx.lifecycle.AmA8tU.values()[a4TApA.f8708AzWtSf[i3]];
                    int i6 = i2 + 2;
                    dXnQ0V.f8911A5SV6n = iArr[i4] != 0;
                    int i7 = iArr[i6];
                    dXnQ0V.f8912ADYaiT = i7;
                    int i8 = iArr[i2 + 3];
                    dXnQ0V.AMqCpz = i8;
                    int i9 = i2 + 5;
                    int i10 = iArr[i2 + 4];
                    dXnQ0V.f8913ARc23Z = i10;
                    i2 += 6;
                    int i11 = iArr[i9];
                    dXnQ0V.f8914ASJ6gh = i11;
                    a2egSU.f8918A4TApA = i7;
                    a2egSU.f8919A5SV6n = i8;
                    a2egSU.f8920ADYaiT = i10;
                    a2egSU.AMqCpz = i11;
                    a2egSU.A4TApA(dXnQ0V);
                    i3++;
                }
                a2egSU.f8921ARc23Z = a4TApA.f8709B25kr6;
                a2egSU.f8924AZOQYO = a4TApA.f8710B2KMhB;
                a2egSU.f8922ASJ6gh = true;
                a2egSU.f8925AZkASS = a4TApA.f8712B4ZgIw;
                a2egSU.f8926AaHO0E = a4TApA.f8713B7CMnp;
                a2egSU.f8927AcNBzu = a4TApA.f8714B9tovu;
                a2egSU.f8928AlLFFp = a4TApA.f8715BChYOn;
                a2egSU.f8929AmA8tU = a4TApA.f8716BI9f7h;
                a2egSU.f8930AzWtSf = a4TApA.f8717BIYEnU;
                a2egSU.f8931B25kr6 = a4TApA.f8718BJ7GGh;
                a2egSU.f8704B7CMnp = a4TApA.f8711B3GDIM;
                int i12 = 0;
                while (true) {
                    ArrayList arrayList2 = a4TApA.f8706AlLFFp;
                    if (i12 >= arrayList2.size()) {
                        break;
                    }
                    String str4 = (String) arrayList2.get(i12);
                    if (str4 != null) {
                        ((DXnQ0V) a2egSU.f8917A2egSU.get(i12)).f8910A4TApA = dv2e8k.A4TApA(str4);
                    }
                    i12++;
                }
                a2egSU.B25kr6(1);
                if (C4FrIb(2)) {
                    a2egSU.toString();
                    PrintWriter printWriter = new PrintWriter(new QkAq4X.AMqCpz(1));
                    a2egSU.B3GDIM("  ", printWriter, false);
                    printWriter.close();
                }
                this.f8832ADYaiT.add(a2egSU);
                i++;
            }
        } else {
            this.f8832ADYaiT = null;
        }
        this.f8836AZOQYO.set(d8cQ8b.f8875AzWtSf);
        String str5 = d8cQ8b.f8876B25kr6;
        if (str5 != null) {
            Fragment A4TApA3 = dv2e8k.A4TApA(str5);
            this.f8850BI9f7h = A4TApA3;
            B2KMhB(A4TApA3);
        }
        ArrayList arrayList3 = d8cQ8b.f8877B2KMhB;
        if (arrayList3 != null) {
            for (int i13 = 0; i13 < arrayList3.size(); i13++) {
                this.f8837AZkASS.put((String) arrayList3.get(i13), (A5SV6n) d8cQ8b.f8878B3GDIM.get(i13));
            }
        }
        this.f8856BV3sI0 = new ArrayDeque(d8cQ8b.f8879B4ZgIw);
    }

    public final Bundle CtxOCS() {
        A4TApA[] a4TApAArr;
        ArrayList arrayList;
        int size;
        Bundle bundle = new Bundle();
        BV3sI0();
        Iterator it = AMqCpz().iterator();
        while (it.hasNext()) {
            ((AmA8tU) it.next()).ASJ6gh();
        }
        BIYEnU(true);
        this.f8858BniPrB = true;
        this.f8864CQhlFr.f8885AZOQYO = true;
        DV2E8K dv2e8k = this.f8831A5SV6n;
        dv2e8k.getClass();
        HashMap hashMap = dv2e8k.f8906A4TApA;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (DUi7mC dUi7mC : hashMap.values()) {
            if (dUi7mC != null) {
                Fragment fragment = dUi7mC.f8903A5SV6n;
                dv2e8k.AZOQYO(dUi7mC.AcNBzu(), fragment.mWho);
                arrayList2.add(fragment.mWho);
                if (C4FrIb(2)) {
                    fragment.toString();
                    Objects.toString(fragment.mSavedFragmentState);
                }
            }
        }
        HashMap hashMap2 = this.f8831A5SV6n.f8907A5SV6n;
        if (hashMap2.isEmpty()) {
            C4FrIb(2);
            return bundle;
        }
        DV2E8K dv2e8k2 = this.f8831A5SV6n;
        synchronized (dv2e8k2.f8905A2egSU) {
            try {
                a4TApAArr = null;
                if (dv2e8k2.f8905A2egSU.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(dv2e8k2.f8905A2egSU.size());
                    Iterator it2 = dv2e8k2.f8905A2egSU.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment2 = (Fragment) it2.next();
                        arrayList.add(fragment2.mWho);
                        if (C4FrIb(2)) {
                            fragment2.toString();
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = this.f8832ADYaiT;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            a4TApAArr = new A4TApA[size];
            for (int i = 0; i < size; i++) {
                a4TApAArr[i] = new A4TApA((androidx.fragment.app.A2egSU) this.f8832ADYaiT.get(i));
                if (C4FrIb(2)) {
                    Objects.toString(this.f8832ADYaiT.get(i));
                }
            }
        }
        D8cQ8b d8cQ8b = new D8cQ8b();
        d8cQ8b.f8872AcNBzu = arrayList2;
        d8cQ8b.f8873AlLFFp = arrayList;
        d8cQ8b.f8874AmA8tU = a4TApAArr;
        d8cQ8b.f8875AzWtSf = this.f8836AZOQYO.get();
        Fragment fragment3 = this.f8850BI9f7h;
        if (fragment3 != null) {
            d8cQ8b.f8876B25kr6 = fragment3.mWho;
        }
        d8cQ8b.f8877B2KMhB.addAll(this.f8837AZkASS.keySet());
        d8cQ8b.f8878B3GDIM.addAll(this.f8837AZkASS.values());
        d8cQ8b.f8879B4ZgIw = new ArrayList(this.f8856BV3sI0);
        bundle.putParcelable("state", d8cQ8b);
        for (String str : this.f8838AaHO0E.keySet()) {
            bundle.putBundle(ADYaiT.CtFAbx.BChYOn("result_", str), (Bundle) this.f8838AaHO0E.get(str));
        }
        for (String str2 : hashMap2.keySet()) {
            bundle.putBundle(ADYaiT.CtFAbx.BChYOn("fragment_", str2), (Bundle) hashMap2.get(str2));
        }
        return bundle;
    }

    public final BV3sI0 D07BeM(Fragment fragment) {
        DUi7mC dUi7mC = (DUi7mC) this.f8831A5SV6n.f8906A4TApA.get(fragment.mWho);
        if (dUi7mC != null) {
            Fragment fragment2 = dUi7mC.f8903A5SV6n;
            if (fragment2.equals(fragment)) {
                if (fragment2.mState > -1) {
                    return new BV3sI0(dUi7mC.AcNBzu());
                }
                return null;
            }
        }
        DAk1zC(new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", fragment, " is not currently in the FragmentManager")));
        throw null;
    }

    public final void D6DOie() {
        synchronized (this.f8829A2egSU) {
            try {
                if (this.f8829A2egSU.size() == 1) {
                    this.f8847B7CMnp.f8813AmA8tU.removeCallbacks(this.f8865CSDoyG);
                    this.f8847B7CMnp.f8813AmA8tU.post(this.f8865CSDoyG);
                    DRlcZ9();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void D6yqiO(Fragment fragment, boolean z) {
        ViewGroup BniPrB2 = BniPrB(fragment);
        if (BniPrB2 == null || !(BniPrB2 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) BniPrB2).setDrawDisappearingViewsLast(!z);
    }

    public final void D8MqeW(Fragment fragment, androidx.lifecycle.AmA8tU amA8tU) {
        if (fragment.equals(this.f8831A5SV6n.A4TApA(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = amA8tU;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void D8cQ8b(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f8831A5SV6n.A4TApA(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.f8850BI9f7h;
        this.f8850BI9f7h = fragment;
        B2KMhB(fragment2);
        B2KMhB(this.f8850BI9f7h);
    }

    public final void D9tr6l(Fragment fragment) {
        ViewGroup BniPrB2 = BniPrB(fragment);
        if (BniPrB2 != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (BniPrB2.getTag(2131298317) == null) {
                    BniPrB2.setTag(2131298317, fragment);
                }
                ((Fragment) BniPrB2.getTag(2131298317)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void DAk1zC(IllegalStateException illegalStateException) {
        illegalStateException.getMessage();
        PrintWriter printWriter = new PrintWriter(new QkAq4X.AMqCpz(1));
        CQhlFr cQhlFr = this.f8847B7CMnp;
        try {
            if (cQhlFr != null) {
                ((C2rE4F) cQhlFr).f8802B25kr6.dump("  ", null, printWriter, new String[0]);
            } else {
                B9tovu("  ", null, printWriter, new String[0]);
            }
            throw illegalStateException;
        } catch (Exception unused) {
            throw illegalStateException;
        }
    }

    public final void DG07BK(A2egSU a2egSU) {
        Cd8JRx cd8JRx = this.f8839AcNBzu;
        synchronized (cd8JRx.f8820A2egSU) {
            try {
                int size = cd8JRx.f8820A2egSU.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (((CcAIMM) cd8JRx.f8820A2egSU.get(i)).f8818A2egSU == a2egSU) {
                        cd8JRx.f8820A2egSU.remove(i);
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void DRlcZ9() {
        synchronized (this.f8829A2egSU) {
            try {
                if (!this.f8829A2egSU.isEmpty()) {
                    MOpbMP.BmvVmW bmvVmW = this.f8835AYUAbz;
                    bmvVmW.f5056A2egSU = true;
                    androidx.activity.B7CMnp b7CMnp = bmvVmW.f5058A5SV6n;
                    if (b7CMnp != null) {
                        b7CMnp.invoke();
                    }
                    return;
                }
                MOpbMP.BmvVmW bmvVmW2 = this.f8835AYUAbz;
                ArrayList arrayList = this.f8832ADYaiT;
                bmvVmW2.f5056A2egSU = (arrayList != null ? arrayList.size() : 0) > 0 && COJEAR(this.f8849BChYOn);
                androidx.activity.B7CMnp b7CMnp2 = bmvVmW2.f5058A5SV6n;
                if (b7CMnp2 != null) {
                    b7CMnp2.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f8849BChYOn;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f8849BChYOn)));
            sb.append("}");
        } else {
            CQhlFr cQhlFr = this.f8847B7CMnp;
            if (cQhlFr != null) {
                sb.append(cQhlFr.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f8847B7CMnp)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}
