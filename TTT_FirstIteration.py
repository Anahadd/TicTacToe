# very basic TTT when i first learned python
import random 

def game(score_computer,score_user):
  
  for i in range(0, 4):
    user_input = input("Input: ")
    y = x[random.randint(0, 2)]
    print(y)
    if y == 'Rock':
      if user_input == 'Paper':
        score_user =score_user+ 1
        print(score_user,score_computer)
      elif y == user_input:
        score_user = score_user
        score_computer = score_computer
        print(score_user,score_computer)
      else:
        score_computer += 1
        print(score_user,score_computer)
    
    elif y == 'Paper':
      if user_input == 'Scissors':
        score_user += 1
        print(score_user,score_computer)
      elif y == user_input:
        score_user = score_user
        score_computer = score_computer
        print(score_user,score_computer)
      else:
        score_computer += 1
        print(score_user,score_computer)
    elif y == 'Scissors':
      if user_input == 'Rock':
        score_user += 1
        print(score_user,score_computer)
      elif y == user_input:
        score_user = score_user
        score_computer = score_computer
        print(score_user,score_computer)
      else:
        score_computer += 1
        print(score_user,score_computer)
  if score_user > score_computer:
    print("User won! ")
    print(score_user, score_computer)
  elif score_computer == score_user:
    print("Tie!")
    print(score_user, score_computer)
  else:
    print("Computer won! ")
    print(score_user, score_computer)

        
        
  

x = ['Rock','Paper','Scissors']
score_computer=0
score_user=0
game(score_computer,score_user)


ask_user = input("Do you want to play again: ")
if ask_user == 'n' or ask_user =='N':
  print("Sounds good. Nice playing!")
else:
  game(score_computer,score_user)
