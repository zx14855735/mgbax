package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.pl;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVDrmCreater {
    public static final int DrmTypeIntertrust = 1;
    public static final int DrmTypeNone = 0;

    @CalledByNative
    public static synchronized long createDrm(int i) {
        synchronized (AVDrmCreater.class) {
            if (i != 1) {
                return 0L;
            }
            return createDrm(100, "com.bykv.vk.component.ttvideo.drm.intertrust.IntertrustDrm");
        }
    }

    private static long createDrm(int i, String str) {
        try {
            ClassLoader loadPlugin = TTPlayerPluginLoader.loadPlugin(i);
            return Long.parseLong(String.valueOf((loadPlugin != null ? Class.forName(str, true, loadPlugin) : Class.forName(str)).getMethod("createDrm", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception e) {
            pl.xj(e);
            return 0L;
        }
    }
}
