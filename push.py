import os
os.system('git add .')
os.system(f'git commit -m "{input("Name of update >>  ")}"')
os.system(f'git push -u --force origin master')
input('Нажмите Enter для завершения работы программы...')