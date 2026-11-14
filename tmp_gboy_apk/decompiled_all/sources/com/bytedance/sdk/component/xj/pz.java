package com.bytedance.sdk.component.xj;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.xj.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class pz {
    private final LruCache<String, w> hf;
    private final String u;
    private final p.xj w;
    private final Map<String, List<hf>> xj = new ConcurrentHashMap();
    private volatile boolean kd = false;

    public static final class hf {
        ra hf;
        List<String> u;
        List<String> w;
        Pattern xj;

        private hf() {
        }
    }

    public static final class w {
        ra xj = ra.PUBLIC;
        Set<String> hf = new HashSet();
        Set<String> w = new HashSet();
    }

    public static class xj extends IllegalStateException {
        public xj(String str) {
            super(str);
        }
    }

    @WorkerThread
    public pz(String str, int i, p.xj xjVar, final Executor executor, JSONObject jSONObject) {
        this.u = str;
        if (i <= 0) {
            this.hf = new LruCache<>(16);
        } else {
            this.hf = new LruCache<>(i);
        }
        this.w = xjVar;
        if (jSONObject != null) {
            update(jSONObject);
        } else {
            u(str);
            new Object() { // from class: com.bytedance.sdk.component.xj.pz.1
            };
        }
    }

    private static String hf(String str) {
        String[] split;
        int length;
        if (str == null || (length = (split = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return split[length - 2] + "." + split[length - 1];
    }

    private static String u(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private List<hf> w(String str) {
        if (this.kd) {
            return this.xj.get(str);
        }
        throw new xj("Permission config is outdated!");
    }

    public void update(JSONObject jSONObject) {
        xj(jSONObject);
        u(this.u);
    }

    public w xj(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        w wVar = new w();
        if (authority == null || authority.isEmpty()) {
            wVar.xj = ra.PUBLIC;
            return wVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(".".concat(String.valueOf(str2)))) {
                wVar.xj = ra.PRIVATE;
                return wVar;
            }
        }
        w wVar2 = this.hf.get(builder);
        return wVar2 != null ? wVar2 : xj(builder);
    }

    @WorkerThread
    private static hf hf(JSONObject jSONObject) {
        hf hfVar = new hf();
        hfVar.xj = Pattern.compile(jSONObject.getString("pattern"));
        hfVar.hf = ra.xj(jSONObject.getString("group"));
        hfVar.w = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                hfVar.w.add(optJSONArray.getString(i));
            }
        }
        hfVar.u = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                hfVar.u.add(optJSONArray2.getString(i2));
            }
        }
        return hfVar;
    }

    @WorkerThread
    private void xj(JSONObject jSONObject) {
        this.xj.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(IAdInterListener.AdProdType.PRODUCT_CONTENT);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.xj.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(hf(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            d.hf("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.kd = true;
    }

    private w xj(String str) {
        w wVar = new w();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String hf2 = hf(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && hf2 != null) {
            List<hf> w2 = w(hf2);
            if (w2 == null) {
                return wVar;
            }
            for (hf hfVar : w2) {
                if (hfVar.xj.matcher(str).find()) {
                    if (hfVar.hf.compareTo(wVar.xj) >= 0) {
                        wVar.xj = hfVar.hf;
                    }
                    wVar.hf.addAll(hfVar.w);
                    wVar.w.addAll(hfVar.u);
                }
            }
            this.hf.put(str, wVar);
            return wVar;
        }
        wVar.xj = ra.PUBLIC;
        return wVar;
    }
}
