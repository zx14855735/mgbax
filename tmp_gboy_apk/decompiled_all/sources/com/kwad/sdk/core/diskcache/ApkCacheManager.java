package com.kwad.sdk.core.diskcache;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ApkCacheManager {
    private File aHk;
    private final ExecutorService aHl;
    private final Callable<Void> aHm;
    private Future auP;

    public enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager(0);

        static {
            uTTSj();
        }

        Holder() {
        }

        private static /* synthetic */ void uTTSj() {
            char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 170);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 170);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ix() {
        File file = this.aHk;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.aHk.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && l(this.aHk) <= 400;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            for (File file2 : file.listFiles()) {
                h(file2);
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    private int l(File file) {
        return (int) ((m(file) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                j = listFiles[i].isDirectory() ? j + m(listFiles[i]) : listFiles[i].length() + j;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        z(arrayList);
        return arrayList;
    }

    private void z(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }
        });
    }

    public final void Iy() {
        File file = this.aHk;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.auP;
        if (future == null || future.isDone()) {
            this.auP = this.aHl.submit(this.aHm);
        }
    }

    private ApkCacheManager() {
        this.aHl = GlobalThreadPools.Lq();
        this.aHm = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Iz, reason: merged with bridge method [inline-methods] */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    try {
                        try {
                        } finally {
                        }
                    } catch (Throwable unused) {
                    }
                    if (ApkCacheManager.this.aHk != null && ApkCacheManager.this.aHk.exists() && !ApkCacheManager.this.Ix()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.n(apkCacheManager.aHk)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.Ix()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.aHk = be.dR(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }
}
