# -*- coding: utf-8 -*-
"""Convert the mGBAx tutorial markdown into a docx-ready HTML (single file)."""
import re, sys

SRC = "D:/mgba-android-version/安卓版完整使用教程.md"
OUT = "D:/mgba-android-version/output/mgbax-tutorial/stage2/formatted-mgbax-tutorial.html"

def inline(text):
    # code spans first
    text = re.sub(r'`([^`]+)`', lambda m: '<code>%s</code>' % m.group(1), text)
    # bold
    text = re.sub(r'\*\*([^*]+)\*\*', lambda m: '<strong>%s</strong>' % m.group(1), text)
    # links [t](u)
    text = re.sub(r'\[([^\]]+)\]\(([^)]+)\)', lambda m: '<a href="%s">%s</a>' % (m.group(2), m.group(1)), text)
    return text

HTML_HEADER = '''<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="docx-page-size" content="A4">
  <title>mGBAx 安卓版完整使用教程</title>
  <style>
  :root {
    --page-content-width: 15.6cm;
    --fs-h1: 22pt;
    --fs-h2: 16pt;
    --fs-h3: 13pt;
    --fs-body: 12pt;
    --fs-small: 10pt;
    --ff-heading: "黑体", SimHei, sans-serif;
    --ff-body: "宋体", SimSun, serif;
    --color-primary: #1a4d8f;
    --color-text: #000000;
    --color-muted: #555555;
    --color-border: #bbbbbb;
    --color-highlight: #eef3fa;
    --spacing-paragraph: 0.5em;
    --spacing-section: 1.2em;
  }
  * { box-sizing: border-box; margin: 0; padding: 0; }
  body {
    font-family: "宋体", SimSun, serif;
    font-size: 12pt;
    line-height: 1.6;
    color: #000000;
    background: #ffffff;
    max-width: 15.6cm;
    margin-left: auto;
    margin-right: auto;
    padding: 2.5cm 0;
  }
  h1 {
    font-family: "黑体", SimHei, sans-serif;
    font-size: 22pt;
    font-weight: 700;
    text-align: center;
    margin-top: 0.4em;
    margin-bottom: 0.8em;
    color: #1a4d8f;
  }
  h2 {
    font-family: "黑体", SimHei, sans-serif;
    font-size: 16pt;
    font-weight: 700;
    margin-top: 1.2em;
    margin-bottom: 0.5em;
    color: #1a4d8f;
    border-bottom: 1px solid #cccccc;
    padding-bottom: 0.2em;
  }
  h3 {
    font-family: "黑体", SimHei, sans-serif;
    font-size: 13pt;
    font-weight: 700;
    margin-top: 0.9em;
    margin-bottom: 0.4em;
    color: #222222;
  }
  p {
    font-family: "宋体", SimSun, serif;
    font-size: 12pt;
    margin-bottom: 0.5em;
    text-indent: 2em;
  }
  ul, ol { padding-left: 2em; margin-bottom: 0.5em; }
  li { font-family: "宋体", SimSun, serif; font-size: 12pt; margin-bottom: 0.25em; }
  table { border-collapse: collapse; width: 100%; margin: 0.6em 0 0.8em 0; }
  th, td {
    font-family: "宋体", SimSun, serif;
    font-size: 11pt;
    padding: 0.4em 0.6em;
    border: 1px solid #bbbbbb;
    text-indent: 0;
    vertical-align: top;
  }
  th { font-weight: 700; background: #eef3fa; }
  caption { font-size: 10pt; margin-bottom: 0.3em; text-align: left; }
  code { font-family: "Courier New", monospace; font-size: 11pt; background: #f2f2f2; padding: 0 2px; }
  .callout {
    border-left: 3px solid #1a4d8f;
    background: #eef3fa;
    padding: 6px 8px;
    margin: 0.6em 0;
    font-family: "宋体", SimSun, serif;
    font-size: 12pt;
  }
  .spacer { height: 0.4em; }
  a { color: #1a4d8f; }
  </style>
</head>
<body>
'''

HTML_FOOTER = "</body>\n</html>\n"

def parse_table(rows):
    # rows: list of raw lines starting with |
    def split_row(line):
        line = line.strip()
        if line.startswith('|'): line = line[1:]
        if line.endswith('|'): line = line[:-1]
        return [c.strip() for c in line.split('|')]
    header = split_row(rows[0])
    # rows[1] is separator
    body = [split_row(r) for r in rows[2:]]
    n = len(header)
    out = ['<table>', '<thead><tr>']
    for h in header:
        out.append('<th>%s</th>' % inline(h))
    out.append('</tr></thead><tbody>')
    for r in body:
        # pad
        while len(r) < n: r.append('')
        out.append('<tr>')
        for c in r[:n]:
            out.append('<td>%s</td>' % inline(c))
        out.append('</tr>')
    out.append('</tbody></table>')
    return ''.join(out)

def main():
    with open(SRC, encoding='utf-8') as f:
        lines = f.read().split('\n')
    out = [HTML_HEADER]
    i = 0
    section_n = 0
    in_list = False
    list_type = None  # 'ul' or 'ol'
    list_indent = {}
    while i < len(lines):
        line = lines[i]
        # skip TOC markdown separators and the table-of-contents block (## 目录 with bullet list)
        stripped = line.strip()
        # horizontal rule
        if stripped == '---':
            out.append('<p class="spacer"></p>')
            i += 1
            continue
        # heading
        m = re.match(r'^(#{1,3})\s+(.*)$', line)
        if m:
            level = len(m.group(1))
            text = m.group(2).strip()
            if level == 1:
                out.append('<h1>%s</h1>' % inline(text))
            elif level == 2:
                section_n += 1
                out.append('<h2 id="section-%d">%s</h2>' % (section_n, inline(text)))
            else:
                out.append('<h3>%s</h3>' % inline(text))
            i += 1
            continue
        # table block
        if stripped.startswith('|') and i+1 < len(lines) and re.match(r'^\s*\|[\s:|-]+\|\s*$', lines[i+1]):
            rows = [line]
            j = i+1
            while j < len(lines) and lines[j].strip().startswith('|'):
                rows.append(lines[j]); j += 1
            out.append(parse_table(rows))
            i = j
            continue
        # blockquote / callout
        if stripped.startswith('>'):
            txt = re.sub(r'^>\s?', '', stripped)
            out.append('<p class="callout">&nbsp;&nbsp;%s</p>' % inline(txt))
            i += 1
            continue
        # list item
        lm = re.match(r'^(\s*)[-*]\s+(.*)$', line)
        olm = re.match(r'^(\s*)(\d+)\.\s+(.*)$', line)
        if lm or olm:
            if lm:
                indent = len(lm.group(1)); content = lm.group(2); cur = 'ul'
            else:
                indent = len(olm.group(1)); content = olm.group(3); cur = 'ol'
            if not in_list or list_type != cur:
                if in_list:
                    out.append('</%s>' % list_type)
                out.append('<%s>' % cur)
                in_list = True; list_type = cur
            tag = 'li'
            out.append('<%s>%s</%s>' % (tag, inline(content), tag))
            i += 1
            continue
        else:
            if in_list:
                out.append('</%s>' % list_type); in_list = False; list_type = None
        # blank line
        if stripped == '':
            i += 1
            continue
        # normal paragraph
        out.append('<p>%s</p>' % inline(stripped))
        i += 1
    if in_list:
        out.append('</%s>' % list_type)
    out.append(HTML_FOOTER)
    with open(OUT, 'w', encoding='utf-8') as f:
        f.write('\n'.join(out))
    print("WROTE", OUT)

if __name__ == '__main__':
    main()
