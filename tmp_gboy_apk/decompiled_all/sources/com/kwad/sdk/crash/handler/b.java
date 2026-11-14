package com.kwad.sdk.crash.handler;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b {
    private static final int REAL_TIME_UPLOAD_THRESHOLD = 2;
    public static final String TAG = "ANR_Native_ExceptionHandler";
    public static File sBackupDir;
    protected File mDumpDir;
    protected f mExceptionListener;
    protected AtomicInteger mIndex = new AtomicInteger();
    protected File mJavaTraceFile;
    protected File mLogDir;
    protected File mLogcatFile;
    protected File mMemoryInfoFile;
    protected File mMessageFile;
    protected e mUploader;
    public static final String FILE_NAME_BASE = getBaseDir();
    public static AtomicBoolean isExceptionHappened = new AtomicBoolean(false);
    public static String sCrashingPid = "#####";

    static {
        YhgVO();
    }

    private static /* synthetic */ void YhgVO() {
        char[] charArray = "®¢ ãª¬ ¨ã¯¢´ã¾¥¨¡¡ã\u0087£¤\u008f¿¤©ª¨".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 205);
        }
        String str = new String(charArray);
        char[] charArray2 = "®¡¤£¤¹".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 205);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String getBaseDir() {
        try {
            Context context = com.kwad.sdk.crash.e.Nj().getContext();
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but getInstance().getContext() is null");
                context = z.EX();
            }
            if (context == null) {
                com.kwad.sdk.core.d.c.e(TAG, "getBaseDir() but context is null");
                return UUID.randomUUID().toString();
            }
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName) && !SystemUtil.isInMainProcess(context)) {
                if (processName != null) {
                    if (processName.startsWith(context.getPackageName() + ":")) {
                        processName = processName.substring(context.getPackageName().length() + 1);
                    }
                }
                return processName + "-" + Process.myPid() + "-" + UUID.randomUUID().toString();
            }
            processName = "main";
            return processName + "-" + Process.myPid() + "-" + UUID.randomUUID().toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.U(TAG, Log.getStackTraceString(th));
            return UUID.randomUUID().toString();
        }
    }

    public static void initBackupDir(File file) {
        sBackupDir = file;
        if (file.exists()) {
            return;
        }
        sBackupDir.mkdirs();
    }

    public void backupLogFiles(File file) {
        File file2 = sBackupDir;
        if (file2 == null) {
            return;
        }
        if (!file2.exists()) {
            sBackupDir.mkdirs();
        }
        try {
            w.g(file.getParentFile().getParentFile(), sBackupDir);
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public f getCrashListener() {
        return this.mExceptionListener;
    }

    public abstract int getCrashType();

    public final e getUploader() {
        return this.mUploader;
    }

    public void init(File file, f fVar, e eVar) {
        this.mLogDir = file;
        if (!file.exists()) {
            this.mLogDir.mkdirs();
        }
        File file2 = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        String str = FILE_NAME_BASE;
        sb.append(str);
        sb.append("-");
        sb.append(this.mIndex);
        sb.append(".dump");
        this.mDumpDir = new File(file2, sb.toString());
        File file3 = this.mLogDir;
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "-");
        A5SV6n2.append(this.mIndex);
        A5SV6n2.append(".log");
        this.mLogcatFile = new File(file3, A5SV6n2.toString());
        File file4 = this.mLogDir;
        StringBuilder A5SV6n3 = AYUAbz.A5SV6n(str, "-");
        A5SV6n3.append(this.mIndex);
        A5SV6n3.append(".jtrace");
        this.mJavaTraceFile = new File(file4, A5SV6n3.toString());
        File file5 = this.mLogDir;
        StringBuilder A5SV6n4 = AYUAbz.A5SV6n(str, "-");
        A5SV6n4.append(this.mIndex);
        A5SV6n4.append(".minfo");
        this.mMemoryInfoFile = new File(file5, A5SV6n4.toString());
        this.mExceptionListener = fVar;
        this.mUploader = eVar;
    }

    public abstract void reportException(File[] fileArr, CountDownLatch countDownLatch);

    public void uploadRemainingExceptions() {
        File[] listFiles = this.mLogDir.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.handler.b.1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file.getName().endsWith(".dump");
            }
        });
        if (listFiles == null || listFiles.length <= 2) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(listFiles.length);
        reportException(listFiles, countDownLatch);
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
