package main

import (
	"fmt"
)

func main() {
	arr := [5]int{24, 69, 80, 57, 13}
	bubbleSort(&arr)
}

// 冒泡排序
func bubbleSort(arr *[5]int) {
	fmt.Println("排序前：", (*arr))
	// 总结规律：先内层(每一轮)再外层,内层n-1-i次,外层n-1
	for i := 0; i < len(*arr)-1; i++ {
		for j := 0; j < len(*arr)-1-i; j++ {
			temp := 0
			if (*arr)[j] > (*arr)[j+1] {
				temp = (*arr)[j]
				(*arr)[j] = (*arr)[j+1]
				(*arr)[j+1] = temp
			}
		}
	}
	fmt.Println("排序后：", (*arr))
}
