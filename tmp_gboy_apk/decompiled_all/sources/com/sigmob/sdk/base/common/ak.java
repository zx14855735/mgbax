package com.sigmob.sdk.base.common;

import android.content.Context;
import android.widget.Toast;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ak extends Toast {
    public ak(Context context) {
        super(context);
    }

    public static Toast a(Context context, CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(context, charSequence, i);
        makeText.setGravity(17, 0, 0);
        return makeText;
    }
}
