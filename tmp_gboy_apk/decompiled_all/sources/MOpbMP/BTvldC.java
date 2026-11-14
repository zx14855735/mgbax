package MOpbMP;

import L2suez.ASJ6gh;
import android.text.Editable;
import android.text.TextWatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BTvldC implements TextWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5052AcNBzu;

    public BTvldC(BpkvW3 bpkvW3) {
        this.f5052AcNBzu = bpkvW3;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        BpkvW3 bpkvW3 = this.f5052AcNBzu;
        if (bpkvW3.f5068B2KMhB.f4369ADYaiT.equals(charSequence.toString().trim())) {
            return;
        }
        String trim = charSequence.toString().trim();
        if (trim.isEmpty()) {
            return;
        }
        L2suez.AaHO0E aaHO0E = bpkvW3.f5068B2KMhB;
        String trim2 = charSequence.toString().trim();
        aaHO0E.getClass();
        if (trim2 == null) {
            trim2 = "";
        }
        aaHO0E.f4369ADYaiT = trim2;
        bpkvW3.f5068B2KMhB.AMqCpz.clear();
        bpkvW3.f5068B2KMhB.AMqCpz.add(new LLiCI0.CTkVKb("已有游戏"));
        ArrayList arrayList = BpkvW3.f5062CNPG0E;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) it.next();
                File file = a2egSU.f4366A2egSU;
                if (file != null) {
                    String name = file.getName();
                    Locale locale = Locale.ROOT;
                    String replace = name.toLowerCase(locale).replace(LCJm5h.ARc23Z.ASJ6gh(file.getName()), "");
                    if (replace.contains(trim.toLowerCase(locale))) {
                        File file2 = a2egSU.f4367A4TApA;
                        MTKlkd.ARc23Z aRc23Z = new MTKlkd.ARc23Z();
                        aRc23Z.AzWtSf(replace);
                        aRc23Z.B4ZgIw();
                        aRc23Z.f5248BNL6CD = file.getAbsolutePath();
                        aRc23Z.B2KMhB(LCJm5h.ARc23Z.ASJ6gh(file.getName()));
                        aRc23Z.AmA8tU(file2 != null ? file2.getAbsolutePath() : null);
                        aRc23Z.B3GDIM(3);
                        bpkvW3.f5068B2KMhB.AMqCpz.add(aRc23Z);
                    }
                }
            }
        }
        bpkvW3.f5071B7CMnp.notifyDataSetChanged();
    }
}
