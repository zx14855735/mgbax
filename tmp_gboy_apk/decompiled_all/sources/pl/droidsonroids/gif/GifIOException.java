package pl.droidsonroids.gif;

import java.io.IOException;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class GifIOException extends IOException {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final RujA7D.A2egSU f14094AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f14095AlLFFp;

    public GifIOException(int i, String str) {
        RujA7D.A2egSU a2egSU;
        RujA7D.A2egSU[] values = RujA7D.A2egSU.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                a2egSU = RujA7D.A2egSU.UNKNOWN;
                a2egSU.f7914AlLFFp = i;
                break;
            } else {
                a2egSU = values[i2];
                if (a2egSU.f7914AlLFFp == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.f14094AcNBzu = a2egSU;
        this.f14095AlLFFp = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        RujA7D.A2egSU a2egSU = this.f14094AcNBzu;
        String str = this.f14095AlLFFp;
        if (str == null) {
            a2egSU.getClass();
            Locale locale = Locale.ENGLISH;
            StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(a2egSU.f7914AlLFFp, "GifError ", ": ");
            B9tovu2.append(a2egSU.f7913AcNBzu);
            return B9tovu2.toString();
        }
        StringBuilder sb = new StringBuilder();
        a2egSU.getClass();
        Locale locale2 = Locale.ENGLISH;
        StringBuilder B9tovu3 = J3FDQU.A2egSU.B9tovu(a2egSU.f7914AlLFFp, "GifError ", ": ");
        B9tovu3.append(a2egSU.f7913AcNBzu);
        sb.append(B9tovu3.toString());
        sb.append(": ");
        sb.append(str);
        return sb.toString();
    }
}
