from TeacherFinder import TeacherFinder

f = open("input.txt", "r")
if f.mode == 'r':
    contents = f.read()
    contents = contents.lower()
    x = contents.split(" ")
    print(x)

f1 = open("stopWords.txt", "r")
if f1.mode == 'r':
    contents1 = f1.read()
    y = contents1.split(",")
    print(y)
i, j = [0, 0]
while (i < len(x)):
    while (j < len(y)):
        if (y[j] == x[i]):
            x.remove(x[i])
            i -= 1
            continue
        j += 1
    j = 0
    i += 1

print(x)
i = 0

seen = set()
countedWords = []
for item in x:
    t = tuple(item)
    if t not in seen:
        countedWords.append(item, x)
        seen.add(t)
i, j = [0, 0]

print(countedWords)