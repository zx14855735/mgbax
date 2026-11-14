package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.B4ZgIw {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static int f7975AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static Field f7976AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static Field f7977AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Field f7978B25kr6;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ComponentActivity f7979AcNBzu;

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
        if (alLFFp != androidx.lifecycle.AlLFFp.ON_DESTROY) {
            return;
        }
        if (f7975AlLFFp == 0) {
            try {
                f7975AlLFFp = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f7977AzWtSf = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f7978B25kr6 = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f7976AmA8tU = declaredField3;
                declaredField3.setAccessible(true);
                f7975AlLFFp = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f7975AlLFFp == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f7979AcNBzu.getSystemService("input_method");
            try {
                Object obj = f7976AmA8tU.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) f7977AzWtSf.get(inputMethodManager);
                        if (view != null) {
                            if (!view.isAttachedToWindow()) {
                                f7978B25kr6.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            }
                        }
                    } catch (IllegalAccessException unused2) {
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    } finally {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
