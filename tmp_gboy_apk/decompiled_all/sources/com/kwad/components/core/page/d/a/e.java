package com.kwad.components.core.page.d.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e extends a {
    private LinearLayout UC;
    private TextView UD;
    private ImageView UE;

    private void sn() {
        this.UC = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.Vv.mPageTitle)) {
            this.UC.setVisibility(8);
            return;
        }
        this.UD = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.UE = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.d.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.UC.setVisibility(8);
            }
        });
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.Vv.mAdTemplate);
        boolean bA = com.kwad.sdk.core.response.b.a.bA(er);
        String bw = com.kwad.sdk.core.response.b.a.bw(er);
        if (bA) {
            this.UC.setVisibility(0);
            this.UD.setText(bw);
            this.UD.setSelected(true);
        } else {
            this.UC.setVisibility(8);
        }
        this.Vv.a(so());
    }

    private KsAdWebView.c so() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.d.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void sp() {
                if (e.this.Vv.rQ() && e.this.UC.getVisibility() == 0) {
                    e.this.UC.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        sn();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
