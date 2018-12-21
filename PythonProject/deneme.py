import scholarly
from pathlib import Path
import requests
from urllib.request import Request, urlopen
import requests
import urllib.request
from bs4 import BeautifulSoup

from TeacherFinder import TeacherFinder

aaa = TeacherFinder()
teachers = aaa.get_teachers()

search_query = scholarly.search_author('Ali Fuat Alkaya')
author = next(search_query).fill()
# print(author)

# Print the titles of the author's publications
# print([pub.bib['title'] for pub in author.publications])

# Take a closer look at the first publication

pub = author.publications[0].fill()
# print(pub)
print(len(author.publications))
count=0
for i in author.publications:
    try:
        doc_url = i.fill().bib['eprint']

        if doc_url.endswith(".pdf"):

            doc_url = doc_url[doc_url.rfind("http", 0, len(doc_url)):]
            print(doc_url)
            response = requests.get(doc_url, stream=True)
            with open('asd'+str(count)+'.pdf', 'wb') as f:
                f.write(response.content)
            count += 1

    except:
        print("error")

url = pub.bib['url']
print(url)

# r = requests.get(url)

# with open("document232.txt", "wb") as code:
#    code.write(r.content)
