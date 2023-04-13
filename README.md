# Notebook.hw || Консольное приложение: "Записная книжка"

## О проекте:
* Система сборки: Gradle 
* Архитектурный паттерн: "Model-View-Controller" (Модель; Представление; Контроллер)
* Паттерны проектирования: Facade; DAO
* Использованные библиотеки: Lombok, Log4j;
### Структура приложения *содежания в src/main*
> Model
1. Memo
> View
2. Класс MemoConsoleView (вид для консоли)
> Controller
3. Класс MemoController (где switch-case реагирующий на выбор пользователя в MemoConsoleView и вызывающий методы CRUD и получение всех записок из MemoService) 
> DAO
4. Интерфейс MemoRepository и класс RepositoryOperation имлементирующий MemoRepository
5. Интерфейс Operations ( c абстрактными List<T> readAll(); void saveAll(List<T> data);) и класс FileOperation имлементирующий Operations;
> Facade
6. класс MemoService содержащий методы CRUD и получение всех записок, которые реализованны в RepositoryOperation имлементирующем MemoRepository
> util
7. класс DbCreator создающий файл txt где хранятся записки
