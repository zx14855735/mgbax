package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.u;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends Dialog {
    private TTDislikeLayout hf;
    private TextView kd;
    private boolean u;
    private final com.bytedance.sdk.openadsdk.core.dislike.w.hf w;
    private com.bytedance.sdk.openadsdk.core.dislike.hf.w xj;

    public w(Context context, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        super(context);
        this.u = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.w = hfVar;
    }

    private void w() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.hf = tTDislikeLayout;
        xj(tTDislikeLayout);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.hf.w wVar = this.xj;
        if (wVar == null || this.u) {
            return;
        }
        wVar.w();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.u.xj(getContext()), xj());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        hf();
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.u = false;
            com.bytedance.sdk.openadsdk.core.dislike.hf.w wVar = this.xj;
            if (wVar != null) {
                wVar.hf();
            }
        } catch (Exception unused) {
        }
    }

    private void hf() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.hf.w wVar) {
        this.xj = wVar;
    }

    public ViewGroup.LayoutParams xj() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf().xj(getContext(), 345.0f), -2);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        TTDislikeLayout tTDislikeLayout;
        if (hfVar == null || (tTDislikeLayout = this.hf) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        u uVar = (u) tTDislikeScrollListView.getAdapter();
        if (uVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.xj.hf(hfVar));
            uVar.xj(hfVar.xj());
        }
    }

    private void xj(View view) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(2047279095);
        this.kd = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (w.this.xj != null) {
                    w.this.xj.xj();
                }
                w.this.dismiss();
            }
        });
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    if (w.this.xj != null) {
                        w.this.xj.xj(i, w.this.w.xj().get(i));
                        w.this.u = true;
                    }
                    w.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar = this.w;
        u uVar = new u(getContext(), hfVar == null ? new ArrayList<>(0) : hfVar.xj());
        uVar.xj(new u.xj() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.w.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.u.xj
            public void xj(int i, y yVar) {
                if (w.this.xj != null) {
                    w.this.xj.xj(i, yVar);
                    w.this.u = true;
                }
                w.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(w.this.w, yVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) uVar);
        com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar2 = this.w;
        if (hfVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.xj.hf(hfVar2));
        }
    }

    public void xj(String str) {
        TextView textView = this.kd;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
