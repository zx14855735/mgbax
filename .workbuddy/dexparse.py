import struct, sys, json, collections

class Dex:
    def __init__(self, path):
        self.d = open(path,'rb').read()
        d = self.d
        assert d[:4]==b'dex\n', d[:8]
        self.header = {}
        self.checksum = struct.unpack_from('<I', d, 8)[0]
        self.sig = d[12:32]
        (self.file_size, self.header_size, self.endian_tag,
         self.link_size, self.link_off, self.map_off, self.string_ids_size, self.string_ids_off,
         self.type_ids_size, self.type_ids_off, self.proto_ids_size, self.proto_ids_off,
         self.field_ids_size, self.field_ids_off, self.method_ids_size, self.method_ids_off,
         self.class_defs_size, self.class_defs_off, self.data_size, self.data_off) = struct.unpack_from('<20I', d, 32)
        # strings
        self.strings = []
        self.str_off = []
        for i in range(self.string_ids_size):
            off = struct.unpack_from('<I', d, self.string_ids_off + i*4)[0]
            self.str_off.append(off)
            # uleb128 length then MUTF-8
            p = off
            n, p = self.uleb(p)
            end = d.find(b'\x00', p)
            try:
                s = d[p:end].decode('utf-8', 'replace')
            except Exception:
                s = ''
            self.strings.append(s)
        # types
        self.types = []
        for i in range(self.type_ids_size):
            idx = struct.unpack_from('<I', d, self.type_ids_off + i*4)[0]
            self.types.append(self.strings[idx])
        # protos
        self.proto_shorty = []; self.proto_ret = []; self.proto_params=[]
        for i in range(self.proto_ids_size):
            shorty_i, ret_i, params_off = struct.unpack_from('<III', d, self.proto_ids_off + i*12)
            self.proto_shorty.append(self.strings[shorty_i])
            self.proto_ret.append(self.types[ret_i])
            params=[]
            if params_off:
                sz = struct.unpack_from('<I', d, params_off)[0]
                for k in range(sz):
                    t = struct.unpack_from('<H', d, params_off+4+k*2)[0]
                    params.append(self.types[t])
            self.proto_params.append(params)
        # fields
        self.fields = []
        for i in range(self.field_ids_size):
            cls_i, type_i, name_i = struct.unpack_from('<HHI', d, self.field_ids_off + i*8)
            self.fields.append((self.types[cls_i], self.types[type_i], self.strings[name_i]))
        # methods
        self.methods = []
        for i in range(self.method_ids_size):
            cls_i, proto_i, name_i = struct.unpack_from('<HHI', d, self.method_ids_off + i*8)
            self.methods.append((self.types[cls_i], self.strings[name_i], self.proto_shorty[proto_i], self.proto_ret[proto_i], self.proto_params[proto_i]))
        # class defs
        self.classes = []
        for i in range(self.class_defs_size):
            off = self.class_defs_off + i*32
            cidx, flags, sidx, ifoff, srcfile_i, annotoff, classdata_off, staticoff = struct.unpack_from('<8I', d, off)
            self.classes.append(dict(type_idx=cidx, flags=flags, superclass_idx=sidx,
                source_file=self.strings[srcfile_i] if srcfile_i!=0xffffffff else None,
                classdata_off=classdata_off, static_values_off=staticoff))

    def uleb(self, p):
        r=0; s=0
        while True:
            b=self.d[p]; p+=1
            r |= (b & 0x7f) << s
            if not (b & 0x80): break
            s += 7
        return r, p

    def class_methods(self, ci):
        """return list of (method_idx, access_flags, code_off)"""
        cd = self.classes[ci]['classdata_off']
        if cd == 0: return []
        p = cd
        sf, p = self.uleb(p); inf, p = self.uleb(p)
        dm, p = self.uleb(p); vm, p = self.uleb(p)
        out = []
        idx = 0
        for i in range(sf):
            idx_diff, p = self.uleb(p); idx += idx_diff
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('static', idx, af, code))
        idx = 0
        for i in range(inf):
            idx_diff, p = self.uleb(p); idx += idx_diff
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('instance', idx, af, code))
        idx = 0
        for i in range(dm):
            idx_diff, p = self.uleb(p); idx += idx_diff
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('direct', idx, af, code))
        idx = 0
        for i in range(vm):
            idx_diff, p = self.uleb(p); idx += idx_diff
            af, p = self.uleb(p); code, p = self.uleb(p)
            out.append(('virtual', idx, af, code))
        return out

    def code_insns(self, code_off):
        """yield (off, opcode_name, operands) for a code_item"""
        d=self.d
        regs, ins, outs, tries = struct.unpack_from('<4H', d, code_off)
        insns_size = struct.unpack_from('<I', d, code_off+12)[0]
        base = code_off + 16
        p = 0
        while p < insns_size:
            op = d[base+p]
            name, fmt = OPCODES.get(op, ('unk%02x'%op, 'none'))
            ln = fmt_len(fmt)
            ops = d[base+p+1: base+p+ln]
            yield (p, name, ops, fmt)
            p += ln

OPCODES = {}
def _o(c,n,f): OPCODES[c]=(n,f)
# minimal table: name -> format string of operand widths
T = {
0x00:('nop','10x'),0x01:('move','22x'),0x02:('move/from16','32x'),0x03:('move/16','32x'),
0x04:('move-wide','22x'),0x05:('move-wide/from16','32x'),0x06:('move-wide/16','32x'),
0x07:('move-object','22x'),0x08:('move-object/from16','32x'),0x09:('move-object/16','32x'),
0x0a:('move-result','11x'),0x0b:('move-result-wide','11x'),0x0c:('move-result-object','11x'),
0x0d:('move-exception','11x'),0x0e:('return-void','10x'),0x0f:('return','11x'),0x10:('return-wide','11x'),
0x11:('return-object','11x'),0x12:('const/4','11n'),0x13:('const/16','21s'),
0x14:('const','31i'),0x15:('const/high16','21h'),0x16:('const-wide/16','21s'),
0x17:('const-wide/32','51i'),0x18:('const-wide','51i'),0x19:('const-wide/high16','21h'),
0x1a:('const-string','21c'),0x1b:('const-string/jumbo','31c'),
0x1c:('const-class','21c'),0x1d:('monitor-enter','11x'),0x1e:('monitor-exit','11x'),
0x1f:('check-cast','21c'),0x20:('instance-of','22c'),0x21:('array-length','12x'),
0x22:('new-instance','21c'),0x23:('new-array','22c'),0x24:('filled-new-array','35c'),
0x25:('filled-new-array/range','3rc'),0x26:('fill-array-data','31t'),
0x27:('throw','11x'),0x28:('goto','10t'),0x29:('goto/16','20t'),0x2a:('goto/32','30t'),
0x2b:('packed-switch','31t'),0x2c:('sparse-switch','31t'),
0x2d:('cmpl-float','23x'),0x2e:('cmpg-float','23x'),0x2f:('cmpl-double','23x'),
0x30:('cmpg-double','23x'),0x31:('cmp-long','23x'),
0x32:('if-eq','22t'),0x33:('if-ne','22t'),0x34:('if-lt','22t'),0x35:('if-ge','22t'),
0x36:('if-gt','22t'),0x37:('if-le','22t'),0x38:('if-eqz','21t'),0x39:('if-nez','21t'),
0x3a:('if-ltz','21t'),0x3b:('if-gez','21t'),0x3c:('if-gtz','21t'),0x3d:('if-lez','21t'),
0x44:('aget','23x'),0x45:('aget-wide','23x'),0x46:('aget-object','23x'),0x47:('aget-boolean','23x'),
0x48:('aget-byte','23x'),0x49:('aget-char','23x'),0x4a:('aget-short','23x'),
0x4b:('aput','23x'),0x4c:('aput-wide','23x'),0x4d:('aput-object','23x'),0x4e:('aput-boolean','23x'),
0x4f:('aput-byte','23x'),0x50:('aput-char','23x'),0x51:('aput-short','23x'),
0x52:('iget','22c'),0x53:('iget-wide','22c'),0x54:('iget-object','22c'),0x55:('iget-boolean','22c'),
0x56:('iget-byte','22c'),0x57:('iget-char','22c'),0x58:('iget-short','22c'),
0x59:('iput','22c'),0x5a:('iput-wide','22c'),0x5b:('iput-object','22c'),0x5c:('iput-boolean','22c'),
0x5d:('iput-byte','22c'),0x5e:('iput-char','22c'),0x5f:('iput-short','22c'),
0x60:('sget','21c'),0x61:('sget-wide','21c'),0x62:('sget-object','21c'),0x63:('sget-boolean','21c'),
0x64:('sget-byte','21c'),0x65:('sget-char','21c'),0x66:('sget-short','21c'),
0x67:('sput','21c'),0x68:('sput-wide','21c'),0x69:('sput-object','21c'),0x6a:('sput-boolean','21c'),
0x6b:('sput-byte','21c'),0x6c:('sput-char','21c'),0x6d:('sput-short','21c'),
0x6e:('invoke-virtual','35c'),0x6f:('invoke-super','35c'),0x70:('invoke-direct','35c'),
0x71:('invoke-static','35c'),0x72:('invoke-interface','35c'),
0x74:('invoke-virtual/range','3rc'),0x75:('invoke-super/range','3rc'),0x76:('invoke-direct/range','3rc'),
0x77:('invoke-static/range','3rc'),0x78:('invoke-interface/range','3rc'),
0x90:('add-int','23x'),0x91:('sub-int','23x'),0x92:('mul-int','23x'),0x93:('div-int','23x'),
0x94:('rem-int','23x'),0x95:('and-int','23x'),0x96:('or-int','23x'),0x97:('xor-int','23x'),
0x98:('shl-int','23x'),0x99:('shr-int','23x'),0x9a:('ushr-int','23x'),
0xb0:('add-int/2addr','12x'),0xb1:('sub-int/2addr','12x'),0xb2:('mul-int/2addr','12x'),
0xb3:('div-int/2addr','12x'),0xb4:('rem-int/2addr','12x'),0xb5:('and-int/2addr','12x'),
0xb6:('or-int/2addr','12x'),0xb7:('xor-int/2addr','12x'),
0x90+0x0f:('ushr-int/lit8','22b'),
0xd0:('add-int/lit8','22b'),0xd1:('rsub-int/lit8','22b'),0xd2:('mul-int/lit8','22b'),
0xd3:('div-int/lit8','22b'),0xd4:('rem-int/lit8','22b'),0xd5:('and-int/lit8','22b'),
0xd6:('or-int/lit8','22b'),0xd7:('xor-int/lit8','22b'),0xd8:('shl-int/lit8','22b'),
0xd9:('shr-int/lit8','22b'),0xda:('ushr-int/lit8','22b'),
0xb8:('add-int/lit16','22s'),0xb9:('rsub-int','22s'),0xba:('mul-int/lit16','22s'),
0xbb:('div-int/lit16','22s'),0xbc:('rem-int/lit16','22s'),0xbd:('and-int/lit16','22s'),
0xbe:('or-int/lit16','22s'),0xbf:('xor-int/lit16','22s'),
0xc0:('shl-int/lit16','22s'),0xc1:('shr-int/lit16','22s'),0xc2:('ushr-int/lit16','22s'),
0x00+0xd7:('x',''),
}
# fill remaining with generic
def fmt_len(f):
    # f chars: digits are code units
    n=0
    for ch in f:
        if ch.isdigit(): n = n*10 + int(ch)
        elif ch=='x': n = n*10 + 1
        elif ch in 's': n = n*10+2
        elif ch=='t': n = n*10+2
        elif ch=='c': n = n*10+2
        elif ch=='i': n = n*10+4
        elif ch=='h': n = n*10+2
        elif ch=='b': n = n*10+2
        elif ch=='r': n = n*10+2
    return max(n,1)

if __name__=='__main__':
    dx = Dex(sys.argv[1])
    print('strings', len(dx.strings), 'types', len(dx.types), 'methods', len(dx.methods), 'classes', len(dx.classes))
    if len(sys.argv)>2:
        pat = sys.argv[2]
        import re
        for i,s in enumerate(dx.strings):
            if re.search(pat, s):
                print('  STR[%d] = %r' % (i, s))
