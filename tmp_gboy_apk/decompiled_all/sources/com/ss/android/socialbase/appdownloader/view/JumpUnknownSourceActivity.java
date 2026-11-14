package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.appdownloader.hf;
import com.ss.android.socialbase.appdownloader.w;
import com.ss.android.socialbase.appdownloader.w.g;
import com.ss.android.socialbase.appdownloader.w.pl;
import com.ss.android.socialbase.appdownloader.w.u;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class JumpUnknownSourceActivity extends Activity {
    private Intent hf;
    private JSONObject kd;
    private int u;
    private Intent w;
    private pl xj;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xj();
        f.xj().xj(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        f.xj().xj(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.hf = intent;
        if (intent != null) {
            this.w = (Intent) intent.getParcelableExtra("intent");
            this.u = intent.getIntExtra(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, -1);
            try {
                this.kd = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        if (this.kd == null) {
            w.xj((Activity) this);
            return;
        }
        hf();
        pl plVar = this.xj;
        if (plVar != null && !plVar.hf()) {
            this.xj.xj();
        } else if (this.xj == null) {
            finish();
        }
    }

    private void hf() {
        if (this.xj != null || this.hf == null) {
            return;
        }
        try {
            u hf = com.ss.android.socialbase.appdownloader.u.p().hf();
            g xj = hf != null ? hf.xj(this) : null;
            if (xj == null) {
                xj = new com.ss.android.socialbase.appdownloader.u.xj(this);
            }
            int xj2 = d.xj(this, "tt_appdownloader_tip");
            int xj3 = d.xj(this, "tt_appdownloader_label_ok");
            int xj4 = d.xj(this, "tt_appdownloader_label_cancel");
            String optString = this.kd.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(d.xj(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            xj.xj(xj2).xj(optString).xj(xj3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (hf.xj(jumpUnknownSourceActivity, jumpUnknownSourceActivity.w, JumpUnknownSourceActivity.this.u, JumpUnknownSourceActivity.this.kd)) {
                        hf.w(JumpUnknownSourceActivity.this.u, JumpUnknownSourceActivity.this.kd);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        hf.xj((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.w, true);
                    }
                    hf.xj(JumpUnknownSourceActivity.this.u, JumpUnknownSourceActivity.this.kd);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).hf(xj4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.w != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hf.xj((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.w, true);
                    }
                    hf.hf(JumpUnknownSourceActivity.this.u, JumpUnknownSourceActivity.this.kd);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).xj(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.w != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hf.xj((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.w, true);
                    }
                    hf.hf(JumpUnknownSourceActivity.this.u, JumpUnknownSourceActivity.this.kd);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).xj(false);
            this.xj = xj.xj();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    private void xj() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
