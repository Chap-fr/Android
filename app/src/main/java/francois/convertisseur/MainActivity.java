package francois.convertisseur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //attribut de la classe objet de progs
    private Button btEuros, btFrancs, btAC, btApropos, btTaux;
    private EditText txtMontant;
    private float taux;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //correspondance entre les objets graphiques et les objets de progs :
        this.btAC=(Button) findViewById(R.id.idAC);
        this.btEuros=(Button) findViewById(R.id.idEuros);
        this.btFrancs=(Button) findViewById(R.id.idFrancs);
        this.btApropos=(Button) findViewById(R.id.idApropos);
        this.btTaux=(Button) findViewById(R.id.idTaux);
        this.txtMontant=(EditText) findViewById(R.id.idMontant);

        //rendre boutons cliquables :
        this.btAC.setOnClickListener(this);
        this.btEuros.setOnClickListener(this);
        this.btFrancs.setOnClickListener(this);
        this.btApropos.setOnClickListener(this);
        this.btTaux.setOnClickListener(this);

        this.taux=(float) 6.56;
    }

    @Override
    public void onClick(View v) {

        float mt = 0;

        switch (v.getId()){

            case R.id.idAC:

                this.txtMontant.setText("");
                break;

            case R.id.idApropos :
                //affiche message
                String message = "Logiciel realisé le \n 30/01/18";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();

                break;


            case R.id.idFrancs:

                try{
                    mt = Float.parseFloat(this.txtMontant.getText().toString());
                    mt = mt  * this.taux;
                    this.txtMontant.setText(mt +"");


                }catch (NumberFormatException exp){

                    Toast.makeText(this, "erreur ",Toast.LENGTH_LONG).show();
                    this.txtMontant.setText("0");

                }


                break;

            case R.id.idEuros :
                try{
                    mt = Float.parseFloat(this.txtMontant.getText().toString());
                    mt = mt /this.taux;
                    this.txtMontant.setText(mt +"");


                }catch (NumberFormatException exp){

                    Toast.makeText(this, "erreur ",Toast.LENGTH_LONG).show();
                    this.txtMontant.setText("0");

            }
                break;
            case R.id.idTaux :
                Toast.makeText(this, "le taux est de " + this.taux, Toast.LENGTH_LONG).show();



                break;
        }


    }
}
