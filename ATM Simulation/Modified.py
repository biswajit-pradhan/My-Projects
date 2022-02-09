"""4.WAP to perform following using class and object and multilevel inheritance and also use list for different users to implement ATM simulation
A.	Generate account number  and accept  pin from users of new user and store informationlike account number,pin,name,mobile no and initial balance in different list
B.	Assign a fixed value as balance for account
C.	Ask user to enter account number and pin
D.	Verify user using account number and pin if user is valid then Provide different options like withdraw,fast withdraw,change pin,and check balance  otherwise alert user by providing Invalid pin or account number
E.	Withdraw user defined money if user has sufficient fund otherwise shoe insufficient fund in withdraw option also in fast withdraw provide some fixed amount like 500,1000,2000,5000 etc as option to user to select for withdraw
F.	Check for balance
G.	If user wants change pin and update pin in the list"""
import time
class A():
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        self.acc_no=acc_no
        self.pin=pin
        self.name=name
        self.mob=mob
        self.ini_balance=ini_balance
    def withdraw(self,pos):
        value=float(input("Enter how much money you want to withdraw:"))
        if(value>self.ini_balance[pos]):
            print("Insufficient Fund")
        else:
            self.ini_balance[pos]=self.ini_balance[pos]-value;
            print("\nProcessing..")
            time.sleep(1)
            print("\nMoney Withdraw Successfull")
            print("\nMoney after withdrawal:",self.ini_balance[pos]);
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
                print("\nProcessing..")
                time.sleep(1)
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
                print("\nSorry you can't access the account!!")
                break
            elif(n_pin!=self.pin[pos]):
                n_pin=input("\nWrong PIN.You Have 1 Attempt Left\nPlease enter correct PIN: ")
                i+=1
            else:
                ch=input("Enter PIN that you want to update: ")
                print("\nProcessing..")
                time.sleep(1)
                self.pin[pos]=ch
                print("\nPIN Changed Successfully")
                break
class D(C):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def check(self,pos):
        print("\nProcessing..")
        time.sleep(1)
        print("Updated Balance is RS",ini_balance[pos])
class E(D):
    def __init__(self,acc_no,pin,name,mob,ini_balance):
        super().__init__();
    def show(self,pos):
        print("\nUSER-",pos+1," DETAILS\n____________")
        print("\nProcessing..")
        time.sleep(1)
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
        while(True):
            var,m,z=1,0,0;
            time.sleep(1)
            key=int(input("\nWhat you want to do?(Please Enter The Number Only)\n1.Withdraw\n2.Fast Withdraw\n3.PIN Change\n4.Balance Check\n5.Show User Information\n6.Exit\n-->"))
            if key==6:
                exit()
            verify1=int(input("\n  ------------  \n||VERIFICATION||\n  ------------  \nEnter your account number:"))
            verify2=int(input("Enter your 4 digit pin:"))
            print("\nVerifying..")
            time.sleep(0.5)
            if(var==4):
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
                                    time.sleep(1)
                                    break;
                                else:
                                    continue
                    else:
                        continue
                if flag1==False:
                    print("\n||#WARNING#||\nWrong Account Number. Please enter correct Account Number")
                    z=1
                if (flag2==False or (verify2<999 and verify2>10000 and z==1)):
                    print("\n||#WARNING#||\nWrong PIN. Please enter correct PIN\n\nYou have ",4-var," attempts left")
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
user_no=int(input("Enter number of users: "))
j=12345678901;
acc_no=[]
pin=[]
name=[]
mob=[]
ini_balance=[]
try:
    for i in range(user_no):
        print("\n##### Account number for "+str(i+1)+"th user is ",j," #####");
        acc_no.append(j)
        time.sleep(0.5)
        print("\nUSER-",i+1,"\n_______\n")
        p=int(input(f"Please enter a 4 digit number to set pin for account number {acc_no[i]}:"))
        if(p<10000 and p>999):
            pin.append(int(p))
        else:
            print("\nInvallid PIN. Please enter vallid 4 digit PIN\n")
            exit()
        n=input("Enter your Name:")
        name.append(n)
        m=int(input("Enter your mobile number:"))
        if(m<10000000000 and m>999999999):
            mob.append(m)
        else:
            print("\nInvallid mobile number. Please enter vallid 10 digit mobile number\n")
            exit(0)
        print("Enter initial fixed balance for account number "+str(j))
        i_balance=int(input("-->"))
        ini_balance.append(float(i_balance))
        j+=1
except:
    exit()
obj=ope(user_no,acc_no,pin,name,mob,ini_balance)
obj.operation()