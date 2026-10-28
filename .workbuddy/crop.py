"""裁出并放大 GBA 游戏画面，便于人工/视觉判断当前场景。"""
import sys
from PIL import Image

path = sys.argv[1]
out = sys.argv[2] if len(sys.argv) > 2 else path.replace('.png', '_crop.png')
im = Image.open(path)
w, h = im.size
# 游戏画面是 3:2；在横屏里尽量取满高度
gh = min(h, 520)
gw = int(gh * 3 / 2)
if gw > w:
    gw = w
    gh = int(gw * 2 / 3)
x0 = (w - gw) // 2
y0 = (h - gh) // 2
im.crop((x0, y0, x0 + gw, y0 + gh)).resize((gw * 2, gh * 2), Image.NEAREST).save(out)
print('crop', (x0, y0, gw, gh), '->', out)
