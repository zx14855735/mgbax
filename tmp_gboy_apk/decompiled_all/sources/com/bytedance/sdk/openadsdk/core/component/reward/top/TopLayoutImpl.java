package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TopLayoutImpl extends FrameLayout implements xj<TopLayoutImpl> {
    private View am;
    private View c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private ImageView hf;
    private ws ht;
    private boolean jk;
    private TextView kd;
    private TextView p;

    /* renamed from: pl, reason: collision with root package name */
    private View f10318pl;
    private hf pz;
    private View qt;
    private View tf;
    private View u;
    private TextView v;
    private View w;
    private View xj;
    private View y;
    private View yo;
    private TextView zg;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public View getCloseButton() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public boolean getSkipOrCloseVisible() {
        return r.u(this.tf) || (this.y != null && r.u(this.p) && !TextUtils.isEmpty(this.p.getText()));
    }

    public hf getTopListener() {
        return this.pz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setDislikeLeft(boolean z) {
        if (this.xj.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xj.getLayoutParams();
            layoutParams.gravity = z ? 8388611 : 8388613;
            this.xj.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setListener(hf hfVar) {
        this.pz = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setPlayAgainEntranceText(String str) {
        r.xj(this.kd, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowAgain(boolean z) {
        r.xj(this.u, z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowBack(boolean z) {
        View view = this.w;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowDislike(boolean z) {
        View view = this.xj;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setShowSound(boolean z) {
        ImageView imageView = this.hf;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setSoundMute(boolean z) {
        this.jk = z;
        jk.xj(getContext(), this.jk ? "tt_mute" : "tt_unmute", this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void u() {
        r.xj(this.xj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.w(view);
                }
            }
        }, "top_dislike_button");
        r.xj(this.hf, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl.this.jk = !r0.jk;
                jk.xj(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.jk ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.hf);
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.hf(view);
                }
            }
        }, "top_mute_button");
        r.xj(this.c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        r.xj(this.tf, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.pz);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!x.xj(TopLayoutImpl.this.ht) || com.bytedance.sdk.openadsdk.core.zg.u.xj(String.valueOf(wo.d(TopLayoutImpl.this.ht)))) {
                    am.xj().xj(TopLayoutImpl.this.ht, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.xj(view);
                }
            }
        }, "top_skip_button");
        r.xj(this.w, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.u(view);
                }
            }
        }, "top_back_button");
        r.xj(this.u, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.kd(view);
                }
            }
        }, "top_again_button");
        r.xj(this.y, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.y(view);
                }
            }
        }, "top_skip_border");
        r.xj(this.yo, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.pz != null) {
                    TopLayoutImpl.this.pz.c(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void hf() {
        ImageView imageView = this.hf;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void w() {
        View view = this.xj;
        if (view != null) {
            view.performClick();
        }
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TopLayoutImpl xj(ws wsVar) {
        this.ht = wsVar;
        if (v.p(wsVar)) {
            addView(com.bytedance.sdk.openadsdk.res.kd.f(getContext()));
        } else if (vm.f(this.ht)) {
            addView(com.bytedance.sdk.openadsdk.res.kd.c(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.kd.y(getContext()));
        }
        this.xj = findViewById(2114387845);
        this.hf = (ImageView) findViewById(2114387758);
        this.w = findViewById(2114387819);
        this.u = findViewById(2114387673);
        this.kd = (TextView) findViewById(2114387632);
        this.y = findViewById(2114387713);
        this.c = findViewById(2114387951);
        this.f = findViewById(2114387725);
        this.d = (TextView) findViewById(2114387606);
        this.tf = findViewById(2114387635);
        this.p = (TextView) findViewById(2114387785);
        this.f10318pl = findViewById(2114387738);
        this.g = findViewById(2114387924);
        this.am = findViewById(2114387950);
        this.qt = findViewById(2114387949);
        this.zg = (TextView) findViewById(2114387948);
        this.e = findViewById(2114387947);
        this.yo = findViewById(2114387946);
        this.v = (TextView) findViewById(2114387945);
        View view = this.tf;
        if (view != null) {
            view.setEnabled(false);
            this.tf.setClickable(false);
        }
        u();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj(boolean z, String str, String str2, boolean z2, boolean z3) {
        r.xj(this.y, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        r.xj(this.y, (z4 || z5) ? 0 : 4);
        r.xj(this.c, z4 ? 0 : 8);
        r.xj(this.tf, z5 ? 0 : 8);
        r.xj(this.g, z6 ? 0 : 8);
        r.xj(this.f, z ? 0 : 8);
        r.xj((View) this.d, !TextUtils.isEmpty(str) ? 0 : 8);
        r.xj(this.f10318pl, z2 ? 0 : 8);
        r.xj((View) this.p, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            r.xj(this.d, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            r.xj(this.p, str2);
        }
        View view = this.tf;
        if (view != null) {
            view.setEnabled(z3);
            this.tf.setClickable(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj(String str, String str2, boolean z) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        boolean z2 = (isEmpty || isEmpty2) ? false : true;
        r.xj(this.am, (isEmpty && isEmpty2) ? 4 : 0);
        r.xj(this.qt, !isEmpty ? 0 : 8);
        r.xj(this.yo, !isEmpty2 ? 0 : 8);
        r.xj(this.e, z2 ? 0 : 8);
        r.xj((View) this.zg, !TextUtils.isEmpty(str) ? 0 : 8);
        r.xj((View) this.v, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            r.xj(this.zg, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            r.xj(this.v, str2);
        }
        View view = this.tf;
        if (view != null) {
            view.setEnabled(z);
            this.tf.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xj
    public void xj() {
        View view = this.tf;
        if (view != null) {
            view.performClick();
        }
    }
}
