#!/usr/bin/python

import sys

dict1 = {}				# Define a dictionary that will contain key value pair. Key will be each word from mapper and value will be 1 as assigned by mapper for each word
firsttime = "true"

for line in sys.stdin:
    # Split the word and 1 assigned in the mapper into variable word and count
    word, count = line.split(',')

    if (firsttime == "true"):
        # When coming for first time, dictionary will be empty. Hence just move the (word, count) in dictionary
        dict1[word] = int(count)
        firsttime = "false"

    wordexist = [key for key in dict1]  # Check if word exists in dictionary
    if (word in wordexist):
        # If the word exist, just add the count
        dict1[word] = dict1[word]+int(count)
    else:
        # If the word does not exist, just move the (word, count) in dictio
        dict1[word] = int(count)


maximum = max(dict1, key=dict1.get)
print(maximum, dict1[maximum])
