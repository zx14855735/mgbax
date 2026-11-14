package com.kwad.components.core.s;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class l {
    private static final WeakHashMap<a, ViewTreeObserver.OnGlobalLayoutListener> acS = new WeakHashMap<>();

    public interface a {
        void aU(int i);

        void sX();
    }

    static {
        gSMLG();
    }

    public static void a(Window window, final a aVar) {
        WeakHashMap<a, ViewTreeObserver.OnGlobalLayoutListener> weakHashMap = acS;
        if (weakHashMap.get(aVar) != null) {
            return;
        }
        final View decorView = window.getDecorView();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.s.l.1
            private int acT;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                int i = this.acT;
                if (i == 0) {
                    this.acT = height;
                    return;
                }
                if (i == height) {
                    return;
                }
                int height2 = decorView.getHeight() / 4;
                int i2 = this.acT;
                if (i2 - height > height2) {
                    aVar.aU(i2 - height);
                    this.acT = height;
                } else if (height - i2 > height2) {
                    aVar.sX();
                    this.acT = height;
                }
            }
        };
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        weakHashMap.put(aVar, onGlobalLayoutListener);
    }

    public static void b(Window window, a aVar) {
        window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(acS.remove(aVar));
    }

    private static /* synthetic */ void gSMLG() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
