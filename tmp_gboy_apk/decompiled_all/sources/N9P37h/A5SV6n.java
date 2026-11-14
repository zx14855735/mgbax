package N9P37h;

import NCeV4Q.AZOQYO;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends NUtxJj.A2egSU {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final NSK3xo.A2egSU f5616B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final A5SV6n f5617B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f5618BChYOn;
    public static final Parcelable.Creator<A5SV6n> CREATOR;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5619AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5620AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Account f5621AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final boolean f5622AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f5623B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final boolean f5624B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final String f5625B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final String f5626B4ZgIw;

    static {
        NSK3xo.A2egSU a2egSU = new NSK3xo.A2egSU(1, "profile");
        new NSK3xo.A2egSU(1, "email");
        NSK3xo.A2egSU a2egSU2 = new NSK3xo.A2egSU(1, "openid");
        f5616B7CMnp = a2egSU2;
        A4TApA a4TApA = new A4TApA();
        a4TApA.f5610A2egSU.add(a2egSU2);
        a4TApA.f5610A2egSU.add(a2egSU);
        f5617B9tovu = a4TApA.A2egSU();
        CREATOR = new ARc23Z();
        f5618BChYOn = new B4ZgIw.ARc23Z(10);
        cAAVRe();
    }

    public A5SV6n(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f5619AcNBzu = i;
        this.f5620AlLFFp = arrayList;
        this.f5621AmA8tU = account;
        this.f5622AzWtSf = z;
        this.f5623B25kr6 = z2;
        this.f5624B2KMhB = z3;
        this.f5625B3GDIM = str;
        this.f5626B4ZgIw = str2;
    }

    public static A5SV6n A2egSU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new NSK3xo.A2egSU(1, jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new A5SV6n(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    private static /* synthetic */ void cAAVRe() {
        char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 223);
        }
        String str = new String(charArray);
        char[] charArray2 = "¼³¶±¶«".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 223);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        String str = this.f5625B3GDIM;
        ArrayList arrayList = this.f5620AlLFFp;
        if (obj == null) {
            return false;
        }
        try {
            A5SV6n a5SV6n = (A5SV6n) obj;
            ArrayList arrayList2 = a5SV6n.f5620AlLFFp;
            String str2 = a5SV6n.f5625B3GDIM;
            Account account = a5SV6n.f5621AmA8tU;
            if (arrayList.size() != new ArrayList(arrayList2).size() || !arrayList.containsAll(new ArrayList(arrayList2))) {
                return false;
            }
            Account account2 = this.f5621AmA8tU;
            if (account2 == null) {
                if (account != null) {
                    return false;
                }
            } else if (!account2.equals(account)) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            if (this.f5624B2KMhB == a5SV6n.f5624B2KMhB && this.f5622AzWtSf == a5SV6n.f5622AzWtSf) {
                return this.f5623B25kr6 == a5SV6n.f5623B25kr6;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f5620AlLFFp.iterator();
        while (it.hasNext()) {
            arrayList.add(((NSK3xo.A2egSU) it.next()).f5920AlLFFp);
        }
        Collections.sort(arrayList);
        AZOQYO azoqyo = new AZOQYO();
        azoqyo.A2egSU(arrayList);
        azoqyo.A2egSU(this.f5621AmA8tU);
        azoqyo.A2egSU(this.f5625B3GDIM);
        int i = (31 * ((((azoqyo.f5649A2egSU * 31) + (this.f5624B2KMhB ? 1 : 0)) * 31) + (this.f5622AzWtSf ? 1 : 0))) + (this.f5623B25kr6 ? 1 : 0);
        azoqyo.f5649A2egSU = i;
        return i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5619AcNBzu);
        JrXYwF.A4TApA.AzWtSf(parcel, 2, new ArrayList(this.f5620AlLFFp));
        JrXYwF.A4TApA.ARc23Z(parcel, 3, this.f5621AmA8tU, i);
        JrXYwF.A4TApA.AcNBzu(parcel, 4, 4);
        parcel.writeInt(this.f5622AzWtSf ? 1 : 0);
        JrXYwF.A4TApA.AcNBzu(parcel, 5, 4);
        parcel.writeInt(this.f5623B25kr6 ? 1 : 0);
        JrXYwF.A4TApA.AcNBzu(parcel, 6, 4);
        parcel.writeInt(this.f5624B2KMhB ? 1 : 0);
        JrXYwF.A4TApA.ASJ6gh(parcel, 7, this.f5625B3GDIM);
        JrXYwF.A4TApA.ASJ6gh(parcel, 8, this.f5626B4ZgIw);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }

    public A5SV6n(HashSet hashSet, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(hashSet), account, z, z2, z3, str, str2);
    }
}
