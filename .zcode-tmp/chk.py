import io, os, time
d = io.open(r'.zcode-tmp/gradle3.log', encoding='utf-8', errors='replace').read()
print(d[-500:] if d else 'EMPTY LOG')
p = r'android/app/build/outputs/apk/debug/app-debug.apk'
print('apk mtime', time.strftime('%H:%M:%S', time.localtime(os.path.getmtime(p))))
