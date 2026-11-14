package com.fl.saas.common.util.feature.joor;

import AmA8tU.A2egSU;
import com.fl.saas.base.manager.loader.ADYaiT;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AnnontationManager {
    private static final String TAG = CommConstant.getClassTag(AnnontationManager.class);
    private final HashMap<Class<?>, HandlerAnnotation> handlerAnnMap;

    public static final class Holder {
        private static final AnnontationManager INSTANCE = new AnnontationManager();

        static {
            bODRxBM();
        }

        private Holder() {
        }

        private static /* synthetic */ void bODRxBM() {
            char[] charArray = "ÏÃÁ\u0082ËÍÁÉ\u0082ÎÃÕ\u0082ßÄÉÀÀ\u0082æÂÅîÞÅÈËÉ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 172);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÏÀÅÂÅØ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 172);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        kqrP();
    }

    private AnnontationManager() {
        this.handlerAnnMap = new HashMap<>();
    }

    public static AnnontationManager getInstance() {
        return Holder.INSTANCE;
    }

    private static /* synthetic */ void kqrP() {
        char[] charArray = "\u000b\u0007\u0005F\u000f\t\u0005\rF\n\u0007\u0011F\u001b\u0000\r\u0004\u0004F\"\u0006\u0001*\u001a\u0001\f\u000f\r".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'h');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000b\u0004\u0001\u0006\u0001\u001c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'h');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$handleAnnMethod$2(Object[] objArr, Class[] clsArr) {
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadHandlerAnn$0(Class cls) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadHandlerAnn$1(Class cls) {
        return false;
    }

    private HandlerAnnotation loadHandlerAnn(Class<?> cls) {
        HandlerAnnotation handlerAnnotation = this.handlerAnnMap.get(cls);
        if (handlerAnnotation != null) {
            return handlerAnnotation;
        }
        HandlerAnnotation handlerAnnotation2 = new HandlerAnnotation(cls);
        handlerAnnotation2.parseFieldAnn(new ADYaiT(14));
        handlerAnnotation2.parseMethodAnn(new ADYaiT(15));
        this.handlerAnnMap.put(cls, handlerAnnotation2);
        return handlerAnnotation2;
    }

    public void handleAnnMethod(Object obj, Class<?> cls, A2egSU a2egSU) {
        if (obj == null) {
            LogcatUtil.d(TAG, "handleAnnMethod but obj is empty, ann:".concat(cls.getName()));
        } else {
            loadHandlerAnn(obj.getClass()).invoke(obj, cls, a2egSU);
        }
    }

    public void handleAnnMethod(Object obj, Class<?> cls, Object... objArr) {
        handleAnnMethod(obj, cls, (objArr == null || objArr.length <= 0) ? null : new Cd8JRx.ADYaiT(15, objArr));
    }
}
