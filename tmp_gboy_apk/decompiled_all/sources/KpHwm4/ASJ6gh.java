package KpHwm4;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f4289A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public String f4290A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public String f4291A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public String[] f4292ADYaiT = new String[0];

    public final boolean equals(Object obj) {
        String[] strArr;
        String[] strArr2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASJ6gh)) {
            return false;
        }
        ASJ6gh aSJ6gh = (ASJ6gh) obj;
        if (!this.f4291A5SV6n.equals(aSJ6gh.f4291A5SV6n) || (strArr = this.f4292ADYaiT) == null || (strArr2 = aSJ6gh.f4292ADYaiT) == null || strArr.length != strArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr3 = this.f4292ADYaiT;
            if (i >= strArr3.length) {
                return true;
            }
            if (!strArr3[i].equals(aSJ6gh.f4292ADYaiT[i])) {
                return false;
            }
            i++;
        }
    }

    public final String toString() {
        String str = this.f4290A4TApA;
        if (str != null && str.length() > 0) {
            return this.f4290A4TApA;
        }
        String[] strArr = this.f4292ADYaiT;
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        if (this.f4292ADYaiT.length > 1) {
            sb.append(" ...");
        }
        return sb.toString();
    }
}
