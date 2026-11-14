package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa;

import android.app.Activity;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao extends aaaaaaa0 implements Runnable {
    protected DCloudAOLSlot aaaaaaa0;
    protected int aaaaaaac;
    protected final Activity aaaaaaao;
    private aaaaaaaa.AbstractC0533aaaaaaaa aaaaaaau;

    public class aaaaaaaa extends aaaaaaaa.AbstractC0533aaaaaaaa {
        public aaaaaaaa(String str) {
            super(str);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(JSONObject jSONObject) {
            aaaaaaao.this.aaaaaaaa(jSONObject);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(int i, String str) {
            aaaaaaao.this.aaaaaaa0(i, str);
        }
    }

    public aaaaaaao(Activity activity) {
        this.aaaaaaao = activity;
    }

    private void aaaaaaau() {
        if (this.aaaaaaau == null) {
            this.aaaaaaau = new aaaaaaaa(this.aaaaaaa0.getAdpid());
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(this.aaaaaaao, aaaaaaac(), this.aaaaaaau);
    }

    public void aaaaaaa0(int i, String str) {
        aaaaaaaa(i, str);
    }

    public abstract void aaaaaaaa(int i, String str);

    public abstract void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0 aaaaaaa0Var);

    public final void aaaaaaaa(DCloudAOLSlot dCloudAOLSlot) {
        this.aaaaaaa0 = dCloudAOLSlot;
        dCloudAOLSlot.setType(this.aaaaaaac);
    }

    public int aaaaaaac() {
        return 2;
    }

    public void run() {
        aaaaaaau();
    }

    public void aaaaaaaa(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            aaaaaaaa(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0().aaaaaaaa(jSONObject, aaaaaaac()));
        } else {
            aaaaaaaa(-5001, AOLErrorUtil.getErrorMsg(-5001));
        }
    }

    public void aaaaaaaa(aaaaaaaa.AbstractC0533aaaaaaaa abstractC0533aaaaaaaa) {
        this.aaaaaaau = abstractC0533aaaaaaaa;
    }
}
