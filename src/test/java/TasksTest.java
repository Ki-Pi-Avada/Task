import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        assertTrue(simpleTask.matches("Позвонить"));
        assertFalse(simpleTask.matches("Написать"));
    }
    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55,subtasks);
        assertTrue(epic.matches("Яйца"));
        assertFalse(epic.matches("Мясо"));
    }
    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник поле обеда");
        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанка"));
        assertFalse(meeting.matches("Собеседование"));
    }
    @Test
    void shouldReturnSubtasks() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        String[] expected = { "Молоко", "Яйца", "Хлеб" };
        assertArrayEquals(expected, epic.getSubtasks());
    }
    @Test
    void shouldReturnTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        assertEquals("Позвонить родителям", simpleTask.getTitle());
    }
    @Test
    void shouldReturnTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }

    @Test
    void shouldReturnProject() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        assertEquals("Приложение НетоБанка", meeting.getProject());
    }

    @Test
    void shouldReturnStart() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        assertEquals("Во вторник после обеда", meeting.getStart());
    }
    @Test
    void shouldReturnId() {
        Task task = new Task(5);
        assertEquals(5, task.getId());
    }
    @Test
    void shouldBeEqualIfIdsAreEqual() {
        Task task1 = new Task(5);
        Task task2 = new Task(5);
        assertTrue(task1.equals(task2));
    }

    @Test
    void shouldNotBeEqualIfIdsAreDifferent() {
        Task task1 = new Task(5);
        Task task2 = new Task(10);
        assertFalse(task1.equals(task2));
    }

    @Test
    void shouldNotBeEqualIfObjectIsNull() {
        Task task = new Task(5);
        assertFalse(task.equals(null));
    }

    @Test
    void shouldNotBeEqualIfObjectIsOfDifferentClass() {
        Task task = new Task(5);
        String otherObject = "Not a Task";
        assertFalse(task.equals(otherObject));
    }
    @Test
    void shouldHaveSameHashCodeIfIdsAreEqual() {
        Task task1 = new Task(5);
        Task task2 = new Task(5);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void shouldHaveDifferentHashCodeIfIdsAreDifferent() {
        Task task1 = new Task(5);
        Task task2 = new Task(10);
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }
    @Test
    void shouldNotMatchAnyQuery() {
        Task task = new Task(5);
        assertFalse(task.matches("query"));
    }
    @Test
    void shouldBeEqualIfSameObject() {
        Task task = new Task(5);
        assertTrue(task.equals(task));
    }
}
