package Hjvs0g;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CNPG0E implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3767A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BI9f7h f3768A4TApA;

    public /* synthetic */ CNPG0E(BI9f7h bI9f7h, int i) {
        this.f3767A2egSU = i;
        this.f3768A4TApA = bI9f7h;
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        Uri fromFile;
        switch (this.f3767A2egSU) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    fromFile = null;
                } else if (str.charAt(0) == '/') {
                    fromFile = Uri.fromFile(new File(str));
                } else {
                    Uri parse = Uri.parse(str);
                    fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str)) : parse;
                }
                if (fromFile == null) {
                    return null;
                }
                BI9f7h bI9f7h = this.f3768A4TApA;
                if (bI9f7h.A4TApA(fromFile)) {
                    return bI9f7h.A2egSU(fromFile, i, i2, amA8tU);
                }
                return null;
            default:
                return this.f3768A4TApA.A2egSU(new AcNBzu((URL) obj), i, i2, amA8tU);
        }
    }

    @Override // Hjvs0g.BI9f7h
    public final /* bridge */ /* synthetic */ boolean A4TApA(Object obj) {
        switch (this.f3767A2egSU) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
