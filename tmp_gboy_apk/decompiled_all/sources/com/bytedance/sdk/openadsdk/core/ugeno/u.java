package com.bytedance.sdk.openadsdk.core.ugeno;

import I3HV03.ADYaiT;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.yo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.cy;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements com.bytedance.adsdk.ugeno.xj {

    public interface xj {
        void xj(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable w(byte[] bArr) {
        FileOutputStream fileOutputStream;
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        try {
            boolean w = com.bytedance.sdk.openadsdk.core.multipro.hf.w();
            File hf = com.bytedance.sdk.component.utils.y.hf(pz.getContext(), w, w ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(hf);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT < 28) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(pz.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return bitmapDrawable;
                }
                createSource = ImageDecoder.createSource(hf);
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return decodeDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    pl.w("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public void hf(am amVar, String str, final xj.InterfaceC0033xj interfaceC0033xj) {
        com.bytedance.sdk.component.y.am type = com.bytedance.sdk.openadsdk.f.hf.xj(str).type(1);
        xj(amVar, type, str);
        type.to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.3
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str2, Throwable th) {
                xj.InterfaceC0033xj interfaceC0033xj2 = interfaceC0033xj;
                if (interfaceC0033xj2 != null) {
                    interfaceC0033xj2.xj(null);
                }
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg zgVar) {
                if (zgVar == null) {
                    interfaceC0033xj.xj(null);
                    return;
                }
                xj.InterfaceC0033xj interfaceC0033xj2 = interfaceC0033xj;
                if (interfaceC0033xj2 == null) {
                    interfaceC0033xj2.xj(null);
                    return;
                }
                if (zgVar.getResult() instanceof Bitmap) {
                    interfaceC0033xj.xj((Bitmap) zgVar.getResult());
                } else if (zgVar.getResult() instanceof byte[]) {
                    try {
                        interfaceC0033xj.xj(BitmapFactory.decodeByteArray((byte[]) zgVar.getResult(), 0, ((byte[]) zgVar.getResult()).length));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.xj
    public void xj(am amVar, String str, ImageView imageView, xj.InterfaceC0033xj interfaceC0033xj) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.f.hf.xj(str).type(3).config(Bitmap.Config.RGB_565).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.1
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg zgVar) {
                    try {
                        Object result = zgVar.getResult();
                        if (!(result instanceof byte[])) {
                            if (result instanceof Bitmap) {
                                gifView.setImageBitmap((Bitmap) result);
                            }
                        } else if (!zgVar.isGif()) {
                            gifView.setImageDrawable(yo.xj((byte[]) result, 0));
                        } else {
                            gifView.xj((byte[]) result, false);
                            gifView.setRepeatConfig(true);
                            gifView.hf();
                        }
                    } catch (Throwable th) {
                        onFailed(1002, "", th);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.component.y.am xj2 = com.bytedance.sdk.openadsdk.f.hf.xj(str);
        xj(amVar, xj2, str);
        xj2.to(imageView);
    }

    public boolean hf(byte[] bArr) {
        return TextUtils.equals(FileTypeUtils.FILE_TYPE_PNG, com.bytedance.sdk.component.utils.d.xj(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.d.xj()))) && com.bytedance.sdk.component.adexpress.u.y.xj(bArr);
    }

    @Override // com.bytedance.adsdk.ugeno.xj
    public void xj(am amVar, String str, final ImageView imageView, int i, int i2, xj.InterfaceC0033xj interfaceC0033xj) {
        com.bytedance.sdk.component.y.am type = com.bytedance.sdk.openadsdk.f.hf.xj(str).type(3);
        xj(amVar, type, str);
        type.to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.2
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i3, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(final zg zgVar) {
                if (imageView.isAttachedToWindow()) {
                    u.this.xj(zgVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            u.this.xj(zgVar, imageView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(zg zgVar, ImageView imageView) {
        Object result = zgVar.getResult();
        if (result instanceof byte[]) {
            if (!zgVar.isGif()) {
                byte[] bArr = (byte[]) result;
                if (!hf(bArr)) {
                    if (xj(bArr)) {
                        com.bytedance.sdk.component.adexpress.u.y.xj(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int xj2 = cy.xj(imageView.getWidth(), imageView.getHeight());
                    Bitmap xj3 = new com.bytedance.sdk.component.y.w.hf.xj(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / xj2, imageView.getHeight() / xj2).xj(bArr);
                    if (xj3 != null) {
                        imageView.setImageBitmap(xj3);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                xj((byte[]) result, imageView);
                return;
            } else {
                com.bytedance.sdk.component.adexpress.u.y.xj(imageView, (byte[]) result, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (result instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) result);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xj
    public void xj(am amVar, String str, xj.InterfaceC0033xj interfaceC0033xj) {
        hf(amVar, str, interfaceC0033xj);
    }

    private void xj(am amVar, com.bytedance.sdk.component.y.am amVar2, String str) {
        Map<String, Object> hf;
        if (amVar == null || (hf = amVar.hf()) == null) {
            return;
        }
        Object obj = hf.get("image_info");
        if (obj instanceof Map) {
            amVar2.key((String) ((Map) obj).get(str));
        }
        String str2 = (String) hf.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        amVar2.cacheDir(str2);
    }

    private void xj(byte[] bArr, final ImageView imageView) {
        try {
            pl.u("ImageLoaderProvider", "load animation image");
            xj(bArr, new xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.4
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
                public void xj(final Drawable drawable) {
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && ADYaiT.BNL6CD(drawable)) {
                                ADYaiT.AcNBzu(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private void xj(final byte[] bArr, final xj xjVar) {
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("csj_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.u.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable w = u.this.w(bArr);
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj(w);
                }
            }
        });
    }

    public boolean xj(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.u.y.xj(bArr, 0);
    }
}
