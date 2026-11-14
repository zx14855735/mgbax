package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao {

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public class C0527aaaaaaa0 implements aaaaaaaa.aaaaaaa0 {
        final /* synthetic */ aaaaaaao.aaaaaaaa[] aaaaaaa0;
        String[] aaaaaaaa = new String[1];
        final /* synthetic */ HashMap aaaaaaac;
        final /* synthetic */ String aaaaaaao;
        final /* synthetic */ Context aaaaaaau;

        public C0527aaaaaaa0(aaaaaaao.aaaaaaaa[] aaaaaaaaVarArr, String str, HashMap hashMap, Context context) {
            this.aaaaaaa0 = aaaaaaaaVarArr;
            this.aaaaaaao = str;
            this.aaaaaaac = hashMap;
            this.aaaaaaau = context;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public boolean aaaaaaa0(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
            byte[] aaaaaaaa = aaaaaaac.aaaaaaaa(c0530aaaaaaaa.aaaaaaaa(), this.aaaaaaao, this.aaaaaaac, this.aaaaaaaa);
            if (aaaaaaaa == null) {
                return false;
            }
            try {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa(new String(aaaaaaaa));
                if (aaaaaaaaVar.has("7C61656D")) {
                    aaaaaaa0.this.aaaaaaaa(aaaaaaaaVar, this.aaaaaaau);
                }
                if (!aaaaaaaaVar.has("6C697C69")) {
                    for (aaaaaaao.aaaaaaaa aaaaaaaaVar2 : this.aaaaaaa0) {
                        aaaaaaaaVar2.aaaaaaaa(-1, AOLErrorUtil.getErrorMsg(-5007));
                    }
                    return true;
                }
                aaaaaaaaVar.put("6C697C69", new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa(new String(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaaa(Base64.decode(aaaaaaaaVar.getString("6C697C69"), 2), aaaaaaau.aaaaaaa0(), aaaaaaau.aaaaaaaa()))));
                for (aaaaaaao.aaaaaaaa aaaaaaaaVar3 : this.aaaaaaa0) {
                    aaaaaaaaVar3.aaaaaaaa(aaaaaaaaVar);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                for (aaaaaaao.aaaaaaaa aaaaaaaaVar4 : this.aaaaaaa0) {
                    aaaaaaaaVar4.aaaaaaaa(-1, AOLErrorUtil.getErrorMsg(-5007));
                }
                return true;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(aaaaaaaa.C0530aaaaaaaa c0530aaaaaaaa) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa() {
            for (aaaaaaao.aaaaaaaa aaaaaaaaVar : this.aaaaaaa0) {
                aaaaaaaaVar.aaaaaaaa(-1, this.aaaaaaaa[0]);
            }
        }
    }

    public class aaaaaaaa extends ArrayList {
        final /* synthetic */ int aaaaaaaa;

        public aaaaaaaa(int i) {
            this.aaaaaaaa = i;
            addAll(i != 1 ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0.aaaaaaau : io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaa0.aaaaaaac);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaa0(Context context, int i, aaaaaaao.aaaaaaaa[] aaaaaaaaVarArr) {
        String str;
        String encodeToString = Base64.encodeToString(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa(aaaaaaao.aaaaaaaa(context)).toString()), aaaaaaau.aaaaaaa0(), aaaaaaau.aaaaaaaa()), 2);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaao("uniAd-msg", encodeToString);
        try {
            str = URLEncoder.encode(encodeToString, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str = null;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context, new aaaaaaaa(i), i != 1 ? "ThirdConfig" : ExploreConstants.SCENE_SPLASH, new C0527aaaaaaa0(aaaaaaaaVarArr, CtFAbx.BChYOn("edata=", str), A2egSU.BI9f7h("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"), context));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao
    public void aaaaaaaa(Context context, int i, aaaaaaao.aaaaaaaa... aaaaaaaaVarArr) {
        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0() != null && !TextUtils.isEmpty(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId()) && !TextUtils.isEmpty(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId())) {
            aaaaaaan.aaaaaaaa().aaaaaaaa(new FZu94u.A2egSU(this, context, i, aaaaaaaaVarArr));
            return;
        }
        for (aaaaaaao.aaaaaaaa aaaaaaaaVar : aaaaaaaaVarArr) {
            aaaaaaaaVar.aaaaaaaa(-5016, AOLErrorUtil.getErrorMsg(-5016));
        }
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar, Context context) {
        long j;
        try {
            j = Long.parseLong(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaao(context));
        } catch (Exception unused) {
            j = 0;
        }
        long optLong = aaaaaaaaVar.optLong("7C61656D");
        if (j > 0 && optLong > 0 && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(j * 1000, 1000 * optLong)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(context);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(context, String.valueOf(optLong));
    }
}
