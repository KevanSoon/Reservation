package sg.edu.rp.c346.id19013989.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText EditName;
    EditText EditMobileNo;
    EditText EditGroupSize;
    DatePicker dp;
    TimePicker tp;
    CheckBox smoking;
    Button reserve;
    Button clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditName = findViewById(R.id.editTextName);
        EditMobileNo = findViewById(R.id.editTextMobileNumber);
        EditGroupSize = findViewById(R.id.editTextGroupSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        smoking = findViewById(R.id.checkBoxSmoking);
        reserve = findViewById(R.id.buttonReserve);
        clear = findViewById(R.id.buttonClearDetails);

        dp.updateDate(2020,5,1);
        tp.setCurrentMinute(30);
        tp.setCurrentHour(19);



        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String information = " ";

                information += "Reservation information: \n\n";
                information += "Name: " + EditName.getText().toString() + " \n";
                information += "Mobile No.: " + EditMobileNo.getText().toString() + " \n";
                information += "Group size: " + EditGroupSize.getText().toString() + " \n";
                information += String.format("Booking Date: %d/%d/%d \n",dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear());
                information += String.format("Booking Time: %d:%d \n",tp.getCurrentHour(),tp.getCurrentMinute());

                if (smoking.isChecked()) {
                    information += "Table Type: Smoking";
                }
                else {
                    information += "Table Type: Non-Smoking";
                }

                Toast.makeText(MainActivity.this, information,Toast.LENGTH_SHORT).show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditName.setText(null);
                EditMobileNo.setText(null);
                EditGroupSize.setText(null);
                dp.updateDate(2020,5,1);
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);
                smoking.setChecked(false);



            }
        });




    }
}
