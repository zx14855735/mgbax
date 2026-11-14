package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.CircleImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f13610a;
    private final TextView b;
    private final CircleImageView c;

    public o(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        this.f13610a = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_name"));
        this.b = (TextView) findViewById(ResourceUtil.getId(getContext(), "sig_app_cta"));
        ViewGroup viewGroup = (ViewGroup) findViewById(ResourceUtil.getId(getContext(), "sig_app_icon"));
        CircleImageView circleImageView = new CircleImageView(context);
        this.c = circleImageView;
        circleImageView.setCircle(false);
        circleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(circleImageView, new ViewGroup.LayoutParams(-1, -1));
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_layout");
    }

    public void a(String str, String str2, String str3) {
        this.f13610a.setText(str2);
        this.b.setText(str3);
        Context e = com.sigmob.sdk.b.e();
        if (e == null) {
            return;
        }
        ImageManager.with(e).load(str).into(this.c);
    }

    public View getCtaView() {
        return this.b;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }
}
