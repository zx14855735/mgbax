package LLiCI0;

import MOpbMP.Cd8JRx;
import MOpbMP.CikNvS;
import MOpbMP.CkXcdM;
import MOpbMP.CmUvjW;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.czhj.sdk.common.Constants;
import com.game.boy.MyApp;
import com.game.boy.activity.PackageActivity;
import com.game.boy.activity.SaveSlotsActivity;
import com.game.boy.emu.gba.Console;
import com.sigmob.sdk.base.blurkit.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4751AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f4752AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f4753AmA8tU;

    public /* synthetic */ BV3sI0(Object obj, int i, Object obj2) {
        this.f4751AcNBzu = i;
        this.f4753AmA8tU = obj;
        this.f4752AlLFFp = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int indexOf;
        int i = 2;
        switch (this.f4751AcNBzu) {
            case 0:
                PackageActivity packageActivity = (PackageActivity) ((BpkvW3) this.f4753AmA8tU).f4763AlLFFp;
                LlW7FF.ASJ6gh aSJ6gh = packageActivity.f11075BChYOn;
                SharedPreferences sharedPreferences = packageActivity.getSharedPreferences(packageActivity.getPackageName() + "_preferences", 0);
                sharedPreferences.edit().apply();
                String string = sharedPreferences.getString("user_token", null);
                StringBuilder sb = new StringBuilder("");
                MTKlkd.ADYaiT aDYaiT = (MTKlkd.ADYaiT) this.f4752AlLFFp;
                sb.append(aDYaiT.ADYaiT());
                String sb2 = sb.toString();
                I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(packageActivity, aDYaiT, 24, false);
                aSJ6gh.getClass();
                String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("create_order", string);
                if (!aSJ6gh.A5SV6n(ASJ6gh2)) {
                    aSJ6gh.AZOQYO(a4TApA, "创建订单请求正在进行中，请稍候", true);
                    break;
                } else {
                    aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "create_order", Constants.TOKEN, string, "package_id", sb2)), MTKlkd.A2egSU.class, a4TApA, ASJ6gh2, true);
                    break;
                }
            case 1:
                int adapterPosition = ((Cd8JRx) this.f4752AlLFFp).getAdapterPosition();
                if (adapterPosition != -1) {
                    CikNvS cikNvS = (CikNvS) this.f4753AmA8tU;
                    String str = (String) cikNvS.f5119AlLFFp.get(adapterPosition);
                    try {
                        InputStream open = cikNvS.f5118AcNBzu.getAssets().open("image/" + str);
                        Bitmap decodeStream = BitmapFactory.decodeStream(open);
                        CkXcdM ckXcdM = cikNvS.f5120AmA8tU;
                        ckXcdM.f5122A4TApA.f5134BI9f7h.setImageBitmap(decodeStream);
                        open.close();
                        ckXcdM.f5121A2egSU.dismiss();
                        CmUvjW cmUvjW = ckXcdM.f5122A4TApA;
                        LlW7FF.ASJ6gh aSJ6gh2 = cmUvjW.f5124AlLFFp;
                        String B25kr62 = cmUvjW.f5123AcNBzu.B25kr6("user_token");
                        int parseInt = Integer.parseInt(str.replace(".jpeg", ""));
                        aSJ6gh2.getClass();
                        String ASJ6gh3 = LlW7FF.ASJ6gh.ASJ6gh("update_avatar", B25kr62);
                        if (!aSJ6gh2.A5SV6n(ASJ6gh3)) {
                            aSJ6gh2.AZOQYO(null, "更新头像请求正在进行中，请稍候", true);
                            break;
                        } else {
                            aSJ6gh2.ARc23Z(aSJ6gh2.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "update_avatar", Constants.TOKEN, B25kr62, "avatar", Integer.valueOf(parseInt))), MTKlkd.A2egSU.class, null, ASJ6gh3, true);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                break;
            case 2:
                MQlCFp.ARc23Z aRc23Z = (MQlCFp.ARc23Z) this.f4752AlLFFp;
                int adapterPosition2 = aRc23Z.getAdapterPosition();
                if (adapterPosition2 != -1) {
                    MQlCFp.ASJ6gh aSJ6gh3 = (MQlCFp.ASJ6gh) this.f4753AmA8tU;
                    if (adapterPosition2 < aSJ6gh3.f5149AcNBzu.size()) {
                        List list = aSJ6gh3.f5149AcNBzu;
                        String str2 = (String) list.get(adapterPosition2);
                        LEPB2s.A2egSU a2egSU = aSJ6gh3.f5150AlLFFp;
                        a2egSU.getClass();
                        if (list != null && !list.isEmpty()) {
                            Context context = aRc23Z.itemView.getContext();
                            a2egSU.A2egSU();
                            Mm8v1u.BChYOn bChYOn = new Mm8v1u.BChYOn(context);
                            LayoutInflater.from(bChYOn.getContext()).inflate(2131493177, (ViewGroup) bChYOn, true);
                            bChYOn.f5512AcNBzu = (ViewPager2) bChYOn.findViewById(2131298304);
                            bChYOn.f5513AlLFFp = (TextView) bChYOn.findViewById(2131298206);
                            bChYOn.f5514AmA8tU = (ImageView) bChYOn.findViewById(2131296762);
                            bChYOn.f5515AzWtSf = (LinearLayout) bChYOn.findViewById(2131298113);
                            bChYOn.f5514AmA8tU.setOnClickListener(new Mm8v1u.AmA8tU(bChYOn, 0));
                            bChYOn.setOnClickListener(new Mm8v1u.AmA8tU(bChYOn, 1));
                            bChYOn.f5515AzWtSf.setOnClickListener(new Mm8v1u.AzWtSf());
                            bChYOn.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            bChYOn.setBackgroundColor(d.f13043a);
                            if (str2 != null && (indexOf = list.indexOf(str2)) != -1) {
                                adapterPosition2 = indexOf;
                            }
                            bChYOn.f5516B25kr6 = list;
                            bChYOn.f5517B2KMhB = adapterPosition2;
                            bChYOn.f5512AcNBzu.setAdapter(new Mm8v1u.B9tovu(bChYOn));
                            bChYOn.f5512AcNBzu.A4TApA(bChYOn.f5517B2KMhB, false);
                            bChYOn.f5512AcNBzu.f9587AmA8tU.f9569A2egSU.add(new Mm8v1u.B25kr6(bChYOn));
                            bChYOn.A4TApA();
                            Dialog dialog = new Dialog(context, R.style.Theme.Black.NoTitleBar);
                            a2egSU.f4446A2egSU = dialog;
                            dialog.setContentView(bChYOn);
                            a2egSU.f4446A2egSU.setCancelable(true);
                            a2egSU.f4446A2egSU.setCanceledOnTouchOutside(true);
                            a2egSU.f4446A2egSU.getWindow().setWindowAnimations(R.style.Animation.Dialog);
                            a2egSU.f4446A2egSU.show();
                            break;
                        }
                    }
                }
                break;
            case 3:
                I3HV03.A4TApA a4TApA2 = ((Mi9UWv.A4TApA) this.f4753AmA8tU).f5389AlLFFp;
                if (a4TApA2 != null) {
                    Mi9UWv.ASJ6gh aSJ6gh4 = (Mi9UWv.ASJ6gh) a4TApA2.f3809AmA8tU;
                    I3HV03.A4TApA a4TApA3 = new I3HV03.A4TApA(aSJ6gh4.f5409B9tovu, (String) null);
                    boolean z = ((SharedPreferences) a4TApA3.f3808AlLFFp).getBoolean("on_line_room", false);
                    MTKlkd.AMqCpz aMqCpz = (MTKlkd.AMqCpz) this.f4752AlLFFp;
                    if (!z) {
                        OOnEhG.A4TApA a4TApA4 = new OOnEhG.A4TApA(aSJ6gh4.f5409B9tovu);
                        ADYaiT.AZOQYO azoqyo = a4TApA4.f81AcNBzu;
                        azoqyo.AMqCpz = "提示";
                        azoqyo.f28ASJ6gh = "进入联机前请保存游戏进度，未保存数据将无法恢复！";
                        a4TApA4.AzWtSf("进入", new M0ztbm.ADYaiT(a4TApA2, 2, aMqCpz));
                        a4TApA4.AcNBzu("取消", null);
                        a4TApA4.AlLFFp("不再提醒", new DRlcZ9.ASJ6gh(7, a4TApA3));
                        a4TApA4.AMqCpz();
                        break;
                    } else {
                        Mi9UWv.ASJ6gh.B3GDIM(aSJ6gh4, aMqCpz, (Console) a4TApA2.f3808AlLFFp);
                        break;
                    }
                }
                break;
            case 4:
                Activity activity = ((Mi9UWv.ASJ6gh) this.f4753AmA8tU).f5409B9tovu;
                SharedPreferences sharedPreferences2 = activity.getSharedPreferences(activity.getPackageName() + "_preferences", 0);
                sharedPreferences2.edit().apply();
                if (sharedPreferences2.getString("user_token", null) != null) {
                    LLYwnm.AYUAbz aYUAbz = ((Mi9UWv.ASJ6gh) this.f4753AmA8tU).f5410BChYOn;
                    if (aYUAbz != null) {
                        String str3 = ((Console) this.f4752AlLFFp).f11097ADYaiT;
                        LHpdLt.AlLFFp alLFFp = new LHpdLt.AlLFFp(i, this);
                        if (str3 != null && !str3.isEmpty()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("action", "create_game_room");
                            hashMap.put("room_name", str3);
                            hashMap.put(Constants.TOKEN, aYUAbz.f4627A4TApA);
                            aYUAbz.ARc23Z(hashMap, "create_game_room", alLFFp);
                            break;
                        } else {
                            aYUAbz.A5SV6n(new JrXYwF.A2egSU(alLFFp, 3));
                            break;
                        }
                    } else {
                        MyApp.A2egSU("服务器未连接");
                        break;
                    }
                } else {
                    ((Mi9UWv.ASJ6gh) this.f4753AmA8tU).f5409B9tovu.startActivityForResult(new Intent(((Mi9UWv.ASJ6gh) this.f4753AmA8tU).f5409B9tovu, (Class<?>) SaveSlotsActivity.class).putExtra("romName", "login"), 1);
                    break;
                }
                break;
            default:
                Mt2q9w.A5SV6n a5SV6n = ((Mt2q9w.ADYaiT) this.f4753AmA8tU).f5532AzWtSf;
                if (a5SV6n != null) {
                    a5SV6n.ASJ6gh((Mt2q9w.AYUAbz) this.f4752AlLFFp);
                    break;
                }
                break;
        }
    }
}
