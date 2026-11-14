package MOpbMP;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.czhj.sdk.common.Constants;
import com.game.boy.MyApp;
import com.game.boy.activity.DeviceActivity;
import com.game.boy.activity.DownLoadActivity;
import com.game.boy.activity.FavoriteActivity;
import com.game.boy.activity.PackageActivity;
import com.game.boy.activity.SaveSlotsActivity;
import com.game.boy.activity.SettingsActivity;
import com.google.android.material.chip.Chip;
import com.google.android.material.imageview.ShapeableImageView;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.ads.core.v2.reward.DCRewardAd;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CmUvjW extends Fragment implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public I3HV03.A4TApA f5123AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LlW7FF.ASJ6gh f5124AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public LinearLayout f5125AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public LinearLayout f5126AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public LinearLayout f5127B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public LinearLayout f5128B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public LinearLayout f5129B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public LinearLayout f5130B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LinearLayout f5131B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public LinearLayout f5132B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CardView f5133BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ShapeableImageView f5134BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public ImageView f5135BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public TextView f5136BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public Chip f5137BNL6CD;

    public static String AZkASS(String str) {
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(str).getTime() - new Date().getTime();
            return time <= 0 ? "0秒" : AcNBzu(time / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String AcNBzu(long j) {
        if (j >= 86400) {
            long j2 = j / 86400;
            long j3 = j % 86400;
            if (j3 < 3600) {
                return j2 + "天";
            }
            return j2 + "天" + (j3 / 3600) + "小时";
        }
        if (j < 3600) {
            if (j >= 60) {
                return (j / 60) + "分钟";
            }
            return j + "秒";
        }
        long j4 = j / 3600;
        long j5 = j % 3600;
        if (j5 < 60) {
            return j4 + "小时";
        }
        return j4 + "小时" + (j5 / 60) + "分钟";
    }

    public final void AlLFFp() {
        startActivity(new Intent(requireActivity(), (Class<?>) SaveSlotsActivity.class).putExtra("romName", "login"));
    }

    public final void AmA8tU() {
        TextView textView = this.f5136BJ7GGh;
        I3HV03.A4TApA a4TApA = this.f5123AcNBzu;
        textView.setText(((SharedPreferences) a4TApA.f3808AlLFFp).getString("user_name", getString(2131886640)));
        Chip chip = this.f5137BNL6CD;
        I3HV03.A4TApA a4TApA2 = this.f5123AcNBzu;
        chip.setText(AZkASS(((SharedPreferences) a4TApA2.f3808AlLFFp).getString("user_group", getString(2131886640))));
        L2suez.AZOQYO.A4TApA(requireActivity(), this.f5123AcNBzu.B25kr6("user_avatar"), this.f5134BI9f7h);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = 4;
        int id = view.getId();
        boolean z = false;
        boolean z2 = this.f5123AcNBzu.B25kr6("user_token") != null;
        if (id == 2131298285) {
            requireActivity().startActivity(new Intent(requireActivity(), (Class<?>) SettingsActivity.class));
            return;
        }
        if (id == 2131298312) {
            if (z2) {
                requireActivity().startActivity(new Intent(requireActivity(), (Class<?>) PackageActivity.class));
                return;
            } else {
                AlLFFp();
                return;
            }
        }
        if (id == 2131296272) {
            if (!z2) {
                AlLFFp();
                return;
            }
            this.f5126AzWtSf.setEnabled(false);
            LlW7FF.ASJ6gh aSJ6gh = this.f5124AlLFFp;
            String B25kr62 = this.f5123AcNBzu.B25kr6("user_token");
            IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(10, this);
            aSJ6gh.getClass();
            String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("daily_signin", B25kr62);
            if (aSJ6gh.A5SV6n(ASJ6gh2)) {
                aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "daily_signin", Constants.TOKEN, B25kr62)), MTKlkd.AZkASS.class, amA8tU, ASJ6gh2, true);
                return;
            } else {
                aSJ6gh.AZOQYO(amA8tU, "签到请求正在进行中，请稍候", true);
                return;
            }
        }
        if (id == 2131296262) {
            if (z2) {
                startActivity(new Intent(requireActivity(), (Class<?>) FavoriteActivity.class));
                return;
            } else {
                AlLFFp();
                return;
            }
        }
        if (id == 2131296261) {
            startActivity(new Intent(requireActivity(), (Class<?>) DeviceActivity.class));
            return;
        }
        if (id == 2131298283) {
            startActivity(new Intent(requireActivity(), (Class<?>) DownLoadActivity.class));
            return;
        }
        if (id == 2131298284) {
            if (!z2) {
                AlLFFp();
                return;
            }
            CcAIMM ccAIMM = new CcAIMM(this);
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(requireActivity());
            ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
            azoqyo.AMqCpz = "提示";
            azoqyo.f28ASJ6gh = "是否切换账号？";
            a4TApA.AzWtSf("确定", new DRlcZ9.ASJ6gh(i2, ccAIMM));
            a4TApA.AcNBzu("取消", null);
            a4TApA.AMqCpz();
            return;
        }
        if (id == 2131298281) {
            if (z2) {
                return;
            }
            AlLFFp();
            return;
        }
        if (id != 2131296746) {
            if (id == 2131298286) {
                MyApp.A2egSU("正在加载广告中...");
                DCRewardAd dCRewardAd = new DCRewardAd(requireActivity());
                dCRewardAd.setRewardAdListener(new Hdahpu.AZOQYO(25));
                DCloudAdSlot.Builder builder = new DCloudAdSlot.Builder();
                builder.adpid("1595742866");
                if (z2) {
                    builder.userId(this.f5123AcNBzu.B25kr6("user_token"));
                }
                dCRewardAd.load(builder.build(), new I3HV03.A4TApA(this, dCRewardAd, 9, z));
                return;
            }
            return;
        }
        if (!z2) {
            AlLFFp();
            return;
        }
        CkXcdM ckXcdM = new CkXcdM(this);
        Context requireContext = requireContext();
        ArrayList arrayList = new ArrayList();
        try {
            String[] list = requireContext.getAssets().list("image");
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    String str = list[i];
                    i = (str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".png")) ? 0 : i + 1;
                    arrayList.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(requireContext, "没有找到图片", 0).show();
            return;
        }
        RecyclerView recyclerView = new RecyclerView(requireContext, null);
        recyclerView.setLayoutManager(new GridLayoutManager(4));
        recyclerView.setAdapter(new CikNvS(ckXcdM, requireContext, arrayList));
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, ((int) Math.ceil(arrayList.size() / 4.0d)) * (requireContext.getResources().getDisplayMetrics().widthPixels / 4)));
        OOnEhG.A4TApA a4TApA2 = new OOnEhG.A4TApA(requireContext);
        ADYaiT.AZOQYO azoqyo2 = a4TApA2.f81AcNBzu;
        azoqyo2.AMqCpz = "选择头像";
        azoqyo2.f41B7CMnp = recyclerView;
        a4TApA2.AzWtSf("取消", null);
        ADYaiT.AmA8tU A2egSU2 = a4TApA2.A2egSU();
        ckXcdM.f5121A2egSU = A2egSU2;
        A2egSU2.show();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f5123AcNBzu = new I3HV03.A4TApA(requireActivity(), (String) null);
        this.f5124AlLFFp = MyApp.f10880AzWtSf;
        new Handler(Looper.getMainLooper());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131492962, viewGroup, false);
        this.f5134BI9f7h = (ShapeableImageView) inflate.findViewById(2131296746);
        this.f5135BIYEnU = (ImageView) inflate.findViewById(2131296747);
        this.f5136BJ7GGh = (TextView) inflate.findViewById(2131298165);
        this.f5137BNL6CD = (Chip) inflate.findViewById(2131296498);
        this.f5132B9tovu = (LinearLayout) inflate.findViewById(2131298281);
        this.f5126AzWtSf = (LinearLayout) inflate.findViewById(2131296272);
        this.f5128B2KMhB = (LinearLayout) inflate.findViewById(2131296262);
        this.f5127B25kr6 = (LinearLayout) inflate.findViewById(2131296261);
        this.f5129B3GDIM = (LinearLayout) inflate.findViewById(2131298283);
        this.f5125AmA8tU = (LinearLayout) inflate.findViewById(2131298286);
        this.f5133BChYOn = (CardView) inflate.findViewById(2131298312);
        if (this.f5123AcNBzu.AzWtSf("isVip")) {
            this.f5133BChYOn.setVisibility(0);
        } else {
            this.f5133BChYOn.setVisibility(8);
        }
        this.f5130B4ZgIw = (LinearLayout) inflate.findViewById(2131298285);
        this.f5131B7CMnp = (LinearLayout) inflate.findViewById(2131298284);
        this.f5134BI9f7h.setOnClickListener(this);
        this.f5125AmA8tU.setOnClickListener(this);
        this.f5132B9tovu.setOnClickListener(this);
        this.f5126AzWtSf.setOnClickListener(this);
        this.f5128B2KMhB.setOnClickListener(this);
        this.f5127B25kr6.setOnClickListener(this);
        this.f5129B3GDIM.setOnClickListener(this);
        this.f5133BChYOn.setOnClickListener(this);
        this.f5130B4ZgIw.setOnClickListener(this);
        this.f5131B7CMnp.setOnClickListener(this);
        AmA8tU();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f5123AcNBzu.B25kr6("user_token") != null) {
            LlW7FF.ASJ6gh aSJ6gh = this.f5124AlLFFp;
            String B25kr62 = this.f5123AcNBzu.B25kr6("user_token");
            CcAIMM ccAIMM = new CcAIMM(this);
            aSJ6gh.getClass();
            String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("get_user_info", B25kr62);
            if (aSJ6gh.A5SV6n(ASJ6gh2)) {
                aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "get_user_info", Constants.TOKEN, B25kr62)), MTKlkd.AZkASS.class, ccAIMM, ASJ6gh2, false);
            } else {
                aSJ6gh.AZOQYO(ccAIMM, "获取用户信息请求正在进行中，请稍候", false);
            }
            if (this.f5123AcNBzu.AzWtSf("isVip")) {
                this.f5133BChYOn.setVisibility(0);
            } else {
                this.f5133BChYOn.setVisibility(8);
            }
        }
    }
}
