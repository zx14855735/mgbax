package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f13559a = new HashMap();
    private final Map<String, a> b = new HashMap();
    private final Map<String, a> c = new HashMap();
    private final Context d;

    public interface a {
        void valueChange(JSONObject jSONObject);
    }

    static {
        STufr();
    }

    public p(Context context) {
        this.d = context;
    }

    private static /* synthetic */ void STufr() {
        char[] charArray = "ÿóñ²ûýñù²þóå²ïôùðð²ÖòõÞîõøûù".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 156);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÿðõòõè".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 156);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String a(int i, String str) {
        Object obj;
        if (i == 1) {
            obj = n.b(this.d, str, "");
        } else {
            Map<String, String> map = f13559a;
            if (map.get(str) == null) {
                return "";
            }
            obj = map.get(str);
        }
        return (String) obj;
    }

    public int b(int i) {
        if (i != 1) {
            return f13559a.size();
        }
        Map<String, ?> a2 = n.a(this.d);
        if (a2 == null) {
            return 0;
        }
        return a2.size();
    }

    public void a(int i) {
        if (i == 1) {
            Map<String, ?> a2 = n.a(this.d);
            if (a2 != null && !a2.isEmpty()) {
                for (Map.Entry<String, ?> entry : a2.entrySet()) {
                    a aVar = this.b.get(entry.getKey());
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("key", entry.getKey());
                            jSONObject.put("newValue", "");
                            jSONObject.put("oldValue", entry.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        aVar.valueChange(jSONObject);
                    }
                }
            }
            n.b(this.d);
            return;
        }
        Map<String, String> map = f13559a;
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            a aVar2 = this.c.get(entry2.getKey());
            if (aVar2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("key", entry2.getKey());
                    jSONObject2.put("newValue", "");
                    jSONObject2.put("oldValue", entry2.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                aVar2.valueChange(jSONObject2);
            }
        }
        f13559a.clear();
    }

    public void b(int i, String str) {
        a aVar;
        a aVar2;
        if (i == 1) {
            String str2 = (String) n.b(this.d, str, "");
            if (!TextUtils.isEmpty(str2) && (aVar2 = this.b.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", str);
                    jSONObject.put("newValue", "");
                    jSONObject.put("oldValue", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.valueChange(jSONObject);
            }
            n.b(this.d, str);
            return;
        }
        String str3 = f13559a.get(str);
        if (!TextUtils.isEmpty(str3) && (aVar = this.c.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("newValue", "");
                jSONObject2.put("oldValue", str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.valueChange(jSONObject2);
        }
        f13559a.remove(str);
    }

    public void a(int i, String str, a aVar) {
        (i == 1 ? this.b : this.c).put(str, aVar);
    }

    public void a(int i, String str, String str2) {
        a aVar;
        a aVar2;
        if (i == 1) {
            String str3 = (String) n.b(this.d, str, "");
            if (str3 != null && !str3.equals(str2) && (aVar2 = this.b.get(str)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", str);
                    jSONObject.put("newValue", str2);
                    jSONObject.put("oldValue", str3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar2.valueChange(jSONObject);
            }
            n.a(this.d, str, str2);
            return;
        }
        Map<String, String> map = f13559a;
        String str4 = map.get(str) != null ? map.get(str) : "";
        if (str4 != null && !str4.equals(str2) && (aVar = this.c.get(str)) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("newValue", str2);
                jSONObject2.put("oldValue", str4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.valueChange(jSONObject2);
        }
        f13559a.put(str, str2);
    }
}
