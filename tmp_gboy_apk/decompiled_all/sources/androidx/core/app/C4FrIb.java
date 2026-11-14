package androidx.core.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class C4FrIb {

    /* renamed from: A2egSU, reason: collision with root package name */
    public BV3sI0 f8553A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public CharSequence f8554A4TApA;

    public void A2egSU(Bundle bundle) {
        CharSequence charSequence = this.f8554A4TApA;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String AMqCpz = AMqCpz();
        if (AMqCpz != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", AMqCpz);
        }
    }

    public void A4TApA(CikNvS cikNvS) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Bitmap A5SV6n(IconCompat iconCompat, int i, int i2) {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        Drawable drawable2;
        Object obj;
        int identifier;
        Context context = this.f8553A2egSU.f8511A2egSU;
        if (iconCompat.f8574A2egSU == 2 && (obj = iconCompat.f8575A4TApA) != null) {
            String str = (String) obj;
            if (str.contains(":")) {
                String str2 = str.split(":", -1)[1];
                String str3 = str2.split("/", -1)[0];
                String str4 = str2.split("/", -1)[1];
                String str5 = str.split(":", -1)[0];
                if (!"0_resource_name_obfuscated".equals(str4) && iconCompat.AMqCpz != (identifier = IconCompat.getResources(context, iconCompat.ADYaiT()).getIdentifier(str4, str3, str5))) {
                    iconCompat.AMqCpz = identifier;
                }
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            drawable2 = BmvVmW.A5SV6n.A4TApA(iconCompat.ASJ6gh(context), context);
        } else {
            switch (iconCompat.f8574A2egSU) {
                case 1:
                    drawable = new BitmapDrawable(context.getResources(), (Bitmap) iconCompat.f8575A4TApA);
                    break;
                case 2:
                    String ADYaiT2 = iconCompat.ADYaiT();
                    if (TextUtils.isEmpty(ADYaiT2)) {
                        ADYaiT2 = context.getPackageName();
                    }
                    Resources resources = IconCompat.getResources(context, ADYaiT2);
                    try {
                        int i4 = iconCompat.AMqCpz;
                        Resources.Theme theme = context.getTheme();
                        ThreadLocal threadLocal = BTvldC.B4ZgIw.f1468A2egSU;
                        drawable = BTvldC.AcNBzu.A2egSU(resources, i4, theme);
                        break;
                    } catch (RuntimeException unused) {
                        String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(iconCompat.AMqCpz), iconCompat.f8575A4TApA);
                        break;
                    }
                case 3:
                    drawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) iconCompat.f8575A4TApA, iconCompat.AMqCpz, iconCompat.f8578ARc23Z));
                    break;
                case 4:
                    InputStream ARc23Z2 = iconCompat.ARc23Z(context);
                    if (ARc23Z2 != null) {
                        bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(ARc23Z2));
                        drawable = bitmapDrawable;
                        break;
                    }
                    drawable = null;
                    break;
                case 5:
                    drawable = new BitmapDrawable(context.getResources(), IconCompat.A2egSU((Bitmap) iconCompat.f8575A4TApA, false));
                    break;
                case 6:
                    InputStream ARc23Z3 = iconCompat.ARc23Z(context);
                    if (ARc23Z3 != null) {
                        if (i3 < 26) {
                            bitmapDrawable = new BitmapDrawable(context.getResources(), IconCompat.A2egSU(BitmapFactory.decodeStream(ARc23Z3), false));
                            drawable = bitmapDrawable;
                            break;
                        } else {
                            drawable = BmvVmW.ADYaiT.A2egSU(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(ARc23Z3)));
                            break;
                        }
                    }
                    drawable = null;
                    break;
                default:
                    drawable = null;
                    break;
            }
            if (drawable != null && (iconCompat.f8579ASJ6gh != null || iconCompat.f8580AYUAbz != IconCompat.f8573AaHO0E)) {
                drawable.mutate();
                BmvVmW.A2egSU.AYUAbz(drawable, iconCompat.f8579ASJ6gh);
                BmvVmW.A2egSU.AZOQYO(drawable, iconCompat.f8580AYUAbz);
            }
            drawable2 = drawable;
        }
        int intrinsicWidth = i2 == 0 ? drawable2.getIntrinsicWidth() : i2;
        if (i2 == 0) {
            i2 = drawable2.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i2, Bitmap.Config.ARGB_8888);
        drawable2.setBounds(0, 0, intrinsicWidth, i2);
        if (i != 0) {
            drawable2.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
        drawable2.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final Bitmap ADYaiT(int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = 0;
        }
        Context context = this.f8553A2egSU.f8511A2egSU;
        PorterDuff.Mode mode = IconCompat.f8573AaHO0E;
        context.getClass();
        Bitmap A5SV6n2 = A5SV6n(IconCompat.A4TApA(context.getResources(), context.getPackageName(), 2131231458), i4, i2);
        Canvas canvas = new Canvas(A5SV6n2);
        Drawable mutate = this.f8553A2egSU.f8511A2egSU.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        int i5 = (i2 - i3) / 2;
        int i6 = i3 + i5;
        mutate.setBounds(i5, i5, i6, i6);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        mutate.draw(canvas);
        return A5SV6n2;
    }

    public String AMqCpz() {
        return null;
    }

    public RemoteViews ARc23Z() {
        return null;
    }

    public RemoteViews ASJ6gh() {
        return null;
    }

    public RemoteViews AYUAbz() {
        return null;
    }
}
