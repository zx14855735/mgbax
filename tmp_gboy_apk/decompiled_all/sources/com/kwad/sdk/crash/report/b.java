package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b extends d {
    private String B(File file) {
        File file2 = new File(file, "anr_reason");
        String str = "";
        if (file2.exists()) {
            try {
                str = w.W(file2);
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
            w.U(file2);
        }
        return str;
    }

    private AnrExceptionMessage C(File file) {
        String str;
        try {
            str = w.W(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        w.U(file);
        return anrExceptionMessage;
    }

    private static boolean ge(String str) {
        for (String str2 : com.kwad.sdk.crash.e.Nj().Nk()) {
            if (str.contains(str2)) {
                A2egSU.B7CMnp(" tag=", str2, "AnrReporter");
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(File file, File file2, File file3, File file4, File file5) {
        com.kwad.sdk.core.d.c.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + file5.getPath());
        AnrExceptionMessage C = C(file2);
        try {
            C.mReason = B(file5);
            a(C, file);
            a(file4, C);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) C.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            C.toString();
            File file6 = new File(file5, "meminfo");
            if (file6.exists()) {
                C.mDumpsys = w.W(file6);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("AnrReporter", Log.getStackTraceString(e));
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            C.mErrorMessage += this.mErrorMessage;
        }
        return C;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }
}
