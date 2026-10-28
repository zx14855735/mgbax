from PIL import Image
img = Image.open(r'D:\mgba-android-version\.workbuddy\a_after_start.png')
w, h = img.size
# dialog box is roughly x 300-910, y 360-470 in 1200x540
crop = img.crop((300, 350, 910, 480)).resize((1830, 390), Image.NEAREST)
crop.save(r'D:\mgba-android-version\.zcode-tmp\a_dialog_zoom.png')
print('saved', crop.size)
