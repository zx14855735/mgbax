package RD2OKB;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class B4ZgIw extends B3GDIM {
    public static boolean AYUAbz(Collection collection, Object obj) {
        int i;
        RXb0Sz.ARc23Z.AMqCpz(collection, "<this>");
        if (collection instanceof Collection) {
            return collection.contains(obj);
        }
        if (!(collection instanceof List)) {
            Iterator it = collection.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                if (RXb0Sz.ARc23Z.A2egSU(obj, next)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        } else {
            i = ((List) collection).indexOf(obj);
        }
        return i >= 0;
    }

    public static Object AZOQYO(List list) {
        RXb0Sz.ARc23Z.AMqCpz(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object AZkASS(D8MqeW.AmA8tU amA8tU, int i) {
        if (i < 0 || i >= amA8tU.A2egSU()) {
            return null;
        }
        return amA8tU.get(i);
    }

    public static String AaHO0E(Iterable iterable, Function1 function1, int i) {
        String str = (i & 2) != 0 ? "" : "[";
        String str2 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            function1 = null;
        }
        RXb0Sz.ARc23Z.AMqCpz(iterable, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ", ");
            }
            if (function1 != null) {
                sb.append((CharSequence) function1.invoke(next));
            } else {
                if (next != null ? next instanceof CharSequence : true) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append((CharSequence) String.valueOf(next));
                }
            }
        }
        sb.append((CharSequence) str2);
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }

    public static Object AcNBzu(List list) {
        RXb0Sz.ARc23Z.AMqCpz(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AaHO0E.ADYaiT(list));
    }

    public static final void AlLFFp(Iterable iterable, AbstractCollection abstractCollection) {
        RXb0Sz.ARc23Z.AMqCpz(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static ArrayList AmA8tU(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set AzWtSf(ArrayList arrayList) {
        BI9f7h bI9f7h = BI9f7h.f7848AcNBzu;
        int size = arrayList.size();
        if (size == 0) {
            return bI9f7h;
        }
        if (size != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(BNL6CD.A2egSU(arrayList.size()));
            AlLFFp(arrayList, linkedHashSet);
            return linkedHashSet;
        }
        Set singleton = Collections.singleton(arrayList.get(0));
        RXb0Sz.ARc23Z.ADYaiT(singleton, "singleton(...)");
        return singleton;
    }
}
