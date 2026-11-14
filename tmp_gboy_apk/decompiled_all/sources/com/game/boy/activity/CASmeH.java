package com.game.boy.activity;

import android.net.Uri;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CASmeH implements FilenameFilter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f10942A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Pattern f10943A4TApA = Pattern.compile("(landscape|portrait)(-kbopen)?\\.xml");

    public CASmeH(String str) {
        this.f10942A2egSU = Uri.encode(str) + "-";
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        String str2 = this.f10942A2egSU;
        if (str.startsWith(str2)) {
            return this.f10943A4TApA.matcher(str.substring(str2.length())).matches();
        }
        return false;
    }
}
