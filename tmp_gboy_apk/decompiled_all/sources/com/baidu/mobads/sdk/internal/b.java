package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.sigmob.sdk.base.models.ClickCommon;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f9752a = 0;
    private List<a> b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.f9752a = jSONObject.optInt("n", 0);
                int optInt = jSONObject.optInt("enc", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray(ClickCommon.CLICK_SCENE_AD);
                if (optInt == 1) {
                    String optString = jSONObject.optString(ClickCommon.CLICK_SCENE_AD);
                    if (!TextUtils.isEmpty(optString)) {
                        String b = h.b(optString);
                        if (!TextUtils.isEmpty(b)) {
                            optJSONArray = new JSONArray(b);
                        }
                    }
                }
                bVar.b = a.a(optJSONArray);
                return bVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bVar;
    }

    public List<a> a() {
        return this.b;
    }
}
