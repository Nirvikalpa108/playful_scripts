import acalc
import sys
import socket

def main():
    if len(sys.argv) == 2:
        port = int(sys.argv[1])
        s = socket.socket()
        s.bind(('0.0.0.0', port))
        s.listen(1)
        connection, address = s.accept()
        while True:
            connection.sendall('calc '.encode('utf-8'))
            data = connection.recv(1024)
            if not data: 
                break
            input = data.decode('utf-8').strip().split(' ')
            output = str(acalc.calc(input)) + '\n'
            connection.sendall(output.encode('utf-8'))
        connection.close()
    else:
        print('please give me something like `anetecho 5000`')

if __name__ == '__main__':
    main()