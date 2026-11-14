package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf extends AlertDialog {
    private String c;
    private String d;
    private String f;
    private TextView hf;
    private Context kd;
    private xj p;
    private Drawable tf;
    private Button u;
    private Button w;
    private TextView xj;
    private String y;

    public interface xj {
        void onClickNo(Dialog dialog);

        void onClickYes(Dialog dialog);
    }

    public tf(Context context) {
        super(context, jk.f(context, "tt_custom_dialog"));
        this.kd = context;
    }

    private void hf() {
        TextView textView = this.xj;
        if (textView != null) {
            textView.setText(this.y);
            Drawable drawable = this.tf;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.tf.getIntrinsicHeight();
                int w = r.w(this.kd, 45.0f);
                if (intrinsicWidth > w || intrinsicWidth < w) {
                    intrinsicWidth = w;
                }
                if (intrinsicHeight > w || intrinsicHeight < w) {
                    intrinsicHeight = w;
                }
                this.tf.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.xj.setCompoundDrawables(this.tf, null, null, null);
                this.xj.setCompoundDrawablePadding(r.w(this.kd, 10.0f));
            }
        }
        TextView textView2 = this.hf;
        if (textView2 != null) {
            textView2.setText(this.c);
        }
        Button button = this.w;
        if (button != null) {
            button.setText(this.f);
        }
        Button button2 = this.u;
        if (button2 != null) {
            button2.setText(this.d);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.kd.qd(this.kd));
        setCanceledOnTouchOutside(true);
        xj();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        hf();
    }

    public tf u(String str) {
        this.d = str;
        return this;
    }

    public tf w(String str) {
        this.f = str;
        return this;
    }

    private void xj() {
        this.xj = (TextView) findViewById(2114387852);
        this.hf = (TextView) findViewById(2114387654);
        this.w = (Button) findViewById(2114387751);
        this.u = (Button) findViewById(2114387889);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.tf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tf.this.dismiss();
                if (tf.this.p != null) {
                    tf.this.p.onClickYes(tf.this);
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.tf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tf.this.dismiss();
                if (tf.this.p != null) {
                    tf.this.p.onClickNo(tf.this);
                }
            }
        });
    }

    public tf xj(String str) {
        this.y = str;
        return this;
    }

    public tf xj(Drawable drawable) {
        this.tf = drawable;
        return this;
    }

    public tf xj(xj xjVar) {
        this.p = xjVar;
        return this;
    }

    public tf xj(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public tf hf(String str) {
        this.c = str;
        return this;
    }
}
