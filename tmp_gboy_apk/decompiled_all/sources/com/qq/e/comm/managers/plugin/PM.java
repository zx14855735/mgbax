package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fl.saas.base.custom.MedProConst;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class PM {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final Map f12932B4ZgIw;
    public static final int CALL_START_BY_DEV = 1;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ExecutorService f12933A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f12934A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public String f12935A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public File f12936ADYaiT;
    public volatile int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public DexClassLoader f12937ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public RandomAccessFile f12938ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f12939AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public volatile POFactory f12940AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f12941AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f12942AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Future f12943AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f12944AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f12945AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public String f12946AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public JSONObject f12947B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final com.qq.e.comm.util.b f12948B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f12949B3GDIM;

    class a implements Callable<Boolean> {
        public a() {
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            PM pm = PM.this;
            pm.f12948B2KMhB.c();
            Context context = pm.f12934A4TApA;
            h.b(context);
            com.qq.e.comm.util.b bVar = pm.f12948B2KMhB;
            bVar.b();
            SharedPreferences sharedPreferences = context.getSharedPreferences("start_crash", 0);
            if (sharedPreferences.getInt("crash_count", 0) >= 2) {
                pm.f12945AmA8tU = true;
                sharedPreferences.edit().remove("crash_count").commit();
                GDTLogger.e("加载本地插件");
            }
            bVar.b();
            if (!pm.f12939AYUAbz) {
                pm.f12939AYUAbz = pm.tryLockUpdate();
            }
            bVar.b();
            try {
                System.currentTimeMillis();
                boolean A5SV6n2 = pm.A5SV6n();
                bVar.b();
                z = A5SV6n2 ? true : pm.A4TApA();
                bVar.b();
                System.currentTimeMillis();
            } catch (Throwable th) {
                try {
                    GDTLogger.e("插件加载出现异常", th);
                    com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                    System.currentTimeMillis();
                    z = false;
                } catch (Throwable th2) {
                    System.currentTimeMillis();
                    throw th2;
                }
            }
            if (z) {
                pm.f12942AaHO0E = (int) (System.currentTimeMillis() - currentTimeMillis);
                File file = pm.f12936ADYaiT;
                if (file != null) {
                    file.getAbsolutePath();
                }
                if (pm.f12935A5SV6n == null || pm.f12936ADYaiT == null) {
                    pm.f12937ARc23Z = null;
                } else {
                    try {
                        pm.f12937ARc23Z = new DexClassLoader(pm.f12936ADYaiT.getAbsolutePath(), context.getDir(h.f12963A4TApA, 0).getAbsolutePath(), null, pm.getClass().getClassLoader());
                    } catch (Throwable th3) {
                        GDTLogger.e("插件ClassLoader构造发生异常", th3);
                        com.qq.e.comm.managers.plugin.a.a(th3, th3.getMessage());
                    }
                }
            }
            bVar.a();
            pm.f12941AZkASS = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    public class b extends HashMap<Class<?>, String> {
    }

    static {
        b bVar = new b();
        bVar.put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        f12932B4ZgIw = bVar;
        TetMcu();
    }

    public PM(Context context, f fVar) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f12933A2egSU = newSingleThreadExecutor;
        this.f12944AlLFFp = false;
        this.f12934A4TApA = context.getApplicationContext();
        this.f12948B2KMhB = new com.qq.e.comm.util.b();
        i.a(context);
        this.f12944AlLFFp = false;
        this.f12943AcNBzu = newSingleThreadExecutor.submit(new a());
    }

    private static /* synthetic */ void TetMcu() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final JSONObject A2egSU() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.f12946AzWtSf);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.f12935A5SV6n);
            jSONObject.put(MedProConst.AD_APPID, com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", i.a(this.f12934A4TApA));
            jSONObject.put("ict", this.f12941AZkASS);
            jSONObject.put("mup", this.f12939AYUAbz);
            jSONObject.put("ifg", this.f12949B3GDIM);
            jSONObject.put("pct", this.f12942AaHO0E);
            jSONObject.put("tcr", this.f12948B2KMhB.toString());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean A4TApA() {
        if (!this.f12939AYUAbz) {
            return false;
        }
        try {
            this.f12949B3GDIM = 1;
            Context context = this.f12934A4TApA;
            com.qq.e.comm.managers.plugin.b.A2egSU(context, h.ASJ6gh(context), new File(h.ARc23Z(this.f12934A4TApA), "gdt_plugin.jar.sig"));
            this.f12935A5SV6n = Sig.ASSET_PLUGIN_SIG;
            this.f12936ADYaiT = h.ASJ6gh(this.f12934A4TApA);
            this.AMqCpz = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    public final boolean A5SV6n() {
        if (!this.f12945AmA8tU) {
            if (this.f12939AYUAbz) {
                Context context = this.f12934A4TApA;
                String str = h.f12962A2egSU;
                g gVar = new g(new File(h.ARc23Z(context), "gdt_plugin.next"), new File(h.ARc23Z(this.f12934A4TApA), "gdt_plugin.next.sig"));
                if (gVar.A2egSU(this.f12934A4TApA, false)) {
                    this.f12949B3GDIM = 3;
                    h.A4TApA(this.f12934A4TApA);
                    File ASJ6gh2 = h.ASJ6gh(this.f12934A4TApA);
                    File file = new File(h.ARc23Z(this.f12934A4TApA), "gdt_plugin.jar.sig");
                    Context context2 = this.f12934A4TApA;
                    File file2 = gVar.f12958A2egSU;
                    if (ASJ6gh2.equals(file2) || h.a(file2, ASJ6gh2, context2, true)) {
                        File file3 = gVar.f12959A4TApA;
                        if (!file.equals(file3)) {
                            h.a(file3, file, context2, false);
                        }
                    }
                }
            }
            g gVar2 = new g(h.ASJ6gh(this.f12934A4TApA), new File(h.ARc23Z(this.f12934A4TApA), "gdt_plugin.jar.sig"));
            if (gVar2.A2egSU(this.f12934A4TApA, true)) {
                if (gVar2.f12961ADYaiT < SDKStatus.getBuildInPluginVersion()) {
                    SDKStatus.getBuildInPluginVersion();
                    return false;
                }
                if (this.f12949B3GDIM == 0) {
                    this.f12949B3GDIM = 2;
                }
                this.f12935A5SV6n = gVar2.f12960A5SV6n;
                this.AMqCpz = gVar2.f12961ADYaiT;
                this.f12936ADYaiT = h.ASJ6gh(this.f12934A4TApA);
                this.f12946AzWtSf = gVar2.c();
                this.f12944AlLFFp = true;
                return true;
            }
        }
        return false;
    }

    public <T> T getFactory(Class<T> cls) {
        Future future = this.f12943AcNBzu;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        Objects.toString(cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f12937ARc23Z;
        getClass().getClassLoader();
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = (String) ((HashMap) f12932B4ZgIw).get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:".concat(cls.getName()));
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f12934A4TApA, A2egSU()));
            Objects.toString(cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:".concat(cls.getName()), th);
        }
    }

    public POFactory getPOFactory() {
        return getPOFactory(true, false);
    }

    public int getPluginVersion() {
        Future future = this.f12943AcNBzu;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.AMqCpz;
    }

    public JSONObject getStartCaller(int i) {
        if (this.f12947B25kr6 == null) {
            this.f12947B25kr6 = new JSONObject();
        }
        try {
            this.f12947B25kr6.put("scr", i);
        } catch (JSONException unused) {
        }
        return this.f12947B25kr6;
    }

    public boolean tryLockUpdate() {
        try {
            Context context = this.f12934A4TApA;
            String str = h.f12962A2egSU;
            File file = new File(h.ARc23Z(context), "update_lc");
            if (!file.exists()) {
                file.createNewFile();
                h.A5SV6n(file, "lock");
            }
            if (!file.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f12938ASJ6gh = randomAccessFile;
            if (randomAccessFile.getChannel().tryLock() == null) {
                return false;
            }
            this.f12938ASJ6gh.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public POFactory getPOFactory(boolean z, boolean z2) {
        if (this.f12940AZOQYO == null) {
            synchronized (this) {
                if (this.f12940AZOQYO == null) {
                    try {
                        this.f12940AZOQYO = (POFactory) getFactory(POFactory.class);
                    } catch (e e) {
                        if (!this.f12944AlLFFp) {
                            throw e;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.f12945AmA8tU = true;
                        this.f12944AlLFFp = false;
                        this.f12943AcNBzu = this.f12933A2egSU.submit(new a());
                        this.f12940AZOQYO = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.f12940AZOQYO != null) {
            this.f12940AZOQYO.start(z2 ? getStartCaller(0) : getStartCaller(2));
        }
        return this.f12940AZOQYO;
    }
}
