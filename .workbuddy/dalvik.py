"""Dalvik opcode metadata: name, format, instruction length (in 16-bit units)."""
OPS = {}
def add(code, name, fmt, ln):
    OPS[code] = (name, fmt, ln)

# --- format helpers ---
# fmt chars: n=1b(reg) s=2b i=4b c=2b(string/type/field/method idx) j=4b
# lengths computed explicitly
add(0x00,'nop','10x',1)
add(0x01,'move','12x',1)
add(0x02,'move/from16','22x',2)
add(0x03,'move/16','32x',3)
add(0x04,'move-wide','12x',1)
add(0x05,'move-wide/from16','22x',2)
add(0x06,'move-wide/16','32x',3)
add(0x07,'move-object','12x',1)
add(0x08,'move-object/from16','22x',2)
add(0x09,'move-object/16','32x',3)
add(0x0a,'move-result','11x',1)
add(0x0b,'move-result-wide','11x',1)
add(0x0c,'move-result-object','11x',1)
add(0x0d,'move-exception','11x',1)
add(0x0e,'return-void','10x',1)
add(0x0f,'return','11x',1)
add(0x10,'return-wide','11x',1)
add(0x11,'return-object','11x',1)
add(0x12,'const/4','11n',1)
add(0x13,'const/16','21s',2)
add(0x14,'const','31i',3)
add(0x15,'const/high16','21h',2)
add(0x16,'const-wide/16','21s',2)
add(0x17,'const-wide/32','51i',3)
add(0x18,'const-wide','51i',5)
add(0x19,'const-wide/high16','21h',2)
add(0x1a,'const-string','21c',2)
add(0x1b,'const-string/jumbo','31c',3)
add(0x1c,'const-class','21c',2)
add(0x1d,'monitor-enter','11x',1)
add(0x1e,'monitor-exit','11x',1)
add(0x1f,'check-cast','21c',2)
add(0x20,'instance-of','22c',2)
add(0x21,'array-length','12x',1)
add(0x22,'new-instance','21c',2)
add(0x23,'new-array','22c',2)
add(0x24,'filled-new-array','35c',3)
add(0x25,'filled-new-array/range','3rc',3)
add(0x26,'fill-array-data','31t',3)
add(0x27,'throw','11x',1)
add(0x28,'goto','10t',1)
add(0x29,'goto/16','20t',2)
add(0x2a,'goto/32','30t',3)
add(0x2b,'packed-switch','31t',3)
add(0x2c,'sparse-switch','31t',3)
add(0x2d,'cmpl-float','23x',2)
add(0x2e,'cmpg-float','23x',2)
add(0x2f,'cmpl-double','23x',2)
add(0x30,'cmpg-double','23x',2)
add(0x31,'cmp-long','23x',2)
for i,n in enumerate(['eq','ne','lt','ge','gt','le']):
    add(0x32+i,'if-'+n,'22t',2)
for i,n in enumerate(['eqz','nez','ltz','gez','gtz','lez']):
    add(0x38+i,'if-'+n,'21t',2)
for i,n in enumerate(['aget','aget-wide','aget-object','aget-boolean','aget-byte','aget-char','aget-short']):
    add(0x44+i,n,'23x',2)
for i,n in enumerate(['aput','aput-wide','aput-object','aput-boolean','aput-byte','aput-char','aput-short']):
    add(0x4b+i,n,'23x',2)
for i,n in enumerate(['iget','iget-wide','iget-object','iget-boolean','iget-byte','iget-char','iget-short']):
    add(0x52+i,n,'22c',2)
for i,n in enumerate(['iput','iput-wide','iput-object','iput-boolean','iput-byte','iput-char','iput-short']):
    add(0x59+i,n,'22c',2)
for i,n in enumerate(['sget','sget-wide','sget-object','sget-boolean','sget-byte','sget-char','sget-short']):
    add(0x60+i,n,'21c',2)
for i,n in enumerate(['sput','sput-wide','sput-object','sput-boolean','sput-byte','sput-char','sput-short']):
    add(0x67+i,n,'21c',2)
add(0x6e,'invoke-virtual','35c',3)
add(0x6f,'invoke-super','35c',3)
add(0x70,'invoke-direct','35c',3)
add(0x71,'invoke-static','35c',3)
add(0x72,'invoke-interface','35c',3)
add(0x73,'invoke-virtual/range','3rc',3)
add(0x74,'invoke-super/range','3rc',3)
add(0x75,'invoke-direct/range','3rc',3)
add(0x76,'invoke-static/range','3rc',3)
add(0x77,'invoke-interface/range','3rc',3)
add(0x78,'neg-int','12x',1)
add(0x79,'not-int','12x',1)
add(0x7a,'neg-long','12x',1)
add(0x7b,'not-long','12x',1)
add(0x7c,'neg-float','12x',1)
add(0x7d,'neg-double','12x',1)
add(0x7e,'int-to-long','12x',1)
add(0x7f,'int-to-float','12x',1)
add(0x80,'int-to-double','12x',1)
add(0x81,'long-to-int','12x',1)
add(0x82,'long-to-float','12x',1)
add(0x83,'long-to-double','12x',1)
add(0x84,'float-to-int','12x',1)
add(0x85,'float-to-long','12x',1)
add(0x86,'float-to-double','12x',1)
add(0x87,'double-to-int','12x',1)
add(0x88,'double-to-long','12x',1)
add(0x89,'double-to-float','12x',1)
add(0x8a,'int-to-byte','12x',1)
add(0x8b,'int-to-char','12x',1)
add(0x8c,'int-to-short','12x',1)
for i,n in enumerate(['add','sub','mul','div','rem','and','or','xor','shl','shr','ushr']):
    add(0x90+i,n+'-int','23x',2)
for i,n in enumerate(['add','sub','mul','div','rem','and','or','xor','shl','shr','ushr']):
    add(0xb0+i,n+'-int/2addr','12x',1)
for i,n in enumerate(['add','rsub','mul','div','rem','and','or','xor','shl','shr','ushr']):
    add(0xd0+i,n+'-int/lit8','22b',2)
for i,n in enumerate(['add','rsub','mul','div','rem','and','or','xor','shl','shr','ushr']):
    add(0xb8+i,n+'-int/lit16','22s',2)
# 3rc / 35c invoke variants handled
add(0xfa,'invoke-polymorphic','45cc',4)
add(0xfb,'invoke-polymorphic/range','4rcc',4)
add(0xfc,'invoke-custom','35c',3)
add(0xfd,'invoke-custom/range','3rc',3)
add(0xfe,'const-method-handle','21c',2)
add(0xff,'const-method-type','21c',2)

def decode(ops_bytes):
    """given operand bytes, return list of parsed fields based on fmt"""
    import struct
    f = ops_bytes[0] if False else None
    return None
