import shutil
for d in ('C:', 'D:'):
    t, u, f = shutil.disk_usage(d + '\\')
    print(d, 'free %.1f GB / total %.1f GB' % (f / 2**30, t / 2**30))
