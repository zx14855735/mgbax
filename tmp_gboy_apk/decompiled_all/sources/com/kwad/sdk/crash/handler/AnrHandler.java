package com.kwad.sdk.crash.handler;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import android.util.Printer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.fp(21);

    public static class a {
        private static final AnrHandler aTZ = new AnrHandler();

        static {
            brjFpRV();
        }

        private static /* synthetic */ void brjFpRV() {
            char[] charArray = "ÈÄÆ\u0085ÌÊÆÎ\u0085ÉÄÒ\u0085ØÃÎÇÇ\u0085áÅÂéÙÂÏÌÎ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 171);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÈÇÂÅÂß".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 171);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        qaxbcF();
    }

    private static boolean checkErrorState() {
        try {
            com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] start");
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) com.kwad.sdk.core.c.b.Ji().getApplication().getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] procs == null");
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "maybe received other apps ANR signal");
                    return false;
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "error sate longMsg = " + processErrorStateInfo.longMsg);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "[checkErrorState] error : " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dumpAnr(String str, int i) {
        boolean z;
        com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i);
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        File file = new File(this.mDumpDir.toString() + "-" + i);
        File file2 = getInstance().mLogDir;
        try {
            if (file2.exists() || file2.mkdirs()) {
                z = true;
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file2.getPath() + " failed!\n";
                z = false;
            }
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + this.mDumpDir.getPath() + " failed!\n";
                z = false;
            }
            g.b(null, anrExceptionMessage, e.Nj().getContext());
            g.a(anrExceptionMessage, 3);
            File file3 = new File(file, com.sigmob.sdk.archives.d.c);
            if (str != null && z) {
                w.f(new File(str), file3);
            }
            g.F(new File(file, "logcat"));
            try {
                final StringBuilder sb = new StringBuilder();
                Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.6
                    @Override // android.util.Printer
                    public final void println(String str2) {
                        StringBuilder sb2 = sb;
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                }, "");
                anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            } catch (Exception e) {
                anrExceptionMessage.mErrorMessage += Log.getStackTraceString(e) + "\n";
            }
            try {
                anrExceptionMessage.mLogUUID = g.gk(file3.getName());
                g.a(new File(file, "message"), anrExceptionMessage.toJson().toString());
                getInstance().backupLogFiles(file2);
                com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
                if (uploader != null) {
                    anrExceptionMessage.toString();
                }
                g.a(uploader, TAG, file3);
                g.I(new File(file, "meminfo"));
            } catch (Throwable unused) {
            }
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
            getInstance().uploadRemainingExceptions();
            notifyJavaDumpDone();
            getAnrReason(str, file);
        } catch (Throwable th) {
            anrExceptionMessage.mErrorMessage += th;
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private static void getAnrReason(String str, File file) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        com.kwad.sdk.core.d.c.d(TAG, "ANR getAnrReasonInner");
        getInstance().getUploader();
        if (str != null) {
            try {
                long lastModified = new File(str).lastModified();
                if (Math.abs(lastModified - sLastTime) < 10000) {
                    return;
                } else {
                    sLastTime = lastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.Nj().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return;
        }
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        boolean z = false;
        for (int i = 0; i < TRY_TIMES; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (Build.VERSION.SDK_INT > 33 && !z && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().pid == Process.myPid()) {
                            break;
                        }
                    } else {
                        com.kwad.sdk.core.d.c.i(TAG, "anr did happen on android14");
                        g.a(new File(file, "anr_happened"), (CharSequence) "anr did happen", false);
                        z = true;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(GET_REASON_INTERVAL);
        }
        if (processErrorStateInfo != null && processErrorStateInfo.pid == MY_PID) {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            File file2 = new File(file, "anr_reason");
            com.kwad.sdk.core.d.c.i(TAG, "anr reason: " + anrReason.toJson().toString());
            g.a(file2, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return a.aTZ;
    }

    @A2egSU
    public static synchronized String getMainThreadStackTrace() {
        String sb;
        synchronized (AnrHandler.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                    sb2.append("  at ");
                    sb2.append(stackTraceElement);
                    sb2.append("\n");
                }
                sb2.append("\n");
                sb = sb2.toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
                return "";
            }
        }
        return sb;
    }

    public static native boolean getStackTraceCrashOccured();

    public static native void install(String str, int i);

    @A2egSU
    public static boolean isRealNotResponding(final int i) {
        com.kwad.sdk.core.d.c.d(TAG, "judge isRealNotResponding");
        try {
            b.isExceptionHappened.set(true);
            b.sCrashingPid = String.valueOf(Process.myPid());
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.5
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, i);
                }
            });
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static native void notifyJavaDumpDone();

    @A2egSU
    public static void onCallFromNative(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            h.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.4
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, AnrHandler.this.mIndex.getAndIncrement());
                }
            });
        }
    }

    private boolean parseTraceFile(String str) {
        int i;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            i = -1;
                            break;
                        }
                        if (PID_PATTERN.matcher(readLine).matches()) {
                            i = Integer.parseInt(readLine.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z = i == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        }
    }

    private static /* synthetic */ void qaxbcF() {
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

    private void watchTraceFile() {
        com.kwad.sdk.core.d.c.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT.concat(str));
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        MessageQueue queue;
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.MU()) {
            com.kwad.sdk.core.d.c.d(TAG, "ANR init ");
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = this.mLogDir;
            StringBuilder sb = new StringBuilder();
            String str = b.FILE_NAME_BASE;
            this.mDumpDir = new File(file2, CtFAbx.B25kr6(sb, str, "-anr"));
            new File(this.mLogDir, str);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in main:");
                            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                        }
                    });
                } else {
                    queue = Looper.getMainLooper().getQueue();
                    queue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in Idle");
                            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                            return false;
                        }
                    });
                }
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }

    private AnrHandler() {
    }
}
