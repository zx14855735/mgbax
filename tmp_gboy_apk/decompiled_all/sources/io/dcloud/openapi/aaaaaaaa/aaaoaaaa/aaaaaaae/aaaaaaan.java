package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aacaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.ADYaiT;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaan implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao {
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaa0;
    private final aaaaaoaa.aaaaaaaa aaaaaaaa;
    private aaaaaaeo aaaaaaac;
    private final aaaaaaae aaaaaaao;
    private final aacaaaaa aaaaaaau;
    private static final List aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ADYaiT.TARGET_METHOD_UTF8, ADYaiT.TARGET_PATH_UTF8, ADYaiT.TARGET_SCHEME_UTF8, ADYaiT.TARGET_AUTHORITY_UTF8);
    private static final List aaaaaaae = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    static {
        zgvxP();
    }

    public aaaaaaan(acaaaaaa acaaaaaaVar, aaaaaoaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, aaaaaaae aaaaaaaeVar2) {
        this.aaaaaaaa = aaaaaaaaVar;
        this.aaaaaaa0 = aaaaaaaeVar;
        this.aaaaaaao = aaaaaaaeVar2;
        List aaaoaaaa = acaaaaaaVar.aaaoaaaa();
        aacaaaaa aacaaaaaVar = aacaaaaa.H2_PRIOR_KNOWLEDGE;
        this.aaaaaaau = aaaoaaaa.contains(aacaaaaaVar) ? aacaaaaaVar : aacaaaaa.HTTP_2;
    }

    private static /* synthetic */ void zgvxP() {
        char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ':');
        }
        String str = new String(charArray);
        char[] charArray2 = "YVSTSN".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ':');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaa0() {
        this.aaaaaaao.flush();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public aaaoaaaa aaaaaaaa(aaaacaaa aaaacaaaVar, long j) {
        return this.aaaaaaac.aaaaaaac();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void cancel() {
        aaaaaaeo aaaaaaeoVar = this.aaaaaaac;
        if (aaaaaaeoVar != null) {
            aaaaaaeoVar.aaaaaaao(aaaaaaa0.CANCEL);
        }
    }

    public static List aaaaaaa0(aaaacaaa aaaacaaaVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa aaaaaaao = aaaacaaaVar.aaaaaaao();
        ArrayList arrayList = new ArrayList(aaaaaaao.aaaaaaa0() + 4);
        arrayList.add(new aaaaaaao(aaaaaaao.aaaaaaan, aaaacaaaVar.aaaaaaau()));
        arrayList.add(new aaaaaaao(aaaaaaao.aaaaaaae, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaeo.aaaaaaaa(aaaacaaaVar.aaaaaaae())));
        String aaaaaaaa2 = aaaacaaaVar.aaaaaaaa("Host");
        if (aaaaaaaa2 != null) {
            arrayList.add(new aaaaaaao(aaaaaaao.aaaaaaeo, aaaaaaaa2));
        }
        arrayList.add(new aaaaaaao(aaaaaaao.aaaaaaav, aaaacaaaVar.aaaaaaae().aaaaaaea()));
        int aaaaaaa0 = aaaaaaao.aaaaaaa0();
        for (int i = 0; i < aaaaaaa0; i++) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaao2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(aaaaaaao.aaaaaaaa(i).toLowerCase(Locale.US));
            if (!aaaaaaan.contains(aaaaaaao2.aaaaaaae())) {
                arrayList.add(new aaaaaaao(aaaaaaao2, aaaaaaao.aaaaaaa0(i)));
            }
        }
        return arrayList;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaaa(aaaacaaa aaaacaaaVar) {
        if (this.aaaaaaac != null) {
            return;
        }
        aaaaaaeo aaaaaaaa2 = this.aaaaaaao.aaaaaaaa(aaaaaaa0(aaaacaaaVar), aaaacaaaVar.aaaaaaaa() != null);
        this.aaaaaaac = aaaaaaaa2;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa aaaaaaav = aaaaaaaa2.aaaaaaav();
        long aaaaaaa0 = this.aaaaaaaa.aaaaaaa0();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aaaaaaav.aaaaaaaa(aaaaaaa0, timeUnit);
        this.aaaaaaac.aaaaaeaa().aaaaaaaa(this.aaaaaaaa.aaaaaaao(), timeUnit);
    }

    public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaav {
        boolean aaaaaaa0;
        long aaaaaaao;

        public aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
            super(aaaaoaaaVar);
            this.aaaaaaa0 = false;
            this.aaaaaaao = 0L;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
        public long aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, long j) {
            try {
                long aaaaaaaa = aaaaaaeo().aaaaaaaa(aaaaaaaoVar, j);
                if (aaaaaaaa <= 0) {
                    return aaaaaaaa;
                }
                this.aaaaaaao += aaaaaaaa;
                return aaaaaaaa;
            } catch (IOException e) {
                aaaaaaaa(e);
                throw e;
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaav, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            aaaaaaaa(null);
        }

        private void aaaaaaaa(IOException iOException) {
            if (this.aaaaaaa0) {
                return;
            }
            this.aaaaaaa0 = true;
            aaaaaaan aaaaaaanVar = aaaaaaan.this;
            aaaaaaanVar.aaaaaaa0.aaaaaaaa(false, aaaaaaanVar, this.aaaaaaao, iOException);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public void aaaaaaaa() {
        this.aaaaaaac.aaaaaaac().close();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public aaaaaaca.aaaaaaaa aaaaaaaa(boolean z) {
        aaaaaaca.aaaaaaaa aaaaaaaa2 = aaaaaaaa(this.aaaaaaac.aaaeaaaa(), this.aaaaaaau);
        if (z && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaa2) == 100) {
            return null;
        }
        return aaaaaaaa2;
    }

    public static aaaaaaca.aaaaaaaa aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa aaaoaaaaVar, aacaaaaa aacaaaaaVar) {
        aaaoaaaa.aaaaaaaa aaaaaaaaVar = new aaaoaaaa.aaaaaaaa();
        int aaaaaaa0 = aaaoaaaaVar.aaaaaaa0();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaeaaa aaaaeaaaVar = null;
        for (int i = 0; i < aaaaaaa0; i++) {
            String aaaaaaaa2 = aaaoaaaaVar.aaaaaaaa(i);
            String aaaaaaa02 = aaaoaaaaVar.aaaaaaa0(i);
            if (aaaaaaaa2.equals(ADYaiT.RESPONSE_STATUS_UTF8)) {
                aaaaeaaaVar = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaeaaa.aaaaaaaa("HTTP/1.1 " + aaaaaaa02);
            } else if (!aaaaaaae.contains(aaaaaaaa2)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaaaaaVar, aaaaaaaa2, aaaaaaa02);
            }
        }
        if (aaaaeaaaVar != null) {
            return new aaaaaaca.aaaaaaaa().aaaaaaaa(aacaaaaaVar).aaaaaaaa(aaaaeaaaVar.aaaaaaa0).aaaaaaaa(aaaaeaaaVar.aaaaaaao).aaaaaaaa(aaaaaaaaVar.aaaaaaaa());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao
    public a0aaaaaa aaaaaaaa(aaaaaaca aaaaaacaVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar = this.aaaaaaa0;
        aaaaaaaeVar.aaaaaaan.aaaaaaau(aaaaaaaeVar.aaaaaaau);
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaav(aaaaaacaVar.aaaaaaa0("Content-Type"), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau.aaaaaaaa(aaaaaacaVar), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa.aaaaaaaa(new aaaaaaaa(this.aaaaaaac.aaaaaaau())));
    }
}
