package com.bytedance.sdk.openadsdk.zg.w.hf;

import IzHBwY.A5SV6n;
import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements Function<SparseArray<Object>, Object> {
    private Function<SparseArray<Object>, Object> xj;

    public y(Function<SparseArray<Object>, Object> function) {
        A5SV6n a5SV6n = AYUAbz.f4118ADYaiT;
        this.xj = a5SV6n;
        this.xj = function == null ? a5SV6n : function;
    }

    public String hf() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(241104, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    public boolean kd() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public List<y> u() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(241108, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new y(com.bytedance.sdk.openadsdk.ai.w.xj(it.next())));
        }
        return arrayList;
    }

    public boolean w() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = J3FDQU.A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            if (intValue == -99999986) {
                return new SparseArray();
            }
            switch (intValue) {
                case 241101:
                    xj(new y(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()))));
                    return null;
                case 241102:
                    xj(ADYaiT2.booleanValue(0, false));
                    return null;
                case 241103:
                    return xj();
                case 241104:
                    return hf();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(w()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(y()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(kd()));
                case 241108:
                    return u();
            }
        }
        return null;
    }

    public boolean y() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public String xj() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(241103, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    public void xj(y yVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, yVar);
        A2egSU.B2KMhB(241101, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    public void xj(boolean z) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }
}
