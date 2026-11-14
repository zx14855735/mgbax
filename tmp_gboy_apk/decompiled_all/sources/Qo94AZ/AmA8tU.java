package Qo94AZ;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AmA8tU extends Exception {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AcNBzu f7814AcNBzu;

    public AmA8tU(AcNBzu acNBzu, String str) {
        super(str);
        this.f7814AcNBzu = acNBzu;
    }

    public final AcNBzu A2egSU() {
        return this.f7814AcNBzu;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmA8tU(IOException iOException, String str) {
        super(str, iOException);
        AcNBzu acNBzu = AcNBzu.INTERNAL_ERROR;
        this.f7814AcNBzu = acNBzu;
    }
}
