package H0qugq;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceAdEncryptData;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final String f3257A5SV6n = CtFAbx.B25kr6(JrXYwF.A4TApA.AMqCpz("gameley/adcachepool/"), DeviceUtil.f9708A2egSU, "/");

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f3258A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f3259A4TApA = new HashMap();

    static {
        zwcW();
    }

    public static double A2egSU(String str) {
        if (str == null || str.isEmpty()) {
            return -1.0d;
        }
        return Double.parseDouble(str);
    }

    public static long A4TApA(long j) {
        return System.currentTimeMillis() + (j <= 0 ? 43200000L : j * 1000);
    }

    public static long A5SV6n(Context context, String str) {
        if (context != null && str != null && !str.isEmpty()) {
            try {
                return context.getSharedPreferences("gameleycachepool", 0).getLong("waitLoadTime".concat(str), 500L);
            } catch (Exception e) {
                e.getMessage();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
            }
        }
        return 500L;
    }

    public static SAAllianceAdData ADYaiT(File file) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        ArrayList arrayList = new ArrayList();
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(file);
            try {
                JsonStreamParser jsonStreamParser = new JsonStreamParser(fileReader);
                while (jsonStreamParser.hasNext()) {
                    arrayList.add((SAAllianceAdEncryptData) gson.fromJson(jsonStreamParser.next(), SAAllianceAdEncryptData.class));
                }
                if (arrayList.isEmpty()) {
                    fileReader.close();
                    return null;
                }
                JSONObject jSONObject = new JSONObject(gson.toJson(arrayList.get(0)));
                SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) new Gson().fromJson(com.bumptech.glide.A5SV6n.AMqCpz(jSONObject.getString("cipher"), jSONObject.getString("encryptParams")), new EiK8oA.A2egSU().getType());
                fileReader.close();
                return sAAllianceAdData;
            } finally {
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            return null;
        }
    }

    public static void ARc23Z(Context context, String str, long j) {
        if (context == null || str == null || str.isEmpty()) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("gameleycachepool", 0).edit();
            edit.putLong("waitLoadTime".concat(str), j);
            edit.apply();
        } catch (Exception e) {
            e.getMessage();
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        }
    }

    public static void ASJ6gh(Context context, String str, String str2) {
        File[] listFiles;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        File file = new File(context.getFilesDir(), CtFAbx.B25kr6(new StringBuilder(), f3257A5SV6n, str));
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.getName().contains(str2)) {
                if (file2.delete()) {
                    return;
                }
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                return;
            }
        }
    }

    public static void AZkASS(File file, SAAllianceAdData sAAllianceAdData) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        Gson gson = new Gson();
        String[] AZkASS2 = com.bumptech.glide.A5SV6n.AZkASS(gson.toJson(sAAllianceAdData));
        String json = gson.toJson(new SAAllianceAdEncryptData(AZkASS2[0], AZkASS2[1]));
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                int ceil = (int) Math.ceil(json.length() / 1000);
                for (int i2 = 0; i2 < ceil; i2++) {
                    int i3 = i2 * 1000;
                    bufferedWriter.write(json.substring(i3, Math.min(i3 + 1000, json.length())));
                }
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            e.getMessage();
            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
        }
    }

    public static boolean AcNBzu(SAAllianceAdData sAAllianceAdData) {
        if (sAAllianceAdData.getDeadlineTime() <= 0) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return false;
        }
        if (sAAllianceAdData.getPriceD() <= 0.0d) {
            String price = sAAllianceAdData.getPrice();
            if (price == null || price.isEmpty()) {
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                return false;
            }
            sAAllianceAdData.setPriceD(Double.parseDouble(price));
        }
        sAAllianceAdData.getDeadlineTime();
        System.currentTimeMillis();
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        return sAAllianceAdData.getDeadlineTime() > System.currentTimeMillis();
    }

    private static /* synthetic */ void zwcW() {
        char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '@');
        }
        String str = new String(charArray);
        char[] charArray2 = "#,).)4".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '@');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void AMqCpz(Context context, SAAllianceAdData sAAllianceAdData, String str) {
        List arrayList;
        File file;
        File[] listFiles;
        try {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            try {
                if (this.f3258A2egSU.get(str) != null) {
                    arrayList = (List) this.f3258A2egSU.get(str);
                } else {
                    arrayList = new ArrayList();
                    this.f3258A2egSU.put(str, arrayList);
                }
                file = new File(context.getFilesDir(), f3257A5SV6n + str);
            } catch (Exception e) {
                e.getMessage();
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            }
            if (file.exists() || file.mkdirs()) {
                if (arrayList.isEmpty() && ((listFiles = file.listFiles()) != null || listFiles.length != 0)) {
                    for (File file2 : listFiles) {
                        SAAllianceAdData ADYaiT2 = ADYaiT(new File(file, file2.getName()));
                        if (ADYaiT2 != null) {
                            if (AcNBzu(ADYaiT2)) {
                                arrayList.add(file2.getName());
                                this.f3259A4TApA.put(file2.getName(), ADYaiT2);
                            } else {
                                ASJ6gh(context, str, ADYaiT2.getRequestid());
                            }
                        }
                    }
                }
                File file3 = new File(file, sAAllianceAdData.getRequestid() + ".json");
                if (!file3.createNewFile()) {
                    int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                    return;
                }
                AZkASS(file3, sAAllianceAdData);
                arrayList.add(file3.getName());
                this.f3259A4TApA.put(file3.getName(), sAAllianceAdData);
                AZOQYO(context, arrayList, str);
                AYUAbz(context, str, arrayList);
                arrayList.size();
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void AYUAbz(Context context, String str, List list) {
        StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n(str, " cache ad info =\n | waitLoadTime: ");
        A5SV6n2.append(A5SV6n(context, str));
        String sb = A5SV6n2.toString();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            HashMap hashMap = this.f3259A4TApA;
            if (hashMap.get(str2) != null) {
                sb = sb + "\n | id: " + str2 + ", price:" + ((SAAllianceAdData) hashMap.get(str2)).getPrice() + ", deadTime:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(((SAAllianceAdData) hashMap.get(str2)).getDeadlineTime()));
            }
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public final void AZOQYO(Context context, List list, String str) {
        list.size();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        if (list.size() <= 5) {
            return;
        }
        String str2 = (String) list.get(0);
        Iterator it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            HashMap hashMap = this.f3259A4TApA;
            if (!hasNext) {
                list.remove(str2);
                hashMap.remove(str2);
                ASJ6gh(context, str, str2);
                AZOQYO(context, list, str);
                return;
            }
            String str3 = (String) it.next();
            if (hashMap.get(str3) != null && ((SAAllianceAdData) hashMap.get(str3)).getDeadlineTime() < ((SAAllianceAdData) hashMap.get(str2)).getDeadlineTime()) {
                str2 = str3;
            }
        }
    }

    public final void AaHO0E(String str, String str2) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        List list = (List) this.f3258A2egSU.get(str);
        if (list != null) {
            list.remove(str2 + ".json");
        }
    }

    public final synchronized SAAllianceAdData AlLFFp(Context context, String str) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            List list = (List) this.f3258A2egSU.get(str);
            if (list != null && !list.isEmpty()) {
                ArrayList AmA8tU2 = AmA8tU(context, str, list);
                for (int i2 = 0; i2 < AmA8tU2.size(); i2++) {
                    SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) this.f3259A4TApA.remove((String) AmA8tU2.remove(i2));
                    if (sAAllianceAdData != null) {
                        if (AcNBzu(sAAllianceAdData)) {
                            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                            return sAAllianceAdData;
                        }
                        ASJ6gh(context, str, sAAllianceAdData.getRequestid());
                    }
                }
            }
            File file = new File(context.getFilesDir(), f3257A5SV6n + str);
            if (file.exists()) {
                ArrayList arrayList = new ArrayList();
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        for (File file2 : listFiles) {
                            SAAllianceAdData ADYaiT2 = ADYaiT(new File(file, file2.getName()));
                            if (ADYaiT2 != null) {
                                if (AcNBzu(ADYaiT2)) {
                                    arrayList.add(file2.getName());
                                    this.f3259A4TApA.put(file2.getName(), ADYaiT2);
                                } else {
                                    ASJ6gh(context, str, file2.getName());
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            ArrayList AmA8tU3 = AmA8tU(context, str, arrayList);
                            String str2 = (String) AmA8tU3.remove(0);
                            if (!AmA8tU3.isEmpty()) {
                                this.f3258A2egSU.put(str, AmA8tU3);
                            }
                            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                            return (SAAllianceAdData) this.f3259A4TApA.remove(str2);
                        }
                    }
                    int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                    return null;
                }
            } else if (!file.mkdirs()) {
                int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                return null;
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            int i7 = GJee0v.AZOQYO.f3039AcNBzu;
            return null;
        }
    }

    public final ArrayList AmA8tU(Context context, String str, List list) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            String str2 = (String) list.get(size);
            HashMap hashMap = this.f3259A4TApA;
            SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) hashMap.get(str2);
            if (sAAllianceAdData != null) {
                if (AcNBzu(sAAllianceAdData)) {
                    arrayList.add(sAAllianceAdData);
                } else {
                    list.remove(size);
                    hashMap.remove(str2);
                    ASJ6gh(context, str, str2);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new B4ZgIw.ARc23Z(3));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SAAllianceAdData sAAllianceAdData2 = (SAAllianceAdData) it.next();
                arrayList2.add(sAAllianceAdData2.getRequestid() + ".json");
                sAAllianceAdData2.getRequestid();
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            }
        }
        return arrayList2;
    }
}
