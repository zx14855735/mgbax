package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ASJ6gh;
import androidx.viewpager.widget.AaHO0E;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager lb;
    private int lh;
    private ImageView ln;
    private ImageView lo;
    private ImageView lp;
    private int lq;
    private final ASJ6gh lr;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    private void dE() {
        int i = this.lq;
        if (i < this.lh - 1) {
            this.lb.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.ln = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.lo = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.lp = imageView;
        com.kwad.sdk.c.a.a.a(this, this.ln, this.lo, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c J;
        if (view.equals(this.ln)) {
            dE();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 162);
        } else if (view.equals(this.lo)) {
            dE();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 36);
        } else {
            if (!view.equals(this.lp) || (J = this.lb.J(this.lq)) == null) {
                return;
            }
            J.fd();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lr = new AaHO0E() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.AaHO0E, androidx.viewpager.widget.ASJ6gh
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.lq = i2;
                if (InterstitialAggregateManualTipsView.this.lq == InterstitialAggregateManualTipsView.this.lh - 1) {
                    InterstitialAggregateManualTipsView.this.ln.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.lo.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.ln.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.lo.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }
}
