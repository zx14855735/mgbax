package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import J3FDQU.A2egSU;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaa0 implements aaaaaoaa {
    private final boolean aaaaaaaa;

    public static final class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaae {
        long aaaaaaa0;

        public aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
            super(aaaoaaaaVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaae, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
        public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            super.aaaaaaa0(aaaaaaaoVar, j);
            this.aaaaaaa0 += j;
        }
    }

    public aaaaaaa0(boolean z) {
        this.aaaaaaaa = z;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa
    public aaaaaaca aaaaaaaa(aaaaaoaa.aaaaaaaa aaaaaaaaVar) {
        aaaaaaae aaaaaaaeVar = (aaaaaaae) aaaaaaaaVar;
        aaaaaaao aaaaaaav = aaaaaaaeVar.aaaaaaav();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaeo = aaaaaaaeVar.aaaaaaeo();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao) aaaaaaaeVar.aaaaaaan();
        aaaacaaa aaaaaaac = aaaaaaaeVar.aaaaaaac();
        long currentTimeMillis = System.currentTimeMillis();
        aaaaaaaeVar.aaaaaaae().aaaaaaac(aaaaaaaeVar.aaaaaaau());
        aaaaaaav.aaaaaaaa(aaaaaaac);
        aaaaaaaeVar.aaaaaaae().aaaaaaaa(aaaaaaaeVar.aaaaaaau(), aaaaaaac);
        aaaaaaca.aaaaaaaa aaaaaaaaVar2 = null;
        if (aaaaaaan.aaaaaaaa(aaaaaaac.aaaaaaau()) && aaaaaaac.aaaaaaaa() != null) {
            if ("100-continue".equalsIgnoreCase(aaaaaaac.aaaaaaaa("Expect"))) {
                aaaaaaav.aaaaaaa0();
                aaaaaaaeVar.aaaaaaae().aaaaaaan(aaaaaaaeVar.aaaaaaau());
                aaaaaaaaVar2 = aaaaaaav.aaaaaaaa(true);
            }
            if (aaaaaaaaVar2 == null) {
                aaaaaaaeVar.aaaaaaae().aaaaaaao(aaaaaaaeVar.aaaaaaau());
                aaaaaaaa aaaaaaaaVar3 = new aaaaaaaa(aaaaaaav.aaaaaaaa(aaaaaaac, aaaaaaac.aaaaaaaa().aaaaaaaa()));
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaaa2 = aaaaaeaa.aaaaaaaa(aaaaaaaaVar3);
                aaaaaaac.aaaaaaaa().aaaaaaaa(aaaaaaaa2);
                aaaaaaaa2.close();
                aaaaaaaeVar.aaaaaaae().aaaaaaaa(aaaaaaaeVar.aaaaaaau(), aaaaaaaaVar3.aaaaaaa0);
            } else if (!aaaaaaaoVar.aaaaaaac()) {
                aaaaaaeo.aaaaaaau();
            }
        }
        aaaaaaav.aaaaaaaa();
        if (aaaaaaaaVar2 == null) {
            aaaaaaaeVar.aaaaaaae().aaaaaaan(aaaaaaaeVar.aaaaaaau());
            aaaaaaaaVar2 = aaaaaaav.aaaaaaaa(false);
        }
        aaaaaaca aaaaaaaa3 = aaaaaaaaVar2.aaaaaaaa(aaaaaaac).aaaaaaaa(aaaaaaeo.aaaaaaao().aaaaaaao()).aaaaaaa0(currentTimeMillis).aaaaaaaa(System.currentTimeMillis()).aaaaaaaa();
        int aaaaeaaa = aaaaaaaa3.aaaaeaaa();
        if (aaaaeaaa == 100) {
            aaaaaaaa3 = aaaaaaav.aaaaaaaa(false).aaaaaaaa(aaaaaaac).aaaaaaaa(aaaaaaeo.aaaaaaao().aaaaaaao()).aaaaaaa0(currentTimeMillis).aaaaaaaa(System.currentTimeMillis()).aaaaaaaa();
            aaaaeaaa = aaaaaaaa3.aaaaeaaa();
        }
        aaaaaaaeVar.aaaaaaae().aaaaaaaa(aaaaaaaeVar.aaaaaaau(), aaaaaaaa3);
        aaaaaaca aaaaaaaa4 = (this.aaaaaaaa && aaaaeaaa == 101) ? aaaaaaaa3.eaaaaaaa().aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaao).aaaaaaaa() : aaaaaaaa3.eaaaaaaa().aaaaaaaa(aaaaaaav.aaaaaaaa(aaaaaaaa3)).aaaaaaaa();
        if ("close".equalsIgnoreCase(aaaaaaaa4.aaoaaaaa().aaaaaaaa("Connection")) || "close".equalsIgnoreCase(aaaaaaaa4.aaaaaaa0("Connection"))) {
            aaaaaaeo.aaaaaaau();
        }
        if ((aaaaeaaa != 204 && aaaaeaaa != 205) || aaaaaaaa4.aaaaaaeo().aaaeaaaa() <= 0) {
            return aaaaaaaa4;
        }
        StringBuilder B9tovu2 = A2egSU.B9tovu(aaaaeaaa, "HTTP ", " had non-zero Content-Length: ");
        B9tovu2.append(aaaaaaaa4.aaaaaaeo().aaaeaaaa());
        throw new ProtocolException(B9tovu2.toString());
    }
}
