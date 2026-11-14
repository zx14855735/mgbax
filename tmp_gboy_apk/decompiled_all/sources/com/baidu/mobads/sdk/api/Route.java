package com.baidu.mobads.sdk.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public @interface Route {
    String name() default "";

    String path();
}
