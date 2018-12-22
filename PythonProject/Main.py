from tika import parser
import csv
import re


class Main:
    pdfFile = 'Project1.pdf'
    files_word_array = []

    def trim2(self, xa):
        # trimmedChar = ["\n", "."]
        i = 0
        while i < len(xa):
            xa[i] = ''.join(e for e in xa[i] if e.isalnum())
            # xa[i] = ''.join([e for e in xa[i] if not e.isdigit()])
            if re.match('^[0-9]+$', xa[i]):
                xa.pop(i)
                i -= 1
            i += 1

    def trim(self, xa):
        trimmedChar = ["\n", "."]
        for i in range(0, len(xa)):
            if xa[i] != ' ':
                if not re.match('[a-zA-Z0-9_]', xa[i]):
                    xa[i].replace(xa[i], ' ')

    def calculate_tf_words(self, teacher_name, file_number):
        parsed = parser.from_file(teacher_name.replace(" ", "_") + "/" + file_number + ".pdf")
        content = parsed["content"]
        print(type(content))
        content = content.lower()
        content.replace("\n", " ")
        self.trim(content)
        wordList = content.split()

        f1 = open("stopWords.txt", "r")
        if f1.mode == 'r':
            contents1 = f1.read()
            y = contents1.split(",")
        self.trim2(wordList)
        i = 0
        while i < len(wordList):
            if len(wordList[i]) < 2:
                wordList.pop(i)
                i -= 1
            i += 1

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

        seen = set()
        countedWords = []
        for item in wordList:
            t = tuple(item)
            if t not in seen:
                countedWords.append([item, wordList.count(item)])
                seen.add(t)

        countedWords.sort(key=lambda x: x[1], reverse=True)
        print(countedWords)
        sum = 0
        for i in countedWords:
            sum += int(i[1])
        print(sum)
        for i in countedWords:
            i.append(i[1] / sum)
        print(countedWords)
        self.files_word_array.append(countedWords)
        with open(teacher_name.replace(" ", "_") + "/" + file_number + 'tf_list.csv', mode='w') as tf_list:
            tf_writer = csv.writer(tf_list, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
            count = 0
            for elements in countedWords:
                try:
                    tf_writer.writerow([elements[0], elements[2]])
                except:
                    print("error")
                count += 1
                if count == 50:
                    break


def main():
    aaa = Main()
    for i in range(0, 3):
        aaa.calculate_tf_words("Ali Fuat Alkaya", str(i))


if __name__ == "__main__":
    main()
