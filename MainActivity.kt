import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tasksAdapter: ArrayAdapter<String>
    private lateinit var listView: ListView
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listView)
        val addButton = findViewById<Button>(R.id.addButton)
        val inputField = findViewById<EditText>(R.id.inputField)

        dbHelper = DatabaseHelper(this)
        loadTasks()

        addButton.setOnClickListener {
            val taskName = inputField.text.toString()
            dbHelper.addTask(taskName)
            loadTasks()
            inputField.text.clear()
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val cursor = (listView.adapter as CursorAdapter).cursor
            cursor.moveToPosition(position)
            val taskId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"))
            dbHelper.updateTaskStatus(taskId, 1)  // Mark as completed
            loadTasks()
        }
    }

    private fun loadTasks() {
        val cursor = dbHelper.getAllTasks()
        val from = arrayOf("task_name")
        val to = intArrayOf(android.R.id.text1)
        val cursorAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to, 0)
        listView.adapter = cursorAdapter
    }
}
