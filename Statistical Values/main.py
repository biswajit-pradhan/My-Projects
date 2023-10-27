"""Program to find all the statistical values i.e Mean,Median,Mode,Range,Variance"""
def mean(a,value):
    total=0;
    for i in range(value):
        total=total+a[i];
    print("Mean=",total/value)
if __name__=="__main__":
    value=int(input("Enter total number of elements:"))
    a=[]
    for i in range(value):
        b=float(input(f"Enter {i+1}th element"))
        a.append(b)
    mean(a,value)
    

    