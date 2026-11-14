package com.bytedance.sdk.component.xj;

import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.xj.ht;
import com.bytedance.sdk.component.xj.pz;
import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.component.xj.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class c implements ht.xj {
    private final g c;
    private final boolean d;
    private final boolean f;
    private final jk hf;
    private final com.bytedance.sdk.component.xj.xj tf;
    private final f xj;
    private final Map<String, hf> w = new HashMap();
    private final Map<String, u.hf> u = new HashMap();
    private final List<zg> kd = new ArrayList();
    private final Set<u> y = new HashSet();

    public static final class xj {
        String hf;
        boolean xj;

        private xj(boolean z, String str) {
            this.xj = z;
            this.hf = str;
        }
    }

    public c(tf tfVar, com.bytedance.sdk.component.xj.xj xjVar, pz pzVar) {
        this.tf = xjVar;
        this.xj = tfVar.u;
        jk jkVar = new jk(pzVar, tfVar.f10256pl, tfVar.g);
        this.hf = jkVar;
        jkVar.xj(this);
        jkVar.xj(tfVar.zg);
        this.c = tfVar.d;
        this.f = tfVar.f;
        this.d = tfVar.qt;
    }

    private ra hf(String str, hf hfVar) {
        return this.d ? ra.PRIVATE : this.hf.xj(this.f, str, hfVar);
    }

    @MainThread
    public xj xj(zg zgVar, y yVar) {
        hf hfVar = this.w.get(zgVar.u);
        if (hfVar != null) {
            try {
                ra hf = hf(yVar.hf, hfVar);
                yVar.u = hf;
                if (hf == null) {
                    d.xj("Permission denied, call: ".concat(String.valueOf(zgVar)));
                    throw new yo(-1);
                }
                if (hfVar instanceof kd) {
                    d.xj("Processing stateless call: ".concat(String.valueOf(zgVar)));
                    return xj(zgVar, (kd) hfVar, yVar);
                }
                if (hfVar instanceof w) {
                    d.xj("Processing raw call: ".concat(String.valueOf(zgVar)));
                    return xj(zgVar, (w) hfVar, hf);
                }
            } catch (pz.xj e) {
                d.xj("No remote permission config fetched, call pending: ".concat(String.valueOf(zgVar)), e);
                this.kd.add(zgVar);
                return new xj(false, dk.xj());
            }
        }
        u.hf hfVar2 = this.u.get(zgVar.u);
        if (hfVar2 == null) {
            d.hf("Received call: " + zgVar + ", but not registered.");
            return null;
        }
        u xj2 = hfVar2.xj();
        xj2.xj(zgVar.u);
        ra hf2 = hf(yVar.hf, xj2);
        yVar.u = hf2;
        if (hf2 != null) {
            d.xj("Processing stateful call: ".concat(String.valueOf(zgVar)));
            return xj(zgVar, xj2, yVar);
        }
        d.xj("Permission denied, call: ".concat(String.valueOf(zgVar)));
        xj2.kd();
        throw new yo(-1);
    }

    public void xj(String str, kd<?, ?> kdVar) {
        kdVar.xj(str);
        this.w.put(str, kdVar);
        d.xj("JsBridge stateless method registered: ".concat(String.valueOf(str)));
    }

    public void xj(String str, u.hf hfVar) {
        this.u.put(str, hfVar);
        d.xj("JsBridge stateful method registered: ".concat(String.valueOf(str)));
    }

    public void xj() {
        Iterator<u> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().y();
        }
        this.y.clear();
        this.w.clear();
        this.u.clear();
        this.hf.hf(this);
    }

    @MainThread
    private xj xj(zg zgVar, kd kdVar, y yVar) {
        return new xj(true, dk.xj(this.xj.xj((f) kdVar.xj(xj(zgVar.kd, (hf) kdVar), yVar))));
    }

    @MainThread
    private xj xj(final zg zgVar, final u uVar, y yVar) {
        this.y.add(uVar);
        uVar.xj(xj(zgVar.kd, uVar), yVar, new u.xj() { // from class: com.bytedance.sdk.component.xj.c.1
            @Override // com.bytedance.sdk.component.xj.u.xj
            public void xj(Object obj) {
                if (c.this.tf == null) {
                    return;
                }
                c.this.tf.hf(dk.xj(c.this.xj.xj((f) obj)), zgVar);
                c.this.y.remove(uVar);
            }

            @Override // com.bytedance.sdk.component.xj.u.xj
            public void xj(Throwable th) {
                if (c.this.tf == null) {
                    return;
                }
                c.this.tf.hf(dk.xj(th), zgVar);
                c.this.y.remove(uVar);
            }
        });
        return new xj(false, dk.xj());
    }

    @MainThread
    private xj xj(final zg zgVar, w wVar, ra raVar) {
        new v(zgVar.u, raVar, new v.xj() { // from class: com.bytedance.sdk.component.xj.c.2
        });
        return new xj(false, dk.xj());
    }

    private Object xj(String str, hf hfVar) {
        return this.xj.xj(str, xj(hfVar)[0]);
    }

    private static Type[] xj(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
