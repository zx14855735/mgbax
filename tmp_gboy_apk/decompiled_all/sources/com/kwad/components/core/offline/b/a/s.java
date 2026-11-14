package com.kwad.components.core.offline.b.a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.ce;
import java.io.File;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class s implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return ce.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return ce.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        ce.zipFile(file);
    }
}
