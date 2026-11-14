package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.c;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView hf;
    private TextView ht;
    private TextView jk;
    private TextView pz;
    private LinearLayout ra;
    private TextView xj;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.xj = new TextView(this.p);
        this.hf = new TextView(this.p);
        this.jk = new TextView(this.p);
        this.ra = new LinearLayout(this.p);
        this.pz = new TextView(this.p);
        this.ht = new TextView(this.p);
        this.xj.setTag(9);
        this.hf.setTag(10);
        this.jk.setTag(12);
        this.ra.addView(this.jk);
        this.ra.addView(this.ht);
        this.ra.addView(this.hf);
        this.ra.addView(this.pz);
        this.ra.addView(this.xj);
        addView(this.ra, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        this.jk.setText("功能");
        this.hf.setText("权限");
        this.pz.setText(" | ");
        this.ht.setText(" | ");
        this.xj.setText("隐私");
        c cVar = this.f10177pl;
        if (cVar != null) {
            this.jk.setTextColor(cVar.c());
            this.jk.setTextSize(this.f10177pl.kd());
            this.hf.setTextColor(this.f10177pl.c());
            this.hf.setTextSize(this.f10177pl.kd());
            this.pz.setTextColor(this.f10177pl.c());
            this.ht.setTextColor(this.f10177pl.c());
            this.xj.setTextColor(this.f10177pl.c());
            this.xj.setTextSize(this.f10177pl.kd());
            return false;
        }
        this.jk.setTextColor(-1);
        this.jk.setTextSize(12.0f);
        this.hf.setTextColor(-1);
        this.hf.setTextSize(12.0f);
        this.pz.setTextColor(-1);
        this.ht.setTextColor(-1);
        this.xj.setTextColor(-1);
        this.xj.setTextSize(12.0f);
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.c, this.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean w() {
        this.xj.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.xj.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.hf.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.hf.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.jk.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.jk.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }
}
