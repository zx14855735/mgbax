package KpHwm4;

import android.R;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import com.game.boy.activity.BniPrB;
import com.game.boy.activity.C2rE4F;
import com.game.boy.activity.LayoutEditor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends OOnEhG.A4TApA implements DialogInterface.OnClickListener, DialogInterface.OnKeyListener {

    /* renamed from: B25kr6, reason: collision with root package name */
    public int[] f4284B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public CharSequence[] f4285B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f4286B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public LayoutEditor f4287B4ZgIw;

    public final void B3GDIM(int i, int i2) {
        int i3 = this.f4286B3GDIM;
        int[] iArr = this.f4284B25kr6;
        if (i3 < iArr.length) {
            iArr[i3] = i;
            this.f4285B2KMhB[i3] = getContext().getString(i2);
            this.f4286B3GDIM++;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LayoutEditor layoutEditor;
        if (i < 0 || i >= this.f4286B3GDIM || (layoutEditor = this.f4287B4ZgIw) == null) {
            return;
        }
        int i2 = this.f4284B25kr6[i];
        if (i2 == 2131297582) {
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(layoutEditor);
            a4TApA.B2KMhB(2131886118);
            a4TApA.ARc23Z(new C2rE4F(layoutEditor, layoutEditor), new BniPrB(layoutEditor, 3));
            a4TApA.AaHO0E(2131886161, null);
            ADYaiT.AmA8tU A2egSU2 = a4TApA.A2egSU();
            A2egSU2.show();
            Window window = A2egSU2.getWindow();
            if (window != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                layoutEditor.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                window.setLayout(-1, displayMetrics.heightPixels);
                window.setGravity(17);
                return;
            }
            return;
        }
        if (i2 == 2131297624) {
            OOnEhG.A4TApA a4TApA2 = new OOnEhG.A4TApA(layoutEditor);
            a4TApA2.B2KMhB(2131886708);
            a4TApA2.AZOQYO(2131886709);
            a4TApA2.AmA8tU(R.string.yes, new BniPrB(layoutEditor, 1));
            a4TApA2.AaHO0E(R.string.no, null);
            a4TApA2.AMqCpz();
            return;
        }
        if (i2 != 2131297620) {
            if (i2 == 2131297617) {
                layoutEditor.finish();
            }
        } else {
            OOnEhG.A4TApA a4TApA3 = new OOnEhG.A4TApA(layoutEditor);
            a4TApA3.B2KMhB(2131886698);
            a4TApA3.AZOQYO(2131886699);
            a4TApA3.AmA8tU(R.string.yes, new BniPrB(layoutEditor, 2));
            a4TApA3.AaHO0E(R.string.no, null);
            a4TApA3.AMqCpz();
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 82 && keyEvent.getAction() == 0;
    }
}
