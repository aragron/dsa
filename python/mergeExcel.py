# -*- coding: cp936 -*-
import os
import sys
import xlrd
import xlwt

if __name__ == '__main__':
    print("������·����")
    path = sys.stdin.readline().strip('\n')
    fn = [filename for filename in os.listdir(path)
          if filename.endswith(('.xlsm')) and filename.startswith('JSXM-')]

    wb = xlwt.Workbook(encoding='ascii', style_compression=0)
    ws = wb.add_sheet(u'����')

    print("��Ŀ����", "7���ۼ������ɱ�", "7���ۼƳɱ�", "12���ۼ������ɱ�", "12�³ɱ�", "���һ�����ۼ������ɱ�", "���һ�����ۼƳɱ�")
    ws.write(0,0,'��Ŀ����')
    ws.write(0,1,'7���ۼ������ɱ�')
    ws.write(0,2,'7���ۼƳɱ�')
    ws.write(0,3,'12���ۼ������ɱ�')
    ws.write(0,4,'12�³ɱ�')
    ws.write(0,5,'���һ�����ۼ������ɱ�')
    ws.write(0,6,'���һ�����ۼƳɱ�')
    write_row = 1
    for filename in fn:
        file = path+"\\"+filename
        split_filename_index = filename.index('��Ŀ_')
        project_name = filename[0:split_filename_index]
        book = xlrd.open_workbook(file)
        sh = book.sheet_by_name('�¶�Ԥ������ͳ��')

        
        columIndex = 0
        for columValue in sh.row(1):
            if columValue.value == "202207":
                index_1 = columIndex
            if columValue.value == '202212':
                index_2 = columIndex
            columIndex = columIndex + 1

        for i in range(index_2,columIndex):
            if sh.cell(3,i).value == "":
                index_last = i-1
                break
        # �����ɱ� human_cost
        # �ۼƳɱ� accu_cost
        human_cost_7 = sh.cell(3,index_1).value
        accu_cost_7 = sh.cell(6,index_1).value

        human_cost_12 = sh.cell(3, index_2).value
        accu_cost_12 = sh.cell(6, index_2).value

        human_cost_last = sh.cell(3, index_last).value
        accu_cost_last = sh.cell(6, index_last).value

        print(project_name, human_cost_7,accu_cost_7,human_cost_12,accu_cost_12,human_cost_last,accu_cost_last)
        ws.write(write_row,0,project_name)
        ws.write(write_row,1,human_cost_7)
        ws.write(write_row,2,accu_cost_7)
        ws.write(write_row,3,human_cost_12)
        ws.write(write_row,4,accu_cost_12)
        ws.write(write_row,5,human_cost_last)
        ws.write(write_row,6,accu_cost_last)

        write_row = write_row+1

    wb.save('D:\ͳ�Ʊ���.xls')