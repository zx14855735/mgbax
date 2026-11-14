package com.kwad.sdk.crash.report;

import ADYaiT.CtFAbx;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f extends d {
    private static void b(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    }
                    if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else {
                        if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                            threadInfo.mName = readLine;
                        }
                        if (threadInfo.mTrace != null) {
                            readLine = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = readLine;
                        threadInfo.mTrace += "#";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.f.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(File file, File file2, File file3, File file4, File file5) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.kwad.sdk.crash.model.message.ExceptionMessage a(java.io.File r8, java.io.File r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.f.a(java.io.File, java.io.File, java.lang.String):com.kwad.sdk.crash.model.message.ExceptionMessage");
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void a(File file, CountDownLatch countDownLatch) {
        String gk = com.kwad.sdk.crash.utils.g.gk(file.getPath());
        File file2 = new File(CtFAbx.AcNBzu(gk, ".msg"));
        File file3 = new File(CtFAbx.AcNBzu(gk, ".log"));
        File file4 = new File(CtFAbx.AcNBzu(gk, ".blog"));
        File file5 = new File(CtFAbx.AcNBzu(gk, ".jtrace"));
        File file6 = new File(CtFAbx.AcNBzu(gk, ".minfo"));
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage a2 = a(file, file3, gk);
            if (a2 == null) {
                try {
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", "message.mCrashSource=" + a2.mCrashSource);
            if (a2.mCrashSource == 2) {
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        w.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(a2, countDownLatch);
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", " java crash 不上传文件");
            try {
                w.delete(file.getPath());
                w.delete(file3.getPath());
                w.delete(file4.getPath());
                w.delete(file2.getPath());
                w.delete(file5.getPath());
                w.delete(file6.getPath());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    w.delete(((File) it2.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th3) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
            }
        } catch (Throwable th4) {
            try {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
                com.kwad.sdk.crash.utils.g.q(th4);
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        w.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th5) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                }
            } finally {
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        w.delete(((File) it4.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th6);
                }
            }
        }
    }
}
