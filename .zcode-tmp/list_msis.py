import os
d = r'D:\mgba-android-version\.zcode-tmp\swix\AttachedContainer'
for n in sorted(os.listdir(d)):
    p = os.path.join(d, n)
    print(n, os.path.getsize(p))
