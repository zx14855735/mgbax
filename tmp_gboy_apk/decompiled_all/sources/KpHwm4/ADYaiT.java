package KpHwm4;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.game.boy.Logs;
import com.octopus.ad.internal.q;
import com.octopus.ad.utils.b.f;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Thread.UncaughtExceptionHandler {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static ADYaiT f4280ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4281A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f4282A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f4283A5SV6n;

    public /* synthetic */ ADYaiT() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: Exception -> 0x0033, TRY_ENTER, TryCatch #9 {Exception -> 0x0033, blocks: (B:15:0x0029, B:23:0x0056, B:25:0x005b, B:27:0x0060), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b A[Catch: Exception -> 0x0033, TryCatch #9 {Exception -> 0x0033, blocks: (B:15:0x0029, B:23:0x0056, B:25:0x005b, B:27:0x0060), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060 A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #9 {Exception -> 0x0033, blocks: (B:15:0x0029, B:23:0x0056, B:25:0x005b, B:27:0x0060), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072 A[Catch: Exception -> 0x006e, TryCatch #1 {Exception -> 0x006e, blocks: (B:45:0x006a, B:36:0x0072, B:38:0x0077), top: B:44:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077 A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #1 {Exception -> 0x006e, blocks: (B:45:0x006a, B:36:0x0072, B:38:0x0077), top: B:44:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A2egSU(java.io.File r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4d
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L44
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L44
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
        L15:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            if (r1 == 0) goto L29
            r0.append(r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            java.lang.String r1 = "\r\n"
            r0.append(r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            goto L15
        L24:
            r0 = move-exception
        L25:
            r1 = r2
            goto L68
        L27:
            r1 = move-exception
            goto L51
        L29:
            r2.close()     // Catch: java.lang.Exception -> L33
            r5.close()     // Catch: java.lang.Exception -> L33
            r3.close()     // Catch: java.lang.Exception -> L33
            goto L63
        L33:
            r5 = move-exception
            r5.getMessage()
            goto L63
        L38:
            r0 = move-exception
            r3 = r1
            goto L25
        L3b:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L51
        L40:
            r0 = move-exception
            r5 = r1
            r3 = r5
            goto L25
        L44:
            r5 = move-exception
            r3 = r1
        L46:
            r1 = r5
            r5 = r3
            goto L51
        L49:
            r0 = move-exception
            r5 = r1
            r3 = r5
            goto L68
        L4d:
            r5 = move-exception
            r2 = r1
            r3 = r2
            goto L46
        L51:
            r1.getMessage()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.lang.Exception -> L33
        L59:
            if (r5 == 0) goto L5e
            r5.close()     // Catch: java.lang.Exception -> L33
        L5e:
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.lang.Exception -> L33
        L63:
            java.lang.String r5 = r0.toString()
            return r5
        L68:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.lang.Exception -> L6e
            goto L70
        L6e:
            r5 = move-exception
            goto L7b
        L70:
            if (r5 == 0) goto L75
            r5.close()     // Catch: java.lang.Exception -> L6e
        L75:
            if (r3 == 0) goto L7e
            r3.close()     // Catch: java.lang.Exception -> L6e
            goto L7e
        L7b:
            r5.getMessage()
        L7e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: KpHwm4.ADYaiT.A2egSU(java.io.File):java.lang.String");
    }

    public void A4TApA() {
        try {
            if (((Context) this.f4283A5SV6n) == null) {
                this.f4283A5SV6n = q.a().j();
            }
            File filesDir = ((Context) this.f4283A5SV6n).getFilesDir();
            if (filesDir != null) {
                File[] listFiles = new File(filesDir.getPath() + "/octopus-crash/").listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.exists()) {
                            String A2egSU2 = A2egSU(file);
                            if (!TextUtils.isEmpty(A2egSU2)) {
                                new Thread(new QEisCN.A2egSU(this, A2egSU2, true)).start();
                            }
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        switch (this.f4281A2egSU) {
            case 0:
                try {
                    Logs.handleCrash((Application) this.f4282A4TApA, (String) this.f4283A5SV6n, th);
                    break;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Logs.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                        return;
                    }
                    return;
                }
            default:
                if (th != null) {
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        String obj = stringWriter.toString();
                        if (!TextUtils.isEmpty(obj)) {
                            new Thread(new QEisCN.A2egSU(this, obj, false)).start();
                        }
                    } catch (Exception e) {
                        f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
                Thread.sleep(1000L);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = (Thread.UncaughtExceptionHandler) this.f4282A4TApA;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                    break;
                } else {
                    Process.killProcess(Process.myPid());
                    break;
                }
        }
    }

    public ADYaiT(Application application, String str) {
        this.f4282A4TApA = application;
        this.f4283A5SV6n = str;
    }
}
