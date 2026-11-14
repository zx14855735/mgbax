package Qo94AZ;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT implements Iterable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final HashMap f7773AcNBzu = new HashMap();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f7774AlLFFp = new ArrayList();

    public ADYaiT(HashMap hashMap) {
        String str = (String) hashMap.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] split = str2.trim().split("=");
                if (split.length == 2) {
                    this.f7773AcNBzu.put(split[0], split[1]);
                }
            }
        }
    }

    public final void A2egSU(AlLFFp alLFFp) {
        Iterator it = this.f7774AlLFFp.iterator();
        while (it.hasNext()) {
            A5SV6n a5SV6n = (A5SV6n) it.next();
            alLFFp.f7808B25kr6.put("Set-Cookie", a5SV6n.f7771A2egSU + "=-delete-; expires=" + a5SV6n.f7772A4TApA);
        }
    }

    public void delete(String str) {
        ArrayList arrayList = this.f7774AlLFFp;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.add(5, -30);
        arrayList.add(new A5SV6n(str, simpleDateFormat.format(calendar.getTime())));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f7773AcNBzu.keySet().iterator();
    }
}
