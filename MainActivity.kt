import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.photoGalleryRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3 columns grid
        
        // 'image1', 'image2', 'image3', ... in a folder
        val imageResourceIds = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3
            
        )
        
        recyclerView.adapter = PhotoAdapter(imageResourceIds)
    }
}
