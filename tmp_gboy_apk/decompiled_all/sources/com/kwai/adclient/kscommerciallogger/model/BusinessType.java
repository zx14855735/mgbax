package com.kwai.adclient.kscommerciallogger.model;

import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum BusinessType {
    TACHIKOMA("TACHIKOMA"),
    AD_SPLASH("AD_SPLASH"),
    AD_INTERSTITIAL("AD_INTERSTITIAL"),
    AD_FULLSCREEN("AD_FULLSCREEN"),
    AD_REWARD("AD_REWARD"),
    AD_FEED("AD_FEED"),
    AD_NATIVE("AD_NATIVE"),
    AD_DRAW("AD_DRAW"),
    CU_SLIDE("CU_SLIDE"),
    CU_PROFILE("CU_PROFILE"),
    CU_PROFILE_SLIDE("CU_PROFILE_SLIDE"),
    CU_FEED("CU_FEED"),
    CU_FEED_SLIDE("CU_FEED_SLIDE"),
    CU_HOTSPOT_ENTRY("CU_HOTSPOT_ENTRY"),
    CU_HOTSPOT_SLIDE("CU_HOTSPOT_SLIDE"),
    CU_HORIZONTAL_FEED("CU_HORIZONTAL_FEED"),
    CU_VIDEO_DETAIL("CU_VIDEO_DETAIL"),
    CU_IMAGE_TEXT_FEED("CU_IMAGE_TEXT_FEED"),
    CU_IMAGE_TEXT_DETAIL("CU_IMAGE_TEXT_DETAIL"),
    CU_WALLPAPER_FEED("CU_WALLPAPER_FEED"),
    CU_WALLPAPER_SLIDE("CU_WALLPAPER_SLIDE"),
    EU_LIVE_SLIDE("EU_LIVE_SLIDE"),
    EU_LIVE_REPLAY("EU_LIVE_REPLAY"),
    WEB_CACHE("WEB_CACHE"),
    AD_SDK_INIT("AD_SDK_INIT"),
    AD_WEBVIEW("AD_WEBVIEW"),
    AD_CONVERT("AD_CONVERT"),
    OTHER(ADBidEvent.OTHER);

    public String value;

    static {
        wMiW();
    }

    BusinessType(String str) {
        this.value = str;
    }

    private static /* synthetic */ void wMiW() {
        char[] charArray = "\u0082\u008e\u008cÏ\u0086\u0080\u008c\u0084Ï\u0083\u008e\u0098Ï\u0092\u0089\u0084\u008d\u008dÏ«\u008f\u0088£\u0093\u0088\u0085\u0086\u0084".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 225);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0082\u008d\u0088\u008f\u0088\u0095".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 225);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
