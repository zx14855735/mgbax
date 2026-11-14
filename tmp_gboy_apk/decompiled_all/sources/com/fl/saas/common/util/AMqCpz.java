package com.fl.saas.common.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10819AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ImageView f10820AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f10821AmA8tU;

    public /* synthetic */ AMqCpz(BitmapDrawable bitmapDrawable, ImageView imageView) {
        this.f10821AmA8tU = bitmapDrawable;
        this.f10820AlLFFp = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10819AcNBzu) {
            case 0:
                this.f10820AlLFFp.setImageBitmap((Bitmap) this.f10821AmA8tU);
                break;
            default:
                ImageUtils.lambda$setBlurImage$1((BitmapDrawable) this.f10821AmA8tU, this.f10820AlLFFp);
                break;
        }
    }

    public /* synthetic */ AMqCpz(ImageView imageView, Bitmap bitmap) {
        this.f10820AlLFFp = imageView;
        this.f10821AmA8tU = bitmap;
    }
}
