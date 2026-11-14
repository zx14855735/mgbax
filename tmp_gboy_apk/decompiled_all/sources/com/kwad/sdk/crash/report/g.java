package com.kwad.sdk.crash.report;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.aw;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g extends d {
    public static final Pattern aVp = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aVq = Pattern.compile("\\sd+\\spc");

    static {
        LwhAI();
    }

    private NativeExceptionMessage E(File file) {
        String str;
        try {
            str = w.W(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        w.U(file);
        return nativeExceptionMessage;
    }

    private static /* synthetic */ void LwhAI() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        r0 = r5.group(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        r4.setSignal(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r0 = r5.group(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        r4.setCode(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        r0 = r5.group(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r4.setFaultAddr(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r0.equals("--------") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        r4.setManuallyKill(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r0 = r5.group(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r4.setThreadName(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        r5 = r5.group(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r5 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r4.setTid(java.lang.Integer.parseInt(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r4, java.io.File r5) {
        /*
            r3 = this;
            boolean r0 = r5.exists()
            if (r0 != 0) goto L8
            goto L9e
        L8:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.io.IOException -> L3b
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.IOException -> L3b
            r1.<init>(r5)     // Catch: java.io.IOException -> L3b
            r0.<init>(r1)     // Catch: java.io.IOException -> L3b
        L12:
            java.lang.String r5 = r0.readLine()     // Catch: java.io.IOException -> L3b
            if (r5 == 0) goto L9e
            java.lang.String r1 = "Fatal signal (\\d+) \\((\\w+)\\), code (-*\\d+) \\((\\w+)\\), fault addr (-*\\w*) in tid (\\d+) \\((.*)\\), pid (\\d+).*"
            java.util.regex.Pattern r1 = r3.gf(r1)     // Catch: java.io.IOException -> L3b
            java.util.regex.Matcher r5 = r1.matcher(r5)     // Catch: java.io.IOException -> L3b
            boolean r1 = r5.lookingAt()     // Catch: java.io.IOException -> L3b
            if (r1 == 0) goto L12
            int r1 = r5.groupCount()     // Catch: java.io.IOException -> L3b
            r2 = 8
            if (r1 < r2) goto L12
            r0 = 2
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L3d
            r4.setSignal(r0)     // Catch: java.io.IOException -> L3b
            goto L3d
        L3b:
            r4 = move-exception
            goto L7f
        L3d:
            r0 = 4
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L47
            r4.setCode(r0)     // Catch: java.io.IOException -> L3b
        L47:
            r0 = 5
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L66
            r4.setFaultAddr(r0)     // Catch: java.io.IOException -> L3b
            java.lang.String r1 = "--------"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L60
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.io.IOException -> L3b
        L5b:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L3b
            goto L63
        L60:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.io.IOException -> L3b
            goto L5b
        L63:
            r4.setManuallyKill(r0)     // Catch: java.io.IOException -> L3b
        L66:
            r0 = 7
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r0 == 0) goto L70
            r4.setThreadName(r0)     // Catch: java.io.IOException -> L3b
        L70:
            r0 = 6
            java.lang.String r5 = r5.group(r0)     // Catch: java.io.IOException -> L3b
            if (r5 == 0) goto L9e
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.io.IOException -> L3b
            r4.setTid(r5)     // Catch: java.io.IOException -> L3b
            return
        L7f:
            r4.printStackTrace()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r3.mErrorMessage
            r5.append(r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = "\n"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.mErrorMessage = r4
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File):void");
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(File file, File file2, File file3, File file4, File file5) {
        File file6 = new File(file5, "java_backtrace");
        new File(file5, "all_java_backtrace");
        File file7 = new File(file5, "maps");
        NativeExceptionMessage E = E(file2);
        try {
            a(E, file, file6, file7, false);
            if (E.mTid == 0) {
                a(E, new File(file5, aw.f9748a));
            }
            File file8 = new File(file5, ".minfo");
            if (file8.exists()) {
                E.mDumpsys = w.W(file8);
            } else {
                com.kwad.sdk.core.d.c.w("NativeCrashReporter", "memory file not exist:" + file8.getName());
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("NativeCrashReporter", Log.getStackTraceString(e));
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        TextUtils.isEmpty(this.mErrorMessage);
        return E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r17, java.io.File r18, java.io.File r19, java.io.File r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File, java.io.File, java.io.File, boolean):void");
    }

    private void a(String str, BufferedReader bufferedReader, NativeExceptionMessage nativeExceptionMessage) {
        StringBuilder sb = new StringBuilder();
        Backtrace backtrace = new Backtrace();
        StringBuilder sb2 = new StringBuilder();
        Backtrace backtrace2 = new Backtrace();
        boolean startsWith = str.startsWith("de");
        if (startsWith) {
            sb2.append(str);
            sb2.append("\n");
        } else {
            sb.append(str);
            sb.append("\n");
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || TextUtils.isEmpty(readLine)) {
                break;
            } else {
                a(readLine, startsWith ? backtrace2 : backtrace);
            }
        }
        if (startsWith) {
            nativeExceptionMessage.setGwpAsanDeallocationThread(sb2.toString());
            nativeExceptionMessage.setGwpAsanDeallocationBacktrace(backtrace2.toJson().toString());
        } else {
            nativeExceptionMessage.setGwpAsanAllocationThread(sb.toString());
            nativeExceptionMessage.setGwpAsanAllocationBacktrace(backtrace.toJson().toString());
        }
    }

    private void a(String str, Backtrace backtrace) {
        String group;
        if (backtrace.mFrame > 256) {
            return;
        }
        NativeBackTraceElement nativeBackTraceElement = new NativeBackTraceElement(str, backtrace.mFrame);
        Matcher matcher = gf(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+\\.so)(?:\\s+\\(offset\\s+\\w+\\))?(?:\\s+\\((.*?)\\+\\d+\\))?(\\s+\\(BuildId:\\s+(\\b\\w+)\\))?").matcher(str);
        Matcher matcher2 = gf(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+)\\s+\\((.*?)\\+\\d+\\)\\s+\\(BuildId:\\s+(\\b\\w+)\\)").matcher(str);
        Matcher matcher3 = gf(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*-cache.*\\(offset\\s+\\w+\\)\\s+\\((.*?)\\+\\d+\\)").matcher(str);
        if (matcher.lookingAt() && matcher.groupCount() >= 5) {
            nativeBackTraceElement.setPc(matcher.group(1));
            nativeBackTraceElement.setFileName(matcher.group(2));
            String group2 = matcher.group(3);
            if (!TextUtils.isEmpty(group2)) {
                if (gf(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*").matcher(group2).lookingAt()) {
                    nativeBackTraceElement.setNeedClustering(false);
                    return;
                }
                Matcher matcher4 = gf("[^\\[(<\\]]+").matcher(group2);
                if (matcher4.lookingAt()) {
                    Matcher matcher5 = gf(".*(\\b\\w+)").matcher(matcher4.group());
                    if (matcher5.lookingAt() && matcher.groupCount() > 0 && (group = matcher5.group(1)) != null) {
                        nativeBackTraceElement.setMethodName(group);
                    }
                }
                if (nativeBackTraceElement.getMethodName() == null) {
                    nativeBackTraceElement.setMethodName(group2);
                }
            }
            String group3 = matcher.group(5);
            if (group3 != null) {
                nativeBackTraceElement.setBuildId(group3);
            }
        } else if (matcher2.lookingAt() && matcher2.groupCount() >= 4) {
            nativeBackTraceElement.setPc(matcher2.group(1));
            nativeBackTraceElement.setFileName(matcher2.group(2));
            String group4 = matcher2.group(3);
            if (group4 != null) {
                nativeBackTraceElement.setMethodName(group4);
            }
            String group5 = matcher2.group(4);
            if (group5 != null) {
                nativeBackTraceElement.setBuildId(group5);
            }
        } else {
            if (!matcher3.lookingAt() || matcher3.groupCount() < 2) {
                return;
            }
            nativeBackTraceElement.setPc(matcher3.group(1));
            nativeBackTraceElement.setFileName("jit-code-cache");
            String group6 = matcher3.group(2);
            if (group6 != null) {
                nativeBackTraceElement.setMethodName(group6);
            }
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(nativeBackTraceElement);
    }

    private static void a(BufferedReader bufferedReader, File file) {
        boolean exists = file.exists();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.startsWith("---")) {
                return;
            }
            if (!exists) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(readLine);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }
    }

    private static void a(BufferedReader bufferedReader, ExceptionMessage exceptionMessage) {
        boolean z = false;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (!z && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                z = true;
            } else if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                if (readLine.contains("dvm_lock_sample")) {
                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                        exceptionMessage.mLockInfo = readLine.concat("\n");
                    } else {
                        exceptionMessage.mLockInfo = A2egSU.B3GDIM(new StringBuilder(), exceptionMessage.mLockInfo, readLine, "\n");
                    }
                } else if (readLine.contains("Long monitor")) {
                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                        exceptionMessage.mMonitorInfo = readLine.concat("\n");
                    } else {
                        exceptionMessage.mMonitorInfo = A2egSU.B3GDIM(new StringBuilder(), exceptionMessage.mMonitorInfo, readLine, "\n");
                    }
                } else if (readLine.contains("Slow Looper")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                        exceptionMessage.mSlowLooper = readLine.concat("\n");
                    } else {
                        exceptionMessage.mSlowLooper = A2egSU.B3GDIM(new StringBuilder(), exceptionMessage.mSlowLooper, readLine, "\n");
                    }
                } else if (readLine.contains("Slow Operation")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                        exceptionMessage.mSlowOperation = readLine.concat("\n");
                    } else {
                        exceptionMessage.mSlowOperation = A2egSU.B3GDIM(new StringBuilder(), exceptionMessage.mSlowOperation, readLine, "\n");
                    }
                }
            } else if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                exceptionMessage.mGCInfo = readLine.concat("\n");
            } else {
                exceptionMessage.mGCInfo = A2egSU.B3GDIM(new StringBuilder(), exceptionMessage.mGCInfo, readLine, "\n");
            }
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < split.length; i4++) {
                    if ("name:".equals(split[i4])) {
                        i = i4;
                    } else if (">>>".equals(split[i4])) {
                        i2 = i4;
                    } else if ("<<<".equals(split[i4])) {
                        i3 = i4;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                int i5 = i + 1;
                sb2.append(split[i5]);
                while (true) {
                    i5++;
                    if (i5 >= i2) {
                        break;
                    }
                    sb2.append(" ");
                    sb2.append(split[i5]);
                }
                nativeExceptionMessage.mThreadName = sb2.toString();
                sb2.setLength(0);
                int i6 = i2 + 1;
                sb2.append(split[i6]);
                while (true) {
                    i6++;
                    if (i6 < i3) {
                        sb2.append(" ");
                        sb2.append(split[i6]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb2.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.gl(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.gl(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb.append(str);
            sb.append('\n');
        }
    }
}
