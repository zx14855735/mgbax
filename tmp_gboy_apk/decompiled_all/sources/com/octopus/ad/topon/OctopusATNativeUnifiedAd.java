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
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATNativeUnifiedAd extends CustomNativeAd {
    private static final String TAG = "OctopusATNativeUnifiedAd";
    private NativeAdResponse mAdResponse;
    private Context mContext;
    private NativeAd mNativeAd;

    static {
        drVOX();
    }

    public OctopusATNativeUnifiedAd(Context context, NativeAd nativeAd, NativeAdResponse nativeAdResponse) {
        this.mContext = context.getApplicationContext();
        this.mNativeAd = nativeAd;
        this.mAdResponse = nativeAdResponse;
        setAdData();
    }

    private static /* synthetic */ void drVOX() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void getChildView(List<View> list, View view) {
        if (!(view instanceof ViewGroup)) {
            list.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            getChildView(list, viewGroup.getChildAt(i));
        }
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
        try {
            NativeAdResponse nativeAdResponse = this.mAdResponse;
            if (nativeAdResponse != null) {
                return nativeAdResponse.getVideoView(this.mContext);
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public boolean isNativeExpress() {
        return false;
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null) {
            clickViewList = new ArrayList<>();
            getChildView(clickViewList, view);
        }
        this.mAdResponse.bindUnifiedView(viewGroup, clickViewList, new NativeAdEventListener() { // from class: com.octopus.ad.topon.OctopusATNativeUnifiedAd.1
            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onADExposed() {
                String unused = OctopusATNativeUnifiedAd.TAG;
                OctopusATNativeUnifiedAd.this.notifyAdImpression();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClick() {
                String unused = OctopusATNativeUnifiedAd.TAG;
                OctopusATNativeUnifiedAd.this.notifyAdClicked();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClose() {
                String unused = OctopusATNativeUnifiedAd.TAG;
                OctopusATNativeUnifiedAd.this.notifyAdDislikeClick();
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdRenderFailed(int i) {
                String unused = OctopusATNativeUnifiedAd.TAG;
            }
        });
    }

    public void setAdData() {
        setTitle(this.mAdResponse.getTitle());
        setDescriptionText(this.mAdResponse.getDescription());
        setIconImageUrl(this.mAdResponse.getIconUrl());
        setMainImageUrl(this.mAdResponse.getImageUrl());
        setImageUrlList(this.mAdResponse.getImageUrls());
        setCallToActionText(this.mAdResponse.getButtonText());
    }
}
