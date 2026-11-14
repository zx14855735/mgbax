package Q2dWmT;

import com.sigmob.sdk.base.views.r;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A5SV6n implements Closeable, Flushable {

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final String[] f7443B9tovu = new String[r.b.d];

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final String[] f7444BChYOn;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Writer f7445AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int[] f7446AlLFFp = new int[32];

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7447AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public String f7448AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f7449B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f7450B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f7451B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public String f7452B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f7453B7CMnp;

    static {
        for (int i = 0; i <= 31; i++) {
            f7443B9tovu[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f7443B9tovu;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f7444BChYOn = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
        fVzwE();
    }

    public A5SV6n(Writer writer) {
        AaHO0E(6);
        this.f7449B25kr6 = ":";
        this.f7453B7CMnp = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f7445AcNBzu = writer;
    }

    private static /* synthetic */ void fVzwE() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        int AZkASS2 = AZkASS();
        if (AZkASS2 == 1) {
            this.f7446AlLFFp[this.f7447AmA8tU - 1] = 2;
            AYUAbz();
            return;
        }
        Writer writer = this.f7445AcNBzu;
        if (AZkASS2 == 2) {
            writer.append(',');
            AYUAbz();
        } else {
            if (AZkASS2 == 4) {
                writer.append((CharSequence) this.f7449B25kr6);
                this.f7446AlLFFp[this.f7447AmA8tU - 1] = 5;
                return;
            }
            if (AZkASS2 != 6) {
                if (AZkASS2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f7450B2KMhB) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f7446AlLFFp[this.f7447AmA8tU - 1] = 7;
        }
    }

    public void A4TApA() {
        B3GDIM();
        A2egSU();
        AaHO0E(1);
        this.f7445AcNBzu.write("[");
    }

    public void A5SV6n() {
        B3GDIM();
        A2egSU();
        AaHO0E(3);
        this.f7445AcNBzu.write("{");
    }

    public final void ADYaiT(int i, int i2, String str) {
        int AZkASS2 = AZkASS();
        if (AZkASS2 != i2 && AZkASS2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f7452B4ZgIw != null) {
            throw new IllegalStateException("Dangling name: " + this.f7452B4ZgIw);
        }
        this.f7447AmA8tU--;
        if (AZkASS2 == i2) {
            AYUAbz();
        }
        this.f7445AcNBzu.write(str);
    }

    public void AMqCpz() {
        ADYaiT(1, 2, "]");
    }

    public void ARc23Z() {
        ADYaiT(3, 5, "}");
    }

    public void ASJ6gh(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f7452B4ZgIw != null) {
            throw new IllegalStateException();
        }
        if (this.f7447AmA8tU == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f7452B4ZgIw = str;
    }

    public final void AYUAbz() {
        if (this.f7448AzWtSf == null) {
            return;
        }
        Writer writer = this.f7445AcNBzu;
        writer.write("\n");
        int i = this.f7447AmA8tU;
        for (int i2 = 1; i2 < i; i2++) {
            writer.write(this.f7448AzWtSf);
        }
    }

    public A5SV6n AZOQYO() {
        if (this.f7452B4ZgIw != null) {
            if (!this.f7453B7CMnp) {
                this.f7452B4ZgIw = null;
                return this;
            }
            B3GDIM();
        }
        A2egSU();
        this.f7445AcNBzu.write("null");
        return this;
    }

    public final int AZkASS() {
        int i = this.f7447AmA8tU;
        if (i != 0) {
            return this.f7446AlLFFp[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void AaHO0E(int i) {
        int i2 = this.f7447AmA8tU;
        int[] iArr = this.f7446AlLFFp;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f7446AlLFFp = iArr2;
        }
        int[] iArr3 = this.f7446AlLFFp;
        int i3 = this.f7447AmA8tU;
        this.f7447AmA8tU = i3 + 1;
        iArr3[i3] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AcNBzu(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f7451B3GDIM
            if (r0 == 0) goto L7
            java.lang.String[] r0 = Q2dWmT.A5SV6n.f7444BChYOn
            goto L9
        L7:
            java.lang.String[] r0 = Q2dWmT.A5SV6n.f7443B9tovu
        L9:
            java.io.Writer r1 = r8.f7445AcNBzu
            java.lang.String r2 = "\""
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = 0
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2dWmT.A5SV6n.AcNBzu(java.lang.String):void");
    }

    public void AlLFFp(long j) {
        B3GDIM();
        A2egSU();
        this.f7445AcNBzu.write(Long.toString(j));
    }

    public void AmA8tU(Boolean bool) {
        if (bool == null) {
            AZOQYO();
            return;
        }
        B3GDIM();
        A2egSU();
        this.f7445AcNBzu.write(bool.booleanValue() ? "true" : "false");
    }

    public void AzWtSf(Number number) {
        if (number == null) {
            AZOQYO();
            return;
        }
        B3GDIM();
        String obj = number.toString();
        if (this.f7450B2KMhB || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            A2egSU();
            this.f7445AcNBzu.append((CharSequence) obj);
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
    }

    public void B25kr6(String str) {
        if (str == null) {
            AZOQYO();
            return;
        }
        B3GDIM();
        A2egSU();
        AcNBzu(str);
    }

    public void B2KMhB(boolean z) {
        B3GDIM();
        A2egSU();
        this.f7445AcNBzu.write(z ? "true" : "false");
    }

    public final void B3GDIM() {
        if (this.f7452B4ZgIw != null) {
            int AZkASS2 = AZkASS();
            if (AZkASS2 == 5) {
                this.f7445AcNBzu.write(44);
            } else if (AZkASS2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            AYUAbz();
            this.f7446AlLFFp[this.f7447AmA8tU - 1] = 4;
            AcNBzu(this.f7452B4ZgIw);
            this.f7452B4ZgIw = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7445AcNBzu.close();
        int i = this.f7447AmA8tU;
        if (i > 1 || (i == 1 && this.f7446AlLFFp[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f7447AmA8tU = 0;
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f7447AmA8tU == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f7445AcNBzu.flush();
    }
}
