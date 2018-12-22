import requests
from bs4 import BeautifulSoup


class TeacherFinder:
    teachers = []

    def __init__(self,department_name):
        r = requests.get("https://eng.marmara.edu.tr/akademik/akademik-kadro/ogretim-uyeleri")

        data = r.text

        soup = BeautifulSoup(data, 'html.parser')

        j = 0
        for aaa in soup.find_all('td'):

            deneme = ''.join(aaa.findAll(text=True))
            deneme2 = deneme.split()

            if (j != 0) and (j % 6 == 0) and (j <= 678):
                tempName = ""
                for i in range(1, len(deneme2)):
                    tempName += deneme2[i]
                    tempName += " "

                    i += 1
                tempName += deneme2[0]
                if tempName != "":
                    self.teachers.append(tempName.replace(",", ""))
            if (j != 5) and (j % 6 == 5) and (j <= 683):
                if len(deneme2) == 0:
                    self.teachers.pop()
                elif deneme2[0].find(department_name) < 0:
                    self.teachers.pop()

            j += 1

    def get_teachers(self):

        return self.teachers

    def print_teachers(self):

        for i in self.teachers:
            print(i)
        return

