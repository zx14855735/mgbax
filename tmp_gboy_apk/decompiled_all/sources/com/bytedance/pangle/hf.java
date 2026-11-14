package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.log.IZeusReporter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static com.bytedance.pangle.flipped.w hf() {
        return w() ? new FlippedV2Impl() : u() ? new com.bytedance.pangle.flipped.hf() : new com.bytedance.pangle.flipped.xj();
    }

    private static boolean u() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return true;
        }
        if (i2 != 27) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    private static boolean w() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return true;
        }
        if (i2 != 29) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    public static void xj() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "start");
        hf().invokeHiddenApiRestrictions();
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "finish");
    }
}
