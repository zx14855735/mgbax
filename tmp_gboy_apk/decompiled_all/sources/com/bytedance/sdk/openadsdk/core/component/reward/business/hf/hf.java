package com.bytedance.sdk.openadsdk.core.component.reward.business.hf;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am;
import com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.f;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.u;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements xj {
    private boolean f;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj hf;
    private final xj.InterfaceC0140xj xj;
    private int y;
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(false);
    private final AtomicBoolean kd = new AtomicBoolean(false);
    private int c = 0;
    private boolean d = true;
    private String tf = "";
    private String p = "";

    /* renamed from: pl, reason: collision with root package name */
    private String f10300pl = "";
    private String g = "";
    private String am = "";

    public hf(xj.InterfaceC0140xj interfaceC0140xj) {
        this.xj = interfaceC0140xj;
    }

    private void p() {
        c.hf(new d("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(5)).hf(n.hf(hf.this.xj.hf()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.w.set(true);
            String u = n.u(this.xj.xj());
            if (TextUtils.isEmpty(u)) {
                u = String.valueOf(this.y);
            }
            if (TextUtils.isEmpty(u)) {
                u = String.valueOf(wo.d(this.xj.xj()));
            }
            f.xj().xj(com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().xj(u), n.w(this.xj.xj()), this.c, new u(new com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.3
                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
                public void hf(qt qtVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
                public void xj() {
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
                public void xj(int i, String str) {
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hf.this.u("当前无新视频，请点击重试");
                            hf.this.w.set(false);
                            if (hf.this.hf != null) {
                                hf.this.hf.kd();
                            }
                            hf.this.xj.xj(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c
                public void xj(final qt qtVar) {
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            qt qtVar2 = qtVar;
                            if (qtVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.w) {
                                com.bytedance.sdk.openadsdk.core.component.reward.w wVar = (com.bytedance.sdk.openadsdk.core.component.reward.w) qtVar2;
                                wVar.xj(true);
                                wVar.xj(hf.this.y);
                                wVar.hf(hf.this.c + 1);
                                wVar.w(hf.this.xj.hf());
                                if (!TextUtils.isEmpty(hf.this.tf) && !TextUtils.isEmpty(hf.this.p)) {
                                    wVar.hf(hf.this.p);
                                    wVar.xj(hf.this.tf);
                                }
                                wVar.hf(hf.this.f);
                                wVar.xj(hf.this.xj.getActivity());
                                hf.this.xj.kd();
                                hf.this.u.set(true);
                            } else {
                                hf.this.u("当前无新视频，请点击重试");
                                hf.this.w.set(false);
                            }
                            hf.this.xj.xj(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.w.set(false);
            u("当前无新视频，请退出后重试");
        }
    }

    private boolean tf() {
        if (!n.hf(this.xj.xj())) {
            return false;
        }
        if (this.w.get()) {
            return true;
        }
        tf tfVar = new tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                if (hf.this.w.get()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.am.u.xj(hf.this.xj.xj(), "reward_endcard", "popup_cancel", (String) null);
                hf.this.xj.w();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                if (hf.this.w.get()) {
                    return;
                }
                if (hf.this.hf != null) {
                    hf.this.hf.u();
                }
                hf.this.d();
                com.bytedance.sdk.openadsdk.core.am.u.xj(hf.this.xj.xj(), "reward_endcard", "reward_again", "popup");
            }
        };
        com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.hf hfVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.hf(this.xj.getActivity(), this.xj.xj());
        this.hf = hfVar;
        hfVar.u(this.tf);
        this.hf.w(this.p);
        this.hf.xj(this.am);
        this.xj.u();
        return this.hf.xj(tfVar).w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public String c() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.kd.get());
            jSONObject.put("mSourceRitId", this.y);
            jSONObject.put("mNowPlayAgainCount", this.c);
            jSONObject.put("isCustomPlayAgain", this.f);
            jSONObject.put("isCanPlayAgain", this.d);
            jSONObject.put("mPlayAgainRewardName", this.tf);
            jSONObject.put("mPlayAgainRewardAmount", this.p);
            jSONObject.put("mLastRewardName", this.f10300pl);
            jSONObject.put("mLastRewardAmount", this.g);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void hf(boolean z) {
        this.f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public boolean kd() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj xjVar = this.hf;
        if (xjVar == null) {
            return false;
        }
        return xjVar.hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void u() {
        xj.InterfaceC0140xj interfaceC0140xj = this.xj;
        if (interfaceC0140xj == null || interfaceC0140xj.getActivity() == null || this.xj.xj() == null || !n.xj(this.xj.xj())) {
            return;
        }
        if (!this.f) {
            boolean z = this.c == 0;
            this.xj.xj(z, null, null);
            this.d = z;
        } else {
            this.d = false;
            this.xj.xj(false, this.tf, this.p);
            final int i = this.c + 1;
            c.hf(new d("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        am xj = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        hf.this.xj(xj.hf(n.hf(hf.this.xj.hf()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public boolean w(int i) {
        xj.InterfaceC0140xj interfaceC0140xj = this.xj;
        if (interfaceC0140xj == null || interfaceC0140xj.getActivity() == null || this.xj.xj() == null || this.w.get() || !this.d) {
            return false;
        }
        if (i == 1) {
            xj.InterfaceC0140xj interfaceC0140xj2 = this.xj;
            interfaceC0140xj2.xj(0, xj(interfaceC0140xj2.getActivity()));
            d();
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.xj.xj(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return tf();
            }
            if (i == 3) {
                xj.InterfaceC0140xj interfaceC0140xj3 = this.xj;
                interfaceC0140xj3.xj(0, xj(interfaceC0140xj3.getActivity()));
                d();
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.xj.xj(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public String y() {
        return this.f10300pl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void hf(int i) {
        this.y = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public boolean hf() {
        return this.u.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void xj(boolean z) {
        this.kd.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void hf(String str) {
        this.g = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void xj(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public boolean xj() {
        return this.kd.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void xj(String str) {
        this.f10300pl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Bundle bundle) {
        boolean z = bundle.getBoolean(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_ALLOW);
        this.tf = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_NAME);
        this.p = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_AMOUNT);
        this.am = bundle.getString("extra_info");
        this.d = z;
        if (z) {
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.2
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.xj.xj(true, hf.this.tf, hf.this.p);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str) {
        xj.InterfaceC0140xj interfaceC0140xj = this.xj;
        if (interfaceC0140xj == null || interfaceC0140xj.getActivity() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.hf.hf.5
            @Override // java.lang.Runnable
            public void run() {
                x.xj(hf.this.xj.getActivity(), str, 0);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void w() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.w();
        }
        p();
    }

    private TTProgressBar xj(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(A2egSU.A4TApA("#77000000", gradientDrawable, context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int w = r.w(context, 10.0f);
        tTProgressBar.setPadding(w, w, w, w);
        tTProgressBar.setIndeterminateDrawable(jk.w(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj
    public void w(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.kd.set(jSONObject.getBoolean("isPlayAgain"));
            this.y = jSONObject.optInt("mSourceRitId");
            this.c = jSONObject.optInt("mNowPlayAgainCount");
            this.f = jSONObject.optBoolean("isCustomPlayAgain");
            this.d = jSONObject.optBoolean("isCanPlayAgain");
            this.tf = jSONObject.optString("mPlayAgainRewardName");
            this.p = jSONObject.optString("mPlayAgainRewardAmount");
            this.f10300pl = jSONObject.optString("mLastRewardName");
            this.p = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }
}
