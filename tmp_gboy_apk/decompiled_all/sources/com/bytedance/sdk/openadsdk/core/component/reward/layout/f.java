package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends hf {
    private RoundImageView am;
    private TextView dk;
    private TextView e;
    private boolean et;
    private RelativeLayout ht;
    private TextView jk;
    private RelativeLayout pz;
    private RelativeLayout qt;
    private TextView ra;
    private TextView v;
    private ImageView yo;
    private TextView zg;

    public f(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void u(int i) {
        if (this.et) {
            return;
        }
        r.xj((View) this.p, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void w(int i) {
        r.xj((View) this.pz, i);
        r.xj((View) this.ht, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        String valueOf;
        String valueOf2;
        super.xj();
        this.f = (RelativeLayout) this.hf.findViewById(2114387662);
        this.d = (FrameLayout) this.hf.findViewById(2114387754);
        this.tf = (TextView) this.hf.findViewById(2114387658);
        this.am = (RoundImageView) this.hf.findViewById(2114387882);
        this.qt = (RelativeLayout) this.hf.findViewById(2114387911);
        this.zg = (TextView) this.hf.findViewById(2114387921);
        this.e = (TextView) this.hf.findViewById(2114387850);
        this.yo = (ImageView) this.hf.findViewById(2114387881);
        this.v = (TextView) this.hf.findViewById(2114387781);
        this.jk = (TextView) this.hf.findViewById(2114387640);
        this.pz = (RelativeLayout) this.hf.findViewById(2114387663);
        this.ht = (RelativeLayout) this.hf.findViewById(2114387835);
        this.p = (RelativeLayout) this.hf.findViewById(2114387717);
        this.ra = (TextView) this.hf.findViewById(2114387752);
        this.dk = (TextView) this.hf.findViewById(2114387716);
        r.xj(this.tf, this.w);
        p();
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.w)) {
            String d = wo.d(this.w);
            if (TextUtils.isEmpty(d) || this.am == null) {
                r.xj((View) this.qt, 8);
            } else {
                r.xj((View) this.qt, 0);
                com.bytedance.sdk.openadsdk.f.hf.xj(d).to(this.am);
            }
            if (this.zg != null) {
                this.zg.setText(wo.w(this.w));
            }
            if (this.e != null) {
                int u = wo.u(this.w);
                if (u < 0) {
                    this.e.setVisibility(4);
                    r.xj((View) this.yo, 4);
                } else {
                    String xj = jk.xj(this.hf, "tt_live_fans_text");
                    if (u > 10000) {
                        valueOf2 = (u / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
                    } else {
                        valueOf2 = String.valueOf(u);
                    }
                    this.e.setText(String.format(xj, valueOf2));
                }
            }
            if (this.v != null) {
                int kd = wo.kd(this.w);
                if (kd < 0) {
                    this.v.setVisibility(4);
                    r.xj((View) this.yo, 4);
                } else {
                    String xj2 = jk.xj(this.hf, "tt_live_watch_text");
                    if (kd > 10000) {
                        valueOf = (kd / 10000.0f) + IAdInterListener.AdReqParam.WIDTH;
                    } else {
                        valueOf = String.valueOf(kd);
                    }
                    this.v.setText(String.format(xj2, valueOf));
                }
            }
            if (this.jk != null) {
                this.jk.setText(wo.y(this.w));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        r.xj((View) this.ra, (View.OnTouchListener) hfVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        r.xj((View) this.ra, (View.OnClickListener) hfVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        r.xj((View) this.dk, (View.OnClickListener) hfVar, "TTBaseVideoActivity#mLiveVideoBtn");
        r.xj((View) this.dk, (View.OnClickListener) hfVar, "TTBaseVideoActivity#mLiveVideoBtn");
        xj(hfVar2);
        xj((View.OnTouchListener) hfVar2);
    }

    private void xj(View.OnTouchListener onTouchListener) {
        r.xj(this.f, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        r.xj(this.d, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        r.xj(this.jk, onTouchListener, "TTBaseVideoActivity#mLiveDesc");
        r.xj(this.e, onTouchListener, "TTBaseVideoActivity#mLiveFans");
        r.xj(this.v, onTouchListener, "TTBaseVideoActivity#mLiveWatch");
        r.xj(this.zg, onTouchListener, "TTBaseVideoActivity#mLiveName");
        r.xj(this.am, onTouchListener, "TTBaseVideoActivity#mLiveIcon");
        r.xj(this.p, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        xj(this.d, hfVar, "click_live_feed");
        xj(this.jk, hfVar, "click_live_author_description");
        xj(this.e, hfVar, "click_live_author_follower_count");
        xj(this.v, hfVar, "click_live_author_following_count");
        xj(this.zg, hfVar, "click_live_author_nickname");
        xj(this.am, hfVar, "click_live_avata");
        xj(this.f, hfVar, "click_live_button");
        xj(this.p, hfVar, "click_live_btn_layout");
    }

    private void xj(View view, final com.bytedance.sdk.openadsdk.core.hf.hf hfVar, final String str) {
        if (view == null || hfVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.hf;
        ws wsVar = this.w;
        boolean z = this.y;
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.hf.hf(tTBaseVideoActivity, wsVar, z ? "rewarded_video" : "fullscreen_interstitial_ad", z ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.f.1
            @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view2, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
                hfVar.xj(view2, tfVar);
            }
        });
    }

    public void xj(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.et = true;
            r.xj((View) this.p, 8);
            return;
        }
        r.xj((View) this.p, 0);
        if (i2 >= 0 && com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(this.w) && dc.xj(this.w) && dc.kd(this.w) == 3 && (textView = (TextView) this.hf.findViewById(2114387716)) != null) {
            textView.setText(String.format(jk.xj(this.hf, "tt_reward_auto_jump_live"), i2 + "s"));
        }
    }
}
