package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaacaaa {
    final String aaaaaaa0;
    final aaaaoaaa aaaaaaaa;
    final aaaaacaa aaaaaaac;
    private volatile aaaaaaao aaaaaaan;
    final aaaoaaaa aaaaaaao;
    final Map aaaaaaau;

    public aaaacaaa(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaa0 = aaaaaaaaVar.aaaaaaa0;
        this.aaaaaaao = aaaaaaaaVar.aaaaaaao.aaaaaaaa();
        this.aaaaaaac = aaaaaaaaVar.aaaaaaac;
        this.aaaaaaau = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaaVar.aaaaaaau);
    }

    public aaaaaaao aaaaaaa0() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaan;
        if (aaaaaaaoVar != null) {
            return aaaaaaaoVar;
        }
        aaaaaaao aaaaaaaa2 = aaaaaaao.aaaaaaaa(this.aaaaaaao);
        this.aaaaaaan = aaaaaaaa2;
        return aaaaaaaa2;
    }

    public String aaaaaaaa(String str) {
        return this.aaaaaaao.aaaaaaa0(str);
    }

    public boolean aaaaaaac() {
        return this.aaaaaaaa.aaaaaaav();
    }

    public aaaaoaaa aaaaaaae() {
        return this.aaaaaaaa;
    }

    public aaaaaaaa aaaaaaan() {
        return new aaaaaaaa(this);
    }

    public aaaoaaaa aaaaaaao() {
        return this.aaaaaaao;
    }

    public String aaaaaaau() {
        return this.aaaaaaa0;
    }

    public String toString() {
        return "Request{method=" + this.aaaaaaa0 + ", url=" + this.aaaaaaaa + ", tags=" + this.aaaaaaau + '}';
    }

    public static class aaaaaaaa {
        String aaaaaaa0;
        aaaaoaaa aaaaaaaa;
        aaaaacaa aaaaaaac;
        aaaoaaaa.aaaaaaaa aaaaaaao;
        Map aaaaaaau;

        public aaaaaaaa() {
            this.aaaaaaau = Collections.EMPTY_MAP;
            this.aaaaaaa0 = an.c;
            this.aaaaaaao = new aaaoaaaa.aaaaaaaa();
        }

        public aaaaaaaa aaaaaaa0(String str) {
            String str2;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str2 = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str2 = "https:" + str.substring(4);
            } else {
                str2 = str;
            }
            return aaaaaaaa(aaaaoaaa.aaaaaaa0(str2));
        }

        public aaaaaaaa aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
            if (aaaaoaaaVar == null) {
                throw new NullPointerException("url == null");
            }
            this.aaaaaaaa = aaaaoaaaVar;
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str, String str2) {
            this.aaaaaaao.aaaaaaaa(str, str2);
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str) {
            this.aaaaaaao.aaaaaaa0(str);
            return this;
        }

        public aaaaaaaa(aaaacaaa aaaacaaaVar) {
            Map map = Collections.EMPTY_MAP;
            this.aaaaaaau = map;
            this.aaaaaaaa = aaaacaaaVar.aaaaaaaa;
            this.aaaaaaa0 = aaaacaaaVar.aaaaaaa0;
            this.aaaaaaac = aaaacaaaVar.aaaaaaac;
            this.aaaaaaau = aaaacaaaVar.aaaaaaau.isEmpty() ? map : new LinkedHashMap(aaaacaaaVar.aaaaaaau);
            this.aaaaaaao = aaaacaaaVar.aaaaaaao.aaaaaaaa();
        }

        public aaaaaaaa aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
            this.aaaaaaao = aaaoaaaaVar.aaaaaaaa();
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str, aaaaacaa aaaaacaaVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (aaaaacaaVar != null && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaan.aaaaaaaa(str)) {
                        throw new IllegalArgumentException(CtFAbx.BI9f7h("method ", str, " must not have a request body."));
                    }
                    if (aaaaacaaVar == null && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaan.aaaaaaac(str)) {
                        throw new IllegalArgumentException(CtFAbx.BI9f7h("method ", str, " must have a request body."));
                    }
                    this.aaaaaaa0 = str;
                    this.aaaaaaac = aaaaacaaVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public aaaaaaaa aaaaaaa0(String str, String str2) {
            this.aaaaaaao.aaaaaaao(str, str2);
            return this;
        }

        public aaaacaaa aaaaaaaa() {
            if (this.aaaaaaaa != null) {
                return new aaaacaaa(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public aaaaacaa aaaaaaaa() {
        return this.aaaaaaac;
    }
}
