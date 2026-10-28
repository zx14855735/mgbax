import sys
from PIL import Image
p = sys.argv[1]; out = sys.argv[2]
im = Image.open(p); w,h = im.size
x0=int(0.27*w); y0=int(0.12*h); x1=int(0.79*w); y1=int(0.87*h)
im.crop((x0,y0,x1,y1)).save(out); print('bcrop', (x0,y0,x1,y1))
