package com.bytedance.sdk.component.adexpress.dynamic.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private JSONObject hf;
    private HashMap<String, Object> xj = new HashMap<>();

    public w(JSONObject jSONObject) {
        this.hf = jSONObject;
    }

    public boolean hf(String str) {
        return this.xj.containsKey(str);
    }

    public Object xj(String str) {
        if (this.xj.containsKey(str)) {
            return this.xj.get(str);
        }
        return null;
    }

    public void xj() {
        Iterator<String> keys = this.hf.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = this.hf.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (opt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (i < jSONArray.length()) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                Iterator<String> keys2 = optJSONObject.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    Object opt2 = optJSONObject.opt(next2);
                                    this.xj.put(next + "." + i + "." + next2, opt2);
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (opt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) opt);
                        Iterator<String> keys3 = jSONObject.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            Object opt3 = jSONObject.opt(next3);
                            if ((opt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) opt3).length(); i2++) {
                                    this.xj.put(next + "." + next3 + "." + i2, ((JSONArray) opt3).opt(i2));
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> keys4 = ((JSONObject) opt3).keys();
                                while (keys4.hasNext()) {
                                    String next4 = keys4.next();
                                    Object opt4 = ((JSONObject) opt3).opt(next4);
                                    this.xj.put(next + "." + next3 + "." + next4, opt4);
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                xj(next, next3, opt3);
                            } else {
                                this.xj.put(next + "." + next3, opt3);
                            }
                        }
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            } else if (!(opt instanceof JSONObject)) {
                this.xj.put(next, opt);
                if (opt instanceof String) {
                    this.xj.put(next, opt);
                }
            } else if (opt != null) {
                JSONObject jSONObject2 = (JSONObject) opt;
                Iterator<String> keys5 = jSONObject2.keys();
                while (keys5.hasNext()) {
                    String next5 = keys5.next();
                    Object opt5 = jSONObject2.opt(next5);
                    this.xj.put(next + "." + next5, opt5);
                }
            }
        }
    }

    private void xj(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if ((opt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            Object opt2 = optJSONObject.opt(next2);
                            this.xj.put(str + "." + str2 + "." + next + "." + i + "." + next2, opt2);
                        }
                        i++;
                    }
                }
            } else {
                this.xj.put(str + "." + str2 + "." + next, opt);
            }
        }
    }
}
