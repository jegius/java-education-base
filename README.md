1. [Коротко о pull request](#pull-request)
1. [Как делать Rebase?](#rebase)
1. [Что делать если возник merge conflict?](#Что-такое-merge-conflict)
1. [Как сделать сложный merge?](#Как-сделать-сложный-merge)
1. [Новая структура проекта](#Новая-структура)


## Как начать работу?

Склонировать репозиторий себе на пк:

Для этого сначала нужно взять ссылку с репозитория

![Первый шаг](images/mainreadme/clone.jpg)

Затем скопировать скопировать ее в ide в окно VCS => Checkout from Version Control => git

![Второй шаг](images/mainreadme/clone-repository-window.jpg)

Выполнять работу нужно на своей ветке. 

## Как создать свою ветку? 

## Первый шаг
![Первый шаг](images/mainreadme/workwithbranch/step-one.jpg)
## Второй шаг
![Второй шаг](images/mainreadme/workwithbranch/step-two.jpg)
## Третий шаг
Имя бренча формируется из:

Имя исполнителя - выполняемое задание

Пример:

`ivan-menu.commands.tasks.objects`

![Третий шаг](images/mainreadme/workwithbranch/step-three.jpg)
## Четвертый шаг
![Четвертый шаг](images/mainreadme/workwithbranch/step-four.jpg)
## Пятый шаг

На своей ветке можете писать код и делать любое колличество коммитов.
[Как работать с веткой (бернчом)?](#Как-работать-с-веткой)

![Пятый шаг](images/mainreadme/workwithbranch/step-five.jpg)
## Шестой шаг
![Шестой шаг](images/mainreadme/workwithbranch/step-six.jpg)
## Седьмой шаг
Решив что-то закоммитить, опиши что именно ты сделал, в краткой но понятной форме

![Седьмой шаг](images/mainreadme/workwithbranch/step-seven.jpg)
## Восьмой шаг
После добавления описания можно закоммитить все что ты написал на свой пк (commit) или залить закоммитить локально а затем залить
изменения на сервер (commit and push)

![Восьмой шаг](images/mainreadme/workwithbranch/step-eight.jpg)
## Девятый шаг
![Девятый шаг](images/mainreadme/workwithbranch/step-nine.jpg)
## Десятый шаг
Если все прошло успешно то в IDE появится оповещение об этом, если push по каким то причинам не удался
то гит тебя об этом оповестит так же.

![Десятый шаг](images/mainreadme/workwithbranch/step-ten.jpg)
## Одинадцатый шаг
После всех проделаннх действий твою ветку можно будет увидеть на git

![Одинадцатый шаг](images/mainreadme/workwithbranch/step-eleven.jpg)

# Как работать с веткой?
Написаннй тобой код хранится в системе контроля версий которая сопоставляет твои измениня с кодом который хранится
на серверах git. После checkout и первого push твой код хранится в двух местах:

- У тебя на компьютере

![Локальная ветка](images/mainreadme/local.jpg)
- На сервере

![Ветка на сервере](images/mainreadme/workwithbranch/step-eleven.jpg)

После одобрения pull request и мерджа в мастер свою ветку можно удалить, чтобы она не захламляла место. 

Удалить можно через git нажав на кнопку корзины:

![Удаление на git](images/mainreadme/delete-branch.jpg)

Или через интерфейс IDE:

![Удаление через IDE](images/mainreadme/local-delete.jpg)

После удаления в IDE она спросит тебя нужно ли удалить ветку на сервере, **будь предельно внимателен на этом моменте 
иногда по невнимательности есть опасность удалить нужную ветку с сервера**

![Удаление через IDE](images/mainreadme/delete.jpg)

При выборе пункта `restore` ветка будет востановлена.
 
# Pull request

**Перед создание pull request необходимо сделать [rebase](#rebase) на мастер!**

PULL REQUEST - это запрос на перенос данных с твоей ветки на основуню ветку разработки - master

**Напрямую в `master` коммитить запрещено! все измения должны проходить только через pull request!**  

Для отправки задания на проверку нужно будет сделать несколько действий:

После того как ты посчитаешь что задание выполнено нужно перейти на github, найти свою ветку и нажать на кнопку
`new pull request`

![Ветка на сервере](images/mainreadme/pullrequest/pull-request-one.jpg)

Откроется окно создания pull request. Нужно заполнить название pull request и сделать assign на меня, а так же выставить
label `done`. Можно выставлять и другие лейблы, например `help wanted` если в ходе выполнения задания или исправлнения
замечаний по pull request возникли сложности. 
![Ветка на сервере](images/mainreadme/pullrequest/pull-request-two.jpg)

Так же в описании желательно заполнить что именно было сделано.
![Ветка на сервере](images/mainreadme/pullrequest/pull-request-three.jpg)

## Rebase

Перед созданием pull request необходимо подтянуть измениня которые могли возникнуть в мастере после того как ты создал 
свою ветку. Для этого необходимо:

Перейти с твоей текущей ветки на ветку в которую ты хочешь сделать pull request (в нашем случае ветка `master`)

![Rebase one](images/mainreadme/rebase/rebase-one.jpg)

Обновить ветку до последней версии

![Rebase two](images/mainreadme/rebase/rebase-two.jpg)

Нажать Ok использовав параметры которые идея выставит по умолчанию.

![Rebase three](images/mainreadme/rebase/rebase-three.jpg)

Вернутся на ветку в которой ты писал код и с которой ты будешь отправлять pull request.

![Rebase four](images/mainreadme/rebase/rebase-four.jpg)

Находясь на этой ветке в меню гит выбрать пункт `rebase current onto selecte` у ветки в которую будет отправлен 
pull request (В нашем случае в `master`)

![Rebase five](images/mainreadme/rebase/rebase-five.jpg)

Изменение лучше отправлять с помощью **force push** Однако будь предельно внимателен! Force push удалит 
все изменения в твоей ветке на сервере и зальет на него твою текущую ветку с того пк на котором ты сейчас работаешь. 

**! Использовать Force push можно только на своей ветке и только при полной уверенности что на серевере 
нет кода которого нет на твоем текущем пк !**

![Rebase six](images/mainreadme/rebase/rebase-six.jpg)

## Что такое merge conflict?

Git отслеживает изменения во всех файлах построчно, и если он видит что в одном и том же файле, в одной и той же строчке
два разных пользователя сделали два разных изменения, то при попытки обновить ветку (например с помощью rebase) 
возникнит конфликт. Для его решения если изменеий много и самостоятельно ты в них разобраться не способен необходимо:

Вычислить автора изменений которые конфликтуют с твоим кодом. Для этого в Idea кликни правой клавишей мыши 
по любому номеру строкчки кода.

![conflict one](images/mainreadme/conflicts/conflict-one.jpg)

Поле этого возле каждой строчки кода появится имя пользователя который внес изменения в файл и время, когда он 
это сделал.

![conflict two](images/mainreadme/conflicts/conflict-two.jpg)

Дальше желательно связаться с ним и убедится что твои изменения не сломают логику автора. 

**! Удалять код другого пользователя без причины или согласования запрещено !**

Если конфликт не сложный можно добавть свой код самостоятельно не удаляя при этом код предидущего автора.

## Как сделать сложный merge?

Merge считается одной из самых сложных операций при работе с SVN в не зависимости от ее типа. В случае если 
на проекте произошло много изменений, его сложность многократно увеличивается. Перед тем как начать мердж
необходимо простмотреть все изменения в ветке в которую в будущем сделать слияние и пронять как это повлияет на 
то что ты уже сделал и как изменить свой текущий код чтобы он успешно работал на новой ветке. 

На примере больших изменений между локальной веткой и мастером.

- Открываем проект, убедившись что находимся на своей ветке которую нужно обновить до уровня текущего мастера

![Your work branch](images/mainreadme/howtomakecomplicatedmerge/work-branch.jpg)

- Переходим на ветку изменения с которой нам нужно перенести в нашу. (В нашем случае `master`)

![Master](images/mainreadme/howtomakecomplicatedmerge/master.jpg)

- Обновляем ветку с которой мы хоти подтянуть изменения до последней версии.

![Your work branch](images/mainreadme/howtomakecomplicatedmerge/return-to-work-branch.jpg)

- Возвращаемся к своей ветке

`Если в проекте есть какие-либо незакоммиченные изменения то при пререходе от ветки к ветки идея будет показывать тебе
окно с проблемами checkout, в общем случае нужно нажимать smart checkout`

![window example](images/mainreadme/howtomakecomplicatedmerge/git-checkout-problem.jpg)

- Выбираем бренч с которого мы хотим подтянуть изменения (`master`), выбираем `rebase current onto selected`

`Если на целевой ветке и на той которую на которую ты хочешь сдалть rebase имееются изменения в одних и тех же файлах, 
появится окно conflicts: `

![Conflicts](images/mainreadme/howtomakecomplicatedmerge/conflicts.jpg)

`Что именно выбрать, зависит от сепецифики изменений на векте. В данном случае мы видим что файл в котором были сделанны
 изменния на твоей ветке удален в мастере. Изменения в мастере всегад в приоритете, а значит и тебе необходимо 
 выбрать пункт ACCEPT THEIRS и понять как сделать так, чтобы твой код запускался. Для этого перед мерджом необходимо 
 для начала разобраться что именно произошло на проекте и как и куда нужно добавить код.`
 
 Посмотрев на структуру проекта мы видим что она серьезно изменилась: 
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/new-structure.jpg)

 Подробно на изменениях останавливаться не имеет смыла, но для программиста очень важно уметь самостоятельно разбираться
 с незнакомым кодом, по этом я настоятельно рекомендую перед rebase запустить проект несколько раз и попробовать
 самостоятельно понять что и как работает, и куда и что нужно добавить для окончательного выполнения задания.

 Если самому в том что происходит разобраься все такеи 
 не поулчеается то про новую структуру программы [читай здесь](#Новая-структура)
 
 Изучив структуру проекта м ыидим что задачи теперь находятся в папке tasks

 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/objects.jpg)
 
 Так как выполняется задание Objects то необходимо пренести выполнение задания из старого метста в новое, дирикторию
 в которой лежало старое задание нужно удалить
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/pub.jpg)
 
 Видим что в нашем файле Pub идея увидила ошибка:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/pub-error-one.jpg)
 
 Заходим в файл и пытаемся понять что с ним не так:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/pub-error-two.jpg)
 
 Видим что проблема в неправильном импорте абстарктного класса. Удаляем старый импорт, ставим курсор на 
 название абстрактного класса Organization и нажимаем ctrl + enter (cmd + enter в Mac) выбираем подпункт import class.
 После этого ошибка исчезнет, но задание не будет показанно в меню консольного приложения и не может считаться выполненным.
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/example-run.jpg)
 
 Для полного его выполнения необходимо добавить его в меню. Для этого смотрим как сделаны уже готовые задания.
 
 `Все структуры использованные в задании будут рассмотренны нами позже, сейчас на них останавливаться подробно не имеет смысла`
 
 Изучив как выводятся в консоль команды, находим класс ObjectTaskCommand в котором видим следующие записи:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/task-command.jpg)
 
 Делаем все по аналогии, добавляя новый пункт меню с выполнением задания.
 
 Сначала добавляем новый пункт меню путем копирования одно из ни и добавления названия нашего объекта:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub.jpg)
 
 Видим что ниже есть конструкция switch case отвечающая за выбор задания и ExerciseFactory, отвечающая за создание
 конкретного объекта:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-one.jpg)
 
 Обращаем внимание что каждое задане имеет свой индекс в switch case и свое название в перечислении Exercise, зажимаем
 cmd\ctrl и кликаем на названии перечисления, после чего попадаем в него:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-two.jpg)
 
 Видим что для каждого задания имеется соответвующее ему название в enum, добавляем запис для нашего задания:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-three.jpg)
 
 Возвращаемся в класс ObjectTaskCommand и добавляем в switch case, case с идексом который мы указывали выше (4), 
 в него копируем тоже самые действия что проделаны в предидущем пункте, за исключением того что в аргументы метода 
 createOrganization мы отправлем Exercise.PUB:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-four.jpg)
 
 Переходим в ExerciseObjectFactory, и видим что в ней так же есть switch case в котором происходит создание объектов для
 заданий:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-five.jpg)
 
 Добавляем пункт для нашего задания:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-six.jpg)
 
 Запускаем приложение и проверяем:
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-seven.jpg)
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/add-pub-eight.jpg)
 
 Задание успешно добавлено, можно делать commit + push в совю ветку и создавать pull request
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/all-done.jpg)
 
 ![Conflicts](images/mainreadme/howtomakecomplicatedmerge/all-done-one.jpg)
 
 
## Новая-структура

Нам пора двигаться вперед, и структура нашего приложения изменилась. Приложение стало консольным, теперь выполнения заданий может
происхоить в любой момент по желанию пользователя. 

Как добавить выполнение задание?

Все актуальные и будущие просты задания будут храниться в впапке `menu => commands => tasks`

![Conflicts](images/mainreadme/newstructure/new-structure-one.jpg)

Здесь хранятся все задания по папкам с отдельным для каждого readme с указанием задания.

В каждой папке есть примр, выполнять задания нужно по аналогии с примером. Подробное добавление ответа на задание
на примере задания `objects` описанно выше.
