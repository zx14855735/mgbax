package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private Set<String> aTU = new HashSet();
    private Set<String> aTV = new HashSet();

    public final synchronized String[] Nl() {
        Set<String> set;
        set = this.aTV;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] Nw() {
        Set<String> set;
        set = this.aTU;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aTU.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aTV.add(str2);
                }
            }
        }
    }
}
