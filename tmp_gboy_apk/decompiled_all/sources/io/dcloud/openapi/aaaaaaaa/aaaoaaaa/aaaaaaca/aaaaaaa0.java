package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 implements AOLLoader.FeedAOLInteractionListener, AOLLoader.NativeAOLInteractionListener {
    protected aaaaaaao aaaaaaa0;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaa;

    public aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa() {
        this.aaaaaaaa.aaoaaaaa();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public void destroy() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(Activity activity) {
        this.aaaaaaaa.dislike(activity);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public Bitmap getAdLogo() {
        return this.aaaaaaaa.getAdLogo();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public AOLLoader.AppInfo getAppInfo() {
        return this.aaaaaaaa.getAppInfo();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getButtonText() {
        return this.aaaaaaaa.getButtonText();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getDescription() {
        return this.aaaaaaaa.getDescription();
    }

    public View getFeedAOLView(Activity activity) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            return aaaaaaaaVar.aaaaaaaa(activity);
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getIconUrl() {
        return this.aaaaaaaa.getIconUrl();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public List<AOLLoader.AdImage> getImageList() {
        return this.aaaaaaaa.getImageList();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getInteractionType() {
        return this.aaaaaaaa.getInteractionType();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getMaterialType() {
        return this.aaaaaaaa.getMaterialType();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getSource() {
        return this.aaaaaaaa.getSource();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getTitle() {
        return this.aaaaaaaa.getTitle();
    }

    public String getType() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        return aaaaaaaaVar != null ? aaaaaaaaVar.aaaaaaac() : "";
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public double getVideoDuration() {
        return this.aaaaaaaa.getVideoDuration();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public View getVideoView(Activity activity) {
        if (Thread.currentThread() == MainHandlerUtil.getMainHandler().getLooper().getThread()) {
            return this.aaaaaaaa.getVideoView(activity);
        }
        throw new RuntimeException("getVideoView must be called on the main thread");
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        return this.aaaaaaaa.isExpressAd();
    }

    public boolean isValid() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        return aaaaaaaaVar != null && aaaaaaaaVar.aaaaaaau();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClicked() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onClick();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClosed(String str) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onClosed(str);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderFail() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onRenderFail();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderSuccess() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onRenderSuccess();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShow() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onShow();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShowError() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onShowError();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3) {
        this.aaaaaaaa.aaaaaaaa(this);
        this.aaaaaaaa.registerViewForInteraction(activity, frameLayout, list, list2, list3);
    }

    public void render() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
            MainHandlerUtil.getMainHandler().post(new com.fl.saas.common.crash.A2egSU(3, this));
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(AOLLoader.AppDownloadListener appDownloadListener) {
        this.aaaaaaaa.setAppDownloadListener(appDownloadListener);
    }

    public void setFeedAOLListener(aaaaaaao aaaaaaaoVar) {
        this.aaaaaaa0 = aaaaaaaoVar;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(AOLLoader.VideoAdListener videoAdListener) {
        this.aaaaaaaa.setVideoAdListener(videoAdListener);
    }
}
