package RD2OKB;

import java.util.AbstractList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ADYaiT extends AbstractList implements List {
    public abstract int A2egSU();

    public abstract Object A4TApA(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return A4TApA(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return A2egSU();
    }
}
