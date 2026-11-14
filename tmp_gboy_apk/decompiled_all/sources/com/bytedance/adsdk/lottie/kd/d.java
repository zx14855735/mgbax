package com.bytedance.adsdk.lottie.kd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.xj.xj.pz;
import com.bytedance.sdk.component.utils.pl;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    private static final ThreadLocal<PathMeasure> xj = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.lottie.kd.d.1
        @Override // java.lang.ThreadLocal
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> hf = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.kd.d.2
        @Override // java.lang.ThreadLocal
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> w = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.lottie.kd.d.3
        @Override // java.lang.ThreadLocal
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> u = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.lottie.kd.d.4
        @Override // java.lang.ThreadLocal
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float kd = (float) (Math.sqrt(2.0d) / 2.0d);

    static {
        dlax();
    }

    private static /* synthetic */ void dlax() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf(Matrix matrix) {
        float[] fArr = u.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int xj(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static boolean xj(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static Path xj(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f = pointF.x + pointF3.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
            return path;
        }
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    public static void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float xj(Matrix matrix) {
        float[] fArr = u.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = kd;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void xj(Path path, pz pzVar) {
        if (pzVar == null || pzVar.kd()) {
            return;
        }
        xj(path, ((com.bytedance.adsdk.lottie.xj.hf.u) pzVar.hf()).d() / 100.0f, ((com.bytedance.adsdk.lottie.xj.hf.u) pzVar.w()).d() / 100.0f, ((com.bytedance.adsdk.lottie.xj.hf.u) pzVar.u()).d() / 360.0f);
    }

    public static void xj(Path path, float f, float f2, float f3) {
        com.bytedance.adsdk.lottie.kd.xj("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = xj.get();
        Path path2 = hf.get();
        Path path3 = w.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.bytedance.adsdk.lottie.kd.hf("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f2 - f) - 1.0f) >= 0.01d) {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = f.xj(min, length);
                max = f.xj(max, length);
            }
            if (min < 0.0f) {
                min = f.xj(min, length);
            }
            if (max < 0.0f) {
                max = f.xj(max, length);
            }
            if (min == max) {
                path.reset();
                com.bytedance.adsdk.lottie.kd.hf("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.bytedance.adsdk.lottie.kd.hf("applyTrimPathIfNeeded");
            return;
        }
        com.bytedance.adsdk.lottie.kd.hf("applyTrimPathIfNeeded");
    }

    public static float xj() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float xj(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap xj(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean xj(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void xj(Canvas canvas, RectF rectF, Paint paint) {
        xj(canvas, rectF, paint, 31);
    }

    public static void xj(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.bytedance.adsdk.lottie.kd.xj("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.bytedance.adsdk.lottie.kd.hf("Utils#saveLayer");
    }

    public static float xj(String str, String str2, int i) {
        if (str2 != null) {
            try {
                if (str2.contains("%")) {
                    return (Integer.parseInt(str2.substring(0, str2.length() - 1)) / 100.0f) * i;
                }
                return Integer.parseInt(str2) * xj();
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        if (TextUtils.equals("x", str) || TextUtils.equals("y", str)) {
            return 0.0f;
        }
        return i;
    }
}
