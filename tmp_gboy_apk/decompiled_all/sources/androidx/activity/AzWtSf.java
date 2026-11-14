package androidx.activity;

import MOpbMP.BmvVmW;
import androidx.lifecycle.CQhlFr;
import androidx.lifecycle.D07BeM;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf extends RXb0Sz.ASJ6gh implements Function0 {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f7958AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f7959AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AzWtSf(int i, Object obj) {
        super(0);
        this.f7958AlLFFp = i;
        this.f7959AmA8tU = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object obj;
        switch (this.f7958AlLFFp) {
            case 0:
                ((OnBackPressedDispatcher) this.f7959AmA8tU).A4TApA();
                return R8Rbcg.AMqCpz.f7833A5SV6n;
            case 1:
                OnBackPressedDispatcher onBackPressedDispatcher = (OnBackPressedDispatcher) this.f7959AmA8tU;
                RD2OKB.ARc23Z aRc23Z = onBackPressedDispatcher.f7981A4TApA;
                ListIterator listIterator = aRc23Z.listIterator(aRc23Z.A2egSU());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        if (((BmvVmW) obj).f5056A2egSU) {
                        }
                    } else {
                        obj = null;
                    }
                }
                onBackPressedDispatcher.f7982A5SV6n = null;
                return R8Rbcg.AMqCpz.f7833A5SV6n;
            case 2:
                ((OnBackPressedDispatcher) this.f7959AmA8tU).A4TApA();
                return R8Rbcg.AMqCpz.f7833A5SV6n;
            default:
                return CQhlFr.AMqCpz((D07BeM) this.f7959AmA8tU);
        }
    }
}
