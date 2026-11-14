package ADYaiT;

import android.R;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f47A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public WeakReference f48A4TApA;

    public /* synthetic */ AZkASS() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        McNXgv.A2egSU a2egSU;
        McNXgv.A5SV6n a5SV6n;
        String str;
        AmA8tU amA8tU;
        switch (this.f47A2egSU) {
            case 0:
                int i = message.what;
                if (i == -3 || i == -2 || i == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f48A4TApA.get(), message.what);
                    return;
                } else {
                    if (i != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            case 1:
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f48A4TApA.get();
                if (emulatorActivity == null || emulatorActivity.f11015CSDoyG == null) {
                    return;
                }
                emulatorActivity.f11011CASmeH.ASJ6gh();
                Object obj = message.obj;
                Console console = null;
                if (obj instanceof McNXgv.A2egSU) {
                    a2egSU = (McNXgv.A2egSU) obj;
                    a5SV6n = a2egSU != null ? a2egSU.f5281A4TApA : null;
                } else {
                    a2egSU = null;
                    a5SV6n = null;
                }
                switch (message.what) {
                    case 1:
                        LHpdLt.BTvldC bTvldC = LHpdLt.BTvldC.f4560CikNvS;
                        if (bTvldC != null) {
                            bTvldC.AYUAbz(false);
                        }
                        emulatorActivity.BpkvW3 = null;
                        LLYwnm.AYUAbz aYUAbz = emulatorActivity.f10998B9tovu;
                        if (aYUAbz != null && aYUAbz.f4626A2egSU.ADYaiT() && emulatorActivity.f10999BChYOn.B25kr6("user_token") != null) {
                            LHpdLt.AZOQYO azoqyo = emulatorActivity.f10997B7CMnp;
                            if (azoqyo != null) {
                                synchronized (azoqyo.f4506CQhlFr) {
                                    try {
                                        azoqyo.f4494BJ7GGh.clear();
                                        if (azoqyo.f4496BPw6Q8 == 0) {
                                            azoqyo.f4491BChYOn.clear();
                                            azoqyo.f4490B9tovu.notifyDataSetChanged();
                                        }
                                    } finally {
                                    }
                                }
                                emulatorActivity.f10997B7CMnp.AcNBzu(true);
                            }
                            emulatorActivity.f10998B9tovu.ADYaiT("", Mi9UWv.ASJ6gh.f5401BmvVmW, null);
                        }
                        AmA8tU amA8tU2 = emulatorActivity.f11017CcAIMM;
                        if (amA8tU2 != null && amA8tU2.isShowing()) {
                            emulatorActivity.f11017CcAIMM.dismiss();
                            emulatorActivity.f11017CcAIMM = null;
                        }
                        emulatorActivity.f11011CASmeH.ARc23Z(emulatorActivity.f11015CSDoyG);
                        if (emulatorActivity.BpkvW3()) {
                            emulatorActivity.CASmeH(null, false);
                        }
                        emulatorActivity.f11015CSDoyG.ADYaiT(a5SV6n);
                        break;
                    case 2:
                        emulatorActivity.BJ7GGh();
                        KpHwm4.B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
                        if (b25kr6 != null && b25kr6.f4356AYUAbz) {
                            emulatorActivity.C2rE4F();
                            break;
                        } else {
                            if (emulatorActivity.f11017CcAIMM == null && emulatorActivity.BpkvW3 == null) {
                                MyApp.f10879AmA8tU.post(new KpHwm4.ARc23Z(2131886468));
                            } else {
                                int i2 = message.arg1;
                                if (i2 == 1) {
                                    new LLcl8r.A2egSU(emulatorActivity).AMqCpz();
                                    break;
                                } else {
                                    int i3 = i2 != 2 ? i2 != 3 ? 2131886469 : 2131886471 : 2131886470;
                                    OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(emulatorActivity);
                                    a4TApA.B2KMhB(2131886223);
                                    a4TApA.AYUAbz();
                                    a4TApA.AZOQYO(i3);
                                    a4TApA.AmA8tU(R.string.ok, null);
                                    a4TApA.A2egSU().show();
                                }
                            }
                            emulatorActivity.C2rE4F();
                            break;
                        }
                        break;
                    case 3:
                        Console console2 = emulatorActivity.f11004BPw6Q8.f11100A2egSU;
                        console2.AMqCpz.a();
                        try {
                            KpHwm4.B25kr6 b25kr62 = emulatorActivity.f11015CSDoyG;
                            String romHash = console2.getRomHash();
                            String name = console2.f11096A5SV6n.getName();
                            b25kr62.getClass();
                            byte[] bytes = romHash.getBytes();
                            byte[] bytes2 = name.getBytes();
                            a5SV6n.A2egSU(KpHwm4.B25kr6.ARc23Z((short) 2, bytes.length + 2 + bytes2.length).put(bytes).putShort((short) bytes2.length).put(bytes2));
                            break;
                        } catch (Exception e) {
                            MyApp.A2egSU("发送失败" + e.toString());
                            break;
                        }
                    case 4:
                        try {
                            String[] strArr = a2egSU.f5280A2egSU;
                            if (strArr != null && strArr.length >= 1) {
                                int i4 = a2egSU.f5282A5SV6n;
                                String str2 = strArr[0];
                                File file = emulatorActivity.f11003BNL6CD;
                                if (strArr.length >= 2) {
                                    File parentFile = file.getParentFile();
                                    str = parentFile != null ? new File(parentFile, strArr[1]).getAbsolutePath() : new File(strArr[1]).getAbsolutePath();
                                } else if (str2.equals(emulatorActivity.f11002BJ7GGh)) {
                                    str = file.getAbsolutePath();
                                } else {
                                    LCJm5h.AYUAbz.A5SV6n();
                                    File file2 = (File) LCJm5h.AYUAbz.f4439A5SV6n.get(str2.toLowerCase(Locale.ROOT));
                                    if (file2 == null || !file2.exists()) {
                                        file2 = null;
                                    }
                                    String str3 = (file2 == null || !file2.isFile()) ? emulatorActivity.f11002BJ7GGh : strArr[0];
                                    String absolutePath = (file2 == null || !file2.isFile()) ? file.getAbsolutePath() : file2.getAbsolutePath();
                                    str2 = str3;
                                    str = absolutePath;
                                }
                                if (emulatorActivity.B9tovu(str2, a5SV6n, i4) == null) {
                                    String CtxOCS2 = emulatorActivity.CtxOCS(str);
                                    if (CtxOCS2 != null) {
                                        if (CtxOCS2.equals(str2)) {
                                            console = emulatorActivity.B9tovu(CtxOCS2, a5SV6n, i4);
                                        } else {
                                            emulatorActivity.f11004BPw6Q8.unloadRom(CtxOCS2);
                                        }
                                    }
                                    if (console == null) {
                                        emulatorActivity.f11021CmUvjW = str2;
                                        new LLcl8r.A2egSU(emulatorActivity).AMqCpz();
                                        break;
                                    }
                                }
                            }
                            new LLcl8r.A2egSU(emulatorActivity, "异常数据").AMqCpz();
                        } catch (Exception unused) {
                            new LLcl8r.A2egSU(emulatorActivity, "异常数据，请反馈。").AMqCpz();
                            break;
                        }
                        break;
                    case 5:
                        try {
                            KpHwm4.B25kr6 b25kr63 = emulatorActivity.f11015CSDoyG;
                            byte[] saveStateToMemory = emulatorActivity.f11004BPw6Q8.f11100A2egSU.saveStateToMemory();
                            McNXgv.A5SV6n a5SV6n2 = ((McNXgv.A2egSU) message.obj).f5281A4TApA;
                            b25kr63.getClass();
                            if (a5SV6n2 != null) {
                                a5SV6n2.A2egSU(KpHwm4.B25kr6.ARc23Z((short) 6, saveStateToMemory.length + 4).putInt(saveStateToMemory.length).put(saveStateToMemory));
                                break;
                            } else {
                                break;
                            }
                        } catch (Exception unused2) {
                            break;
                        }
                    case 6:
                        McNXgv.A2egSU a2egSU2 = (McNXgv.A2egSU) obj;
                        String[] strArr2 = a2egSU2.f5280A2egSU;
                        McNXgv.A5SV6n a5SV6n3 = a2egSU2.f5281A4TApA;
                        int i5 = a2egSU2.f5282A5SV6n;
                        if (emulatorActivity.B9tovu(strArr2[0], a5SV6n3, i5) == null) {
                            String str4 = strArr2[0];
                            String CtxOCS3 = emulatorActivity.CtxOCS(new File(emulatorActivity.f11004BPw6Q8.f11100A2egSU.f11096A5SV6n.getParentFile(), strArr2[1]).getAbsolutePath());
                            if (CtxOCS3 != null) {
                                if (CtxOCS3.equals(str4)) {
                                    console = emulatorActivity.B9tovu(CtxOCS3, a5SV6n3, i5);
                                } else {
                                    emulatorActivity.f11004BPw6Q8.unloadRom(CtxOCS3);
                                }
                            }
                            if (console == null) {
                                emulatorActivity.f11021CmUvjW = strArr2[0];
                                new LLcl8r.A2egSU(emulatorActivity).AMqCpz();
                                break;
                            }
                        }
                        break;
                    case 7:
                        int i6 = message.arg1;
                        if (!emulatorActivity.isFinishing() && ((amA8tU = emulatorActivity.f11018Cd8JRx) == null || !amA8tU.isShowing())) {
                            if (i6 <= 0) {
                                i6 = 50000;
                            }
                            try {
                                OOnEhG.A4TApA a4TApA2 = new OOnEhG.A4TApA(emulatorActivity);
                                AZOQYO azoqyo2 = a4TApA2.f81AcNBzu;
                                azoqyo2.AMqCpz = "正在重连";
                                azoqyo2.f28ASJ6gh = EmulatorActivity.CTkVKb(i6);
                                azoqyo2.f35AmA8tU = false;
                                a4TApA2.AzWtSf("断开", new com.game.boy.activity.AlLFFp(emulatorActivity, 2));
                                AmA8tU A2egSU2 = a4TApA2.A2egSU();
                                emulatorActivity.f11018Cd8JRx = A2egSU2;
                                A2egSU2.show();
                                try {
                                    com.game.boy.activity.BChYOn bChYOn = emulatorActivity.f11019CikNvS;
                                    if (bChYOn != null) {
                                        bChYOn.cancel();
                                    }
                                } catch (Throwable unused3) {
                                }
                                emulatorActivity.f11019CikNvS = null;
                                com.game.boy.activity.BChYOn bChYOn2 = new com.game.boy.activity.BChYOn(emulatorActivity, i6);
                                emulatorActivity.f11019CikNvS = bChYOn2;
                                bChYOn2.start();
                                break;
                            } catch (Throwable unused4) {
                                emulatorActivity.f11018Cd8JRx = null;
                                break;
                            }
                        }
                        break;
                    case 8:
                        emulatorActivity.BJ7GGh();
                        break;
                }
                emulatorActivity.f11011CASmeH.AMqCpz();
                return;
            default:
                pl.droidsonroids.gif.A5SV6n a5SV6n4 = (pl.droidsonroids.gif.A5SV6n) this.f48A4TApA.get();
                if (a5SV6n4 == null) {
                    return;
                }
                if (message.what == -1) {
                    a5SV6n4.invalidateSelf();
                    return;
                }
                Iterator it = a5SV6n4.f14082B4ZgIw.iterator();
                if (it.hasNext()) {
                    throw CtFAbx.A5SV6n(it);
                }
                return;
        }
    }

    public AZkASS(EmulatorActivity emulatorActivity) {
        this.f48A4TApA = new WeakReference(emulatorActivity);
    }

    public AZkASS(pl.droidsonroids.gif.A5SV6n a5SV6n) {
        super(Looper.getMainLooper());
        this.f48A4TApA = new WeakReference(a5SV6n);
    }
}
