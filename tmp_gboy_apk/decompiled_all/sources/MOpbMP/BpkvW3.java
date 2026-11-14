package MOpbMP;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import L2suez.ASJ6gh;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.MainActivity;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BpkvW3 extends Fragment implements LCJm5h.AMqCpz {

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static ArrayList f5062CNPG0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public SearchView f5063AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public SearchBar f5064AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public RecyclerView f5065AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public LLiCI0.BJ7GGh f5066AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TextView f5067B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public L2suez.AaHO0E f5068B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public TabLayout f5069B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public SwipeRefreshLayout f5070B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LLiCI0.CcAIMM f5071B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public RecyclerView f5072B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public LinearLayoutManager f5073BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public LLiCI0.ARc23Z f5074BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public BmvVmW f5075BIYEnU;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public File f5080BV3sI0;
    public I3HV03.A4TApA BpkvW3;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ArrayList f5076BJ7GGh = new ArrayList();

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final ArrayList f5077BNL6CD = new ArrayList();

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public File f5078BPw6Q8 = null;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f5079BTvldC = false;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f5081BmvVmW = -1;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final ExecutorService f5082BniPrB = Executors.newSingleThreadExecutor();

    /* renamed from: C2rE4F, reason: collision with root package name */
    public long f5083C2rE4F = 0;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f5084C4FrIb = false;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final ADYaiT.CTkVKb f5085CASmeH = new ADYaiT.CTkVKb(6, this);

    public static boolean AmA8tU(File file) {
        ArrayList arrayList;
        if (file == null || (arrayList = f5062CNPG0E) == null) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File parentFile = ((ASJ6gh.A2egSU) it.next()).f4366A2egSU.getParentFile();
            if (parentFile != null && parentFile.equals(file)) {
                return false;
            }
        }
        return true;
    }

    @Override // LCJm5h.AMqCpz
    public final void A4TApA(int i, String str) {
        Toast.makeText(getActivity(), str, 0).show();
        if (i == 0 || i == 4) {
            AzWtSf();
        }
    }

    public final void AZkASS(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - this.f5083C2rE4F >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            this.f5083C2rE4F = currentTimeMillis;
            Context requireContext = requireContext();
            MyApp myApp = MyApp.f10877AcNBzu;
            L2suez.B2KMhB.A2egSU(requireContext, false, new B7CMnp(this));
        }
    }

    public final void AcNBzu(String str) {
        requireActivity().getSharedPreferences("MainActivity", 0).edit().putString("lastGame", str).apply();
        requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str), requireActivity(), EmulatorActivity.class));
    }

    public final void AlLFFp() {
        ArrayList arrayList;
        if (f5062CNPG0E == null || !isAdded() || getView() == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (this.f5079BTvldC) {
            Iterator it = LCJm5h.A2egSU.A2egSU(requireContext()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Iterator it2 = f5062CNPG0E.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) it2.next();
                    File file = a2egSU.f4366A2egSU;
                    if (file != null && file.getAbsolutePath().equals(str)) {
                        arrayList2.add(a2egSU);
                        break;
                    }
                }
            }
            LLiCI0.BJ7GGh bJ7GGh = this.f5066AzWtSf;
            bJ7GGh.f4737AcNBzu = arrayList2;
            bJ7GGh.notifyDataSetChanged();
            B4ZgIw(arrayList2.isEmpty());
            arrayList2.size();
            return;
        }
        String absolutePath = new File(Environment.getExternalStorageDirectory(), "GBoy/rom").getAbsolutePath();
        Iterator it3 = f5062CNPG0E.iterator();
        while (it3.hasNext()) {
            ASJ6gh.A2egSU a2egSU2 = (ASJ6gh.A2egSU) it3.next();
            File file2 = a2egSU2.f4366A2egSU;
            if (file2 != null) {
                if (this.f5078BPw6Q8 == null) {
                    if (file2.getAbsolutePath().startsWith(absolutePath)) {
                        arrayList2.add(a2egSU2);
                    }
                } else if (file2.getAbsolutePath().startsWith(this.f5078BPw6Q8.getAbsolutePath())) {
                    arrayList2.add(a2egSU2);
                }
            }
        }
        if (this.f5069B3GDIM != null && this.f5076BJ7GGh.size() >= 2) {
            TabLayout.A2egSU AZOQYO2 = this.f5069B3GDIM.AZOQYO(0);
            TabLayout.A2egSU AZOQYO3 = this.f5069B3GDIM.AZOQYO(1);
            if (AZOQYO2 != null && (arrayList = f5062CNPG0E) != null) {
                int size = arrayList.size();
                AZOQYO2.A2egSU(size > 0 ? CtFAbx.ASJ6gh(size, "全部 (", ")") : "全部");
            }
            if (AZOQYO3 != null) {
                int size2 = LCJm5h.A2egSU.A2egSU(requireContext()).size();
                AZOQYO3.A2egSU(size2 > 0 ? CtFAbx.ASJ6gh(size2, "喜欢 (", ")") : "喜欢");
            }
        }
        LLiCI0.BJ7GGh bJ7GGh2 = this.f5066AzWtSf;
        bJ7GGh2.f4737AcNBzu = arrayList2;
        bJ7GGh2.notifyDataSetChanged();
        B4ZgIw(arrayList2.isEmpty());
        File file3 = this.f5078BPw6Q8;
        if (file3 != null) {
            file3.getName();
        }
        arrayList2.size();
    }

    public final void AzWtSf() {
        this.f5070B4ZgIw.setRefreshing(true);
        if (this.f5074BI9f7h != null) {
            String B25kr62 = this.BpkvW3.B25kr6("updater");
            List list = null;
            if (B25kr62 != null && !B25kr62.isEmpty()) {
                try {
                    MTKlkd.AZOQYO azoqyo = (MTKlkd.AZOQYO) new Gson().fromJson(B25kr62, MTKlkd.AZOQYO.class);
                    if (azoqyo != null && azoqyo.A2egSU() != null) {
                        list = azoqyo.A2egSU();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LLiCI0.ARc23Z aRc23Z = this.f5074BI9f7h;
            if (list == null) {
                list = new ArrayList();
            }
            aRc23Z.A2egSU(list);
            B7CMnp();
        }
        this.f5082BniPrB.execute(new B4ZgIw(this));
    }

    public final void B25kr6(boolean z) {
        TabLayout.A2egSU AZOQYO2;
        if (this.f5069B3GDIM != null && this.f5076BJ7GGh.size() >= 2 && (AZOQYO2 = this.f5069B3GDIM.AZOQYO(1)) != null) {
            int size = LCJm5h.A2egSU.A2egSU(requireContext()).size();
            AZOQYO2.A2egSU(size > 0 ? CtFAbx.ASJ6gh(size, "喜欢 (", ")") : "喜欢");
        }
        if (z && this.f5079BTvldC) {
            AlLFFp();
        }
    }

    public final void B2KMhB(boolean z) {
        LLiCI0.AMqCpz aMqCpz;
        LLiCI0.A4TApA a4TApA;
        if (this.f5065AmA8tU.getAdapter() == null) {
            return;
        }
        LLiCI0.ARc23Z aRc23Z = this.f5074BI9f7h;
        if (aRc23Z != null && (aMqCpz = aRc23Z.f4683AlLFFp) != null && (a4TApA = aMqCpz.f4680AmA8tU) != null) {
            a4TApA.f4675ADYaiT = false;
            a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
        }
        this.f5084C4FrIb = false;
        if (z) {
            int i = (int) (((getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().density) - 16.0f) / 120.0f);
            int max = getResources().getConfiguration().orientation == 1 ? Math.max(2, i) : Math.max(3, i);
            getActivity();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(max);
            gridLayoutManager.f9419ASJ6gh = new BChYOn(this, max);
            this.f5066AzWtSf.f4741B25kr6 = 2;
            this.f5065AmA8tU.setLayoutManager(gridLayoutManager);
        } else {
            RecyclerView recyclerView = this.f5065AmA8tU;
            requireActivity();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            this.f5066AzWtSf.f4741B25kr6 = 1;
        }
        this.f5065AmA8tU.post(new LLYwnm.AMqCpz(9, this));
    }

    public final void B3GDIM() {
        if (getView() == null) {
            return;
        }
        TabLayout tabLayout = (TabLayout) getView().findViewById(2131298055);
        this.f5069B3GDIM = tabLayout;
        tabLayout.f11879D07BeM.clear();
        this.f5069B3GDIM.AcNBzu();
        ArrayList arrayList = this.f5076BJ7GGh;
        arrayList.clear();
        arrayList.add(new BniPrB(null, 0));
        TabLayout tabLayout2 = this.f5069B3GDIM;
        TabLayout.A2egSU AZkASS2 = tabLayout2.AZkASS();
        AZkASS2.A2egSU("全部");
        tabLayout2.A4TApA(AZkASS2);
        arrayList.add(new BniPrB(null, 1));
        TabLayout tabLayout3 = this.f5069B3GDIM;
        TabLayout.A2egSU AZkASS3 = tabLayout3.AZkASS();
        AZkASS3.A2egSU("喜欢");
        tabLayout3.A4TApA(AZkASS3);
        ArrayList arrayList2 = this.f5077BNL6CD;
        arrayList2.clear();
        File file = new File(Environment.getExternalStorageDirectory(), "GBoy/rom");
        if (f5062CNPG0E != null) {
            HashSet hashSet = new HashSet();
            Iterator it = f5062CNPG0E.iterator();
            while (it.hasNext()) {
                File parentFile = ((ASJ6gh.A2egSU) it.next()).f4366A2egSU.getParentFile();
                if (parentFile != null && !parentFile.equals(file)) {
                    hashSet.add(parentFile);
                }
            }
            arrayList2.addAll(hashSet);
        }
        Collections.sort(arrayList2, new B4ZgIw.ARc23Z(6));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            File file2 = (File) it2.next();
            file2.getName();
            arrayList.add(new BniPrB(file2, 2));
            TabLayout tabLayout4 = this.f5069B3GDIM;
            TabLayout.A2egSU AZkASS4 = tabLayout4.AZkASS();
            AZkASS4.A2egSU(file2.getName());
            tabLayout4.A4TApA(AZkASS4);
        }
        TabLayout.A2egSU AZOQYO2 = this.f5069B3GDIM.AZOQYO(0);
        if (AZOQYO2 != null) {
            TabLayout tabLayout5 = AZOQYO2.f11894ARc23Z;
            if (tabLayout5 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout5.AzWtSf(AZOQYO2, true);
        }
        this.f5069B3GDIM.A2egSU(new B9tovu(this));
    }

    public final void B4ZgIw(boolean z) {
        this.f5067B25kr6.setVisibility(z ? 0 : 8);
        this.f5065AmA8tU.setVisibility(z ? 8 : 0);
    }

    public final void B7CMnp() {
        RecyclerView recyclerView;
        RecyclerView.ARc23Z layoutManager;
        View findViewByPosition;
        LLiCI0.A4TApA a4TApA;
        LLiCI0.A4TApA a4TApA2;
        LLiCI0.ARc23Z aRc23Z = this.f5074BI9f7h;
        if (aRc23Z == null || this.f5065AmA8tU == null) {
            return;
        }
        ArrayList arrayList = aRc23Z.f4682AcNBzu;
        boolean z = (arrayList == null ? 0 : arrayList.size()) > 1 && isResumed() && (recyclerView = this.f5065AmA8tU) != null && recyclerView.getScrollState() == 0 && (layoutManager = this.f5065AmA8tU.getLayoutManager()) != null && (findViewByPosition = layoutManager.findViewByPosition(0)) != null && findViewByPosition.getBottom() > 0;
        if (z == this.f5084C4FrIb) {
            return;
        }
        this.f5084C4FrIb = z;
        if (z) {
            LLiCI0.AMqCpz aMqCpz = this.f5074BI9f7h.f4683AlLFFp;
            if (aMqCpz == null || (a4TApA2 = aMqCpz.f4680AmA8tU) == null) {
                return;
            }
            a4TApA2.A2egSU();
            return;
        }
        LLiCI0.AMqCpz aMqCpz2 = this.f5074BI9f7h.f4683AlLFFp;
        if (aMqCpz2 == null || (a4TApA = aMqCpz2.f4680AmA8tU) == null) {
            return;
        }
        a4TApA.f4675ADYaiT = false;
        a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        switch (i) {
            case 1001:
                if (this.f5080BV3sI0 != null) {
                    File file = new File(L2suez.B9tovu.A2egSU("GBoy/image"), this.f5080BV3sI0.getName().replace(LCJm5h.ARc23Z.ASJ6gh(this.f5080BV3sI0.getName()), ".png"));
                    LCJm5h.ARc23Z.AMqCpz(requireActivity(), data, file, new BIYEnU(this, file));
                    break;
                }
                break;
            case 1002:
                if (this.f5080BV3sI0 != null) {
                    String AYUAbz2 = LCJm5h.ARc23Z.AYUAbz(requireActivity(), data);
                    if (AYUAbz2 != null && AYUAbz2.toLowerCase(Locale.ROOT).endsWith(".sav")) {
                        LCJm5h.ARc23Z.AMqCpz(requireActivity(), data, new File(L2suez.B9tovu.A2egSU("GBoy/save"), this.f5080BV3sI0.getName().replace(LCJm5h.ARc23Z.ASJ6gh(this.f5080BV3sI0.getName()), ".sav")), new BJ7GGh(this));
                        break;
                    } else {
                        Toast.makeText(getActivity(), 2131886661, 0).show();
                        break;
                    }
                }
                break;
            case 1003:
                LCJm5h.ARc23Z.AlLFFp(requireActivity(), data, this);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        B2KMhB(this.BpkvW3.AzWtSf("list_grid"));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131492960, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f5082BniPrB.shutdown();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LLiCI0.AMqCpz aMqCpz;
        LLiCI0.A4TApA a4TApA;
        this.f5084C4FrIb = false;
        LLiCI0.ARc23Z aRc23Z = this.f5074BI9f7h;
        if (aRc23Z != null && (aMqCpz = aRc23Z.f4683AlLFFp) != null && (a4TApA = aMqCpz.f4680AmA8tU) != null) {
            a4TApA.f4675ADYaiT = false;
            a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
        }
        try {
            DG07BK.A5SV6n.A2egSU(requireActivity()).unregisterReceiver(this.f5085CASmeH);
        } catch (Exception unused) {
        }
        this.f5069B3GDIM = null;
        this.f5070B4ZgIw = null;
        this.f5064AlLFFp = null;
        this.f5063AcNBzu = null;
        this.f5072B9tovu = null;
        this.f5065AmA8tU = null;
        this.f5067B25kr6 = null;
        this.f5066AzWtSf = null;
        this.f5071B7CMnp = null;
        this.f5073BChYOn = null;
        this.f5074BI9f7h = null;
        this.f5076BJ7GGh.clear();
        super.onDestroyView();
        if (getActivity() != null) {
            BmvVmW bmvVmW = ((MainActivity) getActivity()).f11066B4ZgIw;
            bmvVmW.f5056A2egSU = true;
            androidx.activity.B7CMnp b7CMnp = bmvVmW.f5058A5SV6n;
            if (b7CMnp != null) {
                b7CMnp.invoke();
            }
        }
    }

    @Override // LCJm5h.AMqCpz
    public final void onError(String str) {
        Toast.makeText(getActivity(), str, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        LLiCI0.AMqCpz aMqCpz;
        LLiCI0.A4TApA a4TApA;
        super.onPause();
        this.f5084C4FrIb = false;
        LLiCI0.ARc23Z aRc23Z = this.f5074BI9f7h;
        if (aRc23Z == null || (aMqCpz = aRc23Z.f4683AlLFFp) == null || (a4TApA = aMqCpz.f4680AmA8tU) == null) {
            return;
        }
        a4TApA.f4675ADYaiT = false;
        a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        AZkASS(false);
        B7CMnp();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        L2suez.AaHO0E aaHO0E;
        super.onSaveInstanceState(bundle);
        LinearLayoutManager linearLayoutManager = this.f5073BChYOn;
        if (linearLayoutManager == null || (aaHO0E = this.f5068B2KMhB) == null) {
            return;
        }
        aaHO0E.f4370ARc23Z = linearLayoutManager.onSaveInstanceState();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5084C4FrIb = false;
        this.BpkvW3 = new I3HV03.A4TApA(requireActivity(), (String) null);
        this.f5068B2KMhB = (L2suez.AaHO0E) new DUi7mC(getActivity()).AlLFFp(L2suez.AaHO0E.class);
        this.f5070B4ZgIw = (SwipeRefreshLayout) view.findViewById(2131298041);
        int A4TApA2 = L2suez.B9tovu.A4TApA(requireActivity(), R.attr.colorPrimary);
        int A4TApA3 = L2suez.B9tovu.A4TApA(requireActivity(), R.attr.colorSecondary);
        this.f5070B4ZgIw.setColorSchemeColors(A4TApA2, A4TApA3, A4TApA3, L2suez.B9tovu.A4TApA(requireActivity(), R.attr.colorError));
        this.f5064AlLFFp = (SearchBar) view.findViewById(2131296475);
        this.f5063AcNBzu = (SearchView) view.findViewById(2131296476);
        this.f5072B9tovu = (RecyclerView) view.findViewById(2131297796);
        this.f5065AmA8tU = (RecyclerView) view.findViewById(2131297794);
        this.f5067B25kr6 = (TextView) view.findViewById(2131296625);
        SearchBar searchBar = this.f5064AlLFFp;
        SearchView searchView = this.f5063AcNBzu;
        searchBar.setOnMenuItemClickListener(new B7CMnp(this));
        searchView.getEditText().addTextChangedListener(new BTvldC(this));
        searchView.getEditText().setOnEditorActionListener(new BV3sI0(this, searchView, searchBar));
        this.f5075BIYEnU = new BmvVmW(0, searchView);
        requireActivity().getOnBackPressedDispatcher().A2egSU(getViewLifecycleOwner(), this.f5075BIYEnU);
        searchView.f11778BniPrB.add(new B3GDIM(this));
        FragmentActivity activity = getActivity();
        LLiCI0.BJ7GGh bJ7GGh = new LLiCI0.BJ7GGh();
        bJ7GGh.f4740AzWtSf = false;
        bJ7GGh.f4741B25kr6 = 1;
        bJ7GGh.f4739AmA8tU = activity;
        bJ7GGh.f4738AlLFFp = this;
        bJ7GGh.f4737AcNBzu = new ArrayList();
        this.f5066AzWtSf = bJ7GGh;
        this.f5065AmA8tU.setHasFixedSize(true);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        this.f5073BChYOn = linearLayoutManager;
        this.f5072B9tovu.setLayoutManager(linearLayoutManager);
        this.f5072B9tovu.setHasFixedSize(true);
        this.f5071B7CMnp = new LLiCI0.CcAIMM(requireActivity(), this.f5068B2KMhB.AMqCpz, new B7CMnp(this));
        this.f5072B9tovu.addOnScrollListener(new BNL6CD(this));
        this.f5072B9tovu.setAdapter(this.f5071B7CMnp);
        this.f5065AmA8tU.addOnScrollListener(new BPw6Q8(this));
        LLiCI0.ARc23Z aRc23Z = new LLiCI0.ARc23Z();
        this.f5074BI9f7h = aRc23Z;
        this.f5065AmA8tU.setAdapter(new androidx.recyclerview.widget.ASJ6gh(aRc23Z, this.f5066AzWtSf));
        B2KMhB(this.BpkvW3.AzWtSf("list_grid"));
        this.f5070B4ZgIw.setOnRefreshListener(new BJ7GGh(this));
        AzWtSf();
        DG07BK.A5SV6n.A2egSU(requireActivity()).registerReceiver(this.f5085CASmeH, new IntentFilter("com.game.boy.DOWNLOAD_UPDATE"));
    }
}
