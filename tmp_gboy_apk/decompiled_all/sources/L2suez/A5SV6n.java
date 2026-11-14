package L2suez;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.game.boy.activity.EmulatorActivity;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A5SV6n {
    public static String A2egSU(EmulatorActivity emulatorActivity, Uri uri) {
        Throwable th;
        Cursor cursor;
        int columnIndex;
        String string;
        Cursor cursor2 = null;
        try {
            cursor = emulatorActivity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_data")) >= 0 && (string = cursor.getString(columnIndex)) != null) {
                        if (new File(string).exists()) {
                            cursor.close();
                            return string;
                        }
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 == null) {
                        throw th;
                    }
                    cursor2.close();
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
                return null;
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return null;
    }

    public static String A4TApA(EmulatorActivity emulatorActivity, Uri uri) {
        Throwable th;
        Cursor cursor;
        int columnIndex;
        Cursor cursor2 = null;
        try {
            cursor = emulatorActivity.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_display_name")) >= 0) {
                        String string = cursor.getString(columnIndex);
                        cursor.close();
                        return string;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 == null) {
                        throw th;
                    }
                    cursor2.close();
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
                return null;
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return null;
    }

    public static String A5SV6n(EmulatorActivity emulatorActivity, Uri uri) {
        String A4TApA2;
        String A2egSU2 = A2egSU(emulatorActivity, uri);
        if (A2egSU2 != null) {
            return A2egSU2;
        }
        if (Build.VERSION.SDK_INT < 29 || (A4TApA2 = A4TApA(emulatorActivity, uri)) == null) {
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), A4TApA2);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }
}
