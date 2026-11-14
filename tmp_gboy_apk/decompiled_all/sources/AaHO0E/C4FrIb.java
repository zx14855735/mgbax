package AaHO0E;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class C4FrIb {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f678ADYaiT = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f679A2egSU = 2;

    /* renamed from: A4TApA, reason: collision with root package name */
    public View f680A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f681A5SV6n;

    static {
        iuTo();
    }

    public /* synthetic */ C4FrIb() {
    }

    private static /* synthetic */ void iuTo() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public KeyListener A2egSU(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((K1Z3yj.A2egSU) ((KCxDWD.A5SV6n) this.f681A5SV6n).f4241AlLFFp).getClass();
        if (keyListener instanceof D07BeM.ASJ6gh) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new D07BeM.ASJ6gh(keyListener);
    }

    public void A4TApA(AttributeSet attributeSet, int i) {
        switch (this.f679A2egSU) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f680A4TApA;
                GYpKKt ARc23Z2 = GYpKKt.ARc23Z(absSeekBar.getContext(), attributeSet, f678ADYaiT, i);
                Drawable A5SV6n2 = ARc23Z2.A5SV6n(0);
                if (A5SV6n2 != null) {
                    if (A5SV6n2 instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) A5SV6n2;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable AMqCpz = AMqCpz(animationDrawable.getFrame(i2), true);
                            AMqCpz.setLevel(10000);
                            animationDrawable2.addFrame(AMqCpz, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        A5SV6n2 = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(A5SV6n2);
                }
                Drawable A5SV6n3 = ARc23Z2.A5SV6n(1);
                if (A5SV6n3 != null) {
                    absSeekBar.setProgressDrawable(AMqCpz(A5SV6n3, false));
                }
                ARc23Z2.ASJ6gh();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f680A4TApA).getContext().obtainStyledAttributes(attributeSet, R$styleable.f8021AZOQYO, i, 0);
                try {
                    boolean z = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
                    obtainStyledAttributes.recycle();
                    ADYaiT(z);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public D07BeM.A5SV6n A5SV6n(InputConnection inputConnection, EditorInfo editorInfo) {
        KCxDWD.A5SV6n a5SV6n = (KCxDWD.A5SV6n) this.f681A5SV6n;
        if (inputConnection == null) {
            a5SV6n.getClass();
            inputConnection = null;
        } else {
            K1Z3yj.A2egSU a2egSU = (K1Z3yj.A2egSU) a5SV6n.f4241AlLFFp;
            a2egSU.getClass();
            if (!(inputConnection instanceof D07BeM.A5SV6n)) {
                inputConnection = new D07BeM.A5SV6n((EditText) a2egSU.f4174AlLFFp, inputConnection, editorInfo);
            }
        }
        return (D07BeM.A5SV6n) inputConnection;
    }

    public void ADYaiT(boolean z) {
        D07BeM.AZkASS aZkASS = (D07BeM.AZkASS) ((K1Z3yj.A2egSU) ((KCxDWD.A5SV6n) this.f681A5SV6n).f4241AlLFFp).f4175AmA8tU;
        if (aZkASS.f1939AmA8tU != z) {
            if (aZkASS.f1938AlLFFp != null) {
                androidx.emoji2.text.AmA8tU A2egSU2 = androidx.emoji2.text.AmA8tU.A2egSU();
                GGG1xW gGG1xW = aZkASS.f1938AlLFFp;
                A2egSU2.getClass();
                JrXYwF.A4TApA.B4ZgIw(gGG1xW, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = A2egSU2.f8659A2egSU;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    A2egSU2.f8660A4TApA.remove(gGG1xW);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            aZkASS.f1939AmA8tU = z;
            if (z) {
                D07BeM.AZkASS.A2egSU(aZkASS.f1937AcNBzu, androidx.emoji2.text.AmA8tU.A2egSU().A4TApA());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable AMqCpz(Drawable drawable, boolean z) {
        if (drawable instanceof BmvVmW.AZkASS) {
            BmvVmW.AaHO0E aaHO0E = (BmvVmW.AaHO0E) ((BmvVmW.AZkASS) drawable);
            Drawable drawable2 = aaHO0E.f1526B2KMhB;
            if (drawable2 != null) {
                aaHO0E.ASJ6gh(AMqCpz(drawable2, z));
                return drawable;
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = AMqCpz(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                    if (Build.VERSION.SDK_INT >= 23) {
                        C2rE4F.A2egSU(layerDrawable, layerDrawable2, i2);
                    }
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f681A5SV6n) == null) {
                    this.f681A5SV6n = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public C4FrIb(AbsSeekBar absSeekBar) {
        this.f680A4TApA = absSeekBar;
    }

    public C4FrIb(EditText editText) {
        this.f680A4TApA = editText;
        this.f681A5SV6n = new KCxDWD.A5SV6n(editText);
    }
}
