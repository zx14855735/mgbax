package com.bytedance.pangle.fragment;

import A5SV6n.A2egSU;
import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import com.bytedance.pangle.Zeus;

@A2egSU
@SuppressLint({"NewApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ReportBaseFragment extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new w(this);

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}
