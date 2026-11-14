package com.ss.android.downloadlib.addownload.xj;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.c.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd extends Dialog {
    private String c;
    private String d;
    private String f;
    private w hf;
    private Activity kd;
    private boolean u;
    private boolean w;
    private u xj;
    private String y;

    public static class xj {
        private u c;
        private w f;
        private String hf;
        private String kd;
        private String u;
        private String w;
        private Activity xj;
        private boolean y;

        public xj(Activity activity) {
            this.xj = activity;
        }

        public xj hf(String str) {
            this.w = str;
            return this;
        }

        public xj u(String str) {
            this.kd = str;
            return this;
        }

        public xj w(String str) {
            this.u = str;
            return this;
        }

        public xj xj(String str) {
            this.hf = str;
            return this;
        }

        public xj xj(boolean z) {
            this.y = z;
            return this;
        }

        public xj xj(u uVar) {
            this.c = uVar;
            return this;
        }

        public xj xj(w wVar) {
            this.f = wVar;
            return this;
        }

        public kd xj() {
            return new kd(this.xj, this.hf, this.w, this.u, this.kd, this.y, this.c, this.f);
        }
    }

    public kd(Activity activity, String str, String str2, String str3, String str4, boolean z, u uVar, w wVar) {
        super(activity);
        this.kd = activity;
        this.xj = uVar;
        this.y = str;
        this.c = str2;
        this.f = str3;
        this.d = str4;
        this.hf = wVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        xj(this.kd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.u = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.kd.isFinishing()) {
            this.kd.finish();
        }
        if (this.w) {
            this.xj.xj();
        } else if (this.u) {
            this.hf.delete();
        } else {
            this.xj.hf();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        dismiss();
    }

    private void xj(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(xj(context, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(xj(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int xj2 = xj(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(xj2, xj2, xj2, xj2);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.y)) {
            textView.setText(this.y);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = xj(context, 26);
        layoutParams4.bottomMargin = xj2;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(xj(context, 70), xj(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.d)) {
            textView2.setText(this.d);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.xj.kd.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    kd.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = xj(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(xj(context, 70), xj(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.f)) {
            textView3.setText(this.f);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.xj.kd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.this.hf();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(xj(context, 70), xj(context, 33));
        layoutParams6.leftMargin = xj(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.c)) {
            textView4.setText(this.c);
        }
        textView4.setBackground(xj(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.xj.kd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.this.xj();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    private static GradientDrawable xj(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(xj(context, i));
        return gradientDrawable;
    }

    private static int xj(Context context, int i) {
        return g.xj(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        this.w = true;
        dismiss();
    }
}
