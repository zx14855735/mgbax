package DAk1zC;

import ADYaiT.DUi7mC;
import B25kr6.AZOQYO;
import B25kr6.B25kr6;
import androidx.lifecycle.B9tovu;
import androidx.lifecycle.CtxOCS;
import com.sigmob.sdk.base.views.r;
import java.io.PrintWriter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f2056A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A4TApA f2057A4TApA;

    public A5SV6n(B9tovu b9tovu, CtxOCS ctxOCS) {
        this.f2056A2egSU = b9tovu;
        this.f2057A4TApA = (A4TApA) new DUi7mC(ctxOCS, A4TApA.AMqCpz).AlLFFp(A4TApA.class);
    }

    public final void A4TApA(String str, PrintWriter printWriter) {
        B25kr6 b25kr6 = this.f2057A4TApA.f2055ADYaiT;
        if (b25kr6.AMqCpz() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (b25kr6.AMqCpz() <= 0) {
                return;
            }
            if (b25kr6.ARc23Z(0) != null) {
                throw new ClassCastException();
            }
            printWriter.print(str);
            printWriter.print("  #");
            if (b25kr6.f1012AcNBzu) {
                AZOQYO.A2egSU(b25kr6);
            }
            printWriter.print(b25kr6.f1013AlLFFp[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f2056A2egSU;
        if (obj == null) {
            sb.append("null");
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
