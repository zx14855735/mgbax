package BChYOn;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AlLFFp extends AaHO0E {

    /* renamed from: DyaChj, reason: collision with root package name */
    public int f1265DyaChj = 0;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public int f1266ECyGFg = 0;

    /* renamed from: EGM26s, reason: collision with root package name */
    public int f1267EGM26s = 0;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public int f1268EH1KK8 = 0;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public int f1269EPdU4G = 0;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f1270EQurEW = 0;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public boolean f1271EUIRHA = false;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public int f1272EY4UKY = 0;
    public int EdQ5bb = 0;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public final BI9f7h.A4TApA f1273EdhSi6 = new BI9f7h.A4TApA();

    /* renamed from: EiK8oA, reason: collision with root package name */
    public BJ7GGh.AMqCpz f1274EiK8oA = null;

    @Override // BChYOn.AaHO0E
    public final void CmUvjW() {
        for (int i = 0; i < this.f1263DvK7DB; i++) {
            ARc23Z aRc23Z = this.f1262DuwtYk[i];
            if (aRc23Z != null) {
                aRc23Z.f1161C2rE4F = true;
            }
        }
    }

    public void CqNSpT(int i, int i2, int i3, int i4) {
    }

    public final void CrfGsy(ARc23Z aRc23Z, int i, int i2, int i3, int i4) {
        BJ7GGh.AMqCpz aMqCpz;
        ARc23Z aRc23Z2;
        while (true) {
            aMqCpz = this.f1274EiK8oA;
            if (aMqCpz != null || (aRc23Z2 = this.f1175CrfGsy) == null) {
                break;
            } else {
                this.f1274EiK8oA = ((ASJ6gh) aRc23Z2).f1199EGM26s;
            }
        }
        BI9f7h.A4TApA a4TApA = this.f1273EdhSi6;
        a4TApA.f1276A2egSU = i;
        a4TApA.f1277A4TApA = i3;
        a4TApA.f1278A5SV6n = i2;
        a4TApA.f1279ADYaiT = i4;
        aMqCpz.A4TApA(aRc23Z, a4TApA);
        aRc23Z.CcAIMM(a4TApA.AMqCpz);
        aRc23Z.CQhlFr(a4TApA.f1280ARc23Z);
        aRc23Z.BpkvW3 = a4TApA.f1282AYUAbz;
        aRc23Z.CASmeH(a4TApA.f1281ASJ6gh);
    }
}
