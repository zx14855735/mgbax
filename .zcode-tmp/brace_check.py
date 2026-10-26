import re

files = [
    r'D:\mgba-android-version\ios\mGBA\ControlsView.swift',
    r'D:\mgba-android-version\ios\mGBA\EmulatorViewController.swift',
    r'D:\mgba-android-version\ios\mGBA\AudioOut.swift',
    r'D:\mgba-android-version\ios\mGBA\ShellStageView.swift',
]
for f in files:
    s = open(f, encoding='utf-8').read()
    s = re.sub(r'//[^\n]*', '', s)
    s = re.sub(r'/\*.*?\*/', '', s, flags=re.S)
    s = re.sub(r'"(?:[^"\\]|\\.)*"', '', s)
    b = s.count('{') - s.count('}')
    p = s.count('(') - s.count(')')
    k = s.count('[') - s.count(']')
    print(f.split('\\')[-1], 'braces:', b, 'parens:', p, 'brackets:', k)
