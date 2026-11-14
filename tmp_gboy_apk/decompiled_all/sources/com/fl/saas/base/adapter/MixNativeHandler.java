package com.fl.saas.base.adapter;

import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.innterNative.NativeType;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MixNativeHandler implements MixNativeAPI, NativeLoadListener {
    private static final WeakHashMap<Class<?>, EnumMap<NativeStyle, EnumMap<NativeType, Method>>> loadMap = new WeakHashMap<>();
    private String appId;
    private NativeType customNativeType;
    private AdParams mAdParams;
    private AdSource mAdSource;
    private Context mContext;
    private NativeLoadListener mListener;
    private String posId;
    private final String TAG = CommConstant.getObjTag("Native", this);
    private NativeStyle mNativeStyle = NativeStyle.NONE;
    private boolean isCache = false;

    static {
        cIzHTL();
    }

    private static /* synthetic */ void cIzHTL() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void handleLoadEvent(Consumer<? super NativeLoadListener> consumer) {
        Optional.ofNullable(this.mListener).ifPresent(consumer);
    }

    private void registerLoadMethod(Class<?> cls) {
        if (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            EnumMap<NativeStyle, EnumMap<NativeType, Method>> enumMap = new EnumMap<>((Class<NativeStyle>) NativeStyle.class);
            for (Method method : declaredMethods) {
                MixNativeLoad mixNativeLoad = (MixNativeLoad) method.getAnnotation(MixNativeLoad.class);
                if (mixNativeLoad != null) {
                    NativeStyle style = mixNativeLoad.style();
                    EnumMap<NativeType, Method> enumMap2 = enumMap.get(style);
                    if (enumMap2 == null) {
                        enumMap2 = new EnumMap<>((Class<NativeType>) NativeType.class);
                        enumMap.put((EnumMap<NativeStyle, EnumMap<NativeType, Method>>) style, (NativeStyle) enumMap2);
                    }
                    enumMap2.put((EnumMap<NativeType, Method>) mixNativeLoad.type(), (NativeType) method);
                }
            }
            loadMap.put(cls, enumMap);
        }
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void clearCache() {
        this.isCache = false;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void destroy() {
        this.mListener = null;
    }

    public AdParams getAdParams() {
        return this.mAdParams;
    }

    public AdSource getAdSource() {
        return this.mAdSource;
    }

    public NativeStyle getAdStyle() {
        if (this.mNativeStyle == NativeStyle.NONE) {
            this.mNativeStyle = NativeStyle.create(this.mAdSource.getAdStyle());
        }
        return this.mNativeStyle;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.mAdSource.app_key;
    }

    public int getBidfloor() {
        return this.mAdSource.bidfloor;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getExt() {
        return this.mAdSource.getExt();
    }

    public String getKey() {
        return this.mAdParams.getKey();
    }

    public String getPosId() {
        return this.posId;
    }

    public String getSDKBidToken() {
        return this.mAdSource.token;
    }

    public NativeType getType(int i) {
        return null;
    }

    public <T> void handleAd(T t, AmA8tU.A2egSU a2egSU) {
        NativeAd nativeAd;
        StringBuilder sb;
        String str;
        if (t == null) {
            str = "onLoadFailed, native is empty";
            LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
            sb = new StringBuilder();
            sb.append(this.TAG);
        } else {
            if (a2egSU == null) {
                LogcatUtil.e(this.TAG, "handleAd success but mapper is null");
                nativeAd = null;
            } else {
                nativeAd = (NativeAd) a2egSU.apply(t);
            }
            if (nativeAd != null) {
                onNativeAdLoaded(nativeAd);
                return;
            }
            LogcatUtil.e(this.TAG, "handleAd success but nativeAd is null");
            sb = new StringBuilder();
            sb.append(this.TAG);
            str = ",native is empty";
        }
        sb.append(str);
        onLoadFailed(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void handleListAd(List<T> list, AmA8tU.A2egSU a2egSU) {
        handleAd(Check.findFirstNonNull(list), a2egSU);
    }

    public abstract void init();

    public boolean isC2CBidAd() {
        return this.mAdSource.isC2SBidAd;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public boolean isGromore() {
        return this.mAdSource.isGromore();
    }

    public boolean isSDKBidAd() {
        return this.mAdSource.isSDKBidAd;
    }

    public boolean isUseSurfaceView() {
        return this.mAdParams.isUseSurfaceView();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    @Override // com.fl.saas.base.adapter.MixNativeAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void load(android.app.Activity r10) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.adapter.MixNativeHandler.load(android.app.Activity):void");
    }

    @Override // com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        LogcatUtil.d(this.TAG, "onAdFailed:" + ydError);
        handleLoadEvent(new A2egSU(7, ydError));
    }

    public void onLoadFailed(String str) {
        LogcatUtil.e(this.TAG, str);
        onAdFailed(YdError.create(ErrorCodeConstant.NETWORK_ERROR, str));
    }

    @Override // com.fl.saas.api.mixNative.NativeLoadListener
    public void onNativeAdLoaded(NativeAd nativeAd) {
        LogcatUtil.d(this.TAG, "onNativeAdLoaded");
        handleLoadEvent(new AYUAbz(nativeAd, 1));
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdId(String str, String str2) {
        this.appId = str;
        this.posId = str2;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdParams(AdParams adParams) {
        this.mAdParams = adParams;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdSource(AdSource adSource) {
        this.mAdSource = adSource;
        this.appId = adSource.app_id;
        this.posId = adSource.tagid;
        this.mNativeStyle = NativeStyle.create(adSource.getAdStyle());
        return this;
    }

    public MixNativeHandler setAdStyle(NativeStyle nativeStyle) {
        this.mNativeStyle = nativeStyle;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void setCache() {
        this.isCache = true;
        this.mListener = null;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public void setCustomNativeType(NativeType nativeType) {
        this.customNativeType = nativeType;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setLoadListener(NativeLoadListener nativeLoadListener) {
        this.mListener = nativeLoadListener;
        return this;
    }
}
