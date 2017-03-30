package textextraction.finalyear.demo.imageprocessing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_sign_in_screen extends AppCompatActivity {

    private EditText txtEmailLogin;
    private EditText txtEmailPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        txtEmailLogin=(EditText)findViewById(R.id.etUserName);
        txtEmailPassword=(EditText)findViewById(R.id.etPass);
        firebaseAuth=firebaseAuth.getInstance();
    }
public void btnSingIn_Click(View v)
{
final ProgressDialog progressDialog=ProgressDialog.show(activity_sign_in_screen.this,"Please Hook on...","Processing ...",true);
    (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(),txtEmailPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
progressDialog.dismiss();
            if (task.isSuccessful())
            {
                Toast.makeText(activity_sign_in_screen.this,"Login successful",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(activity_sign_in_screen.this,UploadImage.class);
                intent.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                startActivity(intent);
            }
            else {
                Log.e("ERROR",task.getException().toString());
                Toast.makeText(activity_sign_in_screen.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    });
}
}
