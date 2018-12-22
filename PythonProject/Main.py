import PyPDF2
from tika import parser

class Main:

    pdfFile = 'Project1.pdf'

    def trim(x):
        trimmedChar = ["\n", "."]
        for i, element in enumerate(x):
            for char in trimmedChar:
                x[i] = x[i].replace(char, "")

    parsed = parser.from_file(pdfFile)
    content = parsed["content"]
    print(type(content))
    content = content.lower()
    wordList = content.split(" ")
    trim(wordList)
    print(wordList)

    f1 = open("stopWords.txt", "r")
    if f1.mode == 'r':
        contents1 = f1.read()
        y = contents1.split(",")
        print(y)
    i, j = [0, 0]
    while (i < len(wordList)):
        while (j < len(y)):
            if (y[j] == wordList[i]):
                wordList.remove(wordList[i])
                i -= 1
                continue
            j += 1
        j = 0
        i += 1

    print(wordList)
    i = 0

    seen = set()
    countedWords = []
    for item in wordList:
        t = tuple(item)
        if t not in seen:
            countedWords.append([item, wordList.count(item)])
            seen.add(t)
    i, j = [0, 0]

    print(countedWords)

