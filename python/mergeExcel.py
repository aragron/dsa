# -*- coding: cp936 -*-
import os
import sys
import xlrd
import xlwt

if __name__ == '__main__':
    print("请输入路径：")
    path = sys.stdin.readline().strip('\n')
    fn = [filename for filename in os.listdir(path)
          if filename.endswith(('.xlsm')) and filename.startswith('JSXM-')]

    wb = xlwt.Workbook(encoding='ascii', style_compression=0)
    ws = wb.add_sheet(u'报表')

    print("项目名称", "7月累计人力成本", "7月累计成本", "12月累计人力成本", "12月成本", "最后一个月累计人力成本", "最后一个月累计成本")
    ws.write(0,0,'项目名称')
    ws.write(0,1,'7月累计人力成本')
    ws.write(0,2,'7月累计成本')
    ws.write(0,3,'12月累计人力成本')
    ws.write(0,4,'12月成本')
    ws.write(0,5,'最后一个月累计人力成本')
    ws.write(0,6,'最后一个月累计成本')
    write_row = 1
    for filename in fn:
        file = path+"\\"+filename
        split_filename_index = filename.index('项目_')
        project_name = filename[0:split_filename_index]
        book = xlrd.open_workbook(file)
        sh = book.sheet_by_name('月度预计收入统计')

        
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
        # 人力成本 human_cost
        # 累计成本 accu_cost
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

    wb.save('D:\统计报表.xls')