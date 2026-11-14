package J3FDQU;

import B4ZgIw.AYUAbz;
import IzHBwY.ASJ6gh;
import RXb0Sz.ARc23Z;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A2egSU {
    public static final void A2egSU(int i, View view) {
        ARc23Z.AMqCpz(view, "view");
        int ADYaiT2 = AYUAbz.ADYaiT(i);
        if (ADYaiT2 == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                if (CtxOCS.C4FrIb(2)) {
                    view.toString();
                    viewGroup.toString();
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (ADYaiT2 == 1) {
            if (CtxOCS.C4FrIb(2)) {
                view.toString();
            }
            view.setVisibility(0);
        } else if (ADYaiT2 == 2) {
            if (CtxOCS.C4FrIb(2)) {
                view.toString();
            }
            view.setVisibility(8);
        } else {
            if (ADYaiT2 != 3) {
                return;
            }
            if (CtxOCS.C4FrIb(2)) {
                view.toString();
            }
            view.setVisibility(4);
        }
    }

    public static int A4TApA(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return BTvldC(str);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static int A5SV6n(String str, String str2, JSONObject jSONObject) {
        return jSONObject.optInt(str2, new Integer(str).intValue());
    }

    public static ASJ6gh ADYaiT(SparseArray sparseArray) {
        return new IzHBwY.AYUAbz(sparseArray).A2egSU();
    }

    public static ImageView AMqCpz(Context context, int i) {
        ImageView imageView = new ImageView(context);
        imageView.setId(i);
        return imageView;
    }

    public static LinearLayout ARc23Z(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(i);
        return linearLayout;
    }

    public static RelativeLayout.LayoutParams ASJ6gh(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(i3);
        return layoutParams;
    }

    public static RelativeLayout AYUAbz(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(i);
        return relativeLayout;
    }

    public static TextView AZOQYO(Context context, int i) {
        TextView textView = new TextView(context);
        textView.setId(i);
        return textView;
    }

    public static Object AcNBzu(String str) {
        return c.a().a(str).a();
    }

    public static Object AlLFFp(List list, int i) {
        return list.get(list.size() - i);
    }

    public static String AmA8tU(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String AzWtSf(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String B25kr6(String str, Number number) {
        return number.getClass().getName().concat(str);
    }

    public static String B2KMhB(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String B3GDIM(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String B4ZgIw(Throwable th, StringBuilder sb) {
        sb.append(th.getMessage());
        return sb.toString();
    }

    public static StringBuilder B7CMnp(int i, int i2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder B9tovu(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder BChYOn(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static HashMap BI9f7h(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static Map BIYEnU() {
        return Collections.synchronizedMap(new HashMap());
    }

    public static /* synthetic */ void BJ7GGh(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = ARc23Z.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder BChYOn2 = BChYOn("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            BChYOn2.append(str);
            NullPointerException nullPointerException = new NullPointerException(BChYOn2.toString());
            ARc23Z.ARc23Z(nullPointerException, ARc23Z.class.getName());
            throw nullPointerException;
        }
    }

    public static void BNL6CD(int i, HashMap hashMap, String str, int i2, String str2) {
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(str2, Integer.valueOf(i2));
    }

    public static /* synthetic */ String BPw6Q8(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int BTvldC(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals(an.c)) {
            return 1;
        }
        if (str.equals("PUT")) {
            return 2;
        }
        if (str.equals(an.b)) {
            return 3;
        }
        if (str.equals("DELETE")) {
            return 4;
        }
        if (str.equals(com.sigmob.sdk.downloader.core.c.f13360a)) {
            return 5;
        }
        if (str.equals("OPTIONS")) {
            return 6;
        }
        if (str.equals("TRACE")) {
            return 7;
        }
        if (str.equals("CONNECT")) {
            return 8;
        }
        if (str.equals("PATCH")) {
            return 9;
        }
        if (str.equals("PROPFIND")) {
            return 10;
        }
        if (str.equals("PROPPATCH")) {
            return 11;
        }
        if (str.equals("MKCOL")) {
            return 12;
        }
        if (str.equals("MOVE")) {
            return 13;
        }
        if (str.equals("COPY")) {
            return 14;
        }
        if (str.equals("LOCK")) {
            return 15;
        }
        if (str.equals("UNLOCK")) {
            return 16;
        }
        throw new IllegalArgumentException("No enum constant fi.iki.elonen.NanoHTTPD.Method.".concat(str));
    }
}
