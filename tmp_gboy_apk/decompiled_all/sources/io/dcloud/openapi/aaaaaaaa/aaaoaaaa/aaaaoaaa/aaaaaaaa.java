package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.sigmob.sdk.base.mta.PointCategory;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa {
    private String aaaaaaae;
    private String aaaaaaan;
    ExecutorService aaaaaaau;
    private String aaaaaaav;
    private String aaaaaaea;
    private String aaaaaaeo;
    private HashMap aaaaaeaa;
    private JSONObject aaaaeaaa;
    private String aaaeaaaa;
    private String eaaaaaaa;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class RunnableC0534aaaaaaaa implements Runnable {
        final /* synthetic */ String aaaaaaaa;

        public RunnableC0534aaaaaaaa(String str) {
            this.aaaaaaaa = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr = new String[1];
            byte[] aaaaaaaa = aaaaaaac.aaaaaaaa(aaaaaaaa.this.aaaaaaae, this.aaaaaaaa, aaaaaaaa.this.aaaaaeaa, strArr);
            if (aaaaaaaa == null) {
                aaaaaaaa aaaaaaaaVar = aaaaaaaa.this;
                String str = strArr[0];
                if (str == null) {
                    str = "data null";
                }
                aaaaaaaaVar.aaaaaaaa(60003, "网络请求失败：".concat(str));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(aaaaaaaa));
                aaaaaaa0 aaaaaaa0Var = new aaaaaaa0();
                aaaaaaa0Var.aaaaaaao(aaaaaaaa.this.aaaaaaa0());
                jSONObject.put("appid", aaaaaaaa.this.aaaaaaan);
                jSONObject.put("adpid", ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa) aaaaaaaa.this).aaaaaaao);
                jSONObject.put("tid", aaaaaaaa.this.aaaaaaav);
                jSONObject.put("did", aaaaaaaa.this.aaaaaaea);
                jSONObject.put("adid", aaaaaaaa.this.eaaaaaaa);
                aaaaaaa0Var.aaaaaaaa(jSONObject, new C0535aaaaaaaa(aaaaaaa0Var), true);
            } catch (JSONException e) {
                aaaaaaaa.this.aaaaaaaa(60006, e.getMessage());
            }
        }

        /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa$aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
        public class C0535aaaaaaaa implements aaaaaaa0.aaaaaaau {
            final /* synthetic */ aaaaaaa0 aaaaaaaa;

            public C0535aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
                this.aaaaaaaa = aaaaaaa0Var;
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0.aaaaaaau
            public void aaaaaaaa() {
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa) aaaaaaaa.this).aaaaaaac = this.aaaaaaaa;
                aaaaaaaa.this.aaaaaaaa();
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0.aaaaaaau
            public void aaaaaaaa(int i, String str) {
                try {
                    for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaaa aaaaaaaaVar : aaaaaaav.aaaaaaaa().aaaaaaa0(aaaaaaaa.this.aaaaaaa0()).values()) {
                        if (!aaaaaaaaVar.aaaaaaa0()) {
                            aaaaaaa0 aaaaaaa0Var = new aaaaaaa0();
                            aaaaaaaaVar.aaaaaaaa(aaaaaaaa.this.aaaaaaa0(), aaaaaaa0Var);
                            if (aaaaaaa0Var.eaaaaaaa() && aaaaaaa0Var.aaaaaaea() && aaaaaaa0Var.aaaaaaao().equals(aaaaaaaa.this.aaaaaaan) && aaaaaaa0Var.aaaeaaaa().equals(aaaaaaaa.this.aaaaaaav) && ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa) aaaaaaaa.this).aaaaaaac == null) {
                                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa) aaaaaaaa.this).aaaaaaac = aaaaaaa0Var;
                                aaaaaaaa.this.aaaaaaaa();
                                return;
                            }
                        } else {
                            aaaaaaav.aaaaaaaa().aaaaaaa0(aaaaaaaa.this.aaaaaaa0(), aaaaaaaaVar.aaaaaaaa());
                        }
                    }
                } catch (Exception unused) {
                }
                aaaaaaaa.this.aaaaaaaa(i, str);
            }
        }
    }

    public aaaaaaaa(aaaaaaaa.aaaaaaao aaaaaaaoVar, Context context, String str, String str2, String str3, String str4) {
        this(aaaaaaaoVar, context, str2);
        this.aaaaaaeo = str3;
        this.aaaeaaaa = str4;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aaaaaaea = jSONObject.optString("did");
            this.eaaaaaaa = jSONObject.optString("adid");
            this.aaaaaaae = jSONObject.optString("url");
            JSONObject optJSONObject = jSONObject.optJSONObject(PointCategory.APP);
            this.aaaaeaaa = optJSONObject;
            this.aaaaaaan = optJSONObject.optString(PluginConstants.KEY_APP_ID);
            this.aaaaaaav = jSONObject.optString("tid");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
            if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
                return;
            }
            this.aaaaaeaa = new HashMap();
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.aaaaaeaa.put(next, optJSONObject2.optString(next));
            }
        } catch (JSONException unused) {
        }
    }

    public void aaaaaaao() {
        if (TextUtils.isEmpty(this.aaaaaaae)) {
            aaaaaaaa(60001, "广告请求地址出错");
            return;
        }
        JSONObject jSONObject = this.aaaaeaaa;
        if (jSONObject != null && jSONObject.length() > 0) {
            if (!TextUtils.isEmpty(this.aaaaaaao)) {
                try {
                    this.aaaaeaaa.put("adp_id", this.aaaaaaao);
                } catch (JSONException unused) {
                }
            }
            JSONObject aaaaaaaa = aaaaaaeo.aaaaaaaa(aaaaaaa0());
            try {
                aaaaaaaa.put(PointCategory.APP, this.aaaaeaaa);
            } catch (JSONException unused2) {
            }
            String jSONObject2 = aaaaaaaa.toString();
            if ("1".equals(this.aaaaaaeo)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(this.aaaeaaaa);
                    jSONObject3.optString("method");
                    String encodeToString = Base64.encodeToString(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(jSONObject2), jSONObject3.optString("key"), jSONObject3.optString("iv")), 2);
                    try {
                        encodeToString = URLEncoder.encode(encodeToString, "utf-8");
                    } catch (UnsupportedEncodingException unused3) {
                    }
                    jSONObject2 = "edata=" + encodeToString;
                } catch (Exception unused4) {
                }
            } else {
                if (this.aaaaaeaa == null) {
                    this.aaaaaeaa = new HashMap();
                }
                if (!this.aaaaaeaa.containsKey("Content-Type")) {
                    this.aaaaaeaa.put("Content-Type", an.d);
                }
            }
            this.aaaaaaau.execute(new RunnableC0534aaaaaaaa(jSONObject2));
            return;
        }
        aaaaaaaa(60002, "广告配置异常");
    }

    private aaaaaaaa(aaaaaaaa.aaaaaaao aaaaaaaoVar, Context context, String str) {
        super(aaaaaaaoVar, context, str);
        this.aaaaaaau = Executors.newSingleThreadExecutor();
        this.aaaaaaan = "";
        this.aaaaaaae = "";
        this.aaaaaaeo = "";
        this.aaaeaaaa = "";
    }
}
