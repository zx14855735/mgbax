package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a;

import android.app.Activity;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends aaaaaaao implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa {
    private int aacaaaaa;
    private int acaaaaaa;

    public aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.acaaaaaa = 0;
        this.aacaaaaa = 0;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaa0(int i) {
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(int i) {
        int i2 = this.aaaaaoaa;
        if (i < i2 || i2 < 0) {
            this.aaaaaoaa = i;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaac() {
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public int aaaaaaao() {
        return super.aaaaaaao();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaau(int i) {
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaav() {
        this.aoaaaaaa = true;
        if (this.aaaaaaa0) {
            return;
        }
        aaaaaeaa();
        if (this.aaaaaaan.isEmpty()) {
            aoaaaaaa();
        } else {
            aaaoaaaa();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa
    public void aaaeaaaa() {
        List list = this.aaaaeaaa;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((DCBaseAOL) it.next()).biddingSuccess(this.acaaaaaa, this.aacaaaaa);
            }
        }
        DCBaseAOL dCBaseAOL = this.aaaeaaaa;
        if (dCBaseAOL != null) {
            dCBaseAOL.biddingSuccess(this.acaaaaaa, this.aacaaaaa);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao
    public void aaaoaaaa() {
        if (aaaaeaaa() || this.aoaaaaaa) {
            if (!aaaaaaea()) {
                if (this.aaaaaaan.size() <= 0) {
                    aoaaaaaa();
                    return;
                }
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaan);
                DCBaseAOL dCBaseAOL = (DCBaseAOL) this.aaaaaaan.remove(0);
                this.aaaeaaaa = dCBaseAOL;
                this.aaaaaaav.remove(dCBaseAOL);
                this.acaaaaaa = this.aaaeaaaa.aeaaaaaa();
                if (this.aaaaaaan.size() >= 1) {
                    DCBaseAOL dCBaseAOL2 = (DCBaseAOL) this.aaaaaaan.remove(0);
                    this.aaaaaaav.remove(dCBaseAOL2);
                    int aeaaaaaa = dCBaseAOL2.aeaaaaaa();
                    this.aacaaaaa = aeaaaaaa;
                    dCBaseAOL2.biddingFail(this.acaaaaaa, aeaaaaaa, 2);
                    Iterator it = this.aaaaaaan.iterator();
                    while (it.hasNext()) {
                        ((DCBaseAOL) it.next()).biddingFail(this.acaaaaaa, this.aacaaaaa, 2);
                    }
                }
                Iterator it2 = this.aaaaaaae.iterator();
                while (it2.hasNext()) {
                    ((DCBaseAOLLoader) it2.next()).biddingFail(this.acaaaaaa, this.aacaaaaa, 3);
                }
                aaoaaaaa();
                return;
            }
            if (this.aaaaaaeo.size() <= 0) {
                aoaaaaaa();
                return;
            }
            Iterator it3 = this.aaaaaaeo.values().iterator();
            ArrayList arrayList = new ArrayList();
            while (it3.hasNext()) {
                arrayList.addAll((Collection) it3.next());
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(arrayList);
            aaaaaaau.aaaaaaaa("level load success,total ads:" + arrayList.size());
            if (arrayList.size() > this.aaaoaaaa.getCount()) {
                List subList = arrayList.subList(0, this.aaaoaaaa.getCount());
                this.aaaaeaaa = subList;
                this.acaaaaaa = ((DCBaseAOL) subList.get(0)).aeaaaaaa();
                List subList2 = arrayList.subList(this.aaaoaaaa.getCount(), arrayList.size());
                this.aacaaaaa = ((DCBaseAOL) subList2.get(0)).aeaaaaaa();
                Iterator it4 = subList2.iterator();
                while (it4.hasNext()) {
                    ((DCBaseAOL) it4.next()).biddingFail(this.acaaaaaa, this.aacaaaaa, 2);
                }
            } else {
                this.acaaaaaa = ((DCBaseAOL) arrayList.get(0)).aeaaaaaa();
                this.aaaaeaaa = arrayList;
            }
            aaoaaaaa();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa
    public void aaaaaaac(int i) {
        DCBaseAOL dCBaseAOL = this.aaaeaaaa;
        if (dCBaseAOL != null) {
            dCBaseAOL.biddingFail(i, this.acaaaaaa, 2);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa.InterfaceC0537aaaaaaaa
    public void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, List list, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar) {
        if (this.aoaaaaaa || this.aaaaaaa0) {
            dCBaseAOLLoader.biddingFail(this.acaaaaaa, this.aacaaaaa, 1);
        }
        super.aaaaaaaa(dCBaseAOLLoader, list, aaaaaaaoVar);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa.InterfaceC0537aaaaaaaa
    public void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar) {
        if (this.aoaaaaaa || this.aaaaaaa0) {
            if (aaaaaaaoVar.aaaaaaaa() == -5000) {
                dCBaseAOLLoader.biddingFail(this.acaaaaaa, this.aacaaaaa, 1);
            } else {
                dCBaseAOLLoader.biddingFail(this.acaaaaaa, this.aacaaaaa, 3);
            }
        }
        super.aaaaaaaa(dCBaseAOLLoader, aaaaaaaoVar);
    }
}
