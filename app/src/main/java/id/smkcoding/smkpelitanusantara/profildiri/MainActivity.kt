package id.smkcoding.smkpelitanusantara.profildiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener {
            validasiInput()
        }
        setDataSpinnerGender()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter
    }

    private fun validasiInput() {
        val genderInput = spinnerGender.selectedItem.toString()
        when{
            edtName.text.toString().isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih kelamin") -> tampilToast("Kelamin harus dipilih")
            edtEmail.text.toString().isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            edtTelp.text.toString().isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            edtAddress.text.toString().isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"
            else -> {
                tampilToast("Navigasi ke halaman profil diri")
                navigasiKeProfilDiri()
            }

        }
    }

    private fun tampilToast(pesan: String) {
            Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }
    private fun navigasiKeProfilDiri() {
        val intent = Intent(this, MyProfileActivity::class.java)
        val bundle = Bundle()
        bundle.putString("nama", edtName.text.toString())
        bundle.putString("gender", spinnerGender.selectedItem.toString())
        bundle.putString("email", edtEmail.text.toString())
        bundle.putString("telp", edtTelp.text.toString())
        bundle.putString("alamat", edtAddress.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
