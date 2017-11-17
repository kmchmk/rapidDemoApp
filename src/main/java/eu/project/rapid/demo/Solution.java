package eu.project.rapid.demo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Solution extends Activity {
    TableLayout table;
    Context context = this;
    TextView index;
    ArrayList<byte[][]> result_board;
    int N;
    long time;
    int currentSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        index = (TextView) findViewById(R.id.index);
        table = (TableLayout) findViewById(R.id.view_root);
        result_board = (ArrayList<byte[][]>) getIntent().getExtras().getSerializable("solution");
        N = getIntent().getIntExtra("N", 2);
        time = getIntent().getLongExtra("time",0);
        currentSolution = 0;
        populate_with_current_solution();
        TextView timeText = (TextView)findViewById(R.id.time);
        timeText.setText(Long.toString(time)+"ms");
    }


    void populate_with_current_solution() {
        table.removeAllViews();
        for (int y = 0; y < N; y++) {
            final int row = y;
            TableRow r = new TableRow(this);
            table.addView(r);
            for (int x = 0; x < N; x++) {
                final int col = x;
                final ImageButton b = new ImageButton(this);
                b.setEnabled(true);
//                byte[][] temp = (byte[][])result_board.get(currentSolution);
//                if (temp[row][col] == 1) {
////                    b.setBackgroundColor(Color.RED);
//                    b.setImageResource(R.drawable.queen);
//                }
//                else{
//                    b.setImageResource(R.drawable.blank);
//                }
                r.addView(b);
            }
        }
        index.setText(Integer.toString(currentSolution + 1) + "/" + Integer.toString(result_board.size()));
    }

    public void decrease(View v) {
        if (currentSolution != 0) {
            currentSolution -= 1;
            populate_with_current_solution();
        }
    }

    public void increase(View v) {
        if (currentSolution != (result_board.size() - 1)) {
            currentSolution += 1;
            populate_with_current_solution();
        }
    }

}
