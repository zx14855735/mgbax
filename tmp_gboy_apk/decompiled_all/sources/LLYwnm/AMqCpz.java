package LLYwnm;

import LLiCI0.B3GDIM;
import MOpbMP.B4ZgIw;
import MOpbMP.BpkvW3;
import MOpbMP.C2rE4F;
import MOpbMP.COJEAR;
import MOpbMP.CTkVKb;
import Mm8v1u.BI9f7h;
import NGepWW.DuwtYk;
import QgOIY0.BNL6CD;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.BChYOn;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.game.boy.MyApp;
import com.game.boy.activity.DeviceActivity;
import com.game.boy.activity.DownLoadActivity;
import com.game.boy.activity.KeyMappingSettings;
import com.game.boy.service.FileService;
import com.game.boy.viewUi.AutoSaveTextInputEditText;
import com.game.boy.viewUi.BadgedMaterialCardView;
import com.game.boy.viewUi.Material3AutoCompleteTextView;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4618AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f4619AlLFFp;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f4618AcNBzu = i;
        this.f4619AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewPager2 viewPager2;
        LinearLayoutManager linearLayoutManager;
        PreferenceCategory preferenceCategory;
        int i = 1;
        switch (this.f4618AcNBzu) {
            case 0:
                ((LHpdLt.A4TApA) this.f4619AlLFFp).getClass();
                MyApp.A2egSU("消息为 null");
                return;
            case 1:
                ((B25kr6) this.f4619AlLFFp).A5SV6n("token 未设置");
                return;
            case 2:
                ((B25kr6) ((AZOQYO.ARc23Z) this.f4619AlLFFp).f363AcNBzu).ADYaiT();
                return;
            case 3:
                if (((AcNBzu) this.f4619AlLFFp).f4644AZkASS || ((AcNBzu) this.f4619AlLFFp).f4645AaHO0E) {
                    return;
                }
                ((AcNBzu) this.f4619AlLFFp).A4TApA();
                return;
            case 4:
                LLiCI0.A4TApA a4TApA = (LLiCI0.A4TApA) this.f4619AlLFFp;
                if (a4TApA.f4675ADYaiT && (viewPager2 = a4TApA.f4672A2egSU) != null) {
                    if (viewPager2.isShown() && viewPager2.getWindowVisibility() == 0 && viewPager2.getWindowToken() != null) {
                        Rect rect = a4TApA.AMqCpz;
                        rect.setEmpty();
                        if (viewPager2.getGlobalVisibleRect(rect)) {
                            int height = rect.height() * rect.width();
                            int height2 = viewPager2.getHeight() * viewPager2.getWidth();
                            if (height2 > 0 && height > height2 / 2) {
                                if ((viewPager2.getAdapter() != null ? viewPager2.getAdapter().getItemCount() : 0) > 1) {
                                    viewPager2.A4TApA(viewPager2.getCurrentItem() + 1, true);
                                }
                            }
                        }
                    }
                    a4TApA.f4673A4TApA.postDelayed(this, a4TApA.f4674A5SV6n);
                    return;
                }
                return;
            case 5:
                LLiCI0.AlLFFp alLFFp = (LLiCI0.AlLFFp) this.f4619AlLFFp;
                if (alLFFp.f4699AlLFFp.isAttachedToWindow()) {
                    LLiCI0.AzWtSf.A2egSU(alLFFp.f4698AcNBzu + 1, alLFFp.f4699AlLFFp, alLFFp.f4700AmA8tU);
                    return;
                }
                return;
            case 6:
                MOpbMP.ADYaiT aDYaiT = (MOpbMP.ADYaiT) this.f4619AlLFFp;
                MaterialButton materialButton = aDYaiT.f4993AlLFFp.f4999B3GDIM;
                if (materialButton != null) {
                    materialButton.setEnabled(true);
                    aDYaiT.f4993AlLFFp.f4999B3GDIM.setText("获取验证码");
                    return;
                }
                return;
            case 7:
                MOpbMP.AZkASS aZkASS = (MOpbMP.AZkASS) this.f4619AlLFFp;
                BluetoothAdapter bluetoothAdapter = aZkASS.f5020AcNBzu;
                if (bluetoothAdapter == null || bluetoothAdapter.isDiscovering()) {
                    return;
                }
                aZkASS.f5020AcNBzu.startDiscovery();
                return;
            case 8:
                BpkvW3 bpkvW3 = ((B4ZgIw) this.f4619AlLFFp).f5038AcNBzu;
                if (!bpkvW3.isAdded() || bpkvW3.getView() == null) {
                    return;
                }
                bpkvW3.B3GDIM();
                SwipeRefreshLayout swipeRefreshLayout = bpkvW3.f5070B4ZgIw;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                bpkvW3.AlLFFp();
                Parcelable parcelable = bpkvW3.f5068B2KMhB.f4370ARc23Z;
                if (parcelable != null && (linearLayoutManager = bpkvW3.f5073BChYOn) != null) {
                    linearLayoutManager.onRestoreInstanceState(parcelable);
                    bpkvW3.f5068B2KMhB.f4370ARc23Z = null;
                }
                if (BpkvW3.f5062CNPG0E.isEmpty()) {
                    bpkvW3.B4ZgIw(true);
                } else {
                    bpkvW3.B4ZgIw(false);
                }
                bpkvW3.B7CMnp();
                return;
            case 9:
                BpkvW3 bpkvW32 = (BpkvW3) this.f4619AlLFFp;
                if (!bpkvW32.isAdded() || bpkvW32.getView() == null) {
                    return;
                }
                bpkvW32.B7CMnp();
                return;
            case 10:
                MOpbMP.A2egSU a2egSU = (MOpbMP.A2egSU) this.f4619AlLFFp;
                PreferenceScreen preferenceScreen = (PreferenceScreen) a2egSU.f4986AlLFFp;
                C2rE4F c2rE4F = (C2rE4F) a2egSU.f4987AmA8tU;
                c2rE4F.f5087B9tovu.AZOQYO(preferenceScreen, 0, c2rE4F.f5089BI9f7h[0]);
                int i2 = 0;
                while (true) {
                    int[] iArr = c2rE4F.f5088BChYOn;
                    if (i2 >= iArr.length) {
                        KeyMappingSettings keyMappingSettings = c2rE4F.f5087B9tovu;
                        int[] AZkASS2 = KeyMappingSettings.AZkASS(keyMappingSettings.f11049B2KMhB);
                        while (r3 < AZkASS2.length) {
                            keyMappingSettings.f11050B3GDIM[r3].BmvVmW(AZkASS2[r3]);
                            r3++;
                        }
                        return;
                    }
                    int i3 = iArr[i2];
                    HashMap hashMap = c2rE4F.f5086B7CMnp;
                    if (hashMap.containsKey(Integer.valueOf(i2))) {
                        preferenceCategory = (PreferenceCategory) hashMap.get(Integer.valueOf(i2));
                    } else {
                        PreferenceCategory preferenceCategory2 = new PreferenceCategory(c2rE4F.getActivity(), null);
                        preferenceCategory2.BPw6Q8(i3);
                        hashMap.put(Integer.valueOf(i2), preferenceCategory2);
                        preferenceCategory = preferenceCategory2;
                    }
                    preferenceScreen.BmvVmW(preferenceCategory);
                    KeyMappingSettings keyMappingSettings2 = c2rE4F.f5087B9tovu;
                    int[] iArr2 = c2rE4F.f5089BI9f7h;
                    int i4 = iArr2[i2];
                    i2++;
                    keyMappingSettings2.AZOQYO(preferenceCategory, i4, iArr2[i2]);
                }
            case 11:
                CTkVKb cTkVKb = ((COJEAR) this.f4619AlLFFp).f5093AmA8tU.f5107B2KMhB;
                if (cTkVKb.getActivity() != null) {
                    Toast.makeText(cTkVKb.getActivity(), 2131886777, 0).show();
                    return;
                }
                return;
            case 12:
                ((Mi9UWv.ASJ6gh) this.f4619AlLFFp).f5405B2KMhB.setRefreshing(false);
                return;
            case 13:
                try {
                    Thread.sleep(PushUIConfig.dismissTime);
                    ((Process) this.f4619AlLFFp).destroy();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 14:
                FileService fileService = (FileService) ((AZkASS.ARc23Z) this.f4619AlLFFp).f451AlLFFp;
                boolean z = FileService.f11116AzWtSf;
                fileService.ARc23Z();
                return;
            case 15:
                int i5 = AutoSaveTextInputEditText.f11142BI9f7h;
                ((AutoSaveTextInputEditText) this.f4619AlLFFp).A4TApA();
                return;
            case 16:
                BadgedMaterialCardView badgedMaterialCardView = (BadgedMaterialCardView) this.f4619AlLFFp;
                badgedMaterialCardView.f11146BNL6CD.invalidate();
                badgedMaterialCardView.f11146BNL6CD.requestLayout();
                badgedMaterialCardView.invalidate();
                badgedMaterialCardView.requestLayout();
                return;
            case 17:
                try {
                    View view = (View) ((Material3AutoCompleteTextView) this.f4619AlLFFp).getParent();
                    if (view instanceof TextInputLayout) {
                        TextInputLayout textInputLayout = (TextInputLayout) view;
                        textInputLayout.setEndIconOnClickListener(new BI9f7h(this, r3));
                        textInputLayout.setOnClickListener(new BI9f7h(this, i));
                        textInputLayout.setClickable(true);
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            case 18:
                NGepWW.A4TApA a4TApA2 = (NGepWW.A4TApA) this.f4619AlLFFp;
                ReentrantLock reentrantLock = a4TApA2.f5670AlLFFp;
                ReentrantLock reentrantLock2 = a4TApA2.f5670AlLFFp;
                reentrantLock.lock();
                try {
                    NGepWW.A4TApA.ARc23Z(a4TApA2);
                    return;
                } finally {
                    reentrantLock2.unlock();
                }
            case 19:
                DuwtYk duwtYk = (DuwtYk) this.f4619AlLFFp;
                RevocationBoundService revocationBoundService = duwtYk.f5755AmA8tU;
                duwtYk.f5756AzWtSf.getClass();
                if (NOd7IU.AMqCpz.f5864A5SV6n.getAndSet(true)) {
                    return;
                }
                try {
                    NotificationManager notificationManager = (NotificationManager) revocationBoundService.getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.cancel(10436);
                        return;
                    }
                    return;
                } catch (SecurityException unused3) {
                    return;
                }
            case 20:
                IzHBwY.A4TApA a4TApA3 = (IzHBwY.A4TApA) this.f4619AlLFFp;
                a4TApA3.f4105A5SV6n = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) a4TApA3.AMqCpz;
                CqNSpT.ARc23Z aRc23Z = bottomSheetBehavior.f11428D6yqiO;
                if (aRc23Z != null && aRc23Z.ASJ6gh()) {
                    a4TApA3.A2egSU(a4TApA3.f4104A4TApA);
                    return;
                } else {
                    if (bottomSheetBehavior.f11427D6DOie == 2) {
                        bottomSheetBehavior.B2KMhB(a4TApA3.f4104A4TApA);
                        return;
                    }
                    return;
                }
            case 21:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f4619AlLFFp).f11909AmA8tU.f7334B3GDIM;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 22:
                ((BNL6CD) this.f4619AlLFFp).CNPG0E();
                return;
            case 23:
                QgOIY0.AMqCpz.AmA8tU((ArrayList) this.f4619AlLFFp, 4);
                return;
            case 24:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
            case 25:
                androidx.viewpager.widget.AlLFFp alLFFp2 = (androidx.viewpager.widget.AlLFFp) this.f4619AlLFFp;
                alLFFp2.setScrollState(0);
                alLFFp2.populate();
                return;
            case 26:
                androidx.viewpager2.adapter.AYUAbz aYUAbz = (androidx.viewpager2.adapter.AYUAbz) this.f4619AlLFFp;
                aYUAbz.f9561B4ZgIw = false;
                aYUAbz.A5SV6n();
                return;
            case 27:
                com.bumptech.glide.AzWtSf azWtSf = (com.bumptech.glide.AzWtSf) this.f4619AlLFFp;
                azWtSf.f9950AmA8tU.ASJ6gh(azWtSf);
                return;
            case 28:
                int i6 = DeviceActivity.f10961BNL6CD;
                DeviceActivity deviceActivity = (DeviceActivity) this.f4619AlLFFp;
                deviceActivity.AZOQYO();
                deviceActivity.f10970BIYEnU.postDelayed(this, 1000L);
                return;
            default:
                DownLoadActivity downLoadActivity = (DownLoadActivity) ((com.game.boy.activity.ASJ6gh) this.f4619AlLFFp).f10894AlLFFp;
                if (downLoadActivity.isFinishing()) {
                    return;
                }
                B3GDIM b3gdim = downLoadActivity.f10975B3GDIM;
                ArrayList arrayList = downLoadActivity.f10976B4ZgIw;
                androidx.recyclerview.widget.B3GDIM A2egSU2 = BChYOn.A2egSU(new LLiCI0.B25kr6(b3gdim.f4716AcNBzu, arrayList));
                b3gdim.f4716AcNBzu = new ArrayList(arrayList);
                A2egSU2.A2egSU(b3gdim);
                downLoadActivity.f10974B2KMhB.setRefreshing(false);
                return;
        }
    }

    public AMqCpz(AZOQYO.ARc23Z aRc23Z, String str) {
        this.f4618AcNBzu = 2;
        this.f4619AlLFFp = aRc23Z;
    }
}
