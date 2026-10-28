import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

serial = sys.argv[1]
if serial == dev.A:
    menu, link = (481, 410), (752, 33)
    swipe = ('600', '420', '600', '80')
else:
    menu, link = (1019, 820), (1517, 60)
    swipe = ('1200', '870', '1200', '170')

dev.tap(serial, *menu, 0.5)
dev.tap(serial, *link, 1.2)

for i in range(12):
    xml = dev.dump(serial)
    n = dev.find(xml, '大厅创建')
    if n:
        x, y = dev.bounds(n)
        print('found after', i, 'scrolls at', x, y, n.get('bounds'))
        break
    dev.sh(serial, 'input', 'swipe', *swipe, '1500')
    time.sleep(0.8)
else:
    print('not found')
    dev.show(serial)
