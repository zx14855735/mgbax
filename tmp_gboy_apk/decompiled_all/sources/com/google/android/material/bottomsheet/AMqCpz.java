package com.google.android.material.bottomsheet;

import ADYaiT.CrfGsy;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AMqCpz extends CrfGsy {
    @Override // androidx.fragment.app.B4ZgIw
    public final void dismiss() {
        Dialog dialog = getDialog();
        if (dialog instanceof ADYaiT) {
            boolean z = ((ADYaiT) dialog).ASJ6gh().f11422CqNSpT;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.B4ZgIw
    public final void dismissAllowingStateLoss() {
        Dialog dialog = getDialog();
        if (dialog instanceof ADYaiT) {
            boolean z = ((ADYaiT) dialog).ASJ6gh().f11422CqNSpT;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // ADYaiT.CrfGsy, androidx.fragment.app.B4ZgIw
    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        int theme = getTheme();
        if (theme == 0) {
            TypedValue typedValue = new TypedValue();
            theme = context.getTheme().resolveAttribute(2130968716, typedValue, true) ? typedValue.resourceId : 2131952315;
        }
        ADYaiT aDYaiT = new ADYaiT(context, theme);
        aDYaiT.f11381B9tovu = true;
        aDYaiT.f11382BChYOn = true;
        aDYaiT.f11387BPw6Q8 = new A4TApA(aDYaiT);
        aDYaiT.A5SV6n().ARc23Z(1);
        TypedArray obtainStyledAttributes = aDYaiT.getContext().getTheme().obtainStyledAttributes(new int[]{2130969058});
        aDYaiT.f11385BJ7GGh = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return aDYaiT;
    }
}
