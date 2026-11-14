package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import android.content.Context;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa {

    public class aaaaaaaa implements Runnable {
        final /* synthetic */ HashMap aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;

        public aaaaaaaa(String str, HashMap hashMap) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaaa, this.aaaaaaa0, true);
            } catch (Exception unused) {
            }
        }
    }

    public static void aaaaaaaa(JSONArray jSONArray, String str, aaaaaaaa.aaaaaaau aaaaaaauVar) {
        HashMap hashMap;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ADHandler_youdao", str + ";url=" + optString);
                JSONObject aaaaaaao = aaaaaaauVar.aaaaaaao();
                if (aaaaaaao != null && aaaaaaao.has("ua") && aaaaaaao.optString("ua").equalsIgnoreCase("webview")) {
                    hashMap = new HashMap();
                    hashMap.put("User-Agent", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ua-webview"));
                } else {
                    hashMap = null;
                }
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaaa(optString, hashMap));
            }
        }
    }

    public static void aaaaaaac(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        JSONObject aaaaaaau = aaaaaaauVar.aaaaaaau();
        if (aaaaaaau != null) {
            aaaaaaaa(aaaaaaau.optJSONArray("clktrackers"), "clktrackers", aaaaaaauVar);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(context, aaaaaaauVar, str);
    }

    public static void aaaaaaan(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        JSONObject aaaaaaau = aaaaaaauVar.aaaaaaau();
        if (aaaaaaau != null) {
            aaaaaaaa(aaaaaaau.optJSONArray("imptracker"), "imptracker", aaaaaaauVar);
        }
    }

    public static void aaaaaaau(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str) {
        JSONObject aaaaaaau = aaaaaaauVar.aaaaaaau();
        if (aaaaaaau != null) {
            aaaaaaaa(aaaaaaau.optJSONArray("dptrackers"), "dptrackers", aaaaaaauVar);
        }
    }
}
