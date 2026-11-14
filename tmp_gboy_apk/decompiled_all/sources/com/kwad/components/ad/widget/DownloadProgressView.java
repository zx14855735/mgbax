package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView MS;
    private int MT;
    private int MU;
    private int MV;
    private int MW;
    protected Drawable MX;
    protected Drawable MY;
    private String MZ;
    private final KsAppDownloadListener dW;
    protected TextProgressBar fR;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.MT = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.MU = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.MV = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.MW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.MX = drawable;
        if (drawable == null) {
            nZ();
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.MY = drawable2;
        if (drawable2 == null) {
            oa();
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.MZ = string;
        if (string == null) {
            this.MZ = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        nY();
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.fR = textProgressBar;
        textProgressBar.setTextDimen(this.MW);
        this.fR.setTextColor(this.MU, this.MV);
        this.fR.setProgressDrawable(this.MX);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.MS = textView;
        textView.setTextColor(this.MT);
        this.MS.setTextSize(0, this.MW);
        this.MS.setVisibility(0);
        this.MS.setBackground(this.MY);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void aw(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo er = e.er(adTemplate);
        this.mAdInfo = er;
        this.MS.setText(com.kwad.sdk.core.response.b.a.aF(er));
        this.fR.setVisibility(8);
        this.MS.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.dW;
    }

    public void nY() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
    }

    public void nZ() {
        this.MX = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
    }

    public void oa() {
        this.MY = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.MS.setText(com.kwad.sdk.core.response.b.a.aF(downloadProgressView.mAdInfo));
                DownloadProgressView.this.MS.setVisibility(0);
                DownloadProgressView.this.fR.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.MS.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.cp(downloadProgressView.mAdTemplate), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.MS.setText(com.kwad.sdk.core.response.b.a.aF(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.MS.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.ad(downloadProgressView.mAdInfo), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.MS.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.KI(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.MS.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.w(i2, downloadProgressView.MZ), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
