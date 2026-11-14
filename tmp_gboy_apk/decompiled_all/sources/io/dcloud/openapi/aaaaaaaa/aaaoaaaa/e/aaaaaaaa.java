package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e;

import Dphsd2.AlLFFp;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.sigmob.sdk.videoplayer.AMqCpz;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0 implements AOLLoader.FeedAOLInteractionListener, AOLLoader.NativeAOLInteractionListener, AOLLoader.AppDownloadListener, AOLLoader.VideoAdListener {
    private final DCBaseAOL aaaaaaa0;
    protected AOLLoader.FeedAOLInteractionListener aaaaaaac;
    private AOLLoader.VideoAdListener aaaaaaae;
    private AOLLoader.AppDownloadListener aaaaaaan;
    private final Activity aaaaaaao;
    private SparseArray aaaaaaau;

    public aaaaaaaa(DCBaseAOL dCBaseAOL, Activity activity) {
        this.aaaaaaau = new SparseArray();
        this.aaaaaaa0 = dCBaseAOL;
        this.aaaaaaao = activity;
        dCBaseAOL.aaaaaaaa(this);
        this.aaaaaaau = dCBaseAOL.getNativeAdInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaa0(long j, long j2, String str, String str2) {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadFailed(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(String str) {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onClosed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaae() {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onIdle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaan() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaav() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onRenderFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaea() {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaeo() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onRenderSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaeaa() {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaeaaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onShowError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaeaaaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener != null) {
            feedAOLInteractionListener.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aeaaaaaa() {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aoaaaaaa() {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void eaaaaaaa() {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdResume();
        }
    }

    public String aaaaaaac() {
        return this.aaaaaaa0 != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaao(this.aaaaaaa0.getType()) : "";
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0
    public boolean aaaaaaao() {
        return false;
    }

    public boolean aaaaaaau() {
        DCBaseAOL dCBaseAOL = this.aaaaaaa0;
        return dCBaseAOL != null && dCBaseAOL.isValid();
    }

    public void aaoaaaaa() {
        DCBaseAOL dCBaseAOL = this.aaaaaaa0;
        if (dCBaseAOL != null) {
            dCBaseAOL.render();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public void destroy() {
        DCBaseAOL dCBaseAOL = this.aaaaaaa0;
        if (dCBaseAOL != null) {
            dCBaseAOL.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(Activity activity) {
        Object obj = this.aaaaaaa0;
        if (obj instanceof AOLLoader.NativeAOLListener) {
            ((AOLLoader.NativeAOLListener) obj).dislike(activity);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public AOLLoader.AppInfo getAppInfo() {
        Object obj = this.aaaaaaau.get(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, null);
        if (obj instanceof AOLLoader.AppInfo) {
            return (AOLLoader.AppInfo) obj;
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getButtonText() {
        return this.aaaaaaau.get(1000, "").toString();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getDescription() {
        return this.aaaaaaau.get(1001, "").toString();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getIconUrl() {
        return this.aaaaaaau.get(1002, "").toString();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public List getImageList() {
        return (List) this.aaaaaaau.get(1009, Collections.EMPTY_LIST);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getInteractionType() {
        return ((Integer) this.aaaaaaau.get(PluginConstants.ERROR_PLUGIN_FETCH, 0)).intValue();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public int getMaterialType() {
        return ((Integer) this.aaaaaaau.get(1008, 0)).intValue();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getSource() {
        return this.aaaaaaau.get(1003, "").toString();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public String getTitle() {
        return this.aaaaaaau.get(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "").toString();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public double getVideoDuration() {
        return Double.parseDouble(this.aaaaaaau.get(1010, 0).toString());
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public View getVideoView(Activity activity) {
        Object obj = this.aaaaaaa0;
        if (obj instanceof AOLLoader.NativeAOLListener) {
            return ((AOLLoader.NativeAOLListener) obj).getVideoView(activity);
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        SparseArray sparseArray = this.aaaaaaau;
        return sparseArray == null || ((Boolean) sparseArray.get(1005, Boolean.TRUE)).booleanValue();
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClicked() {
        aaaaaaaa(this.aaaaaaao, this.aaaaaaa0);
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 9));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onClosed(String str) {
        MainHandlerUtil.getMainHandler().post(new AMqCpz(this, 2, str));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        MainHandlerUtil.getMainHandler().post(new A4TApA(this, j, j2, str, str2, 2));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        MainHandlerUtil.getMainHandler().post(new A4TApA(this, j, j2, str, str2, 0));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.A5SV6n
            @Override // java.lang.Runnable
            public final void run() {
                aaaaaaaa.this.aaaaaaaa(j, str, str2);
            }
        });
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        MainHandlerUtil.getMainHandler().post(new A4TApA(this, j, j2, str, str2, 1));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onIdle() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 5));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.AppDownloadListener
    public void onInstalled(String str, String str2) {
        MainHandlerUtil.getMainHandler().post(new AlLFFp(11, this, str, str2));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
        aaaaaaaa(aaaaaaaa(), this.aaaaaaa0, j, str, i);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onProgressUpdate(final long j, final long j2) {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.ADYaiT
            @Override // java.lang.Runnable
            public final void run() {
                aaaaaaaa.this.aaaaaaaa(j, j2);
            }
        });
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderFail() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 6));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onRenderSuccess() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 4));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShow() {
        aaaaaaa0(this.aaaaaaao, this.aaaaaaa0);
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 10));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.FeedAOLInteractionListener
    public void onShowError() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 0));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdComplete() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 8));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdPaused() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 7));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdResume() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 2));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoAdStartPlay() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 1));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoError(int i, String str) {
        MainHandlerUtil.getMainHandler().post(new DUi7mC.A2egSU(i, 5, this, str));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
    public void onVideoLoad() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 3));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List list, List list2, List list3) {
        Object obj = this.aaaaaaa0;
        if (obj instanceof AOLLoader.NativeAOLListener) {
            ((AOLLoader.NativeAOLListener) obj).registerViewForInteraction(activity, frameLayout, list, list2, list3);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(AOLLoader.AppDownloadListener appDownloadListener) {
        Object obj = this.aaaaaaa0;
        if (obj instanceof AOLLoader.NativeAOLListener) {
            ((AOLLoader.NativeAOLListener) obj).setAppDownloadListener(this);
            this.aaaaaaan = appDownloadListener;
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(AOLLoader.VideoAdListener videoAdListener) {
        Object obj = this.aaaaaaa0;
        if (obj instanceof AOLLoader.NativeAOLListener) {
            ((AOLLoader.NativeAOLListener) obj).setVideoAdListener(this);
            this.aaaaaaae = videoAdListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaao(long j, long j2, String str, String str2) {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadPaused(j, j2, str, str2);
        }
    }

    public View aaaaaaaa(Activity activity) {
        DCBaseAOL dCBaseAOL = this.aaaaaaa0;
        if (dCBaseAOL != null) {
            return dCBaseAOL.getExpressAdView(activity);
        }
        return null;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0
    public Activity aaaaaaaa() {
        return this.aaaaaaao;
    }

    public void aaaaaaaa(AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener) {
        this.aaaaaaac = feedAOLInteractionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(long j, long j2, String str, String str2) {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadActive(j, j2, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(long j, String str, String str2) {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadFinished(j, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(String str, String str2) {
        AOLLoader.AppDownloadListener appDownloadListener = this.aaaaaaan;
        if (appDownloadListener != null) {
            appDownloadListener.onInstalled(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(int i, String str) {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(long j, long j2) {
        AOLLoader.VideoAdListener videoAdListener = this.aaaaaaae;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }
}
