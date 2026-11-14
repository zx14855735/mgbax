package com.bytedance.sdk.component.y.w.xj;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.y.hf, Cloneable {
    private static volatile com.bytedance.sdk.component.y.hf c;
    private int hf;
    private boolean kd;
    private boolean u;
    private int w;
    private long xj;
    private File y;

    public xj(int i, long j, File file) {
        this(i, 0, j, i != 0, j != 0, file);
    }

    private static long hf() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static void xj(Context context, com.bytedance.sdk.component.y.hf hfVar) {
        if (hfVar != null) {
            c = hfVar;
        } else {
            c = xj(new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context), "image"));
        }
    }

    @Override // com.bytedance.sdk.component.y.hf
    public File getCacheDir() {
        return this.y;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public long getFileCacheSize() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public int getMemoryCacheSize() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public int getRawMemoryCacheSize() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isDiskCache() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isMemoryCache() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isQueryAll() {
        return true;
    }

    @Override // com.bytedance.sdk.component.y.hf
    public boolean isRawMemoryCache() {
        return this.w > 0;
    }

    public xj(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.xj = j;
        this.hf = i;
        this.w = i2;
        this.u = z;
        this.kd = z2;
        this.y = file;
    }

    public static com.bytedance.sdk.component.y.hf xj(File file) {
        int min;
        long min2;
        file.mkdirs();
        if (c == null) {
            min = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            min2 = Math.min(hf() / 16, 31457280L);
        } else {
            min = Math.min(c.getMemoryCacheSize() / 2, 10485760);
            min2 = Math.min(c.getFileCacheSize() / 2, 31457280L);
        }
        return new xj(Math.max(min, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), Math.max(min2, 10485760L), file);
    }

    public static com.bytedance.sdk.component.y.hf xj() {
        return c;
    }
}
