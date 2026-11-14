package N9P37h;

import NUY5pn.AYUAbz;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends NUtxJj.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f5598AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5599AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final String f5600AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final String f5601AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final String f5602B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final String f5603B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Uri f5604B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public String f5605B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final long f5606B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final String f5607B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final String f5608BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final String f5609BI9f7h;
    public static final Parcelable.Creator<A2egSU> CREATOR = new AMqCpz();

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f5597BIYEnU = new B4ZgIw.ARc23Z(9);

    static {
        XRGBUw();
    }

    public A2egSU(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.f5598AcNBzu = i;
        this.f5600AmA8tU = str;
        this.f5601AzWtSf = str2;
        this.f5602B25kr6 = str3;
        this.f5603B2KMhB = str4;
        this.f5604B3GDIM = uri;
        this.f5605B4ZgIw = str5;
        this.f5606B7CMnp = j;
        this.f5607B9tovu = str6;
        this.f5599AlLFFp = arrayList;
        this.f5608BChYOn = str7;
        this.f5609BI9f7h = str8;
    }

    public static A2egSU A2egSU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new NSK3xo.A2egSU(1, jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString(f.f13353a);
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString("email", null);
        String optString5 = jSONObject.optString("displayName", null);
        String optString6 = jSONObject.optString("givenName", null);
        String optString7 = jSONObject.optString("familyName", null);
        String string = jSONObject.getString("obfuscatedIdentifier");
        AYUAbz.ADYaiT(string);
        A2egSU a2egSU = new A2egSU(3, optString2, optString3, optString4, optString5, parse, null, parseLong, string, new ArrayList(hashSet), optString6, optString7);
        a2egSU.f5605B4ZgIw = jSONObject.optString("serverAuthCode", null);
        return a2egSU;
    }

    private static /* synthetic */ void XRGBUw() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final JSONObject A4TApA() {
        ArrayList arrayList = this.f5599AlLFFp;
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f5600AmA8tU;
            if (str != null) {
                jSONObject.put(f.f13353a, str);
            }
            String str2 = this.f5601AzWtSf;
            if (str2 != null) {
                jSONObject.put("tokenId", str2);
            }
            String str3 = this.f5602B25kr6;
            if (str3 != null) {
                jSONObject.put("email", str3);
            }
            String str4 = this.f5603B2KMhB;
            if (str4 != null) {
                jSONObject.put("displayName", str4);
            }
            String str5 = this.f5608BChYOn;
            if (str5 != null) {
                jSONObject.put("givenName", str5);
            }
            String str6 = this.f5609BI9f7h;
            if (str6 != null) {
                jSONObject.put("familyName", str6);
            }
            Uri uri = this.f5604B3GDIM;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str7 = this.f5605B4ZgIw;
            if (str7 != null) {
                jSONObject.put("serverAuthCode", str7);
            }
            jSONObject.put("expirationTime", this.f5606B7CMnp);
            jSONObject.put("obfuscatedIdentifier", this.f5607B9tovu);
            JSONArray jSONArray = new JSONArray();
            Collections.sort(arrayList, f5597BIYEnU);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(((NSK3xo.A2egSU) it.next()).f5920AlLFFp);
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof A2egSU) {
            return ((A2egSU) obj).A4TApA().toString().equals(A4TApA().toString());
        }
        return false;
    }

    public final int hashCode() {
        return A4TApA().toString().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int AZkASS2 = JrXYwF.A4TApA.AZkASS(parcel, 20293);
        JrXYwF.A4TApA.AcNBzu(parcel, 1, 4);
        parcel.writeInt(this.f5598AcNBzu);
        JrXYwF.A4TApA.ASJ6gh(parcel, 2, this.f5600AmA8tU);
        JrXYwF.A4TApA.ASJ6gh(parcel, 3, this.f5601AzWtSf);
        JrXYwF.A4TApA.ASJ6gh(parcel, 4, this.f5602B25kr6);
        JrXYwF.A4TApA.ASJ6gh(parcel, 5, this.f5603B2KMhB);
        JrXYwF.A4TApA.ARc23Z(parcel, 6, this.f5604B3GDIM, i);
        JrXYwF.A4TApA.ASJ6gh(parcel, 7, this.f5605B4ZgIw);
        JrXYwF.A4TApA.AcNBzu(parcel, 8, 8);
        parcel.writeLong(this.f5606B7CMnp);
        JrXYwF.A4TApA.ASJ6gh(parcel, 9, this.f5607B9tovu);
        JrXYwF.A4TApA.AzWtSf(parcel, 10, this.f5599AlLFFp);
        JrXYwF.A4TApA.ASJ6gh(parcel, 11, this.f5608BChYOn);
        JrXYwF.A4TApA.ASJ6gh(parcel, 12, this.f5609BI9f7h);
        JrXYwF.A4TApA.AmA8tU(parcel, AZkASS2);
    }
}
