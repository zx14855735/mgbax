package com.kwad.components.ad.interstitial.h;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.sigmob.sdk.base.views.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends j implements View.OnClickListener {
    private static boolean nU;
    private TextView fv;
    private TextView kn;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.interstitial.f.c mi;
    private KSCornerImageView nQ;
    private TextView nR;
    private TextView nS;
    private TextView nT;

    public static void e(com.kwad.components.ad.interstitial.f.c cVar) {
        if (nU) {
            return;
        }
        nU = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.kV.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void f(com.kwad.components.ad.interstitial.f.c cVar) {
        this.mi = cVar;
    }

    private void initData() {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.nQ, com.kwad.sdk.core.response.b.a.cp(er), this.mAdTemplate, 12);
        this.kn.setText(com.kwad.sdk.core.response.b.a.cm(er));
        this.fv.setText(com.kwad.sdk.core.response.b.a.av(er));
        if (com.kwad.sdk.core.response.b.a.cs(this.mAdTemplate)) {
            this.nR.setText(com.kwad.sdk.core.response.b.a.aF(er));
        }
    }

    private void j(View view) {
        this.nQ = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.kn = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.fv = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.nR = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.nS = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.nT = textView;
        com.kwad.sdk.c.a.a.a(this, this.nQ, this.kn, this.fv, this.nR, this.nS, textView);
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        j(inflate);
        initData();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.f.c cVar = this.mi;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().dx(149).dC(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.mi != null) {
            if (view.equals(this.nQ)) {
                com.kwad.components.ad.interstitial.f.c cVar = this.mi;
                cVar.a(cVar.kV.getContext(), 127, 2, 9);
            } else if (view.equals(this.kn)) {
                com.kwad.components.ad.interstitial.f.c cVar2 = this.mi;
                cVar2.a(cVar2.kV.getContext(), r.b.d, 2, 9);
            } else if (view.equals(this.fv)) {
                com.kwad.components.ad.interstitial.f.c cVar3 = this.mi;
                cVar3.a(cVar3.kV.getContext(), 129, 2, 9);
            } else if (view.equals(this.nR)) {
                com.kwad.components.ad.interstitial.f.c cVar4 = this.mi;
                cVar4.a(cVar4.kV.getContext(), 131, 2, 9);
            } else if (view.equals(this.nS)) {
                com.kwad.sdk.core.adlog.c.c(this.mi.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dC(9));
            } else if (view.equals(this.nT)) {
                com.kwad.components.ad.interstitial.f.c cVar5 = this.mi;
                cVar5.a(false, -1, cVar5.cq);
                this.mi.kV.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.mi.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().dx(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS).dC(9));
            }
        }
        dismiss();
        nU = false;
    }
}
