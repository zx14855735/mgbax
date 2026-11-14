package com.bytedance.sdk.component.y;

import P8ccfD.AaHO0E;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt implements am, Function {
    am hf;
    Function xj;

    public qt(am amVar) {
        this.hf = amVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (obj2 != null) {
                    obj2 = new et(AaHO0E.AYUAbz(obj2));
                }
                pl plVar = this.hf.to((dk) obj2, ((Integer) obj3).intValue());
                return plVar != null ? new g(plVar) : plVar;
            case 2:
                Object obj4 = sparseArray.get(1);
                if (obj4 != null) {
                    obj4 = new et(AaHO0E.AYUAbz(obj4));
                }
                pl plVar2 = this.hf.to((dk) obj4);
                return plVar2 != null ? new g(plVar2) : plVar2;
            case 3:
                pl plVar3 = this.hf.to((ImageView) sparseArray.get(1));
                return plVar3 != null ? new g(plVar3) : plVar3;
            case 4:
                return this.hf.from((String) sparseArray.get(1));
            case 5:
                return this.hf.key((String) sparseArray.get(1));
            case 6:
                Object obj5 = sparseArray.get(1);
                if (obj5 != null) {
                    obj5 = new w(AaHO0E.AYUAbz(obj5));
                }
                return this.hf.cache((hf) obj5);
            case 7:
                return this.hf.cacheDir((String) sparseArray.get(1));
            case 8:
                return this.hf.scaleType((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.hf.config((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.hf.width(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.hf.height(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.hf.type(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object obj6 = sparseArray.get(1);
                if (obj6 != null) {
                    obj6 = new z(AaHO0E.AYUAbz(obj6));
                }
                return this.hf.track((q) obj6);
            case 14:
                return this.hf.headers(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.hf.requestTime(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.hf.runIn((ExecutorService) sparseArray.get(1));
            case 17:
                Object obj7 = sparseArray.get(1);
                if (obj7 != null) {
                    obj7 = new p(AaHO0E.AYUAbz(obj7));
                }
                return this.hf.converter((tf) obj7);
            case 18:
                return this.hf.maxWidth(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.hf.maxHeight(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.hf.sync(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object obj8 = sparseArray.get(1);
                if (obj8 != null) {
                    obj8 = new pz(AaHO0E.AYUAbz(obj8));
                }
                return this.hf.loadSetp((jk) obj8);
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.y.am
    public am cache(hf hfVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (hfVar != null) {
            hfVar = new w(hfVar);
        }
        sparseArray.put(1, hfVar);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am cacheDir(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(7, sparseArray, 0, 1, str);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am config(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am converter(tf tfVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (tfVar != null) {
            tfVar = new p(tfVar);
        }
        sparseArray.put(1, tfVar);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am from(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(4, sparseArray, 0, 1, str);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am headers(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am height(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(11, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am key(String str) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(5, sparseArray, 0, 1, str);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am loadSetp(jk jkVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (jkVar != null) {
            jkVar = new pz(jkVar);
        }
        sparseArray.put(1, jkVar);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am maxHeight(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(19, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am maxWidth(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(18, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am requestTime(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am runIn(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am scaleType(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am sync(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.y.am
    public pl to(ImageView imageView) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        apply = this.xj.apply(sparseArray);
        g gVar = apply;
        if (apply != 0) {
            gVar = new g((Function) apply);
        }
        return gVar;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am track(q qVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (qVar != null) {
            qVar = new z(qVar);
        }
        sparseArray.put(1, qVar);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am type(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(12, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.y.am
    public am width(int i) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B25kr6(10, sparseArray, 0, i, 1);
        this.xj.apply(sparseArray);
        return this;
    }

    public qt(Function function) {
        this.xj = function;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.y.am
    public pl to(dk dkVar) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (dkVar != null) {
            dkVar = new et(dkVar);
        }
        sparseArray.put(1, dkVar);
        apply = this.xj.apply(sparseArray);
        g gVar = apply;
        if (apply != 0) {
            gVar = new g((Function) apply);
        }
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    @Override // com.bytedance.sdk.component.y.am
    public pl to(dk dkVar, int i) {
        ?? apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (dkVar != null) {
            dkVar = new et(dkVar);
        }
        sparseArray.put(1, dkVar);
        sparseArray.put(2, Integer.valueOf(i));
        apply = this.xj.apply(sparseArray);
        g gVar = apply;
        if (apply != 0) {
            gVar = new g((Function) apply);
        }
        return gVar;
    }
}
