package com.kwad.library.b.a;

import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> aue;
    private final List<String> auf;
    private final ClassLoader aug;

    public b(ClassLoader classLoader, String str, File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aug = classLoader;
        this.aue = list;
        this.auf = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        if (TextUtils.isEmpty(findLibrary)) {
            ClassLoader classLoader = this.aug;
            if (classLoader instanceof BaseDexClassLoader) {
                return ((BaseDexClassLoader) classLoader).findLibrary(str);
            }
        }
        return findLibrary;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        List<String> list = this.aue;
        if (list != null && list.contains(str)) {
            return super.loadClass(str, z);
        }
        List<String> list2 = this.auf;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e2) {
                e2.addSuppressed(e);
                throw e2;
            }
        }
    }
}
