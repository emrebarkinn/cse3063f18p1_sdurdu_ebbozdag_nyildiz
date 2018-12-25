from tika import parser
import csv
import re
import math
from wordcloud import WordCloud
import matplotlib.pyplot as plt


class Main:
    pdfFile = 'Project1.pdf'
    files_word_array = []
    dictinory_list = []
    idf_dict = {}

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

            temp_dict = {}
            tf_writer = csv.writer(tf_list, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)

            headers = ['Word', 'TfValue']
            tf_writer.writerow(headers)

            count = 0
            for elements in countedWords:
                temp_dict.update({elements[0]: float(elements[2])})
                if count <= 50:
                    try:
                        tf_writer.writerow([elements[0], elements[2]])
                    except:
                        print("error")

                count += 1

            self.dictinory_list.append(temp_dict)
        with open(teacher_name.replace(" ", "_") + "/" +file_number+'tf_list.csv') as csv_file:
            csv_reader = csv.reader(csv_file)
            d = {}
            for row in csv_reader:
                try:
                    if row[0] == 'Word':
                        continue

                    d.update({row[0]: float(row[1])})
                except:
                    pass


        '''
        wordcloud = WordCloud(width=800, height=800,
                              background_color='white',
                              min_font_size=10).generate_from_frequencies(d)
        fig = plt.figure(1)
        plt.imshow(wordcloud)
        plt.axis('off')
        plt.show()
        fig.savefig("word1.png", dpi=900)
        '''

    def calculateIdf(self):


        for i in range(0,len(self.dictinory_list)):
            for word, key in self.dictinory_list[i].items():
                self.idf_dict[word] = key


        for word,key in self.idf_dict.items():
            temp_count=0
            for i in range(0,len(self.dictinory_list)):
                if word in self.dictinory_list[i]:
                    temp_count += 1
            self.idf_dict[word] = math.log10(len(self.dictinory_list)/temp_count)

        for word in sorted(self.idf_dict.items(), key=lambda x : x[1] ,reverse=True):
            print(word[0] + " " + str(word[1]))

    def calculate_idf_tf(self):

        for i in range(0, len(self.dictinory_list)):

            temp_dict = {}
            for word, key in self.idf_dict.items():
                if word in self.dictinory_list[i]:
                    temp_dict[word] = key*self.dictinory_list[i][word]
            count=0
            for aaa in sorted(temp_dict.items(), key=lambda x: x[1], reverse=True):
                if count <= 50:
                    print(aaa[0] + " " + str(aaa[1]))
                count += 1
            print("-----------------------------")


def main():
    aaa = Main()
    for i in range(0, 25):
        aaa.calculate_tf_words("Haluk_Topçuoğlu", str(i))

    aaa.calculateIdf()
    aaa.calculate_idf_tf()

if __name__ == "__main__":
    main()
