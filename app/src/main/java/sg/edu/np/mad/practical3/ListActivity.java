package sg.edu.np.mad.practical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    Integer Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView imageView=findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryOTP();

            }
        });

    }
    private void queryOTP(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                Number=generatedOTP();
                myIntent.putExtra("myNumber", Number);
                startActivity(myIntent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onRestart();
            }
        });
        AlertDialog alert= builder.create();
        alert.show();
    }
    private int generatedOTP(){
        Random ran =new Random();
        int myNumber = ran.nextInt(999999999);
        return myNumber;
    }

}