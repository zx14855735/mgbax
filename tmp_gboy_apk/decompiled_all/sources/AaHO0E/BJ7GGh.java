package AaHO0E;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Space;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f656A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f657A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f658A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f659ADYaiT;
    public final Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Object f660ARc23Z;

    public BJ7GGh(ScrollView scrollView, AlphaSlideBar alphaSlideBar, FrameLayout frameLayout, BrightnessSlideBar brightnessSlideBar, FrameLayout frameLayout2, ColorPickerView colorPickerView, FrameLayout frameLayout3, Space space) {
        this.f656A2egSU = scrollView;
        this.f657A4TApA = frameLayout;
        this.f658A5SV6n = brightnessSlideBar;
        this.f659ADYaiT = frameLayout2;
        this.AMqCpz = frameLayout3;
        this.f660ARc23Z = space;
    }

    public static boolean A2egSU(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList A4TApA(Context context, int i) {
        int A5SV6n2 = GIi2tl.A5SV6n(context, 2130968853);
        return new ColorStateList(new int[][]{GIi2tl.f873A4TApA, GIi2tl.f875ADYaiT, GIi2tl.f874A5SV6n, GIi2tl.f876ARc23Z}, new int[]{GIi2tl.A4TApA(context, 2130968848), BV3sI0.A2egSU.A5SV6n(A5SV6n2, i), BV3sI0.A2egSU.A5SV6n(A5SV6n2, i), i});
    }

    public static LayerDrawable A5SV6n(FpcJKS fpcJKS, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable ARc23Z2 = fpcJKS.ARc23Z(context, 2131230827);
        Drawable ARc23Z3 = fpcJKS.ARc23Z(context, 2131230828);
        if ((ARc23Z2 instanceof BitmapDrawable) && ARc23Z2.getIntrinsicWidth() == dimensionPixelSize && ARc23Z2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) ARc23Z2;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            ARc23Z2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            ARc23Z2.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((ARc23Z3 instanceof BitmapDrawable) && ARc23Z3.getIntrinsicWidth() == dimensionPixelSize && ARc23Z3.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) ARc23Z3;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            ARc23Z3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            ARc23Z3.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    public static void AMqCpz(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = BNL6CD.f661A4TApA;
        }
        mutate.setColorFilter(BNL6CD.A5SV6n(i, mode));
    }

    public ColorStateList ADYaiT(Context context, int i) {
        if (i == 2131230784) {
            return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099669);
        }
        if (i == 2131230830) {
            return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099672);
        }
        if (i != 2131230829) {
            if (i == 2131230772) {
                return A4TApA(context, GIi2tl.A5SV6n(context, 2130968848));
            }
            if (i == 2131230766) {
                return A4TApA(context, 0);
            }
            if (i == 2131230771) {
                return A4TApA(context, GIi2tl.A5SV6n(context, 2130968846));
            }
            if (i == 2131230825 || i == 2131230826) {
                return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099671);
            }
            if (A2egSU((int[]) this.f657A4TApA, i)) {
                return GIi2tl.ADYaiT(context, 2130968854);
            }
            if (A2egSU((int[]) this.AMqCpz, i)) {
                return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099668);
            }
            if (A2egSU((int[]) this.f660ARc23Z, i)) {
                return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099667);
            }
            if (i == 2131230822) {
                return BPw6Q8.ASJ6gh.A5SV6n(context, 2131099670);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList ADYaiT2 = GIi2tl.ADYaiT(context, 2130968905);
        if (ADYaiT2 == null || !ADYaiT2.isStateful()) {
            iArr[0] = GIi2tl.f873A4TApA;
            iArr2[0] = GIi2tl.A4TApA(context, 2130968905);
            iArr[1] = GIi2tl.AMqCpz;
            iArr2[1] = GIi2tl.A5SV6n(context, 2130968852);
            iArr[2] = GIi2tl.f876ARc23Z;
            iArr2[2] = GIi2tl.A5SV6n(context, 2130968905);
        } else {
            int[] iArr3 = GIi2tl.f873A4TApA;
            iArr[0] = iArr3;
            iArr2[0] = ADYaiT2.getColorForState(iArr3, 0);
            iArr[1] = GIi2tl.AMqCpz;
            iArr2[1] = GIi2tl.A5SV6n(context, 2130968852);
            iArr[2] = GIi2tl.f876ARc23Z;
            iArr2[2] = ADYaiT2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public BJ7GGh() {
        this.f656A2egSU = new int[]{2131230840, 2131230838, 2131230764};
        this.f657A4TApA = new int[]{2131230788, 2131230823, 2131230795, 2131230790, 2131230791, 2131230794, 2131230793};
        this.f658A5SV6n = new int[]{2131230837, 2131230839, 2131230781, 2131230833, 2131230834, 2131230835, 2131230836};
        this.f659ADYaiT = new int[]{2131230813, 2131230779, 2131230812};
        this.AMqCpz = new int[]{2131230831, 2131230841};
        this.f660ARc23Z = new int[]{2131230767, 2131230773, 2131230768, 2131230774};
    }
}
