# Apteka-SystemWarehouse
## Данная программа построена по принципу трёхуровневой архитектуры на стеке:
### Vaadin (frontend layer)/Java Spring Framework (backend layer)/ PostgreSQL (СУБД)(database layer). 
Основной задачей было реализовать интерфейс для рабочих процессов фармацевтической компании. 
## Под рабочими процессами подразумевается:
### -Поиск, продажа, учет и заказ(в случае отсутсвия) медикаментов;
### -Оформление рецепта с последующей валидацией на соответсвие индекса
***Индекс-идентификатор рецепта, за которым в БД закреплен способ приготовления,
название и кол-во компонентов, а так же дополнительная информация.
В случае успешной валидации, рецепт заносится в базу данных с автоматическим проставлением даты оформления
и даты готовности рецепта.(Дата готовности вычисляется в соответсвии с прописанными сроками в БД, которые закрепленны за индексом(см.выше).***
### -Заказ недостающих компонентов и медикаментов со склада;
### -Аналитический блок с диаграммами деятельности фармацевта. 
