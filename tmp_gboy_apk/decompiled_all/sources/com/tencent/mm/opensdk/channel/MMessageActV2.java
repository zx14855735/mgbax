package com.tencent.mm.opensdk.channel;

import ADYaiT.CtFAbx;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.C;
import com.kwad.components.ad.reward.A2egSU;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public int launchMode = 2;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(Context context, Args args) {
        if (context == null || args == null) {
            Log.e(TAG, "send fail, invalid argument");
            return false;
        }
        if (b.b(args.targetPkgName)) {
            Log.e(TAG, "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName);
            return false;
        }
        if (b.b(args.targetClassName)) {
            args.targetClassName = CtFAbx.B25kr6(new StringBuilder(), args.targetPkgName, DEFAULT_ENTRY_CLASS_NAME);
        }
        Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName + ", launchMode = " + args.launchMode);
        Intent intent = new Intent();
        intent.setClassName(args.targetPkgName, args.targetClassName);
        Bundle bundle = args.bundle;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, args.content);
        intent.putExtra(ConstantsAPI.CHECK_SUM, a.a(args.content, Build.SDK_INT, packageName));
        intent.putExtra(ConstantsAPI.TOKEN, args.token);
        int i = args.flags;
        if (i == -1) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW).addFlags(134217728);
        } else {
            intent.setFlags(i);
        }
        try {
            if (Build.VERSION.SDK_INT < 29 || args.launchMode != 2) {
                context.startActivity(intent);
            } else {
                sendUsingPendingIntent(context, intent);
            }
            Log.d(TAG, "send mm message, intent=" + intent);
            return true;
        } catch (Exception e) {
            A2egSU.A5SV6n(e, new StringBuilder("send fail, ex = "), TAG);
            return false;
        }
    }

    private static void sendUsingPendingIntent(Context context, Intent intent) {
        Context context2;
        try {
            Log.i(TAG, "sendUsingPendingIntent");
            context2 = context;
        } catch (Exception e) {
            e = e;
            context2 = context;
        }
        try {
            PendingIntent.getActivity(context, 3, intent, 134217728).send(context2, 4, null, new PendingIntent.OnFinished() { // from class: com.tencent.mm.opensdk.channel.MMessageActV2.1
                @Override // android.app.PendingIntent.OnFinished
                public void onSendFinished(PendingIntent pendingIntent, Intent intent2, int i, String str, Bundle bundle) {
                    Log.i(MMessageActV2.TAG, "sendUsingPendingIntent onSendFinished resultCode: " + i + ", resultData: " + str);
                }
            }, null);
        } catch (Exception e2) {
            e = e2;
            Log.e(TAG, "sendUsingPendingIntent fail, ex = " + e.getMessage());
            context2.startActivity(intent);
        }
    }
}
