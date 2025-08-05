package manager;// Сервис для работы с Задачами

import status.TaskStatus;
import task.Epic;
import task.Subtask;

import java.util.HashMap;

/*
1) Возможность хранить задачи всех типов. Для этого вам нужно выбрать подходящую коллекцию.
2) Методы для каждого из типов задач (Задача/Эпик/Подзадача):
     a. Получение списка всех задач.
     b. Удаление всех задач.
     c. Получение по идентификатору.
     d. Создание. Сам объект должен передаваться в качестве параметра.
     e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
     f. Удаление по идентификатору.
3) Дополнительные методы:
    a. Получение списка всех подзадач определённого эпика.
4) Управление статусами осуществляется по следующему правилу:
     a. Менеджер сам не выбирает статус для задачи.
        Информация о нём приходит менеджеру вместе с информацией о самой задаче.
        По этим данным в одних случаях он будет сохранять статус, в других будет рассчитывать.
     b. Для эпиков:
        если у эпика нет подзадач или все они имеют статус NEW, то статус должен быть NEW.
        если все подзадачи имеют статус DONE, то и эпик считается завершённым — со статусом DONE.
        во всех остальных случаях статус должен быть IN_PROGRESS.
 */
public class EpicManager {
    // Структура данных для хранения Задач
    private static HashMap<Long, Epic> epics = new HashMap<>();

    // Получение всех задач
    public static HashMap<Long, Epic> getListOfTasks(){
        return epics;
    }

    // Удаление всех задач
    public static void clearTasks(){
        epics.clear();
    }

    // Получение задачи по id
    public static Epic getById(long id){
        return epics.get(id);
    }

    //Создание задачи
    public static void addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    // Обновление задачи
    public static void update(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    // Удаление задачи по id
    public static void removeById(long id) {
        epics.remove(id);
    }

    // Получение подзадач эпика
    public static HashMap<Long, Subtask> getSubtasks(Epic epic) {
        return epic.getSubtasks();
    }

    // Добавление подзадачи в эпик
    protected static void addSubtaskInEpic(Subtask subtask, Epic epic) {
        epic.getSubtasks().put(subtask.getId(), subtask);
    }

    // Проверка на статус подзадач и изменение статуса эпика
    public static void checkStatus(Epic epic) {
        HashMap<Long, Subtask> subtasks = epic.getSubtasks();
        int countSubtasks = subtasks.size();
        int countNew = 0;
        int countDone = 0;
        int countInProgress = 0;

        for (Subtask subtask : subtasks.values()) {
            switch (subtask.getStatus()){
                case NEW:
                    countNew++;
                    break;
                case DONE:
                    countDone++;
                    break;
                case IN_PROGRESS:
                    countInProgress++;
                    break;
            }
        }

        if(countNew == countSubtasks){
            epic.setStatus(TaskStatus.NEW);
        } else if(countDone == countSubtasks){
            epic.setStatus(TaskStatus.DONE);
        } else {
            epic.setStatus(TaskStatus.IN_PROGRESS);
        }
    }



}
