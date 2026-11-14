package com.bytedance.sdk.component.w.hf.xj.y;

import com.bytedance.sdk.component.w.xj.pl;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.yo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface xj {
    public static final xj xj = new xj() { // from class: com.bytedance.sdk.component.w.hf.xj.y.xj.1
        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public void delete(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public yo hf(File file) {
            try {
                return pl.hf(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return pl.hf(file);
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public long kd(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public boolean u(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public yo w(File file) {
            try {
                return pl.w(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return pl.w(file);
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public v xj(File file) {
            return pl.xj(file);
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public void y(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    y(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.y.xj
        public void xj(File file, File file2) {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    static {
        HDLz();
    }

    private static /* synthetic */ void HDLz() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    void delete(File file);

    yo hf(File file);

    long kd(File file);

    boolean u(File file);

    yo w(File file);

    v xj(File file);

    void xj(File file, File file2);

    void y(File file);
}
