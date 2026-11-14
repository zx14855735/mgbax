package Qo94AZ;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class B25kr6 {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final Pattern f7815ASJ6gh = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final Pattern f7816AYUAbz = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final Pattern f7817AZOQYO = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Logger f7818AZkASS = Logger.getLogger(B25kr6.class.getName());

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile ServerSocket f7820A4TApA;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Thread f7822ADYaiT;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ARc23Z f7821A5SV6n = new ARc23Z();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f7819A2egSU = 6377;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final OLy1FW.AzWtSf f7823ARc23Z = new OLy1FW.AzWtSf(8, 0);
    public final AMqCpz AMqCpz = new AMqCpz();

    static {
        myNao();
    }

    public static String A4TApA(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            f7818AZkASS.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    public static AlLFFp A5SV6n(AcNBzu acNBzu, String str, String str2) {
        byte[] bArr;
        A4TApA a4TApA = new A4TApA(str);
        if (str2 == null) {
            return new AlLFFp(acNBzu, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(a4TApA.A2egSU()).newEncoder().canEncode(str2) && a4TApA.f7769A5SV6n == null) {
                a4TApA = new A4TApA(str.concat("; charset=UTF-8"));
            }
            bArr = str2.getBytes(a4TApA.A2egSU());
        } catch (UnsupportedEncodingException e) {
            f7818AZkASS.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bArr = new byte[0];
        }
        return new AlLFFp(acNBzu, a4TApA.f7767A2egSU, new ByteArrayInputStream(bArr), bArr.length);
    }

    public static final void ADYaiT(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                f7818AZkASS.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public static boolean ASJ6gh(AlLFFp alLFFp) {
        String str = alLFFp.f7805AlLFFp;
        if (str != null) {
            return str.toLowerCase().contains("text/") || alLFFp.f7805AlLFFp.toLowerCase().contains("/json");
        }
        return false;
    }

    private static /* synthetic */ void myNao() {
        char[] charArray = "\u0082\u008e\u008cÏ\u0086\u0080\u008c\u0084Ï\u0083\u008e\u0098Ï\u0092\u0089\u0084\u008d\u008dÏ«\u008f\u0088£\u0093\u0088\u0085\u0086\u0084".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 225);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0082\u008d\u0088\u008f\u0088\u0095".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 225);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract AlLFFp AMqCpz(AZOQYO azoqyo);

    public final void ARc23Z() {
        this.f7821A5SV6n.getClass();
        this.f7820A4TApA = new ServerSocket();
        this.f7820A4TApA.setReuseAddress(true);
        QEisCN.A2egSU a2egSU = new QEisCN.A2egSU(this);
        Thread thread = new Thread(a2egSU);
        this.f7822ADYaiT = thread;
        thread.setDaemon(false);
        this.f7822ADYaiT.setName("NanoHttpd Main Listener");
        this.f7822ADYaiT.start();
        while (!a2egSU.f7455AlLFFp && ((IOException) a2egSU.f7456AmA8tU) == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = (IOException) a2egSU.f7456AmA8tU;
        if (iOException != null) {
            throw iOException;
        }
    }
}
