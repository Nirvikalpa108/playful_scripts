import acalc

programme_running = True
while programme_running:
    user_input = raw_input('calc ')
    if user_input == 'exit':
        programme_running = False
    else:
        input = user_input.split(' ')
        print(acalc.calc(input))
