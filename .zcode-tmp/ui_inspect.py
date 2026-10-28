import re
import sys

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

serial = sys.argv[1] if len(sys.argv) > 1 else dev.B
xml = dev.dump(serial)
for m in re.finditer(r'<node ([^>]*)/>', xml):
    attrs = dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1)))
    cls = attrs.get('class', '')
    if attrs.get('scrollable') == 'true' or cls.endswith('ScrollView') or cls.endswith('View'):
        print(cls, attrs.get('scrollable'), attrs.get('bounds'), repr(attrs.get('text', ''))[:80])
print('--- visible text ---')
for m in re.finditer(r'<node ([^>]*)/>', xml):
    attrs = dict(re.findall(r'([\w-]+)="([^"]*)"', m.group(1)))
    text = attrs.get('text', '')
    if text:
        print(repr(text)[:100], attrs.get('bounds'))
