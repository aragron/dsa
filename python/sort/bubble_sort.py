def bubble_sort(array):
    for i in range(1, len(array)):
        for j in range(0, len(array) - i):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
    return array


if __name__ == '__main__':
    array = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    sorted = bubble_sort(array)
    print(sorted)
