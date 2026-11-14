package io.dcloud.openapi.core.module;

import ADYaiT.CtFAbx;
import android.app.Activity;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.Const;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa extends DCBaseAOL {
    private boolean a0aaaaaa;
    private long aa0aaaaa;
    private String aaaaaaca;
    private JSONObject aaaaacaa;
    private int aaaacaaa;
    private long aaacaaaa;

    public aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.aaacaaaa = 0L;
        this.aaaacaaa = -1;
        this.aaaaaaca = "";
        this.a0aaaaaa = true;
        this.aa0aaaaa = 0L;
    }

    public void aaaaaaac(int i) {
        this.aaaacaaa = i;
    }

    public void aaaaaaao(int i, String str) {
        this.a0aaaaaa = i != -9999;
        aaaaaaau.aaaaaaa0("uniAD", getDCloudId() + ":" + getType() + ":" + i + ":" + str + ";id:" + getSlotId());
        this.aaaacaaa = 0;
        this.aaacaaaa = System.currentTimeMillis() - this.aa0aaaaa;
        JSONObject jSONObject = new JSONObject();
        this.aaaaacaa = jSONObject;
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            this.aaaaacaa.put(br.c, str);
        } catch (JSONException unused) {
        }
        if (getType().equals("gdt") && i == 6000) {
            StringBuilder sb = new StringBuilder();
            sb.append(getType());
            sb.append(":");
            sb.append(i);
            sb.append("(");
            this.aaaaaaca = CtFAbx.B25kr6(sb, str, ")");
            return;
        }
        if (getType().equals(Const.TYPE_BD) && i == -1) {
            this.aaaaaaca = getType() + ":" + str;
            return;
        }
        this.aaaaaaca = getType() + ":" + i;
    }

    public void aaaaaaoa() {
        this.aaacaaaa = System.currentTimeMillis() - this.aa0aaaaa;
    }

    public final long aaaaaoaa() {
        return this.aaacaaaa;
    }

    public void acaaaaaa() {
        aaaaaaau.aaaaaaa0("uniAD", getDCloudId() + ":" + getType() + ":success;id:" + getSlotId());
        this.aaaacaaa = 1;
        this.aaacaaaa = System.currentTimeMillis() - this.aa0aaaaa;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public int getAdStatus() {
        return this.aaaacaaa;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void startLoadTime() {
        this.aa0aaaaa = System.currentTimeMillis();
    }
}
