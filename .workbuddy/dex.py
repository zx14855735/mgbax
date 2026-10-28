"""Pure-python DEX parser + disassembler for DCloud-packed multi-dex containers."""
import struct, sys, re
from dalvik import OPS


class Dex:
    def __init__(self, path=None, data=None):
        self.d = data if data is not None else open(path, 'rb').read()
        d = self.d
        assert d[:4] == b'dex\n', d[:8]
        self.checksum = struct.unpack_from('<I', d, 8)[0]
        self.sig = d[12:32]
        (self.file_size, self.header_size, self.endian_tag,
         self.link_size, self.link_off, self.map_off,
         self.string_ids_size, self.string_ids_off,
         self.type_ids_size, self.type_ids_off,
         self.proto_ids_size, self.proto_ids_off,
         self.field_ids_size, self.field_ids_off,
         self.method_ids_size, self.method_ids_off,
         self.class_defs_size, self.class_defs_off,
         self.data_size, self.data_off) = struct.unpack_from('<20I', d, 32)

        # --- strings ---
        self.strings = []
        for i in range(self.string_ids_size):
            off = struct.unpack_from('<I', d, self.string_ids_off + i * 4)[0]
            p = off
            _n, p = self.uleb(p)
            end = d.find(b'\x00', p)
            self.strings.append(d[p:end].decode('utf-8', 'replace'))

        # --- types ---
        self.types = []
        for i in range(self.type_ids_size):
            idx = struct.unpack_from('<I', d, self.type_ids_off + i * 4)[0]
            self.types.append(self.strings[idx])

        # --- protos ---
        self.proto_shorty = []; self.proto_ret = []; self.proto_params = []
        for i in range(self.proto_ids_size):
            shorty_i, ret_i, params_off = struct.unpack_from('<III', d, self.proto_ids_off + i * 12)
            self.proto_shorty.append(self.strings[shorty_i])
            self.proto_ret.append(self.types[ret_i])
            params = []
            if params_off:
                sz = struct.unpack_from('<I', d, params_off)[0]
                for k in range(sz):
                    t = struct.unpack_from('<H', d, params_off + 4 + k * 2)[0]
                    params.append(self.types[t])
            self.proto_params.append(params)

        # --- fields ---
        self.fields = []
        for i in range(self.field_ids_size):
            cls_i, type_i, name_i = struct.unpack_from('<HHI', d, self.field_ids_off + i * 8)
            self.fields.append((self.types[cls_i], self.types[type_i], self.strings[name_i]))

        # --- methods ---
        self.methods = []
        for i in range(self.method_ids_size):
            cls_i, proto_i, name_i = struct.unpack_from('<HHI', d, self.method_ids_off + i * 8)
            self.methods.append((self.types[cls_i], self.strings[name_i],
                                 self.proto_shorty[proto_i], self.proto_ret[proto_i],
                                 self.proto_params[proto_i]))

        # --- class defs ---
        self.classes = []
        for i in range(self.class_defs_size):
            off = self.class_defs_off + i * 32
            (cidx, flags, sidx, ifoff, srcfile_i, annotoff,
             classdata_off, staticoff) = struct.unpack_from('<8I', d, off)
            self.classes.append(dict(
                type_idx=cidx, flags=flags, superclass_idx=sidx,
                source_file=self.strings[srcfile_i] if srcfile_i != 0xffffffff else None,
                classdata_off=classdata_off, static_values_off=staticoff))

    def uleb(self, p):
        r = 0; s = 0
        while True:
            b = self.d[p]; p += 1
            r |= (b & 0x7f) << s
            if not (b & 0x80):
                break
            s += 7
        return r, p

    def class_methods(self, ci):
        """class_data_item: static_fields, instance_fields, direct_methods, virtual_methods.
        method_idx_diff for methods continues across direct->virtual boundary."""
        cd = self.classes[ci]['classdata_off']
        if cd == 0:
            return []
        p = cd
        sf, p = self.uleb(p); inf, p = self.uleb(p)
        dm, p = self.uleb(p); vm, p = self.uleb(p)
        # fields
        idx = 0
        for i in range(sf):
            i2, p = self.uleb(p); idx += i2
            af, p = self.uleb(p); _c, p = self.uleb(p)
        idx = 0
        for i in range(inf):
            i2, p = self.uleb(p); idx += i2
            af, p = self.uleb(p); _c, p = self.uleb(p)
        # methods: direct then virtual, idx continues across the boundary
        out = []
        idx = 0
        for i in range(dm):
            i2, p = self.uleb(p); idx += i2
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('direct', idx, af, code))
        for i in range(vm):
            i2, p = self.uleb(p); idx += i2
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('virtual', idx, af, code))
        return out

    def code_info(self, code_off):
        """return (registers, ins, outs, insns_bytes, base_off)"""
        d = self.d
        regs, ins, outs, tries = struct.unpack_from('<4H', d, code_off)
        size = struct.unpack_from('<I', d, code_off + 12)[0]
        return regs, ins, outs, d[code_off + 16: code_off + 16 + size * 2], code_off + 16

    def disasm(self, code_off):
        """yield (off, name, operands_bytes, extra_description)"""
        d = self.d
        regs, ins, outs, raw, base = self.code_info(code_off)
        p = 0
        n = len(raw)
        while p < n:
            op = raw[p]
            name, fmt, ln = OPS.get(op, ('unk%02x' % op, '', 1))
            size = ln * 2
            ops = raw[p + 1: p + size]
            yield (p, name, ops, fmt, op)
            p += size

    def describe(self, name, ops, fmt, op):
        """human-readable operand description"""
        d = self.d
        try:
            if name in ('const-string',):
                return '"%s"' % self.strings[struct.unpack_from('<H', ops, 0)[0]]
            if name == 'const-string/jumbo':
                return '"%s"' % self.strings[struct.unpack_from('<I', ops, 0)[0]]
            if name == 'const-class':
                return self.types[struct.unpack_from('<H', ops, 0)[0]]
            if name == 'check-cast':
                return self.types[struct.unpack_from('<H', ops, 0)[0]]
            if name in ('instance-of',):
                return self.types[struct.unpack_from('<H', ops, 0)[0]]
            if name == 'new-instance':
                return self.types[struct.unpack_from('<H', ops, 0)[0]]
            if name.startswith('invoke-'):
                idx = struct.unpack_from('<H', ops, 2)[0]
                c, mn, sh, r, pa = self.methods[idx]
                return '%s.%s(%s) -> %s' % (c, mn, ', '.join(pa), r)
            if name.startswith(('sget', 'sput', 'iget', 'iput')):
                idx = struct.unpack_from('<H', ops, 0)[0]
                c, t, fn = self.fields[idx]
                return '%s.%s : %s' % (c, fn, t)
            if name == 'const/4':
                v = ops[0] & 0x0f
                if v & 0x8: v -= 16
                return str(v)
            if name == 'const/16':
                return str(struct.unpack_from('<h', ops, 0)[0])
            if name == 'const':
                return str(struct.unpack_from('<i', ops, 0)[0])
            if name == 'const/high16':
                return hex(struct.unpack_from('<H', ops, 0)[0] << 16)
            if name in ('const-wide/16',):
                return str(struct.unpack_from('<h', ops, 0)[0])
            if name in ('const-wide/32',):
                return str(struct.unpack_from('<i', ops, 0)[0])
            if name == 'const-wide':
                return str(struct.unpack_from('<q', ops, 0)[0])
            if name.startswith('if-'):
                return '-> %04x' % (struct.unpack_from('<h', ops, 0)[0])
            if name.startswith('goto'):
                return '-> %04x' % (struct.unpack_from('<h', ops, 0)[0])
            if name == 'packed-switch' or name == 'sparse-switch':
                return 'table @ %08x' % (struct.unpack_from('<i', ops, 0)[0])
            if name == 'fill-array-data':
                return 'data @ %08x' % (struct.unpack_from('<i', ops, 0)[0])
        except Exception:
            pass
        return ''

    def method_str(self, midx):
        c, mn, sh, r, pa = self.methods[midx]
        return '%s.%s(%s)%s' % (c, mn, ', '.join(pa), ':' + r if r != 'V' else '')


def split_multidex(data):
    """split a DCloud multi-dex container into individual dex blobs"""
    offs = [m.start() for m in re.finditer(rb'dex\n', data)]
    out = []
    for o in offs:
        if o + 112 > len(data):
            continue
        fsz = struct.unpack_from('<I', data, o + 32)[0]
        if fsz <= 0 or o + fsz > len(data):
            fsz = len(data) - o
        out.append((o, data[o:o + fsz]))
    return out
