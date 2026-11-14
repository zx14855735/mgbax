package LHpdLt;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.game.boy.MyApp;
import com.game.boy.activity.SaveSlotsActivity;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4534AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f4535AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f4536AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f4537AzWtSf;

    public /* synthetic */ B9tovu(int i, Object obj, Object obj2, Object obj3) {
        this.f4534AcNBzu = i;
        this.f4537AzWtSf = obj;
        this.f4535AlLFFp = obj2;
        this.f4536AmA8tU = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Integer num;
        Mt2q9w.ASJ6gh A2egSU2;
        Integer num2;
        Mt2q9w.ASJ6gh A2egSU3;
        switch (this.f4534AcNBzu) {
            case 0:
                AZkASS aZkASS = ((BIYEnU) this.f4537AzWtSf).f4547AzWtSf;
                if (aZkASS != null) {
                    BJ7GGh bJ7GGh = (BJ7GGh) this.f4535AlLFFp;
                    BTvldC bTvldC = aZkASS.f4508A4TApA;
                    boolean z = false;
                    if (!bTvldC.AMqCpz) {
                        String str2 = bJ7GGh.f4548A2egSU;
                        if (str2 == null || str2.isEmpty()) {
                            MyApp.A2egSU("玩家信息异常");
                        } else {
                            LLYwnm.AYUAbz aYUAbz = bTvldC.f4598CTkVKb;
                            if (aYUAbz == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
                                MyApp.A2egSU("未连接服务器");
                            } else {
                                try {
                                    LLYwnm.AYUAbz aYUAbz2 = bTvldC.f4598CTkVKb;
                                    String str3 = bJ7GGh.f4548A2egSU;
                                    AlLFFp alLFFp = new AlLFFp(0, bJ7GGh);
                                    aYUAbz2.getClass();
                                    if (str3 != null && !str3.isEmpty()) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("action", "invite_player");
                                        hashMap.put("target", str3);
                                        aYUAbz2.ARc23Z(hashMap, "invite_player", alLFFp);
                                        z = true;
                                    }
                                    aYUAbz2.A5SV6n(new JrXYwF.A2egSU(alLFFp, 5));
                                    z = true;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                    if (z && (str = bJ7GGh.f4550A5SV6n) != null) {
                        aZkASS.f4508A4TApA.f4595COJEAR.put(str, Long.valueOf(SystemClock.uptimeMillis() + aZkASS.f4508A4TApA.f4594CNPG0E));
                    }
                    if (z) {
                        BIYEnU bIYEnU = (BIYEnU) this.f4537AzWtSf;
                        AaHO0E aaHO0E = bIYEnU.f4546AmA8tU;
                        bIYEnU.A2egSU((BI9f7h) this.f4536AmA8tU, aaHO0E != null ? aaHO0E.f4510A4TApA.f4594CNPG0E : PushUIConfig.dismissTime);
                        break;
                    }
                }
                break;
            case 1:
                MOpbMP.B2KMhB b2KMhB = (MOpbMP.B2KMhB) this.f4537AzWtSf;
                String B25kr62 = b2KMhB.f5031AzWtSf.B25kr6("user_token");
                if (B25kr62 != null && !B25kr62.isEmpty()) {
                    ((LlW7FF.ASJ6gh) this.f4535AlLFFp).AYUAbz("toggle_favorite", B25kr62, b2KMhB.f5034B3GDIM.A4TApA() + "", new IQ76hF.AmA8tU(8, this));
                    break;
                } else {
                    ((MaterialButton) this.f4536AmA8tU).setChecked(false);
                    b2KMhB.startActivity(new Intent(b2KMhB.requireActivity(), (Class<?>) SaveSlotsActivity.class).putExtra("romName", "login"));
                    break;
                }
                break;
            default:
                Mt2q9w.ASJ6gh aSJ6gh = (Mt2q9w.ASJ6gh) this.f4535AlLFFp;
                ArrayList arrayList = aSJ6gh.AMqCpz;
                Mt2q9w.ADYaiT aDYaiT = (Mt2q9w.ADYaiT) this.f4537AzWtSf;
                if (arrayList != null && !arrayList.isEmpty()) {
                    boolean contains = aDYaiT.f5530AlLFFp.contains(Integer.valueOf(aSJ6gh.f5537A4TApA));
                    AppCompatImageView appCompatImageView = ((Mt2q9w.A2egSU) this.f4536AmA8tU).f5524AzWtSf;
                    if (appCompatImageView != null) {
                        appCompatImageView.clearAnimation();
                        appCompatImageView.animate().rotation(!contains ? 90.0f : 0.0f).setDuration(250L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
                    }
                    Mt2q9w.A5SV6n a5SV6n = aDYaiT.f5532AzWtSf;
                    if (a5SV6n != null) {
                        a5SV6n.AMqCpz(aSJ6gh);
                    }
                    int i = aSJ6gh.f5537A4TApA;
                    HashSet hashSet = aDYaiT.f5530AlLFFp;
                    boolean contains2 = hashSet.contains(Integer.valueOf(i));
                    HashMap hashMap2 = aDYaiT.f5533B25kr6;
                    if (!contains2) {
                        if (!hashSet.contains(Integer.valueOf(i)) && (num = (Integer) hashMap2.get(Integer.valueOf(i))) != null && (A2egSU2 = aDYaiT.A2egSU(i)) != null) {
                            ArrayList arrayList2 = A2egSU2.AMqCpz;
                            if (!arrayList2.isEmpty()) {
                                int size = arrayList2.size();
                                hashSet.add(Integer.valueOf(i));
                                aDYaiT.A4TApA();
                                aDYaiT.notifyItemRangeInserted(num.intValue() + 1, size);
                                break;
                            }
                        }
                    } else if (hashSet.contains(Integer.valueOf(i)) && (num2 = (Integer) hashMap2.get(Integer.valueOf(i))) != null && (A2egSU3 = aDYaiT.A2egSU(i)) != null) {
                        int size2 = A2egSU3.AMqCpz.size();
                        hashSet.remove(Integer.valueOf(i));
                        aDYaiT.A4TApA();
                        aDYaiT.notifyItemRangeRemoved(num2.intValue() + 1, size2);
                        break;
                    }
                } else {
                    Mt2q9w.A5SV6n a5SV6n2 = aDYaiT.f5532AzWtSf;
                    if (a5SV6n2 != null) {
                        a5SV6n2.AMqCpz(aSJ6gh);
                        break;
                    }
                }
                break;
        }
    }
}
