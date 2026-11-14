package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import com.bykv.vk.component.ttvideo.player.C;
import com.sigmob.sdk.downloader.f;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaae implements Closeable {
    static final /* synthetic */ boolean aaaaaaca = true;
    private static final ExecutorService aaaaacaa = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("OkHttp Http2Connection", true));
    final aaaeaaaa aaaaaaa0;
    final boolean aaaaaaaa;
    final String aaaaaaac;
    private boolean aaaaaaae;
    int aaaaaaan;
    int aaaaaaau;
    private final ScheduledExecutorService aaaaaaav;
    private final ExecutorService aaaaaaeo;
    final aaaaaaea aaaaaaoa;
    final Set aaaacaaa;
    long aaaaoaaa;
    final aaaaaeaa aaacaaaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa aaaeaaaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa aacaaaaa;
    final Socket acaaaaaa;
    final Map aaaaaaao = new LinkedHashMap();
    private long aaaaeaaa = 0;
    private long aaaaaeaa = 0;
    private long aaaaaaea = 0;
    private long eaaaaaaa = 0;
    private long aeaaaaaa = 0;
    private long aoaaaaaa = 0;
    private long aaoaaaaa = 0;
    long aaaoaaaa = 0;
    aaaaaaea aaaaaoaa = new aaaaaaea();

    public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ long aaaaaaao;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaa0(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = j;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            try {
                aaaaaaae.this.aacaaaaa.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao);
            } catch (IOException unused) {
                aaaaaaae.this.aaaeaaaa();
            }
        }
    }

    public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaao;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaaa(String str, Object[] objArr, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = aaaaaaa0Var;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            try {
                aaaaaaae.this.aaaaaaa0(this.aaaaaaa0, this.aaaaaaao);
            } catch (IOException unused) {
                aaaaaaae.this.aaaeaaaa();
            }
        }
    }

    public class aaaaaaac extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ List aaaaaaao;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaac(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = list;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            if (aaaaaaae.this.aaaeaaaa.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao)) {
                try {
                    aaaaaaae.this.aacaaaaa.aaaaaaaa(this.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
                    synchronized (aaaaaaae.this) {
                        aaaaaaae.this.aaaacaaa.remove(Integer.valueOf(this.aaaaaaa0));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae$aaaaaaae, reason: collision with other inner class name */
    public class C0519aaaaaaae extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaao;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0519aaaaaaae(String str, Object[] objArr, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = aaaaaaa0Var;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            aaaaaaae.this.aaaeaaaa.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao);
            synchronized (aaaaaaae.this) {
                aaaaaaae.this.aaaacaaa.remove(Integer.valueOf(this.aaaaaaa0));
            }
        }
    }

    public class aaaaaaan extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ int aaaaaaac;
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaao;
        final /* synthetic */ boolean aaaaaaau;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaan(String str, Object[] objArr, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, int i2, boolean z) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = aaaaaaaoVar;
            this.aaaaaaac = i2;
            this.aaaaaaau = z;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            try {
                boolean aaaaaaaa = aaaaaaae.this.aaaeaaaa.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac, this.aaaaaaau);
                if (aaaaaaaa) {
                    aaaaaaae.this.aacaaaaa.aaaaaaaa(this.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
                }
                if (aaaaaaaa || this.aaaaaaau) {
                    synchronized (aaaaaaae.this) {
                        aaaaaaae.this.aaaacaaa.remove(Integer.valueOf(this.aaaaaaa0));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        public aaaaaaao(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            aaaaaaae.this.aaaaaaaa(false, 2, 0);
        }
    }

    public class aaaaaaau extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final /* synthetic */ int aaaaaaa0;
        final /* synthetic */ boolean aaaaaaac;
        final /* synthetic */ List aaaaaaao;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public aaaaaaau(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.aaaaaaa0 = i;
            this.aaaaaaao = list;
            this.aaaaaaac = z;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            boolean aaaaaaaa = aaaaaaae.this.aaaeaaaa.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac);
            if (aaaaaaaa) {
                try {
                    aaaaaaae.this.aacaaaaa.aaaaaaaa(this.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (aaaaaaaa || this.aaaaaaac) {
                synchronized (aaaaaaae.this) {
                    aaaaaaae.this.aaaacaaa.remove(Integer.valueOf(this.aaaaaaa0));
                }
            }
        }
    }

    public final class aaaaaaeo extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        public aaaaaaeo() {
            super("OkHttp %s ping", aaaaaaae.this.aaaaaaac);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            boolean z;
            synchronized (aaaaaaae.this) {
                if (aaaaaaae.this.aaaaaeaa < aaaaaaae.this.aaaaeaaa) {
                    z = true;
                } else {
                    aaaaaaae.aaaaaaau(aaaaaaae.this);
                    z = false;
                }
            }
            if (z) {
                aaaaaaae.this.aaaeaaaa();
            } else {
                aaaaaaae.this.aaaaaaaa(false, 1, 0);
            }
        }
    }

    public class aaaaaeaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 implements aaaaaaav.aaaaaaa0 {
        final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav aaaaaaa0;

        public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
            final /* synthetic */ boolean aaaaaaa0;
            final /* synthetic */ aaaaaaea aaaaaaao;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public aaaaaaa0(String str, Object[] objArr, boolean z, aaaaaaea aaaaaaeaVar) {
                super(str, objArr);
                this.aaaaaaa0 = z;
                this.aaaaaaao = aaaaaaeaVar;
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
            public void aaaaaaa0() {
                aaaaaeaa.this.aaaaaaa0(this.aaaaaaa0, this.aaaaaaao);
            }
        }

        public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
            final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaa0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public aaaaaaaa(String str, Object[] objArr, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar) {
                super(str, objArr);
                this.aaaaaaa0 = aaaaaaeoVar;
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
            public void aaaaaaa0() {
                try {
                    aaaaaaae.this.aaaaaaa0.aaaaaaaa(this.aaaaaaa0);
                } catch (IOException e) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(4, "Http2Connection.Listener failure for " + aaaaaaae.this.aaaaaaac, e);
                    try {
                        this.aaaaaaa0.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public class aaaaaaao extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
            public aaaaaaao(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
            public void aaaaaaa0() {
                aaaaaaae aaaaaaaeVar = aaaaaaae.this;
                aaaaaaaeVar.aaaaaaa0.aaaaaaaa(aaaaaaaeVar);
            }
        }

        public aaaaaeaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav aaaaaaavVar) {
            super("OkHttp %s", aaaaaaae.this.aaaaaaac);
            this.aaaaaaa0 = aaaaaaavVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            Throwable th;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.INTERNAL_ERROR;
            try {
                try {
                    this.aaaaaaa0.aaaaaaaa(this);
                    while (this.aaaaaaa0.aaaaaaaa(false, (aaaaaaav.aaaaaaa0) this)) {
                    }
                    aaaaaaa0Var = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.NO_ERROR;
                    try {
                        try {
                            aaaaaaae.this.aaaaaaaa(aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
                        } catch (IOException unused) {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.PROTOCOL_ERROR;
                            aaaaaaae.this.aaaaaaaa(aaaaaaa0Var3, aaaaaaa0Var3);
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            aaaaaaae.this.aaaaaaaa(aaaaaaa0Var, aaaaaaa0Var2);
                        } catch (IOException unused2) {
                        }
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                aaaaaaa0Var = aaaaaaa0Var2;
            } catch (Throwable th3) {
                th = th3;
                aaaaaaa0Var = aaaaaaa0Var2;
                aaaaaaae.this.aaaaaaaa(aaaaaaa0Var, aaaaaaa0Var2);
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0);
                throw th;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(int i, int i2, int i3, boolean z) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(boolean z, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i2) {
            if (aaaaaaae.this.aaaaaaa0(i)) {
                aaaaaaae.this.aaaaaaaa(i, aaaaaaauVar, i2, z);
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa2 = aaaaaaae.this.aaaaaaaa(i);
            if (aaaaaaaa2 == null) {
                aaaaaaae.this.aaaaaaao(i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.PROTOCOL_ERROR);
                long j = i2;
                aaaaaaae.this.aaaaaaae(j);
                aaaaaaauVar.skip(j);
                return;
            }
            aaaaaaaa2.aaaaaaaa(aaaaaaauVar, i2);
            if (z) {
                aaaaaaaa2.aaaaaaeo();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(boolean z, int i, int i2, List list) {
            if (aaaaaaae.this.aaaaaaa0(i)) {
                aaaaaaae.this.aaaaaaa0(i, list, z);
                return;
            }
            synchronized (aaaaaaae.this) {
                try {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa2 = aaaaaaae.this.aaaaaaaa(i);
                    if (aaaaaaaa2 == null) {
                        if (aaaaaaae.this.aaaaaaae) {
                            return;
                        }
                        aaaaaaae aaaaaaaeVar = aaaaaaae.this;
                        if (i <= aaaaaaaeVar.aaaaaaau) {
                            return;
                        }
                        if (i % 2 == aaaaaaaeVar.aaaaaaan % 2) {
                            return;
                        }
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo(i, aaaaaaae.this, false, z, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(list));
                        aaaaaaae aaaaaaaeVar2 = aaaaaaae.this;
                        aaaaaaaeVar2.aaaaaaau = i;
                        aaaaaaaeVar2.aaaaaaao.put(Integer.valueOf(i), aaaaaaeoVar);
                        aaaaaaae.aaaaacaa.execute(new aaaaaaaa("OkHttp %s stream %d", new Object[]{aaaaaaae.this.aaaaaaac, Integer.valueOf(i)}, aaaaaaeoVar));
                        return;
                    }
                    aaaaaaaa2.aaaaaaaa(list);
                    if (z) {
                        aaaaaaaa2.aaaaaaeo();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void aaaaaaa0(boolean z, aaaaaaea aaaaaaeaVar) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[] aaaaaaeoVarArr;
            long j;
            synchronized (aaaaaaae.this.aacaaaaa) {
                synchronized (aaaaaaae.this) {
                    try {
                        int aaaaaaao2 = aaaaaaae.this.aaaaaaoa.aaaaaaao();
                        if (z) {
                            aaaaaaae.this.aaaaaaoa.aaaaaaaa();
                        }
                        aaaaaaae.this.aaaaaaoa.aaaaaaaa(aaaaaaeaVar);
                        int aaaaaaao3 = aaaaaaae.this.aaaaaaoa.aaaaaaao();
                        aaaaaaeoVarArr = null;
                        if (aaaaaaao3 == -1 || aaaaaaao3 == aaaaaaao2) {
                            j = 0;
                        } else {
                            j = aaaaaaao3 - aaaaaaao2;
                            if (!aaaaaaae.this.aaaaaaao.isEmpty()) {
                                aaaaaaeoVarArr = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[]) aaaaaaae.this.aaaaaaao.values().toArray(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[aaaaaaae.this.aaaaaaao.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    aaaaaaae aaaaaaaeVar = aaaaaaae.this;
                    aaaaaaaeVar.aacaaaaa.aaaaaaaa(aaaaaaaeVar.aaaaaaoa);
                } catch (IOException unused) {
                    aaaaaaae.this.aaaeaaaa();
                }
            }
            if (aaaaaaeoVarArr != null) {
                for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar : aaaaaaeoVarArr) {
                    synchronized (aaaaaaeoVar) {
                        aaaaaaeoVar.aaaaaaaa(j);
                    }
                }
            }
            aaaaaaae.aaaaacaa.execute(new aaaaaaao("OkHttp %s settings", aaaaaaae.this.aaaaaaac));
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
            if (aaaaaaae.this.aaaaaaa0(i)) {
                aaaaaaae.this.aaaaaaaa(i, aaaaaaa0Var);
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaao2 = aaaaaaae.this.aaaaaaao(i);
            if (aaaaaaao2 != null) {
                aaaaaaao2.aaaaaaac(aaaaaaa0Var);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(boolean z, aaaaaaea aaaaaaeaVar) {
            try {
                aaaaaaae.this.aaaaaaav.execute(new aaaaaaa0("OkHttp %s ACK Settings", new Object[]{aaaaaaae.this.aaaaaaac}, z, aaaaaaeaVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(boolean z, int i, int i2) {
            if (!z) {
                try {
                    aaaaaaae.this.aaaaaaav.execute(aaaaaaae.this.new aaaaeaaa(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (aaaaaaae.this) {
                try {
                    if (i == 1) {
                        aaaaaaae.aaaaaaao(aaaaaaae.this);
                    } else if (i == 2) {
                        aaaaaaae.aaaaaaav(aaaaaaae.this);
                    } else if (i == 3) {
                        aaaaaaae.aaaaaaeo(aaaaaaae.this);
                        aaaaaaae.this.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[] aaaaaaeoVarArr;
            aaaaaaanVar.aaaaaaac();
            synchronized (aaaaaaae.this) {
                aaaaaaeoVarArr = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[]) aaaaaaae.this.aaaaaaao.values().toArray(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[aaaaaaae.this.aaaaaaao.size()]);
                aaaaaaae.this.aaaaaaae = true;
            }
            for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar : aaaaaaeoVarArr) {
                if (aaaaaaeoVar.aaaaaaao() > i && aaaaaaeoVar.aaaaaaan()) {
                    aaaaaaeoVar.aaaaaaac(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.REFUSED_STREAM);
                    aaaaaaae.this.aaaaaaao(aaaaaaeoVar.aaaaaaao());
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(int i, long j) {
            if (i == 0) {
                synchronized (aaaaaaae.this) {
                    aaaaaaae aaaaaaaeVar = aaaaaaae.this;
                    aaaaaaaeVar.aaaaoaaa += j;
                    aaaaaaaeVar.notifyAll();
                }
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa2 = aaaaaaae.this.aaaaaaaa(i);
            if (aaaaaaaa2 != null) {
                synchronized (aaaaaaaa2) {
                    aaaaaaaa2.aaaaaaaa(j);
                }
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav.aaaaaaa0
        public void aaaaaaaa(int i, int i2, List list) {
            aaaaaaae.this.aaaaaaaa(i2, list);
        }
    }

    public final class aaaaeaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 {
        final boolean aaaaaaa0;
        final int aaaaaaac;
        final int aaaaaaao;

        public aaaaeaaa(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", aaaaaaae.this.aaaaaaac, Integer.valueOf(i), Integer.valueOf(i2));
            this.aaaaaaa0 = z;
            this.aaaaaaao = i;
            this.aaaaaaac = i2;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0
        public void aaaaaaa0() {
            aaaaaaae.this.aaaaaaaa(this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac);
        }
    }

    public static abstract class aaaeaaaa {
        public static final aaaeaaaa aaaaaaaa = new aaaaaaaa();

        public class aaaaaaaa extends aaaeaaaa {
            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaeaaaa
            public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar) {
                aaaaaaeoVar.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.REFUSED_STREAM);
            }
        }

        static {
            KrFbZC();
        }

        private static /* synthetic */ void KrFbZC() {
            char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 255);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 255);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public void aaaaaaaa(aaaaaaae aaaaaaaeVar) {
        }

        public abstract void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar);
    }

    static {
        uLFfXhD();
    }

    public aaaaaaae(aaaaaaav aaaaaaavVar) {
        aaaaaaea aaaaaaeaVar = new aaaaaaea();
        this.aaaaaaoa = aaaaaaeaVar;
        this.aaaacaaa = new LinkedHashSet();
        this.aaaeaaaa = aaaaaaavVar.aaaaaaan;
        boolean z = aaaaaaavVar.aaaaaaae;
        this.aaaaaaaa = z;
        this.aaaaaaa0 = aaaaaaavVar.aaaaaaau;
        int i = z ? 1 : 2;
        this.aaaaaaan = i;
        if (z) {
            this.aaaaaaan = i + 2;
        }
        if (z) {
            this.aaaaaoaa.aaaaaaaa(7, 16777216);
        }
        String str = aaaaaaavVar.aaaaaaa0;
        this.aaaaaaac = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("OkHttp %s Writer", str), false));
        this.aaaaaaav = scheduledThreadPoolExecutor;
        if (aaaaaaavVar.aaaaaaav != 0) {
            aaaaaaeo aaaaaaeoVar = new aaaaaaeo();
            long j = aaaaaaavVar.aaaaaaav;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(aaaaaaeoVar, j, j, TimeUnit.MILLISECONDS);
        }
        this.aaaaaaeo = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("OkHttp %s Push Observer", str), true));
        aaaaaaeaVar.aaaaaaaa(7, 65535);
        aaaaaaeaVar.aaaaaaaa(5, f.a.d);
        this.aaaaoaaa = aaaaaaeaVar.aaaaaaao();
        this.acaaaaaa = aaaaaaavVar.aaaaaaaa;
        this.aacaaaaa = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa(aaaaaaavVar.aaaaaaac, z);
        this.aaacaaaa = new aaaaaeaa(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaav(aaaaaaavVar.aaaaaaao, z));
    }

    public static /* synthetic */ long aaaaaaao(aaaaaaae aaaaaaaeVar) {
        long j = aaaaaaaeVar.aaaaaeaa;
        aaaaaaaeVar.aaaaaeaa = 1 + j;
        return j;
    }

    public static /* synthetic */ long aaaaaaau(aaaaaaae aaaaaaaeVar) {
        long j = aaaaaaaeVar.aaaaeaaa;
        aaaaaaaeVar.aaaaeaaa = 1 + j;
        return j;
    }

    public static /* synthetic */ long aaaaaaav(aaaaaaae aaaaaaaeVar) {
        long j = aaaaaaaeVar.eaaaaaaa;
        aaaaaaaeVar.eaaaaaaa = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaeaaaa() {
        try {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.PROTOCOL_ERROR;
            aaaaaaaa(aaaaaaa0Var, aaaaaaa0Var);
        } catch (IOException unused) {
        }
    }

    private static /* synthetic */ void uLFfXhD() {
        char[] charArray = "\u000b\u0007\u0005F\u000f\t\u0005\rF\n\u0007\u0011F\u001b\u0000\r\u0004\u0004F\"\u0006\u0001*\u001a\u0001\f\u000f\r".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'h');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000b\u0004\u0001\u0006\u0001\u001c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'h');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean aaaaaaa0(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public void aaaaaaea() {
        aaaaaaaa(true);
    }

    public void aaaaaeaa() {
        synchronized (this) {
            try {
                long j = this.eaaaaaaa;
                long j2 = this.aaaaaaea;
                if (j < j2) {
                    return;
                }
                this.aaaaaaea = j2 + 1;
                this.aaoaaaaa = System.nanoTime() + C.NANOS_PER_SECOND;
                try {
                    this.aaaaaaav.execute(new aaaaaaao("OkHttp %s ping", this.aaaaaaac));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized int aaaaeaaa() {
        return this.aaaaaaoa.aaaaaaa0(Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.NO_ERROR, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.CANCEL);
    }

    public void flush() {
        this.aacaaaaa.flush();
    }

    public static /* synthetic */ long aaaaaaeo(aaaaaaae aaaaaaaeVar) {
        long j = aaaaaaaeVar.aoaaaaaa;
        aaaaaaaeVar.aoaaaaaa = 1 + j;
        return j;
    }

    public synchronized void aaaaaaae(long j) {
        long j2 = this.aaaoaaaa + j;
        this.aaaoaaaa = j2;
        if (j2 >= this.aaaaaoaa.aaaaaaao() / 2) {
            aaaaaaaa(0, this.aaaoaaaa);
            this.aaaoaaaa = 0L;
        }
    }

    public synchronized boolean aaaaaaan(long j) {
        if (this.aaaaaaae) {
            return false;
        }
        if (this.eaaaaaaa < this.aaaaaaea) {
            if (j >= this.aaoaaaaa) {
                return false;
            }
        }
        return true;
    }

    public synchronized io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaao(int i) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar;
        aaaaaaeoVar = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo) this.aaaaaaao.remove(Integer.valueOf(i));
        notifyAll();
        return aaaaaaeoVar;
    }

    public void aaaaaaa0(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        this.aacaaaaa.aaaaaaaa(i, aaaaaaa0Var);
    }

    public synchronized io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa(int i) {
        return (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo) this.aaaaaaao.get(Integer.valueOf(i));
    }

    public static class aaaaaaav {
        String aaaaaaa0;
        Socket aaaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaac;
        boolean aaaaaaae;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaao;
        int aaaaaaav;
        aaaeaaaa aaaaaaau = aaaeaaaa.aaaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaeaa.aaaaaaaa;

        public aaaaaaav(boolean z) {
            this.aaaaaaae = z;
        }

        public aaaaaaav aaaaaaaa(Socket socket, String str, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaaaaacVar) {
            this.aaaaaaaa = socket;
            this.aaaaaaa0 = str;
            this.aaaaaaao = aaaaaaauVar;
            this.aaaaaaac = aaaaaaacVar;
            return this;
        }

        public aaaaaaav aaaaaaaa(aaaeaaaa aaaeaaaaVar) {
            this.aaaaaaau = aaaeaaaaVar;
            return this;
        }

        public aaaaaaav aaaaaaaa(int i) {
            this.aaaaaaav = i;
            return this;
        }

        public aaaaaaae aaaaaaaa() {
            return new aaaaaaae(this);
        }
    }

    public void aaaaaaa0(int i, List list, boolean z) {
        try {
            try {
                aaaaaaaa(new aaaaaaau("OkHttp %s Push Headers[%s]", new Object[]{this.aaaaaaac, Integer.valueOf(i)}, i, list, z));
            } catch (RejectedExecutionException unused) {
            }
        } catch (RejectedExecutionException unused2) {
        }
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa(List list, boolean z) {
        return aaaaaaaa(0, list, z);
    }

    public void aaaaaaao(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        try {
            this.aaaaaaav.execute(new aaaaaaaa("OkHttp %s stream %d", new Object[]{this.aaaaaaac, Integer.valueOf(i)}, i, aaaaaaa0Var));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[Catch: all -> 0x003d, TryCatch #4 {all -> 0x003d, blocks: (B:15:0x0027, B:17:0x002c, B:19:0x0034, B:23:0x0041, B:25:0x0047, B:26:0x0050, B:49:0x0080, B:42:0x007a, B:43:0x007f), top: B:4:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053 A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #3 {all -> 0x0059, blocks: (B:28:0x0053, B:29:0x0065, B:34:0x005c, B:36:0x0060, B:37:0x006e, B:38:0x0075, B:57:0x0085, B:50:0x0081), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c A[Catch: all -> 0x0059, TryCatch #3 {all -> 0x0059, blocks: (B:28:0x0053, B:29:0x0065, B:34:0x005c, B:36:0x0060, B:37:0x006e, B:38:0x0075, B:57:0x0085, B:50:0x0081), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaaa(int r10, java.util.List r11, boolean r12) {
        /*
            r9 = this;
            r3 = r12 ^ 1
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r6 = r9.aacaaaaa
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L82
            int r0 = r9.aaaaaaan     // Catch: java.lang.Throwable -> L76
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L18
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 r0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.REFUSED_STREAM     // Catch: java.lang.Throwable -> L13
            r9.aaaaaaaa(r0)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L80
        L18:
            boolean r0 = r9.aaaaaaae     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L79
            int r1 = r9.aaaaaaan     // Catch: java.lang.Throwable -> L76
            int r0 = r1 + 2
            r9.aaaaaaan = r0     // Catch: java.lang.Throwable -> L76
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo r0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r4 = 0
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3d
            if (r12 == 0) goto L40
            long r4 = r2.aaaaoaaa     // Catch: java.lang.Throwable -> L3d
            r7 = 0
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 == 0) goto L40
            long r4 = r0.aaaaaaa0     // Catch: java.lang.Throwable -> L3d
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 != 0) goto L3b
            goto L40
        L3b:
            r12 = 0
            goto L41
        L3d:
            r0 = move-exception
        L3e:
            r10 = r0
            goto L80
        L40:
            r12 = 1
        L41:
            boolean r4 = r0.aaaaaaae()     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L50
            java.util.Map r4 = r2.aaaaaaao     // Catch: java.lang.Throwable -> L3d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L3d
            r4.put(r5, r0)     // Catch: java.lang.Throwable -> L3d
        L50:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L3d
            if (r10 != 0) goto L5c
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r4 = r2.aacaaaaa     // Catch: java.lang.Throwable -> L59
            r4.aaaaaaaa(r3, r1, r10, r11)     // Catch: java.lang.Throwable -> L59
            goto L65
        L59:
            r0 = move-exception
        L5a:
            r10 = r0
            goto L85
        L5c:
            boolean r3 = r2.aaaaaaaa     // Catch: java.lang.Throwable -> L59
            if (r3 != 0) goto L6e
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r3 = r2.aacaaaaa     // Catch: java.lang.Throwable -> L59
            r3.aaaaaaaa(r10, r1, r11)     // Catch: java.lang.Throwable -> L59
        L65:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L59
            if (r12 == 0) goto L6d
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r10 = r2.aacaaaaa
            r10.flush()
        L6d:
            return r0
        L6e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L59
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L59
            throw r10     // Catch: java.lang.Throwable -> L59
        L76:
            r0 = move-exception
            r2 = r9
            goto L3e
        L79:
            r2 = r9
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaaa r10 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaaa     // Catch: java.lang.Throwable -> L3d
            r10.<init>()     // Catch: java.lang.Throwable -> L3d
            throw r10     // Catch: java.lang.Throwable -> L3d
        L80:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L3d
            throw r10     // Catch: java.lang.Throwable -> L59
        L82:
            r0 = move-exception
            r2 = r9
            goto L5a
        L85:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L59
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaaaaaa(int, java.util.List, boolean):io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.aacaaaaa.aaaeaaaa());
        r6 = r3;
        r8.aaaaoaaa -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void aaaaaaaa(int r9, boolean r10, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r12 = r8.aacaaaaa
            r12.aaaaaaaa(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.aaaaoaaa     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map r3 = r8.aaaaaaao     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r3 = r8.aacaaaaa     // Catch: java.lang.Throwable -> L28
            int r3 = r3.aaaeaaaa()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.aaaaoaaa     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.aaaaoaaa = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaeaaaa r4 = r8.aacaaaaa
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.aaaaaaaa(r5, r9, r11, r3)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaaaaaa(int, boolean, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao, long):void");
    }

    public void aaaaaaaa(int i, long j) {
        try {
            this.aaaaaaav.execute(new aaaaaaa0("OkHttp Window Update %s stream %d", new Object[]{this.aaaaaaac, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void aaaaaaaa(boolean z, int i, int i2) {
        try {
            this.aacaaaaa.aaaaaaaa(z, i, i2);
        } catch (IOException unused) {
            aaaeaaaa();
        }
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        synchronized (this.aacaaaaa) {
            synchronized (this) {
                if (this.aaaaaaae) {
                    return;
                }
                this.aaaaaaae = true;
                this.aacaaaaa.aaaaaaaa(this.aaaaaaau, aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa);
            }
        }
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var2) {
        if (!aaaaaaca && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[] aaaaaaeoVarArr = null;
        try {
            aaaaaaaa(aaaaaaa0Var);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (!this.aaaaaaao.isEmpty()) {
                    aaaaaaeoVarArr = (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[]) this.aaaaaaao.values().toArray(new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo[this.aaaaaaao.size()]);
                    this.aaaaaaao.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aaaaaaeoVarArr != null) {
            for (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar : aaaaaaeoVarArr) {
                try {
                    aaaaaaeoVar.aaaaaaaa(aaaaaaa0Var2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.aacaaaaa.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.acaaaaaa.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.aaaaaaav.shutdown();
        this.aaaaaaeo.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void aaaaaaaa(boolean z) {
        if (z) {
            this.aacaaaaa.aaaaaaeo();
            this.aacaaaaa.aaaaaaa0(this.aaaaaoaa);
            if (this.aaaaaoaa.aaaaaaao() != 65535) {
                this.aacaaaaa.aaaaaaaa(0, r5 - 65535);
            }
        }
        new Thread(this.aaacaaaa).start();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:32:0x0046
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void aaaaaaaa(int r9, java.util.List r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set r0 = r8.aaaacaaa     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L18
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 r10 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r8.aaaaaaao(r9, r10)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L44
        L18:
            java.util.Set r0 = r8.aaaacaaa     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L41
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae$aaaaaaac r2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae$aaaaaaac     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.aaaaaaac     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 0
            r5[r3] = r0     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r0 = 1
            r5[r0] = r1     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5, r6, r7)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            r8.aaaaaaaa(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            return
        L3f:
            r3 = r8
        L40:
            return
        L41:
            r0 = move-exception
            r3 = r8
        L43:
            r9 = r0
        L44:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L46
            throw r9
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaaaaaa(int, java.util.List):void");
    }

    public void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaauVar, int i2, boolean z) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        long j = i2;
        aaaaaaauVar.aaaaaaau(j);
        aaaaaaauVar.aaaaaaaa(aaaaaaaoVar, j);
        if (aaaaaaaoVar.size() == j) {
            aaaaaaaa(new aaaaaaan("OkHttp %s Push Data[%s]", new Object[]{this.aaaaaaac, Integer.valueOf(i)}, i, aaaaaaaoVar, i2, z));
            return;
        }
        throw new IOException(aaaaaaaoVar.size() + " != " + i2);
    }

    public void aaaaaaaa(int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0 aaaaaaa0Var) {
        aaaaaaaa(new C0519aaaaaaae("OkHttp %s Push Reset[%s]", new Object[]{this.aaaaaaac, Integer.valueOf(i)}, i, aaaaaaa0Var));
    }

    private synchronized void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaa0 aaaaaaa0Var) {
        if (this.aaaaaaae) {
            return;
        }
        this.aaaaaaeo.execute(aaaaaaa0Var);
    }
}
