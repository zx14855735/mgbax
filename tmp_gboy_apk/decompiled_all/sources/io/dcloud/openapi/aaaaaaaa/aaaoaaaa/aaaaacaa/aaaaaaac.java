package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaacaa;

import android.app.Activity;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaac extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaaa {
    protected io.dcloud.openapi.aaaaaaaa.aaaoaaaa.d.aaaaaaa0 aaaaaaa0;

    public class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 {
        public aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
        public void onError(int i, String str, JSONArray jSONArray) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
        public void onLoaded(List<io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaacaa.aaaaaaaa(it.next()));
            }
        }
    }

    public aaaaaaac(Activity activity) {
        super(activity);
        this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.d.aaaaaaa0(activity);
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, aaaaaaao aaaaaaaoVar) {
        if (getContext() != null && dCloudAOLSlot != null) {
            this.aaaaaaa0.aaaaaaaa(dCloudAOLSlot, new aaaaaaaa(aaaaaaaoVar));
        } else if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
