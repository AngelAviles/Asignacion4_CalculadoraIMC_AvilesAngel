package aviles.angel.asignacion4_calculadoraimc_avilesangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * Asignación 4 - CalculadoraIMC
 * Nombre: Angel Armando Aviles Martinez
 * ID: 00000132986
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables con los elementos de la UI
        val weight : EditText = findViewById(R.id.weight) as EditText
        val height : EditText = findViewById(R.id.height) as EditText
        val btnCalcular : Button = findViewById(R.id.btnCalcular)
        val imc : TextView = findViewById(R.id.imc)
        val range : TextView = findViewById(R.id.range)

        // Evento Listener del boton Calcular
        btnCalcular.setOnClickListener {

            // Si los campos no estan vacio y son numeros
            if (esNumero(weight.text.toString()) && esNumero(height.text.toString()) && !weight.text.toString().isNullOrBlank() && !height.text.toString().isNullOrBlank()) {

                // Obtiene el peso y la estatura cuadrada en Float
                var peso = weight.text.toString().toFloat()
                var estaturaCuadrado = height.text.toString().toFloat() * height.text.toString().toFloat()

                // Calcula el IMC
                var imcCalculo = peso / estaturaCuadrado

                // Muestra el IMC
                imc.text = imcCalculo.toString()

                // Muestra los rango y el color dependiendo del IMC
                if (imcCalculo < 18.5) {
                    range.text = "Bajo peso"
                    range.setBackgroundResource(R.color.colorGreenish)
                } else if (imcCalculo < 24.9) {
                    range.text = "Normal"
                    range.setBackgroundResource(R.color.colorGreen)
                } else if (imcCalculo < 29.9) {
                    range.text = "Sobrepeso"
                    range.setBackgroundResource(R.color.colorYellow)
                } else if (imcCalculo < 34.5) {
                    range.text = "Obesidad grado 1"
                    range.setBackgroundResource(R.color.colorOrange)
                } else if (imcCalculo < 39.9) {
                    range.text = "Obesidad grado 2"
                    range.setBackgroundResource(R.color.colorRed)
                } else if (imcCalculo >= 40) {
                    range.text = "Obesidad grado 3"
                    range.setBackgroundResource(R.color.colorBrown)
                }

                // Si no es numero o esta vacia los campos
            } else {
                // Se muestra el siguiente mensaje
                Toast.makeText(this, "INGRESA SOLO NUMEROS EN AMBOS CAMPOS", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Funcion que determina si un String es un numero Float
    fun esNumero(numero: String): Boolean {
        try {
            numero.toFloat()
            return true
        } catch (excepcion: NumberFormatException) {
            return false
        }
    }
}