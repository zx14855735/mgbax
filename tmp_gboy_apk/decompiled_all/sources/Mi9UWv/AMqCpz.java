package Mi9UWv;

import android.text.Editable;
import android.text.TextWatcher;
import com.game.boy.viewUi.AutoSaveTextInputEditText;
import com.google.android.material.search.SearchView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements TextWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5396AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f5397AlLFFp;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f5396AcNBzu = i;
        this.f5397AlLFFp = obj;
    }

    private final void A2egSU(Editable editable) {
    }

    private final void A4TApA(Editable editable) {
    }

    private final void A5SV6n(Editable editable) {
    }

    private final void ADYaiT(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void AMqCpz(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void ARc23Z(int i, int i2, int i3, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.f5396AcNBzu;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.f5396AcNBzu;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        switch (this.f5396AcNBzu) {
            case 0:
                ASJ6gh aSJ6gh = (ASJ6gh) this.f5397AlLFFp;
                if (aSJ6gh.f5413BJ7GGh != null) {
                    if (!charSequence.toString().isEmpty()) {
                        A4TApA a4TApA = aSJ6gh.f5413BJ7GGh;
                        ArrayList arrayList = aSJ6gh.f5404B25kr6;
                        String charSequence2 = charSequence.toString();
                        ArrayList arrayList2 = new ArrayList();
                        if (charSequence2.isEmpty()) {
                            arrayList2.addAll(arrayList);
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                MTKlkd.AMqCpz aMqCpz = (MTKlkd.AMqCpz) it.next();
                                if (Integer.toString(aMqCpz.ADYaiT()).contains(charSequence2)) {
                                    arrayList2.add(aMqCpz);
                                }
                            }
                        }
                        Collections.sort(arrayList2, ASJ6gh.f5403C2rE4F);
                        a4TApA.f5388AcNBzu = arrayList2;
                        a4TApA.notifyDataSetChanged();
                        break;
                    } else {
                        A4TApA a4TApA2 = aSJ6gh.f5413BJ7GGh;
                        a4TApA2.f5388AcNBzu = aSJ6gh.f5404B25kr6;
                        a4TApA2.notifyDataSetChanged();
                        break;
                    }
                }
                break;
            case 1:
                AutoSaveTextInputEditText autoSaveTextInputEditText = (AutoSaveTextInputEditText) this.f5397AlLFFp;
                LLYwnm.AMqCpz aMqCpz2 = autoSaveTextInputEditText.f11145BChYOn;
                if (aMqCpz2 != null) {
                    autoSaveTextInputEditText.removeCallbacks(aMqCpz2);
                }
                LLYwnm.AMqCpz aMqCpz3 = new LLYwnm.AMqCpz(15, autoSaveTextInputEditText);
                autoSaveTextInputEditText.f11145BChYOn = aMqCpz3;
                autoSaveTextInputEditText.postDelayed(aMqCpz3, 500L);
                break;
            default:
                ((SearchView) this.f5397AlLFFp).f11770BI9f7h.setVisibility(charSequence.length() > 0 ? 0 : 8);
                break;
        }
    }
}
