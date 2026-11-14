package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: BniPrB, reason: collision with root package name */
    public static final /* synthetic */ int f12022BniPrB = 0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final Chip f12023BmvVmW;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AZkASS aZkASS = new AZkASS(this);
        LayoutInflater.from(context).inflate(2131493222, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(2131297561);
        materialButtonToggleGroup.f11488BChYOn.add(new AZOQYO());
        Chip chip = (Chip) findViewById(2131297572);
        Chip chip2 = (Chip) findViewById(2131297569);
        this.f12023BmvVmW = chip2;
        AcNBzu acNBzu = new AcNBzu(new GestureDetector(getContext(), new AaHO0E(this)));
        chip.setOnTouchListener(acNBzu);
        chip2.setOnTouchListener(acNBzu);
        chip.setTag(2131297907, 12);
        chip2.setTag(2131297907, 10);
        chip.setOnClickListener(aZkASS);
        chip2.setOnClickListener(aZkASS);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.f12023BmvVmW.sendAccessibilityEvent(8);
        }
    }
}
