import manager.EpicManager;
import manager.SubtaskManager;
import status.TaskStatus;
import task.Epic;
import task.Subtask;

import java.util.HashMap;

// Класс для тестов приложения
public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Epic epic_1 = new Epic("Уборка", "Надо убраться");
        Epic epic_2 = new Epic("Покупки", "Сходить за едой в магазин");
        Epic epic_3 = new Epic("Учёба", "Надо сесть поучиться");

        EpicManager.addEpic(epic_1);
        EpicManager.addEpic(epic_2);
        EpicManager.addEpic(epic_3);

        EpicManager.getById(epic_1.getId());
        map = EpicManager.getListOfTasks();
        Epic epic_4 = EpicManager.getById(epic_1.getId());
        epic_4.setStatus(TaskStatus.DONE);
        EpicManager.update(epic_4);
        EpicManager.removeById(epic_2.getId());
        map = EpicManager.getListOfTasks();
        EpicManager.clearTasks();
        map = EpicManager.getListOfTasks();

        EpicManager.addEpic(epic_1);
        EpicManager.addEpic(epic_2);
        EpicManager.addEpic(epic_3);
        Subtask subtask_1 = new Subtask("Стол", "Убрать стол");
        Subtask subtask_2 = new Subtask("Кухня", "Убрать кухню");
        Subtask subtask_3 = new Subtask("Полы", "Помыть полы");
        Subtask subtask_4 = new Subtask("Молоко", "Взять литр молока");
        Subtask subtask_5 = new Subtask("Яйца", "Взять 2 десятка яиц");
        Subtask subtask_6 = new Subtask("Теория", "Выучить теорию");

        SubtaskManager.add(subtask_1, epic_1);
        SubtaskManager.add(subtask_2, epic_1);
        SubtaskManager.add(subtask_3, epic_1);
        SubtaskManager.add(subtask_4, epic_2);
        SubtaskManager.add(subtask_5, epic_2);
        SubtaskManager.add(subtask_6, epic_3);

        SubtaskManager.getListOfTasks(epic_1);
        Subtask subtask_7 = SubtaskManager.getById(subtask_1.getId(), epic_1);
        subtask_7.setStatus(TaskStatus.DONE);
        SubtaskManager.update(subtask_7, epic_1);
        subtask_7 = SubtaskManager.getById(subtask_2.getId(), epic_1);
        subtask_7.setStatus(TaskStatus.DONE);
        SubtaskManager.update(subtask_7, epic_1);
        map = EpicManager.getListOfTasks();
        subtask_7 = SubtaskManager.getById(subtask_3.getId(), epic_1);
        subtask_7.setStatus(TaskStatus.DONE);
        SubtaskManager.update(subtask_7, epic_1);
        map = EpicManager.getListOfTasks();
    }
}