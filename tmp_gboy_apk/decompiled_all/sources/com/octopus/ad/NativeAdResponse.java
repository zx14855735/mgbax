package com.octopus.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.octopus.ad.internal.nativead.NativeAdEventListener;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.video.VideoStateListener;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.model.ShakeValue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface NativeAdResponse {
    public static final int INTERACTION_TYPE_DOWNLOAD = 2;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 4;
    public static final int INTERACTION_TYPE_MINI_PROGRAMS = 6;
    public static final int INTERACTION_TYPE_QUICK_APP = 3;

    public enum a {
        OCTOPUS;

        static {
            WsAiy();
        }

        private static /* synthetic */ void WsAiy() {
            char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 19);
            }
            String str = new String(charArray);
            char[] charArray2 = "p\u007fz}zg".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 19);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum b {
        CONTENT,
        APP_INSTALL;

        static {
            XPha();
        }

        private static /* synthetic */ void XPha() {
            char[] charArray = "hdf%ljfn%idr%xcngg%AebIyboln".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 11);
            }
            String str = new String(charArray);
            char[] charArray2 = "hgbeb\u007f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 11);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    void addShakeView(ViewGroup viewGroup, int i, float f);

    void bindUnifiedView(ViewGroup viewGroup, List<View> list, NativeAdEventListener nativeAdEventListener);

    void bindUnifiedView(ViewGroup viewGroup, List<View> list, List<View> list2, NativeAdEventListener nativeAdEventListener);

    void bindView(ViewGroup viewGroup, NativeAdEventListener nativeAdEventListener);

    void destroy();

    String getAdvertiser();

    View getBlurView(Context context);

    String getButtonText();

    ComplianceInfo getComplianceInfo();

    View getComplianceView(Context context);

    View getComplianceView(Context context, int i);

    String getDescription();

    Bitmap getIcon();

    String getIconUrl();

    Bitmap getImage();

    String getImageUrl();

    ArrayList<String> getImageUrls();

    int getInteractionType();

    String getLandingPageUrl();

    Bitmap getLogo(Context context);

    ServerResponse.AdLogoInfo getLogoInfo();

    String getLogoUrl();

    int getMaterialType();

    Map<String, Object> getMediaExtraInfo();

    b getNativeAdType();

    HashMap<String, Object> getNativeElements();

    List<? extends View> getNativeInfoListView();

    View getNativeView();

    a getNetworkIdentifier();

    int getPictureHeight();

    int getPictureWidth();

    int getPrice();

    ShakeValue getShakeValue();

    double getStarRating();

    String getStore();

    ArrayList<String> getTextList();

    Bitmap getTextLogo(Context context);

    ServerResponse.AdLogoInfo getTextLogoInfo();

    String getTextLogoUrl();

    String getTitle();

    ArrayList<String> getVideoUrls();

    View getVideoView(Context context);

    boolean hasExpired();

    boolean isShakeAd();

    boolean isVideo();

    void setAdWidth(int i);

    void setIcon(Bitmap bitmap);

    void setImage(Bitmap bitmap);

    void setIsVideoMute(boolean z);

    void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener);

    void setNativeInfoListView(List<? extends View> list);

    void setOnSensorListener(OnSensorListener onSensorListener);

    void setVideoStateListener(VideoStateListener videoStateListener);

    void showCloseButton(boolean z);

    void unregisterViews();
}
