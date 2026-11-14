package AZkASS;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends BaseAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f479A2egSU = -1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AZkASS f480A4TApA;

    public AZOQYO(AZkASS aZkASS) {
        this.f480A4TApA = aZkASS;
        A2egSU();
    }

    public final void A2egSU() {
        AmA8tU amA8tU = this.f480A4TApA.f483AmA8tU;
        B25kr6 b25kr6 = amA8tU.f514C4FrIb;
        if (b25kr6 != null) {
            amA8tU.AZOQYO();
            ArrayList arrayList = amA8tU.f502B9tovu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((B25kr6) arrayList.get(i)) == b25kr6) {
                    this.f479A2egSU = i;
                    return;
                }
            }
        }
        this.f479A2egSU = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: A4TApA, reason: merged with bridge method [inline-methods] */
    public final B25kr6 getItem(int i) {
        AZkASS aZkASS = this.f480A4TApA;
        AmA8tU amA8tU = aZkASS.f483AmA8tU;
        amA8tU.AZOQYO();
        ArrayList arrayList = amA8tU.f502B9tovu;
        aZkASS.getClass();
        int i2 = this.f479A2egSU;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (B25kr6) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        AZkASS aZkASS = this.f480A4TApA;
        AmA8tU amA8tU = aZkASS.f483AmA8tU;
        amA8tU.AZOQYO();
        int size = amA8tU.f502B9tovu.size();
        aZkASS.getClass();
        return this.f479A2egSU < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f480A4TApA.f482AlLFFp.inflate(2131492882, viewGroup, false);
        }
        ((BPw6Q8) view).A2egSU(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        A2egSU();
        super.notifyDataSetChanged();
    }
}
