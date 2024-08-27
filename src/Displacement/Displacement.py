with open('displacement.dat') as f:
    list_lines = f.readlines

dimensions = list_lines[0].replace("{", "").replace("}", "").split(",");

print(dimensions);