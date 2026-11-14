package com.kwad.sdk.core.j;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b implements c {
    private boolean aRK = false;
    private boolean SF = false;
    private boolean SG = false;

    public abstract void aJ();

    public abstract void aK();

    @Override // com.kwad.sdk.core.j.c
    public final void bs() {
        this.aRK = true;
        if (this.SG) {
            return;
        }
        aJ();
        this.SG = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        if (this.aRK && !this.SF) {
            aK();
            this.SF = true;
        }
    }
}
