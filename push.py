import os
#git remote set-url origin https://token@github.com/UserName/RepositoryName.git
while True:
    os.system('git add .')
    os.system(f'git commit -m "{input("Name of update >>  ")}"')
    os.system(f'git push -u --force origin master')
    a=input('Нажмите Enter для завершения работы программы или g и Enter для повторного запуска...')
    if a.lower() != "g":
        exit()