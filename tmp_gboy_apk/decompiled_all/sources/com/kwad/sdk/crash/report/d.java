package com.kwad.sdk.crash.report;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class d {
    protected e mUploader;
    protected String mErrorMessage = "";
    private final ConcurrentHashMap<String, Pattern> aVm = new ConcurrentHashMap<>();

    @SuppressLint({"CheckResult"})
    private static void b(File file, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    public static String gg(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    @SuppressLint({"CheckResult"})
    public void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException file =" + file2.getName());
                return file2.isDirectory();
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    public abstract ExceptionMessage a(File file, File file2, File file3, File file4, File file5);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final Pattern gf(String str) {
        if (!this.aVm.containsKey(str)) {
            if (str.equals(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)") || str.equals(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*")) {
                this.aVm.put(str, Pattern.compile(str, 66));
            } else {
                this.aVm.put(str, Pattern.compile(str));
            }
        }
        return this.aVm.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0309 A[Catch: all -> 0x0317, LOOP:4: B:81:0x0303->B:83:0x0309, LOOP_END, TryCatch #4 {all -> 0x0317, blocks: (B:80:0x02dc, B:81:0x0303, B:83:0x0309, B:85:0x0319), top: B:79:0x02dc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.io.File r20, java.util.concurrent.CountDownLatch r21) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.d.a(java.io.File, java.util.concurrent.CountDownLatch):void");
    }

    public final void a(ExceptionMessage exceptionMessage, List<File> list, CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "compressAndUpload");
        File Nf = this.mUploader.Nf();
        if (!Nf.exists()) {
            Nf.mkdir();
        }
        File file = new File(Nf, CtFAbx.B25kr6(new StringBuilder(), exceptionMessage.mLogUUID, ".zip"));
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "compressAndUpload zipFile=" + file.getPath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        q.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("mLogUUID", exceptionMessage.mLogUUID);
            new JSONObject(hashMap);
            b(file, countDownLatch);
            return;
        }
        w.U(file);
    }

    public final void a(String str, Backtrace backtrace, boolean z) {
        if (backtrace.getFrame() > 256) {
            return;
        }
        JavaBackTraceElement javaBackTraceElement = new JavaBackTraceElement(str, backtrace.getFrame());
        Matcher matcher = gf(".*at\\s+(.*)\\.(.*)\\(((.*):(-?\\d+)|Native method)\\)").matcher(str);
        if (matcher.lookingAt()) {
            javaBackTraceElement.setDeclaringClass(matcher.group(1));
            javaBackTraceElement.setMethodName(matcher.group(2));
            if (matcher.groupCount() >= 5) {
                String group = matcher.group(4);
                if (group != null) {
                    javaBackTraceElement.setFileName(group);
                } else {
                    javaBackTraceElement.setIsNative(true);
                }
                String group2 = matcher.group(5);
                if (group2 != null) {
                    try {
                        javaBackTraceElement.setLineNumber(Long.parseLong(group2));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            backtrace.getFrame();
            if (str.startsWith("Caused by: ")) {
                javaBackTraceElement.setIsCausedBy(true);
            }
        }
        if (javaBackTraceElement.isTitle() || javaBackTraceElement.isCausedBy() || javaBackTraceElement.isNative()) {
            javaBackTraceElement.setNeedClustering(false);
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(javaBackTraceElement);
    }

    public final void a(File file, ExceptionMessage exceptionMessage) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        String str2;
        String str3;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (!z && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                                z = true;
                            } else {
                                if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                    if (readLine.contains("dvm_lock_sample")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                            sb2 = new StringBuilder();
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(exceptionMessage.mLockInfo);
                                            sb2.append(readLine);
                                            sb2.append("\n");
                                        }
                                        exceptionMessage.mLockInfo = sb2.toString();
                                    } else if (readLine.contains("Long monitor")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                            str = readLine + "\n";
                                        } else {
                                            str = exceptionMessage.mMonitorInfo + readLine + "\n";
                                        }
                                        exceptionMessage.mMonitorInfo = str;
                                    } else if (readLine.contains("Slow Looper")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                            str2 = readLine + "\n";
                                        } else {
                                            str2 = exceptionMessage.mSlowLooper + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowLooper = str2;
                                    } else if (readLine.contains("Slow Operation")) {
                                        if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                            str3 = readLine + "\n";
                                        } else {
                                            str3 = exceptionMessage.mSlowOperation + readLine + "\n";
                                        }
                                        exceptionMessage.mSlowOperation = str3;
                                    }
                                }
                                if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                    sb = new StringBuilder();
                                    sb.append(readLine);
                                    sb.append("\n");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(exceptionMessage.mGCInfo);
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                exceptionMessage.mGCInfo = sb.toString();
                            }
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }
}
