package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.res.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends AlertDialog implements ai.xj {
    private final String c;
    private long d;
    private final xj f;
    protected final ai hf;
    private TextView kd;
    private boolean tf;
    private TextView u;
    private Context w;
    public com.bytedance.sdk.openadsdk.core.hf.hf xj;
    private TextView y;

    public interface xj {
        void hf(Dialog dialog);

        void xj(Dialog dialog);
    }

    public hf(Context context, ws wsVar, xj xjVar) {
        super(context);
        this.hf = new ai(Looper.getMainLooper(), this);
        this.tf = false;
        this.w = context;
        if (context == null) {
            this.w = pz.getContext();
        }
        this.c = dc.y(wsVar);
        this.f = xjVar;
        if (dc.kd(wsVar) != 3) {
            this.d = dc.f(wsVar);
        } else {
            this.tf = true;
            this.d = 5L;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(kd.a(this.w));
        setCanceledOnTouchOutside(false);
        xj();
        this.hf.sendEmptyMessageDelayed(101, 1000L);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.hf.removeMessages(101);
        } else {
            this.hf.removeMessages(101);
            this.hf.sendEmptyMessageDelayed(101, 1000L);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        r.xj(this.u, this.c);
    }

    private void xj() {
        this.u = (TextView) findViewById(2114387826);
        this.kd = (TextView) findViewById(2114387638);
        this.y = (TextView) findViewById(2114387833);
        if (this.f == null) {
            return;
        }
        r.xj((View) this.kd, (View.OnClickListener) this.xj, "goLiveListener");
        r.xj(this.y, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.hf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.this.f.xj(hf.this);
            }
        }, "cancelTv");
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        xj xjVar;
        if (message.what == 101) {
            long j = this.d - 1;
            this.d = j;
            if (j <= 0) {
                if (this.tf && (xjVar = this.f) != null) {
                    xjVar.hf(this);
                }
                xj xjVar2 = this.f;
                if (xjVar2 != null) {
                    xjVar2.xj(this);
                    return;
                }
                return;
            }
            if (this.tf) {
                r.xj(this.y, jk.xj(this.w, "tt_reward_live_dialog_cancel_text"));
            } else {
                r.xj(this.y, String.format(jk.xj(this.w, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j)));
            }
            this.hf.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
