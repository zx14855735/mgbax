package NGepWW;

import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DAk1zC extends ThreadLocal {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f5721A2egSU;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f5721A2egSU) {
            case 0:
                return Boolean.FALSE;
            default:
                return new Random();
        }
    }
}
