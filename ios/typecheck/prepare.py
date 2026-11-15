#!/usr/bin/env python3
"""
把 ios/mGBA/*.swift 复制到 ios/typecheck/build/，并做最小化的、不改变行号的改写，
使其可以在 Windows 上（无 iOS SDK、无 ObjC 运行时）被 swiftc -typecheck 检查。

改写内容（每条都保持行号不变，行内列号可能变化）：
  1. `import X` 整行清空   —— Windows 上没有 UIKit/AVFoundation/... 这些模块，
                              同名类型全部由 stubs/ 里的Swift声明提供（同一 module）。
  2. `@objc` / `@objc(...)` / `@objcMembers` 删除 —— 非 Darwin 平台不支持 ObjC 运行时。
  3. `#selector(...)` 替换成 `Selector()` —— #selector 是 ObjC 专用语法。

用法: python prepare.py <src_dir> <out_dir>
"""
import os
import re
import sys
import shutil

IMPORT_RE = re.compile(r'^\s*(@_exported\s+)?(import|@testable\s+import)\s+[A-Za-z_][A-Za-z0-9_.]*\s*$')
OBJC_RE = re.compile(r'@objcMembers\b|@objc\([^)]*\)|@objc\b')
SEL_START = '#selector('


def strip_selectors(text, path):
    out = []
    i = 0
    n = len(text)
    while True:
        j = text.find(SEL_START, i)
        if j < 0:
            out.append(text[i:])
            break
        out.append(text[i:j])
        # 找到与 '(' 配对的 ')'
        k = j + len(SEL_START) - 1
        depth = 0
        while k < n:
            c = text[k]
            if c == '(':
                depth += 1
            elif c == ')':
                depth -= 1
                if depth == 0:
                    break
            k += 1
        if k >= n:
            raise SystemExit('unbalanced #selector( in ' + path)
        inner = text[j:k + 1]
        if '\n' in inner:
            raise SystemExit('#selector spans multiple lines in ' + path)
        out.append('Selector()')
        i = k + 1
    return ''.join(out)


FUNC_RE = re.compile(r'^(?P<indent>\s*)(?:@\w+\s+)*(?:(?:public|private|fileprivate|internal|static|class|final|override|mutating|nonmutating)\s+)*func\s+(?P<name>\w+)\s*\(')


def merge_cgfloat_overloads(lines):
    """
    stub 里 CGFloat 就是 Double（typealias），于是
        static func clamp01(_ v: CGFloat) -> CGFloat
        static func clamp01(_ v: Double)  -> Double
    这种“只为区分数值类型”的重载在副本里会变成“重复声明”。
    真机上 CGFloat 是独立类型，两条都能编过，所以这里是 stub 的表达能力问题，
    不是源码问题。处理办法：把 CGFloat 那一条在副本里挖空（保留行数），
    并在原位留一行标记，方便查看。
    """
    groups = {}
    i = 0
    n = len(lines)
    while i < n:
        m = FUNC_RE.match(lines[i])
        if not m:
            i += 1
            continue
        # 找到该函数的右花括号（简单括号计数，够用）
        depth = 0
        started = False
        j = i
        while j < n:
            depth += lines[j].count('{') - lines[j].count('}')
            if '{' in lines[j]:
                started = True
            if started and depth <= 0:
                break
            j += 1
        body = '\n'.join(lines[i:j + 1])
        kind = 'CGFloat' if re.search(r'\(\s*_\s+\w+\s*:\s*CGFloat\s*\)', body) else (
            'Double' if re.search(r'\(\s*_\s+\w+\s*:\s*Double\s*\)', body) else None)
        if kind:
            groups.setdefault((m.group('name'), m.group('indent'), body.count(',')), []).append((kind, i, j))
        i = j + 1

    for key, entries in groups.items():
        kinds = {k for k, _, _ in entries}
        if kinds == {'CGFloat', 'Double'}:
            for kind, start, end in entries:
                if kind != 'CGFloat':
                    continue
                marker = key[1] + '// [typecheck] 与同名 Double 重载在 stub 中撞名（CGFloat==Double），副本里略去'
                for k in range(start, end + 1):
                    lines[k] = marker if k == start else ''
                for k in range(start + 1, end + 1):
                    lines[k] = ''
    return lines


def process(src, dst):
    # 源文件带 UTF-8 BOM，会让 ^import 匹配不到，用 utf-8-sig 吃掉
    with open(src, 'r', encoding='utf-8-sig', newline='') as f:
        text = f.read()
    text = strip_selectors(text, src)
    dst_lines = []
    for line in text.split('\n'):
        if IMPORT_RE.match(line):
            dst_lines.append('')
            continue
        if '@objc' in line:
            line = OBJC_RE.sub('', line)
            # 删掉属性后可能留下 "  func foo" 之类的双空格，无害
        dst_lines.append(line)
    dst_lines = merge_cgfloat_overloads(dst_lines)
    with open(dst, 'w', encoding='utf-8', newline='') as f:
        f.write('\n'.join(dst_lines))


def main():
    if len(sys.argv) != 3:
        raise SystemExit('usage: prepare.py <src_dir> <out_dir>')
    src_dir, out_dir = sys.argv[1], sys.argv[2]
    if os.path.isdir(out_dir):
        shutil.rmtree(out_dir)
    os.makedirs(out_dir)
    names = sorted(x for x in os.listdir(src_dir) if x.endswith('.swift'))
    for name in names:
        process(os.path.join(src_dir, name), os.path.join(out_dir, name))
    print('prepared %d files -> %s' % (len(names), out_dir))


if __name__ == '__main__':
    main()
