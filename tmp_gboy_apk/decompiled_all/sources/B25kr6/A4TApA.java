package B25kr6;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements Iterator, Map.Entry {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f973AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f974AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f975AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f976AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Object f977B25kr6;

    public A4TApA(QkAq4X.A2egSU a2egSU) {
        this.f973AcNBzu = 1;
        this.f977B25kr6 = a2egSU;
        this.f976AzWtSf = false;
        this.f974AlLFFp = a2egSU.A2egSU() - 1;
        this.f975AmA8tU = -1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        switch (this.f973AcNBzu) {
            case 0:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    int i = this.f975AmA8tU;
                    ADYaiT aDYaiT = (ADYaiT) this.f977B25kr6;
                    if (RXb0Sz.ARc23Z.A2egSU(key, aDYaiT.ARc23Z(i)) && RXb0Sz.ARc23Z.A2egSU(entry.getValue(), aDYaiT.AZkASS(this.f975AmA8tU))) {
                        return true;
                    }
                }
                return false;
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry2 = (Map.Entry) obj;
                Object key2 = entry2.getKey();
                int i2 = this.f975AmA8tU;
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f977B25kr6;
                Object A5SV6n2 = a2egSU.A5SV6n(i2, 0);
                if (key2 != A5SV6n2 && (key2 == null || !key2.equals(A5SV6n2))) {
                    return false;
                }
                Object value = entry2.getValue();
                Object A5SV6n3 = a2egSU.A5SV6n(this.f975AmA8tU, 1);
                return value == A5SV6n3 || (value != null && value.equals(A5SV6n3));
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.f973AcNBzu) {
            case 0:
                if (this.f976AzWtSf) {
                    return ((ADYaiT) this.f977B25kr6).ARc23Z(this.f975AmA8tU);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                return ((QkAq4X.A2egSU) this.f977B25kr6).A5SV6n(this.f975AmA8tU, 0);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        switch (this.f973AcNBzu) {
            case 0:
                if (this.f976AzWtSf) {
                    return ((ADYaiT) this.f977B25kr6).AZkASS(this.f975AmA8tU);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                return ((QkAq4X.A2egSU) this.f977B25kr6).A5SV6n(this.f975AmA8tU, 1);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f973AcNBzu) {
            case 0:
                if (this.f975AmA8tU < this.f974AlLFFp) {
                }
                break;
            default:
                if (this.f975AmA8tU < this.f974AlLFFp) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        switch (this.f973AcNBzu) {
            case 0:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                int i = this.f975AmA8tU;
                ADYaiT aDYaiT = (ADYaiT) this.f977B25kr6;
                Object ARc23Z2 = aDYaiT.ARc23Z(i);
                Object AZkASS2 = aDYaiT.AZkASS(this.f975AmA8tU);
                return (ARc23Z2 == null ? 0 : ARc23Z2.hashCode()) ^ (AZkASS2 != null ? AZkASS2.hashCode() : 0);
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                int i2 = this.f975AmA8tU;
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f977B25kr6;
                Object A5SV6n2 = a2egSU.A5SV6n(i2, 0);
                Object A5SV6n3 = a2egSU.A5SV6n(this.f975AmA8tU, 1);
                return (A5SV6n2 == null ? 0 : A5SV6n2.hashCode()) ^ (A5SV6n3 != null ? A5SV6n3.hashCode() : 0);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f973AcNBzu) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f975AmA8tU++;
                this.f976AzWtSf = true;
                return this;
            default:
                this.f975AmA8tU++;
                this.f976AzWtSf = true;
                return this;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f973AcNBzu) {
            case 0:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException();
                }
                ((ADYaiT) this.f977B25kr6).AYUAbz(this.f975AmA8tU);
                this.f975AmA8tU--;
                this.f974AlLFFp--;
                this.f976AzWtSf = false;
                return;
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException();
                }
                ((QkAq4X.A2egSU) this.f977B25kr6).ADYaiT(this.f975AmA8tU);
                this.f975AmA8tU--;
                this.f974AlLFFp--;
                this.f976AzWtSf = false;
                return;
        }
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        switch (this.f973AcNBzu) {
            case 0:
                if (this.f976AzWtSf) {
                    return ((ADYaiT) this.f977B25kr6).AZOQYO(this.f975AmA8tU, obj);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            default:
                if (!this.f976AzWtSf) {
                    throw new IllegalStateException("This container does not support retaining Map.Entry objects");
                }
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f977B25kr6;
                int i = this.f975AmA8tU;
                switch (a2egSU.f7723ADYaiT) {
                    case 0:
                        int i2 = (i << 1) + 1;
                        Object[] objArr = ((QkAq4X.A4TApA) a2egSU.AMqCpz).f7751AlLFFp;
                        Object obj2 = objArr[i2];
                        objArr[i2] = obj;
                        return obj2;
                    default:
                        throw new UnsupportedOperationException("not a map");
                }
        }
    }

    public final String toString() {
        switch (this.f973AcNBzu) {
            case 0:
                return getKey() + "=" + getValue();
            default:
                return getKey() + "=" + getValue();
        }
    }

    public A4TApA(ADYaiT aDYaiT) {
        this.f973AcNBzu = 0;
        this.f977B25kr6 = aDYaiT;
        this.f974AlLFFp = aDYaiT.f1011AmA8tU - 1;
        this.f975AmA8tU = -1;
    }
}
