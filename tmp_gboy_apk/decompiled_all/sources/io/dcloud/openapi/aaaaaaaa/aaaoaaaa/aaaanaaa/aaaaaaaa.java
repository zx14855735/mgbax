package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.custom.MedProConst;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaae;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.poly.api.Platform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa implements aaaaaaao.aaaaaaaa {
    private static volatile aaaaaaaa aaaaaeaa;
    private JSONObject aaaaaaac;
    private Context aaaaaaae;
    private final AtomicBoolean aaaaaaaa = new AtomicBoolean(false);
    private final Queue aaaaaaa0 = new ConcurrentLinkedQueue();
    private final Map aaaaaaao = new HashMap();
    private final Map aaaaaaau = new HashMap();
    private String aaaaaaan = "";
    private final String aaaaaaav = "uniad_config";
    private final String aaaaaaeo = "S_C";
    private final String aaaeaaaa = "pap";
    private final String aaaaeaaa = "dpap";

    public static abstract class aaaaaaa0 extends AbstractC0533aaaaaaaa {
        private boolean aaaaaaa0;

        public aaaaaaa0(String str) {
            super(str);
            this.aaaaaaa0 = false;
        }

        public abstract void aaaaaaaa(JSONArray jSONArray);

        public abstract void aaaaaaaa(JSONArray jSONArray, boolean z);

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(JSONObject jSONObject) {
            this.aaaaaaa0 = true;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.AbstractC0533aaaaaaaa
        public void aaaaaaaa(int i, String str) {
            this.aaaaaaa0 = true;
        }

        public boolean aaaaaaaa() {
            return this.aaaaaaa0;
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public static abstract class AbstractC0533aaaaaaaa {
        String aaaaaaaa;

        public AbstractC0533aaaaaaaa(String str) {
            this.aaaaaaaa = str;
        }

        public abstract void aaaaaaaa(int i, String str);

        public abstract void aaaaaaaa(JSONObject jSONObject);
    }

    private aaaaaaaa() {
    }

    private JSONObject aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa aaaaaaaaVar2;
        JSONObject aaaaaaaa = aaaaaaaaVar.aaaaaaaa("appid");
        JSONObject aaaaaaaa2 = aaaaaaaaVar.aaaaaaaa(MedProConst.AD_APPKEY);
        JSONObject aaaaaaaa3 = aaaaaaaaVar.aaaaaaaa(MediationConstant.RIT_TYPE_SPLASH);
        JSONObject aaaaaaaa4 = aaaaaaaaVar.aaaaaaaa("sp");
        HashMap hashMap = new HashMap();
        if (aaaaaaaa != null) {
            Iterator<String> keys = aaaaaaaa.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa aaaaaaaaVar3 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa();
                aaaaaaaaVar3.aaaaaaao(next);
                aaaaaaaaVar3.aaaaaaaa(aaaaaaaa.optString(next));
                if (aaaaaaaa2 != null && aaaaaaaa2.has(next)) {
                    aaaaaaaaVar3.aaaaaaa0(aaaaaaaa.optString(next));
                }
                hashMap.put(next, aaaaaaaaVar3);
            }
        }
        if (aaaaaaaa4 != null) {
            Iterator<String> keys2 = aaaaaaaa4.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject optJSONObject = aaaaaaaa4.optJSONObject(next2);
                if (optJSONObject != null) {
                    if (hashMap.containsKey(next2)) {
                        aaaaaaaaVar2 = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa) hashMap.get(next2);
                    } else {
                        aaaaaaaaVar2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa();
                        aaaaaaaaVar2.aaaaaaao(next2);
                    }
                    Platform platform = new Platform();
                    platform.setType(next2);
                    platform.setPlatJson(optJSONObject);
                    aaaaaaaaVar2.aaaaaaaa(platform);
                    hashMap.put(next2, aaaaaaaaVar2);
                }
            }
        }
        this.aaaaaaau.putAll(hashMap);
        JSONObject jSONObject = null;
        if (aaaaaaaa3 != null) {
            String optString = aaaaaaaa3.optString("_psp_");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("adpid", aaaaaaaa3.optString("_adpid_"));
                jSONObject2.put(PointParamKey.TYPE, 1);
                jSONObject2.put("cpadpid", aaaaaaaa3.optString("cp_adp_id"));
                jSONObject2.put("fs", aaaaaaaa3.optString("_fs_"));
                jSONObject2.put("fwt", aaaaaaaa3.optString("_fwt_"));
                jSONObject2.put("ord", aaaaaaaa3.optString("_ord_"));
                jSONObject2.put("sr", aaaaaaaa3.optString("_sr_"));
                JSONObject optJSONObject2 = aaaaaaaa3.optJSONObject("_w_");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                JSONObject optJSONObject3 = aaaaaaaa3.optJSONObject("_m_");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                }
                String[] split = TextUtils.split(optString, ",");
                JSONArray jSONArray = new JSONArray();
                for (String str : split) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(t.b, str);
                    jSONObject3.put("sid", aaaaaaaa3.optString(str));
                    if (optJSONObject2.has(str)) {
                        jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, optJSONObject2.optString(str));
                    }
                    if (optJSONObject3.has(str)) {
                        jSONObject3.put(t.m, optJSONObject3.optString(str));
                    }
                    jSONArray.put(jSONObject3);
                }
                jSONObject2.put("cfgs", jSONArray);
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
        }
        return jSONObject;
    }

    public static aaaaaaaa aaaaaaaa() {
        if (aaaaaeaa == null) {
            synchronized (aaaaaaaa.class) {
                try {
                    if (aaaaaeaa == null) {
                        aaaaaeaa = new aaaaaaaa();
                        return aaaaaeaa;
                    }
                } finally {
                }
            }
        }
        return aaaaaeaa;
    }

    public void aaaaaaaa(Context context, int i, AbstractC0533aaaaaaaa abstractC0533aaaaaaaa) {
        JSONObject jSONObject;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar;
        if (TextUtils.isEmpty(abstractC0533aaaaaaaa.aaaaaaaa) && i != 1 && i != 3) {
            abstractC0533aaaaaaaa.aaaaaaaa(-5001, AOLErrorUtil.getErrorMsg(-5001));
            return;
        }
        if (i == 3) {
            JSONObject jSONObject2 = this.aaaaaaac;
            if (jSONObject2 != null && jSONObject2.has("frsplash")) {
                abstractC0533aaaaaaaa.aaaaaaaa(this.aaaaaaac.optJSONObject("frsplash"));
                return;
            } else {
                abstractC0533aaaaaaaa.aaaaaaaa(-5015, AOLErrorUtil.getErrorMsg(-5015));
                return;
            }
        }
        if (i == 1) {
            JSONObject jSONObject3 = this.aaaaaaac;
            if (jSONObject3 != null) {
                if (!jSONObject3.has(MediationConstant.RIT_TYPE_SPLASH)) {
                    abstractC0533aaaaaaaa.aaaaaaaa(-5019, AOLErrorUtil.getErrorMsg(-5019));
                    return;
                } else if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaac(context)) {
                    abstractC0533aaaaaaaa.aaaaaaaa(this.aaaaaaac.optJSONObject(MediationConstant.RIT_TYPE_SPLASH));
                    return;
                } else {
                    abstractC0533aaaaaaaa.aaaaaaaa(-5022, AOLErrorUtil.getErrorMsg(-5022));
                    return;
                }
            }
            String aaaaaaaa = aaaaaaau.aaaaaaaa(context, "uniad_config", "S_C");
            if (!TextUtils.isEmpty(aaaaaaaa)) {
                try {
                    aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa(aaaaaaae.aaaaaaao(aaaaaaaa));
                } catch (JSONException unused) {
                    aaaaaaaaVar = null;
                }
                if (aaaaaaaaVar != null && aaaaaaaaVar.length() > 0) {
                    if (!aaaaaaaaVar.has("7B78") && !aaaaaaaaVar.has("697878436D71")) {
                        aaaaaaaa(aaaaaaaaVar.aaaaaaa0("697878616C"));
                        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaac(context)) {
                            JSONObject aaaaaaa02 = aaaaaaaaVar.aaaaaaa0("7B7864697B60");
                            if (aaaaaaa02 != null) {
                                abstractC0533aaaaaaaa.aaaaaaaa(aaaaaaa02);
                            }
                        } else {
                            abstractC0533aaaaaaaa.aaaaaaaa(-5022, AOLErrorUtil.getErrorMsg(-5022));
                        }
                    } else {
                        JSONObject aaaaaaa03 = aaaaaaa0(aaaaaaaaVar);
                        if (aaaaaaa03 != null) {
                            abstractC0533aaaaaaaa.aaaaaaaa(aaaaaaa03);
                        }
                    }
                }
            }
            this.aaaaaaa0.add(abstractC0533aaaaaaaa);
            if (this.aaaaaaaa.get()) {
                return;
            }
            aaaaaaaa(context, i);
            return;
        }
        if (this.aaaaaaau.size() > 0 && (jSONObject = this.aaaaaaac) != null && jSONObject.length() > 0) {
            if (!TextUtils.isEmpty(abstractC0533aaaaaaaa.aaaaaaaa)) {
                if (this.aaaaaaac.has(abstractC0533aaaaaaaa.aaaaaaaa)) {
                    abstractC0533aaaaaaaa.aaaaaaaa(this.aaaaaaac.optJSONObject(abstractC0533aaaaaaaa.aaaaaaaa));
                    return;
                }
                abstractC0533aaaaaaaa.aaaaaaaa(-5002, AOLErrorUtil.getErrorMsg(-5002) + abstractC0533aaaaaaaa.aaaaaaaa);
                return;
            }
            abstractC0533aaaaaaaa.aaaaaaaa(-5001, AOLErrorUtil.getErrorMsg(-5001));
            return;
        }
        this.aaaaaaa0.add(abstractC0533aaaaaaaa);
        if (this.aaaaaaaa.get()) {
            return;
        }
        aaaaaaaa(context, i);
    }

    private void aaaaaaaa(Context context, int i) {
        this.aaaaaaae = context.getApplicationContext();
        this.aaaaaaaa.set(true);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaaa().aaaaaaaa(context, i, this);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao.aaaaaaaa
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar) {
        int i = 0;
        this.aaaaaaaa.set(false);
        if (aaaaaaaaVar.has("786978")) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaa0(this.aaaaaaae, aaaaaaaaVar.optString("786978", Constants.FAIL));
        }
        if (aaaaaaaaVar.has("6C786978")) {
            String optString = aaaaaaaaVar.optString("6C786978", Constants.FAIL);
            this.aaaaaaan = optString;
            aaaaaaau.aaaaaaaa(this.aaaaaaae, "uniad_config", "dpap", optString);
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa optJSONObject = aaaaaaaaVar.optJSONObject("6C697C69");
        if (optJSONObject != null && optJSONObject.has("7D6661696C")) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa optJSONObject2 = optJSONObject.optJSONObject("7D6661696C");
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                JSONObject aaaaaaa02 = optJSONObject2.has("6B606966666D64") ? optJSONObject2.aaaaaaa0("6B606966666D64") : new JSONObject();
                this.aaaaaaau.clear();
                aaaaaaaa(aaaaaaa02);
                JSONArray optJSONArray = optJSONObject2.has("787A") ? optJSONObject2.optJSONArray("787A") : null;
                JSONObject aaaaaaa03 = optJSONObject2.aaaaaaa0("696C78616C7B");
                this.aaaaaaac = aaaaaaa03;
                JSONObject optJSONObject3 = aaaaaaa03 != null ? aaaaaaa03.optJSONObject(MediationConstant.RIT_TYPE_SPLASH) : null;
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa aaaaaaaaVar2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaana.aaaaaaaa();
                try {
                    aaaaaaaaVar2.put("697878616C", aaaaaaa02);
                    aaaaaaaaVar2.put("7B7864697B60", optJSONObject3);
                } catch (JSONException unused) {
                }
                aaaaaaaa(aaaaaaaaVar2.toString(), this.aaaaaaae);
                JSONArray optJSONArray2 = aaaaaaaaVar.optJSONArray("787B697B");
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = this.aaaaaaac;
                if (jSONObject != null && jSONObject.length() > 0) {
                    Iterator it = this.aaaaaaa0.iterator();
                    while (it.hasNext()) {
                        AbstractC0533aaaaaaaa abstractC0533aaaaaaaa = (AbstractC0533aaaaaaaa) it.next();
                        if (abstractC0533aaaaaaaa instanceof aaaaaaa0) {
                            arrayList.add((aaaaaaa0) abstractC0533aaaaaaaa);
                        } else if (this.aaaaaaac.has(abstractC0533aaaaaaaa.aaaaaaaa)) {
                            abstractC0533aaaaaaaa.aaaaaaaa(this.aaaaaaac.optJSONObject(abstractC0533aaaaaaaa.aaaaaaaa));
                        } else {
                            abstractC0533aaaaaaaa.aaaaaaaa(-5002, AOLErrorUtil.getErrorMsg(-5002) + abstractC0533aaaaaaaa.aaaaaaaa);
                        }
                        it.remove();
                    }
                } else {
                    Iterator it2 = this.aaaaaaa0.iterator();
                    while (it2.hasNext()) {
                        AbstractC0533aaaaaaaa abstractC0533aaaaaaaa2 = (AbstractC0533aaaaaaaa) it2.next();
                        if (abstractC0533aaaaaaaa2 instanceof aaaaaaa0) {
                            arrayList.add((aaaaaaa0) abstractC0533aaaaaaaa2);
                        } else {
                            abstractC0533aaaaaaaa2.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
                        }
                        it2.remove();
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    aaaaaaa0 aaaaaaa0Var = (aaaaaaa0) obj;
                    if (!aaaaaaa0Var.aaaaaaa0) {
                        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaac(this.aaaaaaae)) {
                            if (optJSONObject3 != null && optJSONObject3.length() > 0) {
                                aaaaaaa0Var.aaaaaaaa(optJSONObject3);
                            } else {
                                aaaaaaa0Var.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
                            }
                        } else {
                            aaaaaaa0Var.aaaaaaaa(-5022, AOLErrorUtil.getErrorMsg(-5022));
                        }
                    }
                    aaaaaaa0Var.aaaaaaaa(optJSONArray2, true);
                    aaaaaaa0Var.aaaaaaaa(optJSONArray);
                }
                return;
            }
            Iterator it3 = this.aaaaaaa0.iterator();
            while (it3.hasNext()) {
                AbstractC0533aaaaaaaa abstractC0533aaaaaaaa3 = (AbstractC0533aaaaaaaa) it3.next();
                if (abstractC0533aaaaaaaa3 instanceof aaaaaaa0) {
                    aaaaaaa0 aaaaaaa0Var2 = (aaaaaaa0) abstractC0533aaaaaaaa3;
                    if (!aaaaaaa0Var2.aaaaaaaa()) {
                        abstractC0533aaaaaaaa3.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
                    }
                    aaaaaaa0Var2.aaaaaaaa((JSONArray) null, false);
                } else {
                    abstractC0533aaaaaaaa3.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
                }
                it3.remove();
            }
            return;
        }
        Iterator it4 = this.aaaaaaa0.iterator();
        while (it4.hasNext()) {
            AbstractC0533aaaaaaaa abstractC0533aaaaaaaa4 = (AbstractC0533aaaaaaaa) it4.next();
            if (abstractC0533aaaaaaaa4 instanceof aaaaaaa0) {
                aaaaaaa0 aaaaaaa0Var3 = (aaaaaaa0) abstractC0533aaaaaaaa4;
                if (!aaaaaaa0Var3.aaaaaaaa()) {
                    abstractC0533aaaaaaaa4.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
                }
                aaaaaaa0Var3.aaaaaaaa((JSONArray) null, false);
            } else {
                abstractC0533aaaaaaaa4.aaaaaaaa(-5007, AOLErrorUtil.getErrorMsg(-5007));
            }
            it4.remove();
        }
    }

    private void aaaaaaaa(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa();
            aaaaaaaaVar.aaaaaaao(next);
            if (aaaaaaaaVar.aaaaaaaa(optJSONObject)) {
                this.aaaaaaau.put(next, aaaaaaaaVar);
            } else {
                this.aaaaaaau.remove(next);
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaao.aaaaaaaa
    public void aaaaaaaa(int i, String str) {
        int i2;
        this.aaaaaaac = new JSONObject();
        aaaaaaau.aaaaaaaa(this.aaaaaaae, "uniad_config", "S_C", "");
        this.aaaaaaaa.set(false);
        try {
            i2 = Integer.parseInt(str);
        } catch (Exception unused) {
            i2 = -1;
        }
        Iterator it = this.aaaaaaa0.iterator();
        while (it.hasNext()) {
            AbstractC0533aaaaaaaa abstractC0533aaaaaaaa = (AbstractC0533aaaaaaaa) it.next();
            if (abstractC0533aaaaaaaa instanceof aaaaaaa0) {
                aaaaaaa0 aaaaaaa0Var = (aaaaaaa0) abstractC0533aaaaaaaa;
                if (!aaaaaaa0Var.aaaaaaaa()) {
                    abstractC0533aaaaaaaa.aaaaaaaa(-5007, i2 != -1 ? CtFAbx.BChYOn("http:", str) : str);
                }
                aaaaaaa0Var.aaaaaaaa((JSONArray) null, false);
            } else {
                abstractC0533aaaaaaaa.aaaaaaaa(-5007, i2 != -1 ? CtFAbx.BChYOn("http:", str) : str);
            }
            it.remove();
        }
    }

    private void aaaaaaaa(String str, Context context) {
        if (context != null) {
            aaaaaaau.aaaaaaaa(context, "uniad_config", "S_C", aaaaaaae.aaaaaaau(str));
        }
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa aaaaaaaa(String str) {
        if (Const.TYPE_GM.equalsIgnoreCase(str) && !this.aaaaaaau.containsKey(str)) {
            str = Const.TYPE_CSJ;
        }
        if (this.aaaaaaau.size() == 0 || TextUtils.isEmpty(str) || !this.aaaaaaau.containsKey(str)) {
            return null;
        }
        return (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa) this.aaaaaaau.get(str);
    }

    public boolean aaaaaaaa(Context context) {
        if (TextUtils.isEmpty(this.aaaaaaan)) {
            this.aaaaaaan = aaaaaaau.aaaaaaaa(context, "uniad_config", "dpap");
        }
        return "1".equals(this.aaaaaaan);
    }
}
