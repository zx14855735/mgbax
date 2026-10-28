import subprocess

ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SERIAL = 'emulator-5556'

XML = """<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="orientation">landscape</string>
    <string name="layout_p_默认"></string>
    <boolean name="save_access_declined" value="false" />
    <string name="lastRom">/sdcard/Android/data/io.mgba.android/files/quetzal.gba</string>
    <string name="gboy_ip">10.0.2.2</string>
    <int name="gboy_port" value="16374" />
</map>
"""
proc = subprocess.Popen([ADB, '-s', SERIAL, 'shell', 'run-as', 'io.mgba.android',
                         'sh', '-c', r'cat > /data/data/io.mgba.android/shared_prefs/EmulatorActivity.xml'],
                        stdin=subprocess.PIPE)
proc.communicate(XML.encode('utf-8'))
print('rc', proc.returncode)
out = subprocess.run([ADB, '-s', SERIAL, 'shell', 'run-as', 'io.mgba.android',
                      'cat', 'shared_prefs/EmulatorActivity.xml'], capture_output=True)
print(out.stdout.decode('utf-8', errors='replace'))
