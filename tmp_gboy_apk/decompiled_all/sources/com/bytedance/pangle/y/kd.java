package com.bytedance.pangle.y;

import B4ZgIw.AYUAbz;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.y.y;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements y.xj {
    private static volatile Object hf;
    private static volatile IBinder xj;

    public static class hf extends ResultReceiver {
        private xj xj;

        public hf(xj xjVar) {
            super(null);
            this.xj = xjVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public interface xj {
    }

    private static void hf(String str, int i) {
        if (str == null) {
            return;
        }
        String hf2 = com.bytedance.pangle.kd.w.hf(str, i);
        String kd = com.bytedance.pangle.kd.w.kd(str, i);
        xj(hf2, kd);
        xj(Zeus.getAppApplication().getPackageName(), kd, com.bytedance.pangle.y.hf.xj());
    }

    private static void w(String str, String str2, String str3) {
        if (hf == null || str == null || str2 == null || str3 == null) {
            return;
        }
        xj(hf, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static String[] xj(String... strArr) {
        return strArr;
    }

    @Override // com.bytedance.pangle.y.y.xj
    public boolean xj(String str, int i) {
        xj();
        hf(str, i);
        boolean xj2 = xj("speed", str, i);
        w(str, i);
        return xj2;
    }

    private static void w(String str, int i) {
        if (str == null) {
            return;
        }
        hf(com.bytedance.pangle.kd.w.c(str, i), com.bytedance.pangle.kd.w.y(str, i));
        hf(com.bytedance.pangle.kd.w.kd(str, i));
        hf();
    }

    private static void xj() {
        PackageManager packageManager;
        Field xj2;
        IBinder asBinder;
        if (xj == null && (xj2 = xj((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object xj3 = xj(xj2, packageManager);
            hf = xj3;
            if ((xj3 instanceof IInterface) && (asBinder = ((IInterface) hf).asBinder()) != null) {
                xj = asBinder;
            }
        }
    }

    private static void hf(String str, String str2, String str3) {
        if (hf == null || str == null || str2 == null || str3 == null) {
            return;
        }
        xj(hf, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void hf() {
        xj(w(), (xj) null);
    }

    private static void hf(String str, String str2) {
        try {
            com.bytedance.pangle.util.c.xj(str, str2);
        } catch (Exception unused) {
        }
    }

    private static String[] w() {
        return xj("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void hf(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static boolean xj(String str, String str2, int i) {
        String kd = com.bytedance.pangle.kd.w.kd(str2, i);
        StringBuilder A4TApA2 = AYUAbz.A4TApA(com.bytedance.pangle.kd.w.f(str2, i));
        A4TApA2.append(File.separator);
        A4TApA2.append(com.bytedance.pangle.y.hf.xj(kd));
        String sb = A4TApA2.toString();
        for (int i2 = 1; i2 <= 3; i2++) {
            xj(xj(str), (xj) null);
            if (com.bytedance.pangle.y.hf.xj(sb)) {
                return true;
            }
        }
        return false;
    }

    private static void xj(String str, String str2, String str3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 30) {
            hf(str, str2, str3);
        } else if (i == 29) {
            w(str, str2, str3);
        }
    }

    private static void xj(String[] strArr, xj xjVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new hf(xjVar).writeToParcel(obtain, 0);
        try {
            xj.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static String[] xj(String str) {
        return xj("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static void xj(String str, String str2) {
        try {
            com.bytedance.pangle.util.f.xj(str, str2);
        } catch (Exception unused) {
        }
    }

    public static Field xj(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return xj(obj.getClass(), str);
    }

    public static Field xj(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object xj(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object xj(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
