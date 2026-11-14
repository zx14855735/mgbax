package OLy1FW;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Map f6380A2egSU;

    static {
        OO3awZ.AZOQYO azoqyo = new OO3awZ.AZOQYO();
        HashMap hashMap = new HashMap();
        hashMap.put(2131100524, azoqyo.ASJ6gh());
        hashMap.put(2131100513, new OO3awZ.A5SV6n("on_primary", new OO3awZ.ASJ6gh(1), new OO3awZ.ASJ6gh(3), false, new OO3awZ.ARc23Z(7, azoqyo), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100526, new OO3awZ.A5SV6n("inverse_primary", new OO3awZ.ASJ6gh(4), new OO3awZ.ASJ6gh(5), false, new OO3awZ.ASJ6gh(azoqyo), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 7.0d), null));
        hashMap.put(2131100525, azoqyo.AYUAbz());
        hashMap.put(2131100514, new OO3awZ.A5SV6n("on_primary_container", new OO3awZ.ASJ6gh(12), new OO3awZ.ARc23Z(9, azoqyo), false, new OO3awZ.ARc23Z(10, azoqyo), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 11.0d), null));
        hashMap.put(2131100529, azoqyo.AZOQYO());
        hashMap.put(2131100515, new OO3awZ.A5SV6n("on_secondary", new OO3awZ.ASJ6gh(21), new OO3awZ.ASJ6gh(22), false, new OO3awZ.ARc23Z(13, azoqyo), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100530, azoqyo.AZkASS());
        hashMap.put(2131100516, new OO3awZ.A5SV6n("on_secondary_container", new OO3awZ.AYUAbz(3), new OO3awZ.ARc23Z(18, azoqyo), false, new OO3awZ.ARc23Z(19, azoqyo), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 11.0d), null));
        hashMap.put(2131100543, azoqyo.AaHO0E());
        hashMap.put(2131100520, new OO3awZ.A5SV6n("on_tertiary", new OO3awZ.ASJ6gh(11), new OO3awZ.ASJ6gh(20), false, new OO3awZ.ARc23Z(15, azoqyo), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100544, azoqyo.AcNBzu());
        hashMap.put(2131100521, new OO3awZ.A5SV6n("on_tertiary_container", new OO3awZ.AYUAbz(2), new OO3awZ.ARc23Z(16, azoqyo), false, new OO3awZ.ARc23Z(17, azoqyo), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 11.0d), null));
        hashMap.put(2131100504, new OO3awZ.A5SV6n("background", new OO3awZ.AMqCpz(19), new OO3awZ.AMqCpz(20), true, null, null, null));
        hashMap.put(2131100510, new OO3awZ.A5SV6n("on_background", new OO3awZ.AMqCpz(24), new OO3awZ.AMqCpz(25), false, new OO3awZ.AMqCpz(azoqyo), new OO3awZ.A4TApA(3.0d, 3.0d, 4.5d, 7.0d), null));
        hashMap.put(2131100533, new OO3awZ.A5SV6n("surface", new OO3awZ.AMqCpz(0), new OO3awZ.AMqCpz(14), true, null, null, null));
        hashMap.put(2131100517, new OO3awZ.A5SV6n("on_surface", new OO3awZ.AYUAbz(4), new OO3awZ.AYUAbz(13), false, new OO3awZ.AYUAbz(azoqyo, 22), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100542, new OO3awZ.A5SV6n("surface_variant", new OO3awZ.ASJ6gh(13), new OO3awZ.ASJ6gh(14), true, null, null, null));
        hashMap.put(2131100519, new OO3awZ.A5SV6n("on_surface_variant", new OO3awZ.AYUAbz(11), new OO3awZ.AYUAbz(12), false, new OO3awZ.AYUAbz(azoqyo, 22), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 11.0d), null));
        hashMap.put(2131100541, OO3awZ.AZOQYO.ADYaiT());
        hashMap.put(2131100518, new OO3awZ.A5SV6n("inverse_on_surface", new OO3awZ.ASJ6gh(29), new OO3awZ.AYUAbz(0), false, new OO3awZ.AYUAbz(azoqyo, 1), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100534, new OO3awZ.A5SV6n("surface_bright", new OO3awZ.AMqCpz(29), new OO3awZ.ASJ6gh(0), true, null, null, null));
        hashMap.put(2131100540, new OO3awZ.A5SV6n("surface_dim", new OO3awZ.AMqCpz(5), new OO3awZ.AMqCpz(6), true, null, null, null));
        hashMap.put(2131100535, new OO3awZ.A5SV6n("surface_container", new OO3awZ.AYUAbz(9), new OO3awZ.AYUAbz(10), true, null, null, null));
        hashMap.put(2131100538, new OO3awZ.A5SV6n("surface_container_low", new OO3awZ.AMqCpz(11), new OO3awZ.AMqCpz(12), true, null, null, null));
        hashMap.put(2131100536, new OO3awZ.A5SV6n("surface_container_high", new OO3awZ.AMqCpz(22), new OO3awZ.AMqCpz(23), true, null, null, null));
        hashMap.put(2131100539, new OO3awZ.A5SV6n("surface_container_lowest", new OO3awZ.ASJ6gh(25), new OO3awZ.ASJ6gh(26), true, null, null, null));
        hashMap.put(2131100537, new OO3awZ.A5SV6n("surface_container_highest", new OO3awZ.ASJ6gh(17), new OO3awZ.ASJ6gh(18), true, null, null, null));
        hashMap.put(2131100522, new OO3awZ.A5SV6n("outline", new OO3awZ.ASJ6gh(27), new OO3awZ.ASJ6gh(28), false, new OO3awZ.AYUAbz(azoqyo, 22), new OO3awZ.A4TApA(1.5d, 3.0d, 4.5d, 7.0d), null));
        hashMap.put(2131100523, new OO3awZ.A5SV6n("outline_variant", new OO3awZ.AMqCpz(27), new OO3awZ.AMqCpz(28), false, new OO3awZ.AYUAbz(azoqyo, 22), new OO3awZ.A4TApA(1.0d, 1.0d, 3.0d, 4.5d), null));
        hashMap.put(2131100508, azoqyo.A2egSU());
        hashMap.put(2131100511, new OO3awZ.A5SV6n("on_error", new OO3awZ.ASJ6gh(7), new OO3awZ.ASJ6gh(8), false, new OO3awZ.ARc23Z(8, azoqyo), new OO3awZ.A4TApA(4.5d, 7.0d, 11.0d, 21.0d), null));
        hashMap.put(2131100509, azoqyo.A4TApA());
        hashMap.put(2131100512, new OO3awZ.A5SV6n("on_error_container", new OO3awZ.AYUAbz(16), new OO3awZ.AYUAbz(17), false, new OO3awZ.ARc23Z(21, azoqyo), new OO3awZ.A4TApA(3.0d, 4.5d, 7.0d, 11.0d), null));
        hashMap.put(2131100505, OO3awZ.A5SV6n.A4TApA("control_activated", new OO3awZ.AMqCpz(9), new OO3awZ.AMqCpz(10)));
        hashMap.put(2131100507, OO3awZ.A5SV6n.A4TApA("control_normal", new OO3awZ.AMqCpz(7), new OO3awZ.AMqCpz(8)));
        hashMap.put(2131100506, new OO3awZ.A5SV6n(new OO3awZ.AMqCpz(15), new OO3awZ.AMqCpz(16), new OO3awZ.AMqCpz(17)));
        hashMap.put(2131100546, OO3awZ.A5SV6n.A4TApA("text_primary_inverse", new OO3awZ.AYUAbz(7), new OO3awZ.AYUAbz(8)));
        hashMap.put(2131100548, OO3awZ.A5SV6n.A4TApA("text_secondary_and_tertiary_inverse", new OO3awZ.AYUAbz(18), new OO3awZ.AYUAbz(19)));
        hashMap.put(2131100549, OO3awZ.A5SV6n.A4TApA("text_secondary_and_tertiary_inverse_disabled", new OO3awZ.AMqCpz(21), new OO3awZ.ASJ6gh(2)));
        hashMap.put(2131100547, OO3awZ.A5SV6n.A4TApA("text_primary_inverse_disable_only", new OO3awZ.ASJ6gh(9), new OO3awZ.ASJ6gh(10)));
        hashMap.put(2131100545, OO3awZ.A5SV6n.A4TApA("text_hint_inverse", new OO3awZ.ASJ6gh(15), new OO3awZ.ASJ6gh(16)));
        f6380A2egSU = Collections.unmodifiableMap(hashMap);
        aRtTOeh();
    }

    private static /* synthetic */ void aRtTOeh() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
