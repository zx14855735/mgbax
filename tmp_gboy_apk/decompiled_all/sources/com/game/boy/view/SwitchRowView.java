package com.game.boy.view;

import DRlcZ9.A2egSU;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.game.boy.R$styleable;
import com.google.android.material.materialswitch.MaterialSwitch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SwitchRowView extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public CharSequence f11136AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CharSequence f11137AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CharSequence f11138AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final TextView f11139AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final TextView f11140B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final MaterialSwitch f11141B2KMhB;

    public SwitchRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AMqCpz);
        CharSequence text = obtainStyledAttributes.getText(3);
        this.f11136AcNBzu = obtainStyledAttributes.getText(0);
        this.f11137AlLFFp = obtainStyledAttributes.getText(2);
        this.f11138AmA8tU = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(2131493348, this);
        TextView textView = (TextView) findViewById(2131298050);
        this.f11139AzWtSf = textView;
        this.f11140B25kr6 = (TextView) findViewById(2131298048);
        MaterialSwitch materialSwitch = (MaterialSwitch) findViewById(2131298049);
        this.f11141B2KMhB = materialSwitch;
        textView.setText(text);
        A2egSU();
        materialSwitch.setOnCheckedChangeListener(new A2egSU(3, this));
    }

    public final void A2egSU() {
        CharSequence charSequence;
        boolean isChecked = this.f11141B2KMhB.isChecked();
        if ((!isChecked || (charSequence = this.f11137AlLFFp) == null) && (isChecked || (charSequence = this.f11138AmA8tU) == null)) {
            charSequence = this.f11136AcNBzu;
        }
        this.f11140B25kr6.setText(charSequence);
    }

    public MaterialSwitch getMaterialSwitch() {
        return this.f11141B2KMhB;
    }

    public CharSequence getSubtitle() {
        return this.f11136AcNBzu;
    }

    public CharSequence getSubtitleOff() {
        return this.f11138AmA8tU;
    }

    public CharSequence getSubtitleOn() {
        return this.f11137AlLFFp;
    }

    public CharSequence getTitle() {
        return this.f11139AzWtSf.getText();
    }

    public void setMaterialSwitChecked(boolean z) {
        getMaterialSwitch().setChecked(z);
        A2egSU();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f11136AcNBzu = charSequence;
        A2egSU();
    }

    public void setSubtitleOff(CharSequence charSequence) {
        this.f11138AmA8tU = charSequence;
        A2egSU();
    }

    public void setSubtitleOn(CharSequence charSequence) {
        this.f11137AlLFFp = charSequence;
        A2egSU();
    }

    public void setTitle(CharSequence charSequence) {
        this.f11139AzWtSf.setText(charSequence);
    }
}
