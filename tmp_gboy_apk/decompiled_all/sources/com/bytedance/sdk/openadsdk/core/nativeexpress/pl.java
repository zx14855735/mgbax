package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class pl extends BackupView {
    private static zg[] g = {new zg(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new zg(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new zg(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new zg(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new zg(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new zg(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private int am;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w e;
    private ImageView jk;
    private View qt;
    private TextView v;
    private TextView yo;
    private NativeExpressView zg;

    static {
        VLvDA();
    }

    public pl(Context context) {
        super(context);
        this.xj = context;
    }

    private static /* synthetic */ void VLvDA() {
        char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 134);
        }
        String str = new String(charArray);
        char[] charArray2 = "åêïèïò".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 134);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void c() {
        View s = com.bytedance.sdk.openadsdk.res.kd.s(this.xj);
        this.qt = s;
        addView(s);
        this.qt.findViewById(2114387734).setVisibility(0);
        this.qt.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.qt.findViewById(2114387965);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387913);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        TextView textView = (TextView) this.qt.findViewById(2114387855);
        TextView textView2 = (TextView) this.qt.findViewById(2114387856);
        TextView textView3 = (TextView) this.qt.findViewById(2114387633);
        TextView textView4 = (TextView) this.qt.findViewById(2114387908);
        TTRatingBar tTRatingBar = (TTRatingBar) this.qt.findViewById(2114387874);
        r.xj((TextView) this.qt.findViewById(2114387617), this.hf);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.uf()).to(imageView);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        int kd = this.hf.vh() != null ? this.hf.vh().kd() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(kd)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(kd);
        tTRatingBar.setStarImageWidth(r.w(this.xj, 15.0f));
        tTRatingBar.setStarImageHeight(r.w(this.xj, 14.0f));
        tTRatingBar.setStarImagePadding(r.w(this.xj, 4.0f));
        tTRatingBar.xj();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView3.setText(this.hf.bh());
        }
        View xj = xj(this.zg);
        if (xj != null) {
            int i = (this.y * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(xj, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        xj(this, false);
        xj(textView3, true);
    }

    private void d() {
        View dc = com.bytedance.sdk.openadsdk.res.kd.dc(this.xj);
        this.qt = dc;
        addView(dc);
        FrameLayout frameLayout = (FrameLayout) this.qt.findViewById(2114387734);
        frameLayout.setVisibility(0);
        this.qt.findViewById(2114387955).setVisibility(8);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        TextView textView = (TextView) this.qt.findViewById(2114387633);
        r.xj((TextView) this.qt.findViewById(2114387658), this.hf);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView.setText(this.hf.bh());
        }
        View xj = xj(this.zg);
        if (xj != null) {
            frameLayout.removeAllViews();
            int i = this.y;
            frameLayout.addView(xj, new ViewGroup.LayoutParams(i, (i * 9) / 16));
        }
        xj(this, false);
        xj(textView, true);
    }

    private void f() {
        View hl = com.bytedance.sdk.openadsdk.res.kd.hl(this.xj);
        this.qt = hl;
        addView(hl);
        FrameLayout frameLayout = (FrameLayout) this.qt.findViewById(2114387734);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387936);
        TextView textView = (TextView) this.qt.findViewById(2114387920);
        TextView textView2 = (TextView) this.qt.findViewById(2114387940);
        TextView textView3 = (TextView) this.qt.findViewById(2114387633);
        TextView textView4 = (TextView) this.qt.findViewById(2114387658);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        r.xj(textView4, this.hf);
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView3.setText(this.hf.bh());
        }
        if (ws.hf(this.hf)) {
            imageView.setVisibility(8);
        } else {
            xj(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        View xj = xj(this.zg);
        NativeExpressView nativeExpressView = this.zg;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (xj instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) xj;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (xj != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(xj, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.qt.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        }
        xj(textView2, false);
        xj(textView, false);
        xj(textView3, true);
    }

    private com.bytedance.sdk.openadsdk.core.hf.xj g() {
        Context context = this.xj;
        ws wsVar = this.hf;
        String str = this.kd;
        final com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(context, wsVar, str, wo.hf(str)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.8
            @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
                if (view == null) {
                    super.xj(view, tfVar);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
                super.xj(view, tfVar);
            }
        };
        w wVar = new w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
            public void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
                try {
                    raVar.xj().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).kd());
                } catch (JSONException unused) {
                }
                pl.this.xj(view, i, raVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj xjVar2 = (com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj.class);
        if (xjVar2 != null) {
            xjVar2.xj(wVar);
            xjVar2.xj(2);
        }
        return xjVar;
    }

    private void kd(int i) {
        if (i == 1) {
            hf();
            this.qt.setBackgroundColor(0);
            if (this.jk != null) {
                com.bytedance.sdk.component.utils.jk.xj(getContext(), "tt_dislike_icon_night", this.jk);
                return;
            }
            return;
        }
        xj();
        this.qt.setBackgroundColor(-1);
        if (this.jk != null) {
            com.bytedance.sdk.component.utils.jk.xj(getContext(), "tt_dislike_icon2", this.jk);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p() {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pl() {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.pl():void");
    }

    private void tf() {
        View s = com.bytedance.sdk.openadsdk.res.kd.s(this.xj);
        this.qt = s;
        addView(s);
        this.qt.findViewById(2114387734).setVisibility(8);
        this.qt.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387936);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        TextView textView = (TextView) this.qt.findViewById(2114387633);
        r.xj((TextView) this.qt.findViewById(2114387658), this.hf);
        xj(imageView);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView.setText(this.hf.bh());
        }
        xj(this, false);
        xj(textView, true);
    }

    private zg u(int i) {
        zg[] zgVarArr = g;
        zg zgVar = zgVarArr[0];
        try {
            for (zg zgVar2 : zgVarArr) {
                if (zgVar2.xj == i) {
                    return zgVar2;
                }
            }
        } catch (Throwable unused) {
        }
        return zgVar;
    }

    private void w(int i) {
        zg u = u(this.hf.rx());
        this.y = r.w(this.xj, this.zg.getExpectExpressWidth());
        this.c = r.w(this.xj, this.zg.getExpectExpressHeight());
        if (this.y <= 0) {
            this.y = r.u(this.xj);
        }
        if (this.c <= 0) {
            this.c = Float.valueOf(this.y / u.w).intValue();
        }
        int i2 = this.y;
        if (i2 > 0 && i2 > r.u(this.xj)) {
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
        if (i == 9) {
            this.kd = "draw_ad";
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.hf)) {
                p();
                return;
            } else {
                f();
                return;
            }
        }
        this.kd = "embeded_ad";
        int rx = this.hf.rx();
        if (rx == 2) {
            w();
            return;
        }
        if (rx == 3) {
            y();
            return;
        }
        if (rx == 4) {
            u();
            return;
        }
        if (rx == 5) {
            d();
            return;
        }
        if (rx == 15) {
            c();
            return;
        }
        if (rx == 16) {
            tf();
            return;
        }
        if (rx == 131) {
            tf();
        } else if (rx != 166) {
            tf();
        } else {
            pl();
        }
    }

    private void y() {
        View dc = com.bytedance.sdk.openadsdk.res.kd.dc(this.xj);
        this.qt = dc;
        addView(dc);
        this.qt.findViewById(2114387734).setVisibility(8);
        this.qt.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387936);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        TextView textView = (TextView) this.qt.findViewById(2114387633);
        r.xj((TextView) this.qt.findViewById(2114387658), this.hf);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.c);
        xj(imageView);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView.setText(this.hf.bh());
        }
        xj(this, false);
        xj(textView, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.xj
    public void b_(int i) {
        super.b_(i);
        kd(i);
    }

    public void hf() {
        TextView textView = this.yo;
        if (textView == null || this.v == null) {
            return;
        }
        textView.setTextColor(-1);
        this.v.setTextColor(-1);
    }

    public void xj(ws wsVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.pl.hf.w wVar) {
        setBackgroundColor(-1);
        this.hf = wsVar;
        this.zg = nativeExpressView;
        this.e = wVar;
        int d = wo.d(wsVar);
        this.am = d;
        hf(d);
        int f = wo.f(this.hf);
        w(f);
        kd(com.bytedance.sdk.openadsdk.core.f.zg().wn());
        int i = f != 9 ? -2 : -1;
        this.zg.addView(this, new ViewGroup.LayoutParams(i, i));
    }

    private void u() {
        View aq = com.bytedance.sdk.openadsdk.res.kd.aq(this.xj);
        this.qt = aq;
        addView(aq);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387695);
        ImageView imageView2 = (ImageView) this.qt.findViewById(2114387692);
        ImageView imageView3 = (ImageView) this.qt.findViewById(2114387690);
        ImageView imageView4 = (ImageView) this.qt.findViewById(2114387931);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        TextView textView = (TextView) this.qt.findViewById(2114387633);
        r.xj((TextView) this.qt.findViewById(2114387658), this.hf);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(0)).to(imageView);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(1)).to(imageView2);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(2)).to(imageView3);
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.uf()).to(imageView4);
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        if (!TextUtils.isEmpty(this.hf.bh())) {
            textView.setText(this.hf.bh());
        }
        xj(this, false);
        xj(textView, true);
    }

    private void xj(ImageView imageView) {
        com.bytedance.sdk.openadsdk.f.hf.xj(this.hf.lx().get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.hf)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.hf), com.bytedance.sdk.openadsdk.kd.xj.tf(this.hf));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.kd.xj.xj(imageView, upieImageView);
        }
    }

    private void xj(View view, TextView textView, ws wsVar) {
        if (view == null || textView == null) {
            return;
        }
        if (wsVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(wsVar.nn())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            r.xj(view, wsVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            r.xj(textView, wsVar);
        }
    }

    private void xj(View view, com.bytedance.sdk.openadsdk.core.hf.hf hfVar, String str) {
        if (view == null || hfVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        NativeExpressView nativeExpressView = this.zg;
        if (nativeExpressView != null) {
            if (i == 1 && nativeExpressView.getClickListener() != null) {
                this.zg.getClickListener().hf(this.jk);
            }
            if (i == 2 && this.zg.getClickCreativeListener() != null) {
                this.zg.getClickCreativeListener().hf(this.jk);
            }
            this.zg.xj(view, i, raVar);
        }
    }

    private void w() {
        View eu = com.bytedance.sdk.openadsdk.res.kd.eu(this.xj);
        this.qt = eu;
        addView(eu);
        ImageView imageView = (ImageView) this.qt.findViewById(2114387936);
        this.jk = (ImageView) this.qt.findViewById(2114387854);
        this.v = (TextView) this.qt.findViewById(2114387920);
        this.yo = (TextView) this.qt.findViewById(2114387940);
        xj((LinearLayout) this.qt.findViewById(2114387660), (TextView) this.qt.findViewById(2114387658), this.hf);
        xj(imageView);
        this.v.setText(getDescription());
        this.yo.setText(getTitle());
        this.jk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pl.this.kd();
            }
        });
        xj(this, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public NativeVideoTsView xj(Context context, ws wsVar, String str, boolean z, boolean z2) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, wsVar, str, z, z2);
        }
        return new NativeVideoTsView(context, wsVar, str, z, z2);
    }

    public void xj() {
        if (this.yo == null || this.v == null) {
            return;
        }
        int rx = this.hf.rx();
        if (rx != 2) {
            if (rx != 3) {
                if (rx == 4) {
                    this.yo.setTextColor(Color.parseColor("#FF3E3E3E"));
                    this.v.setTextColor(Color.parseColor("#FF3E3E3E"));
                    return;
                } else if (rx != 5 && rx != 15 && rx != 16) {
                    return;
                }
            }
            this.yo.setTextColor(Color.parseColor("#FF222222"));
            this.v.setTextColor(Color.parseColor("#FF505050"));
            return;
        }
        this.yo.setTextColor(Color.parseColor("#FFBCBCBC"));
        this.v.setTextColor(Color.parseColor("#FF999999"));
    }
}
