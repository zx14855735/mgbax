package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import DG07BK.A5SV6n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import io.dcloud.base.R;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import io.dcloud.openapi.core.util.ReflectUtil;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaeaaa {
    aaaaaaaa.aaaaaaau aaaaaaa0;
    aaaaaaae aaaaaaaa;
    View aaaaaaac;
    View aaaaaaao;
    Context aaaaaaav;
    boolean aaaaaaau = false;
    boolean aaaaaaan = false;
    boolean aaaaaaae = false;
    BroadcastReceiver aaaaaaeo = new aaaaaaa0();
    private final Runnable aaaeaaaa = new com.fl.saas.common.crash.A2egSU(5, this);

    public class aaaaaaa0 extends BroadcastReceiver {
        public aaaaaaa0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (aaaaeaaa.this.aaaaaaan) {
                return;
            }
            String stringExtra = intent.getStringExtra("src");
            if (TextUtils.isEmpty(stringExtra) || aaaaeaaa.this.aaaaaaa0.aaaaaaao() == null || !aaaaeaaa.this.aaaaaaa0.aaaaaaa0().optString("src").equalsIgnoreCase(stringExtra)) {
                return;
            }
            if (!intent.getBooleanExtra("downloadImage", false)) {
                aaaaeaaa.this.aaaaaaaa();
                return;
            }
            aaaaaaaa.aaaaaaau aaaaaaauVar = aaaaeaaa.this.aaaaaaa0;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, aaaaaaauVar.aaaaaaav, aaaaaaauVar);
            if (aaaaeaaa.this.aaaaaaa0.aaaaaaaa()) {
                aaaaeaaa.this.aaaaaaao();
            } else {
                aaaaeaaa.this.aaaaaaaa();
            }
        }
    }

    public class aaaaaaaa implements aaaeaaaa {
        final /* synthetic */ Context aaaaaaaa;

        public aaaaaaaa(Context context) {
            this.aaaaaaaa = context;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaeaaaa
        public void aaaaaaaa(JSONObject jSONObject) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "listenADReceive----------------onReceiver-");
            aaaaeaaa aaaaeaaaVar = aaaaeaaa.this;
            if (aaaaeaaaVar.aaaaaaan) {
                return;
            }
            Context context = aaaaeaaaVar.aaaaaaav;
            aaaaaaaa.aaaaaaau aaaaaaauVar = aaaaeaaaVar.aaaaaaa0;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, aaaaaaauVar.aaaaaaav, aaaaaaauVar);
            if (aaaaeaaa.this.aaaaaaa0.aaaaaaaa()) {
                aaaaeaaa.this.aaaaaaao();
            } else {
                aaaaeaaa.this.aaaaaaaa(this.aaaaaaaa);
            }
        }
    }

    public class aaaaaaac implements View.OnTouchListener {
        public aaaaaaac() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                aaaaeaaa.this.aaaaaaa0.aaaaaaaa = motionEvent;
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            aaaaeaaa.this.aaaaaaa0.aaaaaaa0 = motionEvent;
            return false;
        }
    }

    public class aaaaaaao implements View.OnClickListener {
        final /* synthetic */ Context aaaaaaaa;

        public aaaaaaao(Context context) {
            this.aaaaaaaa = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("down_x", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaaa.getX()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("down_y", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaaa.getY()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("up_x", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaa0.getX()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("up_y", aaaaeaaa.this.aaaaaaa0.aaaaaaa0.getY());
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("relative_down_x", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaaa.getX() - view.getX()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("relative_down_y", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaaa.getY() - view.getY()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("relative_up_x", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaa0.getX() - view.getX()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("relative_up_y", Math.round(aaaaeaaa.this.aaaaaaa0.aaaaaaa0.getY() - view.getY()));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("dw", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa.aaaaaaaa.aaaaaaa0(this.aaaaaaaa));
                aaaaeaaa.this.aaaaaaa0.aaaaaaao().put("dh", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaaa));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Context context = this.aaaaaaaa;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, aaaaeaaa.this.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, "adid"));
            view.setOnClickListener(null);
            aaaaeaaa aaaaeaaaVar = aaaaeaaa.this;
            aaaaaaaa.aaaaaaau aaaaaaauVar = aaaaeaaaVar.aaaaaaa0;
            aaaaaaauVar.aaaaaaaa = null;
            aaaaaaauVar.aaaaaaa0 = null;
            aaaaeaaaVar.aaaaaaaa.onClicked();
        }
    }

    public class aaaaaaau implements View.OnClickListener {
        public aaaaaaau() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            aaaaeaaa aaaaeaaaVar = aaaaeaaa.this;
            aaaaeaaaVar.aaaaaaac.removeCallbacks(aaaaeaaaVar.aaaeaaaa);
            aaaaeaaa.this.aaaaaaaa();
        }
    }

    public aaaaeaaa(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, ViewGroup viewGroup, aaaaaaae aaaaaaaeVar) {
        this.aaaaaaaa = null;
        this.aaaaaaao = null;
        this.aaaaaaac = null;
        this.aaaaaaaa = aaaaaaaeVar;
        this.aaaaaaa0 = aaaaaaauVar;
        this.aaaaaaav = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dcloud_ad_main_container, (ViewGroup) null);
        this.aaaaaaac = inflate;
        viewGroup.addView(inflate);
        this.aaaaaaao = (TextView) this.aaaaaaac.findViewById(R.id.ad_dcloud_main_skip);
        if (this.aaaaaaa0.aaaaaaaa()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("SplashADViewWrapper", "use cache AdData");
            aaaaaaaa(context, this.aaaaaaac);
        } else {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "listenADReceive-----------------");
            this.aaaaaaa0.aaaaaaaa(context, new aaaaaaaa(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaao() {
        if (this.aaaaaaau) {
            this.aaaaaaac.removeCallbacks(this.aaaeaaaa);
            this.aaaaaaac.postDelayed(this.aaaeaaaa, 2000L);
        }
        aaaaaaaa(this.aaaaaaav, this.aaaaaaac);
    }

    public void aaaaaaa0() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ADReceive", "onWillCloseSplash ");
        this.aaaaaaau = true;
        if (this.aaaaaaao != null && this.aaaaaaa0.aaaaaaaa()) {
            this.aaaaaaao.setVisibility(0);
        }
        this.aaaaaaac.postDelayed(this.aaaeaaaa, PushUIConfig.dismissTime);
    }

    public void aaaaaaaa(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ad_img_downlaod_receive");
        A5SV6n.A2egSU(context).registerReceiver(this.aaaaaaeo, intentFilter);
        this.aaaaaaae = true;
    }

    private void aaaaaaaa(Context context, View view) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ADReceive", "initAdMainView ");
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ad_dcloud_main_img);
        frameLayout.setOnClickListener(new aaaaaaao(context));
        frameLayout.setOnTouchListener(new aaaaaaac());
        Object obj = this.aaaaaaa0.aaaaaaau;
        if (obj instanceof Bitmap) {
            aaaaaaaa.aaaaaaau aaaaaaauVar = this.aaaaaaa0;
            frameLayout.addView(new aaaaaaav(context, (Bitmap) aaaaaaauVar.aaaaaaau, aaaaaaauVar), -1, -1);
        } else if (obj instanceof Drawable) {
            ImageView imageView = (ImageView) ReflectUtil.newInstance("pl.droidsonroids.gif.GifImageView", new Class[]{Context.class}, new Object[]{context});
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable((Drawable) this.aaaaaaa0.aaaaaaau);
            frameLayout.addView(imageView, -1, -1);
        }
        if (this.aaaaaaau) {
            this.aaaaaaao.setVisibility(0);
        }
        this.aaaaaaao.setOnClickListener(new aaaaaaau());
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaao(context, this.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, "adid"));
        this.aaaaaaaa.onShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaaa() {
        this.aaaaaaaa.aaaaaaaa();
        View view = this.aaaaaaac;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.aaaaaaac.getParent()).removeView(this.aaaaaaac);
        }
        this.aaaaaaan = true;
        Object obj = this.aaaaaaa0.aaaaaaau;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.aaaaaaau = false;
        if (this.aaaaaaae) {
            A5SV6n.A2egSU(this.aaaaaaav).unregisterReceiver(this.aaaaaaeo);
        }
    }
}
