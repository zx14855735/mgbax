package com.bytedance.sdk.openadsdk.core.activity.base;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.dislike.ui.xj;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pl.w.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.d.hf;
import com.bytedance.sdk.openadsdk.core.ugeno.d.u;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.core.ugeno.w.xj;
import com.bytedance.sdk.openadsdk.res.kd;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements ai.xj {
    private static WeakReference<w> c;
    private boolean ai;
    private TTViewStub am;
    private ImageView d;
    private xj dk;
    private ImageView e;
    private long en;
    private boolean et;
    private ImageView f;
    private TTViewStub g;
    private u ht;

    /* renamed from: io, reason: collision with root package name */
    private FrameLayout f10282io;
    private Activity jk;
    private TextView p;

    /* renamed from: pl, reason: collision with root package name */
    private Context f10283pl;
    private FrameLayout pz;
    private int q;
    private TTViewStub qt;
    private hf ra;
    private TextView tf;
    private boolean x;
    com.bytedance.sdk.openadsdk.core.dislike.ui.xj y;
    private y yo;
    private int z;
    private TTViewStub zg;
    private AtomicBoolean v = new AtomicBoolean(true);
    private boolean j = true;
    private final ai l = new ai(Looper.getMainLooper(), this);
    private String ff = "立即下载";

    private void c() {
        if (!tf.f(this.kd)) {
            d();
            return;
        }
        xj xjVar = new xj(this, this.pz, this.yo, this.kd, this.w, this.u, f());
        this.dk = xjVar;
        xjVar.xj(new com.bytedance.sdk.openadsdk.core.ugeno.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(int i) {
                TTNativePageActivity.this.xj(i);
            }
        });
        this.dk.xj();
    }

    private void d() {
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj x = this.kd.x();
        if (x == null) {
            return;
        }
        int u = x.u();
        if (u == 2) {
            u uVar = new u(this.f10283pl, this.pz, this.yo, this.kd, this.w, this.u);
            this.ht = uVar;
            uVar.g();
            return;
        }
        if (u == 3) {
            hf hfVar = new hf(this.f10283pl, this.pz, this.yo, this.kd, this.w, this.u);
            this.ra = hfVar;
            hfVar.hf(false);
            this.ra.g();
            if (TextUtils.equals(x.xj(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.f10283pl);
            float w = r.w(this.f10283pl, 18.0f);
            float w2 = r.w(this.f10283pl, 18.0f);
            int i = (int) w;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) w2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.f10282io.addView(imageView, layoutParams);
            jk.xj(this.f10283pl, "tt_unmute", imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.et = !r3.et;
                    jk.xj(TTNativePageActivity.this.f10283pl, TTNativePageActivity.this.et ? "tt_mute" : "tt_unmute", imageView);
                    TTNativePageActivity.this.ra.w(TTNativePageActivity.this.et);
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.hf.xj f() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.multipro.hf.xj.xj(new JSONObject(stringExtra));
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    private void g() {
        this.q = 0;
        if (this.x) {
            this.q = com.bytedance.sdk.openadsdk.core.f.u.xj;
        } else if (this.ai && !com.bytedance.sdk.openadsdk.core.f.u.u) {
            this.q = aq.am(this.kd);
        }
        w(this.q);
        if (this.q > 0 && !this.l.hasMessages(10)) {
            if (this.x) {
                this.l.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.ai) {
                this.l.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void kd() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.x() == null || this.kd.x().u() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.kd);
    }

    private boolean p() {
        return this.x || this.ai;
    }

    private boolean pl() {
        return ws.w(this.kd);
    }

    private void tf() {
        TTViewStub tTViewStub;
        this.f10282io = (FrameLayout) findViewById(2114387634);
        this.pz = (FrameLayout) findViewById(2114387720);
        this.zg = (TTViewStub) findViewById(2114387956);
        this.g = (TTViewStub) findViewById(2114387770);
        this.am = (TTViewStub) findViewById(2114387792);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387933);
        this.qt = tTViewStub2;
        if (this.x || this.ai) {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.e = (ImageView) findViewById(2114387843);
        } else {
            int ai = f.zg().ai();
            if (ai == 0) {
                TTViewStub tTViewStub3 = this.g;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (ai == 1 && (tTViewStub = this.am) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.f = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.d = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.tf = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.p = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.xj();
                }
            });
        }
    }

    private void y() {
        this.ai = aq.v(this.kd);
        boolean yo = aq.yo(this.kd);
        this.x = yo;
        if (this.ai) {
            if (!com.bytedance.sdk.openadsdk.core.f.u.u) {
                this.x = false;
            } else if (yo) {
                this.ai = false;
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kd == null) {
            return;
        }
        setRequestedOrientation(1);
        this.jk = this;
        this.f10283pl = this;
        getWindow().addFlags(1024);
        try {
            pz.xj(this.jk);
        } catch (Throwable th) {
            pl.xj(th);
        }
        setContentView(kd.wo(this.f10283pl));
        this.en = System.currentTimeMillis();
        String stringExtra = getIntent().getStringExtra("title");
        kd();
        y();
        tf();
        ws wsVar = this.kd;
        if (wsVar != null && wsVar.xl() != null) {
            this.kd.xl().xj("landing_page");
        }
        y yVar = new y(this.kd);
        this.yo = yVar;
        yVar.xj(true);
        this.yo.xj();
        if (this.kd != null) {
            c();
        }
        TextView textView = this.tf;
        if (textView != null && !this.x && !this.ai) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = jk.xj(this.jk, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        hf(4);
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, getClass().getName());
        if (this.x || this.ai) {
            g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        xj xjVar = this.dk;
        if (xjVar != null) {
            xjVar.u();
        }
        hf hfVar = this.ra;
        if (hfVar != null) {
            hfVar.zg();
        }
        y yVar = this.yo;
        if (yVar != null) {
            yVar.u();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        xj xjVar = this.dk;
        if (xjVar != null) {
            xjVar.hf();
        }
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        y yVar = this.yo;
        if (yVar != null) {
            yVar.w();
        }
        u();
        xj xjVar = this.dk;
        if (xjVar != null) {
            xjVar.w();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        y yVar = this.yo;
        if (yVar != null) {
            yVar.xj(0);
        }
        if (this.j) {
            this.j = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.en);
                jSONObject.put(PointCategory.END, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, this.kd);
            } catch (JSONException e) {
                pl.xj(e);
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject2) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    public void u() {
        if (!p() || this.l.hasMessages(10)) {
            return;
        }
        this.l.sendEmptyMessageDelayed(10, 1000L);
    }

    private void hf(int i) {
        if (pl()) {
            r.xj((View) this.d, 4);
        } else {
            if (this.d == null || !pl()) {
                return;
            }
            r.xj((View) this.d, i);
        }
    }

    private void w(int i) {
        if (i <= 0) {
            if (this.x) {
                r.xj(this.tf, "领取成功");
                return;
            } else {
                if (this.ai) {
                    r.xj((View) this.e, 8);
                    r.xj(this.tf, "恭喜你！福利已领取");
                    return;
                }
                return;
            }
        }
        if (this.x) {
            r.xj(this.tf, i + "s后可领取奖励");
            return;
        }
        if (this.ai) {
            SpannableString spannableString = new SpannableString(CtFAbx.ASJ6gh(i, "浏览 ", "秒 获得更多福利"));
            spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() - 4, spannableString.length(), 17);
            r.xj(this.tf, spannableString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        Intent intent;
        WeakReference<w> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = c) != null && weakReference.get() != null) {
            c.get().hf(false);
            c.get().xj(wo.v(this.kd), false);
            c = null;
        } else {
            if (ws.hf(this.kd) && wo.kd(this.kd)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.hf.xj(this.jk, intent, null);
            } catch (Throwable th) {
                pl.hf("TTNativePageActivity", th);
            }
        }
        finish();
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(this.jk, this.kd.xl(), this.w, true);
        this.y = xjVar;
        com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.jk, this.kd, xjVar);
        this.y.xj(new xj.InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void hf() {
                TTNativePageActivity.this.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj() {
                TTNativePageActivity.this.w();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj(int i, String str, boolean z) {
                TTNativePageActivity.this.u();
            }
        });
    }

    public void xj() {
        if (this.kd == null || isFinishing()) {
            return;
        }
        if (this.y == null) {
            hf();
        }
        this.y.xj();
    }

    public void w() {
        if (p()) {
            this.l.removeMessages(10);
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 10 && p()) {
            int i = this.z + 1;
            this.z = i;
            if (this.x) {
                com.bytedance.sdk.openadsdk.core.f.u.hf = i;
            }
            int max = Math.max(0, this.q - i);
            w(max);
            if (max <= 0 && this.ai) {
                com.bytedance.sdk.openadsdk.core.f.u.u = true;
            }
            this.l.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public static void xj(w wVar) {
        c = new WeakReference<>(wVar);
    }
}
