package com.ss.android.socialbase.downloader.network.xj;

import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.tf.y;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private final Map<String, w> hf;
    private final Map<String, u> w;
    protected int xj;

    /* renamed from: com.ss.android.socialbase.downloader.network.xj.xj$xj, reason: collision with other inner class name */
    public static final class C0506xj {
        private static final xj xj = new xj();

        static {
            YINPYDI();
        }

        private static /* synthetic */ void YINPYDI() {
            char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'U');
            }
            String str = new String(charArray);
            char[] charArray2 = "69<;<!".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'U');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public u hf(String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        u remove;
        synchronized (this.w) {
            remove = this.w.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (y.xj(remove.y(), list)) {
            try {
                remove.kd();
            } catch (InterruptedException e) {
                pl.xj(e);
            }
            if (remove.f() && remove.c()) {
                return remove;
            }
        }
        try {
            remove.u();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void xj(String str, w wVar) {
        synchronized (this.hf) {
            this.hf.put(str, wVar);
        }
    }

    private xj() {
        this.hf = new HashMap();
        this.w = new LinkedHashMap(3);
        this.xj = 3;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public w xj(String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        w remove;
        synchronized (this.hf) {
            remove = this.hf.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (y.xj(remove.f(), list)) {
            try {
                remove.u();
            } catch (InterruptedException e) {
                pl.xj(e);
            }
            if (remove.y() && remove.kd()) {
                return remove;
            }
        }
        try {
            remove.w();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean xj(String str) {
        w wVar = this.hf.get(str);
        if (wVar != null) {
            if (wVar.c()) {
                return true;
            }
            if (wVar.y() && wVar.kd()) {
                return true;
            }
        }
        return false;
    }

    public static xj xj() {
        return C0506xj.xj;
    }
}
