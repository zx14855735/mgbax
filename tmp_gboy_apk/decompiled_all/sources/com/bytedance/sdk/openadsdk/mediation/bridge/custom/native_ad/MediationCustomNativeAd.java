package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.xj.hf;
import com.bytedance.sdk.openadsdk.mediation.xj.xj;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationCustomNativeAd extends xj implements IMediationCustomNativeAd {
    private List<String> am;
    private int c;
    private String d;
    private int e;
    private int f;
    private double g;
    private Map<String, Object> hf;
    private Function jk;
    private String kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10472pl;
    private MediationCustomNativeDislikeDialog pz;
    private String qt;
    private String tf;
    private String u;
    private MediationNativeAdAppInfo v;
    private String w;
    private double xj;
    private String y;
    private int yo;
    private boolean zg;

    private Integer xj() {
        MediationConstant.AdIsReadyStatus isReadyCondition = isReadyCondition();
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        return isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY ? 4 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.jk = hf.xj(valueSet.objectValue(8034, Object.class));
        } else if (i == 6083) {
            render();
        } else {
            if (i == 6081) {
                return (T) getExpressView();
            }
            if (i == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder(hf.xj(valueSet.objectValue(8071, Object.class))));
            } else {
                if (i == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8121) {
                        return (T) xj();
                    }
                    if (i == 8194) {
                        String stringValue = valueSet.stringValue(8036, null);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.pz;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(stringValue, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.pz;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new com.bytedance.sdk.openadsdk.mediation.hf.xj.hf(dislikeDialog);
                        }
                    } else {
                        if (i == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            y.w(MediationConstant.TAG, "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        } else if (i == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8130, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8113, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8184, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i, String str) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8132, sparseArray, -99999987, -99999985, Void.class);
            A2egSU.B3GDIM(i, sparseArray, 8038, 8039, str);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8185, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8187, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8157, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8155, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8158, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8152, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8156, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i, String str) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8134, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f, float f2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8133, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f));
            sparseArray.put(8041, Float.valueOf(f2));
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8118, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i, String str) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8117, sparseArray, -99999987, -99999985, Void.class);
            A2egSU.B3GDIM(i, sparseArray, 8014, 8015, str);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8146, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8154, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(8072, Long.valueOf(j));
            sparseArray.put(8073, Long.valueOf(j2));
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8150, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(8145, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xj.xj
    public SparseArray<Object> get() {
        return getValues();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Object apply;
        if (this.jk == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8226, sparseArray, -99999987, -99999985, Integer.class);
        apply = this.jk.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    public SparseArray<Object> getValues() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8016, Double.valueOf(this.xj));
        sparseArray.put(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.hf);
        sparseArray.put(8045, this.w);
        sparseArray.put(8046, this.u);
        sparseArray.put(8048, this.kd);
        sparseArray.put(8050, this.y);
        sparseArray.put(8051, Integer.valueOf(this.f));
        sparseArray.put(8052, Integer.valueOf(this.c));
        sparseArray.put(8061, this.d);
        sparseArray.put(8054, this.tf);
        sparseArray.put(8420, Integer.valueOf(this.p));
        sparseArray.put(8421, Integer.valueOf(this.f10472pl));
        sparseArray.put(8082, Double.valueOf(this.g));
        sparseArray.put(8053, this.am);
        sparseArray.put(8049, this.qt);
        sparseArray.put(8033, Boolean.valueOf(this.zg));
        sparseArray.put(8060, Integer.valueOf(this.e));
        sparseArray.put(8059, Integer.valueOf(this.yo));
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.v;
        if (mediationNativeAdAppInfo != null) {
            sparseArray.put(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return sparseArray;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    public View getVideoView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        Object apply;
        if (this.jk == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8110, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.jk.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        Object apply;
        if (this.jk == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8136, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.jk.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Object apply;
        if (this.jk == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(8160, sparseArray, -99999987, -99999985, Boolean.class);
        apply = this.jk.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i) {
        this.e = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d) {
        this.xj = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.u = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        if (this.jk != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(6085, sparseArray, -99999987, -99999985, Void.class);
            this.jk.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.zg = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.kd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i) {
        this.f = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.am = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.y = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i) {
        this.yo = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.hf = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.v = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.tf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.qt = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d) {
        this.g = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.w = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i) {
        this.f10472pl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i) {
        this.p = i;
    }
}
