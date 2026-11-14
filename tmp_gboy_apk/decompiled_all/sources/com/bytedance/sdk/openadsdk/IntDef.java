package com.bytedance.sdk.openadsdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public @interface IntDef {
    boolean flag() default false;

    int[] value() default {};
}
