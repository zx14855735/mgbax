package LHpdLt;

import android.util.Base64;
import android.view.View;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import com.google.gson.Gson;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4521AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BTvldC f4522AlLFFp;

    public /* synthetic */ B3GDIM(BTvldC bTvldC, int i) {
        this.f4521AcNBzu = i;
        this.f4522AlLFFp = bTvldC;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Link link;
        Console console;
        String str;
        int i = 1;
        switch (this.f4521AcNBzu) {
            case 0:
                BTvldC bTvldC = this.f4522AlLFFp;
                bTvldC.f4583BIYEnU.setVisibility(8);
                bTvldC.f4584BJ7GGh.setVisibility(0);
                break;
            case 1:
                BTvldC bTvldC2 = this.f4522AlLFFp;
                if (!bTvldC2.AMqCpz) {
                    LLYwnm.AYUAbz aYUAbz = bTvldC2.f4598CTkVKb;
                    if (aYUAbz == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
                        MyApp.A2egSU("未连接服务器");
                        break;
                    } else {
                        EmulatorActivity emulatorActivity = bTvldC2.f4576B2KMhB;
                        if (emulatorActivity == null || (link = emulatorActivity.f11004BPw6Q8) == null || (console = link.f11100A2egSU) == null) {
                            MyApp.A2egSU("模拟器未就绪");
                            break;
                        } else {
                            try {
                                String str2 = "";
                                if (bTvldC2.f4578B4ZgIw) {
                                    str = "";
                                } else {
                                    byte[] saveStateToMemory = console.saveStateToMemory();
                                    Gson gson = L2suez.AYUAbz.f4368A2egSU;
                                    str = saveStateToMemory == null ? null : Base64.encodeToString(saveStateToMemory, 2);
                                }
                                LLYwnm.AYUAbz aYUAbz2 = bTvldC2.f4598CTkVKb;
                                AlLFFp alLFFp = new AlLFFp(i, bTvldC2);
                                aYUAbz2.getClass();
                                HashMap hashMap = new HashMap();
                                hashMap.put("action", PointCategory.READY);
                                if (str != null) {
                                    str2 = str;
                                }
                                hashMap.put("base", str2);
                                aYUAbz2.ARc23Z(hashMap, PointCategory.READY, alLFFp);
                                break;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                    }
                }
                break;
            default:
                BTvldC bTvldC3 = this.f4522AlLFFp;
                bTvldC3.AYUAbz(true);
                EmulatorActivity emulatorActivity2 = bTvldC3.f4576B2KMhB;
                if (emulatorActivity2 != null) {
                    emulatorActivity2.C2rE4F();
                    break;
                }
                break;
        }
    }
}
