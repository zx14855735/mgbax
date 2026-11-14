package C4FrIb;

import MOpbMP.COJEAR;
import MOpbMP.CTkVKb;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1547AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1548AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f1549AmA8tU;

    public /* synthetic */ A4TApA(int i, int i2, Object obj) {
        this.f1547AcNBzu = i2;
        this.f1549AmA8tU = obj;
        this.f1548AlLFFp = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1547AcNBzu) {
            case 0:
                BTvldC.B2KMhB b2KMhB = ((BV3sI0.ASJ6gh) this.f1549AmA8tU).f1489A2egSU;
                if (b2KMhB != null) {
                    b2KMhB.A4TApA(this.f1548AlLFFp);
                    break;
                }
                break;
            case 1:
                ((De4eam.AlLFFp) this.f1549AmA8tU).smoothScrollToPosition(this.f1548AlLFFp);
                break;
            case 2:
                CTkVKb.AcNBzu(((COJEAR) this.f1549AmA8tU).f5093AmA8tU.f5107B2KMhB, 1, this.f1548AlLFFp);
                break;
            case 3:
                CTkVKb.AcNBzu(((COJEAR) this.f1549AmA8tU).f5093AmA8tU.f5107B2KMhB, 2, this.f1548AlLFFp);
                break;
            case 4:
                ((OpB85q.ARc23Z) this.f1549AmA8tU).AZkASS(this.f1548AlLFFp);
                break;
            case 5:
                ((PSeUZ5.ADYaiT) this.f1549AmA8tU).f7188B4ZgIw.BIYEnU(this.f1548AlLFFp, 4);
                break;
            case 6:
                ArrayList arrayList = (ArrayList) this.f1549AmA8tU;
                int size = arrayList.size();
                int i = 0;
                if (this.f1548AlLFFp == 1) {
                    while (i < size) {
                        ((androidx.emoji2.text.AaHO0E) arrayList.get(i)).A4TApA();
                        i++;
                    }
                    break;
                } else {
                    while (i < size) {
                        ((androidx.emoji2.text.AaHO0E) arrayList.get(i)).A2egSU();
                        i++;
                    }
                    break;
                }
            case 7:
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f1549AmA8tU;
                emulatorActivity.BChYOn((Console) emulatorActivity.f11004BPw6Q8.f11101A4TApA.get(this.f1548AlLFFp));
                break;
            default:
                ((com.google.android.material.datepicker.AlLFFp) this.f1549AmA8tU).f11605B7CMnp.smoothScrollToPosition(this.f1548AlLFFp);
                break;
        }
    }

    public A4TApA(int i, De4eam.AlLFFp alLFFp) {
        this.f1547AcNBzu = 1;
        this.f1548AlLFFp = i;
        this.f1549AmA8tU = alLFFp;
    }

    public A4TApA(List list, int i, Throwable th) {
        this.f1547AcNBzu = 6;
        JrXYwF.A4TApA.B4ZgIw(list, "initCallbacks cannot be null");
        this.f1549AmA8tU = new ArrayList(list);
        this.f1548AlLFFp = i;
    }

    public A4TApA(PSeUZ5.ADYaiT aDYaiT) {
        this.f1547AcNBzu = 5;
        this.f1549AmA8tU = aDYaiT;
        this.f1548AlLFFp = -1;
    }
}
