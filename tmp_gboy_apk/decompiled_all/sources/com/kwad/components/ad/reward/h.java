package com.kwad.components.ad.reward;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.czhj.sdk.common.Constants;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String sQ = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String sR = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a sP;

    public interface a extends com.kwad.components.core.webview.tachikoma.f.c {
        void h(int i, int i2);

        void hi();
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void H(boolean z) {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void h(int i, int i2) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hb() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void hi() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hj() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hk() {
        }
    }

    public static c a(g gVar, String str) {
        int i;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.sq;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.sr;
        int i2 = gVar.ss;
        boolean k = com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.er(adTemplate)));
        int i3 = 0;
        if (k || com.kwad.sdk.core.response.b.e.O(adTemplate)) {
            int ae = (int) com.kwad.sdk.core.response.b.a.ae(er);
            int M = com.kwad.sdk.core.response.b.a.M(er);
            if (ae > M) {
                ae = M;
            }
            long playDuration = gVar.rH.getPlayDuration();
            if (playDuration < (ae * 1000) - 800 && (i = (int) (ae - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i3 = i;
            }
        }
        return (!k || aVar == null) ? (!com.kwad.sdk.core.response.b.e.O(adTemplate) || aVar2 == null) ? com.kwad.components.ad.reward.a.b.i(er) ? c.h(er) : (com.kwad.sdk.core.response.b.a.ck(er) == 1 && com.kwad.components.ad.reward.a.b.hK() == 1) ? c.a(er, i2) : adTemplate.isNativeRewardPreview ? c.h(str, i2) : com.kwad.sdk.core.response.b.a.cS(er) ? c.c(adTemplate, i2) : com.kwad.sdk.core.response.b.a.cs(adTemplate) ? c.d(adTemplate, i2) : com.kwad.components.ad.reward.a.b.hE() == 1 ? c.n(i2) : c.E(str) : c.a(aVar2, adTemplate, String.valueOf(i3)) : c.a(aVar, adTemplate, String.valueOf(i3));
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.ho(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.ta, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hk();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.hi();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString(CtFAbx.BI9f7h("再看", str, "秒，即可获得奖励"));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    public static c g(String str, int i) {
        return c.h(str, i);
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
        a aVar = this.sP;
        if (aVar != null) {
            aVar.hb();
        }
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public String sW;
        public String sX;
        public String sY;
        public String sZ;
        public com.kwad.components.ad.reward.l.b.a sq;
        public com.kwad.components.ad.reward.l.a.a sr;
        public int style;
        public String ta;
        public String tb;
        public String tc;
        public String td;
        public String title;

        private c() {
        }

        public static c E(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.sW = "关闭广告";
            cVar.sX = "继续观看";
            return cVar;
        }

        public static c F(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void G(String str) {
            this.td = str;
        }

        public static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.sq = aVar;
            cVar.sZ = str;
            cVar.ta = com.kwad.sdk.core.response.b.a.cp(com.kwad.sdk.core.response.b.e.er(adTemplate));
            return cVar;
        }

        public static c c(AdTemplate adTemplate, long j) {
            AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.ta = com.kwad.sdk.core.response.b.a.cp(er);
            cVar.title = "再看" + j + "秒，可获得奖励";
            cVar.tb = com.kwad.sdk.core.response.b.a.cm(er);
            cVar.tc = com.kwad.sdk.core.response.b.a.av(er);
            cVar.sW = "放弃奖励";
            cVar.sX = "继续观看";
            cVar.sY = com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.er(adTemplate));
            return cVar;
        }

        public static c d(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo dx = com.kwad.sdk.core.response.b.b.dx(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.ta = dx.userHeadUrl;
            cVar.title = "再看" + j + "秒，可获得奖励";
            cVar.tb = dx.title;
            cVar.sW = "放弃奖励";
            cVar.sX = "继续观看";
            cVar.sY = com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.er(adTemplate));
            return cVar;
        }

        public static c h(String str, int i) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.sW = "残忍离开";
            cVar.sX = "留下看看";
            if (i > 0) {
                cVar.td = String.valueOf(i);
            }
            return cVar;
        }

        public static c n(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.sW = "残忍离开";
            cVar.sX = "留下看看";
            if (j > 0) {
                cVar.G(String.valueOf(j));
                return cVar;
            }
            cVar.G(null);
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.sq == null) {
                    this.sq = new com.kwad.components.ad.reward.l.b.a();
                }
                this.sq.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.sr == null) {
                    this.sr = new com.kwad.components.ad.reward.l.a.a();
                }
                this.sr.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.sq;
            if (aVar != null) {
                aa.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.sr;
            if (aVar2 != null) {
                aa.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hl() {
            return TextUtils.isEmpty(this.sW) ? "关闭广告" : this.sW;
        }

        public final String hm() {
            return TextUtils.isEmpty(this.sX) ? "继续观看" : this.sX;
        }

        public final com.kwad.components.ad.reward.l.b.a hn() {
            return this.sq;
        }

        public final com.kwad.components.ad.reward.l.a.a ho() {
            return this.sr;
        }

        public final String hp() {
            return this.ta;
        }

        public final String hq() {
            return this.tb;
        }

        public final String hr() {
            return this.tc;
        }

        public final String hs() {
            return TextUtils.isEmpty(this.td) ? "" : CtFAbx.BI9f7h("再看", this.td, "秒，可获得优惠");
        }

        public static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.sr = aVar;
            cVar.sZ = str;
            cVar.ta = com.kwad.sdk.core.response.b.a.cp(com.kwad.sdk.core.response.b.e.er(adTemplate));
            return cVar;
        }

        public static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.av(adInfo);
            cVar.ta = cW.getIcon();
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            cVar.tb = com.kwad.sdk.core.response.b.a.av(adInfo);
            String name = cW.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ay(adInfo);
            }
            cVar.ta = cW.getIcon();
            if (j > 0) {
                cVar.G(String.valueOf(j));
                return cVar;
            }
            cVar.G(null);
            return cVar;
        }
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.sP = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a2;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c F = c.F(string);
        int style = F.getStyle();
        if (style == 1) {
            a2 = a(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sP);
        } else if (style == 2) {
            a2 = b(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sP);
        } else if (style == 4) {
            a2 = c(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sP);
            com.kwad.components.core.s.m.a(new com.kwad.components.core.widget.e(), (ViewGroup) a2);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.sP);
            jVar.a(F);
            a2 = jVar.hQ();
        } else if (style == 6) {
            a2 = a(this, layoutInflater, viewGroup, F, this.sP);
        } else if (style != 8) {
            a2 = a((DialogFragment) this, layoutInflater, viewGroup, F, this.sP);
        } else {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.sP);
            mVar.a(F);
            a2 = mVar.hQ();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return a2;
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.hl());
        textView2.setText(cVar.hm());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hk();
                }
            }
        });
        return inflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(inflate.getContext(), cVar.td));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.hl());
        textView2.setText(cVar.hm());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hk();
                }
            }
        });
        return inflate;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String format;
        int i;
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.kL(), cVar.sZ);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.hp(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.kM());
        String sb2 = sb.toString();
        String str = cVar.sZ;
        boolean equals = Constants.FAIL.equals(str);
        if (equals) {
            format = String.format(sQ, sb2);
        } else {
            format = String.format(sR, str);
        }
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i = 1 + indexOf;
            } else {
                i = str.length() > 1 ? indexOf + 3 : indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.H(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.hk();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hn(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }
}
