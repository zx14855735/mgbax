import os, time
p = r'android/app/build/outputs/apk/debug/app-debug.apk'
st = os.stat(p)
print('size', st.st_size, 'mtime', time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(st.st_mtime)))
