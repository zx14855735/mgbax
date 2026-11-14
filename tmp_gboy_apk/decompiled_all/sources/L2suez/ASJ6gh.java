package L2suez;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String[] f4365A2egSU = {".gba", ".zip"};

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public File f4366A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public File f4367A4TApA;
    }

    static {
        uyPOin();
    }

    public static void A2egSU(File file, HashMap hashMap, ArrayList arrayList) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    A2egSU(file2, hashMap, arrayList);
                } else {
                    String lowerCase = file2.getName().toLowerCase(Locale.ROOT);
                    String[] strArr = f4365A2egSU;
                    int i = 0;
                    while (true) {
                        if (i >= 2) {
                            break;
                        }
                        if (!lowerCase.endsWith(strArr[i])) {
                            i++;
                        } else if (file2.length() > 0) {
                            String name = file2.getName();
                            int lastIndexOf = name.lastIndexOf(46);
                            if (lastIndexOf > 0) {
                                name = name.substring(0, lastIndexOf);
                            }
                            File file3 = (File) hashMap.get(name);
                            A2egSU a2egSU = new A2egSU();
                            a2egSU.f4366A2egSU = file2;
                            a2egSU.f4367A4TApA = file3;
                            arrayList.add(a2egSU);
                        }
                    }
                }
            }
        }
    }

    private static /* synthetic */ void uyPOin() {
        char[] charArray = "HDF\u0005LJFN\u0005IDR\u0005XCNGG\u0005aEBiYBOLN".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '+');
        }
        String str = new String(charArray);
        char[] charArray2 = "HGBEB_".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '+');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
