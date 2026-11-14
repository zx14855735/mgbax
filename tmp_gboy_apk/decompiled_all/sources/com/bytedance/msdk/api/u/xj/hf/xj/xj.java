package com.bytedance.msdk.api.u.xj.hf.xj;

import android.view.View;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj extends com.bytedance.msdk.api.u.xj.hf.hf.xj {
    public abstract View hf();

    public final View xj() {
        try {
            return hf();
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }
}
