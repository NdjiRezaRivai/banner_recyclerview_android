package exapmle.com.customrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import exapmle.com.customrecyclerview.R;
import exapmle.com.customrecyclerview.adapter.AdapterList;
import exapmle.com.customrecyclerview.model.ModelList;


public class MainActivity extends AppCompatActivity {

    private TextView username;
    private ImageView imgProfile;
    private RecyclerView list;
    private ImageView imgContent;
    private LinearLayout Container;
    private float realDx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareId();
        setView();
        setListItem(dummy());
        animateContentOnScroll();
    }

    private void setView() {

        username.setText(R.string.my_name);

    }


    private void declareId(){

        // declare id view here
        username    = (TextView)    findViewById(R.id.username);
        imgProfile  = (ImageView)   findViewById(R.id.image_profile);
        list        = (RecyclerView)findViewById(R.id.list);
        imgContent  = (ImageView)   findViewById(R.id.img_background);
        Container   = (LinearLayout)findViewById(R.id.container);

    }

    private void setListItem(List<ModelList> listData){

        // set list item here

        /**
         * set animasi drop down item list recycler ada di adapter
         * uncomment codenya
         */

        AdapterList adapterList         = new AdapterList(this, listData, list);
        LinearLayoutManager viewAdapter = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        list.setAdapter(adapterList);
        list.setLayoutManager(viewAdapter);

    }

    private void animateContentOnScroll(){

        // set animation image on scroll here
        list.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                /**
                 * @param realDx : sum of scroll by user continuously (+/-)
                 * dokumentasi alpha :
                 *
                 * - realDx adalah variable global untuk menyimpan jumlah scroll yang dilakukan user
                 * - pada kondisi if pertama realDx <= 300 artinya scroll dibatasi sejauh 300dp jika lebih animasi alam terhenti
                 *
                 * - pada sintak container.setAlpha(1 - realDx/500):
                 *   1. 500 adalah parameter yang didapatkan dari perhitungan untuk membatasi persentase alpha yang akan di set
                 *   2. disini batas atas scroll 300dp (realDx) maka batas alpha adalah 1 - 300/500 = 0.4 atau 40% alpha maksimal
                 *   3. 300 dan 500 mempengaruhi tingkat alpha dan jarak
                 *   4. rumus perhitungannya adalah alpha = 1 - persentase
                 *   5. persentase didapatkan dari jarakScroll/jarakScrollMaks + penambahan angka agar tidak 1 (jika 1 maka akan hilang atau alpha 0%)
                 */

                realDx  = realDx +  dx;

                if(realDx <= 300 && realDx > 0){

                    Container.setAlpha(1 - realDx/500);

                }



                /**
                 * @param realDx : sum of scroll by user continuously (+/-)
                 * dokumentasi move position :
                 *
                 * - realDx adalah variable global untuk menyimpan jumlah scroll yang dilakukan user
                 * - pada kondisi if pertama realDx <= 300 artinya scroll dibatasi sejauh 300dp jika lebih animasi alam terhenti
                 * - dx dapat bernilai positif atau negatif (posiitif : scroll ke kiri, negatif scroll ke kanan)
                 * - jika dx positif harus dibatasi minimum scroll adalah >= 0 dengan maksimum scroll sejauh 300dp
                 * - jika dx negatif harus dibatasi maksimum scroll adalah < 0 dengan maksimum scroll sejauh 300dp
                 * - jika kedua kondisi tersebut tidak terpenuhi maka animasi tidak akan berjalan kaeran sudah mencapai batas
                 * - disini maksimum scroll adalah 300, namun maksimum perpindahan gambar adalah 300/5 = 60dp, ini bertujuan agar scroll lebih lembut
                 */

                if(dx >= 0 && realDx <= 300){

                    imgContent.setLeft((int) -realDx/5);

                }else if(dx < 0 && realDx <= 300){

                    imgContent.setLeft((int) -realDx/5);

                }


                /**
                 * note :
                 *
                 * - image harus berada pada posisi x = 0, tidak boleh di tambah padding atau margin(xml)
                 * - jika memang harus ingin dirubah posisi x maka parameter di kondisi harus dirubah, misal ada padding 20dp maka 0 diganti dengan 20, 300 duganti menjadi 320 dan 500 diganti dengan 520
                 * - kode ini hanya digunakan untuk layar ukuran 5 inch 320 ppi - 400 ppi (jika ingin disemua ukuran tambahkan res dimens untuk ukuran lainnya)
                 *
                 */


            }
        });

    }


    private List<ModelList> dummy(){

        // dummy item here

        /**
         * data dapat diambil dari sqlite/external storage
         */

        List<ModelList> listDatas   = new ArrayList<>();

        String[] title  = new String[]{"My Computer","My Movies","My Explorer","My Traffic","My Settings","I Love Bugs","Configuration"};
        int[] img       = new int[]{R.drawable.ic_computer,R.drawable.ic_movie,R.drawable.ic_scientists,R.drawable.ic_traffic_lights,R.drawable.ic_settings,R.drawable.ic_bugs,R.drawable.ic_configure};

        for(int i = 0; i < title.length; i++){

            ModelList data = new ModelList();
            data.setId(i);
            data.setImg(img[i]);
            data.setTitle(title[i]);

            listDatas.add(data);
        }

        return listDatas;

    }

}
