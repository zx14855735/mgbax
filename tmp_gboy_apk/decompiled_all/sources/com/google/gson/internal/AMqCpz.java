package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f12031AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ InstanceCreator f12032AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Type f12033AmA8tU;

    public /* synthetic */ AMqCpz(InstanceCreator instanceCreator, Type type, int i) {
        this.f12031AcNBzu = i;
        this.f12032AlLFFp = instanceCreator;
        this.f12033AmA8tU = type;
    }

    @Override // com.google.gson.internal.AlLFFp
    public final Object AZkASS() {
        switch (this.f12031AcNBzu) {
        }
        return this.f12032AlLFFp.createInstance(this.f12033AmA8tU);
    }
}
