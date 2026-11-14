package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DUi7mC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Cd8JRx f8901A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final DV2E8K f8902A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Fragment f8903A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f8904ADYaiT = false;
    public int AMqCpz = -1;

    public DUi7mC(Cd8JRx cd8JRx, DV2E8K dv2e8k, Fragment fragment) {
        this.f8901A2egSU = cd8JRx;
        this.f8902A4TApA = dv2e8k;
        this.f8903A5SV6n = fragment;
    }

    public final void A2egSU() {
        Fragment fragment;
        View view;
        View view2;
        int i = -1;
        Fragment fragment2 = this.f8903A5SV6n;
        View view3 = fragment2.mContainer;
        while (true) {
            fragment = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(2131296696);
            Fragment fragment3 = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment3 != null) {
                fragment = fragment3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        Fragment parentFragment = fragment2.getParentFragment();
        if (fragment != null && !fragment.equals(parentFragment)) {
            int i2 = fragment2.mContainerId;
            D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(fragment2);
            sb.append(" within the view of parent fragment ");
            sb.append(fragment);
            sb.append(" via container with ID ");
            D6yqiO.ADYaiT.A4TApA(new D6yqiO.A2egSU(fragment2, ADYaiT.CtFAbx.AZkASS(" without using parent's childFragmentManager", i2, sb)));
            D6yqiO.ADYaiT.A2egSU(fragment2).getClass();
        }
        DV2E8K dv2e8k = this.f8902A4TApA;
        dv2e8k.getClass();
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup != null) {
            ArrayList arrayList = dv2e8k.f8905A2egSU;
            int indexOf = arrayList.indexOf(fragment2);
            int i3 = indexOf - 1;
            while (true) {
                if (i3 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment4 = (Fragment) arrayList.get(indexOf);
                        if (fragment4.mContainer == viewGroup && (view = fragment4.mView) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment5 = (Fragment) arrayList.get(i3);
                    if (fragment5.mContainer == viewGroup && (view2 = fragment5.mView) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i3--;
                }
            }
        }
        fragment2.mContainer.addView(fragment2.mView, i);
    }

    public final void A4TApA() {
        boolean C4FrIb2 = CtxOCS.C4FrIb(3);
        Fragment fragment = this.f8903A5SV6n;
        if (C4FrIb2) {
            Objects.toString(fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        DUi7mC dUi7mC = null;
        DV2E8K dv2e8k = this.f8902A4TApA;
        if (fragment2 != null) {
            DUi7mC dUi7mC2 = (DUi7mC) dv2e8k.f8906A4TApA.get(fragment2.mWho);
            if (dUi7mC2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            dUi7mC = dUi7mC2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (dUi7mC = (DUi7mC) dv2e8k.f8906A4TApA.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(ADYaiT.CtFAbx.B25kr6(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (dUi7mC != null) {
            dUi7mC.AZOQYO();
        }
        CtxOCS ctxOCS = fragment.mFragmentManager;
        fragment.mHost = ctxOCS.f8847B7CMnp;
        fragment.mParentFragment = ctxOCS.f8849BChYOn;
        Cd8JRx cd8JRx = this.f8901A2egSU;
        cd8JRx.ASJ6gh(fragment, false);
        fragment.performAttach();
        cd8JRx.A4TApA(fragment, false);
    }

    public final int A5SV6n() {
        Object obj;
        Fragment fragment = this.f8903A5SV6n;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i = this.AMqCpz;
        int ordinal = fragment.mMaxState.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                i = Math.max(this.AMqCpz, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.AMqCpz < 4 ? Math.min(i, fragment.mState) : Math.min(i, 1);
            }
        }
        if (!fragment.mAdded) {
            i = Math.min(i, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            AmA8tU AYUAbz2 = AmA8tU.AYUAbz(viewGroup, fragment.getParentFragmentManager());
            AYUAbz2.getClass();
            DyaChj ARc23Z2 = AYUAbz2.ARc23Z(fragment);
            int i2 = ARc23Z2 != null ? ARc23Z2.f8954A4TApA : 0;
            Iterator it = AYUAbz2.f8755A5SV6n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                DyaChj dyaChj = (DyaChj) obj;
                if (RXb0Sz.ARc23Z.A2egSU(dyaChj.f8955A5SV6n, fragment) && !dyaChj.f8957ARc23Z) {
                    break;
                }
            }
            DyaChj dyaChj2 = (DyaChj) obj;
            r5 = dyaChj2 != null ? dyaChj2.f8954A4TApA : 0;
            int i3 = i2 == 0 ? -1 : EGM26s.f8961A2egSU[B4ZgIw.AYUAbz.ADYaiT(i2)];
            if (i3 != -1 && i3 != 1) {
                r5 = i2;
            }
        }
        if (r5 == 2) {
            i = Math.min(i, 6);
        } else if (r5 == 3) {
            i = Math.max(i, 3);
        } else if (fragment.mRemoving) {
            i = fragment.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            i = Math.min(i, 4);
        }
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(fragment);
        }
        return i;
    }

    public final void ADYaiT() {
        String str;
        Fragment fragment = this.f8903A5SV6n;
        if (fragment.mFromLayout) {
            return;
        }
        if (CtxOCS.C4FrIb(3)) {
            Objects.toString(fragment);
        }
        Bundle bundle = fragment.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(bundle2);
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException(J3FDQU.A2egSU.AzWtSf("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.f8848B9tovu.A4TApA(i);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            str = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
                    D6yqiO.ADYaiT.A4TApA(new D6yqiO.A2egSU(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    D6yqiO.ADYaiT.A2egSU(fragment).getClass();
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(performGetLayoutInflater, viewGroup, bundle2);
        if (fragment.mView != null) {
            if (CtxOCS.C4FrIb(3)) {
                Objects.toString(fragment);
            }
            fragment.mView.setSaveFromParentEnabled(false);
            fragment.mView.setTag(2131296696, fragment);
            if (viewGroup != null) {
                A2egSU();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view = fragment.mView;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            if (view.isAttachedToWindow()) {
                COJEAR.CikNvS.A5SV6n(fragment.mView);
            } else {
                View view2 = fragment.mView;
                view2.addOnAttachStateChangeListener(new DRlcZ9(view2));
            }
            fragment.performViewCreated();
            this.f8901A2egSU.AlLFFp(fragment, fragment.mView, bundle2, false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (CtxOCS.C4FrIb(2)) {
                        findFocus.toString();
                        Objects.toString(fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void AMqCpz() {
        Fragment A4TApA2;
        boolean C4FrIb2 = CtxOCS.C4FrIb(3);
        Fragment fragment = this.f8903A5SV6n;
        if (C4FrIb2) {
            Objects.toString(fragment);
        }
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        DV2E8K dv2e8k = this.f8902A4TApA;
        if (z2 && !fragment.mBeingSaved) {
            dv2e8k.AZOQYO(null, fragment.mWho);
        }
        if (!z2) {
            D9tr6l d9tr6l = dv2e8k.f8908ADYaiT;
            if (!((d9tr6l.f8881ADYaiT.containsKey(fragment.mWho) && d9tr6l.f8883ASJ6gh) ? d9tr6l.f8884AYUAbz : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (A4TApA2 = dv2e8k.A4TApA(str)) != null && A4TApA2.mRetainInstance) {
                    fragment.mTarget = A4TApA2;
                }
                fragment.mState = 0;
                return;
            }
        }
        CQhlFr cQhlFr = fragment.mHost;
        if (cQhlFr instanceof androidx.lifecycle.D07BeM) {
            z = dv2e8k.f8908ADYaiT.f8884AYUAbz;
        } else if (cQhlFr.getContext() instanceof Activity) {
            z = true ^ ((Activity) cQhlFr.getContext()).isChangingConfigurations();
        }
        if ((z2 && !fragment.mBeingSaved) || z) {
            D9tr6l d9tr6l2 = dv2e8k.f8908ADYaiT;
            d9tr6l2.getClass();
            if (CtxOCS.C4FrIb(3)) {
                Objects.toString(fragment);
            }
            d9tr6l2.ADYaiT(fragment.mWho);
        }
        fragment.performDestroy();
        this.f8901A2egSU.ADYaiT(fragment, false);
        Iterator it = dv2e8k.ADYaiT().iterator();
        while (it.hasNext()) {
            DUi7mC dUi7mC = (DUi7mC) it.next();
            if (dUi7mC != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = dUi7mC.f8903A5SV6n;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = dv2e8k.A4TApA(str3);
        }
        dv2e8k.AYUAbz(this);
    }

    public final void ARc23Z() {
        View view;
        boolean C4FrIb2 = CtxOCS.C4FrIb(3);
        Fragment fragment = this.f8903A5SV6n;
        if (C4FrIb2) {
            Objects.toString(fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f8901A2egSU.AmA8tU(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.AMqCpz(null);
        fragment.mInLayout = false;
    }

    public final void ASJ6gh() {
        boolean C4FrIb2 = CtxOCS.C4FrIb(3);
        Fragment fragment = this.f8903A5SV6n;
        if (C4FrIb2) {
            Objects.toString(fragment);
        }
        fragment.performDetach();
        this.f8901A2egSU.AMqCpz(fragment, false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            D9tr6l d9tr6l = this.f8902A4TApA.f8908ADYaiT;
            if (!((d9tr6l.f8881ADYaiT.containsKey(fragment.mWho) && d9tr6l.f8883ASJ6gh) ? d9tr6l.f8884AYUAbz : true)) {
                return;
            }
        }
        if (CtxOCS.C4FrIb(3)) {
            Objects.toString(fragment);
        }
        fragment.initState();
    }

    public final void AYUAbz() {
        Fragment fragment = this.f8903A5SV6n;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (CtxOCS.C4FrIb(3)) {
                Objects.toString(fragment);
            }
            Bundle bundle = fragment.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            fragment.performCreateView(fragment.performGetLayoutInflater(bundle2), null, bundle2);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(2131296696, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f8901A2egSU.AlLFFp(fragment, fragment.mView, bundle2, false);
                fragment.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0181, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZOQYO() {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DUi7mC.AZOQYO():void");
    }

    public final void AZkASS(ClassLoader classLoader) {
        Fragment fragment = this.f8903A5SV6n;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (fragment.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            fragment.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("viewRegistryState");
        DG07BK dg07bk = (DG07BK) fragment.mSavedFragmentState.getParcelable("state");
        if (dg07bk != null) {
            fragment.mTargetWho = dg07bk.f8897BI9f7h;
            fragment.mTargetRequestCode = dg07bk.f8898BIYEnU;
            Boolean bool = fragment.mSavedUserVisibleHint;
            if (bool != null) {
                fragment.mUserVisibleHint = bool.booleanValue();
                fragment.mSavedUserVisibleHint = null;
            } else {
                fragment.mUserVisibleHint = dg07bk.f8899BJ7GGh;
            }
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    public final void AaHO0E() {
        boolean C4FrIb2 = CtxOCS.C4FrIb(3);
        Fragment fragment = this.f8903A5SV6n;
        if (C4FrIb2) {
            Objects.toString(fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            if (focusedView != fragment.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != fragment.mView) {
                    }
                }
            }
            focusedView.requestFocus();
            if (CtxOCS.C4FrIb(2)) {
                focusedView.toString();
                Objects.toString(fragment);
                Objects.toString(fragment.mView.findFocus());
            }
        }
        fragment.setFocusedView(null);
        fragment.performResume();
        this.f8901A2egSU.AZOQYO(fragment, false);
        this.f8902A4TApA.AZOQYO(null, fragment.mWho);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle AcNBzu() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f8903A5SV6n;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new DG07BK(fragment));
        if (fragment.mState > -1) {
            Bundle bundle3 = new Bundle();
            fragment.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f8901A2egSU.AZkASS(fragment, bundle3, false);
            Bundle bundle4 = new Bundle();
            fragment.mSavedStateRegistryController.A5SV6n(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle CtxOCS2 = fragment.mChildFragmentManager.CtxOCS();
            if (!CtxOCS2.isEmpty()) {
                bundle2.putBundle("childFragmentManager", CtxOCS2);
            }
            if (fragment.mView != null) {
                AlLFFp();
            }
            SparseArray<Parcelable> sparseArray = fragment.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = fragment.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = fragment.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void AlLFFp() {
        Fragment fragment = this.f8903A5SV6n;
        if (fragment.mView == null) {
            return;
        }
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(fragment);
            Objects.toString(fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.f8949B2KMhB.A5SV6n(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public DUi7mC(Cd8JRx cd8JRx, DV2E8K dv2e8k, ClassLoader classLoader, FragmentFactory fragmentFactory, Bundle bundle) {
        this.f8901A2egSU = cd8JRx;
        this.f8902A4TApA = dv2e8k;
        DG07BK dg07bk = (DG07BK) bundle.getParcelable("state");
        Fragment A2egSU2 = fragmentFactory.A2egSU(classLoader, dg07bk.f8886AcNBzu);
        A2egSU2.mWho = dg07bk.f8887AlLFFp;
        A2egSU2.mFromLayout = dg07bk.f8888AmA8tU;
        A2egSU2.mRestored = true;
        A2egSU2.mFragmentId = dg07bk.f8889AzWtSf;
        A2egSU2.mContainerId = dg07bk.f8890B25kr6;
        A2egSU2.mTag = dg07bk.f8891B2KMhB;
        A2egSU2.mRetainInstance = dg07bk.f8892B3GDIM;
        A2egSU2.mRemoving = dg07bk.f8893B4ZgIw;
        A2egSU2.mDetached = dg07bk.f8894B7CMnp;
        A2egSU2.mHidden = dg07bk.f8895B9tovu;
        A2egSU2.mMaxState = androidx.lifecycle.AmA8tU.values()[dg07bk.f8896BChYOn];
        A2egSU2.mTargetWho = dg07bk.f8897BI9f7h;
        A2egSU2.mTargetRequestCode = dg07bk.f8898BIYEnU;
        A2egSU2.mUserVisibleHint = dg07bk.f8899BJ7GGh;
        this.f8903A5SV6n = A2egSU2;
        A2egSU2.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        A2egSU2.setArguments(bundle2);
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(A2egSU2);
        }
    }

    public DUi7mC(Cd8JRx cd8JRx, DV2E8K dv2e8k, Fragment fragment, Bundle bundle) {
        this.f8901A2egSU = cd8JRx;
        this.f8902A4TApA = dv2e8k;
        this.f8903A5SV6n = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
