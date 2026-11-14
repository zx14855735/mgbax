package com.baidu.mobads.sdk.api;

import android.app.Fragment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface CPUComponent {
    void destroy();

    Fragment getFragment();

    androidx.fragment.app.Fragment getSupportFragment();

    void refresh();
}
