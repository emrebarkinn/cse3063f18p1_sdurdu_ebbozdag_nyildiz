import PyPDF2
'''
def trim(x):
    for i,element in enumerate(x):
        x[i] = element.replace(".", "")

'''
'''
f = open("input.txt", "r")
if f.mode == 'r':
    contents = f.read()
    contents = contents.lower()
    x = contents.split(" ")

    trim(x)
    print(x)
'''

f = open('kulup.pdf', 'rb')
pdfReader = PyPDF2.PdfFileReader(f)
print(pdfReader.getNumPages())
pageObj = pdfReader.getPage(1)
print(pageObj.extractText())
f.close()
'''
if f.mode == 'rb':
    contents = f.read()
    contents = contents.lower()
    x = contents.split(" ")

    trim(x)
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
        countedWords.append([item,x.count(item)])
        seen.add(t)
i, j = [0, 0]

print(countedWords)
'''
