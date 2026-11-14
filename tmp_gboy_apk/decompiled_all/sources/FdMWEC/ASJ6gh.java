package FdMWEC;

import ADYaiT.D8MqeW;
import com.alliance.ssp.ad.bean.SAAllianceAdData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2802AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2803AlLFFp;

    public /* synthetic */ ASJ6gh(AZkASS aZkASS, int i) {
        this.f2802AcNBzu = i;
        this.f2803AlLFFp = aZkASS;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2802AcNBzu) {
            case 0:
                HFjH17.ADYaiT aDYaiT = this.f2803AlLFFp.f2841H0qugq;
                if (aDYaiT != null) {
                    aDYaiT.AcNBzu();
                    break;
                }
                break;
            case 1:
                AZkASS aZkASS = this.f2803AlLFFp;
                Fyurov.ASJ6gh aSJ6gh = aZkASS.f2821FZu94u;
                if (aSJ6gh != null && aZkASS.f2847HIguqb == 1) {
                    aSJ6gh.A4TApA(aZkASS.f2825FmyuN2.getAccelerationDefault(), aZkASS.f2825FmyuN2.getRotationAngleDefault(), aZkASS.f2825FmyuN2.getOperationTimeDefault(), aZkASS.f2825FmyuN2.getDirection());
                    SAAllianceAdData sAAllianceAdData = aZkASS.f3187AYUAbz;
                    if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null && aZkASS.f3187AYUAbz.getInteraction().getShake() != null) {
                        aZkASS.f3187AYUAbz.getInteraction().getShake().setAcceleration(aZkASS.f2825FmyuN2.getAccelerationDefault());
                        aZkASS.f3187AYUAbz.getInteraction().getShake().setRotationAngle(aZkASS.f2825FmyuN2.getRotationAngleDefault());
                        aZkASS.f3187AYUAbz.getInteraction().getShake().setOperationTime(aZkASS.f2825FmyuN2.getOperationTimeDefault());
                        break;
                    }
                }
                break;
            case 2:
                try {
                    this.f2803AlLFFp.f2853HZUvgL.runOnUiThread(new D8MqeW(16, this));
                    break;
                } catch (Exception unused) {
                    return;
                }
            default:
                try {
                    this.f2803AlLFFp.f2853HZUvgL.runOnUiThread(new D8MqeW(17, this));
                    break;
                } catch (Exception unused2) {
                    return;
                }
        }
    }
}
