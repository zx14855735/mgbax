package com.bytedance.sdk.openadsdk.x;

import com.bytedance.sdk.component.utils.pl;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static void hf(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                xj(file2);
            }
        }
    }

    public static void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                pl.hf("FileUtils", e);
            }
        }
    }

    public static File xj(File file, String str) {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                xj(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e) {
                            e = e;
                            zipOutputStream = zipOutputStream2;
                            pl.hf("FileUtils", e);
                            xj(zipOutputStream);
                            return file2;
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            xj(zipOutputStream);
                            throw th;
                        }
                    }
                    xj(zipOutputStream);
                    return file2;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                file2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void xj(String str, File file) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            bufferedWriter.write(str);
            xj(bufferedWriter);
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            pl.hf("FileUtils", e);
            xj(bufferedWriter2);
        } catch (IOException e4) {
            e = e4;
            bufferedWriter2 = bufferedWriter;
            pl.hf("FileUtils", e);
            xj(bufferedWriter2);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            xj(bufferedWriter2);
            throw th;
        }
    }

    public static void xj(OutputStream outputStream, File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    xj(fileInputStream);
                    return;
                }
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            pl.hf("FileUtils", e);
            xj(fileInputStream2);
        } catch (IOException e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            pl.hf("FileUtils", e);
            xj(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            xj(fileInputStream2);
            throw th;
        }
    }

    public static void xj(File file) {
        if (file.isDirectory()) {
            hf(file);
        } else {
            file.delete();
        }
    }
}
