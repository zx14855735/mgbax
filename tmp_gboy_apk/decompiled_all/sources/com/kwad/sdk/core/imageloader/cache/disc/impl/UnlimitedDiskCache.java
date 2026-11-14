package com.kwad.sdk.core.imageloader.cache.disc.impl;

import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UnlimitedDiskCache extends BaseDiskCache {
    public UnlimitedDiskCache(File file) {
        super(file);
    }

    public UnlimitedDiskCache(File file, File file2) {
        super(file, file2);
    }

    public UnlimitedDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        super(file, file2, fileNameGenerator);
    }
}
