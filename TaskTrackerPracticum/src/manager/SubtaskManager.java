package manager;

import task.Epic;
import task.Subtask;

import java.util.HashMap;

public class SubtaskManager extends EpicManager {
    // Получение всех задач

    public static HashMap<Long, Subtask> getListOfTasks(Epic epic) {
        return epic.getSubtasks();
    }

    // Удаление всех задач
    public static void clearTasks(Epic epic){
        epic.getSubtasks().clear();
    }

    // Получение задачи по id
    public static Subtask getById(long id, Epic epic){
        return epic.getSubtasks().get(id);
    }

    //Создание задачи
    public static void add(Subtask subtask, Epic epic) {
        epic.getSubtasks().put(subtask.getId(), subtask);
        EpicManager.addSubtaskInEpic(subtask, epic);
        EpicManager.checkStatus(epic);
    }

    // Обновление задачи по id
    public static void update(Subtask subtask, Epic epic) {
        add(subtask, epic);
    }

    // Удаление задачи по id
    public static void removeById(long id, Epic epic) {
        epic.getSubtasks().remove(id);
        EpicManager.checkStatus(epic);
    }
}
