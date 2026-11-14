package DcUJf1;

import BTvldC.B4ZgIw;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import com.sigmob.sdk.base.common.a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM extends AZOQYO {

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final PorterDuff.Mode f2382B9tovu = PorterDuff.Mode.SRC_IN;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public B25kr6 f2383AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public PorterDuffColorFilter f2384AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ColorFilter f2385AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f2386B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f2387B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final float[] f2388B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Matrix f2389B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Rect f2390B7CMnp;

    static {
        fsklHZc();
    }

    public B3GDIM() {
        this.f2387B2KMhB = true;
        this.f2388B3GDIM = new float[9];
        this.f2389B4ZgIw = new Matrix();
        this.f2390B7CMnp = new Rect();
        this.f2383AlLFFp = new B25kr6();
    }

    public static B3GDIM A2egSU(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            B3GDIM b3gdim = new B3GDIM();
            ThreadLocal threadLocal = B4ZgIw.f1468A2egSU;
            b3gdim.f2331AcNBzu = BTvldC.AcNBzu.A2egSU(resources, i, theme);
            new B2KMhB(b3gdim.f2331AcNBzu.getConstantState());
            return b3gdim;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            B3GDIM b3gdim2 = new B3GDIM();
            b3gdim2.inflate(resources, xml, asAttributeSet, theme);
            return b3gdim2;
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    private static /* synthetic */ void fsklHZc() {
        char[] charArray = "s\u007f}>wq}u>r\u007fi>cxu||>Z~yRbytwu".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        String str = new String(charArray);
        char[] charArray2 = "s|y~yd".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 16);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final PorterDuffColorFilter A4TApA(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable == null) {
            return false;
        }
        BmvVmW.A2egSU.A4TApA(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f2390B7CMnp;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2385AzWtSf;
        if (colorFilter == null) {
            colorFilter = this.f2384AmA8tU;
        }
        Matrix matrix = this.f2389B4ZgIw;
        canvas.getMatrix(matrix);
        float[] fArr = this.f2388B3GDIM;
        matrix.getValues(fArr);
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[4]);
        float abs3 = Math.abs(fArr[1]);
        float abs4 = Math.abs(fArr[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int width = (int) (rect.width() * abs);
        int min = Math.min(2048, width);
        int min2 = Math.min(2048, (int) (rect.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && com.bumptech.glide.A5SV6n.BPw6Q8(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        B25kr6 b25kr6 = this.f2383AlLFFp;
        Bitmap bitmap = b25kr6.f2374ARc23Z;
        if (bitmap == null || min != bitmap.getWidth() || min2 != b25kr6.f2374ARc23Z.getHeight()) {
            b25kr6.f2374ARc23Z = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
            b25kr6.f2379AaHO0E = true;
        }
        if (this.f2387B2KMhB) {
            B25kr6 b25kr62 = this.f2383AlLFFp;
            if (b25kr62.f2379AaHO0E || b25kr62.f2375ASJ6gh != b25kr62.f2372A5SV6n || b25kr62.f2376AYUAbz != b25kr62.f2373ADYaiT || b25kr62.f2378AZkASS != b25kr62.AMqCpz || b25kr62.f2377AZOQYO != b25kr62.f2371A4TApA.getRootAlpha()) {
                B25kr6 b25kr63 = this.f2383AlLFFp;
                b25kr63.f2374ARc23Z.eraseColor(0);
                Canvas canvas2 = new Canvas(b25kr63.f2374ARc23Z);
                AzWtSf azWtSf = b25kr63.f2371A4TApA;
                azWtSf.A2egSU(azWtSf.f2361ASJ6gh, AzWtSf.f2355B25kr6, canvas2, min, min2);
                B25kr6 b25kr64 = this.f2383AlLFFp;
                b25kr64.f2375ASJ6gh = b25kr64.f2372A5SV6n;
                b25kr64.f2376AYUAbz = b25kr64.f2373ADYaiT;
                b25kr64.f2377AZOQYO = b25kr64.f2371A4TApA.getRootAlpha();
                b25kr64.f2378AZkASS = b25kr64.AMqCpz;
                b25kr64.f2379AaHO0E = false;
            }
        } else {
            B25kr6 b25kr65 = this.f2383AlLFFp;
            b25kr65.f2374ARc23Z.eraseColor(0);
            Canvas canvas3 = new Canvas(b25kr65.f2374ARc23Z);
            AzWtSf azWtSf2 = b25kr65.f2371A4TApA;
            azWtSf2.A2egSU(azWtSf2.f2361ASJ6gh, AzWtSf.f2355B25kr6, canvas3, min, min2);
        }
        B25kr6 b25kr66 = this.f2383AlLFFp;
        if (b25kr66.f2371A4TApA.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (b25kr66.f2380AcNBzu == null) {
                Paint paint2 = new Paint();
                b25kr66.f2380AcNBzu = paint2;
                paint2.setFilterBitmap(true);
            }
            b25kr66.f2380AcNBzu.setAlpha(b25kr66.f2371A4TApA.getRootAlpha());
            b25kr66.f2380AcNBzu.setColorFilter(colorFilter);
            paint = b25kr66.f2380AcNBzu;
        }
        canvas.drawBitmap(b25kr66.f2374ARc23Z, (Rect) null, rect, paint);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getAlpha() : this.f2383AlLFFp.f2371A4TApA.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2383AlLFFp.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? BmvVmW.A2egSU.A5SV6n(drawable) : this.f2385AzWtSf;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f2331AcNBzu != null && Build.VERSION.SDK_INT >= 24) {
            return new B2KMhB(this.f2331AcNBzu.getConstantState());
        }
        this.f2383AlLFFp.f2370A2egSU = getChangingConfigurations();
        return this.f2383AlLFFp;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2383AlLFFp.f2371A4TApA.f2363AZOQYO;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2383AlLFFp.f2371A4TApA.f2362AYUAbz;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.isAutoMirrored() : this.f2383AlLFFp.AMqCpz;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        B25kr6 b25kr6 = this.f2383AlLFFp;
        if (b25kr6 == null) {
            return false;
        }
        AzWtSf azWtSf = b25kr6.f2371A4TApA;
        if (azWtSf.f2368AmA8tU == null) {
            azWtSf.f2368AmA8tU = Boolean.valueOf(azWtSf.f2361ASJ6gh.A2egSU());
        }
        if (azWtSf.f2368AmA8tU.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f2383AlLFFp.f2372A5SV6n;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2386B25kr6 && super.mutate() == this) {
            B25kr6 b25kr6 = this.f2383AlLFFp;
            B25kr6 b25kr62 = new B25kr6();
            b25kr62.f2372A5SV6n = null;
            b25kr62.f2373ADYaiT = f2382B9tovu;
            if (b25kr6 != null) {
                b25kr62.f2370A2egSU = b25kr6.f2370A2egSU;
                AzWtSf azWtSf = new AzWtSf(b25kr6.f2371A4TApA);
                b25kr62.f2371A4TApA = azWtSf;
                if (b25kr6.f2371A4TApA.AMqCpz != null) {
                    azWtSf.AMqCpz = new Paint(b25kr6.f2371A4TApA.AMqCpz);
                }
                if (b25kr6.f2371A4TApA.f2359ADYaiT != null) {
                    b25kr62.f2371A4TApA.f2359ADYaiT = new Paint(b25kr6.f2371A4TApA.f2359ADYaiT);
                }
                b25kr62.f2372A5SV6n = b25kr6.f2372A5SV6n;
                b25kr62.f2373ADYaiT = b25kr6.f2373ADYaiT;
                b25kr62.AMqCpz = b25kr6.AMqCpz;
            }
            this.f2383AlLFFp = b25kr62;
            this.f2386B25kr6 = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        B25kr6 b25kr6 = this.f2383AlLFFp;
        ColorStateList colorStateList = b25kr6.f2372A5SV6n;
        if (colorStateList == null || (mode = b25kr6.f2373ADYaiT) == null) {
            z = false;
        } else {
            this.f2384AmA8tU = A4TApA(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        AzWtSf azWtSf = b25kr6.f2371A4TApA;
        if (azWtSf.f2368AmA8tU == null) {
            azWtSf.f2368AmA8tU = Boolean.valueOf(azWtSf.f2361ASJ6gh.A2egSU());
        }
        if (azWtSf.f2368AmA8tU.booleanValue()) {
            boolean A4TApA2 = b25kr6.f2371A4TApA.f2361ASJ6gh.A4TApA(iArr);
            b25kr6.f2379AaHO0E |= A4TApA2;
            if (A4TApA2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f2383AlLFFp.f2371A4TApA.getRootAlpha() != i) {
            this.f2383AlLFFp.f2371A4TApA.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f2383AlLFFp.AMqCpz = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2385AzWtSf = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            com.bumptech.glide.A5SV6n.D9tr6l(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            BmvVmW.A2egSU.AYUAbz(drawable, colorStateList);
            return;
        }
        B25kr6 b25kr6 = this.f2383AlLFFp;
        if (b25kr6.f2372A5SV6n != colorStateList) {
            b25kr6.f2372A5SV6n = colorStateList;
            this.f2384AmA8tU = A4TApA(colorStateList, b25kr6.f2373ADYaiT);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            BmvVmW.A2egSU.AZOQYO(drawable, mode);
            return;
        }
        B25kr6 b25kr6 = this.f2383AlLFFp;
        if (b25kr6.f2373ADYaiT != mode) {
            b25kr6.f2373ADYaiT = mode;
            this.f2384AmA8tU = A4TApA(b25kr6.f2372A5SV6n, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2331AcNBzu;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AzWtSf azWtSf;
        int i;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f2331AcNBzu;
        if (drawable != null) {
            BmvVmW.A2egSU.ADYaiT(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        B25kr6 b25kr6 = this.f2383AlLFFp;
        b25kr6.f2371A4TApA = new AzWtSf();
        TypedArray ASJ6gh2 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, A2egSU.f2304A2egSU);
        B25kr6 b25kr62 = this.f2383AlLFFp;
        AzWtSf azWtSf2 = b25kr62.f2371A4TApA;
        int i2 = !BTvldC.A4TApA.ADYaiT(xmlPullParser, "tintMode") ? -1 : ASJ6gh2.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i2 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i2 != 5) {
            if (i2 != 9) {
                switch (i2) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        b25kr62.f2373ADYaiT = mode;
        ColorStateList colorStateList = null;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            ASJ6gh2.getValue(1, typedValue);
            int i3 = typedValue.type;
            if (i3 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i3 >= 28 && i3 <= 31) {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = ASJ6gh2.getResources();
                int resourceId = ASJ6gh2.getResourceId(1, 0);
                ThreadLocal threadLocal = BTvldC.A5SV6n.f1446A2egSU;
                try {
                    colorStateList = BTvldC.A5SV6n.A2egSU(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception unused) {
                }
            }
        }
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList2 != null) {
            b25kr62.f2372A5SV6n = colorStateList2;
        }
        boolean z = b25kr62.AMqCpz;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = ASJ6gh2.getBoolean(5, z);
        }
        b25kr62.AMqCpz = z;
        float f = azWtSf2.f2364AZkASS;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = ASJ6gh2.getFloat(7, f);
        }
        azWtSf2.f2364AZkASS = f;
        float f2 = azWtSf2.f2365AaHO0E;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = ASJ6gh2.getFloat(8, f2);
        }
        azWtSf2.f2365AaHO0E = f2;
        if (azWtSf2.f2364AZkASS <= 0.0f) {
            throw new XmlPullParserException(ASJ6gh2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 > 0.0f) {
            azWtSf2.f2362AYUAbz = ASJ6gh2.getDimension(3, azWtSf2.f2362AYUAbz);
            float dimension = ASJ6gh2.getDimension(2, azWtSf2.f2363AZOQYO);
            azWtSf2.f2363AZOQYO = dimension;
            if (azWtSf2.f2362AYUAbz <= 0.0f) {
                throw new XmlPullParserException(ASJ6gh2.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = azWtSf2.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = ASJ6gh2.getFloat(4, alpha);
                }
                azWtSf2.setAlpha(alpha);
                String string = ASJ6gh2.getString(0);
                if (string != null) {
                    azWtSf2.f2367AlLFFp = string;
                    azWtSf2.f2369AzWtSf.put(string, azWtSf2);
                }
                ASJ6gh2.recycle();
                b25kr6.f2370A2egSU = getChangingConfigurations();
                b25kr6.f2379AaHO0E = true;
                B25kr6 b25kr63 = this.f2383AlLFFp;
                AzWtSf azWtSf3 = b25kr63.f2371A4TApA;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(azWtSf3.f2361ASJ6gh);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z2 = true;
                for (int i4 = 1; eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3); i4 = 1) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        AcNBzu acNBzu = (AcNBzu) arrayDeque.peek();
                        boolean equals = "path".equals(name);
                        B25kr6.ADYaiT aDYaiT = azWtSf3.f2369AzWtSf;
                        azWtSf = azWtSf3;
                        if (equals) {
                            AaHO0E aaHO0E = new AaHO0E();
                            aaHO0E.AMqCpz = 0.0f;
                            aaHO0E.f2334ASJ6gh = 1.0f;
                            aaHO0E.f2335AYUAbz = 1.0f;
                            i = depth;
                            aaHO0E.f2336AZOQYO = 0.0f;
                            aaHO0E.f2337AZkASS = 1.0f;
                            aaHO0E.f2338AaHO0E = 0.0f;
                            aaHO0E.f2339AcNBzu = Paint.Cap.BUTT;
                            aaHO0E.f2340AlLFFp = Paint.Join.MITER;
                            aaHO0E.f2341AmA8tU = 4.0f;
                            TypedArray ASJ6gh3 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, A2egSU.f2306A5SV6n);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = ASJ6gh3.getString(0);
                                if (string2 != null) {
                                    aaHO0E.f2353A4TApA = string2;
                                }
                                String string3 = ASJ6gh3.getString(2);
                                if (string3 != null) {
                                    aaHO0E.f2352A2egSU = com.bumptech.glide.AMqCpz.B9tovu(string3);
                                }
                                aaHO0E.f2333ARc23Z = BTvldC.A4TApA.A4TApA(ASJ6gh3, xmlPullParser, theme, "fillColor", 1);
                                float f3 = aaHO0E.f2335AYUAbz;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f3 = ASJ6gh3.getFloat(12, f3);
                                }
                                aaHO0E.f2335AYUAbz = f3;
                                int i5 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? ASJ6gh3.getInt(8, -1) : -1;
                                Paint.Cap cap2 = aaHO0E.f2339AcNBzu;
                                if (i5 == 0) {
                                    cap = Paint.Cap.BUTT;
                                } else if (i5 != 1) {
                                    cap = i5 != 2 ? cap2 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                aaHO0E.f2339AcNBzu = cap;
                                int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? ASJ6gh3.getInt(9, -1) : -1;
                                Paint.Join join2 = aaHO0E.f2340AlLFFp;
                                if (i6 == 0) {
                                    join = Paint.Join.MITER;
                                } else if (i6 != 1) {
                                    join = i6 != 2 ? join2 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                aaHO0E.f2340AlLFFp = join;
                                float f4 = aaHO0E.f2341AmA8tU;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f4 = ASJ6gh3.getFloat(10, f4);
                                }
                                aaHO0E.f2341AmA8tU = f4;
                                aaHO0E.f2332ADYaiT = BTvldC.A4TApA.A4TApA(ASJ6gh3, xmlPullParser, theme, "strokeColor", 3);
                                float f5 = aaHO0E.f2334ASJ6gh;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f5 = ASJ6gh3.getFloat(11, f5);
                                }
                                aaHO0E.f2334ASJ6gh = f5;
                                float f6 = aaHO0E.AMqCpz;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f6 = ASJ6gh3.getFloat(4, f6);
                                }
                                aaHO0E.AMqCpz = f6;
                                float f7 = aaHO0E.f2337AZkASS;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f7 = ASJ6gh3.getFloat(6, f7);
                                }
                                aaHO0E.f2337AZkASS = f7;
                                float f8 = aaHO0E.f2338AaHO0E;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f8 = ASJ6gh3.getFloat(7, f8);
                                }
                                aaHO0E.f2338AaHO0E = f8;
                                float f9 = aaHO0E.f2336AZOQYO;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f9 = ASJ6gh3.getFloat(5, f9);
                                }
                                aaHO0E.f2336AZOQYO = f9;
                                int i7 = aaHO0E.f2354A5SV6n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i7 = ASJ6gh3.getInt(13, i7);
                                }
                                aaHO0E.f2354A5SV6n = i7;
                            }
                            ASJ6gh3.recycle();
                            acNBzu.f2343A4TApA.add(aaHO0E);
                            if (aaHO0E.getPathName() != null) {
                                aDYaiT.put(aaHO0E.getPathName(), aaHO0E);
                            }
                            b25kr63.f2370A2egSU = b25kr63.f2370A2egSU;
                            z2 = false;
                        } else {
                            i = depth;
                            if ("clip-path".equals(name)) {
                                AZkASS aZkASS = new AZkASS();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray ASJ6gh4 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, A2egSU.f2307ADYaiT);
                                    String string4 = ASJ6gh4.getString(0);
                                    if (string4 != null) {
                                        aZkASS.f2353A4TApA = string4;
                                    }
                                    String string5 = ASJ6gh4.getString(1);
                                    if (string5 != null) {
                                        aZkASS.f2352A2egSU = com.bumptech.glide.AMqCpz.B9tovu(string5);
                                    }
                                    aZkASS.f2354A5SV6n = !BTvldC.A4TApA.ADYaiT(xmlPullParser, "fillType") ? 0 : ASJ6gh4.getInt(2, 0);
                                    ASJ6gh4.recycle();
                                }
                                acNBzu.f2343A4TApA.add(aZkASS);
                                if (aZkASS.getPathName() != null) {
                                    aDYaiT.put(aZkASS.getPathName(), aZkASS);
                                }
                                b25kr63.f2370A2egSU = b25kr63.f2370A2egSU;
                            } else if ("group".equals(name)) {
                                AcNBzu acNBzu2 = new AcNBzu();
                                TypedArray ASJ6gh5 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, A2egSU.f2305A4TApA);
                                float f10 = acNBzu2.f2344A5SV6n;
                                if (BTvldC.A4TApA.ADYaiT(xmlPullParser, a.B)) {
                                    f10 = ASJ6gh5.getFloat(5, f10);
                                }
                                acNBzu2.f2344A5SV6n = f10;
                                acNBzu2.f2345ADYaiT = ASJ6gh5.getFloat(1, acNBzu2.f2345ADYaiT);
                                acNBzu2.AMqCpz = ASJ6gh5.getFloat(2, acNBzu2.AMqCpz);
                                float f11 = acNBzu2.f2346ARc23Z;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f11 = ASJ6gh5.getFloat(3, f11);
                                }
                                acNBzu2.f2346ARc23Z = f11;
                                float f12 = acNBzu2.f2347ASJ6gh;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f12 = ASJ6gh5.getFloat(4, f12);
                                }
                                acNBzu2.f2347ASJ6gh = f12;
                                float f13 = acNBzu2.f2348AYUAbz;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f13 = ASJ6gh5.getFloat(6, f13);
                                }
                                acNBzu2.f2348AYUAbz = f13;
                                float f14 = acNBzu2.f2349AZOQYO;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f14 = ASJ6gh5.getFloat(7, f14);
                                }
                                acNBzu2.f2349AZOQYO = f14;
                                String string6 = ASJ6gh5.getString(0);
                                if (string6 != null) {
                                    acNBzu2.f2351AaHO0E = string6;
                                }
                                acNBzu2.A5SV6n();
                                ASJ6gh5.recycle();
                                acNBzu.f2343A4TApA.add(acNBzu2);
                                arrayDeque.push(acNBzu2);
                                if (acNBzu2.getGroupName() != null) {
                                    aDYaiT.put(acNBzu2.getGroupName(), acNBzu2);
                                }
                                b25kr63.f2370A2egSU = b25kr63.f2370A2egSU;
                            }
                        }
                    } else {
                        azWtSf = azWtSf3;
                        i = depth;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    azWtSf3 = azWtSf;
                    depth = i;
                }
                if (!z2) {
                    this.f2384AmA8tU = A4TApA(b25kr6.f2372A5SV6n, b25kr6.f2373ADYaiT);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(ASJ6gh2.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(ASJ6gh2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public B3GDIM(B25kr6 b25kr6) {
        this.f2387B2KMhB = true;
        this.f2388B3GDIM = new float[9];
        this.f2389B4ZgIw = new Matrix();
        this.f2390B7CMnp = new Rect();
        this.f2383AlLFFp = b25kr6;
        this.f2384AmA8tU = A4TApA(b25kr6.f2372A5SV6n, b25kr6.f2373ADYaiT);
    }
}
