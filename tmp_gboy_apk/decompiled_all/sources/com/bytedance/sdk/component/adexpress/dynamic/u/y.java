package com.bytedance.sdk.component.adexpress.dynamic.u;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.u.kd;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static HashMap<String, String> c;
    private JSONObject hf;
    private w kd;
    private xj u;
    private com.bytedance.sdk.component.adexpress.dynamic.w.w w;
    private JSONObject xj;
    private com.bytedance.sdk.component.adexpress.dynamic.w.u y;

    public static class xj {
        float hf;
        boolean w;
        float xj;

        public static xj xj(JSONObject jSONObject) {
            xj xjVar = new xj();
            if (jSONObject != null) {
                xjVar.xj = (float) jSONObject.optDouble(MediaFormat.KEY_WIDTH);
                xjVar.hf = (float) jSONObject.optDouble(MediaFormat.KEY_HEIGHT);
                xjVar.w = jSONObject.optBoolean("isLandscape");
            }
            return xjVar;
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        c = hashMap;
        hashMap.put(MediaFormat.KEY_SUBTITLE, "description");
        c.put(n.l, "source|app.app_name");
        c.put("screenshot", "dynamic_creative.screenshot");
        ioJVr();
    }

    public y(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.xj = jSONObject;
        this.hf = jSONObject2;
        this.w = new com.bytedance.sdk.component.adexpress.dynamic.w.w(jSONObject2);
        this.u = xj.xj(jSONObject3);
        this.y = com.bytedance.sdk.component.adexpress.dynamic.w.u.xj(jSONObject4);
    }

    private void hf(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        com.bytedance.sdk.component.adexpress.dynamic.w.w wVar;
        Object xj2;
        Object xj3;
        Object xj4;
        Object xj5;
        if (fVar == null || (wVar = this.w) == null || (xj2 = wVar.xj("image.0.url")) == null) {
            return;
        }
        String valueOf = String.valueOf(xj2);
        if (TextUtils.isEmpty(valueOf) || (xj3 = this.w.xj("title")) == null) {
            return;
        }
        String valueOf2 = String.valueOf(xj3);
        if (TextUtils.isEmpty(valueOf2) || (xj4 = this.w.xj("description")) == null) {
            return;
        }
        String valueOf3 = String.valueOf(xj4);
        if (TextUtils.isEmpty(valueOf3) || (xj5 = this.w.xj("icon")) == null) {
            return;
        }
        String valueOf4 = String.valueOf(xj5);
        if (TextUtils.isEmpty(valueOf4)) {
            return;
        }
        Object xj6 = this.w.xj("app.app_name");
        Object xj7 = this.w.xj(n.l);
        if (xj6 == null && xj7 == null) {
            return;
        }
        if (xj6 == null) {
            xj6 = xj7;
        }
        String valueOf5 = String.valueOf(xj6);
        if (TextUtils.isEmpty(valueOf5)) {
            return;
        }
        fVar.xj("imageUrl", valueOf);
        fVar.xj("title", valueOf2);
        fVar.xj("description", valueOf3);
        fVar.xj("icon", valueOf4);
        fVar.xj("app_name", valueOf5);
        fVar.xj(true);
    }

    private static /* synthetic */ void ioJVr() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.w.f xj(double d, int i, double d2, String str, g gVar) {
        JSONObject jSONObject;
        this.w.xj();
        try {
            jSONObject = new JSONObject(this.y.hf);
        } catch (JSONException e) {
            pl.xj(e);
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.w.f xj2 = xj(u.xj(this.xj, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.w.f) null);
        xj(xj2);
        kd kdVar = new kd(d, i, d2, str, gVar);
        kd.xj xjVar = new kd.xj();
        xj xjVar2 = this.u;
        xjVar.xj = xjVar2.xj;
        xjVar.hf = xjVar2.hf;
        xjVar.w = 0.0f;
        kdVar.xj(xjVar);
        kdVar.xj(xj2, 0.0f, 0.0f);
        kdVar.xj();
        com.bytedance.sdk.component.adexpress.dynamic.w.hf hfVar = kdVar.xj;
        if (hfVar.u == 65536.0f) {
            return null;
        }
        return hfVar.y;
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        int xj2;
        if (fVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w() != null) {
            xj2 = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().qt();
        } else {
            xj2 = com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext());
        }
        int hf = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), xj2);
        xj xjVar = this.u;
        float min = xjVar.w ? xjVar.xj : Math.min(xjVar.xj, hf);
        if (this.u.hf == 0.0f) {
            fVar.kd(min);
            fVar.tf().kd().tf(LiveConfigKey.AUTO);
            fVar.y(0.0f);
        } else {
            fVar.kd(min);
            int hf2 = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), com.bytedance.sdk.component.adexpress.u.f.w(com.bytedance.sdk.component.adexpress.u.getContext()));
            xj xjVar2 = this.u;
            fVar.y(xjVar2.w ? xjVar2.hf : Math.min(xjVar2.hf, hf2));
            fVar.tf().kd().tf("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.w.f xj(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.w.f fVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(PointParamKey.TYPE);
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt("componentId");
            if (this.y != null) {
                w wVar = new w();
                this.kd = wVar;
                JSONObject xj2 = wVar.xj(this.y.xj, optInt, jSONObject);
                if (xj2 != null) {
                    jSONObject = xj2;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.w.f xj3 = xj(jSONObject);
        xj3.xj(fVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            xj3.xj((List<com.bytedance.sdk.component.adexpress.dynamic.w.f>) null);
            return xj3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(optString, "tag-group")) {
                    length = xj3.tf().kd().ss();
                } else {
                    length = optJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.w.f xj4 = xj(optJSONArray2.optJSONObject(i2), xj3);
                    if (com.bytedance.sdk.component.adexpress.u.xj() && "skip-with-time".equals(xj3.tf().getType()) && !"transparent".equals(xj3.ra()) && !TextUtils.isEmpty(xj3.ra())) {
                        xj4.w(xj3.ra());
                    }
                    arrayList.add(xj4);
                    arrayList3.add(xj4);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            xj3.xj(arrayList);
        }
        if (arrayList2.size() > 0) {
            xj3.hf(arrayList2);
        }
        return xj3;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.w.f xj(JSONObject jSONObject) {
        String xj2;
        JSONObject jSONObject2;
        String optString = jSONObject.optString(PointParamKey.TYPE);
        String optString2 = jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        d.xj(optString, optJSONObject);
        JSONObject xj3 = d.xj(optString, d.xj(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.w.f fVar = new com.bytedance.sdk.component.adexpress.dynamic.w.f();
        if (TextUtils.isEmpty(optString2)) {
            fVar.hf(String.valueOf(fVar.hashCode()));
        } else {
            fVar.hf(optString2);
        }
        if (optJSONObject != null) {
            hf(fVar);
            fVar.w((float) optJSONObject.optDouble("x"));
            fVar.u((float) optJSONObject.optDouble("y"));
            fVar.kd((float) optJSONObject.optDouble(MediaFormat.KEY_WIDTH));
            fVar.y((float) optJSONObject.optDouble(MediaFormat.KEY_HEIGHT));
            fVar.c(optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.w.kd kdVar = new com.bytedance.sdk.component.adexpress.dynamic.w.kd();
            kdVar.xj(optString);
            kdVar.hf(optJSONObject.optString(PointParamKey.DATA));
            kdVar.w(optJSONObject.optString("filterData"));
            kdVar.u(optJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.w.y xj4 = com.bytedance.sdk.component.adexpress.dynamic.w.y.xj(optJSONObject);
            kdVar.xj(xj4);
            com.bytedance.sdk.component.adexpress.dynamic.w.y xj5 = com.bytedance.sdk.component.adexpress.dynamic.w.y.xj(xj3);
            if (xj5 == null) {
                kdVar.hf(xj4);
            } else {
                kdVar.hf(xj5);
            }
            xj(xj4);
            xj(xj5);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.hf) != null) {
                xj(kdVar, jSONObject2.optInt("image_mode"));
            }
            String type = kdVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.w.y kd = kdVar.kd();
            if (c.containsKey(type) && !kd.tu()) {
                kd.jk(c.get(type));
            }
            if (kd.tu()) {
                xj2 = kdVar.hf();
            } else {
                xj2 = xj(kdVar.hf());
            }
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    xj2 = xj("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    xj2 = xj("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && xj4.mg()) {
                    xj2 = xj("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(xj()) && (TextUtils.equals("logo-union", optString) || TextUtils.equals("logo", optString))) {
                StringBuilder A5SV6n2 = AYUAbz.A5SV6n(xj2, "adx:");
                A5SV6n2.append(xj());
                kdVar.hf(A5SV6n2.toString());
            } else {
                kdVar.hf(xj2);
            }
            kdVar.w(xj(kdVar.w()));
            fVar.xj(kdVar);
        }
        return fVar;
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.kd kdVar, int i) {
        int lastIndexOf;
        if (i != 5 && i != 15 && i != 50 && i != 154) {
            kdVar.xj("image");
            String xj2 = d.xj("image");
            com.bytedance.sdk.component.adexpress.dynamic.w.y kd = kdVar.kd();
            kd.jk(xj2);
            kdVar.c().jk(xj2);
            String xj3 = d.xj("image", "clickArea");
            if (!TextUtils.isEmpty(xj3)) {
                kd.qt(xj3);
                kdVar.c().qt(xj3);
            }
            JSONObject ci = kd.ci();
            if (ci != null) {
                kd.ra(ci.optString("imageLottieTosPath"));
                kd.pl(ci.optBoolean("animationsLoop"));
                kd.io(ci.optInt("lottieAppNameMaxLength"));
                kd.ai(ci.optInt("lottieAdDescMaxLength"));
                kd.x(ci.optInt("lottieAdTitleMaxLength"));
            }
            kdVar.hf(xj2);
            if (xj2 != null && (lastIndexOf = xj2.lastIndexOf(".")) > 0) {
                String substring = xj2.substring(0, lastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MediaFormat.KEY_WIDTH, xj(substring + ".width"));
                    jSONObject.put(MediaFormat.KEY_HEIGHT, xj(substring + ".height"));
                } catch (JSONException e) {
                    pl.xj(e);
                }
                kdVar.u(jSONObject.toString());
            }
            kd.ol();
            return;
        }
        kdVar.xj("video");
        String xj4 = d.xj("video");
        kdVar.kd().jk(xj4);
        String xj5 = d.xj("video", "clickArea");
        if (!TextUtils.isEmpty(xj5)) {
            kdVar.kd().qt(xj5);
            kdVar.c().qt(xj5);
        }
        kdVar.c().jk(xj4);
        kdVar.hf(xj4);
        kdVar.kd().uf();
    }

    private String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.w.hf(str2)) {
                String valueOf = String.valueOf(this.w.xj(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private String xj() {
        com.bytedance.sdk.component.adexpress.dynamic.w.w wVar = this.w;
        if (wVar == null) {
            return "";
        }
        return String.valueOf(wVar.xj("adx_name"));
    }

    private void xj(com.bytedance.sdk.component.adexpress.dynamic.w.y yVar) {
        if (yVar == null) {
            return;
        }
        String q = yVar.q();
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            String u = com.bytedance.sdk.component.adexpress.u.f.u(com.bytedance.sdk.component.adexpress.u.getContext());
            if ("zh".equals(u)) {
                u = "cn";
            }
            if (!TextUtils.isEmpty(u) && yVar.y() != null) {
                String optString = yVar.y().optString(u);
                if (!TextUtils.isEmpty(optString)) {
                    q = optString;
                }
            }
        }
        if (TextUtils.isEmpty(q)) {
            return;
        }
        int indexOf = q.indexOf("{{");
        int indexOf2 = q.indexOf("}}");
        if (indexOf >= 0 && indexOf2 >= 0 && indexOf2 >= indexOf) {
            String xj2 = xj(q.substring(indexOf + 2, indexOf2));
            StringBuilder sb = new StringBuilder(q.substring(0, indexOf));
            if (!TextUtils.isEmpty(xj2)) {
                sb.append(xj2);
            }
            sb.append(q.substring(indexOf2 + 2));
            yVar.pl(sb.toString());
            return;
        }
        yVar.pl(q);
    }
}
