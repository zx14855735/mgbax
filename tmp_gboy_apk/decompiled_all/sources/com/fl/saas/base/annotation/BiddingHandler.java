package com.fl.saas.base.annotation;

import com.fl.saas.base.base.AdapterAPI;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public @interface BiddingHandler {
    Class<? extends AdapterAPI>[] extend() default {AdapterAPI.class};

    int value();
}
