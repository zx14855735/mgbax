package com.bytedance.pangle;

import A5SV6n.A2egSU;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<hf>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<hf>> mActions = new HashMap<>();
    private final ArrayList<xj> mPendingBroadcasts = new ArrayList<>();

    public static final class hf {
        final PluginBroadcastReceiver hf;
        boolean u;
        boolean w;
        final IntentFilter xj;

        public hf(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.xj = intentFilter;
            this.hf = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(r.b.d);
            sb.append("Receiver{");
            sb.append(this.hf);
            sb.append(" filter=");
            sb.append(this.xj);
            if (this.u) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public static final class xj {
        final ArrayList<hf> hf;
        final Intent xj;

        public xj(Intent intent, ArrayList<hf> arrayList) {
            this.xj = intent;
            this.hf = arrayList;
        }
    }

    static {
        ALLvt();
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    private static /* synthetic */ void ALLvt() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    public void executePendingBroadcasts() {
        int size;
        xj[] xjVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                try {
                    size = this.mPendingBroadcasts.size();
                    if (size <= 0) {
                        return;
                    }
                    xjVarArr = new xj[size];
                    this.mPendingBroadcasts.toArray(xjVarArr);
                    this.mPendingBroadcasts.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i = 0; i < size; i++) {
                xj xjVar = xjVarArr[i];
                int size2 = xjVar.hf.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    hf hfVar = xjVar.hf.get(i2);
                    if (!hfVar.u) {
                        hfVar.hf.onReceive(this.mAppContext, xjVar.xj);
                    }
                }
            }
        }
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                hf hfVar = new hf(intentFilter, pluginBroadcastReceiver);
                ArrayList<hf> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.mReceivers.put(pluginBroadcastReceiver, arrayList);
                }
                arrayList.add(hfVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<hf> arrayList2 = this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(hfVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        String str;
        synchronized (this.mReceivers) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    com.bytedance.sdk.openadsdk.api.y.xj(TAG, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<hf> arrayList = this.mActions.get(intent.getAction());
                if (arrayList != null) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.api.y.xj(TAG, "Action list: ".concat(String.valueOf(arrayList)));
                    }
                    ArrayList arrayList2 = null;
                    int i = 0;
                    while (i < arrayList.size()) {
                        hf hfVar = arrayList.get(i);
                        if (z) {
                            com.bytedance.sdk.openadsdk.api.y.xj(TAG, "Matching against filter " + hfVar.xj);
                        }
                        if (hfVar.w) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.api.y.xj(TAG, "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int match = hfVar.xj.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                            if (match >= 0) {
                                if (z) {
                                    str = action;
                                    com.bytedance.sdk.openadsdk.api.y.xj(TAG, "  Filter matched!  match=0x" + Integer.toHexString(match));
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(hfVar);
                                hfVar.w = true;
                            } else {
                                str = action;
                                if (z) {
                                    com.bytedance.sdk.openadsdk.api.y.xj(TAG, "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : PointParamKey.TYPE : PointParamKey.DATA : "action" : PointParamKey.CATEGORY));
                                }
                            }
                        }
                        i++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            ((hf) arrayList2.get(i2)).w = false;
                        }
                        this.mPendingBroadcasts.add(new xj(intent, arrayList2));
                        if (!this.mHandler.hasMessages(1)) {
                            this.mHandler.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList<hf> remove = this.mReceivers.remove(pluginBroadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    hf hfVar = remove.get(size);
                    hfVar.u = true;
                    for (int i = 0; i < hfVar.xj.countActions(); i++) {
                        String action = hfVar.xj.getAction(i);
                        ArrayList<hf> arrayList = this.mActions.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                hf hfVar2 = arrayList.get(size2);
                                if (hfVar2.hf == pluginBroadcastReceiver) {
                                    hfVar2.u = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
