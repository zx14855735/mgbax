package com.bytedance.sdk.openadsdk.core.p;

import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private int hf;
    private volatile boolean w;
    private int xj;

    public hf(int i, int i2) {
        this.xj = 15;
        this.hf = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.xj = i;
        this.hf = i2;
    }

    private void u(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long hf = hf(list);
                int size = list.size();
                boolean xj = xj(hf, size);
                if (xj) {
                    pl.xj("splashLoadAd", "不满足删除条件，不执行删除操作(true)".concat(String.valueOf(xj)));
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !xj) {
                        pl.u("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            hf -= length;
                            pl.xj("splashLoadAd", "删除 一个 Cache file 当前总个数：".concat(String.valueOf(size)));
                        } else {
                            pl.u("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (xj(file2, hf, size)) {
                            pl.xj("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.xj + " 最小个数 " + this.hf);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void w(List<File> list) {
        long hf = hf(list);
        int size = list.size();
        if (xj(hf, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                hf -= length;
                pl.xj("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                pl.xj("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (xj(file, hf, size)) {
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xj
    public boolean xj(long j, int i) {
        return i <= this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xj
    public boolean xj(File file, long j, int i) {
        return i <= this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xj
    public void xj(List<File> list) {
        if (this.w) {
            u(list);
            this.w = false;
        } else {
            w(list);
        }
    }
}
