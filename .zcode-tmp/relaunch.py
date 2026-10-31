"""Relaunch both emulators' app in lockstep and snapshot.

Usage: python relaunch.py [wait_seconds]
"""
import sys, time
import drv

wait = int(sys.argv[1]) if len(sys.argv) > 1 else 25

for d in (1, 2):
    drv.sh(d, 'am force-stop io.mgba.android')
time.sleep(1.5)
for d in (1, 2):
    drv.sh(d, 'am start -n io.mgba.android/.EmulatorActivity -d file:///sdcard/rom.gba')
print('launched, waiting %ds' % wait)
time.sleep(wait)
for d in (1, 2):
    p = drv.shot(d, 'r_%d.png' % d)
    print('shot', p)
print('done')
