package com.octopus.ad.topon;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.octopus.ad.NativeAd;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.internal.nativead.NativeAdEventListener;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATNativeExpressAd extends CustomNativeAd {
    private static final String TAG = "OctopusATNativeExpressAd";
    private NativeAdResponse mAdResponse;
    private Context mContext;
    private NativeAd mNativeAd;

    static {
        KUYMqWd();
    }

    public OctopusATNativeExpressAd(Context context, NativeAd nativeAd, NativeAdResponse nativeAdResponse) {
        this.mContext = context.getApplicationContext();
        this.mNativeAd = nativeAd;
        this.mAdResponse = nativeAdResponse;
    }

    private static /* synthetic */ void KUYMqWd() {
        char[] charArray = "õùû¸ñ÷ûó¸ôùï¸åþóúú¸ÜøÿÔäÿòñó".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 150);
        }
        String str = new String(charArray);
        char[] charArray2 = "õúÿøÿâ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 150);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void clear(View view) {
    }

    public void destroy() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
        this.mContext = null;
        this.mAdResponse = null;
    }

    public Bitmap getAdLogo() {
        NativeAdResponse nativeAdResponse = this.mAdResponse;
        if (nativeAdResponse != null) {
            return nativeAdResponse.getLogo(this.mContext);
        }
        return null;
    }

    public View getAdMediaView(Object... objArr) {
        return null;
    }

    public boolean isNativeExpress() {
        return true;
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null) {
            return;
        }
        this.mAdResponse.bindView((ViewGroup) view, new NativeAdEventListener() { // from class: com.octopus.ad.topon.OctopusATNativeExpressAd.1
            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onADExposed() {
                String unused = OctopusATNativeExpressAd.TAG;
                OctopusATNativeExpressAd.this.notifyAdImpression();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClick() {
                String unused = OctopusATNativeExpressAd.TAG;
                OctopusATNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClose() {
                String unused = OctopusATNativeExpressAd.TAG;
                OctopusATNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdRenderFailed(int i) {
                String unused = OctopusATNativeExpressAd.TAG;
            }
        });
    }
}
