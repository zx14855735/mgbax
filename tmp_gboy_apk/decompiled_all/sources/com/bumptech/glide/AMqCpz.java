package com.bumptech.glide;

import ADYaiT.CtFAbx;
import AaHO0E.BpkvW3;
import AaHO0E.GYpKKt;
import D8MqeW.B2KMhB;
import D8MqeW.B4ZgIw;
import D8MqeW.B7CMnp;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.czhj.sdk.common.Constants;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.blurkit.d;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.language.Soundex;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AMqCpz implements AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static Method f9914A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f9915A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static Field f9916A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static boolean f9917ADYaiT;
    public static boolean AMqCpz;

    public static int A2egSU(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static Bitmap A4TApA(Context context, Bitmap bitmap, int i) {
        int AzWtSf2;
        Objects.toString(context);
        if (bitmap != null && context != null) {
            try {
                WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setColor(d.f13043a);
                float f = i2;
                float f2 = i3;
                canvas.drawRect(0.0f, 0.0f, f, f2, paint);
                int i4 = 0;
                if (i == 1) {
                    int height = (int) (bitmap.getHeight() * (f / bitmap.getWidth()));
                    int i5 = (i3 - height) / 2;
                    if (bitmap.getWidth() == i2) {
                        if (bitmap.getHeight() != height) {
                        }
                        i4 = i5;
                    }
                    bitmap = Bitmap.createScaledBitmap(bitmap, i2, height, true);
                    i4 = i5;
                } else if (i == 2) {
                    if (bitmap.getWidth() > bitmap.getHeight()) {
                        int width = (int) (bitmap.getWidth() * (f2 / bitmap.getHeight()));
                        AzWtSf2 = (i2 - width) / 2;
                        if (bitmap.getWidth() != width || bitmap.getHeight() != i3) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, width, i3, true);
                        }
                    } else {
                        int AzWtSf3 = i2 - NOd7IU.AlLFFp.AzWtSf(context, 100.0f);
                        if (bitmap.getWidth() != AzWtSf3 || bitmap.getHeight() != i3) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, AzWtSf3, i3, true);
                        }
                        AzWtSf2 = NOd7IU.AlLFFp.AzWtSf(context, 50.0f);
                    }
                    canvas.drawBitmap(bitmap, AzWtSf2, i4, paint);
                    return createBitmap;
                }
                AzWtSf2 = 0;
                canvas.drawBitmap(bitmap, AzWtSf2, i4, paint);
                return createBitmap;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Parcelable A5SV6n(Parcel parcel, int i, Parcelable.Creator creator) {
        int A2egSU2 = A2egSU(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (A2egSU2 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(A2egSU2 + dataPosition);
        return parcelable;
    }

    public static String ADYaiT(Activity activity, float f, StringBuilder sb) {
        sb.append(NOd7IU.AlLFFp.AzWtSf(activity, f));
        return sb.toString();
    }

    public static String AMqCpz(String str) {
        if (str.length() <= 7) {
            return str;
        }
        return str.substring(0, 7) + "...";
    }

    public static void ARc23Z() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void ASJ6gh(android.content.Context r5, GEYgCP.A2egSU r6) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.AMqCpz.ASJ6gh(android.content.Context, GEYgCP.A2egSU):void");
    }

    public static void AYUAbz(Parcel parcel, int i, int i2) {
        int A2egSU2 = A2egSU(parcel, i);
        if (A2egSU2 == i2) {
            return;
        }
        String valueOf = String.valueOf(Integer.toHexString(A2egSU2));
        StringBuilder sb = new StringBuilder(valueOf.length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(A2egSU2);
        throw new DXnQ0V.A5SV6n(J3FDQU.A2egSU.B3GDIM(sb, " (0x", valueOf, ")"), parcel);
    }

    public static String AZOQYO(String str) {
        String str2;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("e7c43d1f0b2169f87f65582d8c46453d".getBytes(), "HmacSHA1");
            SecretKeySpec secretKeySpec2 = new SecretKeySpec("0eff60659338efa2b25b8668ce18c3fb".getBytes(), "HmacSHA1");
            byte[] bytes = "Fmcvv2OIv27cSSj4QBh".getBytes();
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.reset();
            mac.init(secretKeySpec);
            mac.update(bytes);
            byte[] copyOf = Arrays.copyOf(mac.doFinal(), 20);
            if (str.length() >= 8) {
                str2 = str.substring(0, 8);
            } else {
                String str3 = "";
                for (int i = 0; i < 8 - str.length(); i++) {
                    str3 = str3 + Constants.FAIL;
                }
                str2 = str3 + str;
            }
            byte[] bytes2 = str2.getBytes();
            byte[] bArr = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i2] = (byte) (copyOf[i2] ^ bytes2[i2]);
            }
            byte[] bArr2 = new byte[bytes.length + 8];
            System.arraycopy(bytes2, 0, bArr2, 0, 8);
            System.arraycopy(bytes, 0, bArr2, 8, bytes.length);
            mac.reset();
            mac.init(secretKeySpec2);
            mac.update(bArr2);
            byte[] copyOf2 = Arrays.copyOf(mac.doFinal(), 4);
            byte[] bArr3 = new byte[bytes.length + 12];
            System.arraycopy(bArr, 0, bArr3, 0, 8);
            System.arraycopy(copyOf2, 0, bArr3, 8, 4);
            System.arraycopy(bytes, 0, bArr3, 12, bytes.length);
            return new String(Base64.encode(bArr3, 0), "GBK").replace('+', Soundex.SILENT_MARKER).replace('/', '_').replace("==", "").replace("=", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String AZkASS(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toHexString((b >> 4) & 15));
                sb.append(Integer.toHexString(b & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static float AaHO0E(float f, float f2, int i) {
        return (Math.max(0, i - 1) * f2) + f;
    }

    public static float AcNBzu(float f, float f2, int i) {
        return i > 0 ? (f2 / 2.0f) + f : f;
    }

    public static int AlLFFp(Parcel parcel) {
        int readInt = parcel.readInt();
        int A2egSU2 = A2egSU(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new DXnQ0V.A5SV6n(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = A2egSU2 + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new DXnQ0V.A5SV6n(sb.toString(), parcel);
    }

    public static void AmA8tU(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + A2egSU(parcel, i));
    }

    public static boolean AzWtSf(Parcel parcel, int i) {
        AYUAbz(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static boolean B25kr6(BV3sI0.ARc23Z[] aRc23ZArr, BV3sI0.ARc23Z[] aRc23ZArr2) {
        if (aRc23ZArr == null || aRc23ZArr2 == null || aRc23ZArr.length != aRc23ZArr2.length) {
            return false;
        }
        for (int i = 0; i < aRc23ZArr.length; i++) {
            BV3sI0.ARc23Z aRc23Z = aRc23ZArr[i];
            char c = aRc23Z.f1487A2egSU;
            BV3sI0.ARc23Z aRc23Z2 = aRc23ZArr2[i];
            if (c != aRc23Z2.f1487A2egSU || aRc23Z.f1488A4TApA.length != aRc23Z2.f1488A4TApA.length) {
                return false;
            }
        }
        return true;
    }

    public static float B2KMhB(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int B3GDIM(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static float[] B4ZgIw(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int min = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, min);
        return fArr2;
    }

    public static OCUYV2.AlLFFp B7CMnp(Context context, float f, int i, OCUYV2.A2egSU a2egSU, int i2) {
        OCUYV2.AaHO0E aaHO0E;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (i2 != 1) {
            float min = Math.min(context.getResources().getDimension(2131165695) + f, a2egSU.f6223ARc23Z);
            float f7 = min / 2.0f;
            float f8 = 0.0f - f7;
            float f9 = a2egSU.f6223ARc23Z;
            int i3 = a2egSU.f6224ASJ6gh;
            float AcNBzu2 = AcNBzu(0.0f, f9, i3);
            float CtFAbx2 = CtFAbx(0.0f, AaHO0E(AcNBzu2, a2egSU.f6223ARc23Z, i3), a2egSU.f6223ARc23Z, i3);
            float AcNBzu3 = AcNBzu(CtFAbx2, a2egSU.AMqCpz, a2egSU.f6222ADYaiT);
            float AcNBzu4 = AcNBzu(CtFAbx(CtFAbx2, AcNBzu3, a2egSU.AMqCpz, a2egSU.f6222ADYaiT), a2egSU.f6220A4TApA, a2egSU.f6221A5SV6n);
            float f10 = f7 + i;
            float A4TApA2 = OCUYV2.AZOQYO.A4TApA(min, a2egSU.f6223ARc23Z, f);
            float A4TApA3 = OCUYV2.AZOQYO.A4TApA(a2egSU.f6220A4TApA, a2egSU.f6223ARc23Z, f);
            float A4TApA4 = OCUYV2.AZOQYO.A4TApA(a2egSU.AMqCpz, a2egSU.f6223ARc23Z, f);
            OCUYV2.AaHO0E aaHO0E2 = new OCUYV2.AaHO0E(a2egSU.f6223ARc23Z, i);
            aaHO0E2.A2egSU(f8, A4TApA2, min, false, true);
            aaHO0E2.A5SV6n(AcNBzu2, 0.0f, a2egSU.f6223ARc23Z, a2egSU.f6224ASJ6gh, true);
            if (a2egSU.f6222ADYaiT > 0) {
                aaHO0E2.A2egSU(AcNBzu3, A4TApA4, a2egSU.AMqCpz, false, false);
            }
            int i4 = a2egSU.f6221A5SV6n;
            if (i4 > 0) {
                aaHO0E2.A5SV6n(AcNBzu4, A4TApA3, a2egSU.f6220A4TApA, i4, false);
            }
            aaHO0E2.A2egSU(f10, A4TApA2, min, false, true);
            return aaHO0E2.ADYaiT();
        }
        float min2 = Math.min(context.getResources().getDimension(2131165695) + f, a2egSU.f6223ARc23Z);
        float f11 = min2 / 2.0f;
        float f12 = 0.0f - f11;
        float AcNBzu5 = AcNBzu(0.0f, a2egSU.f6220A4TApA, a2egSU.f6221A5SV6n);
        float CtFAbx3 = CtFAbx(0.0f, AaHO0E(AcNBzu5, a2egSU.f6220A4TApA, (int) Math.floor(a2egSU.f6221A5SV6n / 2.0f)), a2egSU.f6220A4TApA, a2egSU.f6221A5SV6n);
        float AcNBzu6 = AcNBzu(CtFAbx3, a2egSU.AMqCpz, a2egSU.f6222ADYaiT);
        float CtFAbx4 = CtFAbx(CtFAbx3, AaHO0E(AcNBzu6, a2egSU.AMqCpz, (int) Math.floor(a2egSU.f6222ADYaiT / 2.0f)), a2egSU.AMqCpz, a2egSU.f6222ADYaiT);
        float f13 = a2egSU.f6223ARc23Z;
        int i5 = a2egSU.f6224ASJ6gh;
        float AcNBzu7 = AcNBzu(CtFAbx4, f13, i5);
        float CtFAbx5 = CtFAbx(CtFAbx4, AaHO0E(AcNBzu7, a2egSU.f6223ARc23Z, i5), a2egSU.f6223ARc23Z, i5);
        float AcNBzu8 = AcNBzu(CtFAbx5, a2egSU.AMqCpz, a2egSU.f6222ADYaiT);
        float AcNBzu9 = AcNBzu(CtFAbx(CtFAbx5, AaHO0E(AcNBzu8, a2egSU.AMqCpz, (int) Math.ceil(a2egSU.f6222ADYaiT / 2.0f)), a2egSU.AMqCpz, a2egSU.f6222ADYaiT), a2egSU.f6220A4TApA, a2egSU.f6221A5SV6n);
        float f14 = f11 + i;
        float A4TApA5 = OCUYV2.AZOQYO.A4TApA(min2, a2egSU.f6223ARc23Z, f);
        float A4TApA6 = OCUYV2.AZOQYO.A4TApA(a2egSU.f6220A4TApA, a2egSU.f6223ARc23Z, f);
        float A4TApA7 = OCUYV2.AZOQYO.A4TApA(a2egSU.AMqCpz, a2egSU.f6223ARc23Z, f);
        OCUYV2.AaHO0E aaHO0E3 = new OCUYV2.AaHO0E(a2egSU.f6223ARc23Z, i);
        aaHO0E3.A2egSU(f12, A4TApA5, min2, false, true);
        if (a2egSU.f6221A5SV6n > 0) {
            f3 = AcNBzu7;
            float f15 = a2egSU.f6220A4TApA;
            int floor = (int) Math.floor(r0 / 2.0f);
            aaHO0E = aaHO0E3;
            f4 = AcNBzu8;
            f2 = AcNBzu6;
            aaHO0E.A5SV6n(AcNBzu5, A4TApA6, f15, floor, false);
            f5 = A4TApA6;
        } else {
            aaHO0E = aaHO0E3;
            f2 = AcNBzu6;
            f3 = AcNBzu7;
            f4 = AcNBzu8;
            f5 = A4TApA6;
        }
        if (a2egSU.f6222ADYaiT > 0) {
            f6 = A4TApA7;
            aaHO0E.A5SV6n(f2, f6, a2egSU.AMqCpz, (int) Math.floor(r8 / 2.0f), false);
        } else {
            f6 = A4TApA7;
        }
        aaHO0E.A5SV6n(f3, 0.0f, a2egSU.f6223ARc23Z, a2egSU.f6224ASJ6gh, true);
        if (a2egSU.f6222ADYaiT > 0) {
            aaHO0E.A5SV6n(f4, f6, a2egSU.AMqCpz, (int) Math.ceil(r0 / 2.0f), false);
        }
        if (a2egSU.f6221A5SV6n > 0) {
            aaHO0E.A5SV6n(AcNBzu9, f5, a2egSU.f6220A4TApA, (int) Math.ceil(r0 / 2.0f), false);
        }
        OCUYV2.AaHO0E aaHO0E4 = aaHO0E;
        aaHO0E4.A2egSU(f14, A4TApA5, min2, false, true);
        return aaHO0E4.ADYaiT();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098 A[Catch: NumberFormatException -> 0x00ac, LOOP:3: B:25:0x006a->B:35:0x0098, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:35:0x0098, B:39:0x009e, B:44:0x00b3, B:56:0x00b6), top: B:21:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:35:0x0098, B:39:0x009e, B:44:0x00b3, B:56:0x00b6), top: B:21:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3 A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:35:0x0098, B:39:0x009e, B:44:0x00b3, B:56:0x00b6), top: B:21:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static BV3sI0.ARc23Z[] B9tovu(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.AMqCpz.B9tovu(java.lang.String):BV3sI0.ARc23Z[]");
    }

    public static Path BChYOn(String str) {
        Path path = new Path();
        try {
            BV3sI0.ARc23Z.A4TApA(B9tovu(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing ".concat(str), e);
        }
    }

    public static int BI9f7h(Parcel parcel, int i) {
        AYUAbz(parcel, i, 4);
        return parcel.readInt();
    }

    public static BV3sI0.ARc23Z[] BIYEnU(BV3sI0.ARc23Z[] aRc23ZArr) {
        BV3sI0.ARc23Z[] aRc23ZArr2 = new BV3sI0.ARc23Z[aRc23ZArr.length];
        for (int i = 0; i < aRc23ZArr.length; i++) {
            aRc23ZArr2[i] = new BV3sI0.ARc23Z(aRc23ZArr[i]);
        }
        return aRc23ZArr2;
    }

    public static View BJ7GGh(int i, View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View findViewById = viewGroup.getChildAt(i2).findViewById(i);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }

    public static ColorStateList BNL6CD(Context context, GYpKKt gYpKKt, int i) {
        int resourceId;
        ColorStateList A5SV6n2;
        TypedArray typedArray = gYpKKt.f884A4TApA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(context, resourceId)) == null) ? gYpKKt.A2egSU(i) : A5SV6n2;
    }

    public static ColorStateList BPw6Q8(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList A5SV6n2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(context, resourceId)) == null) ? typedArray.getColorStateList(i) : A5SV6n2;
    }

    public static int BTvldC(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable BV3sI0(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable CQhlFr2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (CQhlFr2 = NOd7IU.AlLFFp.CQhlFr(context, resourceId)) == null) ? typedArray.getDrawable(i) : CQhlFr2;
    }

    public static int BmvVmW(Context context, int i) {
        if (i == 0) {
            return 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.f11243C4FrIb);
        TypedValue typedValue = new TypedValue();
        boolean value = obtainStyledAttributes.getValue(4, typedValue);
        if (!value) {
            value = obtainStyledAttributes.getValue(2, typedValue);
        }
        obtainStyledAttributes.recycle();
        if (value) {
            return (Build.VERSION.SDK_INT >= 22 ? typedValue.getComplexUnit() : typedValue.data & 15) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static String BpkvW3(Parcel parcel, int i) {
        int A2egSU2 = A2egSU(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (A2egSU2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(A2egSU2 + dataPosition);
        return readString;
    }

    public static void C2rE4F() {
        JrXYwF.A5SV6n.f4152ADYaiT.getClass();
    }

    public static int C4FrIb(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static boolean CASmeH(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean CNPG0E(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static int COJEAR(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public static D8MqeW.AmA8tU CQhlFr(D8MqeW.AaHO0E aaHO0E, B4ZgIw b4ZgIw) {
        List list;
        RXb0Sz.ARc23Z.AMqCpz(b4ZgIw, "polygon");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AbstractList abstractList = b4ZgIw.f2041A2egSU;
        int size = abstractList.size();
        for (int i = 0; i < size; i++) {
            D8MqeW.AYUAbz aYUAbz = (D8MqeW.AYUAbz) abstractList.get(i);
            int size2 = aYUAbz.f2018A2egSU.size();
            for (int i2 = 0; i2 < size2; i2++) {
                boolean z = aYUAbz instanceof D8MqeW.ARc23Z;
                List list2 = aYUAbz.f2018A2egSU;
                if (z && i2 == list2.size() / 2) {
                    arrayList2.add(new R8Rbcg.A4TApA(aYUAbz, Integer.valueOf(arrayList.size())));
                }
                arrayList.add(list2.get(i2));
            }
        }
        Float valueOf = Float.valueOf(0.0f);
        int ASJ6gh2 = RD2OKB.AcNBzu.ASJ6gh(arrayList, 9);
        if (ASJ6gh2 == 0) {
            list = RD2OKB.AZkASS.A5SV6n(valueOf);
        } else {
            ArrayList arrayList3 = new ArrayList(ASJ6gh2 + 1);
            arrayList3.add(valueOf);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                D8MqeW.A4TApA a4TApA = (D8MqeW.A4TApA) it.next();
                float floatValue = valueOf.floatValue();
                RXb0Sz.ARc23Z.AMqCpz(a4TApA, "c");
                float intBitsToFloat = Float.intBitsToFloat((int) (aaHO0E.A2egSU(a4TApA, Float.POSITIVE_INFINITY) & 4294967295L));
                if (intBitsToFloat < 0.0f) {
                    throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                }
                valueOf = Float.valueOf(floatValue + intBitsToFloat);
                arrayList3.add(valueOf);
            }
            list = arrayList3;
        }
        float floatValue2 = ((Number) RD2OKB.B4ZgIw.AcNBzu(list)).floatValue();
        B25kr6.AaHO0E aaHO0E2 = new B25kr6.AaHO0E(list.size());
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            aaHO0E2.A2egSU(((Number) list.get(i3)).floatValue() / floatValue2);
        }
        RFbdkT.A5SV6n A4TApA2 = RD2OKB.AZkASS.A4TApA();
        int size4 = arrayList2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            int intValue = ((Number) ((R8Rbcg.A4TApA) arrayList2.get(i4)).f7827AlLFFp).intValue();
            A4TApA2.add(new B2KMhB(B7CMnp.A5SV6n((aaHO0E2.A4TApA(intValue + 1) + aaHO0E2.A4TApA(intValue)) / 2), (D8MqeW.AYUAbz) ((R8Rbcg.A4TApA) arrayList2.get(i4)).f7826AcNBzu));
        }
        return new D8MqeW.AmA8tU(aaHO0E, RD2OKB.AZkASS.A2egSU(A4TApA2), arrayList, aaHO0E2);
    }

    public static void CSDoyG(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static CtxOCS.A4TApA CTkVKb(MappedByteBuffer mappedByteBuffer) {
        long j;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i = duplicate.getShort() & 65535;
        if (i > 100) {
            throw new IOException("Cannot read metadata.");
        }
        duplicate.position(duplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = duplicate.getInt();
            duplicate.position(duplicate.position() + 4);
            j = duplicate.getInt() & 4294967295L;
            duplicate.position(duplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            duplicate.position(duplicate.position() + ((int) (j - duplicate.position())));
            duplicate.position(duplicate.position() + 12);
            long j2 = duplicate.getInt() & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = duplicate.getInt();
                long j3 = duplicate.getInt() & 4294967295L;
                duplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    duplicate.position((int) (j3 + j));
                    CtxOCS.A4TApA a4TApA = new CtxOCS.A4TApA();
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int position = duplicate.position() + duplicate.getInt(duplicate.position());
                    a4TApA.f1918A4TApA = duplicate;
                    a4TApA.f1917A2egSU = position;
                    int i6 = position - duplicate.getInt(position);
                    a4TApA.f1919A5SV6n = i6;
                    a4TApA.f1920ADYaiT = a4TApA.f1918A4TApA.getShort(i6);
                    return a4TApA;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void CcAIMM(BpkvW3 bpkvW3, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            CikNvS.AcNBzu.A5SV6n(bpkvW3, z);
            return;
        }
        if (!f9917ADYaiT) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f9916A5SV6n = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f9917ADYaiT = true;
        }
        Field field = f9916A5SV6n;
        if (field != null) {
            try {
                field.set(bpkvW3, Boolean.valueOf(z));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static void CikNvS(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            CikNvS.AcNBzu.ADYaiT(popupWindow, i);
            return;
        }
        if (!f9915A4TApA) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f9914A2egSU = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f9915A4TApA = true;
        }
        Method method = f9914A2egSU;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long CkXcdM(java.lang.String r23, long r24, long r26, long r28) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.AMqCpz.CkXcdM(java.lang.String, long, long, long):long");
    }

    public static int CmUvjW(int i, int i2, String str) {
        return (int) CkXcdM(str, i, 1, (i2 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final void CqNSpT(Object obj) {
        if (obj instanceof R8Rbcg.A5SV6n) {
            throw ((R8Rbcg.A5SV6n) obj).f7828AcNBzu;
        }
    }

    public static final B4ZgIw CrfGsy(B4ZgIw b4ZgIw, Matrix matrix) {
        RXb0Sz.ARc23Z.AMqCpz(b4ZgIw, "<this>");
        K1Z3yj.A2egSU a2egSU = new K1Z3yj.A2egSU(r0, 12, matrix);
        long j = b4ZgIw.f2042A4TApA;
        float[] fArr = {JrXYwF.A4TApA.COJEAR(j), JrXYwF.A4TApA.CQhlFr(j)};
        matrix.mapPoints(fArr);
        long A2egSU2 = B25kr6.ARc23Z.A2egSU(fArr[0], fArr[1]);
        long A2egSU3 = B25kr6.ARc23Z.A2egSU(Float.intBitsToFloat((int) (A2egSU2 >> 32)), Float.intBitsToFloat((int) (A2egSU2 & 4294967295L)));
        RFbdkT.A5SV6n A4TApA2 = RD2OKB.AZkASS.A4TApA();
        AbstractList abstractList = b4ZgIw.f2041A2egSU;
        int size = abstractList.size();
        for (int i = 0; i < size; i++) {
            A4TApA2.add(((D8MqeW.AYUAbz) abstractList.get(i)).A2egSU(a2egSU));
        }
        return new B4ZgIw(RD2OKB.AZkASS.A2egSU(A4TApA2), A2egSU3);
    }

    public static float CtFAbx(float f, float f2, float f3, int i) {
        return i > 0 ? (f3 / 2.0f) + f2 : f;
    }

    public static IySJvm.A2egSU CtxOCS(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new IySJvm.A2egSU(203);
        }
        try {
            if (new JSONObject(new String(bArr, Charset.forName("utf-8"))).length() <= 0) {
                return new IySJvm.A2egSU(204, 0);
            }
            IySJvm.A2egSU a2egSU = new IySJvm.A2egSU();
            a2egSU.f4098A2egSU = 0;
            return a2egSU;
        } catch (JSONException unused) {
            return new IySJvm.A2egSU(204, 0);
        }
    }

    public static IySJvm.A2egSU D07BeM(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return D6yqiO(str, str2.getBytes(), z);
            }
            return new IySJvm.A2egSU(201);
        } catch (Throwable th) {
            C2rE4F();
            return new IySJvm.A2egSU(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static IySJvm.A2egSU D6DOie(java.lang.String r6, byte[] r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.AMqCpz.D6DOie(java.lang.String, byte[], java.lang.String, java.lang.String, boolean):IySJvm.A2egSU");
    }

    public static IySJvm.A2egSU D6yqiO(String str, byte[] bArr, boolean z) {
        if (str == null) {
            return new IySJvm.A2egSU(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String str2 = null;
        if (bArr.length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    gZIPOutputStream.close();
                    throw th;
                }
            } catch (Throwable unused) {
                C2rE4F();
                gZIPOutputStream.close();
                bArr = null;
            }
            str2 = "gzip";
        }
        if (bArr == null) {
            return new IySJvm.A2egSU(202);
        }
        String str3 = "application/json; charset=utf-8";
        if (!z) {
            return D6DOie(str, bArr, "application/json; charset=utf-8", str2, false);
        }
        byte[] a2 = TTEncryptUtils.a(bArr, bArr.length);
        if (a2 != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str.concat("?");
                }
            } else if (!str.endsWith("&")) {
                str = str.concat("&");
            }
            str = CtFAbx.AcNBzu(str, "encrypt=true");
            str3 = "application/octet-stream;tt-data=a";
            bArr = a2;
        }
        return D6DOie(str, bArr, str3, str2, true);
    }

    public static String D8MqeW() {
        String str = "";
        if (!NOd7IU.AlLFFp.D6DOie()) {
            String str2 = Build.DISPLAY;
            if (!str2.contains("Flyme") && !Build.USER.equals("flyme")) {
                String str3 = Build.MANUFACTURER;
                if (!(!TextUtils.isEmpty(str3) ? str3.toLowerCase(Locale.getDefault()).contains("oppo") : false)) {
                    String D9tr6l2 = NOd7IU.AlLFFp.D9tr6l();
                    String AlLFFp2 = (D9tr6l2 == null || !D9tr6l2.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : CtFAbx.AlLFFp(D9tr6l2, "_", str2);
                    if (!TextUtils.isEmpty(AlLFFp2)) {
                        return AlLFFp2;
                    }
                    String D8cQ8b2 = D8cQ8b("ro.vivo.os.build.display.id");
                    if (!TextUtils.isEmpty(D8cQ8b2) && D8cQ8b2.toLowerCase(Locale.getDefault()).contains("funtouch")) {
                        return D8cQ8b("ro.vivo.os.build.display.id") + "_" + D8cQ8b("ro.vivo.product.version");
                    }
                    if (!TextUtils.isEmpty(str2) && str2.toLowerCase(Locale.getDefault()).contains("amigo")) {
                        StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(str2, "_");
                        A5SV6n2.append(D8cQ8b("ro.gn.sv.version"));
                        return A5SV6n2.toString();
                    }
                    StringBuilder A4TApA2 = B4ZgIw.AYUAbz.A4TApA(str3);
                    A4TApA2.append(Build.BRAND);
                    String sb = A4TApA2.toString();
                    if (!TextUtils.isEmpty(sb)) {
                        String lowerCase = sb.toLowerCase(Locale.getDefault());
                        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                            return D8cQ8b("ro.build.uiversion") + "_" + str2;
                        }
                    }
                    if (!TextUtils.isEmpty(D8cQ8b("ro.letv.release.version"))) {
                        str = "eui_" + D8cQ8b("ro.letv.release.version") + "_" + str2;
                    }
                    return !TextUtils.isEmpty(str) ? str : str2;
                }
                if (TextUtils.isEmpty(str3) ? false : str3.toLowerCase(Locale.getDefault()).contains("oppo")) {
                    return "coloros_" + D8cQ8b("ro.build.version.opporom") + "_" + str2;
                }
            } else if (str2 != null && str2.toLowerCase(Locale.getDefault()).contains("flyme")) {
                return str2;
            }
        } else if (NOd7IU.AlLFFp.D6DOie()) {
            return "miui_" + D8cQ8b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String D8cQ8b(String str) {
        BufferedReader bufferedReader;
        Process exec;
        String str2 = "";
        try {
            exec = Runtime.getRuntime().exec("getprop ".concat(str));
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.destroy();
            D9tr6l(bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            D9tr6l(bufferedReader);
            return str2;
        }
    }

    public static void D9tr6l(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] DAk1zC(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    D9tr6l(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public abstract float BniPrB(Object obj);

    public abstract void Cd8JRx(Object obj, float f);
}
