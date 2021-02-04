![](https://github.com/id-05/MagnetMonitorRemoteViewerServer/blob/master/images/preview.jpg)


# Magnet Monitor Remote Viewer

### Description

- Program for remote viewing of GE Magnet Monitor 3 parameters;
- Cross-platform console application;
- Uses HtmlUnitDriver and emulates the operator's work with the Web interface;
- Hiding in a trey;
- Allows you to view errors on your device;
- Provides its own Web interface for remote monitoring;
- For operational remote information, there is a built-in telegram-bot,
  but you will have to create a bot and a chat where it will send information yourself,
  using BotFather, for example, according to this instruction:[instructions for creating a bot](https://www.process.st/telegram-bot/)



### How to use

- The computer must have a Java interpreter installed, you can download from here: https://www.java.com/ru/download/
- It is enough to start the Web interface on the device once (press the buttons on the device console: Service mode - Service mode - Yes);
- You must know its address on your LAN in the device settings (Data button);
- Start the Magnet Monitor Remote Viewer;
- Make sure that the computer on which you run the program is on the same LAN as your device;
- Add your device using the Add Equipment form;
- Configure the hardware polling interval on the Settings tab, default is 15 minutes;
- Select the port for the program web interface, default 8765;
- To access the Web interface, in the address bar of the browser, type: http ://localhost: 8765 - where localhost - the address of the machine on which the program is running;


### Caution

- To access the GE Magnet Monitor 3 Web interface, this program sends the administrator login and password in open form, make sure that the configuration of your local network prevents this data from reaching third parties;
- Antivirus and Windows Defender can block the network functions of the program, it is recommended to run the program with administrative rights;

# [Скачать Magnet Monitor Remote Viewer](https://github.com/id-05/MagnetMonitorRemoteViewerServer/raw/master/out/artifacts/MagMon_jar/MagMon.jar)


# Magnet Monitor Remote Viewer

### Описание

- Программа для удаленного просмотра параметров GE Magnet Monitor 3;
- Кросплатформенное консольное приложение;
- Использует HtmlUnitDriver и эмулирует работу оператора с Web-интерфейсом;
- Прячется в трей;
- Позволяет просматривать ошибки на устройстве;
- Предоставляет собственный Web-интерфейс для удаленного контроля;
- Для оперативного удаленного информирования, предусмотрен встроенный telegram-bot,
  однако создать бота и чат, куда он будет отправлять информацию, вам придется самостоятельно,
  с помощью BotFather, например вот по этой инструкции:[инструкция по созданию бота](https://1spla.ru/blog/telegram_bot_for_mikrotik/)

### Как пользоваться
- На компьютере должен быть установлен Java-интерпретатор, можно скачать отсюда: https://www.java.com/ru/download/ 
- Достаточно один раз запустить Web-интерфейс на устройстве (нажать на консоли прибора кнопки: Service mode - Service mode - Yes);
- Необходимо в параметрах устройствах (кнопка Data) узнать его адрес в вашей локальной сети;
- Запустить Magnet Monitor Remote Viewer;
- Убедиться что компьютер, на котором вы запустили программу, находится в одной локальной сети с вашим устройством;
- Добавить ваше устройство с помощью формы добавления оборудования;
- Настроить интервал опроса оборудования на вкладке Settings, по умолчанию 15 минут;
- Выбрать порт для Web-интерфейса программы, по умолчанию 8765;
- Для доступа в Web-интерфейс, в адресной строке браузера набрать: http://localhost:8765 - где localhost - адрес машины на которой запущена программа; 

### Предостережение

- Для доступа к Web-интерфейсу GE Magnet Monitor 3, данная программа передает логин и пароль администратора в открытом виде, убедитесь что конфигурация вашей локальной сети, исключает возможность попадания этих данных к третьим лицам;  
- Антивирусы и защитник Windows могут блокировать сетевые функции программы, рекомендуется запускать программу с правами администратора;


# [Скачать Magnet Monitor Remote Viewer](https://github.com/id-05/MagnetMonitorRemoteViewerServer/raw/master/out/artifacts/MagMon_jar/MagMon.jar)