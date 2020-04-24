import acat
import sys
import socket

# TODO print the contents of the file to the CLIENT
# currently it's printing on the server side
# finally, add a new line after the second prompt

def main():
    if len(sys.argv) == 2:
        port = int(sys.argv[1])
        s = socket.socket()
        s.bind(('0.0.0.0', port))
        s.listen(1)
        connection, address = s.accept()
        while True:
            connection.sendall('which file would you like to read? '.encode('utf-8'))
            data = connection.recv(1024)
            if not data: 
                break
            file_name = data.decode('utf-8').strip()
            output = acat.read(file_name)
            connection.sendall(file_name.encode('utf-8'))
        connection.close()
    else:
        print('please give me something like `python net.py 5000`')

if __name__ == '__main__':
    main()