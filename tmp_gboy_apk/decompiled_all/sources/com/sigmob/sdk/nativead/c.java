package com.sigmob.sdk.nativead;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final String f13605a;

    public c(Context context, String str) {
        super(context, com.sigmob.sdk.base.k.e());
        this.f13605a = str;
    }

    private void a() {
        int i;
        Window window = getWindow();
        Context context = getContext();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        int dipsToIntPixels = Dips.dipsToIntPixels(0.0f, context);
        int i4 = -1;
        if (i3 > i2) {
            i4 = i2 - dipsToIntPixels;
            i = -1;
        } else {
            i = i3 - dipsToIntPixels;
        }
        attributes.width = i4;
        attributes.height = i;
        window.setAttributes(attributes);
        int g = com.sigmob.sdk.base.k.g();
        if (g <= 0) {
            return;
        }
        window.setWindowAnimations(g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() == null) {
            return;
        }
        setContentView(R.layout.sig_fullscreen_layout);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        final int i = 0;
        findViewById(R.id.dialog_root).setOnClickListener(new View.OnClickListener(this) { // from class: com.sigmob.sdk.nativead.AYUAbz

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ c f13585AlLFFp;

            {
                this.f13585AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.f13585AlLFFp.b(view);
                        break;
                    default:
                        this.f13585AlLFFp.a(view);
                        break;
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.dialog_text);
        final int i2 = 1;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.sigmob.sdk.nativead.AYUAbz

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ c f13585AlLFFp;

            {
                this.f13585AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        this.f13585AlLFFp.b(view);
                        break;
                    default:
                        this.f13585AlLFFp.a(view);
                        break;
                }
            }
        });
        textView.setText(this.f13605a);
        textView.requestFocus();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }
}
