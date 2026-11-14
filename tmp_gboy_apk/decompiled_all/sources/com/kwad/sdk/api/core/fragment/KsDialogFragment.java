package com.kwad.sdk.api.core.fragment;

import A5SV6n.A2egSU;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsDialogFragment extends KsFragment implements IDialogFragmentLifecycle {
    private DelegateDialogFragment mBase;

    @KsAdSdkDynamicApi
    @A2egSU
    public KsDialogFragment() {
        super(null);
        ResDialogFragment resDialogFragment = new ResDialogFragment(this);
        this.mBase = resDialogFragment;
        setBase(resDialogFragment);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void dismiss() {
        this.mBase.dismiss();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void dismissAllowingStateLoss() {
        this.mBase.dismissAllowingStateLoss();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public Dialog getDialog() {
        return this.mBase.getDialog();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean getShowsDialog() {
        return this.mBase.getShowsDialog();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int getTheme() {
        return this.mBase.getTheme();
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public boolean isCancelable() {
        return this.mBase.isCancelable();
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @A2egSU
    public void onCancel(DialogInterface dialogInterface) {
        this.mBase.superOnCancel(dialogInterface);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @A2egSU
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mBase.superOnCreateDialog(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @A2egSU
    public void onDismiss(DialogInterface dialogInterface) {
        this.mBase.superOnDismiss(dialogInterface);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setCancelable(boolean z) {
        this.mBase.setCancelable(z);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setShowsDialog(boolean z) {
        this.mBase.setShowsDialog(z);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void setStyle(int i, int i2) {
        this.mBase.setStyle(i, i2);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i) {
        this.mBase.setupDialog(dialog, i);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public void show(KsFragmentManager ksFragmentManager, String str) {
        this.mBase.show(ksFragmentManager.getBase(), str);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public int show(KsFragmentTransaction ksFragmentTransaction, String str) {
        return this.mBase.show(ksFragmentTransaction.getBase(), str);
    }

    @A2egSU
    public KsDialogFragment(DelegateDialogFragment delegateDialogFragment) {
        super(delegateDialogFragment);
        this.mBase = delegateDialogFragment;
    }
}
