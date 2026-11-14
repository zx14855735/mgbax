package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements xj<RewardBrowserMixTopLayoutImpl> {
    private View hf;
    private Context kd;
    private ws u;
    private hf w;
    private View xj;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    private void u() {
        r.xj(this.xj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.w);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                am.xj().xj(RewardBrowserMixTopLayoutImpl.this.u, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.w != null) {
                    RewardBrowserMixTopLayoutImpl.this.w.xj(view);
                }
            }
        }, "top_skip_border");
        r.xj(this.hf, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.w != null) {
                    RewardBrowserMixTopLayoutImpl.this.w.w(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public View getCloseButton() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public boolean getSkipOrCloseVisible() {
        return r.u(this.xj);
    }

    public hf getTopListener() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void hf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setListener(hf hfVar) {
        this.w = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowAgain(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowBack(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowDislike(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowSound(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setSoundMute(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void w() {
        View view = this.hf;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj(String str, String str2, boolean z) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kd = context;
    }

    public RewardBrowserMixTopLayoutImpl xj(ws wsVar) {
        this.u = wsVar;
        addView(com.bytedance.sdk.openadsdk.res.kd.f(getContext()));
        this.xj = findViewById(2114387869);
        View findViewById = findViewById(2114387453);
        this.hf = findViewById(2114387454);
        if (v.g(wsVar)) {
            this.xj = findViewById(2114387869);
            this.hf.setVisibility(8);
            findViewById.setVisibility(8);
            jk.xj(this.kd, "tt_ad_skip_btn_bg", this.xj);
        } else if (v.am(wsVar)) {
            findViewById(2114387738).setVisibility(8);
            this.xj = findViewById(2114387869);
        } else {
            this.xj = findViewById(2114387713);
            this.hf.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if (this.xj != null) {
            if (wsVar.g()) {
                this.xj.setVisibility(8);
            } else {
                this.xj.setVisibility(0);
                this.xj.setEnabled(true);
                this.xj.setClickable(true);
            }
        }
        u();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj() {
        View view = this.xj;
        if (view != null) {
            view.performClick();
        }
    }
}
