package textextraction.finalyear.demo.imageprocessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnRegistration_Click(View v)
    {
       Intent intent=new Intent(MainActivity.this,activity_sign_up_screen.class);
        startActivity(intent);

    }
    public void btnLogin_Click(View v)
    {
        Intent intent=new Intent(MainActivity.this,activity_sign_in_screen.class);
        startActivity(intent);
    }
}
