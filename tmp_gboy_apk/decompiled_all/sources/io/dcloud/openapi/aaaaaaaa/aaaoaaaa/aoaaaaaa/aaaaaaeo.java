package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import ADYaiT.CtFAbx;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaeo {
    public static boolean aaaaaaa0(Object obj) {
        if (!(obj instanceof String)) {
            if (obj instanceof File) {
                return ((File) obj).exists();
            }
            return false;
        }
        String str = (String) obj;
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return new File(str).exists();
    }

    public static boolean aaaaaaaa(Object obj) {
        boolean delete;
        if (obj == null) {
            return false;
        }
        try {
            File aaaaaaao = aaaaaaao(obj);
            if (!aaaaaaao.exists()) {
                return false;
            }
            if (aaaaaaao.isFile()) {
                return aaaaaaao.delete();
            }
            File[] listFiles = aaaaaaao.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i = 0; i < listFiles.length; i++) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaaa("delete:" + listFiles[i].getPath());
                    if (listFiles[i].isDirectory()) {
                        delete = aaaaaaaa((Object) (aaaaaaao.getPath() + "/" + listFiles[i].getName()));
                    } else {
                        delete = listFiles[i].delete();
                        Thread.sleep(2L);
                    }
                    if (!delete) {
                        return false;
                    }
                }
            }
            boolean delete2 = aaaaaaao.delete();
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaaa("delete " + obj + ":" + String.valueOf(delete2));
            return delete2;
        } catch (Exception e) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaac("DHFile.delete" + e);
            return false;
        }
    }

    public static InputStream aaaaaaac(Object obj) {
        File file;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.startsWith("file://")) {
                str = str.substring(7);
            }
            file = new File(str);
        } else {
            file = obj instanceof File ? (File) obj : null;
        }
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaa0("uniAD", "DHFile getInputStream not found file: " + file.getPath());
            return null;
        } catch (SecurityException e) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaac("getInputStream2" + e);
            return null;
        }
    }

    private static File aaaaaaao(Object obj) {
        if (!(obj instanceof String)) {
            if (obj instanceof File) {
                return (File) obj;
            }
            return null;
        }
        String str = (String) obj;
        if (str.endsWith("/")) {
            str = CtFAbx.AMqCpz(1, 0, str);
        }
        return new File(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if (r4 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
    
        if (r4 != null) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] aaaaaaau(java.lang.Object r4) {
        /*
            java.lang.String r0 = "readAll 0:"
            java.lang.String r1 = "readAll 1:"
            java.lang.String r2 = "readAll 2:"
            r3 = 0
            java.io.InputStream r4 = aaaaaaac(r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28 java.lang.SecurityException -> L3c java.io.FileNotFoundException -> L50
            if (r4 == 0) goto L23
            byte[] r0 = aaaaaaaa(r4)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d java.lang.SecurityException -> L1f java.io.FileNotFoundException -> L21
            r4.close()     // Catch: java.io.IOException -> L15
            return r0
        L15:
            r4 = move-exception
            r4.printStackTrace()
            return r0
        L1a:
            r0 = move-exception
            r3 = r4
            goto L70
        L1d:
            r0 = move-exception
            goto L2a
        L1f:
            r0 = move-exception
            goto L3e
        L21:
            r1 = move-exception
            goto L52
        L23:
            if (r4 == 0) goto L6f
            goto L67
        L26:
            r0 = move-exception
            goto L70
        L28:
            r0 = move-exception
            r4 = r3
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            r1.append(r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L1a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaac(r0)     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L6f
            goto L67
        L3c:
            r0 = move-exception
            r4 = r3
        L3e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1a
            r2.append(r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L1a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaac(r0)     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L6f
            goto L67
        L50:
            r1 = move-exception
            r4 = r3
        L52:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> L1a
            r2.append(r0)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L1a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaaa(r0)     // Catch: java.lang.Throwable -> L1a
            if (r4 == 0) goto L6f
        L67:
            r4.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r4 = move-exception
            r4.printStackTrace()
        L6f:
            return r3
        L70:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r4 = move-exception
            r4.printStackTrace()
        L7a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaau(java.lang.Object):byte[]");
    }

    public static byte[] aaaaaaaa(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[204800];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                aaaaaaaa((OutputStream) byteArrayOutputStream);
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void aaaaaaaa(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean aaaaaaaa(String str) {
        return aaaaaaa0(aaaaaaao(str));
    }

    public static void aaaaaaaa(byte[] bArr, int i, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaaa(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                randomAccessFile.setLength(bArr.length + i);
                randomAccessFile.seek(i);
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                return;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            file.createNewFile();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                if (bArr != null) {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                throw th;
            }
        }
    }

    public static void aaaaaaaa(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau.aaaaaaaa(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
                randomAccessFile.seek(file.length());
                byte[] bArr2 = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr2, 0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                    if (read != -1) {
                        randomAccessFile.write(bArr2, 0, read);
                    } else {
                        randomAccessFile.close();
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    try {
                        bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    while (true) {
                        int read2 = inputStream.read(bArr, 0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                        if (read2 != -1) {
                            fileOutputStream.write(bArr, 0, read2);
                        }
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    throw th;
                }
            }
        }
    }

    public static boolean aaaaaaaa(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (-1 != read) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
