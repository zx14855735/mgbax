package Qo94AZ;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AYUAbz f7781A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final OutputStream f7782A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BufferedInputStream f7783A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f7784ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public String f7785ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f7786ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public HashMap f7787AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public HashMap f7788AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ADYaiT f7789AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final String f7790AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public String f7791AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f7792AlLFFp;

    public AZOQYO(B25kr6 b25kr6, AYUAbz aYUAbz, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f7792AlLFFp = b25kr6;
        this.f7781A2egSU = aYUAbz;
        this.f7783A5SV6n = new BufferedInputStream(inputStream, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        this.f7782A4TApA = outputStream;
        this.f7790AaHO0E = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
            inetAddress.getHostName().getClass();
        }
        this.f7788AZOQYO = new HashMap();
    }

    public static void A5SV6n(String str, HashMap hashMap) {
        String trim;
        String str2;
        if (str == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf >= 0) {
                trim = B25kr6.A4TApA(nextToken.substring(0, indexOf)).trim();
                str2 = B25kr6.A4TApA(nextToken.substring(indexOf + 1));
            } else {
                trim = B25kr6.A4TApA(nextToken).trim();
                str2 = "";
            }
            List list = (List) hashMap.get(trim);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(trim, list);
            }
            list.add(str2);
        }
    }

    public static int AMqCpz(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i) {
                return 0;
            }
            byte b = bArr[i3];
            if (b == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                return i3 + 4;
            }
            if (b == 10 && bArr[i4] == 10) {
                return i3 + 2;
            }
            i3 = i4;
        }
    }

    public static int[] ARc23Z(ByteBuffer byteBuffer, byte[] bArr) {
        int[] iArr = new int[0];
        if (byteBuffer.remaining() < bArr.length) {
            return iArr;
        }
        int length = bArr.length + f.a.c;
        byte[] bArr2 = new byte[length];
        int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
        byteBuffer.get(bArr2, 0, remaining);
        int length2 = remaining - bArr.length;
        int i = 0;
        do {
            for (int i2 = 0; i2 < length2; i2++) {
                for (int i3 = 0; i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                    if (i3 == bArr.length - 1) {
                        int[] iArr2 = new int[iArr.length + 1];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i + i2;
                        iArr = iArr2;
                    }
                }
            }
            i += length2;
            System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
            length2 = length - bArr.length;
            if (byteBuffer.remaining() < length2) {
                length2 = byteBuffer.remaining();
            }
            byteBuffer.get(bArr2, bArr.length, length2);
        } while (length2 > 0);
        return iArr;
    }

    public final void A2egSU(BufferedReader bufferedReader, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        String A4TApA2;
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            boolean hasMoreTokens = stringTokenizer.hasMoreTokens();
            AcNBzu acNBzu = AcNBzu.BAD_REQUEST;
            if (!hasMoreTokens) {
                throw new AmA8tU(acNBzu, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            hashMap.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new AmA8tU(acNBzu, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(63);
            if (indexOf >= 0) {
                A5SV6n(nextToken.substring(indexOf + 1), hashMap2);
                A4TApA2 = B25kr6.A4TApA(nextToken.substring(0, indexOf));
            } else {
                A4TApA2 = B25kr6.A4TApA(nextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.f7791AcNBzu = stringTokenizer.nextToken();
            } else {
                this.f7791AcNBzu = "HTTP/1.1";
                B25kr6.f7818AZkASS.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String readLine2 = bufferedReader.readLine();
            while (readLine2 != null && !readLine2.trim().isEmpty()) {
                int indexOf2 = readLine2.indexOf(58);
                if (indexOf2 >= 0) {
                    hashMap3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                }
                readLine2 = bufferedReader.readLine();
            }
            hashMap.put(ContentProviderManager.PROVIDER_URI, A4TApA2);
        } catch (IOException e) {
            throw new AmA8tU(e, "SERVER INTERNAL ERROR: IOException: " + e.getMessage());
        }
    }

    public final void A4TApA(A4TApA a4TApA, ByteBuffer byteBuffer, HashMap hashMap, HashMap hashMap2) {
        int[] ARc23Z2;
        int length;
        AcNBzu acNBzu;
        String str;
        A4TApA a4TApA2 = a4TApA;
        String str2 = a4TApA2.f7770ADYaiT;
        AcNBzu acNBzu2 = AcNBzu.INTERNAL_ERROR;
        try {
            ARc23Z2 = ARc23Z(byteBuffer, str2.getBytes());
            length = ARc23Z2.length;
            acNBzu = AcNBzu.BAD_REQUEST;
        } catch (AmA8tU e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (length < 2) {
                throw new AmA8tU(acNBzu, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            }
            int i = 1024;
            byte[] bArr = new byte[1024];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < ARc23Z2.length - 1) {
                byteBuffer.position(ARc23Z2[i3]);
                int remaining = byteBuffer.remaining() < i ? byteBuffer.remaining() : 1024;
                byteBuffer.get(bArr, i2, remaining);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i2, remaining), Charset.forName(a4TApA2.A2egSU())), remaining);
                String readLine = bufferedReader.readLine();
                if (readLine == null || !readLine.contains(str2)) {
                    throw new AmA8tU(acNBzu, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                String readLine2 = bufferedReader.readLine();
                String str3 = null;
                String str4 = null;
                int i5 = i4;
                int i6 = 2;
                String str5 = null;
                while (readLine2 != null && readLine2.trim().length() > 0) {
                    Matcher matcher = B25kr6.f7815ASJ6gh.matcher(readLine2);
                    if (matcher.matches()) {
                        str = str2;
                        Matcher matcher2 = B25kr6.f7817AZOQYO.matcher(matcher.group(2));
                        while (matcher2.find()) {
                            int[] iArr = ARc23Z2;
                            String group = matcher2.group(1);
                            if ("name".equalsIgnoreCase(group)) {
                                str3 = matcher2.group(2);
                            } else if (com.sigmob.sdk.downloader.core.breakpoint.f.e.equalsIgnoreCase(group)) {
                                String group2 = matcher2.group(2);
                                if (!group2.isEmpty()) {
                                    if (i5 > 0) {
                                        str5 = group2;
                                        i5++;
                                        str3 = str3 + String.valueOf(i5);
                                    } else {
                                        i5++;
                                    }
                                }
                                str5 = group2;
                            }
                            ARc23Z2 = iArr;
                        }
                    } else {
                        str = str2;
                    }
                    int[] iArr2 = ARc23Z2;
                    Matcher matcher3 = B25kr6.f7816AYUAbz.matcher(readLine2);
                    if (matcher3.matches()) {
                        str4 = matcher3.group(2).trim();
                    }
                    readLine2 = bufferedReader.readLine();
                    i6++;
                    ARc23Z2 = iArr2;
                    str2 = str;
                }
                String str6 = str2;
                int[] iArr3 = ARc23Z2;
                int i7 = 0;
                while (true) {
                    int i8 = i6 - 1;
                    if (i6 <= 0) {
                        break;
                    }
                    while (bArr[i7] != 10) {
                        i7++;
                    }
                    i7++;
                    i6 = i8;
                }
                if (i7 >= remaining - 4) {
                    throw new AmA8tU(acNBzu2, "Multipart header size exceeds MAX_HEADER_SIZE.");
                }
                int i9 = iArr3[i3] + i7;
                i3++;
                int i10 = iArr3[i3] - 4;
                byteBuffer.position(i9);
                List list = (List) hashMap.get(str3);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(str3, list);
                }
                if (str4 == null) {
                    byte[] bArr2 = new byte[i10 - i9];
                    byteBuffer.get(bArr2);
                    list.add(new String(bArr2, a4TApA.A2egSU()));
                } else {
                    String AZOQYO2 = AZOQYO(byteBuffer, i9, i10 - i9);
                    if (hashMap2.containsKey(str3)) {
                        int i11 = 2;
                        while (true) {
                            if (!hashMap2.containsKey(str3 + i11)) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        hashMap2.put(str3 + i11, AZOQYO2);
                    } else {
                        hashMap2.put(str3, AZOQYO2);
                    }
                    list.add(str5);
                }
                a4TApA2 = a4TApA;
                ARc23Z2 = iArr3;
                i4 = i5;
                str2 = str6;
                i = 1024;
                i2 = 0;
            }
        } catch (AmA8tU e3) {
            throw e3;
        } catch (Exception e4) {
            e = e4;
            throw new AmA8tU(acNBzu2, e.toString());
        }
    }

    public final void ADYaiT() {
        AcNBzu acNBzu = AcNBzu.INTERNAL_ERROR;
        B25kr6 b25kr6 = this.f7792AlLFFp;
        AYUAbz aYUAbz = this.f7781A2egSU;
        OutputStream outputStream = this.f7782A4TApA;
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                        boolean z = false;
                        this.f7784ADYaiT = 0;
                        this.AMqCpz = 0;
                        BufferedInputStream bufferedInputStream = this.f7783A5SV6n;
                        bufferedInputStream.mark(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                        try {
                            int read = bufferedInputStream.read(bArr, 0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                            if (read == -1) {
                                B25kr6.ADYaiT(bufferedInputStream);
                                B25kr6.ADYaiT(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (read > 0) {
                                int i = this.AMqCpz + read;
                                this.AMqCpz = i;
                                int AMqCpz = AMqCpz(bArr, i);
                                this.f7784ADYaiT = AMqCpz;
                                if (AMqCpz > 0) {
                                    break;
                                }
                                int i2 = this.AMqCpz;
                                read = bufferedInputStream.read(bArr, i2, 8192 - i2);
                            }
                            if (this.f7784ADYaiT < this.AMqCpz) {
                                bufferedInputStream.reset();
                                bufferedInputStream.skip(this.f7784ADYaiT);
                            }
                            this.f7787AYUAbz = new HashMap();
                            HashMap hashMap = this.f7788AZOQYO;
                            if (hashMap == null) {
                                this.f7788AZOQYO = new HashMap();
                            } else {
                                hashMap.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.AMqCpz)));
                            HashMap hashMap2 = new HashMap();
                            A2egSU(bufferedReader, hashMap2, this.f7787AYUAbz, this.f7788AZOQYO);
                            String str = this.f7790AaHO0E;
                            if (str != null) {
                                this.f7788AZOQYO.put("remote-addr", str);
                                this.f7788AZOQYO.put("http-client-ip", str);
                            }
                            int A4TApA2 = J3FDQU.A2egSU.A4TApA((String) hashMap2.get("method"));
                            this.f7786ASJ6gh = A4TApA2;
                            if (A4TApA2 == 0) {
                                throw new AmA8tU(AcNBzu.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) hashMap2.get("method")) + " unhandled.");
                            }
                            this.f7785ARc23Z = (String) hashMap2.get(ContentProviderManager.PROVIDER_URI);
                            this.f7789AZkASS = new ADYaiT(this.f7788AZOQYO);
                            String str2 = (String) this.f7788AZOQYO.get("connection");
                            boolean z2 = "HTTP/1.1".equals(this.f7791AcNBzu) && (str2 == null || !str2.matches("(?i).*close.*"));
                            AlLFFp AMqCpz2 = b25kr6.AMqCpz(this);
                            String str3 = (String) this.f7788AZOQYO.get("accept-encoding");
                            this.f7789AZkASS.A2egSU(AMqCpz2);
                            AMqCpz2.AZOQYO(this.f7786ASJ6gh);
                            if (B25kr6.ASJ6gh(AMqCpz2) && str3 != null && str3.contains("gzip")) {
                                z = true;
                            }
                            AMqCpz2.ASJ6gh(z);
                            AMqCpz2.AYUAbz(z2);
                            AMqCpz2.ADYaiT(outputStream);
                            if (!z2 || AMqCpz2.A4TApA()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            B25kr6.ADYaiT(AMqCpz2);
                            aYUAbz.A2egSU();
                        } catch (SSLException e) {
                            throw e;
                        } catch (IOException unused) {
                            B25kr6.ADYaiT(bufferedInputStream);
                            B25kr6.ADYaiT(outputStream);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (AmA8tU e2) {
                        B25kr6.A5SV6n(e2.A2egSU(), an.e, e2.getMessage()).ADYaiT(outputStream);
                        B25kr6.ADYaiT(outputStream);
                        B25kr6.ADYaiT(null);
                        aYUAbz.A2egSU();
                    }
                } catch (SSLException e3) {
                    B25kr6.A5SV6n(acNBzu, an.e, "SSL PROTOCOL FAILURE: " + e3.getMessage()).ADYaiT(outputStream);
                    B25kr6.ADYaiT(outputStream);
                    B25kr6.ADYaiT(null);
                    aYUAbz.A2egSU();
                } catch (IOException e4) {
                    B25kr6.A5SV6n(acNBzu, an.e, "SERVER INTERNAL ERROR: IOException: " + e4.getMessage()).ADYaiT(outputStream);
                    B25kr6.ADYaiT(outputStream);
                    B25kr6.ADYaiT(null);
                    aYUAbz.A2egSU();
                }
            } catch (SocketException e5) {
                throw e5;
            } catch (SocketTimeoutException e6) {
                throw e6;
            }
        } catch (Throwable th) {
            B25kr6.ADYaiT(null);
            aYUAbz.A2egSU();
            throw th;
        }
    }

    public final HashMap ASJ6gh() {
        HashMap hashMap = new HashMap();
        for (String str : this.f7787AYUAbz.keySet()) {
            hashMap.put(str, ((List) this.f7787AYUAbz.get(str)).get(0));
        }
        return hashMap;
    }

    public final void AYUAbz(HashMap hashMap) {
        long j;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutput dataOutput;
        ByteBuffer map;
        RandomAccessFile randomAccessFile = null;
        try {
            if (this.f7788AZOQYO.containsKey("content-length")) {
                j = Long.parseLong((String) this.f7788AZOQYO.get("content-length"));
            } else {
                j = this.f7784ADYaiT < this.AMqCpz ? r4 - r3 : 0L;
            }
            if (j < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutput = new DataOutputStream(byteArrayOutputStream);
            } else {
                try {
                    AYUAbz aYUAbz = this.f7781A2egSU;
                    ASJ6gh aSJ6gh = new ASJ6gh(aYUAbz.f7779A2egSU);
                    aYUAbz.f7780A4TApA.add(aSJ6gh);
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(aSJ6gh.f7777A2egSU.getAbsolutePath(), "rw");
                    byteArrayOutputStream = null;
                    randomAccessFile = randomAccessFile2;
                    dataOutput = randomAccessFile2;
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
            byte[] bArr = new byte[512];
            while (this.AMqCpz >= 0 && j > 0) {
                int read = this.f7783A5SV6n.read(bArr, 0, (int) Math.min(j, 512L));
                this.AMqCpz = read;
                j -= read;
                if (read > 0) {
                    dataOutput.write(bArr, 0, read);
                }
            }
            if (byteArrayOutputStream != null) {
                map = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            } else {
                map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                randomAccessFile.seek(0L);
            }
            if (B4ZgIw.AYUAbz.A2egSU(3, this.f7786ASJ6gh)) {
                A4TApA a4TApA = new A4TApA((String) this.f7788AZOQYO.get("content-type"));
                String str = a4TApA.f7768A4TApA;
                if (!"multipart/form-data".equalsIgnoreCase(str)) {
                    byte[] bArr2 = new byte[map.remaining()];
                    map.get(bArr2);
                    String trim = new String(bArr2, a4TApA.A2egSU()).trim();
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(str)) {
                        A5SV6n(trim, this.f7787AYUAbz);
                    } else if (trim.length() != 0) {
                        hashMap.put("postData", trim);
                    }
                } else {
                    if (a4TApA.f7770ADYaiT == null) {
                        throw new AmA8tU(AcNBzu.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                    A4TApA(a4TApA, map, this.f7787AYUAbz, hashMap);
                }
            } else if (B4ZgIw.AYUAbz.A2egSU(2, this.f7786ASJ6gh)) {
                hashMap.put(IAdInterListener.AdProdType.PRODUCT_CONTENT, AZOQYO(map, 0, map.limit()));
            }
        } finally {
            B25kr6.ADYaiT(null);
        }
    }

    public final String AZOQYO(ByteBuffer byteBuffer, int i, int i2) {
        File file;
        ByteBuffer duplicate;
        FileOutputStream fileOutputStream;
        if (i2 <= 0) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                AYUAbz aYUAbz = this.f7781A2egSU;
                ASJ6gh aSJ6gh = new ASJ6gh(aYUAbz.f7779A2egSU);
                file = aSJ6gh.f7777A2egSU;
                aYUAbz.f7780A4TApA.add(aSJ6gh);
                duplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            FileChannel channel = fileOutputStream.getChannel();
            duplicate.position(i).limit(i + i2);
            channel.write(duplicate.slice());
            String absolutePath = file.getAbsolutePath();
            B25kr6.ADYaiT(fileOutputStream);
            return absolutePath;
        } catch (Exception e2) {
            e = e2;
            throw new Error(e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            B25kr6.ADYaiT(fileOutputStream2);
            throw th;
        }
    }
}
