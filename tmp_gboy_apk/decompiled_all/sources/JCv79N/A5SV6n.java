package JCv79N;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n {
    public static JSONObject A2egSU(AMqCpz aMqCpz, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append(aMqCpz.f4135A2egSU);
        map.put("room_id", sb.toString());
        map.put("anchor_id", aMqCpz.f4136A4TApA);
        map.put("enter_from_merge", aMqCpz.f4138ADYaiT.A2egSU());
        map.put("enter_method", aMqCpz.AMqCpz.name().toLowerCase());
        map.put("action_type", "CLICK".toLowerCase());
        map.put(PointParamKey.REQUEST_ID, aMqCpz.f4137A5SV6n);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aMqCpz.f4139ARc23Z);
        map.put(MediationConstant.EXTRA_DURATION, sb2.toString());
        map.put("is_other_channel", "union_ad");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return jSONObject;
    }
}
