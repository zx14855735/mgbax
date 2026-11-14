package com.fl.saas.base.inner.reward;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdInnerRewardVideoActivity extends Activity implements View.OnClickListener {
    private static InnerRewardVideoListener rewardVideoListener;
    private boolean canClickReward;
    private int curPosition;
    private int getRewardTime;
    private boolean hasReward;
    private AdSource mAdSource;
    private ImageView mCloseImageView;
    private TextView mDurationCountdownTextView;
    private NativeAd mNativeAd;
    private LinearLayout mRewardTipsView;
    private RelativeLayout mSelfRender;
    private TextView mSkipTextView;
    private NativeAdView nativeAdView;
    private YdCommonDialog skipDialog;
    private TextView tv_has_reward;
    private Handler mDurationCountdownHandler = new Handler();
    private boolean mIsResume = false;

    public static /* synthetic */ int access$412(YdInnerRewardVideoActivity ydInnerRewardVideoActivity, int i) {
        int i2 = ydInnerRewardVideoActivity.curPosition + i;
        ydInnerRewardVideoActivity.curPosition = i2;
        return i2;
    }

    private void checkReward() {
        InnerRewardVideoListener innerRewardVideoListener;
        if (this.hasReward || (innerRewardVideoListener = rewardVideoListener) == null) {
            return;
        }
        this.hasReward = true;
        innerRewardVideoListener.onReward();
        this.tv_has_reward.setVisibility(0);
        TextView textView = this.mDurationCountdownTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void hideActionStatusBar() {
        if (Build.VERSION.SDK_INT > 23) {
            requestWindowFeature(1);
            if (getActionBar() != null) {
                getActionBar().hide();
            }
            getWindow().setFlags(1024, 1024);
        }
    }

    private void initData() {
        String str;
        try {
            InnerRewardVideoListener innerRewardVideoListener = rewardVideoListener;
            if (innerRewardVideoListener != null) {
                this.mAdSource = innerRewardVideoListener.getRewardVideoAdSource();
                NativeAd rewardVideoNativeAd = rewardVideoListener.getRewardVideoNativeAd();
                this.mNativeAd = rewardVideoNativeAd;
                if (this.mAdSource != null && rewardVideoNativeAd != null) {
                    rewardVideoNativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity.1
                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdClicked(NativeAdView nativeAdView) {
                            YdInnerRewardVideoActivity.this.jump();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdClose(NativeAdView nativeAdView) {
                            if (YdInnerRewardVideoActivity.rewardVideoListener != null) {
                                YdInnerRewardVideoActivity.rewardVideoListener.onClose();
                            }
                            YdInnerRewardVideoActivity.this.finish();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                            if (YdInnerRewardVideoActivity.rewardVideoListener != null) {
                                YdInnerRewardVideoActivity.rewardVideoListener.onError(ydError);
                            }
                            YdInnerRewardVideoActivity.this.finish();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdImpressed(NativeAdView nativeAdView) {
                            if (YdInnerRewardVideoActivity.rewardVideoListener != null) {
                                YdInnerRewardVideoActivity.rewardVideoListener.onShow();
                            }
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoEnd(NativeAdView nativeAdView) {
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                        }

                        @Override // com.fl.saas.api.mixNative.NativeEventListener
                        public void onAdVideoStart(NativeAdView nativeAdView) {
                        }
                    });
                    this.getRewardTime = this.mAdSource.rd_countdown * 1000;
                    ImageView imageView = (ImageView) findViewById(R.id.iv_yd_reward_video_adinfo_logo);
                    TextView textView = (TextView) findViewById(R.id.tv_yd_reward_video_adinfo_title);
                    TextView textView2 = (TextView) findViewById(R.id.tv_yd_reward_video_adinfo_desc);
                    TextView textView3 = (TextView) findViewById(R.id.tv_yd_reward_video_adinfo_button);
                    ImageView imageView2 = (ImageView) findViewById(R.id.iv_yd_reward_video_adinfo_source);
                    FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_media);
                    ImageView imageView3 = (ImageView) findViewById(R.id.iv_media);
                    if (this.mNativeAd.getAdMaterial() != null && !this.mNativeAd.isNativeExpress()) {
                        this.mNativeAd.renderAdContainer(this.nativeAdView, this.mSelfRender);
                        NativeMaterial adMaterial = this.mNativeAd.getAdMaterial();
                        textView.setText(adMaterial.getTitle());
                        textView2.setText(adMaterial.getDescription());
                        String callToAction = adMaterial.getCallToAction();
                        if (TextUtils.isEmpty(callToAction)) {
                            callToAction = "查看详情";
                        }
                        textView3.setText(callToAction);
                        if (TextUtils.isEmpty(adMaterial.getIconUrl())) {
                            imageView.setVisibility(8);
                        } else {
                            ImageLoader.loadImage(adMaterial.getIconUrl(), imageView);
                        }
                        if (adMaterial.getAdMediaView() != null) {
                            imageView3.setVisibility(8);
                            frameLayout.setVisibility(0);
                            View adMediaView = adMaterial.getAdMediaView();
                            ViewHelper.removeParent(adMediaView);
                            frameLayout.addView(adMediaView, new FrameLayout.LayoutParams(-1, -1));
                        } else {
                            frameLayout.setVisibility(8);
                            imageView3.setVisibility(0);
                            if (TextUtils.isEmpty(adMaterial.getMainImageUrl())) {
                                str = (String) Check.findFirstNonNull(adMaterial.getImageUrlList());
                                if (!TextUtils.isEmpty(str)) {
                                }
                            } else {
                                str = adMaterial.getMainImageUrl();
                            }
                            ImageLoader.loadImage(str, imageView3);
                        }
                        if (adMaterial.getAdLogoBitmap() != null) {
                            imageView2.setImageBitmap(adMaterial.getAdLogoBitmap());
                        } else if (!TextUtils.isEmpty(adMaterial.getAdLogoUrl())) {
                            ImageLoader.loadImage(adMaterial.getAdLogoUrl(), imageView2);
                        }
                        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                        nativePrepareInfo.setActivity(this);
                        nativePrepareInfo.setCtaView(textView3);
                        nativePrepareInfo.setClickView(imageView, textView, textView2, this.mRewardTipsView);
                        this.mNativeAd.prepare(nativePrepareInfo);
                        startDurationCountdown();
                        return;
                    }
                    InnerRewardVideoListener innerRewardVideoListener2 = rewardVideoListener;
                    if (innerRewardVideoListener2 != null) {
                        innerRewardVideoListener2.onError(new YdError(ErrorCodeConstant.METHOD_ERROR, "广告类型配置错误，应该配置自渲染类型"));
                    }
                }
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
            finish();
        }
    }

    private void initViews() {
        try {
            this.tv_has_reward = (TextView) findViewById(R.id.tv_has_reward);
            this.nativeAdView = (NativeAdView) findViewById(R.id.na_root);
            this.mSelfRender = (RelativeLayout) findViewById(R.id.rl_self_render);
            this.mRewardTipsView = (LinearLayout) findViewById(R.id.ll_yd__reward_video_tips);
            this.mCloseImageView = (ImageView) findViewById(R.id.iv_yd__reward_video_close);
            this.mSkipTextView = (TextView) findViewById(R.id.tv_yd_reward_video_skip);
            this.mDurationCountdownTextView = (TextView) findViewById(R.id.tv_yd__reward_video_duration_countdown);
            this.mSkipTextView.setOnClickListener(this);
            this.mCloseImageView.setOnClickListener(this);
            this.mRewardTipsView.setOnClickListener(this);
            this.mRewardTipsView.setVisibility(8);
            this.mCloseImageView.setVisibility(8);
            this.mSkipTextView.setVisibility(8);
        } catch (Throwable th) {
            th.printStackTrace();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jump() {
        InnerRewardVideoListener innerRewardVideoListener = rewardVideoListener;
        if (innerRewardVideoListener != null) {
            innerRewardVideoListener.onClick();
            if (this.canClickReward) {
                checkReward();
            }
            LinearLayout linearLayout = this.mRewardTipsView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$0() {
        InnerRewardVideoListener innerRewardVideoListener = rewardVideoListener;
        if (innerRewardVideoListener != null) {
            innerRewardVideoListener.onClose();
        }
        finish();
    }

    private void pauseDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playEnd() {
        try {
            YdCommonDialog ydCommonDialog = this.skipDialog;
            if (ydCommonDialog != null && ydCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.mCloseImageView.setVisibility(0);
            this.mSkipTextView.setVisibility(8);
            this.mRewardTipsView.setVisibility(8);
            InnerRewardVideoListener innerRewardVideoListener = rewardVideoListener;
            if (innerRewardVideoListener != null) {
                innerRewardVideoListener.onVideoComplete();
            }
            checkReward();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationCountdown(long j) {
        StringBuilder sb;
        String str;
        if (j < 0) {
            j = 0;
        }
        TextView textView = this.mDurationCountdownTextView;
        if (textView != null) {
            if (this.hasReward) {
                sb = new StringBuilder();
                sb.append(j / 1000);
                str = "";
            } else {
                sb = new StringBuilder();
                sb.append(j / 1000);
                str = "秒后获取奖励";
            }
            sb.append(str);
            textView.setText(sb.toString());
            this.mDurationCountdownTextView.setVisibility(0);
        }
    }

    public static void setRewardVideoListener(InnerRewardVideoListener innerRewardVideoListener) {
        rewardVideoListener = innerRewardVideoListener;
    }

    private void startDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mDurationCountdownHandler.post(new Runnable() { // from class: com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!YdInnerRewardVideoActivity.this.mIsResume) {
                        YdInnerRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        return;
                    }
                    YdInnerRewardVideoActivity.access$412(YdInnerRewardVideoActivity.this, 1000);
                    if (!YdInnerRewardVideoActivity.this.canClickReward && YdInnerRewardVideoActivity.this.mAdSource.rd_type == 0 && YdInnerRewardVideoActivity.this.mAdSource.rd_click_time >= 0 && YdInnerRewardVideoActivity.this.curPosition > YdInnerRewardVideoActivity.this.mAdSource.rd_click_time * 1000) {
                        YdInnerRewardVideoActivity.this.canClickReward = true;
                        if (YdInnerRewardVideoActivity.this.mRewardTipsView != null) {
                            YdInnerRewardVideoActivity.this.mRewardTipsView.setVisibility(0);
                        }
                    }
                    long j = YdInnerRewardVideoActivity.this.getRewardTime - YdInnerRewardVideoActivity.this.curPosition;
                    YdInnerRewardVideoActivity.this.setDurationCountdown(j);
                    if (YdInnerRewardVideoActivity.this.mAdSource != null && YdInnerRewardVideoActivity.this.mAdSource.rd_skip_time >= 0 && YdInnerRewardVideoActivity.this.curPosition >= YdInnerRewardVideoActivity.this.mAdSource.rd_skip_time * 1000) {
                        YdInnerRewardVideoActivity.this.mSkipTextView.setVisibility(0);
                    }
                    if (j > 0) {
                        YdInnerRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        return;
                    }
                    YdInnerRewardVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                    YdInnerRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                    YdInnerRewardVideoActivity.this.mSkipTextView.setVisibility(8);
                    YdInnerRewardVideoActivity.this.mRewardTipsView.setVisibility(8);
                    YdInnerRewardVideoActivity.this.playEnd();
                }
            });
        }
    }

    public void hideBottomStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility(4102);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:
    
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        r3.onClose();
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r3 = r3.getId()
            int r0 = com.fl.saas.s2s.R.id.iv_yd__reward_video_close
            if (r3 != r0) goto Ld
            com.fl.saas.base.inner.reward.InnerRewardVideoListener r3 = com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity.rewardVideoListener
            if (r3 == 0) goto L1c
            goto L19
        Ld:
            int r0 = com.fl.saas.s2s.R.id.tv_yd_reward_video_skip
            if (r3 != r0) goto L46
            boolean r3 = r2.hasReward
            if (r3 == 0) goto L20
            com.fl.saas.base.inner.reward.InnerRewardVideoListener r3 = com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity.rewardVideoListener
            if (r3 == 0) goto L1c
        L19:
            r3.onClose()
        L1c:
            r2.finish()
            return
        L20:
            com.fl.saas.base.widget.YdCommonDialog r3 = r2.skipDialog
            if (r3 != 0) goto L41
            com.fl.saas.base.widget.YdCommonDialog r3 = new com.fl.saas.base.widget.YdCommonDialog
            r3.<init>(r2)
            java.lang.String r0 = "此时跳过将不会获得奖励，确认跳过吗？"
            com.fl.saas.base.widget.YdCommonDialog r3 = r3.setContent(r0)
            r0 = 0
            com.fl.saas.base.widget.YdCommonDialog r3 = r3.setCanDismiss(r0)
            Cd8JRx.ADYaiT r0 = new Cd8JRx.ADYaiT
            r1 = 13
            r0.<init>(r1, r2)
            com.fl.saas.base.widget.YdCommonDialog r3 = r3.setOnSubmitListener(r0)
            r2.skipDialog = r3
        L41:
            com.fl.saas.base.widget.YdCommonDialog r3 = r2.skipDialog
            r3.show()
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.inner.reward.YdInnerRewardVideoActivity.onClick(android.view.View):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            if (getIntent().getIntExtra("draw_type", 0) == 0) {
                setRequestedOrientation(7);
            } else {
                setRequestedOrientation(6);
            }
            hideActionStatusBar();
            hideBottomStatusBar();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        super.onCreate(bundle);
        setContentView(R.layout.yd_activity_reward_video);
        initViews();
        initData();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YdCommonDialog ydCommonDialog = this.skipDialog;
        if (ydCommonDialog != null) {
            if (ydCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.skipDialog = null;
        }
        pauseDurationCountdown();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsResume = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsResume = true;
    }
}
