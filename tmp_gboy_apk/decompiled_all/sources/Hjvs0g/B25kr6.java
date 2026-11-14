package Hjvs0g;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements AlLFFp {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Map f3731A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile Map f3732A5SV6n;

    public B25kr6(Map map) {
        this.f3731A4TApA = Collections.unmodifiableMap(map);
    }

    public final HashMap A2egSU() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f3731A4TApA.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = ((AzWtSf) list.get(i)).f3730A2egSU;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public final Map A4TApA() {
        if (this.f3732A5SV6n == null) {
            synchronized (this) {
                try {
                    if (this.f3732A5SV6n == null) {
                        this.f3732A5SV6n = Collections.unmodifiableMap(A2egSU());
                    }
                } finally {
                }
            }
        }
        return this.f3732A5SV6n;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof B25kr6) {
            return this.f3731A4TApA.equals(((B25kr6) obj).f3731A4TApA);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3731A4TApA.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f3731A4TApA + '}';
    }
}
