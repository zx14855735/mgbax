package MIEDxH;

import ADYaiT.CtFAbx;
import H0R8Px.ARc23Z;
import HMGPfW.A5SV6n;
import Hdahpu.AZOQYO;
import L2suez.AcNBzu;
import L2suez.AlLFFp;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.game.boy.MyApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {
    public static final byte[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final byte[] f4978ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static volatile A2egSU f4979ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static MyApp f4980AYUAbz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final File f4981A2egSU;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final OkHttpClient f4984ADYaiT;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f4983A5SV6n = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ARc23Z f4982A4TApA = new ARc23Z(50, 1);

    static {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            AMqCpz = messageDigest.digest("c3fcd3d76192e4007dfb496cca67e13b".getBytes("UTF-8"));
            messageDigest.reset();
            f4978ARc23Z = messageDigest.digest("a4f5e6d7c8b9a0f1e2d3c4b5a6f7e8d9".getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException("密钥初始化失败", e);
        }
    }

    public A2egSU(MyApp myApp) {
        OkHttpClient build;
        FileOutputStream fileOutputStream;
        byte[] ADYaiT2;
        this.f4981A2egSU = new File(myApp.getCacheDir(), "rom_config.ini");
        InputStream inputStream = null;
        try {
            TrustManager[] trustManagerArr = {new AcNBzu(3)};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]).hostnameVerifier(new AlLFFp(3));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            build = hostnameVerifier.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
        } catch (Exception unused) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            build = builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).build();
        }
        this.f4984ADYaiT = build;
        File file = this.f4981A2egSU;
        if (file.exists()) {
            return;
        }
        File file2 = new File(file.getParent(), "rom_config.ini.plain.tmp");
        try {
            InputStream open = myApp.getAssets().open("rom_config.ini");
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                    while (true) {
                        int read = open.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused2) {
                            }
                        }
                    }
                    open.close();
                    try {
                        ADYaiT2 = ADYaiT(file2);
                    } catch (Exception unused3) {
                        if (!file2.exists()) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        throw th;
                    }
                    if (ADYaiT2 == null || ADYaiT2.length == 0) {
                        throw new IOException("默认配置为空");
                    }
                    byte[] A4TApA2 = A4TApA(ADYaiT2, f4978ARc23Z);
                    fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(A4TApA2);
                        if (!file2.exists()) {
                            return;
                        }
                        file2.delete();
                    } finally {
                        fileOutputStream2.close();
                    }
                } catch (IOException unused4) {
                    inputStream = open;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = open;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused8) {
                        throw th;
                    }
                }
            } catch (IOException unused9) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException unused10) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static byte[] A2egSU(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 16) {
            throw new IllegalArgumentException("加密数据长度异常");
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, 16);
        int length = bArr.length - 16;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 16, bArr4, 0, length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return cipher.doFinal(bArr4);
    }

    public static byte[] A4TApA(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr3 = new byte[16];
        new SecureRandom().nextBytes(bArr3);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
        byte[] doFinal = cipher.doFinal(bArr);
        byte[] bArr4 = new byte[doFinal.length + 16];
        System.arraycopy(bArr3, 0, bArr4, 0, 16);
        System.arraycopy(doFinal, 0, bArr4, 16, doFinal.length);
        return bArr4;
    }

    public static A2egSU A5SV6n() {
        if (f4979ASJ6gh == null) {
            synchronized (A2egSU.class) {
                try {
                    if (f4979ASJ6gh == null) {
                        MyApp myApp = f4980AYUAbz;
                        if (myApp == null) {
                            throw new IllegalStateException("先调用RomConfig.init(context)");
                        }
                        f4979ASJ6gh = new A2egSU(myApp);
                    }
                } finally {
                }
            }
        }
        return f4979ASJ6gh;
    }

    public static byte[] ADYaiT(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        if (file.exists() && file.length() != 0) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException unused) {
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                byteArrayOutputStream = null;
            }
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
                } catch (IOException unused3) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                return byteArray;
            } catch (IOException unused5) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused8) {
                    }
                }
                if (byteArrayOutputStream == null) {
                    throw th;
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException unused9) {
                    throw th;
                }
            }
        }
        return null;
    }

    public final void AMqCpz(boolean z, AZOQYO azoqyo) {
        StringBuilder sb = new StringBuilder("rom_config_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        File file = new File(this.f4981A2egSU.getParent(), CtFAbx.AZkASS(".tmp", (int) (Math.random() * 10000.0d), sb));
        this.f4984ADYaiT.newCall(new Request.Builder().url("https://gboy.top/RoomConfig.php").build()).enqueue(new A5SV6n(this, file, z, azoqyo));
    }
}
