import collections
class A:
    def isEmpty(self,a):
        if not a:
            return True
        else:
            return False
    def push(self,a,n,value):
        if len(a)==n:
            print("Stack is full\n")
        else:
            a.append(value)
            
if __name__=="__main__":
    stack=collections.deque()
    n=int(input("Enter limit of stack: "))
    i=A()
    while(True):
        key=int(input("\n1.PUSH\n2.POP\n3.isEmpty\n4.PEEK OR TOP\n5.TRAVERSE\n6.QUIT\nChoose the option: "))
        if key==1:
            value=int(input("Enter value to be pushed: "))
            i.push(stack,n,value)
            print("PUSHed Successfully\n")
        elif key==2:
            if i.isEmpty(stack)==True:
                print("Stack is empty\n")
            else:
                stack.pop()
                print("POP operation successfull\n")
        elif key==3:
            print(i.isEmpty(stack))
        elif key==4:
            if i.isEmpty(stack)==False:
                print(stack[-1])
            else:
                print("Stack is Empty")
        elif key==5:
            print(stack)
        elif key==6:
            break
        else:
            print("Enter correct option\n")