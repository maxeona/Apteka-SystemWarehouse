# Apteka-SystemWarehouse
## Данная программа построена по принципу трёхуровневой архитектуры на стеке:
### Vaadin (frontend layer)/Java Spring Framework (backend layer)/ PostgreSQL (СУБД)(database layer). 

  Главная цель  проекта, автоматизация под единым интерфейсом рабочих процессов фармацевтической компании. 
Задачи решенные при помощи данной программы  направлены  на сокращение  временных затрат, а так же на повышение товарооборота и производительности фирмы.
## Под рабочими процессами подразумевается:
### -Поиск, продажа, учет и заказ(в случае отсутствия) медикаментов;
### -Оформление рецепта с последующей валидацией на соответсвие индекса
  Индекс-идентификатор рецепта, за которым в БД закреплен способ приготовления,название и кол-во компонентов, а так же дополнительная информация.

В случае успешной валидации, рецепт заносится в базу данных с автоматическим проставлением даты оформленияи даты готовности рецепта.
(Дата готовности вычисляется в соответствии с прописанными сроками в БД, которые закрепленны за индексом(см.выше).

### -Заказ недостающих компонентов и медикаментов со склада;
### -Аналитический блок с диаграммами деятельности фармацевта. 

  Также в программе реализован и настроен под требования фреймворка Vaadin  Spring Security.

Внедрение данной технологии позволяет взаимодействовать и проводить мониторинг процессов и системы, посредством личного кабинета. 

## Технические характеристики
***Для входа в систему:***

-login: user

-password:12345

***Версия Java:***

-Не ниже Java 8 (Имеются лямбда-выражения)

***Допонительные требования***

-Для успешного запуска, должен быть установлен плагин Vaadin версия не ниже 8.






