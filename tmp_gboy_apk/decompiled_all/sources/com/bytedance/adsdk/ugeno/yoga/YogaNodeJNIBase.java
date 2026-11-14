package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.bytedance.adsdk.ugeno.yoga.xj.xj
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class YogaNodeJNIBase extends tf implements Cloneable {

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    private float[] arr;
    private boolean c;
    private YogaNodeJNIBase hf;
    private hf kd;

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    private int mLayoutDirection;
    private c u;
    private List<YogaNodeJNIBase> w;
    protected long xj;
    private Object y;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.c = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.xj = j;
    }

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.w;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.w.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.hf = this;
        return yogaNodeJNIBase.xj;
    }

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    public final float baseline(float f, float f2) {
        return this.kd.xj(this, f, f2);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void d(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void f(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void kd(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.xj, f);
    }

    @com.bytedance.adsdk.ugeno.yoga.xj.xj
    public final long measure(float f, int i, float f2, int i2) {
        if (pl()) {
            return this.u.xj(this, f, f.xj(i), f2, f.xj(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hf() {
        return this.hf;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void pl(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void tf(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hf(int i) {
        List<YogaNodeJNIBase> list = this.w;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase remove = list.remove(i);
        remove.hf = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.xj, remove.xj);
        return remove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase xj(int i) {
        List<YogaNodeJNIBase> list = this.w;
        if (list != null) {
            return list.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void y(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public float c() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public float d() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public float f() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void kd() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.xj);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void p(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.xj, f);
    }

    public boolean pl() {
        return this.u != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public Object tf() {
        return this.y;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public int xj() {
        List<YogaNodeJNIBase> list = this.w;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public float y() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void hf(xj xjVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.xj, xjVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(tf tfVar, int i) {
        if (tfVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) tfVar;
            if (yogaNodeJNIBase.hf == null) {
                if (this.w == null) {
                    this.w = new ArrayList(4);
                }
                this.w.add(i, yogaNodeJNIBase);
                yogaNodeJNIBase.hf = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.xj, yogaNodeJNIBase.xj, i);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void hf(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void w(xj xjVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.xj, xjVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void hf(u uVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.xj, uVar.xj(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void w(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void u(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void w() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.xj);
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void u() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.xj);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void w(u uVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.xj, uVar.xj(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public int xj(tf tfVar) {
        List<YogaNodeJNIBase> list = this.w;
        if (list == null) {
            return -1;
        }
        return list.indexOf(tfVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).w;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].xj;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.xj, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(w wVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.xj, wVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(kd kdVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.xj, kdVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(y yVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.xj, yVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(xj xjVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.xj, xjVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(g gVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.xj, gVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(am amVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.xj, amVar.xj());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.xj, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(u uVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.xj, uVar.xj(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(c cVar) {
        this.u = cVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.xj, cVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.xj, z);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tf
    public void xj(Object obj) {
        this.y = obj;
    }
}
