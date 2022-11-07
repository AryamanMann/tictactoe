def is_won(grid, player):
    for i in range(3):
        if grid[i][0] == grid[i][1] == grid[i][2] == player:
            return True
        elif grid[0][i] == grid[1][i] == grid[2][i] == player:
            return True
        elif grid[0][0] == grid[1][1] == grid[2][2] == player:
            return True
        elif grid[2][0] == grid[1][1] == grid[0][2] == player:
            return True
    return False


def check(user_input, player):
    if player == 'X' and is_won(user_input, 'X'):
        print('X wins')
        return True
    elif player == 'O' and is_won(user_input, 'O'):
        print('O wins')
        return True
    return False


def print_grid(user):
    print("---------")
    print("|", user[0][0], user[0][1], user[0][2], "|")
    print("|", user[1][0], user[1][1], user[1][2], "|")
    print("|", user[2][0], user[2][1], user[2][2], "|")
    print("---------")


def prompt():
    user_prompt = input().split()
    try:
        a, b = int(user_prompt[0]) - 1, int(user_prompt[1]) - 1
        if a > 2 or b > 2:
            print("Coordinates should be from 1 to 3!")
            user_prompt = prompt()
    except:
        print("You should enter numbers!")
        user_prompt = prompt()

    return user_prompt


def main():
    grid = [
        [' ', ' ', ' '],
        [' ', ' ', ' '],
        [' ', ' ', ' ']
    ]
    count_move = 1
    print_grid(grid)
    user_input = prompt()
    while True:
        a, b = int(user_input[0]) - 1, int(user_input[1]) - 1
        if count_move == 9:
            print('Draw')
            break

        if grid[a][b] == 'X' or grid[a][b] == 'O':
            print("This cell is occupied! Choose another one!")
            user_input = prompt()

        if grid[a][b] == ' ' and count_move % 2 != 0:
            grid[a][b] = 'X'
            print_grid(grid)
            count_move += 1
            if check(grid, 'X'):
                break
            user_input = prompt()
        elif grid[a][b] == ' ' and count_move % 2 == 0:
            grid[a][b] = 'O'
            print_grid(grid)
            count_move += 1
            if check(grid, 'O'):
                break
            user_input = prompt()



if __name__ == '__main__':
    main()
