package com.bytedance.sdk.openadsdk.zg.xj.xj;

import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class y implements FilterWord, Function<SparseArray<Object>, Object> {
    private FilterWord hf;
    private final Function<SparseArray<Object>, Object> xj;

    public y(FilterWord filterWord) {
        this.hf = filterWord;
        this.xj = ARc23Z.f4112ADYaiT;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new y(filterWord));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(241103, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(241104, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(241108, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new y(qt.xj(it.next())));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(241102, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.hf != null) {
            ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
            switch (AMqCpz.intValue(-99999987, 0)) {
                case 241101:
                    this.hf.addOption(new y(qt.xj(AMqCpz.objectValue(0, Object.class))));
                    return null;
                case 241102:
                    this.hf.setIsSelected(AMqCpz.booleanValue(0, false));
                    return null;
                case 241103:
                    return this.hf.getId();
                case 241104:
                    return this.hf.getName();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(this.hf.getIsSelected()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(this.hf.hasSecondOptions()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(this.hf.isValid()));
                case 241108:
                    return this.hf.getOptions();
            }
        }
        return null;
    }

    public y(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }
}
