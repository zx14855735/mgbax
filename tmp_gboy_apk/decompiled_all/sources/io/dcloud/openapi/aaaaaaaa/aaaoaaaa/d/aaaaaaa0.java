package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.d;

import android.app.Activity;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0 {
    public aaaaaaa0(Activity activity) {
        super(activity, 10);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0
    public List aaaaaaac(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new aaaaaaaa((DCBaseAOL) it.next(), aaaaaaaa()));
            }
        }
        return arrayList;
    }
}
