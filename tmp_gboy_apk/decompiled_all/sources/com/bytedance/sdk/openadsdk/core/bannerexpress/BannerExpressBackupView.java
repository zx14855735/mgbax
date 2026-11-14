package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.zg;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.res.kd;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BannerExpressBackupView extends BackupView {
    private static zg[] g = {new zg(1, 6.4f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 100), new zg(3, 1.2f, 600, 500)};
    private View am;
    private int e;
    private TextView jk;
    private ImageView pz;
    private NativeExpressView qt;
    private TextView v;
    private zg yo;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w zg;

    static {
        iXVcet();
    }

    public BannerExpressBackupView(Context context) {
        super(context);
        this.e = 1;
        this.xj = context;
    }

    private void hf() {
        float w = (this.c * 1.0f) / r.w(this.xj, 50.0f);
        float f = this.c * 1.0f;
        int i = this.y;
        if (f / i > 0.21875f) {
            w = (i * 1.0f) / r.w(this.xj, 320.0f);
        }
        View tj = kd.tj(this.xj);
        this.am = tj;
        addView(tj);
        this.pz = (ImageView) this.am.findViewById(2114387854);
        ImageView imageView = (ImageView) this.am.findViewById(2114387931);
        this.v = (TextView) this.am.findViewById(2114387940);
        TextView textView = (TextView) this.am.findViewById(2114387794);
        TTRatingBar tTRatingBar = (TTRatingBar) this.am.findViewById(2114387891);
        TextView textView2 = (TextView) this.am.findViewById(2114387633);
        this.v.setTextSize(2, r.hf(this.xj, r6.getTextSize()) * w);
        textView.setTextSize(2, r.hf(this.xj, textView.getTextSize()) * w);
        textView2.setTextSize(2, r.hf(this.xj, textView2.getTextSize()) * w);
        TextView textView3 = (TextView) this.am.findViewById(2114387658);
        this.pz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.kd();
            }
        });
        r.xj(textView3, this.hf, 27, 11);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.uf()).to(imageView);
        this.v.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (r.w(this.xj, 45.0f) * w);
            layoutParams.height = (int) (r.w(this.xj, 45.0f) * w);
        }
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView2.setText(this.hf.bh());
        }
        int kd = this.hf.vh() != null ? this.hf.vh().kd() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(kd)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(kd);
        tTRatingBar.setStarImageWidth(r.w(this.xj, 15.0f) * w);
        tTRatingBar.setStarImageHeight(r.w(this.xj, 14.0f) * w);
        tTRatingBar.setStarImagePadding(r.w(this.xj, 4.0f));
        tTRatingBar.xj();
        xj((View) this, true);
        xj((View) textView2, true);
    }

    private static /* synthetic */ void iXVcet() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void u() {
        int i = this.yo.xj;
        if (i == 2 || i == 3) {
            TextView textView = this.v;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.jk;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.v;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.pz != null) {
            jk.xj(getContext(), "tt_dislike_icon_night", this.pz);
        }
    }

    private void w(int i) {
        if (i == 1) {
            u();
            this.am.setBackgroundColor(0);
        } else {
            w();
            this.am.setBackgroundColor(-1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.xj
    public void b_(int i) {
        super.b_(i);
        w(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void xj(View view, int i, ra raVar) {
        if (this.qt != null) {
            if (i == 1 || i == 2) {
                View findViewById = this.am.findViewById(2114387854);
                if (i == 1) {
                    this.qt.getClickListener().hf(findViewById);
                } else {
                    this.qt.getClickCreativeListener().hf(findViewById);
                }
            }
            this.qt.xj(view, i, raVar);
        }
    }

    private void w() {
        int i = this.yo.xj;
        if (i != 2 && i != 3) {
            TextView textView = this.v;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FF333333"));
            }
            if (this.pz != null) {
                jk.xj(getContext(), "tt_dislike_icon", this.pz);
                return;
            }
            return;
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        }
        TextView textView3 = this.jk;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#3E3E3E"));
        }
        if (this.pz != null) {
            this.pz.setImageDrawable(kd.yy(this.xj));
        }
    }

    public void xj(ws wsVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.pl.hf.w wVar) {
        setBackgroundColor(-1);
        this.hf = wsVar;
        this.qt = nativeExpressView;
        this.zg = wVar;
        this.kd = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        int d = wo.d(this.hf);
        this.f = d;
        hf(d);
        xj();
        w(f.zg().wn());
    }

    private void xj() {
        this.yo = xj(this.qt.getExpectExpressWidth(), this.qt.getExpectExpressHeight());
        if (this.qt.getExpectExpressWidth() > 0 && this.qt.getExpectExpressHeight() > 0) {
            this.y = r.w(this.xj, this.qt.getExpectExpressWidth());
            this.c = r.w(this.xj, this.qt.getExpectExpressHeight());
        } else {
            int u = r.u(this.xj);
            this.y = u;
            this.c = Float.valueOf(u / this.yo.w).intValue();
        }
        int i = this.y;
        if (i > 0 && i > r.u(this.xj)) {
            this.y = r.u(this.xj);
            this.c = Float.valueOf(this.c * (r.u(this.xj) / this.y)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.y, this.c);
        }
        layoutParams.width = this.y;
        layoutParams.height = this.c;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        zg zgVar = this.yo;
        int i2 = zgVar.xj;
        if (i2 != 1 && i2 == 3) {
            xj(zgVar);
        } else {
            hf();
        }
    }

    private void xj(ImageView imageView) {
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.hf)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.hf), com.bytedance.sdk.openadsdk.kd.xj.tf(this.hf));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.bytedance.sdk.openadsdk.kd.xj.xj(imageView, upieImageView);
        }
    }

    private void xj(zg zgVar) {
        float w = (this.c * 1.0f) / r.w(this.xj, 250.0f);
        View n = kd.n(this.xj);
        this.am = n;
        addView(n);
        FrameLayout frameLayout = (FrameLayout) this.am.findViewById(2114387772);
        this.pz = (ImageView) this.am.findViewById(2114387854);
        ImageView imageView = (ImageView) this.am.findViewById(2114387936);
        ImageView imageView2 = (ImageView) this.am.findViewById(2114387931);
        this.v = (TextView) this.am.findViewById(2114387940);
        this.jk = (TextView) this.am.findViewById(2114387920);
        TextView textView = (TextView) this.am.findViewById(2114387927);
        TextView textView2 = (TextView) this.am.findViewById(2114387633);
        r.xj((TextView) this.am.findViewById(2114387658), this.hf);
        LinearLayout linearLayout = (LinearLayout) this.am.findViewById(2114387871);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (r.w(this.xj, 45.0f) * w);
            layoutParams.height = (int) (r.w(this.xj, 45.0f) * w);
        }
        this.v.setTextSize(2, r.hf(this.xj, r8.getTextSize()) * w);
        this.jk.setTextSize(2, r.hf(this.xj, r8.getTextSize()) * w);
        textView.setTextSize(2, r.hf(this.xj, textView.getTextSize()) * w);
        textView2.setTextSize(2, r.hf(this.xj, textView2.getTextSize()) * w);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f = w - 1.0f;
            if (f > 0.0f) {
                layoutParams2.topMargin = r.w(this.xj, f * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (r.w(this.xj, 16.0f) * w), 0, 0);
        } catch (Throwable unused) {
        }
        this.pz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.kd();
            }
        });
        int w2 = r.w(this.xj, 15.0f);
        r.xj(this.pz, w2, w2, w2, w2);
        if (h.am(this.hf) != null) {
            View xj = xj(this.qt);
            if (xj != null) {
                int i = (this.y * 406) / 600;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, (i * 9) / 16);
                int i2 = zgVar.hf;
                if (i2 == 1) {
                    int i3 = (this.y * 406) / 600;
                    layoutParams3 = new FrameLayout.LayoutParams(i3, (i3 * 9) / 16);
                } else if (i2 == 2) {
                    layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                } else if (i2 == 3) {
                    int i4 = (this.c * MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                    layoutParams3 = new FrameLayout.LayoutParams((i4 * 16) / 9, i4);
                } else if (i2 == 4) {
                    int i5 = (this.y * 480) / 690;
                    layoutParams3 = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
                }
                layoutParams3.gravity = 17;
                frameLayout.addView(xj, 0, layoutParams3);
                r.xj((View) imageView, 8);
            } else {
                xj(imageView);
                r.xj((View) imageView, 0);
            }
        } else {
            xj(imageView);
            r.xj((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.uf()).to(imageView2);
        textView.setText(getNameOrSource());
        TextView textView3 = this.v;
        Locale.getDefault();
        textView3.setText(getNameOrSource() + "提供的广告");
        this.jk.setText(getDescription());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView2.setText(this.hf.bh());
        }
        xj((View) this, true);
        xj((View) textView2, true);
        xj(frameLayout);
    }

    private zg xj(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 300.0d) / 600.0d) ? g[1] : g[0];
        } catch (Throwable unused) {
            return g[0];
        }
    }
}
