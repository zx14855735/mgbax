package com.bytedance.adsdk.lottie.hf;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.kd.kd;
import com.bytedance.adsdk.lottie.model.c;
import com.bytedance.adsdk.lottie.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private w kd;
    private final AssetManager u;
    private final c<String> xj = new c<>();
    private final Map<c<String>, Typeface> hf = new HashMap();
    private final Map<String, Typeface> w = new HashMap();
    private String y = ".ttf";

    public xj(Drawable.Callback callback, w wVar) {
        this.kd = wVar;
        if (callback instanceof View) {
            this.u = ((View) callback).getContext().getAssets();
        } else {
            kd.hf("LottieDrawable must be inside of a view for images to work.");
            this.u = null;
        }
    }

    private Typeface hf(com.bytedance.adsdk.lottie.model.w wVar) {
        Typeface typeface;
        String xj = wVar.xj();
        Typeface typeface2 = this.w.get(xj);
        if (typeface2 != null) {
            return typeface2;
        }
        String w = wVar.w();
        String hf = wVar.hf();
        w wVar2 = this.kd;
        if (wVar2 != null) {
            typeface = wVar2.xj(xj, w, hf);
            if (typeface == null) {
                typeface = this.kd.xj(xj);
            }
        } else {
            typeface = null;
        }
        w wVar3 = this.kd;
        if (wVar3 != null && typeface == null) {
            String hf2 = wVar3.hf(xj, w, hf);
            if (hf2 == null) {
                hf2 = this.kd.hf(xj);
            }
            if (hf2 != null) {
                try {
                    typeface = Typeface.createFromAsset(this.u, hf2);
                } catch (Throwable unused) {
                    typeface = Typeface.DEFAULT;
                }
            }
        }
        if (wVar.u() != null) {
            return wVar.u();
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.u, "fonts/" + xj + this.y);
            } catch (Throwable unused2) {
                typeface = Typeface.DEFAULT;
            }
        }
        this.w.put(xj, typeface);
        return typeface;
    }

    public void xj(w wVar) {
        this.kd = wVar;
    }

    public void xj(String str) {
        this.y = str;
    }

    public Typeface xj(com.bytedance.adsdk.lottie.model.w wVar) {
        this.xj.xj(wVar.xj(), wVar.w());
        Typeface typeface = this.hf.get(this.xj);
        if (typeface != null) {
            return typeface;
        }
        Typeface xj = xj(hf(wVar), wVar.w());
        this.hf.put(this.xj, xj);
        return xj;
    }

    private Typeface xj(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
