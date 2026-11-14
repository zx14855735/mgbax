package com.bytedance.sdk.component.xj;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class f {
    private pl xj;

    private f(pl plVar) {
        this.xj = plVar;
    }

    public static f xj(pl plVar) {
        return new f(plVar);
    }

    public <T> T xj(String str, Type type) {
        xj(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.xj.xj(str, type);
    }

    public <T> String xj(T t) {
        String obj;
        if (t == null) {
            return "{}";
        }
        if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
            obj = this.xj.xj(t);
        } else {
            obj = t.toString();
        }
        xj(obj);
        return obj;
    }

    private static void xj(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        d.xj(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }
}
