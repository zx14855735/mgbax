package com.czhj.volley;

import ADYaiT.CtFAbx;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Header {

    /* renamed from: a, reason: collision with root package name */
    private final String f10626a;
    private final String b;

    public Header(String str, String str2) {
        this.f10626a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Header.class == obj.getClass()) {
            Header header = (Header) obj;
            if (TextUtils.equals(this.f10626a, header.f10626a) && TextUtils.equals(this.b, header.b)) {
                return true;
            }
        }
        return false;
    }

    public final String getName() {
        return this.f10626a;
    }

    public final String getValue() {
        return this.b;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f10626a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.f10626a);
        sb.append(",value=");
        return CtFAbx.B25kr6(sb, this.b, "]");
    }
}
