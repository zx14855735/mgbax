package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aq extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f13270a;
    private TextView b;

    public aq(Context context) {
        super(context);
        a();
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.f13270a = textView;
        textView.setId(View.generateViewId());
        this.b = new TextView(getContext());
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f13270a.setTextColor(-1);
        this.f13270a.setSingleLine();
        this.f13270a.setGravity(17);
        this.f13270a.setTextSize(2, 20.0f);
        this.b.setSingleLine();
        this.b.setTextColor(-1);
        this.b.setGravity(17);
        this.b.setTextSize(2, 14.0f);
        addView(this.f13270a, layoutParams);
        addView(this.b, new LinearLayout.LayoutParams(-1, -2));
    }

    public void setDescription(String str) {
        this.b.setText(str);
    }

    public void setTitle(String str) {
        this.f13270a.setText(str);
    }

    public aq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public aq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
