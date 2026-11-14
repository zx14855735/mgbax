package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    static final int f13105a = 1;
    private static final String b = "LocalBroadcastManager";
    private static final boolean c = false;
    private static final Object d = new Object();
    private static aj e;
    private final Context f;
    private final HashMap<BroadcastReceiver, ArrayList<b>> g = new HashMap<>();
    private final HashMap<String, ArrayList<b>> h = new HashMap<>();
    private final ArrayList<a> i = new ArrayList<>();
    private final Handler j = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.base.common.aj.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                aj.this.a();
            } else {
                super.handleMessage(message);
            }
        }
    };

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f13107a;
        final ArrayList<b> b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f13107a = intent;
            this.b = arrayList;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f13108a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f13108a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(r.b.d);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f13108a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        jkQltbz();
    }

    private aj(Context context) {
        this.f = context;
    }

    public static aj a(Context context) {
        aj ajVar;
        synchronized (d) {
            try {
                if (e == null) {
                    e = new aj(context.getApplicationContext());
                }
                ajVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ajVar;
    }

    private static /* synthetic */ void jkQltbz() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    public void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.g) {
                try {
                    size = this.i.size();
                    if (size <= 0) {
                        return;
                    }
                    aVarArr = new a[size];
                    this.i.toArray(aVarArr);
                    this.i.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.f, aVar.f13107a);
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.g) {
            try {
                ArrayList<b> remove = this.g.remove(broadcastReceiver);
                if (remove != null) {
                    for (int size = remove.size() - 1; size >= 0; size--) {
                        b bVar = remove.get(size);
                        bVar.d = true;
                        for (int i = 0; i < bVar.f13108a.countActions(); i++) {
                            String action = bVar.f13108a.getAction(i);
                            ArrayList<b> arrayList = this.h.get(action);
                            if (arrayList != null) {
                                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                    b bVar2 = arrayList.get(size2);
                                    if (bVar2.b == broadcastReceiver) {
                                        bVar2.d = true;
                                        arrayList.remove(size2);
                                    }
                                }
                                if (arrayList.size() <= 0) {
                                    this.h.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.g) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.g.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.g.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<b> arrayList2 = this.h.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.h.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(Intent intent) {
        return a(intent, 0);
    }

    public boolean a(Intent intent, int i) {
        int i2;
        synchronized (this.g) {
            try {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    intent.toString();
                }
                ArrayList<b> arrayList = this.h.get(intent.getAction());
                if (arrayList == null) {
                    return false;
                }
                if (z) {
                    arrayList.toString();
                }
                ArrayList arrayList2 = null;
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    b bVar = arrayList.get(i3);
                    if (z) {
                        Objects.toString(bVar.f13108a);
                    }
                    if (bVar.c) {
                        i2 = i3;
                    } else {
                        i2 = i3;
                        int match = bVar.f13108a.match(action, resolveTypeIfNeeded, scheme, data, categories, b);
                        if (match >= 0) {
                            if (z) {
                                Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(bVar);
                            bVar.c = true;
                        }
                    }
                    i3 = i2 + 1;
                }
                if (arrayList2 == null) {
                    return false;
                }
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    ((b) arrayList2.get(i4)).c = false;
                }
                this.i.add(new a(intent, arrayList2));
                if (!this.j.hasMessages(1)) {
                    if (i > 0) {
                        this.j.sendEmptyMessageDelayed(1, i);
                    } else {
                        this.j.sendEmptyMessage(1);
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
