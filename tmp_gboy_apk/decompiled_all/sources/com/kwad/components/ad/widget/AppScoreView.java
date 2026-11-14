package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AppScoreView extends LinearLayout {
    private ImageView MQ;
    private ImageView MR;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.ksad_app_score, this);
        this.MQ = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.MR = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.MQ.setImageResource(R.drawable.ksad_star_checked);
            this.MR.setImageResource(R.drawable.ksad_star_checked);
            return;
        }
        if (d > 4.0d) {
            this.MQ.setImageResource(R.drawable.ksad_star_checked);
            this.MR.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d > 3.5d) {
            this.MQ.setImageResource(R.drawable.ksad_star_checked);
            this.MR.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.MQ.setImageResource(R.drawable.ksad_star_half);
            this.MR.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            this.MQ.setImageResource(R.drawable.ksad_star_unchecked);
            this.MR.setImageResource(R.drawable.ksad_star_unchecked);
        }
    }

    public AppScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
