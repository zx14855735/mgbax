package BmvVmW;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n {
    public static Uri A2egSU(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AMqCpz.A5SV6n(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Drawable A4TApA(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    public static Icon A5SV6n(IconCompat iconCompat, Context context) {
        Icon createWithBitmap;
        switch (iconCompat.f8574A2egSU) {
            case -1:
                return (Icon) iconCompat.f8575A4TApA;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f8575A4TApA);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(iconCompat.ADYaiT(), iconCompat.AMqCpz);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) iconCompat.f8575A4TApA, iconCompat.AMqCpz, iconCompat.f8578ARc23Z);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) iconCompat.f8575A4TApA);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    createWithBitmap = Icon.createWithBitmap(IconCompat.A2egSU((Bitmap) iconCompat.f8575A4TApA, false));
                    break;
                } else {
                    createWithBitmap = ADYaiT.A4TApA((Bitmap) iconCompat.f8575A4TApA);
                    break;
                }
            case 6:
                int i = Build.VERSION.SDK_INT;
                if (i >= 30) {
                    createWithBitmap = ARc23Z.A2egSU(iconCompat.AMqCpz());
                    break;
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.AMqCpz());
                    }
                    InputStream ARc23Z2 = iconCompat.ARc23Z(context);
                    if (ARc23Z2 == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.AMqCpz());
                    }
                    if (i < 26) {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.A2egSU(BitmapFactory.decodeStream(ARc23Z2), false));
                        break;
                    } else {
                        createWithBitmap = ADYaiT.A4TApA(BitmapFactory.decodeStream(ARc23Z2));
                        break;
                    }
                }
        }
        ColorStateList colorStateList = iconCompat.f8579ASJ6gh;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f8580AYUAbz;
        if (mode != IconCompat.f8573AaHO0E) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public static int getType(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AMqCpz.getType(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            Objects.toString(obj);
            return -1;
        } catch (NoSuchMethodException unused2) {
            Objects.toString(obj);
            return -1;
        } catch (InvocationTargetException unused3) {
            Objects.toString(obj);
            return -1;
        }
    }
}
