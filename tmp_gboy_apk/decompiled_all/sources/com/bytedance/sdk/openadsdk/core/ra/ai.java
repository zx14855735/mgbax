package com.bytedance.sdk.openadsdk.core.ra;

import B4ZgIw.AYUAbz;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ai {
    private static final List<w> hf = new CopyOnWriteArrayList();
    public static boolean xj = false;

    public static class hf {
        private final String hf;
        private final String kd;
        private final String u;
        private final String w;
        private final long xj;
        private final String y;

        public hf(JSONObject jSONObject) {
            this.xj = jSONObject.optLong("size", 0L);
            this.hf = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.w = jSONObject.optString("content_hash");
            this.u = jSONObject.optString("url");
            this.kd = jSONObject.optString("mime_type");
            this.y = jSONObject.optString("file_name");
        }

        public String hf() {
            return this.y;
        }

        public JSONObject w() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.xj);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.hf);
                jSONObject.put("content_hash", this.w);
                jSONObject.put("mime_type", this.kd);
                jSONObject.put("file_name", this.y);
                jSONObject.put("url", this.u);
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                return jSONObject;
            }
        }

        public String xj() {
            return this.kd;
        }
    }

    public static class u {
        private final String hf;
        private final List<hf> w = new ArrayList();
        private final String xj;

        public u(JSONObject jSONObject) {
            this.xj = jSONObject.optString("resource_url");
            this.hf = jSONObject.optString("content_hash");
            JSONArray optJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.w.add(new hf(optJSONObject));
                    }
                }
            }
        }

        public String hf() {
            return this.hf;
        }

        public JSONObject u() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.xj);
                jSONObject.put("content_hash", this.hf);
                JSONArray jSONArray = new JSONArray();
                Iterator<hf> it = this.w.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().w());
                }
                jSONObject.put("channel_resource_list", jSONArray);
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                return jSONObject;
            }
        }

        public List<hf> w() {
            return this.w;
        }

        public String xj() {
            return this.xj;
        }
    }

    public static class w {
        private final String hf;
        private final List<u> w = new ArrayList();
        private final String xj;

        public w(JSONObject jSONObject) {
            this.xj = jSONObject.optString("channel");
            this.hf = jSONObject.optString("prefix");
            JSONArray optJSONArray = jSONObject.optJSONArray("resource");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.w.add(new u(optJSONObject));
                    }
                }
            }
        }

        public List<u> getResources() {
            return this.w;
        }

        public String hf() {
            return this.hf;
        }

        public JSONObject kd() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.xj);
                jSONObject.put("prefix", this.hf);
                JSONArray jSONArray = new JSONArray();
                Iterator<u> it = this.w.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().u());
                }
                jSONObject.put("resource", jSONArray);
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                return jSONObject;
            }
        }

        public String u() {
            String str = this.xj;
            if (w() == null) {
                return str;
            }
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "$");
            A5SV6n2.append(com.bytedance.sdk.component.utils.kd.hf(w().hf()));
            return A5SV6n2.toString();
        }

        public u w() {
            if (this.w.isEmpty()) {
                return null;
            }
            return this.w.get(0);
        }

        public String xj() {
            return this.xj;
        }
    }

    public interface xj {
        void hf(w wVar);

        void xj(w wVar);
    }

    static {
        YzMl();
    }

    private static /* synthetic */ void YzMl() {
        char[] charArray = "\u008f\u0083\u0081Â\u008b\u008d\u0081\u0089Â\u008e\u0083\u0095Â\u009f\u0084\u0089\u0080\u0080Â¦\u0082\u0085®\u009e\u0085\u0088\u008b\u0089".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 236);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008f\u0080\u0085\u0082\u0085\u0098".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 236);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void hf(JSONObject jSONObject, final xj xjVar) {
        if (xj) {
            final ArrayList arrayList = new ArrayList();
            String str = "h5_cache_resources";
            JSONArray optJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new w(optJSONObject));
                    }
                }
            }
            com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d(str) { // from class: com.bytedance.sdk.openadsdk.core.ra.ai.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.a.eu.xj().xj(arrayList, xjVar);
                }
            });
        }
    }

    public static void xj(JSONObject jSONObject, xj xjVar) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.eu.xj().xj(xjVar);
        xj = jSONObject.optBoolean("h5_cache_resources_enable", false);
        hf(jSONObject, xjVar);
    }

    public static List<w> xj() {
        return hf;
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        try {
            xj = wVar.get("h5_cache_resources_enable", false);
            JSONArray jSONArray = new JSONArray(wVar.get("h5_cache_resources", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hf.add(new w(optJSONObject));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        wVar.put("h5_cache_resources_enable", xj);
    }

    public static synchronized void hf(com.bytedance.sdk.component.u.hf.w wVar, w wVar2) {
        synchronized (ai.class) {
            try {
                List<w> list = hf;
                list.remove(wVar2);
                JSONArray jSONArray = new JSONArray();
                Iterator<w> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().kd());
                }
                wVar.put("h5_cache_resources", jSONArray.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void xj(com.bytedance.sdk.component.u.hf.w wVar, w wVar2) {
        synchronized (ai.class) {
            try {
                List<w> list = hf;
                list.add(wVar2);
                JSONArray jSONArray = new JSONArray();
                Iterator<w> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().kd());
                }
                wVar.put("h5_cache_resources", jSONArray.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
