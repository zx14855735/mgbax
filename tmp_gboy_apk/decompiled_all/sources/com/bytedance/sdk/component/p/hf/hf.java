package com.bytedance.sdk.component.p.hf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public @interface hf {
    String xj() default "MULTITON";
}
