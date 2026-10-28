import io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
path = sys.argv[1]
start = int(sys.argv[2]) if len(sys.argv) > 2 else 0
end = int(sys.argv[3]) if len(sys.argv) > 3 else 8000
data = open(path, encoding='utf-8', errors='replace').read()
print('total chars:', len(data))
print(data[start:end])
