package com.game.boy.emu.gba;

import ADYaiT.DUi7mC;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Link {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static Link f11099A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Console f11100A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f11101A4TApA = new ArrayList(4);

    static {
        System.loadLibrary("gboy");
        ZCouaI();
    }

    private static /* synthetic */ void ZCouaI() {
        char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '@');
        }
        String str = new String(charArray);
        char[] charArray2 = "#,).)4".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '@');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static native ByteBuffer allocateBuffer(int i);

    public static native void deallocateBuffer(ByteBuffer byteBuffer);

    private native void nativeCloseConsole(Console console);

    private native long nativeOpenConsole(String str, int i);

    public static native int patch(ByteBuffer byteBuffer, int i, byte[] bArr);

    public final void A2egSU() {
        ArrayList arrayList = this.f11101A4TApA;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Console console = (Console) it.next();
            DUi7mC dUi7mC = console.AMqCpz;
            if (dUi7mC != null) {
                console.clearCheats();
                ((ArrayList) dUi7mC.f239AlLFFp).remove(console);
            }
            nativeCloseConsole(console);
        }
        arrayList.clear();
    }

    public final Console A4TApA(int i, String str) {
        long nativeOpenConsole = nativeOpenConsole(str, i);
        if (nativeOpenConsole == 0) {
            return null;
        }
        return new Console(nativeOpenConsole, this);
    }

    public final void A5SV6n(Console console) {
        this.f11101A4TApA.remove(console);
        DUi7mC dUi7mC = console.AMqCpz;
        if (dUi7mC != null) {
            console.clearCheats();
            ((ArrayList) dUi7mC.f239AlLFFp).remove(console);
        }
        nativeCloseConsole(console);
    }

    public native void loadBios(byte[] bArr);

    public native String loadRom(ByteBuffer byteBuffer, int i);

    public native void runFrame(boolean z);

    public native void unloadRom(String str);
}
