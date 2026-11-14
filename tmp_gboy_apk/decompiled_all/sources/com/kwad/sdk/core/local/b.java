package com.kwad.sdk.core.local;

import ADYaiT.CtFAbx;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.au;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static LocalWriteResult a(Context context, String str, byte[] bArr, String str2) {
        return Build.VERSION.SDK_INT >= 29 ? b(context, str, bArr, str2) : a(context, bArr, CtFAbx.AlLFFp(str2, ".", MimeTypeMap.getSingleton().getExtensionFromMimeType(str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.ContentResolver] */
    private static LocalWriteResult b(Context context, String str, byte[] bArr, String str2) {
        OutputStream outputStream;
        LocalWriteResult localWriteResult = LocalWriteResult.FAIL;
        ?? r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        ?? contentResolver = context.getContentResolver();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        Uri insert = contentResolver.insert(r1, contentValues);
        if (insert == null) {
            return localWriteResult;
        }
        Closeable closeable = null;
        try {
            try {
                outputStream = contentResolver.openOutputStream(insert);
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                    r1 = outputStream;
                } catch (Exception e) {
                    e = e;
                    c.printStackTraceOnly(e);
                    r1 = outputStream;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r1);
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    contentResolver.update(insert, contentValues, null, null);
                    return LocalWriteResult.SUCCESS;
                }
            } catch (Throwable th) {
                th = th;
                closeable = r1;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r1);
        contentValues.clear();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(insert, contentValues, null, null);
        return LocalWriteResult.SUCCESS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    private static LocalWriteResult a(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        if (au.aw(context, g.j) == 0) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (String) str));
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        LocalWriteResult localWriteResult = LocalWriteResult.SUCCESS;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        return localWriteResult;
                    } catch (Exception e2) {
                        e = e2;
                        LocalWriteResult localWriteResult2 = LocalWriteResult.FAIL;
                        c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        return localWriteResult2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                    throw th;
                }
            } catch (Exception e3) {
                fileOutputStream = null;
                e = e3;
            } catch (Throwable th3) {
                str = 0;
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
        } else {
            return LocalWriteResult.PERMISSION_DENIED;
        }
    }
}
