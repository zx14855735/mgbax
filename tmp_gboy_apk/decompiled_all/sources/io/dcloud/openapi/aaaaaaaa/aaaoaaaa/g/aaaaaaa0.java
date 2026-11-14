package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g;

import android.app.Activity;
import android.view.ViewGroup;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.entry.SplashAOLConfig;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa {
    private final Queue aaaacaaa;
    private SplashAOLConfig aaacaaaa;

    public class aaaaaaaa extends aaaaaaaa.aaaaaaa0 {
        public aaaaaaaa() {
            super("");
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(JSONArray jSONArray) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(JSONArray jSONArray, boolean z) {
            if (jSONArray == null || jSONArray.length() == 0) {
                Iterator it = aaaaaaa0.this.aaaacaaa.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) ((DCBaseAOL) it.next())).aaaaaaaa((JSONArray) null, true);
                }
                return;
            }
            int i = 0;
            if (aaaaaaa0.this.aaaacaaa.size() <= 0) {
                while (i < jSONArray.length()) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0 aaaaaaa0Var = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) aaaaaaa0.this.aaaaoaaa();
                    if (aaaaaaa0Var != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(jSONArray.opt(i));
                        aaaaaaa0Var.aaaaaaaa(jSONArray2, true);
                        aaaaaaa0.this.aaaacaaa.add(aaaaaaa0Var);
                    }
                    i++;
                }
                return;
            }
            for (DCBaseAOL dCBaseAOL : aaaaaaa0.this.aaaacaaa) {
                if (jSONArray.length() > i) {
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put(jSONArray.opt(i));
                    ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) dCBaseAOL).aaaaaaaa(jSONArray3, true);
                } else {
                    ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) dCBaseAOL).aaaaaaaa((JSONArray) null, true);
                }
                i++;
            }
            if (jSONArray.length() > i) {
                for (int i2 = i; i2 < jSONArray.length(); i2++) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0 aaaaaaa0Var2 = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0) aaaaaaa0.this.aaaaoaaa();
                    if (aaaaaaa0Var2 != null) {
                        JSONArray jSONArray4 = new JSONArray();
                        jSONArray4.put(jSONArray.opt(i));
                        aaaaaaa0Var2.aaaaaaaa(jSONArray4, true);
                        aaaaaaa0.this.aaaacaaa.add(aaaaaaa0Var2);
                    }
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(JSONObject jSONObject) {
            super.aaaaaaaa(jSONObject);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                jSONObject2.remove("cfgs");
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa) aaaaaaa0.this).aaaaoaaa.getClass().getDeclaredMethod("getConfig", JSONObject.class).invoke(((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa) aaaaaaa0.this).aaaaoaaa, jSONObject2);
            } catch (Exception unused) {
            }
            aaaaaaa0.this.aaaaaaaa(jSONObject);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(int i, String str) {
            super.aaaaaaaa(i, str);
            aaaaaaa0.this.aaaaaaa0(i, str);
        }
    }

    public aaaaaaa0(Activity activity, int i) {
        super(activity, i);
        this.aaaacaaa = new ConcurrentLinkedQueue();
        aaaaaaaa(new aaaaaaaa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DCBaseAOLLoader aaaaoaaa() {
        IAdAdapter aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0("dcloud");
        if (aaaaaaa0 == null) {
            return null;
        }
        DCBaseAOLLoader ad = aaaaaaa0.getAd(aaaaaaaa(), this.aaaaaaa0);
        this.aaaacaaa.add(ad);
        return ad;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao
    public int aaaaaaac() {
        return 1;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public DCBaseAOLLoader aaaaaaa0() {
        return this.aaaacaaa.isEmpty() ? aaaaoaaa() : (DCBaseAOLLoader) this.aaaacaaa.remove();
    }

    public void aaaaaaaa(ViewGroup viewGroup) {
        DCBaseAOL dCBaseAOL = this.aaaaaoaa;
        if (dCBaseAOL instanceof DCBaseAOLLoader) {
            ((DCBaseAOLLoader) dCBaseAOL).showIn(viewGroup);
        }
    }

    public void aaaaaaaa(SplashAOLConfig splashAOLConfig, aaaaaaao aaaaaaaoVar) {
        this.aaacaaaa = splashAOLConfig;
        super.aaaaaaaa(new DCloudAOLSlot.Builder().height(splashAOLConfig.getHeight()).width(splashAOLConfig.getWidth()).build(), aaaaaaaoVar);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0 aaaaaaa0Var) {
        super.aaaaaaaa(aaaaaaa0Var);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao
    public void aaaaaaaa(int i, String str) {
        super.aaaaaaaa(i, str);
    }
}
