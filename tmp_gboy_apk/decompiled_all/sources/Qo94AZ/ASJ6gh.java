package Qo94AZ;

import java.io.File;
import java.io.FileOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ASJ6gh implements AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final File f7777A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final FileOutputStream f7778A4TApA;

    public ASJ6gh(File file) {
        File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
        this.f7777A2egSU = createTempFile;
        this.f7778A4TApA = new FileOutputStream(createTempFile);
    }

    @Override // Qo94AZ.AzWtSf
    public void delete() {
        B25kr6.ADYaiT(this.f7778A4TApA);
        File file = this.f7777A2egSU;
        if (file.delete()) {
            return;
        }
        throw new Exception("could not delete temporary file: " + file.getAbsolutePath());
    }
}
