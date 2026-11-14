package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsAppTagsView extends LinearLayout {
    private int Nb;

    public KsAppTagsView(Context context) {
        super(context);
        this.Nb = 3;
    }

    public final void a(List<String> list, int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.Nb) {
                return;
            } else {
                a(this, str, i);
            }
        }
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i) {
        this.Nb = i;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nb = 3;
    }

    private static void a(LinearLayout linearLayout, String str, int i) {
        TextView textView = (TextView) m.a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nb = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Nb = 3;
    }
}
