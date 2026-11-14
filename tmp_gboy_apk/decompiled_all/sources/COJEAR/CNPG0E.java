package COJEAR;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CNPG0E implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f1660AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Iterator f1661AlLFFp;

    public CNPG0E(DaOi9o daOi9o) {
        this.f1661AlLFFp = daOi9o;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1661AlLFFp.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.f1661AlLFFp.next();
        View view = (View) next;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        DaOi9o daOi9o = viewGroup != null ? new DaOi9o(0, viewGroup) : null;
        ArrayList arrayList = this.f1660AcNBzu;
        if (daOi9o != null && daOi9o.hasNext()) {
            arrayList.add(this.f1661AlLFFp);
            this.f1661AlLFFp = daOi9o;
            return next;
        }
        while (!this.f1661AlLFFp.hasNext() && !arrayList.isEmpty()) {
            this.f1661AlLFFp = (Iterator) RD2OKB.B4ZgIw.AcNBzu(arrayList);
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            arrayList.remove(RD2OKB.AaHO0E.ADYaiT(arrayList));
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
