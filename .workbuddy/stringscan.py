import re, sys, os, collections

def strings(data, minlen=4):
    # ASCII
    for m in re.finditer(rb'[\x20-\x7e]{%d,}' % minlen, data):
        yield m.start(), m.group().decode('ascii')
    # UTF-16LE
    for m in re.finditer(rb'(?:[\x20-\x7e]\x00){%d,}' % minlen, data):
        yield m.start(), m.group().decode('utf-16le')

URL_RE = re.compile(r'https?://[A-Za-z0-9\-._~:/?#\[\]@!$&\'()*+,;=%]{3,200}')
DOM_RE = re.compile(r'\b(?:[a-zA-Z0-9](?:[a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+(?:com|cn|net|org|io|cc|top|xyz|info|biz|tv|me|app|dev|cloud|game|games|store|team|work|link|live|fun|wang|club|site|online|pro|vip|icu)\b')
IP_RE  = re.compile(r'\b(?:\d{1,3}\.){3}\d{1,3}(?::\d{1,5})?\b')
PORT_RE= re.compile(r'\b(?:port|PORT|Port)\b')

def analyze(path, label):
    data = open(path,'rb').read()
    urls=collections.Counter(); doms=collections.Counter(); ips=collections.Counter()
    allstr=[]
    for off,s in strings(data):
        allstr.append((off,s))
        for u in URL_RE.findall(s): urls[u]+=1
        for d in DOM_RE.findall(s): doms[d]+=1
        for i in IP_RE.findall(s): ips[i]+=1
    print('='*70)
    print('FILE', label, os.path.getsize(path))
    print('  URLs:', len(urls))
    for u,c in urls.most_common(80): print('    ', c, u)
    print('  IPs:', len(ips))
    for i,c in ips.most_common(60): print('    ', c, i)
    print('  DOMAINS:', len(doms))
    for dd,c in doms.most_common(120): print('    ', c, dd)
    return allstr

if __name__=='__main__':
    for p in sys.argv[1:]:
        analyze(p, p)
