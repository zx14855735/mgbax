package com.game.boy.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.widget.Toast;
import com.game.boy.service.FileService;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DeviceActivity extends A5SV6n {

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final /* synthetic */ int f10961BNL6CD = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public MaterialToolbar f10962B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public MaterialButton f10963B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MaterialButton f10964B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public MaterialCardView f10965B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TextView f10966B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public TextView f10967B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public TextView f10968BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public TextView f10969BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Handler f10970BIYEnU = new Handler(Looper.getMainLooper());

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final LLYwnm.AMqCpz f10971BJ7GGh = new LLYwnm.AMqCpz(28, this);

    public final void AYUAbz(String str) {
        Intent intent = new Intent(this, (Class<?>) FileService.class);
        intent.setAction(str);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        } catch (Exception e) {
            Toast.makeText(this, "服务调用失败：" + e.getMessage(), 0).show();
        }
    }

    public final void AZOQYO() {
        if (FileService.f11116AzWtSf) {
            this.f10962B25kr6.setSubtitle("服务运行中");
            this.f10963B2KMhB.setText("停止服务");
            this.f10966B7CMnp.setText("状态：服务运行中");
            this.f10965B4ZgIw.setVisibility(0);
            ArrayList A4TApA2 = FileService.A4TApA();
            StringBuilder sb = new StringBuilder();
            if (A4TApA2.isEmpty()) {
                sb.append("未检测到可用 IP，请先连接 WiFi 或开启热点");
            } else {
                for (int i = 0; i < A4TApA2.size(); i++) {
                    if (i > 0) {
                        sb.append("\n");
                    }
                    sb.append("http://");
                    sb.append((String) A4TApA2.get(i));
                    sb.append(":6377");
                }
            }
            this.f10967B9tovu.setText("浏览器访问：\n" + sb.toString());
        } else {
            this.f10962B25kr6.setSubtitle("未启动");
            this.f10963B2KMhB.setText("启动服务");
            this.f10966B7CMnp.setText("状态：未启动");
            this.f10965B4ZgIw.setVisibility(8);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f10964B3GDIM.setText(FileService.f11117B25kr6 ? "关闭热点" : "开启热点");
        }
        if (!FileService.f11117B25kr6) {
            if (i2 >= 26) {
                this.f10968BChYOn.setText("提示：未开热点时，请让接收端连到同一 WiFi 后访问上方地址");
                return;
            } else {
                this.f10968BChYOn.setText("提示：本机系统版本不支持自动开热点，请手动开启热点或连接同一 WiFi");
                return;
            }
        }
        String str = FileService.f11119B3GDIM.isEmpty() ? "（系统未返回密码，请在系统设置中查看）" : FileService.f11119B3GDIM;
        TextView textView = this.f10968BChYOn;
        StringBuilder sb2 = new StringBuilder("热点： ");
        sb2.append(FileService.f11118B2KMhB);
        sb2.append("\n密码： ");
        sb2.append(str);
        sb2.append(!FileService.f11120B4ZgIw.isEmpty() ? "\n网关： ".concat(FileService.f11120B4ZgIw) : "");
        textView.setText(sb2.toString());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1002) {
            if (Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : BPw6Q8.ASJ6gh.A2egSU(this, g.j) == 0) {
                AYUAbz("com.game.boy.utils.START_SERVER");
            } else {
                Toast.makeText(this, "需要存储权限才能访问 GBoy 目录", 0).show();
            }
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        this.f10962B25kr6 = materialToolbar;
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().B25kr6();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
            getSupportActionBar().AmA8tU();
        }
        this.f10963B2KMhB = (MaterialButton) findViewById(2131296446);
        this.f10964B3GDIM = (MaterialButton) findViewById(2131296437);
        this.f10965B4ZgIw = (MaterialCardView) findViewById(2131296466);
        this.f10966B7CMnp = (TextView) findViewById(2131298235);
        this.f10967B9tovu = (TextView) findViewById(2131298176);
        this.f10968BChYOn = (TextView) findViewById(2131298205);
        this.f10969BI9f7h = (TextView) findViewById(2131298196);
        File file = new File(Environment.getExternalStorageDirectory(), "GBoy");
        this.f10969BI9f7h.setText("共享目录：" + file.getAbsolutePath());
        this.f10963B2KMhB.setOnClickListener(new AMqCpz(this, 0));
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f10964B3GDIM.setVisibility(0);
            this.f10964B3GDIM.setOnClickListener(new AMqCpz(this, 1));
        } else {
            this.f10964B3GDIM.setVisibility(8);
        }
        if (i >= 33 && BPw6Q8.ASJ6gh.A2egSU(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            androidx.core.app.AYUAbz.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1003);
        }
        AZOQYO();
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f10970BIYEnU.removeCallbacks(this.f10971BJ7GGh);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = iArr.length > 0 && iArr[0] == 0;
        if (i == 1001) {
            if (z) {
                AYUAbz("com.game.boy.utils.START_HOTSPOT");
                return;
            } else {
                Toast.makeText(this, "权限被拒绝，无法开启热点", 0).show();
                return;
            }
        }
        if (i == 1002) {
            if (z) {
                AYUAbz("com.game.boy.utils.START_SERVER");
            } else {
                Toast.makeText(this, "需要存储权限才能访问 GBoy 目录", 0).show();
            }
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f10970BIYEnU.post(this.f10971BJ7GGh);
    }
}
