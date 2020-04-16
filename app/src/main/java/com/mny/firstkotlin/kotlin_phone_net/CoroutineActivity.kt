
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class CoroutineActivity: AppCompatActivity(), CoroutineScope {

  override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job

  lateinit var job: Job

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    job = Job()
  }

  override fun onDestroy() {
    job.cancel()
    super.onDestroy()
  }
  open fun startActivity(context: Context, activity: Class<Any>) {
    var intent = Intent(context, activity)
    startActivity(intent)
  }
}