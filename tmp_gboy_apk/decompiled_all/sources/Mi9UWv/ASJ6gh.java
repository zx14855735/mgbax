package Mi9UWv;

import ADYaiT.AZOQYO;
import ADYaiT.AmA8tU;
import ADYaiT.CtFAbx;
import LHpdLt.AlLFFp;
import LHpdLt.AzWtSf;
import LLYwnm.AYUAbz;
import LLiCI0.BV3sI0;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.mobads.sdk.internal.cb;
import com.game.boy.MyApp;
import com.game.boy.activity.SaveSlotsActivity;
import com.game.boy.emu.gba.Console;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends OOnEhG.A4TApA {

    /* renamed from: BmvVmW, reason: collision with root package name */
    public static volatile String f5401BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public static volatile int f5402BniPrB;
    public static final Gson BpkvW3 = new Gson();

    /* renamed from: C2rE4F, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f5403C2rE4F = new B4ZgIw.ARc23Z(7);

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f5404B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public SwipeRefreshLayout f5405B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AppCompatEditText f5406B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AMqCpz f5407B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public AmA8tU f5408B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public Activity f5409B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final AYUAbz f5410BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ExecutorService f5411BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public RecyclerView f5412BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public A4TApA f5413BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public volatile boolean f5414BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final AzWtSf f5415BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public LHpdLt.AMqCpz f5416BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f5417BV3sI0;

    static {
        XjPnDt();
    }

    public ASJ6gh(Activity activity, Console console, AYUAbz aYUAbz) {
        super(activity);
        ArrayList arrayList = new ArrayList();
        this.f5404B25kr6 = arrayList;
        this.f5411BI9f7h = Executors.newSingleThreadExecutor();
        this.f5414BNL6CD = false;
        AzWtSf azWtSf = new AzWtSf(1, this);
        this.f5415BPw6Q8 = azWtSf;
        this.f5417BV3sI0 = -1;
        this.f5409B9tovu = activity;
        this.f5410BChYOn = aYUAbz;
        View inflate = LayoutInflater.from(activity).inflate(2131492954, (ViewGroup) null);
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.AMqCpz = "联机大厅";
        azoqyo.f41B7CMnp = inflate;
        ASJ6gh();
        AzWtSf("关闭", null);
        AlLFFp("创房", null);
        this.f5412BIYEnU = (RecyclerView) inflate.findViewById(2131297833);
        this.f5405B2KMhB = (SwipeRefreshLayout) inflate.findViewById(2131298042);
        this.f5406B3GDIM = (AppCompatEditText) inflate.findViewById(2131297894);
        this.f5408B7CMnp = A2egSU();
        Activity activity2 = this.f5409B9tovu;
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(this, console, 11, false);
        A4TApA a4TApA2 = new A4TApA();
        a4TApA2.f5390AmA8tU = activity2;
        a4TApA2.f5388AcNBzu = arrayList;
        a4TApA2.f5389AlLFFp = a4TApA;
        this.f5413BJ7GGh = a4TApA2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f5409B9tovu.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = i > i2 ? 3 : 2;
        int i4 = i > i2 ? 12 : 20;
        this.f5412BIYEnU.setLayoutManager(new GridLayoutManager(i3));
        RecyclerView recyclerView = this.f5412BIYEnU;
        ARc23Z aRc23Z = new ARc23Z();
        aRc23Z.f5398A2egSU = i3;
        aRc23Z.f5399A4TApA = i4;
        aRc23Z.f5400A5SV6n = true;
        recyclerView.addItemDecoration(aRc23Z);
        this.f5412BIYEnU.setAdapter(this.f5413BJ7GGh);
        this.f5405B2KMhB.setOnRefreshListener(new IQ76hF.AmA8tU(13, this));
        AMqCpz aMqCpz = new AMqCpz(0, this);
        this.f5407B4ZgIw = aMqCpz;
        this.f5406B3GDIM.addTextChangedListener(aMqCpz);
        Window window = this.f5408B7CMnp.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            window.setLayout(-1, displayMetrics2.heightPixels);
            window.setGravity(17);
        }
        this.f5408B7CMnp.show();
        LHpdLt.AMqCpz aMqCpz2 = new LHpdLt.AMqCpz(this, this.f5409B9tovu, 1);
        this.f5416BTvldC = aMqCpz2;
        if (aMqCpz2.canDetectOrientation()) {
            this.f5416BTvldC.enable();
        }
        if (aYUAbz != null) {
            aYUAbz.f4630ARc23Z.add(azWtSf);
        }
        this.f5408B7CMnp.ARc23Z(-1).setOnClickListener(new ADYaiT.A5SV6n(10, this));
        this.f5408B7CMnp.ARc23Z(-3).setOnClickListener(new BV3sI0(this, 4, console));
        this.f5408B7CMnp.setOnDismissListener(new ADYaiT(0, this));
        SharedPreferences sharedPreferences = activity.getSharedPreferences(activity.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().apply();
        if (sharedPreferences.getString("user_token", null) == null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) SaveSlotsActivity.class).putExtra("romName", "login"), 1);
        } else {
            this.f5405B2KMhB.setRefreshing(true);
            B9tovu();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r0.contains(r10.getRomHash()) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void B3GDIM(Mi9UWv.ASJ6gh r8, MTKlkd.AMqCpz r9, com.game.boy.emu.gba.Console r10) {
        /*
            r8.getClass()
            boolean r0 = r9.AZOQYO()
            java.lang.String r1 = "知道了"
            java.lang.String r2 = "提示"
            r3 = 0
            if (r0 == 0) goto L24
            OOnEhG.A4TApA r9 = new OOnEhG.A4TApA
            android.app.Activity r8 = r8.f5409B9tovu
            r9.<init>(r8)
            ADYaiT.AZOQYO r8 = r9.f81AcNBzu
            r8.AMqCpz = r2
            java.lang.String r10 = "此房间《游戏已开始》请更换！"
            r8.f28ASJ6gh = r10
            r9.AzWtSf(r1, r3)
            r9.AMqCpz()
            return
        L24:
            java.lang.String r0 = r9.AYUAbz()
            int r4 = r9.A4TApA()
            r5 = 1
            if (r4 != r5) goto L30
            goto L8e
        L30:
            r4 = 0
            if (r0 == 0) goto L7c
            r6 = 44
            int r7 = r0.indexOf(r6)
            if (r7 >= 0) goto L3c
            goto L7c
        L3c:
            LLYwnm.AYUAbz r7 = r8.f5410BChYOn
            if (r7 == 0) goto L43
            java.lang.String r7 = r7.f4628A5SV6n
            goto L44
        L43:
            r7 = r3
        L44:
            if (r7 == 0) goto L7e
            int r6 = r7.indexOf(r6)
            if (r6 >= 0) goto L4d
            goto L7e
        L4d:
            java.lang.String r10 = ","
            java.lang.String[] r6 = r7.split(r10)
            java.lang.String[] r10 = r0.split(r10)
            int r0 = r6.length
            if (r0 <= r5) goto L7c
            int r0 = r10.length
            if (r0 > r5) goto L5e
            goto L7c
        L5e:
            r0 = r6[r5]
            java.lang.String r0 = r0.trim()
            r10 = r10[r5]
            java.lang.String r10 = r10.trim()
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L7c
            boolean r5 = r10.isEmpty()
            if (r5 == 0) goto L77
            goto L7c
        L77:
            boolean r5 = r0.equals(r10)
            goto L8e
        L7c:
            r5 = 0
            goto L8e
        L7e:
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L7c
            java.lang.String r10 = r10.getRomHash()
            boolean r10 = r0.contains(r10)
            if (r10 == 0) goto L7c
        L8e:
            if (r5 != 0) goto La6
            OOnEhG.A4TApA r9 = new OOnEhG.A4TApA
            android.app.Activity r8 = r8.f5409B9tovu
            r9.<init>(r8)
            ADYaiT.AZOQYO r8 = r9.f81AcNBzu
            r8.AMqCpz = r2
            java.lang.String r10 = "此房间《游戏与您不相同》请更换！"
            r8.f28ASJ6gh = r10
            r9.AzWtSf(r1, r3)
            r9.AMqCpz()
            return
        La6:
            java.lang.String r10 = r9.AMqCpz()
            Mi9UWv.ASJ6gh.f5401BmvVmW = r10
            LLYwnm.AYUAbz r8 = r8.f5410BChYOn
            if (r8 != 0) goto Lb6
            java.lang.String r8 = "网络异常，请关闭大厅后重新尝试。"
            com.game.boy.MyApp.A2egSU(r8)
            return
        Lb6:
            java.lang.String r9 = r9.AMqCpz()
            r8.AMqCpz(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Mi9UWv.ASJ6gh.B3GDIM(Mi9UWv.ASJ6gh, MTKlkd.AMqCpz, com.game.boy.emu.gba.Console):void");
    }

    public static int B4ZgIw(String str) {
        Process process;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        BufferedReader bufferedReader = null;
        String str2 = null;
        r2 = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec(CtFAbx.BChYOn(lowerCase.contains(PointCategory.WIN) ? "ping -n 3 -w 3000 " : "ping -c 3 -w 3 ", str));
            try {
                Thread thread = new Thread(new LLYwnm.AMqCpz(13, process));
                thread.setDaemon(true);
                thread.start();
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(process.getInputStream(), lowerCase.contains(PointCategory.WIN) ? "GBK" : "UTF-8"));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                try {
                                    break;
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            } else if (readLine.contains("time=") || readLine.contains("时间=")) {
                                str2 = readLine;
                            }
                        } catch (Exception unused2) {
                            bufferedReader2 = bufferedReader3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (process == null) {
                                return -1;
                            }
                            process.destroy();
                            return -1;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (process == null) {
                            throw th;
                        }
                        try {
                            process.destroy();
                            throw th;
                        } catch (Throwable unused5) {
                            throw th;
                        }
                    }
                }
                process.waitFor();
                try {
                    if (process.exitValue() == 0 && str2 != null) {
                        if (str2.contains("time=")) {
                            int parseFloat = (int) Float.parseFloat(str2.split("time=")[1].replace("ms", "").trim());
                            try {
                                bufferedReader3.close();
                            } catch (IOException unused6) {
                            }
                            try {
                                process.destroy();
                            } catch (Throwable unused7) {
                            }
                            return parseFloat;
                        }
                        if (str2.contains("时间=")) {
                            int parseInt = Integer.parseInt(str2.split("时间=")[1].replace("ms", "").replace("毫秒", "").trim());
                            try {
                                bufferedReader3.close();
                            } catch (IOException unused8) {
                            }
                            try {
                                process.destroy();
                            } catch (Throwable unused9) {
                            }
                            return parseInt;
                        }
                    }
                } catch (IllegalThreadStateException | Exception unused10) {
                }
                try {
                    bufferedReader3.close();
                } catch (IOException unused11) {
                }
            } catch (Exception unused12) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused13) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        try {
            process.destroy();
            return -1;
        } catch (Throwable unused14) {
            return -1;
        }
    }

    public static HashMap B7CMnp(JsonObject jsonObject) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (!key.equals(PointParamKey.TYPE) && !key.equals(cb.o)) {
                try {
                    hashMap.put(key, (MTKlkd.AMqCpz) BpkvW3.fromJson(entry.getValue(), MTKlkd.AMqCpz.class));
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    private static /* synthetic */ void XjPnDt() {
        char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 232);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 232);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void B9tovu() {
        AYUAbz aYUAbz = this.f5410BChYOn;
        if (aYUAbz == null) {
            SwipeRefreshLayout swipeRefreshLayout = this.f5405B2KMhB;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.post(new LLYwnm.AMqCpz(12, this));
            }
            MyApp.A2egSU("连接失败，请检查网络！");
            return;
        }
        AlLFFp alLFFp = new AlLFFp(3, this);
        HashMap hashMap = new HashMap();
        hashMap.put("action", "query_room");
        aYUAbz.ARc23Z(hashMap, "query_room", alLFFp);
    }
}
