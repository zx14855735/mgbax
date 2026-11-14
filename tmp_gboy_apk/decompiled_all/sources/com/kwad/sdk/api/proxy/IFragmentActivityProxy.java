package com.kwad.sdk.api.proxy;

import A5SV6n.A2egSU;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    @KsAdSdkDynamicApi
    @A2egSU
    public ApplicationInfo getApplicationInfo() {
        return this.mProxyFragmentActivity.getApplicationInfo();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public BaseProxyFragmentActivity getProxyFragmentActivity() {
        return this.mProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int getRequestedOrientation() {
        return this.mProxyFragmentActivity.getRequestedOrientation();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public Resources getResources() {
        return this.mProxyFragmentActivity.getResources();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public Resources.Theme getTheme() {
        return this.mProxyFragmentActivity.getTheme();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isFinishing() {
        return this.mProxyFragmentActivity.isFinishing();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public TypedArray obtainStyledAttributes(int[] iArr) {
        return this.mProxyFragmentActivity.obtainStyledAttributes(iArr);
    }

    public void onAttachFragment(KsFragment ksFragment) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void runOnUiThread(Runnable runnable) {
        this.mProxyFragmentActivity.runOnUiThread(runnable);
    }

    public void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setResult(int i, Intent intent) {
        this.mProxyFragmentActivity.setResult(i, intent);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void startActivity(Intent intent) {
        this.mProxyFragmentActivity.startActivity(intent);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void startActivityForResult(Intent intent, int i) {
        this.mProxyFragmentActivity.startActivityForResult(intent, i);
    }
}
