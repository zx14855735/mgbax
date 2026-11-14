package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.hf.y;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.res.kd;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FullSwiperItemView extends FrameLayout implements ai.xj, tf {
    private int am;
    public TTProgressBar c;
    private float d;
    private final ai e;
    private float f;
    private com.bytedance.sdk.openadsdk.core.component.reward.y.xj g;
    public FrameLayout hf;
    private int jk;
    public FrameLayout kd;
    private FullRewardExpressView p;

    /* renamed from: pl, reason: collision with root package name */
    private Context f10316pl;
    private hf pz;
    private boolean qt;
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj tf;
    public FrameLayout u;
    private boolean v;
    public FrameLayout w;
    public ViewGroup xj;
    public FrameLayout y;
    private xj yo;
    private boolean zg;

    public interface hf {
        void xj(View view, float f, float f2);
    }

    public interface xj {
        void xj();
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj xjVar, float f, float f2) {
        super(context);
        this.e = new ai(Looper.getMainLooper(), this);
        this.tf = xjVar;
        this.f = f;
        this.d = f2;
        this.f10316pl = context;
        setBackgroundColor(0);
        pl();
        this.jk = wo.d(xjVar.xj());
        this.v = pz.hf().xj(xjVar.xj(), this.jk);
        g();
        this.p = new FullRewardExpressView(this.xj.getContext(), this.tf.xj(), com.bytedance.sdk.openadsdk.core.a.ai.xj(8, String.valueOf(this.jk), this.f, this.d), this.tf.hf(), this.v, null);
    }

    public void am() {
        if (this.tf == null) {
            return;
        }
        this.c.setVisibility(0);
        this.p.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, float f, float f2) {
                if (FullSwiperItemView.this.pz != null) {
                    FullSwiperItemView.this.pz.xj(view, f, f2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, int i) {
                super.xj(view, i);
            }
        });
        this.p.setExpressVideoListenerProxy(this);
        this.p.setInteractListener(this.yo);
        this.p.setOnVideoSizeChangeListener(new FullRewardExpressView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.xj
            public void xj(int i) {
                FullSwiperItemView.this.am = i;
            }
        });
        if (this.p.getParent() != null) {
            ((ViewGroup) this.p.getParent()).removeView(this.p);
        }
        this.kd.addView(this.p);
        this.g = new com.bytedance.sdk.openadsdk.core.component.reward.y.xj(this.xj.getContext(), this.w, this.tf.xj(), null);
        this.g.xj(new w(this.tf.kd(), vm.w(this.tf.xj()), new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.w.xj
            public void xj() {
                if (FullSwiperItemView.this.f10316pl instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.f10316pl).lw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.w.xj
            public void xj(long j, long j2) {
                y dc;
                if (FullSwiperItemView.this.p == null || !(FullSwiperItemView.this.f10316pl instanceof TTBaseVideoActivity) || (dc = ((TTBaseVideoActivity) FullSwiperItemView.this.f10316pl).dc()) == null) {
                    return;
                }
                dc.hf(j);
                FullSwiperItemView.this.p.xj(String.valueOf(dc.q()), (int) (dc.z() / 1000), 0, j == j2 || dc.l());
            }
        }, this.e));
        this.g.hf(this.v);
        this.p.setVideoController(this.g);
        this.tf.xj(this.w, this.u, this.p);
        this.p.e();
        this.p.yo();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
        am.xj().w(this.tf.xj(), "stats_reward_full_click_express_close");
        Context context = this.f10316pl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).aq().xj().xj();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ws xj2 = this.tf.xj();
            if (xj2 != null && xj2.lq() != null) {
                jSONObject.put("refresh_num", this.tf.xj().lq().w());
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        am.xj().xj(this.tf.xj(), "stats_reward_full_click_native_close", jSONObject);
        xj xjVar = this.yo;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
        xj xjVar = this.yo;
        if (xjVar != null) {
            xjVar.xj();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ws xj2 = this.tf.xj();
            if (xj2 != null && xj2.lq() != null) {
                jSONObject.put("refresh_num", this.tf.xj().lq().w());
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        am.xj().xj(this.tf.xj(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.f10316pl;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void g() {
        ws xj2 = this.tf.xj();
        if (xj2 == null) {
            return;
        }
        float yq = xj2.yq();
        int rs = xj2.rs();
        float eq = xj2.eq();
        float[] xj3 = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.f10316pl.getApplicationContext(), xj2.yq(), xj2.rs());
        float f = xj3[0];
        float f2 = xj3[1];
        if (yq == 100.0f) {
            this.f = f;
            this.d = f2;
            return;
        }
        int[] xj4 = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.f10316pl.getApplicationContext(), yq, eq, rs);
        int i = xj4[0];
        int i2 = xj4[1];
        int i3 = xj4[2];
        int i4 = xj4[3];
        this.f = (int) ((f - i) - i3);
        this.d = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void hf(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void kd() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
    }

    public void pl() {
        View pl2 = kd.pl(this.f10316pl);
        addView(pl2);
        this.xj = (ViewGroup) pl2.findViewById(2114387892);
        this.hf = (FrameLayout) pl2.findViewById(2114387778);
        this.w = (FrameLayout) pl2.findViewById(2114387812);
        this.u = (FrameLayout) pl2.findViewById(2114387670);
        this.kd = (FrameLayout) pl2.findViewById(2114387821);
        this.y = (FrameLayout) pl2.findViewById(2114387679);
        this.c = (TTProgressBar) pl2.findViewById(2114387767);
    }

    public void qt() {
        if (this.g != null && this.qt) {
            this.tf.d();
            this.p.zg();
            this.zg = true;
            if (ws.hf(this.tf.xj())) {
                this.e.sendEmptyMessageDelayed(102, PushUIConfig.dismissTime);
            }
            this.tf.xj(this.p);
            if (this.p.pz()) {
                return;
            }
            this.g.xj(this.tf.tf());
        }
    }

    public void setOnSwiperItemInteractListener(xj xjVar) {
        this.yo = xjVar;
    }

    public void setOnSwiperItemRenderResultListener(hf hfVar) {
        this.pz = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
        com.bytedance.sdk.openadsdk.core.component.reward.u.xj aq;
        xj xjVar = this.yo;
        if (xjVar != null) {
            xjVar.xj();
        }
        Context context = this.f10316pl;
        if (!(context instanceof TTBaseVideoActivity) || (aq = ((TTBaseVideoActivity) context).aq()) == null || aq.xj() == null) {
            return;
        }
        aq.xj().w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void u() {
    }

    public void v() {
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
    }

    public void yo() {
        ai aiVar = this.e;
        if (aiVar != null) {
            aiVar.removeMessages(102);
        }
    }

    public void zg() {
        com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
        if (xjVar == null) {
            return;
        }
        xjVar.y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f, float f2, float f3, float f4, int i) {
    }

    public void hf(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.pz()) {
            Context context = this.f10316pl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).v();
            }
        } else {
            this.p.xj((ViewGroup) this.hf, false);
        }
        this.qt = true;
        this.tf.w(z);
        qt();
        this.c.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int w() {
        com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
        if (xjVar == null) {
            return 0;
        }
        return (int) (xjVar.p() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i, String str) {
    }

    public static class w implements xj.InterfaceC0194xj {
        private final xj hf;
        private final ai kd;
        private final int u;
        private boolean w = false;
        private final xj.InterfaceC0194xj xj;

        public interface xj {
            void xj();

            void xj(long j, long j2);
        }

        public w(xj.InterfaceC0194xj interfaceC0194xj, int i, xj xjVar, ai aiVar) {
            this.xj = interfaceC0194xj;
            this.hf = xjVar;
            this.u = i;
            this.kd = aiVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void hf() {
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.hf();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void w() {
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.w();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj() {
            this.w = false;
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj();
            }
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.xj();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj(int i, String str) {
            this.w = false;
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
        public void xj(long j, long j2) {
            this.kd.removeMessages(102);
            xj.InterfaceC0194xj interfaceC0194xj = this.xj;
            if (interfaceC0194xj != null) {
                interfaceC0194xj.xj(j, j2);
            }
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.xj(j, j2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
        if (this.v != z) {
            this.v = z;
            com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
            if (xjVar != null) {
                xjVar.hf(z);
            }
            Context context = this.f10316pl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).aq().xj().hf();
            }
            xj xjVar2 = this.yo;
            if (xjVar2 != null) {
                xjVar2.xj();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        com.bytedance.sdk.openadsdk.core.component.reward.y.xj xjVar = this.g;
        if (xjVar == null || !this.zg) {
            return 2;
        }
        if (xjVar.s()) {
            return 5;
        }
        if (this.g.ht()) {
            return 1;
        }
        if (this.g.dq()) {
            return 2;
        }
        this.g.dk();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        return this.g.p();
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj xjVar = this.tf;
        if (xjVar != null) {
            xjVar.c();
        }
        Context context = this.f10316pl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).p();
        }
        xj xjVar2 = this.yo;
        if (xjVar2 != null) {
            xjVar2.xj();
        }
    }
}
