package COJEAR;

import android.graphics.Insets;
import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ExjC7D extends EwN40Z {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BV3sI0.A5SV6n f1740AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BV3sI0.A5SV6n f1741AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public BV3sI0.A5SV6n f1742B25kr6;

    public ExjC7D(FG7pZc fG7pZc, WindowInsets windowInsets) {
        super(fG7pZc, windowInsets);
        this.f1740AmA8tU = null;
        this.f1741AzWtSf = null;
        this.f1742B25kr6 = null;
    }

    @Override // COJEAR.F32kj0
    public BV3sI0.A5SV6n ASJ6gh() {
        Insets mandatorySystemGestureInsets;
        if (this.f1741AzWtSf == null) {
            mandatorySystemGestureInsets = this.f1735A5SV6n.getMandatorySystemGestureInsets();
            this.f1741AzWtSf = BV3sI0.A5SV6n.A5SV6n(mandatorySystemGestureInsets);
        }
        return this.f1741AzWtSf;
    }

    @Override // COJEAR.F32kj0
    public BV3sI0.A5SV6n AZOQYO() {
        Insets systemGestureInsets;
        if (this.f1740AmA8tU == null) {
            systemGestureInsets = this.f1735A5SV6n.getSystemGestureInsets();
            this.f1740AmA8tU = BV3sI0.A5SV6n.A5SV6n(systemGestureInsets);
        }
        return this.f1740AmA8tU;
    }

    @Override // COJEAR.F32kj0
    public BV3sI0.A5SV6n AaHO0E() {
        Insets tappableElementInsets;
        if (this.f1742B25kr6 == null) {
            tappableElementInsets = this.f1735A5SV6n.getTappableElementInsets();
            this.f1742B25kr6 = BV3sI0.A5SV6n.A5SV6n(tappableElementInsets);
        }
        return this.f1742B25kr6;
    }

    @Override // COJEAR.ErKPGd, COJEAR.F32kj0
    public FG7pZc AcNBzu(int i, int i2, int i3, int i4) {
        WindowInsets inset;
        inset = this.f1735A5SV6n.inset(i, i2, i3, i4);
        return FG7pZc.ASJ6gh(null, inset);
    }

    @Override // COJEAR.EsrwYR, COJEAR.F32kj0
    public void B2KMhB(BV3sI0.A5SV6n a5SV6n) {
    }
}
