package task;

import status.TaskStatus;

import java.util.HashMap;

// Класс отвечающий за реализацию объекта "Задача"
/*
1) Название, кратко описывающее суть задачи (например, «Переезд»).
2) Описание, в котором раскрываются детали.
3) Уникальный идентификационный номер задачи, по которому её можно будет найти.
4) Статус, отображающий её прогресс. Вы будете выделять следующие этапы жизни задачи, используя enum:
    1. NEW — задача только создана, но к её выполнению ещё не приступили.
    2. IN_PROGRESS — над задачей ведётся работа.
    3. DONE — задача выполнена.
*/
public class Epic {
    private static long counter;
    protected final long id;
    protected String name;
    protected String description;
    protected TaskStatus status;
    private HashMap<Long, Subtask> subtasks;

    public Epic(String name, String description){
        id = counter++;
        this.name = name;
        this.description = description;
        status = TaskStatus.NEW;
        subtasks = new HashMap<Long, Subtask>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public HashMap<Long, Subtask> getSubtasks() {
        return subtasks;
    }

}
