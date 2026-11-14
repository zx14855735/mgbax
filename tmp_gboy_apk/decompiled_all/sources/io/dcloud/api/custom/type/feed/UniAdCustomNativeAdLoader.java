package io.dcloud.api.custom.type.feed;

import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomNativeAdLoader extends UniAdCustomBaseLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void destroy() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final boolean isReady() {
        return false;
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdClicked() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdClosed() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdPlayEnd() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdPlayError(int i, String str) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdShow() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onAdSkip() {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadFail(int i, String str) {
        super.onLoadFail(i, str);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess(List<? extends UniAdCustomNativeAd> list) {
        super.onLoadSuccess(list);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void setBidPrice(int i) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess() {
        throw new RuntimeException("should call method 'onLoadSuccess(List ads)'.");
    }
}
