import math


with open(r'C:\Users\adity\OneDrive\Desktop\CS4 Labs\CS-IS-Labs\src\MovingSidewalk\moving_sidewalk') as input:
    lines = input.readLines()

readerOffset = 0;
while len(lines) > 0:
    dimensions = lines[0].split("/")
    rows = dimensions[0]
    maze = str[dimensions[0]][dimensions[1]]
    for i in range(rows):
        line = lines[readerOffset + i]
        for j in range(len(line)):
            maze[i][j] = line[j]

def find_start(maze):
    for i in range (len(maze)):
        for j in range (len(maze[0])):
            if maze[i][j] == "S":
                return [i, j]

def bfs_d(maze, start):
    maze_num = int[len(maze)][len(maze[0])]
    for i in range(len(maze)):
        for j in range(len(maze[0])):
            maze_num[i][j] = math.inf
    queue = []


    
    