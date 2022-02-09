import random
c_win=0;
p_win=0;
def chooseop():
    u_choice=input("Choose Rock, Paper, Scissors: ")
    if u_choice.lower()=='r' or u_choice.lower()=='rock':
        u_choice='r';
    elif u_choice.lower()=='p' or u_choice.lower()=='paper':
        u_choice='p';
    elif u_choice.lower()=='s' or u_choice.lower()=='scissors':
        u_choice='s';
    else:
        print("I don't understand, try again\n")
        chooseop();
    print("Player:",u_choice)
    return u_choice;
def cop():
    c_choice=random.randint(1,3)
    if c_choice==1:
        c_choice='r';
    if c_choice==2:
        c_choice='p';
    if c_choice==3:
        c_choice='s';
    print("Computer:",c_choice)
    return c_choice;
while True:
    print("")
    u_choice=chooseop();
    c_choice=cop();
    print("")
    if u_choice=='r' and c_choice=='r':
        print("You choose Rock and the computer choose Rock. You tied")
    elif u_choice=='r' and c_choice=='p':
        print("You choose Rock and the computer choose Paper. You lose")
        c_win+=1
    elif u_choice=='r' and c_choice=='s':
        print("You choose Rock and the computer choose Scissors. You win")
        p_win+=1
    elif u_choice=='p' and c_choice=='r':
        print("You choose Paper and the computer choose Rock. You win")
        p_win+=1
    elif u_choice=='p' and c_choice=='p':
        print("You choose Paper and the computer choose Paper. You tied")
    elif u_choice=='p' and c_choice=='s':
        print("You choose Rock and the computer choose Scissors. You lose")
        c_win+=1
    elif u_choice=='s' and c_choice=='r':
        print("You choose Rock and the computer choose Rock. You lose")
        c_win+=1
    elif u_choice=='s' and c_choice=='p':
        print("You choose Rock and the computer choose Paper. You win")
        p_win+=1
    elif u_choice=='s' and c_choice=='s':
        print("You choose Scissors and the computer choose Scissors. You tied")
    print("")
    print("Player wins:",p_win)
    print("Computer wins:",c_win)
    print("")
    u_choice=input("Do you want to play again? (y/n)")
    if u_choice.lower()=='y' or u_choice.lower()=='yes':
        pass
    elif u_choice.lower()=='n' or u_choice.lower()=='no':
        break;
    else:
        break;