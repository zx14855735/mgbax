package com.game.boy.activity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.textfield.TextInputEditText;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LayoutEditor extends A5SV6n implements MkAsKS.ARc23Z, MkAsKS.ASJ6gh {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static Map f11052BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final String[] f11053BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final int[] f11054BIYEnU;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11055B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public I3HV03.A4TApA f11056B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MkAsKS.A2egSU f11057B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public DisplayMetrics f11058B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f11059B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public SharedPreferences f11060B9tovu;

    static {
        String[] strArr = {"dpad", "turbo_a", "turbo_b", "select", "start", "tl", "tr", t.f, t.l, "a+b", "tl+tr", "tl+a", "tl+b", "tr+a", "tr+b", "load", "save", "ff", "rewind", "ss", "menu"};
        f11053BI9f7h = strArr;
        int[] iArr = {2131886337, 2131886333, 2131886336, 2131886338, 2131886339, 2131886396, 2131886400, 2131886392, 2131886394, 2131886393, 2131886399, 2131886397, 2131886398, 2131886401, 2131886402, 2131886694, 2131886695, 2131886307, 2131886722, 2131886739, 2131886409};
        f11054BIYEnU = iArr;
        if (iArr.length != strArr.length) {
            throw new AssertionError("Controls are not consistent");
        }
    }

    public static int AcNBzu(TextInputEditText textInputEditText) {
        String obj = textInputEditText.getText().toString();
        if (obj.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(obj);
    }

    public static Bitmap AlLFFp(Resources resources, int i, HashMap hashMap) {
        String resourceEntryName = resources.getResourceEntryName(i);
        if (hashMap != null && hashMap.containsKey(resourceEntryName)) {
            return (Bitmap) hashMap.get(resourceEntryName);
        }
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, i), (int) (r2.getWidth() * 0.6f), (int) (r2.getHeight() * 0.6f), true);
    }

    public static HashMap AmA8tU(String str) {
        ZipFile zipFile;
        InputStream inputStream;
        HashMap hashMap = new HashMap();
        ZipFile zipFile2 = null;
        InputStream inputStream2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && nextElement.getName().toLowerCase(Locale.ROOT).endsWith(".png")) {
                    try {
                        inputStream = zipFile.getInputStream(nextElement);
                        try {
                            try {
                                String name = new File(nextElement.getName()).getName();
                                String substring = name.substring(0, name.lastIndexOf(46));
                                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                                if (decodeStream != null) {
                                    hashMap.put(substring, Bitmap.createScaledBitmap(decodeStream, (int) (decodeStream.getWidth() * 0.6f), (int) (decodeStream.getHeight() * 0.6f), true));
                                }
                                if (inputStream == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                            nextElement.getName();
                            if (inputStream == null) {
                            }
                            inputStream.close();
                        }
                    } catch (Exception unused3) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException unused5) {
            }
            return hashMap;
        } catch (Throwable th4) {
            th = th4;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    public static String AzWtSf(Rect rect) {
        Locale locale = Locale.ROOT;
        return rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x004f, code lost:
    
        if (r6.equals("fit_xy") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AYUAbz() {
        /*
            r9 = this;
            r0 = 2
            r1 = 1
            android.content.SharedPreferences r2 = r9.f11060B9tovu
            java.lang.String r3 = "enable_background_effect"
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            r3 = -15108398(0xffffffffff1976d2, float:-2.0398883E38)
            java.lang.String r5 = "game_COLOR"
            if (r2 == 0) goto Lbd
            android.content.res.Resources r2 = r9.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            android.content.SharedPreferences r6 = r9.f11060B9tovu
            java.lang.String r7 = "display_style"
            java.lang.String r8 = "center_crop"
            java.lang.String r6 = r6.getString(r7, r8)
            r6.getClass()
            r7 = -1
            int r8 = r6.hashCode()
            switch(r8) {
                case -1274273297: goto L49;
                case 225732390: goto L3e;
                case 1379043793: goto L33;
                default: goto L31;
            }
        L31:
            r4 = -1
            goto L52
        L33:
            java.lang.String r4 = "original"
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L3c
            goto L31
        L3c:
            r4 = 2
            goto L52
        L3e:
            java.lang.String r4 = "center_inside"
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L47
            goto L31
        L47:
            r4 = 1
            goto L52
        L49:
            java.lang.String r8 = "fit_xy"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L52
            goto L31
        L52:
            switch(r4) {
                case 0: goto L59;
                case 1: goto L5a;
                case 2: goto L57;
                default: goto L55;
            }
        L55:
            r0 = 1
            goto L5a
        L57:
            r0 = 4
            goto L5a
        L59:
            r0 = 3
        L5a:
            r4 = 0
            if (r2 != r1) goto L8d
            android.content.SharedPreferences r1 = r9.f11060B9tovu
            java.lang.String r2 = "portrait_background_image"
            java.lang.String r1 = r1.getString(r2, r4)
            if (r1 == 0) goto Lbc
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto Lbc
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1)
            if (r1 == 0) goto L81
            com.game.boy.activity.C4FrIb r2 = new com.game.boy.activity.C4FrIb
            r9.getResources()
            r2.<init>(r1, r0)
            MkAsKS.A2egSU r0 = r9.f11057B3GDIM
            r0.setBackground(r2)
            return
        L81:
            MkAsKS.A2egSU r0 = r9.f11057B3GDIM
            android.content.SharedPreferences r1 = r9.f11060B9tovu
            int r1 = r1.getInt(r5, r3)
            r0.setBackgroundColor(r1)
            return
        L8d:
            android.content.SharedPreferences r1 = r9.f11060B9tovu
            java.lang.String r2 = "landscape_background_image"
            java.lang.String r1 = r1.getString(r2, r4)
            if (r1 == 0) goto Lbc
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto Lbc
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1)
            if (r1 == 0) goto Lb1
            com.game.boy.activity.C4FrIb r2 = new com.game.boy.activity.C4FrIb
            r9.getResources()
            r2.<init>(r1, r0)
            MkAsKS.A2egSU r0 = r9.f11057B3GDIM
            r0.setBackground(r2)
            return
        Lb1:
            MkAsKS.A2egSU r0 = r9.f11057B3GDIM
            android.content.SharedPreferences r1 = r9.f11060B9tovu
            int r1 = r1.getInt(r5, r3)
            r0.setBackgroundColor(r1)
        Lbc:
            return
        Lbd:
            MkAsKS.A2egSU r0 = r9.f11057B3GDIM
            android.content.SharedPreferences r1 = r9.f11060B9tovu
            int r1 = r1.getInt(r5, r3)
            r0.setBackgroundColor(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.LayoutEditor.AYUAbz():void");
    }

    public final void AZOQYO(Map map) {
        MkAsKS.A2egSU a2egSU = this.f11057B3GDIM;
        a2egSU.f5418AcNBzu.clear();
        MkAsKS.ADYaiT aDYaiT = null;
        a2egSU.f5422B25kr6 = null;
        a2egSU.f5423B2KMhB = null;
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) f11052BChYOn.get(str);
            if (bitmap != null) {
                MkAsKS.ADYaiT AaHO0E2 = AaHO0E(str, bitmap, (Rect) map.get(str));
                if (aDYaiT == null && "video".equals(str)) {
                    aDYaiT = AaHO0E2;
                }
            }
        }
        if (aDYaiT != null) {
            Rect rect = aDYaiT.f5434A5SV6n;
            int width = rect.width();
            Bitmap bitmap2 = aDYaiT.f5433A4TApA;
            aDYaiT.AMqCpz = (bitmap2.getHeight() * width) / bitmap2.getWidth() == rect.height();
            MkAsKS.A2egSU a2egSU2 = this.f11057B3GDIM;
            ArrayList arrayList = a2egSU2.f5418AcNBzu;
            if (arrayList.remove(aDYaiT)) {
                arrayList.add(0, aDYaiT);
                a2egSU2.A4TApA(aDYaiT);
            }
        }
    }

    public final int AZkASS() {
        int width = this.f11057B3GDIM.getWidth();
        int height = this.f11057B3GDIM.getHeight();
        int i = MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
        int i2 = 160;
        int i3 = 1;
        while (true) {
            i <<= 1;
            i2 <<= 1;
            if (i > width || i2 > height) {
                break;
            }
            i3 <<= 1;
        }
        return i3;
    }

    public final MkAsKS.ADYaiT AaHO0E(String str, Bitmap bitmap, Rect rect) {
        MkAsKS.A2egSU a2egSU = this.f11057B3GDIM;
        a2egSU.getClass();
        MkAsKS.ADYaiT aDYaiT = new MkAsKS.ADYaiT(a2egSU, bitmap, rect);
        a2egSU.f5418AcNBzu.add(aDYaiT);
        a2egSU.invalidate(rect);
        aDYaiT.f5435ADYaiT = str;
        int width = (int) ((bitmap.getWidth() / 2) * this.f11058B4ZgIw.density);
        int height = (int) ((bitmap.getHeight() / 2) * this.f11058B4ZgIw.density);
        aDYaiT.f5436ARc23Z = width;
        aDYaiT.f5437ASJ6gh = height;
        return aDYaiT;
    }

    public final void B25kr6(int i, int i2) {
        if (this.f11055B25kr6) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f11056B2KMhB.AaHO0E(i > i2)));
                XmlSerializer newSerializer = Xml.newSerializer();
                newSerializer.setOutput(bufferedOutputStream, "UTF-8");
                newSerializer.startDocument(null, null);
                newSerializer.startTag(null, "screen");
                for (MkAsKS.ADYaiT aDYaiT : this.f11057B3GDIM.getAllItems()) {
                    newSerializer.startTag(null, "control");
                    newSerializer.attribute(null, PointParamKey.TYPE, aDYaiT.f5435ADYaiT.toString());
                    newSerializer.attribute(null, "bounds", AzWtSf(aDYaiT.f5434A5SV6n));
                    newSerializer.endTag(null, "control");
                }
                newSerializer.endTag(null, "screen");
                newSerializer.endDocument();
                this.f11055B25kr6 = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // ADYaiT.B2KMhB, androidx.core.app.AmA8tU, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                openOptionsMenu();
                return true;
            }
            if (keyCode == 82) {
                openOptionsMenu();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // ADYaiT.B2KMhB, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AYUAbz();
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) {
        MkAsKS.ADYaiT aDYaiT = ((MkAsKS.A4TApA) menuItem.getMenuInfo()).f5431A2egSU;
        int i = 0;
        switch (menuItem.getItemId()) {
            case 1:
                this.f11055B25kr6 = true;
                MkAsKS.A2egSU a2egSU = this.f11057B3GDIM;
                a2egSU.A4TApA(aDYaiT);
                a2egSU.f5418AcNBzu.remove(aDYaiT);
                if (a2egSU.f5422B25kr6 == aDYaiT) {
                    a2egSU.f5422B25kr6 = null;
                    a2egSU.f5423B2KMhB = null;
                }
                return true;
            case 2:
                boolean z = aDYaiT.AMqCpz;
                aDYaiT.AMqCpz = !z;
                if (!z) {
                    Rect rect = aDYaiT.f5434A5SV6n;
                    int width = rect.width();
                    Bitmap bitmap = aDYaiT.f5433A4TApA;
                    int height = (bitmap.getHeight() * width) / bitmap.getWidth();
                    MkAsKS.A2egSU a2egSU2 = aDYaiT.f5432A2egSU;
                    if (height > a2egSU2.getHeight()) {
                        height = a2egSU2.getHeight();
                        width = (bitmap.getWidth() * height) / bitmap.getHeight();
                    }
                    aDYaiT.A2egSU(MkAsKS.A2egSU.A2egSU(a2egSU2, rect.centerX() - (width / 2), a2egSU2.getWidth() - width), MkAsKS.A2egSU.A2egSU(a2egSU2, rect.centerY() - (height / 2), a2egSU2.getHeight() - height), width, height);
                    return true;
                }
                return true;
            case 3:
                aDYaiT.AMqCpz = false;
                aDYaiT.A2egSU(0, 0, this.f11057B3GDIM.getWidth(), this.f11057B3GDIM.getHeight());
                return true;
            case 4:
                Rect rect2 = aDYaiT.f5434A5SV6n;
                aDYaiT.A2egSU((this.f11057B3GDIM.getWidth() - rect2.width()) / 2, (this.f11057B3GDIM.getHeight() - rect2.height()) / 2, rect2.width(), rect2.height());
                return true;
            case 5:
                int AZkASS2 = AZkASS();
                int i2 = AZkASS2 * MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
                int i3 = AZkASS2 * 160;
                aDYaiT.A2egSU((this.f11057B3GDIM.getWidth() - i2) / 2, (this.f11057B3GDIM.getHeight() - i3) / 2, i2, i3);
                return true;
            case 6:
                int round = Math.round(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA * getResources().getDisplayMetrics().density);
                int round2 = Math.round(160 * getResources().getDisplayMetrics().density);
                aDYaiT.A2egSU((this.f11057B3GDIM.getWidth() - round) / 2, (this.f11057B3GDIM.getHeight() - round2) / 2, round, round2);
                return true;
            case 7:
                Rect rect3 = aDYaiT.f5434A5SV6n;
                View inflate = LayoutInflater.from(this).inflate(2131492978, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(2131298192);
                TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(2131296644);
                TextInputEditText textInputEditText2 = (TextInputEditText) inflate.findViewById(2131296645);
                TextInputEditText textInputEditText3 = (TextInputEditText) inflate.findViewById(2131296643);
                TextInputEditText textInputEditText4 = (TextInputEditText) inflate.findViewById(2131296640);
                TextView textView2 = (TextView) inflate.findViewById(2131298231);
                StringBuilder sb = new StringBuilder("控件类型: ");
                String str = aDYaiT.f5435ADYaiT;
                while (true) {
                    if (i < 21) {
                        if (f11053BI9f7h[i].equals(str)) {
                            str = getString(f11054BIYEnU[i]);
                        } else {
                            i++;
                        }
                    }
                }
                sb.append(str);
                textView.setText(sb.toString());
                textInputEditText.setText(String.valueOf(rect3.left));
                textInputEditText2.setText(String.valueOf(rect3.top));
                textInputEditText3.setText(String.valueOf(rect3.width()));
                textInputEditText4.setText(String.valueOf(rect3.height()));
                Locale locale = Locale.ROOT;
                textView2.setText("屏幕尺寸: " + this.f11057B3GDIM.getWidth() + " x " + this.f11057B3GDIM.getHeight());
                OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
                ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                azoqyo.AMqCpz = "调整位置和大小";
                azoqyo.f41B7CMnp = inflate;
                a4TApA.AzWtSf("确定", new BpkvW3(this, aDYaiT, textInputEditText, textInputEditText2, textInputEditText3, textInputEditText4));
                a4TApA.AcNBzu("取消", null);
                ADYaiT.AmA8tU A2egSU2 = a4TApA.A2egSU();
                A2egSU2.show();
                textInputEditText.requestFocus();
                A2egSU2.getWindow().setSoftInputMode(5);
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        char c;
        int i;
        int i2 = -1;
        int i3 = 0;
        super.onCreate(bundle);
        this.f11058B4ZgIw = getResources().getDisplayMetrics();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.f11060B9tovu = defaultSharedPreferences;
        String string = defaultSharedPreferences.getString("screenOrientation", "sensor");
        string.getClass();
        switch (string.hashCode()) {
            case -905948230:
                if (string.equals("sensor")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -675508834:
                if (string.equals("reverse_landscape")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 729267099:
                if (string.equals("portrait")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1430647483:
                if (string.equals("landscape")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i2 = 4;
                break;
            case 1:
                i2 = 8;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 0;
                break;
        }
        setRequestedOrientation(i2);
        boolean z = this.f11060B9tovu.getBoolean("fullScreenMode", true);
        boolean z2 = this.f11060B9tovu.getBoolean("fullScreenImmersive", true);
        View decorView = getWindow().getDecorView();
        Class<?> cls = Boolean.TYPE;
        if (z) {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
                try {
                    decorView.getClass().getMethod("setFitsSystemWindows", cls).invoke(decorView, Boolean.FALSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (z2) {
                getWindow().setNavigationBarColor(0);
                getWindow().setStatusBarColor(0);
                i = 5894;
            } else {
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                sharedPreferences.edit().apply();
                getWindow().setNavigationBarColor(sharedPreferences.getInt("game_COLOR", -15108398));
                getWindow().setStatusBarColor(0);
                i = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
            }
            decorView.setSystemUiVisibility(i);
            decorView.setOnApplyWindowInsetsListener(new CrfGsy.A2egSU(2));
        } else {
            getWindow().clearFlags(1024);
            SharedPreferences sharedPreferences2 = getSharedPreferences(getPackageName() + "_preferences", 0);
            sharedPreferences2.edit().apply();
            int i4 = sharedPreferences2.getInt("game_COLOR", -15108398);
            getWindow().setNavigationBarColor(i4);
            getWindow().setStatusBarColor(i4);
            decorView.setSystemUiVisibility(0);
            try {
                decorView.getClass().getMethod("setFitsSystemWindows", cls).invoke(decorView, Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            decorView.setOnApplyWindowInsetsListener(null);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                attributes2.layoutInDisplayCutoutMode = 0;
                getWindow().setAttributes(attributes2);
            }
        }
        boolean z3 = this.f11060B9tovu.getBoolean("fullScreenMode", true);
        this.f11059B7CMnp = z3;
        if (z3) {
            getWindow().addFlags(1024);
        }
        this.f11059B7CMnp = this.f11060B9tovu.getBoolean("fullScreenImmersive", true) && this.f11059B7CMnp;
        MkAsKS.A2egSU a2egSU = new MkAsKS.A2egSU(this);
        this.f11057B3GDIM = a2egSU;
        a2egSU.setGridSize((int) (10 * this.f11058B4ZgIw.density));
        this.f11057B3GDIM.setOnSizeChangeListener(this);
        this.f11057B3GDIM.setOnItemChangeListener(this);
        AYUAbz();
        setContentView(this.f11057B3GDIM);
        registerForContextMenu(this.f11057B3GDIM);
        MkAsKS.A2egSU a2egSU2 = this.f11057B3GDIM;
        if (this.f11059B7CMnp) {
            a2egSU2.setSystemUiVisibility(5894);
        } else {
            a2egSU2.setSystemUiVisibility(1);
        }
        Resources resources = getResources();
        this.f11056B2KMhB = new I3HV03.A4TApA(getIntent().getStringExtra("profile-name"), 6, new Hdahpu.ASJ6gh(this));
        if (f11052BChYOn == null) {
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
            ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
            azoqyo.AMqCpz = "加载中...";
            azoqyo.f35AmA8tU = false;
            a4TApA.AzWtSf("取消", new BniPrB(this, i3));
            ADYaiT.AmA8tU A2egSU2 = a4TApA.A2egSU();
            A2egSU2.show();
            new Thread(new C4FrIb.B4ZgIw(12, this, resources, A2egSU2)).start();
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        MkAsKS.ADYaiT aDYaiT = ((MkAsKS.A4TApA) contextMenuInfo).f5431A2egSU;
        if (!"video".equals(aDYaiT.f5435ADYaiT)) {
            contextMenu.add(0, 7, 0, "自定义大小");
            contextMenu.add(0, 1, 0, 2131886697);
            return;
        }
        contextMenu.add(0, 3, 0, 2131886509);
        contextMenu.add(0, 4, 0, 2131886507);
        contextMenu.add(0, 5, 0, getString(2131886140, Integer.valueOf(AZkASS())));
        contextMenu.add(0, 6, 0, "一比一对标");
        contextMenu.add(0, 7, 0, "自定义大小");
        contextMenu.add(0, 2, 0, aDYaiT.AMqCpz ? 2131886152 : 2131886391);
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            f11052BChYOn = null;
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        B25kr6(this.f11057B3GDIM.getWidth(), this.f11057B3GDIM.getHeight());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            MkAsKS.A2egSU a2egSU = this.f11057B3GDIM;
            if (this.f11059B7CMnp) {
                a2egSU.setSystemUiVisibility(5894);
            } else {
                a2egSU.setSystemUiVisibility(1);
            }
        }
    }

    @Override // ADYaiT.B2KMhB, android.app.Activity
    public final void openOptionsMenu() {
        KpHwm4.AMqCpz aMqCpz = new KpHwm4.AMqCpz(this);
        aMqCpz.f4284B25kr6 = new int[20];
        CharSequence[] charSequenceArr = new CharSequence[20];
        aMqCpz.f4285B2KMhB = charSequenceArr;
        aMqCpz.f4287B4ZgIw = this;
        aMqCpz.f4286B3GDIM = 0;
        aMqCpz.B3GDIM(2131297582, 2131886118);
        aMqCpz.B3GDIM(2131297624, 2131886708);
        aMqCpz.B3GDIM(2131297620, 2131886698);
        aMqCpz.B3GDIM(2131297617, 2131886186);
        CharSequence[] charSequenceArr2 = (CharSequence[]) Arrays.copyOf(charSequenceArr, aMqCpz.f4286B3GDIM);
        ADYaiT.AZOQYO azoqyo = aMqCpz.f81AcNBzu;
        azoqyo.f38B2KMhB = charSequenceArr2;
        azoqyo.f40B4ZgIw = aMqCpz;
        azoqyo.f37B25kr6 = aMqCpz;
        aMqCpz.AMqCpz();
    }
}
