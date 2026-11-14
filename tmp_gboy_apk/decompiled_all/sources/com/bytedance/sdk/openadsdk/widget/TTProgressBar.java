package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.bytedance.sdk.component.utils.pl;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTProgressBar extends ProgressBar {
    public TTProgressBar(Context context) {
        super(context);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            try {
                super.onRestoreInstanceState(parcelable);
            } catch (Throwable th) {
                pl.xj(th);
            }
        } catch (Exception unused) {
            Field field = getClass().getField("mPrivateFlags");
            field.setAccessible(true);
            field.set(this, Integer.valueOf(((Integer) field.get(this)).intValue() | WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        }
    }

    public TTProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
