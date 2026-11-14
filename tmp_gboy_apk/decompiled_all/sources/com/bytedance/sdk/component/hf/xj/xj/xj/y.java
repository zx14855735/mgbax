package com.bytedance.sdk.component.hf.xj.xj.xj;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.w.hf.ht;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.pz;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.u;
import com.bytedance.sdk.component.w.hf.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends pl {
    com.bytedance.sdk.component.hf.xj.u g;

    /* renamed from: pl, reason: collision with root package name */
    ra f10210pl;

    public y(pl.xj xjVar) {
        super(xjVar);
        xj(xjVar);
        this.g = new c(this.f10210pl);
    }

    private boolean hf(qt qtVar) {
        byte[] bArr;
        return qtVar != null && qtVar.y == qt.xj.BYTE_ARRAY_TYPE && (bArr = qtVar.kd) != null && bArr.length > 0;
    }

    private boolean w(qt qtVar) {
        return (qtVar == null || qtVar.y != qt.xj.STRING_TYPE || TextUtils.isEmpty(qtVar.u)) ? false : true;
    }

    private void xj(pl.xj xjVar) {
        ra.xj xjVar2 = new ra.xj();
        xjVar2.dk = (int) xjVar.w;
        xjVar2.z = xjVar.u;
        xjVar2.et = (int) xjVar.kd;
        xjVar2.j = xjVar.y;
        xjVar2.f10231io = (int) xjVar.c;
        xjVar2.en = xjVar.f;
        xjVar2.q = xjVar.tf;
        xjVar2.ai = xjVar.p;
        xjVar2.xj(new w(xjVar.hf));
        List<com.bytedance.sdk.component.hf.xj.d> list = xjVar.xj;
        if (list != null && !list.isEmpty()) {
            for (final com.bytedance.sdk.component.hf.xj.d dVar : list) {
                xjVar2.xj(new jk() { // from class: com.bytedance.sdk.component.hf.xj.xj.xj.y.1
                    @Override // com.bytedance.sdk.component.w.hf.jk
                    public q xj(jk.xj xjVar3) {
                        return ((d) dVar.xj(new kd(xjVar3))).xj;
                    }
                });
            }
        }
        this.f10210pl = xjVar2.xj();
    }

    @Override // com.bytedance.sdk.component.hf.xj.pl
    public com.bytedance.sdk.component.hf.xj.u xj() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.hf.xj.pl
    public com.bytedance.sdk.component.hf.xj.hf xj(am amVar) {
        if (amVar == null) {
            return null;
        }
        io.xj xjVar = new io.xj();
        xjVar.xj(amVar.xj());
        if (amVar.hf() != null) {
            xjVar.xj(amVar.hf().xj());
        }
        if (amVar.y() != null) {
            if (w(amVar.y())) {
                xjVar.xj(amVar.w(), x.xj(pz.xj(amVar.y().w.toString()), amVar.y().u));
            } else if (xj(amVar.y())) {
                xjVar.xj(amVar.w(), new ht.xj().xj(ht.kd).xj(amVar.y().hf(), amVar.y().xj(), x.xj(pz.xj("multipart/form-data"), amVar.y().kd)).xj());
            } else if (hf(amVar.y())) {
                xjVar.xj(amVar.w(), x.xj(pz.xj(amVar.y().w.toString()), amVar.y().kd));
            }
        }
        if (amVar.kd() != null && amVar.kd().xj) {
            xjVar.xj(new u.xj().xj().w());
        }
        if (amVar.u() != null && amVar.u().size() > 0) {
            for (Map.Entry<String, List<String>> entry : amVar.u().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    xjVar.xj(entry.getKey(), it.next());
                }
            }
        }
        return new u(this.f10210pl.xj(xjVar.xj()));
    }

    private boolean xj(qt qtVar) {
        byte[] bArr;
        return qtVar != null && qtVar.y == qt.xj.FILE_TYPE && (bArr = qtVar.kd) != null && bArr.length > 0;
    }
}
