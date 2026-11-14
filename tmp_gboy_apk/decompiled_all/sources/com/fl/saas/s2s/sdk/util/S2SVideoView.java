package com.fl.saas.s2s.sdk.util;

import ADYaiT.BChYOn;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.saas.videocache.VideoPreLoadModel;
import com.fl.saas.videocache.VideoProxyHelper;
import com.kwad.sdk.collector.AppStatusRules;
import com.sigmob.sdk.base.blurkit.d;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class S2SVideoView extends FrameLayout implements VideoSoundControlListener {
    private final int MSG_AD_VISIBLE_CHECK;
    private int currentTime;
    private RelativeLayout endFrameView;
    private ImageView firstFrameView;
    private boolean hasChangeSurfaceViewSize;
    private ImageView icon;
    private boolean isPlayError;
    private AdInfoPoJo mAdInfoPoJo;
    private final Context mContext;
    private final Handler mDurationCountdownHandler;
    Handler mHandler;
    private boolean mIs25Preent;
    private boolean mIs50Preent;
    private boolean mIs75Preent;
    private boolean mIsCallPlay;
    private boolean mIsFirstCreateSurfaceView;
    private boolean mIsSoundEnable;
    private boolean mIsSurfaceViewCreate;
    private boolean mIsVideoCompleted;
    private boolean mIsVideoPrepared;
    private S2SVideoPlayListener mPlayListener;
    private MediaPlayer mediaPlayer;
    private ImageView soundControlImageView;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private TextView textView;
    private TextView tvBtn;
    private TextView tvTitle;
    private VideoSoundControlListener.SoundControlViewStateChangeListener viewStateChangeListener;

    /* renamed from: com.fl.saas.s2s.sdk.util.S2SVideoView$7, reason: invalid class name */
    public class AnonymousClass7 implements SurfaceHolder.Callback {
        public AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$surfaceCreated$0() {
            S2SVideoView s2SVideoView = S2SVideoView.this;
            s2SVideoView.startVideo(s2SVideoView.mAdInfoPoJo.autoPlayCheckWifi());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogcatUtil.d("YdSDK-S2SVideoView", "surfaceCreated");
            S2SVideoView.this.mIsSurfaceViewCreate = true;
            if (S2SVideoView.this.mediaPlayer == null) {
                S2SVideoView.this.createMediaView();
            }
            if (S2SVideoView.this.mediaPlayer != null) {
                S2SVideoView.this.mediaPlayer.setDisplay(surfaceHolder);
            }
            if (!S2SVideoView.this.mIsFirstCreateSurfaceView) {
                LogcatUtil.d("YdSDK-S2SVideoView", "restart");
                if (!S2SVideoView.this.mIsVideoCompleted && !S2SVideoView.this.mIsCallPlay && S2SVideoView.this.mIsVideoPrepared) {
                    DeviceUtil.postUIDelayed(200L, new A4TApA(0, this));
                    return;
                }
                if (S2SVideoView.this.mediaPlayer == null || !S2SVideoView.this.mIsVideoPrepared || S2SVideoView.this.mIsVideoCompleted) {
                    return;
                }
                if (S2SVideoView.this.currentTime > 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        S2SVideoView.this.mediaPlayer.seekTo(S2SVideoView.this.currentTime, 3);
                    } else {
                        S2SVideoView.this.mediaPlayer.seekTo(S2SVideoView.this.currentTime);
                    }
                }
                S2SVideoView.this.mediaPlayer.start();
                return;
            }
            S2SVideoView.this.mIsFirstCreateSurfaceView = false;
            try {
                LogcatUtil.d("YdSDK-S2SVideoView", "surfaceFirstCreate");
                if (S2SVideoView.this.mediaPlayer != null) {
                    LogcatUtil.d("YdSDK-S2SVideoView", "beforePrepare");
                    S2SVideoView.this.mediaPlayer.setDataSource(VideoProxyHelper.getInstance().getProxyUrl(S2SVideoView.this.mContext, new VideoPreLoadModel(AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, S2SVideoView.this.mAdInfoPoJo.video_url)));
                    S2SVideoView.this.mediaPlayer.prepareAsync();
                    LogcatUtil.d("YdSDK-S2SVideoView", "startPrepare");
                }
            } catch (Exception e) {
                LogcatUtil.d("YdSDK-S2SVideoView", "setSourceError" + e.getMessage());
                e.printStackTrace();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            S2SVideoView.this.mIsSurfaceViewCreate = false;
            if (S2SVideoView.this.mediaPlayer == null || !S2SVideoView.this.mediaPlayer.isPlaying()) {
                return;
            }
            S2SVideoView s2SVideoView = S2SVideoView.this;
            s2SVideoView.currentTime = s2SVideoView.mediaPlayer.getCurrentPosition();
            S2SVideoView.this.mediaPlayer.pause();
        }
    }

    public S2SVideoView(Context context) {
        super(context);
        this.MSG_AD_VISIBLE_CHECK = ErrorCodeConstant.PRICE_ERROR;
        this.hasChangeSurfaceViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsSurfaceViewCreate = false;
        this.mIsFirstCreateSurfaceView = true;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.mDurationCountdownHandler = new Handler();
        this.isPlayError = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.9
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 11000) {
                    return;
                }
                if (S2SVideoView.this.checkViewVisible()) {
                    S2SVideoView s2SVideoView = S2SVideoView.this;
                    s2SVideoView.startVideo(s2SVideoView.mAdInfoPoJo.autoPlayCheckWifi());
                } else {
                    Handler handler = S2SVideoView.this.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(ErrorCodeConstant.PRICE_ERROR, 500L);
                    }
                }
            }
        };
        this.mContext = context;
        setBackgroundColor(d.f13043a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceViewSize(boolean z) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (z && this.hasChangeSurfaceViewSize) {
            return;
        }
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = this.mediaPlayer.getVideoHeight();
        int width = getWidth();
        int height = getHeight();
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(videoWidth, videoHeight, "changeSize----width:", "height:", "viewWidth:");
        B7CMnp2.append(width);
        B7CMnp2.append("viewHeight:");
        B7CMnp2.append(height);
        LogcatUtil.d("YdSDK-S2SVideoView", B7CMnp2.toString());
        if (videoWidth <= 0 || videoHeight <= 0 || width <= 0 || height <= 0) {
            return;
        }
        this.hasChangeSurfaceViewSize = true;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.surfaceView.getLayoutParams();
        int i = height * videoWidth;
        int i2 = width * videoHeight;
        if (i > i2) {
            layoutParams.height = i2 / videoWidth;
        } else {
            layoutParams.width = i / videoHeight;
        }
        this.surfaceView.setLayoutParams(layoutParams);
    }

    private boolean checkAreaEffective(Rect rect) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            if (rect.height() * rect.width() > width * height * 0.7d) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewVisible() {
        Rect rect = new Rect();
        return getGlobalVisibleRect(rect) && checkAreaEffective(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMediaView() {
        this.mIsVideoCompleted = false;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                S2SVideoView.this.mIsVideoCompleted = true;
                S2SVideoView.this.showEndFrame();
                CommReportHelper.getInstance().reportVideoEnd(S2SVideoView.this.mAdInfoPoJo, mediaPlayer2.getDuration());
                S2SVideoView.this.mAdInfoPoJo.END_TIME = mediaPlayer2.getDuration() / 1000;
                CommReportHelper.getInstance().reportVideoInfo(S2SVideoView.this.mAdInfoPoJo);
                if (S2SVideoView.this.mPlayListener != null) {
                    S2SVideoView.this.mPlayListener.onVideoPlayComplete();
                }
            }
        });
        this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                if (!S2SVideoView.this.isPlayError) {
                    S2SVideoView.this.isPlayError = true;
                    S2SVideoView.this.mAdInfoPoJo.END_TIME = mediaPlayer2.getDuration() / 1000;
                    S2SVideoView.this.mAdInfoPoJo.STATUS = 2;
                    CommReportHelper.getInstance().reportVideoInfo(S2SVideoView.this.mAdInfoPoJo);
                    if (S2SVideoView.this.mPlayListener != null) {
                        S2SVideoView.this.mPlayListener.onVideoPlayError(i, i2);
                    }
                    S2SVideoView.this.showEndFrame();
                }
                return true;
            }
        });
        this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                LogcatUtil.d("YdSDK-S2SVideoView", "prepared");
                S2SVideoView.this.mIsVideoPrepared = true;
                S2SVideoView.this.mAdInfoPoJo.PLAY_LAST_FRAME = 1;
                if (mediaPlayer2 != null && mediaPlayer2.getDuration() > 0) {
                    S2SVideoView.this.mAdInfoPoJo.VIDEO_TIME = mediaPlayer2.getDuration() / 1000;
                }
                S2SVideoView s2SVideoView = S2SVideoView.this;
                s2SVideoView.setSoundEnable(s2SVideoView.mIsSoundEnable);
                if (S2SVideoView.this.mIsVideoCompleted || S2SVideoView.this.mIsCallPlay) {
                    return;
                }
                S2SVideoView s2SVideoView2 = S2SVideoView.this;
                s2SVideoView2.startVideo(s2SVideoView2.mAdInfoPoJo.autoPlayCheckWifi());
            }
        });
        this.mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.6
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                int videoWidth = mediaPlayer2.getVideoWidth();
                int videoHeight = mediaPlayer2.getVideoHeight();
                if (videoWidth == 0 || videoHeight == 0) {
                    return;
                }
                if (S2SVideoView.this.surfaceView != null) {
                    S2SVideoView.this.surfaceView.getHolder().setFixedSize(videoWidth, videoHeight);
                }
                S2SVideoView.this.changeSurfaceViewSize(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$0(View view) {
        setSoundEnable(!this.mIsSoundEnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$1(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap == null || (imageView = this.firstFrameView) == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$2(AdInfoPoJo adInfoPoJo) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(adInfoPoJo.video_url, new HashMap());
                DeviceUtil.postUI(new BChYOn(this, 26, mediaMetadataRetriever.getFrameAtTime()));
                mediaMetadataRetriever.release();
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    mediaMetadataRetriever.release();
                } catch (Throwable th2) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    throw th2;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startVideo$3(View view) {
        ViewHelper.removeParent(view);
        startVideo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startVideo$4() {
        ImageView imageView = this.firstFrameView;
        if (imageView != null) {
            ViewHelper.removeParent(imageView);
            this.firstFrameView = null;
        }
    }

    private void setSurfaceHolder() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (this.surfaceView == null) {
            SurfaceView surfaceView = new SurfaceView(this.mContext);
            this.surfaceView = surfaceView;
            surfaceView.setZOrderOnTop(false);
            SurfaceHolder holder = this.surfaceView.getHolder();
            this.surfaceHolder = holder;
            holder.addCallback(new AnonymousClass7());
            addView(this.surfaceView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEndFrame() {
        if (this.endFrameView == null || this.icon == null || this.tvTitle == null || this.tvBtn == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (width > DeviceUtil.getMobileWidth()) {
            width = DeviceUtil.getMobileWidth();
        }
        if (height > DeviceUtil.getMobileHeight()) {
            height = DeviceUtil.getMobileHeight();
        }
        if (width > height) {
            int i = (int) (height * 0.25d);
            this.icon.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        } else {
            int i2 = (int) (width * 0.25d);
            this.icon.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        }
        this.endFrameView.setVisibility(0);
        ImageView imageView = this.soundControlImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        VideoSoundControlListener.SoundControlViewStateChangeListener soundControlViewStateChangeListener = this.viewStateChangeListener;
        if (soundControlViewStateChangeListener != null) {
            soundControlViewStateChangeListener.changeViewVisible(false);
        }
        if (this.endFrameView.getParent() != null && (this.endFrameView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.endFrameView.getParent()).removeView(this.endFrameView);
        }
        addView(this.endFrameView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo(boolean z) {
        LogcatUtil.d("YdSDK-S2SVideoView", "startPlayVideo");
        if (checkViewVisible() && this.mIsSurfaceViewCreate) {
            changeSurfaceViewSize(true);
            if (z && !"1".equals(DeviceUtil.getNetworkType())) {
                if (this.textView == null) {
                    TextView textView = new TextView(getContext());
                    this.textView = textView;
                    textView.setText("播放");
                    this.textView.setTextSize(12.0f);
                    this.textView.setPadding(DeviceUtil.dip2px(10.0f), DeviceUtil.dip2px(5.0f), DeviceUtil.dip2px(10.0f), DeviceUtil.dip2px(5.0f));
                    this.textView.setBackground(this.mContext.getDrawable(R.drawable.yd_saas_reward_video_adinfo_btn));
                    this.textView.setTypeface(Typeface.DEFAULT_BOLD);
                    this.textView.setTextColor(Color.parseColor("#ffffff"));
                    this.textView.setOnClickListener(new A2egSU(this, 1));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    addView(this.textView, layoutParams);
                    return;
                }
                return;
            }
            if (this.mediaPlayer == null || !this.mIsVideoPrepared || this.mIsVideoCompleted) {
                return;
            }
            this.mIsCallPlay = true;
            LogcatUtil.d("YdSDK-S2SVideoView", "playVideo");
            CommReportHelper.getInstance().reportVideoStart(this.mAdInfoPoJo, this.mediaPlayer.getDuration());
            int i = this.currentTime;
            if (i > 0) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mediaPlayer.seekTo(i, 3);
                } else {
                    this.mediaPlayer.seekTo(i);
                }
            }
            this.mediaPlayer.start();
            S2SVideoPlayListener s2SVideoPlayListener = this.mPlayListener;
            if (s2SVideoPlayListener != null) {
                s2SVideoPlayListener.onVideoPlayStart();
            }
            DeviceUtil.postUIDelayed(200L, new A4TApA(1, this));
            this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
            this.mDurationCountdownHandler.post(new Runnable() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.8
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    try {
                        if (S2SVideoView.this.mediaPlayer == null || S2SVideoView.this.mediaPlayer.getDuration() == 0) {
                            j = 0;
                        } else {
                            j = S2SVideoView.this.mediaPlayer.getDuration() - S2SVideoView.this.mediaPlayer.getCurrentPosition();
                            int currentPosition = (int) ((S2SVideoView.this.mediaPlayer.getCurrentPosition() / S2SVideoView.this.mediaPlayer.getDuration()) * 100.0d);
                            if (currentPosition >= 25 && !S2SVideoView.this.mIs25Preent) {
                                S2SVideoView.this.mIs25Preent = true;
                                CommReportHelper.getInstance().reportVideoFirst(S2SVideoView.this.mAdInfoPoJo);
                            }
                            if (currentPosition >= 50 && !S2SVideoView.this.mIs50Preent) {
                                S2SVideoView.this.mIs50Preent = true;
                                CommReportHelper.getInstance().reportVideomMidpoint(S2SVideoView.this.mAdInfoPoJo);
                            }
                            if (currentPosition >= 75 && !S2SVideoView.this.mIs75Preent) {
                                S2SVideoView.this.mIs75Preent = true;
                                CommReportHelper.getInstance().reportVideoThird(S2SVideoView.this.mAdInfoPoJo);
                            }
                        }
                        if (j > 0) {
                            S2SVideoView.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        } else {
                            S2SVideoView.this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
                        }
                    } catch (Throwable unused) {
                        if (S2SVideoView.this.mDurationCountdownHandler != null) {
                            S2SVideoView.this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
                        }
                    }
                }
            });
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener
    public void changeSoundEnable(boolean z) {
        setSoundEnable(z);
    }

    public long getProgress() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.getCurrentPosition();
        }
        return -1L;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener
    public boolean getSoundEnable() {
        return this.mIsSoundEnable;
    }

    public void onDestroy() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mIsVideoCompleted = true;
            this.mediaPlayer = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            changeSurfaceViewSize(true);
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener
    public void setSoundControlViewStateChangeListener(VideoSoundControlListener.SoundControlViewStateChangeListener soundControlViewStateChangeListener) {
        ImageView imageView = this.soundControlImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.viewStateChangeListener = soundControlViewStateChangeListener;
    }

    public void setSoundEnable(boolean z) {
        this.mIsSoundEnable = z;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (z) {
                mediaPlayer.setVolume(1.0f, 1.0f);
                ImageView imageView = this.soundControlImageView;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.yd_saas_volume_on);
                    return;
                }
                return;
            }
            mediaPlayer.setVolume(0.0f, 0.0f);
            ImageView imageView2 = this.soundControlImageView;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.yd_saas_volume_off);
            }
            CommReportHelper.getInstance().reportVideoMute(this.mAdInfoPoJo);
        } catch (Exception unused) {
        }
    }

    public void setVideo(final AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null || TextUtils.isEmpty(adInfoPoJo.video_url)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mIsSoundEnable = ConfigHelper.getInstance().getVideoSoundEnable(adInfoPoJo.place_id);
        this.mAdInfoPoJo = adInfoPoJo;
        setSurfaceHolder();
        ImageView imageView = new ImageView(this.mContext);
        this.soundControlImageView = imageView;
        imageView.setPadding(DeviceUtil.dip2px(5.0f), DeviceUtil.dip2px(5.0f), DeviceUtil.dip2px(5.0f), DeviceUtil.dip2px(5.0f));
        addView(this.soundControlImageView, new FrameLayout.LayoutParams(DeviceUtil.dip2px(30.0f), DeviceUtil.dip2px(30.0f)));
        this.soundControlImageView.setOnClickListener(new A2egSU(this, 0));
        if (this.mediaPlayer != null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessage(ErrorCodeConstant.PRICE_ERROR);
                return;
            }
            return;
        }
        createMediaView();
        if (this.firstFrameView == null) {
            ImageView imageView2 = new ImageView(this.mContext);
            this.firstFrameView = imageView2;
            imageView2.setBackgroundColor(d.f13043a);
            this.firstFrameView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(this.firstFrameView, layoutParams);
        }
        if (TextUtils.isEmpty(adInfoPoJo.img_url)) {
            ThreadPoolManager.getInstance().addTask(new BChYOn(this, 25, adInfoPoJo));
        } else {
            AdHttpUtils.getInstance().doGet(adInfoPoJo.img_url, new HttpCallbackBytesListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.1
                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onSuccess(byte[] bArr) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr));
                        if (S2SVideoView.this.firstFrameView != null) {
                            S2SVideoView.this.firstFrameView.setImageBitmap(decodeStream);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(ErrorCodeConstant.PRICE_ERROR, 500L);
        }
        String str = !TextUtils.isEmpty(adInfoPoJo.logo_icon) ? adInfoPoJo.logo_icon : "";
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(adInfoPoJo.img_url)) {
            str = adInfoPoJo.img_url;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AdHttpUtils.getInstance().doGet(str, new HttpCallbackBytesListener() { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.2
            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onError(Exception exc) {
            }

            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onSuccess(byte[] bArr) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    adInfoPoJo.READY_TIME = System.currentTimeMillis();
                    Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                    S2SVideoView s2SVideoView = S2SVideoView.this;
                    s2SVideoView.endFrameView = (RelativeLayout) LayoutInflater.from(s2SVideoView.mContext).inflate(R.layout.s2s_video_view_end_frame, (ViewGroup) null);
                    S2SVideoView.this.endFrameView.setVisibility(8);
                    S2SVideoView s2SVideoView2 = S2SVideoView.this;
                    s2SVideoView2.icon = (ImageView) s2SVideoView2.endFrameView.findViewById(R.id.s2s_video_view_finish_logo_imageview);
                    S2SVideoView s2SVideoView3 = S2SVideoView.this;
                    s2SVideoView3.tvTitle = (TextView) s2SVideoView3.endFrameView.findViewById(R.id.s2s_video_view_finish_title_textview);
                    S2SVideoView s2SVideoView4 = S2SVideoView.this;
                    s2SVideoView4.tvBtn = (TextView) s2SVideoView4.endFrameView.findViewById(R.id.s2s_video_view_finish_button);
                    S2SVideoView.this.icon.setImageBitmap(decodeStream);
                    S2SVideoView.this.icon.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (!TextUtils.isEmpty(adInfoPoJo.title)) {
                        S2SVideoView.this.tvTitle.setText(adInfoPoJo.title);
                    }
                    String str2 = adInfoPoJo.creative.button;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "查看详情";
                    }
                    S2SVideoView.this.tvBtn.setText(str2);
                } catch (Exception unused) {
                }
            }
        });
    }

    public void setVideoPlayListener(S2SVideoPlayListener s2SVideoPlayListener) {
        this.mPlayListener = s2SVideoPlayListener;
    }

    public S2SVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MSG_AD_VISIBLE_CHECK = ErrorCodeConstant.PRICE_ERROR;
        this.hasChangeSurfaceViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsSurfaceViewCreate = false;
        this.mIsFirstCreateSurfaceView = true;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.mDurationCountdownHandler = new Handler();
        this.isPlayError = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.9
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 11000) {
                    return;
                }
                if (S2SVideoView.this.checkViewVisible()) {
                    S2SVideoView s2SVideoView = S2SVideoView.this;
                    s2SVideoView.startVideo(s2SVideoView.mAdInfoPoJo.autoPlayCheckWifi());
                } else {
                    Handler handler = S2SVideoView.this.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(ErrorCodeConstant.PRICE_ERROR, 500L);
                    }
                }
            }
        };
        this.mContext = context;
        setBackgroundColor(d.f13043a);
    }

    public S2SVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MSG_AD_VISIBLE_CHECK = ErrorCodeConstant.PRICE_ERROR;
        this.hasChangeSurfaceViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsSurfaceViewCreate = false;
        this.mIsFirstCreateSurfaceView = true;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.mDurationCountdownHandler = new Handler();
        this.isPlayError = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.fl.saas.s2s.sdk.util.S2SVideoView.9
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 11000) {
                    return;
                }
                if (S2SVideoView.this.checkViewVisible()) {
                    S2SVideoView s2SVideoView = S2SVideoView.this;
                    s2SVideoView.startVideo(s2SVideoView.mAdInfoPoJo.autoPlayCheckWifi());
                } else {
                    Handler handler = S2SVideoView.this.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(ErrorCodeConstant.PRICE_ERROR, 500L);
                    }
                }
            }
        };
        this.mContext = context;
        setBackgroundColor(d.f13043a);
    }
}
