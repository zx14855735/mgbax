import sys
from PIL import Image
p = sys.argv[1]; out = sys.argv[2]
im = Image.open(p)
im.crop((300,20,900,520)).resize((1200,1000), Image.NEAREST).save(out)
print('acrop ok')
