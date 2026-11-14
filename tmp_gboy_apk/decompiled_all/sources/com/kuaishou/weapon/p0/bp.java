package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class bp {
    public static boolean a(Context context, String str) {
        try {
            String str2 = Engine.soPath;
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("/lib");
            sb.append(str);
            return new File(sb.toString()).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static List<File> a(File file, final String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.kuaishou.weapon.p0.bp.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return file2.isDirectory() || file2.getName().toLowerCase().contains(str);
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isFile()) {
                        arrayList.add(file2);
                        return arrayList;
                    }
                    int i3 = i + 1;
                    arrayList.addAll(a(file2, str, i));
                    i2++;
                    i = i3;
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static int a(String[] strArr) {
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                if (new File(strArr[i2]).exists()) {
                    i |= 1 << i2;
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }
}
