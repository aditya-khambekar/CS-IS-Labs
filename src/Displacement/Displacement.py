import math


with open(r'C:\Users\adity\OneDrive\Desktop\CS4 Labs\CS-IS-Labs\src\Displacement\displacement.dat') as f:
    list_lines = f.readlines()

dimensions = list_lines[0].replace("(", "").replace(")", "").split(",");

#print(dimensions);

x_coord = float(dimensions[0]);
y_coord = float(dimensions[1]);

original_x = x_coord
original_y = y_coord

for i in range(1, len(list_lines)):
    numbers = list_lines[i].split("/");
    numbers2 = [0] * 2
    for j in range(2):
        #print(j)
        numbers2[j] = float(numbers[j])
    x_coord = x_coord + numbers2[1]*math.cos(math.radians(numbers2[0]))
    y_coord = y_coord + numbers2[1]*math.sin(math.radians(numbers2[0]))

final_distance = math.sqrt((original_x-x_coord)**2 + (original_y-y_coord)**2)

print("%2.2f" % (final_distance))
        
