from PIL import Image
import io, sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

img = Image.open(r'D:\mgba-android-version\.workbuddy\a_now3.png')
print('size:', img.size, 'mode:', img.mode)
exif = img.getexif()
print('exif orientation:', exif.get(274))
img.save(r'D:\mgba-android-version\.zcode-tmp\a_rot_raw.png')
img.transpose(Image.ROTATE_90).save(r'D:\mgba-android-version\.zcode-tmp\a_rot_ccw.png')
img.transpose(Image.ROTATE_270).save(r'D:\mgba-android-version\.zcode-tmp\a_rot_cw.png')
print('saved 3 variants')
