package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import DG07BK.A5SV6n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa;
import io.dcloud.openapi.core.util.ReflectUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {
    private static LinkedList aaaaaaaa;

    public class aaaaaaa0 implements Runnable {
        final /* synthetic */ Context aaaaaaa0;
        final /* synthetic */ aaaaaaau aaaaaaaa;
        final /* synthetic */ String aaaaaaac;
        final /* synthetic */ String aaaaaaao;

        public aaaaaaa0(aaaaaaau aaaaaaauVar, Context context, String str, String str2) {
            this.aaaaaaaa = aaaaaaauVar;
            this.aaaaaaa0 = context;
            this.aaaaaaao = str;
            this.aaaaaaac = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject aaaaaaao = this.aaaaaaaa.aaaaaaao();
            if (aaaaaaao != null && aaaaaaao.has("ua")) {
                aaaaaaao.optString("ua");
            }
            aaaaaaaa.aaaaaaa0(50, this.aaaaaaa0, this.aaaaaaao, this.aaaaaaac, this.aaaaaaaa, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class RunnableC0544aaaaaaaa implements Runnable {
        final /* synthetic */ aaaaaaeo aaaaaaaa;

        public RunnableC0544aaaaaaaa(aaaaaaeo aaaaaaeoVar) {
            this.aaaaaaaa = aaaaaaeoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.aaaaaaaa.aaaaaaaa();
        }
    }

    public class aaaaaaac implements aaaaaaeo {
        final /* synthetic */ String aaaaaaa0;
        final /* synthetic */ JSONObject aaaaaaaa;
        final /* synthetic */ aaaaaaae aaaaaaac;
        final /* synthetic */ String aaaaaaao;

        public aaaaaaac(JSONObject jSONObject, String str, String str2, aaaaaaae aaaaaaaeVar) {
            this.aaaaaaaa = jSONObject;
            this.aaaaaaa0 = str;
            this.aaaaaaao = str2;
            this.aaaaaaac = aaaaaaaeVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaeo
        public void aaaaaaaa() {
            HashMap hashMap;
            byte[] bArr = null;
            if (this.aaaaaaaa.has("ua") && this.aaaaaaaa.optString("ua").equalsIgnoreCase("webview")) {
                hashMap = new HashMap();
                hashMap.put("User-Agent", aaaaaaaa.aaaaaaaa("ua-webview"));
            } else {
                hashMap = null;
            }
            try {
                bArr = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaa0, hashMap, true);
            } catch (Exception unused) {
            }
            StringBuilder sb = new StringBuilder("download file is nulll");
            sb.append(bArr == null);
            sb.append("src=");
            sb.append(this.aaaaaaa0);
            aaaaaaaa.aaaaaaaa("adh", sb.toString());
            if (bArr == null) {
                this.aaaaaaac.aaaaaaa0();
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa(bArr, 0, this.aaaaaaao);
                this.aaaaaaac.aaaaaaaa();
            }
        }
    }

    public interface aaaaaaae {
        void aaaaaaa0();

        void aaaaaaaa();
    }

    public interface aaaaaaan {
        void aaaaaaaa(Object obj);

        boolean aaaaaaaa();
    }

    public class aaaaaaao implements aaaaaaan {
        final /* synthetic */ Context aaaaaaa0;
        final /* synthetic */ aaaaaaau aaaaaaaa;

        public aaaaaaao(aaaaaaau aaaaaaauVar, Context context) {
            this.aaaaaaaa = aaaaaaauVar;
            this.aaaaaaa0 = context;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaan
        public boolean aaaaaaaa() {
            return this.aaaaaaaa.aaaaaaaa();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaan
        public void aaaaaaaa(File file) {
            aaaaaaaa.aaaaaaaa.add(file);
            aaaaaaaa.aaaaaaa0(this.aaaaaaa0, file, this.aaaaaaaa);
        }
    }

    public static class aaaaaaau {
        MotionEvent aaaaaaa0;
        MotionEvent aaaaaaaa;
        JSONObject aaaaaaac;
        String aaaaaaae;
        String aaaaaaan;
        String aaaaaaao;
        public Object aaaaaaau;
        String aaaaaaav;
        String aaaaeaaa;
        int aaaaaaeo = 0;
        int aaaeaaaa = 0;
        public String aaaaaeaa = "";

        public class aaaaaaa0 implements aaaaaaaa.InterfaceC0539aaaaaaaa {
            final /* synthetic */ String aaaaaaa0;
            final /* synthetic */ Context aaaaaaaa;
            final /* synthetic */ String aaaaaaac;
            final /* synthetic */ String aaaaaaao;

            public aaaaaaa0(Context context, String str, String str2, String str3) {
                this.aaaaaaaa = context;
                this.aaaaaaa0 = str;
                this.aaaaaaao = str2;
                this.aaaaaaac = str3;
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa.InterfaceC0539aaaaaaaa
            public void aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar) {
                Context context = this.aaaaaaaa;
                String str = this.aaaaaaa0;
                String str2 = this.aaaaaaao;
                aaaaaaau aaaaaaauVar = aaaaaaau.this;
                aaaaaaaa.aaaaaaa0(32, context, str, str2, aaaaaaauVar, aaaaaaauVar.aaaaaaav);
            }

            @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa.InterfaceC0539aaaaaaaa
            public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar) {
                Context context = this.aaaaaaaa;
                String str = this.aaaaaaa0;
                String str2 = this.aaaaaaao;
                aaaaaaau aaaaaaauVar = aaaaaaau.this;
                aaaaaaaa.aaaaaaa0(30, context, str, str2, aaaaaaauVar, aaaaaaauVar.aaaaaaav);
                PackageInfo aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaan(this.aaaaaaaa, this.aaaaaaac);
                if (aaaaaaan != null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    this.aaaaaaaa.registerReceiver(new aaaaaaav(aaaaaaau.this, aaaaaaan.packageName), intentFilter);
                }
                try {
                    Class.forName("io.dcloud.feature.pack.FileUtils").getDeclaredMethod("addFileToSystem", Context.class, String.class, String.class).invoke(null, this.aaaaaaaa, this.aaaaaaaa.getPackageName() + ".dc.fileprovider", this.aaaaaaac);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa$aaaaaaau$aaaaaaaa, reason: collision with other inner class name */
        public class C0545aaaaaaaa extends BroadcastReceiver {
            final /* synthetic */ aaaeaaaa aaaaaaaa;

            public C0545aaaaaaaa(aaaeaaaa aaaeaaaaVar) {
                this.aaaaaaaa = aaaeaaaaVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    long longExtra = intent.getLongExtra(PointCategory.END, 0L) - intent.getLongExtra("begin", 0L);
                    aaaaaaaa.aaaaaaaa("ADReceive", "useTime=" + longExtra);
                    if (longExtra <= 3000) {
                        this.aaaaaaaa.aaaaaaaa(null);
                    }
                    aaaaaaaa.aaaaaaaa("ADReceive", "unregisterReceiver");
                    context.unregisterReceiver(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public JSONObject aaaaaaa0() {
            return this.aaaaaaac.optJSONObject(PointParamKey.DATA);
        }

        public void aaaaaaaa(String str) {
            this.aaaaeaaa = str;
        }

        public boolean aaaaaaac() {
            return this.aaaeaaaa == 1;
        }

        public JSONObject aaaaaaao() {
            return this.aaaaaaac;
        }

        public JSONObject aaaaaaau() {
            return this.aaaaaaac.optJSONObject(PointCategory.REPORT);
        }

        public boolean aaaaaaaa() {
            return (this.aaaaaaac == null || this.aaaaaaau == null) ? false : true;
        }

        public void aaaaaaaa(Context context, aaaeaaaa aaaeaaaaVar) {
            if (aaaeaaaaVar != null) {
                C0545aaaaaaaa c0545aaaaaaaa = new C0545aaaaaaaa(aaaeaaaaVar);
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("ad_receive");
                    A5SV6n.A2egSU(context).registerReceiver(c0545aaaaaaaa, intentFilter);
                    aaaaaaaa.aaaaaaaa("ADReceive", "registerReceiver");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void aaaaaaaa(Context context, String str, String str2) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaaa(context);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0 aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaa0.aaaaaaaa(context);
            List aaaaaaaa2 = aaaaaaaa.aaaaaaaa();
            JSONObject optJSONObject = this.aaaaaaac.optJSONObject(PointParamKey.DATA);
            if (optJSONObject == null) {
                return;
            }
            String optString = optJSONObject.optString("url");
            String optString2 = optJSONObject.optString("downloadAppName");
            Iterator it = aaaaaaaa2.iterator();
            while (it.hasNext()) {
                if (((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa) it.next()).aaaaaaao().equals(optString)) {
                    return;
                }
            }
            String str3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaaa.aaaaaaaa;
            String aaaaaaaa3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa.aaaaaaaa.aaaaaaaa(optString, str3, TextUtils.isEmpty(optString2) ? null : CtFAbx.AcNBzu(optString2, str3));
            String absolutePath = context.getExternalFilesDir(null).getAbsolutePath();
            StringBuilder A4TApA2 = AYUAbz.A4TApA(absolutePath);
            A4TApA2.append(absolutePath.endsWith("/") ? "" : "/");
            String AlLFFp2 = CtFAbx.AlLFFp(A4TApA2.toString(), "Download/", aaaaaaaa3);
            aaaaaaaa.aaaaaaa0(29, context, str, str2, this, this.aaaaaaav);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa();
            aaaaaaaaVar.aaaaaaaa(context, optString, AlLFFp2);
            aaaaaaaaVar.aaaaaaaa(new aaaaaaa0(context, str, str2, AlLFFp2));
            aaaaaaaa.aaaaaaaa(aaaaaaaaVar);
        }
    }

    public static class aaaaaaav extends BroadcastReceiver {
        String aaaaaaa0;
        aaaaaaau aaaaaaaa;

        public aaaaaaav(aaaaaaau aaaaaaauVar, String str) {
            this.aaaaaaaa = aaaaaaauVar;
            this.aaaaaaa0 = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.aaaaaaa0.equals(intent.getData().getSchemeSpecificPart())) {
                String optString = this.aaaaaaaa.aaaaaaa0().optString("tid");
                String aaaaaaaa = aaaaaaaa.aaaaaaaa(context, "adid");
                aaaaaaau aaaaaaauVar = this.aaaaaaaa;
                aaaaaaaa.aaaaaaa0(31, context, optString, aaaaaaaa, aaaaaaauVar, aaaaaaauVar.aaaaaaav);
                context.unregisterReceiver(this);
            }
        }
    }

    public interface aaaaaaeo {
        void aaaaaaaa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aaaaaaa0(int i, Context context, String str, String str2, aaaaaaau aaaaaaauVar, String str3) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new A2egSU(context, str3, str, str2, i, aaaaaaauVar, 0));
    }

    public static void aaaaaaaa(String str, String str2) {
    }

    public static void aaaaaaao(Context context, aaaaaaau aaaaaaauVar, String str) {
        if ("wanka".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaa0.aaaaaaan(context, aaaaaaauVar, str);
        } else if ("youdao".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaao.aaaaaaan(context, aaaaaaauVar, str);
        } else if ("common".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaan.aaaaaaaa(context, aaaaaaauVar, str, "imptracker");
        }
    }

    public static void aaaaaaa0(Context context, aaaaaaau aaaaaaauVar, String str) {
        JSONObject aaaaaaa02 = aaaaaaauVar.aaaaaaa0();
        String optString = aaaaaaauVar.aaaaaaa0().optString("tid");
        if (aaaaaaa02.has("dplk") && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaac(context, aaaaaaa02.optString("dplk"))) {
            if (aaaaaaauVar.aaaaaaac()) {
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaa0(aaaaaaauVar, context, optString, str));
            if ("wanka".equals(aaaaaaauVar.aaaaaaao)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaa0.aaaaaaau(context, aaaaaaauVar, str);
                return;
            } else if ("youdao".equals(aaaaaaauVar.aaaaaaao)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaao.aaaaaaau(context, aaaaaaauVar, str);
                return;
            } else {
                if ("common".equals(aaaaaaauVar.aaaaaaao)) {
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaan.aaaaaaaa(context, aaaaaaauVar, str, "dptracker");
                    return;
                }
                return;
            }
        }
        String optString2 = aaaaaaa02.optString("action");
        if (TextUtils.equals("url", optString2)) {
            if (aaaaaaauVar.aaaaaaac()) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaac.aaaaaaaa(context, aaaaaaa02.optString("url"));
                return;
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaau(context, aaaaaaa02.optString("url"));
                return;
            }
        }
        if (!TextUtils.equals("download", optString2)) {
            if (!TextUtils.equals("browser", optString2) || aaaaaaauVar.aaaaaaac()) {
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaao(context, aaaaaaa02.optString("url"));
            return;
        }
        if (aaaaaaa02.has("expires")) {
            try {
                new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(aaaaaaa02.optString("expires")).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String optString3 = aaaaaaauVar.aaaaaaao() != null ? aaaaaaauVar.aaaaaaao().optString("ua") : "";
        if (aaaaaaauVar.aaaaaaac()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaac.aaaaaaaa(context, aaaaaaauVar.aaaaaaav, optString, str, aaaaaaa02.optString("url"), aaaaaaa02.optString("bundle"), null, optString3, aaaaaaauVar.aaaaeaaa);
        } else {
            aaaaaaauVar.aaaaaaaa(context, optString, str);
        }
    }

    public static String aaaaaaaa(String str) {
        str.getClass();
        switch (str) {
            case "adid":
                return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId();
            case "appid":
                return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId();
            case "ua-webview":
                return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo.aaaaaaau(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaao());
            default:
                return null;
        }
    }

    public static String aaaaaaaa(Context context, String str) {
        return aaaaaaaa(str);
    }

    private static void aaaaaaaa(aaaaaaeo aaaaaaeoVar) {
        if (aaaaaaeoVar != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new RunnableC0544aaaaaaaa(aaaaaaeoVar));
            } else {
                aaaaaaeoVar.aaaaaaaa();
            }
        }
    }

    public static String aaaaaaaa(String str, JSONObject jSONObject) {
        try {
            return str.replace("${User-Agent}", URLEncoder.encode(jSONObject.optString("u-a"), "utf-8")).replace("${click_id}", jSONObject.optString(AdBaseConstants.MARKET_OPEN_CLICK_ID)).replace("${down_x}", String.valueOf(jSONObject.optInt("down_x", -999))).replace("${down_y}", String.valueOf(jSONObject.optInt("down_y", -999))).replace("${up_x}", String.valueOf(jSONObject.optInt("up_x", -999))).replace("${up_y}", String.valueOf(jSONObject.optInt("up_y", -999))).replace("${relative_down_x}", String.valueOf(jSONObject.optInt("relative_down_x", -999))).replace("${relative_down_y}", String.valueOf(jSONObject.optInt("relative_down_y", -999))).replace("${relative_up_x}", String.valueOf(jSONObject.optInt("relative_up_x", -999))).replace("${relative_up_y}", String.valueOf(jSONObject.optInt("relative_up_y", -999)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void aaaaaaaa(Context context, String str, String str2, String str3, int i, aaaaaaau aaaaaaauVar) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaaa.aaaaaaaa(context, str, str2, str3, i, aaaaaaauVar.aaaaeaaa);
    }

    public static void aaaaaaaa(Context context, aaaaaaau aaaaaaauVar, String str) {
        if ("wanka".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaa0.aaaaaaac(context, aaaaaaauVar, str);
            return;
        }
        if ("youdao".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaao.aaaaaaac(context, aaaaaaauVar, str);
        } else if ("common".equals(aaaaaaauVar.aaaaaaao)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaan.aaaaaaac(context, aaaaaaauVar, str);
        } else {
            aaaaaaa0(context, aaaaaaauVar, str);
        }
    }

    private static void aaaaaaaa(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (int i = 0; i < fileArr.length - 1; i++) {
            int i2 = 0;
            while (i2 < (fileArr.length - 1) - i) {
                int i3 = i2 + 1;
                if (Long.parseLong(fileArr[i2].getName()) < Long.parseLong(fileArr[i3].getName())) {
                    File file = fileArr[i2];
                    fileArr[i2] = fileArr[i3];
                    fileArr[i3] = file;
                }
                i2 = i3;
            }
        }
    }

    public static aaaaaaau aaaaaaa0(Context context, String str) {
        return aaaaaaaa(context, str, new aaaaaaau());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aaaaaaa0(Context context, File file, aaaaaaau aaaaaaauVar) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        try {
            String str = new String(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaau(file.getAbsolutePath() + "/data.json"));
            if (!TextUtils.isEmpty(str) && (optJSONObject = (jSONObject = new JSONObject(str)).optJSONObject(PointParamKey.DATA)) != null) {
                aaaaaaauVar.aaaaaaao = jSONObject.optString("provider");
                aaaaaaauVar.aaaaaaac = jSONObject;
                aaaaaaauVar.aaaaaaeo = jSONObject.optInt("es", 0);
                aaaaaaauVar.aaaeaaaa = jSONObject.optInt("ec", 0);
                String optString = optJSONObject.optString("src");
                aaaaaaauVar.aaaaaaae = optString;
                aaaaaaauVar.aaaaaeaa = optJSONObject.optString("tid", "");
                boolean endsWith = optString.toLowerCase(Locale.ENGLISH).endsWith(".gif");
                StringBuilder sb = new StringBuilder();
                sb.append(file.getAbsolutePath());
                sb.append("/");
                sb.append(endsWith ? "img.gif" : "img.png");
                String sb2 = sb.toString();
                String str2 = file.getAbsolutePath() + "/s.txt";
                if (!new File(sb2).exists() || new File(str2).exists()) {
                    return;
                }
                if (endsWith) {
                    aaaaaaauVar.aaaaaaau = ReflectUtil.newInstance("pl.droidsonroids.gif.GifDrawable", new Class[]{String.class}, new Object[]{jSONObject.optString("srcPath")});
                } else {
                    Bitmap decodeFile = BitmapFactory.decodeFile(sb2);
                    if (decodeFile != null) {
                        aaaaaaauVar.aaaaaaau = decodeFile;
                    }
                }
                aaaaaaauVar.aaaaaaan = sb2;
                new File(str2).createNewFile();
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa((Object) file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void aaaaaaaa(Context context, aaaaaaan aaaaaaanVar) {
        File file = new File(aaaaaaaa(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        aaaaaaaa(listFiles);
        for (File file2 : listFiles) {
            if (!aaaaaaanVar.aaaaaaaa()) {
                for (File file3 : file2.listFiles()) {
                    if (Long.parseLong(file3.getName()) > System.currentTimeMillis()) {
                        if (!aaaaaaanVar.aaaaaaaa()) {
                            for (File file4 : file3.listFiles()) {
                                aaaaaaanVar.aaaaaaaa(file4);
                                if (aaaaaaanVar.aaaaaaaa()) {
                                    break;
                                }
                            }
                        }
                    } else {
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa(file3);
                    }
                }
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa(file2);
            }
        }
    }

    public static void aaaaaaa0(Context context, JSONObject jSONObject, long j, aaaaaaae aaaaaaaeVar) {
        String aaaaaaaa2 = aaaaaaaa(context);
        JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
        Date parse = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(optJSONObject.optString("expires"));
        if (parse.getTime() > System.currentTimeMillis()) {
            String optString = optJSONObject.optString("src");
            aaaaaaaa(context, jSONObject, optJSONObject.optString("tid"), optString, aaaaaaaa2 + j + "/" + parse.getTime() + "/" + URLEncoder.encode(optString, "utf-8").hashCode() + "/", aaaaaaaeVar);
            return;
        }
        aaaaaaaeVar.aaaaaaa0();
    }

    public static aaaaaaau aaaaaaaa(Context context, String str, aaaaaaau aaaaaaauVar) {
        aaaaaaauVar.aaaaaaav = str;
        aaaaaaaa = new LinkedList();
        aaaaaaaa(context, new aaaaaaao(aaaaaaauVar, context));
        if (!aaaaaaauVar.aaaaaaaa() && aaaaaaaa.size() != 0) {
            for (int i = 0; i < aaaaaaaa.size(); i++) {
                new File(((File) aaaaaaaa.get(i)).getAbsolutePath() + "/s.txt").delete();
                if (i == 0) {
                    aaaaaaa0(context, (File) aaaaaaaa.get(i), aaaaaaauVar);
                }
            }
        }
        return aaaaaaauVar;
    }

    private static String aaaaaaaa(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return "/sdcard/Android/data/" + context.getPackageName() + "/cache/ad/";
        }
        return externalCacheDir.getAbsolutePath() + "/ad/";
    }

    private static void aaaaaaaa(Context context, JSONObject jSONObject, String str, String str2, String str3, aaaaaaae aaaaaaaeVar) {
        if (jSONObject != null && jSONObject.has("es") && jSONObject.getInt("es") == 1) {
            new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaac(context, jSONObject).aaaaaaac();
            return;
        }
        System.currentTimeMillis();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa(str.getBytes(), 0, str3 + "tid.txt");
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(str2.endsWith(".gif") ? "img.gif" : "img.png");
        String sb2 = sb.toString();
        jSONObject.put("srcPath", sb2);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo.aaaaaaaa(jSONObject.toString().getBytes(), 0, str3 + "data.json");
        aaaaaaaa(new aaaaaaac(jSONObject, str2, sb2, aaaaaaaeVar));
    }

    public static void aaaaaaaa(Context context, JSONObject jSONObject, long j, aaaaaaae aaaaaaaeVar) {
        try {
            aaaaaaa0(context, jSONObject, j, aaaaaaaeVar);
        } catch (Exception unused) {
            aaaaaaaeVar.aaaaaaa0();
        }
    }
}
