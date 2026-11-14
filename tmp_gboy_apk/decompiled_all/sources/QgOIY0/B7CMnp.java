package QgOIY0;

import ADYaiT.CtFAbx;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class B7CMnp extends AlLFFp {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f7600AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f7601B25kr6;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f7604B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f7605B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public QkAq4X.AZOQYO f7606B9tovu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DG07BK.A2egSU f7598AlLFFp = new DG07BK.A2egSU(this);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final IQ76hF.AmA8tU f7599AmA8tU = new IQ76hF.AmA8tU(27, new B3GDIM(this));

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f7602B2KMhB = true;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f7603B3GDIM = true;

    public static void A4TApA(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        String str2;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        int visibility = view.getVisibility();
        if (visibility == 0) {
            sb.append('V');
        } else if (visibility == 4) {
            sb.append('I');
        } else if (visibility != 8) {
            sb.append('.');
        } else {
            sb.append('G');
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : '.');
        sb.append(view.isSelected() ? 'S' : '.');
        sb.append(view.isPressed() ? 'P' : '.');
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append(Soundex.SILENT_MARKER);
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                int i = (-16777216) & id;
                if (i == 16777216) {
                    str2 = "android";
                } else if (i != 2130706432) {
                    try {
                        str2 = resources.getResourcePackageName(id);
                    } catch (Resources.NotFoundException unused) {
                    }
                } else {
                    str2 = PointCategory.APP;
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                sb.append(" ");
                sb.append(str2);
                sb.append(":");
                sb.append(resourceTypeName);
                sb.append("/");
                sb.append(resourceEntryName);
            }
        }
        sb.append("}");
        printWriter.println(sb.toString());
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        String AcNBzu2 = CtFAbx.AcNBzu(str, "  ");
        for (int i2 = 0; i2 < childCount; i2++) {
            A4TApA(AcNBzu2, printWriter, viewGroup.getChildAt(i2));
        }
    }

    public final void A5SV6n(boolean z) {
        boolean z2 = this.f7603B3GDIM;
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        if (z2) {
            if (z) {
                amA8tU.B9tovu();
                B3GDIM b3gdim = (B3GDIM) amA8tU.f3956AlLFFp;
                b3gdim.f7591ARc23Z = true;
                CcAIMM ccAIMM = b3gdim.f7592ASJ6gh;
                if (ccAIMM != null && b3gdim.f7594AZOQYO) {
                    b3gdim.f7594AZOQYO = false;
                    ccAIMM.AMqCpz();
                    return;
                }
                return;
            }
            return;
        }
        this.f7603B3GDIM = true;
        this.f7604B4ZgIw = z;
        this.f7598AlLFFp.removeMessages(1);
        boolean z3 = this.f7604B4ZgIw;
        B3GDIM b3gdim2 = (B3GDIM) amA8tU.f3956AlLFFp;
        b3gdim2.f7591ARc23Z = z3;
        CcAIMM ccAIMM2 = b3gdim2.f7592ASJ6gh;
        if (ccAIMM2 != null && b3gdim2.f7594AZOQYO) {
            b3gdim2.f7594AZOQYO = false;
            if (z3) {
                ccAIMM2.AMqCpz();
            } else {
                ccAIMM2.ADYaiT();
            }
        }
        BNL6CD bnl6cd = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd.f7612A5SV6n = true;
        bnl6cd.A2egSU(2, false);
        bnl6cd.f7612A5SV6n = false;
    }

    public final int ADYaiT(B2KMhB b2KMhB) {
        if (this.f7606B9tovu.A4TApA() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (true) {
            QkAq4X.AZOQYO azoqyo = this.f7606B9tovu;
            int i = this.f7605B7CMnp;
            if (azoqyo.f7754AcNBzu) {
                azoqyo.ARc23Z();
            }
            if (QkAq4X.ADYaiT.A2egSU(azoqyo.f7757AzWtSf, i, azoqyo.f7755AlLFFp) < 0) {
                int i2 = this.f7605B7CMnp;
                this.f7606B9tovu.A5SV6n(i2, b2KMhB.f7575CNPG0E);
                this.f7605B7CMnp = (this.f7605B7CMnp + 1) % 65534;
                return i2;
            }
            this.f7605B7CMnp = (this.f7605B7CMnp + 1) % 65534;
        }
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f7600AzWtSf);
        printWriter.print("mResumed=");
        printWriter.print(this.f7601B25kr6);
        printWriter.print(" mStopped=");
        printWriter.print(this.f7602B2KMhB);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f7603B3GDIM);
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        B3GDIM b3gdim = (B3GDIM) amA8tU.f3956AlLFFp;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(b3gdim.f7594AZOQYO);
        if (b3gdim.f7592ASJ6gh != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(b3gdim.f7592ASJ6gh)));
            printWriter.println(":");
            b3gdim.f7592ASJ6gh.A2egSU(str2 + "  ", printWriter);
        }
        ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.AZOQYO(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        A4TApA(str + "  ", printWriter, getWindow().getDecorView());
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        B2KMhB B9tovu2;
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.f7623AzWtSf = false;
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        String str = (String) this.f7606B9tovu.A2egSU(i4);
        this.f7606B9tovu.ADYaiT(i4);
        if (str == null || (B9tovu2 = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.B9tovu(str)) == null) {
            return;
        }
        B9tovu2.getClass();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        BNL6CD bnl6cd = ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd.CtFAbx();
        bnl6cd.CNPG0E();
        bnl6cd.BmvVmW();
        boolean AcNBzu2 = bnl6cd.AcNBzu(bnl6cd.f7627B4ZgIw, bnl6cd.f7628B7CMnp, -1, 0);
        if (AcNBzu2) {
            bnl6cd.f7612A5SV6n = true;
            try {
                bnl6cd.BI9f7h(bnl6cd.f7627B4ZgIw, bnl6cd.f7628B7CMnp);
            } finally {
                bnl6cd.D07BeM();
            }
        }
        bnl6cd.COJEAR();
        if (AcNBzu2) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.AmA8tU();
    }

    @Override // QgOIY0.AlLFFp, android.app.Activity
    public void onCreate(Bundle bundle) {
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        B3GDIM b3gdim = (B3GDIM) amA8tU.f3956AlLFFp;
        BNL6CD bnl6cd = b3gdim.f7589A5SV6n;
        if (bnl6cd.f7620AcNBzu != null) {
            throw new IllegalStateException("Already attached");
        }
        bnl6cd.f7620AcNBzu = b3gdim;
        bnl6cd.f7621AlLFFp = b3gdim;
        bnl6cd.f7622AmA8tU = null;
        super.onCreate(bundle);
        B4ZgIw b4ZgIw = (B4ZgIw) getLastNonConfigurationInstance();
        B3GDIM b3gdim2 = (B3GDIM) amA8tU.f3956AlLFFp;
        if (b4ZgIw != null) {
            QkAq4X.AYUAbz aYUAbz = b4ZgIw.f7597A4TApA;
            if (aYUAbz != null) {
                int i = aYUAbz.f7752AmA8tU;
                for (int i2 = 0; i2 < i; i2++) {
                    ((CcAIMM) aYUAbz.ARc23Z(i2)).f7704ASJ6gh = b3gdim2;
                }
            }
            b3gdim2.AMqCpz = aYUAbz;
        }
        if (bundle != null) {
            b3gdim2.f7589A5SV6n.ARc23Z(bundle.getParcelable("android:support:fragments"), b4ZgIw != null ? b4ZgIw.f7596A2egSU : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f7605B7CMnp = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.f7606B9tovu = new QkAq4X.AZOQYO(intArray.length);
                    for (int i3 = 0; i3 < intArray.length; i3++) {
                        this.f7606B9tovu.A5SV6n(intArray[i3], stringArray[i3]);
                    }
                }
            }
        }
        if (this.f7606B9tovu == null) {
            this.f7606B9tovu = new QkAq4X.AZOQYO();
            this.f7605B7CMnp = 0;
        }
        BNL6CD bnl6cd2 = b3gdim2.f7589A5SV6n;
        bnl6cd2.f7623AzWtSf = false;
        bnl6cd2.f7612A5SV6n = true;
        bnl6cd2.A2egSU(1, false);
        bnl6cd2.f7612A5SV6n = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        return onCreatePanelMenu | ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.AzWtSf();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        A5SV6n(false);
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.CqNSpT();
        CcAIMM ccAIMM = ((B3GDIM) amA8tU.f3956AlLFFp).f7592ASJ6gh;
        if (ccAIMM == null) {
            return;
        }
        ccAIMM.ASJ6gh();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.CrfGsy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        if (i == 0) {
            return ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.B25kr6();
        }
        if (i != 6) {
            return false;
        }
        return ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.BJ7GGh();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.B4ZgIw();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.f7623AzWtSf = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.BChYOn();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f7601B25kr6 = false;
        DG07BK.A2egSU a2egSU = this.f7598AlLFFp;
        boolean hasMessages = a2egSU.hasMessages(2);
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        if (hasMessages) {
            a2egSU.removeMessages(2);
            BNL6CD bnl6cd = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
            bnl6cd.f7623AzWtSf = false;
            bnl6cd.f7612A5SV6n = true;
            bnl6cd.A2egSU(5, false);
            bnl6cd.f7612A5SV6n = false;
        }
        BNL6CD bnl6cd2 = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd2.f7612A5SV6n = true;
        bnl6cd2.A2egSU(4, false);
        bnl6cd2.f7612A5SV6n = false;
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.BV3sI0();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        this.f7598AlLFFp.removeMessages(2);
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        BNL6CD bnl6cd = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd.f7623AzWtSf = false;
        bnl6cd.f7612A5SV6n = true;
        bnl6cd.A2egSU(5, false);
        bnl6cd.f7612A5SV6n = false;
        ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.CNPG0E();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : super.onPreparePanel(0, view, menu) | ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.AlLFFp();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f7606B9tovu.A2egSU(i3);
            this.f7606B9tovu.ADYaiT(i3);
            if (str == null) {
                return;
            }
            ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.B9tovu(str);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f7598AlLFFp.sendEmptyMessage(2);
        this.f7601B25kr6 = true;
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.CNPG0E();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.f7602B2KMhB) {
            A5SV6n(true);
        }
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        BPw6Q8 CcAIMM2 = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n.CcAIMM();
        B3GDIM b3gdim = (B3GDIM) amA8tU.f3956AlLFFp;
        QkAq4X.AYUAbz aYUAbz = b3gdim.AMqCpz;
        boolean z = false;
        if (aYUAbz != null) {
            int i = aYUAbz.f7752AmA8tU;
            CcAIMM[] ccAIMMArr = new CcAIMM[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                ccAIMMArr[i2] = (CcAIMM) b3gdim.AMqCpz.ARc23Z(i2);
            }
            boolean z2 = b3gdim.f7591ARc23Z;
            for (int i3 = 0; i3 < i; i3++) {
                CcAIMM ccAIMM = ccAIMMArr[i3];
                if (!ccAIMM.AMqCpz && z2) {
                    if (!ccAIMM.f7702ADYaiT) {
                        ccAIMM.A5SV6n();
                    }
                    ccAIMM.AMqCpz();
                }
                if (ccAIMM.AMqCpz) {
                    z = true;
                } else {
                    ccAIMM.ASJ6gh();
                    b3gdim.AMqCpz.remove(ccAIMM.f7701A5SV6n);
                }
            }
        }
        QkAq4X.AYUAbz aYUAbz2 = z ? b3gdim.AMqCpz : null;
        if (CcAIMM2 == null && aYUAbz2 == null) {
            return null;
        }
        B4ZgIw b4ZgIw = new B4ZgIw();
        b4ZgIw.f7596A2egSU = CcAIMM2;
        b4ZgIw.f7597A4TApA = aYUAbz2;
        return b4ZgIw;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BTvldC CikNvS2 = ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.CikNvS();
        if (CikNvS2 != null) {
            bundle.putParcelable("android:support:fragments", CikNvS2);
        }
        if (this.f7606B9tovu.A4TApA() > 0) {
            bundle.putInt("android:support:next_request_index", this.f7605B7CMnp);
            int[] iArr = new int[this.f7606B9tovu.A4TApA()];
            String[] strArr = new String[this.f7606B9tovu.A4TApA()];
            for (int i = 0; i < this.f7606B9tovu.A4TApA(); i++) {
                iArr[i] = this.f7606B9tovu.AMqCpz(i);
                strArr[i] = (String) this.f7606B9tovu.ASJ6gh(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f7602B2KMhB = false;
        this.f7603B3GDIM = false;
        this.f7598AlLFFp.removeMessages(1);
        boolean z = this.f7600AzWtSf;
        IQ76hF.AmA8tU amA8tU = this.f7599AmA8tU;
        if (!z) {
            this.f7600AzWtSf = true;
            BNL6CD bnl6cd = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
            bnl6cd.f7623AzWtSf = false;
            bnl6cd.f7612A5SV6n = true;
            bnl6cd.A2egSU(2, false);
            bnl6cd.f7612A5SV6n = false;
        }
        BNL6CD bnl6cd2 = ((B3GDIM) amA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd2.f7623AzWtSf = false;
        bnl6cd2.CNPG0E();
        amA8tU.B9tovu();
        B3GDIM b3gdim = (B3GDIM) amA8tU.f3956AlLFFp;
        BNL6CD bnl6cd3 = b3gdim.f7589A5SV6n;
        bnl6cd3.f7623AzWtSf = false;
        bnl6cd3.f7612A5SV6n = true;
        bnl6cd3.A2egSU(4, false);
        bnl6cd3.f7612A5SV6n = false;
        QkAq4X.AYUAbz aYUAbz = b3gdim.AMqCpz;
        if (aYUAbz != null) {
            int i = aYUAbz.f7752AmA8tU;
            CcAIMM[] ccAIMMArr = new CcAIMM[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                ccAIMMArr[i2] = (CcAIMM) b3gdim.AMqCpz.ARc23Z(i2);
            }
            for (int i3 = 0; i3 < i; i3++) {
                CcAIMM ccAIMM = ccAIMMArr[i3];
                if (ccAIMM.AMqCpz) {
                    ccAIMM.AMqCpz = false;
                    QkAq4X.AZOQYO azoqyo = ccAIMM.f7699A2egSU;
                    for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
                        CTkVKb cTkVKb = (CTkVKb) azoqyo.ASJ6gh(A4TApA2);
                        if (cTkVKb.f7693ASJ6gh) {
                            cTkVKb.f7693ASJ6gh = false;
                            boolean z2 = cTkVKb.f7692ARc23Z;
                            if (z2 != cTkVKb.f7694AYUAbz && !z2) {
                                cTkVKb.ADYaiT();
                            }
                        }
                        if (cTkVKb.f7692ARc23Z && cTkVKb.f7690A5SV6n && !cTkVKb.f7695AZOQYO) {
                            cTkVKb.A5SV6n(cTkVKb.AMqCpz);
                        }
                    }
                }
                ccAIMM.ARc23Z();
            }
        }
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n.f7623AzWtSf = false;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f7602B2KMhB = true;
        this.f7598AlLFFp.sendEmptyMessage(1);
        BNL6CD bnl6cd = ((B3GDIM) this.f7599AmA8tU.f3956AlLFFp).f7589A5SV6n;
        bnl6cd.f7623AzWtSf = true;
        bnl6cd.f7612A5SV6n = true;
        bnl6cd.A2egSU(3, false);
        bnl6cd.f7612A5SV6n = false;
    }

    @Override // QgOIY0.AlLFFp, android.app.Activity
    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.f7534AcNBzu && i != -1) {
            AlLFFp.A2egSU(i);
        }
        super.startActivityForResult(intent, i);
    }
}
