package Mxl9NN;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements FilenameFilter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f5545A2egSU;

    public A4TApA(String str) {
        this.f5545A2egSU = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f5545A2egSU);
    }
}
