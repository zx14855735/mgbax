package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends AlertDialog {
    private String hf;
    private Context xj;

    public xj(Context context, String str) {
        super(context, jk.f(context, "tt_custom_dialog"));
        this.xj = context == null ? pz.getContext() : context;
        this.hf = str;
    }

    private void xj() {
        ((TextView) findViewById(2114387699)).setText(this.hf);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.kd.b(getContext()));
        xj();
    }
}
