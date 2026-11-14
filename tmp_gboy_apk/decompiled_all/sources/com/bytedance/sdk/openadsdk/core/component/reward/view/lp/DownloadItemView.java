package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.f.hf;
import com.bytedance.sdk.openadsdk.res.kd;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void xj(ws wsVar) {
        String valueOf;
        if (wsVar == null) {
            return;
        }
        Context context = getContext();
        addView(kd.ff(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(r.w(context, 12.0f));
            tTRatingBar.setStarImageHeight(r.w(context, 12.0f));
            tTRatingBar.setStarImagePadding(r.w(context, 4.0f));
            tTRatingBar.xj();
        }
        if (textView4 != null) {
            int y = wsVar.vh() != null ? wsVar.vh().y() : 6870;
            String xj = jk.xj(context, "tt_comment_num");
            if (y > 10000) {
                valueOf = (y / 10000) + "万";
            } else {
                valueOf = String.valueOf(y);
            }
            textView4.setText(String.format(xj, valueOf));
        }
        if (tTRoundRectImageView != null) {
            z uf = wsVar.uf();
            if (uf == null || TextUtils.isEmpty(uf.xj())) {
                jk.xj(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            } else {
                hf.xj(uf).to(tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(wo.e(wsVar));
        }
        if (textView2 != null) {
            textView2.setText(wo.yo(wsVar));
        }
        if (textView3 != null) {
            textView3.setText(TextUtils.isEmpty(wsVar.bh()) ? wsVar.vw() != 4 ? "查看详情" : "立即下载" : wsVar.bh());
        }
    }
}
