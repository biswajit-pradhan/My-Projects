import random
input(" _________________________________\n||Press enter to Play the Dice Game||\n _______________$_________________")
def roll(min,max):
    print(random.randint(min,max))
    while True:
        c=input("Press enter for continue the rolling else press N: ")
        if c.lower()!='n':
            print(random.randint(min,max))
        else:
            break;
        
roll(1,6)