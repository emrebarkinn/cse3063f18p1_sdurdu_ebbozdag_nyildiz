
from tika import parser

class Main:

    pdfFile = 'Project1.pdf'

    def trim(xa):
        trimmedChar = ["\n", "."]
        for i in range(0, len(xa)):
            xa[i] = ''.join(e for e in xa[i] if e.isalnum())
            xa[i] = ''.join([e for e in xa[i] if not e.isdigit()])
        #for i in range(0,len(x)):





    parsed = parser.from_file(pdfFile)
    content = parsed["content"]
    print(type(content))
    content = content.lower()
    content.replace("\n", " ")
    wordList = content.split()
    trim(wordList)


    #print(wordList)

    f1 = open("stopWords.txt", "r")
    if f1.mode == 'r':
        contents1 = f1.read()
        y = contents1.split(",")
        #print(y)

    for i in wordList:
        if len(i) == 0:
            wordList.remove(i)

    i, j = [0, 0]
    while i < len(wordList):
        while j < len(y):
            if y[j] == wordList[i]:
                wordList.remove(wordList[i])
                i -= 1
                continue
            j += 1
        j = 0
        i += 1

    #print(wordList)
    i = 0

    seen = set()
    countedWords = []
    for item in wordList:
        t = tuple(item)
        if t not in seen:
            countedWords.append([item, wordList.count(item)])
            seen.add(t)
    i, j = [0, 0]

    for i in countedWords:
        if len(i[0])==0:
            countedWords.remove(i)

    countedWords.sort(key=lambda x: x[1], reverse=True)
    print(countedWords)

