package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.downloadlib.addownload.compliance.u;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj extends Dialog {
    private ClipImageView c;
    private Activity d;
    private LinearLayout f;
    private TextView hf;
    private TextView kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.ss.android.downloadlib.addownload.hf.hf f13832pl;
    private final long tf;
    private TextView u;
    private TextView w;
    private TextView xj;
    private TextView y;

    public xj(Activity activity, long j) {
        super(activity);
        this.d = activity;
        this.tf = j;
        this.f13832pl = w.xj().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.w.xj(this.d);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f13832pl == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(2131493354);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(2131231703);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.p = this.f13832pl.hf;
        xj();
        c.hf("lp_app_dialog_show", this.p);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                c.xj("lp_app_dialog_cancel", xj.this.p);
            }
        });
    }

    private void xj() {
        this.xj = (TextView) findViewById(2131298180);
        this.hf = (TextView) findViewById(2131298183);
        this.w = (TextView) findViewById(2131298178);
        this.u = (TextView) findViewById(2131298177);
        this.kd = (TextView) findViewById(2131298182);
        this.y = (TextView) findViewById(2131298201);
        this.c = (ClipImageView) findViewById(2131296752);
        this.f = (LinearLayout) findViewById(2131297528);
        this.xj.setText(g.xj(this.f13832pl.kd, "--"));
        this.hf.setText("版本号：" + g.xj(this.f13832pl.y, "--"));
        this.w.setText("开发者：" + g.xj(this.f13832pl.c, "应用信息正在完善中"));
        this.c.setRoundRadius(g.xj(pl.getContext(), 8.0f));
        this.c.setBackgroundColor(Color.parseColor("#EBEBEB"));
        u.xj().xj(this.tf, new u.xj() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.2
            @Override // com.ss.android.downloadlib.addownload.compliance.u.xj
            public void xj(Bitmap bitmap) {
                if (bitmap != null) {
                    xj.this.c.setImageBitmap(bitmap);
                } else {
                    c.xj(8, xj.this.p);
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.xj().xj(xj.this.d);
                AppDetailInfoActivity.xj(xj.this.d, xj.this.tf);
                c.xj("lp_app_dialog_click_detail", xj.this.p);
            }
        });
        this.kd.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.xj().xj(xj.this.d);
                AppPrivacyPolicyActivity.xj(xj.this.d, xj.this.tf);
                c.xj("lp_app_dialog_click_privacy", xj.this.p);
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj.this.dismiss();
                c.xj("lp_app_dialog_click_giveup", xj.this.p);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.xj.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.xj("lp_app_dialog_click_download", xj.this.p);
                hf.xj().hf(xj.this.p);
                xj.this.dismiss();
            }
        });
    }
}
