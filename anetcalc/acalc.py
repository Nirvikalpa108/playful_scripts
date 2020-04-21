import operator 

def calc(input):
    if len(input) == 3:
        operator_input = input[1]
        operator_list = {
        '+': operator.__add__,
        '-': operator.__sub__,
        '*': operator.__mul__,
        '/': operator.__div__
        } 
        if operator_input == '/':
            try:
                first_operand = float(input[0])
                third_operand = float(input[2])
                # if third_operand is 0, will not work - add error statement
                apply_operator = operator_list[operator_input]
                answer = apply_operator(first_operand, third_operand)
            except:
                answer = 'please give me integers or floats and a / operand! For example: 9 / 3' 
        else:
            try:
                first_operand = int(input[0])
                third_operand = int(input[2])
                apply_operator = operator_list[operator_input]
                answer = apply_operator(first_operand, third_operand)
            except:
                answer = 'please give me integers and a +, - or * operand! For example 2 * 2'
    else:
        answer = 'Sorry, I don\'t understand! Why don\'t you try 2 + 2?' 
    return answer  

# Helpful documentation:
# https://stackoverflow.com/questions/2983139/assign-operator-to-variable-in-python
