package com.fl.saas.base.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.interfaces.ISplashEyeAd;
import com.fl.saas.base.interfaces.SplashEyeAdListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomSplashEyeAd implements ISplashEyeAd {
    protected AdapterAPI mBaseAdAdapter;
    protected ViewGroup mEyeAdContainer;
    protected SplashEyeAdListener mSplashEyeAdListener;
    protected View mSplashView;

    public CustomSplashEyeAd(AdapterAPI adapterAPI) {
        this.mBaseAdAdapter = adapterAPI;
    }

    public abstract void customResourceDestory();

    @Override // com.fl.saas.base.interfaces.ISplashEyeAd
    public final void destroy() {
        try {
            AdapterAPI adapterAPI = this.mBaseAdAdapter;
            if (adapterAPI != null) {
                adapterAPI.destroy();
                this.mBaseAdAdapter = null;
            }
            this.mSplashEyeAdListener = null;
            View view = this.mSplashView;
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) this.mSplashView.getParent()).removeView(this.mSplashView);
                }
                this.mSplashView = null;
            }
            ViewGroup viewGroup = this.mEyeAdContainer;
            if (viewGroup != null) {
                if (viewGroup.getParent() != null) {
                    ((ViewGroup) this.mEyeAdContainer.getParent()).removeView(this.mEyeAdContainer);
                }
                this.mEyeAdContainer = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            customResourceDestory();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public SplashEyeAdListener getSplashEyeAdListener() {
        return this.mSplashEyeAdListener;
    }

    @Override // com.fl.saas.base.interfaces.ISplashEyeAd
    public void setEyeAdContainer(ViewGroup viewGroup) {
        this.mEyeAdContainer = viewGroup;
    }

    public void setSplashView(View view) {
        this.mSplashView = view;
    }

    public abstract void show(Context context, Rect rect);

    @Override // com.fl.saas.base.interfaces.ISplashEyeAd
    public final void show(Context context, Rect rect, SplashEyeAdListener splashEyeAdListener) {
        this.mSplashEyeAdListener = splashEyeAdListener;
        show(context, rect);
    }
}
