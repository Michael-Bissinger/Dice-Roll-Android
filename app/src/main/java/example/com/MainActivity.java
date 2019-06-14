package example.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView rollResult;
    Button rollButton;


    int score;
    Random rand;
    int die1; // Field to hold the die value
    int die2;
    int die3;

    ArrayList<Integer> dices; // Array list for all dices


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set initial score
        score = 0;

        rollResult = (TextView) findViewById(R.id.rollResult);
        rollButton = (Button) findViewById(R.id.rollButton);

        Toast.makeText(getApplicationContext(), "Application starting!", Toast.LENGTH_SHORT).show();

        rand = new Random();

        dices = new ArrayList<Integer>();

    }

    public void rollDice(View v) {
        rollResult.setText("Clicked!");

//        Old random gen:
//        int num = rand.nextInt(6)+1;
//        String randomValue = "number generated: " + num;
//        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_SHORT).show();

        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        dices.clear();  // If there are other variables from former rolls
        dices.add(die1);
        dices.add(die2);
        dices.add(die3);

        String msg = "You rolled a " + die1 + ", a " + die2 + " and a " + die3;

        rollResult.setText(msg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
