package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.utils.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SigAdInfoView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13638a;
    private TextView b;
    private TextView c;
    private SigAdPrivacyInfoView d;
    private boolean e;

    public SigAdInfoView(Context context) {
        super(context);
        this.e = false;
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, this.e ? "sig_ad_app_info_small_layout" : "sig_ad_app_info_layout"), this);
        this.f13638a = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.b = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.d = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.d;
    }

    public void setAppInfoView(String str, String str2, String str3) {
        if (o.b(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.f13638a);
        }
        if (o.b(str2)) {
            this.b.setText(str2);
        }
        if (o.b(str3)) {
            this.c.setText(str3);
        }
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.e = attributeSet.getAttributeBooleanValue(null, "sig_isSmall", false);
        a(context);
    }

    public SigAdInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        a(context);
    }
}
