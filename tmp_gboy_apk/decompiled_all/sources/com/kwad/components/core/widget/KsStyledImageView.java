package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.components.core.s.m;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class KsStyledImageView extends ImageView implements d {
    public KsStyledImageView(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        m.b(eVar, getBackground());
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
