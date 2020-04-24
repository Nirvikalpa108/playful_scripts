import sys

def read(file_name):
    file = open(file_name, 'r')
    for line in file:
        print(line),
    file.close()

# I need to add a return statement instead of printing the line
# not sure why I'm struggling to do this