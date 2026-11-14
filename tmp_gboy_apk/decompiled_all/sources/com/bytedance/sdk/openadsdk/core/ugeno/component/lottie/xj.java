package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.adsdk.lottie.pz;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private boolean no;
    private View qi;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj$5, reason: invalid class name */
    public class AnonymousClass5 implements u {
        public AnonymousClass5() {
        }

        @Override // com.bytedance.adsdk.lottie.u
        public Bitmap xj(final d dVar) {
            final String str;
            if (dVar == null) {
                return null;
            }
            String g = dVar.g();
            String pl2 = dVar.pl();
            String u = dVar.u();
            if (!TextUtils.isEmpty(u) && u.startsWith("${") && "image:".equals(g)) {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(u, ((w) xj.this).u);
            } else if (!TextUtils.isEmpty(g) && TextUtils.isEmpty(pl2)) {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(g, ((w) xj.this).u);
            } else if (!TextUtils.isEmpty(pl2) && TextUtils.isEmpty(g)) {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(pl2, ((w) xj.this).u);
            } else if (TextUtils.isEmpty(pl2) || TextUtils.isEmpty(g)) {
                str = null;
            } else {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(g, ((w) xj.this).u) + com.bytedance.adsdk.ugeno.u.hf.xj(pl2, ((w) xj.this).u);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap bitmap = ((hf) xj.this).my.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = ((hf) xj.this).lm.get(str);
            if (num == null || num.intValue() == 2) {
                ((hf) xj.this).lm.put(str, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            com.bytedance.adsdk.ugeno.u.xj().hf().xj(((w) xj.this).d, str, new xj.InterfaceC0033xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.5.1
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(Bitmap bitmap2) {
                    if (bitmap2 == null) {
                        ((hf) xj.this).lm.put(str, 2);
                        return;
                    }
                    final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, dVar.xj(), dVar.hf(), false);
                    ((hf) xj.this).my.put(str, createScaledBitmap);
                    ((hf) xj.this).lm.remove(str);
                    f.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((UgenLottieView) ((w) xj.this).kd).xj(dVar.p(), createScaledBitmap);
                        }
                    });
                }
            });
            return ((hf) xj.this).my.get(str);
        }
    }

    public xj(Context context) {
        super(context);
        this.no = false;
    }

    private void tu() {
        zg zgVar = new zg();
        zgVar.xj(21);
        zgVar.xj(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", ((hf) this).xj);
            zgVar.xj(jSONObject);
            this.da.xj(zgVar, this, this);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf, com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c */
    public UgenLottieView xj() {
        UgenLottieView xj = super.xj();
        xj.setTextDelegate(new jk(xj) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.1
            @Override // com.bytedance.adsdk.lottie.jk
            public String xj(String str) {
                return com.bytedance.adsdk.ugeno.u.hf.xj(str, ((w) xj.this).u);
            }
        });
        xj.setViewDelegate(new pz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.2
            @Override // com.bytedance.adsdk.lottie.pz
            public View xj(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!xj.this.no) {
                    xj.this.no = true;
                    xj.this.xj(map);
                }
                return xj.this.qi;
            }
        });
        xj.setLottieClicklistener(new LottieAnimationView.hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.3
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.hf
            public void xj(String str, JSONArray jSONArray) {
                zg zgVar = new zg();
                zgVar.xj(1);
                zgVar.xj(xj.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    xj.this.xj(zgVar, jSONArray);
                }
                if (((w) xj.this).da != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", ((hf) xj.this).xj);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put(PointParamKey.TYPE, "close");
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put(PointParamKey.TYPE, "clickEvent");
                        }
                        zgVar.xj(jSONObject);
                        yo yoVar = ((w) xj.this).da;
                        xj xjVar = xj.this;
                        yoVar.xj(zgVar, xjVar, xjVar);
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            }
        });
        xj.setLottieAnimListener(new LottieAnimationView.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.4
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.xj
            public void hf(Map<String, Object> map) {
                xj.this.xj(map, 20);
            }

            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.xj
            public void xj(Map<String, Object> map) {
                xj.this.xj(map, 19);
            }
        });
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf
    public void f() {
        T t = this.kd;
        if (t == 0 || ((UgenLottieView) t).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.kd).setImageAssetDelegate(new AnonymousClass5());
        ((UgenLottieView) this.kd).xj();
        tu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Map<String, Object> map, int i) {
        zg zgVar = new zg();
        zgVar.xj(i);
        zgVar.xj(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                xj(zgVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get(MediationConstant.EXTRA_DURATION);
                if (obj2 instanceof Long) {
                    jSONObject.put(MediationConstant.EXTRA_DURATION, obj2);
                    jSONObject.put("uttieUrl", ((hf) this).xj);
                }
            }
            zgVar.xj(jSONObject);
            this.da.xj(zgVar, this, this);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(zg zgVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(PointParamKey.VID);
                    if (!TextUtils.isEmpty(optString)) {
                        int optInt = optJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        w xj = xj(zgVar.xj(), optString);
                        if (xj != null) {
                            xj.hf(optInt == 0 ? 0 : 8);
                            View d = xj.d();
                            if (d instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) d;
                                if (optInt == 0) {
                                    ugenLottieView.xj();
                                    tu();
                                } else {
                                    ugenLottieView.y();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private w xj(w wVar, String str) {
        if (wVar == null) {
            return null;
        }
        while (wVar.z() != null) {
            wVar = wVar.z();
        }
        return wVar.u(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int intValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int intValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (intValue <= 0 || intValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        tf.xj(str, str2, new com.bytedance.sdk.openadsdk.core.ugeno.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj.6
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj(String str4) {
                try {
                    xj.this.xj(new JSONObject(str4), intValue, intValue2, str3);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONObject jSONObject, int i, int i2, String str) {
        w<View> xj;
        qt qtVar = new qt(this.hf);
        if (str.startsWith("2")) {
            xj = qtVar.xj(jSONObject);
            qtVar.hf(this.u);
        } else {
            xj = str.startsWith("3") ? qtVar.xj(jSONObject, this.u, (JSONObject) null) : null;
        }
        if (xj != null) {
            this.qi = xj.d();
        }
    }
}
