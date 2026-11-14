package IzHBwY;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Result {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f4099A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f4100A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f4101A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ValueSet f4102ADYaiT;

    public A2egSU(boolean z, int i, String str, ValueSet valueSet) {
        this.f4099A2egSU = z;
        this.f4100A4TApA = i;
        this.f4101A5SV6n = str;
        this.f4102ADYaiT = valueSet;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public final int code() {
        return this.f4100A4TApA;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public final boolean isSuccess() {
        return this.f4099A2egSU;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public final String message() {
        return this.f4101A5SV6n;
    }

    @Override // com.bykv.vk.openvk.api.proto.Result
    public final ValueSet values() {
        return this.f4102ADYaiT;
    }
}
