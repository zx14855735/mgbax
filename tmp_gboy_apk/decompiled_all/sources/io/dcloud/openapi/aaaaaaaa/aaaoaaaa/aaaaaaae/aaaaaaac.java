package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.cm;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class aaaaaaac {
    static final Map aaaaaaa0;
    static final aaaaaaao[] aaaaaaaa;

    public static final class aaaaaaa0 {
        private final boolean aaaaaaa0;
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaa;
        private boolean aaaaaaac;
        aaaaaaao[] aaaaaaae;
        int aaaaaaan;
        private int aaaaaaao;
        int aaaaaaau;
        int aaaaaaav;
        int aaaaaaeo;
        int aaaeaaaa;

        public aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar) {
            this(f.a.c, true, aaaaaaaoVar);
        }

        private void aaaaaaa0() {
            Arrays.fill(this.aaaaaaae, (Object) null);
            this.aaaaaaav = this.aaaaaaae.length - 1;
            this.aaaaaaeo = 0;
            this.aaaeaaaa = 0;
        }

        private int aaaaaaaa(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.aaaaaaae.length;
                while (true) {
                    length--;
                    i2 = this.aaaaaaav;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.aaaaaaae[length].aaaaaaao;
                    i -= i4;
                    this.aaaeaaaa -= i4;
                    this.aaaaaaeo--;
                    i3++;
                }
                aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaae;
                int i5 = i2 + 1;
                System.arraycopy(aaaaaaaoVarArr, i5, aaaaaaaoVarArr, i5 + i3, this.aaaaaaeo);
                aaaaaaao[] aaaaaaaoVarArr2 = this.aaaaaaae;
                int i6 = this.aaaaaaav + 1;
                Arrays.fill(aaaaaaaoVarArr2, i6, i6 + i3, (Object) null);
                this.aaaaaaav += i3;
            }
            return i3;
        }

        public aaaaaaa0(int i, boolean z, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar) {
            this.aaaaaaao = Integer.MAX_VALUE;
            this.aaaaaaae = new aaaaaaao[8];
            this.aaaaaaav = 7;
            this.aaaaaaeo = 0;
            this.aaaeaaaa = 0;
            this.aaaaaaau = i;
            this.aaaaaaan = i;
            this.aaaaaaa0 = z;
            this.aaaaaaaa = aaaaaaaoVar;
        }

        public void aaaaaaa0(int i) {
            this.aaaaaaau = i;
            int min = Math.min(i, f.a.d);
            int i2 = this.aaaaaaan;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.aaaaaaao = Math.min(this.aaaaaaao, min);
            }
            this.aaaaaaac = true;
            this.aaaaaaan = min;
            aaaaaaaa();
        }

        private void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
            int i = aaaaaaaoVar.aaaaaaao;
            int i2 = this.aaaaaaan;
            if (i > i2) {
                aaaaaaa0();
                return;
            }
            aaaaaaaa((this.aaaeaaaa + i) - i2);
            int i3 = this.aaaaaaeo + 1;
            aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaae;
            if (i3 > aaaaaaaoVarArr.length) {
                aaaaaaao[] aaaaaaaoVarArr2 = new aaaaaaao[aaaaaaaoVarArr.length * 2];
                System.arraycopy(aaaaaaaoVarArr, 0, aaaaaaaoVarArr2, aaaaaaaoVarArr.length, aaaaaaaoVarArr.length);
                this.aaaaaaav = this.aaaaaaae.length - 1;
                this.aaaaaaae = aaaaaaaoVarArr2;
            }
            int i4 = this.aaaaaaav;
            this.aaaaaaav = i4 - 1;
            this.aaaaaaae[i4] = aaaaaaaoVar;
            this.aaaaaaeo++;
            this.aaaeaaaa += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void aaaaaaaa(java.util.List r14) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaac.aaaaaaa0.aaaaaaaa(java.util.List):void");
        }

        public void aaaaaaaa(int i, int i2, int i3) {
            if (i < i2) {
                this.aaaaaaaa.writeByte(i | i3);
                return;
            }
            this.aaaaaaaa.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.aaaaaaaa.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.aaaaaaaa.writeByte(i4);
        }

        public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar) {
            if (this.aaaaaaa0 && aaaaeaaa.aaaaaaa0().aaaaaaaa(aaaaaaanVar) < aaaaaaanVar.aaaaaaac()) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
                aaaaeaaa.aaaaaaa0().aaaaaaaa(aaaaaaanVar, aaaaaaaoVar);
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaeaaa = aaaaaaaoVar.aaaaeaaa();
                aaaaaaaa(aaaaeaaa.aaaaaaac(), 127, r.b.d);
                this.aaaaaaaa.aaaaaaaa(aaaaeaaa);
                return;
            }
            aaaaaaaa(aaaaaaanVar.aaaaaaac(), 127, 0);
            this.aaaaaaaa.aaaaaaaa(aaaaaaanVar);
        }

        private void aaaaaaaa() {
            int i = this.aaaaaaan;
            int i2 = this.aaaeaaaa;
            if (i < i2) {
                if (i == 0) {
                    aaaaaaa0();
                } else {
                    aaaaaaaa(i2 - i);
                }
            }
        }
    }

    public static final class aaaaaaaa {
        private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaa0;
        private final List aaaaaaaa;
        private int aaaaaaac;
        int aaaaaaae;
        int aaaaaaan;
        private final int aaaaaaao;
        aaaaaaao[] aaaaaaau;
        int aaaaaaav;

        public aaaaaaaa(int i, aaaaoaaa aaaaoaaaVar) {
            this(i, i, aaaaoaaaVar);
        }

        private void aaaaaaa0() {
            Arrays.fill(this.aaaaaaau, (Object) null);
            this.aaaaaaan = this.aaaaaaau.length - 1;
            this.aaaaaaae = 0;
            this.aaaaaaav = 0;
        }

        private void aaaaaaaa() {
            int i = this.aaaaaaac;
            int i2 = this.aaaaaaav;
            if (i < i2) {
                if (i == 0) {
                    aaaaaaa0();
                } else {
                    aaaaaaa0(i2 - i);
                }
            }
        }

        private boolean aaaaaaac(int i) {
            return i >= 0 && i <= aaaaaaac.aaaaaaaa.length - 1;
        }

        private void aaaaaaae(int i) {
            this.aaaaaaaa.add(new aaaaaaao(aaaaaaao(i), aaaaaaau()));
        }

        private void aaaaaaau(int i) {
            if (aaaaaaac(i)) {
                this.aaaaaaaa.add(aaaaaaac.aaaaaaaa[i]);
                return;
            }
            int aaaaaaaa = aaaaaaaa(i - aaaaaaac.aaaaaaaa.length);
            if (aaaaaaaa >= 0) {
                aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaau;
                if (aaaaaaaa < aaaaaaaoVarArr.length) {
                    this.aaaaaaaa.add(aaaaaaaoVarArr[aaaaaaaa]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void aaaaaaav() {
            this.aaaaaaaa.add(new aaaaaaao(aaaaaaac.aaaaaaaa(aaaaaaau()), aaaaaaau()));
        }

        public void aaaaaaan() {
            while (!this.aaaaaaa0.aaaaaaan()) {
                byte readByte = this.aaaaaaa0.readByte();
                int i = readByte & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    aaaaaaau(aaaaaaaa(i, 127) - 1);
                } else if (i == 64) {
                    aaaaaaae();
                } else if ((readByte & 64) == 64) {
                    aaaaaaan(aaaaaaaa(i, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int aaaaaaaa = aaaaaaaa(i, 31);
                    this.aaaaaaac = aaaaaaaa;
                    if (aaaaaaaa < 0 || aaaaaaaa > this.aaaaaaao) {
                        throw new IOException("Invalid dynamic table size update " + this.aaaaaaac);
                    }
                    aaaaaaaa();
                } else if (i == 16 || i == 0) {
                    aaaaaaav();
                } else {
                    aaaaaaae(aaaaaaaa(i, 15) - 1);
                }
            }
        }

        public List aaaaaaao() {
            ArrayList arrayList = new ArrayList(this.aaaaaaaa);
            this.aaaaaaaa.clear();
            return arrayList;
        }

        public aaaaaaaa(int i, int i2, aaaaoaaa aaaaoaaaVar) {
            this.aaaaaaaa = new ArrayList();
            this.aaaaaaau = new aaaaaaao[8];
            this.aaaaaaan = 7;
            this.aaaaaaae = 0;
            this.aaaaaaav = 0;
            this.aaaaaaao = i;
            this.aaaaaaac = i2;
            this.aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa.aaaaaaaa(aaaaoaaaVar);
        }

        private int aaaaaaac() {
            return this.aaaaaaa0.readByte() & 255;
        }

        private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaao(int i) {
            if (aaaaaaac(i)) {
                return aaaaaaac.aaaaaaaa[i].aaaaaaaa;
            }
            int aaaaaaaa = aaaaaaaa(i - aaaaaaac.aaaaaaaa.length);
            if (aaaaaaaa >= 0) {
                aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaau;
                if (aaaaaaaa < aaaaaaaoVarArr.length) {
                    return aaaaaaaoVarArr[aaaaaaaa].aaaaaaaa;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int aaaaaaaa(int i) {
            return this.aaaaaaan + 1 + i;
        }

        private void aaaaaaae() {
            aaaaaaaa(-1, new aaaaaaao(aaaaaaac.aaaaaaaa(aaaaaaau()), aaaaaaau()));
        }

        private int aaaaaaa0(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.aaaaaaau.length;
                while (true) {
                    length--;
                    i2 = this.aaaaaaan;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.aaaaaaau[length].aaaaaaao;
                    i -= i4;
                    this.aaaaaaav -= i4;
                    this.aaaaaaae--;
                    i3++;
                }
                aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaau;
                int i5 = i2 + 1;
                System.arraycopy(aaaaaaaoVarArr, i5, aaaaaaaoVarArr, i5 + i3, this.aaaaaaae);
                this.aaaaaaan += i3;
            }
            return i3;
        }

        private void aaaaaaaa(int i, aaaaaaao aaaaaaaoVar) {
            this.aaaaaaaa.add(aaaaaaaoVar);
            int i2 = aaaaaaaoVar.aaaaaaao;
            if (i != -1) {
                i2 -= this.aaaaaaau[aaaaaaaa(i)].aaaaaaao;
            }
            int i3 = this.aaaaaaac;
            if (i2 > i3) {
                aaaaaaa0();
                return;
            }
            int aaaaaaa0 = aaaaaaa0((this.aaaaaaav + i2) - i3);
            if (i == -1) {
                int i4 = this.aaaaaaae + 1;
                aaaaaaao[] aaaaaaaoVarArr = this.aaaaaaau;
                if (i4 > aaaaaaaoVarArr.length) {
                    aaaaaaao[] aaaaaaaoVarArr2 = new aaaaaaao[aaaaaaaoVarArr.length * 2];
                    System.arraycopy(aaaaaaaoVarArr, 0, aaaaaaaoVarArr2, aaaaaaaoVarArr.length, aaaaaaaoVarArr.length);
                    this.aaaaaaan = this.aaaaaaau.length - 1;
                    this.aaaaaaau = aaaaaaaoVarArr2;
                }
                int i5 = this.aaaaaaan;
                this.aaaaaaan = i5 - 1;
                this.aaaaaaau[i5] = aaaaaaaoVar;
                this.aaaaaaae++;
            } else {
                this.aaaaaaau[aaaaaaaa(i) + aaaaaaa0 + i] = aaaaaaaoVar;
            }
            this.aaaaaaav += i2;
        }

        public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaau() {
            int aaaaaaac = aaaaaaac();
            boolean z = (aaaaaaac & r.b.d) == 128;
            int aaaaaaaa = aaaaaaaa(aaaaaaac, 127);
            if (z) {
                return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaaa(aaaaeaaa.aaaaaaa0().aaaaaaaa(this.aaaaaaa0.aaaaaaao(aaaaaaaa)));
            }
            return this.aaaaaaa0.aaaaaaa0(aaaaaaaa);
        }

        private void aaaaaaan(int i) {
            aaaaaaaa(-1, new aaaaaaao(aaaaaaao(i), aaaaaaau()));
        }

        public int aaaaaaaa(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int aaaaaaac = aaaaaaac();
                if ((aaaaaaac & r.b.d) == 0) {
                    return i2 + (aaaaaaac << i4);
                }
                i2 += (aaaaaaac & 127) << i4;
                i4 += 7;
            }
        }
    }

    static {
        aaaaaaao aaaaaaaoVar = new aaaaaaao(aaaaaaao.aaaaaaeo, "");
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar = aaaaaaao.aaaaaaan;
        aaaaaaao aaaaaaaoVar2 = new aaaaaaao(aaaaaaanVar, an.c);
        aaaaaaao aaaaaaaoVar3 = new aaaaaaao(aaaaaaanVar, an.b);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar2 = aaaaaaao.aaaaaaae;
        aaaaaaao aaaaaaaoVar4 = new aaaaaaao(aaaaaaanVar2, "/");
        aaaaaaao aaaaaaaoVar5 = new aaaaaaao(aaaaaaanVar2, "/index.html");
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar3 = aaaaaaao.aaaaaaav;
        aaaaaaao aaaaaaaoVar6 = new aaaaaaao(aaaaaaanVar3, Constants.HTTP);
        aaaaaaao aaaaaaaoVar7 = new aaaaaaao(aaaaaaanVar3, "https");
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar4 = aaaaaaao.aaaaaaau;
        aaaaaaaa = new aaaaaaao[]{aaaaaaaoVar, aaaaaaaoVar2, aaaaaaaoVar3, aaaaaaaoVar4, aaaaaaaoVar5, aaaaaaaoVar6, aaaaaaaoVar7, new aaaaaaao(aaaaaaanVar4, "200"), new aaaaaaao(aaaaaaanVar4, "204"), new aaaaaaao(aaaaaaanVar4, "206"), new aaaaaaao(aaaaaaanVar4, "304"), new aaaaaaao(aaaaaaanVar4, "400"), new aaaaaaao(aaaaaaanVar4, cm.b), new aaaaaaao(aaaaaaanVar4, "500"), new aaaaaaao("accept-charset", ""), new aaaaaaao("accept-encoding", "gzip, deflate"), new aaaaaaao("accept-language", ""), new aaaaaaao("accept-ranges", ""), new aaaaaaao("accept", ""), new aaaaaaao("access-control-allow-origin", ""), new aaaaaaao("age", ""), new aaaaaaao("allow", ""), new aaaaaaao("authorization", ""), new aaaaaaao("cache-control", ""), new aaaaaaao("content-disposition", ""), new aaaaaaao("content-encoding", ""), new aaaaaaao("content-language", ""), new aaaaaaao("content-length", ""), new aaaaaaao("content-location", ""), new aaaaaaao("content-range", ""), new aaaaaaao("content-type", ""), new aaaaaaao("cookie", ""), new aaaaaaao("date", ""), new aaaaaaao(com.sigmob.sdk.downloader.core.breakpoint.f.c, ""), new aaaaaaao("expect", ""), new aaaaaaao("expires", ""), new aaaaaaao("from", ""), new aaaaaaao("host", ""), new aaaaaaao("if-match", ""), new aaaaaaao("if-modified-since", ""), new aaaaaaao("if-none-match", ""), new aaaaaaao("if-range", ""), new aaaaaaao("if-unmodified-since", ""), new aaaaaaao("last-modified", ""), new aaaaaaao("link", ""), new aaaaaaao("location", ""), new aaaaaaao("max-forwards", ""), new aaaaaaao("proxy-authenticate", ""), new aaaaaaao("proxy-authorization", ""), new aaaaaaao("range", ""), new aaaaaaao("referer", ""), new aaaaaaao("refresh", ""), new aaaaaaao("retry-after", ""), new aaaaaaao("server", ""), new aaaaaaao("set-cookie", ""), new aaaaaaao("strict-transport-security", ""), new aaaaaaao("transfer-encoding", ""), new aaaaaaao("user-agent", ""), new aaaaaaao("vary", ""), new aaaaaaao("via", ""), new aaaaaaao("www-authenticate", "")};
        aaaaaaa0 = aaaaaaaa();
        PteDr();
    }

    private static /* synthetic */ void PteDr() {
        char[] charArray = "\u00ad¡£à©¯£«à¬¡·à½¦«¢¢à\u0084 §\u008c¼§ª©«".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 206);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u00ad¢§ §º".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 206);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Map aaaaaaaa() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(aaaaaaaa.length);
        int i = 0;
        while (true) {
            aaaaaaao[] aaaaaaaoVarArr = aaaaaaaa;
            if (i >= aaaaaaaoVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aaaaaaaoVarArr[i].aaaaaaaa)) {
                linkedHashMap.put(aaaaaaaoVarArr[i].aaaaaaaa, Integer.valueOf(i));
            }
            i++;
        }
    }

    public static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar) {
        int aaaaaaac = aaaaaaanVar.aaaaaaac();
        for (int i = 0; i < aaaaaaac; i++) {
            byte aaaaaaaa2 = aaaaaaanVar.aaaaaaaa(i);
            if (aaaaaaaa2 >= 65 && aaaaaaaa2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + aaaaaaanVar.aaaaaaae());
            }
        }
        return aaaaaaanVar;
    }
}
