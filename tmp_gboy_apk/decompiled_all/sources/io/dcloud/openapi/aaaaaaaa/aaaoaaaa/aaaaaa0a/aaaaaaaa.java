package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a;

import android.content.Context;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.AdUtil;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa implements AOLLoader {
    private static volatile aaaaaaaa aaaaaaan;
    private aaaaaaao aaaaaaa0;
    private DCloudAOLManager.InitConfig aaaaaaaa;
    private Context aaaaaaao;
    private boolean aaaaaaau = false;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaauaaa.aaaaaaaa aaaaaaac = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaauaaa.aaaaaaaa();

    private aaaaaaaa() {
    }

    public static aaaaaaaa aaaaaaac() {
        if (aaaaaaan == null) {
            synchronized (aaaaaaaa.class) {
                try {
                    if (aaaaaaan == null) {
                        aaaaaaan = new aaaaaaaa();
                        aaaaaaan.aaaaaaa0 = new aaaaaaa0();
                    }
                } finally {
                }
            }
        }
        return aaaaaaan;
    }

    public DCloudAOLManager.InitConfig aaaaaaa0() {
        return this.aaaaaaaa;
    }

    public void aaaaaaaa(DCloudAOLManager.InitConfig initConfig) {
        this.aaaaaaaa = initConfig;
    }

    public Context aaaaaaao() {
        return this.aaaaaaao;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader
    public boolean getPersonalAOL(Context context) {
        return AdUtil.getPersonalAd(context);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader
    public void setPersonalAOL(Context context, boolean z) {
        AdUtil.setPersonalAd(context, z);
        Map aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaaa();
        Iterator it = aaaaaaaa.keySet().iterator();
        while (it.hasNext()) {
            ((IAdAdapter) aaaaaaaa.get((String) it.next())).setPersonalAd(z);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader
    public void setPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        Iterator it = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaao().iterator();
        while (it.hasNext()) {
            IAdAdapter aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0((String) it.next());
            if (aaaaaaa0 != null) {
                aaaaaaa0.updatePrivacyConfig(privacyConfig);
            }
        }
        AdUtil.setCustomPrivacyConfig(privacyConfig);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader
    public void updatePrivacyConfig(Context context, JSONObject jSONObject) {
    }

    public aaaaaaao aaaaaaaa() {
        return this.aaaaaaa0;
    }

    public void aaaaaaaa(Context context) {
        this.aaaaaaao = context;
    }
}
