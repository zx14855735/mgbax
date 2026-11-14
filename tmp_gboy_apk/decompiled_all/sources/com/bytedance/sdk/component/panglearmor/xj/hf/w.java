package com.bytedance.sdk.component.panglearmor.xj.hf;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w {
    public static hf xj(RandomAccessFile randomAccessFile, long j, long j2) {
        return xj(randomAccessFile.getChannel(), j, j2);
    }

    public static hf xj(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new u(fileChannel, j, j2);
    }
}
