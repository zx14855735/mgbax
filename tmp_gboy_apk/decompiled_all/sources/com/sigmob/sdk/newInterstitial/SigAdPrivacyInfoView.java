package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.utils.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SigAdPrivacyInfoView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13639a;
    private View b;
    private View c;
    private TextView d;

    public SigAdPrivacyInfoView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_ad_privacy_layout"), this);
        this.f13639a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_logo"));
        this.b = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_view"));
        this.c = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ll"));
        this.d = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_ad_text"));
    }

    public TextView getPrivacyAdText() {
        return this.d;
    }

    public View getPrivacyLl() {
        return this.c;
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(String str, boolean z) {
        if (o.b(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.f13639a);
        }
        this.b.setVisibility(z ? 0 : 8);
    }

    public SigAdPrivacyInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
