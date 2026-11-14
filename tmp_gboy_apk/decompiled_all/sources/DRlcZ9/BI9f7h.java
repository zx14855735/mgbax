package DRlcZ9;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h {
    public static final Class[] AMqCpz = {Context.class, AttributeSet.class};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final HashMap f2122ARc23Z = new HashMap();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f2123A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BNL6CD f2125A5SV6n;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object[] f2124A4TApA = new Object[2];

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String[] f2126ADYaiT = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    static {
        CqlCv();
    }

    public BI9f7h(Context context, BNL6CD bnl6cd) {
        this.f2123A2egSU = context;
        this.f2125A5SV6n = bnl6cd;
    }

    private static /* synthetic */ void CqlCv() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final Preference A2egSU(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> cls;
        HashMap hashMap = f2122ARc23Z;
        Constructor<?> constructor = (Constructor) hashMap.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f2123A2egSU.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        cls = null;
                        ClassNotFoundException e = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                            }
                        }
                        if (cls == null) {
                            if (e != null) {
                                throw e;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                        constructor = cls.getConstructor(AMqCpz);
                        constructor.setAccessible(true);
                        hashMap.put(str, constructor);
                    }
                    cls = Class.forName(str, false, classLoader);
                    constructor = cls.getConstructor(AMqCpz);
                    constructor.setAccessible(true);
                    hashMap.put(str, constructor);
                } catch (Exception e3) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e3);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e4) {
                throw e4;
            }
        }
        Object[] objArr = this.f2124A4TApA;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference A4TApA(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? A2egSU(str, this.f2126ADYaiT, attributeSet) : A2egSU(str, null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    public final PreferenceGroup A5SV6n(XmlResourceParser xmlResourceParser) {
        int next;
        PreferenceGroup preferenceGroup;
        synchronized (this.f2124A4TApA) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
            this.f2124A4TApA[0] = this.f2123A2egSU;
            do {
                try {
                    try {
                        next = xmlResourceParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (InflateException e) {
                        throw e;
                    }
                } catch (IOException e2) {
                    InflateException inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroup = (PreferenceGroup) A4TApA(xmlResourceParser.getName(), asAttributeSet);
            preferenceGroup.AcNBzu(this.f2125A5SV6n);
            ADYaiT(xmlResourceParser, preferenceGroup, asAttributeSet);
        }
        return preferenceGroup;
    }

    public final void ADYaiT(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.f9089BIYEnU = Intent.parseIntent(getContext().getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e);
                        throw xmlPullParserException;
                    }
                } else if (BaseConstants.EVENT_LABEL_EXTRA.equals(name)) {
                    Resources resources = getContext().getResources();
                    if (preference.f9091BNL6CD == null) {
                        preference.f9091BNL6CD = new Bundle();
                    }
                    resources.parseBundleExtra(BaseConstants.EVENT_LABEL_EXTRA, attributeSet, preference.f9091BNL6CD);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 != 1 && (next2 != 3 || xmlResourceParser.getDepth() > depth2)) {
                            }
                        }
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference A4TApA2 = A4TApA(name, attributeSet);
                    ((PreferenceGroup) preference).BmvVmW(A4TApA2);
                    ADYaiT(xmlResourceParser, A4TApA2, attributeSet);
                }
            }
        }
    }

    public Context getContext() {
        return this.f2123A2egSU;
    }
}
