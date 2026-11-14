package com.bytedance.sdk.component.f.hf.xj;

import android.content.Context;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.c;
import com.bytedance.sdk.component.f.hf.xj.xj.hf.f;
import com.bytedance.sdk.component.utils.pl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements kd {
    private List<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> am = new ArrayList();
    private com.bytedance.sdk.component.f.hf.u.hf.xj c;
    private com.bytedance.sdk.component.f.hf.u.hf.xj d;
    private com.bytedance.sdk.component.f.hf.u.hf.xj f;
    private com.bytedance.sdk.component.f.xj.kd g;
    private com.bytedance.sdk.component.f.hf.xj.xj.hf.y hf;
    private com.bytedance.sdk.component.f.hf.xj.xj.hf.xj kd;
    private com.bytedance.sdk.component.f.hf.u.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.component.f.hf.u.hf.xj f10206pl;
    private com.bytedance.sdk.component.f.hf.u.hf.xj tf;
    private c u;
    private com.bytedance.sdk.component.f.hf.xj.xj.hf.kd w;
    private com.bytedance.sdk.component.f.hf.xj.xj.hf.u xj;
    private f y;

    public u(com.bytedance.sdk.component.f.xj.kd kdVar) {
        this.g = kdVar;
        Context context = kdVar.getContext();
        if (com.bytedance.sdk.component.f.hf.hf.xj.xj(kdVar)) {
            com.bytedance.sdk.component.f.hf.u.hf.xj c = this.g.c();
            this.c = c;
            com.bytedance.sdk.component.f.hf.xj.xj.hf.u uVar = new com.bytedance.sdk.component.f.hf.xj.xj.hf.u(context, c, this.g);
            this.xj = uVar;
            this.am.add(uVar);
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.kd(kdVar)) {
            if (this.g.xj() != null) {
                this.d = this.g.xj();
            } else {
                this.d = this.g.f();
            }
            com.bytedance.sdk.component.f.hf.xj.xj.hf.kd kdVar2 = new com.bytedance.sdk.component.f.hf.xj.xj.hf.kd(context, this.d, this.g);
            this.w = kdVar2;
            this.am.add(kdVar2);
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.hf(kdVar)) {
            com.bytedance.sdk.component.f.hf.u.hf.xj f = this.g.f();
            this.f = f;
            com.bytedance.sdk.component.f.hf.xj.xj.hf.y yVar = new com.bytedance.sdk.component.f.hf.xj.xj.hf.y(context, f, this.g);
            this.hf = yVar;
            this.am.add(yVar);
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.w(kdVar)) {
            com.bytedance.sdk.component.f.hf.u.hf.xj f2 = this.g.f();
            this.tf = f2;
            c cVar = new c(context, f2, this.g);
            this.u = cVar;
            this.am.add(cVar);
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.u(kdVar)) {
            com.bytedance.sdk.component.f.hf.u.hf.xj d = this.g.d();
            this.p = d;
            com.bytedance.sdk.component.f.hf.xj.xj.hf.xj xjVar = new com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(context, d, this.g);
            this.kd = xjVar;
            this.am.add(xjVar);
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.y(kdVar)) {
            com.bytedance.sdk.component.f.hf.u.hf.xj y = this.g.y();
            this.f10206pl = y;
            f fVar = new f(context, y, this.g);
            this.y = fVar;
            this.am.add(fVar);
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        try {
            hfVar.hf(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> it = this.am.iterator();
            while (it.hasNext()) {
                it.next().hf(hfVar);
            }
        } catch (Throwable th) {
            pl.xj(th);
            com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(), 1, this.g);
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public hf xj(int i, List<com.bytedance.sdk.component.f.xj.hf> list, int i2) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> it = this.am.iterator();
        hf hfVar = null;
        while (it.hasNext()) {
            hfVar = it.next().xj(i, list);
            if (hfVar.xj()) {
                break;
            }
        }
        return hfVar;
    }

    public List<com.bytedance.sdk.component.f.xj.hf> xj(com.bytedance.sdk.component.f.xj.hf hfVar, int i, int i2, boolean z) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> it = this.am.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.f.xj.hf> xj = it.next().xj(i2, i, hfVar, z);
            if (xj != null && xj.size() != 0) {
                return xj;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> it = this.am.iterator();
        while (it.hasNext()) {
            int i2 = i;
            com.bytedance.sdk.component.f.xj.hf hfVar2 = hfVar;
            boolean z2 = z;
            List<String> list2 = list;
            List<com.bytedance.sdk.component.f.xj.hf> xj = it.next().xj(i2, hfVar2, z2, list2, "db");
            if (xj != null && xj.size() != 0) {
                return xj;
            }
            i = i2;
            hfVar = hfVar2;
            z = z2;
            list = list2;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public boolean xj(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.xj.hf.hf> it = this.am.iterator();
        while (it.hasNext()) {
            if (it.next().xj(i, str, hfVar)) {
                return true;
            }
        }
        return false;
    }
}
