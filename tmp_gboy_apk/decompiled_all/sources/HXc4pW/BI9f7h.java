package HXc4pW;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends Exception {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final StackTraceElement[] f3613B2KMhB = new StackTraceElement[0];

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final List f3614AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public HSHyT0.AZkASS f3615AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f3616AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Class f3617AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final String f3618B25kr6;

    static {
        NgVP();
    }

    public BI9f7h(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void A2egSU(Throwable th, ArrayList arrayList) {
        if (!(th instanceof BI9f7h)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((BI9f7h) th).f3614AcNBzu.iterator();
        while (it.hasNext()) {
            A2egSU((Throwable) it.next(), arrayList);
        }
    }

    public static void A4TApA(List list, BChYOn bChYOn) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            bChYOn.append("Cause (");
            int i2 = i + 1;
            bChYOn.append(String.valueOf(i2));
            bChYOn.append(" of ");
            bChYOn.append(String.valueOf(size));
            bChYOn.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof BI9f7h) {
                ((BI9f7h) th).ADYaiT(bChYOn);
            } else {
                A5SV6n(th, bChYOn);
            }
            i = i2;
        }
    }

    public static void A5SV6n(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static /* synthetic */ void NgVP() {
        char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '+');
        }
        String str = new String(charArray);
        char[] charArray2 = "HGBEB_".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '+');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void ADYaiT(Appendable appendable) {
        A5SV6n(this, appendable);
        try {
            A4TApA(this.f3614AcNBzu, new BChYOn(appendable));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f3618B25kr6);
        String str3 = "";
        if (this.f3617AzWtSf != null) {
            str = ", " + this.f3617AzWtSf;
        } else {
            str = "";
        }
        sb.append(str);
        int i = this.f3616AmA8tU;
        if (i != 0) {
            str2 = ", ".concat(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL");
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.f3615AlLFFp != null) {
            str3 = ", " + this.f3615AlLFFp;
        }
        sb.append(str3);
        ArrayList arrayList = new ArrayList();
        A2egSU(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        ADYaiT(System.err);
    }

    public BI9f7h(String str, List list) {
        this.f3618B25kr6 = str;
        setStackTrace(f3613B2KMhB);
        this.f3614AcNBzu = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        ADYaiT(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        ADYaiT(printWriter);
    }
}
