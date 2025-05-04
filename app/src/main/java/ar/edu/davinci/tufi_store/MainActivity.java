package ar.edu.davinci.tufi_store;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Referencias a los elementos de la Card 1 + import clases
    TextView figurita1TitleTextView;
    ImageView figurita1ImageView;
    TextView figurita1NameTextView;
    Button figurita1ComprarButton;


    // Referencias a los elementos de la Card 2
    TextView figurita2TitleTextView;
    ImageView figurita2ImageView;
    TextView figurita2NameTextView;
    Button figurita2ComprarButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_tufi), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // Obtener referencias a los elementos de la Card 1 (figurita1)
        figurita1TitleTextView = findViewById(R.id.figurita1_title);
        figurita1ImageView = findViewById(R.id.figurita1_image);
        figurita1NameTextView = findViewById(R.id.figurita1_name);
        figurita1ComprarButton = findViewById(R.id.figurita1_comprar);

        // Configurar listeners para los botones de la Card 1 (figurita1) + import VIEW class & Toast class
        figurita1ComprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Comprar Figurita 1", Toast.LENGTH_SHORT).show();

            }
        });


        // Obtener referencias a los elementos de la Card 2 (figurita2)
        figurita2TitleTextView = findViewById(R.id.figurita2_title);
        figurita2ImageView = findViewById(R.id.figurita2_image);
        figurita2NameTextView = findViewById(R.id.figurita2_name);
        figurita2ComprarButton = findViewById(R.id.figurita2_comprar);

        // Configurar listeners para los botones de la Card 2 (figurita2)
        figurita2ComprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Comprar Figurita 2", Toast.LENGTH_SHORT).show();

            }
        });


        // --- Código para agregar dinámicamente un elemento: el título "Últimos agregados" ---

        // 1. Obtener una referencia al LinearLayout principal dentro del ScrollView
                LinearLayout linearLayoutPrincipal = (LinearLayout) findViewById(R.id.card_quienes).getParent();

        // 2. Obtener una referencia a la CardView "Quiénes somos?" para insertar después
                androidx.cardview.widget.CardView cardQuienes = findViewById(R.id.card_quienes);

        // 3. Crear el Elemento: TextView para el título
                TextView tituloUltimosAgregados = new TextView(this);
                LinearLayout.LayoutParams tituloLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                tituloLayoutParams.gravity = android.view.Gravity.CENTER_HORIZONTAL;
                tituloLayoutParams.setMargins(0, 80, 0, 32); // Margen superior e inferior
                tituloUltimosAgregados.setLayoutParams(tituloLayoutParams);
                tituloUltimosAgregados.setText("Últimos agregados");
                tituloUltimosAgregados.setTextSize(23);
                tituloUltimosAgregados.setTypeface(null, android.graphics.Typeface.BOLD);
                tituloUltimosAgregados.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                tituloUltimosAgregados.setBackgroundColor(ContextCompat.getColor(this, R.color.holo_blue_light));
                tituloUltimosAgregados.setPadding(16, 8, 16, 8); // Padding para el texto dentro del fondo

        // 4. Obtener el índice de la CardView "Quiénes somos?"
                int indexCardQuienes = linearLayoutPrincipal.indexOfChild(cardQuienes);

        // 5. Insertar el TextView justo después de la CardView "Quiénes somos?"
                linearLayoutPrincipal.addView(tituloUltimosAgregados, indexCardQuienes + 1);


    }
}