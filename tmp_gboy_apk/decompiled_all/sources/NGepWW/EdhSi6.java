package NGepWW;

import AaHO0E.HHoABE;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EdhSi6 implements DV2E8K, NSK3xo.AZkASS, NSK3xo.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final EicXu4 f5821A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final NSK3xo.ARc23Z f5823A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final DXuj49 f5824ADYaiT;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f5826ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final A5SV6n f5827AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f5828AZOQYO;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final LinkedList f5822A4TApA = new LinkedList();
    public final HashSet AMqCpz = new HashSet();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final HashMap f5825ARc23Z = new HashMap();

    /* renamed from: AZkASS, reason: collision with root package name */
    public NOd7IU.A2egSU f5829AZkASS = null;

    public EdhSi6(EicXu4 eicXu4, B7CMnp b7CMnp) {
        this.f5821A2egSU = eicXu4;
        eicXu4.f5844B3GDIM.getLooper();
        b7CMnp.getClass();
        throw null;
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        Looper myLooper = Looper.myLooper();
        EicXu4 eicXu4 = this.f5821A2egSU;
        if (myLooper == eicXu4.f5844B3GDIM.getLooper()) {
            ASJ6gh();
        } else {
            eicXu4.f5844B3GDIM.post(new EdQ5bb(this, 0));
        }
    }

    @Override // NSK3xo.AaHO0E
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        NUY5pn.AYUAbz.A2egSU(this.f5821A2egSU.f5844B3GDIM);
        A5SV6n a5SV6n = this.f5827AYUAbz;
        if (a5SV6n != null) {
            a5SV6n.f5676ARc23Z.AYUAbz();
        }
        NUY5pn.AYUAbz.A2egSU(this.f5821A2egSU.f5844B3GDIM);
        this.f5829AZkASS = null;
        this.f5821A2egSU.f5840AmA8tU = -1;
        AMqCpz(a2egSU);
        if (a2egSU.f5854AlLFFp == 4) {
            A5SV6n(EicXu4.f5835B7CMnp);
            return;
        }
        if (this.f5822A4TApA.isEmpty()) {
            this.f5829AZkASS = a2egSU;
            return;
        }
        synchronized (EicXu4.f5836B9tovu) {
            this.f5821A2egSU.getClass();
        }
        if (this.f5821A2egSU.A4TApA(a2egSU, this.f5826ASJ6gh)) {
            return;
        }
        if (a2egSU.f5854AlLFFp == 18) {
            this.f5828AZOQYO = true;
        }
        if (!this.f5828AZOQYO) {
            throw null;
        }
        Handler handler = this.f5821A2egSU.f5844B3GDIM;
        Message obtain = Message.obtain(handler, 7, null);
        this.f5821A2egSU.getClass();
        handler.sendMessageDelayed(obtain, PushUIConfig.dismissTime);
    }

    public final void A5SV6n(NSK3xo.A4TApA a4TApA) {
        NUY5pn.AYUAbz.A2egSU(this.f5821A2egSU.f5844B3GDIM);
        LinkedList linkedList = this.f5822A4TApA;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((D8MqeW) it.next()).ADYaiT(a4TApA);
        }
        linkedList.clear();
    }

    @Override // NGepWW.DV2E8K
    public final void ADYaiT(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz) {
        Looper myLooper = Looper.myLooper();
        EicXu4 eicXu4 = this.f5821A2egSU;
        if (myLooper == eicXu4.f5844B3GDIM.getLooper()) {
            A4TApA(a2egSU);
        } else {
            eicXu4.f5844B3GDIM.post(new MOpbMP.A2egSU(this, 15, a2egSU));
        }
    }

    public final void AMqCpz(NOd7IU.A2egSU a2egSU) {
        HashSet hashSet = this.AMqCpz;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((D9tr6l) it.next()).A2egSU(null, a2egSU);
        }
        hashSet.clear();
    }

    public final void ARc23Z() {
        EicXu4 eicXu4 = this.f5821A2egSU;
        NUY5pn.AYUAbz.A2egSU(eicXu4.f5844B3GDIM);
        NSK3xo.ARc23Z aRc23Z = this.f5823A5SV6n;
        NUY5pn.BJ7GGh bJ7GGh = (NUY5pn.BJ7GGh) aRc23Z;
        if (bJ7GGh.AZOQYO() || bJ7GGh.AZkASS()) {
            return;
        }
        aRc23Z.getClass();
        if (eicXu4.f5840AmA8tU != 0) {
            int A2egSU2 = eicXu4.f5839AlLFFp.A2egSU(eicXu4.f5838AcNBzu);
            eicXu4.f5840AmA8tU = A2egSU2;
            if (A2egSU2 != 0) {
                A4TApA(new NOd7IU.A2egSU(eicXu4.f5840AmA8tU, null));
                return;
            }
        }
        EiK8oA eiK8oA = new EiK8oA(eicXu4, aRc23Z, null);
        if (aRc23Z.i()) {
            A5SV6n a5SV6n = this.f5827AYUAbz;
            BpkvW3 bpkvW3 = a5SV6n.f5676ARc23Z;
            if (bpkvW3 != null) {
                bpkvW3.AYUAbz();
            }
            Looper looper = a5SV6n.f5673A4TApA.getLooper();
            HHoABE hHoABE = a5SV6n.AMqCpz;
            BpkvW3 bpkvW32 = (BpkvW3) a5SV6n.f5674A5SV6n.A4TApA(a5SV6n.f5672A2egSU, looper, hHoABE, (BI9f7h) hHoABE.f930ARc23Z, a5SV6n, a5SV6n);
            a5SV6n.f5676ARc23Z = bpkvW32;
            a5SV6n.f5677ASJ6gh = eiK8oA;
            bpkvW32.f5985A4TApA = new NUY5pn.B2KMhB(bpkvW32);
            bpkvW32.A4TApA(2, null);
        }
        NUY5pn.BJ7GGh bJ7GGh2 = (NUY5pn.BJ7GGh) aRc23Z;
        bJ7GGh2.f5985A4TApA = eiK8oA;
        bJ7GGh2.A4TApA(2, null);
    }

    public final void ASJ6gh() {
        NSK3xo.ARc23Z aRc23Z;
        EicXu4 eicXu4 = this.f5821A2egSU;
        NUY5pn.AYUAbz.A2egSU(eicXu4.f5844B3GDIM);
        this.f5829AZkASS = null;
        AMqCpz(NOd7IU.A2egSU.f5852B25kr6);
        if (this.f5828AZOQYO) {
            eicXu4.f5844B3GDIM.removeMessages(9, null);
            eicXu4.f5844B3GDIM.removeMessages(7, null);
            this.f5828AZOQYO = false;
        }
        Iterator it = this.f5825ARc23Z.values().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            aRc23Z = this.f5823A5SV6n;
            if (!hasNext) {
                break;
            }
            it.next();
            try {
                new NIA37H.A4TApA();
            } catch (DeadObjectException unused) {
                a(1);
                ((NUY5pn.BJ7GGh) aRc23Z).AYUAbz();
            } catch (RemoteException unused2) {
            }
        }
        while (((NUY5pn.BJ7GGh) aRc23Z).AZOQYO()) {
            LinkedList linkedList = this.f5822A4TApA;
            if (linkedList.isEmpty()) {
                break;
            }
            D8MqeW d8MqeW = (D8MqeW) linkedList.remove();
            d8MqeW.A4TApA(this.f5824ADYaiT, aRc23Z.i());
            try {
                d8MqeW.A5SV6n(this);
            } catch (DeadObjectException unused3) {
                a(1);
                ((NUY5pn.BJ7GGh) aRc23Z).AYUAbz();
            }
        }
        AZOQYO();
    }

    public final void AYUAbz() {
        EicXu4 eicXu4 = this.f5821A2egSU;
        NUY5pn.AYUAbz.A2egSU(eicXu4.f5844B3GDIM);
        this.f5829AZkASS = null;
        this.f5828AZOQYO = true;
        DXuj49 dXuj49 = this.f5824ADYaiT;
        dXuj49.getClass();
        dXuj49.A2egSU(true, ARc23Z.f5679A5SV6n);
        Handler handler = eicXu4.f5844B3GDIM;
        Message obtain = Message.obtain(handler, 7, null);
        NSK3xo.A4TApA a4TApA = EicXu4.f5834B4ZgIw;
        handler.sendMessageDelayed(obtain, PushUIConfig.dismissTime);
        Handler handler2 = eicXu4.f5844B3GDIM;
        handler2.sendMessageDelayed(Message.obtain(handler2, 9, null), 120000L);
        eicXu4.f5840AmA8tU = -1;
    }

    public final void AZOQYO() {
        EicXu4 eicXu4 = this.f5821A2egSU;
        eicXu4.f5844B3GDIM.removeMessages(10, null);
        Handler handler = eicXu4.f5844B3GDIM;
        handler.sendMessageDelayed(handler.obtainMessage(10, null), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
        Looper myLooper = Looper.myLooper();
        EicXu4 eicXu4 = this.f5821A2egSU;
        if (myLooper == eicXu4.f5844B3GDIM.getLooper()) {
            AYUAbz();
        } else {
            eicXu4.f5844B3GDIM.post(new EdQ5bb(this, 1));
        }
    }
}
