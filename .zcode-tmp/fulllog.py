import subprocess, io, sys, re, collections
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
ADB = r'D:\Android\Sdk\platform-tools\adb.exe'
SER = {'A': 'emulator-5554', 'B': 'emulator-5556'}

for k, s in SER.items():
    r = subprocess.run([ADB, '-s', s, 'logcat', '-d', '-s', 'mGBA:*'],
                       capture_output=True, timeout=60)
    lines = r.stdout.decode('utf-8', 'replace').strip().splitlines()
    counts = collections.Counter()
    for ln in lines:
        msg = ln.split('I mGBA    : ', 1)[-1] if 'I mGBA    : ' in ln else ln
        if msg.startswith('SIO kick'):
            counts['kick'] += 1
        elif msg.startswith('SIO begin'):
            counts['begin'] += 1
        elif msg.startswith('SIO multi me='):
            counts['multi-ok'] += 1
            counts.setdefault('multi-last', msg)
        elif msg.startswith('SIO poll'):
            counts['poll'] += 1
            counts.setdefault('poll-last', msg)
        elif 'timeout' in msg:
            counts['timeout'] += 1
        elif msg.startswith('SIO CNT'):
            counts['cnt'] += 1
        elif msg.startswith('SIO mode'):
            counts['mode'] += 1
        else:
            counts['other'] += 1
            if counts['other'] <= 12:
                counts.setdefault('other-sample', '')
    print(f'==== {k} ({len(lines)} lines) ====')
    for kk, vv in counts.items():
        if kk in ('multi-last', 'poll-last'):
            print('  LAST', kk, ':', vv)
        else:
            print(f'  {kk}: {vv}')
    # show a few non-poll/kick lines verbatim
    shown = 0
    for ln in lines:
        msg = ln.split('I mGBA    : ', 1)[-1] if 'I mGBA    : ' in ln else ''
        if msg and not msg.startswith(('SIO poll', 'SIO kick')):
            print('   |', ln.split('I mGBA    : ')[-1][:120])
            shown += 1
            if shown >= 14:
                break
    print()
