### Пример абстрагирования:
Возьмем класс Авторизация, который предназначался для флоу авторизации. Изначально авторизация была возможна только одним способом.
Но по мере развития проекта появлялись как новые способы авторизации, так и любимые менеджерами эксперименты, в итоге наш класс разрастается большим количеством условных конструкций и в целом становится объемным.
Применим абстрагирование и выделим в отдельные классы конкретные способы авторизации. Например, классы для:
- Авторизация через стороннего провайдера; 
- авторизация нативная; 
- авторизация через партнерское приложение.

### Пример факторизации

Возьмем такую сущность как UI Маппер, назначение которого, условно говоря, сформировать готовый к показу на UI тип данных на основе данных, пришедших с сервера, чтобы новый тип был готов сразу же отобразиться пользователю без дополнительных форматирований и преобразований.
Таких Мапперов в системе может быть множество и изначально они не рассматривались, как связанные между собой, ведь для каждого типа свой Маппер.
Но если подняться на более высокий уровень абстракции, то можно обнаружить, что все эти разные типы мапперов служат одной цели: получить из объекта одного типа объект другого типа. 
Тогда мы добавляем общий для всех мапперов класс (вероятнее, интерфейс) и используем параметризовынный тип для указания входного. По итогу все конкретные классы мапперов имеют общего родителя. 