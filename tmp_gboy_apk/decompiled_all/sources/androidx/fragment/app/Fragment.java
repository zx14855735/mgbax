package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import com.sigmob.sdk.base.views.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.B9tovu, androidx.lifecycle.D07BeM, androidx.lifecycle.AZOQYO, DV2E8K.ARc23Z {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    BPw6Q8 mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.CqNSpT mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    CtxOCS mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    CQhlFr mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.BI9f7h mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    DV2E8K.AMqCpz mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    DuwtYk mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    CtxOCS mChildFragmentManager = new D8MqeW();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new BChYOn(this, 0);
    androidx.lifecycle.AmA8tU mMaxState = androidx.lifecycle.AmA8tU.f8981B25kr6;
    androidx.lifecycle.BTvldC mViewLifecycleOwnerLiveData = new androidx.lifecycle.BTvldC();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<BTvldC> mOnPreAttachedListeners = new ArrayList<>();
    private final BTvldC mSavedStateAttachListener = new BI9f7h(this);

    static {
        OIwHE();
    }

    public Fragment() {
        AYUAbz();
    }

    private static /* synthetic */ void OIwHE() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final BPw6Q8 AMqCpz() {
        if (this.mAnimationInfo == null) {
            BPw6Q8 bPw6Q8 = new BPw6Q8();
            bPw6Q8.f8783AZOQYO = null;
            Object obj = USE_DEFAULT_TRANSITION;
            bPw6Q8.f8784AZkASS = obj;
            bPw6Q8.f8785AaHO0E = null;
            bPw6Q8.f8786AcNBzu = obj;
            bPw6Q8.f8787AlLFFp = null;
            bPw6Q8.f8788AmA8tU = obj;
            bPw6Q8.f8791B2KMhB = null;
            bPw6Q8.f8792B3GDIM = null;
            bPw6Q8.f8793B4ZgIw = 1.0f;
            bPw6Q8.f8794B7CMnp = null;
            this.mAnimationInfo = bPw6Q8;
        }
        return this.mAnimationInfo;
    }

    public final int ARc23Z() {
        androidx.lifecycle.AmA8tU amA8tU = this.mMaxState;
        return (amA8tU == androidx.lifecycle.AmA8tU.f8978AlLFFp || this.mParentFragment == null) ? amA8tU.ordinal() : Math.min(amA8tU.ordinal(), this.mParentFragment.ARc23Z());
    }

    public final Fragment ASJ6gh(boolean z) {
        String str;
        if (z) {
            D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
            D6yqiO.ADYaiT.A4TApA(new D6yqiO.ARc23Z(this, "Attempting to get target fragment from fragment " + this));
            D6yqiO.ADYaiT.A2egSU(this).getClass();
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return ctxOCS.f8831A5SV6n.A4TApA(str);
    }

    public final void AYUAbz() {
        this.mLifecycleRegistry = new androidx.lifecycle.BI9f7h(this);
        this.mSavedStateRegistryController = new DV2E8K.AMqCpz(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        BTvldC bTvldC = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            bTvldC.A2egSU();
        } else {
            this.mOnPreAttachedListeners.add(bTvldC);
        }
    }

    public final B9tovu AZOQYO(A4TApA.A4TApA a4TApA, AmA8tU.A2egSU a2egSU, androidx.activity.result.A4TApA a4TApA2) {
        if (this.mState > 1) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        BNL6CD bnl6cd = new BNL6CD(this, a2egSU, atomicReference, a4TApA, a4TApA2);
        if (this.mState >= 0) {
            bnl6cd.A2egSU();
        } else {
            this.mOnPreAttachedListeners.add(bnl6cd);
        }
        return new B9tovu(atomicReference);
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        CtxOCS ctxOCS;
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 != null) {
            bPw6Q8.f8795B9tovu = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (ctxOCS = this.mFragmentManager) == null) {
            return;
        }
        AmA8tU AYUAbz2 = AmA8tU.AYUAbz(viewGroup, ctxOCS);
        AYUAbz2.AZOQYO();
        if (z) {
            this.mHost.f8813AmA8tU.post(new AzWtSf(1, AYUAbz2));
        } else {
            AYUAbz2.ADYaiT();
        }
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            this.mPostponedHandler = null;
        }
    }

    public CNPG0E createFragmentContainer() {
        return new BIYEnU(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment ASJ6gh2 = ASJ6gh(false);
        if (ASJ6gh2 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(ASJ6gh2);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            DAk1zC.A2egSU.A2egSU(this).A4TApA(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.B9tovu(ADYaiT.CtFAbx.AcNBzu(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f8831A5SV6n.A5SV6n(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr == null) {
            return null;
        }
        return (FragmentActivity) cQhlFr.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null || (bool = bPw6Q8.f8790B25kr6) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null || (bool = bPw6Q8.f8789AzWtSf) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        bPw6Q8.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final CtxOCS getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr == null) {
            return null;
        }
        return cQhlFr.getContext();
    }

    @Override // androidx.lifecycle.AZOQYO
    public D9tr6l.A4TApA getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && CtxOCS.C4FrIb(3)) {
            Objects.toString(requireContext().getApplicationContext());
        }
        D9tr6l.ADYaiT aDYaiT = new D9tr6l.ADYaiT();
        LinkedHashMap linkedHashMap = aDYaiT.f2052A2egSU;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.CkXcdM.f9033A2egSU, application);
        }
        linkedHashMap.put(androidx.lifecycle.CQhlFr.f9015A2egSU, this);
        linkedHashMap.put(androidx.lifecycle.CQhlFr.f9016A4TApA, this);
        if (getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.CQhlFr.f9017A5SV6n, getArguments());
        }
        return aDYaiT;
    }

    @Override // androidx.lifecycle.AZOQYO
    public androidx.lifecycle.CqNSpT getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && CtxOCS.C4FrIb(3)) {
                Objects.toString(requireContext().getApplicationContext());
            }
            this.mDefaultFactory = new androidx.lifecycle.CcAIMM(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 0;
        }
        return bPw6Q8.f8777A4TApA;
    }

    public Object getEnterTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8783AZOQYO;
    }

    public androidx.core.app.D07BeM getEnterTransitionCallback() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8791B2KMhB;
    }

    public int getExitAnim() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 0;
        }
        return bPw6Q8.f8778A5SV6n;
    }

    public Object getExitTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8785AaHO0E;
    }

    public androidx.core.app.D07BeM getExitTransitionCallback() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8792B3GDIM;
    }

    public View getFocusedView() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8794B7CMnp;
    }

    @Deprecated
    public final CtxOCS getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr == null) {
            return null;
        }
        return ((C2rE4F) cQhlFr).f8802B25kr6;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.B9tovu
    public androidx.lifecycle.AzWtSf getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public DAk1zC.A2egSU getLoaderManager() {
        return DAk1zC.A2egSU.A2egSU(this);
    }

    public int getNextTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 0;
        }
        return bPw6Q8.f8780ARc23Z;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final CtxOCS getParentFragmentManager() {
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS != null) {
            return ctxOCS;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return false;
        }
        return bPw6Q8.f8776A2egSU;
    }

    public int getPopEnterAnim() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 0;
        }
        return bPw6Q8.f8779ADYaiT;
    }

    public int getPopExitAnim() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 0;
        }
        return bPw6Q8.AMqCpz;
    }

    public float getPostOnViewCreatedAlpha() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return 1.0f;
        }
        return bPw6Q8.f8793B4ZgIw;
    }

    public Object getReenterTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        Object obj = bPw6Q8.f8786AcNBzu;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
        D6yqiO.ADYaiT.A4TApA(new D6yqiO.AMqCpz(this, "Attempting to get retain instance for fragment " + this));
        D6yqiO.ADYaiT.A2egSU(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        Object obj = bPw6Q8.f8784AZkASS;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // DV2E8K.ARc23Z
    public final DV2E8K.ADYaiT getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f2197A4TApA;
    }

    public Object getSharedElementEnterTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        return bPw6Q8.f8787AlLFFp;
    }

    public Object getSharedElementReturnTransition() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return null;
        }
        Object obj = bPw6Q8.f8788AmA8tU;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        return (bPw6Q8 == null || (arrayList = bPw6Q8.f8781ASJ6gh) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        return (bPw6Q8 == null || (arrayList = bPw6Q8.f8782AYUAbz) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return ASJ6gh(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
        D6yqiO.ADYaiT.A4TApA(new D6yqiO.ARc23Z(this, "Attempting to get target request code from fragment " + this));
        D6yqiO.ADYaiT.A2egSU(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.B9tovu getViewLifecycleOwner() {
        DuwtYk duwtYk = this.mViewLifecycleOwner;
        if (duwtYk != null) {
            return duwtYk;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.D07BeM
    public androidx.lifecycle.CtxOCS getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (ARc23Z() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap hashMap = this.mFragmentManager.f8864CQhlFr.f8882ARc23Z;
        androidx.lifecycle.CtxOCS ctxOCS = (androidx.lifecycle.CtxOCS) hashMap.get(this.mWho);
        if (ctxOCS != null) {
            return ctxOCS;
        }
        androidx.lifecycle.CtxOCS ctxOCS2 = new androidx.lifecycle.CtxOCS();
        hashMap.put(this.mWho, ctxOCS2);
        return ctxOCS2;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        AYUAbz();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new D8MqeW();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS != null) {
            Fragment fragment = this.mParentFragment;
            ctxOCS.getClass();
            if (fragment == null ? false : fragment.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            if (!(fragment == null ? true : fragment.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        if (bPw6Q8 == null) {
            return false;
        }
        return bPw6Q8.f8795B9tovu;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS == null) {
            return false;
        }
        return ctxOCS.CQhlFr();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.CTkVKb();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (CtxOCS.C4FrIb(2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        CQhlFr cQhlFr = this.mHost;
        Activity activity = cQhlFr == null ? null : cQhlFr.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        CtxOCS ctxOCS = this.mChildFragmentManager;
        if (ctxOCS.f8846B4ZgIw >= 1) {
            return;
        }
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        CQhlFr cQhlFr = this.mHost;
        Activity activity = cQhlFr == null ? null : cQhlFr.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.CTkVKb();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (CtxOCS.C4FrIb(3)) {
            toString();
        }
        if (this.mView != null) {
            Bundle bundle2 = this.mSavedFragmentState;
            restoreViewState(bundle2 != null ? bundle2.getBundle("savedInstanceState") : null);
        }
        this.mSavedFragmentState = null;
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(4);
    }

    public void performAttach() {
        Iterator<BTvldC> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().A2egSU();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.A4TApA(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.f8840AlLFFp.iterator();
        while (it2.hasNext()) {
            ((DAk1zC) it2.next()).A2egSU(this);
        }
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.AZOQYO(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.CTkVKb();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.A2egSU(new androidx.lifecycle.B4ZgIw() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
                View view;
                if (alLFFp != androidx.lifecycle.AlLFFp.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.AZkASS(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.CTkVKb();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new DuwtYk(this, getViewModelStore(), new B7CMnp(0, this));
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.f8948B25kr6 != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.A4TApA();
        if (CtxOCS.C4FrIb(3)) {
            Objects.toString(this.mView);
            toString();
        }
        androidx.lifecycle.CQhlFr.ARc23Z(this.mView, this.mViewLifecycleOwner);
        View view = this.mView;
        DuwtYk duwtYk = this.mViewLifecycleOwner;
        RXb0Sz.ARc23Z.AMqCpz(view, "<this>");
        view.setTag(2131298311, duwtYk);
        JrXYwF.A4TApA.CtFAbx(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.AMqCpz(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.AaHO0E();
        this.mLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.B7CMnp(1);
        if (this.mView != null) {
            DuwtYk duwtYk = this.mViewLifecycleOwner;
            duwtYk.A4TApA();
            if (duwtYk.f8948B25kr6.f8988A5SV6n.compareTo(androidx.lifecycle.AmA8tU.f8979AmA8tU) >= 0) {
                this.mViewLifecycleOwner.A2egSU(androidx.lifecycle.AlLFFp.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        B25kr6.B25kr6 b25kr6 = DAk1zC.A2egSU.A2egSU(this).f2057A4TApA.f2055ADYaiT;
        if (b25kr6.AMqCpz() <= 0) {
            this.mPerformedCreateView = false;
        } else {
            b25kr6.ARc23Z(0).getClass();
            throw new ClassCastException();
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onDetach()"));
        }
        CtxOCS ctxOCS = this.mChildFragmentManager;
        if (ctxOCS.f8859C2rE4F) {
            return;
        }
        ctxOCS.AaHO0E();
        this.mChildFragmentManager = new D8MqeW();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.AzWtSf(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.B25kr6(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.B7CMnp(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.A2egSU(androidx.lifecycle.AlLFFp.ON_PAUSE);
        }
        this.mLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.B4ZgIw(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean COJEAR2 = CtxOCS.COJEAR(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != COJEAR2) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(COJEAR2);
            onPrimaryNavigationFragmentChanged(COJEAR2);
            CtxOCS ctxOCS = this.mChildFragmentManager;
            ctxOCS.DRlcZ9();
            ctxOCS.B2KMhB(ctxOCS.f8850BI9f7h);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.CTkVKb();
        this.mChildFragmentManager.BIYEnU(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onResume()"));
        }
        androidx.lifecycle.BI9f7h bI9f7h = this.mLifecycleRegistry;
        androidx.lifecycle.AlLFFp alLFFp = androidx.lifecycle.AlLFFp.ON_RESUME;
        bI9f7h.ARc23Z(alLFFp);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f8948B25kr6.ARc23Z(alLFFp);
        }
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.CTkVKb();
        this.mChildFragmentManager.BIYEnU(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.BI9f7h bI9f7h = this.mLifecycleRegistry;
        androidx.lifecycle.AlLFFp alLFFp = androidx.lifecycle.AlLFFp.ON_START;
        bI9f7h.ARc23Z(alLFFp);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f8948B25kr6.ARc23Z(alLFFp);
        }
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(5);
    }

    public void performStop() {
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.BpkvW3 = true;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = true;
        ctxOCS.B7CMnp(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.A2egSU(androidx.lifecycle.AlLFFp.ON_STOP);
        }
        this.mLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle = this.mSavedFragmentState;
        onViewCreated(this.mView, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.mChildFragmentManager.B7CMnp(2);
    }

    public void postponeEnterTransition() {
        AMqCpz().f8795B9tovu = true;
    }

    public final <I, O> androidx.activity.result.A5SV6n registerForActivityResult(A4TApA.A4TApA a4TApA, androidx.activity.result.A4TApA a4TApA2) {
        return AZOQYO(a4TApA, new BJ7GGh(0, this), a4TApA2);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to Activity"));
        }
        CtxOCS parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f8855BTvldC == null) {
            parentFragmentManager.f8847B7CMnp.getClass();
            return;
        }
        parentFragmentManager.f8856BV3sI0.addLast(new D07BeM(this.mWho, i));
        parentFragmentManager.f8855BTvldC.A2egSU(strArr);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final CtxOCS requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.mChildFragmentManager.CtFAbx(bundle);
        CtxOCS ctxOCS = this.mChildFragmentManager;
        ctxOCS.f8858BniPrB = false;
        ctxOCS.BpkvW3 = false;
        ctxOCS.f8864CQhlFr.f8885AZOQYO = false;
        ctxOCS.B7CMnp(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new QgOIY0.AYUAbz(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.A2egSU(androidx.lifecycle.AlLFFp.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        AMqCpz().f8790B25kr6 = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        AMqCpz().f8789AzWtSf = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        AMqCpz().f8777A4TApA = i;
        AMqCpz().f8778A5SV6n = i2;
        AMqCpz().f8779ADYaiT = i3;
        AMqCpz().AMqCpz = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(androidx.core.app.D07BeM d07BeM) {
        AMqCpz().f8791B2KMhB = d07BeM;
    }

    public void setEnterTransition(Object obj) {
        AMqCpz().f8783AZOQYO = obj;
    }

    public void setExitSharedElementCallback(androidx.core.app.D07BeM d07BeM) {
        AMqCpz().f8792B3GDIM = d07BeM;
    }

    public void setExitTransition(Object obj) {
        AMqCpz().f8785AaHO0E = obj;
    }

    public void setFocusedView(View view) {
        AMqCpz().f8794B7CMnp = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((C2rE4F) this.mHost).f8802B25kr6.invalidateMenu();
        }
    }

    public void setInitialSavedState(BV3sI0 bV3sI0) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (bV3sI0 == null || (bundle = bV3sI0.f8796AcNBzu) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((C2rE4F) this.mHost).f8802B25kr6.invalidateMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        AMqCpz();
        this.mAnimationInfo.f8780ARc23Z = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        AMqCpz().f8776A2egSU = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        AMqCpz().f8793B4ZgIw = f;
    }

    public void setReenterTransition(Object obj) {
        AMqCpz().f8786AcNBzu = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
        D6yqiO.ADYaiT.A4TApA(new D6yqiO.AMqCpz(this, "Attempting to set retain instance for fragment " + this));
        D6yqiO.ADYaiT.A2egSU(this).getClass();
        this.mRetainInstance = z;
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            ctxOCS.f8864CQhlFr.A5SV6n(this);
        } else {
            ctxOCS.f8864CQhlFr.AMqCpz(this);
        }
    }

    public void setReturnTransition(Object obj) {
        AMqCpz().f8784AZkASS = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        AMqCpz().f8787AlLFFp = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        AMqCpz();
        BPw6Q8 bPw6Q8 = this.mAnimationInfo;
        bPw6Q8.f8781ASJ6gh = arrayList;
        bPw6Q8.f8782AYUAbz = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        AMqCpz().f8788AmA8tU = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i) {
        if (fragment != null) {
            D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
            D6yqiO.ADYaiT.A4TApA(new D6yqiO.ARc23Z(this, "Attempting to set target fragment " + fragment + " with request code " + i + " for fragment " + this));
            D6yqiO.ADYaiT.A2egSU(this).getClass();
        }
        CtxOCS ctxOCS = this.mFragmentManager;
        CtxOCS ctxOCS2 = fragment != null ? fragment.mFragmentManager : null;
        if (ctxOCS != null && ctxOCS2 != null && ctxOCS != ctxOCS2) {
            throw new IllegalArgumentException(J3FDQU.A2egSU.AzWtSf("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.ASJ6gh(false)) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        D6yqiO.A5SV6n a5SV6n = D6yqiO.ADYaiT.f2006A2egSU;
        D6yqiO.ADYaiT.A4TApA(new D6yqiO.A2egSU(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        D6yqiO.ADYaiT.A2egSU(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            CtxOCS ctxOCS = this.mFragmentManager;
            DUi7mC ARc23Z2 = ctxOCS.ARc23Z(this);
            Fragment fragment = ARc23Z2.f8903A5SV6n;
            if (fragment.mDeferStart) {
                if (ctxOCS.f8830A4TApA) {
                    ctxOCS.f8860C4FrIb = true;
                } else {
                    fragment.mDeferStart = false;
                    ARc23Z2.AZOQYO();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr != null) {
            return androidx.core.app.AYUAbz.ARc23Z(((C2rE4F) cQhlFr).f8802B25kr6, str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intent intent2;
        if (this.mHost == null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to Activity"));
        }
        if (CtxOCS.C4FrIb(2)) {
            toString();
            Objects.toString(intentSender);
            Objects.toString(intent);
            Objects.toString(bundle);
        }
        CtxOCS parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f8854BPw6Q8 == null) {
            CQhlFr cQhlFr = parentFragmentManager.f8847B7CMnp;
            if (i == -1) {
                cQhlFr.f8811AcNBzu.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                return;
            } else {
                cQhlFr.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (CtxOCS.C4FrIb(2)) {
                bundle.toString();
                intent2.toString();
                Objects.toString(this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        RXb0Sz.ARc23Z.AMqCpz(intentSender, "intentSender");
        androidx.activity.result.AZOQYO azoqyo = new androidx.activity.result.AZOQYO(intentSender, intent2, i2, i3);
        parentFragmentManager.f8856BV3sI0.addLast(new D07BeM(this.mWho, i));
        if (CtxOCS.C4FrIb(2)) {
            toString();
        }
        parentFragmentManager.f8854BPw6Q8.A2egSU(azoqyo);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !AMqCpz().f8795B9tovu) {
            return;
        }
        if (this.mHost == null) {
            AMqCpz().f8795B9tovu = false;
        } else if (Looper.myLooper() != this.mHost.f8813AmA8tU.getLooper()) {
            this.mHost.f8813AmA8tU.postAtFrontOfQueue(new BChYOn(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentFactory.A5SV6n(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.setArguments(bundle);
            return fragment;
        } catch (IllegalAccessException e) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new DXnQ0V.A5SV6n(ADYaiT.CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        AMqCpz().f8795B9tovu = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        CtxOCS ctxOCS = this.mFragmentManager;
        if (ctxOCS != null) {
            this.mPostponedHandler = ctxOCS.f8847B7CMnp.f8813AmA8tU;
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public final <I, O> androidx.activity.result.A5SV6n registerForActivityResult(A4TApA.A4TApA a4TApA, androidx.activity.result.ASJ6gh aSJ6gh, androidx.activity.result.A4TApA a4TApA2) {
        return AZOQYO(a4TApA, new BJ7GGh(2, aSJ6gh), a4TApA2);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr == null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to Activity"));
        }
        BPw6Q8.ASJ6gh.startActivity(cQhlFr.f8812AlLFFp, intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AzWtSf("Fragment ", this, " not attached to Activity"));
        }
        CtxOCS parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f8853BNL6CD != null) {
            parentFragmentManager.f8856BV3sI0.addLast(new D07BeM(this.mWho, i));
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.f8853BNL6CD.A2egSU(intent);
            return;
        }
        CQhlFr cQhlFr = parentFragmentManager.f8847B7CMnp;
        if (i == -1) {
            BPw6Q8.ASJ6gh.startActivity(cQhlFr.f8812AlLFFp, intent, bundle);
        } else {
            cQhlFr.getClass();
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        CQhlFr cQhlFr = this.mHost;
        if (cQhlFr != null) {
            FragmentActivity fragmentActivity = ((C2rE4F) cQhlFr).f8802B25kr6;
            LayoutInflater cloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            cloneInContext.setFactory2(this.mChildFragmentManager.f8833ARc23Z);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
