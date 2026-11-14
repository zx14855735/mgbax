package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@KsAdSdkDynamicApi
@A2egSU
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public @interface KsAdSdkDynamicImpl {
    Class<?> value();
}
