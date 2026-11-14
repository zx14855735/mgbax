package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class f1 implements FilenameFilter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f14008A2egSU;

    public f1(String str) {
        this.f14008A2egSU = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f14008A2egSU);
    }
}
