package OvgpEe;

import AaHO0E.GEYgCP;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ASJ6gh extends Drawable implements Animatable {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final GEYgCP f6850BIYEnU = new GEYgCP(Float.class, "growFraction", 9);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f6851AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B25kr6 f6852AlLFFp;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ObjectAnimator f6854AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ObjectAnimator f6855B25kr6;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ArrayList f6857B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f6858B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public float f6859B7CMnp;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f6861BChYOn;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final float f6856B2KMhB = -1.0f;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Paint f6860B9tovu = new Paint();

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Rect f6862BI9f7h = new Rect();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A2egSU f6853AmA8tU = new A2egSU();

    static {
        aQII();
    }

    public ASJ6gh(Context context, B25kr6 b25kr6) {
        this.f6851AcNBzu = context;
        this.f6852AlLFFp = b25kr6;
        setAlpha(255);
    }

    private static /* synthetic */ void aQII() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final float A4TApA() {
        B25kr6 b25kr6 = this.f6852AlLFFp;
        if (b25kr6.f6913ASJ6gh == 0 && b25kr6.f6914AYUAbz == 0) {
            return 1.0f;
        }
        return this.f6859B7CMnp;
    }

    public final float A5SV6n() {
        float f = this.f6856B2KMhB;
        if (f > 0.0f) {
            return f;
        }
        boolean z = this instanceof AMqCpz;
        B25kr6 b25kr6 = this.f6852AlLFFp;
        if (b25kr6.A5SV6n(z) && b25kr6.f6919AlLFFp != 0) {
            A2egSU a2egSU = this.f6853AmA8tU;
            ContentResolver contentResolver = this.f6851AcNBzu.getContentResolver();
            a2egSU.getClass();
            float A2egSU2 = A2egSU.A2egSU(contentResolver);
            if (A2egSU2 > 0.0f) {
                float uptimeMillis = (SystemClock.uptimeMillis() % r0) / ((int) ((((z ? b25kr6.f6916AZkASS : b25kr6.f6917AaHO0E) * 1000.0f) / b25kr6.f6919AlLFFp) * A2egSU2));
                return uptimeMillis < 0.0f ? (uptimeMillis % 1.0f) + 1.0f : uptimeMillis;
            }
        }
        return 0.0f;
    }

    public final boolean ADYaiT(boolean z, boolean z2, boolean z3) {
        A2egSU a2egSU = this.f6853AmA8tU;
        ContentResolver contentResolver = this.f6851AcNBzu.getContentResolver();
        a2egSU.getClass();
        return AMqCpz(z, z2, z3 && A2egSU.A2egSU(contentResolver) > 0.0f);
    }

    public boolean AMqCpz(boolean z, boolean z2, boolean z3) {
        int i = 1;
        int i2 = 0;
        ObjectAnimator objectAnimator = this.f6854AzWtSf;
        GEYgCP gEYgCP = f6850BIYEnU;
        if (objectAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, gEYgCP, 0.0f, 1.0f);
            this.f6854AzWtSf = ofFloat;
            ofFloat.setDuration(500L);
            this.f6854AzWtSf.setInterpolator(NdEzCJ.A2egSU.f6037A4TApA);
            ObjectAnimator objectAnimator2 = this.f6854AzWtSf;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f6854AzWtSf = objectAnimator2;
            objectAnimator2.addListener(new ARc23Z(this, i2));
        }
        if (this.f6855B25kr6 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, gEYgCP, 1.0f, 0.0f);
            this.f6855B25kr6 = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f6855B25kr6.setInterpolator(NdEzCJ.A2egSU.f6037A4TApA);
            ObjectAnimator objectAnimator3 = this.f6855B25kr6;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.f6855B25kr6 = objectAnimator3;
            objectAnimator3.addListener(new ARc23Z(this, i));
        }
        if (isVisible() || z) {
            ObjectAnimator objectAnimator4 = z ? this.f6854AzWtSf : this.f6855B25kr6;
            ObjectAnimator objectAnimator5 = z ? this.f6855B25kr6 : this.f6854AzWtSf;
            if (!z3) {
                if (objectAnimator5.isRunning()) {
                    boolean z4 = this.f6858B4ZgIw;
                    this.f6858B4ZgIw = true;
                    new ValueAnimator[]{objectAnimator5}[0].cancel();
                    this.f6858B4ZgIw = z4;
                }
                if (objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                } else {
                    boolean z5 = this.f6858B4ZgIw;
                    this.f6858B4ZgIw = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f6858B4ZgIw = z5;
                }
                return super.setVisible(z, false);
            }
            if (!objectAnimator4.isRunning()) {
                boolean z6 = !z || super.setVisible(z, false);
                B25kr6 b25kr6 = this.f6852AlLFFp;
                if (!z ? b25kr6.f6914AYUAbz != 0 : b25kr6.f6913ASJ6gh != 0) {
                    boolean z7 = this.f6858B4ZgIw;
                    this.f6858B4ZgIw = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f6858B4ZgIw = z7;
                    return z6;
                }
                if (z2 || !objectAnimator4.isPaused()) {
                    objectAnimator4.start();
                    return z6;
                }
                objectAnimator4.resume();
                return z6;
            }
        }
        return false;
    }

    public final void ARc23Z(A5SV6n a5SV6n) {
        ArrayList arrayList = this.f6857B3GDIM;
        if (arrayList == null || !arrayList.contains(a5SV6n)) {
            return;
        }
        this.f6857B3GDIM.remove(a5SV6n);
        if (this.f6857B3GDIM.isEmpty()) {
            this.f6857B3GDIM = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6861BChYOn;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ObjectAnimator objectAnimator = this.f6854AzWtSf;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.f6855B25kr6;
        return objectAnimator2 != null && objectAnimator2.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f6861BChYOn = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6860B9tovu.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return ADYaiT(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        AMqCpz(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        AMqCpz(false, true, false);
    }
}
