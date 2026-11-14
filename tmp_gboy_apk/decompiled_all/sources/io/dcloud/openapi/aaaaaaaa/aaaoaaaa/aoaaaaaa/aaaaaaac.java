package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaac {
    private Context aaaaaaa0;
    aaaaaaaa.aaaaaaau aaaaaaaa = null;
    JSONObject aaaaaaac;
    Handler aaaaaaao;

    public class aaaaaaa0 implements Runnable {
        public aaaaaaa0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aaaaaaac aaaaaaacVar = aaaaaaac.this;
            aaaaaaacVar.aaaaaaaa = aaaaaaacVar.aaaaaaaa(aaaaaaacVar.aaaaaaac);
            aaaaaaaa.aaaaaaau aaaaaaauVar = aaaaaaac.this.aaaaaaaa;
            if (aaaaaaauVar != null) {
                String optString = aaaaaaauVar.aaaaaaao() != null ? aaaaaaac.this.aaaaaaaa.aaaaaaao().optString("ua") : "";
                aaaaaaac aaaaaaacVar2 = aaaaaaac.this;
                aaaaaaacVar2.aaaaaaaa(aaaaaaacVar2.aaaaaaaa.aaaaaaae, optString);
            }
        }
    }

    public class aaaaaaaa extends Handler {
        public aaaaaaaa(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 10000) {
                return;
            }
            aaaaaaac.this.aaaaaaao();
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaac$aaaaaaac, reason: collision with other inner class name */
    public class RunnableC0546aaaaaaac implements Runnable {
        public RunnableC0546aaaaaaac() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aaaaaaac.this.aaaaaaaa();
        }
    }

    public class aaaaaaao implements Runnable {
        final /* synthetic */ String aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;

        public aaaaaaao(String str, String str2) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.aaaaaaaa) && this.aaaaaaaa.equalsIgnoreCase("webview")) {
                hashMap.put("User-Agent", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("ua-webview"));
            }
            try {
                if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaa0, hashMap, true) != null) {
                    aaaaaaac.this.aaaaaaao.sendEmptyMessage(10000);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class aaaaaaau implements aaaaaaaa.InterfaceC0539aaaaaaaa {
        final /* synthetic */ String aaaaaaa0;
        final /* synthetic */ Context aaaaaaaa;
        final /* synthetic */ String aaaaaaac;
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0 aaaaaaan;
        final /* synthetic */ String aaaaaaao;
        final /* synthetic */ String aaaaaaau;

        public aaaaaaau(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaac aaaaaaacVar, Context context, String str, String str2, String str3, String str4, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0 aaaaaaa0Var) {
            this.aaaaaaaa = context;
            this.aaaaaaa0 = str;
            this.aaaaaaao = str2;
            this.aaaaaaac = str3;
            this.aaaaaaau = str4;
            this.aaaaaaan = aaaaaaa0Var;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa.InterfaceC0539aaaaaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar) {
            aaaaaaac.aaaaaaa0(this.aaaaaaaa, this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac, this.aaaaaaau, 32);
            File file = new File(aaaaaaaaVar.aaaaaaa0());
            if (file.exists()) {
                file.delete();
            }
            this.aaaaaaan.aaaaaaa0(aaaaaaaaVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa.InterfaceC0539aaaaaaaa
        public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar) {
            aaaaaaaaVar.aaaaaaaa();
            throw null;
        }
    }

    public aaaaaaac(Context context, JSONObject jSONObject) {
        this.aaaaaaao = null;
        this.aaaaaaac = jSONObject;
        this.aaaaaaa0 = context;
        this.aaaaaaao = new aaaaaaaa(context.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaao() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "ADSim---view");
        Context context = this.aaaaaaa0;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaao(context, this.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, "adid"));
        aaaaaaa0();
    }

    public void aaaaaaac() {
        this.aaaaaaao.postDelayed(new aaaaaaa0(), aaaaaaaa(MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM, 350));
    }

    private void aaaaaaa0() {
        if (this.aaaaaaaa.aaaaaaac()) {
            this.aaaaaaao.postDelayed(new RunnableC0546aaaaaaac(), aaaaaaaa(800, 2000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aaaaaaa0(Context context, String str, String str2, String str3, String str4, int i) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new A2egSU(context, str, str2, str3, i, str4, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaaa(String str, String str2) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaao(str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aaaaaaaa.aaaaaaau aaaaaaaa(JSONObject jSONObject) {
        aaaaaaaa.aaaaaaau aaaaaaauVar = new aaaaaaaa.aaaaaaau();
        JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
        if (optJSONObject != null) {
            aaaaaaauVar.aaaaaaao = jSONObject.optString("provider");
            aaaaaaauVar.aaaaaaac = jSONObject;
            aaaaaaauVar.aaaaaaeo = jSONObject.optInt("es", 0);
            aaaaaaauVar.aaaeaaaa = jSONObject.optInt("ec", 0);
            aaaaaaauVar.aaaaaaae = optJSONObject.optString("src");
            aaaaaaauVar.aaaaaaau = "000";
            aaaaaaauVar.aaaaaaav = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("appid");
        }
        return aaaaaaauVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaaa() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "ADSim---click");
        Context context = this.aaaaaaa0;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, this.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(context, "adid"));
    }

    public static int aaaaaaaa(int i, int i2) {
        return (int) ((Math.random() * ((i2 - i) + 1)) + i);
    }

    public static void aaaaaaaa(Context context, String str) {
        new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaau(context).aaaaaaaa(str);
    }

    public static void aaaaaaaa(Context context, String str, String str2, String str3, String str4, String str5, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaac aaaaaaacVar, String str6, String str7) {
        aaaaaaa0(context, str, str2, str3, str7, 29);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0 aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0.aaaaaaaa(context.getApplicationContext());
        String absolutePath = context.getExternalFilesDir(null).getAbsolutePath();
        StringBuilder A4TApA2 = AYUAbz.A4TApA(absolutePath);
        A4TApA2.append(absolutePath.endsWith("/") ? "" : "/");
        String AcNBzu2 = CtFAbx.AcNBzu(A4TApA2.toString(), "/Download/ADSIM-INFO.io");
        File file = new File(AcNBzu2);
        if (file.exists()) {
            file.delete();
        }
        for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar : aaaaaaaa2.aaaaaaaa()) {
            if (aaaaaaaaVar.aaaaaaao().equals(str4)) {
                aaaaaaaa2.aaaaaaa0(aaaaaaaaVar);
            }
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa();
        aaaaaaaaVar2.aaaaaaaa(context, str4, AcNBzu2);
        aaaaaaaaVar2.aaaaaaaa(new aaaaaaau(aaaaaaacVar, context, str, str2, str3, str7, aaaaaaaa2));
        aaaaaaaa2.aaaaaaaa(aaaaaaaaVar2);
    }
}
