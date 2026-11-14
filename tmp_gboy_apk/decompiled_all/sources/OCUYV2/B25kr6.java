package OCUYV2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DG07BK;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends AZOQYO {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f6268ADYaiT = {1};
    public static final int[] AMqCpz = {1, 0};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f6269A5SV6n = 0;

    static {
        PKfasX();
    }

    private static /* synthetic */ void PKfasX() {
        char[] charArray = "ðüþ½ôòþö½ñüê½àûöÿÿ½ÙýúÑáú÷ôö".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 147);
        }
        String str = new String(charArray);
        char[] charArray2 = "ðÿúýúç".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 147);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // OCUYV2.AZOQYO
    public final AlLFFp A5SV6n(CarouselLayoutManager carouselLayoutManager, View view) {
        int height = carouselLayoutManager.getHeight();
        if (carouselLayoutManager.B2KMhB()) {
            height = carouselLayoutManager.getWidth();
        }
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carouselLayoutManager.B2KMhB()) {
            f = ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f2 = this.f6238A2egSU + f;
        float max = Math.max(this.f6239A4TApA + f, f2);
        float f3 = height;
        float min = Math.min(measuredHeight + f, f3);
        float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB((measuredHeight / 3.0f) + f, f2 + f, max + f);
        float f4 = (min + B2KMhB2) / 2.0f;
        int[] iArr = f6268ADYaiT;
        float f5 = 2.0f * f2;
        boolean z = true;
        boolean z2 = false;
        if (f3 <= f5) {
            iArr = new int[]{0};
        }
        int[] iArr2 = AMqCpz;
        if (carouselLayoutManager.f11513AmA8tU == 1) {
            iArr = AZOQYO.A2egSU(iArr);
            iArr2 = AZOQYO.A2egSU(iArr2);
        }
        int[] iArr3 = iArr2;
        int[] iArr4 = iArr;
        int max2 = (int) Math.max(1.0d, Math.floor(((f3 - (com.bumptech.glide.AMqCpz.COJEAR(iArr3) * f4)) - (com.bumptech.glide.AMqCpz.COJEAR(iArr4) * max)) / min));
        int ceil = (int) Math.ceil(f3 / min);
        int i = (ceil - max2) + 1;
        int[] iArr5 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr5[i2] = ceil - i2;
        }
        A2egSU A2egSU2 = A2egSU.A2egSU(f3, B2KMhB2, f2, max, iArr4, f4, iArr3, min, iArr5);
        int i3 = A2egSU2.f6221A5SV6n + A2egSU2.f6222ADYaiT;
        int i4 = A2egSU2.f6224ASJ6gh;
        this.f6269A5SV6n = i3 + i4;
        int itemCount = carouselLayoutManager.getItemCount();
        int i5 = A2egSU2.f6221A5SV6n;
        int i6 = A2egSU2.f6222ADYaiT;
        int i7 = ((i5 + i6) + i4) - itemCount;
        if (i7 > 0 && (i5 > 0 || i6 > 1)) {
            z2 = true;
        }
        while (i7 > 0) {
            int i8 = A2egSU2.f6221A5SV6n;
            if (i8 > 0) {
                A2egSU2.f6221A5SV6n = i8 - 1;
            } else {
                int i9 = A2egSU2.f6222ADYaiT;
                if (i9 > 1) {
                    A2egSU2.f6222ADYaiT = i9 - 1;
                }
            }
            i7--;
        }
        int i10 = A2egSU2.f6222ADYaiT;
        if (i10 == 0 && A2egSU2.f6221A5SV6n == 0 && f3 > f5) {
            A2egSU2.f6221A5SV6n = 1;
        } else {
            z = z2;
        }
        if (z) {
            A2egSU2 = A2egSU.A2egSU(f3, B2KMhB2, f2, max, new int[]{A2egSU2.f6221A5SV6n}, f4, new int[]{i10}, min, new int[]{i4});
        }
        return com.bumptech.glide.AMqCpz.B7CMnp(view.getContext(), f, height, A2egSU2, carouselLayoutManager.f11513AmA8tU);
    }

    @Override // OCUYV2.AZOQYO
    public final boolean ADYaiT(CarouselLayoutManager carouselLayoutManager, int i) {
        if (i >= this.f6269A5SV6n || carouselLayoutManager.getItemCount() < this.f6269A5SV6n) {
            return i >= this.f6269A5SV6n && carouselLayoutManager.getItemCount() < this.f6269A5SV6n;
        }
        return true;
    }
}
