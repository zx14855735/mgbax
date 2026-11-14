package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.pl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private final boolean am;
    private final long c;
    private final JSONObject d;
    private final JSONObject f;
    private final String g;
    private final String hf;
    private final long kd;
    private final int p;

    /* renamed from: pl, reason: collision with root package name */
    private final Object f13825pl;
    private final String qt;
    private final List<String> tf;
    private final boolean u;
    private final String w;
    private String xj;
    private final String y;
    private final JSONObject zg;

    public static class xj {
        private String am;
        private long c;
        private JSONObject d;
        private JSONObject e;
        private JSONObject f;
        private Object g;
        private String hf;
        private long kd;
        private List<String> p;

        /* renamed from: pl, reason: collision with root package name */
        private int f13826pl;
        private Map<String, Object> tf;
        private String w;
        private String xj;
        private String y;
        private String zg;
        private boolean u = false;
        private boolean qt = false;

        public xj hf(String str) {
            this.w = str;
            return this;
        }

        public xj u(String str) {
            this.am = str;
            return this;
        }

        public xj w(String str) {
            this.y = str;
            return this;
        }

        public xj xj(boolean z) {
            this.qt = z;
            return this;
        }

        public xj hf(long j) {
            this.c = j;
            return this;
        }

        public xj xj(String str) {
            this.hf = str;
            return this;
        }

        public xj hf(boolean z) {
            this.u = z;
            return this;
        }

        public xj xj(long j) {
            this.kd = j;
            return this;
        }

        public xj hf(JSONObject jSONObject) {
            this.d = jSONObject;
            return this;
        }

        public xj xj(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public xj xj(List<String> list) {
            this.p = list;
            return this;
        }

        public xj xj(int i) {
            this.f13826pl = i;
            return this;
        }

        public xj xj(Object obj) {
            this.g = obj;
            return this;
        }

        public w xj() {
            if (TextUtils.isEmpty(this.xj)) {
                this.xj = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f == null) {
                this.f = new JSONObject();
            }
            try {
                Map<String, Object> map = this.tf;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.tf.entrySet()) {
                        if (!this.f.has(entry.getKey())) {
                            this.f.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.qt) {
                    this.zg = this.w;
                    JSONObject jSONObject2 = new JSONObject();
                    this.e = jSONObject2;
                    if (this.u) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f.toString());
                    } else {
                        Iterator<String> keys = this.f.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.e.put(next, this.f.get(next));
                        }
                    }
                    this.e.put(PointParamKey.CATEGORY, this.xj);
                    this.e.put("tag", this.hf);
                    this.e.put("value", this.kd);
                    this.e.put("ext_value", this.c);
                    if (!TextUtils.isEmpty(this.am)) {
                        this.e.put("refer", this.am);
                    }
                    JSONObject jSONObject3 = this.d;
                    if (jSONObject3 != null) {
                        this.e = com.ss.android.download.api.w.hf.xj(jSONObject3, this.e);
                    }
                    if (this.u) {
                        if (!this.e.has("log_extra") && !TextUtils.isEmpty(this.y)) {
                            this.e.put("log_extra", this.y);
                        }
                        this.e.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.u) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.y)) {
                        jSONObject.put("log_extra", this.y);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.f);
                }
                if (!TextUtils.isEmpty(this.am)) {
                    jSONObject.putOpt("refer", this.am);
                }
                JSONObject jSONObject4 = this.d;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.w.hf.xj(jSONObject4, jSONObject);
                }
                this.f = jSONObject;
            } catch (Exception e) {
                pl.jk().xj(e, "DownloadEventModel build");
            }
            return new w(this);
        }
    }

    public w(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y;
        this.c = xjVar.c;
        this.f = xjVar.f;
        this.d = xjVar.d;
        this.tf = xjVar.p;
        this.p = xjVar.f13826pl;
        this.f13825pl = xjVar.g;
        this.am = xjVar.qt;
        this.qt = xjVar.zg;
        this.zg = xjVar.e;
        this.g = xjVar.am;
    }

    public String am() {
        return this.qt;
    }

    public long c() {
        return this.c;
    }

    public JSONObject d() {
        return this.d;
    }

    public JSONObject f() {
        return this.f;
    }

    public boolean g() {
        return this.am;
    }

    public String hf() {
        return this.hf;
    }

    public long kd() {
        return this.kd;
    }

    public int p() {
        return this.p;
    }

    public Object pl() {
        return this.f13825pl;
    }

    public JSONObject qt() {
        return this.zg;
    }

    public List<String> tf() {
        return this.tf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("category: ");
        sb.append(this.xj);
        sb.append("\ttag: ");
        sb.append(this.hf);
        sb.append("\tlabel: ");
        sb.append(this.w);
        sb.append("\nisAd: ");
        sb.append(this.u);
        sb.append("\tadId: ");
        sb.append(this.kd);
        sb.append("\tlogExtra: ");
        sb.append(this.y);
        sb.append("\textValue: ");
        sb.append(this.c);
        sb.append("\nextJson: ");
        sb.append(this.f);
        sb.append("\nparamsJson: ");
        sb.append(this.d);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.tf;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.p);
        sb.append("\textraObject: ");
        Object obj = this.f13825pl;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.am);
        sb.append("\tV3EventName: ");
        sb.append(this.qt);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.zg;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public boolean u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        return this.y;
    }
}
