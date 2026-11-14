package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa {
    private static volatile aaaaaaaa aaaaaaac;
    private final Map aaaaaaao;
    private final Map aaaaaaaa = new HashMap();
    private final Map aaaaaaa0 = new C0538aaaaaaaa();

    public class aaaaaaa0 extends HashMap {
        public aaaaaaa0() {
            put(Const.TYPE_BD, "io.dcloud.openapi.poly.adapter.bd.BDAdAdapter");
            put(Const.TYPE_CSJ, "io.dcloud.openapi.poly.adapter.csj.CSJAdAdapter");
            put("gdt", "io.dcloud.openapi.poly.adapter.gdt.GDTADAdapter");
            put(Const.TYPE_SGM, "io.dcloud.openapi.poly.adapter.sgm.SGMADAdapter");
            put("ks", "io.dcloud.openapi.poly.adapter.ks.KSADAdapter");
            put(Const.TYPE_HW, "io.dcloud.openapi.poly.adapter.hw.HWAdAdapter");
            put(Const.TYPE_GM, "io.dcloud.openapi.poly.adapter.gm.DGMAdAdapter");
            putAll(aaaaaaaa.this.aaaaaaa0);
            put(Const.TYPE_WM, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aanaaaaa.aaaaaaaa.class.getName());
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0538aaaaaaaa extends HashMap {
        public C0538aaaaaaaa() {
            put(Const.TYPE_GG, "io.dcloud.openapi.poly.adapter.google.AdMobAdAdapter");
            put(Const.TYPE_PG, "io.dcloud.openapi.poly.adapter.pg.PGADAdapter");
        }
    }

    private aaaaaaaa() {
        aaaaaaa0 aaaaaaa0Var = new aaaaaaa0();
        this.aaaaaaao = aaaaaaa0Var;
        for (String str : aaaaaaa0Var.keySet()) {
            IAdAdapter aaaaaaaa = aaaaaaaa((String) this.aaaaaaao.get(str), str);
            if (aaaaaaaa != null) {
                this.aaaaaaaa.put(str, aaaaaaaa);
            }
        }
    }

    public static aaaaaaaa aaaaaaa0() {
        if (aaaaaaac == null) {
            synchronized (aaaaaaaa.class) {
                try {
                    if (aaaaaaac == null) {
                        aaaaaaac = new aaaaaaaa();
                    }
                } finally {
                }
            }
        }
        return aaaaaaac;
    }

    public String aaaaaaao(String str) {
        return this.aaaaaaa0.containsKey(str) ? Const.PROVIDER_TYPE_GLOBAL : Const.PROVIDER_TYPE_CHINA;
    }

    public Map aaaaaaaa() {
        return this.aaaaaaaa;
    }

    public List aaaaaaao() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(this.aaaaaaaa.keySet());
        } catch (Exception unused) {
        }
        if (!arrayList.contains("dcloud")) {
            arrayList.add("dcloud");
        }
        return arrayList;
    }

    private IAdAdapter aaaaaaaa(String str, String str2) {
        try {
            IAdAdapter iAdAdapter = (IAdAdapter) Class.forName(str).newInstance();
            iAdAdapter.getAdapterSDKVersion().equalsIgnoreCase("5.5.2");
            if (iAdAdapter.getSDKVersion() != null) {
                aaaaaaau.aaaaaaaa("uniAD", "SDKVersion:" + str2 + ":" + iAdAdapter.getSDKVersion());
            }
            return iAdAdapter;
        } catch (Exception unused) {
            return null;
        }
    }

    public IAdAdapter aaaaaaa0(String str) {
        return (IAdAdapter) this.aaaaaaaa.get(str);
    }

    public boolean aaaaaaaa(String str) {
        return this.aaaaaaao.containsKey(str);
    }

    public void aaaaaaaa(String str, IAdAdapter iAdAdapter) {
        this.aaaaaaaa.put(str, iAdAdapter);
    }
}
