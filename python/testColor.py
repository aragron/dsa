import xlrd

book = xlrd.open_workbook("sample.xls", formatting_info=True)

def get_front_color(xf):
    font = book.font_list[xf.font_index]
    if not font:
        return None
    return get_color(font.colour_index)

def get_back_color(xf):
    if not xf.background:
        return None
    return get_color(xf.background.background_colour_index)

def get_color(color_index):
    return book.colour_map.get(color_index)

def get_if_protected(xf):
    if not xf.protection:
        return False
    return xf.protection.cell_locked

sheets = book.sheet_names()

for index, sh in enumerate(sheets):
    sheet = book.sheet_by_index(index)
    print("Sheet:", sheet.name)
    rows, cols = sheet.nrows, sheet.ncols

    for row in range(rows):
        for col in range(cols):
            c = sheet.cell(row, col)
            xf = book.xf_list[c.xf_index]
            print(u'{},{}:{:>6}: FRONT: {:>20} | BACK: {:>20} | LOCKED: {}'
                  .format(row, col, c.value, get_front_color(xf), get_back_color(xf), get_if_protected(xf)))
