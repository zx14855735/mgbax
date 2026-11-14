package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.C;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa {

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public class RunnableC0543aaaaaaa0 implements Runnable {
        final /* synthetic */ Context aaaaaaa0;
        final /* synthetic */ aaaaaaaa.aaaaaaau aaaaaaaa;
        final /* synthetic */ String aaaaaaao;

        public RunnableC0543aaaaaaa0(aaaaaaaa.aaaaaaau aaaaaaauVar, Context context, String str) {
            this.aaaaaaaa = aaaaaaauVar;
            this.aaaaaaa0 = context;
            this.aaaaaaao = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String optString = this.aaaaaaaa.aaaaaaa0().optString("url");
            String optString2 = this.aaaaaaaa.aaaaaaa0().optString("tid");
            Context context = this.aaaaaaa0;
            aaaaaaaa.aaaaaaau aaaaaaauVar = this.aaaaaaaa;
            aaaaaaa0.aaaaaaa0(context, aaaaaaauVar, optString, aaaaaaauVar.aaaaaaav, optString2, this.aaaaaaao, aaaaaaauVar.aaaaaaao());
        }
    }

    public class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao {
        final /* synthetic */ Context aaaaaaa0;
        final /* synthetic */ aaaaaaaa.aaaaaaau aaaaaaaa;
        final /* synthetic */ String aaaaaaao;

        public aaaaaaaa(aaaaaaaa.aaaaaaau aaaaaaauVar, Context context, String str) {
            this.aaaaaaaa = aaaaaaauVar;
            this.aaaaaaa0 = context;
            this.aaaaaaao = str;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao
        public Object aaaaaaaa(int i, Object obj) {
            JSONObject optJSONObject = ((JSONObject) obj).optJSONObject(PointParamKey.DATA);
            String optString = optJSONObject.optString("dstlink");
            String optString2 = optJSONObject.optString("clickid");
            String optString3 = this.aaaaaaaa.aaaaaaa0().optString("tid");
            try {
                this.aaaaaaaa.aaaaaaao().put(AdBaseConstants.MARKET_OPEN_CLICK_ID, optString2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Context context = this.aaaaaaa0;
            aaaaaaaa.aaaaaaau aaaaaaauVar = this.aaaaaaaa;
            aaaaaaa0.aaaaaaa0(context, aaaaaaauVar, optString, aaaaaaauVar.aaaaaaav, optString3, this.aaaaaaao, aaaaaaauVar.aaaaaaao());
            if (this.aaaaaaaa.aaaaaaac()) {
                return null;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaaa(this.aaaaaaa0);
            return null;
        }
    }

    public class aaaaaaac implements Runnable {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ boolean aaaaaaaa;
        final /* synthetic */ String aaaaaaac;
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao aaaaaaae;
        final /* synthetic */ int aaaaaaan;
        final /* synthetic */ String aaaaaaao;
        final /* synthetic */ boolean aaaaaaau;

        public aaaaaaac(boolean z, int i, String str, String str2, boolean z2, int i2, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao aaaaaaaoVar) {
            this.aaaaaaaa = z;
            this.aaaaaaa0 = i;
            this.aaaaaaao = str;
            this.aaaaaaac = str2;
            this.aaaaaaau = z2;
            this.aaaaaaan = i2;
            this.aaaaaaae = aaaaaaaoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            byte[] bArr = null;
            if (this.aaaaaaaa) {
                hashMap = new HashMap();
                hashMap.put("User-Agent", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ua-webview"));
            } else {
                hashMap = null;
            }
            int i = this.aaaaaaa0;
            if (i == 0) {
                try {
                    bArr = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaao, hashMap, true);
                } catch (Exception unused) {
                }
            } else if (i == 1) {
                bArr = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaao, this.aaaaaaac, hashMap);
            }
            if (!this.aaaaaaau || bArr == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (jSONObject.optInt("ret") == 0) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao aaaaaaaoVar = this.aaaaaaae;
                    if (aaaaaaaoVar != null) {
                        aaaaaaaoVar.aaaaaaaa(1, jSONObject);
                        return;
                    }
                    return;
                }
                String optString = jSONObject.optString(br.c);
                aaaaaaa0.aaaaaaa0("handleTrackers_wanka Runnable Error url=" + this.aaaaaaao + ";msg=" + optString);
                int i2 = this.aaaaaaan;
                if (i2 > 0) {
                    aaaaaaa0.aaaaaaa0(this.aaaaaaao, optString, this.aaaaaaa0, i2, this.aaaaaaau, this.aaaaaaae, null, this.aaaaaaaa);
                }
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaao, hashMap, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class aaaaaaao implements Runnable {
        final /* synthetic */ aaaaaaaa.aaaaaaau aaaaaaa0;
        final /* synthetic */ JSONArray aaaaaaaa;
        final /* synthetic */ Context aaaaaaao;

        public aaaaaaao(JSONArray jSONArray, aaaaaaaa.aaaaaaau aaaaaaauVar, Context context) {
            this.aaaaaaaa = jSONArray;
            this.aaaaaaa0 = aaaaaaauVar;
            this.aaaaaaao = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.aaaaaaaa != null) {
                for (int i = 0; i < this.aaaaaaaa.length(); i++) {
                    try {
                        JSONObject optJSONObject = this.aaaaaaaa.optJSONObject(i);
                        int optInt = optJSONObject.optInt("template_type");
                        JSONObject aaaaaaao = this.aaaaaaa0.aaaaaaao();
                        boolean z = aaaaaaao.has("ua") && aaaaaaao.optString("ua").equalsIgnoreCase("webview");
                        aaaaaaao.put("u-a", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ua-webview"));
                        String aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(optJSONObject.optString("url"), aaaaaaao);
                        int optInt2 = optJSONObject.optInt("http_method");
                        String optString = optJSONObject.optString(IAdInterListener.AdProdType.PRODUCT_CONTENT);
                        if (optInt != 1) {
                            aaaaaaa0.aaaaaaa0(aaaaaaaa, optString, optInt2, 2, false, null, "clktrackers", z);
                        } else if (this.aaaaaaa0.aaaaaaac()) {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaao, aaaaaaaa);
                        } else {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaau(this.aaaaaaao, aaaaaaaa);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aaaaaaa0(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str, String str2, String str3, String str4, JSONObject jSONObject) {
    }

    public static void aaaaaaac(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        int optInt = aaaaaaauVar.aaaaaaa0().optInt(ClickCommon.CLICK_SCENE_TEMPLATE, 0);
        String optString = aaaaaaauVar.aaaaaaa0().optString("action");
        if (optInt == 1) {
            if (aaaaaaauVar.aaaaaaac()) {
                return;
            }
            JSONArray optJSONArray = aaaaaaauVar.aaaaaaau().optJSONArray("clktrackers");
            if ("download".equals(optString)) {
                aaaaaaaa(optJSONArray, aaaaaaauVar.aaaaaaao(), new aaaaaaaa(aaaaaaauVar, context, str), "clktrackers");
                return;
            } else {
                if ("url".equals(optString)) {
                    aaaaaaaa(context, aaaaaaauVar, optJSONArray, aaaaaaauVar.aaaaaaav, str);
                    return;
                }
                return;
            }
        }
        JSONArray optJSONArray2 = aaaaaaauVar.aaaaaaau().optJSONArray("clktrackers");
        if (optJSONArray2 != null) {
            aaaaaaaa(optJSONArray2, aaaaaaauVar.aaaaaaao(), "clktrackers");
        }
        if (!"download".equals(optString)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(context, aaaaaaauVar, str);
            return;
        }
        String optString2 = aaaaaaauVar.aaaaaaa0().optString("bundle");
        if (TextUtils.isEmpty(optString2) || !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaaa(context, optString2)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new RunnableC0543aaaaaaa0(aaaaaaauVar, context, str));
            if (aaaaaaauVar.aaaaaaac()) {
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaaa(context);
            return;
        }
        if (aaaaaaauVar.aaaaaaac()) {
            return;
        }
        try {
            Intent parseUri = Intent.parseUri(aaaaaaauVar.aaaaaaa0().optString("dplk"), 1);
            parseUri.setFlags(C.ENCODING_PCM_MU_LAW);
            parseUri.setSelector(null);
            parseUri.setComponent(null);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            if (context.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                context.startActivity(parseUri);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void aaaaaaan(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        JSONObject aaaaaaau = aaaaaaauVar.aaaaaaau();
        if (aaaaaaau != null) {
            aaaaaaaa(aaaaaaau.optJSONArray("imptrackers"), aaaaaaauVar.aaaaaaao(), "imptrackers");
        }
    }

    public static void aaaaaaau(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        JSONArray optJSONArray = aaaaaaauVar.aaaaaaau().optJSONArray("dplktrackers");
        if (optJSONArray != null) {
            aaaaaaaa(optJSONArray, aaaaaaauVar.aaaaaaao(), "dplktrackers");
        }
    }

    public static void aaaaaaa0(String str) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("wanka", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aaaaaaa0(String str, String str2, int i, int i2, boolean z, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao aaaaaaaoVar, String str3, boolean z2) {
        int i3 = i2 - 1;
        aaaaaaa0(J3FDQU.A2egSU.B3GDIM(J3FDQU.A2egSU.B7CMnp(z ? 1 : 0, i3, "handleTrackers_wanka template = ", "; t_count=", "; tagMsg "), str3, ";  url=", str));
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaac(z2, i, str, str2, z, i3, aaaaaaaoVar));
    }

    private static void aaaaaaaa(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, JSONArray jSONArray, String str, String str2) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaao(jSONArray, aaaaaaauVar, context));
    }

    private static void aaaaaaaa(JSONArray jSONArray, JSONObject jSONObject, String str) {
        aaaaaaaa(jSONArray, jSONObject, (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao) null, str);
    }

    private static void aaaaaaaa(JSONArray jSONArray, JSONObject jSONObject, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaao aaaaaaaoVar, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            int optInt = optJSONObject.optInt("template_type");
            boolean z = jSONObject.has("ua") && jSONObject.optString("ua").equalsIgnoreCase("webview");
            try {
                jSONObject.put("u-a", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ua-webview"));
            } catch (JSONException unused) {
            }
            aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(optJSONObject.optString("url"), jSONObject), optJSONObject.optString(IAdInterListener.AdProdType.PRODUCT_CONTENT), optJSONObject.optInt("http_method"), 2, optInt == 1, aaaaaaaoVar, str, z);
        }
    }
}
