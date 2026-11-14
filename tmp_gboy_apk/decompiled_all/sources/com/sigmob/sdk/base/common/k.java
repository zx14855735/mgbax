package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface k {
    void a();

    void a(int i);

    void a(Class<? extends Activity> cls, int i, Bundle bundle);

    void onBackPressed();

    void onSetContentView(View view);
}
