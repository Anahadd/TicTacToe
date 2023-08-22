# 1.2 - issues (the min max algorithm does not work properly)
import numpy as np

def create_empty_board():
    return np.zeros((3, 3), dtype=int)

def print_board(board):
    for row in board:
        print(' '.join(map(str, row)))

def place_move(board, player, row, col):
    if board[row, col] == 0:
        board[row, col] = player
        return True
    else:
        print("Invalid move. Cell already occupied.")
        return False
    
def check_winner(board, player):
    for i in range(3):
        if np.all(board[i, :] == player) or np.all(board[:, i] == player):
            return True
    if np.all(np.diag(board) == player) or np.all(np.diag(np.fliplr(board)) == player):
        return True
    return False

def get_empty_cells(board):
    return np.argwhere(board == 0)

def minimax(board, depth, maximizing_player):
    if check_winner(board, 1):
        return 1
    if check_winner(board, -1):
        return -1
    if len(get_empty_cells(board)) == 0:
        return 0

    if maximizing_player:
        max_eval = float('-inf')
        for move in get_empty_cells(board):
            new_board = board.copy()
            new_board[move[0], move[1]] = 1
            eval = minimax(new_board, depth + 1, False)
            max_eval = max(max_eval, eval)
        return max_eval
    else:
        min_eval = float('inf')
        for move in get_empty_cells(board):
            new_board = board.copy()
            new_board[move[0], move[1]] = -1
            eval = minimax(new_board, depth + 1, True)
            min_eval = min(min_eval, eval)
        return min_eval

def make_auto_move(board, player):
    empty_cells = get_empty_cells(board)
    if len(empty_cells) > 0:
        scores = []
        for move in empty_cells:
            new_board = board.copy()
            new_board[move[0], move[1]] = player
            score = minimax(new_board, 0, False)
            scores.append(score)
        best_move_index = np.argmax(scores) if player == 1 else np.argmin(scores)
        best_move = empty_cells[best_move_index]
        place_move(board, player, best_move[0], best_move[1])

# Simulation
total_plays = 100
player_x_wins = 0
player_o_wins = 0
draws = 0

for _ in range(total_plays):
    board = create_empty_board()
    current_player = 1  

    while True:
        if current_player == 1:
            row, col = map(int, input("Player 'X', enter row and column (e.g., 0 0): ").split())
            place_move(board, current_player, row, col)
        else:
            make_auto_move(board, current_player)

        print_board(board)

        if check_winner(board, current_player):
            if current_player == 1:
                player_x_wins += 1
                print("Player 'X' wins!")
            else:
                player_o_wins += 1
                print("Player 'O' wins!")
            break

        if np.all(board != 0):
            draws += 1
            print("It's a draw!")
            break

        current_player *= -1  

