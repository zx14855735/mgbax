package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aeR;

        static {
            int[] iArr = new int[AdaptType.values().length];
            aeR = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aeR[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aeR[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aeR[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL;

        static {
            QkWw();
        }

        private static /* synthetic */ void QkWw() {
            char[] charArray = "q}\u007f<us\u007fw<p}k<azw~~<X|{P`{vuw".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 18);
            }
            String str = new String(charArray);
            char[] charArray2 = "q~{|{f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 18);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean E(View view) {
            return view.isInLayout() || view.isLayoutRequested();
        }

        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(final View view, View view2, int i, int i2) {
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            AdaptType adaptType = (z2 && z) ? AdaptType.PORTRAIT_VERTICAL : z2 ? AdaptType.PORTRAIT_HORIZONTAL : z ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (E(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view.setLayoutParams(layoutParams);
            }
        }

        public abstract void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2);
    }

    public static class b extends a {
        private float aeU = 0.8f;
        private float aeV = 0.9375f;
        private float aeW = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float vC;
            float f;
            float vD = dVar.vD();
            float vD2 = dVar2.vD();
            float vC2 = dVar.vC();
            float vB = dVar.vB();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + vB + ", " + vC2);
            int i = AnonymousClass1.aeR[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (vD > vD2) {
                    float vB2 = dVar.vB();
                    float f2 = vB2 / vD2;
                    float f3 = vC2 / f2;
                    float f4 = this.aeU;
                    if (f3 >= f4) {
                        f = vB2;
                        vC = f2;
                    } else {
                        vC = vC2 / f4;
                        f = vC * vD2;
                    }
                } else {
                    vC = dVar.vC();
                    f = vD2 * vC;
                    float f5 = vB / f;
                    float f6 = this.aeV;
                    if (f5 < f6) {
                        f = vB / f6;
                        vC = f / vD2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = vC2 * this.aeW;
                vC = f / vD2;
            } else {
                vC = -2.14748365E9f;
                f = -2.14748365E9f;
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + vC);
            if (f == -2.14748365E9f || vC == -2.14748365E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) vC;
                layoutParams.height = (int) f;
            } else {
                layoutParams.height = (int) vC;
                layoutParams.width = (int) f;
            }
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float vB;
            float vC;
            float vD = dVar.vD();
            float vD2 = dVar2.vD();
            int i = AnonymousClass1.aeR[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (vD >= vD2) {
                    vC = dVar.vC();
                    vB = vC * vD2;
                } else {
                    vB = dVar.vB();
                    vC = vB / vD2;
                }
            } else if (i == 3 || i == 4) {
                vB = dVar.vC();
                vC = vB / vD2;
            } else {
                vB = 0.0f;
                vC = -2.14748365E9f;
            }
            if (vC == -2.14748365E9f || vB == -2.14748365E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) vC;
                layoutParams.height = (int) vB;
            } else {
                layoutParams.height = (int) vC;
                layoutParams.width = (int) vB;
            }
        }
    }

    public static class d {
        float aeX;
        float height;
        float width;

        public d(float f, float f2) {
            this.aeX = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.aeX = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.aeX;
        }

        public final float getWidth() {
            return this.width;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.aeX + '}';
        }

        public final float vB() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float vC() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float vD() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            return f > f2 ? f / f2 : f2 / f;
        }
    }
}
