#! /usr/bin/python
import sys
import os

if len(sys.argv) == 2:
    directory = sys.argv[1]
else:
    directory = os.getcwd()
listing = os.listdir(directory)
print('\n'.join(sorted(listing)))

#get number chars column terminal window
#get longest file name + number chars for spacing 
#number columns =(longest file name + space) / total chars
#number files per column = 
#move into the next column at the right time
#adam says the printing has to be done once and once only

https://stackoverflow.com/questions/566746/how-to-get-linux-console-window-width-in-python

# obtain directory from parameter
# if there is no paramter, obtain current directory 
# open directory 
# loop - read file name and print to the terminal
# loop ends when no more files left
# close the file