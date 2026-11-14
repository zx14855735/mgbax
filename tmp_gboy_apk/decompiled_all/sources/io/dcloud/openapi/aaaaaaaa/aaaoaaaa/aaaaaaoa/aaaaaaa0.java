package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.dcloud.base.R;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa;
import java.io.IOException;
import java.util.Locale;
import pl.droidsonroids.gif.A5SV6n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends RelativeLayout implements View.OnClickListener {
    private ViewGroup aaaaaaa0;
    Drawable aaaaaaaa;
    private ImageView aaaaaaac;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaae;
    private aaaaaaaa.aaaaaaao aaaaaaan;
    private View aaaaaaao;
    private TextView aaaaaaau;
    private int aaaaaaav;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public class RunnableC0525aaaaaaa0 implements Runnable {
        final /* synthetic */ ViewGroup aaaaaaaa;

        public RunnableC0525aaaaaaa0(ViewGroup viewGroup) {
            this.aaaaaaaa = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaaa)) {
                if (aaaaaaa0.this.aaaaaaan != null) {
                    aaaaaaa0.this.aaaaaaan.aaaaaaaa(60010, "广告容器不可见");
                    return;
                }
                return;
            }
            aaaaaaa0 aaaaaaa0Var = aaaaaaa0.this;
            if (aaaaaaa0Var.aaaaaaaa == null) {
                if (aaaaaaa0Var.aaaaaaan != null) {
                    aaaaaaa0.this.aaaaaaan.aaaaaaaa(60004, "图片资源加载失败");
                    return;
                }
                return;
            }
            this.aaaaaaaa.removeAllViews();
            this.aaaaaaaa.getGlobalVisibleRect(new Rect());
            this.aaaaaaaa.getRootView().getGlobalVisibleRect(new Rect());
            this.aaaaaaaa.addView(aaaaaaa0.this, new ViewGroup.LayoutParams(-1, -1));
            aaaaaaa0.this.aaaaaaae.aaaaaaaa(new RectF(this.aaaaaaaa.getX(), this.aaaaaaaa.getY(), 0.0f, 0.0f));
            aaaaaaa0.this.aaaaaaac.setImageDrawable(aaaaaaa0.this.aaaaaaaa);
            if (aaaaaaa0.this.aaaaaaan != null) {
                aaaaaaa0.this.aaaaaaan.onAdShow();
            }
            aaaaaaa0.this.aaaaaaae.aaaaaaaa();
            aaaaaaav.aaaaaaaa().aaaaaaa0(aaaaaaa0.this.getContext(), aaaaaaa0.this.aaaaaaae.aaaaeaaa());
        }
    }

    public class aaaaaaaa implements Runnable {
        public aaaaaaaa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aaaaaaa0.this.aaaaaaan != null) {
                aaaaaaa0.this.aaaaaaan.aaaaaaae();
            }
        }
    }

    public aaaaaaa0(Context context, aaaaaaaa.aaaaaaao aaaaaaaoVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0 aaaaaaa0Var) {
        super(context);
        this.aaaaaaav = 5000;
        this.aaaaaaan = aaaaaaaoVar;
        this.aaaaaaae = aaaaaaa0Var;
        this.aaaaaaav = aaaaaaa0Var.aaaaaaeo();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.dcloud_ad_splash_container, (ViewGroup) null);
        this.aaaaaaa0 = viewGroup;
        this.aaaaaaao = viewGroup.findViewById(R.id.ad_dcloud_main_skip);
        this.aaaaaaac = (ImageView) this.aaaaaaa0.findViewById(R.id.ad_dcloud_main_img);
        this.aaaaaaau = (TextView) this.aaaaaaa0.findViewById(R.id.ad_dcloud_main_click);
        this.aaaaaaac.setOnClickListener(this);
        this.aaaaaaao.setOnClickListener(this);
        addView(this.aaaaaaa0, -1);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (aaaaaaa0Var.aaaaaaae() == null) {
            BitmapFactory.decodeFile(aaaaaaa0Var.aaaaaaan(), options);
            String str = options.outMimeType;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ENGLISH).contains("gif")) {
                this.aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaaa(BitmapFactory.decodeFile(aaaaaaa0Var.aaaaaaan()), getContext());
                return;
            }
            try {
                this.aaaaaaaa = new A5SV6n(aaaaaaa0Var.aaaaaaan());
                return;
            } catch (IOException unused) {
                this.aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaaa(BitmapFactory.decodeFile(aaaaaaa0Var.aaaaaaan()), getContext());
                return;
            }
        }
        BitmapFactory.decodeByteArray(aaaaaaa0Var.aaaaaaae(), 0, aaaaaaa0Var.aaaaaaae().length, options);
        String str2 = options.outMimeType;
        if (TextUtils.isEmpty(str2) || !str2.toLowerCase(Locale.ENGLISH).contains("gif")) {
            this.aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaaa(BitmapFactory.decodeByteArray(aaaaaaa0Var.aaaaaaae(), 0, aaaaaaa0Var.aaaaaaae().length), getContext());
            return;
        }
        try {
            this.aaaaaaaa = new A5SV6n(aaaaaaa0Var.aaaaaaae());
        } catch (IOException unused2) {
            this.aaaaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa.aaaaaaaa(BitmapFactory.decodeByteArray(aaaaaaa0Var.aaaaaaae(), 0, aaaaaaa0Var.aaaaaaae().length), getContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aaaaaaae.aaaaaaaa(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            this.aaaaaaae.aaaaaaa0(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_dcloud_main_skip) {
            aaaaaaaa.aaaaaaao aaaaaaaoVar = this.aaaaaaan;
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.aaaaeaaa();
                return;
            }
            return;
        }
        if (view.getId() == R.id.ad_dcloud_main_img) {
            aaaaaaaa.aaaaaaao aaaaaaaoVar2 = this.aaaaaaan;
            if (aaaaaaaoVar2 != null) {
                aaaaaaaoVar2.onAdClicked();
            }
            this.aaaaaaae.aaaaaaaa(getContext());
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void aaaaaaaa(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.postDelayed(new aaaaaaaa(), this.aaaaaaav);
        viewGroup.postDelayed(new RunnableC0525aaaaaaa0(viewGroup), 50L);
    }
}
