package AZOQYO;

import AZkASS.B2KMhB;
import AaHO0E.EGM26s;
import AaHO0E.GYpKKt;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.R$styleable;
import com.sigmob.sdk.downloader.f;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends MenuInflater {
    public static final Class[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Class[] f402ARc23Z;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object[] f403A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object[] f404A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Context f405A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Object f406ADYaiT;

    static {
        Class[] clsArr = {Context.class};
        AMqCpz = clsArr;
        f402ARc23Z = clsArr;
        MEUJ();
    }

    public AZkASS(Context context) {
        super(context);
        this.f405A5SV6n = context;
        Object[] objArr = {context};
        this.f403A2egSU = objArr;
        this.f404A4TApA = objArr;
    }

    public static Object A2egSU(Object obj) {
        return obj instanceof Activity ? obj : obj instanceof ContextWrapper ? A2egSU(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private static /* synthetic */ void MEUJ() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v58 */
    public final void A4TApA(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        ?? r4;
        int i;
        XmlResourceParser xmlResourceParser2;
        ColorStateList colorStateList;
        AZOQYO azoqyo = new AZOQYO(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r4 = 1;
            i = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == r4) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z2 && name2.equals(str)) {
                        xmlResourceParser2 = xmlResourceParser;
                        z2 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        azoqyo.f373A4TApA = 0;
                        azoqyo.f374A5SV6n = 0;
                        azoqyo.f375ADYaiT = 0;
                        azoqyo.AMqCpz = 0;
                        azoqyo.f376ARc23Z = r4;
                        azoqyo.f377ASJ6gh = r4;
                    } else if (name2.equals("item")) {
                        if (!azoqyo.f378AYUAbz) {
                            COJEAR.A5SV6n a5SV6n = azoqyo.f396BNL6CD;
                            if (a5SV6n == null || !((B2KMhB) a5SV6n).f549A5SV6n.hasSubMenu()) {
                                azoqyo.f378AYUAbz = r4;
                                azoqyo.A4TApA(azoqyo.f372A2egSU.add(azoqyo.f373A4TApA, azoqyo.f379AZOQYO, azoqyo.f380AZkASS, azoqyo.f381AaHO0E));
                            } else {
                                azoqyo.f378AYUAbz = r4;
                                azoqyo.A4TApA(azoqyo.f372A2egSU.addSubMenu(azoqyo.f373A4TApA, azoqyo.f379AZOQYO, azoqyo.f380AZkASS, azoqyo.f381AaHO0E).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        xmlResourceParser2 = xmlResourceParser;
                        z = true;
                    }
                    eventType = xmlResourceParser2.next();
                    r4 = 1;
                    i = 2;
                }
                xmlResourceParser2 = xmlResourceParser;
            } else {
                if (!z2) {
                    String name3 = xmlResourceParser.getName();
                    boolean equals = name3.equals("group");
                    AZkASS aZkASS = azoqyo.f401BniPrB;
                    if (equals) {
                        TypedArray obtainStyledAttributes = aZkASS.f405A5SV6n.obtainStyledAttributes(attributeSet, R$styleable.f8029B2KMhB);
                        azoqyo.f373A4TApA = obtainStyledAttributes.getResourceId(r4, 0);
                        azoqyo.f374A5SV6n = obtainStyledAttributes.getInt(3, 0);
                        azoqyo.f375ADYaiT = obtainStyledAttributes.getInt(4, 0);
                        azoqyo.AMqCpz = obtainStyledAttributes.getInt(5, 0);
                        azoqyo.f376ARc23Z = obtainStyledAttributes.getBoolean(2, r4);
                        azoqyo.f377ASJ6gh = obtainStyledAttributes.getBoolean(0, r4);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        GYpKKt AMqCpz2 = GYpKKt.AMqCpz(aZkASS.f405A5SV6n, attributeSet, R$styleable.f8030B3GDIM);
                        TypedArray typedArray = AMqCpz2.f884A4TApA;
                        azoqyo.f379AZOQYO = typedArray.getResourceId(2, 0);
                        azoqyo.f380AZkASS = (typedArray.getInt(5, azoqyo.f374A5SV6n) & (-65536)) | (typedArray.getInt(6, azoqyo.f375ADYaiT) & 65535);
                        azoqyo.f381AaHO0E = typedArray.getText(7);
                        azoqyo.f382AcNBzu = typedArray.getText(8);
                        azoqyo.f383AlLFFp = typedArray.getResourceId(0, 0);
                        String string = typedArray.getString(9);
                        azoqyo.f384AmA8tU = string == null ? (char) 0 : string.charAt(0);
                        azoqyo.f385AzWtSf = typedArray.getInt(16, f.a.c);
                        String string2 = typedArray.getString(10);
                        azoqyo.f386B25kr6 = string2 == null ? (char) 0 : string2.charAt(0);
                        azoqyo.f387B2KMhB = typedArray.getInt(20, f.a.c);
                        if (typedArray.hasValue(11)) {
                            azoqyo.f388B3GDIM = typedArray.getBoolean(11, false) ? 1 : 0;
                        } else {
                            azoqyo.f388B3GDIM = azoqyo.AMqCpz;
                        }
                        azoqyo.f389B4ZgIw = typedArray.getBoolean(3, false);
                        azoqyo.f390B7CMnp = typedArray.getBoolean(4, azoqyo.f376ARc23Z);
                        azoqyo.f391B9tovu = typedArray.getBoolean(1, azoqyo.f377ASJ6gh);
                        azoqyo.f392BChYOn = typedArray.getInt(21, -1);
                        azoqyo.f395BJ7GGh = typedArray.getString(12);
                        azoqyo.f393BI9f7h = typedArray.getResourceId(13, 0);
                        azoqyo.f394BIYEnU = typedArray.getString(15);
                        String string3 = typedArray.getString(14);
                        if (string3 != null && azoqyo.f393BI9f7h == 0 && azoqyo.f394BIYEnU == null) {
                            azoqyo.f396BNL6CD = (COJEAR.A5SV6n) azoqyo.A2egSU(string3, f402ARc23Z, aZkASS.f404A4TApA);
                        } else {
                            azoqyo.f396BNL6CD = null;
                        }
                        azoqyo.f397BPw6Q8 = typedArray.getText(17);
                        azoqyo.f398BTvldC = typedArray.getText(22);
                        if (typedArray.hasValue(19)) {
                            azoqyo.f400BmvVmW = EGM26s.A5SV6n(typedArray.getInt(19, -1), azoqyo.f400BmvVmW);
                            colorStateList = null;
                        } else {
                            colorStateList = null;
                            azoqyo.f400BmvVmW = null;
                        }
                        if (typedArray.hasValue(18)) {
                            azoqyo.f399BV3sI0 = AMqCpz2.A2egSU(18);
                        } else {
                            azoqyo.f399BV3sI0 = colorStateList;
                        }
                        AMqCpz2.ASJ6gh();
                        azoqyo.f378AYUAbz = false;
                        xmlResourceParser2 = xmlResourceParser;
                    } else {
                        if (name3.equals("menu")) {
                            azoqyo.f378AYUAbz = true;
                            SubMenu addSubMenu = azoqyo.f372A2egSU.addSubMenu(azoqyo.f373A4TApA, azoqyo.f379AZOQYO, azoqyo.f380AZkASS, azoqyo.f381AaHO0E);
                            azoqyo.A4TApA(addSubMenu.getItem());
                            xmlResourceParser2 = xmlResourceParser;
                            A4TApA(xmlResourceParser2, attributeSet, addSubMenu);
                        } else {
                            xmlResourceParser2 = xmlResourceParser;
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlResourceParser2.next();
                        r4 = 1;
                        i = 2;
                    }
                }
                xmlResourceParser2 = xmlResourceParser;
            }
            eventType = xmlResourceParser2.next();
            r4 = 1;
            i = 2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof AZkASS.AmA8tU)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z = false;
        try {
            try {
                xmlResourceParser = this.f405A5SV6n.getResources().getLayout(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof AZkASS.AmA8tU) {
                    AZkASS.AmA8tU amA8tU = (AZkASS.AmA8tU) menu;
                    if (!amA8tU.f508BPw6Q8) {
                        amA8tU.BJ7GGh();
                        z = true;
                    }
                }
                A4TApA(xmlResourceParser, asAttributeSet, menu);
                if (z) {
                    ((AZkASS.AmA8tU) menu).BIYEnU();
                }
                xmlResourceParser.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (z) {
                ((AZkASS.AmA8tU) menu).BIYEnU();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
