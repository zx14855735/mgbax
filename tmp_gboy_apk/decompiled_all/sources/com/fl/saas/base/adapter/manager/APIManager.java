package com.fl.saas.base.adapter.manager;

import android.text.TextUtils;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.type.AdvertiserID;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ReflectUtils;
import com.fl.saas.common.util.SPILoader;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class APIManager<T> {
    private static final List<Integer> ADVS = ReflectUtils.getStaticFinalValues(AdvertiserID.class, Integer.TYPE);
    private String TAG = CommConstant.getObjTag(this);
    private final Map<Integer, Constructor<T>> adapters = new HashMap();

    static {
        tqGxLc();
    }

    public APIManager(Class<T> cls) {
        registerAdapter(cls);
    }

    private Constructor<T> register(int i, Class<T> cls) {
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.adapters.put(Integer.valueOf(i), constructor);
        return constructor;
    }

    private void registerAdapter(Class<T> cls) {
        Iterator<String> it = SPILoader.loadSPINames(cls.getClassLoader(), registerClass()).iterator();
        while (it.hasNext()) {
            try {
                Class<?> cls2 = Class.forName(it.next());
                if (cls.isAssignableFrom(cls2)) {
                    register(cls2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Constructor<T> registerCustom(int i, String str) {
        try {
            return register(i, Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static /* synthetic */ void tqGxLc() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public T loadAdapter(int i, String str) {
        Constructor<T> constructor = this.adapters.get(Integer.valueOf(i));
        if (constructor == null && !TextUtils.isEmpty(str)) {
            constructor = registerCustom(i, str);
        }
        if (constructor == null && TextUtils.isEmpty(str) && !ADVS.contains(Integer.valueOf(i))) {
            constructor = this.adapters.get(5);
        }
        if (constructor != null) {
            try {
                return constructor.newInstance(new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogcatUtil.e(this.TAG, String.format(Locale.getDefault(), "loadAdapter is empty, advId: %d,customName: %s", Integer.valueOf(i), str));
        return null;
    }

    public abstract Class<?> registerClass();

    private void register(Class<T> cls) {
        int custom;
        try {
            Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
            if (advertiser == null) {
                return;
            }
            int value = advertiser.value();
            for (Class<?> cls2 : advertiser.keyClass()) {
                if (cls2 != Object.class) {
                    LogcatUtil.d(cls2.toString());
                }
            }
            if (value == -1 && (custom = advertiser.custom()) != -1) {
                value = custom;
            }
            register(value, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
