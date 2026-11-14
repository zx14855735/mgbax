package HSr46Q;

import Hdahpu.AZOQYO;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements com.bumptech.glide.load.data.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3478AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Comparable f3479AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f3480AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Object f3481AzWtSf;

    public /* synthetic */ A5SV6n(int i, Comparable comparable, Object obj) {
        this.f3478AcNBzu = i;
        this.f3479AlLFFp = comparable;
        this.f3480AmA8tU = obj;
    }

    private final void A4TApA() {
    }

    private final void A5SV6n() {
    }

    private final void ADYaiT() {
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final Class A2egSU() {
        switch (this.f3478AcNBzu) {
            case 0:
                return InputStream.class;
            case 1:
                ((AZOQYO) this.f3480AmA8tU).getClass();
                return InputStream.class;
            default:
                return ((AZOQYO) this.f3480AmA8tU).AcNBzu();
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void AMqCpz() {
        switch (this.f3478AcNBzu) {
            case 0:
                InputStream inputStream = (InputStream) this.f3481AzWtSf;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            case 1:
                try {
                    ((ByteArrayInputStream) this.f3481AzWtSf).close();
                    break;
                } catch (IOException unused2) {
                    return;
                }
            default:
                Object obj = this.f3481AzWtSf;
                if (obj != null) {
                    try {
                        switch (((AZOQYO) this.f3480AmA8tU).f3699AcNBzu) {
                            case 4:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                        break;
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void ARc23Z(com.bumptech.glide.AZOQYO azoqyo, com.bumptech.glide.load.data.ADYaiT aDYaiT) {
        Object open;
        switch (this.f3478AcNBzu) {
            case 0:
                try {
                    InputStream ASJ6gh2 = ASJ6gh();
                    this.f3481AzWtSf = ASJ6gh2;
                    aDYaiT.ASJ6gh(ASJ6gh2);
                    break;
                } catch (FileNotFoundException e) {
                    Log.isLoggable("MediaStoreThumbFetcher", 3);
                    aDYaiT.A5SV6n(e);
                    return;
                }
            case 1:
                try {
                    ByteArrayInputStream AZkASS2 = AZOQYO.AZkASS((String) this.f3479AlLFFp);
                    this.f3481AzWtSf = AZkASS2;
                    aDYaiT.ASJ6gh(AZkASS2);
                    break;
                } catch (IllegalArgumentException e2) {
                    aDYaiT.A5SV6n(e2);
                    return;
                }
            default:
                try {
                    AZOQYO azoqyo2 = (AZOQYO) this.f3480AmA8tU;
                    File file = (File) this.f3479AlLFFp;
                    switch (azoqyo2.f3699AcNBzu) {
                        case 4:
                            open = ParcelFileDescriptor.open(file, C.ENCODING_PCM_MU_LAW);
                            break;
                        default:
                            open = new FileInputStream(file);
                            break;
                    }
                    this.f3481AzWtSf = open;
                    aDYaiT.ASJ6gh(open);
                    break;
                } catch (FileNotFoundException e3) {
                    Log.isLoggable("FileLoader", 3);
                    aDYaiT.A5SV6n(e3);
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        if (r5 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003b, code lost:
    
        if (r5 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream ASJ6gh() {
        /*
            r12 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            java.lang.Comparable r1 = r12.f3479AlLFFp
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.Object r2 = r12.f3480AmA8tU
            HSr46Q.AMqCpz r2 = (HSr46Q.AMqCpz) r2
            r3 = 3
            r4 = 0
            HSr46Q.ADYaiT r5 = r2.f3482A2egSU     // Catch: java.lang.Throwable -> L2e java.lang.SecurityException -> L31
            android.database.Cursor r5 = r5.query(r1)     // Catch: java.lang.Throwable -> L2e java.lang.SecurityException -> L31
            if (r5 == 0) goto L27
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L23 java.lang.SecurityException -> L32
            if (r6 == 0) goto L27
            r6 = 0
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Throwable -> L23 java.lang.SecurityException -> L32
            r5.close()
            goto L3e
        L23:
            r0 = move-exception
            r4 = r5
            goto Lc3
        L27:
            if (r5 == 0) goto L2c
        L29:
            r5.close()
        L2c:
            r6 = r4
            goto L3e
        L2e:
            r0 = move-exception
            goto Lc3
        L31:
            r5 = r4
        L32:
            boolean r6 = android.util.Log.isLoggable(r0, r3)     // Catch: java.lang.Throwable -> L23
            if (r6 == 0) goto L3b
            java.util.Objects.toString(r1)     // Catch: java.lang.Throwable -> L23
        L3b:
            if (r5 == 0) goto L2c
            goto L29
        L3e:
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            android.content.ContentResolver r7 = r2.f3484A5SV6n
            if (r5 == 0) goto L48
        L46:
            r5 = r4
            goto L89
        L48:
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            boolean r6 = r5.exists()
            if (r6 == 0) goto L46
            long r8 = r5.length()
            r10 = 0
            int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r6 >= 0) goto L46
            android.net.Uri r5 = android.net.Uri.fromFile(r5)
            java.io.InputStream r5 = r7.openInputStream(r5)     // Catch: java.lang.NullPointerException -> L66
            goto L89
        L66:
            r0 = move-exception
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "NPE opening uri: "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " -> "
            r3.append(r1)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            java.lang.Throwable r0 = r2.initCause(r0)
            java.io.FileNotFoundException r0 = (java.io.FileNotFoundException) r0
            throw r0
        L89:
            r6 = -1
            if (r5 == 0) goto Lb9
            java.io.InputStream r4 = r7.openInputStream(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Throwable -> La2
            java.util.ArrayList r7 = r2.f3485ADYaiT     // Catch: java.lang.Throwable -> La0 java.lang.Throwable -> La2
            HZUvgL.AaHO0E r2 = r2.f3483A4TApA     // Catch: java.lang.Throwable -> La0 java.lang.Throwable -> La2
            int r0 = HSHyT0.AZOQYO.A2egSU(r2, r4, r7)     // Catch: java.lang.Throwable -> La0 java.lang.Throwable -> La2
            if (r4 == 0) goto Lba
            r4.close()     // Catch: java.io.IOException -> L9e
            goto Lba
        L9e:
            goto Lba
        La0:
            r0 = move-exception
            goto Lb3
        La2:
            boolean r0 = android.util.Log.isLoggable(r0, r3)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lab
            java.util.Objects.toString(r1)     // Catch: java.lang.Throwable -> La0
        Lab:
            if (r4 == 0) goto Lb9
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb9
        Lb1:
            goto Lb9
        Lb3:
            if (r4 == 0) goto Lb8
            r4.close()     // Catch: java.io.IOException -> Lb8
        Lb8:
            throw r0
        Lb9:
            r0 = -1
        Lba:
            if (r0 == r6) goto Lc2
            com.bumptech.glide.load.data.AZkASS r1 = new com.bumptech.glide.load.data.AZkASS
            r1.<init>(r5, r0)
            r5 = r1
        Lc2:
            return r5
        Lc3:
            if (r4 == 0) goto Lc8
            r4.close()
        Lc8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: HSr46Q.A5SV6n.ASJ6gh():java.io.InputStream");
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final void cancel() {
        int i = this.f3478AcNBzu;
    }

    @Override // com.bumptech.glide.load.data.AMqCpz
    public final int getDataSource() {
        switch (this.f3478AcNBzu) {
        }
        return 1;
    }
}
