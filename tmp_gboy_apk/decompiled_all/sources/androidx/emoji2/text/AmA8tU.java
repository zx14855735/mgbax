package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Object f8657AZkASS = new Object();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static volatile AmA8tU f8658AaHO0E;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ReentrantReadWriteLock f8659A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B25kr6.AMqCpz f8660A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile int f8661A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Handler f8662ADYaiT;
    public final AYUAbz AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final AcNBzu f8663ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final AZkASS f8664ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final int f8665AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ARc23Z f8666AZOQYO;

    static {
        gzTqkW();
    }

    public AmA8tU(AzWtSf azWtSf) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f8659A2egSU = reentrantReadWriteLock;
        this.f8661A5SV6n = 3;
        AcNBzu acNBzu = azWtSf.f8654A2egSU;
        this.f8663ARc23Z = acNBzu;
        int i = azWtSf.f8655A4TApA;
        this.f8665AYUAbz = i;
        this.f8666AZOQYO = azWtSf.f8656A5SV6n;
        this.f8662ADYaiT = new Handler(Looper.getMainLooper());
        this.f8660A4TApA = new B25kr6.AMqCpz();
        this.f8664ASJ6gh = new AZkASS();
        AYUAbz aYUAbz = new AYUAbz(this);
        this.AMqCpz = aYUAbz;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.f8661A5SV6n = 0;
            } catch (Throwable th) {
                this.f8659A2egSU.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (A4TApA() == 0) {
            try {
                acNBzu.A2egSU(new ASJ6gh(aYUAbz));
            } catch (Throwable th2) {
                ADYaiT(th2);
            }
        }
    }

    public static AmA8tU A2egSU() {
        AmA8tU amA8tU;
        synchronized (f8657AZkASS) {
            try {
                amA8tU = f8658AaHO0E;
                if (!(amA8tU != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return amA8tU;
    }

    private static /* synthetic */ void gzTqkW() {
        char[] charArray = "~rp3z|px3\u007frd3nuxqq3Wst_otyzx".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 29);
        }
        String str = new String(charArray);
        char[] charArray2 = "~qtsti".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 29);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A4TApA() {
        this.f8659A2egSU.readLock().lock();
        try {
            return this.f8661A5SV6n;
        } finally {
            this.f8659A2egSU.readLock().unlock();
        }
    }

    public final void A5SV6n() {
        if (!(this.f8665AYUAbz == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (A4TApA() == 1) {
            return;
        }
        this.f8659A2egSU.writeLock().lock();
        try {
            if (this.f8661A5SV6n == 0) {
                return;
            }
            this.f8661A5SV6n = 0;
            this.f8659A2egSU.writeLock().unlock();
            AYUAbz aYUAbz = this.AMqCpz;
            AmA8tU amA8tU = aYUAbz.f8651A2egSU;
            try {
                amA8tU.f8663ARc23Z.A2egSU(new ASJ6gh(aYUAbz));
            } catch (Throwable th) {
                amA8tU.ADYaiT(th);
            }
        } finally {
            this.f8659A2egSU.writeLock().unlock();
        }
    }

    public final void ADYaiT(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f8659A2egSU.writeLock().lock();
        try {
            this.f8661A5SV6n = 2;
            arrayList.addAll(this.f8660A4TApA);
            this.f8660A4TApA.clear();
            this.f8659A2egSU.writeLock().unlock();
            this.f8662ADYaiT.post(new C4FrIb.A4TApA(arrayList, this.f8661A5SV6n, th));
        } catch (Throwable th2) {
            this.f8659A2egSU.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x005a, B:31:0x005f, B:33:0x0063, B:35:0x0070, B:37:0x008f, B:39:0x0099, B:41:0x009c, B:43:0x009f, B:45:0x00af, B:46:0x00b2), top: B:27:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence AMqCpz(java.lang.CharSequence r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.AmA8tU.AMqCpz(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void ARc23Z(AaHO0E aaHO0E) {
        JrXYwF.A4TApA.B4ZgIw(aaHO0E, "initCallback cannot be null");
        this.f8659A2egSU.writeLock().lock();
        try {
            if (this.f8661A5SV6n != 1 && this.f8661A5SV6n != 2) {
                this.f8660A4TApA.add(aaHO0E);
                this.f8659A2egSU.writeLock().unlock();
            }
            this.f8662ADYaiT.post(new C4FrIb.A4TApA(Arrays.asList(aaHO0E), this.f8661A5SV6n, (Throwable) null));
            this.f8659A2egSU.writeLock().unlock();
        } catch (Throwable th) {
            this.f8659A2egSU.writeLock().unlock();
            throw th;
        }
    }
}
