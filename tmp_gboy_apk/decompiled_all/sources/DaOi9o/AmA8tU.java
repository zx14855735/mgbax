package DaOi9o;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Dphsd2;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AmA8tU extends Dphsd2 {
    @Override // androidx.fragment.app.Dphsd2
    public final void A2egSU(View view, Object obj) {
        ((B4ZgIw) obj).A4TApA(view);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void A4TApA(Object obj, ArrayList arrayList) {
        B4ZgIw b4ZgIw = (B4ZgIw) obj;
        if (b4ZgIw == null) {
            return;
        }
        int i = 0;
        if (b4ZgIw instanceof BPw6Q8) {
            BPw6Q8 bPw6Q8 = (BPw6Q8) b4ZgIw;
            int size = bPw6Q8.f2275CcAIMM.size();
            while (i < size) {
                A4TApA((i < 0 || i >= bPw6Q8.f2275CcAIMM.size()) ? null : (B4ZgIw) bPw6Q8.f2275CcAIMM.get(i), arrayList);
                i++;
            }
            return;
        }
        if (Dphsd2.AYUAbz(b4ZgIw.f2242B25kr6) && Dphsd2.AYUAbz(b4ZgIw.f2243B2KMhB)) {
            int size2 = arrayList.size();
            while (i < size2) {
                b4ZgIw.A4TApA((View) arrayList.get(i));
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void A5SV6n(ViewGroup viewGroup, Object obj) {
        BJ7GGh.A2egSU(viewGroup, (B4ZgIw) obj);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final boolean AMqCpz(Object obj) {
        return obj instanceof B4ZgIw;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object ARc23Z(Object obj) {
        if (obj != null) {
            return ((B4ZgIw) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object AZOQYO(Object obj, Object obj2, Object obj3) {
        B4ZgIw b4ZgIw = (B4ZgIw) obj;
        B4ZgIw b4ZgIw2 = (B4ZgIw) obj2;
        B4ZgIw b4ZgIw3 = (B4ZgIw) obj3;
        if (b4ZgIw != null && b4ZgIw2 != null) {
            BPw6Q8 bPw6Q8 = new BPw6Q8();
            bPw6Q8.COJEAR(b4ZgIw);
            bPw6Q8.COJEAR(b4ZgIw2);
            bPw6Q8.CTkVKb(1);
            b4ZgIw = bPw6Q8;
        } else if (b4ZgIw == null) {
            b4ZgIw = b4ZgIw2 != null ? b4ZgIw2 : null;
        }
        if (b4ZgIw3 == null) {
            return b4ZgIw;
        }
        BPw6Q8 bPw6Q82 = new BPw6Q8();
        if (b4ZgIw != null) {
            bPw6Q82.COJEAR(b4ZgIw);
        }
        bPw6Q82.COJEAR(b4ZgIw3);
        return bPw6Q82;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object AZkASS(Object obj, Object obj2) {
        BPw6Q8 bPw6Q8 = new BPw6Q8();
        if (obj != null) {
            bPw6Q8.COJEAR((B4ZgIw) obj);
        }
        bPw6Q8.COJEAR((B4ZgIw) obj2);
        return bPw6Q8;
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AaHO0E(Object obj, View view, ArrayList arrayList) {
        ((B4ZgIw) obj).A2egSU(new AZkASS(view, arrayList));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AcNBzu(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((B4ZgIw) obj).A2egSU(new AaHO0E(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AlLFFp(View view, Object obj) {
        if (view != null) {
            Dphsd2.ASJ6gh(new Rect(), view);
            ((B4ZgIw) obj).BmvVmW(new AZOQYO());
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AmA8tU(Object obj, Rect rect) {
        ((B4ZgIw) obj).BmvVmW(new AlLFFp());
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void AzWtSf(Object obj, C2rE4F.AMqCpz aMqCpz, androidx.fragment.app.AYUAbz aYUAbz) {
        B4ZgIw b4ZgIw = (B4ZgIw) obj;
        aMqCpz.A2egSU(new AYUAbz(b4ZgIw, 0, aYUAbz));
        b4ZgIw.A2egSU(new AcNBzu(aYUAbz));
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void B25kr6(Object obj, View view, ArrayList arrayList) {
        BPw6Q8 bPw6Q8 = (BPw6Q8) obj;
        ArrayList arrayList2 = bPw6Q8.f2243B2KMhB;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Dphsd2.ADYaiT(arrayList2, (View) arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        A4TApA(bPw6Q8, arrayList);
    }

    @Override // androidx.fragment.app.Dphsd2
    public final void B2KMhB(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        BPw6Q8 bPw6Q8 = (BPw6Q8) obj;
        if (bPw6Q8 != null) {
            ArrayList arrayList3 = bPw6Q8.f2243B2KMhB;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            B4ZgIw(bPw6Q8, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.Dphsd2
    public final Object B3GDIM(Object obj) {
        if (obj == null) {
            return null;
        }
        BPw6Q8 bPw6Q8 = new BPw6Q8();
        bPw6Q8.COJEAR((B4ZgIw) obj);
        return bPw6Q8;
    }

    public final void B4ZgIw(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        B4ZgIw b4ZgIw = (B4ZgIw) obj;
        int i = 0;
        if (b4ZgIw instanceof BPw6Q8) {
            BPw6Q8 bPw6Q8 = (BPw6Q8) b4ZgIw;
            int size = bPw6Q8.f2275CcAIMM.size();
            while (i < size) {
                B4ZgIw((i < 0 || i >= bPw6Q8.f2275CcAIMM.size()) ? null : (B4ZgIw) bPw6Q8.f2275CcAIMM.get(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (Dphsd2.AYUAbz(b4ZgIw.f2242B25kr6)) {
            ArrayList arrayList3 = b4ZgIw.f2243B2KMhB;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size2) {
                    b4ZgIw.A4TApA((View) arrayList2.get(i));
                    i++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b4ZgIw.BNL6CD((View) arrayList.get(size3));
                }
            }
        }
    }
}
