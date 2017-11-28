package com.fesac.carlos.a011_boletin2ej1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * https://android--code.blogspot.com.es/2015/08/android-alertdialog-multichoice.html
 *
 */
public class MainActivity extends AppCompatActivity {

    private EditText edtNumero;
    private Button btnPotencia, btnBorrar, btnRellenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero = findViewById(R.id.edtNumero);
        btnPotencia = findViewById(R.id.butPotencia);
        btnBorrar = findViewById(R.id.butBorrar);
        btnRellenar = findViewById(R.id.butRellenar);

        btnPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto = edtNumero.getText().toString();

                if (Objects.equals(texto, "")){

                    Toast.makeText(MainActivity.this, "Campo vacio", Toast.LENGTH_SHORT).show();

                }else {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Potencia");
                    dialog.setMessage("Se va a calcular 2 elevado a " + texto);
                    dialog.setPositiveButton("Calcular", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    edtNumero.setText("" + Math.pow(2, Integer.parseInt(edtNumero.getText().toString())));
                                    dialog.cancel();
                                }
                            });
                    dialog.show();

                }

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Borrar");
                dialog.setMessage("Se va a borrar el número actual");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edtNumero.setText("");
                        dialog.cancel();
                    }
                });

                dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();

            }
        });

        btnRellenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Rellenar");

                final ArrayAdapter<String> opciones = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice);
                opciones.add("8");
                opciones.add("16");
                opciones.add("32");

                dialog.setAdapter(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {

                        final String numero = opciones.getItem(which);
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage(numero);
                        builder.setTitle("Has seleccionado: ");
                        builder.setPositiveButton("Rellenar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                edtNumero.setText(numero);

                                dialog.dismiss();

                            }
                        });

                        builder.show();

                    }
                });

                dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });

    }
}
