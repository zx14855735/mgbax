package COJEAR;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements AMqCpz, ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1618AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f1619AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1620AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1621AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Object f1622B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Cloneable f1623B2KMhB;

    public /* synthetic */ ARc23Z() {
        this.f1618AcNBzu = 0;
    }

    public void A2egSU(FG7pZc fG7pZc, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((EUIRHA) it.next()).f1716A2egSU.A5SV6n() & 8) != 0) {
                ((View) this.f1622B25kr6).setTranslationY(NdEzCJ.A2egSU.A5SV6n(r3.f1716A2egSU.A4TApA(), this.f1621AzWtSf, 0));
                return;
            }
        }
    }

    @Override // COJEAR.ASJ6gh
    public ClipData A5SV6n() {
        return (ClipData) this.f1619AlLFFp;
    }

    @Override // COJEAR.AMqCpz
    public void AMqCpz(Uri uri) {
        this.f1622B25kr6 = uri;
    }

    @Override // COJEAR.AMqCpz
    public void AZOQYO(int i) {
        this.f1621AzWtSf = i;
    }

    @Override // COJEAR.ASJ6gh
    public int B25kr6() {
        return this.f1621AzWtSf;
    }

    @Override // COJEAR.ASJ6gh
    public ContentInfo B2KMhB() {
        return null;
    }

    @Override // COJEAR.AMqCpz
    public AYUAbz build() {
        return new AYUAbz(new ARc23Z(this));
    }

    @Override // COJEAR.ASJ6gh
    public int getSource() {
        return this.f1620AmA8tU;
    }

    @Override // COJEAR.AMqCpz
    public void setExtras(Bundle bundle) {
        this.f1623B2KMhB = bundle;
    }

    public String toString() {
        String str;
        switch (this.f1618AcNBzu) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.f1619AlLFFp).getDescription());
                sb.append(", source=");
                int i = this.f1620AmA8tU;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.f1621AzWtSf;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                Uri uri = (Uri) this.f1622B25kr6;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return ADYaiT.CtFAbx.B25kr6(sb, ((Bundle) this.f1623B2KMhB) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int[], java.lang.Cloneable] */
    public ARc23Z(View view) {
        this.f1618AcNBzu = 2;
        this.f1623B2KMhB = new int[2];
        this.f1622B25kr6 = view;
    }

    public ARc23Z(ARc23Z aRc23Z) {
        this.f1618AcNBzu = 1;
        ClipData clipData = (ClipData) aRc23Z.f1619AlLFFp;
        clipData.getClass();
        this.f1619AlLFFp = clipData;
        int i = aRc23Z.f1620AmA8tU;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i <= 5) {
            this.f1620AmA8tU = i;
            int i2 = aRc23Z.f1621AzWtSf;
            if ((i2 & 1) == i2) {
                this.f1621AzWtSf = i2;
                this.f1622B25kr6 = (Uri) aRc23Z.f1622B25kr6;
                this.f1623B2KMhB = (Bundle) aRc23Z.f1623B2KMhB;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
