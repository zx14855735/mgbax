package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca;

import android.app.Activity;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaau extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaaa {
    protected io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0 aaaaaaa0;

    public class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 {
        public aaaaaaaa(aaaaaaac aaaaaaacVar) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
        public void onError(int i, String str, JSONArray jSONArray) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
        public void onLoaded(List<io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new aaaaaaa0(it.next()));
            }
        }
    }

    public aaaaaaau(Activity activity) {
        super(activity);
    }

    public void initLoader() {
        if (this.aaaaaaa0 == null) {
            this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaa0(getContext(), 4);
        }
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, aaaaaaac aaaaaaacVar) {
        if (getContext() != null && dCloudAOLSlot != null) {
            initLoader();
            this.aaaaaaa0.aaaaaaaa(dCloudAOLSlot, new aaaaaaaa(aaaaaaacVar));
        } else if (aaaaaaacVar != null) {
            aaaaaaacVar.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
