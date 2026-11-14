package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ar extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13271a;
    private final int b;

    public ar(Context context) {
        super(context);
        this.b = Dips.dipsToIntPixels(22.0f, context);
        b(Dips.dipsToIntPixels(15.0f, context));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        gradientDrawable.setStroke(1, -1);
        gradientDrawable.setCornerRadius(r0 / 2);
        gradientDrawable.setAlpha(102);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams);
    }

    private void b(int i) {
        this.f13271a = new ImageView(getContext());
        RelativeLayout.LayoutParams ASJ6gh2 = J3FDQU.A2egSU.ASJ6gh(i, i, 13);
        this.f13271a.setImageBitmap(s.CLOSE_NEW.a());
        this.f13271a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f13271a.setImageAlpha(204);
        addView(this.f13271a, ASJ6gh2);
    }

    public void a(int i) {
        this.f13271a.setImageResource(i);
    }

    public void a(Bitmap bitmap) {
        this.f13271a.setImageBitmap(bitmap);
    }

    public void a(BaseAdUnit baseAdUnit) {
        ImageView imageView;
        s sVar;
        if (baseAdUnit == null || baseAdUnit.getEndcardCloseImage() != 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBackground(gradientDrawable);
            int i = this.b;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(13);
            this.f13271a.setLayoutParams(layoutParams);
            imageView = this.f13271a;
            sVar = s.CLOSE_OLD;
        } else {
            imageView = this.f13271a;
            sVar = s.CLOSE_NEW;
        }
        imageView.setImageBitmap(sVar.a());
    }

    public void a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
            b(str);
        } else if (lowerCase.startsWith("file://")) {
            try {
                this.f13271a.setImageURI(Uri.fromFile(new File(str)));
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
    }

    private void b(final String str) {
        com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.ar.1
            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
            }

            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                if (bitmap != null) {
                    ar.this.f13271a.setImageBitmap(bitmap);
                    return;
                }
                SigmobLog.d(str + " returned null bitmap");
            }
        });
    }
}
