package com.bytedance.sdk.component.y.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.ai;
import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.component.y.qt;
import com.bytedance.sdk.component.y.v;
import com.bytedance.sdk.component.y.w.w;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements ht, Function {
    private volatile y xj;

    private hf() {
    }

    private void hf(Context context, v vVar) {
        if (this.xj != null) {
            pl.hf(ImageLoader.TAG, "already init!");
        }
        if (vVar == null) {
            vVar = kd.xj(context);
        }
        this.xj = new y(context, vVar);
    }

    public static ht xj(Context context, v vVar) {
        hf hfVar = new hf();
        hfVar.hf(context, vVar);
        return hfVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                am from = from((String) sparseArray.get(1));
                return from != null ? new qt(from) : from;
            case 2:
                xj(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 3:
                clearMemoryCache(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 4:
                hf(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 5:
                xj();
                return null;
            case 6:
                return getCacheStream((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return xj((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
            case 8:
                return Boolean.valueOf(hf((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.y.ht
    public void clearMemoryCache(double d) {
        if (this.xj != null) {
            xj(this.xj.xj(), d);
            xj(this.xj.hf(), d);
        }
    }

    @Override // com.bytedance.sdk.component.y.ht
    public am from(String str) {
        return new w.hf(this.xj).from(str);
    }

    @Override // com.bytedance.sdk.component.y.ht
    public InputStream getCacheStream(String str, String str2) {
        if (this.xj != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.y.w.w.w.xj(str);
            }
            Collection<ai> hf = this.xj.hf();
            if (hf != null) {
                Iterator<ai> it = hf.iterator();
                while (it.hasNext()) {
                    byte[] xj = it.next().xj((ai) str2);
                    if (xj != null) {
                        return new ByteArrayInputStream(xj);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.y.u> w = this.xj.w();
            if (w != null) {
                Iterator<com.bytedance.sdk.component.y.u> it2 = w.iterator();
                while (it2.hasNext()) {
                    InputStream xj2 = it2.next().xj(str2);
                    if (xj2 != null) {
                        return xj2;
                    }
                }
            }
        }
        return null;
    }

    public void xj(double d) {
        clearMemoryCache(d);
        hf(d);
    }

    private void xj(Collection<? extends com.bytedance.sdk.component.y.xj> collection, double d) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.y.xj> it = collection.iterator();
        while (it.hasNext()) {
            it.next().xj(d);
        }
    }

    public void hf(double d) {
        if (this.xj != null) {
            xj(this.xj.w(), d);
        }
    }

    public boolean hf(String str, String str2, String str3) {
        if (this.xj == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.y.w.w.w.xj(str);
        }
        com.bytedance.sdk.component.y.u xj = this.xj.xj(str3);
        if (xj != null) {
            return xj.hf(str2);
        }
        return false;
    }

    public void xj() {
        hf(0.0d);
        clearMemoryCache(0.0d);
    }

    public InputStream xj(String str, String str2, String str3) {
        if (this.xj == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.y.w.w.w.xj(str);
        }
        com.bytedance.sdk.component.y.u xj = this.xj.xj(str3);
        if (xj != null) {
            return xj.xj(str2);
        }
        return null;
    }
}
