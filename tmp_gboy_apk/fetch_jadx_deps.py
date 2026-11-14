import os, re, sys, urllib.request

BASE = "https://maven.aliyun.com/repository/public/"
OUT = "jadxlibs"
os.makedirs(OUT, exist_ok=True)

seen = set()
jars = []


def get(url):
    req = urllib.request.Request(url, headers={"User-Agent": "curl/8"})
    return urllib.request.urlopen(req, timeout=90).read()


def tag(block, t):
    m = re.search(r"<%s>(.*?)</%s>" % (t, t), block, re.S)
    return m.group(1).strip() if m else None


def resolve(g, a, v, depth=0):
    key = (g, a)
    if key in seen or depth > 6:
        return
    seen.add(key)
    path = BASE + g.replace(".", "/") + "/" + a + "/" + v + "/" + a + "-" + v
    pom = None
    try:
        pom = get(path + ".pom").decode("utf-8", "ignore")
    except Exception:
        return
    # skip if packaging is pom-only? still try jar
    jar_url = path + ".jar"
    fn = os.path.join(OUT, "%s-%s.jar" % (a, v))
    if not os.path.exists(fn):
        try:
            data = get(jar_url)
            open(fn, "wb").write(data)
            jars.append(fn)
        except Exception:
            pass
    # collect properties for ${} resolution
    props = {}
    for pm in re.finditer(r"<properties>(.*?)</properties>", pom, re.S):
        for m in re.finditer(r"<([A-Za-z0-9_.\-]+)>([^<]+)</\1>", pm.group(1)):
            props[m.group(1)] = m.group(2).strip()

    deps_block = re.search(r"<dependencies>(.*?)</dependencies>", pom, re.S)
    if not deps_block:
        return
    for m in re.finditer(r"<dependency>(.*?)</dependency>", deps_block.group(1), re.S):
        blk = m.group(1)
        scope = tag(blk, "scope") or "compile"
        if scope not in ("compile", "runtime"):
            continue
        dg, da, dv = tag(blk, "groupId"), tag(blk, "artifactId"), tag(blk, "version")
        if not dv:
            # try dependencyManagement / properties
            dv = props.get(da or "", None)
            if not dv:
                continue
        if "${" in dv:
            for k, val in props.items():
                dv = dv.replace("${%s}" % k, val)
            if "${" in dv:
                continue
        if tag(blk, "optional") == "true":
            continue
        resolve(dg, da, dv, depth + 1)


resolve("io.github.skylot", "jadx-cli", "1.5.1")
print("downloaded:", len(jars))
for j in jars:
    print("  ", j, os.path.getsize(j))
print("total in dir:", len(os.listdir(OUT)))
