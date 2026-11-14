package com.fl.saas.common.util.feature.joor;

import AmA8tU.A2egSU;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EventAnnotation {
    private final String TAG = CommConstant.getClassTag(EventAnnotation.class);
    private final Map<Class<?>, Method> annMethod = new HashMap();
    private final Class<?> type;

    public EventAnnotation(Object obj, Class<?>... clsArr) {
        this.type = obj.getClass();
        parseMethodAnn(clsArr);
    }

    private void parseMethodAnn(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return;
        }
        List asList = Arrays.asList(clsArr);
        for (Method method : this.type.getMethods()) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            if (declaredAnnotations.length == 0) {
                return;
            }
            for (Annotation annotation : declaredAnnotations) {
                Class<?> cls = annotation.getClass();
                if (asList.contains(cls)) {
                    method.setAccessible(true);
                    this.annMethod.put(cls, method);
                }
            }
        }
    }

    public void handleAnnMethod(Object obj, Class<?> cls, A2egSU a2egSU) {
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
        LogcatUtil.d(this.TAG, "type mismatch,type:" + this.type.getName() + ", obj:" + cls2.getName() + ".");
    }
}
