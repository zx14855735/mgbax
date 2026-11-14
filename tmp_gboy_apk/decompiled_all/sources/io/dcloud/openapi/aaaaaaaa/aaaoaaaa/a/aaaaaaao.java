package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a;

import C4FrIb.A5SV6n;
import J3FDQU.A2egSU;
import android.app.Activity;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaao implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0, aaaaaaaa.InterfaceC0537aaaaaaaa {
    protected final Activity aaaaoaaa;
    protected DCBaseAOL aaaeaaaa;
    protected final DCloudAOLSlot aaaoaaaa;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaoaaaaa;
    protected int aeaaaaaa;
    private boolean aaaaaaaa = false;
    protected volatile boolean aaaaaaa0 = false;
    private final List aaaaaaao = new ArrayList();
    private final AtomicInteger aaaaaaac = new AtomicInteger(0);
    private final aaaaaaa0 aaaaaaau = new aaaaaaa0();
    protected List aaaaaaan = new ArrayList();
    protected List aaaaaaae = new ArrayList();
    protected List aaaaaaav = new ArrayList();
    protected Map aaaaaaeo = new HashMap();
    protected List aaaaeaaa = new ArrayList();
    private final List aaaaaeaa = new ArrayList();
    private final Map aaaaaaea = new HashMap();
    private final List eaaaaaaa = new ArrayList();
    protected boolean aoaaaaaa = false;
    protected int aaaaaoaa = Integer.MIN_VALUE;
    private String aaaaaaoa = "";

    public static class aaaaaaa0 {
        private Integer aaaaaaa0;
        private Integer aaaaaaaa;

        private aaaaaaa0() {
            this.aaaaaaaa = 0;
            this.aaaaaaa0 = 0;
        }

        public boolean aaaaaaa0(Integer num) {
            return num.compareTo(this.aaaaaaa0) <= 0;
        }

        public boolean aaaaaaaa(Integer num) {
            return (num.compareTo(this.aaaaaaaa) >= 0) && (num.compareTo(this.aaaaaaa0) <= 0);
        }

        public void aaaaaaao(Integer num) {
            if (aaaaaaaa(num)) {
                return;
            }
            if (num.intValue() > this.aaaaaaa0.intValue()) {
                this.aaaaaaa0 = num;
            } else if (num.intValue() < this.aaaaaaaa.intValue()) {
                this.aaaaaaaa = num;
            }
        }

        public String toString() {
            return "[" + this.aaaaaaaa + ", " + this.aaaaaaa0 + "]";
        }
    }

    public aaaaaaao(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        this.aaaoaaaa = dCloudAOLSlot;
        this.aaaaoaaa = activity;
    }

    private void aaaaaaa0() {
        aaaaaaau.aaaaaaac("ordered request list");
        eaaaaaaa();
        if (aaaaeaaa()) {
            aoaaaaaa();
        }
    }

    private void aeaaaaaa() {
        if (!aaaaaaac()) {
            ArrayList arrayList = new ArrayList();
            if (this.aaaaaaeo.size() > 0) {
                if (this.aaaaaeaa.size() <= 0) {
                    for (List list : this.aaaaaaeo.values()) {
                        if (list != null) {
                            arrayList.addAll(list);
                        }
                        if (arrayList.size() >= this.aaaoaaaa.getCount()) {
                            break;
                        }
                    }
                } else {
                    for (Integer num : this.aaaaaeaa) {
                        for (DCBaseAOL dCBaseAOL : this.aaaaaaan) {
                            if (dCBaseAOL.aaaoaaaa() == num.intValue()) {
                                List list2 = (List) this.aaaaaaeo.get(dCBaseAOL);
                                if (list2 != null) {
                                    arrayList.addAll(list2);
                                }
                                if (arrayList.size() >= this.aaaoaaaa.getCount()) {
                                    break;
                                }
                            }
                        }
                        if (aaaaaaaa(num) > 0) {
                            break;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() >= this.aaaoaaaa.getCount()) {
                    this.aaaaeaaa.addAll(arrayList.subList(0, this.aaaoaaaa.getCount()));
                    aaoaaaaa();
                } else if (aaaaeaaa()) {
                    this.aaaaeaaa.addAll(arrayList);
                    aaoaaaaa();
                }
            }
        }
        aaaoaaaa();
    }

    private void eaaaaaaa() {
        if (this.aoaaaaaa || this.aaaaaaa0) {
            return;
        }
        if (this.aaaaaaao.size() <= 0) {
            aoaaaaaa();
            return;
        }
        aaaaaaac aaaaaaacVar = (aaaaaaac) this.aaaaaaao.remove(0);
        DCBaseAOLLoader aaaaaaa02 = aaaaaaa0(aaaaaaacVar);
        if (aaaaaaa02 == null) {
            aaaaaaau.aaaaaaa0("load sub slot fail cfg:" + aaaaaaacVar.toString());
            this.aaaaaaac.decrementAndGet();
            eaaaaaaa();
            return;
        }
        aaaaaaa02.aaaaaaaa(this);
        this.aaaaaaav.add(aaaaaaa02);
        aaaaaaa02.aaaaaaaa(aaaaaaacVar);
        aaaaaaa02.aaaaaaac(this.aaaaaaoa);
        aaaaaaa02.aaaaaaaa((Map) null);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(aaaaaaac aaaaaaacVar) {
        this.aaaaaaau.aaaaaaao(Integer.valueOf(aaaaaaacVar.aaaaaaao()));
        this.aaaaaaao.add(aaaaaaacVar);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaac() {
        return false;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public List aaaaaaae() {
        return this.eaaaaaaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public int aaaaaaan() {
        return this.aaaaaoaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public int aaaaaaao() {
        if (!aaaaaaea()) {
            DCBaseAOL dCBaseAOL = this.aaaeaaaa;
            if (dCBaseAOL != null) {
                return dCBaseAOL.aeaaaaaa();
            }
            return -1;
        }
        List list = this.aaaaeaaa;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaeaaa);
        return ((DCBaseAOL) A2egSU.AlLFFp(this.aaaaeaaa, 1)).aeaaaaaa();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaau() {
        if (this instanceof io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaaa) {
            return;
        }
        this.aaaaaaaa = true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaav() {
        this.aoaaaaaa = true;
        if (this.aaaaaaa0) {
            return;
        }
        aaaaaeaa();
        if (this.aaaaaaan.isEmpty()) {
            aoaaaaaa();
            return;
        }
        Collections.sort(this.aaaaaaan, new A5SV6n(5));
        if (!aaaaaaea()) {
            this.aaaeaaaa = (DCBaseAOL) this.aaaaaaan.get(0);
            aaoaaaaa();
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.aaaaaaan.iterator();
        while (it.hasNext()) {
            List list = (List) this.aaaaaaeo.get((DCBaseAOL) it.next());
            if (list != null) {
                arrayList.addAll(list);
            }
            if (arrayList.size() >= this.aaaoaaaa.getCount()) {
                break;
            }
        }
        if (arrayList.size() <= 0) {
            aoaaaaaa();
            return;
        }
        if (arrayList.size() > this.aaaoaaaa.getCount()) {
            this.aaaaeaaa.addAll(arrayList.subList(0, this.aaaoaaaa.getCount()));
        } else {
            this.aaaaeaaa.addAll(arrayList);
        }
        aaoaaaaa();
    }

    public boolean aaaaaaea() {
        int i = this.aeaaaaaa;
        return i == 10 || i == 4 || i == 5;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public List aaaaaaeo() {
        if (aaaaaaea()) {
            return this.aaaaeaaa;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.aaaeaaaa);
        return arrayList;
    }

    public void aaaaaeaa() {
        if (this.aaaaaaav.isEmpty()) {
            return;
        }
        this.aaaaaaav.removeAll(this.aaaaaaan);
        this.aaaaaaav.removeAll(this.aaaaaaae);
        Iterator it = this.aaaaaaav.iterator();
        while (it.hasNext()) {
            this.eaaaaaaa.add(((DCBaseAOLLoader) it.next()).aaaaacaa());
        }
        this.aaaaaaav.clear();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaeaaa() {
        return this.aoaaaaaa || this.aaaaaaac.get() <= 0;
    }

    public void aaaoaaaa() {
        if (aaaaeaaa()) {
            if (this.aaaaaaan.isEmpty()) {
                aoaaaaaa();
            }
        } else if (this.aaaaaaaa) {
            aaaaaaa0();
        }
    }

    public void aaoaaaaa() {
        if (this.aaaaaaa0) {
            return;
        }
        if (aaaaaaea()) {
            aaaaaaau.aaaaaaaa("current level load success.level:" + this.aaaaaoaa + ";count:" + this.aaaaeaaa.size());
        } else {
            aaaaaaau.aaaaaaaa("current level load success.level:" + this.aaaaaoaa + ";slot:" + this.aaaeaaaa.getSlotId() + ";ss:" + this.aaaeaaaa.aaaoaaaa());
        }
        this.aaaaaaa0 = true;
        aaaaaeaa();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar = this.aaoaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
        }
    }

    public void aoaaaaaa() {
        if (this.aaaaaaa0) {
            return;
        }
        aaaaaaau.aaaaaaaa("current level load fail.level:" + this.aaaaaoaa);
        this.aaaaaaa0 = true;
        aaaaaeaa();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar = this.aaoaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaa0(this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("print all slot cfg:level:");
        sb.append(this.aaaaaoaa);
        sb.append(";");
        for (aaaaaaac aaaaaaacVar : this.aaaaaaao) {
            sb.append(aaaaaaacVar.aaaaaeaa());
            sb.append(":");
            sb.append(aaaaaaacVar.eaaaaaaa());
            sb.append(":show:");
            sb.append(aaaaaaacVar.aaaaaaea());
            sb.append(",");
        }
        return sb.toString();
    }

    private void aaaaaaan(int i) {
        AtomicInteger atomicInteger = (AtomicInteger) this.aaaaaaea.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            this.aaaaaaea.put(Integer.valueOf(i), new AtomicInteger(0));
        } else {
            atomicInteger.decrementAndGet();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar) {
        this.aaoaaaaa = aaaaaaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaau(int i) {
        Iterator it = this.aaaaaaao.iterator();
        while (it.hasNext()) {
            if (((aaaaaaac) it.next()).aaaaaaao() <= i) {
                it.remove();
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa() {
        if (this.aaaaaaao.isEmpty()) {
            aoaaaaaa();
            return;
        }
        if (this.aoaaaaaa) {
            aoaaaaaa();
            return;
        }
        aaaaaaa0("+");
        if (aaaaaaac()) {
            aaaaaaaa(false);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aaaaaaao.size() > 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (aaaaaaac aaaaaaacVar : this.aaaaaaao) {
                this.aaaaaaac.incrementAndGet();
                if (aaaaaaacVar.aaaaoaaa()) {
                    try {
                        int aoaaaaaa = aaaaaaacVar.aoaaaaaa();
                        if (aoaaaaaa > 0) {
                            jSONObject.put(aaaaaaacVar.eaaaaaaa(), aoaaaaaa);
                        }
                        int aaaaaaae = aaaaaaacVar.aaaaaaae();
                        if (aaaaaaae > 0) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(aaaaaaacVar.aaaaaeaa());
                            jSONArray.put(aaaaaaae);
                            jSONObject2.put(aaaaaaacVar.eaaaaaaa(), jSONArray);
                        }
                    } catch (Exception unused) {
                    }
                }
                linkedHashMap.put(aaaaaaacVar.eaaaaaaa(), aaaaaaacVar);
            }
            if (jSONObject.length() <= 0 && jSONObject2.length() <= 0) {
                if (this.aaaaaaaa) {
                    aaaaaaa0();
                    return;
                } else {
                    aaaaaaaa(false);
                    return;
                }
            }
            List aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaoaaa, new ArrayList(linkedHashMap.keySet()), this.aaaoaaaa.getAdpid(), jSONObject, jSONObject2);
            this.aaaaaaao.clear();
            Iterator it = aaaaaaaa2.iterator();
            while (it.hasNext()) {
                aaaaaaac aaaaaaacVar2 = (aaaaaaac) linkedHashMap.get((String) it.next());
                if (aaaaaaacVar2 != null) {
                    this.aaaaaaao.add(aaaaaaacVar2);
                }
            }
            if (this.aaaaaaaa) {
                aaaaaaa0();
                return;
            } else {
                aaaaaaaa(true);
                return;
            }
        }
        this.aaaaaaac.incrementAndGet();
        aaaaaaa0();
    }

    public DCBaseAOLLoader aaaaaaa0(aaaaaaac aaaaaaacVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaaa aaaaaaaaVar;
        IAdAdapter aaaaaaa02 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0(aaaaaaacVar.aaaaaeaa());
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaaa aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(aaaaaaacVar.aaaaaeaa());
        if (aaaaaaa02 == null && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaaa(aaaaaaacVar.aaaaaeaa())) {
            if (aaaaaaaa2 != null && aaaaaaaa2.aaaaaaae()) {
                try {
                    Object newInstance = Class.forName(aaaaaaaa2.aaaaaaac()).newInstance();
                    if (newInstance instanceof UniAdCustomAdapter) {
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaaa(aaaaaaacVar.aaaaaeaa(), (UniAdCustomAdapter) newInstance);
                        aaaaaaa02 = (UniAdCustomAdapter) newInstance;
                    }
                } catch (Exception unused) {
                }
            } else if (this.aeaaaaaa == 1 && (aaaaaaa02 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0("dcloud")) == null) {
                aaaaaaa02 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaaa();
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaaa("dcloud", aaaaaaa02);
            }
        }
        if (aaaaaaa02 == null || !aaaaaaa02.isSupport()) {
            return null;
        }
        if (aaaaaaacVar.aaaaaeaa().equalsIgnoreCase("dcloud") && (aaaaaaaaVar = this.aaoaaaaa) != null) {
            DCBaseAOLLoader aaaaaaa03 = aaaaaaaaVar.aaaaaaa0();
            aaaaaaa03.setPlatform(null, "dcloud");
            return aaaaaaa03;
        }
        DCBaseAOLLoader ad = aaaaaaa02.getAd(this.aaaaoaaa, this.aaaoaaaa);
        if (aaaaaaaa2 == null || ad == null) {
            return null;
        }
        if (aaaaaaaa2.aaaaaaae()) {
            ad.aaaaaaaa(aaaaaaaa2.aaaaaaaa(), aaaaaaa02, aaaaaaaa2.aaaaaaau());
        } else {
            ad.aaaaaaaa(aaaaaaaa2.aaaaaaaa(), aaaaaaaa2.aaaaaaa0());
            if (aaaaaaaa2.aaaaaaan() != null) {
                ad.setPlatform(aaaaaaaa2.aaaaaaan(), aaaaaaaa2.aaaaaaao());
            }
        }
        return ad;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaao(int i) {
        this.aeaaaaaa = i;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public boolean aaaaaaa0(int i) {
        return this.aaaaaaau.aaaaaaa0(Integer.valueOf(i));
    }

    private void aaaaaaa0(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 70; i++) {
            sb.append(str);
        }
        aaaaaaau.aaaaaaac(sb.toString());
    }

    private void aaaaaaaa(boolean z) {
        AtomicInteger atomicInteger;
        int i = 0;
        this.aaaaaaac.set(0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (aaaaaaac aaaaaaacVar : this.aaaaaaao) {
            DCBaseAOLLoader aaaaaaa02 = aaaaaaa0(aaaaaaacVar);
            if (aaaaaaa02 != null) {
                this.aaaaaaac.incrementAndGet();
                if (z) {
                    aaaaaaacVar.aaaaaaaa(i2);
                    i2++;
                }
                aaaaaaa02.aaaaaaaa(aaaaaaacVar);
                aaaaaaa02.aaaaaaaa(this);
                arrayList.add(aaaaaaa02);
                if (!this.aaaaaeaa.contains(Integer.valueOf(aaaaaaacVar.aaaaaaea()))) {
                    this.aaaaaeaa.add(Integer.valueOf(aaaaaaacVar.aaaaaaea()));
                }
                if (this.aaaaaaea.containsKey(Integer.valueOf(aaaaaaacVar.aaaaaaea()))) {
                    atomicInteger = (AtomicInteger) this.aaaaaaea.get(Integer.valueOf(aaaaaaacVar.aaaaaaea()));
                } else {
                    atomicInteger = new AtomicInteger(0);
                }
                atomicInteger.incrementAndGet();
                this.aaaaaaea.put(Integer.valueOf(aaaaaaacVar.aaaaaaea()), atomicInteger);
            } else {
                aaaaaaau.aaaaaaa0("load sub slot fail cfg:" + aaaaaaacVar.toString());
            }
        }
        aaaaaaau.aaaaaaaa("level start load.current:" + this.aaaaaoaa + ",valid ads:" + arrayList.size());
        if (arrayList.size() > 0) {
            if (this.aaaaaeaa.size() > 1) {
                Collections.sort(this.aaaaaeaa);
            }
            this.aaaaaaav.addAll(arrayList);
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                DCBaseAOLLoader dCBaseAOLLoader = (DCBaseAOLLoader) obj;
                dCBaseAOLLoader.aaaaaaac(this.aaaaaaoa);
                dCBaseAOLLoader.aaaaaaaa((Map) null);
            }
            return;
        }
        aoaaaaaa();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(int i) {
        this.aaaaaoaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int aaaaaaaa(DCBaseAOL dCBaseAOL, DCBaseAOL dCBaseAOL2) {
        return Integer.compare(dCBaseAOL.aaaoaaaa(), dCBaseAOL2.aaaoaaaa());
    }

    public void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, List list, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar) {
        if (!this.aaaaaaoa.equalsIgnoreCase(dCBaseAOLLoader.aaoaaaaa()) || this.aoaaaaaa || this.aaaaaaa0) {
            return;
        }
        this.aaaaaaac.decrementAndGet();
        this.aaaaaaan.add(dCBaseAOLLoader);
        this.eaaaaaaa.add(aaaaaaaoVar);
        aaaaaaan(dCBaseAOLLoader.aaaoaaaa());
        aaaaaaau.aaaaaaac("level ad load success!current sub slot:" + dCBaseAOLLoader.getSlotId() + ";ss;" + dCBaseAOLLoader.aaaoaaaa() + ";type;" + dCBaseAOLLoader.getType());
        if (aaaaaaea()) {
            this.aaaaaaeo.put(dCBaseAOLLoader, list);
        }
        if (aaaaaaea()) {
            if (this.aaaaaaaa) {
                this.aaaaeaaa.addAll(list);
                aaoaaaaa();
                aaaoaaaa();
            } else {
                aeaaaaaa();
            }
        } else {
            if (!aaaaaaac()) {
                if (this.aaaaaeaa.size() > 1) {
                    if (!this.aaaaaaaa) {
                        for (Integer num : this.aaaaaeaa) {
                            if (dCBaseAOLLoader.aaaoaaaa() > num.intValue()) {
                                aaaaaaau.aaaaaaaa("check ss smaller than this.ss:" + num + ";unfinished ss count:" + aaaaaaaa(num));
                                if (aaaaaaaa(num) > 0) {
                                    break;
                                }
                            }
                        }
                    }
                    this.aaaeaaaa = dCBaseAOLLoader;
                    aaoaaaaa();
                } else {
                    this.aaaeaaaa = dCBaseAOLLoader;
                    aaoaaaaa();
                }
            }
            aaaoaaaa();
        }
        aaaaaaa0("-");
    }

    private int aaaaaaaa(Integer num) {
        AtomicInteger atomicInteger = (AtomicInteger) this.aaaaaaea.get(num);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public void aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao aaaaaaaoVar) {
        if (!this.aaaaaaoa.equalsIgnoreCase(dCBaseAOLLoader.aaoaaaaa()) || this.aoaaaaaa || this.aaaaaaa0) {
            return;
        }
        this.aaaaaaac.decrementAndGet();
        this.aaaaaaae.add(dCBaseAOLLoader);
        this.eaaaaaaa.add(aaaaaaaoVar);
        aaaaaaan(dCBaseAOLLoader.aaaoaaaa());
        aaaaaaau.aaaaaaa0("level ad load fail.current sub slot:" + dCBaseAOLLoader.getSlotId() + ";ss:" + dCBaseAOLLoader.aaaoaaaa() + ";type:" + dCBaseAOLLoader.getType());
        if (aaaaaaea()) {
            aeaaaaaa();
        } else {
            if (this.aaaaaeaa.size() > 1 && !this.aaaaaaaa && !aaaaaaac() && this.aaaaaaan.size() > 0) {
                for (Integer num : this.aaaaaeaa) {
                    if (dCBaseAOLLoader.aaaoaaaa() <= num.intValue()) {
                        Iterator it = this.aaaaaaan.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            DCBaseAOL dCBaseAOL = (DCBaseAOL) it.next();
                            if (dCBaseAOL.aaaoaaaa() == num.intValue()) {
                                aaaaaaau.aaaaaaa0("check ss large than this.slot:" + dCBaseAOL.getSlotId() + ";ss:" + dCBaseAOL.aaaoaaaa());
                                this.aaaeaaaa = dCBaseAOL;
                                aaoaaaaa();
                                break;
                            }
                        }
                        if (aaaaaaaa(num) > 0) {
                            break;
                        }
                    } else if (dCBaseAOLLoader.aaaoaaaa() > num.intValue()) {
                        aaaaaaau.aaaaaaa0("check ss smaller than this.ss:" + num + ";unfinished ss count:" + aaaaaaaa(num));
                        if (aaaaaaaa(num) > 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            aaaoaaaa();
        }
        aaaaaaa0("-");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0
    public void aaaaaaaa(String str) {
        this.aaaaaaoa = str;
    }
}
