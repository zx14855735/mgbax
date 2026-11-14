package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a;

import J3FDQU.A2egSU;
import android.app.Activity;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa {
    private aaaaaaao aaaaaaaa;
    private aaaaaaaa aaaaaaac;
    private int aaaaaaae;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaav;
    private int aaaaaaeo;
    protected final Activity aeaaaaaa;
    protected final DCloudAOLSlot eaaaaaaa;
    private boolean aaaaaaa0 = false;
    private boolean aaaaaaao = false;
    private boolean aaaaaaau = false;
    private boolean aaaaaaan = false;
    private boolean aaaeaaaa = false;
    private boolean aaaaeaaa = false;
    private boolean aaaaaeaa = false;
    private boolean aaaaaaea = false;
    private final List aoaaaaaa = new ArrayList();

    public aaaaaaa0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        this.eaaaaaaa = dCloudAOLSlot;
        this.aeaaaaaa = activity;
    }

    private void aaaaaaea() {
        boolean z = this.aaaaaaau;
        if (z && this.aaaaaaa0) {
            if (aaaaaeaa()) {
                aaaaaaaa.C0540aaaaaaaa aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.eaaaaaaa.getCount(), this.aaaaaaac.aaaaaaeo(), this.aaaaaaaa.aaaaaaeo());
                if (aaaaaaaa == null) {
                    eaaaaaaa();
                    return;
                }
                this.aaaaeaaa = true;
                for (DCBaseAOL dCBaseAOL : aaaaaaaa.aaaaaaac) {
                    if (dCBaseAOL.isSlotSupportBidding()) {
                        dCBaseAOL.biddingSuccess(aaaaaaaa.aaaaaaa0, aaaaaaaa.aaaaaaao);
                    }
                }
                this.aoaaaaaa.addAll(aaaaaaaa.aaaaaaac);
            } else if (this.aaaaaaac.aaaaaaao() >= this.aaaaaaaa.aaaaaaao()) {
                this.aaaeaaaa = true;
            } else {
                this.aaaaeaaa = true;
                this.aaaaaaac.aaaaaaac(this.aaaaaaaa.aaaaaaao());
            }
            aeaaaaaa();
            return;
        }
        if (z && this.aaaaaaao) {
            this.aaaeaaaa = true;
            this.aoaaaaaa.addAll(this.aaaaaaac.aaaaaaeo());
            aeaaaaaa();
            return;
        }
        boolean z2 = this.aaaaaaan;
        if (z2 && this.aaaaaaa0) {
            this.aaaaeaaa = true;
            this.aoaaaaaa.addAll(this.aaaaaaaa.aaaaaaeo());
            aeaaaaaa();
        } else if (z2 && this.aaaaaaao) {
            eaaaaaaa();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public DCBaseAOLLoader aaaaaaa0() {
        return null;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(aaaaaaac aaaaaaacVar) {
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaac() {
        return this.aaaeaaaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public List aaaaaaae() {
        ArrayList arrayList = new ArrayList();
        aaaaaaaa aaaaaaaaVar = this.aaaaaaac;
        if (aaaaaaaaVar != null) {
            arrayList.addAll(aaaaaaaaVar.aaaaaaae());
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar != null) {
            arrayList.addAll(aaaaaaaoVar.aaaaaaae());
        }
        return arrayList;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public int aaaaaaan() {
        return this.aaaaaaae;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public int aaaaaaao() {
        if (aaaaaeaa()) {
            if (this.aoaaaaaa.isEmpty()) {
                return -1;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aoaaaaaa);
            return ((DCBaseAOL) A2egSU.AlLFFp(this.aoaaaaaa, 1)).aeaaaaaa();
        }
        if (this.aaaeaaaa) {
            return this.aaaaaaac.aaaaaaao();
        }
        if (this.aaaaeaaa) {
            return this.aaaaaaaa.aaaaaaao();
        }
        return -1;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaau(int i) {
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaav() {
        this.aaaaaeaa = true;
        aaaaaaaa aaaaaaaaVar = this.aaaaaaac;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaav();
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.aaaaaaav();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public List aaaaaaeo() {
        if (aaaaaeaa()) {
            return this.aoaaaaaa;
        }
        if (this.aaaeaaaa) {
            return this.aaaaaaac.aaaaaaeo();
        }
        if (this.aaaaeaaa) {
            return this.aaaaaaaa.aaaaaaeo();
        }
        return null;
    }

    public boolean aaaaaeaa() {
        int i = this.aaaaaaeo;
        return i == 10 || i == 4 || i == 5;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaeaaa() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        return aaaaaaaoVar != null && this.aaaaaaac != null && aaaaaaaoVar.aaaaeaaa() && this.aaaaaaac.aaaaeaaa();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa
    public void aaaeaaaa() {
        if (aaaaaaac()) {
            this.aaaaaaac.aaaeaaaa();
        }
    }

    public void aeaaaaaa() {
        if (this.aaaaaaea) {
            return;
        }
        this.aaaaaaea = true;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar = this.aaaaaaav;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
        }
    }

    public void eaaaaaaa() {
        if (this.aaaaaaea) {
            return;
        }
        this.aaaaaaea = true;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar = this.aaaaaaav;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaa0(this);
        }
    }

    public String toString() {
        return "Bidding:" + this.aaaaaaac.toString() + ",Usual:" + this.aaaaaaaa.toString();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaa0(int i) {
        return true;
    }

    public void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        this.aaaaaaaa = aaaaaaaoVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa
    public void aaaaaaac(int i) {
        if (aaaaaaac()) {
            this.aaaaaaac.aaaaaaac(i);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaau() {
        if (this.aaaeaaaa) {
            this.aaaaaaac.aaaaaaau();
        }
        if (this.aaaaeaaa) {
            this.aaaaaaaa.aaaaaaau();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var) {
        if (aaaaaaa0Var == this.aaaaaaaa) {
            this.aaaaaaao = true;
        } else if (aaaaaaa0Var == this.aaaaaaac) {
            this.aaaaaaan = true;
        }
        aaaaaaea();
    }

    public void aaaaaaaa(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaac = aaaaaaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaav = aaaaaaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa() {
        if (this.aaaaaeaa) {
            eaaaaaaa();
            return;
        }
        aaaaaaaa aaaaaaaaVar = this.aaaaaaac;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
            this.aaaaaaac.aaaaaaaa();
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.aaaaaaaa(this);
            this.aaaaaaaa.aaaaaaaa();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(int i) {
        this.aaaaaaae = i;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaao(int i) {
        this.aaaaaaeo = i;
        aaaaaaaa aaaaaaaaVar = this.aaaaaaac;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaao(i);
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.aaaaaaao(i);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(String str) {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaac;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(str);
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.aaaaaaaa(str);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var) {
        if (aaaaaaa0Var == this.aaaaaaaa) {
            this.aaaaaaa0 = true;
        } else if (aaaaaaa0Var == this.aaaaaaac) {
            this.aaaaaaau = true;
        }
        aaaaaaea();
    }
}
