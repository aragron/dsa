#include <iostream>

#include "vector/vector.h"
#include "vector/vector_insert.h"
#include "vector/vector_traverse.h"
#include "vector/vector_remove.h"
#include "vector/vector_bracket.h"
#include "vector/vector_find.h"
#include "vector/permute.h"
#include "vector/vector_uniquify.h"
#include "vector/vector_sort.h"
#include "vector/vector_deduplicate.h"
#include "vector/vector_search.h"


using namespace std;

void visit(int num) {
    cout << num << "\t";
}
void test01()
{
    Vector<int> vc (3,1,0);
    vc.insert(0,10);
    vc.insert(1,11);
    vc.insert(2,12);
    vc.insert(3,13);
    vc.insert(4,13);
    vc.insert(13);
    int size = vc.size();
    cout << "size: " << size << endl;
    cout << "=============traverse=============" << endl;
    vc.traverse(visit);
    cout << endl;
    cout << "===============get==================" << endl;
    cout << "index:2, value: " << vc.get(2) << endl;
    cout << "index:3, value: " << vc[3] << endl;
    cout << "===============put=================" << endl;
    vc.put(2,22);
    vc.traverse(visit);
    cout << endl;
    cout << "===============remove================" << endl;
    vc.remove(1);
    vc.traverse(visit);
    cout << endl;
    cout << "===============permute================" << endl;
    permute(vc);
    vc.traverse(visit);
    cout << endl;
    cout << "===============sort================" << endl;
    //vc.deduplicate();
    vc.sort();
    vc.uniquify();
    vc.traverse(visit);
    cout << endl;
    cout << "===============search================" << endl;
    cout << vc.search(13) << endl;
    cout << endl;
}


int main() {

    test01();

    return 0;
}


