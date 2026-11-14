package FdMWEC;

import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ARc23Z implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2800A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f2801A4TApA;

    public /* synthetic */ ARc23Z(int i, Object obj) {
        this.f2800A2egSU = i;
        this.f2801A4TApA = obj;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        HFjH17.ADYaiT aDYaiT;
        Object obj = this.f2801A4TApA;
        int i = 0;
        switch (this.f2800A2egSU) {
            case 0:
                AZkASS aZkASS = (AZkASS) obj;
                aZkASS.getClass();
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                if (z) {
                    if (B4ZgIw.AYUAbz.A2egSU(aZkASS.f2865IQ76hF, 6)) {
                        aZkASS.f2865IQ76hF = 5;
                    }
                    if (aZkASS.f2838GhvxjZ) {
                        aZkASS.f2838GhvxjZ = false;
                        aZkASS.Dphsd2(1, null);
                        aZkASS.DdagTj();
                    }
                    aZkASS.f3195B25kr6 = false;
                    Fyurov.ASJ6gh aSJ6gh = aZkASS.f2821FZu94u;
                    if (aSJ6gh != null) {
                        aSJ6gh.AMqCpz();
                    }
                    if (!aZkASS.f2855HieBYM) {
                        int i3 = aZkASS.HHoABE;
                        if (i3 == 0) {
                            HFjH17.ADYaiT aDYaiT2 = aZkASS.f2841H0qugq;
                            if (aDYaiT2 != null) {
                                float f = aZkASS.f2860I3bnmY;
                                if (f != -1.0f) {
                                    MediaPlayer mediaPlayer = aDYaiT2.f3305B4ZgIw;
                                    if (mediaPlayer != null) {
                                        try {
                                            mediaPlayer.setVolume(f, f);
                                            aDYaiT2.f3310BIYEnU = f;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    aZkASS.f2860I3bnmY = -1.0f;
                                    break;
                                }
                            }
                        } else if (i3 == 1) {
                            aZkASS.DcUJf1();
                            break;
                        }
                    } else if (aZkASS.HHoABE == 1 && (aDYaiT = aZkASS.f2841H0qugq) != null) {
                        aDYaiT.AmA8tU();
                        GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.postDelayed(new ASJ6gh(aZkASS, i), 20L);
                        break;
                    }
                } else {
                    aZkASS.f2865IQ76hF = 6;
                    aZkASS.f3195B25kr6 = true;
                    Fyurov.ASJ6gh aSJ6gh2 = aZkASS.f2821FZu94u;
                    if (aSJ6gh2 != null) {
                        aSJ6gh2.A2egSU();
                    }
                    if (!aZkASS.f2855HieBYM) {
                        int i4 = aZkASS.HHoABE;
                        if (i4 == 0) {
                            HFjH17.ADYaiT aDYaiT3 = aZkASS.f2841H0qugq;
                            if (aDYaiT3 != null) {
                                MediaPlayer mediaPlayer2 = aDYaiT3.f3305B4ZgIw;
                                aZkASS.f2860I3bnmY = mediaPlayer2 != null ? aDYaiT3.f3310BIYEnU : -1.0f;
                                if (mediaPlayer2 != null) {
                                    try {
                                        mediaPlayer2.setVolume(0.0f, 0.0f);
                                        aDYaiT3.f3310BIYEnU = 0.0f;
                                        break;
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                }
                            }
                        } else if (i4 == 1) {
                            aZkASS.DaOi9o();
                            break;
                        } else if (i4 == 2) {
                            aZkASS.f2838GhvxjZ = true;
                            aZkASS.f2857HtmBAy.ADYaiT();
                            break;
                        }
                    } else if (aZkASS.HHoABE != 0) {
                        aZkASS.DaOi9o();
                        break;
                    }
                }
                break;
            default:
                HFjH17.ADYaiT aDYaiT4 = (HFjH17.ADYaiT) obj;
                if (!z) {
                    aDYaiT4.getClass();
                    break;
                } else {
                    View view = aDYaiT4.f3301AzWtSf;
                    int width = view.getWidth();
                    int[] iArr = aDYaiT4.f3308BChYOn;
                    iArr[0] = width;
                    iArr[1] = view.getHeight();
                    int[] iArr2 = aDYaiT4.f3307B9tovu;
                    int i5 = iArr2[0];
                    int i6 = iArr2[1];
                    int i7 = iArr[0];
                    int i8 = GJee0v.AZOQYO.f3039AcNBzu;
                    if (!aDYaiT4.f3299AlLFFp && HFjH17.ADYaiT.ARc23Z(iArr) && HFjH17.ADYaiT.ARc23Z(iArr2)) {
                        aDYaiT4.ASJ6gh();
                        break;
                    }
                }
                break;
        }
    }
}
