package okhttp3.internal.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.internal.cache.AMqCpz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ASJ6gh implements Iterator {
    final Iterator<AMqCpz.A5SV6n> delegate;
    AMqCpz.ADYaiT nextSnapshot;
    AMqCpz.ADYaiT removeSnapshot;
    final /* synthetic */ AMqCpz this$0;

    public ASJ6gh(AMqCpz aMqCpz) {
        this.this$0 = aMqCpz;
        this.delegate = new ArrayList(aMqCpz.lruEntries.values()).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextSnapshot != null) {
            return true;
        }
        synchronized (this.this$0) {
            try {
                if (this.this$0.closed) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    AMqCpz.ADYaiT A2egSU2 = this.delegate.next().A2egSU();
                    if (A2egSU2 != null) {
                        this.nextSnapshot = A2egSU2;
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AMqCpz.ADYaiT aDYaiT = this.nextSnapshot;
        this.removeSnapshot = aDYaiT;
        this.nextSnapshot = null;
        return aDYaiT;
    }

    @Override // java.util.Iterator
    public final void remove() {
        String str;
        AMqCpz.ADYaiT aDYaiT = this.removeSnapshot;
        if (aDYaiT == null) {
            throw new IllegalStateException("remove() before next()");
        }
        try {
            AMqCpz aMqCpz = this.this$0;
            str = aDYaiT.key;
            aMqCpz.AzWtSf(str);
        } catch (IOException unused) {
        } finally {
            this.removeSnapshot = null;
        }
    }
}
