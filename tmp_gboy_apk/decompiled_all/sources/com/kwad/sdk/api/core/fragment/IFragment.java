package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
interface IFragment {
    @KsAdSdkDynamicApi
    @A2egSU
    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KsAdSdkDynamicApi
    @A2egSU
    Activity getActivity();

    @KsAdSdkDynamicApi
    @A2egSU
    boolean getAllowEnterTransitionOverlap();

    @KsAdSdkDynamicApi
    @A2egSU
    boolean getAllowReturnTransitionOverlap();

    Bundle getArguments();

    KsFragmentManager getChildFragmentManager();

    @KsAdSdkDynamicApi
    @A2egSU
    Context getContext();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getEnterTransition();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getExitTransition();

    KsFragmentManager getFragmentManager();

    Object getHost();

    int getId();

    @KsAdSdkDynamicApi
    @A2egSU
    @SuppressLint({"RestrictedApi"})
    LayoutInflater getLayoutInflater(Bundle bundle);

    KsLifecycle getLifecycle();

    KsFragment getParentFragment();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getReenterTransition();

    Resources getResources();

    boolean getRetainInstance();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getReturnTransition();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getSharedElementEnterTransition();

    @KsAdSdkDynamicApi
    @A2egSU
    Object getSharedElementReturnTransition();

    String getString(int i);

    String getString(int i, Object... objArr);

    String getTag();

    int getTargetRequestCode();

    CharSequence getText(int i);

    @KsAdSdkDynamicApi
    @A2egSU
    boolean getUserVisibleHint();

    @KsAdSdkDynamicApi
    @A2egSU
    View getView();

    @SuppressLint({"RestrictedApi"})
    boolean hasOptionsMenu();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    @SuppressLint({"RestrictedApi"})
    boolean isMenuVisible();

    boolean isRemoving();

    boolean isResumed();

    boolean isStateSaved();

    boolean isVisible();

    LayoutInflater onGetLayoutInflater(Bundle bundle);

    @KsAdSdkDynamicApi
    @A2egSU
    void postponeEnterTransition();

    @KsAdSdkDynamicApi
    @A2egSU
    void registerForContextMenu(View view);

    void requestPermissions(String[] strArr, int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void setAllowEnterTransitionOverlap(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setAllowReturnTransitionOverlap(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setArguments(Bundle bundle);

    @KsAdSdkDynamicApi
    @A2egSU
    void setEnterTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setExitTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setHasOptionsMenu(boolean z);

    void setInitialSavedState(KsSavedState ksSavedState);

    @KsAdSdkDynamicApi
    @A2egSU
    void setMenuVisibility(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setReenterTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setRetainInstance(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setReturnTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setSharedElementEnterTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setSharedElementReturnTransition(Object obj);

    @KsAdSdkDynamicApi
    @A2egSU
    void setUserVisibleHint(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    boolean shouldShowRequestPermissionRationale(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void startActivity(Intent intent);

    @KsAdSdkDynamicApi
    @A2egSU
    void startActivity(Intent intent, Bundle bundle);

    @KsAdSdkDynamicApi
    @A2egSU
    void startActivityForResult(Intent intent, int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void startActivityForResult(Intent intent, int i, Bundle bundle);

    @KsAdSdkDynamicApi
    @A2egSU
    void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle);

    @KsAdSdkDynamicApi
    @A2egSU
    void startPostponedEnterTransition();

    @KsAdSdkDynamicApi
    @A2egSU
    void unregisterForContextMenu(View view);
}
