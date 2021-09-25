import os
#git remote set-url origin https://token@github.com/UserName/RepositoryName.git
while True:
    un=input("Name of update >>  ")
    os.system('git add .')
    os.system(f'git commit -m "{un}"')
    os.system(f'git push -u --force origin master')
    a=input('Нажмите Enter для завершения работы программы или g и Enter для повторного запуска...\n')
    if a.lower() != "g":
        exit()