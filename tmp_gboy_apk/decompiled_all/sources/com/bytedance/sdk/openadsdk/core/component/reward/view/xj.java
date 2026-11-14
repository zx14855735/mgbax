package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    TextView c;
    private ws d;
    private final TTBaseVideoActivity f;
    TTRoundRectImageView hf;
    TextView kd;
    private boolean p;
    private int tf;
    TTRatingBar u;
    TextView w;
    LinearLayout xj;
    TextView y;

    public xj(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f = tTBaseVideoActivity;
    }

    private void kd() {
        this.xj = (LinearLayout) this.f.findViewById(2114387739);
        this.hf = (TTRoundRectImageView) this.f.findViewById(2114387773);
        this.w = (TextView) this.f.findViewById(2114387645);
        this.u = (TTRatingBar) this.f.findViewById(2114387779);
        this.kd = (TextView) this.f.findViewById(2114387782);
        this.y = (TextView) this.f.findViewById(2114387864);
        this.c = (TextView) this.f.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.u;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.u.setStarFillNum(4);
            this.u.setStarImageWidth(r.w(this.f, 16.0f));
            this.u.setStarImageHeight(r.w(this.f, 16.0f));
            this.u.setStarImagePadding(r.w(this.f, 4.0f));
            this.u.xj();
        }
    }

    private void y() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.tf == 1 && (tTRoundRectImageView = this.hf) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, r.w(this.f, 50.0f), 0, 0);
            this.hf.setLayoutParams(layoutParams);
        }
    }

    public void hf() {
        String valueOf;
        if (this.hf != null) {
            z uf = this.d.uf();
            if (uf == null || TextUtils.isEmpty(uf.xj())) {
                jk.xj((Context) this.f, "tt_ad_logo_small", (ImageView) this.hf);
            } else {
                com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(this.hf);
            }
        }
        if (this.w != null) {
            if (this.d.vh() == null || TextUtils.isEmpty(this.d.vh().w())) {
                this.w.setText(this.d.kr());
            } else {
                this.w.setText(this.d.vh().w());
            }
        }
        if (this.kd != null) {
            int y = this.d.vh() != null ? this.d.vh().y() : 6870;
            String xj = jk.xj(this.f, "tt_comment_num_backup");
            if (y > 10000) {
                valueOf = (y / 10000) + "万";
            } else {
                valueOf = String.valueOf(y);
            }
            this.kd.setText(String.format(xj, valueOf));
        }
        TextView textView = this.c;
        if (textView != null) {
            r.xj(textView, this.d);
        }
    }

    public String u() {
        ws wsVar = this.d;
        return wsVar == null ? "立即下载" : TextUtils.isEmpty(wsVar.bh()) ? this.d.vw() != 4 ? "查看详情" : "立即下载" : this.d.bh();
    }

    public void w() {
        r.xj((View) this.xj, 8);
    }

    public void xj(ws wsVar) {
        if (this.p) {
            return;
        }
        this.p = true;
        this.d = wsVar;
        this.tf = wsVar.rs();
        kd();
        hf();
        xj(u());
        y();
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        r.xj(this.xj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.xj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.y;
        if (textView != null) {
            textView.setOnClickListener(hfVar);
            this.y.setOnTouchListener(hfVar);
        }
    }

    public void xj() {
        r.xj((View) this.xj, 0);
        ws wsVar = this.d;
        if (wsVar == null || wsVar.yq() == 100.0f) {
            return;
        }
        r.xj((View) this.u, 8);
        r.xj((View) this.kd, 8);
    }

    public void xj(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.y) == null) {
            return;
        }
        textView.setText(str);
    }
}
