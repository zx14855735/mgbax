import io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
data = open(r'D:\mgba-android-version\.zcode-tmp\oc_texts.txt', encoding='utf-8', errors='replace').read()
print('total chars:', len(data))
limit = int(sys.argv[1]) if len(sys.argv) > 1 else 0
end = int(sys.argv[2]) if len(sys.argv) > 2 else 8000
if limit:
    print(data[limit:end])
else:
    print(data[:end])
