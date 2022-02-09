"""4.WAP to perform following using class and object and multilevel inheritance and also use list for different users to implement ATM simulation
A.	Generate account number  and accept  pin from users of new user and store informationlike account number,pin,name,mobile no and initial balance in different list
B.	Assign a fixed value as balance for account
C.	Ask user to enter account number and pin
D.	Verify user using account number and pin if user is valid then Provide different options like withdraw,fast withdraw,change pin,and check balance  otherwise alert user by providing Invalid pin or account number
E.	Withdraw user defined money if user has sufficient fund otherwise shoe insufficient fund in withdraw option also in fast withdraw provide some fixed amount like 500,1000,2000,5000 etc as option to user to select for withdraw
F.	Check for balance
G.	If user wants change pin and update pin in the list"""
class A():
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        self.acc_no=acc_no
        self.pin=pin
        self.name=name
        self.mob=mob
        self.ini_balance=ini_balance
    def withdraw(self,pos):
        value=int(input("Enter how much money you want to withdraw:"))
        if(value>self.ini_balance[pos]):
            print("Insufficient Fund")
        else:
            self.ini_balance[pos]=self.ini_balance[pos]-value;
            print("Money Withdraw Successfull")
            print("Money after withdrawal:",self.ini_balance[pos]);
class B(A):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def f_withdraw(self,pos):
        value=int(input("How much you want to withdraw:500 1000 2000 5000\n-->"))
        while(True):
            if(value!=500 and value!=1000 and value!=2000 and value!=5000):
                value=int(input("Please enter correct money value among 500,1000,2000,5000\n-->"))
                continue
            elif(value>self.ini_balance[pos]):
                print("Insufficient Fund")
                break
            else:
                self.ini_balance[pos]=self.ini_balance[pos]-value;
                print("Money Withdraw Successfull")
                print("Money after withdrawal:",self.ini_balance[pos]);
                break
class C(B):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def change(self,pos):
        n_pin,i=input("Please enter old PIN: "),0
        while(True):
            if(i==2):
                print("Sorry you can't access the account!!")
                break
            elif(n_pin!=self.pin[pos]):
                n_pin=input("Wrong PIN.You Have 1 Attempt Left\nPlease enter correct PIN: ")
                i+=1
            else:
                ch=input("Enter PIN that you want to update: ")
                self.pin[pos]=ch
                print("PIN Changed Successfully")
                break
class D(C):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def check(self,pos):
        print("Updated Balance: RS",float(ini_balance[pos]))
class E(D):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def show(self,pos):
        print("\nUSER-",pos+1," DETAILS\n____________")
        print("Accoount Number:",self.acc_no[pos])
        print("PIN:",self.pin[pos])
        print("Name:",self.name[pos])
        print("Mobile Number:",self.mob[pos])
        print("Total Balance: RS",float(self.ini_balance[pos]))
class ope(E):
    def __init__(self,user_no,acc_no,pin,name,mob,ini_balance):
        self.acc_no=acc_no
        self.pin=pin
        self.name=name
        self.mob=mob
        self.ini_balance=ini_balance
        self.user_no=user_no;
        A.__init__(self,acc_no,pin,name,mob,ini_balance);

    def operation(self):
        var,m,z=1,0,0;
        while(True):
            key=int(input("\nWhat you want to do?\n1.Withdraw\n2.Fast Withdraw\n3.PIN Change\n4.Balance Check\n5.Show User Information\n6.Exit\n-->"))
            if key==6:
                exit()
            verify1=int(input("Enter your account number:"))
            verify2=input("Enter your 4 digit pin:")
            if(var==4 or self.user_no==m):
                print("Maximum wrong credentials entered!!! Sorry you can't access");
                exit()
            else:
                flag1,flag2,flag3=False,False,False
                for i in range(self.user_no):
                    if verify1==self.acc_no[i]:
                            flag1,pos=True,i
                            for k in range(self.user_no):
                                if verify2==(self.pin[k]):
                                    flag3=True
                                    flag2=True
                                    print("\n\nAuthentication Successfull\n")
                                    break;
                                else:
                                    continue
                    else:
                        continue
                if flag1==False:
                    print("Wrong Account Number. Please enter correct Account Number\nYou have ",4-var," attempts left")
                    var+=1
                    m+=1
                    z=1
                if flag2==False and z==0:
                    print("Wrong PIN. Please enter correct PIN\nYou have ",4-var," attempts left")
                    var+=1
                    m+=1
            if(flag3==True):
                if key>5 or key<1:
                    print("Please choose correct option")
                elif key==1:
                    super().withdraw(pos)
                elif key==2:
                    super().f_withdraw(pos)
                elif key==3:
                    super().change(pos)
                elif key==4:
                    super().check(pos)
                elif key==5:
                    super().show(pos)
                else:
                    exit()
user_no=int(input("Enter how many users: "))
j=12345678901;
acc_no=[]
pin=[]
name=[]
mob=[]
ini_balance=[]
for i in range(user_no):
    print("Account number for "+str(i+1)+"th user is ",j);
    acc_no.append(j)
    print("USER-",i+1,"\n_______\n")
    p=input("Please enter your new pin:")
    pin.append(p)
    n=input("Enter your Name:")
    name.append(n)
    m=input("Enter your mobile number:")
    mob.append(m)
    print("Enter initial fixed balance for account number "+str(j))
    i_balance=int(input("-->"))
    ini_balance.append(i_balance)
    j+=1
obj=ope(user_no,acc_no,pin,name,mob,ini_balance)
obj.operation()