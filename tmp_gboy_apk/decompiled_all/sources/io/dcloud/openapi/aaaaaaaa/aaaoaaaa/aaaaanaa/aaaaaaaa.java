package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaan;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaae;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {

    public class aaaaaaa0 implements aaaaaaaa.aaaaaaa0 {
        final /* synthetic */ HashMap aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;
        final /* synthetic */ String[] aaaaaaao;

        public aaaaaaa0(String str, HashMap hashMap, String[] strArr) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = hashMap;
            this.aaaaaaao = strArr;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public boolean aaaaaaa0(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
            byte[] aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(c0530aaaaaaaa.aaaaaaaa(), this.aaaaaaaa, this.aaaaaaa0, this.aaaaaaao);
            if (aaaaaaaa == null) {
                return false;
            }
            String str = new String(aaaaaaaa, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            aaaaaaau.aaaaaaao("uniAD-Commit_A", str);
            return true;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0528aaaaaaaa extends ArrayList {
        public C0528aaaaaaaa() {
            addAll(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0.aaaaaaaa);
        }
    }

    public class aaaaaaac implements aaaaaaaa.aaaaaaa0 {
        final /* synthetic */ HashMap aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;

        public aaaaaaac(String str, HashMap hashMap) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = hashMap;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public boolean aaaaaaa0(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
            byte[] aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(c0530aaaaaaaa.aaaaaaaa(), this.aaaaaaaa, this.aaaaaaa0);
            if (aaaaaaaa == null) {
                return false;
            }
            String str = new String(aaaaaaaa, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            aaaaaaau.aaaaaaao("uniAD-Commit_F", str);
            return true;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
        }
    }

    public class aaaaaaao extends ArrayList {
        public aaaaaaao() {
            addAll(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0.aaaaaaan);
        }
    }

    private static Map aaaaaaa0(Context context, String str, String str2, int i, String str3, HashMap hashMap) {
        String str4;
        String str5;
        try {
            str4 = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str4 = "";
        }
        try {
            str5 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused2) {
            str5 = "";
        }
        String aaaaaaaa = aaaaaaav.aaaaaaaa(context, true, true);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(t.b, t.f);
        hashMap2.put("appid", str);
        hashMap2.put(t.c, str5);
        hashMap2.put("at", Integer.valueOf(i));
        hashMap2.put("psdk", Integer.valueOf(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaau()));
        hashMap2.put("os", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap2.put("adpid", str3);
        if (aaaaaaaa.endsWith("&ie=1")) {
            aaaaaaaa = aaaaaaaa.replace("&ie=1", "");
            hashMap2.put("ie", 1);
        } else if (aaaaaaaa.endsWith("&ie=0")) {
            aaaaaaaa = aaaaaaaa.replace("&ie=0", "");
            hashMap2.put("ie", 0);
        }
        hashMap2.put("imei", aaaaaaaa);
        hashMap2.put(LiveConfigKey.MEDIUM, str4);
        hashMap2.put("vd", Build.MANUFACTURER);
        hashMap2.put(TKDownloadReason.KSAD_TK_NET, aaaaaaeo.aaaaaaac(context));
        hashMap2.put("vb", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa());
        hashMap2.put(com.kwad.components.core.s.t.TAG, Long.valueOf(System.currentTimeMillis()));
        hashMap2.put("mc", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa(context));
        hashMap2.put("paid", str2);
        hashMap2.put("oaid", aaaaaaae.aaaaaaaa().aaaaaaaa(context));
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        return hashMap2;
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, int i, String str4) {
        aaaaaaaa(context, null, null, str2, str, str3, i, str4, null, null, null);
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, HashMap hashMap, String str7, String str8) {
        aaaaaaaa(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, hashMap, str7, str8, null, null);
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, HashMap hashMap, String str7, String str8, String str9, String str10) {
        aaaaaaaa(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, hashMap, str7, str8, str9, str10);
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, int i, String str4, String str5, JSONObject jSONObject, String str6, String str7, String str8, String str9, HashMap hashMap, String str10, String str11, String str12, String str13) {
        String str14;
        JSONObject optJSONObject;
        Map aaaaaaa02 = aaaaaaa0(context, str, str3, i, str8, hashMap);
        if (str10 != null) {
            aaaaaaa02.put("rid", str10);
        }
        if (str11 != null) {
            aaaaaaa02.put("cpm", str11);
        }
        if (str6 != null) {
            aaaaaaa02.put("mediaId", str6);
        }
        if (str12 != null) {
            aaaaaaa02.put("csv", str12);
        }
        if (str13 != null) {
            aaaaaaa02.put("cav", str13);
        }
        if (str7 != null) {
            aaaaaaa02.put("slotId", str7);
        }
        if (i == 32) {
            aaaaaaa02.put("dec", str4);
            aaaaaaa02.put("dem", str5);
        }
        if (i == 41 && jSONObject != null && str6 == null) {
            if (jSONObject.has("img")) {
                aaaaaaa02.put("img", aaaaaaan.aaaaaaaa(jSONObject.optString("img")).toLowerCase(Locale.ENGLISH));
            }
            if (jSONObject.has("dw")) {
                aaaaaaa02.put("dw", jSONObject.optString("dw"));
            }
            if (jSONObject.has("dh")) {
                aaaaaaa02.put("dh", jSONObject.optString("dh"));
            }
            if (jSONObject.has("click_coord") && (optJSONObject = jSONObject.optJSONObject("click_coord")) != null) {
                aaaaaaa02.put("click_coord", optJSONObject.toString());
            }
        }
        aaaaaaa02.put("tid", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        try {
            str14 = URLEncoder.encode(Base64.encodeToString(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(new JSONObject(aaaaaaa02).toString()), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaa0(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaaa()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str14 = null;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context, new C0528aaaaaaaa(), CtFAbx.ARc23Z(i, "CAA_"), new aaaaaaa0(CtFAbx.BChYOn("edata=", str14), hashMap2, new String[1]));
    }

    public static void aaaaaaaa(Context context, String str, String str2, int i, String str3, HashMap hashMap) {
        String str4;
        try {
            str4 = URLEncoder.encode(Base64.encodeToString(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(new JSONObject(aaaaaaa0(context, str, str2, i, str3, hashMap)).toString()), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaa0(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaaa()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str4 = null;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context, new aaaaaaao(), "RSP", new aaaaaaac(CtFAbx.BChYOn("edata=", str4), A2egSU.BI9f7h("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")));
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8) {
        String str9;
        String str10;
        String str11 = "";
        try {
            str9 = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str9 = "";
        }
        try {
            str11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused2) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put(t.b, t.f);
        hashMap.put("appid", str);
        hashMap.put(t.c, str11);
        hashMap.put("psdk", Integer.valueOf(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaau()));
        hashMap.put("os", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("adpid", str2);
        hashMap.put(LiveConfigKey.MEDIUM, str9);
        hashMap.put("vd", Build.MANUFACTURER);
        hashMap.put("vb", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa());
        hashMap.put(com.kwad.components.core.s.t.TAG, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("mc", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa(context));
        hashMap.put("paid", str3);
        if (str4 != null) {
            hashMap.put("mediaId", str4);
        }
        if (str5 != null) {
            hashMap.put("slotId", str5);
        }
        if (str8 != null) {
            hashMap.put("rid", str8);
            aaaaaaau.aaaaaaa0("uniad", str8);
        }
        hashMap.put("gcpm", str6);
        hashMap.put("currency", str7);
        hashMap.put("pt", Integer.valueOf(i));
        try {
            str10 = URLEncoder.encode(Base64.encodeToString(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(new JSONObject(hashMap).toString()), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaa0(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau.aaaaaaaa()), 2), "utf-8");
        } catch (UnsupportedEncodingException unused3) {
            str10 = null;
        }
        byte[] aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0.aaaaaaae.aaaaaaaa(), CtFAbx.BChYOn("edata=", str10), A2egSU.BI9f7h("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"));
        if (aaaaaaaa != null) {
            String str12 = new String(aaaaaaaa, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str12)) {
                return;
            }
            aaaaaaau.aaaaaaao("uniAD-Commit_P", str12);
        }
    }
}
