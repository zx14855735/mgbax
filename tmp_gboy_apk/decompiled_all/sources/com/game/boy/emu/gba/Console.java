package com.game.boy.emu.gba;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import B4ZgIw.AYUAbz;
import KpHwm4.AcNBzu;
import MIEDxH.A2egSU;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Console {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashSet f11094A2egSU = new HashSet();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Link f11095A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public File f11096A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public String f11097ADYaiT;
    public DUi7mC AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f11098ARc23Z;
    private long nativeConsole;

    static {
        nativeInitIds();
        jLzii();
    }

    public Console(long j, Link link) {
        this.nativeConsole = j;
        this.f11095A4TApA = link;
    }

    private static /* synthetic */ void jLzii() {
        char[] charArray = "¤¨ªé ¦ª¢é¥¨¾é´¯¢««é\u008d©®\u0085µ®£ ¢".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 199);
        }
        String str = new String(charArray);
        char[] charArray2 = "¤«®©®³".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 199);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static native void nativeInitIds();

    public static native void setGameSaveListener(ConsoleGameSaveListener consoleGameSaveListener);

    public final void A2egSU() {
        File file;
        File file2;
        String B25kr62 = CtFAbx.B25kr6(new StringBuilder(), this.f11097ADYaiT, ".sav");
        ArrayList arrayList = this.f11095A4TApA.f11101A4TApA;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Console console = (Console) arrayList.get(i3);
            if (console != this && ((file = console.f11096A5SV6n) == (file2 = this.f11096A5SV6n) || file.compareTo(file2) == 0)) {
                i2 |= 1 << console.f11098ARc23Z;
            }
        }
        while (i < 4 && ((i2 >> i) & 1) != 0) {
            i++;
        }
        this.f11098ARc23Z = i;
        if (i > 0) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(B25kr62);
            A4TApA2.append(this.f11098ARc23Z + 1);
            B25kr62 = A4TApA2.toString();
        }
        loadBattery(new File(KpHwm4.AYUAbz.A2egSU("save"), B25kr62).getAbsolutePath());
    }

    public final void A4TApA() {
        Properties properties;
        byte[] ADYaiT2;
        A2egSU A5SV6n2 = A2egSU.A5SV6n();
        String str = new String(getRomCode());
        synchronized (A5SV6n2.f4983A5SV6n) {
            Properties properties2 = (Properties) A5SV6n2.f4982A4TApA.get(str);
            if (properties2 != null) {
                properties = new Properties();
                properties.putAll(properties2);
            } else {
                try {
                    ADYaiT2 = A2egSU.ADYaiT(A5SV6n2.f4981A2egSU);
                } catch (Exception unused) {
                }
                if (ADYaiT2 != null && ADYaiT2.length != 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(A2egSU.A2egSU(ADYaiT2, A2egSU.f4978ARc23Z));
                    try {
                        Properties A2egSU2 = AcNBzu.A2egSU(byteArrayInputStream, str);
                        if (A2egSU2 == null || A2egSU2.isEmpty()) {
                            byteArrayInputStream.close();
                            properties = new Properties();
                        } else {
                            A5SV6n2.f4982A4TApA.put(str, A2egSU2);
                            properties = new Properties();
                            properties.putAll(A2egSU2);
                        }
                    } finally {
                        byteArrayInputStream.close();
                    }
                }
                properties = new Properties();
            }
        }
        this.f11094A2egSU.clear();
        String str2 = (String) properties.remove("addon");
        if (str2 != null) {
            String[] split = str2.split("\\+");
            if (split.length > 0) {
                this.f11094A2egSU.clear();
                for (String str3 : split) {
                    this.f11094A2egSU.add(str3);
                }
            }
        }
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str4 = (String) propertyNames.nextElement();
            setOption(str4, properties.getProperty(str4));
            properties.getProperty(str4);
        }
    }

    public native int addCheat(String str, String str2, boolean z);

    public native void clearCheats();

    public native void enableCheat(int i, boolean z);

    public native void enableRumble(boolean z);

    public native void enableSound(boolean z);

    public native int getAudioSamples(short[] sArr, int i);

    public native byte[] getRomCode();

    public native String getRomHash();

    public native boolean getRumblePattern(long[] jArr);

    public native void loadBattery(String str);

    public native int loadState(String str);

    public native int loadStateFromMemory(byte[] bArr);

    public native void reset(boolean z);

    public native void saveBattery();

    public native int saveState(String str);

    public native byte[] saveStateToMemory();

    public native void setGyroValue(int i);

    public native void setKeys(int i);

    public native void setOption(String str, String str2);

    public native void setScreenBuffer(Buffer buffer);

    public native void setSolarValue(int i);

    public native void setTiltValue(int i, int i2);

    public final String toString() {
        return this.f11096A5SV6n.getName();
    }
}
