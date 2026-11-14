package com.bytedance.sdk.openadsdk.am;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.sdk.component.utils.pl;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static int c = 1;
    public static int d = 4;
    public static int f = 2;
    protected static String hf = null;
    protected static long kd = 15360;
    public static int p = 16;

    /* renamed from: pl, reason: collision with root package name */
    public static int f10271pl = 32;
    public static int tf = 8;
    protected static int u = 30;
    protected static int w = 1;
    protected static String xj = "images";
    public static int y;

    public static Bitmap hf(String str) {
        byte[] decode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static boolean xj(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), f.a.c).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean hf(Context context, String str) {
        int checkSelfPermission;
        checkSelfPermission = context.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    public static File xj() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + xj);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            hf = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File xj(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File xj(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File xj2 = xj(str);
            if (xj2 != null && xj2.exists()) {
                byte[] decode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(xj2);
                try {
                    fileOutputStream.write(decode, 0, decode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                        return xj2;
                    } catch (IOException e) {
                        pl.xj(e);
                        return xj2;
                    }
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            pl.xj(e2);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            pl.xj(e3);
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean xj(Context context, int i) {
        boolean xj2;
        boolean xj3;
        if (y == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                xj2 = xj(context, "android.permission.READ_MEDIA_IMAGES");
                xj3 = true;
            } else {
                xj2 = xj(context, g.i);
                xj3 = xj(context, g.j);
            }
            boolean xj4 = xj(context, "android.permission.CAMERA");
            boolean xj5 = xj(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (xj2 && xj3) {
                y |= c;
            }
            if (xj4 && packageManager.hasSystemFeature("android.hardware.camera")) {
                y |= f;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                y |= d;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                y |= tf;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                y |= p;
            }
            if (xj5 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                y |= f10271pl;
            }
        }
        return (y & i) != 0;
    }

    public static boolean xj(Context context) {
        int checkSelfPermission;
        boolean z;
        int checkSelfPermission2;
        boolean z2;
        int checkSelfPermission3;
        if (Build.VERSION.SDK_INT >= 33) {
            checkSelfPermission3 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES");
            z = checkSelfPermission3 == 0;
        } else {
            checkSelfPermission = context.checkSelfPermission(g.i);
            z = checkSelfPermission == 0;
            checkSelfPermission2 = context.checkSelfPermission(g.j);
            if (checkSelfPermission2 != 0) {
                z2 = false;
                return !z2 && z;
            }
        }
        z2 = true;
        if (z2) {
        }
    }
}
