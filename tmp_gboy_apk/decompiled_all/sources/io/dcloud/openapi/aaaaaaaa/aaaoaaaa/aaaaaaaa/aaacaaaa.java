package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaacaaaa implements aaaaaaac {
    private static final Comparator aaaaaaav = new aaaaaaa0();
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaeaaaa aaaaaaa0;
    final acaaaaaa aaaaaaaa;
    private aoaaaaaa aaaaaaac;
    private boolean aaaaaaae;
    final boolean aaaaaaan;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa aaaaaaao;
    final aaaacaaa aaaaaaau;

    public class aaaaaaa0 implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa {
        public aaaaaaaa() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaaa
        public void aaaeaaaa() {
            aaacaaaa.this.aaaaaaaa();
        }
    }

    public final class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        static final /* synthetic */ boolean aaaaaaac = true;
        private final aaaaaaau aaaaaaa0;

        public aaaaaaao(aaaaaaau aaaaaaauVar) {
            super("OkHttp %s", aaacaaaa.this.aaaaaaau());
            this.aaaaaaa0 = aaaaaaauVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            aaacaaaa.this.aaaaaaao.aaaaaaav();
            boolean z = false;
            try {
                try {
                    try {
                        this.aaaaaaa0.aaaaaaaa(aaacaaaa.this, aaacaaaa.this.aaaaaaao());
                        aaacaaaa.this.aaaaaaaa.aaaaaaav().aaaaaaa0(this);
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        IOException aaaaaaaa = aaacaaaa.this.aaaaaaaa(e);
                        if (z) {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(4, "Callback failure for " + aaacaaaa.this.aaaaaaan(), aaaaaaaa);
                        } else {
                            aaacaaaa.this.aaaaaaac.aaaaaaaa(aaacaaaa.this, aaaaaaaa);
                            this.aaaaaaa0.aaaaaaaa(aaacaaaa.this, aaaaaaaa);
                        }
                        aaacaaaa.this.aaaaaaaa.aaaaaaav().aaaaaaa0(this);
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        aaacaaaa.this.aaaaaaaa();
                        if (!z) {
                            this.aaaaaaa0.aaaaaaaa(aaacaaaa.this, new IOException("canceled due to " + th));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    aaacaaaa.this.aaaaaaaa.aaaaaaav().aaaaaaa0(this);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public void aaaaaaaa(ExecutorService executorService) {
            if (!aaaaaaac && Thread.holdsLock(aaacaaaa.this.aaaaaaaa.aaaaaaav())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    aaacaaaa.this.aaaaaaac.aaaaaaaa(aaacaaaa.this, interruptedIOException);
                    this.aaaaaaa0.aaaaaaaa(aaacaaaa.this, interruptedIOException);
                    aaacaaaa.this.aaaaaaaa.aaaaaaav().aaaaaaa0(this);
                }
            } catch (Throwable th) {
                aaacaaaa.this.aaaaaaaa.aaaaaaav().aaaaaaa0(this);
                throw th;
            }
        }

        public String aaaaaaac() {
            return aaacaaaa.this.aaaaaaau.aaaaaaae().aaaaaaae();
        }

        public aaacaaaa aaaaaaao() {
            return aaacaaaa.this;
        }
    }

    static {
        OKrxm();
    }

    private aaacaaaa(acaaaaaa acaaaaaaVar, aaaacaaa aaaacaaaVar, boolean z) {
        this.aaaaaaaa = acaaaaaaVar;
        this.aaaaaaau = aaaacaaaVar;
        this.aaaaaaan = z;
        this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaeaaaa(acaaaaaaVar, z);
        aaaaaaaa aaaaaaaaVar = new aaaaaaaa();
        this.aaaaaaao = aaaaaaaaVar;
        aaaaaaaaVar.aaaaaaaa(acaaaaaaVar.aaaaaaa0(), TimeUnit.MILLISECONDS);
    }

    private static /* synthetic */ void OKrxm() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void aaaaaaa0() {
        this.aaaaaaa0.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa("response.body().close()"));
    }

    public boolean aaaaaaac() {
        return this.aaaaaaa0.aaaaaaa0();
    }

    public String aaaaaaan() {
        StringBuilder sb = new StringBuilder();
        sb.append(aaaaaaac() ? "canceled " : "");
        sb.append(this.aaaaaaan ? "web socket" : "call");
        sb.append(" to ");
        sb.append(aaaaaaau());
        return sb.toString();
    }

    public aaaaaaca aaaaaaao() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aaaaaaaa.eaaaaaaa());
        arrayList.add(this.aaaaaaa0);
        arrayList.add(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaaa(this.aaaaaaaa.aaaaaaae()));
        this.aaaaaaaa.aeaaaaaa();
        arrayList.add(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao.aaaaaaaa(null));
        arrayList.add(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaaa));
        if (!this.aaaaaaan) {
            arrayList.addAll(this.aaaaaaaa.aoaaaaaa());
        }
        arrayList.add(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaa0(this.aaaaaaan));
        aaaaaaca aaaaaaaa2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaae(arrayList, null, null, null, 0, this.aaaaaaau, this, this.aaaaaaac, this.aaaaaaaa.aaaaaaac(), this.aaaaaaaa.acaaaaaa(), this.aaaaaaaa.aaaaacaa()).aaaaaaaa(this.aaaaaaau);
        if (!this.aaaaaaa0.aaaaaaa0()) {
            return aaaaaaaa2;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        throw new IOException("Canceled");
    }

    public String aaaaaaau() {
        return this.aaaaaaau.aaaaaaae().aaaaaeaa();
    }

    public static aaacaaaa aaaaaaaa(acaaaaaa acaaaaaaVar, aaaacaaa aaaacaaaVar, boolean z) {
        aaacaaaa aaacaaaaVar = new aaacaaaa(acaaaaaaVar, aaaacaaaVar, z);
        aaacaaaaVar.aaaaaaac = acaaaaaaVar.aaaeaaaa().aaaaaaaa(aaacaaaaVar);
        return aaacaaaaVar;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public aaacaaaa m20clone() {
        return aaaaaaaa(this.aaaaaaaa, this.aaaaaaau, this.aaaaaaan);
    }

    public IOException aaaaaaaa(IOException iOException) {
        if (!this.aaaaaaao.aaaaaaeo()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac
    public void aaaaaaaa(aaaaaaau aaaaaaauVar) {
        synchronized (this) {
            if (!this.aaaaaaae) {
                this.aaaaaaae = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        aaaaaaa0();
        this.aaaaaaac.aaaaaaa0(this);
        this.aaaaaaaa.aaaaaaav().aaaaaaaa(new aaaaaaao(aaaaaaauVar));
    }

    public void aaaaaaaa() {
        this.aaaaaaa0.aaaaaaaa();
    }
}
