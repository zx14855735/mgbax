package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.dynamic.w.y;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.hf.p;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.sigmob.sdk.base.views.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.u, com.bytedance.sdk.component.adexpress.theme.xj {
    private int am;
    private ThemeStatusBroadcastReceiver c;
    private ViewGroup d;
    private String e;
    private com.bytedance.sdk.component.adexpress.dynamic.hf f;
    private int g;
    boolean hf;
    private DynamicBaseWidget kd;
    private List<com.bytedance.sdk.component.adexpress.dynamic.w> p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.kd f10178pl;
    private g qt;
    private int tf;
    private p u;
    public View w;
    protected final am xj;
    private com.bytedance.sdk.component.adexpress.dynamic.kd.xj y;
    private Map<Integer, String> yo;
    private Context zg;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar) {
        super(context);
        this.d = null;
        this.tf = 0;
        this.p = new ArrayList();
        this.g = 0;
        this.am = 0;
        this.zg = context;
        am amVar = new am();
        this.xj = amVar;
        amVar.xj(2);
        this.y = xjVar;
        xjVar.xj(this);
        this.c = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.xj(this);
        this.hf = z;
        this.qt = gVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.xj
    public void b_(int i) {
        DynamicBaseWidget dynamicBaseWidget = this.kd;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.xj(i);
    }

    public String getBgColor() {
        return this.e;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.yo;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.kd.xj getDynamicClickListener() {
        return this.y;
    }

    public int getLogoUnionHeight() {
        return this.g;
    }

    public p getRenderListener() {
        return this.u;
    }

    public g getRenderRequest() {
        return this.qt;
    }

    public int getScoreCountWithIcon() {
        return this.am;
    }

    public ViewGroup getTimeOut() {
        return this.d;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.w> getTimeOutListener() {
        return this.p;
    }

    public int getTimedown() {
        return this.tf;
    }

    public void hf() {
        xj(this.kd, 4);
    }

    public void setBgColor(String str) {
        this.e = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.yo = map;
    }

    public void setDislikeView(View view) {
        this.y.hf(view);
    }

    public void setLogoUnionHeight(int i) {
        this.g = i;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.hf hfVar) {
        this.f = hfVar;
    }

    public void setRenderListener(p pVar) {
        this.u = pVar;
        this.y.xj(pVar);
    }

    public void setScoreCountWithIcon(int i) {
        this.am = i;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.hf hfVar = this.f;
        if (hfVar != null) {
            hfVar.setSoundMute(z);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.w wVar) {
        this.p.add(wVar);
    }

    public void setTimeUpdate(int i) {
        this.f10178pl.setTimeUpdate(i);
    }

    public void setTimedown(int i) {
        this.tf = i;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.kd kdVar) {
        this.f10178pl = kdVar;
    }

    public void xj(f fVar, int i) {
        this.kd = xj(fVar, this, i);
        this.xj.xj(true);
        this.xj.xj(this.kd.kd);
        this.xj.hf(this.kd.y);
        this.xj.xj(this.w);
        this.u.xj(this.xj);
    }

    public DynamicBaseWidget xj(f fVar, ViewGroup viewGroup, int i) {
        if (fVar == null) {
            return null;
        }
        List<f> p = fVar.p();
        DynamicBaseWidget xj = com.bytedance.sdk.component.adexpress.dynamic.xj.hf.xj(this.zg, this, fVar);
        if (xj instanceof DynamicUnKnowView) {
            xj(i == 3 ? r.b.d : TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, "unknow widget");
            return null;
        }
        xj(fVar);
        xj.xj();
        if (viewGroup != null) {
            viewGroup.addView(xj);
            xj(viewGroup, fVar);
        }
        if (p == null || p.size() <= 0) {
            return null;
        }
        Iterator<f> it = p.iterator();
        while (it.hasNext()) {
            xj(it.next(), xj, i);
        }
        return xj;
    }

    private void xj(f fVar) {
        y kd;
        com.bytedance.sdk.component.adexpress.dynamic.w.kd tf = fVar.tf();
        if (tf == null || (kd = tf.kd()) == null) {
            return;
        }
        this.xj.hf(kd.ic());
    }

    private void xj(ViewGroup viewGroup, f fVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !fVar.dk()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void xj(double d, double d2, double d3, double d4, float f) {
        this.xj.w(d);
        this.xj.u(d2);
        this.xj.kd(d3);
        this.xj.y(d4);
        this.xj.xj(f);
        this.xj.hf(f);
        this.xj.w(f);
        this.xj.u(f);
    }

    public void xj(int i, String str) {
        this.xj.xj(false);
        this.xj.hf(i);
        this.xj.xj(str);
        this.u.xj(this.xj);
    }

    public void xj() {
        xj(this.kd, 0);
    }

    public void xj(DynamicBaseWidget dynamicBaseWidget, int i) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i);
            View view = dynamicBaseWidget.qt;
            if (view != null) {
                view.setVisibility(i);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (dynamicBaseWidget.getChildAt(i2) instanceof DynamicBaseWidget) {
                xj((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void xj(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            if (this.p.get(i3) != null) {
                this.p.get(i3).xj(charSequence, i == 1, i2, z);
            }
        }
    }
}
