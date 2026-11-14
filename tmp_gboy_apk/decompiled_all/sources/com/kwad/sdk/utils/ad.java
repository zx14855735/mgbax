package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ad {
    private static ad beu;
    private static final Object mLock = new Object();
    private final Context beq;
    private final HashMap<BroadcastReceiver, ArrayList<b>> ber = new HashMap<>();
    private final HashMap<String, ArrayList<b>> bes = new HashMap<>();
    private final ArrayList<a> bet = new ArrayList<>();
    private final Handler iK;

    public static final class a {
        final ArrayList<b> bew;
        final Intent intent;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.bew = arrayList;
        }
    }

    public static final class b {
        final BroadcastReceiver bex;
        boolean bey;
        boolean bez;
        final IntentFilter filter;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.bex = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(r.b.d);
            sb.append("Receiver{");
            sb.append(this.bex);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.bez) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        GZBKdVX();
    }

    private ad(Context context) {
        this.beq = context;
        this.iK = new Handler(context.getMainLooper()) { // from class: com.kwad.sdk.utils.ad.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    ad.this.RS();
                }
            }
        };
    }

    private static /* synthetic */ void GZBKdVX() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ad cX(Context context) {
        ad adVar;
        synchronized (mLock) {
            try {
                if (beu == null) {
                    beu = new ad(context.getApplicationContext());
                }
                adVar = beu;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adVar;
    }

    public final void RS() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.ber) {
                try {
                    size = this.bet.size();
                    if (size <= 0) {
                        return;
                    }
                    aVarArr = new a[size];
                    this.bet.toArray(aVarArr);
                    this.bet.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.bew.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.bew.get(i2);
                    if (!bVar.bez) {
                        bVar.bex.onReceive(this.beq, aVar.intent);
                    }
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.ber) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.ber.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.ber.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<b> arrayList2 = this.bes.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.bes.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(Intent intent) {
        int match;
        synchronized (this.ber) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.beq.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    intent.toString();
                }
                ArrayList<b> arrayList = this.bes.get(intent.getAction());
                if (arrayList != null) {
                    if (z) {
                        arrayList.toString();
                    }
                    ArrayList arrayList2 = null;
                    for (int i = 0; i < arrayList.size(); i++) {
                        b bVar = arrayList.get(i);
                        if (z) {
                            Objects.toString(bVar.filter);
                        }
                        if (!bVar.bey && (match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager")) >= 0) {
                            if (z) {
                                Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(bVar);
                            bVar.bey = true;
                        }
                    }
                    if (arrayList2 != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            ((b) arrayList2.get(i2)).bey = false;
                        }
                        this.bet.add(new a(intent, arrayList2));
                        if (!this.iK.hasMessages(1)) {
                            this.iK.sendEmptyMessage(1);
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

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.ber) {
            try {
                ArrayList<b> remove = this.ber.remove(broadcastReceiver);
                if (remove == null) {
                    return;
                }
                for (int size = remove.size() - 1; size >= 0; size--) {
                    b bVar = remove.get(size);
                    bVar.bez = true;
                    for (int i = 0; i < bVar.filter.countActions(); i++) {
                        String action = bVar.filter.getAction(i);
                        ArrayList<b> arrayList = this.bes.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.bex == broadcastReceiver) {
                                    bVar2.bez = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.bes.remove(action);
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
