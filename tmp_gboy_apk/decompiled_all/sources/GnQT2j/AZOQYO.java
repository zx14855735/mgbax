package GnQT2j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static String f3116AYUAbz = Environment.getExternalStorageDirectory() + "/azhong";

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static AZOQYO f3117AZOQYO;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A2egSU f3118A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public SQLiteDatabase f3119A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AlLFFp f3120A5SV6n;
    public H0qugq.AZOQYO AMqCpz;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap f3121ADYaiT = new HashMap();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final HashMap f3122ARc23Z = new HashMap();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public String f3123ASJ6gh = "";

    static {
        yFHpc();
    }

    public AZOQYO(A2egSU a2egSU, AlLFFp alLFFp) {
        this.f3118A2egSU = a2egSU;
        this.f3120A5SV6n = alLFFp;
        this.f3119A4TApA = a2egSU.getWritableDatabase();
    }

    private static /* synthetic */ void yFHpc() {
        char[] charArray = "&*(k\"$( k'*<k6- ))k\u000f+,\u00077,!\" ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'E');
        }
        String str = new String(charArray);
        char[] charArray2 = "&),+,1".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'E');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(AZkASS aZkASS) {
        SQLiteDatabase sQLiteDatabase = this.f3119A4TApA;
        A2egSU a2egSU = this.f3118A2egSU;
        a2egSU.getClass();
        Cursor query = sQLiteDatabase.query(n.z, null, "url = ?", new String[]{aZkASS.f3125A4TApA}, null, null, null, null);
        boolean moveToNext = query.moveToNext();
        query.close();
        HashMap hashMap = this.f3121ADYaiT;
        if (moveToNext) {
            SQLiteDatabase writableDatabase = a2egSU.getWritableDatabase();
            this.f3119A4TApA = writableDatabase;
            AZkASS A2egSU2 = A2egSU.A2egSU(writableDatabase, aZkASS.f3125A4TApA);
            if (hashMap.containsKey(aZkASS.f3125A4TApA)) {
                return;
            }
            hashMap.put(aZkASS.f3125A4TApA, A2egSU2);
            return;
        }
        SQLiteDatabase writableDatabase2 = a2egSU.getWritableDatabase();
        this.f3119A4TApA = writableDatabase2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileName", aZkASS.f3124A2egSU);
        contentValues.put("url", aZkASS.f3125A4TApA);
        contentValues.put("length", Integer.valueOf(aZkASS.f3126A5SV6n));
        contentValues.put("finished", Integer.valueOf(aZkASS.f3127ADYaiT));
        writableDatabase2.insert(n.z, null, contentValues);
        hashMap.put(aZkASS.f3125A4TApA, aZkASS);
    }

    public final void A4TApA(String str) {
        ((AZkASS) this.f3121ADYaiT.get(str)).AMqCpz = true;
    }

    public final void A5SV6n(String str, String str2) {
        if (this.f3122ARc23Z.containsKey(str)) {
            AYUAbz aYUAbz = (AYUAbz) this.f3122ARc23Z.get(str);
            if (!aYUAbz.isAlive()) {
                this.f3122ARc23Z.remove(str);
                return;
            }
            AlLFFp alLFFp = this.f3120A5SV6n;
            synchronized (aYUAbz) {
                aYUAbz.f3111B25kr6 = alLFFp;
                aYUAbz.f3115B7CMnp = new DG07BK.A2egSU(aYUAbz.f3113B3GDIM, alLFFp, 5);
            }
            return;
        }
        this.f3123ASJ6gh = str2;
        SQLiteDatabase writableDatabase = this.f3118A2egSU.getWritableDatabase();
        this.f3119A4TApA = writableDatabase;
        this.f3118A2egSU.getClass();
        this.f3121ADYaiT.put(str, A2egSU.A2egSU(writableDatabase, str));
        AZkASS aZkASS = (AZkASS) this.f3121ADYaiT.get(str);
        A2egSU a2egSU = this.f3118A2egSU;
        AlLFFp alLFFp2 = this.f3120A5SV6n;
        String str3 = this.f3123ASJ6gh;
        H0qugq.AZOQYO azoqyo = f3117AZOQYO.AMqCpz;
        AYUAbz aYUAbz2 = new AYUAbz();
        aYUAbz2.f3110AzWtSf = 0;
        aYUAbz2.f3112B2KMhB = "";
        Looper mainLooper = Looper.getMainLooper();
        aYUAbz2.f3113B3GDIM = mainLooper;
        aYUAbz2.f3114B4ZgIw = new Handler(mainLooper);
        aYUAbz2.f3115B7CMnp = new DG07BK.A2egSU(aYUAbz2, mainLooper, 6);
        aYUAbz2.f3112B2KMhB = str3;
        aYUAbz2.f3107AcNBzu = aZkASS;
        aYUAbz2.f3109AmA8tU = a2egSU;
        aYUAbz2.f3108AlLFFp = a2egSU.getWritableDatabase();
        aYUAbz2.f3111B25kr6 = alLFFp2;
        aZkASS.getClass();
        this.f3122ARc23Z.put(str, aYUAbz2);
        aYUAbz2.start();
    }
}
