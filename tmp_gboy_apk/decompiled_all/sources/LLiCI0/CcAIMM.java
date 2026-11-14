package LLiCI0;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.view.MarqueeTextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CcAIMM extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final FragmentActivity f4786AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final COJEAR f4787AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f4788AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f4789AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Set f4790B25kr6 = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ExecutorService f4791B2KMhB = Executors.newSingleThreadExecutor();

    public CcAIMM(FragmentActivity fragmentActivity, ArrayList arrayList, COJEAR cojear) {
        this.f4788AmA8tU = new ArrayList();
        this.f4786AcNBzu = fragmentActivity;
        this.f4788AmA8tU = arrayList;
        this.f4787AlLFFp = cojear;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6 A[Catch: all -> 0x00ca, IOException -> 0x00cd, LOOP:0: B:21:0x00bf->B:23:0x00c6, LOOP_END, TryCatch #13 {IOException -> 0x00cd, all -> 0x00ca, blocks: (B:20:0x00bd, B:21:0x00bf, B:23:0x00c6, B:25:0x00d0), top: B:19:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0106 A[Catch: IOException -> 0x0102, TRY_LEAVE, TryCatch #11 {IOException -> 0x0102, blocks: (B:51:0x00fe, B:44:0x0106), top: B:50:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A2egSU(LLiCI0.CcAIMM r6, java.io.File r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LLiCI0.CcAIMM.A2egSU(LLiCI0.CcAIMM, java.io.File, java.lang.String):void");
    }

    public static String A4TApA(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format(Locale.ROOT, "%02X", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static boolean A5SV6n(File file) {
        FileInputStream fileInputStream;
        boolean z = false;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[12];
            if (fileInputStream.read(bArr) != 12) {
                fileInputStream.close();
                return false;
            }
            String str = new String(bArr, 0, 4);
            String str2 = new String(bArr, 8, 4);
            if ("RIFF".equals(str)) {
                if ("WEBP".equals(str2)) {
                    z = true;
                }
            }
            try {
                fileInputStream.close();
                return z;
            } catch (IOException e3) {
                e3.printStackTrace();
                return z;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public final void ADYaiT(String str, String str2) {
        File A2egSU2 = L2suez.B9tovu.A2egSU("GBoy/image");
        if (!A2egSU2.exists()) {
            A2egSU2.mkdirs();
        }
        File file = null;
        if (A2egSU2.exists()) {
            String[] strArr = L2suez.B9tovu.f4390A2egSU;
            int i = 0;
            while (true) {
                if (i >= 6) {
                    break;
                }
                File file2 = new File(A2egSU2, CtFAbx.AcNBzu(str2, strArr[i]));
                if (file2.exists()) {
                    file = file2;
                    break;
                }
                i++;
            }
        }
        if (file != null) {
            file.getName();
            return;
        }
        Set set = this.f4790B25kr6;
        if (set.contains(str)) {
            return;
        }
        set.add(str);
        this.f4791B2KMhB.execute(new C4FrIb.B4ZgIw(9, this, str, str2));
    }

    public final void AMqCpz(L5dZB6.A4TApA a4TApA) {
        ArrayList arrayList = this.f4788AmA8tU;
        try {
            int parseInt = Integer.parseInt(a4TApA.f4392AcNBzu);
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof MTKlkd.ARc23Z) {
                    MTKlkd.ARc23Z aRc23Z = (MTKlkd.ARc23Z) obj;
                    if (aRc23Z.A4TApA() == parseInt) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("status");
                        aRc23Z.B3GDIM(a4TApA.f4400B7CMnp);
                        aRc23Z.B25kr6(a4TApA.f4399B4ZgIw);
                        arrayList.set(i, aRc23Z);
                        if (arrayList2.isEmpty()) {
                            return;
                        }
                        notifyItemChanged(i, arrayList2);
                        return;
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4788AmA8tU.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        return this.f4788AmA8tU.get(i) instanceof CTkVKb ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i, List list) {
        if (list.isEmpty()) {
            onBindViewHolder(dphsd2, i);
            return;
        }
        if (dphsd2 instanceof CSDoyG) {
            CSDoyG cSDoyG = (CSDoyG) dphsd2;
            if (!list.isEmpty() && (list.get(0) instanceof String) && "MARQUEE_STATE".equals(list.get(0))) {
                cSDoyG.f4778AlLFFp.setMarqueeEnabled(!this.f4789AzWtSf);
                return;
            }
            MTKlkd.ARc23Z aRc23Z = (MTKlkd.ARc23Z) this.f4788AmA8tU.get(i);
            cSDoyG.getClass();
            for (Object obj : list) {
                if (obj instanceof List) {
                    for (Object obj2 : (List) obj) {
                        if ((obj2 instanceof String) && "status".equals((String) obj2)) {
                            cSDoyG.A2egSU(aRc23Z);
                        }
                    }
                } else if ((obj instanceof String) && "status".equals((String) obj)) {
                    cSDoyG.A2egSU(aRc23Z);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        FragmentActivity fragmentActivity = this.f4786AcNBzu;
        return i == 0 ? new CNPG0E(LayoutInflater.from(fragmentActivity).inflate(2131492914, viewGroup, false)) : new CSDoyG(this, LayoutInflater.from(fragmentActivity).inflate(2131492977, viewGroup, false), this.f4787AlLFFp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        boolean z = dphsd2 instanceof CNPG0E;
        ArrayList arrayList = this.f4788AmA8tU;
        if (z) {
            CNPG0E cnpg0e = (CNPG0E) dphsd2;
            CTkVKb cTkVKb = (CTkVKb) arrayList.get(i);
            cnpg0e.getClass();
            cnpg0e.f4774AcNBzu.setText(cTkVKb.f4785A2egSU);
            return;
        }
        if (dphsd2 instanceof CSDoyG) {
            CSDoyG cSDoyG = (CSDoyG) dphsd2;
            MTKlkd.ARc23Z aRc23Z = (MTKlkd.ARc23Z) arrayList.get(i);
            cSDoyG.itemView.setTag(aRc23Z);
            cSDoyG.f4781B25kr6.setTag(aRc23Z);
            String ARc23Z2 = aRc23Z.ARc23Z();
            MarqueeTextView marqueeTextView = cSDoyG.f4778AlLFFp;
            marqueeTextView.setText(ARc23Z2);
            CcAIMM ccAIMM = cSDoyG.f4784B4ZgIw;
            marqueeTextView.setMarqueeEnabled(!ccAIMM.f4789AzWtSf);
            cSDoyG.f4780AzWtSf.setText(aRc23Z.AZkASS() != null ? aRc23Z.AZkASS() : "");
            String AMqCpz = aRc23Z.AMqCpz() != null ? aRc23Z.AMqCpz() : "";
            TextView textView = cSDoyG.f4779AmA8tU;
            textView.setText(AMqCpz);
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            cSDoyG.A2egSU(aRc23Z);
            String ADYaiT2 = aRc23Z.ADYaiT();
            ImageView imageView = cSDoyG.f4777AcNBzu;
            if (ADYaiT2 != null && !aRc23Z.ADYaiT().isEmpty()) {
                ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(cSDoyG.itemView.getContext()).AaHO0E(aRc23Z.ADYaiT()).AZkASS(2131231009)).AMqCpz(2131231009)).ADYaiT(HXc4pW.AlLFFp.f3555A2egSU)).B25kr6(false)).BTvldC(imageView);
                if (aRc23Z.AaHO0E() == 3) {
                    ccAIMM.ADYaiT(aRc23Z.ADYaiT(), aRc23Z.ARc23Z());
                    return;
                }
                return;
            }
            imageView.setImageResource(2131231009);
        }
    }
}
