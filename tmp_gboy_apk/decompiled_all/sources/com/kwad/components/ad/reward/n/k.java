package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class k extends d implements com.kwad.sdk.widget.d {
    private KsPriceView CA;
    private TextView CD;
    private TextView CE;
    private View CF;
    private ViewStub CZ;
    private ViewGroup Da;
    private KsStyledTextButton Db;
    private KsStyledTextButton Dc;
    private TextView fv;
    private TextView kn;
    private KSCornerImageView nQ;
    private com.kwad.components.ad.reward.g tq;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.CZ = viewStub;
        this.tq = gVar;
    }

    private void f(View view, boolean z) {
        boolean equals = view.equals(this.Dc);
        int i = MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT;
        if (equals) {
            com.kwad.components.ad.reward.g gVar = this.tq;
            Context context = view.getContext();
            if (z) {
                i = 38;
            }
            gVar.a(2, context, i, 1);
            return;
        }
        if (view.equals(this.Db)) {
            com.kwad.components.ad.reward.g gVar2 = this.tq;
            Context context2 = view.getContext();
            if (z) {
                i = 37;
            }
            gVar2.a(2, context2, i, 1);
            return;
        }
        if (view.equals(this.Da)) {
            com.kwad.components.ad.reward.g gVar3 = this.tq;
            Context context3 = view.getContext();
            if (z) {
                i = 2;
            }
            gVar3.a(2, context3, i, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.R(rVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eg(this.tq.mAdTemplate)) {
            f(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hQ() {
        return this.Da;
    }

    public final void hide() {
        ViewGroup viewGroup = this.Da;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.Da = viewGroup;
        this.tq = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.nQ, aVar.hp(), adTemplate, 8);
        this.kn.setText(aVar.getTitle());
        this.fv.setText(aVar.hq());
        int dimensionPixelSize = this.Da.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.CA.getConfig().au(dimensionPixelSize).aw(dimensionPixelSize).av(this.Da.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.CA.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String ih = aVar.ih();
        this.CF.setVisibility(TextUtils.isEmpty(ih) ? 8 : 0);
        if (ih != null) {
            this.CD.setText(ih);
        }
        this.CE.setText(aVar.ii());
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        f(view, true);
    }
}
