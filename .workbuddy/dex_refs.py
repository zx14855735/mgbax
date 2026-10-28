#!/usr/bin/env python
"""Minimal DEX parser: find methods that reference given strings (const-string).
Usage: python dex_refs.py classes.dex <needle> [needle2 ...]
"""
import struct, sys, io

class Dex:
    def __init__(self, data):
        self.d = data
        f = struct.unpack_from('<' + 'I' + '20s' + 'I' * 20, data, 8)
        (self.checksum, self.signature, self.file_size, self.header_size,
         self.endian_tag, self.link_size, self.link_off, self.map_off,
         self.string_ids_size, self.string_ids_off, self.type_ids_size,
         self.type_ids_off, self.proto_ids_size, self.proto_ids_off,
         self.field_ids_size, self.field_ids_off, self.method_ids_size,
         self.method_ids_off, self.class_defs_size, self.class_defs_off,
         self.data_size, self.data_off) = f

    def u32(self, off):
        return struct.unpack_from('<I', self.d, off)[0]

    def u16(self, off):
        return struct.unpack_from('<H', self.d, off)[0]

    def uleb(self, off):
        result = 0; shift = 0
        while True:
            b = self.d[off]; off += 1
            result |= (b & 0x7f) << shift
            if not (b & 0x80): break
            shift += 7
        return result, off

    def string(self, idx):
        off = self.u32(self.string_ids_off + idx * 4)
        _, p = self.uleb(off)          # utf16 length
        end = self.d.index(b'\x00', p)
        return self.d[p:end].decode('utf-8', 'replace')

    def type(self, idx):
        return self.string(self.u32(self.type_ids_off + idx * 4))

    def method(self, idx):
        o = self.method_ids_off + idx * 8
        cls_idx = self.u16(o); proto_idx = self.u16(o + 2); name_idx = self.u32(o + 4)
        return self.type(cls_idx), self.string(name_idx)

    def proto_ret(self, idx):
        o = self.proto_ids_off + idx * 12
        return self.type(self.u32(o + 4))

    def class_name(self, class_idx):
        return self.type(class_idx)

    # ---- class data ----
    def class_defs(self):
        n = self.class_defs_size
        base = self.class_defs_off
        for i in range(n):
            o = base + i * 32
            class_idx, access, super_idx, ifaces, src_idx, annos, cdata_off, sval = struct.unpack_from(
                '<IIIIIIII', self.d, o)
            yield class_idx, cdata_off

    def methods_of(self, cdata_off):
        """yield (method_idx, code_off, is_static)"""
        off = cdata_off
        sf, off = self.uleb(off)
        inf, off = self.uleb(off)
        dm, off = self.uleb(off)
        vm, off = self.uleb(off)
        for _ in range(sf):
            _, off = self.uleb(off)
            _, off = self.uleb(off)
        for _ in range(inf):
            _, off = self.uleb(off)
            _, off = self.uleb(off)
        for count, is_static in ((dm, True), (vm, False)):
            idx = 0
            for _ in range(count):
                diff, off = self.uleb(off)
                idx += diff
                acc, off = self.uleb(off)
                code_off, off = self.uleb(off)
                if idx >= self.method_ids_size:
                    return
                yield idx, code_off, is_static

    def code_insns(self, code_off):
        if code_off == 0:
            return b'', 0
        # code_item: registers(2) ins(2) outs(2) tries(2) debug(4) insns_size(4)
        insns_size = self.u32(code_off + 12)
        start = code_off + 16
        return self.d[start:start + insns_size * 2], insns_size


def scan(needle_list):
    data = open(sys.argv[1], 'rb').read()
    dex = Dex(data)
    needles = [n.lower() for n in needle_list]
    targets = {}
    for i in range(dex.string_ids_size):
        s = dex.string(i)
        low = s.lower()
        if any(n in low for n in needles):
            targets[i] = s

    print(f"[*] {len(targets)} strings matched", file=sys.stderr)
    hits = {}
    for class_idx, cdata in dex.class_defs():
        cname = dex.class_name(class_idx)
        for midx, code_off, is_static in dex.methods_of(cdata):
            insns, size = dex.code_insns(code_off)
            if not insns:
                continue
            # brute force over every code-unit boundary: a const-string whose
            # literal index matches one of our targets is almost certainly real.
            for off in range(0, len(insns) - 4, 2):
                op = insns[off]
                if op in (0x1a, 0x1b):
                    if op == 0x1a:
                        sidx = struct.unpack_from('<H', insns, off + 2)[0]
                    else:
                        if off + 6 > len(insns):
                            continue
                        sidx = struct.unpack_from('<I', insns, off + 2)[0]
                    if sidx in targets:
                        m, mn = dex.method(midx)
                        rec = (cname.replace('/', '.'), mn, midx)
                        lst = hits.setdefault(sidx, [])
                        if rec not in lst:
                            lst.append(rec)
    for sidx, s in targets.items():
        print(f"\n=== {s!r}")
        for c, m, _ in hits.get(sidx, []):
            print(f"    {c.replace('/','.')}  ->  {m}")

if __name__ == '__main__':
    scan(sys.argv[2:])
