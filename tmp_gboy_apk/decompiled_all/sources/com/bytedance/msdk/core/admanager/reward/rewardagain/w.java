package com.bytedance.msdk.core.admanager.reward.rewardagain;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.msdk.core.f.g;
import com.bytedance.msdk.core.kd.hf.u;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private String c;
    private final com.bytedance.msdk.api.xj.hf hf;
    private Activity kd;
    private com.bytedance.msdk.api.u.xj.f.xj u;
    private com.bytedance.msdk.api.u.xj.f.xj w;
    private final SoftReference<Context> xj;
    private Object y;
    private static final Map<String, hf> tf = new ConcurrentHashMap();
    private static final Map<String, com.bytedance.msdk.core.admanager.reward.rewardagain.xj> p = new ConcurrentHashMap();

    /* renamed from: pl, reason: collision with root package name */
    private static xj f10120pl = new xj();
    private volatile boolean f = false;
    private volatile boolean d = false;

    public static class xj {
        public Runnable hf;
        public Runnable w;
        public hf xj;
    }

    static {
        eROYPe();
    }

    public w(Context context, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.f.xj xjVar, com.bytedance.msdk.api.u.xj.f.xj xjVar2) {
        this.xj = new SoftReference<>(context);
        this.hf = hfVar;
        if (xjVar != null) {
            this.w = xjVar;
        }
        if (xjVar2 != null) {
            this.u = xjVar2;
        }
    }

    public static com.bytedance.msdk.core.admanager.reward.rewardagain.xj d(String str) {
        return p.get(str);
    }

    private static /* synthetic */ void eROYPe() {
        char[] charArray = "\u0084\u0088\u008aÉ\u0080\u0086\u008a\u0082É\u0085\u0088\u009eÉ\u0094\u008f\u0082\u008b\u008bÉ\u00ad\u0089\u008e¥\u0095\u008e\u0083\u0080\u0082".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 231);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0084\u008b\u008e\u0089\u008e\u0093".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 231);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void tf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.remove(str);
    }

    private static String c() {
        return new SimpleDateFormat("dd-MM-yyyy HH", Locale.getDefault()).format(new Date());
    }

    public static double f(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar = p.get(str);
        if (xjVar != null) {
            return xjVar.y();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        com.bytedance.msdk.api.u.xj.f.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.w();
        }
        y.hf(this.hf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar, com.bytedance.msdk.hf.w wVar) {
        int xj2 = xj(this.hf, xjVar, wVar);
        y.w(this.hf, xj2);
        if (xj2 == 0) {
            xj();
            return;
        }
        com.bytedance.msdk.api.u.xj.f.xj xjVar2 = this.w;
        if (xjVar2 != null) {
            xjVar2.w();
        }
    }

    private static String y() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    public void hf(com.bytedance.msdk.api.u.xj.f.xj xjVar) {
        if (xjVar != null) {
            this.u = xjVar;
        }
    }

    private void hf(final com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar, final com.bytedance.msdk.hf.w wVar) {
        xj xjVar2 = new xj();
        f10120pl = xjVar2;
        xjVar2.xj = tf.get(xjVar.u());
        f10120pl.hf = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.3
            @Override // java.lang.Runnable
            public void run() {
                w.this.w(xjVar, wVar);
                w.f();
            }
        };
        f10120pl.w = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.4
            @Override // java.lang.Runnable
            public void run() {
                w.this.kd();
                w.f();
            }
        };
        Intent intent = new Intent(com.bytedance.msdk.core.hf.getContext(), (Class<?>) GMRewardAgainDialogActivity.class);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        com.bytedance.msdk.core.hf.getContext().startActivity(intent);
    }

    public static void u(String str) {
        ai xj2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext());
        String hf = xj2.hf("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(hf)) {
            try {
                JSONObject jSONObject = new JSONObject(hf);
                String c = c();
                JSONObject optJSONObject = jSONObject.optJSONObject(c);
                if (optJSONObject == null) {
                    xj2.xj("ra_show_count_in_hour", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(c, optJSONObject);
                xj2.xj("ra_show_count_in_hour", jSONObject.toString());
                return;
            } catch (JSONException e) {
                pl.xj(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(c(), jSONObject2);
            xj2.xj("ra_show_count_in_hour", jSONObject3.toString());
        } catch (JSONException e2) {
            pl.xj(e2);
        }
    }

    public static double c(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar = p.get(str);
        if (xjVar == null) {
            return -1.0d;
        }
        double w = xjVar.w();
        if (w < 0.0d || w > 1.0d) {
            return -1.0d;
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        xj xjVar = f10120pl;
        xjVar.xj = null;
        xjVar.hf = null;
        xjVar.w = null;
    }

    public static long y(String str) {
        String hf = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf("ra_play_rit_ts");
        try {
            if (!TextUtils.isEmpty(hf)) {
                return new JSONObject(hf).optLong(str, -1L);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return -1L;
    }

    public void xj(Activity activity, Object obj, String str) {
        this.kd = activity;
        this.y = obj;
        this.c = str;
    }

    public static void kd(String str) {
        JSONObject jSONObject;
        ai xj2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext());
        String hf = xj2.hf("ra_play_rit_ts");
        try {
            if (TextUtils.isEmpty(hf)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(hf);
            }
            jSONObject.put(str, System.currentTimeMillis());
            xj2.xj("ra_play_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static int w(String str) {
        String hf = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(hf)) {
            try {
                JSONObject optJSONObject = new JSONObject(hf).optJSONObject(c());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return 0;
    }

    public void xj(com.bytedance.msdk.api.u.xj.f.xj xjVar) {
        if (xjVar != null) {
            this.w = xjVar;
        }
    }

    public void xj(final com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar, final com.bytedance.msdk.hf.w wVar) {
        Activity activity = this.kd;
        if (activity != null && !activity.isFinishing() && !this.kd.isDestroyed()) {
            final Dialog dialog = new Dialog(this.kd);
            View inflate = LayoutInflater.from(this.kd.getApplicationContext()).inflate(2131493305, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(2131297784);
            TextView textView = (TextView) inflate.findViewById(2131297785);
            TextView textView2 = (TextView) inflate.findViewById(2131297783);
            TextView textView3 = (TextView) inflate.findViewById(2131297782);
            hf hfVar = tf.get(xjVar.u());
            if (hfVar != null) {
                textView.setText(hfVar.hf());
                textView2.setText(hfVar.u());
                textView3.setText(hfVar.kd());
                if (!TextUtils.isEmpty(hfVar.w())) {
                    new com.bytedance.msdk.xj.kd.hf(imageView).xj((Object[]) new String[]{hfVar.w()});
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.w(xjVar, wVar);
                    dialog.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.kd();
                    dialog.dismiss();
                }
            });
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            return;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- reward again show activity dialog");
        hf(xjVar, wVar);
    }

    public void hf() {
        this.d = true;
    }

    public static void hf(String str) {
        ai xj2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext());
        String hf = xj2.hf("ra_show_count");
        if (!TextUtils.isEmpty(hf)) {
            try {
                JSONObject jSONObject = new JSONObject(hf);
                String y = y();
                JSONObject optJSONObject = jSONObject.optJSONObject(y);
                if (optJSONObject == null) {
                    xj2.xj("ra_show_count", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(y, optJSONObject);
                xj2.xj("ra_show_count", jSONObject.toString());
                return;
            } catch (JSONException e) {
                pl.xj(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(y(), jSONObject2);
            xj2.xj("ra_show_count", jSONObject3.toString());
        } catch (JSONException e2) {
            pl.xj(e2);
        }
    }

    public static xj w() {
        return f10120pl;
    }

    public void xj() {
        Context context = this.xj.get();
        if (context != null) {
            this.hf.kd(1);
            final com.bytedance.msdk.w.u.pl plVar = new com.bytedance.msdk.w.u.pl(context);
            xj(plVar);
            plVar.xj(this.hf, new com.bytedance.msdk.api.u.xj.f.hf() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.5
                @Override // com.bytedance.msdk.api.u.xj.f.hf
                public void hf() {
                    if (w.this.f) {
                        return;
                    }
                    w.this.f = true;
                    plVar.xj(w.this.kd, w.this.y, w.this.c);
                }

                @Override // com.bytedance.msdk.api.u.xj.f.hf
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                    if (w.this.f) {
                        return;
                    }
                    w.this.f = true;
                    if (w.this.w != null) {
                        w.this.w.w();
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.f.hf
                public void xj() {
                    if (w.this.f) {
                        return;
                    }
                    w.this.f = true;
                    plVar.xj(w.this.kd, w.this.y, w.this.c);
                }
            });
            com.bytedance.msdk.xj.kd.y.hf(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.6
                @Override // java.lang.Runnable
                public void run() {
                    if (w.this.f) {
                        return;
                    }
                    w.this.f = true;
                    if (w.this.w != null) {
                        w.this.w.w();
                    }
                }
            }, 500L);
        }
    }

    private void xj(com.bytedance.msdk.w.u.pl plVar) {
        plVar.xj(new com.bytedance.msdk.api.u.xj.f.xj() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.7
            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void i_() {
                String ra = w.this.hf != null ? w.this.hf.ra() : "";
                w.hf(ra);
                w.u(ra);
                w.kd(ra);
                if (w.this.u != null) {
                    w.this.u.i_();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void j_() {
                if (w.this.u != null) {
                    w.this.u.j_();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void kd() {
                if (w.this.u != null) {
                    w.this.u.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void u() {
                if (w.this.u != null) {
                    w.this.u.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void w() {
                if (w.this.w != null) {
                    w.this.w.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (w.this.u != null) {
                    w.this.u.xj(xjVar);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void y() {
                if (w.this.u != null) {
                    w.this.u.y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                if (w.this.u != null) {
                    w.this.u.xj(xjVar);
                }
            }
        });
        plVar.hf(new com.bytedance.msdk.api.u.xj.f.xj() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.w.8
            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void i_() {
                if (w.this.u != null) {
                    w.this.u.i_();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void j_() {
                if (w.this.u != null) {
                    w.this.u.j_();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void kd() {
                if (w.this.u != null) {
                    w.this.u.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void u() {
                if (w.this.u != null) {
                    w.this.u.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void w() {
                if (w.this.w != null) {
                    w.this.w.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (w.this.u != null) {
                    w.this.u.xj(xjVar);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void y() {
                if (w.this.u != null) {
                    w.this.u.y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                if (w.this.u != null) {
                    w.this.u.xj(xjVar);
                }
            }
        });
    }

    public int xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar, com.bytedance.msdk.hf.w wVar) {
        if (!this.d) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 还未触发rewardVerify");
            return 1;
        }
        String ra = hfVar.ra();
        int kd = xjVar.kd();
        int xj2 = xj(ra);
        if (xj2 >= kd) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得展示次数超过天级别限制，限制: " + kd + ", 已经展示: " + xj2);
            return 2;
        }
        if (tf.get(xjVar.u()) == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得样式为空");
            return 3;
        }
        if (com.bytedance.msdk.core.c.xj.xj().hf()) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 命中请求熔断");
            return 4;
        }
        if (!g.xj().f(ra)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 命中展示频控");
            return 5;
        }
        if (!g.xj().w(ra)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 命中展示间隔");
            return 6;
        }
        double hf = u.xj().hf(ra, hfVar);
        if (hf <= -1.0d) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得无缓存可用");
            return 7;
        }
        if (hf < f(ra)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得有缓存，但是ecpm不符合");
            return 8;
        }
        int xj3 = xjVar.xj();
        int w = w(ra);
        if (w >= xj3) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得展示次数超过小时级别限制，限制: " + xj3 + ", 已经展示: " + w);
            return 9;
        }
        long hf2 = xjVar.hf();
        long y = y(ra);
        long currentTimeMillis = System.currentTimeMillis() - y;
        if (y != -1 && currentTimeMillis < hf2) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("--==--ra: 激励再得展示间隔超过限制，config间隔: ", hf2, ", 实际间隔: ");
            B2KMhB2.append(currentTimeMillis);
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, B2KMhB2.toString());
            return 10;
        }
        double c = c(ra);
        if (wVar == null || c == -1.0d || hf >= wVar.da() * c) {
            return 0;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==--ra: 激励再得ecpm下探期间不满足");
        return 11;
    }

    public static int xj(String str) {
        String hf = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf("ra_show_count");
        if (!TextUtils.isEmpty(hf)) {
            try {
                JSONObject optJSONObject = new JSONObject(hf).optJSONObject(y());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return 0;
    }

    public static void xj(String str, com.bytedance.msdk.core.admanager.reward.rewardagain.xj xjVar) {
        if (TextUtils.isEmpty(str) || xjVar == null) {
            return;
        }
        p.put(str, xjVar);
    }

    public static void xj(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                hf hfVar = new hf();
                hfVar.xj(optJSONObject.optString("ra_id"));
                hfVar.hf(optJSONObject.optString("title"));
                hfVar.w(optJSONObject.optString("pic_url"));
                hfVar.u(optJSONObject.optString("btn_ok"));
                hfVar.kd(optJSONObject.optString("btn_cancel"));
                tf.put(hfVar.xj(), hfVar);
            }
        }
    }
}
