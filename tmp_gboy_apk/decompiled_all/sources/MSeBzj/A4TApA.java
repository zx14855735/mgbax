package MSeBzj;

import L2suez.ASJ6gh;
import android.text.Editable;
import android.text.TextWatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements TextWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f5180AcNBzu;

    public A4TApA(ASJ6gh aSJ6gh) {
        this.f5180AcNBzu = aSJ6gh;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String lowerCase = charSequence.toString().trim().toLowerCase(Locale.ROOT);
        ASJ6gh aSJ6gh = this.f5180AcNBzu;
        ArrayList arrayList = aSJ6gh.f5187AlLFFp;
        arrayList.clear();
        Iterator it = aSJ6gh.f5186AcNBzu.iterator();
        while (it.hasNext()) {
            ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) it.next();
            File file = a2egSU.f4366A2egSU;
            if (file != null && (lowerCase.isEmpty() || file.getName().toLowerCase(Locale.ROOT).contains(lowerCase))) {
                arrayList.add(a2egSU);
            }
        }
        Collections.sort(arrayList, new A5SV6n());
        aSJ6gh.f5189AzWtSf.notifyDataSetChanged();
    }
}
