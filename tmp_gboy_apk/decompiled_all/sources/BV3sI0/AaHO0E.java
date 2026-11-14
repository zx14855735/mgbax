package BV3sI0;

import C4FrIb.AzWtSf;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E extends AZOQYO {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Class f1501AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Constructor f1502B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Method f1503B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Method f1504B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Method f1505B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Method f1506B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Method f1507B9tovu;

    public AaHO0E() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = EsrwYR(cls);
            Class<?> cls2 = Integer.TYPE;
            method3 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
            method4 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method5 = EwN40Z(cls);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f1501AzWtSf = cls;
        this.f1502B25kr6 = constructor;
        this.f1503B2KMhB = method2;
        this.f1504B3GDIM = method3;
        this.f1505B4ZgIw = method4;
        this.f1506B7CMnp = method;
        this.f1507B9tovu = method5;
    }

    public static Method EsrwYR(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // BV3sI0.AZOQYO, JrXYwF.A4TApA
    public final Typeface BI9f7h(Context context, BTvldC.ASJ6gh aSJ6gh, Resources resources, int i) {
        if (this.f1503B2KMhB == null) {
            return super.BI9f7h(context, aSJ6gh, resources, i);
        }
        Object ErKPGd2 = ErKPGd();
        if (ErKPGd2 != null) {
            BTvldC.AYUAbz[] aYUAbzArr = aSJ6gh.f1450A2egSU;
            int length = aYUAbzArr.length;
            int i2 = 0;
            while (i2 < length) {
                BTvldC.AYUAbz aYUAbz = aYUAbzArr[i2];
                String str = aYUAbz.f1451A2egSU;
                FontVariationAxis[] fromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(aYUAbz.f1454ADYaiT);
                Context context2 = context;
                if (!EiK8oA(context2, ErKPGd2, str, aYUAbz.AMqCpz, aYUAbz.f1452A4TApA, aYUAbz.f1453A5SV6n ? 1 : 0, fromFontVariationSettings)) {
                    EdhSi6(ErKPGd2);
                    return null;
                }
                i2++;
                context = context2;
            }
            if (EmJGcg(ErKPGd2)) {
                return EicXu4(ErKPGd2);
            }
        }
        return null;
    }

    @Override // BV3sI0.AZOQYO, JrXYwF.A4TApA
    public final Typeface BIYEnU(Context context, AzWtSf[] azWtSfArr, int i) {
        Typeface EicXu42;
        boolean z;
        if (azWtSfArr.length >= 1) {
            if (this.f1503B2KMhB != null) {
                HashMap hashMap = new HashMap();
                for (AzWtSf azWtSf : azWtSfArr) {
                    if (azWtSf.AMqCpz == 0) {
                        Uri uri = azWtSf.f1576A2egSU;
                        if (!hashMap.containsKey(uri)) {
                            hashMap.put(uri, NOd7IU.AlLFFp.CmUvjW(context, uri));
                        }
                    }
                }
                Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                Object ErKPGd2 = ErKPGd();
                if (ErKPGd2 != null) {
                    boolean z2 = false;
                    for (AzWtSf azWtSf2 : azWtSfArr) {
                        ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(azWtSf2.f1576A2egSU);
                        if (byteBuffer != null) {
                            try {
                                z = ((Boolean) this.f1504B3GDIM.invoke(ErKPGd2, byteBuffer, Integer.valueOf(azWtSf2.f1577A4TApA), null, Integer.valueOf(azWtSf2.f1578A5SV6n), Integer.valueOf(azWtSf2.f1579ADYaiT ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                z = false;
                            }
                            if (!z) {
                                EdhSi6(ErKPGd2);
                                return null;
                            }
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        EdhSi6(ErKPGd2);
                        return null;
                    }
                    if (EmJGcg(ErKPGd2) && (EicXu42 = EicXu4(ErKPGd2)) != null) {
                        return Typeface.create(EicXu42, i);
                    }
                }
            } else {
                AzWtSf BmvVmW2 = BmvVmW(i, azWtSfArr);
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(BmvVmW2.f1576A2egSU, t.k, null);
                    if (openFileDescriptor != null) {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(BmvVmW2.f1578A5SV6n).setItalic(BmvVmW2.f1579ADYaiT).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    }
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BNL6CD(Context context, Resources resources, int i, String str, int i2) {
        if (this.f1503B2KMhB == null) {
            return super.BNL6CD(context, resources, i, str, i2);
        }
        Object ErKPGd2 = ErKPGd();
        if (ErKPGd2 != null) {
            if (!EiK8oA(context, ErKPGd2, str, 0, -1, -1, null)) {
                EdhSi6(ErKPGd2);
                return null;
            }
            if (EmJGcg(ErKPGd2)) {
                return EicXu4(ErKPGd2);
            }
        }
        return null;
    }

    public final void EdhSi6(Object obj) {
        try {
            this.f1506B7CMnp.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean EiK8oA(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1503B2KMhB.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface EicXu4(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f1501AzWtSf, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1507B9tovu.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean EmJGcg(Object obj) {
        try {
            return ((Boolean) this.f1505B4ZgIw.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object ErKPGd() {
        try {
            return this.f1502B25kr6.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method EwN40Z(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
