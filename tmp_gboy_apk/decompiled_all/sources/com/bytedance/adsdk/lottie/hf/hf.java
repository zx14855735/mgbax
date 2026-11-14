package com.bytedance.adsdk.lottie.hf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.kd.kd;
import com.bytedance.adsdk.lottie.u;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static final Object xj = new Object();
    private final Context hf;
    private final Map<String, d> kd;
    private u u;
    private final String w;

    static {
        IMacgwW();
    }

    public hf(Drawable.Callback callback, String str, u uVar, Map<String, d> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.w = str;
        } else {
            this.w = str.concat("/");
        }
        this.kd = map;
        xj(uVar);
        if (callback instanceof View) {
            this.hf = ((View) callback).getContext().getApplicationContext();
        } else {
            this.hf = null;
        }
    }

    private static /* synthetic */ void IMacgwW() {
        char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'n');
        }
        String str = new String(charArray);
        char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Bitmap hf(String str, Bitmap bitmap) {
        synchronized (xj) {
        }
        return bitmap;
    }

    public void xj(u uVar) {
        this.u = uVar;
    }

    public Bitmap xj(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return this.kd.get(str).am();
        }
        d dVar = this.kd.get(str);
        Bitmap am = dVar.am();
        dVar.xj(null);
        return am;
    }

    public Bitmap xj(String str) {
        d dVar = this.kd.get(str);
        if (dVar == null) {
            return null;
        }
        Bitmap am = dVar.am();
        if (am != null) {
            return am;
        }
        u uVar = this.u;
        if (uVar != null) {
            return uVar.xj(dVar);
        }
        Context context = this.hf;
        if (context == null) {
            return null;
        }
        String pl2 = dVar.pl();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (pl2.startsWith("data:") && pl2.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(pl2.substring(pl2.indexOf(44) + 1), 0);
                return hf(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                kd.xj("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.w)) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.w + pl2), null, options);
                    if (decodeStream == null) {
                        kd.hf("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return hf(str, com.bytedance.adsdk.lottie.kd.d.xj(decodeStream, dVar.xj(), dVar.hf()));
                } catch (IllegalArgumentException e2) {
                    kd.xj("Unable to decode image `" + str + "`.", e2);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e3) {
            kd.xj("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean xj(Context context) {
        return (context == null && this.hf == null) || this.hf.equals(context);
    }
}
