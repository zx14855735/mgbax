package com.google.android.material.timepicker;

import Oay4Bh.C2rE4F;
import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import com.sigmob.sdk.archives.tar.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends C2rE4F {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f11981AcNBzu;

    public A2egSU(ChipTextInputComboView chipTextInputComboView) {
        this.f11981AcNBzu = chipTextInputComboView;
    }

    @Override // Oay4Bh.C2rE4F, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean isEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f11981AcNBzu;
        if (isEmpty) {
            chipTextInputComboView.f11991AcNBzu.setText(ChipTextInputComboView.A2egSU(chipTextInputComboView, e.V));
            return;
        }
        String A2egSU2 = ChipTextInputComboView.A2egSU(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.f11991AcNBzu;
        if (TextUtils.isEmpty(A2egSU2)) {
            A2egSU2 = ChipTextInputComboView.A2egSU(chipTextInputComboView, e.V);
        }
        chip.setText(A2egSU2);
    }
}
