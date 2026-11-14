package EsrwYR;

import ADYaiT.BmvVmW;
import Hjvs0g.B3GDIM;
import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import K7mCWO.AYUAbz;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import com.czhj.sdk.common.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements EmJGcg.A2egSU, BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2549AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Context f2550AlLFFp;

    public void A2egSU(boolean z) {
        boolean A2egSU2;
        JSONObject jSONObject;
        Context context = this.f2550AlLFFp;
        try {
            SharedPreferences hf = hf.hf(context, "npth", 0);
            long j = hf.getLong("history_time", -1L);
            if (j < 0) {
                hf.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                File file = new File(com.bumptech.glide.A5SV6n.DuwtYk(context), "crash_history");
                if (file.exists()) {
                    file.delete();
                }
                hf.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        if (z) {
            File file2 = new File(com.bumptech.glide.A5SV6n.DuwtYk(this.f2550AlLFFp), "CrashLogJava");
            File[] listFiles = !file2.exists() ? null : TextUtils.isEmpty(".npth") ? file2.listFiles() : file2.listFiles(new AYUAbz());
            if (listFiles == null) {
                return;
            }
            Arrays.sort(listFiles, Collections.reverseOrder());
            for (int i = 0; i < listFiles.length && i < 50; i++) {
                File file3 = listFiles[i];
                try {
                    K1Z3yj.A2egSU B9tovu2 = K1Z3yj.A2egSU.B9tovu();
                    String absolutePath = file3.getAbsolutePath();
                    synchronized (B9tovu2) {
                        try {
                            K1qm5H.A2egSU a2egSU = (K1qm5H.A2egSU) B9tovu2.f4174AlLFFp;
                            A2egSU2 = a2egSU != null ? a2egSU.A2egSU((SQLiteDatabase) B9tovu2.f4175AmA8tU, absolutePath) : false;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!A2egSU2) {
                        KCVcbs.A4TApA DdagTj2 = JrXYwF.A4TApA.DdagTj(file3.getAbsolutePath());
                        if (DdagTj2 != null && (jSONObject = DdagTj2.f4230A4TApA) != null) {
                            String name = file3.getName();
                            boolean z2 = true;
                            if (!name.startsWith("launch_") && !name.startsWith("anr_") && name.startsWith("java_") && jSONObject.optInt("is_dart") != 1) {
                                jSONObject.optInt("isJava");
                            }
                            DdagTj2.f4230A4TApA.put("upload_scene", "launch_scan");
                            if (com.bumptech.glide.AMqCpz.D07BeM(DdagTj2.f4229A2egSU, jSONObject.toString(), DdagTj2.f4231A5SV6n).f4098A2egSU == 0) {
                                if (!file3.exists() || !file3.delete()) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    K1Z3yj.A2egSU B9tovu3 = K1Z3yj.A2egSU.B9tovu();
                                    String absolutePath2 = file3.getAbsolutePath();
                                    K32z9s.A2egSU a2egSU2 = new K32z9s.A2egSU();
                                    a2egSU2.f4176A2egSU = absolutePath2;
                                    a2egSU2.f4177A4TApA = System.currentTimeMillis();
                                    B9tovu3.BChYOn(a2egSU2);
                                }
                            }
                        }
                    } else if (file3.exists()) {
                        file3.delete();
                    }
                } catch (Exception unused) {
                    com.bumptech.glide.AMqCpz.C2rE4F();
                }
            }
        }
    }

    @Override // EmJGcg.A2egSU
    public void A4TApA(GEYgCP.A2egSU a2egSU) {
        switch (this.f2549AcNBzu) {
            case 0:
                Context context = this.f2550AlLFFp;
                if (context != null) {
                    Intent intent = new Intent("android.service.action.msa");
                    intent.setPackage("com.android.creator");
                    AMqCpz.A2egSU(context, intent, a2egSU, new BmvVmW(19));
                    return;
                }
                return;
            case 1:
                Context context2 = this.f2550AlLFFp;
                if (context2 != null) {
                    Intent intent2 = new Intent();
                    intent2.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                    AMqCpz.A2egSU(context2, intent2, a2egSU, new BmvVmW(22));
                    return;
                }
                return;
            case 2:
                Context context3 = this.f2550AlLFFp;
                if (context3 != null) {
                    try {
                        Intent intent3 = new Intent("com.bun.msa.action.start.service");
                        intent3.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                        intent3.putExtra("com.bun.msa.param.pkgname", context3.getPackageName());
                        if (Build.VERSION.SDK_INT < 26) {
                            context3.startService(intent3);
                        } else {
                            context3.startForegroundService(intent3);
                        }
                    } catch (Exception unused) {
                    }
                    Intent intent4 = new Intent("com.bun.msa.action.bindto.service");
                    intent4.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                    intent4.putExtra("com.bun.msa.param.pkgname", context3.getPackageName());
                    AMqCpz.A2egSU(context3, intent4, a2egSU, new BmvVmW(23));
                    return;
                }
                return;
            default:
                Context context4 = this.f2550AlLFFp;
                if (context4 == null) {
                    return;
                }
                try {
                    Cursor query = context4.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                    try {
                        Objects.requireNonNull(query);
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("value"));
                        if (string == null || string.length() == 0) {
                            throw new GL2Jh7.A2egSU("OAID query failed");
                        }
                        AlLFFp.f5886AlLFFp = string;
                        query.close();
                        return;
                    } finally {
                    }
                } catch (Exception unused2) {
                    return;
                }
        }
    }

    @Override // Hjvs0g.BIYEnU
    public BI9f7h AYUAbz(Hjvs0g.BmvVmW bmvVmW) {
        switch (this.f2549AcNBzu) {
            case 4:
                return new B3GDIM(this.f2550AlLFFp, 0);
            default:
                return new B3GDIM(this.f2550AlLFFp, 1);
        }
    }

    @Override // EmJGcg.A2egSU
    /* renamed from: a */
    public boolean mo0a() {
        switch (this.f2549AcNBzu) {
            case 0:
                Context context = this.f2550AlLFFp;
                if (context == null) {
                    return false;
                }
                try {
                    return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
                } catch (Exception unused) {
                    return false;
                }
            case 1:
                Context context2 = this.f2550AlLFFp;
                if (context2 == null) {
                    return false;
                }
                try {
                    return context2.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
                } catch (Exception unused2) {
                    return false;
                }
            case 2:
                Context context3 = this.f2550AlLFFp;
                if (context3 == null) {
                    return false;
                }
                try {
                    return context3.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
                } catch (Exception unused3) {
                    return false;
                }
            default:
                if (Build.VERSION.SDK_INT < 28) {
                    return false;
                }
                return JrXYwF.A4TApA.ADYaiT("persist.sys.identifierid.supported", Constants.FAIL).equals("1");
        }
    }

    public /* synthetic */ A4TApA(Context context, int i) {
        this.f2549AcNBzu = i;
        this.f2550AlLFFp = context;
    }
}
