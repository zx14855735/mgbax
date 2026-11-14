package HtmBAy;

import HSHyT0.AmA8tU;
import Hjvs0g.BChYOn;
import Hjvs0g.BI9f7h;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.AZOQYO;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements com.bumptech.glide.load.data.AMqCpz {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final String[] f3780BChYOn = {"_data"};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f3781AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final BI9f7h f3782AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BI9f7h f3783AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Uri f3784AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f3785B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f3786B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final AmA8tU f3787B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Class f3788B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public volatile boolean f3789B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public volatile com.bumptech.glide.load.data.AMqCpz f3790B9tovu;

    static {
        BCxA();
    }

    public A5SV6n(Context context, BI9f7h bI9f7h, BI9f7h bI9f7h2, Uri uri, int i, int i2, AmA8tU amA8tU, Class cls) {
        this.f3781AcNBzu = context.getApplicationContext();
        this.f3782AlLFFp = bI9f7h;
        this.f3783AmA8tU = bI9f7h2;
        this.f3784AzWtSf = uri;
        this.f3785B25kr6 = i;
        this.f3786B2KMhB = i2;
        this.f3787B3GDIM = amA8tU;
        this.f3788B4ZgIw = cls;
    }

    private static /* synthetic */ void BCxA() {
        char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 239);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 239);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        return this.f3788B4ZgIw;
    }

    public final com.bumptech.glide.load.data.AMqCpz A4TApA() {
        boolean isExternalStorageLegacy;
        int checkSelfPermission;
        BChYOn A2egSU2;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        AmA8tU amA8tU = this.f3787B3GDIM;
        int i = this.f3786B2KMhB;
        int i2 = this.f3785B25kr6;
        Context context = this.f3781AcNBzu;
        if (isExternalStorageLegacy) {
            Uri uri = this.f3784AzWtSf;
            try {
                Cursor query = context.getContentResolver().query(uri, f3780BChYOn, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            query.close();
                            A2egSU2 = this.f3782AlLFFp.A2egSU(file, i2, i, amA8tU);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            Uri uri2 = this.f3784AzWtSf;
            if (checkSelfPermission == 0) {
                uri2 = MediaStore.setRequireOriginal(uri2);
            }
            A2egSU2 = this.f3783AmA8tU.A2egSU(uri2, i2, i, amA8tU);
        }
        if (A2egSU2 != null) {
            return A2egSU2.f3744A5SV6n;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        com.bumptech.glide.load.data.AMqCpz aMqCpz = this.f3790B9tovu;
        if (aMqCpz != null) {
            aMqCpz.AMqCpz();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(AZOQYO azoqyo, com.bumptech.glide.load.data.ADYaiT aDYaiT) {
        try {
            com.bumptech.glide.load.data.AMqCpz A4TApA2 = A4TApA();
            if (A4TApA2 == null) {
                aDYaiT.A5SV6n(new IllegalArgumentException("Failed to build fetcher for: " + this.f3784AzWtSf));
            } else {
                this.f3790B9tovu = A4TApA2;
                if (this.f3789B7CMnp) {
                    cancel();
                } else {
                    A4TApA2.ARc23Z(azoqyo, aDYaiT);
                }
            }
        } catch (FileNotFoundException e) {
            aDYaiT.A5SV6n(e);
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        this.f3789B7CMnp = true;
        com.bumptech.glide.load.data.AMqCpz aMqCpz = this.f3790B9tovu;
        if (aMqCpz != null) {
            aMqCpz.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        return 1;
    }
}
