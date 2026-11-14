package L2suez;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ADYaiT {
    public static boolean A2egSU(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = CtFAbx.AcNBzu(str, str2);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    File file2 = new File(listFiles[i].getAbsolutePath());
                    z = (file2.exists() && file2.isFile()) ? file2.delete() : false;
                    if (!z) {
                        break;
                    }
                } else {
                    if (listFiles[i].isDirectory() && !(z = A2egSU(listFiles[i].getAbsolutePath()))) {
                        break;
                    }
                }
            }
            if (z) {
                return file.delete();
            }
        }
        return false;
    }

    public static byte[] A4TApA(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file.exists() && file.isFile()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                    try {
                        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return byteArray;
                    } catch (Exception unused3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            throw th;
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                } catch (Exception unused8) {
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Exception unused9) {
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        }
        return null;
    }

    public static boolean delete(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    if (!file.isFile()) {
                        return A2egSU(str);
                    }
                    File file2 = new File(str);
                    if (file2.exists() && file2.isFile()) {
                        return file2.delete();
                    }
                    return false;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }
}
