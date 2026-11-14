package com.bytedance.sdk.component.hf.xj.xj.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.g;
import com.bytedance.sdk.component.hf.xj.p;
import com.bytedance.sdk.component.hf.xj.zg;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends zg {
    am hf;
    p kd = null;
    public long u;
    public long w;
    HttpURLConnection xj;

    public y(HttpURLConnection httpURLConnection, am amVar) {
        this.xj = httpURLConnection;
        this.hf = amVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public com.bytedance.sdk.component.hf.xj.y c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.xj.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!com.sigmob.sdk.downloader.core.c.f.equalsIgnoreCase(entry.getKey()) || w() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.hf.xj.y((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            y().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public p d() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public g f() {
        return g.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public long hf() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String kd() {
        return this.xj.getResponseMessage();
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public boolean u() {
        return w() >= 200 && w() < 300;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public int w() {
        try {
            return this.xj.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public long xj() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public e y() {
        try {
            return new c(this.xj);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String xj(String str) {
        return this.xj.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String xj(String str, String str2) {
        return !TextUtils.isEmpty(xj(str)) ? xj(str) : str2;
    }
}
