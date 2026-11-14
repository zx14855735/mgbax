package L2suez;

import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {
    public static String A2egSU(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean A4TApA(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.canRead() && file.length() != 0;
    }

    public static boolean A5SV6n(String str, String str2) {
        String A2egSU2;
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("预期的哈希值不能为空");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("文件路径不能为空");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("文件不存在: ".concat(str));
        }
        if (!file.isFile()) {
            throw new IOException("路径不是普通文件: ".concat(str));
        }
        if (!file.canRead()) {
            throw new IOException("文件不可读: ".concat(str));
        }
        if (file.length() == 0) {
            A2egSU2 = A2egSU(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest());
        } else {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                A2egSU2 = A2egSU(messageDigest.digest());
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return A2egSU2.equalsIgnoreCase(str2);
    }
}
