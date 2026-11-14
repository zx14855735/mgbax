package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13642a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private Button e;
    private ImageView f;
    private SigAdPrivacyInfoView g;
    private w h;
    private View i;

    public h(Context context) {
        super(context);
        a(context);
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.g;
    }

    public Button getCTAButton() {
        return this.e;
    }

    public View getCloseButton() {
        return this.f13642a;
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_endcard_layout"), this);
        this.i = inflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_close"));
        ImageView imageView = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.f13642a = imageView;
        if (q.b(imageView)) {
            this.f13642a.setImageBitmap(s.CLOSE_OLD.a());
        }
        this.b = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.c = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.d = (TextView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.e = (Button) inflate.findViewById(ResourceUtil.getId(context, "sig_cta_button"));
        this.f = (ImageView) inflate.findViewById(ResourceUtil.getId(context, "sig_endCard_image"));
        this.g = (SigAdPrivacyInfoView) inflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.h == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.h = wVar;
            wVar.setText("反馈");
            this.h.setOnClickListener(onClickListener);
            this.h.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.i.getId());
            layoutParams.addRule(8, this.i.getId());
            ViewParent parent = this.i.getParent();
            if (parent == null) {
                return;
            }
            ((ViewGroup) parent).addView(this.h, layoutParams);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (o.b(str)) {
            com.sigmob.sdk.base.common.h.a().load(str).into(this.b);
        }
        if (o.b(str2) || o.b(str)) {
            if (!o.a((CharSequence) str2)) {
                str = str2;
            }
            com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.newInterstitial.h.1
                @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                }

                @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    com.sigmob.sdk.base.blurkit.a.a(h.this.getContext());
                    Bitmap a2 = com.sigmob.sdk.base.blurkit.a.a().a(bitmap.copy(bitmap.getConfig(), true), 25);
                    if (a2 == null) {
                        return;
                    }
                    h.this.f.setImageBitmap(a2);
                }
            });
        }
        if (o.b(str3)) {
            this.c.setText(str3);
        }
        if (o.b(str4)) {
            this.d.setText(str4);
        }
        if (o.b(str5)) {
            this.e.setText(str5);
        }
    }
}
