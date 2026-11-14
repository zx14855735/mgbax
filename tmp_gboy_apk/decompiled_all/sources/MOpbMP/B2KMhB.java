package MOpbMP;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B2KMhB extends AZOQYO {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public I3HV03.A4TApA f5031AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ViewPager2 f5032B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public TabLayout f5033B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MTKlkd.ARc23Z f5034B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ADYaiT.CTkVKb f5035B4ZgIw = new ADYaiT.CTkVKb(5, this);

    /* renamed from: B7CMnp, reason: collision with root package name */
    public MaterialButton f5036B7CMnp;

    public static void AlLFFp(B2KMhB b2KMhB, L5dZB6.A4TApA a4TApA) {
        String str;
        switch (a4TApA.f4400B7CMnp) {
            case 0:
                str = "等待";
                break;
            case 1:
                str = String.format(Locale.getDefault(), "%d%%", Integer.valueOf(a4TApA.f4399B4ZgIw));
                break;
            case 2:
                str = "继续";
                break;
            case 3:
                str = "打开";
                break;
            case 4:
                str = "失败";
                break;
            case 5:
                str = "验证中";
                break;
            case 6:
                str = "重试";
                break;
            default:
                str = "下载";
                break;
        }
        b2KMhB.f5036B7CMnp.setText(str);
    }

    public static void AmA8tU(B2KMhB b2KMhB, String str) {
        b2KMhB.requireActivity().getSharedPreferences("MainActivity", 0).edit().putString("lastGame", str).apply();
        b2KMhB.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str), b2KMhB.requireActivity(), EmulatorActivity.class));
    }

    public static B2KMhB AzWtSf(MTKlkd.ARc23Z aRc23Z) {
        B2KMhB b2KMhB = new B2KMhB();
        Bundle bundle = new Bundle();
        bundle.putParcelable("game_item", aRc23Z);
        b2KMhB.setArguments(bundle);
        return b2KMhB;
    }

    @Override // MOpbMP.AZOQYO
    public final int AcNBzu() {
        return 2131492969;
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        LEPB2s.A2egSU A4TApA2 = LEPB2s.A2egSU.A4TApA();
        boolean A5SV6n2 = A4TApA2.A5SV6n();
        if (A5SV6n2) {
            A4TApA2.A2egSU();
        }
        if (A5SV6n2) {
            return;
        }
        super.onCancel(dialogInterface);
        DG07BK.A5SV6n.A2egSU(requireActivity()).unregisterReceiver(this.f5035B4ZgIw);
    }

    @Override // MOpbMP.AZOQYO, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5031AzWtSf = new I3HV03.A4TApA(requireActivity());
        if (getArguments() != null) {
            this.f5034B3GDIM = (MTKlkd.ARc23Z) getArguments().getParcelable("game_item");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        com.bumptech.glide.AzWtSf ASJ6gh2;
        String str;
        int i = 1;
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(2131296383);
        TextView textView = (TextView) view.findViewById(2131296384);
        MaterialButton materialButton = (MaterialButton) view.findViewById(2131296657);
        TextView textView2 = (TextView) view.findViewById(2131296582);
        this.f5036B7CMnp = (MaterialButton) view.findViewById(2131296601);
        this.f5033B2KMhB = (TabLayout) view.findViewById(2131298053);
        this.f5032B25kr6 = (ViewPager2) view.findViewById(2131298302);
        this.f5032B25kr6.setAdapter(new B25kr6(this, this));
        this.f5032B25kr6.setOffscreenPageLimit(2);
        this.f5032B25kr6.setUserInputEnabled(false);
        TabLayout tabLayout = this.f5033B2KMhB;
        ViewPager2 viewPager2 = this.f5032B25kr6;
        com.google.android.material.tabs.AYUAbz aYUAbz = new com.google.android.material.tabs.AYUAbz(tabLayout, viewPager2, new AzWtSf());
        if (aYUAbz.f11837ADYaiT) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.A2egSU adapter = viewPager2.getAdapter();
        aYUAbz.f11836A5SV6n = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        aYUAbz.f11837ADYaiT = true;
        viewPager2.f9587AmA8tU.f9569A2egSU.add(new com.google.android.material.tabs.ARc23Z(tabLayout));
        tabLayout.A2egSU(new com.google.android.material.tabs.ASJ6gh(viewPager2));
        aYUAbz.f11836A5SV6n.registerAdapterDataObserver(new PWIgQJ.AMqCpz(aYUAbz));
        aYUAbz.A2egSU();
        tabLayout.B2KMhB(true, 0.0f, viewPager2.getCurrentItem(), true, true);
        IQ76hF.AaHO0E A5SV6n2 = com.bumptech.glide.A4TApA.A5SV6n(getContext());
        A5SV6n2.getClass();
        ItGa5w.ARc23Z.A5SV6n(getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (getActivity() != null) {
                getActivity();
                A5SV6n2.f3951B2KMhB.getClass();
            }
            ASJ6gh2 = A5SV6n2.ASJ6gh(getContext(), getChildFragmentManager(), this, isVisible());
        } else {
            ASJ6gh2 = A5SV6n2.A5SV6n(getContext().getApplicationContext());
        }
        ((RequestBuilder) ((RequestBuilder) ASJ6gh2.AaHO0E(this.f5034B3GDIM.ADYaiT()).ADYaiT(HXc4pW.AlLFFp.f3555A2egSU)).AZkASS(2131231009)).BTvldC(imageView);
        textView.setText(this.f5034B3GDIM.ARc23Z());
        textView2.setText("大小: " + this.f5034B3GDIM.AZkASS());
        MTKlkd.ARc23Z aRc23Z = this.f5034B3GDIM;
        switch (aRc23Z.AaHO0E()) {
            case 0:
                str = "等待";
                break;
            case 1:
                str = String.format(Locale.getDefault(), "%d%%", Integer.valueOf(aRc23Z.ASJ6gh()));
                break;
            case 2:
                str = "继续";
                break;
            case 3:
                str = "打开";
                break;
            case 4:
                str = "失败";
                break;
            case 5:
                str = "验证中";
                break;
            case 6:
                str = "重试";
                break;
            default:
                str = "下载";
                break;
        }
        this.f5036B7CMnp.setText(str);
        String B25kr62 = this.f5031AzWtSf.B25kr6("user_token");
        LlW7FF.ASJ6gh aSJ6gh = MyApp.f10880AzWtSf;
        if (B25kr62 == null || B25kr62.isEmpty()) {
            this.f5034B3GDIM.AlLFFp(false);
            materialButton.setChecked(false);
        } else if (this.f5034B3GDIM.AcNBzu()) {
            materialButton.setChecked(this.f5034B3GDIM.AcNBzu());
        } else {
            aSJ6gh.AYUAbz("check_favorite", B25kr62, this.f5034B3GDIM.A4TApA() + "", new I3HV03.A4TApA(this, materialButton, 8, false));
        }
        materialButton.setOnClickListener(new LHpdLt.B9tovu(i, this, aSJ6gh, materialButton));
        if ((this.f5034B3GDIM.AYUAbz() == null || this.f5034B3GDIM.AYUAbz().isEmpty()) && this.f5034B3GDIM.f5248BNL6CD == null) {
            this.f5036B7CMnp.setVisibility(8);
        } else {
            this.f5036B7CMnp.setVisibility(0);
        }
        this.f5036B7CMnp.setOnClickListener(new ADYaiT.A5SV6n(9, this));
        DG07BK.A5SV6n.A2egSU(requireActivity()).registerReceiver(this.f5035B4ZgIw, new IntentFilter("com.game.boy.DOWNLOAD_UPDATE"));
    }
}
