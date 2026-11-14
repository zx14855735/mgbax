package Hjvs0g;

import ADYaiT.DUi7mC;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3711A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f3712A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f3713A5SV6n;

    public /* synthetic */ A4TApA(Object obj, int i, Object obj2) {
        this.f3711A2egSU = i;
        this.f3712A4TApA = obj;
        this.f3713A5SV6n = obj2;
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [Hjvs0g.A2egSU, java.lang.Object] */
    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        BChYOn A2egSU2;
        Uri uri;
        switch (this.f3711A2egSU) {
            case 0:
                Uri uri2 = (Uri) obj;
                return new BChYOn(new IssTRV.ADYaiT(uri2), this.f3713A5SV6n.AmA8tU((AssetManager) this.f3712A4TApA, uri2.toString().substring(22)));
            case 1:
                ArrayList arrayList = (ArrayList) this.f3712A4TApA;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                HSHyT0.AZkASS aZkASS = null;
                for (int i3 = 0; i3 < size; i3++) {
                    BI9f7h bI9f7h = (BI9f7h) arrayList.get(i3);
                    if (bI9f7h.A4TApA(obj) && (A2egSU2 = bI9f7h.A2egSU(obj, i, i2, amA8tU)) != null) {
                        arrayList2.add(A2egSU2.f3744A5SV6n);
                        aZkASS = A2egSU2.f3742A2egSU;
                    }
                }
                if (arrayList2.isEmpty() || aZkASS == null) {
                    return null;
                }
                return new BChYOn(aZkASS, new BPw6Q8(arrayList2, (DUi7mC) this.f3713A5SV6n));
            default:
                Integer num = (Integer) obj;
                Resources resources = (Resources) this.f3713A5SV6n;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num.intValue()) + '/' + resources.getResourceTypeName(num.intValue()) + '/' + resources.getResourceEntryName(num.intValue()));
                } catch (Resources.NotFoundException unused) {
                    Log.isLoggable("ResourceLoader", 5);
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((BI9f7h) this.f3712A4TApA).A2egSU(uri, i, i2, amA8tU);
        }
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        switch (this.f3711A2egSU) {
            case 0:
                Uri uri = (Uri) obj;
                return n.z.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                Iterator it = ((ArrayList) this.f3712A4TApA).iterator();
                while (it.hasNext()) {
                    if (((BI9f7h) it.next()).A4TApA(obj)) {
                        return true;
                    }
                }
                return false;
            default:
                return true;
        }
    }

    public String toString() {
        switch (this.f3711A2egSU) {
            case 1:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f3712A4TApA).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public A4TApA(Resources resources, BI9f7h bI9f7h) {
        this.f3711A2egSU = 2;
        this.f3713A5SV6n = resources;
        this.f3712A4TApA = bI9f7h;
    }
}
