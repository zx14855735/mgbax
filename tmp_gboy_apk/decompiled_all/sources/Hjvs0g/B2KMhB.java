package Hjvs0g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB implements com.bumptech.glide.load.data.AMqCpz {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final String[] f3733AzWtSf = {"_data"};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3734AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3735AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f3736AmA8tU;

    static {
        BBPygRC();
    }

    public /* synthetic */ B2KMhB(Object obj, int i, Object obj2) {
        this.f3734AcNBzu = i;
        this.f3735AlLFFp = obj;
        this.f3736AmA8tU = obj2;
    }

    private final void A4TApA() {
    }

    private final void A5SV6n() {
    }

    private final void ADYaiT() {
    }

    private final void ASJ6gh() {
    }

    private static /* synthetic */ void BBPygRC() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        switch (this.f3734AcNBzu) {
            case 0:
                return File.class;
            default:
                return ((Hdahpu.AZOQYO) this.f3736AmA8tU).AcNBzu();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        int i = this.f3734AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, com.bumptech.glide.load.data.ADYaiT aDYaiT) {
        Object wrap;
        switch (this.f3734AcNBzu) {
            case 0:
                Cursor query = ((Context) this.f3735AlLFFp).getContentResolver().query((Uri) this.f3736AmA8tU, f3733AzWtSf, null, null, null);
                if (query != null) {
                    try {
                        r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                        query.close();
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                if (!TextUtils.isEmpty(r0)) {
                    aDYaiT.ASJ6gh(new File(r0));
                    return;
                }
                aDYaiT.A5SV6n(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f3736AmA8tU)));
                return;
            default:
                Hdahpu.AZOQYO azoqyo2 = (Hdahpu.AZOQYO) this.f3736AmA8tU;
                byte[] bArr = (byte[]) this.f3735AlLFFp;
                switch (azoqyo2.f3699AcNBzu) {
                    case 1:
                        wrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        wrap = new ByteArrayInputStream(bArr);
                        break;
                }
                aDYaiT.ASJ6gh(wrap);
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        int i = this.f3734AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        switch (this.f3734AcNBzu) {
        }
        return 1;
    }
}
