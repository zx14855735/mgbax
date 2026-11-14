package OpB85q;

import ADYaiT.CtFAbx;
import Oay4Bh.BIYEnU;
import android.content.Context;
import android.view.SubMenu;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends AZkASS.AmA8tU {

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final Class f6723CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final int f6724CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final boolean f6725CTkVKb;

    public ASJ6gh(Context context, Class cls, int i, boolean z) {
        super(context);
        this.f6723CQhlFr = cls;
        this.f6724CSDoyG = i;
        this.f6725CTkVKb = z;
    }

    @Override // AZkASS.AmA8tU
    public final AZkASS.B25kr6 A2egSU(int i, int i2, int i3, CharSequence charSequence) {
        int size = this.f498B2KMhB.size() + 1;
        int i4 = this.f6724CSDoyG;
        if (size <= i4) {
            BJ7GGh();
            AZkASS.B25kr6 A2egSU2 = super.A2egSU(i, i2, i3, charSequence);
            BIYEnU();
            return A2egSU2;
        }
        String simpleName = this.f6723CQhlFr.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i4);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(CtFAbx.B25kr6(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override // AZkASS.AmA8tU, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        if (!this.f6725CTkVKb) {
            throw new UnsupportedOperationException(this.f6723CQhlFr.getSimpleName().concat(" does not support submenus"));
        }
        AZkASS.B25kr6 A2egSU2 = A2egSU(i, i2, i3, charSequence);
        BIYEnU bIYEnU = new BIYEnU(getContext(), this, A2egSU2, 1);
        A2egSU2.f534BNL6CD = bIYEnU;
        bIYEnU.setHeaderTitle(A2egSU2.f524B25kr6);
        return bIYEnU;
    }
}
