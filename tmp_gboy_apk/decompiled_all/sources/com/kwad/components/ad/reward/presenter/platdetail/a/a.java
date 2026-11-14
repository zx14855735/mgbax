package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ca;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, ca.a {
    private static final String[] yF = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private ca bQ;
    private TextView jU;
    private boolean jW;
    private long jX;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private TextView yB;
    private ImageView yC;
    private View yD;
    private boolean yE = false;
    private boolean yG = false;
    private boolean yH = false;
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.jW) {
                return;
            }
            a.this.bQ.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            long a2 = g.a(j, a.this.mAdInfo);
            a.this.jX = j2;
            a.this.a(a2, j2);
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.yB.setText(a.yF[2]);
        }
    };

    static {
        WuvKHXP();
    }

    private void G(int i) {
        this.tq.ss = i;
        if (!g.P(this.mAdTemplate)) {
            this.jU.setText(String.valueOf(i));
        } else {
            if (this.yG) {
                return;
            }
            this.yB.setText(String.format(yF[0], Integer.valueOf(i)));
        }
    }

    private static /* synthetic */ void WuvKHXP() {
        char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 188);
        }
        String str = new String(charArray);
        char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 188);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void dn() {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.mAdTemplate);
        this.mAdInfo = er;
        this.mApkDownloadHelper = this.tq.mApkDownloadHelper;
        long a2 = g.a(com.kwad.sdk.core.response.b.a.N(er), this.mAdInfo) / 1000;
        if (g.P(this.mAdTemplate)) {
            this.yD.setVisibility(0);
            this.yD.setOnClickListener(this);
            this.yB.setText(String.format(yF[0], Long.valueOf(a2)));
            this.jU.setVisibility(8);
        } else {
            this.yD.setVisibility(8);
            this.jU.setText(String.valueOf(a2));
            this.jU.setVisibility(0);
            this.jU.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.gl().a(this.mRewardVerifyListener);
        this.tq.rH.a(this.jE);
    }

    private void jw() {
        if (this.yE) {
            return;
        }
        this.yE = true;
        this.yC.setAlpha(0.0f);
        this.yC.setVisibility(0);
        this.yC.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.jU.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.jU.setAlpha(1.0f - floatValue);
                a.this.yC.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void jx() {
        com.kwad.components.ad.reward.e.d dVar = this.tq.mAdRewardStepListener;
        if (dVar != null) {
            dVar.gq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.tq.mRootContainer.getTouchCoords()).dv(41), this.tq.mReportExtData);
        this.tq.rG.cV();
    }

    private void notifyRewardVerify() {
        this.tq.rG.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.bQ = new ca(this);
        dn();
        if (this.tq.rH.lh()) {
            G((int) (com.kwad.sdk.core.response.b.a.ah(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.yC || view == this.yD) {
            com.kwad.components.core.e.d.a.a(new a.C0291a(view.getContext()).aE(this.mAdTemplate).b(this.mApkDownloadHelper).aD(2).A(this.tq.rH.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jU = (TextView) findViewById(R.id.ksad_video_count_down);
        this.yC = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.yB = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.yD = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gl().b(this.mRewardVerifyListener);
        this.tq.rH.b(this.jE);
        this.yC.setVisibility(8);
        this.yD.setVisibility(8);
        this.yE = false;
        this.yG = false;
        this.jW = false;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.yG = true;
        return true;
    }

    public final void a(long j, long j2) {
        int aL;
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo) && com.kwad.components.core.q.a.ua().ub() == 0) {
            aL = com.kwad.sdk.core.response.b.a.aN(this.mAdInfo);
        } else {
            aL = com.kwad.sdk.core.response.b.a.aL(this.mAdInfo);
        }
        g gVar = this.tq;
        long j3 = aL * (gVar.rZ ? 1000 : 0);
        com.kwad.components.ad.reward.m.b(gVar, j2, j, j3);
        if (!this.yH) {
            this.yH = k.a(this.tq, j2, j, j3);
        }
        a(j2, j, j3);
    }

    private void a(long j, long j2, long j3) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (j < (j2 - 800) - j3) {
            int floor = (int) Math.floor((j2 - j) / 1000.0f);
            int i = floor > 0 ? floor : 1;
            G(i);
            p pVar = this.tq.si;
            if (pVar != null) {
                pVar.aj(i);
                return;
            }
            return;
        }
        this.tq.sc = true;
        if (g.P(this.mAdTemplate)) {
            if (g.N(this.mAdTemplate) && (aVar2 = this.tq.sq) != null) {
                if (!aVar2.kW()) {
                    this.tq.sq.kV();
                }
            } else if (g.O(this.mAdTemplate) && (aVar = this.tq.sr) != null && !aVar.kW()) {
                this.tq.sr.kV();
            }
            if (this.yG) {
                return;
            }
            this.yB.setText(yF[1]);
            jx();
            return;
        }
        notifyRewardVerify();
        jw();
        p pVar2 = this.tq.si;
        if (pVar2 != null) {
            pVar2.aj(0);
        }
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.tq.gW() && !this.tq.gV()) {
                this.jX += 500;
                a(com.kwad.sdk.core.response.b.a.ah(this.mAdInfo), this.jX);
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
