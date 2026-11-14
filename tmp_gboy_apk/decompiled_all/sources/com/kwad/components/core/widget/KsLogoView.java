package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class KsLogoView extends LinearLayout {
    private boolean amZ;
    TextView ana;
    ImageView anb;
    private a anc;
    private SimpleImageLoadingListener hy;

    public interface a {
        void bD();
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int paddingRight = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : textView.getPaddingRight() + textView.getPaddingLeft() + ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString())))) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int a2 = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(paddingRight, a2);
        ksLogoView.layout(0, 0, paddingRight, a2);
        Bitmap createBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return createBitmap;
    }

    private void init() {
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.ana = (TextView) findViewById(R.id.ksad_logo_text);
        this.anb = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.amZ = z;
        if (z) {
            this.anb.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.ana.setTextColor(-6513508);
        } else {
            this.anb.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.ana.setTextColor(-1711276033);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF() {
        this.anb.setImageDrawable(getContext().getResources().getDrawable(this.amZ ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public final void aS(AdTemplate adTemplate) {
        View findViewById = findViewById(R.id.ksad_logo_container);
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        String str = this.amZ ? er.adBaseInfo.adGrayMarkIcon : er.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(er.adBaseInfo.adSourceDescription)) {
            this.ana.setVisibility(0);
            this.ana.setText(com.kwad.sdk.core.response.b.a.aE(er));
            this.anb.setVisibility(0);
            xF();
            a aVar = this.anc;
            if (aVar != null) {
                aVar.bD();
            }
        } else {
            if (TextUtils.isEmpty(er.adBaseInfo.adSourceDescription)) {
                this.ana.setVisibility(8);
                this.ana.setText("");
            } else {
                this.ana.setText(com.kwad.sdk.core.response.b.a.aE(er));
                this.ana.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.anb.setVisibility(8);
                this.anb.setImageDrawable(null);
                a aVar2 = this.anc;
                if (aVar2 != null) {
                    aVar2.bD();
                }
            } else {
                KSImageLoader.loadFeeImage(this.anb, str, adTemplate, this.hy);
                this.anb.setVisibility(0);
            }
        }
        findViewById.setVisibility(0);
    }

    public ImageView getIcon() {
        return this.anb;
    }

    public TextView getTextView() {
        return this.ana;
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.anc = aVar;
    }

    public KsLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.anc != null) {
                    KsLogoView.this.anc.bD();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.xF();
                if (KsLogoView.this.anc != null) {
                    KsLogoView.this.anc.bD();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(m.wrapContextIfNeed(context));
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.anc != null) {
                    KsLogoView.this.anc.bD();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.xF();
                if (KsLogoView.this.anc != null) {
                    KsLogoView.this.anc.bD();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }
}
