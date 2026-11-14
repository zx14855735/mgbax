package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class zg extends AlertDialog {
    private String hf;
    private xj u;
    private boolean w;
    private Context xj;

    public interface xj {
        void hf(String str);

        void xj(String str);
    }

    public zg(Context context, String str) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.xj = context;
        this.hf = str;
        this.w = TextUtils.isEmpty(str);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        xj xjVar = this.u;
        if (xjVar == null) {
            return;
        }
        xjVar.hf(this.hf);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        xj();
    }

    private View hf() {
        LinearLayout linearLayout = new LinearLayout(this.xj);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int w = r.w(this.xj, 10.0f) * 2;
        TextView textView2 = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = w;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int w2 = r.w(this.xj, 25.0f);
        int w3 = r.w(this.xj, 8.0f);
        if (!this.w) {
            Button button = new Button(this.xj);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(w2, w3, w2, w3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(r.w(this.xj, 230.0f), -2);
            layoutParams4.topMargin = w;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.zg.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zg.this.dismiss();
                    if (zg.this.u == null) {
                        return;
                    }
                    zg.this.u.xj(zg.this.hf);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.xj);
        button2.setBackgroundColor(-65536);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(r.w(this.xj, 230.0f), -2);
        layoutParams5.topMargin = w;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(w2, w3, w2, w3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.zg.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zg.this.dismiss();
                if (zg.this.u == null) {
                    return;
                }
                zg.this.u.hf(zg.this.hf);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private void xj() {
        setContentView(hf());
    }

    public void xj(xj xjVar) {
        this.u = xjVar;
    }
}
