package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar fR;
    private View fS;
    private Context mContext;

    public DrawDownloadProgressBar(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.fR = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View findViewById = findViewById(R.id.ksad_download_progress_cover);
        this.fS = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void e(String str, int i) {
        if (i == 0 || i == getMax()) {
            this.fS.setVisibility(0);
        } else {
            this.fS.setVisibility(8);
        }
        this.fR.e(str, i);
    }

    public int getMax() {
        return this.fR.getMax();
    }

    public void setTextColor(int i) {
        this.fR.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.fR.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), i));
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }
}
