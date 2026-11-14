package com.kwad.sdk.liteapi.utils;

import A5SV6n.A2egSU;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LiteMd5Util {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getFileMD5Digest(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[f.a.c];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String hexString = toHexString(messageDigest.digest());
                            LiteCloseableUtil.closeQuietly(fileInputStream);
                            return hexString;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    LiteApiLogger.printStackTraceOnly(e);
                    LiteCloseableUtil.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                LiteCloseableUtil.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            LiteCloseableUtil.closeQuietly(fileInputStream2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static String getPartOfFileMD5Digest(String str, long j, long j2) {
        ?? r1;
        RandomAccessFile randomAccessFile;
        int i;
        long j3;
        int read;
        File file = new File(str);
        long length = file.length();
        try {
            if (length > 0) {
                try {
                    randomAccessFile = new RandomAccessFile(file, t.k);
                    if (j >= 0) {
                        try {
                            if (j < file.length()) {
                                randomAccessFile.seek(j);
                                byte[] bArr = new byte[f.a.c];
                                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                                i = 0;
                                while (true) {
                                    j3 = i;
                                    if (j3 >= j2 || (read = randomAccessFile.read(bArr)) == -1) {
                                        break;
                                    }
                                    if (read <= 0 || i + read <= j2) {
                                        messageDigest.update(bArr, 0, read);
                                        i += read;
                                    } else {
                                        int i2 = (int) (j2 - j3);
                                        messageDigest.update(bArr, 0, i2);
                                        i += i2;
                                    }
                                }
                                String hexString = toHexString(messageDigest.digest());
                                LiteCloseableUtil.closeQuietly(randomAccessFile);
                                return hexString;
                            }
                        } catch (Exception e) {
                            e = e;
                            LiteApiLogger.printStackTrace(e);
                            LiteCloseableUtil.closeQuietly(randomAccessFile);
                            return null;
                        }
                    }
                    j = 0;
                    randomAccessFile.seek(j);
                    byte[] bArr2 = new byte[f.a.c];
                    MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
                    i = 0;
                    while (true) {
                        j3 = i;
                        if (j3 >= j2) {
                            break;
                        }
                        break;
                    }
                    String hexString2 = toHexString(messageDigest2.digest());
                    LiteCloseableUtil.closeQuietly(randomAccessFile);
                    return hexString2;
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    r1 = 0;
                    th = th;
                    LiteCloseableUtil.closeQuietly((Closeable) r1);
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r1 = length;
        }
    }

    public static String md5(String str) {
        return TextUtils.isEmpty(str) ? "" : md5ForByte(str.getBytes());
    }

    public static String md5ForByte(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append(Constants.FAIL);
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sha1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest, 0, digest.length);
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
            return "";
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = bArr[i5 + i];
            int i6 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[(b & 255) >> 4];
            i4 += 2;
            cArr[i6] = cArr2[b & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5Digest(String str) {
        return getFileMD5Digest(new File(str));
    }
}
