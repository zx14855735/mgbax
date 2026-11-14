package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.AYUAbz;
import com.bytedance.sdk.openadsdk.api.y;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ApiDownloadHandleNotificationActivity extends Activity {
    private static final String[] xj = {"android.permission.POST_NOTIFICATIONS"};
    private ApiDownloadHandlerService hf = new ApiDownloadHandlerService();

    static {
        xPPWc();
    }

    private static /* synthetic */ void xPPWc() {
        char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 254);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 254);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void xj() {
        try {
            AYUAbz.requestPermissions(this, xj, 1000);
        } catch (Throwable th) {
            y.hf("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            xj();
        } else {
            this.hf.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            y.hf("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
