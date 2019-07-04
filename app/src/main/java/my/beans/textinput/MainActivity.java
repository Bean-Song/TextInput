package my.beans.textinput;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText passWord;
    private EditText editUserName;
    private EditText editPassWord;
    private TextInputLayout tlUserName;
    private TextInputLayout tlPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.user_name);
        passWord = findViewById(R.id.pass_word);
        editUserName = findViewById(R.id.et_user_name);
        editPassWord = findViewById(R.id.et_pass_word);
        tlUserName = findViewById(R.id.tl_user_name);
        tlPassWord = findViewById(R.id.tl_pass_word);


        findViewById(R.id.button).setOnClickListener((v) -> {
            String info = userName.getText() + "--" +
                    passWord.getText() + " -> " +
                    editUserName.getText() +"--" +
                    editPassWord.getText();
            Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
            login();
        });
    }

    private void login() {
        if (!validateUsername(editUserName.getText().toString())) {
            tlUserName.setErrorEnabled(true);
            tlUserName.setError("Email please !");
        } else if (!validatePassword(editPassWord.getText().toString())) {
            tlPassWord.setErrorEnabled(true);
            tlPassWord.setError("more please !");
        } else {
            tlUserName.setErrorEnabled(false);
            tlPassWord.setErrorEnabled(false);
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePassword(String string) {
        return string.length() >= 6;
    }
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private boolean validateUsername(String string) {
        return pattern.matcher(string).matches();
    }
}
