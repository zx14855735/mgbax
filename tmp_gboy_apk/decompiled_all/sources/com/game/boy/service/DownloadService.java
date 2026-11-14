package com.game.boy.service;

import ADYaiT.CtFAbx;
import L5dZB6.A2egSU;
import L5dZB6.A4TApA;
import L5dZB6.ADYaiT;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BNL6CD;
import androidx.core.app.BPw6Q8;
import androidx.core.app.BV3sI0;
import androidx.core.content.FileProvider;
import androidx.core.graphics.drawable.IconCompat;
import com.bykv.vk.component.ttvideo.player.C;
import com.game.boy.activity.MainActivity;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadService extends Service {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ADYaiT f11102AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public A2egSU f11103AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public NotificationManager f11104AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final HashMap f11105AzWtSf = new HashMap();

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f11106B25kr6 = 1000;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AtomicBoolean f11107B2KMhB = new AtomicBoolean(false);

    public static String A4TApA(String str) {
        return str.endsWith(".apk") ? AdBaseConstants.MIME_APK : str.endsWith(".pdf") ? "application/pdf" : str.endsWith(".zip") ? "application/zip" : (str.endsWith(".jpg") || str.endsWith(".jpeg")) ? "image/jpeg" : str.endsWith(".png") ? "image/png" : str.endsWith(".mp3") ? "audio/mpeg" : str.endsWith(".mp4") ? "video/mp4" : "*/*";
    }

    public final Notification A2egSU() {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(C.ENCODING_PCM_A_LAW);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        BV3sI0 bV3sI0 = new BV3sI0(this, "download_channel");
        bV3sI0.AMqCpz = BV3sI0.A4TApA("下载服务运行中");
        bV3sI0.f8515ARc23Z = BV3sI0.A4TApA("正在处理下载任务");
        bV3sI0.f8551CikNvS.icon = 2131230957;
        bV3sI0.f8516ASJ6gh = activity;
        bV3sI0.f8522AlLFFp = -1;
        bV3sI0.f8537BTvldC = "service";
        bV3sI0.f8540BniPrB = 1;
        bV3sI0.AMqCpz(2, true);
        return bV3sI0.A2egSU();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    public final void A5SV6n(A4TApA a4TApA) {
        String str;
        int i;
        switch (a4TApA.f4400B7CMnp) {
            case 0:
                str = "等待下载";
                i = 2131230957;
                break;
            case 1:
                str = CtFAbx.AZkASS("%", a4TApA.f4399B4ZgIw, new StringBuilder("下载中: "));
                i = 2131230957;
                break;
            case 2:
                str = "已暂停";
                i = 2131230957;
                break;
            case 3:
                str = "下载完成";
                i = 2131231009;
                break;
            case 4:
                str = "下载失败";
                i = 2131231009;
                break;
            case 5:
                str = "验证中";
                i = 2131230957;
                break;
            case 6:
                str = "下载已取消";
                i = 2131231009;
                break;
            default:
                str = "未知状态";
                i = 2131230957;
                break;
        }
        String str2 = a4TApA.f4392AcNBzu;
        HashMap hashMap = this.f11105AzWtSf;
        if (!hashMap.containsKey(str2)) {
            int i2 = this.f11106B25kr6;
            this.f11106B25kr6 = i2 + 1;
            hashMap.put(str2, Integer.valueOf(i2));
        }
        int intValue = ((Integer) hashMap.get(str2)).intValue();
        BV3sI0 bV3sI0 = new BV3sI0(this, "download_channel");
        bV3sI0.AMqCpz = BV3sI0.A4TApA(a4TApA.f4395AzWtSf);
        bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(str);
        bV3sI0.f8551CikNvS.icon = i;
        bV3sI0.f8522AlLFFp = -1;
        int i3 = a4TApA.f4400B7CMnp;
        bV3sI0.AMqCpz(2, i3 == 1 || i3 == 5);
        int i4 = a4TApA.f4400B7CMnp;
        if (i4 == 1) {
            bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(a4TApA.f4399B4ZgIw + "%");
            int i5 = a4TApA.f4399B4ZgIw;
            bV3sI0.f8528B4ZgIw = 100;
            bV3sI0.f8529B7CMnp = i5;
            bV3sI0.f8530B9tovu = false;
            BPw6Q8 bPw6Q8 = new BPw6Q8();
            bPw6Q8.f8554A4TApA = BV3sI0.A4TApA(a4TApA.f4395AzWtSf);
            bPw6Q8.f8510A5SV6n = BV3sI0.A4TApA(str);
            bV3sI0.ASJ6gh(bPw6Q8);
            Intent intent = new Intent(this, (Class<?>) DownloadService.class);
            intent.setAction("pause_download");
            intent.putExtra("download_info", a4TApA);
            BNL6CD bnl6cd = new BNL6CD(2131231009, "暂停", PendingIntent.getService(this, 0, intent, 201326592));
            Intent intent2 = new Intent(this, (Class<?>) DownloadService.class);
            intent2.setAction("pause_download");
            intent2.putExtra("download_info", a4TApA);
            PendingIntent.getService(this, 1, intent2, 201326592);
            IconCompat A4TApA2 = IconCompat.A4TApA(null, "", 2131231009);
            new Bundle();
            if (A4TApA2.getType() == 2) {
                A4TApA2.A5SV6n();
            }
            BV3sI0.A4TApA("取消");
            bV3sI0.f8512A4TApA.add(bnl6cd);
        } else if (i4 == 2) {
            Intent intent3 = new Intent(this, (Class<?>) DownloadService.class);
            intent3.setAction("resume_download");
            intent3.putExtra("download_info", a4TApA);
            BNL6CD bnl6cd2 = new BNL6CD(2131231009, "继续", PendingIntent.getService(this, 2, intent3, 201326592));
            Intent intent4 = new Intent(this, (Class<?>) DownloadService.class);
            intent4.setAction("pause_download");
            intent4.putExtra("download_info", a4TApA);
            PendingIntent.getService(this, 3, intent4, 201326592);
            IconCompat A4TApA3 = IconCompat.A4TApA(null, "", 2131231009);
            new Bundle();
            if (A4TApA3.getType() == 2) {
                A4TApA3.A5SV6n();
            }
            BV3sI0.A4TApA("取消");
            bV3sI0.f8512A4TApA.add(bnl6cd2);
        } else {
            bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(str);
        }
        if (a4TApA.f4400B7CMnp == 3) {
            try {
                File file = new File(a4TApA.f4396B25kr6);
                if (file.exists()) {
                    Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file);
                    Intent intent5 = new Intent("android.intent.action.VIEW");
                    intent5.setDataAndType(uriForFile, A4TApA(a4TApA.f4395AzWtSf));
                    intent5.addFlags(1);
                    intent5.addFlags(C.ENCODING_PCM_MU_LAW);
                    if (intent5.resolveActivity(getPackageManager()) != null) {
                        PendingIntent activity = PendingIntent.getActivity(this, 0, intent5, 201326592);
                        bV3sI0.f8516ASJ6gh = activity;
                        bV3sI0.AMqCpz(16, true);
                        bV3sI0.f8512A4TApA.add(new BNL6CD(2131230957, "打开", activity));
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        this.f11104AmA8tU.notify(intValue, bV3sI0.A2egSU());
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        ADYaiT aDYaiT;
        super.onCreate();
        synchronized (ADYaiT.class) {
            try {
                if (ADYaiT.f4406AZOQYO == null) {
                    ADYaiT.f4406AZOQYO = new ADYaiT(this);
                }
                aDYaiT = ADYaiT.f4406AZOQYO;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11102AcNBzu = aDYaiT;
        this.f11103AlLFFp = new A2egSU(this);
        this.f11104AmA8tU = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel ADYaiT2 = JMFfuZ.A2egSU.ADYaiT();
            ADYaiT2.setDescription("文件下载进度通知");
            this.f11104AmA8tU.createNotificationChannel(ADYaiT2);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f11104AmA8tU.cancelAll();
        this.f11105AzWtSf.clear();
        this.f11102AcNBzu.AZOQYO();
        this.f11103AlLFFp.close();
        stopForeground(true);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x006d, code lost:
    
        if (r1.equals("update_progress") == false) goto L14;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int onStartCommand(android.content.Intent r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.service.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }
}
