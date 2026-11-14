package AaHO0E;

import android.view.View;
import android.widget.AdapterView;
import com.game.boy.activity.CheatsActivity;
import com.game.boy.emu.gba.Console;
import com.game.boy.viewUi.Material3AutoCompleteTextView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CmUvjW implements AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f701AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f702AlLFFp;

    public /* synthetic */ CmUvjW(int i, Object obj) {
        this.f701AcNBzu = i;
        this.f702AlLFFp = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        CharSequence convertSelectionToString;
        switch (this.f701AcNBzu) {
            case 0:
                CrfGsy crfGsy = (CrfGsy) this.f702AlLFFp;
                crfGsy.f709CmUvjW.setSelection(i);
                D07BeM d07BeM = crfGsy.f709CmUvjW;
                if (d07BeM.getOnItemClickListener() != null) {
                    d07BeM.performItemClick(view, i, crfGsy.f706Cd8JRx.getItemId(i));
                }
                crfGsy.dismiss();
                break;
            case 1:
                MkAsKS.AZkASS aZkASS = (MkAsKS.AZkASS) this.f702AlLFFp;
                aZkASS.AYUAbz((String) aZkASS.f5453B25kr6.getItem(i));
                break;
            case 2:
                ((Material3AutoCompleteTextView) this.f702AlLFFp).setSelectedValueByDisplay((String) adapterView.getItemAtPosition(i));
                break;
            case 3:
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) this.f702AlLFFp;
                FM663C fm663c = materialAutoCompleteTextView.f11896B25kr6;
                convertSelectionToString = materialAutoCompleteTextView.convertSelectionToString(i < 0 ? !fm663c.f845COJEAR.isShowing() ? null : fm663c.f823AmA8tU.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i));
                materialAutoCompleteTextView.setText(convertSelectionToString, false);
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !fm663c.f845COJEAR.isShowing() ? null : fm663c.f823AmA8tU.getSelectedView();
                        i = !fm663c.f845COJEAR.isShowing() ? -1 : fm663c.f823AmA8tU.getSelectedItemPosition();
                        j = !fm663c.f845COJEAR.isShowing() ? Long.MIN_VALUE : fm663c.f823AmA8tU.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(fm663c.f823AmA8tU, view, i, j);
                }
                fm663c.dismiss();
                break;
            default:
                CheatsActivity cheatsActivity = (CheatsActivity) this.f702AlLFFp;
                boolean z = !((KpHwm4.ASJ6gh) cheatsActivity.f10954B2KMhB.getItem(i)).f4289A2egSU;
                ADYaiT.DUi7mC dUi7mC = cheatsActivity.f10953B25kr6;
                KpHwm4.ASJ6gh aSJ6gh = (KpHwm4.ASJ6gh) ((ArrayList) dUi7mC.f240AmA8tU).get(i);
                if (aSJ6gh.f4289A2egSU != z) {
                    aSJ6gh.f4289A2egSU = z;
                    Iterator it = ((ArrayList) dUi7mC.f239AlLFFp).iterator();
                    while (it.hasNext()) {
                        Console console = (Console) it.next();
                        int i2 = 0;
                        for (int i3 = 0; i3 < i; i3++) {
                            i2 += ((KpHwm4.ASJ6gh) ((ArrayList) dUi7mC.f240AmA8tU).get(i3)).f4292ADYaiT.length;
                        }
                        for (int i4 = 0; i4 < aSJ6gh.f4292ADYaiT.length; i4++) {
                            console.enableCheat(i2 + i4, aSJ6gh.f4289A2egSU);
                        }
                    }
                }
                cheatsActivity.f10955B3GDIM = true;
                break;
        }
    }
}
