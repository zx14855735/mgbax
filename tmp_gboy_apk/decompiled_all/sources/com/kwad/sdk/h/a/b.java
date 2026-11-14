package com.kwad.sdk.h.a;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bp;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public String aWm;
    public String aWn;
    public String aWo;
    public long aWp;
    public boolean aWq;
    public String avr;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Ok() {
        return this.aWp;
    }

    public final void aQ(long j) {
        this.aWp = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (bp.isEquals(this.aWm, bVar.aWm) && bp.isEquals(this.avr, bVar.avr) && bp.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.aWm);
        sb.append("_");
        sb.append(this.avr);
        sb.append("_");
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.aWm) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.aWn)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "PackageInfoBean{packageId='" + this.aWm + "', zipFileName='" + this.aWn + "', zipPath='" + this.aWo + "', startDownloadTime=" + this.aWp + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.avr + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.aWq + '}';
    }
}
