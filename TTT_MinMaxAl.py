# update 1.1 to tic tac toe using min-max algorithm
import numpy as np

def create_empty_board():
    return np.zeros((3, 3), dtype=int)

def print_board(board):
    print(board)

def check_winner(board, player):

    for i in range(0, 3): # row, column
        if np.all(board[i, :] == player) or np.all(board[:, i] == player): # checks for all horziontals, verticals
            return True
    if np.all(np.diag(board) == player) or np.all(np.diag(np.fliplr(board)) == player): # checks for all diagonals
        return True
    return False

board = create_empty_board()
print_board(board)

