package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca;

import ADYaiT.CtFAbx;
import Dphsd2.AlLFFp;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import io.dcloud.base.R;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaaa;
import io.dcloud.openapi.activity.WebViewActivity;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa {
    private final Activity aaaaaaa0;
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0 aaaaaaaa;
    private Runnable aaaaaaae;
    private CountDownTimer aaaaaaao;
    private TextView aaaaaaeo;
    private FrameLayout aaaeaaaa;
    private long aaaaaaac = PushUIConfig.dismissTime;
    private boolean aaaaaaau = false;
    private boolean aaaaaaav = false;
    private final Handler aaaaaaan = new Handler();

    public class aaaaaaa0 extends ClickableSpan {
        final /* synthetic */ AOLLoader.AppInfo aaaaaaaa;

        public aaaaaaa0(AOLLoader.AppInfo appInfo) {
            this.aaaaaaaa = appInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent(aaaaaaaa.this.aaaaaaa0, (Class<?>) WebViewActivity.class);
            intent.putExtra("url", this.aaaaaaaa.getPermissionInfoUrl());
            aaaaaaaa.this.aaaaaaa0.startActivity(intent);
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0523aaaaaaaa extends ClickableSpan {
        final /* synthetic */ AOLLoader.AppInfo aaaaaaaa;

        public C0523aaaaaaaa(AOLLoader.AppInfo appInfo) {
            this.aaaaaaaa = appInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent(aaaaaaaa.this.aaaaaaa0, (Class<?>) WebViewActivity.class);
            intent.putExtra("url", this.aaaaaaaa.getPrivacyUrl());
            aaaaaaaa.this.aaaaaaa0.startActivity(intent);
        }
    }

    public class aaaaaaac implements View.OnClickListener {
        final /* synthetic */ FrameLayout aaaaaaaa;

        public aaaaaaac(FrameLayout frameLayout) {
            this.aaaaaaaa = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aaaaaaaa.this.aaaaaaau) {
                return;
            }
            if (aaaaaaaa.this.aaaaaaae != null) {
                aaaaaaaa.this.aaaaaaan.removeCallbacks(aaaaaaaa.this.aaaaaaae);
                aaaaaaaa.this.aaaaaaav = false;
            }
            if (this.aaaaaaaa.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aaaaaaaa.getParent()).removeView(this.aaaaaaaa);
            }
            aaaaaaaa.this.aaaaaaaa.onClosed("");
        }
    }

    public class aaaaaaae implements Runnable {
        final /* synthetic */ FrameLayout aaaaaaaa;

        public aaaaaaae(FrameLayout frameLayout) {
            this.aaaaaaaa = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout frameLayout = this.aaaaaaaa;
            if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.aaaaaaaa.getParent()).removeView(this.aaaaaaaa);
            }
            aaaaaaaa.this.aaaaaaav = false;
            aaaaaaaa.this.aaaaaaaa.onClosed("");
        }
    }

    public class aaaaaaan extends ArrayList {
        final /* synthetic */ View aaaaaaaa;

        public aaaaaaan(View view) {
            this.aaaaaaaa = view;
            add(view);
        }
    }

    public class aaaaaaao extends ClickableSpan {
        final /* synthetic */ AOLLoader.AppInfo aaaaaaaa;

        public aaaaaaao(AOLLoader.AppInfo appInfo) {
            this.aaaaaaaa = appInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent(aaaaaaaa.this.aaaaaaa0, (Class<?>) WebViewActivity.class);
            intent.putExtra("url", this.aaaaaaaa.getFunctionDescUrl());
            aaaaaaaa.this.aaaaaaa0.startActivity(intent);
        }
    }

    public class aaaaaaau implements AOLLoader.VideoAdListener {
        final /* synthetic */ FrameLayout aaaaaaa0;
        final /* synthetic */ TextView aaaaaaaa;

        public aaaaaaau(TextView textView, FrameLayout frameLayout) {
            this.aaaaaaaa = textView;
            this.aaaaaaa0 = frameLayout;
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoAdComplete() {
            if (aaaaaaaa.this.aaaaaaao != null) {
                aaaaaaaa.this.aaaaaaao.cancel();
                aaaaaaaa.this.aaaaaaao = null;
            }
            aaaaaaaa.this.aaaaaaau = false;
            aaaaaaaa.this.aaaaaaac = 0L;
            if (aaaaaaaa.this.aaaaaaav) {
                return;
            }
            aaaaaaaa.this.aaaaaaao(this.aaaaaaaa, this.aaaaaaa0);
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoAdPaused() {
            aaaaaaaa.this.aaaaaaaa();
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoAdResume() {
            aaaaaaaa.this.aaaaaaa0();
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoAdStartPlay() {
            aaaaaaaa.this.aaaaaaao();
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoError(int i, String str) {
            if (aaaaaaaa.this.aaaaaaao != null) {
                aaaaaaaa.this.aaaaaaao.cancel();
                aaaaaaaa.this.aaaaaaao = null;
            }
            aaaaaaaa.this.aaaaaaau = false;
            aaaaaaaa.this.aaaaaaao(this.aaaaaaaa, this.aaaaaaa0);
        }

        @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VideoAdListener
        public void onVideoLoad() {
            aaaaaaaa.this.aaaaaaa0(this.aaaaaaaa, this.aaaaaaa0);
        }
    }

    public class aaaaaaav extends CountDownTimer {
        final /* synthetic */ FrameLayout aaaaaaa0;
        final /* synthetic */ TextView aaaaaaaa;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaav(long j, long j2, TextView textView, FrameLayout frameLayout) {
            super(j, j2);
            this.aaaaaaaa = textView;
            this.aaaaaaa0 = frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void aaaaaaaa(TextView textView, int i) {
            if (textView != null) {
                textView.setText(i + "s");
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            aaaaaaaa.this.aaaaaaau = false;
            aaaaaaaa.this.aaaaaaac = 0L;
            if (aaaaaaaa.this.aaaaaaav) {
                return;
            }
            aaaaaaaa.this.aaaaaaao(this.aaaaaaaa, this.aaaaaaa0);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            aaaaaaaa.this.aaaaaaac = j;
            final int max = Math.max(0, Math.round(j / 1000.0f));
            Activity activity = aaaaaaaa.this.aaaaaaa0;
            final TextView textView = this.aaaaaaaa;
            activity.runOnUiThread(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.A2egSU
                @Override // java.lang.Runnable
                public final void run() {
                    aaaaaaaa.aaaaaaav.aaaaaaaa(textView, max);
                }
            });
        }
    }

    public aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0 aaaaaaa0Var, Activity activity) {
        this.aaaaaaaa = aaaaaaa0Var;
        this.aaaaaaa0 = activity;
    }

    public View getFeedAOLView() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            if (aaaaaaa0Var.isExpressAd()) {
                return this.aaaaaaaa.getFeedAOLView(this.aaaaaaa0);
            }
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.aaaaaaa0).inflate(R.layout.dcloud_ad_custom_feed_ad, (ViewGroup) null);
            if (this.aaaaaaaa.getMaterialType() == 1) {
                long videoDuration = (long) (this.aaaaaaaa.getVideoDuration() * 1000.0d);
                this.aaaaaaac = videoDuration;
                ViewGroup viewGroup = (ViewGroup) frameLayout.findViewById(R.id.videoContainer);
                View videoView = this.aaaaaaaa.getVideoView(this.aaaaaaa0);
                if (videoView != null) {
                    viewGroup.addView(videoView, new ViewGroup.LayoutParams(-1, -1));
                    TextView textView = (TextView) frameLayout.findViewById(R.id.privacyInfo);
                    if (this.aaaaaaaa.getInteractionType() == 1) {
                        AOLLoader.AppInfo appInfo = this.aaaaaaaa.getAppInfo();
                        Locale locale = Locale.ENGLISH;
                        SpannableString spannableString = new SpannableString(CtFAbx.B25kr6(J3FDQU.A2egSU.BChYOn("应用名称：", appInfo.getAppName(), "|开发者：", appInfo.getDeveloperName(), "|应用版本："), appInfo.getAppVersion(), "|隐私协议|权限详情|简介"));
                        C0523aaaaaaaa c0523aaaaaaaa = new C0523aaaaaaaa(appInfo);
                        aaaaaaa0 aaaaaaa0Var2 = new aaaaaaa0(appInfo);
                        aaaaaaao aaaaaaaoVar = new aaaaaaao(appInfo);
                        spannableString.setSpan(c0523aaaaaaaa, spannableString.toString().indexOf("隐私协议"), spannableString.toString().indexOf("隐私协议") + 4, 33);
                        spannableString.setSpan(aaaaaaa0Var2, spannableString.toString().indexOf("权限详情"), spannableString.toString().indexOf("权限详情") + 4, 33);
                        spannableString.setSpan(aaaaaaaoVar, spannableString.toString().indexOf("简介"), spannableString.toString().indexOf("简介") + 2, 33);
                        textView.setText(spannableString);
                        textView.setVisibility(0);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                    } else {
                        textView.setVisibility(8);
                    }
                    TextView textView2 = (TextView) frameLayout.findViewById(R.id.skipView);
                    textView2.setText(Math.max(0, Math.round(videoDuration / 1000.0f)) + "s");
                    this.aaaaaaeo = textView2;
                    this.aaaeaaaa = frameLayout;
                    textView2.setOnClickListener(new aaaaaaac(frameLayout));
                    this.aaaaaaaa.setVideoAdListener(new aaaaaaau(textView2, frameLayout));
                    this.aaaaaaaa.registerViewForInteraction(this.aaaaaaa0, frameLayout, new aaaaaaan(videoView), null, null);
                    return frameLayout;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaao(TextView textView, FrameLayout frameLayout) {
        if (this.aaaaaaav) {
            return;
        }
        CountDownTimer countDownTimer = this.aaaaaaao;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.aaaaaaao = null;
        }
        this.aaaaaaau = false;
        this.aaaaaaac = 0L;
        this.aaaaaaa0.runOnUiThread(new AlLFFp(9, this, textView, frameLayout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaa0(TextView textView, FrameLayout frameLayout) {
        CountDownTimer countDownTimer = this.aaaaaaao;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.aaaaaaao = null;
        }
        if (this.aaaaaaac <= 0) {
            this.aaaaaaac = 1000L;
        }
        this.aaaaaaao = new aaaaaaav(this.aaaaaaac, 1000L, textView, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(TextView textView, FrameLayout frameLayout) {
        if (textView != null) {
            textView.setText("关闭");
        }
        Runnable runnable = this.aaaaaaae;
        if (runnable != null) {
            this.aaaaaaan.removeCallbacks(runnable);
        }
        this.aaaaaaae = new aaaaaaae(frameLayout);
        this.aaaaaaav = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaao() {
        CountDownTimer countDownTimer = this.aaaaaaao;
        if (countDownTimer == null || this.aaaaaaau) {
            return;
        }
        this.aaaaaaau = true;
        countDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaa0() {
        TextView textView;
        FrameLayout frameLayout;
        if (this.aaaaaaau || this.aaaaaaac <= 0 || (textView = this.aaaaaaeo) == null || (frameLayout = this.aaaeaaaa) == null) {
            return;
        }
        aaaaaaa0(textView, frameLayout);
        aaaaaaao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaaa() {
        CountDownTimer countDownTimer = this.aaaaaaao;
        if (countDownTimer == null || !this.aaaaaaau) {
            return;
        }
        countDownTimer.cancel();
        this.aaaaaaao = null;
        this.aaaaaaau = false;
    }
}
