package RD2OKB;

import COJEAR.DaOi9o;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU extends DaOi9o implements ListIterator {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f7835AzWtSf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2egSU(A5SV6n a5SV6n, int i) {
        super(1, a5SV6n);
        this.f7835AzWtSf = a5SV6n;
        int A2egSU2 = a5SV6n.A2egSU();
        if (i < 0 || i > A2egSU2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, A2egSU2, "index: ", ", size: "));
        }
        this.f1688AlLFFp = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1688AlLFFp > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1688AlLFFp;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f1688AlLFFp - 1;
        this.f1688AlLFFp = i;
        return this.f7835AzWtSf.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1688AlLFFp - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
