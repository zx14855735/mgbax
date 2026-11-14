package com.kwad.sdk.api.proxy;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class IActivityProxy implements IComponentProxy {
    private Activity mActivity;

    @KsAdSdkDynamicApi
    @A2egSU
    public <T extends View> T findViewById(int i) {
        return (T) this.mActivity.findViewById(i);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void finish() {
        this.mActivity.finish();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    @Deprecated
    public Activity getActivity() {
        return this.mActivity;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public Intent getIntent() {
        return this.mActivity.getIntent();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public Window getWindow() {
        return this.mActivity.getWindow();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onBackPressed() {
        Activity activity = this.mActivity;
        try {
            if (activity instanceof BaseProxyActivity) {
                ((BaseProxyActivity) activity).superOnBackPressed();
            } else {
                if (activity instanceof BaseProxyFragmentActivity) {
                    ((BaseProxyFragmentActivity) activity).superOnBackPressed();
                    return;
                }
                throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
            }
        } catch (Exception unused) {
        }
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onConfigurationChanged(Configuration configuration) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onDestroy() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyDown(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyDown(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyLongPress(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyLongPress(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyUp(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyUp(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onNewIntent(Intent intent) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPause() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPostCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPostResume() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreDestroy() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPrePause() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreResume() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreStart() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onPreStop() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onRestart() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onResume() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onStart() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onStop() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onTitleChanged(CharSequence charSequence, int i) {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void onUserLeaveHint() {
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void overridePendingTransition(int i, int i2) {
        this.mActivity.overridePendingTransition(i, i2);
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setContentView(int i) {
        this.mActivity.setContentView(i);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setContentView(View view) {
        this.mActivity.setContentView(view);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActivity.setContentView(view, layoutParams);
    }
}
