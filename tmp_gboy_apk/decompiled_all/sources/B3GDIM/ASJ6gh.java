package B3GDIM;

import ADYaiT.CtFAbx;
import NOd7IU.AlLFFp;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ASJ6gh implements Future {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final boolean f1032AzWtSf = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final Logger f1033B25kr6 = Logger.getLogger(ASJ6gh.class.getName());

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final AlLFFp f1034B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final Object f1035B3GDIM;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public volatile Object f1036AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public volatile A5SV6n f1037AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public volatile ARc23Z f1038AmA8tU;

    static {
        AlLFFp aMqCpz;
        try {
            aMqCpz = new ADYaiT(AtomicReferenceFieldUpdater.newUpdater(ARc23Z.class, Thread.class, "A2egSU"), AtomicReferenceFieldUpdater.newUpdater(ARc23Z.class, ARc23Z.class, "A4TApA"), AtomicReferenceFieldUpdater.newUpdater(ASJ6gh.class, ARc23Z.class, "AmA8tU"), AtomicReferenceFieldUpdater.newUpdater(ASJ6gh.class, A5SV6n.class, "AlLFFp"), AtomicReferenceFieldUpdater.newUpdater(ASJ6gh.class, Object.class, "AcNBzu"));
            th = null;
        } catch (Throwable th) {
            th = th;
            aMqCpz = new AMqCpz();
        }
        f1034B2KMhB = aMqCpz;
        if (th != null) {
            f1033B25kr6.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1035B3GDIM = new Object();
    }

    public static void A4TApA(ASJ6gh aSJ6gh) {
        ARc23Z aRc23Z;
        A5SV6n a5SV6n;
        do {
            aRc23Z = aSJ6gh.f1038AmA8tU;
        } while (!f1034B2KMhB.BI9f7h(aSJ6gh, aRc23Z, ARc23Z.f1029A5SV6n));
        while (aRc23Z != null) {
            Thread thread = aRc23Z.f1030A2egSU;
            if (thread != null) {
                aRc23Z.f1030A2egSU = null;
                LockSupport.unpark(thread);
            }
            aRc23Z = aRc23Z.f1031A4TApA;
        }
        do {
            a5SV6n = aSJ6gh.f1037AlLFFp;
        } while (!f1034B2KMhB.B9tovu(aSJ6gh, a5SV6n));
        A5SV6n a5SV6n2 = null;
        while (a5SV6n != null) {
            A5SV6n a5SV6n3 = a5SV6n.f1023A2egSU;
            a5SV6n.f1023A2egSU = a5SV6n2;
            a5SV6n2 = a5SV6n;
            a5SV6n = a5SV6n3;
        }
        while (a5SV6n2 != null) {
            a5SV6n2 = a5SV6n2.f1023A2egSU;
            try {
                throw null;
            } catch (RuntimeException e) {
                f1033B25kr6.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e);
            }
        }
    }

    public static Object A5SV6n(Object obj) {
        if (obj instanceof A2egSU) {
            CancellationException cancellationException = ((A2egSU) obj).f1021A2egSU;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof A4TApA) {
            ((A4TApA) obj).getClass();
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f1035B3GDIM) {
            return null;
        }
        return obj;
    }

    public static Object ADYaiT(ASJ6gh aSJ6gh) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = aSJ6gh.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void A2egSU(StringBuilder sb) {
        try {
            Object ADYaiT2 = ADYaiT(this);
            sb.append("SUCCESS, result=[");
            sb.append(ADYaiT2 == this ? "this future" : String.valueOf(ADYaiT2));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    public final void AMqCpz(ARc23Z aRc23Z) {
        aRc23Z.f1030A2egSU = null;
        while (true) {
            ARc23Z aRc23Z2 = this.f1038AmA8tU;
            if (aRc23Z2 == ARc23Z.f1029A5SV6n) {
                return;
            }
            ARc23Z aRc23Z3 = null;
            while (aRc23Z2 != null) {
                ARc23Z aRc23Z4 = aRc23Z2.f1031A4TApA;
                if (aRc23Z2.f1030A2egSU != null) {
                    aRc23Z3 = aRc23Z2;
                } else if (aRc23Z3 != null) {
                    aRc23Z3.f1031A4TApA = aRc23Z4;
                    if (aRc23Z3.f1030A2egSU == null) {
                        break;
                    }
                } else if (!f1034B2KMhB.BI9f7h(this, aRc23Z2, aRc23Z4)) {
                    break;
                }
                aRc23Z2 = aRc23Z4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f1036AcNBzu;
        if (obj != null) {
            return false;
        }
        if (!f1034B2KMhB.BChYOn(this, obj, f1032AzWtSf ? new A2egSU(z, new CancellationException("Future.cancel() was called.")) : z ? A2egSU.f1019A4TApA : A2egSU.f1020A5SV6n)) {
            return false;
        }
        A4TApA(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1036AcNBzu;
        if (obj != null) {
            return A5SV6n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            ARc23Z aRc23Z = this.f1038AmA8tU;
            ARc23Z aRc23Z2 = ARc23Z.f1029A5SV6n;
            if (aRc23Z != aRc23Z2) {
                ARc23Z aRc23Z3 = new ARc23Z();
                do {
                    AlLFFp alLFFp = f1034B2KMhB;
                    alLFFp.CqNSpT(aRc23Z3, aRc23Z);
                    if (alLFFp.BI9f7h(this, aRc23Z, aRc23Z3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                AMqCpz(aRc23Z3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1036AcNBzu;
                            if (obj2 != null) {
                                return A5SV6n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        AMqCpz(aRc23Z3);
                    } else {
                        aRc23Z = this.f1038AmA8tU;
                    }
                } while (aRc23Z != aRc23Z2);
            }
            return A5SV6n(this.f1036AcNBzu);
        }
        while (nanos > 0) {
            Object obj3 = this.f1036AcNBzu;
            if (obj3 != null) {
                return A5SV6n(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aSJ6gh = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("Waited ", j, " ");
        B2KMhB2.append(timeUnit.toString().toLowerCase(locale));
        String sb = B2KMhB2.toString();
        if (nanos + 1000 < 0) {
            String AcNBzu2 = CtFAbx.AcNBzu(sb, " (plus ");
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str = AcNBzu2 + convert + " " + lowerCase;
                if (z) {
                    str = CtFAbx.AcNBzu(str, ",");
                }
                AcNBzu2 = CtFAbx.AcNBzu(str, " ");
            }
            if (z) {
                AcNBzu2 = AcNBzu2 + nanos2 + " nanoseconds ";
            }
            sb = CtFAbx.AcNBzu(AcNBzu2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(CtFAbx.AcNBzu(sb, " but future completed as timeout expired"));
        }
        throw new TimeoutException(CtFAbx.AlLFFp(sb, " for ", aSJ6gh));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1036AcNBzu instanceof A2egSU;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f1036AcNBzu != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f1036AcNBzu instanceof A2egSU) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            A2egSU(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                A2egSU(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1036AcNBzu;
            if (obj2 != null) {
                return A5SV6n(obj2);
            }
            ARc23Z aRc23Z = this.f1038AmA8tU;
            ARc23Z aRc23Z2 = ARc23Z.f1029A5SV6n;
            if (aRc23Z != aRc23Z2) {
                ARc23Z aRc23Z3 = new ARc23Z();
                do {
                    AlLFFp alLFFp = f1034B2KMhB;
                    alLFFp.CqNSpT(aRc23Z3, aRc23Z);
                    if (alLFFp.BI9f7h(this, aRc23Z, aRc23Z3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1036AcNBzu;
                            } else {
                                AMqCpz(aRc23Z3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return A5SV6n(obj);
                    }
                    aRc23Z = this.f1038AmA8tU;
                } while (aRc23Z != aRc23Z2);
            }
            return A5SV6n(this.f1036AcNBzu);
        }
        throw new InterruptedException();
    }
}
