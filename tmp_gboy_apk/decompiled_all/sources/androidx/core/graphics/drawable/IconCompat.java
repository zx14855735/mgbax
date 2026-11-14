package androidx.core.graphics.drawable;

import BmvVmW.A5SV6n;
import BmvVmW.AMqCpz;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.blurkit.d;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final PorterDuff.Mode f8573AaHO0E = PorterDuff.Mode.SRC_IN;

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f8574A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f8575A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public byte[] f8576A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Parcelable f8577ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f8578ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ColorStateList f8579ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public PorterDuff.Mode f8580AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public String f8581AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public String f8582AZkASS;

    static {
        yXmtnqd();
    }

    public IconCompat() {
        this.f8574A2egSU = -1;
        this.f8576A5SV6n = null;
        this.f8577ADYaiT = null;
        this.AMqCpz = 0;
        this.f8578ARc23Z = 0;
        this.f8579ASJ6gh = null;
        this.f8580AYUAbz = f8573AaHO0E;
        this.f8581AZOQYO = null;
    }

    public static Bitmap A2egSU(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(d.f13043a);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat A4TApA(Resources resources, String str, int i) {
        str.getClass();
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.AMqCpz = i;
        if (resources != null) {
            try {
                iconCompat.f8575A4TApA = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f8575A4TApA = str;
        }
        iconCompat.f8582AZkASS = str;
        return iconCompat;
    }

    public static Resources getResources(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Unable to find pkg=");
            sb.append(str);
            sb.append(" for icon");
            return null;
        }
    }

    private static /* synthetic */ void yXmtnqd() {
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

    public final int A5SV6n() {
        int i;
        int i2 = this.f8574A2egSU;
        if (i2 != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            if (i2 == 2) {
                return this.AMqCpz;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        Object obj = this.f8575A4TApA;
        if (i >= 28) {
            return AMqCpz.A2egSU(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return 0;
        }
    }

    public final String ADYaiT() {
        int i;
        int i2 = this.f8574A2egSU;
        if (i2 == -1 && (i = Build.VERSION.SDK_INT) >= 23) {
            Object obj = this.f8575A4TApA;
            if (i >= 28) {
                return AMqCpz.A4TApA(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        if (i2 == 2) {
            String str = this.f8582AZkASS;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f8575A4TApA).split(":", -1)[0] : this.f8582AZkASS;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public final Uri AMqCpz() {
        int i = this.f8574A2egSU;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return A5SV6n.A2egSU(this.f8575A4TApA);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.f8575A4TApA);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final InputStream ARc23Z(Context context) {
        Uri AMqCpz = AMqCpz();
        String scheme = AMqCpz.getScheme();
        if (IAdInterListener.AdProdType.PRODUCT_CONTENT.equals(scheme) || n.z.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(AMqCpz);
            } catch (Exception unused) {
                AMqCpz.toString();
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f8575A4TApA));
        } catch (FileNotFoundException unused2) {
            AMqCpz.toString();
            return null;
        }
    }

    public final Icon ASJ6gh(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return A5SV6n.A5SV6n(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public int getType() {
        int i = this.f8574A2egSU;
        return (i != -1 || Build.VERSION.SDK_INT < 23) ? i : A5SV6n.getType(this.f8575A4TApA);
    }

    public final String toString() {
        String str;
        if (this.f8574A2egSU == -1) {
            return String.valueOf(this.f8575A4TApA);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f8574A2egSU) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f8574A2egSU) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f8575A4TApA).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f8575A4TApA).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f8582AZkASS);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(A5SV6n())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.AMqCpz);
                if (this.f8578ARc23Z != 0) {
                    sb.append(" off=");
                    sb.append(this.f8578ARc23Z);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f8575A4TApA);
                break;
        }
        if (this.f8579ASJ6gh != null) {
            sb.append(" tint=");
            sb.append(this.f8579ASJ6gh);
        }
        if (this.f8580AYUAbz != f8573AaHO0E) {
            sb.append(" mode=");
            sb.append(this.f8580AYUAbz);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f8576A5SV6n = null;
        this.f8577ADYaiT = null;
        this.AMqCpz = 0;
        this.f8578ARc23Z = 0;
        this.f8579ASJ6gh = null;
        this.f8580AYUAbz = f8573AaHO0E;
        this.f8581AZOQYO = null;
        this.f8574A2egSU = i;
    }
}
