import sys

def add_numbers(a,b):
    return int(a)+int(b)

if __name__=="__main__":

    a,b=sys.argv[1],sys.argv[2]
    print(add_numbers(a,b))