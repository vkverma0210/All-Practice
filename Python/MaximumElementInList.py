list1 = []  #creating an empty list

num = int(input())  # Number of elements

for i in range(0, num):
    element = int(input())  # input of element in list
    list1.append(element)

maxElement = list1[0]  # Let 1st element be largest

for x in list1:
    if(x > maxElement):
        maxElement = x

print("MAximim element in list is : ", maxElement)
