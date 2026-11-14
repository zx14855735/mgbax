package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BaseSystemFragment extends Fragment {
    @KsAdSdkDynamicApi
    @A2egSU
    public final Activity getActivity2() {
        return super.getActivity();
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    @A2egSU
    public Context getContext() {
        return Wrapper.wrapContextIfNeed(super.getContext());
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    @A2egSU
    public void onAttach(Context context) {
        super.onAttach(Wrapper.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @KsAdSdkDynamicApi
    @A2egSU
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return Wrapper.wrapInflaterIfNeed(super.onGetLayoutInflater(bundle));
    }
}
