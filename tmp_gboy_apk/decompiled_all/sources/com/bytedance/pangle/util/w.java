package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static String[] xj(File file) {
        String[] xj = com.bytedance.pangle.util.xj.hf.xj(file);
        return TextUtils.isEmpty(xj[0]) ? com.bytedance.pangle.util.xj.xj.xj(file) : xj;
    }
}
