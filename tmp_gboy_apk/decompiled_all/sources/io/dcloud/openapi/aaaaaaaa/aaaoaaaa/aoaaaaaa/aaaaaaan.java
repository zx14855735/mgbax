package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import android.content.Context;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaan extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa {

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
                String optString = jSONArray.optJSONObject(i).optString("url");
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
            aaaaaaaa(aaaaaaau.optJSONArray("clktracker"), "clktracker", aaaaaaauVar);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(context, aaaaaaauVar, str);
    }

    public static void aaaaaaaa(Context context, aaaaaaaa.aaaaaaau aaaaaaauVar, String str, String str2) {
        JSONObject aaaaaaau = aaaaaaauVar.aaaaaaau();
        if (aaaaaaau != null) {
            aaaaaaaa(aaaaaaau.optJSONArray(str2), str2, aaaaaaauVar);
        }
    }
}
