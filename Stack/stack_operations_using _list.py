class A:
    def isEmpty(self,a):
        if not a:
            return True
        else:
            return False
    def push(self,a,n,value):
        if n==len(a):
            print("Stack is full\n")
        else:
            a.append(value)
            print("Value inserted successfully\n")
    def popp(self,a):
        if self.isEmpty(a)==False:
            a.pop()
        else:
            print("Stack is empty\n")
    def peek_or_top(self,a):
        if self.isEmpty(a)==False:
            print(a[-1])
        else:
            print("Stack is empty\n")
if __name__=="__main__":
    key=A()
    n=int(input("Enter limit of stack: "))
    a=[]
    while(True):
        i=int(input("Choose any option:\n1.PUSH\n2.POP\n3.PEEK OR TOP\n4.isEmpty\n5.TRAVESRE\n6.QUIT\n\n"))
        if i==1:
            value=int(input("Enter value to be inserted: "))
            key.push(a,n,value)
        elif i==2:
            key.popp(a)
            print("Successfully POPed\n")
        elif i==3:
            print(a[-1])
        elif i==4:
            print(key.isEmpty(a))
        elif i==5:
            print(a)
        elif i==6:
            break;
        else:
            print("Choose correct option\n")