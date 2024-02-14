package ws.wolfsoft.e_books;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jackandphantom.blurimage.BlurImage;

public class BookDetailActivity extends AppCompatActivity {


    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        image = findViewById(R.id.image);


        Bitmap bitmap = BlurImage.with(getApplicationContext()).load(R.drawable.the_dreaming).intensity(15).getImageBlur();

        image.setImageBitmap(bitmap);


        //BlurImage.with(getApplicationContext()).load(R.drawable.the_dreaming).intensity(5).Async(false).into(image);
    }
}
