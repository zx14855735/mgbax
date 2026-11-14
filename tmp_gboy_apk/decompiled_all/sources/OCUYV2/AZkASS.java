package OCUYV2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DG07BK;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZkASS extends AZOQYO {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f6240ADYaiT = {1};
    public static final int[] AMqCpz = {0, 1};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f6241A5SV6n = 0;

    static {
        AFZChW();
    }

    private static /* synthetic */ void AFZChW() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // OCUYV2.AZOQYO
    public final AlLFFp A5SV6n(CarouselLayoutManager carouselLayoutManager, View view) {
        int i;
        A2egSU a2egSU;
        int height = carouselLayoutManager.getHeight();
        if (carouselLayoutManager.B2KMhB()) {
            height = carouselLayoutManager.getWidth();
        }
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carouselLayoutManager.B2KMhB()) {
            f = ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float f2 = this.f6238A2egSU + f;
        float max = Math.max(this.f6239A4TApA + f, f2);
        float f3 = height;
        float min = Math.min(measuredWidth + f, f3);
        float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB((measuredWidth / 3.0f) + f, f2 + f, max + f);
        float f4 = (min + B2KMhB2) / 2.0f;
        int[] iArr = f3 < 2.0f * f2 ? new int[]{0} : f6240ADYaiT;
        int max2 = (int) Math.max(1.0d, Math.floor((f3 - (com.bumptech.glide.AMqCpz.COJEAR(r2) * max)) / min));
        int ceil = (((int) Math.ceil(f3 / min)) - max2) + 1;
        int[] iArr2 = new int[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            iArr2[i2] = max2 + i2;
        }
        int i3 = carouselLayoutManager.f11513AmA8tU == 1 ? 1 : 0;
        int[] A2egSU2 = i3 != 0 ? AZOQYO.A2egSU(iArr) : iArr;
        int[] iArr3 = AMqCpz;
        A2egSU A2egSU3 = A2egSU.A2egSU(f3, B2KMhB2, f2, max, A2egSU2, f4, i3 != 0 ? AZOQYO.A2egSU(iArr3) : iArr3, min, iArr2);
        int i4 = A2egSU3.f6221A5SV6n;
        int i5 = A2egSU3.f6222ADYaiT;
        int[] iArr4 = iArr;
        int i6 = A2egSU3.f6224ASJ6gh;
        this.f6241A5SV6n = i4 + i5 + i6;
        if (i4 + i5 + i6 > carouselLayoutManager.getItemCount()) {
            a2egSU = A2egSU.A2egSU(f3, B2KMhB2, f2, max, iArr4, f4, iArr3, min, iArr2);
            i = 0;
        } else {
            i = i3;
            a2egSU = A2egSU3;
        }
        return com.bumptech.glide.AMqCpz.B7CMnp(view.getContext(), f, height, a2egSU, i);
    }

    @Override // OCUYV2.AZOQYO
    public final boolean ADYaiT(CarouselLayoutManager carouselLayoutManager, int i) {
        if (carouselLayoutManager.f11513AmA8tU == 1) {
            return (i < this.f6241A5SV6n && carouselLayoutManager.getItemCount() >= this.f6241A5SV6n) || (i >= this.f6241A5SV6n && carouselLayoutManager.getItemCount() < this.f6241A5SV6n);
        }
        return false;
    }
}
