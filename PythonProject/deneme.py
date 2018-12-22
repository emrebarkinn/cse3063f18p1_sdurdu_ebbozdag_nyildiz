import scholarly
from pathlib import Path
import requests
from urllib.request import Request, urlopen
import requests
import urllib.request
from bs4 import BeautifulSoup
import os
import errno

from TeacherFinder import TeacherFinder

class DownloadPdf:
    teachers = []
    teachers_temp = None
    department_name = None

    def __init__(self, department_name):
        self.department_name = department_name
        self.teachers_temp = TeacherFinder(department_name)
        self.teachers = self.teachers_temp.get_teachers()

    def set_teacher(self):
        print("Teachers of " + str(self.department_name))
        self.teachers_temp.print_teachers()
        teacher_name = input("Please enter teacher name (If you want all teacher enter \'all\'):")

        if self.teachers.index(teacher_name) < 0 and teacher_name != "all":
            print("That teacher is not exist")
            return
        elif teacher_name != "all":
            for i in range(0, len(self.teachers)):
                if i != self.teachers.index(teacher_name):
                    self.teachers.pop(i)
        print("Teacher name has been set")

    def download_teacher_pdf(self, teacher_name):
        search_query = scholarly.search_author(teacher_name)
        author = next(search_query).fill()

        print(len(author.publications))
        count = 0
        for i in author.publications:
            try:
                doc_url = i.fill().bib['eprint']

                if doc_url.endswith(".pdf"):

                    doc_url = doc_url[doc_url.rfind("http", 0, len(doc_url)):]
                    print(doc_url)
                    response = requests.get(doc_url, stream=True)
                    if response.status_code == 200:
                        filename = teacher_name.replace(" ", "_") + "/" + str(count) + '.pdf'
                        if not os.path.exists(os.path.dirname(filename)):
                            try:
                                os.makedirs(os.path.dirname(filename))
                            except OSError as exc:  # Guard against race condition
                                if exc.errno != errno.EEXIST:
                                    raise
                        with open(filename, 'wb') as f:
                            f.write(response.content)

                        count += 1


            except:
                print(end="")

    def download_teacher_list_pdf(self):
        for teacher_name in self.teachers:
            self.download_teacher_list_pdf(teacher_name)
