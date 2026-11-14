package C2rE4F;

import ADYaiT.BpkvW3;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final LocaleList f1542A2egSU;

    public AaHO0E(Object obj) {
        this.f1542A2egSU = BpkvW3.AMqCpz(obj);
    }

    @Override // C2rE4F.AZkASS
    public final String A2egSU() {
        String languageTags;
        languageTags = this.f1542A2egSU.toLanguageTags();
        return languageTags;
    }

    @Override // C2rE4F.AZkASS
    public final Object A4TApA() {
        return this.f1542A2egSU;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        equals = this.f1542A2egSU.equals(((AZkASS) obj).A4TApA());
        return equals;
    }

    @Override // C2rE4F.AZkASS
    public final Locale get(int i) {
        Locale locale;
        locale = this.f1542A2egSU.get(i);
        return locale;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f1542A2egSU.hashCode();
        return hashCode;
    }

    @Override // C2rE4F.AZkASS
    public final boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f1542A2egSU.isEmpty();
        return isEmpty;
    }

    @Override // C2rE4F.AZkASS
    public final int size() {
        int size;
        size = this.f1542A2egSU.size();
        return size;
    }

    public final String toString() {
        String localeList;
        localeList = this.f1542A2egSU.toString();
        return localeList;
    }
}
