package customtoolbar.reza.com.customtoolbarimageandtext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView title;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareId();
        setView();
    }

    private void declareId(){

        title   = (TextView) findViewById(R.id.titleBar);
        icon    = (ImageView)findViewById(R.id.iconBar);

    }

    private void setView(){

        title.setText(R.string.customToolbar);
        icon.setBackgroundResource(R.drawable.ic_title);

    }

}
