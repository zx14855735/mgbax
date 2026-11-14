package com.bytedance.sdk.component.d.w;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.zg;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements d {
    private int xj;

    public void xj(int i) {
        this.xj = i;
    }

    @Override // com.bytedance.sdk.component.hf.xj.d
    public zg xj(d.xj xjVar) {
        IOException iOException;
        am xj = xjVar.xj();
        if (c.xj().xj(this.xj).hf() != null) {
            c.xj().xj(this.xj).hf().kd();
        }
        String cVar = xj.hf().toString();
        String xj2 = c.xj().xj(this.xj).xj(cVar);
        if (!cVar.equals(xj2)) {
            xj = xj.c().xj(xj2).hf();
        }
        zg zgVar = null;
        try {
            iOException = null;
            zgVar = xjVar.xj(xj);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            c.xj().xj(this.xj).xj(xj, e);
        }
        c.xj().xj(this.xj).xj(xj, zgVar);
        if (iOException == null) {
            return zgVar == null ? xjVar.xj(xj) : zgVar;
        }
        throw iOException;
    }
}
