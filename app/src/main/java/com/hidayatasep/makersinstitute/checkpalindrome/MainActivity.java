package com.hidayatasep.makersinstitute.checkpalindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button disemwovelerButton;
    Button palindromeButton;
    Button reverseStringButton;
    Button resetButton;
    EditText inputEditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign view
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        disemwovelerButton = (Button) findViewById(R.id.disemwolverButton);
        palindromeButton = (Button) findViewById(R.id.palindromeButton);
        reverseStringButton = (Button) findViewById(R.id.reverseStringButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        disemwovelerButton.setOnClickListener(this);
        palindromeButton.setOnClickListener(this);
        reverseStringButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(inputEditText.getText().toString().trim().isEmpty()){
            Toast.makeText(MainActivity.this,"Please input your text",Toast.LENGTH_SHORT).show();
        }else{
            int id = view.getId();
            String input = inputEditText.getText().toString().trim();
            switch (id){
                case R.id.palindromeButton : {
                    checkPalindrome(input);
                    break;
                }
                case  R.id.disemwolverButton : {
                    disemwolver(input);
                    break;
                }
                case  R.id.reverseStringButton : {
                    reverseString(input);
                    break;
                }
                case R.id.resetButton : {
                    inputEditText.setText("");
                    resultTextView.setText("Result :");
                    break;
                }
                default: {

                    break;
                }
            }
        }
    }


    public void reverseString(String input){
        StringBuilder stringBuilder = new StringBuilder();

        //reveser string
        for(int i=(input.length()-1) ; i>=0 ; i--){
            stringBuilder.append(input.charAt(i));
        }

        resultTextView.setText("Result : " + stringBuilder.toString());
    }

    public void checkPalindrome(String input){
        boolean status = true;
        int i = 0;
        int j = input.length() - 1;

        //loop when still palndrome or i < half legnth input
        while (status && i < input.length() / 2 ){
            if(input.charAt(i) != input.charAt(j)){
                status = false;
            }else{
                i += 1;
                j -= 1;
            }
        }

        if(status){
            resultTextView.setText("Result : Your input is palindrome");
        }else{
            resultTextView.setText("Result : Your input is not palindrome" );
        }
    }

    public void disemwolver(String input){
        StringBuilder konsonanStringBuilder = new StringBuilder();
        StringBuilder vocalStringBuilder = new StringBuilder();
        String tempInput = input.toLowerCase();

        for(int i=0; i<input.length(); i++){
            if(tempInput.charAt(i) != ' '){
                if(tempInput.charAt(i) == 'a' || tempInput.charAt(i) == 'i' || tempInput.charAt(i) == 'u' || tempInput.charAt(i) == 'e' || tempInput.charAt(i) == 'o'){
                    vocalStringBuilder.append(input.charAt(i));
                }else{
                    konsonanStringBuilder.append(input.charAt(i));
                }
            }
        }

        resultTextView.setText("Result : " + konsonanStringBuilder.toString() + " " + vocalStringBuilder.toString());
    }

}
