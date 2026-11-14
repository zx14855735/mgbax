package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends RelativeLayout {
    private static float d = 8.0f;
    private static final float e = 1.0f;

    /* renamed from: a, reason: collision with root package name */
    private final int f13278a;
    private final ImageView b;
    private final TextView c;

    public b(Context context, int i) {
        super(context);
        this.f13278a = i;
        int dipsToIntPixels = Dips.dipsToIntPixels(5.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(16.0f, context);
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setId(ClientMetadata.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth(Dips.dipsToIntPixels(40.0f, context));
        imageView.setMinimumWidth(dipsToIntPixels2);
        imageView.setBackgroundColor(Color.alpha(0));
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setTextColor(Color.parseColor("#B9B9B9"));
        textView.setTextSize(1, 12.0f);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dipsToIntPixels2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, dipsToIntPixels2);
        if (i == 1) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            int i2 = dipsToIntPixels * 2;
            layoutParams2.setMargins(dipsToIntPixels, 0, 0, i2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, dipsToIntPixels, i2);
        } else {
            layoutParams2.addRule(1, imageView.getId());
            layoutParams2.addRule(8, imageView.getId());
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams.setMargins(dipsToIntPixels, 0, 0, 0);
        }
        addView(imageView, layoutParams);
        addView(textView, layoutParams2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }

    public void b(String str) {
        try {
            this.c.setText(str);
        } catch (Throwable th) {
            SigmobLog.e("showAdText error", th);
        }
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.b.1
            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
            }

            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, b.this.getContext());
                if (bitmap == null) {
                    return;
                }
                if (b.this.f13278a != 1 && bitmap.getWidth() > bitmap.getHeight() * 1.5f) {
                    ((RelativeLayout.LayoutParams) b.this.b.getLayoutParams()).setMargins((bitmap.getWidth() / bitmap.getHeight()) * (-dipsToIntPixels), 0, 0, 0);
                }
                b.this.b.setImageBitmap(bitmap);
            }
        });
    }
}
