package com.kwad.components.ad.draw.presenter.livecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsLiveEndAuthorView extends KsLiveAuthorView {
    private boolean eB;

    public KsLiveEndAuthorView(Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void A(Context context) {
        m.inflate(context, R.layout.ksad_draw_author_end_icon, this);
        this.ej = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.el = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.ek = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.em = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.en = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.et = findViewById(R.id.ksad_author_icon_layout);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView, com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsLiveEndAuthorView", "handleMsg MSG_CHECKING");
        final Animator a2 = a((View) this.em, 900L);
        final Animator a3 = a((View) this.en, 1000L);
        final Animator a4 = KsLiveAuthorView.a((View) this.el, false);
        if (this.eB) {
            return;
        }
        if (a2 == null || a3 == null || a4 == null) {
            this.bQ.sendEmptyMessageDelayed(1, 500L);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a4, a2, a3);
        animatorSet.start();
        this.eB = true;
        a4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.KsLiveEndAuthorView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(a2, a3, a4);
                animatorSet2.start();
            }
        });
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public float getWaveEndSize() {
        return getResources().getDimension(R.dimen.ksad_draw_author_end_icon_width);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void j(AdTemplate adTemplate) {
        String cp = com.kwad.sdk.core.response.b.a.cp(e.er(adTemplate));
        if (!TextUtils.isEmpty(cp)) {
            KSImageLoader.loadImage(this.el, cp, adTemplate);
        }
        this.bQ.sendEmptyMessageAtTime(1, 500L);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
