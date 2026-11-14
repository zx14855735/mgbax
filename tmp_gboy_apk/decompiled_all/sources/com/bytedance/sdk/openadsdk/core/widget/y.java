package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends Dialog {
    private String am;
    private Button c;
    private Button d;
    private int e;
    private Button f;
    private String g;
    public xj hf;
    private View jk;
    private TextView kd;
    private ViewGroup p;

    /* renamed from: pl, reason: collision with root package name */
    private Context f10464pl;
    private String qt;
    private View tf;
    private ImageView u;
    private boolean v;
    public View.OnClickListener w;
    TTProgressBar xj;
    private TextView y;
    private Drawable yo;
    private String zg;

    public interface xj {
        void hf();

        void xj();
    }

    public y(Context context) {
        super(context);
        this.e = -1;
        this.v = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f10464pl = context;
    }

    private void kd() {
        this.c = (Button) findViewById(2114387829);
        this.f = (Button) findViewById(2114387914);
        this.kd = (TextView) findViewById(2114387802);
        this.y = (TextView) findViewById(2114387857);
        this.u = (ImageView) findViewById(2114387832);
        this.tf = findViewById(2114387775);
        this.p = (ViewGroup) findViewById(2114387849);
        this.d = (Button) findViewById(2114387749);
    }

    private void u() {
        Button button;
        if (this.kd != null) {
            if (TextUtils.isEmpty(this.am)) {
                this.kd.setVisibility(8);
            } else {
                this.kd.setText(this.am);
                this.kd.setVisibility(0);
            }
        }
        if (this.y != null && !TextUtils.isEmpty(this.g)) {
            this.y.setText(this.g);
        }
        if (this.f != null) {
            if (TextUtils.isEmpty(this.qt)) {
                this.f.setText("确定");
            } else {
                this.f.setText(this.qt);
            }
            int i = this.e;
            if (i != -1) {
                this.f.setBackgroundColor(i);
            }
        }
        if (this.c != null) {
            if (TextUtils.isEmpty(this.zg)) {
                this.c.setText("取消");
            } else {
                this.c.setText(this.zg);
            }
        }
        ImageView imageView = this.u;
        if (imageView != null) {
            Drawable drawable = this.yo;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.u.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.tf;
        if (view == null || (button = this.c) == null) {
            return;
        }
        if (this.v) {
            view.setVisibility(8);
            this.c.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.tf;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void w() {
        r.xj(this.f, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.y.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj xjVar = y.this.hf;
                if (xjVar != null) {
                    xjVar.xj();
                }
            }
        }, "positiveBn");
        r.xj(this.c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.y.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj xjVar = y.this.hf;
                if (xjVar != null) {
                    xjVar.hf();
                }
            }
        }, "negtiveBn");
        r.xj(this.d, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.y.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = y.this.w;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    public y hf(String str) {
        this.am = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View view = this.jk;
        if (view == null) {
            view = com.bytedance.sdk.openadsdk.res.kd.bl(this.f10464pl);
        }
        setContentView(view);
        kd();
        u();
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            u();
        } catch (Exception unused) {
        }
    }

    public y xj(xj xjVar) {
        this.hf = xjVar;
        return this;
    }

    public void hf() {
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public y xj(View.OnClickListener onClickListener) {
        this.w = onClickListener;
        return this;
    }

    public y xj(String str) {
        this.g = str;
        return this;
    }

    public y w(String str) {
        this.qt = str;
        return this;
    }

    public y xj(int i) {
        this.e = i;
        return this;
    }

    public y xj(Drawable drawable) {
        this.yo = drawable;
        return this;
    }

    public y xj(View view) {
        this.jk = view;
        return this;
    }

    public void xj() {
        if (this.p == null) {
            return;
        }
        if (this.xj == null) {
            try {
                this.xj = new TTProgressBar(this.f10464pl);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                layoutParams.gravity = 17;
                this.xj.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(r.w(this.f10464pl, 2.0f));
                this.xj.setBackground(gradientDrawable);
                int w = r.w(this.f10464pl, 10.0f);
                this.xj.setPadding(w, w, w, w);
                this.xj.setIndeterminateDrawable(jk.w(this.f10464pl, "tt_video_loading_progress_bar"));
                this.p.addView(this.xj);
            } catch (Exception unused) {
            }
        }
        this.p.setVisibility(0);
    }

    public y u(String str) {
        this.zg = str;
        return this;
    }
}
