package com.qq.e.comm.constants;

import android.text.TextUtils;
import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomPkgConstants {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String f12908A2egSU = DownloadService.class.getName();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final String f12909A4TApA = ADActivity.class.getName();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final String f12910A5SV6n = PortraitADActivity.class.getName();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final String f12911ADYaiT = RewardvideoPortraitADActivity.class.getName();
    public static final String AMqCpz = LandscapeADActivity.class.getName();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final String f12912ARc23Z = RewardvideoLandscapeADActivity.class.getName();

    static {
        jZMWMPB();
    }

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !TextUtils.isEmpty(customADActivityClassName) ? customADActivityClassName : f12909A4TApA;
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f12908A2egSU;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !TextUtils.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : AMqCpz;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !TextUtils.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f12910A5SV6n;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f12912ARc23Z;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f12911ADYaiT;
    }

    private static /* synthetic */ void jZMWMPB() {
        char[] charArray = "×ÛÙ\u009aÓÕÙÑ\u009aÖÛÍ\u009aÇÜÑØØ\u009aþÚÝöÆÝÐÓÑ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 180);
        }
        String str = new String(charArray);
        char[] charArray2 = "×ØÝÚÝÀ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 180);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
