package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e;

import android.app.Activity;
import com.sigmob.sdk.videoplayer.AMqCpz;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa {
    protected io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 aaaoaaaa;

    public aaaaaaa0(Activity activity, int i) {
        super(activity);
        this.aaaaaaac = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaao(int i, String str, JSONArray jSONArray) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 aaaaaaa0Var = this.aaaoaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onError(i, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaau(List list) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 aaaaaaa0Var = this.aaaoaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onLoaded(list);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa
    public void aaaaaaaa(int i, String str, JSONArray jSONArray) {
        aaaaaaau.aaaaaaa0("uniAd-loadError", "code:" + i + ";message:" + str + ";detail:" + String.valueOf(jSONArray));
        MainHandlerUtil.getMainHandler().post(new FZu94u.A2egSU(this, i, str, jSONArray, 3));
    }

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

    public void aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        aaaaaaaa(dCloudAOLSlot);
        this.aaaoaaaa = aaaaaaa0Var;
        aaaaaaac.aaaaaaaa().post(this);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa
    public void aaaaaaao(List list) {
        MainHandlerUtil.getMainHandler().post(new AMqCpz(this, 1, aaaaaaac(list)));
    }
}
