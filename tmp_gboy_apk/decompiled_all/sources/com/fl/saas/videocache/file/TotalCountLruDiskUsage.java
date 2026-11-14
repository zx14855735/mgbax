package com.fl.saas.videocache.file;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i;
    }

    @Override // com.fl.saas.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        return i <= this.maxCount;
    }
}
