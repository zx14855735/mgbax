package com.game.boy.activity;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import AaHO0E.D8MqeW;
import android.R;
import android.accounts.Account;
import android.app.NotificationManager;
import android.app.PictureInPictureParams;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.opengl.GLES10;
import android.opengl.GLES11;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Rational;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.game.boy.MyApp;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.ConsoleGameSaveListener;
import com.game.boy.emu.gba.Link;
import com.game.boy.service.EmulatorService;
import com.game.boy.viewUi.GameSurfaceView;
import com.game.boy.viewUi.navigationView.ExpandableNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.archives.tar.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.xml.parsers.DocumentBuilderFactory;
import okhttp3.WebSocket;
import org.w3c.dom.Element;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EmulatorActivity extends A5SV6n implements OpB85q.B4ZgIw {

    /* renamed from: DG07BK, reason: collision with root package name */
    public static WeakReference f10988DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public static boolean f10989DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public static boolean f10990DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public static boolean f10991DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public static int f10992DXnQ0V;

    /* renamed from: B25kr6, reason: collision with root package name */
    public DrawerLayout f10993B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ExpandableNavigationView f10994B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public GameSurfaceView f10995B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public SurfaceView f10996B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LHpdLt.AZOQYO f10997B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public LLYwnm.AYUAbz f10998B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public I3HV03.A4TApA f10999BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public String f11000BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f11001BIYEnU = false;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public String f11002BJ7GGh = null;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public File f11003BNL6CD = null;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final Link f11004BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final HashMap f11005BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final LQ734U.ARc23Z f11006BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final ADYaiT.CTkVKb f11007BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final ADYaiT.AZkASS f11008BniPrB;
    public LHpdLt.BTvldC BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public LSQ6IS.ARc23Z f11009C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f11010C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public KpHwm4.AaHO0E f11011CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f11012CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public LQ734U.A4TApA f11013COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public LQ734U.AMqCpz f11014CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public KpHwm4.B25kr6 f11015CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public IQ76hF.AmA8tU f11016CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public ADYaiT.AmA8tU f11017CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public ADYaiT.AmA8tU f11018Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public BChYOn f11019CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public boolean f11020CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public String f11021CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public AudioTrack f11022CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public final LLcl8r.ARc23Z f11023CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public SharedPreferences f11024CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public boolean f11025CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public boolean f11026D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public boolean f11027D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public final ArrayList f11028D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public final C4FrIb.AmA8tU f11029D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public final BNL6CD f11030D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public IzHBwY.A4TApA f11031D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public Mi9UWv.ASJ6gh f11032DAk1zC;

    public EmulatorActivity() {
        LQ734U.ARc23Z aRc23Z = null;
        if (Link.f11099A5SV6n == null) {
            Link.f11099A5SV6n = new Link();
        }
        this.f11004BPw6Q8 = Link.f11099A5SV6n;
        this.f11005BTvldC = new HashMap();
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            try {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices != null) {
                    Iterator<BluetoothDevice> it = bondedDevices.iterator();
                    while (it.hasNext()) {
                        String name = it.next().getName();
                        if (name != null) {
                            arrayList.add(name);
                        }
                    }
                }
            } catch (SecurityException unused) {
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (str.contains(" 8-bitty ") || str.contains(" iCade ")) {
                aRc23Z = new LQ734U.ARc23Z();
                break;
            }
        }
        this.f11006BV3sI0 = aRc23Z;
        this.f11007BmvVmW = new ADYaiT.CTkVKb(8, this);
        this.f11008BniPrB = new ADYaiT.AZkASS(this);
        this.f11023CrfGsy = new LLcl8r.ARc23Z(this, this.f10996B4ZgIw);
        this.f11028D6yqiO = new ArrayList();
        this.f11029D8MqeW = new C4FrIb.AmA8tU(this);
        this.f11030D8cQ8b = new BNL6CD(this);
    }

    public static KpHwm4.B25kr6 B25kr6(EmulatorActivity emulatorActivity) {
        KpHwm4.B25kr6 A2egSU2;
        emulatorActivity.getClass();
        EmulatorService emulatorService = EmulatorService.f11108B4ZgIw;
        return (emulatorService == null || (A2egSU2 = emulatorService.A2egSU(emulatorActivity.f11011CASmeH)) == null) ? new KpHwm4.B25kr6(emulatorActivity.f11008BniPrB, emulatorActivity.f11011CASmeH) : A2egSU2;
    }

    public static void B2KMhB(EmulatorActivity emulatorActivity, String str) {
        emulatorActivity.getClass();
        EmulatorService emulatorService = EmulatorService.f11108B4ZgIw;
        if (emulatorService != null) {
            synchronized (emulatorService) {
                emulatorService.f11115B3GDIM = str;
                String A5SV6n2 = emulatorService.A5SV6n();
                NotificationManager notificationManager = emulatorService.f11109AcNBzu;
                if (notificationManager != null) {
                    notificationManager.notify(1, emulatorService.A4TApA(A5SV6n2));
                }
            }
        }
    }

    public static void B3GDIM(EmulatorActivity emulatorActivity) {
        I3HV03.A4TApA a4TApA = emulatorActivity.f10999BChYOn;
        ((SharedPreferences.Editor) a4TApA.f3809AmA8tU).putLong("SP_LAST_AD_TIME", System.currentTimeMillis()).apply();
        emulatorActivity.CNPG0E();
    }

    public static void B4ZgIw(SurfaceView surfaceView, float f) {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        if (surfaceView != null) {
            try {
                if (surfaceView.getHolder() != null) {
                    surface = surfaceView.getHolder().getSurface();
                    if (surface == null && surface.isValid()) {
                        surface.setFrameRate(f, 0);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        surface = null;
        if (surface == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r8 != 48000) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x014b, code lost:
    
        r0 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x014d, code lost:
    
        if (r15 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x014f, code lost:
    
        r0 = r15.getInt("soundVolume", 80);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0155, code lost:
    
        r15 = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, r0 / 100.0f));
        r12.setStereoVolume(r15, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0167, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0088 A[Catch: Exception -> 0x00f2, TryCatch #2 {Exception -> 0x00f2, blocks: (B:54:0x0052, B:59:0x0088, B:61:0x008e, B:63:0x0096, B:65:0x00a0, B:66:0x00a4, B:68:0x00a8, B:71:0x00ae, B:72:0x0069, B:75:0x0072, B:77:0x0082, B:79:0x00b5, B:82:0x00bf, B:84:0x00c3, B:85:0x00c7, B:87:0x00cd, B:89:0x00d5, B:91:0x00df, B:92:0x00e3, B:94:0x00e7, B:97:0x00ed), top: B:53:0x0052 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.media.AudioTrack B7CMnp(android.content.SharedPreferences r15) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.B7CMnp(android.content.SharedPreferences):android.media.AudioTrack");
    }

    public static File BPw6Q8(String str, String str2) {
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str2 = str2.substring(0, lastIndexOf);
        }
        String[] strArr = {".ips", ".ups"};
        for (int i = 0; i < 2; i++) {
            File file = new File(str, CtFAbx.AcNBzu(str2, strArr[i]));
            if (file.exists() && file.isFile()) {
                return file;
            }
        }
        return null;
    }

    public static EmulatorActivity BV3sI0() {
        WeakReference weakReference = f10988DG07BK;
        if (weakReference != null) {
            return (EmulatorActivity) weakReference.get();
        }
        return null;
    }

    public static String CTkVKb(int i) {
        return CtFAbx.ASJ6gh(Math.max(0, (i + 999) / 1000), "与服务器的连接已断开，正在尝试重新连接…\n剩余 ", " 秒");
    }

    public static float Cd8JRx(String str) {
        if (str == null || str.length() <= 0) {
            return 8.0f;
        }
        try {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        } catch (NumberFormatException unused) {
            return 8.0f;
        }
    }

    public static AudioTrack CqNSpT(int i, int i2) {
        try {
            AudioTrack audioTrack = new AudioTrack(3, i, 12, 2, i2, 1);
            if (audioTrack.getState() == 1) {
                return audioTrack;
            }
            audioTrack.release();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void AYUAbz(String str) {
        if (str != null) {
            this.f11011CASmeH.f4302AZkASS = Cd8JRx(str);
        } else {
            this.f11011CASmeH.f4302AZkASS = BpkvW3() ? Cd8JRx(this.f11024CtFAbx.getString("fastForwardSpeed", null)) : 1.0f;
        }
    }

    public final ADYaiT.AmA8tU AZOQYO(CharSequence charSequence, CharSequence charSequence2, BTvldC bTvldC) {
        ADYaiT.AmA8tU amA8tU = this.f11017CcAIMM;
        if (amA8tU != null && amA8tU.isShowing()) {
            this.f11017CcAIMM.dismiss();
            this.f11017CcAIMM = null;
        }
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        View inflate = LayoutInflater.from(this).inflate(2131493226, (ViewGroup) null);
        ((TextView) inflate.findViewById(2131297777)).setText(charSequence2);
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.f41B7CMnp = inflate;
        azoqyo.AMqCpz = charSequence;
        azoqyo.f35AmA8tU = false;
        a4TApA.AaHO0E(2131886161, null);
        ADYaiT.AmA8tU A2egSU2 = a4TApA.A2egSU();
        A2egSU2.setOnShowListener(new MOpbMP.AaHO0E(this, 1, bTvldC));
        this.f11017CcAIMM = A2egSU2;
        return A2egSU2;
    }

    public final LqstKO.AMqCpz AZkASS(LqstKO.ASJ6gh aSJ6gh) {
        boolean z = this.f11024CtFAbx.getBoolean("enableGl", false) && this.f11024CtFAbx.getBoolean("linearFiltering", false);
        aSJ6gh.getClass();
        int i = 1;
        while (i < 240) {
            i <<= 1;
        }
        int i2 = 1;
        while (i2 < 160) {
            i2 <<= 1;
        }
        int[] iArr = aSJ6gh.f4949AZkASS;
        GLES10.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        GLES10.glBindTexture(3553, i3);
        int i4 = z ? 9729 : 9728;
        GLES11.glTexParameteri(3553, 10241, i4);
        GLES11.glTexParameteri(3553, d.b, i4);
        GLES11.glTexParameteri(3553, 10242, 10497);
        GLES11.glTexParameteri(3553, 10243, 10497);
        LqstKO.AMqCpz aMqCpz = new LqstKO.AMqCpz();
        aMqCpz.f4933AcNBzu = i3;
        aMqCpz.f4934AlLFFp = i4;
        aMqCpz.f4935AmA8tU = i;
        aMqCpz.f4936AzWtSf = i2;
        GLES10.glTexImage2D(3553, 0, 6407, aMqCpz.f4935AmA8tU, aMqCpz.f4936AzWtSf, 0, 6407, 33635, (i == 240 && i2 == 160) ? null : ShortBuffer.wrap(new short[i * i2]));
        LqstKO.ADYaiT aDYaiT = aSJ6gh.AMqCpz;
        LqstKO.A4TApA a4TApA = aDYaiT instanceof LqstKO.A4TApA ? (LqstKO.A4TApA) aDYaiT : null;
        if (a4TApA != null) {
            String string = this.f11024CtFAbx.getString("shader", "none");
            if (!"none".equals(string) && this.f11024CtFAbx.getBoolean("enableGl", false) && string != null && !string.isEmpty()) {
                String[] split = string.split(",");
                try {
                    if (split.length != 1) {
                        Element[] elementArr = new Element[split.length];
                        for (int i5 = 0; i5 < split.length; i5++) {
                            File file = new File(split[i5].trim());
                            if (file.exists()) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                elementArr[i5] = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                                fileInputStream.close();
                            }
                        }
                        a4TApA.A4TApA(aMqCpz, elementArr);
                        return aMqCpz;
                    }
                    File file2 = new File(split[0].trim());
                    if (file2.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream2).getDocumentElement();
                        fileInputStream2.close();
                        LqstKO.A5SV6n ADYaiT2 = a4TApA.ADYaiT(aMqCpz, documentElement, aMqCpz.f4935AmA8tU, aMqCpz.f4936AzWtSf, false);
                        if (ADYaiT2 == null) {
                            return aMqCpz;
                        }
                        aMqCpz.f4937B25kr6 = ADYaiT2;
                        return aMqCpz;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return aMqCpz;
    }

    public final void AaHO0E(LQ734U.A2egSU a2egSU) {
        a2egSU.f4824AlLFFp = this.f11029D8MqeW;
        this.f11028D6yqiO.add(a2egSU);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void AcNBzu(SharedPreferences sharedPreferences, String str) {
        char c;
        AudioTrack audioTrack;
        int i = 0;
        if (str == null) {
            return;
        }
        switch (str.hashCode()) {
            case -2071475038:
                if (str.equals("rumbleIntensity")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1715019276:
                if (str.equals("enableRumble")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1454235157:
                if (str.equals("maxFrameSkips")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1440043700:
                if (str.equals("enableSound")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1231393898:
                if (str.equals("audioAccelerateMode")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -542604255:
                if (str.equals("useSensor")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -296947179:
                if (str.equals("frameCache")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -232311814:
                if (str.equals("rewindOn")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -91657104:
                if (str.equals("gyroSensitivity")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 227582404:
                if (str.equals("screenOrientation")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 228488879:
                if (str.equals("fastForwardTrigger")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 623118624:
                if (str.equals("fullScreenImmersive")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 714901223:
                if (str.equals("enableVKeypad")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1008943159:
                if (str.equals("floating_window_size")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 1071422733:
                if (str.equals("soundFrequency")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1173363300:
                if (str.equals("soundBlocking")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1195923432:
                if (str.equals("floating_window_alpha")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1776662489:
                if (str.equals("lockScreenOrientation")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1838919710:
                if (str.equals("fullScreenMode")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1851299255:
                if (str.equals("audio_buffer_size")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1858466558:
                if (str.equals("fastForwardSpeed")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1881341013:
                if (str.equals("solarEmulation")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2006668553:
                if (str.equals("soundVolume")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 2138265955:
                if (str.equals("enableCheats")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                if (this.f11004BPw6Q8.f11100A2egSU.f11094A2egSU.contains("rumble")) {
                    CkXcdM(sharedPreferences, "rumble");
                    break;
                }
                break;
            case 2:
                this.f11011CASmeH.f4301AZOQYO = sharedPreferences.getInt(str, 0);
                break;
            case 3:
                boolean z = sharedPreferences.getBoolean(str, true);
                if (z && this.f11022CqNSpT == null) {
                    this.f11022CqNSpT = B7CMnp(sharedPreferences);
                } else if (!z && (audioTrack = this.f11022CqNSpT) != null) {
                    audioTrack.release();
                    this.f11022CqNSpT = null;
                }
                AudioTrack audioTrack2 = this.f11022CqNSpT;
                this.f11011CASmeH.f4298ARc23Z = audioTrack2;
                setVolumeControlStream(audioTrack2 == null ? Integer.MIN_VALUE : 3);
                Console console = this.f11004BPw6Q8.f11100A2egSU;
                if (console != null) {
                    console.enableSound(audioTrack2 != null);
                    break;
                }
                break;
            case 4:
                this.f11011CASmeH.f4318BNL6CD = sharedPreferences.getBoolean(str, false);
                break;
            case 5:
                String string = sharedPreferences.getString(str, null);
                if (string != null && !string.equals("none")) {
                    if (this.f11014CQhlFr == null) {
                        LQ734U.AMqCpz aMqCpz = new LQ734U.AMqCpz(this);
                        this.f11014CQhlFr = aMqCpz;
                        AaHO0E(aMqCpz);
                        break;
                    }
                } else {
                    LQ734U.AMqCpz aMqCpz2 = this.f11014CQhlFr;
                    if (aMqCpz2 != null) {
                        aMqCpz2.A5SV6n();
                        this.f11028D6yqiO.remove(aMqCpz2);
                        this.f11014CQhlFr = null;
                        break;
                    }
                }
                break;
            case 6:
                this.f11011CASmeH.f4300AYUAbz = sharedPreferences.getInt(str, 1);
                break;
            case 7:
                if (this.f11004BPw6Q8.f11100A2egSU != null) {
                    sharedPreferences.getBoolean(str, false);
                    break;
                }
                break;
            case '\b':
                for (LNKngO.A2egSU a2egSU : this.f11005BTvldC.values()) {
                    if (a2egSU instanceof LNKngO.A5SV6n) {
                        ((LNKngO.A5SV6n) a2egSU).a(sharedPreferences.getInt(str, 5));
                    }
                }
                break;
            case '\t':
            case 17:
                String string2 = sharedPreferences.getString("screenOrientation", "sensor");
                int i2 = "sensor".equals(string2) ? 4 : "landscape".equals(string2) ? 0 : "portrait".equals(string2) ? 1 : "reverse_landscape".equals(string2) ? 8 : -1;
                if (i2 != 0 && i2 != 1 && i2 != 8) {
                    Iterator it = this.f11005BTvldC.values().iterator();
                    if (it.hasNext() && (it.next() instanceof LNKngO.A5SV6n) && sharedPreferences.getBoolean("lockScreenOrientation", false)) {
                        int i3 = getResources().getConfiguration().orientation;
                        if (i3 == 1) {
                            int orientation = getWindowManager().getDefaultDisplay().getOrientation();
                            i = (orientation == 2 || orientation == 3) ? 9 : 1;
                        } else if (i3 == 2) {
                            int orientation2 = getWindowManager().getDefaultDisplay().getOrientation();
                            if (orientation2 == 2 || orientation2 == 3) {
                                i = 8;
                            }
                        }
                        setRequestedOrientation(i);
                        break;
                    }
                }
                i = i2;
                setRequestedOrientation(i);
                break;
            case '\n':
                boolean equals = "hold".equals(sharedPreferences.getString(str, null));
                this.f11027D6DOie = equals;
                if (equals && BpkvW3()) {
                    CASmeH(null, false);
                    break;
                }
                break;
            case 11:
                boolean z2 = this.f11026D07BeM;
                BI9f7h(z2, z2 && this.f11024CtFAbx.getBoolean(str, true));
                break;
            case '\f':
                if (sharedPreferences.getBoolean(str, true)) {
                    if (this.f11009C2rE4F == null) {
                        LSQ6IS.ARc23Z aRc23Z = new LSQ6IS.ARc23Z(this.f10995B3GDIM);
                        this.f11009C2rE4F = aRc23Z;
                        AaHO0E(aRc23Z);
                        break;
                    }
                } else {
                    LSQ6IS.ARc23Z aRc23Z2 = this.f11009C2rE4F;
                    if (aRc23Z2 != null) {
                        aRc23Z2.A5SV6n();
                        this.f11028D6yqiO.remove(aRc23Z2);
                        this.f11009C2rE4F = null;
                        break;
                    }
                }
                break;
            case '\r':
                LHpdLt.AZOQYO azoqyo = this.f10997B7CMnp;
                if (azoqyo != null) {
                    azoqyo.AaHO0E(sharedPreferences.getInt(str, 48));
                    break;
                }
                break;
            case 14:
            case 19:
                if (sharedPreferences.getBoolean("enableSound", true)) {
                    AudioTrack audioTrack3 = this.f11022CqNSpT;
                    if (audioTrack3 != null) {
                        audioTrack3.release();
                    }
                    AudioTrack B7CMnp2 = B7CMnp(sharedPreferences);
                    this.f11022CqNSpT = B7CMnp2;
                    this.f11011CASmeH.f4298ARc23Z = B7CMnp2;
                    setVolumeControlStream(3);
                    Console console2 = this.f11004BPw6Q8.f11100A2egSU;
                    if (console2 != null) {
                        console2.enableSound(true);
                        break;
                    }
                }
                break;
            case 15:
                this.f11011CASmeH.f4317BJ7GGh = sharedPreferences.getBoolean(str, false);
                break;
            case 16:
                LHpdLt.AZOQYO azoqyo2 = this.f10997B7CMnp;
                if (azoqyo2 != null) {
                    azoqyo2.AZkASS(sharedPreferences.getInt(str, 5));
                    break;
                }
                break;
            case 18:
                boolean z3 = sharedPreferences.getBoolean(str, true);
                if (this.f11026D07BeM != z3) {
                    this.f11026D07BeM = z3;
                    BI9f7h(this.f11026D07BeM, this.f11024CtFAbx.getBoolean("fullScreenImmersive", true));
                    break;
                }
                break;
            case 20:
                if (BpkvW3()) {
                    AYUAbz(null);
                    break;
                }
                break;
            case 21:
                if (this.f11004BPw6Q8.f11100A2egSU.f11094A2egSU.contains("solar")) {
                    CkXcdM(sharedPreferences, "solar");
                    break;
                }
                break;
            case 22:
                AudioTrack audioTrack4 = this.f11022CqNSpT;
                if (audioTrack4 != null) {
                    audioTrack4.setVolume(sharedPreferences.getInt("soundVolume", 80) / 100.0f);
                    break;
                }
                break;
            case 23:
                if (this.f11015CSDoyG == null) {
                    CmUvjW();
                    break;
                }
                break;
        }
    }

    public final void AlLFFp(Console console) {
        this.f10999BChYOn.AzWtSf("enableRumble");
        console.A4TApA();
        SharedPreferences sharedPreferences = this.f11024CtFAbx;
        if (sharedPreferences.getBoolean("enableCheats", true)) {
            DUi7mC dUi7mC = console.AMqCpz;
            ((ArrayList) dUi7mC.f239AlLFFp).add(console);
            dUi7mC.AaHO0E(console);
        }
        console.setOption("cpuCore", sharedPreferences.getString("cpuCore", LiveConfigKey.AUTO));
        console.setOption("forceSaveType", sharedPreferences.getString("saveType", LiveConfigKey.AUTO));
        console.setOption("smcCheck", Integer.toString(sharedPreferences.getInt("smcCheck", 2) + 8));
        console.setOption("speedHack", sharedPreferences.getBoolean("speedHack", true) ? "true" : "false");
        console.setOption("enableMosaic", sharedPreferences.getBoolean("enableMosaic", true) ? "true" : "false");
        console.reset(this.f11024CtFAbx.getBoolean("bootBios", false));
    }

    public final void AmA8tU(Console console, int i) {
        File AmA8tU2 = MOpbMP.CTkVKb.AmA8tU(i, console.f11097ADYaiT);
        if (AmA8tU2.exists()) {
            CcAIMM(new C4FrIb.B4ZgIw(11, this, console, AmA8tU2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r3 != 0) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AzWtSf(java.net.ServerSocket r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            java.lang.String r4 = "wifi"
            r5 = 0
            if (r2 < r3) goto L13
            int r3 = com.bytedance.pangle.wrapper.AMqCpz.AMqCpz(r8)
            if (r3 == 0) goto L13
        L11:
            r3 = r5
            goto L43
        L13:
            android.content.Context r3 = r8.getApplicationContext()
            java.lang.String r6 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r6)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()
            if (r3 == 0) goto L11
            int r3 = r3.getType()
            if (r3 != r1) goto L11
            android.content.Context r3 = r8.getApplicationContext()
            java.lang.Object r3 = r3.getSystemService(r4)
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3
            android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()
            if (r3 == 0) goto L11
            int r3 = r3.getIpAddress()
            java.lang.String r3 = android.text.format.Formatter.formatIpAddress(r3)
        L43:
            if (r3 == 0) goto L47
            goto Lc9
        L47:
            r3 = 29
            if (r2 < r3) goto L6c
            android.content.Context r2 = r8.getApplicationContext()
            java.lang.Object r2 = r2.getSystemService(r4)
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()
            if (r2 == 0) goto L82
            android.net.wifi.SupplicantState r3 = r2.getSupplicantState()
            android.net.wifi.SupplicantState r4 = android.net.wifi.SupplicantState.COMPLETED
            if (r3 != r4) goto L82
            int r2 = r2.getIpAddress()
            java.lang.String r5 = android.text.format.Formatter.formatIpAddress(r2)
            goto L82
        L6c:
            android.content.Context r2 = r8.getApplicationContext()
            java.lang.Object r2 = r2.getSystemService(r4)
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2
            android.net.DhcpInfo r2 = r2.getDhcpInfo()
            if (r2 == 0) goto L82
            int r2 = r2.ipAddress
            java.lang.String r5 = android.text.format.Formatter.formatIpAddress(r2)
        L82:
            if (r5 == 0) goto L86
            r3 = r5
            goto Lc9
        L86:
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.net.SocketException -> Lc3
        L8a:
            boolean r3 = r2.hasMoreElements()     // Catch: java.net.SocketException -> Lc3
            if (r3 == 0) goto Lc7
            java.lang.Object r3 = r2.nextElement()     // Catch: java.net.SocketException -> Lc3
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3     // Catch: java.net.SocketException -> Lc3
            java.util.Enumeration r4 = r3.getInetAddresses()     // Catch: java.net.SocketException -> Lc3
        L9a:
            boolean r5 = r4.hasMoreElements()     // Catch: java.net.SocketException -> Lc3
            if (r5 == 0) goto L8a
            java.lang.Object r5 = r4.nextElement()     // Catch: java.net.SocketException -> Lc3
            java.net.InetAddress r5 = (java.net.InetAddress) r5     // Catch: java.net.SocketException -> Lc3
            java.lang.String r6 = r3.getName()     // Catch: java.net.SocketException -> Lc3
            java.lang.String r7 = "wlan"
            boolean r6 = r6.contains(r7)     // Catch: java.net.SocketException -> Lc3
            if (r6 == 0) goto L9a
            java.lang.String r6 = r5.getHostAddress()     // Catch: java.net.SocketException -> Lc3
            r7 = 58
            int r6 = r6.indexOf(r7)     // Catch: java.net.SocketException -> Lc3
            if (r6 >= 0) goto L9a
            java.lang.String r3 = r5.getHostAddress()     // Catch: java.net.SocketException -> Lc3
            goto Lc9
        Lc3:
            r2 = move-exception
            r2.printStackTrace()
        Lc7:
            java.lang.String r3 = "127.0.0.1"
        Lc9:
            if (r3 != 0) goto Ld3
            java.net.InetAddress r2 = r9.getInetAddress()
            java.lang.String r3 = r2.getHostAddress()
        Ld3:
            r2 = 2131887045(0x7f1203c5, float:1.9408686E38)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            java.lang.String r1 = r8.getString(r2, r1)
            r2 = 2131887044(0x7f1203c4, float:1.9408684E38)
            java.lang.CharSequence r2 = r8.getText(r2)
            I3HV03.A4TApA r3 = new I3HV03.A4TApA
            r4 = 22
            r3.<init>(r8, r9, r4, r0)
            ADYaiT.AmA8tU r9 = r8.AZOQYO(r2, r1, r3)
            r9.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.AzWtSf(java.net.ServerSocket):void");
    }

    public final Console B9tovu(String str, McNXgv.A5SV6n a5SV6n, int i) {
        boolean z = this.f11015CSDoyG.AMqCpz;
        Console A4TApA2 = this.f11004BPw6Q8.A4TApA(i, str);
        if (A4TApA2 == null) {
            return A4TApA2;
        }
        this.f10999BChYOn.AzWtSf("enableRumble");
        A4TApA2.A4TApA();
        A4TApA2.setOption("speedHack", "true");
        A4TApA2.reset(false);
        try {
            KpHwm4.B25kr6 b25kr6 = this.f11015CSDoyG;
            if (b25kr6.f4354ARc23Z) {
                synchronized (a5SV6n) {
                    if (a5SV6n.f5289B2KMhB.size() < 4) {
                        a5SV6n.f5289B2KMhB.add(A4TApA2);
                    }
                }
            } else {
                a5SV6n.f5295BI9f7h = A4TApA2;
                a5SV6n.A2egSU(KpHwm4.B25kr6.ARc23Z((short) 3, 4));
            }
            b25kr6.ADYaiT(a5SV6n);
            return A4TApA2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void BChYOn(Console console) {
        Link link = this.f11004BPw6Q8;
        Console console2 = link.f11100A2egSU;
        if (console2 != console) {
            if (console2 != null) {
                console2.setKeys(0);
                console2.setScreenBuffer(null);
                console2.enableSound(false);
                HashMap hashMap = this.f11005BTvldC;
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    ((LNKngO.A2egSU) it.next()).c();
                }
                hashMap.clear();
            }
            link.f11100A2egSU = console;
            if (console != null) {
                console.enableSound(this.f11022CqNSpT != null);
                AudioTrack audioTrack = this.f11022CqNSpT;
                if (audioTrack != null) {
                    audioTrack.flush();
                }
                Iterator it2 = console.f11094A2egSU.iterator();
                while (it2.hasNext()) {
                    CkXcdM(this.f11024CtFAbx, (String) it2.next());
                }
            }
        }
    }

    public final void BI9f7h(boolean z, boolean z2) {
        WindowInsetsController insetsController;
        int statusBars;
        int navigationBars;
        WindowInsetsController insetsController2;
        int statusBars2;
        int navigationBars2;
        int navigationBars3;
        Window window = getWindow();
        View decorView = window.getDecorView();
        if (z) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            decorView.setFitsSystemWindows(false);
            if (i >= 30) {
                insetsController2 = window.getInsetsController();
                if (insetsController2 != null) {
                    statusBars2 = WindowInsets.Type.statusBars();
                    navigationBars2 = WindowInsets.Type.navigationBars();
                    insetsController2.hide(statusBars2 | navigationBars2);
                    if (z2) {
                        insetsController2.setSystemBarsBehavior(2);
                    } else {
                        navigationBars3 = WindowInsets.Type.navigationBars();
                        insetsController2.show(navigationBars3);
                    }
                }
            } else if (z2) {
                decorView.setSystemUiVisibility(5894);
            } else {
                decorView.setSystemUiVisibility(1284);
            }
            if (z2) {
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
            } else {
                window.setStatusBarColor(0);
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                sharedPreferences.edit().apply();
                window.setNavigationBarColor(sharedPreferences.getInt("game_COLOR", -15108398));
            }
            decorView.setOnApplyWindowInsetsListener(new CrfGsy.A2egSU(1));
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                insetsController = window.getInsetsController();
                if (insetsController != null) {
                    statusBars = WindowInsets.Type.statusBars();
                    navigationBars = WindowInsets.Type.navigationBars();
                    insetsController.show(statusBars | navigationBars);
                }
            } else {
                window.clearFlags(1024);
                decorView.setSystemUiVisibility(1);
                decorView.setSystemUiVisibility(0);
            }
            SharedPreferences sharedPreferences2 = getSharedPreferences(getPackageName() + "_preferences", 0);
            sharedPreferences2.edit().apply();
            int i3 = sharedPreferences2.getInt("game_COLOR", -15108398);
            window.setNavigationBarColor(i3);
            window.setStatusBarColor(i3);
            decorView.setFitsSystemWindows(true);
            decorView.setOnApplyWindowInsetsListener(null);
            if (i2 >= 28) {
                WindowManager.LayoutParams attributes2 = window.getAttributes();
                attributes2.layoutInDisplayCutoutMode = 0;
                window.setAttributes(attributes2);
            }
        }
        decorView.requestApplyInsets();
        BNL6CD();
    }

    public final boolean BIYEnU(int i) {
        IzHBwY.A4TApA a4TApA = new IzHBwY.A4TApA(this, i);
        this.f11031D9tr6l = a4TApA;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            if (BPw6Q8.ASJ6gh.A2egSU(this, "android.permission.BLUETOOTH_CONNECT") == 0 && BPw6Q8.ASJ6gh.A2egSU(this, "android.permission.BLUETOOTH_SCAN") == 0) {
                return a4TApA.A4TApA();
            }
            androidx.core.app.AYUAbz.requestPermissions(this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", g.g}, 2);
            return false;
        }
        if (i2 < 23) {
            return a4TApA.A4TApA();
        }
        if (BPw6Q8.ASJ6gh.A2egSU(this, g.g) == 0) {
            return a4TApA.A4TApA();
        }
        androidx.core.app.AYUAbz.requestPermissions(this, new String[]{g.g}, 2);
        return false;
    }

    public final void BJ7GGh() {
        try {
            BChYOn bChYOn = this.f11019CikNvS;
            if (bChYOn != null) {
                bChYOn.cancel();
            }
        } catch (Throwable unused) {
        }
        this.f11019CikNvS = null;
        try {
            ADYaiT.AmA8tU amA8tU = this.f11018Cd8JRx;
            if (amA8tU != null && amA8tU.isShowing()) {
                this.f11018Cd8JRx.dismiss();
            }
        } catch (Throwable unused2) {
        }
        this.f11018Cd8JRx = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r0 = r1.getSupportedModes();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BNL6CD() {
        /*
            r8 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lb
            r1 = 30
            if (r0 < r1) goto Le
            android.view.Display r1 = com.bytedance.pangle.wrapper.A4TApA.A5SV6n(r8)     // Catch: java.lang.Exception -> Lb
            goto L16
        Lb:
            r0 = move-exception
            goto Lca
        Le:
            android.view.WindowManager r1 = r8.getWindowManager()     // Catch: java.lang.Exception -> Lb
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch: java.lang.Exception -> Lb
        L16:
            if (r1 != 0) goto L1a
            goto Lcd
        L1a:
            float r2 = r1.getRefreshRate()     // Catch: java.lang.Exception -> Lb
            r3 = 23
            r4 = 0
            if (r0 < r3) goto L5e
            android.view.Display$Mode[] r0 = com.bytedance.pangle.wrapper.AMqCpz.BIYEnU(r1)     // Catch: java.lang.Exception -> Lb
            if (r0 == 0) goto L5e
            int r1 = r0.length     // Catch: java.lang.Exception -> Lb
            if (r1 <= 0) goto L5e
            r1 = r0[r4]     // Catch: java.lang.Exception -> Lb
            int r2 = r0.length     // Catch: java.lang.Exception -> Lb
            r3 = 0
        L30:
            if (r3 >= r2) goto L44
            r5 = r0[r3]     // Catch: java.lang.Exception -> Lb
            float r6 = com.bytedance.pangle.wrapper.AMqCpz.A2egSU(r5)     // Catch: java.lang.Exception -> Lb
            float r7 = com.bytedance.pangle.wrapper.AMqCpz.A2egSU(r1)     // Catch: java.lang.Exception -> Lb
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L41
            r1 = r5
        L41:
            int r3 = r3 + 1
            goto L30
        L44:
            float r2 = com.bytedance.pangle.wrapper.AMqCpz.A2egSU(r1)     // Catch: java.lang.Exception -> Lb
            android.view.Window r0 = r8.getWindow()     // Catch: java.lang.Exception -> Lb
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()     // Catch: java.lang.Exception -> Lb
            int r1 = com.bytedance.pangle.wrapper.AMqCpz.BNL6CD(r1)     // Catch: java.lang.Exception -> Lb
            com.bytedance.pangle.wrapper.AMqCpz.B25kr6(r0, r1)     // Catch: java.lang.Exception -> Lb
            android.view.Window r1 = r8.getWindow()     // Catch: java.lang.Exception -> Lb
            r1.setAttributes(r0)     // Catch: java.lang.Exception -> Lb
        L5e:
            android.view.Window r0 = r8.getWindow()     // Catch: java.lang.Exception -> Lb
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()     // Catch: java.lang.Exception -> Lb
            r0.preferredRefreshRate = r2     // Catch: java.lang.Exception -> Lb
            android.view.Window r1 = r8.getWindow()     // Catch: java.lang.Exception -> Lb
            r1.setAttributes(r0)     // Catch: java.lang.Exception -> Lb
            I3HV03.A4TApA r0 = r8.f10999BChYOn     // Catch: java.lang.Exception -> Lb
            java.lang.String r1 = "enable_interpolation"
            java.lang.Object r0 = r0.f3808AlLFFp     // Catch: java.lang.Exception -> Lb
            android.content.SharedPreferences r0 = (android.content.SharedPreferences) r0     // Catch: java.lang.Exception -> Lb
            boolean r0 = r0.getBoolean(r1, r4)     // Catch: java.lang.Exception -> Lb
            I3HV03.A4TApA r1 = r8.f10999BChYOn     // Catch: java.lang.Exception -> Lb
            java.lang.String r3 = "interp_mode"
            java.lang.Object r1 = r1.f3808AlLFFp     // Catch: java.lang.Exception -> Lb
            android.content.SharedPreferences r1 = (android.content.SharedPreferences) r1     // Catch: java.lang.Exception -> Lb
            int r1 = r1.getInt(r3, r4)     // Catch: java.lang.Exception -> Lb
            LqstKO.A4TApA.f4896Cd8JRx = r1     // Catch: java.lang.Exception -> Lb
            r1 = 1
            LqstKO.A4TApA.f4894CTkVKb = r1     // Catch: java.lang.Exception -> Lb
            r3 = 0
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 <= 0) goto L93
            LqstKO.A4TApA.f4895CcAIMM = r2     // Catch: java.lang.Exception -> Lb
        L93:
            if (r0 == 0) goto La6
            java.lang.Class<LqstKO.A4TApA> r6 = LqstKO.A4TApA.class
            monitor-enter(r6)     // Catch: java.lang.Exception -> Lb
            if (r5 <= 0) goto L9f
            LqstKO.A4TApA.f4895CcAIMM = r2     // Catch: java.lang.Throwable -> L9d
            goto L9f
        L9d:
            r0 = move-exception
            goto La4
        L9f:
            LqstKO.A4TApA.AcNBzu(r1)     // Catch: java.lang.Throwable -> L9d
            monitor-exit(r6)     // Catch: java.lang.Exception -> Lb
            goto La9
        La4:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Exception -> Lb
        La6:
            LqstKO.A4TApA.AcNBzu(r4)     // Catch: java.lang.Exception -> Lb
        La9:
            if (r0 == 0) goto Lbf
            float r0 = LqstKO.A4TApA.f4895CcAIMM     // Catch: java.lang.Exception -> Lb
            r5 = 1121714176(0x42dc0000, float:110.0)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto Lb4
            r4 = 1
        Lb4:
            if (r4 == 0) goto Lbf
            r8.CikNvS(r2)     // Catch: java.lang.Exception -> Lb
            android.view.SurfaceView r0 = r8.f10996B4ZgIw     // Catch: java.lang.Exception -> Lb
            B4ZgIw(r0, r2)     // Catch: java.lang.Exception -> Lb
            return
        Lbf:
            r8.CikNvS(r3)     // Catch: java.lang.Exception -> Lb
            android.view.SurfaceView r0 = r8.f10996B4ZgIw     // Catch: java.lang.Exception -> Lb
            r1 = 1114636288(0x42700000, float:60.0)
            B4ZgIw(r0, r1)     // Catch: java.lang.Exception -> Lb
            return
        Lca:
            r0.printStackTrace()
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.BNL6CD():void");
    }

    public final ADYaiT.AmA8tU BTvldC(int i) {
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        a4TApA.B2KMhB(R.string.dialog_alert_title);
        a4TApA.AYUAbz();
        a4TApA.AZOQYO(i);
        a4TApA.AmA8tU(R.string.ok, null);
        return a4TApA.AMqCpz();
    }

    public final void BmvVmW() {
        KpHwm4.B25kr6 b25kr6 = this.f11015CSDoyG;
        if (b25kr6 == null) {
            this.f11004BPw6Q8.f11100A2egSU.reset(this.f11024CtFAbx.getBoolean("bootBios", false));
        } else if (b25kr6.f4354ARc23Z) {
            try {
                ((McNXgv.A5SV6n) b25kr6.f4352A5SV6n.get(0)).A2egSU(KpHwm4.B25kr6.ARc23Z((short) 5, 4).putInt(0));
            } catch (Exception unused) {
            }
        }
    }

    public final boolean BniPrB() {
        return this.f11004BPw6Q8.f11101A4TApA.size() == 1 && this.f11015CSDoyG == null;
    }

    public final boolean BpkvW3() {
        KpHwm4.AaHO0E aaHO0E = this.f11011CASmeH;
        return aaHO0E != null ? aaHO0E.f4319BPw6Q8 : this.f11012CNPG0E;
    }

    public final void C2rE4F() {
        BJ7GGh();
        ADYaiT.AmA8tU amA8tU = this.f11017CcAIMM;
        if (amA8tU != null && amA8tU.isShowing()) {
            this.f11017CcAIMM.dismiss();
            this.f11017CcAIMM = null;
        }
        if (this.f11015CSDoyG != null) {
            LHpdLt.BTvldC bTvldC = LHpdLt.BTvldC.f4560CikNvS;
            if (bTvldC != null) {
                bTvldC.AYUAbz(true);
            }
            this.BpkvW3 = null;
            KpHwm4.B25kr6 b25kr6 = this.f11015CSDoyG;
            Link link = this.f11004BPw6Q8;
            McNXgv.A4TApA a4TApA = b25kr6.f4351A4TApA;
            if (a4TApA == null) {
                throw new IllegalStateException();
            }
            a4TApA.interrupt();
            b25kr6.f4351A4TApA.A2egSU();
            b25kr6.f4359AaHO0E.f4302AZkASS = 1.0f;
            b25kr6.f4354ARc23Z = false;
            b25kr6.f4355ASJ6gh = false;
            b25kr6.f4357AZOQYO.set(0);
            b25kr6.f4358AZkASS.clear();
            Console console = b25kr6.f4359AaHO0E.f4307AzWtSf.f11100A2egSU;
            if (console != null) {
                try {
                    File AmA8tU2 = MOpbMP.CTkVKb.AmA8tU(9, console.f11097ADYaiT);
                    if (console.saveState(AmA8tU2.getAbsolutePath()) == 0) {
                        AmA8tU2.getName();
                    }
                } catch (Exception unused) {
                }
            }
            Iterator it = b25kr6.f4352A5SV6n.iterator();
            while (it.hasNext()) {
                McNXgv.A5SV6n a5SV6n = (McNXgv.A5SV6n) it.next();
                if (a5SV6n != null) {
                    Console console2 = a5SV6n.f5295BI9f7h;
                    if (console2 != null) {
                        link.A5SV6n(console2);
                        a5SV6n.f5295BI9f7h = null;
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList = a5SV6n.f5289B2KMhB;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                        Iterator it2 = a5SV6n.f5289B2KMhB.iterator();
                        while (it2.hasNext()) {
                            Console console3 = (Console) it2.next();
                            if (console3 != null) {
                                link.A5SV6n(console3);
                            }
                        }
                        a5SV6n.f5289B2KMhB.clear();
                    }
                    a5SV6n.interrupt();
                    Thread.currentThread().interrupt();
                    try {
                        a5SV6n.f5288B25kr6 = false;
                        a5SV6n.interrupt();
                        if (!a5SV6n.f5286AmA8tU && a5SV6n.f5284AcNBzu != null) {
                            try {
                                a5SV6n.f5284AcNBzu.close();
                            } catch (IOException e) {
                                PrintStream printStream = System.err;
                                e.getMessage();
                                printStream.getClass();
                            }
                        }
                        System.out.getClass();
                    } catch (Exception e2) {
                        PrintStream printStream2 = System.err;
                        e2.toString();
                        printStream2.getClass();
                    }
                    a5SV6n.f5293B9tovu = 0;
                    a5SV6n.f5294BChYOn = 0;
                    a5SV6n.f5287AzWtSf.clear();
                    a5SV6n.f5289B2KMhB.clear();
                    a5SV6n.f5296BIYEnU.clear();
                    System.out.getClass();
                    try {
                        a5SV6n.join();
                    } catch (InterruptedException unused2) {
                    }
                }
            }
            try {
                b25kr6.f4351A4TApA.join();
                b25kr6.f4351A4TApA = null;
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            this.f11015CSDoyG = null;
            this.f11011CASmeH.ARc23Z(null);
            this.f11021CmUvjW = null;
            CmUvjW();
            LLYwnm.AYUAbz aYUAbz = this.f10998B9tovu;
            if (aYUAbz != null && aYUAbz.f4626A2egSU.ADYaiT()) {
                this.f10998B9tovu.f4628A5SV6n = this.f11000BI9f7h;
                LLYwnm.AYUAbz aYUAbz2 = this.f10998B9tovu;
                aYUAbz2.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("action", "leave_room");
                aYUAbz2.ARc23Z(hashMap, "leave_room", null);
                this.f10998B9tovu.ADYaiT("", null, null);
            }
        }
        LHpdLt.AZOQYO azoqyo = this.f10997B7CMnp;
        if (azoqyo != null) {
            azoqyo.AcNBzu(false);
        }
        EmulatorService emulatorService = EmulatorService.f11108B4ZgIw;
        if (emulatorService != null) {
            synchronized (emulatorService) {
                emulatorService.f11112AzWtSf = null;
                emulatorService.f11115B3GDIM = null;
                String A5SV6n2 = emulatorService.A5SV6n();
                NotificationManager notificationManager = emulatorService.f11109AcNBzu;
                if (notificationManager != null) {
                    notificationManager.notify(1, emulatorService.A4TApA(A5SV6n2));
                }
            }
        }
    }

    public final void C4FrIb() {
        if (BniPrB()) {
            CharSequence text = getText(2131886144);
            CharSequence text2 = getText(2131886749);
            BI9f7h bI9f7h = new BI9f7h();
            bI9f7h.f10917AcNBzu = this;
            ADYaiT.AmA8tU AZOQYO2 = AZOQYO(text, text2, bI9f7h);
            AZOQYO2.f83B2KMhB.ADYaiT(-1, getText(2131886508), null);
            registerReceiver(this.f11007BmvVmW, new IntentFilter("android.bluetooth.adapter.action.SCAN_MODE_CHANGED"));
            AZOQYO2.setOnDismissListener(new Mi9UWv.ADYaiT(1, this));
            AZOQYO2.show();
            AZOQYO2.ARc23Z(-1).setOnClickListener(new ADYaiT.A5SV6n(19, this));
        }
    }

    public final void CASmeH(String str, boolean z) {
        this.f11012CNPG0E = z;
        KpHwm4.AaHO0E aaHO0E = this.f11011CASmeH;
        if (aaHO0E != null) {
            aaHO0E.f4319BPw6Q8 = z;
        }
        this.f11011CASmeH.ASJ6gh();
        AYUAbz(str);
        this.f11011CASmeH.AMqCpz();
    }

    public final void CNPG0E() {
        ServerSocket serverSocket;
        if (BniPrB()) {
            try {
                serverSocket = new ServerSocket(6374, 1, InetAddress.getByName("0.0.0.0"));
            } catch (IOException unused) {
                serverSocket = null;
            }
            AzWtSf(serverSocket);
        }
    }

    public final void COJEAR() {
        if (this.f11024CtFAbx.getBoolean("enableSync", false) && this.f11024CtFAbx.getBoolean("syncOnChanges", false)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("upload", true);
            ContentResolver.requestSync(new Account(PreferenceManager.getDefaultSharedPreferences(this).getString("syncAccount", null), "com.google"), "com.game.sync.provider", bundle);
        }
    }

    public final void CQhlFr(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        this.f10993B25kr6.A5SV6n(this.f10994B2KMhB, true);
        this.f10993B25kr6.A2egSU(new AmA8tU(this, itemId));
    }

    public final void CSDoyG() {
        if (this.f11025CtxOCS) {
            return;
        }
        Console.setGameSaveListener(new ConsoleGameSaveListener() { // from class: com.game.boy.activity.EmulatorActivity.29
            @Override // com.game.boy.emu.gba.ConsoleGameSaveListener
            public void onGameSaved(boolean z) {
                if (z) {
                    EmulatorActivity.this.COJEAR();
                } else {
                    MyApp.f10879AmA8tU.post(new KpHwm4.ARc23Z(2131886332));
                }
            }
        });
        CrfGsy();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        IQ76hF.AmA8tU amA8tU = defaultAdapter == null ? null : new IQ76hF.AmA8tU(6, defaultAdapter);
        this.f11016CTkVKb = amA8tU;
        if (amA8tU != null) {
            BI9f7h bI9f7h = new BI9f7h();
            bI9f7h.f10917AcNBzu = this;
            amA8tU.AlLFFp(bI9f7h, this);
        }
        this.f11025CtxOCS = true;
    }

    public final void CcAIMM(Runnable runnable) {
        this.f11011CASmeH.ASJ6gh();
        try {
            runnable.run();
        } finally {
            this.f11011CASmeH.AMqCpz();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        r1 = getWindowManager().getDefaultDisplay().getSupportedModes();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void CikNvS(float r9) {
        /*
            r8 = this;
            android.view.Window r0 = r8.getWindow()     // Catch: java.lang.Exception -> L19
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()     // Catch: java.lang.Exception -> L19
            r1 = 23
            r2 = 0
            int r3 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r3 > 0) goto L1b
            r0.preferredRefreshRate = r2     // Catch: java.lang.Exception -> L19
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L19
            if (r9 < r1) goto L5e
            com.bytedance.pangle.wrapper.AMqCpz.AzWtSf(r0)     // Catch: java.lang.Exception -> L19
            goto L5e
        L19:
            r9 = move-exception
            goto L66
        L1b:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L19
            if (r2 < r1) goto L5c
            android.view.WindowManager r1 = r8.getWindowManager()     // Catch: java.lang.Exception -> L19
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch: java.lang.Exception -> L19
            android.view.Display$Mode[] r1 = com.bytedance.pangle.wrapper.AMqCpz.BIYEnU(r1)     // Catch: java.lang.Exception -> L19
            if (r1 == 0) goto L5c
            int r2 = r1.length     // Catch: java.lang.Exception -> L19
            r3 = 0
            r4 = 0
        L30:
            if (r3 >= r2) goto L53
            r5 = r1[r3]     // Catch: java.lang.Exception -> L19
            float r6 = com.bytedance.pangle.wrapper.AMqCpz.A2egSU(r5)     // Catch: java.lang.Exception -> L19
            float r6 = r6 - r9
            float r6 = java.lang.Math.abs(r6)     // Catch: java.lang.Exception -> L19
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L50
            if (r4 == 0) goto L4f
            int r6 = com.bytedance.pangle.wrapper.AMqCpz.A5SV6n(r5)     // Catch: java.lang.Exception -> L19
            int r7 = com.bytedance.pangle.wrapper.AMqCpz.A5SV6n(r4)     // Catch: java.lang.Exception -> L19
            if (r6 <= r7) goto L50
        L4f:
            r4 = r5
        L50:
            int r3 = r3 + 1
            goto L30
        L53:
            if (r4 == 0) goto L5c
            int r1 = com.bytedance.pangle.wrapper.AMqCpz.BNL6CD(r4)     // Catch: java.lang.Exception -> L19
            com.bytedance.pangle.wrapper.AMqCpz.B25kr6(r0, r1)     // Catch: java.lang.Exception -> L19
        L5c:
            r0.preferredRefreshRate = r9     // Catch: java.lang.Exception -> L19
        L5e:
            android.view.Window r9 = r8.getWindow()     // Catch: java.lang.Exception -> L19
            r9.setAttributes(r0)     // Catch: java.lang.Exception -> L19
            return
        L66:
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.CikNvS(float):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [LNKngO.AYUAbz] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v3, types: [LNKngO.ADYaiT] */
    /* JADX WARN: Type inference failed for: r4v7, types: [LNKngO.ASJ6gh] */
    /* JADX WARN: Type inference failed for: r4v8, types: [LNKngO.A4TApA] */
    /* JADX WARN: Type inference failed for: r4v9, types: [LNKngO.ARc23Z] */
    public final void CkXcdM(SharedPreferences sharedPreferences, String str) {
        ?? r4;
        HashMap hashMap = this.f11005BTvldC;
        LNKngO.A2egSU a2egSU = (LNKngO.A2egSU) hashMap.remove(str);
        if (a2egSU != null) {
            a2egSU.c();
        }
        str.getClass();
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        switch (str) {
            case "rumble":
                if (sharedPreferences.getBoolean("enableRumble", true)) {
                    Vibrator vibrator = (Vibrator) getSystemService("vibrator");
                    if (vibrator.hasVibrator()) {
                        r4 = new LNKngO.ADYaiT(vibrator, this.f11011CASmeH, sharedPreferences.getInt("rumbleIntensity", 5));
                        r4.A2egSU();
                        break;
                    }
                }
                break;
            case "gyro":
                SensorManager sensorManager = (SensorManager) getSystemService("sensor");
                if (sensorManager.getSensorList(4).size() <= 0) {
                    if (!f10990DUi7mC) {
                        f10990DUi7mC = true;
                        BTvldC(2131886358);
                    }
                    r4 = new LNKngO.ASJ6gh(this.f11011CASmeH);
                    break;
                } else {
                    r4 = new LNKngO.A4TApA(sensorManager, this.f11011CASmeH);
                    r4.a();
                    break;
                }
            case "tilt":
                SensorManager sensorManager2 = (SensorManager) getSystemService("sensor");
                if (sensorManager2.getSensorList(1).size() <= 0) {
                    BTvldC(2131886844);
                    break;
                } else {
                    r4 = new LNKngO.ARc23Z(sensorManager2, getWindowManager(), this.f11011CASmeH);
                    r4.a();
                    break;
                }
            case "solar":
                if ("light_sensor".equals(sharedPreferences.getString("solarEmulation", "light_sensor"))) {
                    SensorManager sensorManager3 = (SensorManager) getSystemService("sensor");
                    if (sensorManager3.getSensorList(5).size() > 0) {
                        LNKngO.AMqCpz aMqCpz = new LNKngO.AMqCpz(sensorManager3, this.f11011CASmeH);
                        aMqCpz.a();
                        r4 = aMqCpz;
                    }
                }
                if (r4 == 0) {
                    r4 = new LNKngO.AYUAbz(this.f11011CASmeH);
                    if (!f10991DV2E8K) {
                        f10991DV2E8K = true;
                        BTvldC(2131886804);
                        break;
                    }
                }
                break;
        }
        if (r4 != 0) {
            hashMap.put(str, r4);
            if (r4 instanceof LNKngO.A5SV6n) {
                ((LNKngO.A5SV6n) r4).a(sharedPreferences.getInt("gyroSensitivity", 5));
            }
        }
    }

    public final void CmUvjW() {
        Link link = this.f11004BPw6Q8;
        DUi7mC dUi7mC = link.f11100A2egSU.AMqCpz;
        boolean z = this.f11024CtFAbx.getBoolean("enableCheats", true);
        if (z != (((ArrayList) dUi7mC.f239AlLFFp).size() > 0)) {
            dUi7mC.a();
            if (z) {
                Iterator it = link.f11101A4TApA.iterator();
                while (it.hasNext()) {
                    Console console = (Console) it.next();
                    ((ArrayList) dUi7mC.f239AlLFFp).add(console);
                    dUi7mC.AaHO0E(console);
                }
            }
        }
    }

    public final void CrfGsy() {
        SharedPreferences sharedPreferences = this.f11024CtFAbx;
        String[] strArr = {"maxFrameSkips", "fullScreenMode", "screenOrientation", "enableSound", "soundBlocking", "audioAccelerateMode", "audio_buffer_size", "fastForwardTrigger", "frameCache", "rewindOn"};
        boolean z = false;
        for (int i = 0; i < 10; i++) {
            AcNBzu(sharedPreferences, strArr[i]);
        }
        boolean z2 = this.f11026D07BeM;
        if (z2 && this.f11024CtFAbx.getBoolean("fullScreenImmersive", true)) {
            z = true;
        }
        BI9f7h(z2, z);
    }

    public final void CtFAbx() {
        Link link = this.f11004BPw6Q8;
        if (link.f11101A4TApA.size() <= 1) {
            finish();
            return;
        }
        Console console = link.f11100A2egSU;
        BChYOn(null);
        link.A5SV6n(console);
        BChYOn((Console) link.f11101A4TApA.get(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cc, code lost:
    
        if (r3 != null) goto L140;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00d0: MOVE (r2 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:209), block:B:149:0x00d0 */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0063 A[Catch: all -> 0x0084, IOException -> 0x0087, TryCatch #15 {IOException -> 0x0087, all -> 0x0084, blocks: (B:105:0x0059, B:106:0x005d, B:108:0x0063, B:111:0x006f, B:113:0x007b, B:114:0x008a, B:119:0x009c, B:120:0x00a4), top: B:104:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x009c A[Catch: all -> 0x0084, IOException -> 0x0087, TRY_LEAVE, TryCatch #15 {IOException -> 0x0087, all -> 0x0084, blocks: (B:105:0x0059, B:106:0x005d, B:108:0x0063, B:111:0x006f, B:113:0x007b, B:114:0x008a, B:119:0x009c, B:120:0x00a4), top: B:104:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a4 A[Catch: all -> 0x0084, IOException -> 0x0087, TRY_ENTER, TRY_LEAVE, TryCatch #15 {IOException -> 0x0087, all -> 0x0084, blocks: (B:105:0x0059, B:106:0x005d, B:108:0x0063, B:111:0x006f, B:113:0x007b, B:114:0x008a, B:119:0x009c, B:120:0x00a4), top: B:104:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String CtxOCS(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.CtxOCS(java.lang.String):java.lang.String");
    }

    public final void D07BeM() {
        SurfaceView surfaceView = this.f10996B4ZgIw;
        if (surfaceView != null) {
            this.f11023CrfGsy.surfaceDestroyed(surfaceView.getHolder());
        }
        KpHwm4.AaHO0E aaHO0E = this.f11011CASmeH;
        if (aaHO0E != null) {
            synchronized (aaHO0E) {
                aaHO0E.f4309B2KMhB = 4;
                aaHO0E.notify();
            }
            try {
                aaHO0E.f4316BIYEnU.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f11011CASmeH = null;
            stopService(new Intent(this, (Class<?>) EmulatorService.class));
        }
        AudioTrack audioTrack = this.f11022CqNSpT;
        if (audioTrack != null) {
            audioTrack.release();
            this.f11022CqNSpT = null;
        }
    }

    public final void D6DOie() {
        LqstKO.ASJ6gh aSJ6gh;
        String str = this.f11004BPw6Q8.f11100A2egSU.f11097ADYaiT;
        File A2egSU2 = KpHwm4.AYUAbz.A2egSU("screenshot");
        StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(str, "_");
        A5SV6n2.append(System.currentTimeMillis());
        A5SV6n2.append(".png");
        String absolutePath = new File(A2egSU2, A5SV6n2.toString()).getAbsolutePath();
        LLcl8r.ARc23Z aRc23Z = this.f11023CrfGsy;
        if (aRc23Z == null || (aSJ6gh = aRc23Z.f4661AmA8tU) == null) {
            return;
        }
        aSJ6gh.f4952AlLFFp = new BIYEnU(this, false, absolutePath, true);
        aSJ6gh.f4953AmA8tU = true;
    }

    @Override // ADYaiT.B2KMhB, androidx.core.app.AmA8tU, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i;
        LQ734U.ARc23Z aRc23Z = this.f11006BV3sI0;
        if (aRc23Z != null) {
            aRc23Z.getClass();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode >= 29 && keyCode <= 54 && (i = LQ734U.ARc23Z.f4840A2egSU[keyCode - 29]) != 0) {
                keyEvent = keyEvent.getAction() == 0 ? null : new KeyEvent(i >> 24, i & 16777215);
            }
            if (keyEvent == null) {
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final void enterPictureInPictureMode() {
        PictureInPictureParams build;
        if (Build.VERSION.SDK_INT >= 26) {
            Rational rational = new Rational(16, 9);
            PictureInPictureParams.Builder AMqCpz = ADYaiT.AMqCpz();
            AMqCpz.setAspectRatio(rational);
            build = AMqCpz.build();
            enterPictureInPictureMode(build);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x012f, code lost:
    
        if (com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(r0) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(r0) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01b3, code lost:
    
        if (r2 != null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f8, code lost:
    
        if (r2 == null) goto L124;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // ADYaiT.B2KMhB, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = true;
        if (configuration.hardKeyboardHidden != 1 && configuration.navigationHidden != 1) {
            z = false;
        }
        if (this.f11010C4FrIb != z) {
            this.f11010C4FrIb = z;
            this.f11023CrfGsy.A2egSU();
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f10992DXnQ0V++;
        if (!"android.intent.action.VIEW".equals(getIntent().getAction()) || getIntent().getData() == null) {
            MyApp.A2egSU("参数不对，退出");
            return;
        }
        f10988DG07BK = new WeakReference(this);
        getTaskId();
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA((Context) this);
        this.f10999BChYOn = a4TApA;
        BI9f7h(((SharedPreferences) a4TApA.f3808AlLFFp).getBoolean("fullScreenMode", true), ((SharedPreferences) this.f10999BChYOn.f3808AlLFFp).getBoolean("fullScreenImmersive", true));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f11024CtFAbx = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this.f11030D8cQ8b);
        Link link = this.f11004BPw6Q8;
        if (link.f11100A2egSU != null && f10992DXnQ0V > 1) {
            Iterator it = link.f11101A4TApA.iterator();
            while (it.hasNext()) {
                ((Console) it.next()).saveBattery();
            }
            link.f11100A2egSU = null;
            link.A2egSU();
        }
        if (this.f11011CASmeH == null) {
            this.f11011CASmeH = new KpHwm4.AaHO0E(link);
            Intent intent = new Intent(this, (Class<?>) EmulatorService.class);
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                startService(intent);
            } else if (i >= 26) {
                BPw6Q8.A5SV6n.A2egSU(this, intent);
            } else {
                startService(intent);
            }
        }
        if (bundle != null) {
            boolean z = bundle.getBoolean("inFastForward", false);
            this.f11012CNPG0E = z;
            KpHwm4.AaHO0E aaHO0E = this.f11011CASmeH;
            if (aaHO0E != null) {
                aaHO0E.f4319BPw6Q8 = z;
            }
        }
        Configuration configuration = getResources().getConfiguration();
        this.f11010C4FrIb = configuration.hardKeyboardHidden == 1 || configuration.navigationHidden == 1;
        setContentView(2131492906);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(2131296611);
        this.f10993B25kr6 = drawerLayout;
        drawerLayout.setDrawerLockMode(1);
        this.f10993B25kr6.A2egSU(new BPw6Q8(this));
        ExpandableNavigationView expandableNavigationView = (ExpandableNavigationView) findViewById(2131297689);
        this.f10994B2KMhB = expandableNavigationView;
        expandableNavigationView.setNavigationItemSelectedListener(this);
        this.f10995B3GDIM = (GameSurfaceView) findViewById(2131296703);
        SurfaceView surfaceView = (SurfaceView) findViewById(2131298037);
        surfaceView.getHolder().addCallback(this.f11023CrfGsy);
        surfaceView.setKeepScreenOn(true);
        surfaceView.setFocusableInTouchMode(true);
        surfaceView.requestFocus();
        this.f10996B4ZgIw = surfaceView;
        SharedPreferences sharedPreferences = this.f11024CtFAbx;
        LQ734U.A4TApA a4TApA2 = new LQ734U.A4TApA(surfaceView);
        this.f11013COJEAR = a4TApA2;
        AaHO0E(a4TApA2);
        if (sharedPreferences.getBoolean("enableVKeypad", true)) {
            LSQ6IS.ARc23Z aRc23Z = new LSQ6IS.ARc23Z(this.f10995B3GDIM);
            this.f11009C2rE4F = aRc23Z;
            AaHO0E(aRc23Z);
        }
        if (!"none".equals(sharedPreferences.getString("useSensor", "none"))) {
            LQ734U.AMqCpz aMqCpz = new LQ734U.AMqCpz(this);
            this.f11014CQhlFr = aMqCpz;
            AaHO0E(aMqCpz);
        }
        try {
            AaHO0E(new LQ734U.A5SV6n(this));
        } catch (Throwable unused) {
        }
        CrfGsy();
        if (link.f11100A2egSU != null) {
            CSDoyG();
        } else {
            new LLcl8r.ADYaiT(this, getIntent().getData().getPath()).execute(getIntent().getData().getPath());
        }
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        ADYaiT.AmA8tU amA8tU;
        f10992DXnQ0V--;
        GameSurfaceView gameSurfaceView = this.f10995B3GDIM;
        if (gameSurfaceView != null && (amA8tU = gameSurfaceView.f11164BIYEnU) != null && amA8tU.isShowing()) {
            gameSurfaceView.f11164BIYEnU.dismiss();
        }
        LHpdLt.AZOQYO azoqyo = this.f10997B7CMnp;
        if (azoqyo != null) {
            if (azoqyo.f4475ARc23Z) {
                TextInputEditText textInputEditText = azoqyo.f4484AzWtSf;
                InputMethodManager inputMethodManager = (InputMethodManager) azoqyo.f4473A5SV6n.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(textInputEditText.getWindowToken(), 0);
                }
                try {
                    azoqyo.AZOQYO();
                    View view = azoqyo.AMqCpz;
                    if (view != null && azoqyo.f4474ADYaiT != null) {
                        ViewParent parent = view.getParent();
                        ViewGroup viewGroup = azoqyo.f4474ADYaiT;
                        if (parent == viewGroup) {
                            viewGroup.removeView(azoqyo.AMqCpz);
                        }
                    }
                } catch (Exception unused) {
                }
                azoqyo.f4475ARc23Z = false;
                azoqyo.f4476ASJ6gh = false;
                LHpdLt.AMqCpz aMqCpz = azoqyo.f4500BniPrB;
                if (aMqCpz != null) {
                    aMqCpz.disable();
                }
            }
            this.f10997B7CMnp = null;
        }
        LLYwnm.AYUAbz aYUAbz = this.f10998B9tovu;
        if (aYUAbz != null) {
            for (Queue queue : aYUAbz.f4632AYUAbz.values()) {
                while (true) {
                    LLYwnm.ASJ6gh aSJ6gh = (LLYwnm.ASJ6gh) queue.poll();
                    if (aSJ6gh != null) {
                        ScheduledFuture scheduledFuture = aSJ6gh.f4623A4TApA;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                    }
                }
            }
            aYUAbz.f4632AYUAbz.clear();
            aYUAbz.f4633AZOQYO.shutdownNow();
            aYUAbz.f4629ADYaiT.clear();
            aYUAbz.AMqCpz.clear();
            aYUAbz.f4630ARc23Z.clear();
            aYUAbz.f4631ASJ6gh.clear();
            LLYwnm.AcNBzu acNBzu = aYUAbz.f4626A2egSU;
            synchronized (acNBzu) {
                try {
                    acNBzu.f4644AZkASS = true;
                    acNBzu.f4639ADYaiT = false;
                    acNBzu.f4645AaHO0E = false;
                    ScheduledFuture scheduledFuture2 = acNBzu.f4641ASJ6gh;
                    if (scheduledFuture2 != null) {
                        scheduledFuture2.cancel(true);
                        acNBzu.f4641ASJ6gh = null;
                    }
                    WebSocket webSocket = acNBzu.f4636A2egSU;
                    if (webSocket != null) {
                        webSocket.cancel();
                        acNBzu.f4636A2egSU.close(1000, "客户端销毁");
                        acNBzu.f4636A2egSU = null;
                    }
                    ScheduledExecutorService scheduledExecutorService = acNBzu.f4640ARc23Z;
                    if (scheduledExecutorService != null) {
                        scheduledExecutorService.shutdownNow();
                    }
                    ScheduledExecutorService scheduledExecutorService2 = acNBzu.f4643AZOQYO;
                    if (scheduledExecutorService2 != null) {
                        scheduledExecutorService2.shutdownNow();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f10998B9tovu = null;
        }
        Iterator it = this.f11028D6yqiO.iterator();
        while (it.hasNext()) {
            ((LQ734U.A2egSU) it.next()).A5SV6n();
        }
        C2rE4F();
        D07BeM();
        this.f11016CTkVKb = null;
        if (isFinishing() && f10992DXnQ0V == 0 && this.f11001BIYEnU) {
            BChYOn(null);
            this.f11004BPw6Q8.A2egSU();
        }
        Console.setGameSaveListener(null);
        SurfaceView surfaceView = this.f10996B4ZgIw;
        if (surfaceView != null) {
            surfaceView.getHolder().removeCallback(this.f11023CrfGsy);
        }
        SharedPreferences sharedPreferences = this.f11024CtFAbx;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.f11030D8cQ8b);
        }
        WeakReference weakReference = f10988DG07BK;
        if (weakReference != null && weakReference.get() == this) {
            f10988DG07BK = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r7 == false) goto L31;
     */
    @Override // ADYaiT.B2KMhB, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r6, android.view.KeyEvent r7) {
        /*
            r5 = this;
            r0 = 4
            r1 = 1
            if (r6 == r0) goto L11
            r0 = 27
            if (r6 == r0) goto L60
            r0 = 84
            if (r6 == r0) goto L60
            boolean r6 = super.onKeyDown(r6, r7)
            return r6
        L11:
            androidx.drawerlayout.widget.DrawerLayout r6 = r5.f10993B25kr6
            r7 = 8388611(0x800003, float:1.1754948E-38)
            android.view.View r6 = r6.AMqCpz(r7)
            r7 = 0
            if (r6 == 0) goto L22
            boolean r6 = androidx.drawerlayout.widget.DrawerLayout.AcNBzu(r6)
            goto L23
        L22:
            r6 = 0
        L23:
            if (r6 != 0) goto L61
            LSQ6IS.ARc23Z r6 = r5.f11009C2rE4F
            if (r6 == 0) goto L61
            boolean r6 = r6.f4856B9tovu
            if (r6 == 0) goto L61
            LQ734U.A4TApA r6 = r5.f11013COJEAR
            android.util.SparseIntArray r0 = r6.f4826AzWtSf
            int r2 = r0.size()
            int r2 = r2 - r1
        L36:
            if (r2 < 0) goto L5d
            int r3 = r0.valueAt(r2)
            r4 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r4
            if (r3 == 0) goto L5a
            int r7 = r0.keyAt(r2)
            r0 = 82
            if (r7 != r0) goto L58
            android.view.SurfaceView r6 = r6.f4825AmA8tU
            android.content.Context r6 = r6.getContext()
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r7 = r6.hasPermanentMenuKey()
            goto L5d
        L58:
            r7 = 1
            goto L5d
        L5a:
            int r2 = r2 + (-1)
            goto L36
        L5d:
            if (r7 != 0) goto L60
            goto L61
        L60:
            return r1
        L61:
            r5.openOptionsMenu()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.EmulatorActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if (data != null && "gbalink".equals(data.getScheme()) && ("resume".equals(data.getHost()) || "fullscreen".equals(data.getHost()))) {
            return;
        }
        if ("android.nfc.action.NDEF_DISCOVERED".equals(intent.getAction())) {
            IQ76hF.AmA8tU amA8tU = this.f11016CTkVKb;
            Parcelable parcelable = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0];
            amA8tU.getClass();
            Uri uri = ((NdefMessage) parcelable).getRecords()[0].toUri();
            if (uri != null) {
                AZOQYO(getText(2131887042), getText(2131886185), new B7CMnp(this, uri.getHost(), 2)).show();
                return;
            }
            return;
        }
        if (intent.getData() != null) {
            Link link = this.f11004BPw6Q8;
            if (link.f11100A2egSU != null) {
                File file = new File(getIntent().getData().getPath());
                File file2 = new File(intent.getData().getPath());
                if (file2.compareTo(file) != 0) {
                    this.f11011CASmeH.ASJ6gh();
                    BChYOn(null);
                    link.A2egSU();
                    setIntent(intent);
                    new LLcl8r.ADYaiT(this, file2.getAbsolutePath()).execute(file2.getAbsolutePath());
                }
            }
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f11011CASmeH.A5SV6n();
        Iterator it = this.f11028D6yqiO.iterator();
        while (it.hasNext()) {
            ((LQ734U.A2egSU) it.next()).AMqCpz();
        }
        GameSurfaceView gameSurfaceView = this.f10995B3GDIM;
        if (gameSurfaceView != null) {
            gameSurfaceView.setDanmakuEnabled(false);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        this.f10995B3GDIM.setPip(z);
        if (z) {
            LHpdLt.AZOQYO azoqyo = this.f10997B7CMnp;
            if (azoqyo != null && azoqyo.f4475ARc23Z) {
                azoqyo.AZkASS(10);
            }
            this.f11011CASmeH.ADYaiT();
            return;
        }
        this.f11011CASmeH.A5SV6n();
        LHpdLt.AZOQYO azoqyo2 = this.f10997B7CMnp;
        if (azoqyo2 == null || !azoqyo2.f4475ARc23Z) {
            return;
        }
        azoqyo2.AZkASS(azoqyo2.f4471A2egSU.getInt("floating_window_alpha", 5));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        IzHBwY.A4TApA a4TApA = this.f11031D9tr6l;
        a4TApA.getClass();
        if (i == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText((EmulatorActivity) a4TApA.f4106ADYaiT, "蓝牙权限已被拒绝", 0).show();
            } else {
                a4TApA.A4TApA();
            }
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        KpHwm4.AaHO0E aaHO0E;
        super.onResume();
        Iterator it = this.f11028D6yqiO.iterator();
        while (it.hasNext()) {
            ((LQ734U.A2egSU) it.next()).ADYaiT();
        }
        if (this.f11020CkXcdM) {
            this.f11020CkXcdM = false;
            new LLcl8r.A2egSU(this).AMqCpz();
        }
        if (hasWindowFocus()) {
            this.f11011CASmeH.ADYaiT();
        }
        GameSurfaceView gameSurfaceView = this.f10995B3GDIM;
        if (gameSurfaceView != null) {
            gameSurfaceView.setDanmakuEnabled(this.f11024CtFAbx.getBoolean("danmaku_enabled", false));
        }
        LLYwnm.AYUAbz aYUAbz = this.f10998B9tovu;
        if (aYUAbz != null && !aYUAbz.f4626A2egSU.f4644AZkASS && !aYUAbz.f4626A2egSU.ADYaiT() && !aYUAbz.f4626A2egSU.f4645AaHO0E) {
            aYUAbz.f4626A2egSU.A5SV6n();
        }
        EmulatorService emulatorService = EmulatorService.f11108B4ZgIw;
        if (emulatorService == null || (aaHO0E = this.f11011CASmeH) == null) {
            return;
        }
        emulatorService.A2egSU(aaHO0E);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("inFastForward", BpkvW3());
    }

    @Override // ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = this.f11024CtFAbx;
        Iterator it = this.f11028D6yqiO.iterator();
        while (it.hasNext()) {
            ((LQ734U.A2egSU) it.next()).A4TApA(sharedPreferences);
        }
    }

    @Override // ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        int i = f10992DXnQ0V;
        Link link = this.f11004BPw6Q8;
        if (i == 1) {
            Iterator it = link.f11101A4TApA.iterator();
            while (it.hasNext()) {
                ((Console) it.next()).saveBattery();
            }
        }
        if (link.f11100A2egSU != null && link.f11101A4TApA.size() == 1 && this.f11024CtFAbx.getBoolean("autoSave", false)) {
            CcAIMM(new D8MqeW(this, link.f11100A2egSU, 10, 8, false));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (Build.VERSION.SDK_INT < 26 || !new I3HV03.A4TApA(this, (String) null).AzWtSf("isPip")) {
            return;
        }
        enterPictureInPictureMode();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        EmulatorActivity emulatorActivity;
        super.onWindowFocusChanged(z);
        if (z) {
            BNL6CD();
            BI9f7h(this.f11026D07BeM, this.f11026D07BeM && this.f11024CtFAbx.getBoolean("fullScreenImm ersive", true));
        }
        KpHwm4.AaHO0E aaHO0E = this.f11011CASmeH;
        if (aaHO0E != null) {
            if (z) {
                aaHO0E.ADYaiT();
            } else {
                aaHO0E.A5SV6n();
            }
            if (this.f10998B9tovu == null && this.f10999BChYOn.B25kr6("user_token") != null && this.f10998B9tovu == null) {
                LLYwnm.AYUAbz aYUAbz = new LLYwnm.AYUAbz();
                this.f10998B9tovu = aYUAbz;
                aYUAbz.f4629ADYaiT.add(new AzWtSf(this));
                this.f10998B9tovu.AMqCpz.add(new B25kr6(this));
                this.f10998B9tovu.f4630ARc23Z.add(new LHpdLt.AzWtSf(2, this));
                this.f10998B9tovu.f4631ASJ6gh.add(new B2KMhB(this));
                this.f10998B9tovu.f4626A2egSU.A4TApA();
                if (this.f10997B7CMnp == null) {
                    LHpdLt.AZOQYO azoqyo = new LHpdLt.AZOQYO(this);
                    this.f10997B7CMnp = azoqyo;
                    azoqyo.f4504CNPG0E = this.f10998B9tovu;
                    if (azoqyo.f4475ARc23Z || (emulatorActivity = azoqyo.f4472A4TApA) == null || emulatorActivity.isFinishing() || azoqyo.f4472A4TApA.isDestroyed()) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) azoqyo.f4472A4TApA.findViewById(R.id.content);
                    azoqyo.f4474ADYaiT = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    if (azoqyo.AMqCpz.getParent() == azoqyo.f4474ADYaiT) {
                        azoqyo.f4475ARc23Z = true;
                        return;
                    }
                    azoqyo.AMqCpz.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    azoqyo.f4474ADYaiT.addView(azoqyo.AMqCpz);
                    azoqyo.f4475ARc23Z = true;
                    azoqyo.f4483AmA8tU.setVisibility(8);
                    azoqyo.f4493BIYEnU.setVisibility(0);
                    azoqyo.f4476ASJ6gh = true;
                    azoqyo.AMqCpz.post(new LHpdLt.A2egSU(azoqyo, 1));
                }
            }
        }
    }

    @Override // ADYaiT.B2KMhB, android.app.Activity
    public final void openOptionsMenu() {
        ArrayList arrayList;
        KpHwm4.B25kr6 b25kr6;
        KpHwm4.B25kr6 b25kr62;
        View AMqCpz = this.f10993B25kr6.AMqCpz(8388611);
        if (AMqCpz != null ? DrawerLayout.AcNBzu(AMqCpz) : false) {
            DrawerLayout drawerLayout = this.f10993B25kr6;
            View AMqCpz2 = drawerLayout.AMqCpz(8388611);
            if (AMqCpz2 == null) {
                throw new IllegalArgumentException(CtFAbx.BChYOn("No drawer view found with gravity ", "LEFT"));
            }
            drawerLayout.A5SV6n(AMqCpz2, true);
            return;
        }
        if (this.f11004BPw6Q8.f11100A2egSU != null) {
            ExpandableNavigationView expandableNavigationView = this.f10994B2KMhB;
            AZkASS.AmA8tU amA8tU = expandableNavigationView.f11202CqNSpT;
            if (amA8tU != null) {
                amA8tU.clear();
            }
            ArrayList arrayList2 = expandableNavigationView.f11199CikNvS;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            Mt2q9w.ADYaiT aDYaiT = expandableNavigationView.f11196CTkVKb;
            if (aDYaiT != null) {
                ArrayList arrayList3 = expandableNavigationView.f11199CikNvS;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                aDYaiT.f5531AmA8tU = arrayList3;
                aDYaiT.A4TApA();
                aDYaiT.notifyDataSetChanged();
            }
            if (getResources().getConfiguration().orientation == 2) {
                this.f10994B2KMhB.AmA8tU();
            } else if (this.f10994B2KMhB.getHeaderView() == null) {
                ((TextView) this.f10994B2KMhB.ASJ6gh(2131493261).findViewById(2131297688)).setText(new String(this.f11004BPw6Q8.f11100A2egSU.getRomCode()));
            }
            this.f10994B2KMhB.setItemIconTintList(null);
            int size = this.f11004BPw6Q8.f11101A4TApA.size();
            boolean z = this.f11015CSDoyG != null;
            if (size > 1) {
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = this.f11004BPw6Q8.f11101A4TApA;
                int i = 0;
                while (i < arrayList5.size()) {
                    Console console = (Console) arrayList5.get(i);
                    int i2 = i + 1;
                    int i3 = 2131297635 + i;
                    Link link = this.f11004BPw6Q8;
                    arrayList4.add(new Mt2q9w.AYUAbz(i3, i == link.f11101A4TApA.indexOf(link.f11100A2egSU) ? BPw6Q8.A2egSU.A4TApA(this, 2131230977) : null, console.f11097ADYaiT));
                    i = i2;
                }
                this.f10994B2KMhB.AcNBzu(2131297634, 2131231002, getString(2131886819), arrayList4);
            }
            if (z) {
                this.f10994B2KMhB.AcNBzu(2131297607, 2131231002, getString(2131886467), null);
            }
            if (!z && this.f11015CSDoyG == null) {
                this.f10994B2KMhB.AcNBzu(2131297627, 2131231010, getString(2131886115), null);
            }
            if (!z || ((b25kr62 = this.f11015CSDoyG) != null && b25kr62.f4354ARc23Z && Mi9UWv.ASJ6gh.f5402BniPrB == 1)) {
                String string = getString(BpkvW3() ? 2131886644 : 2131886307);
                BpkvW3();
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(new Mt2q9w.AYUAbz(2131297596, BPw6Q8.A2egSU.A4TApA(this, 2131231038), getString(2131886320)));
                if (BpkvW3()) {
                    arrayList6.add(new Mt2q9w.AYUAbz(2131297595, BPw6Q8.A2egSU.A4TApA(this, 2131231039), getString(2131886319)));
                } else {
                    arrayList6.add(new Mt2q9w.AYUAbz(2131297595, BPw6Q8.A2egSU.A4TApA(this, 2131231039), getString(2131886321)));
                }
                arrayList6.add(new Mt2q9w.AYUAbz(2131297597, BPw6Q8.A2egSU.A4TApA(this, 2131231040), getString(2131886322)));
                arrayList6.add(new Mt2q9w.AYUAbz(2131297598, BPw6Q8.A2egSU.A4TApA(this, 2131231041), getString(2131886323)));
                this.f10994B2KMhB.AcNBzu(2131297594, 2131230995, string, arrayList6);
            }
            if (BniPrB() || (size < 4 && !z)) {
                ArrayList arrayList7 = new ArrayList();
                if (BniPrB()) {
                    this.f10994B2KMhB.AcNBzu(2131297616, 2131231018, getString(2131886659), null);
                    arrayList7.add(new Mt2q9w.AYUAbz(2131297641, BPw6Q8.A2egSU.A4TApA(this, 2131231077), getString(2131887044)));
                    arrayList7.add(new Mt2q9w.AYUAbz(2131297640, BPw6Q8.A2egSU.A4TApA(this, 2131231077), getString(2131887042)));
                    arrayList7.add(new Mt2q9w.AYUAbz(2131297584, BPw6Q8.A2egSU.A4TApA(this, 2131230969), getString(2131886144)));
                    arrayList7.add(new Mt2q9w.AYUAbz(2131297583, BPw6Q8.A2egSU.A4TApA(this, 2131230969), getString(2131886143)));
                }
                if (size < 4 && !z) {
                    arrayList7.add(new Mt2q9w.AYUAbz(2131297608, BPw6Q8.A2egSU.A4TApA(this, 2131231020), getString(2131886473)));
                }
                this.f10994B2KMhB.AcNBzu(2131297609, 2131230954, getString(2131886474), arrayList7);
            }
            ArrayList arrayList8 = new ArrayList();
            boolean z2 = false;
            boolean z3 = ((SharedPreferences) this.f10999BChYOn.f3808AlLFFp).getBoolean("enable_interpolation", false);
            int i4 = ((SharedPreferences) this.f10999BChYOn.f3808AlLFFp).getInt("interp_mode", 0);
            arrayList8.add(new Mt2q9w.AYUAbz(2131296697, z3 && i4 == 0 ? BPw6Q8.A2egSU.A4TApA(this, 2131230977) : null, "混合插帧"));
            if (z3 && i4 == 1) {
                z2 = true;
            }
            arrayList8.add(new Mt2q9w.AYUAbz(2131296699, z2 ? BPw6Q8.A2egSU.A4TApA(this, 2131230977) : null, "光流插帧"));
            arrayList8.add(new Mt2q9w.AYUAbz(2131296698, !z3 ? BPw6Q8.A2egSU.A4TApA(this, 2131230977) : null, "关闭"));
            this.f10994B2KMhB.AcNBzu(2131297639, 2131231002, getString(2131886820), arrayList8);
            if (z) {
                this.f10994B2KMhB.AlLFFp(2131297628, BPw6Q8.A2egSU.A4TApA(this, 2131231009), getString(2131886739), null);
                this.f10994B2KMhB.AlLFFp(2131297606, BPw6Q8.A2egSU.A4TApA(this, 2131231016), getString(2131886734), null);
                this.f10994B2KMhB.AlLFFp(2131297631, BPw6Q8.A2egSU.A4TApA(this, 2131230984), getString(2131886773), null);
            } else {
                ArrayList arrayList9 = new ArrayList();
                if (this.f11024CtFAbx.getBoolean("enableCheats", true)) {
                    arrayList9.add(new Mt2q9w.AYUAbz(2131297585, BPw6Q8.A2egSU.A4TApA(this, 2131231050), getString(2131886177)));
                }
                arrayList9.add(new Mt2q9w.AYUAbz(2131297628, BPw6Q8.A2egSU.A4TApA(this, 2131231009), getString(2131886739)));
                arrayList9.add(new Mt2q9w.AYUAbz(2131297606, BPw6Q8.A2egSU.A4TApA(this, 2131231016), getString(2131886734)));
                arrayList9.add(new Mt2q9w.AYUAbz(2131297631, BPw6Q8.A2egSU.A4TApA(this, 2131230984), getString(2131886773)));
                this.f10994B2KMhB.AcNBzu(2131297613, 2131231029, getString(2131886548), arrayList9);
            }
            if (!z || ((b25kr6 = this.f11015CSDoyG) != null && b25kr6.f4354ARc23Z && Mi9UWv.ASJ6gh.f5402BniPrB == 1)) {
                arrayList = null;
                this.f10994B2KMhB.AcNBzu(2131297623, 2131231067, getString(2131886710), null);
            } else {
                arrayList = null;
            }
            this.f10994B2KMhB.AcNBzu(2131297586, 2131230983, getString(2131886186), arrayList);
            if (size > 1) {
                this.f10994B2KMhB.AcNBzu(2131297587, 2131230983, getString(2131886187), arrayList);
            }
            this.f10993B25kr6.AmA8tU(this.f10994B2KMhB);
        }
    }

    public void showadd(View view) {
    }
}
