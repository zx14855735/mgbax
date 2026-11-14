package BChYOn;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AmA8tU extends ARc23Z {

    /* renamed from: DuwtYk, reason: collision with root package name */
    public ArrayList f1275DuwtYk = new ArrayList();

    @Override // BChYOn.ARc23Z
    public void BV3sI0() {
        this.f1275DuwtYk.clear();
        super.BV3sI0();
    }

    @Override // BChYOn.ARc23Z
    public final void BpkvW3(B4ZgIw.A5SV6n a5SV6n) {
        super.BpkvW3(a5SV6n);
        int size = this.f1275DuwtYk.size();
        for (int i = 0; i < size; i++) {
            ((ARc23Z) this.f1275DuwtYk.get(i)).BpkvW3(a5SV6n);
        }
    }

    public void CkXcdM() {
        ArrayList arrayList = this.f1275DuwtYk;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ARc23Z aRc23Z = (ARc23Z) this.f1275DuwtYk.get(i);
            if (aRc23Z instanceof AmA8tU) {
                ((AmA8tU) aRc23Z).CkXcdM();
            }
        }
    }
}
