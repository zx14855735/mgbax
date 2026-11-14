package com.bytedance.sdk.openadsdk.w;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.app.Application;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.w.xj;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class u implements Function<SparseArray<Object>, Object> {
    private static volatile u xj;
    private w hf;
    private final xj w = new xj();

    private u() {
    }

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public Application.ActivityLifecycleCallbacks hf() {
        return this.w;
    }

    public void xj(w wVar) {
        this.hf = wVar;
    }

    private void xj(final hf hfVar) {
        this.w.xj(new xj.InterfaceC0209xj() { // from class: com.bytedance.sdk.openadsdk.w.u.1
            @Override // com.bytedance.sdk.openadsdk.w.xj.InterfaceC0209xj
            public void hf() {
                hfVar.hf();
            }

            @Override // com.bytedance.sdk.openadsdk.w.xj.InterfaceC0209xj
            public void xj() {
                hfVar.xj();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> xj2;
        Object apply;
        int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (intValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 5);
            return sparseArray2;
        }
        if (intValue != 14) {
            switch (intValue) {
                case 2:
                    return this.w.xj();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    w wVar = this.hf;
                    if (wVar != null && (xj2 = wVar.xj(4)) != null) {
                        apply = xj2.apply(sparseArray);
                        return apply;
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (BpkvW3.BmvVmW(obj)) {
                        xj(new hf(AaHO0E.AYUAbz(obj)));
                        return null;
                    }
                    return null;
                case 10:
                    w wVar2 = this.hf;
                    if (wVar2 != null) {
                        return wVar2.xj(((Integer) sparseArray.get(0)).intValue());
                    }
                    return null;
                default:
                    return null;
            }
        }
        return this.w.hf();
    }
}
