package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C4FrIb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        LinearLayoutManager.A2egSU a2egSU = new LinearLayoutManager.A2egSU();
        a2egSU.f9423AcNBzu = parcel.readInt();
        a2egSU.f9424AlLFFp = parcel.readInt();
        a2egSU.f9425AmA8tU = parcel.readInt() == 1;
        return a2egSU;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new LinearLayoutManager.A2egSU[i];
    }
}
