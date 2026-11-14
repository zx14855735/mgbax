package com.sigmob.sdk.nativead;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n extends RelativeLayout {
    public n(Context context) {
        super(context);
        View.inflate(context, getLayoutId(), this);
        TextView textView = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_name"));
        TextView textView2 = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_ver"));
        TextView textView3 = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_dev"));
        TextView textView4 = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_privacy"));
        TextView textView5 = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_permissions"));
        TextView textView6 = (TextView) findViewById(ResourceUtil.getId(context, "sig_app_info_product"));
        setProperties(textView2);
        setProperties(textView);
        setProperties(textView3);
        setProperties(textView4);
        setProperties(textView5);
        setProperties(textView6);
    }

    private int getLayoutId() {
        return ResourceUtil.getLayoutId(getContext(), "sig_app_info_layout");
    }

    private void setProperties(TextView textView) {
        if (textView == null) {
            return;
        }
        TextPaint paint = textView.getPaint();
        paint.setFlags(8);
        paint.setAntiAlias(true);
    }

    public void a(String str, String str2) {
    }
}
