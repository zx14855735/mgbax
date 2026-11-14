package com.bytedance.embedapplog;

import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class b extends l {
    private static final long[] hf = {60000};
    private boolean u;
    private long w;

    static {
        bgeYQX();
    }

    public b(a aVar) {
        super(aVar);
        this.u = true;
    }

    private static /* synthetic */ void bgeYQX() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.embedapplog.l
    public long[] hf() {
        return hf;
    }

    @Override // com.bytedance.embedapplog.l
    public String u() {
        return "s";
    }

    @Override // com.bytedance.embedapplog.l
    public boolean w() {
        Bundle xj;
        long currentTimeMillis = System.currentTimeMillis();
        ws c = this.xj.c();
        if (c != null && (xj = c.xj(currentTimeMillis, 50000L)) != null) {
            xj.xj("play_session", xj, 1);
            xj.hf();
        }
        h w = this.xj.w();
        aq kd = this.xj.kd();
        if (kd.pl() != 0) {
            JSONObject w2 = no.w(kd.xj());
            if (w2 != null) {
                xj(w.xj(w2));
                this.w = System.currentTimeMillis();
                return true;
            }
            cu.hf((Throwable) null);
        }
        return false;
    }

    public void xj(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.embedapplog.l
    public long xj() {
        long et = this.xj.u().et();
        if (et > 60000 || et <= 0) {
            et = 60000;
        }
        hf[0] = et;
        return this.w + et;
    }

    private void xj(ArrayList<t> arrayList) {
        int i;
        h w = this.xj.w();
        ArrayList<t> arrayList2 = new ArrayList<>();
        ArrayList<t> arrayList3 = new ArrayList<>();
        wn u = this.xj.u();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<t> xj = w.xj();
        if (!xj.isEmpty()) {
            arrayList4.addAll(xj);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                t tVar = (t) it.next();
                byte[] bArr = tVar.f10109pl;
                if (bArr != null && bArr.length > 0) {
                    if (this.u) {
                        a aVar = this.xj;
                        i = gj.xj(cy.xj(aVar, aVar.hf(), this.xj.kd().xj()), tVar.f10109pl, u);
                    } else {
                        i = 200;
                    }
                    if (gj.xj(i)) {
                        if (arrayList.contains(tVar)) {
                            tVar.am = i;
                            arrayList3.add(tVar);
                        }
                    } else if (i == 200) {
                        arrayList2.add(tVar);
                    } else {
                        tVar.am = i;
                        arrayList3.add(tVar);
                    }
                } else {
                    arrayList2.add(tVar);
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                w.xj(arrayList2, arrayList3, arrayList);
            }
            cu.u(u() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
