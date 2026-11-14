package LqstKO;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.sigmob.sdk.archives.tar.d;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.w3c.dom.Element;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA implements ADYaiT {

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final int[] f4891COJEAR = new int[4];

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static boolean f4892CQhlFr = false;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public static volatile int f4893CSDoyG = 0;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static boolean f4894CTkVKb = false;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static float f4895CcAIMM = 60.0f;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static int f4896Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public static boolean f4897CikNvS;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f4898AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4899AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A5SV6n f4900AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public A2egSU f4901AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AMqCpz f4902B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public short[] f4903B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public short[][] f4904B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int[] f4905B4ZgIw;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int[] f4918C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public int[] f4919C4FrIb;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f4906B7CMnp = 0;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f4907B9tovu = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f4908BChYOn = 0;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f4909BI9f7h = -1;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f4910BIYEnU = -1;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f4911BJ7GGh = -1;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f4912BNL6CD = -1;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f4913BPw6Q8 = 0;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f4914BTvldC = 0;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f4915BV3sI0 = 0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f4916BmvVmW = 0;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f4917BniPrB = 0;
    public boolean BpkvW3 = false;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f4920CASmeH = 0;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public int f4921CNPG0E = 0;

    static {
        nxlrIx();
    }

    public static void A5SV6n(A5SV6n a5SV6n) {
        int[] iArr = a5SV6n.f4930AZkASS;
        if (iArr == null || !a5SV6n.f4932AcNBzu) {
            return;
        }
        int length = iArr.length;
        int i = a5SV6n.f4931AaHO0E;
        for (int i2 = 0; i2 < length; i2++) {
            GLES20.glActiveTexture(33985 + i2);
            GLES20.glBindTexture(3553, a5SV6n.f4930AZkASS[((((i - 1) - i2) + length) + length) % length]);
        }
        GLES20.glActiveTexture(33984);
    }

    public static void AMqCpz(A5SV6n a5SV6n) {
        if (a5SV6n.f4930AZkASS == null || !a5SV6n.f4932AcNBzu) {
            return;
        }
        int i = a5SV6n.f4931AaHO0E;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, a5SV6n.f4930AZkASS[i]);
        GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, a5SV6n.f4928AYUAbz, a5SV6n.f4929AZOQYO, 0);
        GLES20.glActiveTexture(33984);
    }

    public static int ARc23Z(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static int ASJ6gh(int i, int i2) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, i);
        GLES20.glAttachShader(glCreateProgram, i2);
        GLES20.glBindAttribLocation(glCreateProgram, 0, "aPosition");
        GLES20.glBindAttribLocation(glCreateProgram, 1, "aTexCoord");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static boolean AZOQYO() {
        return f4896Cd8JRx == 1;
    }

    public static boolean AZkASS(InputStream inputStream, int i, int i2) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        if (decodeStream == null) {
            return false;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(i + 33984);
        GLES20.glBindTexture(3553, iArr[0]);
        GLUtils.texImage2D(3553, 0, decodeStream, 0);
        GLES20.glTexParameteri(3553, 10241, i2);
        GLES20.glTexParameteri(3553, d.b, i2);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        decodeStream.recycle();
        return true;
    }

    public static int AaHO0E(String str, float f) {
        if (str != null && !str.isEmpty()) {
            try {
                return str.endsWith("%") ? (int) ((Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f) * f) : Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static synchronized void AcNBzu(boolean z) {
        synchronized (A4TApA.class) {
            f4892CQhlFr = z;
            f4894CTkVKb = true;
            if (!z) {
                f4893CSDoyG = 0;
                return;
            }
            if (!(f4895CcAIMM >= 110.0f)) {
                f4893CSDoyG = 0;
                f4892CQhlFr = false;
            } else {
                int floor = ((int) Math.floor(r4 / 60.0f)) - 1;
                if (floor > 3) {
                    floor = 3;
                }
                f4893CSDoyG = floor;
            }
        }
    }

    public static void AlLFFp(int i, String str, float f, float f2) {
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, str);
        if (glGetUniformLocation != -1) {
            GLES20.glUniform2f(glGetUniformLocation, f, f2);
        }
    }

    private static /* synthetic */ void nxlrIx() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // LqstKO.ADYaiT
    public final void A2egSU(ARc23Z aRc23Z) {
        char c;
        int i;
        A2egSU a2egSU = this.f4901AzWtSf;
        int[] iArr = f4891COJEAR;
        if (a2egSU == null) {
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
            A5SV6n a5SV6n = this.f4900AmA8tU;
            if (a5SV6n != null) {
                int i2 = a5SV6n.f4923A4TApA;
                if (i2 != -1) {
                    GLES20.glUniform2f(i2, aRc23Z.f4939A4TApA, aRc23Z.f4940A5SV6n);
                }
                if (a5SV6n.f4924A5SV6n != 0) {
                    GLES20.glGetIntegerv(2978, iArr, 0);
                    GLES20.glBindFramebuffer(36160, a5SV6n.f4924A5SV6n);
                    GLES20.glViewport(0, 0, a5SV6n.f4926ARc23Z, a5SV6n.f4927ASJ6gh);
                    GLES20.glBindBuffer(34962, a5SV6n.AMqCpz);
                    GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
                    GLES20.glUseProgram(this.f4898AcNBzu);
                    GLES20.glBindTexture(3553, a5SV6n.f4925ADYaiT);
                    GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
                    GLES20.glBindBuffer(34962, aRc23Z.f4938A2egSU);
                }
            }
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
            return;
        }
        A5SV6n[] a5SV6nArr = a2egSU.f4887A2egSU;
        int length = a5SV6nArr.length;
        GLES20.glGetIntegerv(2978, iArr, 0);
        int i3 = this.f4902B25kr6.f4933AcNBzu;
        int i4 = a2egSU.f4888A4TApA;
        if (i4 != 0) {
            GLES20.glBindFramebuffer(36160, i4);
            c = 2;
            GLES20.glViewport(0, 0, a2egSU.f4890ADYaiT, a2egSU.AMqCpz);
            GLES20.glUseProgram(this.f4898AcNBzu);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i3);
            GLES20.glBindBuffer(34962, a5SV6nArr[0].AMqCpz);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            c = 2;
        }
        int i5 = 0;
        while (true) {
            i = length - 1;
            if (i5 >= i) {
                break;
            }
            A5SV6n a5SV6n2 = a5SV6nArr[i5];
            GLES20.glUseProgram(a5SV6n2.f4922A2egSU);
            if (a5SV6n2.f4930AZkASS != null && a5SV6n2.f4932AcNBzu && !f4897CikNvS) {
                int i6 = i5 == 0 ? a2egSU.f4888A4TApA : a5SV6nArr[i5 - 1].f4924A5SV6n;
                if (i6 != 0) {
                    GLES20.glBindFramebuffer(36160, i6);
                    AMqCpz(a5SV6n2);
                    int[] iArr2 = a5SV6n2.f4930AZkASS;
                    if (iArr2 != null && a5SV6n2.f4932AcNBzu) {
                        a5SV6n2.f4931AaHO0E = (a5SV6n2.f4931AaHO0E + 1) % iArr2.length;
                    }
                }
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i3);
            A5SV6n(a5SV6n2);
            AlLFFp(a5SV6n2.f4922A2egSU, "rubyTextureSize", a5SV6n2.f4928AYUAbz, a5SV6n2.f4929AZOQYO);
            AlLFFp(a5SV6n2.f4922A2egSU, "rubyInputSize", a5SV6n2.f4928AYUAbz, a5SV6n2.f4929AZOQYO);
            int i7 = a5SV6n2.f4923A4TApA;
            if (i7 != -1) {
                GLES20.glUniform2f(i7, a5SV6n2.f4926ARc23Z, a5SV6n2.f4927ASJ6gh);
            }
            GLES20.glBindFramebuffer(36160, a5SV6n2.f4924A5SV6n);
            GLES20.glViewport(0, 0, a5SV6n2.f4926ARc23Z, a5SV6n2.f4927ASJ6gh);
            GLES20.glBindBuffer(34962, a5SV6n2.AMqCpz);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
            GLES20.glDrawArrays(5, 0, 4);
            i3 = a5SV6n2.f4925ADYaiT;
            i5++;
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(iArr[0], iArr[1], iArr[c], iArr[3]);
        A5SV6n a5SV6n3 = a5SV6nArr[i];
        GLES20.glUseProgram(a5SV6n3.f4922A2egSU);
        if (a5SV6n3.f4930AZkASS != null && a5SV6n3.f4932AcNBzu && !f4897CikNvS) {
            int i8 = length >= 2 ? a5SV6nArr[length - 2].f4924A5SV6n : a2egSU.f4888A4TApA;
            if (i8 != 0) {
                GLES20.glBindFramebuffer(36160, i8);
                AMqCpz(a5SV6n3);
                int[] iArr3 = a5SV6n3.f4930AZkASS;
                if (iArr3 != null && a5SV6n3.f4932AcNBzu) {
                    a5SV6n3.f4931AaHO0E = (a5SV6n3.f4931AaHO0E + 1) % iArr3.length;
                }
            }
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i3);
        A5SV6n(a5SV6n3);
        AlLFFp(a5SV6n3.f4922A2egSU, "rubyTextureSize", a5SV6n3.f4928AYUAbz, a5SV6n3.f4929AZOQYO);
        AlLFFp(a5SV6n3.f4922A2egSU, "rubyInputSize", a5SV6n3.f4928AYUAbz, a5SV6n3.f4929AZOQYO);
        int i9 = a5SV6n3.f4923A4TApA;
        if (i9 != -1) {
            GLES20.glUniform2f(i9, aRc23Z.f4939A4TApA, aRc23Z.f4940A5SV6n);
        }
        int i10 = a5SV6n3.f4924A5SV6n;
        if (i10 == 0) {
            GLES20.glBindBuffer(34962, aRc23Z.f4938A2egSU);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
            return;
        }
        GLES20.glBindFramebuffer(36160, i10);
        GLES20.glViewport(0, 0, a5SV6n3.f4926ARc23Z, a5SV6n3.f4927ASJ6gh);
        GLES20.glBindBuffer(34962, a5SV6n3.AMqCpz);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        GLES20.glUseProgram(this.f4898AcNBzu);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, a5SV6n3.f4925ADYaiT);
        GLES20.glBindBuffer(34962, aRc23Z.f4938A2egSU);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 16, 0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 16, 8);
    }

    public final boolean A4TApA(AMqCpz aMqCpz, Element[] elementArr) {
        int i;
        if (elementArr.length != 0) {
            if (elementArr.length == 1) {
                A5SV6n ADYaiT2 = ADYaiT(aMqCpz, elementArr[0], aMqCpz.f4935AmA8tU, aMqCpz.f4936AzWtSf, false);
                if (ADYaiT2 == null) {
                    return false;
                }
                aMqCpz.f4937B25kr6 = ADYaiT2;
                return true;
            }
            A2egSU a2egSU = new A2egSU();
            a2egSU.f4887A2egSU = new A5SV6n[elementArr.length];
            int i2 = aMqCpz.f4935AmA8tU;
            int i3 = aMqCpz.f4936AzWtSf;
            for (int i4 = 0; i4 < elementArr.length; i4++) {
                A5SV6n ADYaiT3 = ADYaiT(aMqCpz, elementArr[i4], i2, i3, true);
                if (ADYaiT3 == null) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        A5SV6n a5SV6n = a2egSU.f4887A2egSU[i5];
                        if (a5SV6n != null) {
                            int i6 = a5SV6n.f4922A2egSU;
                            if (i6 != 0) {
                                GLES20.glDeleteProgram(i6);
                                a5SV6n.f4922A2egSU = 0;
                            }
                            int i7 = a5SV6n.f4924A5SV6n;
                            if (i7 != 0) {
                                GLES20.glDeleteFramebuffers(1, new int[]{i7}, 0);
                                a5SV6n.f4924A5SV6n = 0;
                            }
                            int i8 = a5SV6n.f4925ADYaiT;
                            if (i8 != 0) {
                                GLES20.glDeleteTextures(1, new int[]{i8}, 0);
                                a5SV6n.f4925ADYaiT = 0;
                            }
                            int i9 = a5SV6n.AMqCpz;
                            if (i9 != 0) {
                                GLES20.glDeleteBuffers(1, new int[]{i9}, 0);
                                a5SV6n.AMqCpz = 0;
                            }
                            if (a5SV6n.f4930AZkASS != null) {
                                int i10 = !a5SV6n.f4932AcNBzu ? 1 : 0;
                                while (true) {
                                    int[] iArr = a5SV6n.f4930AZkASS;
                                    if (i10 >= iArr.length) {
                                        break;
                                    }
                                    int i11 = iArr[i10];
                                    if (i11 != 0) {
                                        GLES20.glDeleteTextures(1, new int[]{i11}, 0);
                                    }
                                    i10++;
                                }
                                a5SV6n.f4930AZkASS = null;
                            }
                        }
                    }
                } else {
                    a2egSU.f4887A2egSU[i4] = ADYaiT3;
                    int i12 = ADYaiT3.f4926ARc23Z;
                    if (i12 > 0 && (i = ADYaiT3.f4927ASJ6gh) > 0) {
                        i2 = i12;
                        i3 = i;
                    }
                }
            }
            A5SV6n a5SV6n2 = a2egSU.f4887A2egSU[0];
            if (a5SV6n2.f4930AZkASS != null && a5SV6n2.f4932AcNBzu) {
                int i13 = a5SV6n2.f4928AYUAbz;
                int i14 = a5SV6n2.f4929AZOQYO;
                if (i13 > 0 && i14 > 0) {
                    int[] iArr2 = new int[1];
                    GLES20.glGenFramebuffers(1, iArr2, 0);
                    a2egSU.f4888A4TApA = iArr2[0];
                    GLES20.glGenTextures(1, iArr2, 0);
                    a2egSU.f4889A5SV6n = iArr2[0];
                    GLES20.glBindFramebuffer(36160, a2egSU.f4888A4TApA);
                    GLES20.glBindTexture(3553, a2egSU.f4889A5SV6n);
                    GLES20.glTexImage2D(3553, 0, 6408, i13, i14, 0, 6408, 5121, null);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, a2egSU.f4889A5SV6n, 0);
                    GLES20.glTexParameteri(3553, 10241, 9728);
                    GLES20.glTexParameteri(3553, d.b, 9728);
                    GLES20.glTexParameteri(3553, 10242, 33071);
                    GLES20.glTexParameteri(3553, 10243, 33071);
                    GLES20.glBindFramebuffer(36160, 0);
                    a2egSU.f4890ADYaiT = i13;
                    a2egSU.AMqCpz = i14;
                }
            }
            aMqCpz.f4937B25kr6 = a2egSU;
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:69|70|(3:71|72|(1:74))|75|76|78|68) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final LqstKO.A5SV6n ADYaiT(LqstKO.AMqCpz r37, org.w3c.dom.Element r38, int r39, int r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LqstKO.A4TApA.ADYaiT(LqstKO.AMqCpz, org.w3c.dom.Element, int, int, boolean):LqstKO.A5SV6n");
    }

    @Override // LqstKO.ADYaiT
    public final void AYUAbz(AMqCpz aMqCpz) {
        this.f4902B25kr6 = aMqCpz;
        Object obj = aMqCpz.f4937B25kr6;
        if (obj == null) {
            this.f4900AmA8tU = null;
            this.f4901AzWtSf = null;
            GLES20.glUseProgram(this.f4898AcNBzu);
            return;
        }
        if (obj instanceof A2egSU) {
            this.f4900AmA8tU = null;
            this.f4901AzWtSf = (A2egSU) obj;
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, aMqCpz.f4933AcNBzu);
            return;
        }
        this.f4901AzWtSf = null;
        A5SV6n a5SV6n = (A5SV6n) obj;
        this.f4900AmA8tU = a5SV6n;
        GLES20.glUseProgram(a5SV6n.f4922A2egSU);
        int[] iArr = a5SV6n.f4930AZkASS;
        if (iArr == null || a5SV6n.f4932AcNBzu || f4897CikNvS) {
            return;
        }
        int length = iArr.length;
        int i = a5SV6n.f4931AaHO0E;
        aMqCpz.f4933AcNBzu = iArr[i];
        for (int i2 = 0; i2 < length; i2++) {
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, a5SV6n.f4930AZkASS[((i - i2) + length) % length]);
        }
        a5SV6n.f4931AaHO0E = (i + 1) % length;
        GLES20.glActiveTexture(33984);
    }

    @Override // LqstKO.ADYaiT
    public final void a() {
        this.f4899AlLFFp = ARc23Z(35633, "attribute vec2 aPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nvoid main() {\ngl_Position = vec4(aPosition, 0.0, 1.0);\nvTexCoord = aTexCoord;\n}\n");
        this.f4898AcNBzu = ASJ6gh(this.f4899AlLFFp, ARc23Z(35632, "precision mediump float;\nuniform sampler2D rubyTexture;\nvarying vec2 vTexCoord;\nvoid main() {\ngl_FragColor = texture2D(rubyTexture, vTexCoord);\n}\n"));
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glEnableVertexAttribArray(1);
        int ARc23Z2 = ARc23Z(35633, "attribute vec2 aPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nvoid main() {\n  gl_Position = vec4(aPosition, 0.0, 1.0);\n  vTexCoord = aTexCoord;\n}\n");
        int ARc23Z3 = ARc23Z(35632, "precision highp float;\nuniform sampler2D prevTex;\nuniform sampler2D curTex;\nuniform vec2 texSize;\nuniform float blend;\nvarying vec2 vTexCoord;\nvoid main() {\n  vec3 cur = texture2D(curTex, vTexCoord).rgb;\n  vec3 prev = texture2D(prevTex, vTexCoord).rgb;\n  \n  // 静止检测：差异极小直接输出当前帧，避免模糊\n  float staticDiff = dot(abs(cur - prev), vec3(1.0));\n  if (staticDiff < 0.02) {\n    gl_FragColor = vec4(cur, 1.0);\n    return;\n  }\n  \n  // 搜索最佳偏移 (±2像素，适应GBA放大后纹理)\n  float bestDiff = 1.0;\n  vec2 bestOffset = vec2(0.0);\n  for (int dy = -2; dy <= 2; dy++) {\n    for (int dx = -2; dx <= 2; dx++) {\n      vec2 offset = vec2(float(dx), float(dy)) * texSize;\n      vec3 s = texture2D(prevTex, vTexCoord + offset).rgb;\n      float diff = dot(abs(cur - s), vec3(1.0));\n      if (diff < bestDiff) {\n        bestDiff = diff;\n        bestOffset = offset;\n      }\n    }\n  }\n  \n  // 单向正确warp：中间帧 t=blend\n  vec3 fromPrev = texture2D(prevTex, vTexCoord + bestOffset * blend).rgb;\n  vec3 fromCur  = texture2D(curTex,  vTexCoord - bestOffset * blend).rgb;\n  \n  // 双向一致性信任度\n  float consist = dot(abs(fromPrev - fromCur), vec3(1.0));\n  float trust = 1.0 - clamp(consist * 0.5, 0.0, 1.0);\n  \n  // 合成：光流混合，不可信时回退当前帧（不回退简单平均）\n  vec3 flowMixed = mix(fromPrev, fromCur, blend);\n  vec3 outColor = mix(cur, flowMixed, trust);\n  \n  gl_FragColor = vec4(outColor, 1.0);\n}\n");
        if (ARc23Z2 == 0 || ARc23Z3 == 0) {
            return;
        }
        int ASJ6gh2 = ASJ6gh(ARc23Z2, ARc23Z3);
        this.f4908BChYOn = ASJ6gh2;
        if (ASJ6gh2 == 0) {
            return;
        }
        this.f4909BI9f7h = GLES20.glGetUniformLocation(ASJ6gh2, "prevTex");
        this.f4910BIYEnU = GLES20.glGetUniformLocation(this.f4908BChYOn, "curTex");
        this.f4911BJ7GGh = GLES20.glGetUniformLocation(this.f4908BChYOn, "texSize");
        this.f4912BNL6CD = GLES20.glGetUniformLocation(this.f4908BChYOn, "blend");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(new float[]{-1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f}).position(0);
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        int i = iArr[0];
        this.f4913BPw6Q8 = i;
        GLES20.glBindBuffer(34962, i);
        GLES20.glBufferData(34962, 64, asFloatBuffer, 35044);
    }
}
