package IzHBwY;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Function {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4107AcNBzu;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4107AcNBzu) {
            case 0:
                if (obj instanceof SparseArray) {
                    Class cls = (Class) ((SparseArray) obj).get(-99999985);
                    if (cls != Boolean.class && cls != Boolean.TYPE) {
                        if (cls != Integer.TYPE && cls != Integer.class) {
                            if (cls != Long.TYPE && cls != Long.class) {
                                if (cls != Double.TYPE && cls != Double.class) {
                                    if (cls == Float.TYPE || cls == Float.class) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            default:
                if (obj instanceof SparseArray) {
                    Class cls2 = (Class) ((SparseArray) obj).get(-99999985);
                    if (cls2 != Boolean.class && cls2 != Boolean.TYPE) {
                        if (cls2 != Integer.TYPE && cls2 != Integer.class) {
                            if (cls2 != Long.TYPE && cls2 != Long.class) {
                                if (cls2 != Double.TYPE && cls2 != Double.class) {
                                    if (cls2 == Float.TYPE || cls2 == Float.class) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
        }
        return Boolean.FALSE;
    }
}
