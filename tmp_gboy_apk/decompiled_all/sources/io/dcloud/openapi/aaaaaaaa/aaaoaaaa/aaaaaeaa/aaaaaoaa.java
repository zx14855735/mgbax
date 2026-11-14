package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaoaa {
    public static final aaaaaoaa aaaaaaac = new aaaaaaaa();
    private long aaaaaaa0;
    private boolean aaaaaaaa;
    private long aaaaaaao;

    public class aaaaaaaa extends aaaaaoaa {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
        public aaaaaoaa aaaaaaaa(long j) {
            return this;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
        public void aaaaaaau() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa
        public aaaaaoaa aaaaaaaa(long j, TimeUnit timeUnit) {
            return this;
        }
    }

    static {
        SZaxVg();
    }

    private static /* synthetic */ void SZaxVg() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public aaaaaoaa aaaaaaa0() {
        this.aaaaaaao = 0L;
        return this;
    }

    public aaaaaoaa aaaaaaaa(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("timeout < 0: ", j));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.aaaaaaao = timeUnit.toNanos(j);
        return this;
    }

    public boolean aaaaaaac() {
        return this.aaaaaaaa;
    }

    public long aaaaaaan() {
        return this.aaaaaaao;
    }

    public long aaaaaaao() {
        if (this.aaaaaaaa) {
            return this.aaaaaaa0;
        }
        throw new IllegalStateException("No deadline");
    }

    public void aaaaaaau() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.aaaaaaaa && this.aaaaaaa0 - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public aaaaaoaa aaaaaaaa(long j) {
        this.aaaaaaaa = true;
        this.aaaaaaa0 = j;
        return this;
    }

    public aaaaaoaa aaaaaaaa() {
        this.aaaaaaaa = false;
        return this;
    }
}
