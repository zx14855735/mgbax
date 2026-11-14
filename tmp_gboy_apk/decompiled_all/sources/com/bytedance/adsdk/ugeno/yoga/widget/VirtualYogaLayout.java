package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.c;
import com.bytedance.adsdk.ugeno.yoga.p;
import com.bytedance.adsdk.ugeno.yoga.tf;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final Map<View, tf> hf;
    private final tf w;
    private final List<View> xj;

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.xj(this);
            tf yogaNode = virtualYogaLayout.getYogaNode();
            tf tfVar = this.w;
            tfVar.xj(yogaNode, tfVar.xj());
            return;
        }
        tf xj = p.xj();
        YogaLayout.xj(new YogaLayout.xj(layoutParams), xj, view);
        xj.xj(view);
        xj.xj((c) new YogaLayout.hf());
        tf tfVar2 = this.w;
        tfVar2.xj(xj, tfVar2.xj());
        xj(view, xj);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.xj;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.xj(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.xj(layoutParams);
    }

    public tf getYogaNode() {
        return this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    public void xj(View view, tf tfVar) {
        this.xj.add(view);
        this.hf.put(view, tfVar);
    }

    public void xj(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.xj) {
                ((VirtualYogaLayout) viewGroup).xj(view, this.hf.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.xj) {
                ((YogaLayout) viewGroup).xj(view2, this.hf.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.xj.clear();
    }
}
