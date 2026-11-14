package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import B25kr6.AzWtSf;
import DV2E8K.ARc23Z;
import DXnQ0V.A5SV6n;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.kwad.sdk.api.a;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import com.kwad.sdk.api.loader.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsFragment extends AbstractIFragmentLifecycle implements IFragment, IFragmentLifecycle {
    private static final AzWtSf sClassMap = new AzWtSf();
    private Fragment mBase;
    private KsFragmentManager mChildFragmentManager;
    private KsFragmentManager mFragmentManager;
    private KsLifecycle mLifeCycle;

    static {
        JdpGvV();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragment() {
        this.mBase = new ResFragment(this);
    }

    private static /* synthetic */ void JdpGvV() {
        char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '`');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '`');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static KsFragment instantiate(Context context, String str, Bundle bundle) {
        try {
            AzWtSf azWtSf = sClassMap;
            Class<?> cls = (Class) azWtSf.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                azWtSf.put(str, cls);
            }
            KsFragment ksFragment = (KsFragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(ksFragment.getClass().getClassLoader());
                ksFragment.setArguments(bundle);
            }
            return ksFragment;
        } catch (Exception e) {
            throw new A5SV6n(CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        }
    }

    private boolean isKsAdParentFragment() {
        Fragment parentFragment = this.mBase.getParentFragment();
        return parentFragment != null && (parentFragment instanceof IDelegateFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mBase.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final Activity getActivity() {
        ARc23Z aRc23Z = this.mBase;
        if (aRc23Z instanceof IDelegateFragment) {
            return ((IDelegateFragment) aRc23Z).getActivity2();
        }
        throw new RuntimeException(this.mBase + " must be DelegateFragment or DelegateDialogFragment");
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean getAllowEnterTransitionOverlap() {
        return this.mBase.getAllowEnterTransitionOverlap();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean getAllowReturnTransitionOverlap() {
        return this.mBase.getAllowReturnTransitionOverlap();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Bundle getArguments() {
        Bundle arguments = this.mBase.getArguments();
        if (arguments != null) {
            arguments.setClassLoader(Loader.get().getRealClassLoader());
        }
        return arguments;
    }

    @A2egSU
    public final Fragment getBase() {
        return this.mBase;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            this.mChildFragmentManager = new KsFragmentManager(this.mBase.getChildFragmentManager());
        }
        return this.mChildFragmentManager;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final Context getContext() {
        return this.mBase.getContext();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public Object getEnterTransition() {
        return this.mBase.getEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getExitTransition() {
        return this.mBase.getExitTransition();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public final FragmentActivity getFragmentActivity() {
        Fragment fragment = this.mBase;
        if (fragment instanceof ResFragment) {
            return ((ResFragment) fragment).getFragmentActivity();
        }
        throw new RuntimeException(this.mBase + " must be DelegateFragment or DelegateDialogFragment");
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public KsFragmentManager getFragmentManager() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(this.mBase.getFragmentManager());
        }
        return this.mFragmentManager;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getHost() {
        return this.mBase.getHost();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final int getId() {
        return this.mBase.getId();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @SuppressLint({"RestrictedApi"})
    public final LayoutInflater getLayoutInflater(Bundle bundle) {
        return this.mBase.getLayoutInflater(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public KsLifecycle getLifecycle() {
        if (this.mLifeCycle == null) {
            this.mLifeCycle = new KsLifecycle(this.mBase.getLifecycle());
        }
        return this.mLifeCycle;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final KsFragment getParentFragment() {
        Object parentFragment = this.mBase.getParentFragment();
        if (parentFragment instanceof IDelegateFragment) {
            return ((IDelegateFragment) parentFragment).getBase();
        }
        if (parentFragment == null) {
            return null;
        }
        throw new RuntimeException(parentFragment + " is not a DelegateFragment or DelegateDialogFragment");
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getReenterTransition() {
        return this.mBase.getReenterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final Resources getResources() {
        if (a.oy.booleanValue()) {
            throw new RuntimeException("please use getContext().getResources()");
        }
        return this.mBase.getContext().getResources();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean getRetainInstance() {
        return this.mBase.getRetainInstance();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getReturnTransition() {
        return this.mBase.getReturnTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getSharedElementEnterTransition() {
        return this.mBase.getSharedElementEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final Object getSharedElementReturnTransition() {
        return this.mBase.getSharedElementReturnTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final String getTag() {
        return this.mBase.getTag();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final int getTargetRequestCode() {
        return this.mBase.getTargetRequestCode();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean getUserVisibleHint() {
        return this.mBase.getUserVisibleHint();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final View getView() {
        return this.mBase.getView();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @SuppressLint({"RestrictedApi"})
    public final boolean hasOptionsMenu() {
        return this.mBase.hasOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isAdded() {
        return this.mBase.isAdded();
    }

    public boolean isAllFragmentIsHidden() {
        if (isKsAdParentFragment()) {
            KsFragment parentFragment = getParentFragment();
            return parentFragment == null ? isHidden() : isHidden() || parentFragment.isAllFragmentIsHidden();
        }
        Fragment fragment = this.mBase;
        Fragment parentFragment2 = fragment.getParentFragment();
        return parentFragment2 == null ? fragment.isHidden() : fragment.isHidden() || isAllFragmentIsHidden(parentFragment2);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isDetached() {
        return this.mBase.isDetached();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isHidden() {
        return this.mBase.isHidden();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isInLayout() {
        return this.mBase.isInLayout();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @SuppressLint({"RestrictedApi"})
    public final boolean isMenuVisible() {
        return this.mBase.isMenuVisible();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isRemoving() {
        return this.mBase.isRemoving();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public final boolean isResumed() {
        return this.mBase.isResumed();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isStateSaved() {
        return this.mBase.isStateSaved();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean isVisible() {
        return this.mBase.isVisible();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Deprecated
    public /* bridge */ /* synthetic */ void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttachFragment(KsFragment ksFragment) {
        super.onAttachFragment(ksFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i, boolean z, int i2) {
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return this.mBase.onGetLayoutInflater(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void postponeEnterTransition() {
        this.mBase.postponeEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void registerForContextMenu(View view) {
        this.mBase.registerForContextMenu(view);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void requestPermissions(String[] strArr, int i) {
        this.mBase.requestPermissions(strArr, i);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setAllowEnterTransitionOverlap(boolean z) {
        this.mBase.setAllowEnterTransitionOverlap(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setAllowReturnTransitionOverlap(boolean z) {
        this.mBase.setAllowReturnTransitionOverlap(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setArguments(Bundle bundle) {
        this.mBase.setArguments(bundle);
    }

    @A2egSU
    public void setBase(Fragment fragment) {
        this.mBase = fragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setEnterTransition(Object obj) {
        this.mBase.setEnterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setExitTransition(Object obj) {
        this.mBase.setExitTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setHasOptionsMenu(boolean z) {
        this.mBase.setHasOptionsMenu(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public void setInitialSavedState(KsSavedState ksSavedState) {
        this.mBase.setInitialSavedState(ksSavedState.getBase());
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setMenuVisibility(boolean z) {
        this.mBase.setMenuVisibility(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setReenterTransition(Object obj) {
        this.mBase.setReenterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setRetainInstance(boolean z) {
        this.mBase.setRetainInstance(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setReturnTransition(Object obj) {
        this.mBase.setReturnTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setSharedElementEnterTransition(Object obj) {
        this.mBase.setSharedElementEnterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void setSharedElementReturnTransition(Object obj) {
        this.mBase.setSharedElementReturnTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public void setUserVisibleHint(boolean z) {
        this.mBase.setUserVisibleHint(z);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final boolean shouldShowRequestPermissionRationale(String str) {
        return this.mBase.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startActivity(Intent intent) {
        this.mBase.startActivity(intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startActivityForResult(Intent intent, int i) {
        this.mBase.startActivityForResult(intent, i);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mBase.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startPostponedEnterTransition() {
        this.mBase.startPostponedEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void unregisterForContextMenu(View view) {
        this.mBase.unregisterForContextMenu(view);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startActivity(Intent intent, Bundle bundle) {
        this.mBase.startActivity(intent, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @A2egSU
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.mBase.startActivityForResult(intent, i, bundle);
    }

    @A2egSU
    public KsFragment(Fragment fragment) {
        this.mBase = fragment;
    }

    private boolean isAllFragmentIsHidden(Fragment fragment) {
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            return fragment.isHidden();
        }
        return fragment.isHidden() || isAllFragmentIsHidden(parentFragment);
    }
}
