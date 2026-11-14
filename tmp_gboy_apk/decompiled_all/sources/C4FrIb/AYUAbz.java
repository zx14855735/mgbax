package C4FrIb;

import android.util.Base64;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f1554A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f1555A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f1556A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final List f1557ADYaiT;
    public final String AMqCpz;

    public AYUAbz(String str, String str2, String str3, List list) {
        str.getClass();
        this.f1554A2egSU = str;
        str2.getClass();
        this.f1555A4TApA = str2;
        this.f1556A5SV6n = str3;
        list.getClass();
        this.f1557ADYaiT = list;
        this.AMqCpz = str + "-" + str2 + "-" + str3;
    }

    @Deprecated
    public String getIdentifier() {
        return this.AMqCpz;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1554A2egSU + ", mProviderPackage: " + this.f1555A4TApA + ", mQuery: " + this.f1556A5SV6n + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f1557ADYaiT;
            if (i >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i++;
        }
    }
}
