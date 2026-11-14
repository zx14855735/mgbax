package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import com.kwad.sdk.o.m;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends Dialog {
    public c(Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
