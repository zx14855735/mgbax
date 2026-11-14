package com.fl.saas.base.base.listener;

import com.fl.saas.common.pojo.YdNativePojo;
import java.util.List;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerNativeLoaded {

    @Deprecated
    public interface DrawVideoLoaded {
        @Deprecated
        void onAdViewLoaded(List<YdNativePojo> list);
    }

    @Deprecated
    public interface NativeDisplay {
        @Deprecated
        void onAdDisplay(List<YdNativePojo> list);
    }
}
