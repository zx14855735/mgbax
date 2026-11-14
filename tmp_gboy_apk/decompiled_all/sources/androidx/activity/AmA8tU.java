package androidx.activity;

import MOpbMP.BmvVmW;
import java.util.ListIterator;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends RXb0Sz.ASJ6gh implements Function1 {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f7956AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f7957AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmA8tU(int i, Object obj) {
        super(1);
        this.f7956AlLFFp = i;
        this.f7957AmA8tU = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object obj2;
        Object obj3;
        switch (this.f7956AlLFFp) {
            case 0:
                RXb0Sz.ARc23Z.AMqCpz((A4TApA) obj, "backEvent");
                OnBackPressedDispatcher onBackPressedDispatcher = (OnBackPressedDispatcher) this.f7957AmA8tU;
                RD2OKB.ARc23Z aRc23Z = onBackPressedDispatcher.f7981A4TApA;
                ListIterator listIterator = aRc23Z.listIterator(aRc23Z.A2egSU());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj2 = listIterator.previous();
                        if (((BmvVmW) obj2).f5056A2egSU) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                onBackPressedDispatcher.f7982A5SV6n = (BmvVmW) obj2;
                return R8Rbcg.AMqCpz.f7833A5SV6n;
            case 1:
                RXb0Sz.ARc23Z.AMqCpz((A4TApA) obj, "backEvent");
                RD2OKB.ARc23Z aRc23Z2 = ((OnBackPressedDispatcher) this.f7957AmA8tU).f7981A4TApA;
                ListIterator listIterator2 = aRc23Z2.listIterator(aRc23Z2.A2egSU());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        obj3 = listIterator2.previous();
                        if (((BmvVmW) obj3).f5056A2egSU) {
                        }
                    } else {
                        obj3 = null;
                    }
                }
                return R8Rbcg.AMqCpz.f7833A5SV6n;
            default:
                return obj == ((RD2OKB.A5SV6n) this.f7957AmA8tU) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
