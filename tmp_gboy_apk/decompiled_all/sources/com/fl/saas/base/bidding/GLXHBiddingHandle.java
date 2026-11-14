package com.fl.saas.base.bidding;

import android.content.Context;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface GLXHBiddingHandle extends Bidding {

    public interface Callback {
        void onFinish(AdSource adSource);
    }

    void handleBiddingSource(Context context, AdSource adSource, Callback callback);
}
