package com.bytedance.sdk.component.g;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface hf {

    public interface xj {
        Pair<Boolean, Boolean> xj(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(xj xjVar);
}
