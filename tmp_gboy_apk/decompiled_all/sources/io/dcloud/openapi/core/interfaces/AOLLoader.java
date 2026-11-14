package io.dcloud.openapi.core.interfaces;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaaa;
import io.dcloud.openapi.core.DCloudAOLManager;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface AOLLoader {

    public interface AdImage {
        int getHeight();

        String getUrl();

        int getWidth();

        boolean isValid();
    }

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    public interface AdVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    public interface AppDownloadListener {
        void onDownloadActive(long j, long j2, String str, String str2);

        void onDownloadFailed(long j, long j2, String str, String str2);

        void onDownloadFinished(long j, String str, String str2);

        void onDownloadPaused(long j, long j2, String str, String str2);

        void onIdle();

        void onInstalled(String str, String str2);
    }

    public interface AppInfo {
        String getApkSize();

        String getAppDownloadCount();

        String getAppName();

        String getAppPackageName();

        String getAppScore();

        String getAppVersion();

        String getDeveloperName();

        String getFunctionDescUrl();

        String getPermissionInfoUrl();

        String getPrivacyUrl();
    }

    public interface ContentPageVideoListener extends VAOLInteractionListener {
        void onComplete(aaaaaaaa.aaaaaaa0 aaaaaaa0Var);

        void onError(aaaaaaaa.aaaaaaa0 aaaaaaa0Var);

        void onPause(aaaaaaaa.aaaaaaa0 aaaaaaa0Var);

        void onResume(aaaaaaaa.aaaaaaa0 aaaaaaa0Var);

        void onStart(aaaaaaaa.aaaaaaa0 aaaaaaa0Var);
    }

    public interface DrawAOLInteractionListener extends FeedAOLInteractionListener {
        void onEnd();

        void onError();

        void onPause();

        void onResume();

        void onStart();
    }

    public interface FeedAOLInteractionListener {
        void onClicked();

        void onClosed(String str);

        void onPaidGet(long j, String str, int i);

        void onRenderFail();

        void onRenderSuccess();

        void onShow();

        void onShowError();
    }

    public interface NativeAOLInteractionListener extends NativeAOLListener {
        void destroy();

        Bitmap getAdLogo();

        AppInfo getAppInfo();

        String getButtonText();

        String getDescription();

        String getIconUrl();

        List<AdImage> getImageList();

        int getInteractionType();

        int getMaterialType();

        String getSource();

        String getTitle();

        double getVideoDuration();

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
        View getVideoView(Activity activity);

        boolean isExpressAd();

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
        void setAppDownloadListener(AppDownloadListener appDownloadListener);

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
        void setVideoAdListener(VideoAdListener videoAdListener);
    }

    public interface NativeAOLListener {
        void dislike(Activity activity);

        View getVideoView(Activity activity);

        void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3);

        void setAppDownloadListener(AppDownloadListener appDownloadListener);

        void setVideoAdListener(VideoAdListener videoAdListener);
    }

    public interface RewVAOLInteractionListener extends VAOLInteractionListener {
        void onReward(JSONObject jSONObject);
    }

    public interface SplashAOLLoadListener {
        void onError(int i, String str);

        void redBag(View view, FrameLayout.LayoutParams layoutParams);
    }

    public interface VAOLInteractionListener {
        void onClick();

        void onClose();

        void onPaidGet(long j, String str, int i);

        void onShow();

        void onShowError(int i, String str);

        void onSkip();

        void onVideoPlayEnd();
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdPaused();

        void onVideoAdResume();

        void onVideoAdStartPlay();

        void onVideoError(int i, String str);

        void onVideoLoad();
    }

    boolean getPersonalAOL(Context context);

    void setPersonalAOL(Context context, boolean z);

    void setPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig);

    void updatePrivacyConfig(Context context, JSONObject jSONObject);
}
