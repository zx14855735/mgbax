package com.game.boy.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MarqueeTextView extends AppCompatTextView {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f11129B4ZgIw;

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
        setSingleLine(true);
        setHorizontallyScrolling(true);
    }

    public void setMarqueeEnabled(boolean z) {
        if (this.f11129B4ZgIw != z) {
            this.f11129B4ZgIw = z;
            setSelected(z);
        }
    }
}
