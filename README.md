# Описание 
    Система будет состоять из следующих сущностей:
        1 CoffeeDrink – содержит информацию о напитках, которые может приготовить кофе машина (назовем это списком программ);
        2 ResourceContainer – содержит информацию о ресурсах, с которыми будет работать кофе машина (вода, зерна);
        3 CoffeeMaker – содержит информацию о приготовленных напитках.
    Возможный сценарий работы системы «Кофеварка»:
        1 Пользователь выбирает программу (Программа – это фиксированное количество ингредиентов (вода, зерна) для приготовления того или иного напитка. Например, «кофе покрепче»: 100г воды 100г кофе):
        - браузер обращается к серверу, запрашивает возможный список программ для приготовления напитков. Обращение от Browser к CoffeeDrinkController, метод getAll();
        - браузер предоставляет пользователю список напитков, которые кофеварка может приготовить;
        - пользователь выбирает желаемый напиток –> браузер сохраняет программу;
        2 Запускается процесс приготовления кофе:
        - браузер обращается к серверу, проверяет наличие достаточного количества зерен для приготовления напитка (прерывает выполнение программы и выводит сообщение об ошибке, если зерен недостаточно). Обращение от Browser к ResourceContainerController, метод getResource(ResourceContainer grain);
        - браузер обращается к серверу, проверяет наличие достаточного количества воды для приготовления напитка (прерывает выполнение программы и выводит сообщение об ошибке, если воды недостаточно). Обращение от Browser к ResourceContainerController, метод getResource(ResourceContainer water);
        - браузер обращается к серверу, запускает процесс приготовления кофе. Обращение от Browser к CoffeeMakerController, метод create(CoffeeMaker coffeeMaker);
        - браузер отдает напиток пользователю.
![Image alt](https://github.com/PrihEkat/demo/blob/master/img/diagram.png)
