import sys
import time

sys.path.insert(0, r'D:\mgba-android-version\.zcode-tmp')
import dev

serial = sys.argv[1]
label = sys.argv[2]

# Dismiss any soft keyboard and let the dialog settle.
dev.sh(serial, 'input', 'keyevent', '4')
time.sleep(0.8)

for i in range(15):
    xml = dev.dump(serial)
    n = dev.find(xml, label)
    if n:
        x, y = dev.bounds(n)
        print('found', label, 'after', i, 'at', x, y, n.get('bounds'))
        dev.tap(serial, x, y, 1.5)
        dev.snap(serial, 'tapped_' + serial[-4:])
        sys.exit(0)
    if serial == dev.A:
        swipe = ('600', '420', '600', '80')
    else:
        swipe = ('1200', '870', '1200', '170')
    dev.sh(serial, 'input', 'swipe', *swipe, '1500')
    time.sleep(0.8)

print('not found', label)
dev.show(serial)
