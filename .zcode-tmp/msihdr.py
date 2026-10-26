d = r'D:\mgba-android-version\.zcode-tmp\swix\AttachedContainer'
for n in ['a0', 'a1', 'a8', 'a9', 'a10', 'a11', 'a12']:
    with open(d + '\\' + n, 'rb') as f:
        head = f.read(8)
    print(n, head.hex())
