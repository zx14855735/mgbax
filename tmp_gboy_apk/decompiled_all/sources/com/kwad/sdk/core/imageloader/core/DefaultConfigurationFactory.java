package com.kwad.sdk.core.imageloader.core;

import B4ZgIw.AYUAbz;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.UnlimitedDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.LruDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.SimpleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DefaultConfigurationFactory {

    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        static {
            UMBhq();
        }

        public DefaultThreadFactory(int i, String str) {
            this.threadPriority = i;
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
            A4TApA2.append(poolNumber.getAndIncrement());
            A4TApA2.append("-thread-");
            this.namePrefix = A4TApA2.toString();
        }

        private static /* synthetic */ void UMBhq() {
            char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'n');
            }
            String str = new String(charArray);
            char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'n');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j, int i, String str) {
        FileNameGenerator fileNameGenerator2;
        File createReserveDiskCacheDir = createReserveDiskCacheDir(context, str);
        if (j > 0 || i > 0) {
            try {
                fileNameGenerator2 = fileNameGenerator;
            } catch (IOException e) {
                e = e;
                fileNameGenerator2 = fileNameGenerator;
            }
            try {
                return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context, str), createReserveDiskCacheDir, fileNameGenerator2, j, i);
            } catch (IOException e2) {
                e = e2;
                L.e(e);
                return new UnlimitedDiskCache(new File(str), createReserveDiskCacheDir, fileNameGenerator2);
            }
        }
        fileNameGenerator2 = fileNameGenerator;
        return new UnlimitedDiskCache(new File(str), createReserveDiskCacheDir, fileNameGenerator2);
    }

    public static Executor createExecutor(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), createThreadFactory(i2, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean z) {
        return new BaseImageDecoder(z);
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(Context context, int i) {
        if (i <= 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            int memoryClass = activityManager.getMemoryClass();
            if (hasHoneycomb() && isLargeHeap(context)) {
                memoryClass = getLargeMemoryClass(activityManager);
            }
            i = (memoryClass * 1048576) / 8;
        }
        return new LruMemoryCache(i);
    }

    private static File createReserveDiskCacheDir(Context context, String str) {
        File file = new File(str);
        File file2 = new File(file, StorageUtils.INDIVIDUAL_DIR_NAME);
        return (file2.exists() || file2.mkdir()) ? file2 : file;
    }

    public static Executor createTaskDistributor() {
        return Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
    }

    private static ThreadFactory createThreadFactory(int i, String str) {
        return new DefaultThreadFactory(i, str);
    }

    @TargetApi(11)
    private static int getLargeMemoryClass(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    private static boolean hasHoneycomb() {
        return true;
    }

    @TargetApi(11)
    private static boolean isLargeHeap(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }
}
