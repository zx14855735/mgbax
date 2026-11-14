package LHpdLt;

import android.widget.TextView;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf extends LLYwnm.AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4516A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f4517A4TApA;

    public /* synthetic */ AzWtSf(int i, Object obj) {
        this.f4516A2egSU = i;
        this.f4517A4TApA = obj;
    }

    private final void ARc23Z(Map map) {
    }

    @Override // LLYwnm.AzWtSf
    public void A2egSU(String str) {
        switch (this.f4516A2egSU) {
            case 2:
                WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f4517A4TApA;
                OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(emulatorActivity);
                ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                azoqyo.AMqCpz = "获取奖励";
                azoqyo.f28ASJ6gh = str;
                a4TApA.AzWtSf("前往", new com.game.boy.activity.B9tovu(emulatorActivity));
                a4TApA.AcNBzu("放弃", null);
                a4TApA.AMqCpz();
                break;
        }
    }

    @Override // LLYwnm.AzWtSf
    public void A4TApA(Map map) {
        switch (this.f4516A2egSU) {
            case 2:
                WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f4517A4TApA;
                emulatorActivity.AZOQYO("提示", "初始化联机中...", new com.game.boy.activity.B7CMnp(emulatorActivity, new Gson().toJson(map), 0)).show();
                break;
        }
    }

    @Override // LLYwnm.AzWtSf
    public final void A5SV6n(String str, boolean z) {
        switch (this.f4516A2egSU) {
            case 0:
                if (!((BTvldC) this.f4517A4TApA).AMqCpz && !z) {
                    ((BTvldC) this.f4517A4TApA).AYUAbz(false);
                    EmulatorActivity emulatorActivity = ((BTvldC) this.f4517A4TApA).f4576B2KMhB;
                    if (emulatorActivity != null) {
                        emulatorActivity.C2rE4F();
                        break;
                    }
                }
                break;
            case 1:
                if (!((Mi9UWv.ASJ6gh) this.f4517A4TApA).f5414BNL6CD) {
                    MyApp.A2egSU(str);
                    break;
                }
                break;
            default:
                BTvldC bTvldC = BTvldC.f4560CikNvS;
                if (bTvldC != null) {
                    bTvldC.AYUAbz(true);
                }
                ((EmulatorActivity) this.f4517A4TApA).BpkvW3 = null;
                if (!z) {
                    MyApp.A2egSU(str);
                    break;
                }
                break;
        }
    }

    @Override // LLYwnm.AzWtSf
    public final void ADYaiT(Map map) {
        Mi9UWv.ASJ6gh aSJ6gh;
        ADYaiT.AmA8tU amA8tU;
        Map map2;
        Object obj;
        Object obj2;
        switch (this.f4516A2egSU) {
            case 0:
                if (((BTvldC) this.f4517A4TApA).AMqCpz) {
                    return;
                }
                try {
                    Gson gson = ((BTvldC) this.f4517A4TApA).f4577B3GDIM;
                    BPw6Q8 bPw6Q8 = (BPw6Q8) gson.fromJson(gson.toJson(map), BPw6Q8.class);
                    if (bPw6Q8 != null && bPw6Q8.f4556A4TApA) {
                        List<BNL6CD> list = bPw6Q8.f4557A5SV6n;
                        if (list != null) {
                            ((BTvldC) this.f4517A4TApA).B3GDIM(list);
                        }
                        B7CMnp b7CMnp = bPw6Q8.f4558ADYaiT;
                        if (b7CMnp != null) {
                            ((BTvldC) this.f4517A4TApA).ARc23Z(b7CMnp);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 1:
                if (((Mi9UWv.ASJ6gh) this.f4517A4TApA).f5414BNL6CD || (amA8tU = (aSJ6gh = (Mi9UWv.ASJ6gh) this.f4517A4TApA).f5408B7CMnp) == null || !amA8tU.isShowing()) {
                    return;
                }
                aSJ6gh.f5408B7CMnp.dismiss();
                return;
            default:
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f4517A4TApA;
                WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                synchronized (emulatorActivity) {
                    try {
                        Mi9UWv.ASJ6gh aSJ6gh2 = emulatorActivity.f11032DAk1zC;
                        if (aSJ6gh2 != null) {
                            ADYaiT.AmA8tU amA8tU2 = aSJ6gh2.f5408B7CMnp;
                            if (amA8tU2 != null && amA8tU2.isShowing()) {
                                aSJ6gh2.f5408B7CMnp.dismiss();
                            }
                            emulatorActivity.f11032DAk1zC = null;
                        }
                        Object obj3 = map.get("invite");
                        if ((obj3 instanceof Map) && (obj = (map2 = (Map) obj3).get("enabled")) != null && Boolean.parseBoolean(String.valueOf(obj)) && (obj2 = map2.get("room_id")) != null) {
                            Mi9UWv.ASJ6gh.f5401BmvVmW = String.valueOf(obj2);
                        }
                        BTvldC AzWtSf2 = BTvldC.AzWtSf(emulatorActivity, emulatorActivity.f10998B9tovu);
                        emulatorActivity.BpkvW3 = AzWtSf2;
                        if (AzWtSf2 == null) {
                            return;
                        }
                        String str = Mi9UWv.ASJ6gh.f5401BmvVmW;
                        BTvldC bTvldC = emulatorActivity.BpkvW3;
                        bTvldC.f4576B2KMhB = emulatorActivity;
                        String str2 = "ID: " + str;
                        TextView textView = bTvldC.f4579B7CMnp;
                        if (textView != null) {
                            textView.setText(str2);
                        }
                        String json = new Gson().toJson(map);
                        BTvldC bTvldC2 = emulatorActivity.BpkvW3;
                        if (!bTvldC2.AMqCpz) {
                            try {
                                BPw6Q8 bPw6Q82 = (BPw6Q8) bTvldC2.f4577B3GDIM.fromJson(json, BPw6Q8.class);
                                if (bPw6Q82 != null && bPw6Q82.f4556A4TApA) {
                                    List<BNL6CD> list2 = bPw6Q82.f4557A5SV6n;
                                    if (list2 != null) {
                                        bTvldC2.B3GDIM(list2);
                                    }
                                    B7CMnp b7CMnp2 = bPw6Q82.f4558ADYaiT;
                                    if (b7CMnp2 != null) {
                                        bTvldC2.ARc23Z(b7CMnp2);
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    @Override // LLYwnm.AzWtSf
    public void AMqCpz(Map map) {
        switch (this.f4516A2egSU) {
            case 0:
                if (!((BTvldC) this.f4517A4TApA).AMqCpz) {
                    BTvldC bTvldC = (BTvldC) this.f4517A4TApA;
                    if (!bTvldC.AMqCpz && map != null) {
                        bTvldC.f4596CQhlFr.post(new C4FrIb.A2egSU(bTvldC, map, 17, false));
                        break;
                    }
                }
                break;
        }
    }
}
