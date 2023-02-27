package com.example.vk_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


private const val TAG = "MainActivity"
private const val CALL_END_TEXT = "The call has ended"
private const val REQUEST_CONTACT = 1
private const val REQUEST_SMS_BODY = "sms:"

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    private lateinit var messengerImage: ImageView
    private lateinit var contactsImage: ImageView
    private lateinit var mainMenuImage: ImageView

    private lateinit var firstPersonText: TextView
    private lateinit var firstPersonImage: ImageView

    private lateinit var secondPersonText: TextView
    private lateinit var secondPersonImage: ImageView

    private lateinit var firstPersonLayout: ConstraintLayout
    private lateinit var secondPersonLayout: ConstraintLayout

    private lateinit var cameraButton: ImageButton
    private lateinit var microphoneButton: ImageButton
    private lateinit var handButton: ImageButton
    private lateinit var callEndButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messengerImage = findViewById(R.id.messenger_image)
        contactsImage = findViewById(R.id.contacts_image)
        mainMenuImage = findViewById(R.id.main_menu_image)

        messengerImage.setOnClickListener {
            Log.i(TAG, "messengerImage was pressed")
            val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(REQUEST_SMS_BODY))
            startActivity(intent)
        }

        contactsImage.setOnClickListener {
            Log.i(TAG, "contactsImage was pressed")
            val intent = Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }

        mainMenuImage.setOnClickListener {
            Log.i(TAG, "mainMenuImage was pressed")

            firstPersonLayout = findViewById(R.id.first_person_layout)
            secondPersonLayout = findViewById(R.id.second_person_layout)

            firstPersonText = findViewById(R.id.first_person_name)
            firstPersonImage = findViewById(R.id.first_person_image)
            secondPersonText = findViewById(R.id.second_person_name)
            secondPersonImage = findViewById(R.id.second_person_image)

            if (mainMenuImage.tag == null) {
                firstPersonLayout.setBackgroundResource(R.drawable.second_background)
                secondPersonLayout.setBackgroundResource(R.drawable.one_more_background)

                firstPersonText.text = getString(R.string.second_person_name)
                secondPersonText.text = getString(R.string.first_person_name)
                firstPersonImage.setImageResource(R.drawable.another_image)
                secondPersonImage.setImageResource(R.drawable.one_image)

                mainMenuImage.tag = 0
            } else {
                firstPersonLayout.setBackgroundResource(R.drawable.one_more_background)
                secondPersonLayout.setBackgroundResource(R.drawable.second_background)

                firstPersonText.text = getString(R.string.first_person_name)
                secondPersonText.text = getString(R.string.second_person_name)
                firstPersonImage.setImageResource(R.drawable.one_image)
                secondPersonImage.setImageResource(R.drawable.another_image)

                mainMenuImage.tag = null
            }
        }

        cameraButton = findViewById(R.id.camera_image)
        microphoneButton = findViewById(R.id.microphone_image)
        handButton = findViewById(R.id.hand_image)
        callEndButton = findViewById(R.id.call_end_image)

        cameraButton.setOnClickListener {
            Log.i(TAG, "The state of cameraButton: ${cameraButton.isSelected}")

            if (!cameraButton.isSelected) {
                cameraButton.setImageResource(R.drawable.camera_on)
                cameraButton.setBackgroundResource(R.drawable.round_button_on)
                cameraButton.isSelected = true
            } else {
                cameraButton.setImageResource(R.drawable.camera_off)
                cameraButton.setBackgroundResource(R.drawable.round_button_off)
                cameraButton.isSelected = false
            }
        }

        microphoneButton.setOnClickListener {
            Log.i(TAG, "The state of microphoneButton: ${microphoneButton.isSelected}")

            if (!microphoneButton.isSelected) {
                microphoneButton.setImageResource(R.drawable.mic_off)
                microphoneButton.setBackgroundResource(R.drawable.round_button_off)
                microphoneButton.isSelected = true
            } else {
                microphoneButton.setImageResource(R.drawable.mic_on)
                microphoneButton.setBackgroundResource(R.drawable.round_button_on)
                microphoneButton.isSelected = false
            }
        }

        handButton.setOnClickListener {
            Log.i(TAG, "The handButton was pressed")

            val builder = AlertDialog.Builder(this).setMessage("привет")
            builder.show()
        }

        callEndButton.setOnClickListener {
            Log.i(TAG, CALL_END_TEXT); finish()
        }
    }

}