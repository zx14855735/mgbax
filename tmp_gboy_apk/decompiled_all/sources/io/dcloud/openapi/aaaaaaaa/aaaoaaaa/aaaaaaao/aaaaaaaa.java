package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao;

import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.downloader.core.c;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aacaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao.aaaaaaa0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa implements aaaaaoaa {
    public aaaaaaaa(aaaaaaao aaaaaaaoVar) {
    }

    public static boolean aaaaaaa0(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || c.h.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa
    public aaaaaaca aaaaaaaa(aaaaaoaa.aaaaaaaa aaaaaaaaVar) {
        aaaaaaa0 aaaaaaao = new aaaaaaa0.aaaaaaaa(System.currentTimeMillis(), aaaaaaaaVar.aaaaaaac(), null).aaaaaaao();
        aaaacaaa aaaacaaaVar = aaaaaaao.aaaaaaaa;
        aaaaaaca aaaaaacaVar = aaaaaaao.aaaaaaa0;
        if (aaaacaaaVar == null && aaaaaacaVar == null) {
            return new aaaaaaca.aaaaaaaa().aaaaaaaa(aaaaaaaaVar.aaaaaaac()).aaaaaaaa(aacaaaaa.HTTP_1_1).aaaaaaaa(e.E).aaaaaaaa("Unsatisfiable Request (only-if-cached)").aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaao).aaaaaaa0(-1L).aaaaaaaa(System.currentTimeMillis()).aaaaaaaa();
        }
        if (aaaacaaaVar == null) {
            return aaaaaacaVar.eaaaaaaa().aaaaaaaa(aaaaaaaa(aaaaaacaVar)).aaaaaaaa();
        }
        aaaaaaca aaaaaaaa = aaaaaaaaVar.aaaaaaaa(aaaacaaaVar);
        if (aaaaaacaVar != null) {
            if (aaaaaaaa.aaaaeaaa() == 304) {
                aaaaaacaVar.eaaaaaaa().aaaaaaaa(aaaaaaaa(aaaaaacaVar.aaaaaaea(), aaaaaaaa.aaaaaaea())).aaaaaaa0(aaaaaaaa.aaaoaaaa()).aaaaaaaa(aaaaaaaa.aoaaaaaa()).aaaaaaaa(aaaaaaaa(aaaaaacaVar)).aaaaaaao(aaaaaaaa(aaaaaaaa)).aaaaaaaa();
                aaaaaaaa.aaaaaaeo().close();
                throw null;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaacaVar.aaaaaaeo());
        }
        return aaaaaaaa.eaaaaaaa().aaaaaaaa(aaaaaaaa(aaaaaacaVar)).aaaaaaao(aaaaaaaa(aaaaaaaa)).aaaaaaaa();
    }

    private static aaaaaaca aaaaaaaa(aaaaaaca aaaaaacaVar) {
        return (aaaaaacaVar == null || aaaaaacaVar.aaaaaaeo() == null) ? aaaaaacaVar : aaaaaacaVar.eaaaaaaa().aaaaaaaa((a0aaaaaa) null).aaaaaaaa();
    }

    private static aaaoaaaa aaaaaaaa(aaaoaaaa aaaoaaaaVar, aaaoaaaa aaaoaaaaVar2) {
        aaaoaaaa.aaaaaaaa aaaaaaaaVar = new aaaoaaaa.aaaaaaaa();
        int aaaaaaa0 = aaaoaaaaVar.aaaaaaa0();
        for (int i = 0; i < aaaaaaa0; i++) {
            String aaaaaaaa = aaaoaaaaVar.aaaaaaaa(i);
            String aaaaaaa02 = aaaoaaaaVar.aaaaaaa0(i);
            if ((!"Warning".equalsIgnoreCase(aaaaaaaa) || !aaaaaaa02.startsWith("1")) && (aaaaaaaa(aaaaaaaa) || !aaaaaaa0(aaaaaaaa) || aaaoaaaaVar2.aaaaaaa0(aaaaaaaa) == null)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaaVar, aaaaaaaa, aaaaaaa02);
            }
        }
        int aaaaaaa03 = aaaoaaaaVar2.aaaaaaa0();
        for (int i2 = 0; i2 < aaaaaaa03; i2++) {
            String aaaaaaaa2 = aaaoaaaaVar2.aaaaaaaa(i2);
            if (!aaaaaaaa(aaaaaaaa2) && aaaaaaa0(aaaaaaaa2)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaaVar, aaaaaaaa2, aaaoaaaaVar2.aaaaaaa0(i2));
            }
        }
        return aaaaaaaaVar.aaaaaaaa();
    }

    public static boolean aaaaaaaa(String str) {
        return c.e.equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
