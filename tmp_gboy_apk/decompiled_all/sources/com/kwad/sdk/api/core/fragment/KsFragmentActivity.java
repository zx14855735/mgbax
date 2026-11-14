package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.kwad.sdk.api.core.ComponentDestroyer;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsFragmentActivity extends FragmentActivity {
    private KsFragmentManager mFragmentManager;

    @Override // androidx.fragment.app.FragmentActivity
    @A2egSU
    public final CtxOCS getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @A2egSU
    public final KsFragmentManager getSupportFragmentManager2() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
        }
        return this.mFragmentManager;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ComponentDestroyer.destroyActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @A2egSU
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @A2egSU
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity
    @A2egSU
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof IDelegateFragment) {
            onAttachFragment(((IDelegateFragment) fragment).getBase());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    @A2egSU
    public final void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }
}
