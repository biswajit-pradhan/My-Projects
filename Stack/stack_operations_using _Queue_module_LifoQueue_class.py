import queue
class A:
    def isEmpty(self,a):
        if a.empty()==True:
            return True
        else:
            return False
    def push(self,a,n,value):
        if a.qsize()==n:
            print("Stack is full\n")
        else:
            a.put_nowait(value)
            
if __name__=="__main__":
    n=int(input("Enter limit of stack: "))
    stack=queue.LifoQueue(n)
    i=A()
    while(True):
        key=input("\n1.PUSH\n2.POP\n3.isEmpty\n4.PEEK OR TOP\n5.TRAVERSE\n6.QUIT\nChoose the option: ")
        if key=='1':
            value=int(input("Enter value to be pushed: "))
            i.push(stack,n,value)
            print("Successfully pushed\n")
        elif key=='2':
            if i.isEmpty(stack)==True:
                print("Stack is empty\n")
            else:
                stack.get_nowait()
                print("POP operation successfull\n")
        elif key=='3':
            print(i.isEmpty(stack))
        elif key=='4':
            if i.isEmpty(stack)==False:
                print(stack.queue[-1])
            else:
                print("Stack is Empty")
        elif key=='5':
            print(stack.queue)
        elif key=='6':
            break
        else:
            print("Enter correct option\n")