package com.kwad.sdk.n.a;

import android.text.TextUtils;
import android.util.Log;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_b";
    public Object bco;
    public String bcp;
    public String bcq;
    public boolean bcr;
    public String bcs;
    public C0384b bct;
    public b bcu;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public Object bcA;
        public List<Object> bcB;
        public String bcv;
        public String bcw;
        public String bcx;
        public List<String> bcy;
        public List<a> bcz = new ArrayList();
        public String className;
        public String fieldName;

        private Object QR() {
            Object obj = null;
            try {
            } catch (Exception e) {
                c.d(b.TAG, Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(b.TAG, "SpecialParam className is null");
                return null;
            }
            obj = z.hk(this.className);
            c.d(b.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<a> list = this.bcz;
            if (list != null && !list.isEmpty()) {
                for (a aVar : this.bcz) {
                    aVar.bcA = obj;
                    c.d(b.TAG, "param.ob:" + aVar.bcA);
                    try {
                        z.a(aVar.bcA, aVar.fieldName, aVar.getValue());
                    } catch (Exception e2) {
                        c.d(b.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            c.d(b.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object QS() {
            if (TextUtils.isEmpty(this.bcx)) {
                return ap(this.bcv, this.bcw);
            }
            this.bcB = new ArrayList();
            Iterator<String> it = this.bcy.iterator();
            while (it.hasNext()) {
                Object ap = ap(this.bcx, it.next());
                if (ap != null) {
                    this.bcB.add(ap);
                }
            }
            return this.bcB;
        }

        private static Object ap(String str, String str2) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                if (cls == Long.class) {
                    return Long.valueOf(Long.parseLong(str2));
                }
                if (cls == Float.class) {
                    return Float.valueOf(Float.parseFloat(str2));
                }
                if (cls == Boolean.class) {
                    return Boolean.valueOf(Boolean.parseBoolean(str2));
                }
                if (cls == Double.class) {
                    return Double.valueOf(Double.parseDouble(str2));
                }
                if (cls == String.class) {
                    return str2;
                }
                return null;
            } catch (Exception e) {
                c.w(b.TAG, Log.getStackTraceString(e));
                return null;
            }
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.bcv) && TextUtils.isEmpty(this.bcx)) ? QR() : QS();
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.n.a.b$b, reason: collision with other inner class name */
    public static class C0384b extends com.kwad.sdk.core.response.a.a {
        public boolean bcC;
        public List<a> bcD;
        public Object[] bcE;
        public String name;

        public final boolean QQ() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<a> list = this.bcD;
            return (list == null || list.isEmpty()) && this.bcE == null;
        }

        public final Object[] QT() {
            List<a> list = this.bcD;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.bcD.size()];
            for (int i = 0; i < this.bcD.size(); i++) {
                objArr[i] = this.bcD.get(i).getValue();
            }
            return objArr;
        }
    }

    public final boolean QQ() {
        if (this.bco != null || !TextUtils.isEmpty(this.bcp) || !TextUtils.isEmpty(this.bcq) || !TextUtils.isEmpty(this.bcs)) {
            return false;
        }
        C0384b c0384b = this.bct;
        if (c0384b != null && !c0384b.QQ()) {
            return false;
        }
        b bVar = this.bcu;
        return bVar == null || bVar.QQ();
    }
}
