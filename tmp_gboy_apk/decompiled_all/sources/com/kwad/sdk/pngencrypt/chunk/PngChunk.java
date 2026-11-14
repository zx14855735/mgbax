package com.kwad.sdk.pngencrypt.chunk;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aZU;
    public final String asJ;
    public final boolean baU;
    public final boolean baV;
    public final boolean baW;
    protected d baX;
    private boolean baY = false;
    protected int baZ = -1;

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        static {
            KWEl();
        }

        private static /* synthetic */ void KWEl() {
            char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 158);
            }
            String str = new String(charArray);
            char[] charArray2 = "ýò÷ð÷ê".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 158);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.asJ = str;
        this.aZU = kVar;
        this.baU = b.gP(str);
        this.baV = b.gQ(str);
        this.baW = b.gR(str);
    }

    private long Qr() {
        d dVar = this.baX;
        if (dVar != null) {
            return dVar.Qr();
        }
        return -1L;
    }

    private int Qt() {
        d dVar = this.baX;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.baX = dVar;
    }

    public final void eH(int i) {
        this.baZ = i;
    }

    public String toString() {
        return "chunk id= " + this.asJ + " (len=" + Qt() + " offset=" + Qr() + ")";
    }
}
