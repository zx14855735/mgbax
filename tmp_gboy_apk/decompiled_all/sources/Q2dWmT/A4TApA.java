package Q2dWmT;

import B4ZgIw.AYUAbz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.gson.internal.ASJ6gh;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Reader;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA implements Closeable {

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static final char[] f7427BPw6Q8 = ")]}'\n".toCharArray();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Reader f7428AcNBzu;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public long f7436B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f7437B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public String f7438BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int[] f7439BI9f7h;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public String[] f7441BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int[] f7442BNL6CD;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f7429AlLFFp = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final char[] f7430AmA8tU = new char[1024];

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7431AzWtSf = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f7432B25kr6 = 0;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f7433B2KMhB = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f7434B3GDIM = 0;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f7435B4ZgIw = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f7440BIYEnU = 1;

    static {
        ASJ6gh.f12035A2egSU = new A2egSU();
        UAzJMAY();
    }

    public A4TApA(Reader reader) {
        int[] iArr = new int[32];
        this.f7439BI9f7h = iArr;
        iArr[0] = 6;
        this.f7441BJ7GGh = new String[32];
        this.f7442BNL6CD = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f7428AcNBzu = reader;
    }

    private static /* synthetic */ void UAzJMAY() {
        char[] charArray = "7;9z3591z6;-z'<188z\u001e:=\u0016&=031".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'T');
        }
        String str = new String(charArray);
        char[] charArray2 = "78=:= ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'T');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void A2egSU() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 3) {
            BI9f7h(1);
            this.f7442BNL6CD[this.f7440BIYEnU - 1] = 0;
            this.f7435B4ZgIw = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
    }

    public void A4TApA() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 1) {
            BI9f7h(3);
            this.f7435B4ZgIw = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
    }

    public final void A5SV6n() {
        if (this.f7429AlLFFp) {
            return;
        }
        BTvldC("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01b4, code lost:
    
        r22 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0209, code lost:
    
        if (AZkASS(r15) != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x020c, code lost:
    
        if (r4 != 2) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x020e, code lost:
    
        if (r13 == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0214, code lost:
    
        if (r22 != Long.MIN_VALUE) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0216, code lost:
    
        if (r14 == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x021b, code lost:
    
        r10 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x021d, code lost:
    
        if (r14 == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0220, code lost:
    
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0221, code lost:
    
        r24.f7436B7CMnp = r10;
        r24.f7431AzWtSf += r7;
        r15 = 15;
        r24.f7435B4ZgIw = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x022d, code lost:
    
        if (r4 == 2) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0230, code lost:
    
        if (r4 == 4) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0233, code lost:
    
        if (r4 != 7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0235, code lost:
    
        r24.f7437B9tovu = r7;
        r15 = 16;
        r24.f7435B4ZgIw = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0262 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ADYaiT() {
        /*
            Method dump skipped, instructions count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2dWmT.A4TApA.ADYaiT():int");
    }

    public void AMqCpz() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
        int i2 = this.f7440BIYEnU;
        this.f7440BIYEnU = i2 - 1;
        int[] iArr = this.f7442BNL6CD;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f7435B4ZgIw = 0;
    }

    public void ARc23Z() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
        int i2 = this.f7440BIYEnU;
        int i3 = i2 - 1;
        this.f7440BIYEnU = i3;
        this.f7441BJ7GGh[i3] = null;
        int[] iArr = this.f7442BNL6CD;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f7435B4ZgIw = 0;
    }

    public final boolean ASJ6gh(int i) {
        int i2;
        int i3;
        int i4 = this.f7434B3GDIM;
        int i5 = this.f7431AzWtSf;
        this.f7434B3GDIM = i4 - i5;
        int i6 = this.f7432B25kr6;
        char[] cArr = this.f7430AmA8tU;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f7432B25kr6 = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f7432B25kr6 = 0;
        }
        this.f7431AzWtSf = 0;
        do {
            int i8 = this.f7432B25kr6;
            int read = this.f7428AcNBzu.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.f7432B25kr6 + read;
            this.f7432B25kr6 = i2;
            if (this.f7433B2KMhB == 0 && (i3 = this.f7434B3GDIM) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f7431AzWtSf++;
                this.f7434B3GDIM = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    public String AYUAbz() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.f7440BIYEnU;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f7439BI9f7h[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.f7442BNL6CD[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.f7441BJ7GGh[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public boolean AZOQYO() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean AZkASS(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME /* 93 */:
                            return false;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        A5SV6n();
        return false;
    }

    public final String AaHO0E() {
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(this.f7433B2KMhB + 1, (this.f7431AzWtSf - this.f7434B3GDIM) + 1, " at line ", " column ", " path ");
        B7CMnp2.append(AYUAbz());
        return B7CMnp2.toString();
    }

    public boolean AcNBzu() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 5) {
            this.f7435B4ZgIw = 0;
            int[] iArr = this.f7442BNL6CD;
            int i2 = this.f7440BIYEnU - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i != 6) {
            throw new IllegalStateException("Expected a boolean but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
        this.f7435B4ZgIw = 0;
        int[] iArr2 = this.f7442BNL6CD;
        int i3 = this.f7440BIYEnU - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public double AlLFFp() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 15) {
            this.f7435B4ZgIw = 0;
            int[] iArr = this.f7442BNL6CD;
            int i2 = this.f7440BIYEnU - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f7436B7CMnp;
        }
        if (i == 16) {
            this.f7438BChYOn = new String(this.f7430AmA8tU, this.f7431AzWtSf, this.f7437B9tovu);
            this.f7431AzWtSf += this.f7437B9tovu;
        } else if (i == 8 || i == 9) {
            this.f7438BChYOn = B4ZgIw(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f7438BChYOn = B9tovu();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
        this.f7435B4ZgIw = 11;
        double parseDouble = Double.parseDouble(this.f7438BChYOn);
        if (!this.f7429AlLFFp && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new ADYaiT("JSON forbids NaN and infinities: " + parseDouble + AaHO0E());
        }
        this.f7438BChYOn = null;
        this.f7435B4ZgIw = 0;
        int[] iArr2 = this.f7442BNL6CD;
        int i3 = this.f7440BIYEnU - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public int AmA8tU() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 15) {
            long j = this.f7436B7CMnp;
            int i2 = (int) j;
            if (j != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f7436B7CMnp + AaHO0E());
            }
            this.f7435B4ZgIw = 0;
            int[] iArr = this.f7442BNL6CD;
            int i3 = this.f7440BIYEnU - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.f7438BChYOn = new String(this.f7430AmA8tU, this.f7431AzWtSf, this.f7437B9tovu);
            this.f7431AzWtSf += this.f7437B9tovu;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw new IllegalStateException("Expected an int but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
            }
            if (i == 10) {
                this.f7438BChYOn = B9tovu();
            } else {
                this.f7438BChYOn = B4ZgIw(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f7438BChYOn);
                this.f7435B4ZgIw = 0;
                int[] iArr2 = this.f7442BNL6CD;
                int i4 = this.f7440BIYEnU - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f7435B4ZgIw = 11;
        double parseDouble = Double.parseDouble(this.f7438BChYOn);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f7438BChYOn + AaHO0E());
        }
        this.f7438BChYOn = null;
        this.f7435B4ZgIw = 0;
        int[] iArr3 = this.f7442BNL6CD;
        int i6 = this.f7440BIYEnU - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long AzWtSf() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 15) {
            this.f7435B4ZgIw = 0;
            int[] iArr = this.f7442BNL6CD;
            int i2 = this.f7440BIYEnU - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f7436B7CMnp;
        }
        if (i == 16) {
            this.f7438BChYOn = new String(this.f7430AmA8tU, this.f7431AzWtSf, this.f7437B9tovu);
            this.f7431AzWtSf += this.f7437B9tovu;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw new IllegalStateException("Expected a long but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
            }
            if (i == 10) {
                this.f7438BChYOn = B9tovu();
            } else {
                this.f7438BChYOn = B4ZgIw(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f7438BChYOn);
                this.f7435B4ZgIw = 0;
                int[] iArr2 = this.f7442BNL6CD;
                int i3 = this.f7440BIYEnU - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f7435B4ZgIw = 11;
        double parseDouble = Double.parseDouble(this.f7438BChYOn);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f7438BChYOn + AaHO0E());
        }
        this.f7438BChYOn = null;
        this.f7435B4ZgIw = 0;
        int[] iArr3 = this.f7442BNL6CD;
        int i4 = this.f7440BIYEnU - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String B25kr6() {
        String B4ZgIw2;
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 14) {
            B4ZgIw2 = B9tovu();
        } else if (i == 12) {
            B4ZgIw2 = B4ZgIw('\'');
        } else {
            if (i != 13) {
                throw new IllegalStateException("Expected a name but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
            }
            B4ZgIw2 = B4ZgIw('\"');
        }
        this.f7435B4ZgIw = 0;
        this.f7441BJ7GGh[this.f7440BIYEnU - 1] = B4ZgIw2;
        return B4ZgIw2;
    }

    public final int B2KMhB(boolean z) {
        char c;
        int i = this.f7431AzWtSf;
        int i2 = this.f7432B25kr6;
        while (true) {
            if (i == i2) {
                this.f7431AzWtSf = i;
                if (!ASJ6gh(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + AaHO0E());
                }
                i = this.f7431AzWtSf;
                i2 = this.f7432B25kr6;
            }
            int i3 = i + 1;
            char[] cArr = this.f7430AmA8tU;
            c = cArr[i];
            if (c == '\n') {
                this.f7433B2KMhB++;
                this.f7434B3GDIM = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f7431AzWtSf = i3;
                    if (i3 == i2) {
                        this.f7431AzWtSf = i;
                        boolean ASJ6gh2 = ASJ6gh(2);
                        this.f7431AzWtSf++;
                        if (!ASJ6gh2) {
                            break;
                        }
                    }
                    A5SV6n();
                    int i4 = this.f7431AzWtSf;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.f7431AzWtSf = i4 + 1;
                        while (true) {
                            if (this.f7431AzWtSf + 2 > this.f7432B25kr6 && !ASJ6gh(2)) {
                                BTvldC("Unterminated comment");
                                throw null;
                            }
                            int i5 = this.f7431AzWtSf;
                            if (cArr[i5] != '\n') {
                                for (int i6 = 0; i6 < 2; i6++) {
                                    if (cArr[this.f7431AzWtSf + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                }
                                i = this.f7431AzWtSf + 2;
                                i2 = this.f7432B25kr6;
                                break;
                            }
                            this.f7433B2KMhB++;
                            this.f7434B3GDIM = i5 + 1;
                            this.f7431AzWtSf++;
                        }
                    } else {
                        if (c2 != '/') {
                            break;
                        }
                        this.f7431AzWtSf = i4 + 1;
                        BNL6CD();
                        i = this.f7431AzWtSf;
                        i2 = this.f7432B25kr6;
                    }
                } else {
                    if (c != '#') {
                        this.f7431AzWtSf = i3;
                        return c;
                    }
                    this.f7431AzWtSf = i3;
                    A5SV6n();
                    BNL6CD();
                    i = this.f7431AzWtSf;
                    i2 = this.f7432B25kr6;
                }
            }
            i = i3;
        }
        return c;
    }

    public void B3GDIM() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i != 7) {
            throw new IllegalStateException("Expected null but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
        }
        this.f7435B4ZgIw = 0;
        int[] iArr = this.f7442BNL6CD;
        int i2 = this.f7440BIYEnU - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r0.append(r4, r2, r1 - r2);
        r8.f7431AzWtSf = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String B4ZgIw(char r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            int r1 = r8.f7431AzWtSf
            int r2 = r8.f7432B25kr6
        L9:
            r3 = r2
            r2 = r1
        Lb:
            char[] r4 = r8.f7430AmA8tU
            r5 = 1
            if (r1 >= r3) goto L46
            int r6 = r1 + 1
            char r1 = r4[r1]
            if (r1 != r9) goto L22
            r8.f7431AzWtSf = r6
            int r6 = r6 - r2
            int r6 = r6 - r5
            r0.append(r4, r2, r6)
            java.lang.String r9 = r0.toString()
            return r9
        L22:
            r7 = 92
            if (r1 != r7) goto L39
            r8.f7431AzWtSf = r6
            int r6 = r6 - r2
            int r6 = r6 - r5
            r0.append(r4, r2, r6)
            char r1 = r8.BIYEnU()
            r0.append(r1)
            int r1 = r8.f7431AzWtSf
            int r2 = r8.f7432B25kr6
            goto L9
        L39:
            r4 = 10
            if (r1 != r4) goto L44
            int r1 = r8.f7433B2KMhB
            int r1 = r1 + r5
            r8.f7433B2KMhB = r1
            r8.f7434B3GDIM = r6
        L44:
            r1 = r6
            goto Lb
        L46:
            int r3 = r1 - r2
            r0.append(r4, r2, r3)
            r8.f7431AzWtSf = r1
            boolean r1 = r8.ASJ6gh(r5)
            if (r1 == 0) goto L54
            goto L5
        L54:
            java.lang.String r9 = "Unterminated string"
            r8.BTvldC(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2dWmT.A4TApA.B4ZgIw(char):java.lang.String");
    }

    public String B7CMnp() {
        String str;
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        if (i == 10) {
            str = B9tovu();
        } else if (i == 8) {
            str = B4ZgIw('\'');
        } else if (i == 9) {
            str = B4ZgIw('\"');
        } else if (i == 11) {
            str = this.f7438BChYOn;
            this.f7438BChYOn = null;
        } else if (i == 15) {
            str = Long.toString(this.f7436B7CMnp);
        } else {
            if (i != 16) {
                throw new IllegalStateException("Expected a string but was " + J3FDQU.A2egSU.BPw6Q8(BChYOn()) + AaHO0E());
            }
            str = new String(this.f7430AmA8tU, this.f7431AzWtSf, this.f7437B9tovu);
            this.f7431AzWtSf += this.f7437B9tovu;
        }
        this.f7435B4ZgIw = 0;
        int[] iArr = this.f7442BNL6CD;
        int i2 = this.f7440BIYEnU - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        A5SV6n();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String B9tovu() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r7.f7431AzWtSf
            int r4 = r3 + r2
            int r5 = r7.f7432B25kr6
            char[] r6 = r7.f7430AmA8tU
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.A5SV6n()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.ASJ6gh(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L74
        L5c:
            if (r0 != 0) goto L63
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L63:
            int r3 = r7.f7431AzWtSf
            r0.append(r6, r3, r2)
            int r3 = r7.f7431AzWtSf
            int r3 = r3 + r2
            r7.f7431AzWtSf = r3
            r2 = 1
            boolean r2 = r7.ASJ6gh(r2)
            if (r2 != 0) goto L2
        L74:
            if (r0 != 0) goto L7e
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f7431AzWtSf
            r0.<init>(r6, r2, r1)
            goto L87
        L7e:
            int r2 = r7.f7431AzWtSf
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L87:
            int r2 = r7.f7431AzWtSf
            int r2 = r2 + r1
            r7.f7431AzWtSf = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2dWmT.A4TApA.B9tovu():java.lang.String");
    }

    public int BChYOn() {
        int i = this.f7435B4ZgIw;
        if (i == 0) {
            i = ADYaiT();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void BI9f7h(int i) {
        int i2 = this.f7440BIYEnU;
        int[] iArr = this.f7439BI9f7h;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            String[] strArr = new String[i3];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f7442BNL6CD, 0, iArr3, 0, this.f7440BIYEnU);
            System.arraycopy(this.f7441BJ7GGh, 0, strArr, 0, this.f7440BIYEnU);
            this.f7439BI9f7h = iArr2;
            this.f7442BNL6CD = iArr3;
            this.f7441BJ7GGh = strArr;
        }
        int[] iArr4 = this.f7439BI9f7h;
        int i4 = this.f7440BIYEnU;
        this.f7440BIYEnU = i4 + 1;
        iArr4[i4] = i;
    }

    public final char BIYEnU() {
        int i;
        if (this.f7431AzWtSf == this.f7432B25kr6 && !ASJ6gh(1)) {
            BTvldC("Unterminated escape sequence");
            throw null;
        }
        int i2 = this.f7431AzWtSf;
        int i3 = i2 + 1;
        this.f7431AzWtSf = i3;
        char[] cArr = this.f7430AmA8tU;
        char c = cArr[i2];
        if (c == '\n') {
            this.f7433B2KMhB++;
            this.f7434B3GDIM = i3;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            BTvldC("Invalid escape sequence");
            throw null;
        }
        if (i2 + 5 > this.f7432B25kr6 && !ASJ6gh(4)) {
            BTvldC("Unterminated escape sequence");
            throw null;
        }
        int i4 = this.f7431AzWtSf;
        int i5 = i4 + 4;
        char c2 = 0;
        while (i4 < i5) {
            char c3 = cArr[i4];
            char c4 = (char) (c2 << 4);
            if (c3 >= '0' && c3 <= '9') {
                i = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(cArr, this.f7431AzWtSf, 4)));
                }
                i = c3 - '7';
            }
            c2 = (char) (i + c4);
            i4++;
        }
        this.f7431AzWtSf += 4;
        return c2;
    }

    public final void BJ7GGh(char c) {
        do {
            int i = this.f7431AzWtSf;
            int i2 = this.f7432B25kr6;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = this.f7430AmA8tU[i];
                if (c2 == c) {
                    this.f7431AzWtSf = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.f7431AzWtSf = i3;
                    BIYEnU();
                    i = this.f7431AzWtSf;
                    i2 = this.f7432B25kr6;
                } else {
                    if (c2 == '\n') {
                        this.f7433B2KMhB++;
                        this.f7434B3GDIM = i3;
                    }
                    i = i3;
                }
            }
            this.f7431AzWtSf = i;
        } while (ASJ6gh(1));
        BTvldC("Unterminated string");
        throw null;
    }

    public final void BNL6CD() {
        char c;
        do {
            if (this.f7431AzWtSf >= this.f7432B25kr6 && !ASJ6gh(1)) {
                return;
            }
            int i = this.f7431AzWtSf;
            int i2 = i + 1;
            this.f7431AzWtSf = i2;
            c = this.f7430AmA8tU[i];
            if (c == '\n') {
                this.f7433B2KMhB++;
                this.f7434B3GDIM = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x009b. Please report as an issue. */
    public void BPw6Q8() {
        int i = 0;
        do {
            int i2 = this.f7435B4ZgIw;
            if (i2 == 0) {
                i2 = ADYaiT();
            }
            if (i2 == 3) {
                BI9f7h(1);
            } else if (i2 == 1) {
                BI9f7h(3);
            } else {
                if (i2 == 4) {
                    this.f7440BIYEnU--;
                } else if (i2 == 2) {
                    this.f7440BIYEnU--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        do {
                            int i3 = 0;
                            while (true) {
                                int i4 = this.f7431AzWtSf + i3;
                                if (i4 < this.f7432B25kr6) {
                                    char c = this.f7430AmA8tU[i4];
                                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                        if (c != '#') {
                                            if (c != ',') {
                                                if (c != '/' && c != '=') {
                                                    if (c != '{' && c != '}' && c != ':') {
                                                        if (c != ';') {
                                                            switch (c) {
                                                                case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                                                                case MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME /* 93 */:
                                                                    break;
                                                                case MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE /* 92 */:
                                                                    break;
                                                                default:
                                                                    i3++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.f7431AzWtSf = i4;
                                }
                            }
                            A5SV6n();
                            this.f7431AzWtSf += i3;
                        } while (ASJ6gh(1));
                    } else if (i2 == 8 || i2 == 12) {
                        BJ7GGh('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        BJ7GGh('\"');
                    } else if (i2 == 16) {
                        this.f7431AzWtSf += this.f7437B9tovu;
                    }
                    this.f7435B4ZgIw = 0;
                }
                i--;
                this.f7435B4ZgIw = 0;
            }
            i++;
            this.f7435B4ZgIw = 0;
        } while (i != 0);
        int[] iArr = this.f7442BNL6CD;
        int i5 = this.f7440BIYEnU;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.f7441BJ7GGh[i5 - 1] = "null";
    }

    public final void BTvldC(String str) {
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(AaHO0E());
        throw new ADYaiT(A4TApA2.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7435B4ZgIw = 0;
        this.f7439BI9f7h[0] = 8;
        this.f7440BIYEnU = 1;
        this.f7428AcNBzu.close();
    }

    public String toString() {
        return getClass().getSimpleName() + AaHO0E();
    }
}
