package eu.project.rapid.demo;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class board extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Intent br =getIntent() ;
        Bundle b =br.getExtras() ;
        String res=b.getString("result");
        EditText txt = (EditText) findViewById(R.id.editText) ;
        txt.setText(res, TextView.BufferType.EDITABLE);
    }
}
