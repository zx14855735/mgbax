package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa;

import C4FrIb.A5SV6n;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.czhj.sdk.common.Constants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa extends aaaaaaao implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa {
    private final List aaaaaaae;
    private final List aaaaaaan;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaav;
    private long aaaaaaea;
    private boolean aaaaaaeo;
    private final int aaaaaeaa;
    private final int aaaaeaaa;
    private final Handler aaaeaaaa;
    private Set aaoaaaaa;
    private boolean aeaaaaaa;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0 aoaaaaaa;
    private String eaaaaaaa;

    public class aaaaaaa0 extends Handler {
        public aaaaaaa0(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            aaaaaaaa.this.aaaeaaaa();
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public interface InterfaceC0537aaaaaaaa {
        void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar);

        void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, List list, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar);
    }

    public aaaaaaaa(Activity activity) {
        super(activity);
        this.aaaaaaan = new ArrayList();
        this.aaaaaaae = new ArrayList();
        this.aaaaaaeo = false;
        this.aaaaeaaa = 3;
        this.aaaaaeaa = 18000;
        this.aaaaaaea = 0L;
        this.eaaaaaaa = "";
        this.aeaaaaaa = false;
        this.aaoaaaaa = new HashSet();
        this.aaaeaaaa = new aaaaaaa0(aaaaaaac.aaaaaaaa().getLooper());
    }

    private void aaaaaaan() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.aaaaaaea;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.aaaaaaae.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0) it.next()).aaaaaaae());
        }
        JSONArray jSONArray = new JSONArray();
        if (arrayList.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao) obj;
                if (aaaaaaaoVar.aaaaaaau()) {
                    if (this.aaoaaaaa.contains(aaaaaaaoVar.aaaaaaao())) {
                        aaaaaaaoVar.aaaaaaan();
                    }
                    if (aaaaaaaoVar.aaaaaaac() == 0) {
                        jSONArray.put(aaaaaaaoVar.aaaaaaa0());
                    }
                    jSONArray2.put(aaaaaaaoVar.aaaaaaae());
                }
            }
            aaaaaaau.aaaaaaa0("collection data:load time:" + elapsedRealtime);
            aaaaaaaa(this.aoaaaaaa.aaaaaaau(), this.aaaaaaa0.getAdpid(), this.aoaaaaaa.aaaaaaan() ? "1" : Constants.FAIL, this.aaaaaaa0.getEI(), jSONArray2, elapsedRealtime);
        }
        aaaaaaaa(jSONArray);
    }

    private void aaaaaaav() {
        this.aaaaaaa0.setRID(this.eaaaaaaa);
        long aaaaaaac = this.aoaaaaaa.aaaaaaac() - (SystemClock.elapsedRealtime() - this.aaaaaaea);
        if (aaaaaaac <= 0) {
            aaaaaaao(-5005, AOLErrorUtil.getErrorMsg(-5018));
            return;
        }
        this.aaaeaaaa.removeMessages(3);
        this.aaaeaaaa.sendEmptyMessageDelayed(3, aaaaaaac);
        if (this.aaaaaaac != this.aoaaaaaa.aaaaaaau() && (this.aaaaaaac != 4 || this.aoaaaaaa.aaaaaaau() != 5)) {
            aaaaaaao(-5011, AOLErrorUtil.getErrorMsg(-5011));
            return;
        }
        List aaaaaaao = this.aoaaaaaa.aaaaaaao();
        if (aaaaaaao == null || aaaaaaao.isEmpty()) {
            aaaaaaao(-5019, AOLErrorUtil.getErrorMsg(-5019));
            return;
        }
        if (aaaaaaaa(this.aoaaaaaa, aaaaaaao)) {
            return;
        }
        aaaaaaau.aaaaaaaa("level load finish.total:" + this.aaaaaaan.size());
        Iterator it = this.aaaaaaan.iterator();
        while (it.hasNext()) {
            aaaaaaau.aaaaaaaa(((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0) it.next()).toString());
        }
        aaaaaaeo();
    }

    private void aaaaaaeo() {
        if (this.aaaaaaan.size() <= 0 || this.aaaaaaeo) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var = this.aaaaaaav;
            if (aaaaaaa0Var != null) {
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa) aaaaaaa0Var).aaaeaaaa();
                aaaaaaa0(this.aaaaaaav.aaaaaaeo());
            }
            aaaaaaan();
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var2 = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0) this.aaaaaaan.remove(0);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var3 = this.aaaaaaav;
        if (aaaaaaa0Var3 == null || aaaaaaa0Var3.aaaaaaao() <= 0) {
            this.aaaaaaae.add(aaaaaaa0Var2);
            aaaaaaa0Var2.aaaaaaaa(this.eaaaaaaa);
            aaaaaaa0Var2.aaaaaaaa();
            return;
        }
        aaaaaaau.aaaaaaaa("is necessary to load next:" + aaaaaaa0Var2.aaaaaaa0(this.aaaaaaav.aaaaaaao()) + ",next level:" + aaaaaaa0Var2.aaaaaaan());
        if (!aaaaaaa0Var2.aaaaaaa0(this.aaaaaaav.aaaaaaao())) {
            aaaaaaeo();
            return;
        }
        aaaaaaa0Var2.aaaaaaau(this.aaaaaaav.aaaaaaao());
        this.aaaaaaae.add(aaaaaaa0Var2);
        aaaaaaa0Var2.aaaaaaaa(this.eaaaaaaa);
        aaaaaaa0Var2.aaaaaaaa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaeaaaa() {
        this.aaaaaaeo = true;
        aaaaaaau.aaaaaaa0("this slot:time out");
        if (this.aaaaaaae.isEmpty()) {
            aaaaaaaa(new JSONArray());
            return;
        }
        for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var : this.aaaaaaae) {
            if (!aaaaaaa0Var.aaaaeaaa()) {
                aaaaaaa0Var.aaaaaaav();
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public DCBaseAOLLoader aaaaaaa0() {
        return null;
    }

    public abstract void aaaaaaaa(int i, String str, JSONArray jSONArray);

    public boolean aaaaaaae() {
        int i = this.aaaaaaac;
        return i == 10 || i == 4 || i == 5;
    }

    public abstract void aaaaaaao(List list);

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0
    public boolean aaaaaaao() {
        return 1 == this.aoaaaaaa.aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao, java.lang.Runnable
    public void run() {
        this.eaaaaaaa = UUID.randomUUID().toString();
        this.aaaaaaae.clear();
        this.aaaaaaan.clear();
        this.aaoaaaaa.clear();
        this.aaaaaaav = null;
        this.aaaaaaeo = false;
        this.aeaaaaaa = false;
        this.aaaeaaaa.sendEmptyMessageDelayed(3, 18000L);
        this.aaaaaaea = SystemClock.elapsedRealtime();
        super.run();
    }

    private void aaaaaaao(int i, String str) {
        aaaaaaa0(i, str, null);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var) {
        aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0 aaaaaaa0Var) {
        this.aoaaaaaa = aaaaaaa0Var;
        this.aaaaaaa0.setAdpid(aaaaaaa0Var.aaaaaaaa());
        aaaaaaav();
    }

    private void aaaaaaa0(int i, String str, JSONArray jSONArray) {
        if (this.aeaaaaaa) {
            return;
        }
        this.aeaaaaaa = true;
        aaaaaaau.aaaaaaa0("this slot:all fail");
        this.aaaeaaaa.removeMessages(3);
        aaaaaaaa(i, str, jSONArray);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaao
    public void aaaaaaaa(int i, String str) {
        aaaaaaa0(i, str, null);
    }

    private boolean aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaa0 aaaaaaa0Var, List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaaa aaaaaaaaVar = null;
        while (it.hasNext()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac aaaaaaacVar = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac) it.next();
            int aaaaaaan = aaaaaaacVar.aaaaaaan();
            if (aaaaaaacVar.aaaaaoaa()) {
                if (aaaaaaaaVar == null) {
                    aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao);
                    aaaaaaaaVar.aaaaaaao(aaaaaaa0Var.aaaaaaau());
                    if (aaaaaaa0Var.aaaaaaan()) {
                        aaaaaaaaVar.aaaaaaau();
                    }
                }
                aaaaaaaaVar.aaaaaaaa(aaaaaaan);
                aaaaaaaaVar.aaaaaaaa(aaaaaaacVar);
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var2 = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0) hashMap.get(Integer.valueOf(aaaaaaan));
                if (aaaaaaa0Var2 != null) {
                    aaaaaaa0Var2.aaaaaaaa(aaaaaaacVar);
                } else {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao(this.aaaaaaa0, this.aaaaaaao);
                    if (aaaaaaa0Var.aaaaaaan()) {
                        aaaaaaaoVar.aaaaaaau();
                    }
                    aaaaaaaoVar.aaaaaaao(aaaaaaa0Var.aaaaaaau());
                    aaaaaaaoVar.aaaaaaaa(this);
                    aaaaaaaoVar.aaaaaaaa(aaaaaaacVar.aaaaaaan());
                    aaaaaaaoVar.aaaaaaaa(aaaaaaacVar);
                    hashMap.put(Integer.valueOf(aaaaaaacVar.aaaaaaan()), aaaaaaaoVar);
                }
            }
        }
        if (aaaaaaaaVar != null) {
            if (hashMap.containsKey(Integer.valueOf(aaaaaaaaVar.aaaaaaan()))) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaa0 aaaaaaa0Var3 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaa0(this.aaaaaaa0, this.aaaaaaao);
                aaaaaaa0Var3.aaaaaaaa(aaaaaaaaVar);
                aaaaaaa0Var3.aaaaaaaa((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao) hashMap.get(Integer.valueOf(aaaaaaaaVar.aaaaaaan())));
                aaaaaaa0Var3.aaaaaaaa(aaaaaaaaVar.aaaaaaan());
                aaaaaaa0Var3.aaaaaaaa(this);
                aaaaaaa0Var3.aaaaaaao(aaaaaaa0Var.aaaaaaau());
                if (aaaaaaa0Var.aaaaaaan()) {
                    aaaaaaa0Var3.aaaaaaau();
                }
                hashMap.put(Integer.valueOf(aaaaaaaaVar.aaaaaaan()), aaaaaaa0Var3);
            } else {
                aaaaaaaaVar.aaaaaaaa(this);
                hashMap.put(Integer.valueOf(aaaaaaaaVar.aaaaaaan()), aaaaaaaaVar);
            }
        }
        this.aaaaaaan.addAll(hashMap.values());
        if (this.aaaaaaan.size() > 1) {
            Collections.sort(this.aaaaaaan, new A5SV6n(6));
            return false;
        }
        if (hashMap.size() == 1) {
            return false;
        }
        aaaaaaao(-5020, AOLErrorUtil.getErrorMsg(-5020));
        return true;
    }

    private void aaaaaaa0(List list) {
        if (this.aeaaaaaa) {
            return;
        }
        this.aeaaaaaa = true;
        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaa0.aaaaaaaa) {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                DCBaseAOL dCBaseAOL = (DCBaseAOL) it.next();
                StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(i, "success!index:", ";ad:");
                B9tovu2.append(dCBaseAOL.toString());
                B9tovu2.append(";type:");
                B9tovu2.append(dCBaseAOL.getType());
                B9tovu2.append(",id:");
                B9tovu2.append(dCBaseAOL.getSlotId());
                B9tovu2.append(",isbid:");
                B9tovu2.append(dCBaseAOL.isSlotSupportBidding());
                B9tovu2.append(",bidPrice:");
                B9tovu2.append(dCBaseAOL.aeaaaaaa());
                aaaaaaau.aaaaaaaa(B9tovu2.toString());
                i++;
            }
        }
        this.aaaeaaaa.removeMessages(3);
        aaaaaaaa(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var2) {
        return Integer.compare(aaaaaaa0Var.aaaaaaan(), aaaaaaa0Var2.aaaaaaan());
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaa0
    public Activity aaaaaaaa() {
        return this.aaaaaaao;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var) {
        aaaaaaau.aaaaaaaa("level load success.current:" + aaaaaaa0Var.aaaaaaan() + ",is bid:" + aaaaaaa0Var.aaaaaaac());
        if (aaaaaaa0Var.aaaaaaac()) {
            this.aaaaaaav = aaaaaaa0Var;
            aaaaaaeo();
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0 aaaaaaa0Var2 = this.aaaaaaav;
        if (aaaaaaa0Var2 != null && (aaaaaaa0Var2 instanceof io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa)) {
            if (aaaaaaae()) {
                aaaaaaaa.C0540aaaaaaaa aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaa0.getCount(), this.aaaaaaav.aaaaaaeo(), aaaaaaa0Var.aaaaaaeo());
                if (aaaaaaaa == null) {
                    this.aaaaaaav = null;
                    aaaaaaeo();
                    return;
                }
                for (DCBaseAOL dCBaseAOL : aaaaaaaa.aaaaaaac) {
                    if (dCBaseAOL.isSlotSupportBidding()) {
                        dCBaseAOL.biddingSuccess(aaaaaaaa.aaaaaaa0, aaaaaaaa.aaaaaaao);
                    }
                }
                aaaaaaa0(aaaaaaaa.aaaaaaac);
            } else if (aaaaaaa0Var.aaaaaaao() > this.aaaaaaav.aaaaaaao()) {
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa) this.aaaaaaav).aaaaaaac(aaaaaaa0Var.aaaaaaao());
                aaaaaaa0(aaaaaaa0Var.aaaaaaeo());
            } else {
                ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaaa) this.aaaaaaav).aaaeaaaa();
                aaaaaaa0(this.aaaaaaav.aaaaaaeo());
            }
        } else {
            aaaaaaa0(aaaaaaa0Var.aaaaaaeo());
        }
        aaaaaaan();
    }

    private void aaaaaaaa(JSONArray jSONArray) {
        if (this.aaaaaaeo) {
            aaaaaaa0(-5005, AOLErrorUtil.getErrorMsg(-5018), jSONArray);
        } else {
            aaaaaaa0(-5005, AOLErrorUtil.getErrorMsg(-5005), jSONArray);
        }
    }

    private void aaaaaaaa(List list) {
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.aaoaaaaa.add(((DCBaseAOL) it.next()).getSlotId());
            }
        }
        aaaaaaao(list);
    }
}
