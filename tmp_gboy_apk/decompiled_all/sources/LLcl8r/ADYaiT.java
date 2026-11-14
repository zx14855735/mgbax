package LLcl8r;

import ADYaiT.AmA8tU;
import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import com.google.android.material.imageview.ShapeableImageView;
import java.io.File;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends AsyncTask {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final EmulatorActivity f4653A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f4654A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Console f4655A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AmA8tU f4656ADYaiT;

    public ADYaiT(EmulatorActivity emulatorActivity, String str) {
        this.f4653A2egSU = emulatorActivity;
        this.f4654A4TApA = str;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        String CtxOCS2;
        Console A4TApA2;
        EmulatorActivity emulatorActivity = this.f4653A2egSU;
        boolean z = emulatorActivity.f11024CtFAbx.getBoolean("useBios", false);
        Link link = emulatorActivity.f11004BPw6Q8;
        if (z) {
            try {
                String string = emulatorActivity.f11024CtFAbx.getString("biosFile", null);
                if (string == null || string.isEmpty()) {
                    link.loadBios(null);
                } else {
                    File file = new File(string);
                    if (file.exists() && file.canRead()) {
                        byte[] A4TApA3 = L2suez.ADYaiT.A4TApA(file);
                        if (A4TApA3 == null || A4TApA3.length <= 0) {
                            link.loadBios(null);
                        } else {
                            link.loadBios(A4TApA3);
                        }
                    } else {
                        link.loadBios(null);
                    }
                }
            } catch (Exception unused) {
                link.loadBios(null);
            }
        } else {
            link.loadBios(null);
        }
        String str = this.f4654A4TApA;
        File file2 = new File(str);
        int AmA8tU2 = LCJm5h.ARc23Z.AmA8tU(file2);
        if (AmA8tU2 == 2 || AmA8tU2 == 3 || (CtxOCS2 = emulatorActivity.CtxOCS(str)) == null || (A4TApA2 = link.A4TApA(-1, CtxOCS2)) == null) {
            return null;
        }
        A4TApA2.f11096A5SV6n = file2;
        String name = file2.getName();
        A4TApA2.f11097ADYaiT = name;
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            A4TApA2.f11097ADYaiT = A4TApA2.f11097ADYaiT.substring(0, lastIndexOf);
        }
        A4TApA2.AMqCpz = new DUi7mC(A4TApA2.f11097ADYaiT);
        A4TApA2.A2egSU();
        emulatorActivity.AlLFFp(A4TApA2);
        if (link.f11101A4TApA.size() == 0 && emulatorActivity.f11024CtFAbx.getBoolean("autoSave", false)) {
            emulatorActivity.AmA8tU(A4TApA2, 10);
        }
        return A4TApA2;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        int i = 1;
        Console console = (Console) obj;
        EmulatorActivity emulatorActivity = this.f4653A2egSU;
        Link link = emulatorActivity.f11004BPw6Q8;
        if (link.f11100A2egSU == null) {
            link.f11100A2egSU = this.f4655A5SV6n;
        }
        if (console == null) {
            Toast.makeText(emulatorActivity, 2131886480, 0).show();
            if (link.f11101A4TApA.isEmpty()) {
                emulatorActivity.finish();
            }
        } else {
            if (emulatorActivity.f11002BJ7GGh == null) {
                emulatorActivity.f11002BJ7GGh = console.getRomHash();
            }
            if (emulatorActivity.f11003BNL6CD == null) {
                emulatorActivity.f11003BNL6CD = console.f11096A5SV6n;
            }
            link.f11101A4TApA.add(console);
            emulatorActivity.BChYOn(console);
            int indexOf = emulatorActivity.f11004BPw6Q8.f11101A4TApA.indexOf(console);
            if (indexOf > 0) {
                MyApp.A2egSU(emulatorActivity.getString(2131886225, Integer.valueOf(indexOf + 1)));
            }
            emulatorActivity.CSDoyG();
            emulatorActivity.f10995B3GDIM.postDelayed(new A4TApA(this, i), 1000L);
        }
        emulatorActivity.f11011CASmeH.AMqCpz();
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        File file;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new A4TApA(this, 0));
            return;
        }
        EmulatorActivity emulatorActivity = this.f4653A2egSU;
        Link link = emulatorActivity.f11004BPw6Q8;
        this.f4655A5SV6n = link.f11100A2egSU;
        link.f11100A2egSU = null;
        View inflate = LayoutInflater.from(emulatorActivity).inflate(2131492951, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131298106);
        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(2131296733);
        File file2 = new File(this.f4654A4TApA);
        textView.setText(file2.getName());
        File file3 = new File(Environment.getExternalStorageDirectory(), "GBoy/image/");
        if (!file3.exists()) {
            file3.mkdirs();
        }
        String replace = file2.getName().toLowerCase(Locale.ROOT).replace(LCJm5h.ARc23Z.ASJ6gh(file2.getName()), "");
        if (file3.exists()) {
            String[] strArr = {".jpg", ".jpeg", ".png", ".gif", ".webp", ".bmp"};
            for (int i = 0; i < 6; i++) {
                file = new File(file3, CtFAbx.AcNBzu(replace, strArr[i]));
                if (file.exists()) {
                    break;
                }
            }
        }
        file = null;
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.A5SV6n(emulatorActivity).ADYaiT(emulatorActivity).AaHO0E(file != null ? file.getAbsolutePath() : null).AZkASS(2131230940)).AMqCpz(2131230940)).ARc23Z(2131230940)).BTvldC(shapeableImageView);
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(emulatorActivity);
        a4TApA.f81AcNBzu.f41B7CMnp = inflate;
        a4TApA.ASJ6gh();
        AmA8tU AMqCpz = a4TApA.AMqCpz();
        this.f4656ADYaiT = AMqCpz;
        AMqCpz.setOnKeyListener(new A5SV6n(0, this));
        emulatorActivity.f10995B3GDIM.setDialog(this.f4656ADYaiT);
        emulatorActivity.f11011CASmeH.ASJ6gh();
    }
}
