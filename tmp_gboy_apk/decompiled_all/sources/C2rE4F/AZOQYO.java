package C2rE4F;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.archives.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements AZkASS {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Locale[] f1539A5SV6n = new Locale[0];

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Locale[] f1540A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f1541A4TApA;

    static {
        new Locale("en", "XA");
        new Locale(d.f13023a, "XB");
        String[] split = "en-Latn".split("-", -1);
        if (split.length > 2) {
            new Locale(split[0], split[1], split[2]);
        } else if (split.length > 1) {
            new Locale(split[0], split[1]);
        } else {
            if (split.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
            }
            new Locale(split[0]);
        }
    }

    public AZOQYO(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f1540A2egSU = f1539A5SV6n;
            this.f1541A4TApA = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException(CtFAbx.ASJ6gh(i, "list[", "] is null"));
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append(Soundex.SILENT_MARKER);
                    sb.append(locale2.getCountry());
                }
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f1540A2egSU = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f1541A4TApA = sb.toString();
    }

    @Override // C2rE4F.AZkASS
    public final String A2egSU() {
        return this.f1541A4TApA;
    }

    @Override // C2rE4F.AZkASS
    public final Object A4TApA() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AZOQYO)) {
            return false;
        }
        Locale[] localeArr = ((AZOQYO) obj).f1540A2egSU;
        Locale[] localeArr2 = this.f1540A2egSU;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i = 0; i < localeArr2.length; i++) {
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // C2rE4F.AZkASS
    public final Locale get(int i) {
        if (i < 0) {
            return null;
        }
        Locale[] localeArr = this.f1540A2egSU;
        if (i < localeArr.length) {
            return localeArr[i];
        }
        return null;
    }

    public final int hashCode() {
        int i = 1;
        for (Locale locale : this.f1540A2egSU) {
            i = (i * 31) + locale.hashCode();
        }
        return i;
    }

    @Override // C2rE4F.AZkASS
    public final boolean isEmpty() {
        return this.f1540A2egSU.length == 0;
    }

    @Override // C2rE4F.AZkASS
    public final int size() {
        return this.f1540A2egSU.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f1540A2egSU;
            if (i >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i]);
            if (i < localeArr.length - 1) {
                sb.append(',');
            }
            i++;
        }
    }
}
