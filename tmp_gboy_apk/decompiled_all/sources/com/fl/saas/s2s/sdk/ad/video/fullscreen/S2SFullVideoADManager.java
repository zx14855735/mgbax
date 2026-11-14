package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CacheListener;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SFullVideoADManager {
    private AdInfoPoJo mAdInfoPoJo;
    private final CacheListener mCacheListener;
    private OnS2SFullVideoADListener mListener;
    private String mediaId = "";

    public S2SFullVideoADManager(CacheListener cacheListener) {
        this.mCacheListener = cacheListener;
    }

    public void destroy() {
        this.mAdInfoPoJo = null;
        this.mListener = null;
    }

    public AdInfoPoJo getAdInfoPoJo() {
        return this.mAdInfoPoJo;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public S2SFullVideoADManager init(List<AdInfoPoJo> list, OnS2SFullVideoADListener onS2SFullVideoADListener) {
        if (list != null && list.size() > 0) {
            AdInfoPoJo adInfoPoJo = list.get(0);
            if (onS2SFullVideoADListener != null) {
                this.mListener = onS2SFullVideoADListener;
                if (adInfoPoJo != null) {
                    this.mAdInfoPoJo = adInfoPoJo;
                    onS2SFullVideoADListener.onLoad(this);
                    return this;
                }
                onError("视频地址为空");
            }
        }
        return this;
    }

    public boolean isCache() {
        CacheListener cacheListener = this.mCacheListener;
        return cacheListener != null && cacheListener.isCache();
    }

    public boolean isReady() {
        if (getAdInfoPoJo() == null) {
            return false;
        }
        if (!TextUtils.isEmpty(getAdInfoPoJo().video_url)) {
            return true;
        }
        if (getAdInfoPoJo().rd_countdown > 0) {
            return !TextUtils.isEmpty(getAdInfoPoJo().img_url);
        }
        return false;
    }

    public void onClick() {
        OnS2SFullVideoADListener onS2SFullVideoADListener = this.mListener;
        if (onS2SFullVideoADListener != null) {
            onS2SFullVideoADListener.onClick("");
        }
    }

    public void onClose() {
        OnS2SFullVideoADListener onS2SFullVideoADListener = this.mListener;
        if (onS2SFullVideoADListener != null) {
            onS2SFullVideoADListener.onClose();
        }
    }

    public void onComplete() {
        OnS2SFullVideoADListener onS2SFullVideoADListener = this.mListener;
        if (onS2SFullVideoADListener != null) {
            onS2SFullVideoADListener.onComplete(this.mAdInfoPoJo != null ? r1.price : 0);
        }
    }

    public void onError(int i, String str) {
        OnS2SFullVideoADListener onS2SFullVideoADListener = this.mListener;
        if (onS2SFullVideoADListener != null) {
            onS2SFullVideoADListener.onError(YdError.create(i, str));
        }
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void showAd(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) S2SFullVideoActivity.class);
            S2SFullVideoActivity.setAdInfo(this);
            activity.startActivity(intent);
        }
    }

    public void onError(String str) {
        onError(0, str);
    }
}
