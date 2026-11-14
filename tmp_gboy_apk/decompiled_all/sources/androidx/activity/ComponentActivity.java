package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.core.app.BJ7GGh;
import androidx.core.app.CqNSpT;
import androidx.core.app.CrfGsy;
import androidx.core.app.CtFAbx;
import androidx.fragment.app.CmUvjW;
import androidx.lifecycle.BI9f7h;
import androidx.lifecycle.C4FrIb;
import androidx.lifecycle.CNPG0E;
import androidx.lifecycle.CQhlFr;
import androidx.lifecycle.CcAIMM;
import androidx.lifecycle.CkXcdM;
import androidx.lifecycle.CtxOCS;
import androidx.lifecycle.D07BeM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ComponentActivity extends androidx.core.app.AmA8tU implements D07BeM, androidx.lifecycle.AZOQYO, DV2E8K.ARc23Z, B9tovu, androidx.activity.result.AYUAbz, BPw6Q8.AaHO0E, BPw6Q8.AcNBzu, CqNSpT, CrfGsy, COJEAR.AmA8tU {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final /* synthetic */ int f7970AcNBzu = 0;
    private final androidx.activity.result.ASJ6gh mActivityResultRegistry;
    private int mContentLayoutId;
    private androidx.lifecycle.CqNSpT mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final AlLFFp mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<CNPG0E.A2egSU> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<CNPG0E.A2egSU> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<CNPG0E.A2egSU> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<CNPG0E.A2egSU> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<CNPG0E.A2egSU> mOnTrimMemoryListeners;
    final AZkASS mReportFullyDrawnExecutor;
    final DV2E8K.AMqCpz mSavedStateRegistryController;
    private CtxOCS mViewModelStore;
    final A2egSU.A2egSU mContextAwareHelper = new A2egSU.A2egSU();
    private final COJEAR.B3GDIM mMenuHostHelper = new COJEAR.B3GDIM(new CtFAbx.A2egSU(16, this));
    private final BI9f7h mLifecycleRegistry = new BI9f7h(this);

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.activity.ADYaiT] */
    public ComponentActivity() {
        DV2E8K.AMqCpz aMqCpz = new DV2E8K.AMqCpz(this);
        this.mSavedStateRegistryController = aMqCpz;
        this.mOnBackPressedDispatcher = null;
        AaHO0E aaHO0E = new AaHO0E(this);
        this.mReportFullyDrawnExecutor = aaHO0E;
        this.mFullyDrawnReporter = new AlLFFp(aaHO0E, new Function0() { // from class: androidx.activity.ADYaiT
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i = ComponentActivity.f7970AcNBzu;
                ComponentActivity.this.reportFullyDrawn();
                return null;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ASJ6gh(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i = Build.VERSION.SDK_INT;
        getLifecycle().A2egSU(new androidx.lifecycle.B4ZgIw() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
                if (alLFFp == androidx.lifecycle.AlLFFp.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        getLifecycle().A2egSU(new androidx.lifecycle.B4ZgIw() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
                if (alLFFp == androidx.lifecycle.AlLFFp.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.f5A4TApA = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().A2egSU();
                    }
                    AaHO0E aaHO0E2 = (AaHO0E) ComponentActivity.this.mReportFullyDrawnExecutor;
                    ComponentActivity componentActivity = aaHO0E2.f7949AzWtSf;
                    componentActivity.getWindow().getDecorView().removeCallbacks(aaHO0E2);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(aaHO0E2);
                }
            }
        });
        getLifecycle().A2egSU(new androidx.lifecycle.B4ZgIw() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
                ComponentActivity componentActivity = ComponentActivity.this;
                componentActivity.ensureViewModelStore();
                componentActivity.getLifecycle().A5SV6n(this);
            }
        });
        aMqCpz.A2egSU();
        CQhlFr.ADYaiT(this);
        if (i <= 23) {
            androidx.lifecycle.AzWtSf lifecycle = getLifecycle();
            ImmLeaksCleaner immLeaksCleaner = new ImmLeaksCleaner();
            immLeaksCleaner.f7979AcNBzu = this;
            lifecycle.A2egSU(immLeaksCleaner);
        }
        getSavedStateRegistry().A5SV6n(ACTIVITY_RESULT_TAG, new AMqCpz(0, this));
        addOnContextAvailableListener(new A2egSU.A4TApA() { // from class: androidx.activity.ARc23Z
            @Override // A2egSU.A4TApA
            public final void A2egSU(ComponentActivity componentActivity) {
                ComponentActivity.A4TApA(ComponentActivity.this);
            }
        });
    }

    public static void A4TApA(ComponentActivity componentActivity) {
        Bundle A2egSU2 = componentActivity.getSavedStateRegistry().A2egSU(ACTIVITY_RESULT_TAG);
        if (A2egSU2 != null) {
            androidx.activity.result.ASJ6gh aSJ6gh = componentActivity.mActivityResultRegistry;
            aSJ6gh.getClass();
            ArrayList<Integer> integerArrayList = A2egSU2.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = A2egSU2.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            aSJ6gh.f8003ADYaiT = A2egSU2.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            Bundle bundle = A2egSU2.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = aSJ6gh.f8005ASJ6gh;
            bundle2.putAll(bundle);
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = stringArrayList.get(i);
                HashMap hashMap = aSJ6gh.f8001A4TApA;
                boolean containsKey = hashMap.containsKey(str);
                HashMap hashMap2 = aSJ6gh.f8000A2egSU;
                if (containsKey) {
                    Integer num = (Integer) hashMap.remove(str);
                    if (!bundle2.containsKey(str)) {
                        hashMap2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                num2.intValue();
                String str2 = stringArrayList.get(i);
                hashMap2.put(num2, str2);
                hashMap.put(str2, num2);
            }
        }
    }

    public static Bundle A5SV6n(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        androidx.activity.result.ASJ6gh aSJ6gh = componentActivity.mActivityResultRegistry;
        aSJ6gh.getClass();
        HashMap hashMap = aSJ6gh.f8001A4TApA;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(aSJ6gh.f8003ADYaiT));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) aSJ6gh.f8005ASJ6gh.clone());
        return bundle;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.A2egSU(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // COJEAR.AmA8tU
    public void addMenuProvider(COJEAR.B7CMnp b7CMnp) {
        COJEAR.B3GDIM b3gdim = this.mMenuHostHelper;
        b3gdim.f1642A4TApA.add(b7CMnp);
        b3gdim.f1641A2egSU.run();
    }

    @Override // BPw6Q8.AaHO0E
    public final void addOnConfigurationChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnConfigurationChangedListeners.add(a2egSU);
    }

    public final void addOnContextAvailableListener(A2egSU.A4TApA a4TApA) {
        A2egSU.A2egSU a2egSU = this.mContextAwareHelper;
        a2egSU.getClass();
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "listener");
        ComponentActivity componentActivity = a2egSU.f5A4TApA;
        if (componentActivity != null) {
            a4TApA.A2egSU(componentActivity);
        }
        a2egSU.f4A2egSU.add(a4TApA);
    }

    @Override // androidx.core.app.CqNSpT
    public final void addOnMultiWindowModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnMultiWindowModeChangedListeners.add(a2egSU);
    }

    public final void addOnNewIntentListener(CNPG0E.A2egSU a2egSU) {
        this.mOnNewIntentListeners.add(a2egSU);
    }

    @Override // androidx.core.app.CrfGsy
    public final void addOnPictureInPictureModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnPictureInPictureModeChangedListeners.add(a2egSU);
    }

    @Override // BPw6Q8.AcNBzu
    public final void addOnTrimMemoryListener(CNPG0E.A2egSU a2egSU) {
        this.mOnTrimMemoryListeners.add(a2egSU);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            AZOQYO azoqyo = (AZOQYO) getLastNonConfigurationInstance();
            if (azoqyo != null) {
                this.mViewModelStore = azoqyo.f7945A4TApA;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new CtxOCS();
            }
        }
    }

    @Override // androidx.activity.result.AYUAbz
    public final androidx.activity.result.ASJ6gh getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.AZOQYO
    public D9tr6l.A4TApA getDefaultViewModelCreationExtras() {
        D9tr6l.ADYaiT aDYaiT = new D9tr6l.ADYaiT();
        Application application = getApplication();
        LinkedHashMap linkedHashMap = aDYaiT.f2052A2egSU;
        if (application != null) {
            linkedHashMap.put(CkXcdM.f9033A2egSU, getApplication());
        }
        linkedHashMap.put(CQhlFr.f9015A2egSU, this);
        linkedHashMap.put(CQhlFr.f9016A4TApA, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(CQhlFr.f9017A5SV6n, getIntent().getExtras());
        }
        return aDYaiT;
    }

    @Override // androidx.lifecycle.AZOQYO
    public androidx.lifecycle.CqNSpT getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new CcAIMM(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public AlLFFp getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        AZOQYO azoqyo = (AZOQYO) getLastNonConfigurationInstance();
        if (azoqyo != null) {
            return azoqyo.f7944A2egSU;
        }
        return null;
    }

    @Override // androidx.core.app.AmA8tU, androidx.lifecycle.B9tovu
    public androidx.lifecycle.AzWtSf getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.B9tovu
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new LLYwnm.AMqCpz(24, this));
            getLifecycle().A2egSU(new androidx.lifecycle.B4ZgIw() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.B4ZgIw
                public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
                    if (alLFFp != androidx.lifecycle.AlLFFp.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    OnBackPressedDispatcher onBackPressedDispatcher = ComponentActivity.this.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher A2egSU2 = AYUAbz.A2egSU((ComponentActivity) b9tovu);
                    onBackPressedDispatcher.getClass();
                    RXb0Sz.ARc23Z.AMqCpz(A2egSU2, "invoker");
                    onBackPressedDispatcher.AMqCpz = A2egSU2;
                    onBackPressedDispatcher.A5SV6n(onBackPressedDispatcher.f7985ASJ6gh);
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // DV2E8K.ARc23Z
    public final DV2E8K.ADYaiT getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f2197A4TApA;
    }

    @Override // androidx.lifecycle.D07BeM
    public CtxOCS getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        CQhlFr.ARc23Z(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        RXb0Sz.ARc23Z.AMqCpz(decorView, "<this>");
        decorView.setTag(2131298311, this);
        JrXYwF.A4TApA.CtFAbx(getWindow().getDecorView(), this);
        JrXYwF.A4TApA.CtxOCS(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        RXb0Sz.ARc23Z.AMqCpz(decorView2, "<this>");
        decorView2.setTag(2131297800, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.A2egSU(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().A4TApA();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<CNPG0E.A2egSU> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.AmA8tU, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.A4TApA(bundle);
        A2egSU.A2egSU a2egSU = this.mContextAwareHelper;
        a2egSU.getClass();
        a2egSU.f5A4TApA = this;
        Iterator it = a2egSU.f4A2egSU.iterator();
        while (it.hasNext()) {
            ((A2egSU.A4TApA) it.next()).A2egSU(this);
        }
        super.onCreate(bundle);
        int i = CNPG0E.f9008AlLFFp;
        C4FrIb.A4TApA(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        COJEAR.B3GDIM b3gdim = this.mMenuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = b3gdim.f1642A4TApA.iterator();
        while (it.hasNext()) {
            ((CmUvjW) ((COJEAR.B7CMnp) it.next())).f8826A2egSU.AZkASS(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mMenuHostHelper.A2egSU(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<CNPG0E.A2egSU> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new BJ7GGh(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<CNPG0E.A2egSU> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = this.mMenuHostHelper.f1642A4TApA.iterator();
        while (it.hasNext()) {
            ((CmUvjW) ((COJEAR.B7CMnp) it.next())).f8826A2egSU.B25kr6(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<CNPG0E.A2egSU> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new CtFAbx(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.mMenuHostHelper.f1642A4TApA.iterator();
        while (it.hasNext()) {
            ((CmUvjW) ((COJEAR.B7CMnp) it.next())).f8826A2egSU.B4ZgIw(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.A2egSU(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        AZOQYO azoqyo;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        CtxOCS ctxOCS = this.mViewModelStore;
        if (ctxOCS == null && (azoqyo = (AZOQYO) getLastNonConfigurationInstance()) != null) {
            ctxOCS = azoqyo.f7945A4TApA;
        }
        if (ctxOCS == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        AZOQYO azoqyo2 = new AZOQYO();
        azoqyo2.f7944A2egSU = onRetainCustomNonConfigurationInstance;
        azoqyo2.f7945A4TApA = ctxOCS;
        return azoqyo2;
    }

    @Override // androidx.core.app.AmA8tU, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.AzWtSf lifecycle = getLifecycle();
        if (lifecycle instanceof BI9f7h) {
            ((BI9f7h) lifecycle).AYUAbz();
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.A5SV6n(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<CNPG0E.A2egSU> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f5A4TApA;
    }

    public final <I, O> androidx.activity.result.A5SV6n registerForActivityResult(A4TApA.A4TApA a4TApA, androidx.activity.result.ASJ6gh aSJ6gh, androidx.activity.result.A4TApA a4TApA2) {
        return aSJ6gh.ADYaiT("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, a4TApA, a4TApA2);
    }

    @Override // COJEAR.AmA8tU
    public void removeMenuProvider(COJEAR.B7CMnp b7CMnp) {
        this.mMenuHostHelper.A4TApA(b7CMnp);
    }

    @Override // BPw6Q8.AaHO0E
    public final void removeOnConfigurationChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnConfigurationChangedListeners.remove(a2egSU);
    }

    public final void removeOnContextAvailableListener(A2egSU.A4TApA a4TApA) {
        A2egSU.A2egSU a2egSU = this.mContextAwareHelper;
        a2egSU.getClass();
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "listener");
        a2egSU.f4A2egSU.remove(a4TApA);
    }

    @Override // androidx.core.app.CqNSpT
    public final void removeOnMultiWindowModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnMultiWindowModeChangedListeners.remove(a2egSU);
    }

    public final void removeOnNewIntentListener(CNPG0E.A2egSU a2egSU) {
        this.mOnNewIntentListeners.remove(a2egSU);
    }

    @Override // androidx.core.app.CrfGsy
    public final void removeOnPictureInPictureModeChangedListener(CNPG0E.A2egSU a2egSU) {
        this.mOnPictureInPictureModeChangedListeners.remove(a2egSU);
    }

    @Override // BPw6Q8.AcNBzu
    public final void removeOnTrimMemoryListener(CNPG0E.A2egSU a2egSU) {
        this.mOnTrimMemoryListeners.remove(a2egSU);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (NOd7IU.AlLFFp.CikNvS()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            AlLFFp alLFFp = this.mFullyDrawnReporter;
            synchronized (alLFFp.f7953A2egSU) {
                try {
                    alLFFp.f7954A4TApA = true;
                    Iterator it = alLFFp.f7955A5SV6n.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    alLFFp.f7955A5SV6n.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.A2egSU(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<CNPG0E.A2egSU> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                CNPG0E.A2egSU next = it.next();
                RXb0Sz.ARc23Z.AMqCpz(configuration, "newConfig");
                next.accept(new BJ7GGh(z));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<CNPG0E.A2egSU> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                CNPG0E.A2egSU next = it.next();
                RXb0Sz.ARc23Z.AMqCpz(configuration, "newConfig");
                next.accept(new CtFAbx(z));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> androidx.activity.result.A5SV6n registerForActivityResult(A4TApA.A4TApA a4TApA, androidx.activity.result.A4TApA a4TApA2) {
        return registerForActivityResult(a4TApA, this.mActivityResultRegistry, a4TApA2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.A2egSU(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void addMenuProvider(final COJEAR.B7CMnp b7CMnp, androidx.lifecycle.B9tovu b9tovu) {
        final COJEAR.B3GDIM b3gdim = this.mMenuHostHelper;
        b3gdim.f1642A4TApA.add(b7CMnp);
        b3gdim.f1641A2egSU.run();
        androidx.lifecycle.AzWtSf lifecycle = b9tovu.getLifecycle();
        HashMap hashMap = b3gdim.f1643A5SV6n;
        COJEAR.B2KMhB b2KMhB = (COJEAR.B2KMhB) hashMap.remove(b7CMnp);
        if (b2KMhB != null) {
            b2KMhB.f1639A2egSU.A5SV6n(b2KMhB.f1640A4TApA);
            b2KMhB.f1640A4TApA = null;
        }
        hashMap.put(b7CMnp, new COJEAR.B2KMhB(lifecycle, new androidx.lifecycle.B4ZgIw() { // from class: COJEAR.B25kr6
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu2, androidx.lifecycle.AlLFFp alLFFp) {
                androidx.lifecycle.AlLFFp alLFFp2 = androidx.lifecycle.AlLFFp.ON_DESTROY;
                B3GDIM b3gdim2 = B3GDIM.this;
                if (alLFFp == alLFFp2) {
                    b3gdim2.A4TApA(b7CMnp);
                } else {
                    b3gdim2.getClass();
                }
            }
        }));
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.A2egSU(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final COJEAR.B7CMnp b7CMnp, androidx.lifecycle.B9tovu b9tovu, final androidx.lifecycle.AmA8tU amA8tU) {
        final COJEAR.B3GDIM b3gdim = this.mMenuHostHelper;
        b3gdim.getClass();
        androidx.lifecycle.AzWtSf lifecycle = b9tovu.getLifecycle();
        HashMap hashMap = b3gdim.f1643A5SV6n;
        COJEAR.B2KMhB b2KMhB = (COJEAR.B2KMhB) hashMap.remove(b7CMnp);
        if (b2KMhB != null) {
            b2KMhB.f1639A2egSU.A5SV6n(b2KMhB.f1640A4TApA);
            b2KMhB.f1640A4TApA = null;
        }
        hashMap.put(b7CMnp, new COJEAR.B2KMhB(lifecycle, new androidx.lifecycle.B4ZgIw() { // from class: COJEAR.AzWtSf
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu2, androidx.lifecycle.AlLFFp alLFFp) {
                B3GDIM b3gdim2 = B3GDIM.this;
                b3gdim2.getClass();
                androidx.lifecycle.AlLFFp.Companion.getClass();
                androidx.lifecycle.AmA8tU amA8tU2 = amA8tU;
                RXb0Sz.ARc23Z.AMqCpz(amA8tU2, "state");
                int ordinal = amA8tU2.ordinal();
                androidx.lifecycle.AlLFFp alLFFp2 = null;
                androidx.lifecycle.AlLFFp alLFFp3 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : androidx.lifecycle.AlLFFp.ON_RESUME : androidx.lifecycle.AlLFFp.ON_START : androidx.lifecycle.AlLFFp.ON_CREATE;
                Runnable runnable = b3gdim2.f1641A2egSU;
                CopyOnWriteArrayList copyOnWriteArrayList = b3gdim2.f1642A4TApA;
                B7CMnp b7CMnp2 = b7CMnp;
                if (alLFFp == alLFFp3) {
                    copyOnWriteArrayList.add(b7CMnp2);
                    runnable.run();
                    return;
                }
                androidx.lifecycle.AlLFFp alLFFp4 = androidx.lifecycle.AlLFFp.ON_DESTROY;
                if (alLFFp == alLFFp4) {
                    b3gdim2.A4TApA(b7CMnp2);
                    return;
                }
                int ordinal2 = amA8tU2.ordinal();
                if (ordinal2 == 2) {
                    alLFFp2 = alLFFp4;
                } else if (ordinal2 == 3) {
                    alLFFp2 = androidx.lifecycle.AlLFFp.ON_STOP;
                } else if (ordinal2 == 4) {
                    alLFFp2 = androidx.lifecycle.AlLFFp.ON_PAUSE;
                }
                if (alLFFp == alLFFp2) {
                    copyOnWriteArrayList.remove(b7CMnp2);
                    runnable.run();
                }
            }
        }));
    }
}
