package L5dZB6;

import ADYaiT.CtFAbx;
import IQ76hF.AmA8tU;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.game.boy.service.DownloadService;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static ADYaiT f4406AZOQYO;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DownloadService f4407A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile A5SV6n f4408A4TApA;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final A2egSU f4411ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final OkHttpClient f4412ASJ6gh;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f4409A5SV6n = new HashMap();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap f4410ADYaiT = new HashMap();
    public final ArrayDeque AMqCpz = new ArrayDeque();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public volatile boolean f4413AYUAbz = false;

    public ADYaiT(DownloadService downloadService) {
        this.f4407A2egSU = downloadService;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f4408A4TApA = new A5SV6n(new LinkedBlockingQueue(), new AcNBzu.A4TApA(1), new AmA8tU(3, this));
        this.f4411ARc23Z = new A2egSU(downloadService);
        this.f4412ASJ6gh = new OkHttpClient.Builder().connectTimeout(30L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(30L, timeUnit).retryOnConnectionFailure(true).build();
    }

    public static void ASJ6gh(File file, String str) {
        if (file.exists() && file.isFile()) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf == -1) {
                file.renameTo(new File(file.getParent(), CtFAbx.AcNBzu(name, str)));
            } else {
                file.renameTo(new File(file.getParent(), CtFAbx.AcNBzu(name.substring(0, lastIndexOf), str)));
            }
        }
    }

    public final synchronized void A2egSU() {
        try {
            if (this.f4408A4TApA != null) {
                if (!this.f4408A4TApA.isShutdown()) {
                    if (this.f4413AYUAbz) {
                    }
                }
            }
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f4408A4TApA = new A5SV6n(new LinkedBlockingQueue(), new AcNBzu.A4TApA(1), new AmA8tU(3, this));
            this.f4413AYUAbz = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void A4TApA(A4TApA a4TApA) {
        int i;
        this.f4407A2egSU.A5SV6n(a4TApA);
        Intent intent = new Intent("com.game.boy.DOWNLOAD_UPDATE");
        intent.putExtra("download_info", a4TApA);
        DG07BK.A5SV6n A2egSU2 = DG07BK.A5SV6n.A2egSU(this.f4407A2egSU);
        synchronized (A2egSU2.f2067A4TApA) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(A2egSU2.f2066A2egSU.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    intent.toString();
                }
                ArrayList arrayList = (ArrayList) A2egSU2.f2068A5SV6n.get(intent.getAction());
                if (arrayList != null) {
                    if (z) {
                        arrayList.toString();
                    }
                    ArrayList arrayList2 = null;
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        DG07BK.A4TApA a4TApA2 = (DG07BK.A4TApA) arrayList.get(i2);
                        if (z) {
                            Objects.toString(a4TApA2.f2060A2egSU);
                        }
                        if (a4TApA2.f2062A5SV6n) {
                            i = i2;
                        } else {
                            i = i2;
                            int match = a4TApA2.f2060A2egSU.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (match >= 0) {
                                if (z) {
                                    Integer.toHexString(match);
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(a4TApA2);
                                a4TApA2.f2062A5SV6n = true;
                            }
                        }
                        i2 = i + 1;
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            ((DG07BK.A4TApA) arrayList2.get(i3)).f2062A5SV6n = false;
                        }
                        A2egSU2.f2069ADYaiT.add(new K1Z3yj.A2egSU(intent, 13, arrayList2));
                        if (!A2egSU2.AMqCpz.hasMessages(1)) {
                            A2egSU2.AMqCpz.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A5SV6n(A4TApA a4TApA) {
        boolean z;
        a4TApA.f4399B4ZgIw = 100;
        a4TApA.f4398B3GDIM = a4TApA.f4397B2KMhB;
        String str = a4TApA.f4402BChYOn;
        if (str == null || str.isEmpty()) {
            ASJ6gh(new File(a4TApA.f4396B25kr6), a4TApA.getType());
            a4TApA.f4400B7CMnp = 3;
        } else {
            a4TApA.f4400B7CMnp = 5;
            A4TApA(a4TApA);
            try {
                z = L2suez.A2egSU.A5SV6n(a4TApA.f4396B25kr6, a4TApA.f4402BChYOn);
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                a4TApA.f4400B7CMnp = 3;
                ASJ6gh(new File(a4TApA.f4396B25kr6), a4TApA.getType());
            } else {
                a4TApA.f4400B7CMnp = 4;
            }
        }
        this.f4411ARc23Z.ADYaiT(a4TApA);
        this.f4409A5SV6n.remove(a4TApA.f4392AcNBzu);
        this.f4410ADYaiT.remove(a4TApA.f4392AcNBzu);
        A4TApA(a4TApA);
        AcNBzu();
    }

    public final void ADYaiT(A4TApA a4TApA) {
        a4TApA.f4400B7CMnp = 4;
        this.f4411ARc23Z.ADYaiT(a4TApA);
        this.f4409A5SV6n.remove(a4TApA.f4392AcNBzu);
        this.f4410ADYaiT.remove(a4TApA.f4392AcNBzu);
        A4TApA(a4TApA);
        AcNBzu();
    }

    public final void AMqCpz(A4TApA a4TApA) {
        String str = a4TApA.f4392AcNBzu;
        int i = a4TApA.f4399B4ZgIw;
        long j = a4TApA.f4398B3GDIM;
        SQLiteDatabase writableDatabase = this.f4411ARc23Z.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PointCategory.PROGRESS, Integer.valueOf(i));
        contentValues.put("downloaded_size", Long.valueOf(j));
        contentValues.put("update_time", Long.valueOf(System.currentTimeMillis() / 1000));
        writableDatabase.update("downloads", contentValues, "id = ?", new String[]{str});
        writableDatabase.close();
        A4TApA(a4TApA);
    }

    public final void ARc23Z(A4TApA a4TApA, int i) {
        a4TApA.f4400B7CMnp = i;
        this.f4411ARc23Z.ADYaiT(a4TApA);
        A4TApA(a4TApA);
    }

    public final void AYUAbz(String str) {
        A4TApA a4TApA;
        SQLiteDatabase readableDatabase = this.f4411ARc23Z.getReadableDatabase();
        Cursor query = readableDatabase.query("downloads", null, "id = ?", new String[]{str}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            a4TApA = null;
        } else {
            a4TApA = A2egSU.A2egSU(query);
            query.close();
        }
        readableDatabase.close();
        if (a4TApA != null) {
            a4TApA.f4400B7CMnp = 0;
            AZkASS(a4TApA);
        }
    }

    public final void AZOQYO() {
        this.f4413AYUAbz = true;
        if (this.f4408A4TApA != null && !this.f4408A4TApA.isShutdown()) {
            this.f4408A4TApA.shutdownNow();
        }
        this.f4409A5SV6n.clear();
        this.f4410ADYaiT.clear();
        this.AMqCpz.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.sqlite.SQLiteClosable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    public final void AZkASS(A4TApA a4TApA) {
        long j;
        String str = a4TApA.f4392AcNBzu;
        if (str == null) {
            return;
        }
        HashMap hashMap = this.f4409A5SV6n;
        if (hashMap.containsKey(str)) {
            return;
        }
        ArrayDeque arrayDeque = this.AMqCpz;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            if (((A4TApA) it.next()).f4392AcNBzu.equals(str)) {
                return;
            }
        }
        try {
            ?? writableDatabase = this.f4411ARc23Z.getWritableDatabase();
            try {
                try {
                    j = writableDatabase.insertWithOnConflict("downloads", null, A2egSU.A4TApA(a4TApA), 5);
                } catch (Exception e) {
                    e.getMessage();
                    writableDatabase.close();
                    j = -1;
                }
                writableDatabase = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
                if (writableDatabase == 0) {
                    ADYaiT(a4TApA);
                    return;
                }
                A2egSU();
                if (hashMap.size() < 3) {
                    AaHO0E(a4TApA, 0);
                } else {
                    arrayDeque.add(a4TApA);
                    ARc23Z(a4TApA, 0);
                }
            } finally {
                writableDatabase.close();
            }
        } catch (Exception e2) {
            e2.getMessage();
            e2.getMessage();
            ADYaiT(a4TApA);
        }
    }

    public final void AaHO0E(A4TApA a4TApA, int i) {
        if (i > 2) {
            ADYaiT(a4TApA);
            return;
        }
        try {
            boolean z = false;
            if (!((this.f4408A4TApA == null || this.f4408A4TApA.isShutdown() || this.f4408A4TApA.isTerminated()) ? false : true)) {
                synchronized (this) {
                    if (this.f4408A4TApA != null && !this.f4408A4TApA.isShutdown() && !this.f4408A4TApA.isTerminated()) {
                        z = true;
                    }
                    if (!z) {
                        AZOQYO();
                        A2egSU();
                    }
                }
            }
            AMqCpz aMqCpz = new AMqCpz(a4TApA, this.f4412ASJ6gh, this);
            Future<?> submit = this.f4408A4TApA.submit(aMqCpz);
            this.f4409A5SV6n.put(a4TApA.f4392AcNBzu, aMqCpz);
            this.f4410ADYaiT.put(a4TApA.f4392AcNBzu, submit);
            ARc23Z(a4TApA, 1);
        } catch (RejectedExecutionException unused) {
            AZOQYO();
            A2egSU();
            AaHO0E(a4TApA, i + 1);
        } catch (Exception e) {
            e.getMessage();
            this.f4409A5SV6n.remove(a4TApA.f4392AcNBzu);
            this.f4410ADYaiT.remove(a4TApA.f4392AcNBzu);
            e.getMessage();
            ADYaiT(a4TApA);
            AcNBzu();
        }
    }

    public final void AcNBzu() {
        A4TApA a4TApA;
        ArrayDeque arrayDeque = this.AMqCpz;
        if (arrayDeque.isEmpty() || this.f4409A5SV6n.size() >= 3 || (a4TApA = (A4TApA) arrayDeque.poll()) == null) {
            return;
        }
        AaHO0E(a4TApA, 0);
    }
}
