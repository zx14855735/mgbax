package com.kwad.sdk.pngencrypt;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DeflatedChunksSet {
    int aZA;
    int aZB;
    public final String aZC;
    protected final boolean aZb;
    protected byte[] aZr;
    private int aZs;
    private int aZt;
    private int aZu;
    State aZv;
    private final boolean aZw;
    private d aZx;
    private long aZy;
    private long aZz;
    private Inflater inf;

    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        static {
            hquC();
        }

        private static /* synthetic */ void hquC() {
            char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 143);
            }
            String str = new String(charArray);
            char[] charArray2 = "ìãæáæû".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 143);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aZv = state;
        this.aZy = 0L;
        this.aZz = 0L;
        this.aZA = -1;
        this.aZB = -1;
        this.aZC = str;
        this.aZb = z;
        this.aZt = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException(CtFAbx.ARc23Z(i, "bad inital row len "));
        }
        if (inflater != null) {
            this.inf = inflater;
            this.aZw = false;
        } else {
            this.inf = new Inflater();
            this.aZw = true;
        }
        this.aZr = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.aZu = -1;
        this.aZv = state;
        try {
            ex(i);
        } catch (RuntimeException e) {
            close();
            throw e;
        }
    }

    private boolean PR() {
        int i;
        try {
            if (this.aZv == State.ROW_READY) {
                new PngjException("invalid state");
            }
            if (this.aZv.isDone()) {
                return false;
            }
            byte[] bArr = this.aZr;
            if (bArr == null || bArr.length < this.aZt) {
                this.aZr = new byte[this.aZt];
            }
            if (this.aZs < this.aZt && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aZr;
                    int i2 = this.aZs;
                    i = inflater.inflate(bArr2, i2, this.aZt - i2);
                } catch (DataFormatException e) {
                    new PngjException("error decompressing zlib stream ", e);
                    i = 0;
                }
                this.aZs += i;
                this.aZz += i;
            }
            State state = this.aZs == this.aZt ? State.ROW_READY : !this.inf.finished() ? State.WAITING_FOR_INPUT : this.aZs > 0 ? State.ROW_READY : State.DONE;
            this.aZv = state;
            if (state != State.ROW_READY) {
                return false;
            }
            PS();
            return true;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    public void PS() {
    }

    public int PT() {
        throw new PngjException("not implemented");
    }

    public final void PU() {
        if (isDone()) {
            return;
        }
        this.aZv = State.DONE;
    }

    public final int PV() {
        return this.aZu;
    }

    public final void a(d dVar) {
        if (!this.aZC.equals(dVar.PE().asJ)) {
            new PngjException("Bad chunk inside IdatSet, id:" + dVar.PE().asJ + ", expected:" + this.aZC);
        }
        this.aZx = dVar;
        int i = this.aZA + 1;
        this.aZA = i;
        int i2 = this.aZB;
        if (i2 >= 0) {
            dVar.ew(i + i2);
        }
    }

    public final void b(byte[] bArr, int i, int i2) {
        this.aZy += i2;
        if (i2 <= 0 || this.aZv.isDone()) {
            return;
        }
        if (this.aZv == State.ROW_READY) {
            new PngjException("this should only be called if waitingForMoreInput");
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i, i2);
        if (!this.aZb) {
            PR();
            return;
        }
        while (PR()) {
            ex(PT());
            isDone();
        }
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aZv.isClosed()) {
                this.aZv = State.CLOSED;
            }
            if (!this.aZw || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void ex(int i) {
        this.aZs = 0;
        this.aZu++;
        if (i <= 0) {
            this.aZt = 0;
            PU();
        } else {
            if (this.inf.finished()) {
                this.aZt = 0;
                PU();
                return;
            }
            this.aZv = State.WAITING_FOR_INPUT;
            this.aZt = i;
            if (this.aZb) {
                return;
            }
            PR();
        }
    }

    public final boolean gN(String str) {
        if (this.aZv.isClosed()) {
            return false;
        }
        if (str.equals(this.aZC)) {
            return true;
        }
        if (!this.aZv.isDone()) {
            throw new PngjException(CtFAbx.B25kr6(CtFAbx.B3GDIM("Unexpected chunk ", str, " while "), this.aZC, " set is not done"));
        }
        if (!this.aZv.isClosed()) {
            close();
        }
        return false;
    }

    public final boolean isClosed() {
        return this.aZv.isClosed();
    }

    public final boolean isDone() {
        return this.aZv.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aZx.PE().asJ + " state=" + this.aZv + " rows=" + this.aZu + " bytes=" + this.aZy + "/" + this.aZz).toString();
    }
}
