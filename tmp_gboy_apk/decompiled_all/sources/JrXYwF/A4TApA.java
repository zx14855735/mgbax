package JrXYwF;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import AaHO0E.HFjH17;
import AaHO0E.HHLj6Q;
import B4ZgIw.AYUAbz;
import CikNvS.AmA8tU;
import CikNvS.AzWtSf;
import CikNvS.B25kr6;
import CikNvS.B3GDIM;
import DaOi9o.COJEAR;
import GJee0v.AZOQYO;
import NOd7IU.AlLFFp;
import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.view.ActionMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.B9tovu;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.pl;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.sigmob.sdk.base.blurkit.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static boolean f4141A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static Field f4142A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static boolean f4143A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static Class f4144ADYaiT;
    public static boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static Field f4145ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static boolean f4146ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static Field f4147AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static boolean f4148AZOQYO;

    public A4TApA() {
        new ConcurrentHashMap();
    }

    public static float A2egSU(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager == null) {
            return 0.0f;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = i / displayMetrics.xdpi;
        return (float) (Math.sqrt(Math.pow(i2, 2.0d) + Math.pow(i, 2.0d)) / Math.sqrt(Math.pow(i2 / displayMetrics.ydpi, 2.0d) + Math.pow(f, 2.0d)));
    }

    public static Bitmap A4TApA(Bitmap bitmap, float f) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.25f, 0.25f);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Bitmap AaHO0E2 = AaHO0E(createBitmap2, f);
            if (AaHO0E2 == null) {
                createBitmap = null;
            } else {
                createBitmap = Bitmap.createBitmap(AaHO0E2.getWidth(), AaHO0E2.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(AaHO0E2, 0.0f, 0.0f, (Paint) null);
                canvas.drawColor(Math.round(0.0f) | (Math.round(51.0f) << 24) | (Math.round(0.0f) << 16) | (Math.round(0.0f) << 8));
                canvas.save();
                canvas.restore();
            }
            WeakReference weakReference = new WeakReference(createBitmap);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (createBitmap2 != null && !createBitmap2.isRecycled()) {
                createBitmap2.recycle();
            }
            if (AaHO0E2 != null && !AaHO0E2.isRecycled()) {
                AaHO0E2.recycle();
            }
            return (Bitmap) weakReference.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String A5SV6n(String str) {
        try {
            if (!str.contains(".apk")) {
                return com.bumptech.glide.AMqCpz.AZkASS(str) + ".apk";
            }
            int lastIndexOf = str.lastIndexOf(47, str.indexOf(".apk"));
            if (lastIndexOf == -1) {
                return com.bumptech.glide.AMqCpz.AZkASS(str) + ".apk";
            }
            int i = lastIndexOf + 1;
            return str.substring(i, str.indexOf(".apk", i)) + ".apk";
        } catch (Exception unused) {
            return com.bumptech.glide.AMqCpz.AZkASS(str) + ".apk";
        }
    }

    public static String ADYaiT(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.toString();
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static StringBuilder AMqCpz(String str) {
        return AYUAbz.A4TApA(str);
    }

    public static void ARc23Z(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int AZkASS2 = AZkASS(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        AmA8tU(parcel, AZkASS2);
    }

    public static void ASJ6gh(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int AZkASS2 = AZkASS(parcel, i);
        parcel.writeString(str);
        AmA8tU(parcel, AZkASS2);
    }

    public static void AYUAbz(WeakReference weakReference, ImageView imageView, String str, float f) {
        if (weakReference != null) {
            try {
                if (weakReference.get() != null) {
                    if (((Activity) weakReference.get()).isDestroyed()) {
                        return;
                    }
                    Activity activity = (Activity) weakReference.get();
                    com.bumptech.glide.A4TApA.A5SV6n(activity).A4TApA(activity).AaHO0E(str).BpkvW3(f).BTvldC(imageView);
                    return;
                }
            } catch (Exception e) {
                e.getMessage();
                int i = AZOQYO.f3039AcNBzu;
                return;
            }
        }
        Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
        if (A5SV6n2 == null || A5SV6n2.isDestroyed()) {
            return;
        }
        com.bumptech.glide.A4TApA.A5SV6n(A5SV6n2).A4TApA(A5SV6n2).AaHO0E(str).BpkvW3(f).BTvldC(imageView);
    }

    public static void AZOQYO(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static int AZkASS(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static Bitmap AaHO0E(Bitmap bitmap, float f) {
        int i;
        int i2;
        if (bitmap == null || (i = (int) f) < 1) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i + i;
        int i7 = i6 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width, height)];
        int i8 = (i6 + 2) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr6 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr6[i11] = i11 / i9;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
        int i12 = i + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = -i;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i) {
                int[] iArr8 = iArr4;
                int[][] iArr9 = iArr7;
                int i26 = iArr[Math.min(i4, Math.max(i16, 0)) + i14];
                int[] iArr10 = iArr9[i16 + i];
                iArr10[0] = (i26 & 16711680) >> 16;
                iArr10[1] = (i26 & 65280) >> 8;
                iArr10[2] = i26 & 255;
                int abs = i12 - Math.abs(i16);
                int i27 = iArr10[0];
                i17 = (i27 * abs) + i17;
                int i28 = iArr10[1];
                i18 = (i28 * abs) + i18;
                int i29 = iArr10[2];
                i19 = (abs * i29) + i19;
                if (i16 > 0) {
                    i25 += i27;
                    i24 += i28;
                    i23 += i29;
                } else {
                    i22 += i27;
                    i21 += i28;
                    i20 += i29;
                }
                i16++;
                iArr4 = iArr8;
                iArr7 = iArr9;
            }
            int[] iArr11 = iArr4;
            int[][] iArr12 = iArr7;
            int i30 = i;
            int i31 = 0;
            while (i31 < width) {
                iArr2[i14] = iArr6[i17];
                iArr3[i14] = iArr6[i18];
                iArr11[i14] = iArr6[i19];
                int i32 = i17 - i22;
                int i33 = i18 - i21;
                int i34 = i19 - i20;
                int[] iArr13 = iArr12[((i30 - i) + i7) % i7];
                int i35 = i22 - iArr13[0];
                int i36 = i21 - iArr13[1];
                int i37 = i20 - iArr13[2];
                if (i13 == 0) {
                    i2 = i31;
                    iArr5[i2] = Math.min(i31 + i + 1, i4);
                } else {
                    i2 = i31;
                }
                int i38 = iArr[i15 + iArr5[i2]];
                int i39 = (i38 & 16711680) >> 16;
                iArr13[0] = i39;
                int i40 = (i38 & 65280) >> 8;
                iArr13[1] = i40;
                int i41 = i38 & 255;
                iArr13[2] = i41;
                int i42 = i25 + i39;
                int i43 = i24 + i40;
                int i44 = i23 + i41;
                i17 = i32 + i42;
                i18 = i33 + i43;
                i19 = i34 + i44;
                i30 = (i30 + 1) % i7;
                int[] iArr14 = iArr12[i30 % i7];
                int i45 = iArr14[0];
                i22 = i35 + i45;
                int i46 = iArr14[1];
                i21 = i36 + i46;
                int i47 = iArr14[2];
                i20 = i37 + i47;
                i25 = i42 - i45;
                i24 = i43 - i46;
                i23 = i44 - i47;
                i14++;
                i31 = i2 + 1;
            }
            i15 += width;
            i13++;
            iArr4 = iArr11;
            iArr7 = iArr12;
        }
        int[] iArr15 = iArr4;
        int[][] iArr16 = iArr7;
        int i48 = 0;
        while (i48 < width) {
            int i49 = -i;
            int i50 = i49 * width;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            while (i49 <= i) {
                int i60 = i48;
                int max = Math.max(0, i50) + i60;
                int[] iArr17 = iArr16[i49 + i];
                iArr17[0] = iArr2[max];
                iArr17[1] = iArr3[max];
                iArr17[2] = iArr15[max];
                int abs2 = i12 - Math.abs(i49);
                i51 = (iArr2[max] * abs2) + i51;
                i52 = (iArr3[max] * abs2) + i52;
                i53 = (iArr15[max] * abs2) + i53;
                if (i49 > 0) {
                    i59 += iArr17[0];
                    i58 += iArr17[1];
                    i57 += iArr17[2];
                } else {
                    i56 += iArr17[0];
                    i55 += iArr17[1];
                    i54 += iArr17[2];
                }
                if (i49 < i5) {
                    i50 += width;
                }
                i49++;
                i48 = i60;
            }
            int i61 = i48;
            int i62 = i;
            int i63 = i61;
            int i64 = 0;
            while (i64 < height) {
                iArr[i63] = (iArr[i63] & d.f13043a) | (iArr6[i51] << 16) | (iArr6[i52] << 8) | iArr6[i53];
                int i65 = i51 - i56;
                int i66 = i52 - i55;
                int i67 = i53 - i54;
                int[] iArr18 = iArr16[((i62 - i) + i7) % i7];
                int i68 = i56 - iArr18[0];
                int i69 = i55 - iArr18[1];
                int i70 = i54 - iArr18[2];
                int i71 = i64;
                if (i61 == 0) {
                    iArr5[i71] = Math.min(i71 + i12, i5) * width;
                }
                int i72 = i61 + iArr5[i71];
                int i73 = iArr2[i72];
                iArr18[0] = i73;
                int i74 = iArr3[i72];
                iArr18[1] = i74;
                int i75 = iArr15[i72];
                iArr18[2] = i75;
                int i76 = i59 + i73;
                int i77 = i58 + i74;
                int i78 = i57 + i75;
                i51 = i65 + i76;
                i52 = i66 + i77;
                i53 = i67 + i78;
                i62 = (i62 + 1) % i7;
                int[] iArr19 = iArr16[i62];
                int i79 = iArr19[0];
                i56 = i68 + i79;
                int i80 = iArr19[1];
                i55 = i69 + i80;
                int i81 = iArr19[2];
                i54 = i70 + i81;
                i59 = i76 - i79;
                i58 = i77 - i80;
                i57 = i78 - i81;
                i63 += width;
                i64 = i71 + 1;
            }
            i48 = i61 + 1;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public static void AcNBzu(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(i2);
        }
    }

    public static boolean AlLFFp(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void AmA8tU(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void AzWtSf(Parcel parcel, int i, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        int AZkASS2 = AZkASS(parcel, i);
        int size = arrayList.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) arrayList.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        AmA8tU(parcel, AZkASS2);
    }

    public static boolean B25kr6(String str) {
        boolean z;
        int length;
        if (str != null && (length = str.length()) != 0) {
            z = false;
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    break;
                }
            }
        }
        z = true;
        return !z;
    }

    public static void B2KMhB(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void B3GDIM(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void B4ZgIw(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void B7CMnp(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(i, i2, "fromIndex: ", ", toIndex: ", ", size: ");
            B7CMnp2.append(i3);
            throw new IndexOutOfBoundsException(B7CMnp2.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static Drawable B9tovu(Drawable drawable, Drawable drawable2, int i, int i2) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        boolean z = (i == -1 || i2 == -1) ? false : true;
        if (i == -1 && (i = drawable2.getIntrinsicWidth()) == -1) {
            i = drawable.getIntrinsicWidth();
        }
        if (i2 == -1 && (i2 = drawable2.getIntrinsicHeight()) == -1) {
            i2 = drawable.getIntrinsicHeight();
        }
        if (i > drawable.getIntrinsicWidth() || i2 > drawable.getIntrinsicHeight()) {
            float f = i / i2;
            if (f >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i2 = (int) (intrinsicWidth / f);
                i = intrinsicWidth;
            } else {
                i2 = drawable.getIntrinsicHeight();
                i = (int) (f * i2);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            layerDrawable.setLayerSize(1, i, i2);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z) {
            drawable2 = new OQbmgg.AMqCpz(drawable2, i, i2);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, drawable2});
        int max = Math.max((drawable.getIntrinsicWidth() - i) / 2, 0);
        int max2 = Math.max((drawable.getIntrinsicHeight() - i2) / 2, 0);
        layerDrawable2.setLayerInset(1, max, max2, max, max2);
        return layerDrawable2;
    }

    public static ImageView.ScaleType BChYOn(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static Drawable BPw6Q8(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
        if (mode != null) {
            mutate.setTintMode(mode);
        }
        return mutate;
    }

    public static final long BTvldC(long j, float f) {
        return B25kr6.ARc23Z.A2egSU(COJEAR(j) / f, CQhlFr(j) / f);
    }

    public static final float BV3sI0(long j, long j2) {
        return (CQhlFr(j2) * CQhlFr(j)) + (COJEAR(j2) * COJEAR(j));
    }

    public static void BniPrB(Object obj) {
        LongSparseArray longSparseArray;
        if (!AMqCpz) {
            try {
                f4144ADYaiT = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            AMqCpz = true;
        }
        Class cls = f4144ADYaiT;
        if (cls == null) {
            return;
        }
        if (!f4146ASJ6gh) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f4145ARc23Z = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f4146ASJ6gh = true;
        }
        Field field = f4145ARc23Z;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static int[] BpkvW3(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            if (i2 == 16842912) {
                return iArr;
            }
            if (i2 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    public static ColorStateList C2rE4F(Drawable drawable) {
        ColorStateList colorStateList;
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !COJEAR.BJ7GGh(drawable)) {
            return null;
        }
        colorStateList = COJEAR.AMqCpz(drawable).getColorStateList();
        return colorStateList;
    }

    public static final float C4FrIb(long j) {
        return (float) Math.sqrt((CQhlFr(j) * CQhlFr(j)) + (COJEAR(j) * COJEAR(j)));
    }

    public static CASmeH.AYUAbz CNPG0E(AppCompatTextView appCompatTextView) {
        int i;
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return new CASmeH.AYUAbz(B25kr6.A5SV6n(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        if (i3 >= 23) {
            i = 1;
            i2 = 1;
        } else {
            i = 0;
            i2 = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (i3 >= 23) {
            i = AmA8tU.A2egSU(appCompatTextView);
            i2 = AmA8tU.ADYaiT(appCompatTextView);
        }
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i3 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(B25kr6.A4TApA(AzWtSf.A2egSU(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new CASmeH.AYUAbz(textPaint, textDirectionHeuristic, i, i2);
    }

    public static final float COJEAR(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float CQhlFr(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static String CSDoyG(String str) {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        com.bumptech.glide.AMqCpz.D9tr6l(bufferedReader2);
                        return sb.toString();
                    }
                    sb.append(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.bumptech.glide.AMqCpz.D9tr6l(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean CikNvS(Uri uri) {
        return uri != null && IAdInterListener.AdProdType.PRODUCT_CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static Typeface CkXcdM(Configuration configuration, Typeface typeface) {
        int i;
        int i2;
        int weight;
        int i3;
        Typeface create;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        i = configuration.fontWeightAdjustment;
        if (i == Integer.MAX_VALUE) {
            return null;
        }
        i2 = configuration.fontWeightAdjustment;
        if (i2 == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        i3 = configuration.fontWeightAdjustment;
        create = Typeface.create(typeface, com.bumptech.glide.AMqCpz.B3GDIM(i3 + weight, 1, 1000), typeface.isItalic());
        return create;
    }

    public static final long CmUvjW(long j, long j2) {
        return B25kr6.ARc23Z.A2egSU(COJEAR(j) - COJEAR(j2), CQhlFr(j) - CQhlFr(j2));
    }

    public static final long CqNSpT(long j, long j2) {
        return B25kr6.ARc23Z.A2egSU(COJEAR(j2) + COJEAR(j), CQhlFr(j2) + CQhlFr(j));
    }

    public static void CrfGsy(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
        mutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public static final void CtFAbx(View view, DV2E8K.ARc23Z aRc23Z) {
        RXb0Sz.ARc23Z.AMqCpz(view, "<this>");
        view.setTag(2131298310, aRc23Z);
    }

    public static final void CtxOCS(View view, B9tovu b9tovu) {
        RXb0Sz.ARc23Z.AMqCpz(view, "<this>");
        view.setTag(2131298309, b9tovu);
    }

    public static void D8cQ8b(TextView textView, int i) {
        B3GDIM(i);
        if (Build.VERSION.SDK_INT >= 28) {
            B25kr6.ADYaiT(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void D9tr6l(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = hasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static void DAk1zC(TextView textView, int i) {
        B3GDIM(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void DG07BK(TextView textView, int i) {
        B3GDIM(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static void DRlcZ9(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void DUi7mC(Drawable drawable, int i) {
        boolean z = i != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
    }

    public static void DV2E8K(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            HFjH17.A2egSU(view, charSequence);
            return;
        }
        HHLj6Q hHLj6Q = HHLj6Q.f914BChYOn;
        if (hHLj6Q != null && hHLj6Q.f916AcNBzu == view) {
            HHLj6Q.A4TApA(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new HHLj6Q(view, charSequence);
            return;
        }
        HHLj6Q hHLj6Q2 = HHLj6Q.f915BI9f7h;
        if (hHLj6Q2 != null && hHLj6Q2.f916AcNBzu == view) {
            hHLj6Q2.A2egSU();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static final long DXuj49(long j, float f) {
        return B25kr6.ARc23Z.A2egSU(COJEAR(j) * f, CQhlFr(j) * f);
    }

    public static int DaOi9o(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static ActionMode.Callback DcUJf1(ActionMode.Callback callback) {
        return (!(callback instanceof B3GDIM) || Build.VERSION.SDK_INT < 26) ? callback : ((B3GDIM) callback).f1812A2egSU;
    }

    public static KCVcbs.A4TApA DdagTj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(CSDoyG(str));
            KCVcbs.A4TApA a4TApA = new KCVcbs.A4TApA();
            a4TApA.f4229A2egSU = jSONObject.optString("url");
            a4TApA.f4230A4TApA = jSONObject.optJSONObject("body");
            jSONObject.optString("dump_file");
            a4TApA.f4231A5SV6n = jSONObject.optBoolean("encrypt", false);
            return a4TApA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ActionMode.Callback Ddcejp(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof B3GDIM) || callback == null) ? callback : new B3GDIM(callback, textView);
    }

    public static String DjONCG(File file, String str, JSONObject jSONObject) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", "https://apmplus.volces.com/apm/collect/crash");
            jSONObject2.put("body", jSONObject);
            jSONObject2.put("dump_file", "");
            jSONObject2.put("encrypt", true);
            EPdU4G(jSONObject2.toString(), file2, false);
        } catch (IOException e) {
            pl.xj(e);
        } catch (JSONException e2) {
            pl.xj(e2);
        }
        return file2.getAbsolutePath();
    }

    public static String Dphsd2(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        int i = 0;
        Throwable th2 = th;
        while (th2 != null) {
            try {
                if (th2 instanceof StackOverflowError) {
                    EUIRHA(th, printWriter);
                    break;
                }
                if (i > 20) {
                    break;
                }
                th2 = th2.getCause();
                i++;
            } catch (Exception unused) {
                printWriter.close();
                return "";
            } catch (Throwable th3) {
                printWriter.close();
                throw th3;
            }
        }
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    public static JSONObject DuwtYk() {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            sb.append("  at ");
            sb.append(className);
            sb.append(".");
            sb.append(stackTraceElement.getMethodName());
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(")\n");
        }
        jSONObject.put("mainStackFromTrace", sb.toString());
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void DvK7DB(KCVcbs.A5SV6n r7, KCVcbs.A2egSU r8, JrXYwF.ARc23Z r9) {
        /*
            java.lang.String r0 = "_"
            org.json.JSONObject r7 = r7.f4232A2egSU
            if (r7 == 0) goto L86
            java.lang.String r1 = "crash_time"
            long r1 = r7.optLong(r1)
            ADYaiT.DUi7mC r7 = JrXYwF.A5SV6n.f4151A5SV6n
            if (r7 == 0) goto L21
            java.util.Map r7 = r7.BNL6CD()
            java.lang.String r3 = "aid"
            java.lang.Object r7 = r7.get(r3)
            boolean r3 = r7 instanceof java.lang.String
            if (r3 == 0) goto L21
            java.lang.String r7 = (java.lang.String) r7
            goto L22
        L21:
            r7 = 0
        L22:
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 == 0) goto L2a
            goto L32
        L2a:
            int r4 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L2f
            goto L32
        L2f:
            com.bumptech.glide.AMqCpz.C2rE4F()
        L32:
            K7mCWO.A4TApA r7 = JrXYwF.A5SV6n.A2egSU()
            java.lang.String r7 = r7.A5SV6n()
            r5 = 0
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 <= 0) goto L86
            if (r4 <= 0) goto L86
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L86
            java.lang.String r3 = "0"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L86
            java.lang.String r3 = r9.f4162AcNBzu
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L86
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L82
            java.lang.String r5 = "android_"
            r3.<init>(r5)     // Catch: org.json.JSONException -> L82
            r3.append(r4)     // Catch: org.json.JSONException -> L82
            r3.append(r0)     // Catch: org.json.JSONException -> L82
            r3.append(r7)     // Catch: org.json.JSONException -> L82
            r3.append(r0)     // Catch: org.json.JSONException -> L82
            r3.append(r1)     // Catch: org.json.JSONException -> L82
            r3.append(r0)     // Catch: org.json.JSONException -> L82
            r3.append(r9)     // Catch: org.json.JSONException -> L82
            java.lang.String r7 = r3.toString()     // Catch: org.json.JSONException -> L82
            java.lang.String r9 = "unique_key"
            org.json.JSONObject r8 = r8.f4228A4TApA     // Catch: org.json.JSONException -> L82
            if (r8 == 0) goto L86
            r8.put(r9, r7)     // Catch: org.json.JSONException -> L82
            goto L86
        L82:
            r7 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r7)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JrXYwF.A4TApA.DvK7DB(KCVcbs.A5SV6n, KCVcbs.A2egSU, JrXYwF.ARc23Z):void");
    }

    public static synchronized void DyaChj(Context context, AMqCpz aMqCpz, boolean z, boolean z2) {
        synchronized (A4TApA.class) {
            ECyGFg(context, aMqCpz, z, z, z2);
        }
    }

    public static synchronized void ECyGFg(Context context, AMqCpz aMqCpz, boolean z, boolean z2, boolean z3) {
        synchronized (A4TApA.class) {
            try {
                if (f4141A2egSU) {
                    return;
                }
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                }
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                Context context2 = A5SV6n.f4149A2egSU;
                A5SV6n.f4150A4TApA = System.currentTimeMillis();
                A5SV6n.f4149A2egSU = context;
                DUi7mC dUi7mC = new DUi7mC(16);
                dUi7mC.f239AlLFFp = context;
                dUi7mC.f240AmA8tU = aMqCpz;
                A5SV6n.f4151A5SV6n = dUi7mC;
                AZOQYO.ARc23Z.AmA8tU(context);
                if (z || z2) {
                    if (KBWg67.A4TApA.AMqCpz == null) {
                        KBWg67.A4TApA a4TApA = new KBWg67.A4TApA();
                        HashSet hashSet = new HashSet();
                        a4TApA.f4223A4TApA = hashSet;
                        a4TApA.f4225ADYaiT = -1L;
                        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                        if (defaultUncaughtExceptionHandler != a4TApA) {
                            Thread.setDefaultUncaughtExceptionHandler(a4TApA);
                            if (a4TApA.f4222A2egSU == null) {
                                a4TApA.f4222A2egSU = defaultUncaughtExceptionHandler;
                            } else {
                                hashSet.add(defaultUncaughtExceptionHandler);
                            }
                        }
                        KBWg67.A4TApA.AMqCpz = a4TApA;
                    }
                    KBWg67.A4TApA a4TApA2 = KBWg67.A4TApA.AMqCpz;
                    if (z) {
                        NOd7IU.AmA8tU amA8tU = new NOd7IU.AmA8tU();
                        amA8tU.f5913AlLFFp = context;
                        a4TApA2.f4224A5SV6n = amA8tU;
                    }
                }
                f4141A2egSU = true;
                K7mCWO.A2egSU.A2egSU().post(new FSFw2u.ASJ6gh(z3, context, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void EGM26s(Context context, String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            sb.append(str2);
            sb.append("\n");
            EPdU4G(sb.toString(), new File(com.bumptech.glide.A5SV6n.DuwtYk(context), "crash_history"), true);
        } catch (IOException e) {
            pl.xj(e);
        }
    }

    public static void EH1KK8(String str) {
        A5SV6n.f4152ADYaiT.getClass();
        if (str == null) {
            return;
        }
        if (KLMZzS.ADYaiT.f4251A2egSU == null) {
            synchronized (KLMZzS.ADYaiT.class) {
                try {
                    if (KLMZzS.ADYaiT.f4251A2egSU == null) {
                        KLMZzS.ADYaiT.f4251A2egSU = new KLMZzS.ADYaiT();
                    }
                } finally {
                }
            }
        }
        KLMZzS.ADYaiT aDYaiT = KLMZzS.ADYaiT.f4251A2egSU;
        KBWg67.A2egSU a2egSU = new KBWg67.A2egSU(str);
        aDYaiT.getClass();
        if (KLMZzS.ADYaiT.f4252A4TApA != null) {
            KLMZzS.ADYaiT.f4252A4TApA.execute(a2egSU);
        }
    }

    public static void EPdU4G(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                com.bumptech.glide.AMqCpz.D9tr6l(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.bumptech.glide.AMqCpz.D9tr6l(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void EQurEW(Throwable th, IQ76hF.AmA8tU amA8tU, StackTraceElement[] stackTraceElementArr, String str, String str2, Set set) {
        if (set.contains(th)) {
            amA8tU.BChYOn("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i = min - 1;
        int i2 = i;
        for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && min2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[min2]); min2--) {
            i2--;
        }
        int i3 = i - i2;
        amA8tU.BChYOn(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str2, "\tat ");
            A5SV6n2.append(stackTrace[i4]);
            amA8tU.BChYOn(A5SV6n2.toString());
        }
        if (min < stackTrace.length) {
            amA8tU.BChYOn("\t... skip " + (stackTrace.length - min) + " lines");
        }
        if (i3 != 0) {
            amA8tU.BChYOn(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            EQurEW(th2, amA8tU, stackTrace, "Suppressed: ", CtFAbx.AcNBzu(str2, "\t"), set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            EQurEW(cause, amA8tU, stackTrace, "Caused by: ", str2, set);
        }
    }

    public static void EUIRHA(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(1, printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (printWriter) {
                try {
                    amA8tU.BChYOn(th);
                    StackTraceElement[] stackTrace = th.getStackTrace();
                    int length = stackTrace.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = stackTrace[i];
                        if (i2 > 256) {
                            amA8tU.BChYOn("\t... skip " + (stackTrace.length - i2) + " lines");
                            break;
                        }
                        amA8tU.BChYOn("\tat " + stackTraceElement);
                        i2++;
                        i++;
                    }
                    for (Throwable th2 : th.getSuppressed()) {
                        EQurEW(th2, amA8tU, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                    }
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        EQurEW(cause, amA8tU, stackTrace, "Caused by: ", "", newSetFromMap);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public abstract Typeface BI9f7h(Context context, BTvldC.ASJ6gh aSJ6gh, Resources resources, int i);

    public abstract Typeface BIYEnU(Context context, C4FrIb.AzWtSf[] azWtSfArr, int i);

    public Typeface BJ7GGh(Context context, InputStream inputStream) {
        File CTkVKb2 = AlLFFp.CTkVKb(context);
        if (CTkVKb2 == null) {
            return null;
        }
        try {
            if (AlLFFp.BPw6Q8(inputStream, CTkVKb2)) {
                return Typeface.createFromFile(CTkVKb2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            CTkVKb2.delete();
        }
    }

    public Typeface BNL6CD(Context context, Resources resources, int i, String str, int i2) {
        File CTkVKb2 = AlLFFp.CTkVKb(context);
        if (CTkVKb2 == null) {
            return null;
        }
        try {
            if (AlLFFp.BNL6CD(CTkVKb2, resources, i)) {
                return Typeface.createFromFile(CTkVKb2.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            CTkVKb2.delete();
        }
    }

    public C4FrIb.AzWtSf BmvVmW(int i, C4FrIb.AzWtSf[] azWtSfArr) {
        new BmvVmW(4);
        int i2 = (i & 1) == 0 ? MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL : 700;
        boolean z = (i & 2) != 0;
        C4FrIb.AzWtSf azWtSf = null;
        int i3 = Integer.MAX_VALUE;
        for (C4FrIb.AzWtSf azWtSf2 : azWtSfArr) {
            int abs = (Math.abs(azWtSf2.f1578A5SV6n - i2) * 2) + (azWtSf2.f1579ADYaiT == z ? 0 : 1);
            if (azWtSf == null || i3 > abs) {
                azWtSf = azWtSf2;
                i3 = abs;
            }
        }
        return azWtSf;
    }

    public abstract InputFilter[] CASmeH(InputFilter[] inputFilterArr);

    public abstract void CTkVKb();

    public boolean CcAIMM() {
        return false;
    }

    public abstract boolean Cd8JRx();

    public abstract void D07BeM(boolean z);

    public void D6DOie(boolean z) {
    }

    public void D6yqiO(boolean z) {
    }

    public abstract void D8MqeW(boolean z);

    public abstract void DXnQ0V();

    public abstract TransformationMethod De4eam(TransformationMethod transformationMethod);
}
