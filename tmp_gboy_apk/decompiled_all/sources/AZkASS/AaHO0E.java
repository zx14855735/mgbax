package AZkASS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends BaseAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AmA8tU f487A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f488A4TApA = -1;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f489A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f490ADYaiT;
    public final LayoutInflater AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f491ARc23Z;

    public AaHO0E(AmA8tU amA8tU, LayoutInflater layoutInflater, boolean z, int i) {
        this.f490ADYaiT = z;
        this.AMqCpz = layoutInflater;
        this.f487A2egSU = amA8tU;
        this.f491ARc23Z = i;
        A2egSU();
    }

    public final void A2egSU() {
        AmA8tU amA8tU = this.f487A2egSU;
        B25kr6 b25kr6 = amA8tU.f514C4FrIb;
        if (b25kr6 != null) {
            amA8tU.AZOQYO();
            ArrayList arrayList = amA8tU.f502B9tovu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((B25kr6) arrayList.get(i)) == b25kr6) {
                    this.f488A4TApA = i;
                    return;
                }
            }
        }
        this.f488A4TApA = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: A4TApA, reason: merged with bridge method [inline-methods] */
    public final B25kr6 getItem(int i) {
        ArrayList AcNBzu2;
        AmA8tU amA8tU = this.f487A2egSU;
        if (this.f490ADYaiT) {
            amA8tU.AZOQYO();
            AcNBzu2 = amA8tU.f502B9tovu;
        } else {
            AcNBzu2 = amA8tU.AcNBzu();
        }
        int i2 = this.f488A4TApA;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (B25kr6) AcNBzu2.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList AcNBzu2;
        AmA8tU amA8tU = this.f487A2egSU;
        if (this.f490ADYaiT) {
            amA8tU.AZOQYO();
            AcNBzu2 = amA8tU.f502B9tovu;
        } else {
            AcNBzu2 = amA8tU.AcNBzu();
        }
        return this.f488A4TApA < 0 ? AcNBzu2.size() : AcNBzu2.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.AMqCpz.inflate(this.f491ARc23Z, viewGroup, false);
        }
        int i2 = getItem(i).f521AlLFFp;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).f521AlLFFp : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f487A2egSU.AlLFFp() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        BPw6Q8 bPw6Q8 = (BPw6Q8) view;
        if (this.f489A5SV6n) {
            listMenuItemView.setForceShowIcon(true);
        }
        bPw6Q8.A2egSU(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        A2egSU();
        super.notifyDataSetChanged();
    }
}
