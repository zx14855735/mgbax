package com.czhj.sdk.common.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.n;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class FileUtil {
    public static File[] clearCacheFileByCount(File[] fileArr, int i) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (File file : fileArr) {
            if (arrayList.size() <= i) {
                break;
            }
            if (file.exists()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static boolean deleteDirectory(String str) {
        try {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return false;
                }
                boolean z = true;
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        z = deleteFile(file2.getAbsolutePath());
                        if (!z) {
                            break;
                        }
                    } else {
                        if (file2.isDirectory() && !(z = deleteDirectory(file2.getAbsolutePath()))) {
                            break;
                        }
                    }
                }
                if (!z || !file.delete()) {
                    return false;
                }
                SigmobLog.d("删除目录 " + str + " 成功！");
                return true;
            }
            SigmobLog.d("删除目录失败：" + str + "不存在！");
            return false;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        try {
            new SecurityManager().checkDelete(str);
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                SigmobLog.d("删除单个文件失败：" + str + " 不存在！");
                return false;
            }
            if (file.delete()) {
                SigmobLog.d("删除单个文件" + str + " 成功！");
                return true;
            }
            SigmobLog.d("删除单个文件" + str + " 失败！");
            return false;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return false;
        }
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        return (str == null || str.isEmpty() || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf + 1);
    }

    public static String getRealFilePath(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !n.z.equals(scheme)) {
            if (IAdInterListener.AdProdType.PRODUCT_CONTENT.equals(scheme) && (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) != null) {
                if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
                    str = query.getString(columnIndex);
                }
                query.close();
            }
            return str;
        }
        return uri.getPath();
    }

    public static File[] orderByDate(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return listFiles;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.czhj.sdk.common.utils.FileUtil.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                long lastModified = file.lastModified() - file2.lastModified();
                if (lastModified > 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return true;
            }
        });
        return listFiles;
    }

    public static byte[] readBytes(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String readFileToString(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append("\n");
                sb.append(readLine);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static Object readFromCache(String str) {
        FileInputStream fileInputStream;
        File file;
        ObjectInputStream objectInputStream;
        Object obj = null;
        try {
            try {
                file = new File(str);
                try {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                    objectInputStream = null;
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            file = null;
            objectInputStream = null;
        }
        if (!file.exists()) {
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                obj = objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            } catch (Throwable th4) {
                th = th4;
                if (file != null) {
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th5) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th6) {
                                SigmobLog.e(th6.getMessage());
                                throw th5;
                            }
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th5;
                    }
                }
                SigmobLog.e(th.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return obj;
            }
        } catch (Throwable th7) {
            th = th7;
            objectInputStream = null;
        }
        return obj;
    }

    public static void writeToBuffer(byte[] bArr, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    SigmobLog.d("writeCache :" + file.getName());
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        SigmobLog.e(th.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                SigmobLog.e(th3.getMessage());
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            SigmobLog.e(th5.getMessage());
        }
    }

    public static boolean writeToCache(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        File file;
        File file2 = null;
        try {
            file = new File(str);
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                j += read;
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.getFD().sync();
            if (j == 0) {
                file.delete();
            }
            SigmobLog.d("writeCache :" + file.getName());
            try {
                fileOutputStream.close();
                return true;
            } catch (Throwable th3) {
                SigmobLog.e(th3.getMessage());
                return true;
            }
        } catch (Throwable th4) {
            th = th4;
            file2 = file;
            if (file2 != null) {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            SigmobLog.e(th5.getMessage());
                        }
                    }
                }
            }
            SigmobLog.e(th.getMessage());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    SigmobLog.e(th6.getMessage());
                }
            }
            return false;
        }
    }

    public static boolean writeToCache(Object obj, String str) {
        ObjectOutputStream objectOutputStream;
        File file;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(obj);
            SigmobLog.d("writeCache :" + file.getName());
            try {
                fileOutputStream.close();
                objectOutputStream.close();
                return true;
            } catch (Throwable th3) {
                SigmobLog.e(th3.getMessage());
                return true;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            try {
                SigmobLog.e(th.getMessage());
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th5) {
                        SigmobLog.e(th5.getMessage());
                        return false;
                    }
                }
                if (objectOutputStream == null) {
                    return false;
                }
                objectOutputStream.close();
                return false;
            } catch (Throwable th6) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th7) {
                        SigmobLog.e(th7.getMessage());
                        throw th6;
                    }
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th6;
            }
        }
    }
}
