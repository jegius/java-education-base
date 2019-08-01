1. [Коротко о pull request](#pull-request)
1. [Как делать Rebase?](#rebase)
1. [Что делать если возник merge conflict?](#Что-такое-merge-conflict)


## Как начать работу?

Склонировать репозиторий себе на пк:

Для этого сначала нужно взять ссылку с репозитория

![Первый шаг](images/clone.jpg)

Затем скопировать скопировать ее в ide в окно VCS => Checkout from Version Control => git

![Второй шаг](images/clone-repository-window.jpg)

Выполнять работу нужно на своей ветке. 

## Как создать свою ветку? 

## Первый шаг
![Первый шаг](images/step-one.jpg)
## Второй шаг
![Второй шаг](images/step-two.jpg)
## Третий шаг
Имя бренча формируется из:

Имя исполнителя - выполняемое задание

Пример:

`ivan-menu.commands.tasks.objects`

![Третий шаг](images/step-three.jpg)
## Четвертый шаг
![Четвертый шаг](images/step-four.jpg)
## Пятый шаг

На своей ветке можете писать код и делать любое колличество коммитов.
[Как работать с веткой (бернчом)?](#Как-работать-с-веткой)

![Пятый шаг](images/step-five.jpg)
## Шестой шаг
![Шестой шаг](images/step-six.jpg)
## Седьмой шаг
Решив что-то закоммитить, опиши что именно ты сделал, в краткой но понятной форме

![Седьмой шаг](images/step-seven.jpg)
## Восьмой шаг
После добавления описания можно закоммитить все что ты написал на свой пк (commit) или залить закоммитить локально а затем залить
изменения на сервер (commit and push)

![Восьмой шаг](images/step-eight.jpg)
## Девятый шаг
![Девятый шаг](images/step-nine.jpg)
## Десятый шаг
Если все прошло успешно то в IDE появится оповещение об этом, если push по каким то причинам не удался
то гит тебя об этом оповестит так же.

![Десятый шаг](images/step-ten.jpg)
## Одинадцатый шаг
После всех проделаннх действий твою ветку можно будет увидеть на git

![Одинадцатый шаг](images/step-eleven.jpg)

# Как работать с веткой?
Написаннй тобой код хранится в системе контроля версий которая сопоставляет твои измениня с кодом который хранится
на серверах git. После checkout и первого push твой код хранится в двух местах:

- У тебя на компьютере

![Локальная ветка](images/local.jpg)
- На сервере

![Ветка на сервере](images/step-eleven.jpg)

После одобрения pull request и мерджа в мастер свою ветку можно удалить, чтобы она не захламляла место. 

Удалить можно через git нажав на кнопку корзины:

![Удаление на git](images/delete-branch.jpg)

Или через интерфейс IDE:

![Удаление через IDE](images/local-delete.jpg)

После удаления в IDE она спросит тебя нужно ли удалить ветку на сервере, **будь предельно внимателен на этом моменте 
иногда по невнимательности есть опасность удалить нужную ветку с сервера**

![Удаление через IDE](images/delete.jpg)

При выборе пункта `restore` ветка будет востановлена.
 
# Pull request

**Перед создание pull request необходимо сделать [rebase](#rebase) на мастер!**

PULL REQUEST - это запрос на перенос данных с твоей ветки на основуню ветку разработки - master

**Напрямую в `master` коммитить запрещено! все измения должны проходить только через pull request!**  

Для отправки задания на проверку нужно будет сделать несколько действий:

После того как ты посчитаешь что задание выполнено нужно перейти на github, найти свою ветку и нажать на кнопку
`new pull request`

![Ветка на сервере](images/pull-request-one.jpg)

Откроется окно создания pull request. Нужно заполнить название pull request и сделать assign на меня, а так же выставить
label `done`. Можно выставлять и другие лейблы, например `help wanted` если в ходе выполнения задания или исправлнения
замечаний по pull request возникли сложности. 
![Ветка на сервере](images/pull-request-two.jpg)

Так же в описании желательно заполнить что именно было сделано.
![Ветка на сервере](images/pull-request-three.jpg)

## Rebase

Перед созданием pull request необходимо подтянуть измениня которые могли возникнуть в мастере после того как ты создал 
свою ветку. Для этого необходимо:

Перейти с твоей текущей ветки на ветку в которую ты хочешь сделать pull request (в нашем случае ветка `master`)

![Rebase one](images/rebase-one.jpg)

Обновить ветку до последней версии

![Rebase two](images/rebase-two.jpg)

Нажать Ok использовав параметры которые идея выставит по умолчанию.

![Rebase three](images/rebase-three.jpg)

Вернутся на ветку в которой ты писал код и с которой ты будешь отправлять pull request.

![Rebase four](images/rebase-four.jpg)

Находясь на этой ветке в меню гит выбрать пункт `rebase current onto selecte` у ветки в которую будет отправлен 
pull request (В нашем случае в `master`)

![Rebase five](images/rebase-five.jpg)

Изменение лучше отправлять с помощью **force push** Однако будь предельно внимателен! Force push удалит 
все изменения в твоей ветке на сервере и зальет на него твою текущую ветку с того пк на котором ты сейчас работаешь. 

**! Использовать Force push можно только на своей ветке и только при полной уверенности что на серевере 
нет кода которого нет на твоем текущем пк !**

![Rebase six](images/rebase-six.jpg)

## Что такое merge conflict?

Git отслеживает изменения во всех файлах построчно, и если он видит что в одном и том же файле, в одной и той же строчке
два разных пользователя сделали два разных изменения, то при попытки обновить ветку (например с помощью rebase) 
возникнит конфликт. Для его решения если изменеий много и самостоятельно ты в них разобраться не способен необходимо:

Вычислить автора изменений которые конфликтуют с твоим кодом. Для этого в Idea кликни правой клавишей мыши 
по любому номеру строкчки кода.

![conflict one](images/conflict-one.jpg)

Поле этого возле каждой строчки кода появится имя пользователя который внес изменения в файл и время, когда он 
это сделал.

![conflict two](images/conflict-two.jpg)

Дальше желательно связаться с ним и убедится что твои изменения не сломают логику автора. 

**! Удалять код другого пользователя без причины или согласования запрещено !**

Если конфликт не сложный можно добавть свой код самостоятельно не удаляя при этом код предидущего автора.
