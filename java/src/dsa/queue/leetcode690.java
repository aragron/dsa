package dsa.queue;

import java.util.*;

public class leetcode690 {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer empId = queue.poll();
            Employee employee = map.get(empId);
            count += employee.importance;
            List<Integer> subEmpList = employee.subordinates;
            if ( subEmpList.size() > 0) {
                subEmpList.forEach(queue::offer);
            }
        }
        return count;
    }


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;
}
