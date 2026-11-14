package BV3sI0;

import C4FrIb.AzWtSf;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static Class f1492AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static Constructor f1493AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static Method f1494AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static Method f1495AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static boolean f1496AmA8tU;

    public static boolean EY4UKY(Object obj, String str, int i, boolean z) {
        EdQ5bb();
        try {
            try {
                return ((Boolean) f1494AcNBzu.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
            } catch (InvocationTargetException e) {
                e = e;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            e = e2;
        }
    }

    public static void EdQ5bb() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f1496AmA8tU) {
            return;
        }
        f1496AmA8tU = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f1493AaHO0E = constructor;
        f1492AZkASS = cls;
        f1494AcNBzu = method2;
        f1495AlLFFp = method;
    }

    @Override // JrXYwF.A4TApA
    public Typeface BI9f7h(Context context, BTvldC.ASJ6gh aSJ6gh, Resources resources, int i) {
        EdQ5bb();
        try {
            Object newInstance = f1493AaHO0E.newInstance(new Object[0]);
            for (BTvldC.AYUAbz aYUAbz : aSJ6gh.f1450A2egSU) {
                File CTkVKb2 = NOd7IU.AlLFFp.CTkVKb(context);
                if (CTkVKb2 == null) {
                    return null;
                }
                try {
                    if (!NOd7IU.AlLFFp.BNL6CD(CTkVKb2, resources, aYUAbz.f1455ARc23Z)) {
                        return null;
                    }
                    if (!EY4UKY(newInstance, CTkVKb2.getPath(), aYUAbz.f1452A4TApA, aYUAbz.f1453A5SV6n)) {
                        return null;
                    }
                    CTkVKb2.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    CTkVKb2.delete();
                }
            }
            EdQ5bb();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f1492AZkASS, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f1495AlLFFp.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // JrXYwF.A4TApA
    public Typeface BIYEnU(Context context, AzWtSf[] azWtSfArr, int i) {
        File file;
        String readlink;
        if (azWtSfArr.length >= 1) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(BmvVmW(i, azWtSfArr).f1576A2egSU, t.k, null);
                if (openFileDescriptor != null) {
                    try {
                        try {
                            readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    try {
                        if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                            file = new File(readlink);
                            if (file != null && file.canRead()) {
                                Typeface createFromFile = Typeface.createFromFile(file);
                                openFileDescriptor.close();
                                return createFromFile;
                            }
                            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                            Typeface BJ7GGh2 = BJ7GGh(context, fileInputStream);
                            fileInputStream.close();
                            openFileDescriptor.close();
                            return BJ7GGh2;
                        }
                        Typeface BJ7GGh22 = BJ7GGh(context, fileInputStream);
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return BJ7GGh22;
                    } finally {
                    }
                    file = null;
                    if (file != null) {
                        Typeface createFromFile2 = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile2;
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
                } else if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }
}
