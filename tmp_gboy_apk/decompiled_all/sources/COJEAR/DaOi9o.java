package COJEAR;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DaOi9o implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1687AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1688AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f1689AmA8tU;

    public /* synthetic */ DaOi9o(int i, Object obj) {
        this.f1687AcNBzu = i;
        this.f1689AmA8tU = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1687AcNBzu) {
            case 0:
                if (this.f1688AlLFFp < ((ViewGroup) this.f1689AmA8tU).getChildCount()) {
                }
                break;
            case 1:
                if (this.f1688AlLFFp < ((RD2OKB.A5SV6n) this.f1689AmA8tU).A2egSU()) {
                }
                break;
            default:
                if (this.f1688AlLFFp < ((Object[]) this.f1689AmA8tU).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1687AcNBzu) {
            case 0:
                int i = this.f1688AlLFFp;
                this.f1688AlLFFp = i + 1;
                View childAt = ((ViewGroup) this.f1689AmA8tU).getChildAt(i);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            case 1:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i2 = this.f1688AlLFFp;
                this.f1688AlLFFp = i2 + 1;
                return ((RD2OKB.A5SV6n) this.f1689AmA8tU).get(i2);
            default:
                try {
                    Object[] objArr = (Object[]) this.f1689AmA8tU;
                    int i3 = this.f1688AlLFFp;
                    this.f1688AlLFFp = i3 + 1;
                    return objArr[i3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f1688AlLFFp--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1687AcNBzu) {
            case 0:
                int i = this.f1688AlLFFp - 1;
                this.f1688AlLFFp = i;
                ((ViewGroup) this.f1689AmA8tU).removeViewAt(i);
                return;
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
