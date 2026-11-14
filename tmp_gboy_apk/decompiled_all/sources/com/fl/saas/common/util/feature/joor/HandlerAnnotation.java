package com.fl.saas.common.util.feature.joor;

import AmA8tU.A2egSU;
import GnQT2j.A4TApA;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HandlerAnnotation {
    private static final String TAG = CommConstant.getClassTag(EventAnnotation.class);
    private final Class<?> type;
    private final Map<Class<?>, Method> annMethod = new HashMap();
    private final Map<Class<?>, Field> annField = new HashMap();

    static {
        UHLmyj();
    }

    public HandlerAnnotation(Class<?> cls) {
        this.type = cls;
    }

    private static /* synthetic */ void UHLmyj() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$parseFieldAnn$0(Predicate predicate, Field field, Class cls) {
        if (this.annField.containsKey(cls)) {
            throw new AnnontationException("Repeated registration, can only be registered once:".concat(cls.getName()));
        }
        if (!predicate.test(cls)) {
            return Boolean.FALSE;
        }
        field.setAccessible(true);
        this.annField.put(cls, field);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$parseMethodAnn$1(Predicate predicate, Method method, Class cls) {
        if (this.annMethod.containsKey(cls)) {
            throw new AnnontationException("Repeated registration, can only be registered once:".concat(cls.getName()));
        }
        if (!predicate.test(cls)) {
            return Boolean.FALSE;
        }
        method.setAccessible(true);
        this.annMethod.put(cls, method);
        return Boolean.TRUE;
    }

    public void invoke(Object obj, Class<?> cls, A2egSU a2egSU) {
        Class<?> cls2 = obj.getClass();
        if (cls2 == this.type) {
            Method method = this.annMethod.get(cls);
            if (method == null) {
                return;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            try {
                method.invoke(obj, (parameterTypes.length == 0 || a2egSU == null) ? null : (Object[]) a2egSU.apply(parameterTypes));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Locale.getDefault();
        LogcatUtil.d(TAG, "type mismatch,type:" + this.type.getName() + ", obj:" + cls2.getName() + ".");
    }

    public void parseAnn(AnnotatedElement annotatedElement, A2egSU a2egSU) {
        Annotation[] annotations = annotatedElement.getAnnotations();
        int length = annotations.length;
        for (int i = 0; i < length && !((Boolean) a2egSU.apply(annotations[i].getClass())).booleanValue(); i++) {
        }
    }

    public void parseFieldAnn(Predicate<Class<?>> predicate) {
        for (Field field : this.type.getFields()) {
            parseAnn(field, new A4TApA(5, this, predicate, field));
        }
    }

    public void parseMethodAnn(Predicate<Class<?>> predicate) {
        for (Method method : this.type.getMethods()) {
            parseAnn(method, new A4TApA(4, this, predicate, method));
        }
    }
}
