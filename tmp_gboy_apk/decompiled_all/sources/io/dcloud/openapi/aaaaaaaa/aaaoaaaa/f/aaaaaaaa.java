package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.f;

import ADYaiT.BChYOn;
import android.app.Activity;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa implements AOLLoader.RewVAOLInteractionListener {
    public aaaaaaaa(Activity activity) {
        super(activity, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaa0(JSONObject jSONObject) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.RewVAOLInteractionListener) {
            ((AOLLoader.RewVAOLInteractionListener) vAOLInteractionListener).onReward(jSONObject);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!jSONObject.has("provider")) {
            try {
                jSONObject.put("provider", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaao(this.aaaaaoaa.getType()));
            } catch (Exception unused) {
            }
        }
        MainHandlerUtil.getMainHandler().post(new BChYOn(this, 15, jSONObject));
    }
}
