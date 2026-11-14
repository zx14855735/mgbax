package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f13239a;
    private Window b;
    private int c;
    private int d;
    private int e;
    private int f;
    private String g;
    private String h;
    private ImageView i;

    public a(Context context, String str, String str2) {
        super(context, com.sigmob.sdk.base.k.e());
        this.f13239a = context.getApplicationContext();
        this.g = str;
        this.h = str2;
        this.i = b();
        this.d = this.f13239a.getResources().getDisplayMetrics().widthPixels;
        this.c = Dips.dipsToIntPixels(120.0f, context);
    }

    private ImageView b() {
        ImageView imageView = new ImageView(this.f13239a);
        this.i = imageView;
        imageView.setImageBitmap(s.CLOSE.a());
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.setImageAlpha(127);
        this.i.setClickable(true);
        this.i.setOnClickListener(this);
        return this.i;
    }

    private TextView c() {
        TextView textView = new TextView(getContext());
        textView.setText("复制广告信息");
        textView.setTextColor(-16776961);
        textView.setOnClickListener(new A2egSU(this, 0));
        return textView;
    }

    private View d() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels / 4, 0, 0);
        TextView textView = new TextView(getContext());
        textView.setText("appid: " + WindAds.sharedAds().getAppId());
        textView.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        textView.setTextSize(12.0f);
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setText("p_id: " + this.h);
        textView2.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        textView2.setTextSize(12.0f);
        linearLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(getContext());
        String str = "req_id: " + this.g;
        textView3.setTextSize(12.0f);
        textView3.setText(str);
        textView3.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        linearLayout.addView(textView3, layoutParams);
        return linearLayout;
    }

    private void e() {
        Window window = getWindow();
        this.b = window;
        if (window == null) {
            return;
        }
        window.setGravity(80);
        int g = com.sigmob.sdk.base.k.g();
        if (g != 0) {
            this.b.setWindowAnimations(g);
        }
        this.b.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = this.b.getAttributes();
        attributes.width = this.d;
        attributes.height = this.c;
        this.b.setAttributes(attributes);
    }

    public void a() {
        ImageView imageView = this.i;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.r.a(imageView);
            this.i = null;
        }
        if (this.f13239a != null) {
            this.f13239a = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        float dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f13239a);
        gradientDrawable.setCornerRadii(new float[]{dipsToIntPixels, dipsToIntPixels, dipsToIntPixels, dipsToIntPixels, 0.0f, 0.0f, 0.0f, 0.0f});
        int dipsToIntPixels2 = Dips.dipsToIntPixels(10.0f, this.f13239a);
        relativeLayout.setPadding(dipsToIntPixels2, dipsToIntPixels2, dipsToIntPixels2, dipsToIntPixels2);
        relativeLayout.setBackground(gradientDrawable);
        setContentView(relativeLayout);
        setOnShowListener(this);
        setOnDismissListener(this);
        SigmobLog.i("AdInfoDialog onCreate:" + this.d + ":" + this.c);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(18.0f, this.f13239a);
        if (this.i != null) {
            RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels3, dipsToIntPixels3, 10, 11);
            BTvldC2.setMargins(0, dipsToIntPixels3 / 4, dipsToIntPixels3 / 2, 0);
            relativeLayout.addView(this.i, BTvldC2);
        }
        TextView c = c();
        c.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels3);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, dipsToIntPixels3 / 4, dipsToIntPixels3 / 2, 0);
        relativeLayout.addView(c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, c.getId());
        layoutParams2.addRule(9);
        relativeLayout.addView(d(), layoutParams2);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        e();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("AdInfoDialog  onDismiss");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("AdInfoDialog  onShow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String str = "appid:" + WindAds.sharedAds().getAppId();
        String str2 = "p_id:" + this.h;
        String str3 = "req_id:" + this.g;
        Context context = view.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",");
        sb.append(str2);
        sb.append(",");
        sb.append(str3);
        com.sigmob.sdk.base.common.ak.a(view.getContext(), a(context, sb.toString()) ? "广告信息复制完成" : "广告信息复制失败，请检查权限", 0).show();
    }

    private boolean a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
