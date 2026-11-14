package L5dZB6;

import ADYaiT.CtFAbx;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.downloader.core.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Random;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements Runnable {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final String[] f4414B2KMhB = {"Mozilla/5.0 (Linux; Android 13; SM-S918B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; 2210132G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; CPH2447) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; LNA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (iPhone14,6; U; CPU iPhone OS 15_4 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/15.4 Mobile/10A403 Safari/602.1.50", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1"};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f4415AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final OkHttpClient f4416AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ADYaiT f4417AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public volatile boolean f4418AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public volatile boolean f4419B25kr6 = false;

    static {
        jNBZ();
    }

    public AMqCpz(A4TApA a4TApA, OkHttpClient okHttpClient, ADYaiT aDYaiT) {
        this.f4415AcNBzu = a4TApA;
        this.f4416AlLFFp = okHttpClient;
        this.f4417AmA8tU = aDYaiT;
    }

    public static void A2egSU(RandomAccessFile randomAccessFile, InputStream inputStream, Response response) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.getMessage();
            }
        }
        if (response != null) {
            response.close();
        }
    }

    public static Request A4TApA(String str, long j) {
        String AcNBzu2;
        Request.Builder header = new Request.Builder().url(str).header("User-Agent", f4414B2KMhB[new Random().nextInt(7)]).header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            AcNBzu2 = CtFAbx.AcNBzu(language, ";q=0.9,en;q=0.8");
        } else {
            AcNBzu2 = language + "-" + country + "," + language + ";q=0.9,en;q=0.8";
        }
        Request.Builder header2 = header.header("Accept-Language", AcNBzu2).header("Connection", "keep-alive");
        if (Build.VERSION.SDK_INT >= 23) {
            header2.header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "none");
        }
        if (j > 0) {
            header2.header(c.b, "bytes=" + j + "-");
        }
        return header2.build();
    }

    private static /* synthetic */ void jNBZ() {
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

    public final long A5SV6n(Response response, long j) {
        String header = response.header(c.f);
        if (header != null && header.contains("/")) {
            String trim = header.substring(header.indexOf("/") + 1).trim();
            if (!trim.equals("*")) {
                try {
                    return Long.parseLong(trim);
                } catch (NumberFormatException unused) {
                }
            }
        }
        long contentLength = response.body().contentLength();
        if (contentLength > 0) {
            return j > 0 ? contentLength + j : contentLength;
        }
        long j2 = this.f4415AcNBzu.f4397B2KMhB;
        if (j2 > 0) {
            return j2;
        }
        return -1L;
    }

    public final void ADYaiT(long j, long j2, File file) {
        if (!this.f4419B25kr6) {
            if (!this.f4418AzWtSf) {
                if (j == j2) {
                    this.f4417AmA8tU.A5SV6n(this.f4415AcNBzu);
                    return;
                } else {
                    this.f4417AmA8tU.ADYaiT(this.f4415AcNBzu);
                    return;
                }
            }
            ADYaiT aDYaiT = this.f4417AmA8tU;
            A4TApA a4TApA = this.f4415AcNBzu;
            aDYaiT.getClass();
            a4TApA.f4400B7CMnp = 2;
            aDYaiT.f4411ARc23Z.ADYaiT(a4TApA);
            aDYaiT.f4409A5SV6n.remove(a4TApA.f4392AcNBzu);
            aDYaiT.f4410ADYaiT.remove(a4TApA.f4392AcNBzu);
            aDYaiT.A4TApA(a4TApA);
            aDYaiT.AcNBzu();
            return;
        }
        ADYaiT aDYaiT2 = this.f4417AmA8tU;
        A4TApA a4TApA2 = this.f4415AcNBzu;
        aDYaiT2.getClass();
        a4TApA2.f4400B7CMnp = 6;
        String str = a4TApA2.f4392AcNBzu;
        SQLiteDatabase writableDatabase = aDYaiT2.f4411ARc23Z.getWritableDatabase();
        writableDatabase.delete("downloads", "id = ?", new String[]{str});
        writableDatabase.close();
        aDYaiT2.f4409A5SV6n.remove(a4TApA2.f4392AcNBzu);
        aDYaiT2.f4410ADYaiT.remove(a4TApA2.f4392AcNBzu);
        aDYaiT2.A4TApA(a4TApA2);
        aDYaiT2.AcNBzu();
        if (!file.exists() || file.delete()) {
            return;
        }
        file.getAbsolutePath();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Response response;
        InputStream inputStream;
        long j;
        this.f4417AmA8tU.ARc23Z(this.f4415AcNBzu, 1);
        File file = new File(this.f4415AcNBzu.f4396B25kr6);
        RandomAccessFile randomAccessFile = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("创建目录失败: " + parentFile.getAbsolutePath());
            }
            if (file.exists() && this.f4415AcNBzu.f4397B2KMhB > 0) {
                long length = file.length();
                A4TApA a4TApA = this.f4415AcNBzu;
                if (length == a4TApA.f4397B2KMhB) {
                    this.f4417AmA8tU.A5SV6n(a4TApA);
                    return;
                }
            }
            long length2 = file.exists() ? file.length() : 0L;
            Response execute = this.f4416AlLFFp.newCall(A4TApA(this.f4415AcNBzu.f4393AlLFFp, length2)).execute();
            try {
                if (execute.code() == 416) {
                    if (file.exists() && !file.delete()) {
                        file.getAbsolutePath();
                    }
                    execute = this.f4416AlLFFp.newCall(A4TApA(this.f4415AcNBzu.f4393AlLFFp, 0L)).execute();
                    j = 0;
                } else {
                    j = length2;
                }
                response = execute;
                try {
                    if (!response.isSuccessful()) {
                        throw new IOException("服务器响应错误: " + response.code());
                    }
                    long A5SV6n2 = A5SV6n(response, j);
                    if (A5SV6n2 <= 0) {
                        throw new IOException("无法获取文件大小");
                    }
                    A4TApA a4TApA2 = this.f4415AcNBzu;
                    if (a4TApA2.f4397B2KMhB != A5SV6n2) {
                        a4TApA2.f4397B2KMhB = A5SV6n2;
                        this.f4417AmA8tU.AMqCpz(a4TApA2);
                    }
                    if (j >= A5SV6n2) {
                        this.f4417AmA8tU.A5SV6n(this.f4415AcNBzu);
                        A2egSU(null, null, response);
                        return;
                    }
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile2.seek(j);
                        inputStream = response.body().byteStream();
                        try {
                            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                            long currentTimeMillis = System.currentTimeMillis();
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1 || this.f4418AzWtSf || this.f4419B25kr6) {
                                    break;
                                }
                                randomAccessFile2.write(bArr, 0, read);
                                j += read;
                                if (System.currentTimeMillis() - currentTimeMillis > 500 || j == A5SV6n2) {
                                    int min = Math.min((int) ((j * 100.0f) / A5SV6n2), 100);
                                    A4TApA a4TApA3 = this.f4415AcNBzu;
                                    if (min != a4TApA3.f4399B4ZgIw) {
                                        a4TApA3.f4399B4ZgIw = min;
                                        a4TApA3.f4398B3GDIM = j;
                                        this.f4417AmA8tU.AMqCpz(a4TApA3);
                                        currentTimeMillis = System.currentTimeMillis();
                                    }
                                }
                            }
                            ADYaiT(j, A5SV6n2, file);
                            A2egSU(randomAccessFile2, inputStream, response);
                        } catch (Exception e) {
                            e = e;
                            randomAccessFile = randomAccessFile2;
                            try {
                                A4TApA a4TApA4 = this.f4415AcNBzu;
                                ADYaiT aDYaiT = this.f4417AmA8tU;
                                e.getMessage();
                                aDYaiT.ADYaiT(a4TApA4);
                                A2egSU(randomAccessFile, inputStream, response);
                            } catch (Throwable th) {
                                th = th;
                                A2egSU(randomAccessFile, inputStream, response);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile2;
                            A2egSU(randomAccessFile, inputStream, response);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    A4TApA a4TApA42 = this.f4415AcNBzu;
                    ADYaiT aDYaiT2 = this.f4417AmA8tU;
                    e.getMessage();
                    aDYaiT2.ADYaiT(a4TApA42);
                    A2egSU(randomAccessFile, inputStream, response);
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    A2egSU(randomAccessFile, inputStream, response);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                response = execute;
            } catch (Throwable th5) {
                th = th5;
                response = execute;
            }
        } catch (Exception e5) {
            e = e5;
            response = null;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            response = null;
            inputStream = null;
        }
    }
}
